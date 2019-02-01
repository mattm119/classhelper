package my.classhelper;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.Properties;
import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.*;

/**
 *  Fusion 2.0: Matt M, Matt K, Benton, Jordan
 *  April 8th 2017
 * 
 *  The ClassHelper program is designed to help teachers
 *  take attendance electronically and generate reports.
 */

public class ChartPanel extends JPanel {
  private double[] values;
  private String[] names;
  private String title;
  private javax.swing.JButton email;

  public ChartPanel(double[] v, String[] n, String t) 
  {
    names = n; //names
    values = v; //values
    title = t; //title
    email = new javax.swing.JButton("Email");
    email.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent evt) {
            sendEmail(); //send an email if the user clicks
         }
      });
    add(email);//add button to gui
  }
  
  public void sendEmail()
  {
        String em = homeUI.getUser(); //gets the users email
        if(em.equals("Admin"))//if the username is Admin
        {   //send the email to myself
            em = "mmiles1@student.framingham.edu";
        }
        email.setVisible(false);//make button invisible
        BufferedImage img = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);//create image from screenshot
        this.paint(img.getGraphics());
        File outputfile = new File("report.png");
        try
        {   
            ImageIO.write(img, "png", outputfile);
        }
        catch(IOException e){}
        email.setVisible(true);
        
        final String username = "fusion2classhelper@gmail.com";
        final String password = "1qh11jw2ob";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,new javax.mail.Authenticator() 
                                                {
          protected PasswordAuthentication getPasswordAuthentication() 
          {
            return new PasswordAuthentication(username, password);
          }
        });

        try 
        {
            //add recipients
          Message message = new MimeMessage(session);
          message.setFrom(new InternetAddress("fusion2classhelper@gmail.com"));
          message.setRecipients(Message.RecipientType.TO,
                                InternetAddress.parse(em));
          message.setSubject("Attendance Report");
          //set message
          BodyPart messageBodyPart = new MimeBodyPart();
          messageBodyPart.setText("You requested an attendance report from the Fusion 2.0 ClassHelper Attendance Software");

          Multipart multipart = new MimeMultipart();
          multipart.addBodyPart(messageBodyPart);
          //add the image
          messageBodyPart = new MimeBodyPart();
          String filename = "report.png";
          DataSource source = new FileDataSource(filename);
          messageBodyPart.setDataHandler(new DataHandler(source));
          messageBodyPart.setFileName(filename);
          multipart.addBodyPart(messageBodyPart);
          message.setContent(multipart);
          Transport.send(message);
        } 
        catch (MessagingException e) 
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Could not email report");
            throw new RuntimeException(e);
        }
        
  }

  //paints a bar graph
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    //calculate scale of the graph
    if (values == null || values.length == 0)
      return;
    double minValue = 0;
    double maxValue = 0;
    for (int i = 0; i < values.length; i++) {
      if (minValue > values[i])
        minValue = values[i];
      if (maxValue < values[i])
        maxValue = values[i];
    }

    Dimension d = getSize(); //size of screen
    int clientWidth = d.width;
    int clientHeight = d.height;
    int barWidth = (clientWidth / values.length)-50;

    Font titleFont = new Font("SansSerif", Font.BOLD, 20);
    FontMetrics titleFontMetrics = g.getFontMetrics(titleFont);
    Font labelFont = new Font("SansSerif", Font.PLAIN, 10);
    FontMetrics labelFontMetrics = g.getFontMetrics(labelFont);

    int titleWidth = titleFontMetrics.stringWidth(title);
    int y = titleFontMetrics.getAscent()+30;//y position of title
    int x = (clientWidth - titleWidth) / 2;//x position of title
    g.setFont(titleFont);
    g.drawString(title, x, y);

    int top = titleFontMetrics.getHeight()+30;
    int bottom = labelFontMetrics.getHeight();
    if (maxValue == minValue)
      return;
    double scale = (clientHeight - top - bottom) / (maxValue - minValue);
    y = clientHeight - labelFontMetrics.getDescent();
    g.setFont(labelFont);
    Color[] carray = {Color.GREEN, Color.RED, Color.BLUE};//color of bars
    for (int i = 0; i < values.length; i++) //for each of "full" "tardy" "absent"
    {
      int valueX = i * barWidth + 25*(i+1); //calculate position
      int valueY = top;
      int height = (int) (values[i] * scale);
      if (values[i] >= 0)
        valueY += (int) ((maxValue - values[i]) * scale);
      else 
      {
        valueY += (int) (maxValue * scale);
        height = -height;
      }

      g.setColor(carray[i]);
      g.fillRect(valueX, valueY, barWidth - 2, height); //draw bar
      g.setColor(Color.black);
      g.drawRect(valueX, valueY, barWidth - 2, height);
      int labelWidth = labelFontMetrics.stringWidth(names[i]);
      x = i * barWidth + (barWidth - labelWidth) / 2;
      g.drawString(names[i]+": "+values[i], x+(i+1)*25, y); //draw label
    }
  }
  //takes values, names, title from args[]
  public static void main(String[] args) {
    JFrame f = new JFrame();
    f.setSize(600, 400);
    double[] values = new double[3];
    String[] names = new String[3];
    values[0] = Double.parseDouble(args[0]);
    names[0] = "Full";

    values[1] = Double.parseDouble(args[1]);
    names[1] = "Absent";

    values[2] = Double.parseDouble(args[2]);
    names[2] = "Tardy";
    String title = args[3];

    f.getContentPane().add(new ChartPanel(values, names, title));

    f.setVisible(true);
  }
}

package my.classhelper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *  Fusion 2.0: Matt M, Matt K, Benton, Jordan
 *  April 8th 2017
 * 
 *  The ClassHelper program is designed to help teachers
 *  take attendance electronically and generate reports.
 */
public class loginUI extends javax.swing.JFrame {

    
    public loginUI() {
        initComponents();
        setSize(600,400);
        setLocationRelativeTo(null);
    }

    //GUI builder
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        tutorial = new javax.swing.JButton();
        logo = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        username = new javax.swing.JLabel();
        usernameTextField = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        jPanel4 = new javax.swing.JPanel();
        login = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        register = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");

        tutorial.setText("?");
        tutorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tutorialActionPerformed(evt);
            }
        });

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my/classhelper/logo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 96, Short.MAX_VALUE)
                .addComponent(logo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(tutorial))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tutorial)
                    .addComponent(logo))
                .addGap(0, 41, Short.MAX_VALUE))
        );

        username.setText("Username");

        passwordLabel.setText("Password");

        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(232, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(username)
                    .addComponent(usernameTextField)
                    .addComponent(passwordLabel)
                    .addComponent(passwordField, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))
                .addContainerGap(231, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(username)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(passwordLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        login.setText("Login");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });

        reset.setText("Reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        register.setText("Register");
        register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(reset)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(login)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(register)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(login)
                    .addComponent(reset)
                    .addComponent(register))
                .addGap(65, 65, 65))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed
    }//GEN-LAST:event_passwordFieldActionPerformed

    //register a new user
    private void registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerActionPerformed
        new registerUI().setVisible(true);
    }//GEN-LAST:event_registerActionPerformed

    //pressed login button
    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        String email = usernameTextField.getText();
        String pass = new String(passwordField.getPassword());
        boolean found = false;
        
        try //connect to the database
        {
            URL url = new URL("https://paternal-careers.000webhostapp.com/get-users.php");
            URLConnection conn = url.openConnection();

            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String line = rd.readLine();
            JSONObject obj = new JSONObject(line);
            JSONArray users = obj.getJSONArray("result");

            for(int i=0; i<users.length(); i++)
            {
                JSONObject c = users.getJSONObject(i);
                String loginName = c.getString("Login_Name");
                String password = c.getString("Password");
                
                if(email.equals(loginName))//username matches database
                {
                    found = true;
                    if(pass.equals(password))//password matches
                    {
                        new homeUI(email).setVisible(true);
                        dispose();
                    }
                    else
                    {
                        javax.swing.JOptionPane.showMessageDialog(this, "Password Incorrect");
                    }
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        if(email.equals("")||pass.equals(""))//either field is empty
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Please Enter Username/Password");
        }
        else if(!found)
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Username not found");
        }
    }//GEN-LAST:event_loginActionPerformed

    //pressed reset button
    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        String u = usernameTextField.getText();
        boolean found = false;
        
        try //connect to database and read username/passwords
        {
            URL url = new URL("https://paternal-careers.000webhostapp.com/get-users.php");
            URLConnection conn = url.openConnection();

            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String line = rd.readLine();
            JSONObject obj = new JSONObject(line);
            JSONArray users = obj.getJSONArray("result");

            for(int i=0; i<users.length(); i++)
            {
                JSONObject c = users.getJSONObject(i);
                String loginName = c.getString("Login_Name");
                
                if(u.equals(loginName))//username found in database
                {
                    found = true;
                    javax.swing.JOptionPane.showMessageDialog(this, "You will be emailed a new password");
                    emailcode(u);
                    new changeUI(u).setVisible(true);
                }
                    
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "An Error Occurred, Please Try Again");
        }
        if(u.equals(""))//either field is empty
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Please Enter Username");
        }
        else if(!found)//username not found
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Username not found");
        }
    }//GEN-LAST:event_resetActionPerformed

    private void tutorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tutorialActionPerformed
        new tutorialUI().setVisible(true);
    }//GEN-LAST:event_tutorialActionPerformed

    //generate a new password and email it to the user
    public void emailcode(String email)
    {
        String newp = "";
        String em = email;
        String[] array = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        java.util.Random rng = new java.util.Random();
        for(int i = 0; i < 5; i++)//randomly create new password
        {
            newp += array[rng.nextInt(26)];
        }
        
        if(email.equals("Admin"))//for testing purposes
        {
            em = "mmiles1@student.framingham.edu";
        }
        
        
        try //connect to the database
        {
          // open a connection to the site
          URL url = new URL("https://paternal-careers.000webhostapp.com/update-user.php");
          URLConnection con = url.openConnection();
          con.setDoOutput(true);
          PrintStream ps = new PrintStream(con.getOutputStream());
          // send your parameters to your site
          ps.print("loginName="+email);
          ps.print("&password="+newp);


          con.getInputStream();

          // close the print stream
          ps.close();
        } 
        catch (Exception e)
        {
          e.printStackTrace();
        }
        
        final String username = "fusion2classhelper@gmail.com";
        final String password = "1qh11jw2ob";
        //email new password to the user
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

          Message message = new MimeMessage(session);
          message.setFrom(new InternetAddress("fusion2classhelper@gmail.com"));
          message.setRecipients(Message.RecipientType.TO,
                                InternetAddress.parse(em));
          message.setSubject("Password Reset Request");
          message.setText("You requested a new password from the Fusion 2.0 ClassHelper Attendance Software\nYour new password is: "+newp);

          Transport.send(message);
        } 
        catch (MessagingException e) 
        {
          throw new RuntimeException(e);
        }

    }

    public static void main(String args[]) {
        //set look and feel of GUI
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } 
        catch (Exception ex) {
            java.util.logging.Logger.getLogger(loginUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new loginUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton login;
    private javax.swing.JLabel logo;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JButton register;
    private javax.swing.JButton reset;
    private javax.swing.JButton tutorial;
    private javax.swing.JLabel username;
    private javax.swing.JTextField usernameTextField;
    // End of variables declaration//GEN-END:variables
}

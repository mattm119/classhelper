package my.classhelper;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.URL;
import java.net.URLConnection;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *  Fusion 2.0: Matt M, Matt K, Benton, Jordan
 *  April 8th 2017
 * 
 *  The ClassHelper program is designed to help teachers
 *  take attendance electronically and generate reports.
 */
public class editCourseUI extends javax.swing.JFrame {

    public editCourseUI(String c) {
        cid = c;
        initComponents();
        populate();
        setLocationRelativeTo(null);
        setResizable(false);
    }
    //fill in form with current information
    public void populate()
    {
        try //connect to the database
        {
            URL url = new URL("https://paternal-careers.000webhostapp.com/get-course-list.php");
            URLConnection conn = url.openConnection();

            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String line = rd.readLine();
            JSONObject obj = new JSONObject(line);
            JSONArray courses = obj.getJSONArray("result");
            //for all courses
            for(int i=0; i<courses.length(); i++)
            {
                JSONObject c = courses.getJSONObject(i);
                String courseID = c.getString("Course_Number");
                String cname = c.getString("Course_Name");
                String min = c.getString("Course_Minutes");

                if(courseID.equals(cid))//if course id matches
                {   //set the textboxes with current info
                    courseNameTextField.setText(cname);
                    couseIDTextField.setText(cid);
                    durationTextField.setText(min);
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "An Error Occurred, Please Try Again");
        }
    }
    //gui
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title = new javax.swing.JLabel();
        courseName = new javax.swing.JLabel();
        courseID = new javax.swing.JLabel();
        duration = new javax.swing.JLabel();
        courseNameTextField = new javax.swing.JTextField();
        couseIDTextField = new javax.swing.JTextField();
        durationTextField = new javax.swing.JTextField();
        submit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        title.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        title.setText("Edit Course");

        courseName.setText("Course Name");

        courseID.setText("Course ID");

        duration.setText("Class Duration");

        submit.setText("Submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(title)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(courseName)
                            .addComponent(courseID)
                            .addComponent(duration))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(courseNameTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                            .addComponent(couseIDTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(durationTextField, javax.swing.GroupLayout.Alignment.LEADING))))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(submit)
                .addGap(0, 149, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(courseName)
                    .addComponent(courseNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(courseID)
                    .addComponent(couseIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(duration)
                    .addComponent(durationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(71, 71, 71)
                .addComponent(submit)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //submit changes to course
    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        String cnumber = couseIDTextField.getText();
        String cname = courseNameTextField.getText();
        String cminutes = durationTextField.getText();
        //get new information
        try //connect to the database
        {
          // open a connection to the site
          URL url = new URL("https://paternal-careers.000webhostapp.com/update-course.php");
          URLConnection con = url.openConnection();
          con.setDoOutput(true);
          PrintStream ps = new PrintStream(con.getOutputStream());
          // send your parameters to your site
          ps.print("pID="+cid);
          ps.print("&cNumber="+cnumber);
          ps.print("&cName="+cname);
          ps.print("&loginName="+homeUI.getUser());
          ps.print("&cMinutes="+cminutes);
          ps.print("&cMeeting="+"");
          ps.print("&cTime="+"");
          con.getInputStream();
          // close the print stream, close screen
          ps.close();
          dispose();
        } 
        catch (Exception e)
        {
          e.printStackTrace();
          javax.swing.JOptionPane.showMessageDialog(this, "An Error Occurred, Please Try Again");
        }
    }//GEN-LAST:event_submitActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(editCourseUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(editCourseUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(editCourseUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(editCourseUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new editCourseUI("Test").setVisible(true);
            }
        });
    }
    
    private String cid;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel courseID;
    private javax.swing.JLabel courseName;
    private javax.swing.JTextField courseNameTextField;
    private javax.swing.JTextField couseIDTextField;
    private javax.swing.JLabel duration;
    private javax.swing.JTextField durationTextField;
    private javax.swing.JButton submit;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}

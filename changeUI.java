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
public class changeUI extends javax.swing.JFrame {

    public changeUI(String login) {
        email = login;
        
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
                    pword = password;
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        initComponents();
        setSize(600,400);
        setLocationRelativeTo(null);
    }
    //gui
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tutorial = new javax.swing.JButton();
        title = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        currentPassword = new javax.swing.JLabel();
        currentPasswordTextfield = new javax.swing.JPasswordField();
        newPassword = new javax.swing.JLabel();
        newPasswordField = new javax.swing.JPasswordField();
        confirmPassword = new javax.swing.JLabel();
        confirmPasswordfield = new javax.swing.JPasswordField();
        submit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tutorial.setText("?");
        tutorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tutorialActionPerformed(evt);
            }
        });

        title.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        title.setText("Change Password");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 139, Short.MAX_VALUE)
                .addComponent(title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
                .addComponent(tutorial))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(title)
                    .addComponent(tutorial))
                .addGap(0, 31, Short.MAX_VALUE))
        );

        currentPassword.setText("Current Password");

        newPassword.setText("New Password");

        confirmPassword.setText("Confirm Password");

        submit.setText("Submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(confirmPassword)
                        .addComponent(newPassword)
                        .addComponent(currentPassword)
                        .addComponent(currentPasswordTextfield)
                        .addComponent(newPasswordField)
                        .addComponent(confirmPasswordfield, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
                    .addComponent(submit))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(currentPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(currentPasswordTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(newPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(confirmPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(confirmPasswordfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(submit)
                .addGap(41, 41, 41))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //change the password
    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        String cur = currentPasswordTextfield.getText();
        String newp = newPasswordField.getText();
        String newp2 = confirmPasswordfield.getText();
        
        if(newp.equals(newp2)&&cur.equals(pword))//if old password is right and new passwords match
        {
            try 
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
              dispose();
            } 
            catch (Exception e)
            {
              e.printStackTrace();
            }
        }
        else //error handling
            javax.swing.JOptionPane.showMessageDialog(this, "Password Incorrect or Does not Match");
    }//GEN-LAST:event_submitActionPerformed
    //open tutorial
    private void tutorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tutorialActionPerformed
        new tutorialUI().setVisible(true);
    }//GEN-LAST:event_tutorialActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(changeUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(changeUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(changeUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(changeUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new changeUI("Admin").setVisible(true);
            }
        });
    }

    private String email;
    private String pword;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel confirmPassword;
    private javax.swing.JPasswordField confirmPasswordfield;
    private javax.swing.JLabel currentPassword;
    private javax.swing.JPasswordField currentPasswordTextfield;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel newPassword;
    private javax.swing.JPasswordField newPasswordField;
    private javax.swing.JButton submit;
    private javax.swing.JLabel title;
    private javax.swing.JButton tutorial;
    // End of variables declaration//GEN-END:variables
}

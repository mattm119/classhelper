package my.classhelper;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import javax.imageio.ImageIO;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *  Fusion 2.0: Matt M, Matt K, Benton, Jordan
 *  April 8th 2017
 * 
 *  The ClassHelper program is designed to help teachers
 *  take attendance electronically and generate reports.
 */
public class studentUI extends javax.swing.JFrame {

    //set information for student
    public studentUI(String id) {
        sid = id; //student id
        try //connect to the database
        {
          URL url = new URL("https://paternal-careers.000webhostapp.com/get-student-list.php");
          URLConnection conn = url.openConnection();

          BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
          String line = rd.readLine();
          JSONObject obj = new JSONObject(line);
          students = obj.getJSONArray("result");

          for(int i=0; i<students.length(); i++)
          {//get student info from database
            JSONObject c = students.getJSONObject(i);
            String jstudentID = c.getString("Student_ID");
            String jfirstName = c.getString("First_Name");
            String jlastName = c.getString("Last_Name");
            String jyear = c.getString("Year");
            String jmajor = c.getString("Major");
            String jfilePath = c.getString("File_Path");
            cnumber = c.getString("Course_Number");
            
            if( jstudentID.equals(id))//if correct user, set information
            {
                name = jfirstName + " " + jlastName;
                sid = jstudentID;
                year = jyear;
                major = jmajor;
                path = jfilePath;
            }
          }
        } 
        catch (Exception e) 
        {
          e.printStackTrace();
          javax.swing.JOptionPane.showMessageDialog(this, "An Error Occurred, Please Try Again");
        }
        
        try//load image from url
        {
            URL imgurl = new URL("https://paternal-careers.000webhostapp.com/"+path);
            buffImg = ImageIO.read(imgurl);
        } 
        catch(Exception e) {}
        
        initComponents();
        setLocationRelativeTo(null);
    }
    //gui
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        studentName = new javax.swing.JLabel();
        studentInfo = new javax.swing.JLabel();
        studentPhoto = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        full = new javax.swing.JLabel();
        absent = new javax.swing.JLabel();
        tardy = new javax.swing.JLabel();
        numFull = new javax.swing.JLabel();
        numAbsent = new javax.swing.JLabel();
        numTardy = new javax.swing.JLabel();
        editStudent = new javax.swing.JButton();
        back = new javax.swing.JButton();
        genReport = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        studentName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        studentName.setText(name);

        studentInfo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        studentInfo.setText(year+", "+major);

        if(buffImg == null)
        {
            studentPhoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my/classhelper/student.png")));
        }
        else
        {
            studentPhoto.setIcon(new javax.swing.ImageIcon(buffImg));
        }

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        full.setText("Full Credit");

        absent.setText("Absent");

        tardy.setText("Tardy");

        numFull.setText(getStats()[0]+"");

        numAbsent.setText(getStats()[1]+"");

        numTardy.setText(getStats()[2]+"");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(full, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(absent)
                            .addComponent(tardy))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(numFull, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(numAbsent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(numTardy))
                .addGap(96, 96, 96))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numFull)
                    .addComponent(full))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(absent)
                    .addComponent(numAbsent))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tardy)
                    .addComponent(numTardy))
                .addContainerGap(132, Short.MAX_VALUE))
        );

        editStudent.setText("Edit Student Info");
        editStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editStudentActionPerformed(evt);
            }
        });

        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        genReport.setText("Generate Report");
        genReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genReportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(studentName)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(studentPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(studentInfo))
                        .addGap(54, 54, 54)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(editStudent)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(back))
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(14, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(genReport)
                .addGap(124, 124, 124))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(studentName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentInfo)
                    .addComponent(editStudent)
                    .addComponent(back))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(studentPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(genReport)
                .addGap(0, 22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //user wants to go back
    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        dispose();
    }//GEN-LAST:event_backActionPerformed
    //editing student info
    private void editStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editStudentActionPerformed
        new editStudentUI(sid, cnumber).setVisible(true);
    }//GEN-LAST:event_editStudentActionPerformed
    //open reporting page
    private void genReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genReportActionPerformed
        new reportUI(false, name, sid, null, null).setVisible(true);
    }//GEN-LAST:event_genReportActionPerformed
    //get attendance records of student
    private int[] getStats()
    {   //attendance records
        int full = 0, abs = 0, tardy = 0;
        
        try//connect to the database
        {
            URL url = new URL("https://paternal-careers.000webhostapp.com/get-attendance.php");
            URLConnection conn = url.openConnection();

            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = rd.readLine();
            JSONObject obj = new JSONObject(line);
            JSONArray attendance = obj.getJSONArray("result");
            //for all students
            for(int i=0; i<attendance.length(); i++)
            {
                JSONObject c = attendance.getJSONObject(i);
                String studentID = c.getString("Student_ID");
                String status = c.getString("Status");
                //if its the current student
                if(sid.equals(studentID))
                {   //count attendance status
                    if(status.equals("Full"))
                        full++;
                    else if(status.equals("Absent"))
                        abs++;
                    else if(status.equals("Tardy"))
                        tardy++;
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        //set and return stats
        int[] stats = {full, abs, tardy};
        return stats;
    }
    
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(studentUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(studentUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(studentUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(studentUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new studentUI("123456789").setVisible(true);
            }
        });
    }
    private String sid;
    private String name;
    private String year;
    private String major;
    private String path;
    BufferedImage buffImg = null;
    String line;
    JSONArray students = null;
    private String cnumber;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel absent;
    private javax.swing.JButton back;
    private javax.swing.JButton editStudent;
    private javax.swing.JLabel full;
    private javax.swing.JButton genReport;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel numAbsent;
    private javax.swing.JLabel numFull;
    private javax.swing.JLabel numTardy;
    private javax.swing.JLabel studentInfo;
    private javax.swing.JLabel studentName;
    private javax.swing.JLabel studentPhoto;
    private javax.swing.JLabel tardy;
    // End of variables declaration//GEN-END:variables
}

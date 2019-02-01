package my.classhelper;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.URL;
import java.net.URLConnection;
import javax.swing.table.*;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *  Fusion 2.0: Matt M, Matt K, Benton, Jordan
 *  April 8th 2017
 * 
 *  The ClassHelper program is designed to help teachers
 *  take attendance electronically and generate reports.
 */

public class courseUI extends javax.swing.JFrame {

    public courseUI(String n, String i) {
        name = n;
        id = i;
        dates = new Vector<String>();
        //connect to the database
        try//fill a vector with string of attendance dates 
            {
                URL url = new URL("https://paternal-careers.000webhostapp.com/get-attendance.php");
                URLConnection conn = url.openConnection();

                BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line = rd.readLine();
                JSONObject obj = new JSONObject(line);
                JSONArray attendance = obj.getJSONArray("result");

                for(int j=0; j<attendance.length(); j++)
                {
                    JSONObject c = attendance.getJSONObject(j);
                    String date = c.getString("Date");
                    String cnumber = c.getString("Course_Number");
                    
                    if(id.equals(cnumber) && isDifferent(date))
                        dates.add(date);
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        initComponents();
        setLocationRelativeTo(null);
    }
    //if the date is different, prevents duplicate attendance from appearing
    public boolean isDifferent(String s)
    {
        for(int i = 0; i < dates.size(); i++)
        {
            if(s.equals(dates.get(i)))
                return false;
        }
        return true;
    }
    
    public static void addNewStudent(String name, String id) //add new student
    {
        model.addRow(new Object[]{"X", name, id, 100.0});
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tutorial = new javax.swing.JButton();
        title = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        editClass = new javax.swing.JButton();
        addStudent = new javax.swing.JButton();
        genReport = new javax.swing.JButton();
        takeAttendance = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        editButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        enrolledStudents = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tutorial.setText("?");
        tutorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tutorialActionPerformed(evt);
            }
        });

        title.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        title.setText("Class Page: "+name);

        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        editClass.setText("Edit Class");
        editClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editClassActionPerformed(evt);
            }
        });

        addStudent.setText("Add Student");
        addStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStudentActionPerformed(evt);
            }
        });

        genReport.setText("Generate Report");
        genReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genReportActionPerformed(evt);
            }
        });

        takeAttendance.setText("Take Attendance");
        takeAttendance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                takeAttendanceActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(dates));

        editButton.setText("Edit");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(editClass)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addStudent)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(genReport)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(takeAttendance)
                        .addGap(18, 18, 18)
                        .addComponent(editButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(title)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(back)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tutorial))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tutorial)
                    .addComponent(back))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editClass)
                    .addComponent(addStudent)
                    .addComponent(genReport)
                    .addComponent(takeAttendance)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        enrolledStudents.setAutoCreateRowSorter(true);
        enrolledStudents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] { },
            new String [] {
                "", "Name", "ID", "Attendance"
            }
        ) {//dont edit the values
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
            //ensures sorting is done numerically if a number and not lexicographically
            public Class getColumnClass(int column) {
                if(column == 3)
                return Double.class;
                return String.class;
            }
        });
        model = (DefaultTableModel) enrolledStudents.getModel();
        try
        {
            URL url = new URL("https://paternal-careers.000webhostapp.com/get-student-list.php");
            URLConnection conn = url.openConnection();

            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = rd.readLine();
            JSONObject obj = new JSONObject(line);
            students = obj.getJSONArray("result");

            for(int i=0; i<students.length(); i++)
            {
                JSONObject c = students.getJSONObject(i);
                String studentID = c.getString("Student_ID");
                String firstName = c.getString("First_Name");
                String lastName = c.getString("Last_Name");
                String courseNumber = c.getString("Course_Number");
                //if the student is enrolled in the course
                if(courseNumber.equals(id))
                model.addRow(new Object[] {"X",firstName+" "+lastName,studentID,getPercent(studentID)});
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "An Error Occurred, Please Try Again");
        }
        enrolledStudents.getTableHeader().setReorderingAllowed(false);
        enrolledStudents.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                enrolledStudentsMouseClicked(evt);
            }
        });
        enrolledStudents.getColumnModel().getColumn(0).setMaxWidth(20);
        jScrollPane1.setViewportView(enrolledStudents);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private double getPercent(String stid) //calculate attendance percentage
    {
        double here = 0, total = 0;
        
        try//connect to the database
        {
            URL url = new URL("https://paternal-careers.000webhostapp.com/get-attendance.php");
            URLConnection conn = url.openConnection();

            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = rd.readLine();
            JSONObject obj = new JSONObject(line);
            JSONArray attendance = obj.getJSONArray("result");
            //get number of full credit as percent of all attendances
            for(int i=0; i<attendance.length(); i++)
            {
                JSONObject c = attendance.getJSONObject(i);
                String studentID = c.getString("Student_ID");
                String courseNumber = c.getString("Course_Number");
                String status = c.getString("Status");
                //if its the right student in the right course
                if(studentID.equals(stid)&&courseNumber.equals(id))
                {
                    if(status.equals("Full"))
                        here++;
                    total++;
                } 
            }
            if(total == 0.0)//prevents "not a number"
                return 100.0;
            else
                return 100*(here/total);

        }
        catch (Exception e)
        {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "An Error Occurred, Please Try Again");
        }
        
        return 100.0; //just in case
    }
    //previous screen
    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        new courseListUI().setVisible(true);
        dispose();
    }//GEN-LAST:event_backActionPerformed
    //take attendance
    private void takeAttendanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_takeAttendanceActionPerformed
        new attendanceUI(id).setVisible(true);
    }//GEN-LAST:event_takeAttendanceActionPerformed
    //add student
    private void addStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStudentActionPerformed
        new addStudentUI(id).setVisible(true);
    }//GEN-LAST:event_addStudentActionPerformed
    //user clicks on a student
    private void enrolledStudentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_enrolledStudentsMouseClicked
        int row = enrolledStudents.rowAtPoint(evt.getPoint());
        int col = enrolledStudents.columnAtPoint(evt.getPoint());
        String studentClickedOn = (String)enrolledStudents.getValueAt(row, 2);
        
        if (evt.getClickCount() == 2) //if double click
        {
            if(col == 0)//if they clicked delete
            {   //confirm choice
                int n = javax.swing.JOptionPane.showConfirmDialog(this,"Would you like to delete this student?", "Confirm Delete",javax.swing.JOptionPane.YES_NO_OPTION);
                if(n == 0)
                {
                    try //try to remove from database
                    {
                      URL url = new URL("https://paternal-careers.000webhostapp.com/delete-student.php");
                      URLConnection con = url.openConnection();
                      con.setDoOutput(true);
                      PrintStream ps = new PrintStream(con.getOutputStream());
                      // send your parameters to your site
                      ps.print("sID="+studentClickedOn);
                      ps.print("&cNumber="+id);
                      con.getInputStream();
                      // close the print stream
                      ps.close();
                      model.removeRow(row); //remove from GUI
                    } 
                    catch (Exception e)
                    {
                      e.printStackTrace();
                    }
                }
            }
            else//open the students page
            {
                new studentUI((String)enrolledStudents.getValueAt(row, 2)).setVisible(true);
            }
        }
        
    }//GEN-LAST:event_enrolledStudentsMouseClicked
    //edit the class
    private void editClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editClassActionPerformed
        new editCourseUI(id).setVisible(true);
    }//GEN-LAST:event_editClassActionPerformed
    //opens the report page
    private void genReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genReportActionPerformed
        new reportUI(true, null, null, name, id).setVisible(true);
    }//GEN-LAST:event_genReportActionPerformed
    //click edit attendance button
    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        int size = enrolledStudents.getRowCount();
        String[] names = new String[size];
        for(int i = 0; i < size; i++)
        {
            names[i] = (String)enrolledStudents.getValueAt(i, 1);
        }
        //edit attendance for date selected
        new editAttendanceUI(id, (String)jComboBox1.getSelectedItem(), names).setVisible(true);
        
    }//GEN-LAST:event_editButtonActionPerformed
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
            java.util.logging.Logger.getLogger(courseUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(courseUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(courseUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(courseUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new courseUI("Statistic", "MATH100").setVisible(true);
            }
        });
    }

    private static DefaultTableModel model;
    private String name;
    private String id;
    private Vector<String> dates;
    JSONArray students = null;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addStudent;
    private javax.swing.JButton back;
    private javax.swing.JButton editButton;
    private javax.swing.JButton editClass;
    private javax.swing.JTable enrolledStudents;
    private javax.swing.JButton genReport;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton takeAttendance;
    private javax.swing.JLabel title;
    private javax.swing.JButton tutorial;
    // End of variables declaration//GEN-END:variables
}

package my.classhelper;
import javax.swing.table.DefaultTableModel;
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
public class courseListUI extends javax.swing.JFrame {

    public courseListUI() {
 
        initComponents();
        setSize(600,400);
        setLocationRelativeTo(null);
    }
    
    //add a course to the table
    public static void addNewCourse(String name, String id){
        model.addRow(new Object[] {"X", name, id});
    }
    //gui
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        tutorial = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        addNewCourse = new javax.swing.JButton();
        listAllStudents = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        courseTable = new javax.swing.JTable();
        back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        title.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        title.setText("List of Courses");

        tutorial.setText("?");
        tutorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tutorialActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tutorial))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tutorial)
            .addComponent(title)
        );

        addNewCourse.setText("Add New Course");
        addNewCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewCourseActionPerformed(evt);
            }
        });

        listAllStudents.setText("List All Students");
        listAllStudents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listAllStudentsActionPerformed(evt);
            }
        });

        courseTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {    },
            new String [] {
                "", "Course Name", "Course ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };//dont edit values
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        model = (DefaultTableModel) courseTable.getModel();

        try
        {
            URL url = new URL("https://paternal-careers.000webhostapp.com/get-course-list.php");
            URLConnection conn = url.openConnection();

            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String line = rd.readLine();
            JSONObject obj = new JSONObject(line);
            courses = obj.getJSONArray("result");

            for(int i=0; i<courses.length(); i++)
            {
                JSONObject c = courses.getJSONObject(i);
                String courseID = c.getString("Course_Number");
                String cname = c.getString("Course_Name");
                String loginName = c.getString("Login_Name");
                //if course was added by current user
                if(loginName.equals(homeUI.getUser()))
                model.addRow(new Object[] {"X", cname, courseID});
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "An Error Occurred, Please Try Again");
        }

        courseTable.setAutoCreateRowSorter(true);//allow user to sort
        courseTable.getTableHeader().setReorderingAllowed(false);
        //check for clicking on table
        courseTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                courseTableMouseClicked(evt);
            }
        });
        courseTable.getColumnModel().getColumn(0).setMaxWidth(30);
        jScrollPane1.setViewportView(courseTable);

        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(74, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(addNewCourse)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(listAllStudents)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(back))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addNewCourse)
                    .addComponent(listAllStudents)
                    .addComponent(back))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
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

    //navigate to previous page
    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        new homeUI(homeUI.getUser()).setVisible(true);
        dispose();
    }//GEN-LAST:event_backActionPerformed

    //add a new course
    private void addNewCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewCourseActionPerformed
        new addCourseUI().setVisible(true);
    }//GEN-LAST:event_addNewCourseActionPerformed
    //list all the students
    private void listAllStudentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listAllStudentsActionPerformed
        new studentListUI().setVisible(true);
        dispose();
    }//GEN-LAST:event_listAllStudentsActionPerformed
    //user has clicked on the table
    private void courseTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_courseTableMouseClicked
        int row = courseTable.rowAtPoint(evt.getPoint());
        int col = courseTable.columnAtPoint(evt.getPoint());
        String courseIDClicked = (String)courseTable.getValueAt(row, 2);
        
        if (evt.getClickCount() == 2) //if the user double clicked
        {
            
            if(col == 0) //if they clicked the delete button
            { //confirm and delete the course
                int n = javax.swing.JOptionPane.showConfirmDialog(this,"Would you like to delete?", "Confirm Delete",javax.swing.JOptionPane.YES_NO_OPTION);
                if(n == 0)
                {
                    try //connect to the database
                    {
                      URL url = new URL("https://paternal-careers.000webhostapp.com/delete-course.php");
                      URLConnection con = url.openConnection();
                      con.setDoOutput(true);
                      PrintStream ps = new PrintStream(con.getOutputStream());
                      // send your parameters to your site
                      ps.print("cNumber="+courseIDClicked);
                      con.getInputStream();
                      // close the print stream
                      ps.close();
                      model.removeRow(row);
                    } 
                    catch (Exception e)
                    {
                      e.printStackTrace();
                      javax.swing.JOptionPane.showMessageDialog(this, "An Error Occurred, Please Try Again");
                    }
                }
            }
            else //otherwise open the course page
            {
                String name = (String)courseTable.getValueAt(row, 1) + " " + (String)courseTable.getValueAt(row, 2);
                //System.out.println(name);
                new courseUI(name, courseIDClicked).setVisible(true);
                dispose();
            }
        }
        
    }//GEN-LAST:event_courseTableMouseClicked
    //open the tutorial
    private void tutorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tutorialActionPerformed
        new tutorialUI().setVisible(true);
    }//GEN-LAST:event_tutorialActionPerformed


    public static void main(String args[]) throws Exception
    {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(courseListUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(courseListUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(courseListUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(courseListUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new courseListUI().setVisible(true);
            }
        });
    }
    JSONArray courses = null;
    private static DefaultTableModel model;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addNewCourse;
    private javax.swing.JButton back;
    private javax.swing.JTable courseTable;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton listAllStudents;
    private javax.swing.JLabel title;
    private javax.swing.JButton tutorial;
    // End of variables declaration//GEN-END:variables
}

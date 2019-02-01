package my.classhelper;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *  Fusion 2.0: Matt M, Matt K, Benton, Jordan
 *  April 8th 2017
 * 
 *  The ClassHelper program is designed to help teachers
 *  take attendance electronically and generate reports.
 */
public class studentListUI extends javax.swing.JFrame {

    public studentListUI() {
        currentCourses = new ArrayList<String>();
        try //connect to the database
        {
          URL url = new URL("https://paternal-careers.000webhostapp.com/get-course-list.php");
          URLConnection conn = url.openConnection();

          BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String line = rd.readLine();
            JSONObject obj = new JSONObject(line);
            JSONArray courses = obj.getJSONArray("result");
            //ensure only students from current user
            for(int i=0; i<courses.length(); i++) 
            {
              JSONObject c = courses.getJSONObject(i);
              String courseID = c.getString("Course_Number");
              String loginName = c.getString("Login_Name");
              //add all courses of user to an arraylist
              if(loginName.equals(homeUI.getUser()))
                currentCourses.add(courseID);
            }      
        } 
        catch (Exception e) 
        {
          e.printStackTrace();
          javax.swing.JOptionPane.showMessageDialog(this, "An Error Occurred, Please Try Again");
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
        title = new javax.swing.JLabel();
        tutorial = new javax.swing.JButton();
        back = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        allStudentsTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        title.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        title.setText("All Students");

        tutorial.setText("?");
        tutorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tutorialActionPerformed(evt);
            }
        });

        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 294, Short.MAX_VALUE)
                .addComponent(back)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tutorial))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(tutorial)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(back)
                    .addComponent(title))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        allStudentsTable.setAutoCreateRowSorter(true);
        allStudentsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {    },
            new String [] {
                "Name", "ID Number", "Major", "Year", "Attendance"
            }
        ) {
            //dont edit the values
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }

            public Class getColumnClass(int column) {
                if(column == 4)
                return Double.class;
                return String.class;
            }
        });
        model = (DefaultTableModel) allStudentsTable.getModel();

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
                String year = c.getString("Year");
                String major = c.getString("Major");
                String filePath = c.getString("File_Path");
                String courseNumber = c.getString("Course_Number");

                for(int j = 0; j < currentCourses.size(); j++)
                {   //if the student is in a course from the current user, add them
                    if(courseNumber.equals(currentCourses.get(j)))
                    model.addRow(new Object[] {firstName+" "+lastName,studentID,major,year,getPercent(studentID)});
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "An Error Occurred, Please Try Again");
        }
        allStudentsTable.getTableHeader().setReorderingAllowed(false);
        //checks if the table is clicked
        allStudentsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                allStudentsTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(allStudentsTable);
        allStudentsTable.getColumnModel().getColumn(0).setMinWidth(80);
        if (allStudentsTable.getColumnModel().getColumnCount() > 0) {
            allStudentsTable.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //back to the previous page
    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        new homeUI(homeUI.getUser()).setVisible(true);
        dispose();
    }//GEN-LAST:event_backActionPerformed
    //user clicked on the table
    private void allStudentsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_allStudentsTableMouseClicked
        int row = allStudentsTable.rowAtPoint(evt.getPoint());
        
        if (evt.getClickCount() == 2) //if double click
        { //open a new student screen
            new studentUI((String)allStudentsTable.getValueAt(row, 1)).setVisible(true);
        }
    }//GEN-LAST:event_allStudentsTableMouseClicked
    //open tutorial
    private void tutorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tutorialActionPerformed
        new tutorialUI().setVisible(true);
    }//GEN-LAST:event_tutorialActionPerformed
    //calcualte attendance percent
    private double getPercent(String stid)
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
                String status = c.getString("Status");
                //if its the right student
                if(studentID.equals(stid))
                {
                    if(status.equals("Full"))
                        here++;
                    total++;
                } 
            }
            if(total == 0.0)
                return 100.0;
            else
                return 100*(here/total);

        }
        catch (Exception e)
        {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "An Error Occurred, Please Try Again");
        }
        return 100.0;
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
            java.util.logging.Logger.getLogger(studentListUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(studentListUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(studentListUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(studentListUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new studentListUI().setVisible(true);
            }
        });
    }
    private DefaultTableModel model;
    JSONArray students = null;
    private ArrayList<String> currentCourses;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable allStudentsTable;
    private javax.swing.JButton back;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel title;
    private javax.swing.JButton tutorial;
    // End of variables declaration//GEN-END:variables
}

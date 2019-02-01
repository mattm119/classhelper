package my.classhelper;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;
import java.awt.*;
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
public class editAttendanceUI extends javax.swing.JFrame {

    public editAttendanceUI(String cid, String d, String[] names) 
    {
        id = cid;
        adate = d;
        this.names = names;
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
        date = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        submit = new javax.swing.JButton();
        back = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        DefaultTableModel m = new DefaultTableModel()
        {//can columns be edited
            public boolean isCellEditable(int row, int column)
            {
                return column > 1;
            }
        };
        m.setDataVector(new Object[][] {},
            new Object[] {"Name", "ID", "Attendance", "Comment"});
        attendanceTable = new javax.swing.JTable(m)  {
            public void tableChanged(TableModelEvent e) {
                super.tableChanged(e);
                repaint();
            }
        };

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tutorial.setText("?");
        tutorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tutorialActionPerformed(evt);
            }
        });

        title.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        title.setText("Edit Attendance");

        date.setText("Date: "+adate);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title)
                .addGap(115, 115, 115)
                .addComponent(date)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tutorial))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tutorial)
                    .addComponent(title))
                .addGap(0, 49, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(date)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        submit.setText("Submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(371, Short.MAX_VALUE)
                .addComponent(back)
                .addGap(18, 18, 18)
                .addComponent(submit)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submit)
                    .addComponent(back))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        String[] values = new String[] {"Full", "Absent", "Tardy"};
        TableColumn col = attendanceTable.getColumnModel().getColumn(2);
        col.setCellEditor(new MyComboBoxEditor(values));//make the column a dropdown
        col.setCellRenderer(new MyComboBoxRenderer(values));
        attendanceTable.setAutoCreateRowSorter(true);

        try
        {
            URL url = new URL("https://paternal-careers.000webhostapp.com/get-attendance.php");
            URLConnection conn = url.openConnection();

            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = rd.readLine();
            JSONObject obj = new JSONObject(line);
            JSONArray attendance = obj.getJSONArray("result");
            int counter = 0;
            for(int i=0; i<attendance.length(); i++)
            {
                JSONObject c = attendance.getJSONObject(i);
                String cnumber = c.getString("Course_Number");
                String status = c.getString("Status");
                String dateGet = c.getString("Date");
                String sid = c.getString("Student_ID");
                String comment = "";

                if(status.equals("Tardy"))
                comment = c.getString("Minutes_Tardy");
                else if(status.equals("Absent"))
                comment = c.getString("Reason_Absent");
                //if attendance is from date and class
                if(adate.equals(dateGet)&&cnumber.equals(id))
                {
                    m.addRow(new Object[] {names[counter++], sid, status, comment});
                }

            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "An Error Occurred, Please Try Again");
        }
        jScrollPane1.setViewportView(attendanceTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //previous screen
    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        dispose();
    }//GEN-LAST:event_backActionPerformed
    //submit new attendance
    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        
        for(int i = 0; i < attendanceTable.getRowCount(); i++)
        {
            String status = (String)attendanceTable.getValueAt(i,2);
            String minutest = "";
            String rabsent = "";
            
            if(status.equals("Tardy")&&(String)attendanceTable.getValueAt(i,3)!=null)
            {
                minutest = (String)attendanceTable.getValueAt(i,3);
            }
            else if(status.equals("Absent")&&(String)attendanceTable.getValueAt(i,3)!=null)
            {
                rabsent = (String)attendanceTable.getValueAt(i,3);
            }
            
            try //connect to the database
            {
              // open a connection to the site
              URL url = new URL("https://paternal-careers.000webhostapp.com/update-attendance.php");
              URLConnection con = url.openConnection();
              con.setDoOutput(true);
              PrintStream ps = new PrintStream(con.getOutputStream());
              // send your parameters to your site
              ps.print("sID="+(String)attendanceTable.getValueAt(i,1));
              ps.print("&date="+adate);
              ps.print("&status="+status);
              ps.print("&minutesT="+minutest);
              ps.print("&rAbsent="+rabsent);
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
        }
    }//GEN-LAST:event_submitActionPerformed
    //open tutorial
    private void tutorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tutorialActionPerformed
        new tutorialUI().setVisible(true);
    }//GEN-LAST:event_tutorialActionPerformed
    //displaying drop-down menu in  a table code
class MyComboBoxRenderer extends JComboBox implements TableCellRenderer 
{
    public MyComboBoxRenderer(String[] items) 
    {
        super(items);
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
        boolean hasFocus, int row, int column) 
    {
        setSelectedItem(value);
        return this;
    }
}

class MyComboBoxEditor extends DefaultCellEditor 
{
    public MyComboBoxEditor(String[] items) 
    {
        super(new JComboBox(items));
    }
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
            java.util.logging.Logger.getLogger(editAttendanceUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(editAttendanceUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(editAttendanceUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(editAttendanceUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new editAttendanceUI("100", "2017-14-4").setVisible(true);
            }
        });
    }
    private String id;
    private String adate;
    private String[] names;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable attendanceTable;
    private javax.swing.JButton back;
    private javax.swing.JLabel date;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton submit;
    private javax.swing.JLabel title;
    private javax.swing.JButton tutorial;
    // End of variables declaration//GEN-END:variables
}

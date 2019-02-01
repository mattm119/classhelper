package my.classhelper;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.json.JSONArray;
import org.json.JSONObject;
/**
 *  Fusion 2.0: Matt M, Matt K, Benton, Jordan
 *  April 8th 2017
 * 
 *  The ClassHelper program is designed to help teachers
 *  take attendance electronically and generate reports.
 */
public class reportUI extends javax.swing.JFrame {

    public reportUI(boolean b, String sname, String sid, String cname, String cid) 
    {   //information about the report
        classReport = b;
        this.cname = cname;
        this.cid = cid;
        this.sname = sname;
        this.sid = sid;
        mdformat = new SimpleDateFormat("yyyy-MM-dd");
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        courseName = new javax.swing.JLabel();
        tutorial = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        monthly = new javax.swing.JButton();
        semester = new javax.swing.JButton();
        weekly = new javax.swing.JButton();
        dateChooserCombo1 = new datechooser.beans.DateChooserCombo();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        title.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        title.setText("Generate Report");

        courseName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        if(classReport)
        courseName.setText(cname);
        else
        courseName.setText(sname);

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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(title)
                        .addGap(84, 84, 84)
                        .addComponent(tutorial))
                    .addComponent(courseName))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(title))
                    .addComponent(tutorial))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(courseName)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        monthly.setText("Monthly Report");
        monthly.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthlyActionPerformed(evt);
            }
        });

        semester.setText("Semeter Report");
        semester.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semesterActionPerformed(evt);
            }
        });

        weekly.setText("Weekly Report");
        weekly.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                weeklyActionPerformed(evt);
            }
        });

        jLabel1.setText("Enter a Start Date");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(semester)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(weekly, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(monthly, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(dateChooserCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(dateChooserCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
                .addComponent(weekly)
                .addGap(18, 18, 18)
                .addComponent(monthly)
                .addGap(18, 18, 18)
                .addComponent(semester)
                .addGap(33, 33, 33))
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
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //report for entire semester
    private void semesterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semesterActionPerformed
        reset();
        if(classReport)//class report
        {
            try
            {
                URL url = new URL("https://paternal-careers.000webhostapp.com/get-attendance.php");
                URLConnection conn = url.openConnection();

                BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line = rd.readLine();
                JSONObject obj = new JSONObject(line);
                JSONArray attendance = obj.getJSONArray("result");

                for(int i=0; i<attendance.length(); i++)
                {
                    JSONObject c = attendance.getJSONObject(i);
                    String cnumber = c.getString("Course_Number");
                    String status = c.getString("Status");

                    if(cid.equals(cnumber))
                    {//count attendance
                        if(status.equals("Full"))
                            full++;
                        else if(status.equals("Absent"))
                            abs++;
                        else if(status.equals("Tardy"))
                            tardy++;
                    }
                }//display graph
                ChartPanel.main(new String[]{full+"", abs+"", tardy+"", "Semester Attendance for "+cname});
            }
            catch (Exception e)
            {
                e.printStackTrace();
                javax.swing.JOptionPane.showMessageDialog(this, "An Error Occurred, Please Try Again");
            }
        }
        else //student report
        {
            try
            {
                URL url = new URL("https://paternal-careers.000webhostapp.com/get-attendance.php");
                URLConnection conn = url.openConnection();

                BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line = rd.readLine();
                JSONObject obj = new JSONObject(line);
                JSONArray attendance = obj.getJSONArray("result");

                for(int i=0; i<attendance.length(); i++)
                {
                    JSONObject c = attendance.getJSONObject(i);
                    String studentID = c.getString("Student_ID");
                    String status = c.getString("Status");

                    if(sid.equals(studentID))
                    {//count attendance
                        if(status.equals("Full"))
                            full++;
                        else if(status.equals("Absent"))
                            abs++;
                        else if(status.equals("Tardy"))
                            tardy++;
                    }
                }//display graph
                ChartPanel.main(new String[]{full+"", abs+"", tardy+"", "Semester Attendance for "+sname});
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }        
    }//GEN-LAST:event_semesterActionPerformed
    //weekly report
    private void weeklyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_weeklyActionPerformed
        reset();
        Date startDate = new Date(dateChooserCombo1.getSelectedDate().getTimeInMillis());
        Date endDate = new Date(dateChooserCombo1.getSelectedDate().getTimeInMillis()+604800000); //add one week's worth of milliseconds
        String startString = mdformat.format(startDate.getTime()); //convert to string
        String endString = mdformat.format(endDate.getTime());
        
        if(classReport)//class report
        {
            try
            {
                URL url = new URL("https://paternal-careers.000webhostapp.com/get-attendance.php");
                URLConnection conn = url.openConnection();

                BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line = rd.readLine();
                JSONObject obj = new JSONObject(line);
                JSONArray attendance = obj.getJSONArray("result");

                for(int i=0; i<attendance.length(); i++)
                {
                    JSONObject c = attendance.getJSONObject(i);
                    String cnumber = c.getString("Course_Number");
                    String status = c.getString("Status");
                    String dateGet = c.getString("Date");
                    //select dates between start and end date
                    if(cid.equals(cnumber)&&dateGet.compareTo(startString)>=0&&dateGet.compareTo(endString)<=0)
                    {//count attendance
                        if(status.equals("Full"))
                            full++;
                        else if(status.equals("Absent"))
                            abs++;
                        else if(status.equals("Tardy"))
                            tardy++;
                    }
                }//display graph
                ChartPanel.main(new String[]{full+"", abs+"", tardy+"", "Semester Attendance for "+cname});
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else//student report
        {
            try
            {
                URL url = new URL("https://paternal-careers.000webhostapp.com/get-attendance.php");
                URLConnection conn = url.openConnection();

                BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line = rd.readLine();
                JSONObject obj = new JSONObject(line);
                JSONArray attendance = obj.getJSONArray("result");

                for(int i=0; i<attendance.length(); i++)
                {
                    JSONObject c = attendance.getJSONObject(i);
                    String studentID = c.getString("Student_ID");
                    String status = c.getString("Status");
                    String dateGet = c.getString("Date");
                    //select dates between start and end date
                    if(sid.equals(studentID)&&dateGet.compareTo(startString)>=0&&dateGet.compareTo(endString)<=0)
                    {//count attendance
                        if(status.equals("Full"))
                            full++;
                        else if(status.equals("Absent"))
                            abs++;
                        else if(status.equals("Tardy"))
                            tardy++;
                    }
                }//display graph
                ChartPanel.main(new String[]{full+"", abs+"", tardy+"", "Semester Attendance for "+sname});
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_weeklyActionPerformed
    //monthly report
    private void monthlyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthlyActionPerformed
        reset();
        Calendar cal = Calendar.getInstance();
        Date startDate = new Date(dateChooserCombo1.getSelectedDate().getTimeInMillis());
        cal.setTime(startDate);
        //get day, month, year
        int m = cal.get(Calendar.MONTH);
        int y = cal.get(Calendar.YEAR);
        int d = cal.get(Calendar.DAY_OF_MONTH);
        int loopVal = 0;
        //determine days in the month
        if (m == 0 || m == 2 || m == 4 || m == 6 || m == 7 || m == 9 || m == 11) {
            loopVal = 31;
        }

        if (m == 1) {
            if (y % 4 == 0) {
                loopVal = 29;
            }

            else {
                loopVal = 28;
            }
        }

        if (m == 3 || m == 5 || m == 8 || m == 10) {
            loopVal = 30;
        }
        //only allow monthly reports to work if first day of month is chosen
        if(d == 1) 
        {
            Date endDate = new Date(dateChooserCombo1.getSelectedDate().getTimeInMillis()+(long)(loopVal-1)*(long)86400000.0);//add one months worth of milliseconds
            String startString = mdformat.format(startDate.getTime());
            String endString = mdformat.format(endDate.getTime());

            if(classReport)//class report
            {
                try
                {
                    URL url = new URL("https://paternal-careers.000webhostapp.com/get-attendance.php");
                    URLConnection conn = url.openConnection();

                    BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    String line = rd.readLine();
                    JSONObject obj = new JSONObject(line);
                    JSONArray attendance = obj.getJSONArray("result");

                    for(int i=0; i<attendance.length(); i++)
                    {
                        JSONObject c = attendance.getJSONObject(i);
                        String cnumber = c.getString("Course_Number");
                        String status = c.getString("Status");
                        String dateGet = c.getString("Date");
                        //select dates between start and end date
                        if(cid.equals(cnumber)&&dateGet.compareTo(startString)>=0&&dateGet.compareTo(endString)<=0)
                        {//count attendance
                            if(status.equals("Full"))
                                full++;
                            else if(status.equals("Absent"))
                                abs++;
                            else if(status.equals("Tardy"))
                                tardy++;
                        }
                    }//display graph
                    ChartPanel.main(new String[]{full+"", abs+"", tardy+"", "Semester Attendance for "+cname});
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            else //student report
            {
                try
                {
                    URL url = new URL("https://paternal-careers.000webhostapp.com/get-attendance.php");
                    URLConnection conn = url.openConnection();

                    BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    String line = rd.readLine();
                    JSONObject obj = new JSONObject(line);
                    JSONArray attendance = obj.getJSONArray("result");

                    for(int i=0; i<attendance.length(); i++)
                    {
                        JSONObject c = attendance.getJSONObject(i);
                        String studentID = c.getString("Student_ID");
                        String status = c.getString("Status");
                        String dateGet = c.getString("Date");
                        //select dates between start and end date
                        if(sid.equals(studentID)&&dateGet.compareTo(startString)>=0&&dateGet.compareTo(endString)<=0)
                        {//count attendance
                            if(status.equals("Full"))
                                full++;
                            else if(status.equals("Absent"))
                                abs++;
                            else if(status.equals("Tardy"))
                                tardy++;
                        }
                    }//display graph
                    ChartPanel.main(new String[]{full+"", abs+"", tardy+"", "Semester Attendance for "+sname});
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
        else
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Please select the first Day of the month for monthly reports");
        }
    }//GEN-LAST:event_monthlyActionPerformed
    //open tutorial
    private void tutorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tutorialActionPerformed
        new tutorialUI().setVisible(true);
    }//GEN-LAST:event_tutorialActionPerformed
    //reset attendance counters
    public void reset()
    {
        full = 0;
        abs = 0;
        tardy = 0;
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
            java.util.logging.Logger.getLogger(reportUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(reportUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(reportUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(reportUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new reportUI(true, null, null, "Math", "1").setVisible(true);
            }
        });
    }
    private SimpleDateFormat mdformat;
    private int weekNumber = 0, monthNumber = 0;
    private String cname, cid, sname, sid;
    private boolean classReport;
    private int full = 0, abs = 0, tardy = 0;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel courseName;
    private datechooser.beans.DateChooserCombo dateChooserCombo1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton monthly;
    private javax.swing.JButton semester;
    private javax.swing.JLabel title;
    private javax.swing.JButton tutorial;
    private javax.swing.JButton weekly;
    // End of variables declaration//GEN-END:variables
}

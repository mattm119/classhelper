package my.classhelper;
/**
 *  Fusion 2.0: Matt M, Matt K, Benton, Jordan
 *  April 8th 2017
 * 
 *  The ClassHelper program is designed to help teachers
 *  take attendance electronically and generate reports.
 */
public class tutorialUI extends javax.swing.JFrame {

    //one big block of text, scrollable
    public tutorialUI() {
        initComponents();
    }
    //gui
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jLabel2 = new javax.swing.JLabel("<html><b>Registration and Log In</b><br>\n" +
            "To start you must register an account, click “Register” on the login screen, enter an email and password<br>\n" +
            " and click submit to create an account. Then Back on the home page, enter the email and password to log in<br>\n" +
            " to the system. Password must be at least 4 characters.<br><br>\n" +
            "\n" +
            "<b>Forgot Password</b><br>\n" +
            "If you have forgotten your password enter your email into the username field and click “Reset”. You will be<br>\n" +
            " emailed a new password which you will be prompted to change.<br><br>\n" +
            "\n" +
            "<b>Change Password</b><br>\n" +
            "If you would like to change your password, navigate to the home page, and click “Change Password”. You will<br>\n" +
            " be asked to enter your current password and a new password. When you are ready hit “Submit” to save your new<br>\n" +
            " password.<br><br>\n" +
            "\n" +
            "<b>Courses</b><br>\n" +
            "To <b>add a new course</b>, starting from the home page, click “Course List”, then “Add New Course” on next screen.<br>\n" +
            " You will be prompted to add a Name, ID, and the duration of the course in minutes. <br>\n" +
            "To <b>edit a course</b> you have already created, double click the course in the list of courses table. Then click <br>\n" +
            "“Edit Class” on the next screen. The current course information will be displayed. Click “Submit” to save the changes. <br>\n" +
            "To <b>delete a course</b>, double click the X in the far-right column of the list of courses table. You will be asked <br>\n" +
            "to confirm your choice so you do not accidentally delete any courses.<br><br>\n" +
            "\n" +
            "<b>Student</b><br>\n" +
            "To <b>add students</b> to a course, click “Add Student” on your selected course screen. You must enter a first and <br>\n" +
            "last name, and student ID, and optionally may enter a major, year and photo for identification. When you are done<br>\n" +
            " click “Submit” to save the student.<br>\n" +
            "To <b>edit a student</b>, first select the student from either the course page, or the list of all students. An information<br>\n" +
            " page about the student will show up. Click the “Edit Student Info” button in the top right. <br>\n" +
            "To <b>delete a student</b> from a course, click the X in the far-right column of the student entry in the course table.<br><br>\n" +
            "\n" +
            "<b>Attendance </b><br>\n" +
            "To <b>take attendance</b> click the “Take Attendance” button. You will have the option to enter a date in the top right. For <br>\n" +
            "each student, you will be able to record “Full Credit”, “Absent”, “Tardy”, and “Excused Absence”. If you select tardy you<br>\n" +
            " should enter and amount of time in minutes the student has missed. You may also enter a comment for each student if you wish. <br>\n" +
            "To <b>edit attendance</b>, select a date from the drop-down menu on the far right while on the class page then click edit. You may<br>\n" +
            " change a student’s attendance record for that day and submit changes when ready.<br><br>\n" +
            "\n" +
            "<b>Reports</b><br>\n" +
            "To <b>generate a report</b>, navigate to the student’s or course’s page and select “Generate Report”. You will be asked to select <br>\n" +
            "a date. This will be the first date in which the attendance counts in the report. For weekly reports the system will count <br>\n" +
            "attendances 7 days from the selected date, for monthly it will be all days in the month, and for semester it will count all <br> \n" +
            "attendances. For a student report, only the selected student’s attendances will count on the report. For a course report,<br>\n" +
            "a record of all students will be counted.<br>\n" +
            "To <b>email a report</b>, select the “Email” button at the top of a generated report. You must have an internet connection to send <br>\n" +
            "an email.</html>");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jScrollPane1.getVerticalScrollBar().setUnitIncrement(10);
        jScrollPane1.setViewportView(jLabel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(tutorialUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tutorialUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tutorialUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tutorialUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tutorialUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

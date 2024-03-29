/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cbt.project;
import static cbt.project.login.matno;
import static cbt.project.ADMIN1.Matno;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class Scripts extends javax.swing.JFrame {
    

    /**
     * Creates new form Scripts
     */
    public Scripts() {
        initComponents();
        setLocationRelativeTo(null);
        viewScript(matno);
        viewScript(Matno);
        System.out.println("matno: " + matno);
        System.out.println("Matno: " + Matno);
    }
    
    private void viewScript(String matno){
        try {
            String selectQuery = "select * from answeredquestions where matno = ?";
            Class.forName("com.mysql.cj.jdbc.Driver");
            String path = "jdbc:mysql://localhost:3306/cbt";
            String user = "root";
            String pass = "password123";
            
            Connection con = DriverManager.getConnection(path,user,pass);
            PreparedStatement ps = con.prepareStatement(selectQuery);
            ps.setString(1, matno);
            ResultSet rs = ps.executeQuery();
            List<String> loadedQuestions = new ArrayList<>();
            List<String> loadedOptionA = new ArrayList<>();
            List<String> loadedOptionB = new ArrayList<>();
            List<String> loadedOptionC = new ArrayList<>();
            List<String> loadedOptionD = new ArrayList<>();
            List<String> loadedAnswer = new ArrayList<>();
            List<String> loadedYourAnswer = new ArrayList<>();

            while (rs.next()) {
                loadedQuestions.add(rs.getString("question"));
                loadedOptionA.add(rs.getString("optionA"));
                loadedOptionB.add(rs.getString("optionB"));
                loadedOptionC.add(rs.getString("optionC"));
                loadedOptionD.add(rs.getString("optionD"));
                loadedAnswer.add(rs.getString("answer"));
                loadedYourAnswer.add(rs.getString("yourAnswer"));
                // Add other fields as needed (e.g., options, answers)
            }

            // Convert the list to an array if necessary
            String[] questions = loadedQuestions.toArray(String[]::new);
            String[] optionA = loadedOptionA.toArray(String[]::new);
            String[] optionB = loadedOptionB.toArray(String[]::new);
            String[] optionC = loadedOptionC.toArray(String[]::new);
            String[] optionD = loadedOptionD.toArray(String[]::new);
            String[] answer = loadedAnswer.toArray(String[]::new);
            String[] yourAnswer = loadedYourAnswer.toArray(String[]::new);
            

            
            String Question =""; 
            
           
            for (int i = 0; i < questions.length; i++) {
                //System.out.println((i + 1) + ". " + questionsArray[i]);
                Question = Question + "Question " + (i+1) + " : "+ questions[i] +"\n" + "A. " + optionA[i] + "\n" + "B. " + optionB[i] + "\n" + "C. " + optionC[i] + "\n" + "D. " + optionD[i] + "\n" + "The answer is " + answer[i] + "\n" + "Your answer: " + yourAnswer[i] + "\n\n";
                jTextArea1.setText(Question);
            }
            
        } catch (Exception e) {
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jMenu1.setText("File");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem2.setText("Print");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        try {
            jTextArea1.print();
        } catch (Exception e) {
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Scripts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Scripts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Scripts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Scripts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Scripts().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}

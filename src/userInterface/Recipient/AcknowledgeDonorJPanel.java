/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package userInterface.Recipient;

import Business.Payment.Payment;
import Business.UserAccount.UserAccount;
import Business.Utility.Validation;
import Business.WorkQueue.Acknowledgement;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author JJPL
 */
public class AcknowledgeDonorJPanel extends javax.swing.JPanel {

    /**
     * Creates new form AcknowledgeDonorJPanel
     */
    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private Payment payment;
    public AcknowledgeDonorJPanel(JPanel userProcessContainer,UserAccount userAccount,Payment payment) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.userAccount=userAccount;
        this.payment = payment;
        welcomeJlbl.setText("Welcome "+userAccount.getUsername()+",");
        paymentAmountJlbl.setText(payment.getAmount()+"$");
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        displayJPanel = new javax.swing.JLayeredPane();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        welcomeJlbl = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        paymentAmountJlbl = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        acknowledgementJTextArea = new javax.swing.JTextArea();
        degreeOfSatisfactionSlider = new javax.swing.JSlider();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        submitJbutton = new javax.swing.JButton();
        keypadJPanel = new javax.swing.JLayeredPane();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jDesktopPane2 = new javax.swing.JDesktopPane();
        jDesktopPane3 = new javax.swing.JDesktopPane();
        jDesktopPane5 = new javax.swing.JDesktopPane();
        jDesktopPane6 = new javax.swing.JDesktopPane();
        jDesktopPane7 = new javax.swing.JDesktopPane();
        jDesktopPane8 = new javax.swing.JDesktopPane();

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        displayJPanel.setBackground(new java.awt.Color(255, 255, 255));
        displayJPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        displayJPanel.setOpaque(true);
        displayJPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLayeredPane3.setBackground(new java.awt.Color(102, 204, 255));
        jLayeredPane3.setOpaque(true);
        jLayeredPane3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ERADICATE POVERTY");
        jLayeredPane3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, 26));

        jLabel2.setText("Share Happiness");
        jLayeredPane3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 130, -1));

        displayJPanel.add(jLayeredPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 4, 330, 50));

        welcomeJlbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        welcomeJlbl.setText("jLabel4");
        displayJPanel.add(welcomeJlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 130, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 51, 51));
        jLabel5.setText("***Please do not share your MPIN with anyone");
        displayJPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 280, -1));

        jLabel3.setText("Kindly please submit below acknowledgement form to encourage ");
        displayJPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 290, 20));

        jLabel4.setText("Congratulations!!! You have received ");
        displayJPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 210, 20));

        jLabel6.setText("We are happy to help you as a member of our family. ");
        displayJPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 290, 20));

        paymentAmountJlbl.setText("jLabel7");
        displayJPanel.add(paymentAmountJlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, 60, 20));

        jLabel7.setText("donors. Have a great day!!!.");
        displayJPanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        acknowledgementJTextArea.setColumns(20);
        acknowledgementJTextArea.setForeground(new java.awt.Color(204, 204, 204));
        acknowledgementJTextArea.setRows(5);
        acknowledgementJTextArea.setText("Please enter your acknowledgement\nso it can encourage more donors.");
        acknowledgementJTextArea.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                acknowledgementJTextAreaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                acknowledgementJTextAreaFocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(acknowledgementJTextArea);

        displayJPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 250, 80));
        displayJPanel.add(degreeOfSatisfactionSlider, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 240, -1));

        jLabel8.setText("Are you happy with our service?");
        displayJPanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, -1, -1));

        jLabel9.setText("FULLY SATISFIED");
        displayJPanel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 360, -1, -1));

        jLabel10.setText("NOT SATISFIED");
        displayJPanel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, -1, -1));

        jLabel11.setText("MODERATE");
        displayJPanel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 360, -1, -1));

        submitJbutton.setText("SUBMIT");
        submitJbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitJbuttonActionPerformed(evt);
            }
        });
        displayJPanel.add(submitJbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 390, -1, -1));

        jPanel1.add(displayJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, 330, 440));

        keypadJPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout keypadJPanelLayout = new javax.swing.GroupLayout(keypadJPanel);
        keypadJPanel.setLayout(keypadJPanelLayout);
        keypadJPanelLayout.setHorizontalGroup(
            keypadJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 326, Short.MAX_VALUE)
        );
        keypadJPanelLayout.setVerticalGroup(
            keypadJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 136, Short.MAX_VALUE)
        );

        jPanel1.add(keypadJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 500, 330, 140));

        jDesktopPane1.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );

        jPanel1.add(jDesktopPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 30, 10, 450));

        jDesktopPane2.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jDesktopPane2Layout = new javax.swing.GroupLayout(jDesktopPane2);
        jDesktopPane2.setLayout(jDesktopPane2Layout);
        jDesktopPane2Layout.setHorizontalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
        jDesktopPane2Layout.setVerticalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jPanel1.add(jDesktopPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 480, 350, 20));

        jDesktopPane3.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jDesktopPane3Layout = new javax.swing.GroupLayout(jDesktopPane3);
        jDesktopPane3.setLayout(jDesktopPane3Layout);
        jDesktopPane3Layout.setHorizontalGroup(
            jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jDesktopPane3Layout.setVerticalGroup(
            jDesktopPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );

        jPanel1.add(jDesktopPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, 10, 450));

        jDesktopPane5.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jDesktopPane5Layout = new javax.swing.GroupLayout(jDesktopPane5);
        jDesktopPane5.setLayout(jDesktopPane5Layout);
        jDesktopPane5Layout.setHorizontalGroup(
            jDesktopPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
        jDesktopPane5Layout.setVerticalGroup(
            jDesktopPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jPanel1.add(jDesktopPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 350, 40));

        jDesktopPane6.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jDesktopPane6Layout = new javax.swing.GroupLayout(jDesktopPane6);
        jDesktopPane6.setLayout(jDesktopPane6Layout);
        jDesktopPane6Layout.setHorizontalGroup(
            jDesktopPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jDesktopPane6Layout.setVerticalGroup(
            jDesktopPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        jPanel1.add(jDesktopPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 500, -1, 150));

        jDesktopPane7.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jDesktopPane7Layout = new javax.swing.GroupLayout(jDesktopPane7);
        jDesktopPane7.setLayout(jDesktopPane7Layout);
        jDesktopPane7Layout.setHorizontalGroup(
            jDesktopPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
        jDesktopPane7Layout.setVerticalGroup(
            jDesktopPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jPanel1.add(jDesktopPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 640, -1, -1));

        jDesktopPane8.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jDesktopPane8Layout = new javax.swing.GroupLayout(jDesktopPane8);
        jDesktopPane8.setLayout(jDesktopPane8Layout);
        jDesktopPane8Layout.setHorizontalGroup(
            jDesktopPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jDesktopPane8Layout.setVerticalGroup(
            jDesktopPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        jPanel1.add(jDesktopPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 500, -1, 150));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 950, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 950, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 677, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 677, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void acknowledgementJTextAreaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_acknowledgementJTextAreaFocusGained
        // TODO add your handling code here:
        if(acknowledgementJTextArea.getText().trim().equalsIgnoreCase("Please enter your acknowledgement\n" +
"so it can encourage more donors."))
        {
            acknowledgementJTextArea.setText("");
            acknowledgementJTextArea.setForeground(Color.BLACK);
            
        }
    }//GEN-LAST:event_acknowledgementJTextAreaFocusGained

    private void acknowledgementJTextAreaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_acknowledgementJTextAreaFocusLost
        // TODO add your handling code here:
        
        if(acknowledgementJTextArea.getText().trim().equalsIgnoreCase(""))
        {
            acknowledgementJTextArea.setText("Please enter your acknowledgement\n" +
"so it can encourage more donors.");
            acknowledgementJTextArea.setForeground(Color.LIGHT_GRAY);
            
        }
    }//GEN-LAST:event_acknowledgementJTextAreaFocusLost

    private void submitJbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitJbuttonActionPerformed
        // TODO add your handling code here:
        
        if(!validateForm()){
        
            Acknowledgement acknowledgement = new Acknowledgement();
            acknowledgement.setAcknowledgementMsg(acknowledgementJTextArea.getText().trim());
            
            if(degreeOfSatisfactionSlider.getValue()==0)
            acknowledgement.setDegreeOfSatisfaction("NOT SATISFIED");
            else if (degreeOfSatisfactionSlider.getValue()==100)
                acknowledgement.setDegreeOfSatisfaction("COMPLETELY SATISFIED");
            else
                acknowledgement.setDegreeOfSatisfaction("MODERATELY SATISFIED");
                
            JOptionPane.showMessageDialog(displayJPanel,"Thank you for completing acknowledgement form");
            RecipientWorkAreaJPanel recipientWorkAreaJPanel = new RecipientWorkAreaJPanel(userProcessContainer,userAccount);
            CardLayout layout = (CardLayout)userProcessContainer.getLayout();
            userProcessContainer.add("recipientWorkAreaJPanel",recipientWorkAreaJPanel);
            layout.next(userProcessContainer);
    }
    }//GEN-LAST:event_submitJbuttonActionPerformed

    public boolean validateForm()
    {
        boolean errorFlag=false;
        if(!Validation.validateTextAreaForNonEmpty(acknowledgementJTextArea)||acknowledgementJTextArea.getText().trim().equalsIgnoreCase("Please enter your acknowledgement\n" +
"so it can encourage more donors."))
        {
            JOptionPane.showMessageDialog(displayJPanel,"Please enter acknowledgement message","NO INPUT",JOptionPane.ERROR_MESSAGE);
            errorFlag=true;
            
        }
        
        return errorFlag;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea acknowledgementJTextArea;
    private javax.swing.JSlider degreeOfSatisfactionSlider;
    private javax.swing.JLayeredPane displayJPanel;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JDesktopPane jDesktopPane3;
    private javax.swing.JDesktopPane jDesktopPane5;
    private javax.swing.JDesktopPane jDesktopPane6;
    private javax.swing.JDesktopPane jDesktopPane7;
    private javax.swing.JDesktopPane jDesktopPane8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLayeredPane keypadJPanel;
    private javax.swing.JLabel paymentAmountJlbl;
    private javax.swing.JButton submitJbutton;
    private javax.swing.JLabel welcomeJlbl;
    // End of variables declaration//GEN-END:variables
}

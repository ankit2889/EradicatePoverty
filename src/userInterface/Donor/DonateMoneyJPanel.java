/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package userInterface.Donor;

import Business.Donor.DonorPerson;
import Business.Ecosystem;
import Business.Enterprise.DonationEnterprise;
import Business.Enterprise.Enterprise;
import Business.GovernmentEnterprise.Government;
import Business.GovernmentEnterprise.Region;
import Business.GovernmentEnterprise.Village;
import Business.LocalAgent.LocalAgent;
import Business.MobileEnterprise.MobileEnterprise;
import Business.Network.Network;
import Business.Payment.Payment;
import Business.Person.Person;
import Business.Recipient.Recipient;
import Business.Role.DonorRole;
import Business.UserAccount.UserAccount;
import Business.Utility.Validation;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author JJPL
 */
public class DonateMoneyJPanel extends javax.swing.JPanel {

    /**
     * Creates new form DonateMoneyJPanel
     */private JPanel userProcessContainer;
     private Ecosystem business;
     private Government governmentEnterprise;
     private DonationEnterprise donationEnterprise;
     private DonationEnterprise inEnterprise=null;
     private LinkedList<LocalAgent> regionalLocalAgentQueue;
     private MobileEnterprise mobileEnterprise = null;
     private BufferedImage bufferedImg=null;
     
    public DonateMoneyJPanel(JPanel upc,Ecosystem business) {
        initComponents();
        this.userProcessContainer = upc;
        this.business = business;
        this.regionalLocalAgentQueue = new LinkedList<>();
        setValidators();
        hideJPanels();
        
        populatefreeJCharts();
        populateRegions();
        
    }
    
    
    public void populateRegions()
    {
        for(Network network:business.getRootNetwork().getSubNetworkDirectory().getNetworkList())
        {
            for (Enterprise enterprise:network.getEnterpriseDirectory().getEnterpriseList())
            {
                if(enterprise instanceof Government)
                {
                    governmentEnterprise = (Government)enterprise;
                    
                    regionComboBox.addItem(governmentEnterprise.getCountryName());
                }
                
                
            }
        }
    }
    
    public void populatefreeJCharts()
    {
        
        
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(34.0, "Series 1", "Category 1");
        dataset.addValue(23.0, "Series 1", "Category 2");
        dataset.addValue(54.0, "Series 1", "Category 3");
        final JFreeChart chart = ChartFactory.createBarChart(
            "Bar Chart", 
            "Category",
            "Series",
            dataset,
            PlotOrientation.VERTICAL,
            true,
            true,
            false
        );
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(300, 300));
        JPanel jpanel = new JPanel();
        jpanel.add(chartPanel,BorderLayout.CENTER);
        jpanel.setVisible(true);
        populateImage();
        
    }
    
    
    public void populateImage()
    {
//     try
//        {
//            bufferedImg = ImageIO.read("eradicatePoverty1.jpeg");
//            File file=jFileChooser.getSelectedFile();
//            path=file.getPath();
//            ImageIcon imgIco=new ImageIcon(bufferedImg);
//            certificateImage.setIcon(new ImageIcon(imgIco.getImage().getScaledInstance(212, 122, java.awt.Image.SCALE_FAST)));
//
//        } catch (IOException ex)
//        {
//            JOptionPane.showMessageDialog(null, "Please select a valid file", "INVALID", JOptionPane.ERROR_MESSAGE);
//        }
        
    }
    
    
    public void clearAllFields()
    {
        donationAmountComboBox.setSelectedItem("Please select amount:");
        //otherDonationAmountJtext.setText("Enter other amount here:");
        
        donorPasswordJtext.setText("");
        donorPasswordJtext.setForeground(Color.LIGHT_GRAY);
        mediaTypeComboBox.setSelectedItem("Where did you hear about us");
        cardDetailsJPanel.setVisible(false);
        cardNoJtext.setText("Enter 16 digit card no:");
        cardHolderNameJtext.setText("");
        ccvJtext.setText("CCV:");
        passwordStrength.setText("");
        donorEmailAddressJtext.setForeground(Color.lightGray);
        donorEmailAddressJtext.setText("Your email id:");
        cardDetailsJPanel.setVisible(false);
        donorContactNoJtext.setText("Contact no:");
        donorContactNoJtext.setForeground(Color.LIGHT_GRAY);
        paymentTypeRadiobutton.setSelected(false);
        paymentTypeRadiobutton2.setSelected(false);
        
        
    }
    
    
    public void setValidators()
    {
     emailIdValidatorJlbl.setText("");
     contactNoValidatorJlbl.setText("");
     passwordStrength.setText("");
     amtValidatorJlbl4.setText("");
     passwordValidatorJlbl.setForeground(Color.black);
     
     passwordValidatorJlbl.setText("(Minimum 8 characters,no space and tab,atleast one lowercase and one uppercase,special characters allowed)");
     passwordStrengthValueJlbl.setText("");
     mediaTypeValidatorJlbl.setText("");
     paymentTypeValidator.setText("");
     ccvValidatorJlbl.setText("");
     cardNoValidatorJlbl.setText("");
     cardHolderNameValidatorJlbl.setText("");
     expiryDateValidatorJlbl.setText("");
             
    }
    
    public void hideJPanels()
    {
        cardDetailsJPanel.setVisible(false);
    }
    
    public boolean validateForm()
    {
        boolean errorFlag=false;
        
        if(!Validation.validateTextFieldsForEmailId(donorEmailAddressJtext))
        {
            errorFlag=true;
            emailIdValidatorJlbl.setForeground(Color.red);
            emailIdValidatorJlbl.setText("Please enter valid email id");
        }
        
        if(!Validation.validateTextFieldForPassword(donorPasswordJtext))
        {
            errorFlag=true;
            passwordValidatorJlbl.setForeground(Color.red);
            passwordValidatorJlbl.setText("Please enter valid password");
        }
        
        if(!Validation.validateTextFieldsForPhoneNumber(donorContactNoJtext))
        {
            errorFlag=true;
            contactNoValidatorJlbl.setForeground(Color.red);
            contactNoValidatorJlbl.setText("Please enter valid contact no.");
        }
        
        
        
        
        
//        if(String.valueOf(donationAmountComboBox.getSelectedItem()).equalsIgnoreCase("Please select amount:"))
//        {
//           if(!Validation.validateTextFieldsForNonEmpty(otherDonationAmountJtext)||!Validation.validateTextFieldsForInteger(otherDonationAmountJtext))
//           {
//               errorFlag =true;
//               amtValidatorJlbl4.setForeground(Color.red);
//                       
//               amtValidatorJlbl4.setText("Please enter donation amount to continue");
//           }
//        }
//        
//        
//         if(!String.valueOf(donationAmountComboBox.getSelectedItem()).equalsIgnoreCase("Please select amount:"))
//        {
//           if(!otherDonationAmountJtext.getText().trim().equalsIgnoreCase("Enter other amount here:"))
//           {
//               errorFlag =true;
//               amtValidatorJlbl4.setForeground(Color.red);
//               amtValidatorJlbl4.setText("Please enter appropriate amount");
//           }
//        }
         
         if(String.valueOf(mediaTypeComboBox.getSelectedItem()).equalsIgnoreCase("Where did you hear about us"))
         {
             errorFlag=true;
             mediaTypeValidatorJlbl.setForeground(Color.red);
             mediaTypeValidatorJlbl.setText("Please select media type");
         }
         
         
         if(!paymentTypeRadiobutton.isSelected()&&!paymentTypeRadiobutton2.isSelected())
         {
             errorFlag=true;
             paymentTypeValidator.setText("Please select payment type to proceed");
             paymentTypeValidator.setForeground(Color.red);
         }
         
         if(paymentTypeRadiobutton.isSelected())
         {
             
             
             if(!Validation.validateTextFieldsForString(cardHolderNameJtext))
             {
                 errorFlag=true;
                 cardHolderNameValidatorJlbl.setForeground(Color.red);
                 cardHolderNameValidatorJlbl.setText("Please enter valid card holder name");
             }
             
             if(!Validation.validateTextFieldForCCV(ccvJtext))
             {
                 errorFlag=true;
                 ccvValidatorJlbl.setForeground(Color.red);
                 ccvValidatorJlbl.setText("Please enter valid CCV");
             }
             
             
             if(!Validation.validateTextFieldForCreditCardNo(cardNoJtext))
             {
                 errorFlag=true;
                 cardNoValidatorJlbl.setForeground(Color.red);
                 cardNoValidatorJlbl.setText("Please enter valid card no.");
             }
             
             if(String.valueOf(expiryMonthComboBox.getSelectedItem()).equalsIgnoreCase("MM"))
             {
                 errorFlag = true;
                 expiryDateValidatorJlbl.setForeground(Color.red);
                expiryDateValidatorJlbl.setText("Please select correct date");
             }
             
             if(String.valueOf(expiryYearComboBox.getSelectedItem()).equalsIgnoreCase("YYYY"))
             {
                 errorFlag = true;
                expiryDateValidatorJlbl.setText("Please select correct date");
             }
             
             
             
             
         }
        
        
        
        return errorFlag;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        donationAmountComboBox = new javax.swing.JComboBox();
        otherDonationAmountJtext = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        paymentTypeRadiobutton2 = new javax.swing.JRadioButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        paymentTypeRadiobutton = new javax.swing.JRadioButton();
        giveNowJbutton = new javax.swing.JButton();
        cardDetailsJPanel = new javax.swing.JLayeredPane();
        cardNoJtext = new javax.swing.JTextField();
        cardHolderNameJtext = new javax.swing.JTextField();
        ccvJtext = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        expiryYearComboBox = new javax.swing.JComboBox();
        expiryMonthComboBox = new javax.swing.JComboBox();
        expiryDateValidatorJlbl = new javax.swing.JLabel();
        cardNoValidatorJlbl = new javax.swing.JLabel();
        ccvValidatorJlbl = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cardHolderNameValidatorJlbl = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        paymentTypeValidator = new javax.swing.JLabel();
        passwordValidatorJlbl = new javax.swing.JLabel();
        mediaTypeValidatorJlbl = new javax.swing.JLabel();
        mediaTypeComboBox = new javax.swing.JComboBox();
        regionComboBox = new javax.swing.JComboBox();
        jSeparator3 = new javax.swing.JSeparator();
        donorContactNoJtext = new javax.swing.JTextField();
        contactNoValidatorJlbl = new javax.swing.JLabel();
        donorEmailAddressJtext = new javax.swing.JTextField();
        emailIdValidatorJlbl = new javax.swing.JLabel();
        donorPasswordJtext = new javax.swing.JPasswordField();
        passwordStrength = new javax.swing.JLabel();
        passwordStrengthValueJlbl = new javax.swing.JLabel();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        amtValidatorJlbl4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        imgPanel1 = new javax.swing.JLayeredPane();
        imgJlbl = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLayeredPane1.setBackground(new java.awt.Color(0, 0, 0));
        jLayeredPane1.setOpaque(true);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Eradicate Poverty");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Share happiness");

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel1))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(jLabel2)))
                .addContainerGap(858, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        add(jLayeredPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 70));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("PAYMENT OPTIONS:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, -1, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("COUNTRY:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 60, -1));

        donationAmountComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Please select amount:", "50", "100", "150", "200", "500", "1000" }));
        donationAmountComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                donationAmountComboBoxActionPerformed(evt);
            }
        });
        add(donationAmountComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 160, 30));

        otherDonationAmountJtext.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                otherDonationAmountJtextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                otherDonationAmountJtextFocusLost(evt);
            }
        });
        add(otherDonationAmountJtext, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, 160, 30));

        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField1.setText("OTHER:");
        jTextField1.setEnabled(false);
        add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, 60, 30));

        jLabel5.setText("(in dollars)");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, -1, -1));

        jLabel6.setText("(in dollars)");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, -1, 10));

        paymentTypeRadiobutton2.setText("American Express");
        paymentTypeRadiobutton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentTypeRadiobutton2ActionPerformed(evt);
            }
        });
        add(paymentTypeRadiobutton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 470, -1, -1));
        add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 490, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("DONATION:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 70, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("DONOR INFORMATION:");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, 30));

        paymentTypeRadiobutton.setText("Visa/Master");
        paymentTypeRadiobutton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                paymentTypeRadiobuttonItemStateChanged(evt);
            }
        });
        paymentTypeRadiobutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentTypeRadiobuttonActionPerformed(evt);
            }
        });
        add(paymentTypeRadiobutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 470, -1, -1));

        giveNowJbutton.setBackground(new java.awt.Color(0, 255, 51));
        giveNowJbutton.setText("GIVE NOW>>");
        giveNowJbutton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        giveNowJbutton.setBorderPainted(false);
        giveNowJbutton.setContentAreaFilled(false);
        giveNowJbutton.setOpaque(true);
        giveNowJbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                giveNowJbuttonActionPerformed(evt);
            }
        });
        add(giveNowJbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 710, 100, 30));

        cardDetailsJPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        cardDetailsJPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cardNoJtext.setForeground(new java.awt.Color(204, 204, 204));
        cardNoJtext.setText("Enter 16 digit card no:");
        cardNoJtext.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cardNoJtextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cardNoJtextFocusLost(evt);
            }
        });
        cardNoJtext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardNoJtextActionPerformed(evt);
            }
        });
        cardDetailsJPanel.add(cardNoJtext, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 286, 30));

        cardHolderNameJtext.setForeground(new java.awt.Color(204, 204, 204));
        cardHolderNameJtext.setText("Enter name printed on card:");
        cardHolderNameJtext.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cardHolderNameJtextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cardHolderNameJtextFocusLost(evt);
            }
        });
        cardDetailsJPanel.add(cardHolderNameJtext, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 290, 30));

        ccvJtext.setForeground(new java.awt.Color(204, 204, 204));
        ccvJtext.setText("CCV");
        ccvJtext.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ccvJtextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ccvJtextFocusLost(evt);
            }
        });
        cardDetailsJPanel.add(ccvJtext, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, 70, 30));

        jLabel9.setText("Expiry Date:");
        cardDetailsJPanel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        expiryYearComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "YYYY", "2015", "2016", "2017", "2018", "2019", "2020" }));
        expiryYearComboBox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                expiryYearComboBoxFocusGained(evt);
            }
        });
        cardDetailsJPanel.add(expiryYearComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, -1, -1));

        expiryMonthComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MM", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "", "" }));
        expiryMonthComboBox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                expiryMonthComboBoxFocusGained(evt);
            }
        });
        cardDetailsJPanel.add(expiryMonthComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, -1, -1));

        expiryDateValidatorJlbl.setText("jLabel11");
        cardDetailsJPanel.add(expiryDateValidatorJlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 490, 20));

        cardNoValidatorJlbl.setText("jLabel11");
        cardDetailsJPanel.add(cardNoValidatorJlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 190, 20));

        ccvValidatorJlbl.setText("jLabel11");
        cardDetailsJPanel.add(ccvValidatorJlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, 240, 20));
        cardDetailsJPanel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        cardHolderNameValidatorJlbl.setText("jLabel11");
        cardDetailsJPanel.add(cardHolderNameValidatorJlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, 270, 20));

        add(cardDetailsJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 530, 580, 170));

        jLabel10.setForeground(new java.awt.Color(153, 153, 153));
        jLabel10.setText("***  You can use this email id and password to login and track your donation");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 430, -1, 20));

        paymentTypeValidator.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        paymentTypeValidator.setText("jLabel11");
        add(paymentTypeValidator, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 500, 360, 20));

        passwordValidatorJlbl.setText("jLabel11");
        add(passwordValidatorJlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 520, -1));

        mediaTypeValidatorJlbl.setText("jLabel11");
        add(mediaTypeValidatorJlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 390, 440, 20));

        mediaTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Where did you hear about us", "Internet", "Radio", "Newspaper" }));
        add(mediaTypeComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 350, 280, 30));

        add(regionComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 100, 30));
        add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 490, 10));

        donorContactNoJtext.setForeground(new java.awt.Color(204, 204, 204));
        donorContactNoJtext.setText("Contact no:");
        donorContactNoJtext.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                donorContactNoJtextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                donorContactNoJtextFocusLost(evt);
            }
        });
        add(donorContactNoJtext, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 280, 280, 30));

        contactNoValidatorJlbl.setText("jLabel11");
        add(contactNoValidatorJlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 320, 280, -1));

        donorEmailAddressJtext.setForeground(new java.awt.Color(204, 204, 204));
        donorEmailAddressJtext.setText("Your email id:");
        donorEmailAddressJtext.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                donorEmailAddressJtextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                donorEmailAddressJtextFocusLost(evt);
            }
        });
        add(donorEmailAddressJtext, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 280, 30));

        emailIdValidatorJlbl.setText("jLabel11");
        add(emailIdValidatorJlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 280, -1));

        donorPasswordJtext.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                donorPasswordJtextFocusLost(evt);
            }
        });
        donorPasswordJtext.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                donorPasswordJtextKeyPressed(evt);
            }
        });
        add(donorPasswordJtext, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 280, 30));

        passwordStrength.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        passwordStrength.setText("jLabel11");
        add(passwordStrength, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 150, -1));

        passwordStrengthValueJlbl.setText("jLabel11");
        add(passwordStrengthValueJlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 390, -1, -1));

        javax.swing.GroupLayout jLayeredPane3Layout = new javax.swing.GroupLayout(jLayeredPane3);
        jLayeredPane3.setLayout(jLayeredPane3Layout);
        jLayeredPane3Layout.setHorizontalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );
        jLayeredPane3Layout.setVerticalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 210, Short.MAX_VALUE)
        );

        add(jLayeredPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 320, -1, -1));

        amtValidatorJlbl4.setText("jLabel11");
        add(amtValidatorJlbl4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, 220, 20));

        jButton1.setText("Do you want to check poverty rate?");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, 240, -1));

        imgPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        imgJlbl.setText("jLabel11");

        javax.swing.GroupLayout imgPanel1Layout = new javax.swing.GroupLayout(imgPanel1);
        imgPanel1.setLayout(imgPanel1Layout);
        imgPanel1Layout.setHorizontalGroup(
            imgPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgJlbl, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
        );
        imgPanel1Layout.setVerticalGroup(
            imgPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imgPanel1Layout.createSequentialGroup()
                .addComponent(imgJlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );
        imgPanel1.setLayer(imgJlbl, javax.swing.JLayeredPane.DEFAULT_LAYER);

        add(imgPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 80, 370, 220));
    }// </editor-fold>//GEN-END:initComponents

    private void donationAmountComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_donationAmountComboBoxActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_donationAmountComboBoxActionPerformed

    private void giveNowJbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_giveNowJbuttonActionPerformed
        // TODO add your handling code here:
        setValidators();
        
       
        
        if(!validateForm())
        {
            
            int answer = JOptionPane.showConfirmDialog(null,"Are you sure you want to proceed with donation?","EP-Donation",JOptionPane.YES_NO_OPTION);
            if(answer ==JOptionPane.YES_OPTION)
            {
                
             double donationAmount=0.0;
            if(paymentTypeRadiobutton2.isSelected())
            donationAmount = Math.round(donationAmount*.98);  
                
          try{
            
            if(!String.valueOf(donationAmountComboBox.getSelectedItem()).equalsIgnoreCase("Please select amount:"))
            {
                donationAmount = Double.parseDouble(String.valueOf(donationAmountComboBox.getSelectedItem()));
            }
            
            else if(!otherDonationAmountJtext.getText().trim().equals(null)){
                donationAmount = Double.parseDouble(otherDonationAmountJtext.getText());
            
            }
            
            }
            
            catch(Exception e){System.out.println("Exception caught"+e);}
          
            for (Network network:business.getRootNetwork().getSubNetworkDirectory().getNetworkList())
            {
                for(Enterprise enterprise:network.getEnterpriseDirectory().getEnterpriseList())
                {
                    if(enterprise instanceof DonationEnterprise)
                {
                    donationEnterprise = (DonationEnterprise)enterprise;
                    for(Enterprise e:donationEnterprise.getAssociatedEnterprise())
                    {
                        if(e instanceof Government)
                        {
                            governmentEnterprise = (Government)e;
                             if(governmentEnterprise.getCountryName().equalsIgnoreCase(String.valueOf(regionComboBox.getSelectedItem())))
                                {
                                    inEnterprise = donationEnterprise;
                                    break;
                                }
                          
                        }
                    }
                    
                }
            }
            }
            DonorPerson donorPerson=null;
            DonationEnterprise donationEnterprise=null;
            Person person=null;
            if(business.checkIfUserNameIsPresent(donorEmailAddressJtext.getText().trim()))
            {
             for(Network network:business.getAllNetwork())
             {
                 for(Enterprise enterprise:network.getEnterpriseDirectory().getEnterpriseList())
                 {
                     if(enterprise instanceof DonationEnterprise)
                         donationEnterprise=(DonationEnterprise)enterprise;
                     for(UserAccount userAccount:donationEnterprise.getUserAccountDirectory().getUserAccountList())
                     {
                         if(userAccount.getPerson().getEmailId().equalsIgnoreCase(donorEmailAddressJtext.getText().trim()))
                             person = userAccount.getPerson();
                         if(person instanceof DonorPerson)
                             donorPerson = (DonorPerson)person;
                     }
                 }
             }
            }
            
            else
            {
            donorPerson = new DonorPerson();
            }
            Payment paymentItem = new Payment();
            UserAccount donorAccount=business.getUserAccountDirectory().createUserAccount(donorPasswordJtext.getText().trim(),"donor", donorPerson, new DonorRole());
            //inEnterprise.getLocalEnterpriseBankAccount().setAccountBalance(donationAmount);
            inEnterprise.getDonorDirectory().getDonorList().add(donorPerson);
            paymentItem.setDonor(donorPerson);
            paymentItem.setEnterprise(inEnterprise);
            inEnterprise.getLocalEnterpriseBankAccount().setAccountBalance(donationAmount*.02);
            
            donationAmount = Math.round(donationAmount*.98);
            paymentItem.setAmount(donationAmount);
            paymentItem.getPaymentMode().setCardNo(cardNoJtext.getText().trim());
            paymentItem.getPaymentMode().setCardHolderName(cardHolderNameJtext.getText().toUpperCase());
            paymentItem.getPaymentMode().setCcv(ccvJtext.getText().trim());
            paymentItem.setStatus(Payment.paymentStatus.DONATED.getValue());
            //paymentItem.setRegion(selectedRegion);
            inEnterprise.addPayment(paymentItem);
            
            donorAccount.getWorkQueue().getWorkRequestList().add(paymentItem);
            double currentDonationamount=donationAmount;
       
            
            // logic to transfer money directly to agent if balance exceeds 5000
            
            //WorkQueue regionalWorkQueue;
            double enterpriseRegionalWorkQueueAccountBalance=0.0;
            double enterpriseAccountBalance = inEnterprise.getEnterpriseAccountBalance();
            double regionDividingFactor = 0.0;
            double amountToBeDistributed=0.0;
            int regionSize = getRegion().size();
            
            if(inEnterprise.getEnterpriseAccountBalance()>=1500) // if the balance exceeds 5000$
               {
                
                amountToBeDistributed = enterpriseAccountBalance/regionSize;
            for(Region selectedRegion:getRegion())
            {
               
                
                
//            if(!inEnterprise.regionalWorkQueuePresent(selectedRegion, inEnterprise)) // check if regional workQueue is present or not
//            {
//                regionalWorkQueue=inEnterprise.createRegionalWorkQueue(selectedRegion);
//                inEnterprise.addWorkRequest(regionalWorkQueue, paymentItem);
//                paymentItem.setAmount(paymentItem.getAmount());
//                currentDonationamount = paymentItem.getAmount();
//            }
//            
//            else 
//            {
//                regionalWorkQueue =inEnterprise.getRegionalWorkQueue(selectedRegion);
//               inEnterprise.addWorkRequest(regionalWorkQueue,paymentItem);
//               paymentItem.setAmount(paymentItem.getAmount());
//               currentDonationamount = paymentItem.getAmount();
//            }  
               
           // enterpriseRegionalWorkQueueAccountBalance = inEnterprise.getAccountBalance(regionalWorkQueue);// get account balance for regional workqueue
           
            
               
                   amountToBeDistributed =amountToBeDistributed - Math.round(inEnterprise.getEnterpriseAccountBalance()*regionDividingFactor);
                   
//                   regionalLocalAgentQueue = getRegionalLocalAgentList(inEnterprise, selectedRegion);
//                   LocalAgent selectedLocalAgent = regionalLocalAgentQueue.getFirst();
//                   
                   
                   int noOfPeople=selectedRegion.noOfRecipients();
                   
                   if(noOfPeople==0)break;
                   String message="";
                  // noOfPeople=findTotalRecipients(inEnterprise,selectedRegion);
                  int noOfVillagesWithRecipients=0;
                  
                  for(Village village:selectedRegion.getVillageList())
                  {
                      if(village.getRecipientList().size()>0)noOfVillagesWithRecipients++;
                  }
                  double finalTransferAmountVillage=amountToBeDistributed/noOfVillagesWithRecipients; 
                   // for extremely poor recipient with class 0
                  for(Village village:selectedRegion.getVillageList())
                  {
                      if(village.getRecipientList().size()>0)
                      {
                      
                   double finalTransferAmountRecipient=0.0; 
                   double recipientDividingFactor =0.0;
                   double transferAmountRecipient=0.0;
                      transferAmountRecipient = finalTransferAmountVillage/village.getRecipientList().size();
                     for(Recipient recipient:village.getRecipientList())
                       {
                          if(recipient.getRecipientClass()==0)
                          {
                           recipientDividingFactor=0.0;   
                           finalTransferAmountRecipient=transferAmountRecipient - (transferAmountRecipient*recipientDividingFactor); 
                           Payment newPaymentItem = new Payment();
                           newPaymentItem.setAmount(finalTransferAmountRecipient);
                           newPaymentItem.setStatus(Payment.paymentStatus.TRANSFERRED.getValue());
                           newPaymentItem.getPaymentRecipientList().add(recipient);
                           recipient.getUserAccount().getWorkQueue().getWorkRequestList().add(newPaymentItem);
                           for(LocalAgent localAgent:recipient.getAssignedLocalAgent())
                           {
                               localAgent.getUserAccount().getWorkQueue().getWorkRequestList().add(newPaymentItem);
                              localAgent.getSavingsAccount().setAccountBalance(finalTransferAmountRecipient);
                              newPaymentItem.setLocalAgent(localAgent);
                              
                           }
                           
                           message = "\n You have received "+paymentItem.getAmount()+"$ from Eradicate Poverty.\n Thanks for joining Eradicate Poverty.";
                         //sendSMS.sendMessage(recipient.getUserAccount().getUsername(),message);
                           //paymentItem.setTransferredDate(new Date());
                          paymentItem.getPaymentRecipientList().add(recipient);
                          }
                          
                          
                          else  if(recipient.getRecipientClass()==1)
                          { 
                           recipientDividingFactor=0.1;   
                          finalTransferAmountRecipient=transferAmountRecipient - (transferAmountRecipient*recipientDividingFactor); 
                           Payment newPaymentItem = new Payment();
                           newPaymentItem.setAmount(finalTransferAmountRecipient);
                           newPaymentItem.setStatus(Payment.paymentStatus.TRANSFERRED.getValue());
                           recipient.getUserAccount().getWorkQueue().getWorkRequestList().add(newPaymentItem);
                           newPaymentItem.getPaymentRecipientList().add(recipient);
                           for(LocalAgent localAgent:recipient.getAssignedLocalAgent())
                           {
                               localAgent.getUserAccount().getWorkQueue().getWorkRequestList().add(newPaymentItem);
                              localAgent.getSavingsAccount().setAccountBalance(finalTransferAmountRecipient);
                              newPaymentItem.setLocalAgent(localAgent);
                              
                           }
                           
                           message = "\n You have received "+paymentItem.getAmount()+"$ from Eradicate Poverty.\n Thanks for joining Eradicate Poverty.";
                         //sendSMS.sendMessage(recipient.getUserAccount().getUsername(),message);
                           //paymentItem.setTransferredDate(new Date());
                          paymentItem.getPaymentRecipientList().add(recipient);
                          }
                        
                          else if(recipient.getRecipientClass()==2)
                          { 
                           recipientDividingFactor=0.15;   
                           finalTransferAmountRecipient=transferAmountRecipient - (transferAmountRecipient*recipientDividingFactor); 
                           Payment newPaymentItem = new Payment();
                           newPaymentItem.setAmount(finalTransferAmountRecipient);
                           newPaymentItem.setStatus(Payment.paymentStatus.TRANSFERRED.getValue());
                           newPaymentItem.getPaymentRecipientList().add(recipient);
                           recipient.getUserAccount().getWorkQueue().getWorkRequestList().add(newPaymentItem);
                           for(LocalAgent localAgent:recipient.getAssignedLocalAgent())
                           {
                               localAgent.getUserAccount().getWorkQueue().getWorkRequestList().add(newPaymentItem);
                              localAgent.getSavingsAccount().setAccountBalance(finalTransferAmountRecipient);
                              newPaymentItem.setLocalAgent(localAgent);
                              
                           }
                           message = "\n You have received "+paymentItem.getAmount()+"$ from Eradicate Poverty.\n Thanks for joining Eradicate Poverty.";
                         //sendSMS.sendMessage(recipient.getUserAccount().getUsername(),message);
                           //paymentItem.setTransferredDate(new Date());
                          paymentItem.getPaymentRecipientList().add(recipient);
                          }
                          
                          else if(recipient.getRecipientClass()==3)
                          { 
                              
                             recipientDividingFactor=0.2; 
                           finalTransferAmountRecipient=transferAmountRecipient - (transferAmountRecipient*recipientDividingFactor); 
                           Payment newPaymentItem = new Payment();
                           newPaymentItem.setAmount(finalTransferAmountRecipient);
                           newPaymentItem.setStatus(Payment.paymentStatus.TRANSFERRED.getValue());
                           newPaymentItem.getPaymentRecipientList().add(recipient);
                           recipient.getUserAccount().getWorkQueue().getWorkRequestList().add(newPaymentItem);
                           for(LocalAgent localAgent:recipient.getAssignedLocalAgent())
                           {
                               localAgent.getUserAccount().getWorkQueue().getWorkRequestList().add(newPaymentItem);
                              localAgent.getSavingsAccount().setAccountBalance(finalTransferAmountRecipient);
                              newPaymentItem.setLocalAgent(localAgent);
                              
                           }
                           message = "\n You have received "+paymentItem.getAmount()+"$ from Eradicate Poverty.\n Thanks for joining Eradicate Poverty.";
                         //sendSMS.sendMessage(recipient.getUserAccount().getUsername(),message);
                           //paymentItem.setTransferredDate(new Date());
                          paymentItem.getPaymentRecipientList().add(recipient);
                          }
                          
                          else if(recipient.getRecipientClass()==4)
                          { 
                           recipientDividingFactor = .22;   
                           finalTransferAmountRecipient=transferAmountRecipient - (transferAmountRecipient*recipientDividingFactor); 
                           Payment newPaymentItem = new Payment();
                           newPaymentItem.setAmount(finalTransferAmountRecipient);
                           newPaymentItem.setStatus(Payment.paymentStatus.TRANSFERRED.getValue());
                           newPaymentItem.getPaymentRecipientList().add(recipient);
                           recipient.getUserAccount().getWorkQueue().getWorkRequestList().add(newPaymentItem);
                           for(LocalAgent localAgent:recipient.getAssignedLocalAgent())
                           {
                               localAgent.getUserAccount().getWorkQueue().getWorkRequestList().add(newPaymentItem);
                              localAgent.getSavingsAccount().setAccountBalance(finalTransferAmountRecipient);
                              newPaymentItem.setLocalAgent(localAgent);
                              
                           }
                           message = "\n You have received "+paymentItem.getAmount()+"$ from Eradicate Poverty.\n Thanks for joining Eradicate Poverty.";
                         //sendSMS.sendMessage(recipient.getUserAccount().getUsername(),message);
                           //paymentItem.setTransferredDate(new Date());
                          paymentItem.getPaymentRecipientList().add(recipient);
                          }
                           
                        }
                     
                  }
                      
                  }
                     // for recipients with class 1
                     
                  
                  
               
                  
//                  for(WorkRequest workRequest:regionalWorkQueue.getWorkRequestList())
//                  {
//                      if(workRequest.getStatus().equalsIgnoreCase(Payment.paymentStatus.DONATED.getValue()))
//                      {
//                          workRequest.setStatus(Payment.paymentStatus.TRANSFERRED.getValue());
//                          if(workRequest instanceof Payment)
//                          {
//                              Payment payment = (Payment)workRequest;
//                              payment.setTransferredDate(new Date());
//                          }
//                      }
//                  }
                  
                  
                  
                  
                  
                  
                  
                  // inEnterprise.clearWorkQueue(regionalWorkQueue);
//               Recipient recipient =null;
//               
//                for(LocalAgent localAgent:regionalLocalAgentQueue)
//                {
//                   for(WorkRequest workRequest:localAgent.getUserAccount().getWorkQueue().getWorkRequestList())
//                   {
//                       recipient = selectedLocalAgent.getAgentVillage().getRecipientList().peekFirst();
//                       if(workRequest instanceof Payment)
//                       {
//                        Payment recipientPayment = (Payment)workRequest; 
//                        recipientPayment.setLocalAgent(selectedLocalAgent);
//                        recipientPayment.setStatus(Payment.paymentStatus.TRANSFERRED.getValue());
//                        recipientPayment.setTransferredDate(new Date());
//                        recipient.getUserAccount().getWorkQueue().getWorkRequestList().add(recipientPayment);
//                        selectedLocalAgent.getAgentVillage().getRecipientList().addLast(recipient);
//                        selectedLocalAgent.getAgentVillage().getRecipientList().pollFirst();
//                       }
//                  
//               }
//                   
//                }
               
               
               //inEnterprise.clearWorkQueue(regionalWorkQueue);
               
//                                  
                                   
                                  // localAgent.getUserAccount().getWorkQueue().getWorkRequestList().add(paymentItem);
//                                  localAgent.getSavingsAccount().setAccountBalance(donationAmount);
//                                  paymentItem.setLocalAgent(localAgent);
//                                  
//                                  inEnterprise.clearWorkQueue(regionalWorkQueue);
//                                  paymentItem.setStatus(Payment.paymentStatus.TRANSFERRED.getValue());
                                
                                  
                         regionDividingFactor+=.2;
                         
                         
                   
               }
            
            inEnterprise.clearAllWorkRequestBalance();
            
            
            }
            
            
            JOptionPane.showMessageDialog(null,"Amount "+String.valueOf(currentDonationamount)+" is donated to Eradicate Poverty for region"+String.valueOf(regionComboBox.getSelectedItem()));
            clearAllFields();
            
            }
            
            else
            {
                
            }
        }
    }//GEN-LAST:event_giveNowJbuttonActionPerformed

    
    public ArrayList<Region> getRegion()
    {
        String countryName = String.valueOf(regionComboBox.getSelectedItem());
         Government government=null;
            Government inGovernment=null;
            DonationEnterprise inEnterprise=null;
            
            ArrayList <Region>regionList=null;
            ArrayList <Enterprise>enterpriseList;
        for(Network network:business.getRootNetwork().getSubNetworkDirectory().getNetworkList())
           {
               for(Enterprise enterprise:network.getEnterpriseDirectory().getEnterpriseList())
               {
                   if(enterprise instanceof Government)
                   {
                      government = (Government)enterprise;
                      if(government.getCountryName().equalsIgnoreCase(countryName))
                      {
                      inGovernment = government;
                      regionList = inGovernment.getRegionDirectory().getRegionList();
                       
                       
                       }
                       
                   }
               }
           }
    return regionList;
    }
    
    public LinkedList getRegionalLocalAgentList(DonationEnterprise enterprise,Region selectedRegion)
    {
        if(regionalLocalAgentQueue.isEmpty())
        {
        for(Enterprise e:enterprise.getAssociatedEnterprise())
                   {
                       if(e instanceof MobileEnterprise)
                       {
                           mobileEnterprise = (MobileEnterprise)e;
                           for(LocalAgent localAgent:mobileEnterprise.getLocalAgentDirectory().getLocalAgentList())
                           {
                               if(localAgent.getAgentRegion().equals(selectedRegion))
                               {
                                   regionalLocalAgentQueue.offer(localAgent);
                                   
                                   
                               }
                           }
                       }
                   }
        }
        
        
        return regionalLocalAgentQueue;
    }
    
    
    public int findTotalRecipients(DonationEnterprise enterprise,Region selectedRegion)
    {
        int  noOfRecipients=0;
        for(Enterprise e:enterprise.getAssociatedEnterprise())
                   {
                       if(e instanceof MobileEnterprise)
                       {
                           mobileEnterprise = (MobileEnterprise)e;
                           for(LocalAgent localAgent:mobileEnterprise.getLocalAgentDirectory().getLocalAgentList())
                           {
                              if(localAgent.getAgentVillage().getRecipientList().size()>0)
                               noOfRecipients+= localAgent.getAgentVillage().getRecipientList().size();
                           }
                       }
                   }
        
        
        return noOfRecipients;
    }
    private void otherDonationAmountJtextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_otherDonationAmountJtextFocusGained
        // TODO add your handling code here:
        
       
    }//GEN-LAST:event_otherDonationAmountJtextFocusGained

    private void otherDonationAmountJtextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_otherDonationAmountJtextFocusLost
        // TODO add your handling code here:
       
    }//GEN-LAST:event_otherDonationAmountJtextFocusLost

    private void cardNoJtextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cardNoJtextFocusGained
        // TODO add your handling code here:
        
        cardNoJtext.setText(String.valueOf(""));
        cardNoJtext.setForeground(Color.BLACK);
    }//GEN-LAST:event_cardNoJtextFocusGained

    private void cardNoJtextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cardNoJtextFocusLost
        // TODO add your handling code here:
        if(cardNoJtext.getText().trim().equals(String.valueOf("")))
        {
            cardNoJtext.setText("Enter 16 digit card no:");
            cardNoJtext.setForeground(Color.LIGHT_GRAY);
        }
        
    }//GEN-LAST:event_cardNoJtextFocusLost

    private void cardHolderNameJtextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cardHolderNameJtextFocusGained
        // TODO add your handling code here:
        
        cardHolderNameJtext.setText("");
        cardHolderNameJtext.setForeground(Color.BLACK);
    }//GEN-LAST:event_cardHolderNameJtextFocusGained

    private void cardHolderNameJtextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cardHolderNameJtextFocusLost
        // TODO add your handling code here:
        
        if(cardHolderNameJtext.getText().trim().equals(""))
        {
            cardHolderNameJtext.setText("Enter name printed on your card:");
            cardHolderNameJtext.setForeground(Color.LIGHT_GRAY);
        }
    }//GEN-LAST:event_cardHolderNameJtextFocusLost

    private void ccvJtextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ccvJtextFocusGained
        // TODO add your handling code here:
        
        ccvJtext.setForeground(Color.BLACK);
        ccvJtext.setText("");
    }//GEN-LAST:event_ccvJtextFocusGained

    private void paymentTypeRadiobuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentTypeRadiobuttonActionPerformed
        // TODO add your handling code here:
        
        cardDetailsJPanel.setVisible(true);
         paymentTypeRadiobutton2.setSelected(false);
        
    }//GEN-LAST:event_paymentTypeRadiobuttonActionPerformed

    private void cardNoJtextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cardNoJtextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cardNoJtextActionPerformed

    private void ccvJtextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ccvJtextFocusLost
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_ccvJtextFocusLost

    private void donorContactNoJtextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_donorContactNoJtextFocusGained
        // TODO add your handling code here:
        
        if(donorContactNoJtext.getText().equalsIgnoreCase("Contact no:"))
        {
            donorContactNoJtext.setText("");
            donorContactNoJtext.setForeground(Color.BLACK);
                    }
    }//GEN-LAST:event_donorContactNoJtextFocusGained

    private void donorContactNoJtextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_donorContactNoJtextFocusLost
        // TODO add your handling code here:
        
        if(donorContactNoJtext.getText().equalsIgnoreCase(""))
        {
            donorContactNoJtext.setText("Contact no:");
            donorContactNoJtext.setForeground(Color.BLACK);
                    }
        
    }//GEN-LAST:event_donorContactNoJtextFocusLost

    private void donorEmailAddressJtextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_donorEmailAddressJtextFocusGained
        // TODO add your handling code here:
        if(donorEmailAddressJtext.getText().equalsIgnoreCase("Your email id:"))
        {
            donorEmailAddressJtext.setText("");
            donorEmailAddressJtext.setForeground(Color.BLACK);
                    }
        
    }//GEN-LAST:event_donorEmailAddressJtextFocusGained

    private void donorEmailAddressJtextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_donorEmailAddressJtextFocusLost
        // TODO add your handling code here:
        
        if(donorEmailAddressJtext.getText().equals(""))
        {
            donorEmailAddressJtext.setText("Your email id:");
            donorEmailAddressJtext.setForeground(Color.LIGHT_GRAY);
                    }
    }//GEN-LAST:event_donorEmailAddressJtextFocusLost

    private void expiryMonthComboBoxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_expiryMonthComboBoxFocusGained
        // TODO add your handling code here:
       
        expiryMonthComboBox.removeItem("MM");
    }//GEN-LAST:event_expiryMonthComboBoxFocusGained

    private void expiryYearComboBoxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_expiryYearComboBoxFocusGained
        // TODO add your handling code here:
        expiryYearComboBox.removeItem("YYYY");
    }//GEN-LAST:event_expiryYearComboBoxFocusGained

    private void donorPasswordJtextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_donorPasswordJtextKeyPressed
        // TODO add your handling code here:
        
        passwordStrength.setText("Password Strength:");
        String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{5,10}";
       boolean flag = String.valueOf(donorPasswordJtext.getPassword()).trim().matches(pattern);
       if(flag)
       {
        passwordStrengthValueJlbl.setText("Good");
        passwordStrengthValueJlbl.setForeground(Color.green);
       }
       
       else
       {
       passwordStrengthValueJlbl.setText("Bad");
        passwordStrengthValueJlbl.setForeground(Color.red);    
       }
           
       
       
    }//GEN-LAST:event_donorPasswordJtextKeyPressed

    private void donorPasswordJtextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_donorPasswordJtextFocusLost
        // TODO add your handling code here:
        
    }//GEN-LAST:event_donorPasswordJtextFocusLost

    private void paymentTypeRadiobutton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentTypeRadiobutton2ActionPerformed
        // TODO add your handling code here:
        
        paymentTypeRadiobutton.setSelected(false);
        paymentTypeValidator.setText("2% extra processing charge on American express cards");
        paymentTypeValidator.setVisible(true);
        paymentTypeValidator.setForeground(Color.red);
        cardDetailsJPanel.setVisible(true);
    }//GEN-LAST:event_paymentTypeRadiobutton2ActionPerformed

    private void paymentTypeRadiobuttonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_paymentTypeRadiobuttonItemStateChanged
        // TODO add your handling code here:
        cardDetailsJPanel.setVisible(false);
    }//GEN-LAST:event_paymentTypeRadiobuttonItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        
        ChartPanel chart1;
        Government government=null;
        String countryName = String.valueOf(regionComboBox.getSelectedItem());
         try {
        
             DefaultCategoryDataset line_chart_dataset1 = new DefaultCategoryDataset();
             for(Network network:business.getAllNetwork())
             {
                 for(Enterprise enterprise:network.getEnterpriseDirectory().getEnterpriseList())
                 {
                     if(enterprise instanceof Government)
                     {
                         government = (Government)enterprise;
                     if(government.getCountryName().equalsIgnoreCase(countryName))
                     {
                         for(Region selectedRegion:government.getRegionDirectory().getRegionList())
                         {
                             for (Village village :selectedRegion.getVillageList())
                {
                  int percentBPL = village.getPercentPersonsBPL();
                  int personBPL = village.getVillageBPL();
                 
                  line_chart_dataset1.addValue(personBPL,"Percent BPL",village.getVillageName());
                  line_chart_dataset1.addValue(percentBPL,"Person BPL",village.getVillageName());
                  
                  
                  
                 JFreeChart lineChartObject1=ChartFactory.createBarChart("Village List","Statistics","VitalSign Count",line_chart_dataset1,PlotOrientation.VERTICAL,true,true,false);
                 chart1 = new ChartPanel (lineChartObject1);  
                
                                
                 
                 chart1.setLayout(new BorderLayout());
                 chart1.setMouseWheelEnabled(true);
                 chart1.setVisible(true);
                 chart1.setPreferredSize(new java.awt.Dimension(500, 270));
                 
                 JFrame jframe = new JFrame();
                 jframe.setPreferredSize(new java.awt.Dimension(800,800));
                 jframe.setMinimumSize(new java.awt.Dimension(800,800));
                // JInternalFrame iframe = new JInternalFrame();
                 //iframe.setPreferredSize(new Dimension(300,300));
                 jframe.add(chart1);
                 //jframe.getContentPane().add(iframe);
                 jframe.setVisible(true);
                 
                 
                 
                 
                 
                
                 
                 
                 
                
                }
                 
                 
                }  
                
                         }
                     }
                 }
             }
              
         }     
                
         
         catch (Exception i)
         {
             System.out.println(i);
         }
     
      
                                           

    }//GEN-LAST:event_jButton1ActionPerformed

    
    

    public static JInternalFrame createFrame()
    {
        
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(34.0, "Series 1", "Category 1");
        dataset.addValue(23.0, "Series 1", "Category 2");
        dataset.addValue(54.0, "Series 1", "Category 3");
        final JFreeChart chart = ChartFactory.createBarChart(
            "Bar Chart", 
            "Category",
            "Series",
            dataset,
            PlotOrientation.VERTICAL,
            true,
            true,
            false
        );
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(200, 100));
        final JInternalFrame frame1 = new JInternalFrame("Frame 1", true);
        frame1.getContentPane().add(chartPanel);

 
        return frame1;
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel amtValidatorJlbl4;
    private javax.swing.JLayeredPane cardDetailsJPanel;
    private javax.swing.JTextField cardHolderNameJtext;
    private javax.swing.JLabel cardHolderNameValidatorJlbl;
    private javax.swing.JTextField cardNoJtext;
    private javax.swing.JLabel cardNoValidatorJlbl;
    private javax.swing.JTextField ccvJtext;
    private javax.swing.JLabel ccvValidatorJlbl;
    private javax.swing.JLabel contactNoValidatorJlbl;
    private javax.swing.JComboBox donationAmountComboBox;
    private javax.swing.JTextField donorContactNoJtext;
    private javax.swing.JTextField donorEmailAddressJtext;
    private javax.swing.JPasswordField donorPasswordJtext;
    private javax.swing.JLabel emailIdValidatorJlbl;
    private javax.swing.JLabel expiryDateValidatorJlbl;
    private javax.swing.JComboBox expiryMonthComboBox;
    private javax.swing.JComboBox expiryYearComboBox;
    private javax.swing.JButton giveNowJbutton;
    private javax.swing.JLabel imgJlbl;
    private javax.swing.JLayeredPane imgPanel1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JComboBox mediaTypeComboBox;
    private javax.swing.JLabel mediaTypeValidatorJlbl;
    private javax.swing.JTextField otherDonationAmountJtext;
    private javax.swing.JLabel passwordStrength;
    private javax.swing.JLabel passwordStrengthValueJlbl;
    private javax.swing.JLabel passwordValidatorJlbl;
    private javax.swing.JRadioButton paymentTypeRadiobutton;
    private javax.swing.JRadioButton paymentTypeRadiobutton2;
    private javax.swing.JLabel paymentTypeValidator;
    private javax.swing.JComboBox regionComboBox;
    // End of variables declaration//GEN-END:variables
}

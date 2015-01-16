/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package userInterface.FieldStaff;

import Business.Ecosystem;
import Business.Enterprise.DonationEnterprise;
import Business.Enterprise.Enterprise;
import Business.GovernmentEnterprise.Government;
import Business.GovernmentEnterprise.Region;
import Business.GovernmentEnterprise.Village;
import Business.Network.Network;
import Business.Organization.EnrollmentOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.Utility.Validation;
import Business.WorkQueue.EnrollmentWorkRequest;
import Business.WorkQueue.WorkRequest;
import com.javaroots.latlong.AddressConverter;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author JJPL
 */
public class RegisterRecipientJPanel extends javax.swing.JPanel {

    /**
     * Creates new form RegisterRecipientJPanel
     */
    
    private JPanel userProcessContainer;
    private String path;
    private BufferedImage bufferedImg=null;
    private Ecosystem business;
    private UserAccount userAccount;
    private int cellPhoneNo;
    
    public RegisterRecipientJPanel(JPanel upc,Ecosystem business,UserAccount userAccount) {
        initComponents();
        this.userProcessContainer=upc;
        this.business = business;
        this.userAccount=userAccount;
        hideAllLabels();
        registerJbutton.setEnabled(false);
        populateCountryComboBox();
    }
    
    
    public void populateCountryComboBox()
    {
        
                    Government government=null;
            Government inGovernment=null;
            DonationEnterprise inEnterprise=null;
            
            
           
            
            ArrayList <Region>regionList;
            ArrayList <Enterprise>enterpriseList;
           for(Network network:business.getRootNetwork().getSubNetworkDirectory().getNetworkList())
           {
               for(Enterprise enterprise:network.getEnterpriseDirectory().getEnterpriseList())
               {
                   if(enterprise instanceof Government)
                   {
                       government = (Government)enterprise;
                       countryComboBox.addItem(government.getCountryName());
                       
                       
                       
                   }
               }
           }
        
        
        
    }
    
    public void hideAllLabels()
    {
       firstNameValidatorJlbl.setText("");
       lastNameValidatorJlbl.setText("");
       genderValidatorJlbl.setText("");
       maritalStatusValidatorJlbl.setText("");
       educationDegreeValidator.setText("");
       schoolNameValidatorJlbl.setText("");
       employmentTypeValidatorJlbl.setText("");
       employerNameValidatorJlbl.setText("");
      salaryValidatorJlbl.setText("");
      cellPhoneValidatorJlbl.setText("");
      noOfMembersValidatorJlbl.setText("");
      districtNameValidatorJlbl.setText("");
      
      MiddleNameValidatorJlbl.setText("");
      homeTypeValidatorJlbl.setText("");
      homeImageValidatorJlbl.setText("");
      conditionSelectionValidatorJlbl.setText("");
      dateValidatorJlbl.setText("");
      monthValidatorJlbl.setText("");
      yearValidatorJlbl.setText("");
      idNoValidatorJlbl.setText("");
      adultValueValidatorJlbl.setText("");
      childrenValueValidatorJlbl.setText("");
      streetNameValidatorJlbl.setText("");
      landMarkValidatorJlbl.setText("");
    }
    
    public boolean validateForm()
    {
        boolean errorFlag=false;
        
        hideAllLabels();
        if(!Validation.validateTextFieldsForNonEmpty(headFirstNameJtext)||headFirstNameJtext.getText().trim().equalsIgnoreCase("First name:"))
        {
            errorFlag=true;
            firstNameValidatorJlbl.setText("Please enter first name");
        }
        
        if(!Validation.validateTextFieldsForNonEmpty(headLastNameJtext)||headLastNameJtext.getText().trim().equalsIgnoreCase("Last name:"))
        {
            errorFlag=true;
            lastNameValidatorJlbl.setText("Please enter last name");
        }
        
        if(headGenderComboBox.getSelectedItem().equals("Please select gender"))
        {
            errorFlag=true;
            genderValidatorJlbl.setText("Please select gender");
        }
        
        if(maritalStatusComboBox.getSelectedItem().equals("Please select marital status"))
        {
            errorFlag=true;
            maritalStatusValidatorJlbl.setText("Please select marital status");
        }
        
        if(String.valueOf(birthMonthComboBox.getSelectedItem()).equalsIgnoreCase("MM"))
        {
            errorFlag=true;
            monthValidatorJlbl.setText("Please select month");
        }
        
        if(String.valueOf(birthDateComboBox.getSelectedItem()).equalsIgnoreCase("DD"))
        {
            errorFlag=true;
            dateValidatorJlbl.setText("Please select date");
        }
        
        
        if(String.valueOf(birthYearComboBox.getSelectedItem()).equalsIgnoreCase("YYYY"))
        {
            errorFlag=true;
            yearValidatorJlbl.setText("Please select year");
        }
        
        
        
        if(educationComboBox1.getSelectedItem().equals("Education Degree:"))
        {
            errorFlag=true;
            educationDegreeValidator.setText("Please select educated till");
        }
        
        if(!String.valueOf(educationComboBox1.getSelectedItem()).equalsIgnoreCase("NOT EDUCATED"))
        {
            if(headSchoolNameJtext.getText().trim().equalsIgnoreCase("School name:"))
            {
                errorFlag=true;
                schoolNameValidatorJlbl.setText("Please enter your school name");
                
            }
        }
        
        
        if(!String.valueOf(employmentStatusComboBox.getSelectedItem()).equalsIgnoreCase("No Employment")&& String.valueOf(employmentStatusComboBox.getSelectedItem()).equalsIgnoreCase("SERVICE"))
        {
            if(employerNameJtext.getText().trim().equalsIgnoreCase("Employer name:"))
            {
                errorFlag=true;
                employerNameValidatorJlbl.setText("Please enter your employer name");
                
            }
        }
        
        if(!employmentStatusComboBox.getSelectedItem().equals("Not employed")&& employmentStatusComboBox.getSelectedItem().equals("BUSINESS"))
        {
            if(employerNameJtext.getText().trim().equalsIgnoreCase("Employer name:"))
            {
                errorFlag=true;
                employerNameValidatorJlbl.setText("Please enter your business name");
                
            }
        }
        
        if(headSalary.getSelectedItem().equals("Average Daily income"))
        {
            errorFlag=true;
            salaryValidatorJlbl.setText("Please select salary range");
        }
        
        if(headFamilyCellPhoneJRadioButton.isSelected())
        {
            if(!Validation.validateTextFieldsForPhoneNumber(headcellPhoneNumberJtext))
            {
                errorFlag=true;
                cellPhoneValidatorJlbl.setText("Please enter cell Phone no");
            }
        }
        
        
        
        if(districtNameJtext.getText().trim().equalsIgnoreCase("District name:")||!Validation.validateTextFieldsForString(districtNameJtext))
        {
            errorFlag=true;
            districtNameValidatorJlbl.setText("Please enter valid district name");
        }
        
       
        if(homeTypeComboBox.getSelectedItem().equals("Mud thatch home?"))
        {
            errorFlag=true;
            homeTypeValidatorJlbl.setText("Please select home type");
        }
        
       if(path==null)
       {
           errorFlag=true;
           homeImageValidatorJlbl.setText("Please upload your home image");
       }
       
       if(!conditionSelectionCheckbox.isSelected())
       {
           errorFlag=true;
           conditionSelectionValidatorJlbl.setText("Please agree to terms and condition");
       }
       
       
       if((Integer)(noOfAdultJSpinner.getValue())<0||(Integer)noOfAdultJSpinner.getValue()>10)
       {
           errorFlag=true;
           adultValueValidatorJlbl.setText("Please enter valid value");
       }
       
       if((Integer)(noOfChildrenJSpinner.getValue())<0||(Integer)noOfChildrenJSpinner.getValue()>10)
       {
           errorFlag=true;
           childrenValueValidatorJlbl.setText("Please enter valid value");
       }
       
       if(!Validation.validateTextFieldForId(headIdJtext))
            {
                errorFlag=true;
                idNoValidatorJlbl.setText("Please enter valid id");
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

        jLabel1 = new javax.swing.JLabel();
        headCellPhoneNumber = new javax.swing.JLayeredPane();
        headFirstNameJtext = new javax.swing.JTextField();
        headMiddleNameJtext = new javax.swing.JTextField();
        headLastNameJtext = new javax.swing.JTextField();
        employmentStatusComboBox = new javax.swing.JComboBox();
        maritalStatusComboBox = new javax.swing.JComboBox();
        headSchoolDetailsJtext = new javax.swing.JTextField();
        headSchoolNameJtext = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        employerNameJtext = new javax.swing.JTextField();
        headSalary = new javax.swing.JComboBox();
        jRadioButton1 = new javax.swing.JRadioButton();
        headFamilyCellPhoneJRadioButton = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        employerDetailsJtext = new javax.swing.JTextField();
        headcellPhoneNumberJtext = new javax.swing.JTextField();
        maritalStatusValidatorJlbl = new javax.swing.JLabel();
        firstNameValidatorJlbl = new javax.swing.JLabel();
        MiddleNameValidatorJlbl = new javax.swing.JLabel();
        lastNameValidatorJlbl = new javax.swing.JLabel();
        genderValidatorJlbl = new javax.swing.JLabel();
        headGenderComboBox = new javax.swing.JComboBox();
        schoolNameValidatorJlbl = new javax.swing.JLabel();
        educationComboBox1 = new javax.swing.JComboBox();
        educationDegreeValidator = new javax.swing.JLabel();
        employmentTypeValidatorJlbl = new javax.swing.JLabel();
        employerNameValidatorJlbl = new javax.swing.JLabel();
        salaryValidatorJlbl = new javax.swing.JLabel();
        cellPhoneValidatorJlbl = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        birthMonthComboBox = new javax.swing.JComboBox();
        birthDateComboBox = new javax.swing.JComboBox();
        birthYearComboBox = new javax.swing.JComboBox();
        idComboBox = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        headIdJtext = new javax.swing.JTextField();
        monthValidatorJlbl = new javax.swing.JLabel();
        dateValidatorJlbl = new javax.swing.JLabel();
        yearValidatorJlbl = new javax.swing.JLabel();
        idNoValidatorJlbl = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        employmentStatusComboBox1 = new javax.swing.JComboBox();
        locationDetailsJPanel = new javax.swing.JLayeredPane();
        jLabel10 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        homeTypeComboBox = new javax.swing.JComboBox();
        browseImageJbutton = new javax.swing.JButton();
        certificateImage = new javax.swing.JLabel();
        homeTypeValidatorJlbl = new javax.swing.JLabel();
        homeImageValidatorJlbl = new javax.swing.JLabel();
        districtNameJtext = new javax.swing.JTextField();
        nearByLocationJtext = new javax.swing.JTextField();
        streetNameValidatorJlbl = new javax.swing.JLabel();
        landMarkValidatorJlbl = new javax.swing.JLabel();
        countryComboBox = new javax.swing.JComboBox();
        villageComboBox = new javax.swing.JComboBox();
        stateComboBox = new javax.swing.JComboBox();
        streetNameJtext = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        districtNameValidatorJlbl = new javax.swing.JLabel();
        registerJbutton = new javax.swing.JButton();
        conditionSelectionCheckbox = new javax.swing.JCheckBox();
        conditionSelectionValidatorJlbl = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        noOfAdultJSpinner = new javax.swing.JSpinner();
        jLabel16 = new javax.swing.JLabel();
        noOfChildrenJSpinner = new javax.swing.JSpinner();
        spouseNameJtext = new javax.swing.JTextField();
        noOfMembersValidatorJlbl = new javax.swing.JLabel();
        childrenValueValidatorJlbl = new javax.swing.JLabel();
        adultValueValidatorJlbl = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("RECIPIENT REGISTRATION FORM");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, -1, 23));

        headCellPhoneNumber.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        headFirstNameJtext.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        headFirstNameJtext.setForeground(new java.awt.Color(204, 204, 204));
        headFirstNameJtext.setText("First name:");
        headFirstNameJtext.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                headFirstNameJtextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                headFirstNameJtextFocusLost(evt);
            }
        });
        headCellPhoneNumber.add(headFirstNameJtext, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 121, 34));

        headMiddleNameJtext.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        headMiddleNameJtext.setForeground(new java.awt.Color(204, 204, 204));
        headMiddleNameJtext.setText("Middle name:");
        headMiddleNameJtext.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                headMiddleNameJtextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                headMiddleNameJtextFocusLost(evt);
            }
        });
        headCellPhoneNumber.add(headMiddleNameJtext, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 150, 34));

        headLastNameJtext.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        headLastNameJtext.setForeground(new java.awt.Color(204, 204, 204));
        headLastNameJtext.setText("Last name:");
        headLastNameJtext.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                headLastNameJtextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                headLastNameJtextFocusLost(evt);
            }
        });
        headCellPhoneNumber.add(headLastNameJtext, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, 170, 34));

        employmentStatusComboBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        employmentStatusComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Employment type", "SERVICE", "BUSINESS", "CONTRACTUAL", "NO EMPLOYMENT" }));
        employmentStatusComboBox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                employmentStatusComboBoxFocusGained(evt);
            }
        });
        headCellPhoneNumber.add(employmentStatusComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, -1, 34));

        maritalStatusComboBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        maritalStatusComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Please select marital status", "SINGLE", "MARRIED", "DIVORCED", "WIDOWED", " " }));
        maritalStatusComboBox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                maritalStatusComboBoxFocusGained(evt);
            }
        });
        headCellPhoneNumber.add(maritalStatusComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, 190, 34));

        headSchoolDetailsJtext.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        headSchoolDetailsJtext.setForeground(new java.awt.Color(204, 204, 204));
        headSchoolDetailsJtext.setText("SCHOOL CITY,COUNTRY(IF NOT SAME VILLAGE)"); // NOI18N
        headSchoolDetailsJtext.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                headSchoolDetailsJtextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                headSchoolDetailsJtextFocusLost(evt);
            }
        });
        headSchoolDetailsJtext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                headSchoolDetailsJtextActionPerformed(evt);
            }
        });
        headCellPhoneNumber.add(headSchoolDetailsJtext, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 290, 280, 40));

        headSchoolNameJtext.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        headSchoolNameJtext.setForeground(new java.awt.Color(204, 204, 204));
        headSchoolNameJtext.setText("SCHOOL NAME:");
        headSchoolNameJtext.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                headSchoolNameJtextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                headSchoolNameJtextFocusLost(evt);
            }
        });
        headCellPhoneNumber.add(headSchoolNameJtext, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 139, 38));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("If yes,then please enter your cell phone number:");
        headCellPhoneNumber.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, 280, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Personal Details");
        headCellPhoneNumber.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 110, 20));

        employerNameJtext.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        employerNameJtext.setForeground(new java.awt.Color(204, 204, 204));
        employerNameJtext.setText("Employer Name:");
        employerNameJtext.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                employerNameJtextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                employerNameJtextFocusLost(evt);
            }
        });
        headCellPhoneNumber.add(employerNameJtext, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 350, 240, 40));

        headSalary.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        headSalary.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Average Daily Income", "Below 10$", "10$-30$", "30$-50$", "50$-100$", "Above 100$" }));
        headSalary.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                headSalaryFocusGained(evt);
            }
        });
        headCellPhoneNumber.add(headSalary, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 160, 30));

        jRadioButton1.setText("No");
        headCellPhoneNumber.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 420, -1, -1));

        headFamilyCellPhoneJRadioButton.setSelected(true);
        headFamilyCellPhoneJRadioButton.setText("YES");
        headCellPhoneNumber.add(headFamilyCellPhoneJRadioButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 420, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Id no:");
        headCellPhoneNumber.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 240, 40, 20));

        employerDetailsJtext.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        employerDetailsJtext.setForeground(new java.awt.Color(204, 204, 204));
        employerDetailsJtext.setText("Employer City/Village/Town:");
        employerDetailsJtext.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                employerDetailsJtextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                employerDetailsJtextFocusLost(evt);
            }
        });
        employerDetailsJtext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employerDetailsJtextActionPerformed(evt);
            }
        });
        headCellPhoneNumber.add(employerDetailsJtext, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 350, 170, 40));

        headcellPhoneNumberJtext.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        headcellPhoneNumberJtext.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                headcellPhoneNumberJtextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                headcellPhoneNumberJtextFocusLost(evt);
            }
        });
        headcellPhoneNumberJtext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                headcellPhoneNumberJtextActionPerformed(evt);
            }
        });
        headCellPhoneNumber.add(headcellPhoneNumberJtext, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 470, 170, 40));

        maritalStatusValidatorJlbl.setForeground(new java.awt.Color(255, 0, 0));
        maritalStatusValidatorJlbl.setText("jLabel11");
        headCellPhoneNumber.add(maritalStatusValidatorJlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 150, -1, 20));

        firstNameValidatorJlbl.setForeground(new java.awt.Color(255, 0, 0));
        firstNameValidatorJlbl.setText("jLabel11");
        headCellPhoneNumber.add(firstNameValidatorJlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        MiddleNameValidatorJlbl.setForeground(new java.awt.Color(255, 0, 0));
        MiddleNameValidatorJlbl.setText("jLabel11");
        headCellPhoneNumber.add(MiddleNameValidatorJlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, -1, -1));

        lastNameValidatorJlbl.setForeground(new java.awt.Color(255, 0, 0));
        lastNameValidatorJlbl.setText("jLabel11");
        headCellPhoneNumber.add(lastNameValidatorJlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, -1, -1));

        genderValidatorJlbl.setForeground(new java.awt.Color(255, 0, 0));
        genderValidatorJlbl.setText("jLabel11");
        headCellPhoneNumber.add(genderValidatorJlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        headGenderComboBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        headGenderComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Please select gender", "MALE", "FEMALE" }));
        headGenderComboBox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                headGenderComboBoxFocusGained(evt);
            }
        });
        headCellPhoneNumber.add(headGenderComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 140, 34));

        schoolNameValidatorJlbl.setForeground(new java.awt.Color(255, 0, 0));
        schoolNameValidatorJlbl.setText("jLabel11");
        headCellPhoneNumber.add(schoolNameValidatorJlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 330, -1, -1));

        educationComboBox1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        educationComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Education Degree", "SSC", "HSC", "GRADUATE", "UNDERGRADUATE", "NOT EDUCATED" }));
        educationComboBox1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                educationComboBox1FocusGained(evt);
            }
        });
        headCellPhoneNumber.add(educationComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, 34));

        educationDegreeValidator.setForeground(new java.awt.Color(255, 0, 0));
        educationDegreeValidator.setText("jLabel11");
        headCellPhoneNumber.add(educationDegreeValidator, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, -1, -1));

        employmentTypeValidatorJlbl.setForeground(new java.awt.Color(255, 0, 0));
        employmentTypeValidatorJlbl.setText("jLabel12");
        headCellPhoneNumber.add(employmentTypeValidatorJlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, -1, -1));

        employerNameValidatorJlbl.setForeground(new java.awt.Color(255, 0, 0));
        employerNameValidatorJlbl.setText("jLabel13");
        headCellPhoneNumber.add(employerNameValidatorJlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 400, -1, -1));

        salaryValidatorJlbl.setForeground(new java.awt.Color(255, 0, 0));
        salaryValidatorJlbl.setText("jLabel14");
        headCellPhoneNumber.add(salaryValidatorJlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, -1, -1));

        cellPhoneValidatorJlbl.setForeground(new java.awt.Color(255, 0, 51));
        cellPhoneValidatorJlbl.setText("jLabel15");
        headCellPhoneNumber.add(cellPhoneValidatorJlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 470, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Unique Id:");
        headCellPhoneNumber.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, -1));

        birthMonthComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MM", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", " " }));
        headCellPhoneNumber.add(birthMonthComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 70, -1));

        birthDateComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "DD", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        headCellPhoneNumber.add(birthDateComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 50, -1));

        birthYearComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "YYYY", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", " " }));
        headCellPhoneNumber.add(birthYearComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 180, 90, -1));

        idComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Passport", "Driving License", "State Id" }));
        headCellPhoneNumber.add(idComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, 160, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Date of Birth:");
        headCellPhoneNumber.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        headIdJtext.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        headIdJtext.setForeground(new java.awt.Color(204, 204, 204));
        headIdJtext.setText("Id no:");
        headIdJtext.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                headIdJtextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                headIdJtextFocusLost(evt);
            }
        });
        headCellPhoneNumber.add(headIdJtext, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 230, 170, 34));

        monthValidatorJlbl.setForeground(new java.awt.Color(255, 51, 51));
        monthValidatorJlbl.setText("jLabel15");
        headCellPhoneNumber.add(monthValidatorJlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 170, -1));

        dateValidatorJlbl.setForeground(new java.awt.Color(255, 0, 0));
        dateValidatorJlbl.setText("jLabel15");
        headCellPhoneNumber.add(dateValidatorJlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, 160, -1));

        yearValidatorJlbl.setForeground(new java.awt.Color(255, 0, 0));
        yearValidatorJlbl.setText("jLabel15");
        headCellPhoneNumber.add(yearValidatorJlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 210, 200, -1));

        idNoValidatorJlbl.setForeground(new java.awt.Color(255, 0, 0));
        idNoValidatorJlbl.setText("jLabel15");
        headCellPhoneNumber.add(idNoValidatorJlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 270, 130, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setText("Do you have cell phone?");
        headCellPhoneNumber.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 420, 140, 20));

        employmentStatusComboBox1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        employmentStatusComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Employment type", "SERVICE", "BUSINESS", "CONTRACTUAL", "NO EMPLOYMENT" }));
        employmentStatusComboBox1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                employmentStatusComboBox1FocusGained(evt);
            }
        });
        headCellPhoneNumber.add(employmentStatusComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, -1, 34));

        add(headCellPhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 620, 510));

        locationDetailsJPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        locationDetailsJPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Location Details");
        locationDetailsJPanel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 2, -1, 23));
        locationDetailsJPanel.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 27, 432, -1));

        homeTypeComboBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        homeTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mud thatch home?", "Yes", "No" }));
        homeTypeComboBox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                homeTypeComboBoxFocusGained(evt);
            }
        });
        locationDetailsJPanel.add(homeTypeComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 62, 170, 34));

        browseImageJbutton.setText("Upload Home Image");
        browseImageJbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseImageJbuttonActionPerformed(evt);
            }
        });
        locationDetailsJPanel.add(browseImageJbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 390, -1, 32));

        certificateImage.setForeground(new java.awt.Color(204, 204, 204));
        certificateImage.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 204), null));
        locationDetailsJPanel.add(certificateImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 261, 109));

        homeTypeValidatorJlbl.setForeground(new java.awt.Color(255, 51, 0));
        homeTypeValidatorJlbl.setText("jLabel11");
        locationDetailsJPanel.add(homeTypeValidatorJlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 107, -1, -1));

        homeImageValidatorJlbl.setForeground(new java.awt.Color(255, 0, 0));
        homeImageValidatorJlbl.setText("jLabel14");
        locationDetailsJPanel.add(homeImageValidatorJlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 430, -1, -1));

        districtNameJtext.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        districtNameJtext.setForeground(new java.awt.Color(204, 204, 204));
        districtNameJtext.setText("District name:");
        districtNameJtext.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                districtNameJtextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                districtNameJtextFocusLost(evt);
            }
        });
        districtNameJtext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                districtNameJtextActionPerformed(evt);
            }
        });
        locationDetailsJPanel.add(districtNameJtext, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, 180, 30));

        nearByLocationJtext.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        nearByLocationJtext.setForeground(new java.awt.Color(204, 204, 204));
        nearByLocationJtext.setText("Near by landmark:");
        nearByLocationJtext.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nearByLocationJtextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                nearByLocationJtextFocusLost(evt);
            }
        });
        nearByLocationJtext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nearByLocationJtextActionPerformed(evt);
            }
        });
        locationDetailsJPanel.add(nearByLocationJtext, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 310, 170, 30));

        streetNameValidatorJlbl.setForeground(new java.awt.Color(255, 51, 0));
        streetNameValidatorJlbl.setText("jLabel11");
        locationDetailsJPanel.add(streetNameValidatorJlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 184, -1));

        landMarkValidatorJlbl.setForeground(new java.awt.Color(255, 51, 0));
        landMarkValidatorJlbl.setText("jLabel11");
        locationDetailsJPanel.add(landMarkValidatorJlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 360, 184, -1));

        countryComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                countryComboBoxActionPerformed(evt);
            }
        });
        locationDetailsJPanel.add(countryComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 160, 30));

        locationDetailsJPanel.add(villageComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 160, 30));

        stateComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stateComboBoxActionPerformed(evt);
            }
        });
        locationDetailsJPanel.add(stateComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 180, 30));

        streetNameJtext.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        streetNameJtext.setForeground(new java.awt.Color(204, 204, 204));
        streetNameJtext.setText("Street name:");
        streetNameJtext.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                streetNameJtextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                streetNameJtextFocusLost(evt);
            }
        });
        streetNameJtext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                streetNameJtextActionPerformed(evt);
            }
        });
        locationDetailsJPanel.add(streetNameJtext, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 170, 30));

        jLabel12.setText("Select state:");
        locationDetailsJPanel.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, -1, -1));

        jLabel13.setText("Select village:");
        locationDetailsJPanel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        jLabel14.setText("Select country:");
        locationDetailsJPanel.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        districtNameValidatorJlbl.setForeground(new java.awt.Color(255, 51, 51));
        districtNameValidatorJlbl.setText("jLabel2");
        locationDetailsJPanel.add(districtNameValidatorJlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 270, 200, -1));

        add(locationDetailsJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 60, 420, 510));

        registerJbutton.setText("REGISTER>>>");
        registerJbutton.setEnabled(false);
        registerJbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerJbuttonActionPerformed(evt);
            }
        });
        add(registerJbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 590, 150, 40));

        conditionSelectionCheckbox.setText("I agree to Terms and Conditions of Eradicate Poverty Organization");
        conditionSelectionCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conditionSelectionCheckboxActionPerformed(evt);
            }
        });
        add(conditionSelectionCheckbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 650, -1, -1));

        conditionSelectionValidatorJlbl.setForeground(new java.awt.Color(255, 0, 0));
        conditionSelectionValidatorJlbl.setText("jLabel14");
        add(conditionSelectionValidatorJlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 680, -1, -1));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 580, 470, 10));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Family Details:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 590, 110, 20));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("No. of Adults:");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 630, 80, 20));
        add(noOfAdultJSpinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 630, -1, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel16.setText("No. of Children:");
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 630, 90, 20));
        add(noOfChildrenJSpinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 630, -1, -1));

        spouseNameJtext.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        spouseNameJtext.setForeground(new java.awt.Color(204, 204, 204));
        spouseNameJtext.setText("Name of spouse:");
        spouseNameJtext.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                spouseNameJtextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                spouseNameJtextFocusLost(evt);
            }
        });
        spouseNameJtext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spouseNameJtextActionPerformed(evt);
            }
        });
        add(spouseNameJtext, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 680, 133, 35));

        noOfMembersValidatorJlbl.setForeground(new java.awt.Color(255, 0, 51));
        noOfMembersValidatorJlbl.setText("jLabel16");
        add(noOfMembersValidatorJlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 720, -1, -1));

        childrenValueValidatorJlbl.setForeground(new java.awt.Color(255, 0, 51));
        childrenValueValidatorJlbl.setText("jLabel2");
        add(childrenValueValidatorJlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 660, 240, -1));

        adultValueValidatorJlbl.setForeground(new java.awt.Color(255, 0, 0));
        adultValueValidatorJlbl.setText("jLabel2");
        add(adultValueValidatorJlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 660, 180, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void spouseNameJtextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spouseNameJtextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_spouseNameJtextActionPerformed

    private void browseImageJbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseImageJbuttonActionPerformed
        // TODO add your handling code here:

        JFileChooser jFileChooser=new JFileChooser();
        jFileChooser.showOpenDialog(null);
        try
        {
            bufferedImg = ImageIO.read(jFileChooser.getSelectedFile());
            File file=jFileChooser.getSelectedFile();
            path=file.getPath();
            ImageIcon imgIco=new ImageIcon(bufferedImg);
            certificateImage.setIcon(new ImageIcon(imgIco.getImage().getScaledInstance(212, 122, java.awt.Image.SCALE_FAST)));

        } catch (IOException ex)
        {
            JOptionPane.showMessageDialog(null, "Please select a valid file", "INVALID", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_browseImageJbuttonActionPerformed

    private void conditionSelectionCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conditionSelectionCheckboxActionPerformed
        // TODO add your handling code here:
        
      if(conditionSelectionCheckbox.isSelected())
      {
          registerJbutton.setEnabled(true);
      }
        
        
        
    }//GEN-LAST:event_conditionSelectionCheckboxActionPerformed

    private void spouseNameJtextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_spouseNameJtextFocusGained
        // TODO add your handling code here:
        
        spouseNameJtext.setText("");
        spouseNameJtext.setForeground(Color.black);
        
    }//GEN-LAST:event_spouseNameJtextFocusGained

    private void spouseNameJtextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_spouseNameJtextFocusLost
        // TODO add your handling code here:
        
        if(spouseNameJtext.getText().equals(""))
        {
           spouseNameJtext.setText("Name of spouse:");
        spouseNameJtext.setForeground(Color.LIGHT_GRAY); 
        }
        
    }//GEN-LAST:event_spouseNameJtextFocusLost

    private void homeTypeComboBoxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_homeTypeComboBoxFocusGained
        // TODO add your handling code here:
        
        homeTypeComboBox.removeItem("Mud thatch home?");
    }//GEN-LAST:event_homeTypeComboBoxFocusGained

    private void registerJbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerJbuttonActionPerformed
        // TODO add your handling code here:
        boolean phonePresent=false;
        boolean errorFlag=false;
        hideAllLabels();
        if(!validateForm())
        {
           if(business.checkIfUserNameIsPresent(headcellPhoneNumberJtext.getText().trim()))
           {
               errorFlag=true;
               JOptionPane.showMessageDialog(null,"Sorry, we already have recipient account with this number.Please try with other number","Duplicate entry",JOptionPane.ERROR_MESSAGE);
               }
            
           
           else if((checkUserNamePresentInWorkRequest(headcellPhoneNumberJtext.getText().trim())))
            {
                errorFlag=true;
JOptionPane.showMessageDialog(null,"Your request is under evaluation.\n Login credentials will be communicated once request is approved.\n Please send message INQUIRE to 800800800 to get latest status.");
            }
           
           if(!errorFlag)
           {
               
            Village villageSelected = (Village)villageComboBox.getSelectedItem();
             Region regionSelected = (Region)stateComboBox.getSelectedItem();
             int noOfAdultsValue = (Integer)noOfAdultJSpinner.getValue();
             int noOfChildrenValue = (Integer)noOfChildrenJSpinner.getValue();
             int totalFamilyMembers = noOfAdultsValue+noOfChildrenValue;
            EnrollmentWorkRequest enrollmentRequest = new EnrollmentWorkRequest();
            enrollmentRequest.setHeadFirstName(headFirstNameJtext.getText().trim());
            enrollmentRequest.setHeadLastName(headLastNameJtext.getText().trim());
            if(!headMiddleNameJtext.getText().equalsIgnoreCase("Middle name:"))
            enrollmentRequest.setHeadMiddleName(headMiddleNameJtext.getText().trim());
            else
            enrollmentRequest.setHeadMiddleName("");    
            enrollmentRequest.setHeadGender(String.valueOf(headGenderComboBox.getSelectedItem()));
            enrollmentRequest.setHeadMaritalStatus(String.valueOf(maritalStatusComboBox.getSelectedItem()));
            enrollmentRequest.setEducationStatus(String.valueOf(educationComboBox1.getSelectedItem()));
            enrollmentRequest.setSchoolName(headSchoolNameJtext.getText().trim());
            enrollmentRequest.setSchoolDetails(headSchoolDetailsJtext.getText().trim());
            enrollmentRequest.setEmploymentStatus(String.valueOf(employmentStatusComboBox.getSelectedItem()));
            enrollmentRequest.setEmployerName(employerNameJtext.getText().trim());
            enrollmentRequest.setEmployerDetails(employerDetailsJtext.getText().trim());
            enrollmentRequest.setDailyIncome(String.valueOf(headSalary.getSelectedItem()));
            enrollmentRequest.setCellPhoneNo(headcellPhoneNumberJtext.getText().trim());
            enrollmentRequest.setNoOfAdults(String.valueOf(noOfAdultsValue));
            enrollmentRequest.setNoOfChildren(String.valueOf(noOfChildrenValue));
            enrollmentRequest.setNoOfMembers(String.valueOf(totalFamilyMembers));
            if(headFamilyCellPhoneJRadioButton.isSelected())
            {
             phonePresent=true; 
            }
                
            enrollmentRequest.setPhonePresent(phonePresent);
            
             
            enrollmentRequest.setCellPhoneNo(headcellPhoneNumberJtext.getText());
            
            
            
            
            
            enrollmentRequest.setSpouseName(spouseNameJtext.getText().trim());
            enrollmentRequest.setMudHome(String.valueOf(homeTypeComboBox.getSelectedItem()));
            enrollmentRequest.setDistrictName(districtNameJtext.getText().trim());
            enrollmentRequest.setVillageName((Village)villageComboBox.getSelectedItem());
            enrollmentRequest.setHomeImagePath(path);
            enrollmentRequest.setStreetName(districtNameJtext.getText());
            enrollmentRequest.setNearByLandMark(nearByLocationJtext.getText().trim());
            enrollmentRequest.setBirthDate(null);
            Calendar c = new GregorianCalendar();
         c.set(Integer.parseInt(String.valueOf(birthYearComboBox.getSelectedItem())),
                 Integer.parseInt(String.valueOf(birthMonthComboBox.getSelectedItem())),
                 Integer.parseInt(String.valueOf(birthDateComboBox.getSelectedItem())));
         
           enrollmentRequest.setBirthDate(new Date(c.getTimeInMillis()));
           enrollmentRequest.setIdType(String.valueOf(idComboBox.getSelectedItem()));
           enrollmentRequest.setIdNo(headIdJtext.getText().trim());
           
            enrollmentRequest.setUserIdFieldStaff(userAccount);
            
            
            enrollmentRequest.setFieldStaffId(enrollmentRequest.getUserIdFieldStaff().getPerson().getId());
            if(userAccount.equals(null))
                enrollmentRequest.setFieldStaffId(000);
            try
            {AddressConverter.getGeographicDetails(enrollmentRequest,villageSelected.getVillageName(),regionSelected.getRegionName());}
            catch(Exception e){}
            
            System.out.println(enrollmentRequest.getLocation().getLattitude());
            System.out.println(enrollmentRequest.getLocation().getLongitude());
            Government government=null;
            Government inGovernment=null;
            DonationEnterprise inEnterprise=null;
            
            
           
            
            ArrayList <Region>regionList;
            ArrayList <Enterprise>enterpriseList;
           for(Network network:business.getRootNetwork().getSubNetworkDirectory().getNetworkList())
           {
               for(Enterprise enterprise:network.getEnterpriseDirectory().getEnterpriseList())
               {
                   if(enterprise instanceof Government)
                   {
                       government = (Government)enterprise;
                       regionList = government.getRegionDirectory().getRegionList();
                       
                       for(Region region:regionList)
                       {
                         if(region.getRegionName().equalsIgnoreCase(regionSelected.getRegionName()))
                         {
                           for(Village village:region.getVillageList())
                           {
                           if(village.getVillageName().equalsIgnoreCase(villageSelected.getVillageName()))
                           {
                               inGovernment = government;
                               System.out.println(""+inGovernment);
                              
                               
                           }
                           
                           }
                           
                           }
                       }
                       
                   }
               }
           }
           
           
           DonationEnterprise donationEnterprise=null;
           for(Network network:business.getRootNetwork().getSubNetworkDirectory().getNetworkList()) 
           {
               for(Enterprise enterprise:network.getEnterpriseDirectory().getEnterpriseList())
               {
                   if(enterprise instanceof DonationEnterprise)
                   {
                       donationEnterprise = (DonationEnterprise)enterprise;
                       enterpriseList = donationEnterprise.getAssociatedEnterprise();
                       
                       for (Enterprise e:enterpriseList)
                       {
                           System.out.println("Enterprise"+e);
                           if(inGovernment.equals(e))
                           {
                               inEnterprise = donationEnterprise;
                               break;
                           }
                       }
                   }
                   
               }
           }
           
           
           
           
            for(Organization organization:inEnterprise.getOrganizationDirectory().getOrganizationList())
            {
                if(organization instanceof EnrollmentOrganization)
                {
                    organization.getWorkQueue().getWorkRequestList().add(enrollmentRequest);
                    System.out.println("+Request input"+organization);
                }
            }
            
            enrollmentRequest.setStatus("Requested");
            JOptionPane.showMessageDialog(null,"Your request is submitted successfully. \n You will be notified in 2-3 working days if enrollment request is approved.","Successful submission",JOptionPane.INFORMATION_MESSAGE);
            return;
            
        }
            
            
        }
            
            
            
       
        
    }//GEN-LAST:event_registerJbuttonActionPerformed

    private void nearByLocationJtextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nearByLocationJtextFocusGained
        // TODO add your handling code here:
        
        nearByLocationJtext.setText("");
        nearByLocationJtext.setForeground(Color.BLACK);
    }//GEN-LAST:event_nearByLocationJtextFocusGained

    private void nearByLocationJtextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nearByLocationJtextFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_nearByLocationJtextFocusLost

    private void nearByLocationJtextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nearByLocationJtextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nearByLocationJtextActionPerformed

    private void districtNameJtextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_districtNameJtextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_districtNameJtextActionPerformed

    private void districtNameJtextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_districtNameJtextFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_districtNameJtextFocusLost

    private void districtNameJtextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_districtNameJtextFocusGained
        // TODO add your handling code here:
        
        districtNameJtext.setText("");
        districtNameJtext.setForeground(Color.BLACK);
    }//GEN-LAST:event_districtNameJtextFocusGained

    private void streetNameJtextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_streetNameJtextFocusGained
        // TODO add your handling code here:
        
        streetNameJtext.setText("");
        streetNameJtext.setForeground(Color.BLACK);
    }//GEN-LAST:event_streetNameJtextFocusGained

    private void streetNameJtextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_streetNameJtextFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_streetNameJtextFocusLost

    private void streetNameJtextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_streetNameJtextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_streetNameJtextActionPerformed

    private void headIdJtextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_headIdJtextFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_headIdJtextFocusLost

    private void headIdJtextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_headIdJtextFocusGained
        // TODO add your handling code here:

        headIdJtext.setText("");
        headIdJtext.setForeground(Color.BLACK);
    }//GEN-LAST:event_headIdJtextFocusGained

    private void educationComboBox1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_educationComboBox1FocusGained
        // TODO add your handling code here:

        educationComboBox1.removeItem("Education Degree:");
    }//GEN-LAST:event_educationComboBox1FocusGained

    private void headGenderComboBoxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_headGenderComboBoxFocusGained
        // TODO add your handling code here:
        headGenderComboBox.removeItem("Please select gender");
    }//GEN-LAST:event_headGenderComboBoxFocusGained

    private void headcellPhoneNumberJtextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_headcellPhoneNumberJtextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_headcellPhoneNumberJtextActionPerformed

    private void headcellPhoneNumberJtextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_headcellPhoneNumberJtextFocusLost
        // TODO add your handling code here:

    }//GEN-LAST:event_headcellPhoneNumberJtextFocusLost

    private void headcellPhoneNumberJtextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_headcellPhoneNumberJtextFocusGained
        // TODO add your handling code here:

    }//GEN-LAST:event_headcellPhoneNumberJtextFocusGained

    private void employerDetailsJtextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employerDetailsJtextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_employerDetailsJtextActionPerformed

    private void employerDetailsJtextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_employerDetailsJtextFocusLost
        // TODO add your handling code here:

        if(employerDetailsJtext.getText().equals(""))
        {
            employerDetailsJtext.setText("EMPLOYER CITY/VILLAGE/TOWN");
            employerDetailsJtext.setForeground(Color.LIGHT_GRAY);
        }

    }//GEN-LAST:event_employerDetailsJtextFocusLost

    private void employerDetailsJtextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_employerDetailsJtextFocusGained
        // TODO add your handling code here:

        employerDetailsJtext.setText("");
        employerDetailsJtext.setForeground(Color.black);

    }//GEN-LAST:event_employerDetailsJtextFocusGained

    private void headSalaryFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_headSalaryFocusGained
        // TODO add your handling code here:
        headSalary.removeItem("Annual Salary:");
    }//GEN-LAST:event_headSalaryFocusGained

    private void employerNameJtextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_employerNameJtextFocusLost
        // TODO add your handling code here:

        if(employerNameJtext.getText().equals(""))
        {
            employerNameJtext.setText("EMPLOYER NAME");
            employerNameJtext.setForeground(Color.LIGHT_GRAY);
        }
    }//GEN-LAST:event_employerNameJtextFocusLost

    private void employerNameJtextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_employerNameJtextFocusGained
        // TODO add your handling code here:

        employerNameJtext.setText("");
        employerNameJtext.setForeground(Color.black);

    }//GEN-LAST:event_employerNameJtextFocusGained

    private void headSchoolNameJtextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_headSchoolNameJtextFocusLost
        // TODO add your handling code here:

        if(headSchoolNameJtext.getText().equals(""))
        {
            headSchoolNameJtext.setText("School name:");
            headSchoolNameJtext.setForeground(Color.LIGHT_GRAY);
        }
    }//GEN-LAST:event_headSchoolNameJtextFocusLost

    private void headSchoolNameJtextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_headSchoolNameJtextFocusGained
        // TODO add your handling code here:

        headSchoolNameJtext.setText("");
        headSchoolNameJtext.setForeground(Color.black);

    }//GEN-LAST:event_headSchoolNameJtextFocusGained

    private void headSchoolDetailsJtextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_headSchoolDetailsJtextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_headSchoolDetailsJtextActionPerformed

    private void headSchoolDetailsJtextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_headSchoolDetailsJtextFocusLost
        // TODO add your handling code here:
        if(headSchoolDetailsJtext.getText().equals(""))
        {
            headSchoolDetailsJtext.setText("SCHOOL CITY/VILLAGE (IF NOT SAME VILLAGE)");
            headSchoolDetailsJtext.setForeground(Color.LIGHT_GRAY);
        }

    }//GEN-LAST:event_headSchoolDetailsJtextFocusLost

    private void headSchoolDetailsJtextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_headSchoolDetailsJtextFocusGained
        // TODO add your handling code here:

        headSchoolDetailsJtext.setText("");
        headSchoolDetailsJtext.setForeground(Color.black);

    }//GEN-LAST:event_headSchoolDetailsJtextFocusGained

    private void maritalStatusComboBoxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_maritalStatusComboBoxFocusGained
        // TODO add your handling code here:

        maritalStatusComboBox.removeItem("Please select marital status");
    }//GEN-LAST:event_maritalStatusComboBoxFocusGained

    private void employmentStatusComboBoxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_employmentStatusComboBoxFocusGained
        // TODO add your handling code here:

        employmentStatusComboBox.removeItem("Please select gender");
    }//GEN-LAST:event_employmentStatusComboBoxFocusGained

    private void headLastNameJtextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_headLastNameJtextFocusLost
        // TODO add your handling code here:

        if(headLastNameJtext.getText().equals(""))
        {
            headLastNameJtext.setText("Last name:");
            headLastNameJtext.setForeground(Color.LIGHT_GRAY);
        }
    }//GEN-LAST:event_headLastNameJtextFocusLost

    private void headLastNameJtextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_headLastNameJtextFocusGained
        // TODO add your handling code here:
        headLastNameJtext.setText("");
        headLastNameJtext.setForeground(Color.black);

    }//GEN-LAST:event_headLastNameJtextFocusGained

    private void headMiddleNameJtextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_headMiddleNameJtextFocusLost
        // TODO add your handling code here:

        if(headMiddleNameJtext.getText().equals(""))
        {
            headMiddleNameJtext.setText("Middle name:");
            headMiddleNameJtext.setForeground(Color.LIGHT_GRAY);
        }
    }//GEN-LAST:event_headMiddleNameJtextFocusLost

    private void headMiddleNameJtextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_headMiddleNameJtextFocusGained
        // TODO add your handling code here:

        headMiddleNameJtext.setText("");
        headMiddleNameJtext.setForeground(Color.black);
    }//GEN-LAST:event_headMiddleNameJtextFocusGained

    private void headFirstNameJtextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_headFirstNameJtextFocusLost
        // TODO add your handling code here:

        if(headFirstNameJtext.getText().equals(""))
        {
            headFirstNameJtext.setText("First name:");
            headFirstNameJtext.setForeground(Color.LIGHT_GRAY);
        }
    }//GEN-LAST:event_headFirstNameJtextFocusLost

    private void headFirstNameJtextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_headFirstNameJtextFocusGained
        // TODO add your handling code here:
        headFirstNameJtext.setText("");
        headFirstNameJtext.setForeground(Color.black);
    }//GEN-LAST:event_headFirstNameJtextFocusGained

    private void employmentStatusComboBox1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_employmentStatusComboBox1FocusGained
        // TODO add your handling code here:
        
        
        
    }//GEN-LAST:event_employmentStatusComboBox1FocusGained

    private void countryComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_countryComboBoxActionPerformed
        // TODO add your handling code here:
        
        String countryName =String.valueOf(countryComboBox.getSelectedItem());
        populateStateComboBox(countryName);
    }//GEN-LAST:event_countryComboBoxActionPerformed

    private void stateComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stateComboBoxActionPerformed
        // TODO add your handling code here:
        String countryName =String.valueOf(countryComboBox.getSelectedItem());
        Region region =(Region)stateComboBox.getSelectedItem();
        populateVillageComboBox(region, countryName);
        
        
    }//GEN-LAST:event_stateComboBoxActionPerformed

    
    public Government populateStateComboBox(String countryName)
    {
        
        stateComboBox.removeAllItems();
        Government government=null;
            Government inGovernment=null;
            DonationEnterprise inEnterprise=null;
            
            ArrayList <Region>regionList;
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
                      regionList = government.getRegionDirectory().getRegionList();
                       
                       for(Region region:regionList)
                       {
                        stateComboBox.addItem(region);   
                       }
                       }
                       
                   }
               }
           }
        
        return government;
    }
    
    public void populateVillageComboBox(Region region,String countryName)
    {
        villageComboBox.removeAllItems();
        
        
        Government government=null;
         Government inGovernment=null;
            
            
            ArrayList <Region>regionList;
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
                      regionList = government.getRegionDirectory().getRegionList();
                       
                       for(Region region1:regionList)
                       {
                           if(region1.getRegionName().equalsIgnoreCase(region.getRegionName()))
                           {
                               for(Village village:region1.getVillageList())
                               {
                                   villageComboBox.addItem(village);
                               }
                           }
                       }
                       }
                       
                   }
               }
           }
        
        
    
        
    }
    
    
    public boolean checkUserNamePresentInWorkRequest(String mobileNo)
    {
        boolean errorFlag=false;
        EnrollmentWorkRequest enrollment=null;
        String requestStatus="notPresent";
        
        for(Network network:business.getAllNetwork())
        {
            for(Enterprise enterprise:network.getEnterpriseDirectory().getEnterpriseList())
            {
                for(WorkRequest workRequest:enterprise.getWorkQueue().getWorkRequestList())
                {
                    if(workRequest instanceof EnrollmentWorkRequest)
                        enrollment = (EnrollmentWorkRequest)workRequest;
                    if(enrollment.getCellPhoneNo().equalsIgnoreCase(mobileNo)||!enrollment.getStatus().equalsIgnoreCase("Approved"))
                    {
                        errorFlag=true;
                        requestStatus = enrollment.getStatus();
                    break;
                    }
                }
                
                
                for(Organization organization:enterprise.getOrganizationDirectory().getOrganizationList())
                {
                    for(WorkRequest workRequest:organization.getWorkQueue().getWorkRequestList())
                {
                    if(workRequest instanceof EnrollmentWorkRequest)
                        enrollment = (EnrollmentWorkRequest)workRequest;
                    if(enrollment.getCellPhoneNo().equalsIgnoreCase(mobileNo)||!enrollment.getStatus().equalsIgnoreCase("Approved"))
                    {
                        errorFlag=true;
                        requestStatus = enrollment.getStatus();
                        break;
                    }
                }
            }
        }
        
        }
        
        
        return errorFlag;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel MiddleNameValidatorJlbl;
    private javax.swing.JLabel adultValueValidatorJlbl;
    private javax.swing.JComboBox birthDateComboBox;
    private javax.swing.JComboBox birthMonthComboBox;
    private javax.swing.JComboBox birthYearComboBox;
    private javax.swing.JButton browseImageJbutton;
    private javax.swing.JLabel cellPhoneValidatorJlbl;
    private javax.swing.JLabel certificateImage;
    private javax.swing.JLabel childrenValueValidatorJlbl;
    private javax.swing.JCheckBox conditionSelectionCheckbox;
    private javax.swing.JLabel conditionSelectionValidatorJlbl;
    private javax.swing.JComboBox countryComboBox;
    private javax.swing.JLabel dateValidatorJlbl;
    private javax.swing.JTextField districtNameJtext;
    private javax.swing.JLabel districtNameValidatorJlbl;
    private javax.swing.JComboBox educationComboBox1;
    private javax.swing.JLabel educationDegreeValidator;
    private javax.swing.JTextField employerDetailsJtext;
    private javax.swing.JTextField employerNameJtext;
    private javax.swing.JLabel employerNameValidatorJlbl;
    private javax.swing.JComboBox employmentStatusComboBox;
    private javax.swing.JComboBox employmentStatusComboBox1;
    private javax.swing.JLabel employmentTypeValidatorJlbl;
    private javax.swing.JLabel firstNameValidatorJlbl;
    private javax.swing.JLabel genderValidatorJlbl;
    private javax.swing.JLayeredPane headCellPhoneNumber;
    private javax.swing.JRadioButton headFamilyCellPhoneJRadioButton;
    private javax.swing.JTextField headFirstNameJtext;
    private javax.swing.JComboBox headGenderComboBox;
    private javax.swing.JTextField headIdJtext;
    private javax.swing.JTextField headLastNameJtext;
    private javax.swing.JTextField headMiddleNameJtext;
    private javax.swing.JComboBox headSalary;
    private javax.swing.JTextField headSchoolDetailsJtext;
    private javax.swing.JTextField headSchoolNameJtext;
    private javax.swing.JTextField headcellPhoneNumberJtext;
    private javax.swing.JLabel homeImageValidatorJlbl;
    private javax.swing.JComboBox homeTypeComboBox;
    private javax.swing.JLabel homeTypeValidatorJlbl;
    private javax.swing.JComboBox idComboBox;
    private javax.swing.JLabel idNoValidatorJlbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JLabel landMarkValidatorJlbl;
    private javax.swing.JLabel lastNameValidatorJlbl;
    private javax.swing.JLayeredPane locationDetailsJPanel;
    private javax.swing.JComboBox maritalStatusComboBox;
    private javax.swing.JLabel maritalStatusValidatorJlbl;
    private javax.swing.JLabel monthValidatorJlbl;
    private javax.swing.JTextField nearByLocationJtext;
    private javax.swing.JSpinner noOfAdultJSpinner;
    private javax.swing.JSpinner noOfChildrenJSpinner;
    private javax.swing.JLabel noOfMembersValidatorJlbl;
    private javax.swing.JButton registerJbutton;
    private javax.swing.JLabel salaryValidatorJlbl;
    private javax.swing.JLabel schoolNameValidatorJlbl;
    private javax.swing.JTextField spouseNameJtext;
    private javax.swing.JComboBox stateComboBox;
    private javax.swing.JTextField streetNameJtext;
    private javax.swing.JLabel streetNameValidatorJlbl;
    private javax.swing.JComboBox villageComboBox;
    private javax.swing.JLabel yearValidatorJlbl;
    // End of variables declaration//GEN-END:variables
}

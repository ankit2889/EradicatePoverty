/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package userInterface.EnrollmentOrganization;

import Business.Employee.Employee;
import Business.EnrollmentStaff.FieldStaff;
import Business.EnrollmentStaff.SeniorStaff;
import Business.EnrollmentStaff.Staff;
import Business.Organization.Organization;
import Business.Role.FieldStaffRole;
import Business.Role.Role;
import Business.Role.SeniorStaffRole;
import Business.UserAccount.UserAccount;
import Business.Utility.Validation;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JJPL
 */
public class EnrollmentOrganizationAdminJPanel extends javax.swing.JPanel {

    /**
     * Creates new form EnrollmentOrganizationAdminJPanel
     */
    
    private JPanel userProcessContainer;
    private Organization organization;
    private final String FIRSTNAME="First name:";
    private final String LASTNAME="Last name:";
    private final String EMAILADDRESS="Email address:";
    private final String YEARSOFEXPERIENCE="Years of Experience:";
    private final String STATE="State of residence:";
    private final String STAFFTYPE="Please select staff type:";
    private FieldStaff fieldStaff;
    private SeniorStaff seniorStaff;
    
    public EnrollmentOrganizationAdminJPanel(JPanel upc,Organization organization) {
        initComponents();
        this.userProcessContainer=upc;
        this.organization=organization;
        hideJPanels();
        //staffTypeComboBox.addItem(STAFFTYPE);
        setLabels();
                
    }

    
    public void setLabels()
    {
        firstNameValidatorJlbl.setText("");
        lastNameValidatorJlbl.setText("");
        emailIdValidatorJlbl.setText("");
        residenceStateValidatorJlbl.setText("");
    }
    
    public void populateStaffTypeComboBox()
    {
        for(Staff.StaffType type:Staff.StaffType.values())
        {
        
            staffTypeComboBox.addItem(type);
        }
        
    }
    
    
    public void populateStaffTable(Staff.StaffType type)
    {
        
        DefaultTableModel dtm = (DefaultTableModel)staffJtable.getModel();
        dtm.setRowCount(0);
        if(type.equals(Staff.StaffType.FIELDSTAFF))
        {
            for(UserAccount userAccount:organization.getUserAccountDirectory().getUserAccountList())
            {
                if(userAccount.getRole() instanceof FieldStaffRole)
                {
                    
                    Object row[]=new Object[3];
                    row[0]=userAccount.getPerson().getId();
                    row[1]=userAccount.getPerson().getFirstName()+userAccount.getPerson().getLastName();
                    row[2]=userAccount.getPerson().getEmailId();
                    
                    dtm.addRow(row);
                }
                    
            }
        }
        
        else if(type.equals(Staff.StaffType.SENIORSTAFF))
        {
            for(UserAccount userAccount:organization.getUserAccountDirectory().getUserAccountList())
            {
                if(userAccount.getRole() instanceof SeniorStaffRole)
                {
                    
                    Object row[]=new Object[3];
                    row[0]=userAccount.getPerson().getId();
                    row[1]=userAccount.getPerson().getFirstName()+userAccount.getPerson().getLastName();
                    row[2]=userAccount.getPerson().getEmailId();
                    
                    dtm.addRow(row);
                }
                    
            }
        }
        
        
        
    }
    
    public void hideJPanels()
    {
        createStaffJPanel.setVisible(false);
    }
    
    
    public boolean validateForm()
    {
        
        setLabels();
        boolean errorFlag=false;
        
        if(!Validation.validateTextFieldsForNonEmpty(staffFirstNameJtext)||staffFirstNameJtext.getText().trim().equals(FIRSTNAME))
        {
            errorFlag=true;
            firstNameValidatorJlbl.setText("Please enter first name");
        }
        
        if(!Validation.validateTextFieldsForNonEmpty(staffLastNameJtext)||staffLastNameJtext.getText().trim().equals(LASTNAME))
        {
            errorFlag=true;
            lastNameValidatorJlbl.setText("Please enter last name");
        }
        
        
        if(!Validation.validateTextFieldsForNonEmpty(staffEmailIdJtext)||staffEmailIdJtext.getText().trim().equals(EMAILADDRESS))
        {
            errorFlag=true;
            emailIdValidatorJlbl.setText("Please enter email id");
        }
        
        else  if(!Validation.validateTextFieldsForEmailId(staffEmailIdJtext))
        {
            errorFlag=true;
            emailIdValidatorJlbl.setText("Please enter valid email id");
        }
        
        if(!Validation.validateTextFieldsForNonEmpty(residenceState)||residenceState.getText().trim().equals(STATE))
        {
            errorFlag=true;
            residenceStateValidatorJlbl.setText("Please select state of residence");
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
        manageStaffJPanel = new javax.swing.JLayeredPane();
        staffTypeComboBox = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        staffJtable = new javax.swing.JTable();
        createStaffJbutton = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        createStaffJPanel = new javax.swing.JLayeredPane();
        jSeparator1 = new javax.swing.JSeparator();
        createStaffJlbl = new javax.swing.JLabel();
        staffFirstNameJtext = new javax.swing.JTextField();
        staffLastNameJtext = new javax.swing.JTextField();
        staffEmailIdJtext = new javax.swing.JTextField();
        createStaffPanelJbutton = new javax.swing.JButton();
        yearOfExperienceJtext = new javax.swing.JTextField();
        firstNameValidatorJlbl = new javax.swing.JLabel();
        lastNameValidatorJlbl = new javax.swing.JLabel();
        emailIdValidatorJlbl = new javax.swing.JLabel();
        residenceStateValidatorJlbl = new javax.swing.JLabel();
        residenceState = new javax.swing.JTextField();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("ENROLLMENT ORGANIZATION");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, -1, -1));

        manageStaffJPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        staffTypeComboBox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                staffTypeComboBoxFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                staffTypeComboBoxFocusLost(evt);
            }
        });
        staffTypeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staffTypeComboBoxActionPerformed(evt);
            }
        });

        staffJtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Employee Id", "Employee Name", "Employee email Id"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(staffJtable);

        createStaffJbutton.setEnabled(false);
        createStaffJbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createStaffJbuttonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("MANAGE STAFF");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel2.setText("Note:-Please select staff type to view staff list or add new staff");

        javax.swing.GroupLayout manageStaffJPanelLayout = new javax.swing.GroupLayout(manageStaffJPanel);
        manageStaffJPanel.setLayout(manageStaffJPanelLayout);
        manageStaffJPanelLayout.setHorizontalGroup(
            manageStaffJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addGroup(manageStaffJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(manageStaffJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, manageStaffJPanelLayout.createSequentialGroup()
                        .addGap(0, 18, Short.MAX_VALUE)
                        .addGroup(manageStaffJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, manageStaffJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(staffTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(manageStaffJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, manageStaffJPanelLayout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap())
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, manageStaffJPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(173, 173, 173))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, manageStaffJPanelLayout.createSequentialGroup()
                                .addComponent(createStaffJbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(138, 138, 138))))
                    .addGroup(manageStaffJPanelLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        manageStaffJPanelLayout.setVerticalGroup(
            manageStaffJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageStaffJPanelLayout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(staffTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(createStaffJbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );
        manageStaffJPanel.setLayer(staffTypeComboBox, javax.swing.JLayeredPane.DEFAULT_LAYER);
        manageStaffJPanel.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        manageStaffJPanel.setLayer(createStaffJbutton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        manageStaffJPanel.setLayer(jSeparator2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        manageStaffJPanel.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        manageStaffJPanel.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        add(manageStaffJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 480, 380));

        createStaffJPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        staffFirstNameJtext.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        staffFirstNameJtext.setForeground(new java.awt.Color(204, 204, 204));
        staffFirstNameJtext.setText("First name:");
        staffFirstNameJtext.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                staffFirstNameJtextFocusGained(evt);
            }
        });

        staffLastNameJtext.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        staffLastNameJtext.setForeground(new java.awt.Color(204, 204, 204));
        staffLastNameJtext.setText("Last name:");
        staffLastNameJtext.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                staffLastNameJtextFocusGained(evt);
            }
        });

        staffEmailIdJtext.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        staffEmailIdJtext.setForeground(new java.awt.Color(204, 204, 204));
        staffEmailIdJtext.setText("Email id:");
        staffEmailIdJtext.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                staffEmailIdJtextFocusGained(evt);
            }
        });

        createStaffPanelJbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createStaffPanelJbuttonActionPerformed(evt);
            }
        });

        yearOfExperienceJtext.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        yearOfExperienceJtext.setText("Years of Experience:");
        yearOfExperienceJtext.setEnabled(false);
        yearOfExperienceJtext.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                yearOfExperienceJtextFocusGained(evt);
            }
        });

        firstNameValidatorJlbl.setForeground(new java.awt.Color(255, 0, 0));
        firstNameValidatorJlbl.setText("jLabel4");

        lastNameValidatorJlbl.setForeground(new java.awt.Color(255, 51, 0));
        lastNameValidatorJlbl.setText("jLabel5");

        emailIdValidatorJlbl.setForeground(new java.awt.Color(255, 51, 0));
        emailIdValidatorJlbl.setText("jLabel6");

        residenceStateValidatorJlbl.setForeground(new java.awt.Color(255, 51, 0));
        residenceStateValidatorJlbl.setText("jLabel7");

        residenceState.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        residenceState.setForeground(new java.awt.Color(204, 204, 204));
        residenceState.setText("State of Residence:");
        residenceState.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                residenceStateFocusGained(evt);
            }
        });

        javax.swing.GroupLayout createStaffJPanelLayout = new javax.swing.GroupLayout(createStaffJPanel);
        createStaffJPanel.setLayout(createStaffJPanelLayout);
        createStaffJPanelLayout.setHorizontalGroup(
            createStaffJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, createStaffJPanelLayout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(createStaffJlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
            .addGroup(createStaffJPanelLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(createStaffJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(createStaffPanelJbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(createStaffJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(staffFirstNameJtext)
                        .addComponent(staffLastNameJtext)
                        .addComponent(staffEmailIdJtext)
                        .addComponent(firstNameValidatorJlbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lastNameValidatorJlbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(emailIdValidatorJlbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(residenceStateValidatorJlbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(residenceState, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE))
                    .addComponent(yearOfExperienceJtext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        createStaffJPanelLayout.setVerticalGroup(
            createStaffJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(createStaffJPanelLayout.createSequentialGroup()
                .addComponent(createStaffJlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(staffFirstNameJtext, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(firstNameValidatorJlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(staffLastNameJtext, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lastNameValidatorJlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(staffEmailIdJtext, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailIdValidatorJlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(residenceState, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(residenceStateValidatorJlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(yearOfExperienceJtext, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(createStaffPanelJbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        createStaffJPanel.setLayer(jSeparator1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        createStaffJPanel.setLayer(createStaffJlbl, javax.swing.JLayeredPane.DEFAULT_LAYER);
        createStaffJPanel.setLayer(staffFirstNameJtext, javax.swing.JLayeredPane.DEFAULT_LAYER);
        createStaffJPanel.setLayer(staffLastNameJtext, javax.swing.JLayeredPane.DEFAULT_LAYER);

        staffLastNameJtext.getAccessibleContext().setAccessibleName("staffLastNameJtext");
        createStaffJPanel.setLayer(staffEmailIdJtext, javax.swing.JLayeredPane.DEFAULT_LAYER);
        staffEmailIdJtext.getAccessibleContext().setAccessibleName("staffEmailIdJtext");
        createStaffJPanel.setLayer(createStaffPanelJbutton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        createStaffJPanel.setLayer(yearOfExperienceJtext, javax.swing.JLayeredPane.DEFAULT_LAYER);
        createStaffJPanel.setLayer(firstNameValidatorJlbl, javax.swing.JLayeredPane.DEFAULT_LAYER);
        createStaffJPanel.setLayer(lastNameValidatorJlbl, javax.swing.JLayeredPane.DEFAULT_LAYER);
        createStaffJPanel.setLayer(emailIdValidatorJlbl, javax.swing.JLayeredPane.DEFAULT_LAYER);
        createStaffJPanel.setLayer(residenceStateValidatorJlbl, javax.swing.JLayeredPane.DEFAULT_LAYER);
        createStaffJPanel.setLayer(residenceState, javax.swing.JLayeredPane.DEFAULT_LAYER);

        add(createStaffJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 80, 310, 380));
    }// </editor-fold>//GEN-END:initComponents

    private void staffTypeComboBoxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_staffTypeComboBoxFocusGained
        // TODO add your handling code here:
        
      //  staffTypeComboBox.removeItem(STAFFTYPE);
        staffTypeComboBox.setForeground(Color.BLACK);
        populateStaffTypeComboBox();
        
    }//GEN-LAST:event_staffTypeComboBoxFocusGained

    private void staffTypeComboBoxFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_staffTypeComboBoxFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_staffTypeComboBoxFocusLost

    private void staffTypeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staffTypeComboBoxActionPerformed
        // TODO add your handling code here:
        
        Staff.StaffType selectedStaffType = (Staff.StaffType)staffTypeComboBox.getSelectedItem();
        populateStaffTable(selectedStaffType);
        createStaffJbutton.setEnabled(true);
        createStaffJbutton.setText("Add new"+selectedStaffType+" ");
        if(selectedStaffType.equals(Staff.StaffType.SENIORSTAFF))
        {
            yearOfExperienceJtext.setEnabled(true);
        }
    }//GEN-LAST:event_staffTypeComboBoxActionPerformed

    private void createStaffJbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createStaffJbuttonActionPerformed
        // TODO add your handling code here:
         Staff.StaffType selectedStaffType = (Staff.StaffType)staffTypeComboBox.getSelectedItem();
        createStaffJPanel.setVisible(true);
        createStaffJlbl.setText("Create new"+selectedStaffType);
        createStaffPanelJbutton.setText("Create new"+selectedStaffType);
        
        
        
        
    }//GEN-LAST:event_createStaffJbuttonActionPerformed

    private void createStaffPanelJbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createStaffPanelJbuttonActionPerformed
        // TODO add your handling code here:
        
        if(!validateForm())
        {
            Staff.StaffType selectedStaffType = (Staff.StaffType)staffTypeComboBox.getSelectedItem();
            
            if(selectedStaffType.equals(Staff.StaffType.FIELDSTAFF))
        {
           Employee employee= organization.getEmployeeDirectory().createEmployee("o@g.com");
           UserAccount ua=organization.getUserAccountDirectory().createUserAccount(staffLastNameJtext.getText(), "field", employee,new FieldStaffRole());
           employee.setFirstName(staffFirstNameJtext.getText());
            System.out.println("Role:"+ua.getRole());
           employee.setLastName(staffLastNameJtext.getText());
           employee.getAddress().setStateName(residenceState.getText());
           populateStaffTable(selectedStaffType);
           hideJPanels();
         
        }
            
            else if(selectedStaffType.equals(Staff.StaffType.SENIORSTAFF))
        {
           Employee employee= organization.getEmployeeDirectory().createEmployee(staffEmailIdJtext.getText().trim());
           UserAccount ua=organization.getUserAccountDirectory().createUserAccount(staffLastNameJtext.getText(), "field", employee,new SeniorStaffRole());
           employee.setFirstName(staffFirstNameJtext.getText());
           employee.setLastName(staffLastNameJtext.getText());
           employee.getAddress().setStateName(residenceState.getText());
           populateStaffTable(selectedStaffType);
           hideJPanels();
        }
            
            
        }
    }//GEN-LAST:event_createStaffPanelJbuttonActionPerformed

    private void staffFirstNameJtextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_staffFirstNameJtextFocusGained
        // TODO add your handling code here:
       staffFirstNameJtext.setText("");
       staffFirstNameJtext.setForeground(Color.BLACK);
    }//GEN-LAST:event_staffFirstNameJtextFocusGained

    private void staffLastNameJtextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_staffLastNameJtextFocusGained
        // TODO add your handling code here:
        staffLastNameJtext.setText("");
        staffLastNameJtext.setForeground(Color.BLACK);
    }//GEN-LAST:event_staffLastNameJtextFocusGained

    private void staffEmailIdJtextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_staffEmailIdJtextFocusGained
        // TODO add your handling code here:
       staffEmailIdJtext.setText("");
       staffEmailIdJtext.setForeground(Color.BLACK);
    }//GEN-LAST:event_staffEmailIdJtextFocusGained

    private void residenceStateFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_residenceStateFocusGained
        // TODO add your handling code here:
        residenceState.setText("");
        residenceState.setForeground(Color.BLACK);
    }//GEN-LAST:event_residenceStateFocusGained

    private void yearOfExperienceJtextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_yearOfExperienceJtextFocusGained
        // TODO add your handling code here:
        yearOfExperienceJtext.setText("");
        yearOfExperienceJtext.setForeground(Color.BLACK);
    }//GEN-LAST:event_yearOfExperienceJtextFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane createStaffJPanel;
    private javax.swing.JButton createStaffJbutton;
    private javax.swing.JLabel createStaffJlbl;
    private javax.swing.JButton createStaffPanelJbutton;
    private javax.swing.JLabel emailIdValidatorJlbl;
    private javax.swing.JLabel firstNameValidatorJlbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lastNameValidatorJlbl;
    private javax.swing.JLayeredPane manageStaffJPanel;
    private javax.swing.JTextField residenceState;
    private javax.swing.JLabel residenceStateValidatorJlbl;
    private javax.swing.JTextField staffEmailIdJtext;
    private javax.swing.JTextField staffFirstNameJtext;
    private javax.swing.JTable staffJtable;
    private javax.swing.JTextField staffLastNameJtext;
    private javax.swing.JComboBox staffTypeComboBox;
    private javax.swing.JTextField yearOfExperienceJtext;
    // End of variables declaration//GEN-END:variables
}

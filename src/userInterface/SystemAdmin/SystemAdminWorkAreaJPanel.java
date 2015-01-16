/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package userInterface.SystemAdmin;

import Business.Ecosystem;
import Business.Employee.Employee;
import Business.Enterprise.DonationEnterprise;
import Business.Enterprise.Enterprise;
import Business.Enterprise.Enterprise.EnterpriseType;
import Business.GovernmentEnterprise.Government;
import Business.Network.Network;
import Business.Network.Network.NetworkType;
import Business.Organization.Organization;
import Business.Role.BankAdmin;
import Business.Role.EnterpriseAdminRole;
import Business.Role.GovernmentOfficialRole;
import Business.Role.MobileEnterpriseAdminRole;
import Business.Role.Role;
import Business.UserAccount.UserAccount;

import Business.Utility.Validation;
import business.utility.SendEmail;
import java.awt.CardLayout;
//import business.utility.SendEmail;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.util.UUID;

/**
 *
 * @author JJPL
 */
public class SystemAdminWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form SystemAdminWorkAreaJPanel
     */
    
     private JPanel userProcessContainer;
    private Ecosystem business;
    private Enterprise selectedEnterprise = null;
    private UserAccount userAccount;
    private final String NETWORK = "Please enter Network name:";
    public SystemAdminWorkAreaJPanel(JPanel upc,UserAccount userAccount,Ecosystem business) {
        initComponents();
        this.userProcessContainer = upc;
        this.business = business;
        this.userAccount = userAccount;
        populateTree();
        populateEnterpriseTypeComboBox();
        hideAllJPanels();
        //populateNetworkTable();
     
     manageEnterpriseAdmin_Jbutton.setVisible(false);
    }
    
    
    private void hideAllJPanels()
    {
        addNetwork_JPanel.setVisible(false);
        jLayeredPane1.setVisible(false);
        manageEnterpriseAdmin_JPanel.setVisible(false);
        
        
    }
    
    
   
   
//    public void populateNetworkTable()
//    {
//        
//        DefaultTableModel dtm = (DefaultTableModel)network_Jtable.getModel();
//        dtm.setRowCount(0);
//        
//        for (Network network :business.getNetworkDirectory().getNetworkList())
//        {
//            Object row[]=new Object[2];
//            row[0]=network;
//            row[1]=network.getNetworkType();
//            dtm.addRow(row);
//        }
//    }
    
    public void populateTree()
    {
        hideAllJPanels();
        DefaultTreeModel model = (DefaultTreeModel)systemTree.getModel();
        DefaultMutableTreeNode root = (DefaultMutableTreeNode)model.getRoot();
        root.removeAllChildren();
        
        
        Network country;
        Network state;
        Network city;
        ArrayList <Enterprise> enterpriseList;
        ArrayList <Organization> organizationList;
        
        
        Network rootNetwork;
        Enterprise enterprise;
        Organization organization;
        
        
        
       
        
        DefaultMutableTreeNode rootNetworkNode;
        DefaultMutableTreeNode countryNode;
        DefaultMutableTreeNode stateNode;
        DefaultMutableTreeNode cityNode;
        
        rootNetwork = business.getRootNetwork();
        
        DefaultMutableTreeNode enterpriseNode;
        DefaultMutableTreeNode organizationNode;
        
        for (int i =0;i<rootNetwork.getSubNetworkDirectory().getNetworkList().size();i++)
        {
            country = rootNetwork.getSubNetworkDirectory().getNetworkList().get(i);
            countryNode = new DefaultMutableTreeNode(country.getName());
            root.insert(countryNode, i);
            
             
            
            for (int j = 0;j<country.getSubNetworkDirectory().getNetworkList().size();j++)
            {
                state = country.getSubNetworkDirectory().getNetworkList().get(j);
                stateNode = new DefaultMutableTreeNode(state.getName());
                countryNode.insert(stateNode, j);
                
                
                
                for (int k =0;k<state.getSubNetworkDirectory().getNetworkList().size();k++)
                {
                    city = state.getSubNetworkDirectory().getNetworkList().get(k);
                    cityNode = new DefaultMutableTreeNode(city.getName());
                   stateNode.insert(cityNode, k);
                   
                   
                   
                }
            }
            
            
            
        }
        
        model.reload();
        
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
        systemTree = new javax.swing.JTree();
        jLabel1 = new javax.swing.JLabel();
        addNetwork_JPanel = new javax.swing.JLayeredPane();
        jSeparator1 = new javax.swing.JSeparator();
        addNetwork_Jlabel = new javax.swing.JLabel();
        networkName_Jtext = new javax.swing.JTextField();
        addNetwork_Jbutton = new javax.swing.JButton();
        manageNetwork_Jlabel = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jSeparator2 = new javax.swing.JSeparator();
        addEnterprise_Jlabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        enterprise_Jtable = new javax.swing.JTable();
        addEnterprise_Jbutton = new javax.swing.JButton();
        enterpriseName_Jtext = new javax.swing.JTextField();
        manageEnterpriseAdmin_Jbutton = new javax.swing.JButton();
        enterpriseTypeComboBox = new javax.swing.JComboBox();
        enterpriseNameValidatorJlabel = new javax.swing.JLabel();
        enterpriseTypeValidatorJlabel = new javax.swing.JLabel();
        enterpriseNameValidatorJlbl = new javax.swing.JLabel();
        enterpriseNameValidatorJlabel1 = new javax.swing.JLabel();
        enterpriseNameValidatorJlbl1 = new javax.swing.JLabel();
        manageEnterpriseAdmin_JPanel = new javax.swing.JLayeredPane();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        manageEnterpriseAdmin_Jtable = new javax.swing.JTable();
        deleteEnterpriseAdmin_Jbutton = new javax.swing.JButton();
        enterpriseAdminName_Jtext = new javax.swing.JTextField();
        enterpriseAdminEmail_Jtext = new javax.swing.JTextField();
        addAdmin_Jbutton = new javax.swing.JButton();
        manageEnterpriseAdmin_Jlabel = new javax.swing.JLabel();
        adminLastNameJtext = new javax.swing.JTextField();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        manageProfileJbutton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        systemTree.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Global");
        systemTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        systemTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                systemTreeValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(systemTree);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 220, 480));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("Our network");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        addNetwork_JPanel.setBackground(new java.awt.Color(153, 153, 153));
        addNetwork_JPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        addNetwork_JPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        addNetwork_JPanel.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 32, 370, 10));

        addNetwork_Jlabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        addNetwork_Jlabel.setText("Add");
        addNetwork_JPanel.add(addNetwork_Jlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 30, 20));

        networkName_Jtext.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                networkName_JtextFocusGained(evt);
            }
        });
        addNetwork_JPanel.add(networkName_Jtext, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 160, 30));

        addNetwork_Jbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNetwork_JbuttonActionPerformed(evt);
            }
        });
        addNetwork_JPanel.add(addNetwork_Jbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 120, 30));

        manageNetwork_Jlabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        addNetwork_JPanel.add(manageNetwork_Jlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 150, 20));

        add(addNetwork_JPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 500, 370, 250));

        jLayeredPane1.setBackground(new java.awt.Color(153, 153, 153));
        jLayeredPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLayeredPane1.add(jSeparator2);
        jSeparator2.setBounds(0, 30, 370, 10);

        addEnterprise_Jlabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        addEnterprise_Jlabel.setText("         Manage Enterprise");
        jLayeredPane1.add(addEnterprise_Jlabel);
        addEnterprise_Jlabel.setBounds(90, 0, 210, 30);

        enterprise_Jtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Enterprise Id", "Enterprise name", "Enterprise Type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(enterprise_Jtable);

        jLayeredPane1.add(jScrollPane2);
        jScrollPane2.setBounds(30, 40, 320, 90);

        addEnterprise_Jbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEnterprise_JbuttonActionPerformed(evt);
            }
        });
        jLayeredPane1.add(addEnterprise_Jbutton);
        addEnterprise_Jbutton.setBounds(30, 280, 290, 30);

        enterpriseName_Jtext.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        enterpriseName_Jtext.setForeground(new java.awt.Color(204, 204, 204));
        enterpriseName_Jtext.setText(" Please enter enterprise name here:");
        enterpriseName_Jtext.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                enterpriseName_JtextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                enterpriseName_JtextFocusLost(evt);
            }
        });
        enterpriseName_Jtext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterpriseName_JtextActionPerformed(evt);
            }
        });
        jLayeredPane1.add(enterpriseName_Jtext);
        enterpriseName_Jtext.setBounds(30, 150, 290, 30);

        manageEnterpriseAdmin_Jbutton.setText("Manage enterprise admin");
        manageEnterpriseAdmin_Jbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageEnterpriseAdmin_JbuttonActionPerformed(evt);
            }
        });
        jLayeredPane1.add(manageEnterpriseAdmin_Jbutton);
        manageEnterpriseAdmin_Jbutton.setBounds(30, 320, 290, 30);

        enterpriseTypeComboBox.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        enterpriseTypeComboBox.setForeground(new java.awt.Color(204, 204, 204));
        enterpriseTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Please select enterprise type" }));
        enterpriseTypeComboBox.setToolTipText("Please select enterprise type");
        enterpriseTypeComboBox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                enterpriseTypeComboBoxFocusGained(evt);
            }
        });
        enterpriseTypeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterpriseTypeComboBoxActionPerformed(evt);
            }
        });
        jLayeredPane1.add(enterpriseTypeComboBox);
        enterpriseTypeComboBox.setBounds(30, 220, 290, 30);

        enterpriseNameValidatorJlabel.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        enterpriseNameValidatorJlabel.setForeground(new java.awt.Color(255, 0, 0));
        jLayeredPane1.add(enterpriseNameValidatorJlabel);
        enterpriseNameValidatorJlabel.setBounds(70, 190, 230, 0);

        enterpriseTypeValidatorJlabel.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        enterpriseTypeValidatorJlabel.setForeground(new java.awt.Color(255, 0, 0));
        jLayeredPane1.add(enterpriseTypeValidatorJlabel);
        enterpriseTypeValidatorJlabel.setBounds(10, 250, 350, 20);

        enterpriseNameValidatorJlbl.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        enterpriseNameValidatorJlbl.setForeground(new java.awt.Color(255, 0, 0));
        enterpriseNameValidatorJlbl.setEnabled(false);
        jLayeredPane1.add(enterpriseNameValidatorJlbl);
        enterpriseNameValidatorJlbl.setBounds(80, 190, 220, 0);

        enterpriseNameValidatorJlabel1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        enterpriseNameValidatorJlabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLayeredPane1.add(enterpriseNameValidatorJlabel1);
        enterpriseNameValidatorJlabel1.setBounds(60, 130, 250, 14);

        enterpriseNameValidatorJlbl1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        enterpriseNameValidatorJlbl1.setForeground(new java.awt.Color(255, 0, 51));
        jLayeredPane1.add(enterpriseNameValidatorJlbl1);
        enterpriseNameValidatorJlbl1.setBounds(30, 190, 330, 20);

        add(jLayeredPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, 370, 360));

        manageEnterpriseAdmin_JPanel.setBackground(new java.awt.Color(204, 204, 204));
        manageEnterpriseAdmin_JPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        manageEnterpriseAdmin_JPanel.add(jSeparator3);
        jSeparator3.setBounds(0, 30, 400, 2);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("   Manage Enterprise Admin for ");
        manageEnterpriseAdmin_JPanel.add(jLabel3);
        jLabel3.setBounds(0, 0, 200, 30);

        manageEnterpriseAdmin_Jtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Enterprise Admin", "Email address", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(manageEnterpriseAdmin_Jtable);

        manageEnterpriseAdmin_JPanel.add(jScrollPane3);
        jScrollPane3.setBounds(20, 40, 370, 90);

        deleteEnterpriseAdmin_Jbutton.setText("Disable enterprise Admin");
        deleteEnterpriseAdmin_Jbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteEnterpriseAdmin_JbuttonActionPerformed(evt);
            }
        });
        manageEnterpriseAdmin_JPanel.add(deleteEnterpriseAdmin_Jbutton);
        deleteEnterpriseAdmin_Jbutton.setBounds(70, 300, 280, 30);

        enterpriseAdminName_Jtext.setForeground(new java.awt.Color(204, 204, 204));
        enterpriseAdminName_Jtext.setText("Enter admin first name:");
        enterpriseAdminName_Jtext.setToolTipText("Please enter enterprise admin here:");
        enterpriseAdminName_Jtext.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                enterpriseAdminName_JtextFocusGained(evt);
            }
        });
        enterpriseAdminName_Jtext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterpriseAdminName_JtextActionPerformed(evt);
            }
        });
        manageEnterpriseAdmin_JPanel.add(enterpriseAdminName_Jtext);
        enterpriseAdminName_Jtext.setBounds(20, 140, 180, 30);

        enterpriseAdminEmail_Jtext.setForeground(new java.awt.Color(204, 204, 204));
        enterpriseAdminEmail_Jtext.setText("Email address for admin:");
        enterpriseAdminEmail_Jtext.setToolTipText("Please enter email address for admin:");
        enterpriseAdminEmail_Jtext.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                enterpriseAdminEmail_JtextFocusGained(evt);
            }
        });
        manageEnterpriseAdmin_JPanel.add(enterpriseAdminEmail_Jtext);
        enterpriseAdminEmail_Jtext.setBounds(20, 200, 360, 30);

        addAdmin_Jbutton.setText("Add enterprise Admin");
        addAdmin_Jbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAdmin_JbuttonActionPerformed(evt);
            }
        });
        manageEnterpriseAdmin_JPanel.add(addAdmin_Jbutton);
        addAdmin_Jbutton.setBounds(70, 250, 280, 30);

        manageEnterpriseAdmin_Jlabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        manageEnterpriseAdmin_JPanel.add(manageEnterpriseAdmin_Jlabel);
        manageEnterpriseAdmin_Jlabel.setBounds(204, 0, 190, 30);

        adminLastNameJtext.setForeground(new java.awt.Color(204, 204, 204));
        adminLastNameJtext.setText("Enter admin last name:");
        adminLastNameJtext.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                adminLastNameJtextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                adminLastNameJtextFocusLost(evt);
            }
        });
        adminLastNameJtext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminLastNameJtextActionPerformed(evt);
            }
        });
        manageEnterpriseAdmin_JPanel.add(adminLastNameJtext);
        adminLastNameJtext.setBounds(210, 140, 170, 30);

        add(manageEnterpriseAdmin_JPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 120, 400, 350));

        jLayeredPane2.setBackground(new java.awt.Color(51, 153, 255));
        jLayeredPane2.setOpaque(true);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Eradicate Poverty");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Share happiness");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("System Administrator");

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel4)
                        .addGap(120, 120, 120)
                        .addComponent(jLabel2))
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(jLabel5)))
                .addContainerGap(509, Short.MAX_VALUE))
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane2.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        add(jLayeredPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 70));

        manageProfileJbutton.setText("Manage Profile");
        manageProfileJbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageProfileJbuttonActionPerformed(evt);
            }
        });
        add(manageProfileJbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(943, 80, 130, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void networkName_JtextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_networkName_JtextFocusGained
        // TODO add your handling code here:
        
        networkName_Jtext.setText("");
    }//GEN-LAST:event_networkName_JtextFocusGained

    
    public void populateEnterpriseTypeComboBox()
    {
        for(Enterprise.EnterpriseType type:Enterprise.EnterpriseType.values())
        {
            enterpriseTypeComboBox.addItem(type);
        }
    }
    private void systemTreeValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_systemTreeValueChanged
        // TODO add your handling code here:
        
          DefaultMutableTreeNode node = (DefaultMutableTreeNode)systemTree.getLastSelectedPathComponent();
        if (node!=null)
        {
            addNetwork_JPanel.setVisible(true);
            jLayeredPane1.setVisible(true);
            
            manageEnterpriseAdmin_JPanel.setVisible(false);
        
        
        int level = node.getLevel();
        
        if (level==0)
        {
           manageNetwork_Jlabel.setText("Country"+" Network");
           addNetwork_Jbutton.setText("Add Country ");
           Network rootNetwork = business.getRootNetwork();
            System.out.println("Root network"+rootNetwork);
            addEnterprise_Jbutton.setText("Add Enterprise to:"+rootNetwork.getName());
           populateEnterpriseTable(rootNetwork);
          // deleteNetwork_Jbutton.setText("Delete country ");
        }
        
        else if (level==1)
        {
           manageNetwork_Jlabel.setText("State"+" Network"); 
           addNetwork_Jbutton.setText("Add State");
           Network countryNetwork = business.getRootNetwork().findCountryNetwork(node.toString());
           addEnterprise_Jbutton.setText("Add Enterprise to:"+countryNetwork.getName());
           populateEnterpriseTable(countryNetwork);
           //deleteNetwork_Jbutton.setText("Delete State ");
        }
        
        else if (level==2)
        {
            addNetwork_JPanel.setVisible(true);
            manageNetwork_Jlabel.setText("City"+" Network"); 
           addNetwork_Jbutton.setText("Add City");
            
           
           Network stateNetwork = business.getRootNetwork().findStateNetwork(node.getParent().toString(),node.toString());
           addEnterprise_Jbutton.setText("Add Enterprise to:"+stateNetwork.getName());
           populateEnterpriseTable(stateNetwork);
           
           
          // deleteNetwork_Jbutton.setText("Delete City");
        }
        
        else if (level==3)
        {
            addNetwork_JPanel.setVisible(false);
            
            Network cityNetwork = business.getRootNetwork().findCityNetwork(node.getParent().getParent().toString(),node.getParent().toString(),node.toString());
           addEnterprise_Jbutton.setText("Add Enterprise to:"+cityNetwork.getName());
            populateEnterpriseTable(cityNetwork);
        }
        
        }
    }//GEN-LAST:event_systemTreeValueChanged

    
    
    public void populateEnterpriseTable(Network network)
    {
        DefaultTableModel dtm = (DefaultTableModel)enterprise_Jtable.getModel();
        dtm.setRowCount(0);
        
        
        for (Enterprise enterprise:network.getEnterpriseDirectory().getEnterpriseList())
        {
            Object row[]= new Object[3];
            row[0]=enterprise.getEnterpriseId();
            row[1]=enterprise;
            row[2]=enterprise.getEnterpriseType().getValue();
            dtm.addRow(row);
            
            if(enterprise!=null){
                manageEnterpriseAdmin_Jbutton.setVisible(true);
            }
                   
        }
    }
    
    private void addNetwork_JbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNetwork_JbuttonActionPerformed
        // TODO add your handling code here:
        
       
        DefaultMutableTreeNode node= (DefaultMutableTreeNode)systemTree.getLastSelectedPathComponent();
        System.out.println(node);
        if (node!=null)
        {
            if (Validation.validateTextFieldsForNonEmpty(networkName_Jtext))
            {
                if (Validation.validateTextFieldsForString(networkName_Jtext))
                {
                    if (node.getLevel()==0)
                    {
                        business.getRootNetwork().getSubNetworkDirectory().createAndAddNetwork(networkName_Jtext.getText(),NetworkType.COUNTRY.getValue());
                        JOptionPane.showMessageDialog(null,"The country"+networkName_Jtext.getText().trim()+"is added successfully.");
                        networkName_Jtext.setText("");
                        
                    }
                    
                    else if (node.getLevel()==1)
                    {
                        Network countryNetwork = business.getRootNetwork().findCountryNetwork(node.toString());
                        
                        if(countryNetwork!=null)
                        {
                            if(!countryNetwork.getSubNetworkDirectory().isPresent(networkName_Jtext.getText().trim()))
                            {
                                countryNetwork.getSubNetworkDirectory().createAndAddNetwork(networkName_Jtext.getText().trim(),NetworkType.STATE.getValue());
                                JOptionPane.showMessageDialog(null,"The state "+networkName_Jtext.getText().toUpperCase()+" is added successfully to the "+node.toString()+"country",node.toString()+"-->"+networkName_Jtext.getText().toUpperCase(), JOptionPane.INFORMATION_MESSAGE); 
                                networkName_Jtext.setText("");
                            }
                            
                            else
                            {
                                
                             JOptionPane.showMessageDialog(null, "State with same name is already present in this country","Invaid Input",JOptionPane.ERROR_MESSAGE);
                             return;
                            }
                        }
                    }
                    
                    else if (node.getLevel()==2)
                    {
                        Network stateNetwork = business.getRootNetwork().findStateNetwork(node.getParent().toString(),node.toString());
                        if (stateNetwork!=null)
                        {
                            if(!stateNetwork.getSubNetworkDirectory().isPresent(networkName_Jtext.getText().trim()))
                                {
                    stateNetwork.getSubNetworkDirectory().createAndAddNetwork(networkName_Jtext.getText(), Network.NetworkType.CITY.getValue());
                    JOptionPane.showMessageDialog(null,"The city "+networkName_Jtext.getText().toUpperCase()+" is added successfully to the "+node.toString()+"state",node.toString()+"-->"+networkName_Jtext.getText().toUpperCase(), JOptionPane.INFORMATION_MESSAGE);             
                    networkName_Jtext.setText("");
                                }
                            else
                                {
                        JOptionPane.showMessageDialog(null,"The city with same name is already present in the state","Invalid Input",JOptionPane.ERROR_MESSAGE);
                        return;
                                }
                       }
                     
                        
                    }
                    
                    populateTree();
                   
                }else
                    {
                        JOptionPane.showMessageDialog(null,"Please enter valid input","Invalid input",JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
            }else 
                
                {
                    JOptionPane.showMessageDialog(null,"Please enter network name","Blank input",JOptionPane.ERROR_MESSAGE);
                    return;
                }
            
            
                  
            
       }
        
        
        
        
    }//GEN-LAST:event_addNetwork_JbuttonActionPerformed

    private void addEnterprise_JbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEnterprise_JbuttonActionPerformed
        // TODO add your handling code here:
        
       
        
        String errorMsg="";
        boolean errorFlag=false;
        boolean createFlag=true;
        
        Enterprise addedEnterprise=null;
        enterpriseNameValidatorJlbl1.setText("");
        enterpriseTypeValidatorJlabel.setText("");
        int selectedRow = enterprise_Jtable.getSelectedRow();
        
        
        
        if (!Validation.validateTextFieldsForString(enterpriseName_Jtext)||enterpriseName_Jtext.getText().trim().equalsIgnoreCase("Please enter enterprise name here:"))
        {
            //enterpriseNameValidatorJlabel.setEnabled(true);
            
            enterpriseNameValidatorJlbl1.setEnabled(true);
            enterpriseNameValidatorJlbl1.setText("Please enter valid enterprise name");
            errorFlag=true;
           
          
        }
        
        
        if(String.valueOf(enterpriseTypeComboBox.getSelectedItem()).equalsIgnoreCase("Please select enterprise type"))
        {
            enterpriseTypeValidatorJlabel.setEnabled(true);
         
            enterpriseTypeValidatorJlabel.setText("Please select enterprise type");
            errorFlag=true;
        }
        
        else if(selectedRow<0&&!enterpriseTypeComboBox.getSelectedItem().equals(Enterprise.EnterpriseType.DONATION))
        {
            errorFlag=true;
            
               
            enterpriseTypeValidatorJlabel.setText("Please select donation enterprise to connect external enterprise");
            
        }
        
        else
        {
            Enterprise selectedEnterprise = (Enterprise)enterprise_Jtable.getValueAt(selectedRow,1);
            if(!selectedEnterprise.getEnterpriseType().equals(Enterprise.EnterpriseType.DONATION))
            {
                errorFlag=true;
                enterpriseTypeValidatorJlabel.setText("Please select donation enterprise to connect external enterprise");
                
            }
        }
        
        
       
        if(!errorFlag)
        {
        
            
                        DefaultMutableTreeNode node = (DefaultMutableTreeNode)systemTree.getLastSelectedPathComponent();
                        EnterpriseType selectedEnterpriseType = (EnterpriseType)enterpriseTypeComboBox.getSelectedItem();
                        
                        if(!enterpriseTypeComboBox.getSelectedItem().equals(Enterprise.EnterpriseType.DONATION))
                           {
                                Enterprise selectedEnterprise = (Enterprise)enterprise_Jtable.getValueAt(selectedRow,1);
                            }
        
                            if (node!=null)
                                    {
                                        if (checkUniqueEnterprise(enterpriseName_Jtext.getText().trim())){
            
                                                if (node.getLevel()==0){
                
                                                        Network rootNetwork =business.getRootNetwork();
                                                        
                                                        for(Enterprise rootEnterprise:rootNetwork.getEnterpriseDirectory().getEnterpriseList())
                                                        {
                                                            if(rootEnterprise!=null)createFlag=false;
                                                        }
                                                        
                                                        if(createFlag)
                                                        addedEnterprise = rootNetwork.getEnterpriseDirectory().addEnterprise(enterpriseName_Jtext.getText(),selectedEnterpriseType);
                                                        else
                                                        {
                                                            JOptionPane.showMessageDialog(null,"There can be only donation enterprise at global level","Creation denied",JOptionPane.ERROR_MESSAGE);
                                                            return;
                                                        }
                                                        populateEnterpriseTable(rootNetwork);
                                                                        }
                                                if (node.getLevel()==1)
                                                    {
                                                        
                                                        
                                                        Network countryNetwork = business.getRootNetwork().findCountryNetwork(node.toString());
                                                        addedEnterprise =countryNetwork.getEnterpriseDirectory().addEnterprise(enterpriseName_Jtext.getText(),selectedEnterpriseType);
                                                        if(selectedEnterpriseType.equals(Enterprise.EnterpriseType.GOVERNMENT))
                                                        {
                                                            Government government = (Government)addedEnterprise;
                                                            government.setCountryName(node.toString());
                                                        }
                                                        
                                                        
                                                        
                                                        populateEnterpriseTable(countryNetwork);
                                                    }
            
            else if (node.getLevel()==2)
            {
                Network stateNetwork = business.getRootNetwork().findStateNetwork(node.getParent().toString(),node.toString());
                addedEnterprise = stateNetwork.getEnterpriseDirectory().addEnterprise(enterpriseName_Jtext.getText(),selectedEnterpriseType);
                populateEnterpriseTable(stateNetwork);
            }
            
            else if (node.getLevel()==3)
            {
                Network cityNetwork = business.getRootNetwork().findCityNetwork(node.getParent().getParent().toString(),node.getParent().toString(),node.toString());
                addedEnterprise = cityNetwork.getEnterpriseDirectory().addEnterprise(enterpriseName_Jtext.getText(),selectedEnterpriseType);
                populateEnterpriseTable(cityNetwork);
            }
            
            
            if(!selectedEnterpriseType.equals(Enterprise.EnterpriseType.DONATION))
                {
                    if(selectedEnterprise instanceof DonationEnterprise)
                    {
                        DonationEnterprise donationEnterprise = (DonationEnterprise)selectedEnterprise;
                        donationEnterprise.getAssociatedEnterprise().add(addedEnterprise);
                    }
                }
            
                enterpriseName_Jtext.setText("");
                enterpriseTypeComboBox.addItem("Please select enterprise type");
                enterpriseTypeComboBox.setSelectedItem("Please select enterprise type");
                enterpriseNameValidatorJlbl.setText("");
                enterpriseTypeValidatorJlabel.setText("");
            }
            
            else 
            {
                JOptionPane.showMessageDialog(null,"Enterprise with name "+enterpriseName_Jtext.getText()+" is already present in the system.","Duplicate entry",JOptionPane.ERROR_MESSAGE);
                return;
            }
            
        }
        
        else
        {
            errorMsg="\n Please select network to configure";
            errorFlag=true;
        }
        
        }
        
        else
        {
            JOptionPane.showMessageDialog(null,"Please correct all errors and then submit","Invalid input",JOptionPane.ERROR_MESSAGE);
        }
        
       
        
        
        
        
        
        
            
    }//GEN-LAST:event_addEnterprise_JbuttonActionPerformed

    
    
    public boolean checkUniqueEnterprise(String name)
    {
        for (Network network:business.getRootNetwork().getSubNetworkDirectory().getNetworkList())
        {
            for (Enterprise enterprise:network.getEnterpriseDirectory().getEnterpriseList())
            {
                if (enterprise.getName().equalsIgnoreCase(name))
                    return false;
            }
        }
    
    return true;
    }
    private void enterpriseName_JtextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_enterpriseName_JtextFocusGained
        // TODO add your handling code here:
        
        enterpriseName_Jtext.setText("");
        enterpriseName_Jtext.setForeground(Color.BLACK);
    }//GEN-LAST:event_enterpriseName_JtextFocusGained

    private void enterpriseName_JtextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_enterpriseName_JtextFocusLost
        // TODO add your handling code here:
        
        if(enterpriseName_Jtext.getText().equals(""))
        {
            enterpriseName_Jtext.setText("Please enter enterprise name here:");
            enterpriseName_Jtext.setForeground(Color.lightGray);
        }
    }//GEN-LAST:event_enterpriseName_JtextFocusLost

    private void manageEnterpriseAdmin_JbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageEnterpriseAdmin_JbuttonActionPerformed
        // TODO add your handling code here:
        
        int selectedRow = enterprise_Jtable.getSelectedRow();
        
        
        
        if(selectedRow>=0)
        {
            manageEnterpriseAdmin_JPanel.setVisible(true);
            selectedEnterprise = (Enterprise)enterprise_Jtable.getValueAt(selectedRow,1);
            System.out.println("abc"+selectedEnterprise);
            String enterpriseLabel = String.valueOf(enterprise_Jtable.getValueAt(selectedRow,1));
            manageEnterpriseAdmin_Jlabel.setText(enterpriseLabel);
            populateEnterpriseAdminTable(selectedEnterprise);
        
        }
        
        else
        {
            JOptionPane.showMessageDialog(null,"Please select enterprise from the table to create admin","No Selection",JOptionPane.ERROR_MESSAGE);
            return;
        }
    }//GEN-LAST:event_manageEnterpriseAdmin_JbuttonActionPerformed

    private void enterpriseAdminName_JtextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_enterpriseAdminName_JtextFocusGained
        // TODO add your handling code here:
        enterpriseAdminName_Jtext.setText("");
        enterpriseAdminName_Jtext.setForeground(Color.BLACK);
    }//GEN-LAST:event_enterpriseAdminName_JtextFocusGained

    private void addAdmin_JbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAdmin_JbuttonActionPerformed
        // TODO add your handling code here:
        
       String errorMsg="";
       boolean errorFlag=false;
       
       int selectedRow = enterprise_Jtable.getSelectedRow();
       selectedEnterprise = (Enterprise)enterprise_Jtable.getValueAt(selectedRow,1);
       
       if(enterpriseAdminName_Jtext.getText().equalsIgnoreCase("Enter admin first name:"))
          enterpriseAdminName_Jtext.setText(""); 
       
       if(enterpriseAdminEmail_Jtext.getText().equalsIgnoreCase("Email address for admin:"))
          enterpriseAdminName_Jtext.setText(""); 
       
     
       
       if(!Validation.validateTextFieldsForString(enterpriseAdminName_Jtext))
       {
           errorFlag=true;
           errorMsg+="Please enter admin first name \n";
       }
       
        if(!Validation.validateTextFieldsForString(adminLastNameJtext))
       {
           errorFlag=true;
           errorMsg+="Please enter admin last name \n";
       }
       
       
       
       if(!Validation.validateTextFieldsForEmailId(enterpriseAdminEmail_Jtext))
       {
           errorFlag=true;
           errorMsg+="Please enter valid email address \n";
                   
       }
       
      
      
       if(!errorFlag)
       {
           
           
         if(!business.checkUserNamePresent(enterpriseAdminEmail_Jtext.getText().trim()))
         { 
         Enterprise.EnterpriseType selectedEnterpriseType = selectedEnterprise.getEnterpriseType();
         
         
           Employee employee = selectedEnterprise.getEmployeeDirectory().createEmployee(enterpriseAdminEmail_Jtext.getText().trim());
           String employeePassword = randomPasswordGenerator();
         
           
          UserAccount userAccount=null;
          
          if(selectedEnterpriseType.equals(Enterprise.EnterpriseType.GOVERNMENT))
          {
                userAccount=selectedEnterprise.getUserAccountDirectory().createUserAccount(enterpriseAdminEmail_Jtext.getText().trim(),"ent",employee,new GovernmentOfficialRole());
                SendEmail.SendEmail(enterpriseAdminEmail_Jtext.getText().trim(),"Welcome to Eradicate Poverty",enterpriseAdminEmail_Jtext.getText().trim(),"ent");
              
          }
          
          else if(selectedEnterpriseType.equals(Enterprise.EnterpriseType.MOBILE))
          {
                userAccount=selectedEnterprise.getUserAccountDirectory().createUserAccount(enterpriseAdminEmail_Jtext.getText().trim(),"ent",employee,new MobileEnterpriseAdminRole());
             SendEmail.SendEmail(enterpriseAdminEmail_Jtext.getText().trim(),"Welcome to Eradicate Poverty",enterpriseAdminEmail_Jtext.getText().trim(),"ent");
              
          }
          
          
          else if(selectedEnterpriseType.equals(Enterprise.EnterpriseType.BANK))
          {
                userAccount=selectedEnterprise.getUserAccountDirectory().createUserAccount(enterpriseAdminEmail_Jtext.getText().trim(),"ent",employee,new BankAdmin());
             SendEmail.SendEmail(enterpriseAdminEmail_Jtext.getText().trim(),"Welcome to Eradicate Poverty",enterpriseAdminEmail_Jtext.getText().trim(),"ent");
              
          }
          
          else
          {
          userAccount=selectedEnterprise.getUserAccountDirectory().createUserAccount(enterpriseAdminEmail_Jtext.getText().trim(),"ent",employee,new EnterpriseAdminRole());
          SendEmail.SendEmail(enterpriseAdminEmail_Jtext.getText().trim(),"Welcome to Eradicate Poverty",enterpriseAdminEmail_Jtext.getText().trim(),"ent");
           
          }
          
          
           JOptionPane.showMessageDialog(null,"New enterprise admin is created successfully.\n Login credentials will be emailed to you.");
          
          populateEnterpriseAdminTable(selectedEnterprise);
       }
         
         else
         {
             JOptionPane.showMessageDialog(null,"User account with email id "+enterpriseAdminEmail_Jtext.getText()+" already exists.","Duplicate entry",JOptionPane.ERROR_MESSAGE);
         }
         
       }
            
            
            
       
       
       
       
       else
           
       {
           JOptionPane.showMessageDialog(null,errorMsg,"Missing or Incorrect Details",JOptionPane.ERROR_MESSAGE);
           return;
       }
    }//GEN-LAST:event_addAdmin_JbuttonActionPerformed

    
    public String randomPasswordGenerator()
    {
     
        String uuid = UUID.randomUUID().toString();
        return uuid;
        
        
        
        
    }
    
    
    
    
    
    public void populateEnterpriseAdminTable(Enterprise enterprise)
    {
        DefaultTableModel dtm = (DefaultTableModel)manageEnterpriseAdmin_Jtable.getModel();
        dtm.setRowCount(0);
        
        
        for (UserAccount ua:enterprise.getUserAccountDirectory().getUserAccountList())
        {
            if(ua.getRole().getRoleype().equals(Role.RoleType.ENTERPRISEADMIN))
            {
            Object row[]= new Object[3];
            row[0]=ua;
            row[1]=ua.getPerson().getEmailId();
            row[2]=ua.isIsActive()?"Active":"Disabled";
            
           
            dtm.addRow(row);
            }
            
                   
        }
    }

    private void enterpriseAdminEmail_JtextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_enterpriseAdminEmail_JtextFocusGained
        // TODO add your handling code here:

        enterpriseAdminEmail_Jtext.setText("");
        enterpriseAdminEmail_Jtext.setForeground(Color.BLACK);
    }//GEN-LAST:event_enterpriseAdminEmail_JtextFocusGained

    private void deleteEnterpriseAdmin_JbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteEnterpriseAdmin_JbuttonActionPerformed
        // TODO add your handling code here:
        int selectedRow = manageEnterpriseAdmin_Jtable.getSelectedRow();
        
        int selectedEnt = enterprise_Jtable.getSelectedRow();
        selectedEnterprise = (Enterprise)enterprise_Jtable.getValueAt(selectedEnt,1);
        
        if (selectedRow>=0)
        {
            UserAccount ua = (UserAccount)manageEnterpriseAdmin_Jtable.getValueAt(selectedRow,0);
            ua.setIsActive(false);
            populateEnterpriseAdminTable(selectedEnterprise);
        }
        
    }//GEN-LAST:event_deleteEnterpriseAdmin_JbuttonActionPerformed

    private void enterpriseTypeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterpriseTypeComboBoxActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_enterpriseTypeComboBoxActionPerformed

    private void enterpriseTypeComboBoxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_enterpriseTypeComboBoxFocusGained
        // TODO add your handling code here:
        
        enterpriseTypeComboBox.removeItem("Please select enterprise type");
        enterpriseTypeComboBox.setForeground(Color.BLACK);
    }//GEN-LAST:event_enterpriseTypeComboBoxFocusGained

    private void enterpriseName_JtextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterpriseName_JtextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_enterpriseName_JtextActionPerformed

    private void enterpriseAdminName_JtextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterpriseAdminName_JtextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_enterpriseAdminName_JtextActionPerformed

    private void adminLastNameJtextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminLastNameJtextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_adminLastNameJtextActionPerformed

    private void adminLastNameJtextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_adminLastNameJtextFocusGained
        // TODO add your handling code here:
        
        if(adminLastNameJtext.getText().equalsIgnoreCase("Enter admin last name:"))
        {
        adminLastNameJtext.setText("");
        adminLastNameJtext.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_adminLastNameJtextFocusGained

    private void adminLastNameJtextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_adminLastNameJtextFocusLost
        // TODO add your handling code here:
        
        if(adminLastNameJtext.getText().equalsIgnoreCase(""))
        {
        adminLastNameJtext.setText("Enter admin last name:");
        adminLastNameJtext.setForeground(Color.LIGHT_GRAY);
        }
    }//GEN-LAST:event_adminLastNameJtextFocusLost

    private void manageProfileJbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageProfileJbuttonActionPerformed
        // TODO add your handling code here:
        
        ManageProfileJPanel manageProfileJPanel = new ManageProfileJPanel(userProcessContainer,userAccount);
        userProcessContainer.add("manageProfileJPanel",manageProfileJPanel);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageProfileJbuttonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addAdmin_Jbutton;
    private javax.swing.JButton addEnterprise_Jbutton;
    private javax.swing.JLabel addEnterprise_Jlabel;
    private javax.swing.JLayeredPane addNetwork_JPanel;
    private javax.swing.JButton addNetwork_Jbutton;
    private javax.swing.JLabel addNetwork_Jlabel;
    private javax.swing.JTextField adminLastNameJtext;
    private javax.swing.JButton deleteEnterpriseAdmin_Jbutton;
    private javax.swing.JTextField enterpriseAdminEmail_Jtext;
    private javax.swing.JTextField enterpriseAdminName_Jtext;
    private javax.swing.JLabel enterpriseNameValidatorJlabel;
    private javax.swing.JLabel enterpriseNameValidatorJlabel1;
    private javax.swing.JLabel enterpriseNameValidatorJlbl;
    private javax.swing.JLabel enterpriseNameValidatorJlbl1;
    private javax.swing.JTextField enterpriseName_Jtext;
    private javax.swing.JComboBox enterpriseTypeComboBox;
    private javax.swing.JLabel enterpriseTypeValidatorJlabel;
    private javax.swing.JTable enterprise_Jtable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLayeredPane manageEnterpriseAdmin_JPanel;
    private javax.swing.JButton manageEnterpriseAdmin_Jbutton;
    private javax.swing.JLabel manageEnterpriseAdmin_Jlabel;
    private javax.swing.JTable manageEnterpriseAdmin_Jtable;
    private javax.swing.JLabel manageNetwork_Jlabel;
    private javax.swing.JButton manageProfileJbutton;
    private javax.swing.JTextField networkName_Jtext;
    private javax.swing.JTree systemTree;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Employee.Employee;
import Business.Enterprise.DonationEnterprise;
import Business.Enterprise.Enterprise;
import Business.GovernmentEnterprise.Government;
import Business.GovernmentEnterprise.Region;
import Business.GovernmentEnterprise.Village;
import Business.LocalAgent.LocalAgent;
import Business.MobileEnterprise.MobileEnterprise;
import Business.Network.Network;
import Business.Network.Network.NetworkType;
import Business.Organization.Organization;
import Business.Person.Person;
import Business.Recipient.Recipient;
import Business.Role.AccountsManagerRole;
import Business.Role.BankAdmin;
import Business.Role.EnterpriseAdminRole;
import Business.Role.FieldStaffRole;
import Business.Role.GovernmentOfficialRole;
import Business.Role.LocalAgentRole;
import Business.Role.MobileEnterpriseAdminRole;
import Business.Role.RecipientRole;
import Business.Role.SeniorStaffRole;
import Business.Role.SystemAdmin;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.WorkQueue;

/**
 *
 * @author raunak
 */
public class ConfigureABusiness {
    
    public static Business configure(){
        
        Business business = Business.getInstance();
        
        Ecosystem system = new Ecosystem("ERADICATE POVERTY","SYSTEM",Network.NetworkType.GLOBAL.getValue());
        business.setSystemOrg(system);
        Employee employee = system.getEmployeeDirectory().createEmployee("Ankit Kothari");
        UserAccount ua = system.getUserAccountDirectory().createUserAccount("sysadmin@gmail.com","sysadmin", employee,new SystemAdmin());
        ua.setIsActive(true);
        DonationEnterprise rootDonationEnterprise=null;
        Enterprise rootEnterprise = system.getRootNetwork().getEnterpriseDirectory().addEnterprise("Eradicate Poverty",Enterprise.EnterpriseType.DONATION);
        if(rootEnterprise instanceof DonationEnterprise)
        {
            rootDonationEnterprise = (DonationEnterprise)rootEnterprise;
        }
        
        //rootDonationEnterprise.getLocalEnterpriseBankAccount().setAccountNumber();
        
        Network countryNetwork = system.getRootNetwork().getSubNetworkDirectory().createAndAddNetwork("USA",NetworkType.COUNTRY.getValue());
        Enterprise enterprise1 = countryNetwork.getEnterpriseDirectory().addEnterprise("EP-USA",Enterprise.EnterpriseType.DONATION);
        Enterprise government = countryNetwork.getEnterpriseDirectory().addEnterprise("GOV-USA",Enterprise.EnterpriseType.GOVERNMENT);
        DonationEnterprise donationEnterprise = (DonationEnterprise)enterprise1;
        donationEnterprise.getAssociatedEnterprise().add(government);
        
        
        //create region and village
       Government governmentEnterprise=(Government)government;
       governmentEnterprise.setCountryName("USA");
       Region region=governmentEnterprise.getRegionDirectory().addRegion();
       
       region.setRegionName("MA");
       
       Village village=region.addVillage("BOSTON",100,20);
       Village village2=region.addVillage("NEW HAMPSHIRE",100,20);
       WorkQueue workQueue = new WorkQueue();
       workQueue.setRegion(region);
       donationEnterprise.getWorkQueueList().add(workQueue);
       
       
       //Create enrollment organization,senior staff
       
        Organization organization = enterprise1.getOrganizationDirectory().createOrganization("EP-USA-ENROLLMENT",Organization.Type.ENROLLMENT);
        Employee employeeSeniorStaff = organization.getEmployeeDirectory().createEmployee("ankitkothari2889@gmail.com");
        UserAccount userAccountSeniorStaff = organization.getUserAccountDirectory().createUserAccount("senior","senior",employeeSeniorStaff,new SeniorStaffRole());
        Employee employeeFieldStaff = organization.getEmployeeDirectory().createEmployee("ankitkothari420@gmail.com");
        UserAccount userAccountFieldStaff = organization.getUserAccountDirectory().createUserAccount("field","field",employeeFieldStaff,new FieldStaffRole());
        
        //create finance org and accounts manager
        Organization accountOrganization = enterprise1.getOrganizationDirectory().createOrganization("EP-USA-ACCOUNTS",Organization.Type.ACCOUNTS);
        Employee employeeAccountManager = organization.getEmployeeDirectory().createEmployee("ankitkothari2889@gmail.com");
        UserAccount userAccountAccountManager = organization.getUserAccountDirectory().createUserAccount("fin","org",employeeAccountManager,new AccountsManagerRole());

        
        
        Employee e = system.getEmployeeDirectory().createEmployee("PR");
        UserAccount userAccount= enterprise1.getUserAccountDirectory().createUserAccount("ent1","ent",e,new EnterpriseAdminRole());
        
      // government admin  
        Employee e1 = system.getEmployeeDirectory().createEmployee("Deepak Kataria");
        UserAccount userAccount1= government.getUserAccountDirectory().createUserAccount("gov","gov",e1,new GovernmentOfficialRole());
        
        //mobile enterprise admin
        Enterprise mobileEnt = countryNetwork.getEnterpriseDirectory().addEnterprise("M-PESA",Enterprise.EnterpriseType.MOBILE);
        Employee mE = system.getEmployeeDirectory().createEmployee("PR");
        UserAccount userAccountME= mobileEnt.getUserAccountDirectory().createUserAccount("mob","mob",mE,new MobileEnterpriseAdminRole());
        donationEnterprise.getAssociatedEnterprise().add(mobileEnt);
        MobileEnterprise mobileEnterprise;
       
        if(mobileEnt instanceof MobileEnterprise)
        {
            mobileEnterprise = (MobileEnterprise)mobileEnt;
            LocalAgent localAgent = mobileEnterprise.getLocalAgentDirectory().addLocalAgent("ankit@gm.com");
            localAgent.setAgentRegion(region);
            
            localAgent.setAgentVillage(village);
            UserAccount userAccountLocalAgent = mobileEnterprise.getUserAccountDirectory().createUserAccount("l1","l1",localAgent,new LocalAgentRole());
            localAgent.setUserAccount(userAccountLocalAgent);
            localAgent.setAgentFirstName("L1");
            localAgent.setAgentLastName("L2");
            
            village.getLocalAgent().add(localAgent);
            
            LocalAgent localAgent11 = mobileEnterprise.getLocalAgentDirectory().addLocalAgent("ank@gm.com");
            localAgent11.setAgentRegion(region);
            localAgent11.setAgentVillage(village);
            UserAccount userAccountLocalAgent11 = mobileEnterprise.getUserAccountDirectory().createUserAccount("l11","l11",localAgent11,new LocalAgentRole());
            localAgent11.setAgentRegion(region);
            localAgent11.setUserAccount(userAccountLocalAgent11);
             localAgent11.setAgentFirstName("L11");
            localAgent11.setAgentLastName("L12");
            village.getLocalAgent().add(localAgent11);
            
            LocalAgent localAgent12 = mobileEnterprise.getLocalAgentDirectory().addLocalAgent("an@gm.com");
            localAgent12.setAgentRegion(region);
            localAgent12.setAgentVillage(village2);
            UserAccount userAccountLocalAgent12 = mobileEnterprise.getUserAccountDirectory().createUserAccount("l12","l12",localAgent12,new LocalAgentRole());
            localAgent12.setAgentRegion(region);
            localAgent12.setUserAccount(userAccountLocalAgent12);
             localAgent12.setAgentFirstName("L12");
            localAgent12.setAgentLastName("L22");
            village.getLocalAgent().add(localAgent12);
            
            
        
        }  
        
        
        // create recipient
           
           
           
//           Recipient recipient1=null;
//           Person person1 = new Recipient(); 
//           enterprise1.getPersonDirectory().addPerson(person1);
//           UserAccount recipientUserAccount1 = enterprise1.getUserAccountDirectory().createUserAccount("18572659580","1234",person1, new RecipientRole());
//           if(person instanceof Recipient)
//             recipient1 =(Recipient)person1;
//           recipient1.setMpin("123");
//           recipient1.setStartKey("EP");
//           village.getRecipientList().add(recipient1);
//           recipient1.setUserAccount(recipientUserAccount1);
//           recipient1.setUniqueId("123");
           
//           
//           Recipient recipient2=null;
//           Person person2 = new Recipient(); 
//           enterprise1.getPersonDirectory().addPerson(person2);
//           UserAccount recipientUserAccount2 = enterprise1.getUserAccountDirectory().createUserAccount("9704","1234",person2, new RecipientRole());
//           if(person instanceof Recipient)
//             recipient2 =(Recipient)person2;
//           recipient2.setMpin("123");
//           recipient2.setStartKey("EP");
//           village.getRecipientList().add(recipient2);
//           recipient2.setUserAccount(recipientUserAccount2);
//           recipient2.setUniqueId("123");
           
                
      
        //bank enterprise and bank enterprise admin
        
        Enterprise bankEnterprise = countryNetwork.getEnterpriseDirectory().addEnterprise("CITIBANK",Enterprise.EnterpriseType.BANK);
        donationEnterprise.getAssociatedEnterprise().add(bankEnterprise);
        Employee bankAdmin = bankEnterprise.getEmployeeDirectory().createEmployee("citi@gmail.com");
       // UserAccount userAccountBankAdmin = bankEnterprise.getUserAccountDirectory().createUserAccount("citi","citi",bankAdmin,new BankAdmin());
        return business;
        
        
        
    }
    
}

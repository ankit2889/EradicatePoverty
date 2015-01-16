/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.LocalAgent;

import Business.Bank.SavingsAccount;
import Business.GovernmentEnterprise.Region;
import Business.GovernmentEnterprise.Village;
import Business.Person.Person;
import Business.Recipient.Recipient;
import Business.Transaction.TransactionDirectory;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author JJPL
 */
public class LocalAgent extends Person {
    private String outletName;
    private String outletType;
    private String yearEstablishment;
    private String certificatePath;
    private String agentFirstName;
    private String agentLastName;
    private String idType;
    private String idNumber;
    private Region agentRegion;
    private Village agentVillage;
    private TransactionDirectory agentTransactionsList;
    private SavingsAccount savingsAccount;
    private Date lastPaymentDate;
    private ArrayList<Recipient> agentRecipientList;
    
    
    public LocalAgent()
    {
        super();
        this.savingsAccount = new SavingsAccount();
        this.agentRecipientList=new ArrayList<>();
        this.agentTransactionsList = new TransactionDirectory();
    }

    public String getOutletName() {
        return outletName;
    }

    public void setOutletName(String outletName) {
        this.outletName = outletName;
    }

    public String getOutletType() {
        return outletType;
    }

    public void setOutletType(String outletType) {
        this.outletType = outletType;
    }

    public String getYearEstablishment() {
        return yearEstablishment;
    }

    public void setYearEstablishment(String yearEstablishment) {
        this.yearEstablishment = yearEstablishment;
    }

    public String getCertificatePath() {
        return certificatePath;
    }

    public void setCertificatePath(String certificatePath) {
        this.certificatePath = certificatePath;
    }

    public String getAgentFirstName() {
        return agentFirstName;
    }

    public void setAgentFirstName(String agentFirstName) {
        this.agentFirstName = agentFirstName;
    }

    public String getAgentLastName() {
        return agentLastName;
    }

    public void setAgentLastName(String agentLastName) {
        this.agentLastName = agentLastName;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public Region getAgentRegion() {
        return agentRegion;
    }

    public void setAgentRegion(Region agentRegion) {
        this.agentRegion = agentRegion;
    }

    public Village getAgentVillage() {
        return agentVillage;
    }

    public void setAgentVillage(Village agentVillage) {
        this.agentVillage = agentVillage;
    }

    public TransactionDirectory getAgentTransactionsList() {
        return agentTransactionsList;
    }

    public void setAgentTransactionsList(TransactionDirectory agentTransactionsList) {
        this.agentTransactionsList = agentTransactionsList;
    }

    

    public SavingsAccount getSavingsAccount() {
        return savingsAccount;
    }

    public void setSavingsAccount(SavingsAccount savingsAccount) {
        this.savingsAccount = savingsAccount;
    }

    public Date getLastPaymentDate() {
        return lastPaymentDate;
    }

    public void setLastPaymentDate(Date lastPaymentDate) {
        this.lastPaymentDate = lastPaymentDate;
    }

    public ArrayList<Recipient> getAgentRecipientList() {
        return agentRecipientList;
    }

    public void setAgentRecipientList(ArrayList<Recipient> agentRecipientList) {
        this.agentRecipientList = agentRecipientList;
    }

  public String toString()
  {
      return agentFirstName+""+agentLastName;
  }
    
}

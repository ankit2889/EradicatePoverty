/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.WorkQueue;

import Business.GovernmentEnterprise.Region;
import Business.GovernmentEnterprise.Village;

/**
 *
 * @author JJPL
 */
public class AgentRegistrationWorkRequest extends WorkRequest {
    
    private String outletName;
    private String outletType;
    private String yearEstablishment;
    private String certificatePath;
    private String agentFirstName;
    private String agentLastName;
    private String idType;
    private String idNumber;
    private String emailAddress;
    private Region agentRegion;
    private Village agentVillage;
    
    public AgentRegistrationWorkRequest()
    {
        super();
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

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
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
    
    @Override
  public String toString()
  {
      return agentFirstName+" "+agentLastName;
  }
    
    
}

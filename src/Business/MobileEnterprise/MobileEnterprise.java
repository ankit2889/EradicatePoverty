/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.MobileEnterprise;

import Business.Enterprise.Enterprise;
import Business.LocalAgent.LocalAgentDirectory;
import Business.MobileEnterprise.Mobile;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author JJPL
 */
public class MobileEnterprise extends Enterprise {
    
    private ArrayList<Mobile> mobileList;
    private LocalAgentDirectory localAgentDirectory;
   
    
    
    public MobileEnterprise (String name,EnterpriseType type)
    {
        super(name,type.MOBILE);
        this.mobileList = new ArrayList<>();
        this.localAgentDirectory=new LocalAgentDirectory();
    }

    public ArrayList<Mobile> getMobileList() {
        return mobileList;
    }

    public void setMobileList(ArrayList<Mobile> mobileList) {
        this.mobileList = mobileList;
    }

    public LocalAgentDirectory getLocalAgentDirectory() {
        return localAgentDirectory;
    }

    public void setLocalAgentDirectory(LocalAgentDirectory localAgentDirectory) {
        this.localAgentDirectory = localAgentDirectory;
    }

    
    
    public Mobile addMobile()
    {
        Mobile mobile = new Mobile();
        mobileList.add(mobile);
        return mobile;
    }
    
    public Mobile trackMobile(int imeiNo)
    {
        for (Mobile mobile:mobileList)
        {
            if (mobile.getImeiNo()==imeiNo)
                return mobile;
        }
   
     return null;
    }
   
    
     public ArrayList<Role> getSupportedRole() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
     
      
}

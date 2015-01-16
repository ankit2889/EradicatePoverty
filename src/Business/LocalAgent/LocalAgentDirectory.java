/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.LocalAgent;

import java.util.ArrayList;

/**
 *
 * @author JJPL
 */
public class LocalAgentDirectory {
    
    private ArrayList<LocalAgent> localAgentList;
    
    public LocalAgentDirectory()
    {
        this.localAgentList = new ArrayList<>();
    }

    public ArrayList<LocalAgent> getLocalAgentList() {
        return localAgentList;
    }

    public void setLocalAgentList(ArrayList<LocalAgent> localAgentList) {
        this.localAgentList = localAgentList;
    }
    
    public LocalAgent addLocalAgent(String emailId)
    {
     LocalAgent newlocalAgent =new LocalAgent();
     newlocalAgent.setEmailId(emailId);
     localAgentList.add(newlocalAgent);
     return newlocalAgent;
                
          
    }
    
   
    
}

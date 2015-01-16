/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.GovernmentEnterprise;

import Business.LocalAgent.LocalAgent;
import Business.Recipient.Recipient;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**
 *
 * @author JJPL
 */
public class Village {
    
    private String villageName;
    private int villageCode;
    private int villageBPL;
    private int percentPersonsBPL;
    private ArrayList <Recipient>recipientList;
    private ArrayList<LocalAgent>localAgent;
    
    private static int count=0;
    public Village()
    {
        this.recipientList = new ArrayList<>();
        count++;
        this.villageCode=count;
        this.localAgent = new ArrayList<>();
    }

    public int getVillageCode() {
        return villageCode;
    }

    public void setVillageCode(int villageCode) {
        this.villageCode = villageCode;
    }

    public int getVillageBPL() {
        return villageBPL;
    }

    public void setVillageBPL(int villageBPL) {
        this.villageBPL = villageBPL;
    }

    public int getPercentPersonsBPL() {
        return percentPersonsBPL;
    }

    public void setPercentPersonsBPL(int percentPersonsBPL) {
        this.percentPersonsBPL = percentPersonsBPL;
    }
    
    
    

    public String getVillageName() {
        return villageName;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName;
    }

    public ArrayList<Recipient> getRecipientList() {
        return recipientList;
    }

    public void setRecipientList(ArrayList<Recipient> recipientList) {
        this.recipientList = recipientList;
    }
    
    public Recipient addRecipient(String dailyIncome)
    {
        Recipient recipient = new Recipient();
        recipientList.add(recipient);
        if(dailyIncome.equalsIgnoreCase("Below 10$"))
                recipient.setRecipientClass(0);
         if(dailyIncome.equalsIgnoreCase("10$-30$"))
                recipient.setRecipientClass(1);
          if(dailyIncome.equalsIgnoreCase("30$-50$"))
                recipient.setRecipientClass(2);
           if(dailyIncome.equalsIgnoreCase("50$-100$"))
                recipient.setRecipientClass(3);
           if(dailyIncome.equalsIgnoreCase("Above 100$"))
                recipient.setRecipientClass(4);
         Collections.sort(recipientList,new Comparator<Recipient>(){
           @Override public int compare(Recipient r1,Recipient r2) {
            return r1.getRecipientClass()-r2.getRecipientClass();
        }});
         
         return recipient;
    }
    
    @Override
    public String toString()
    {
        return villageName;
    }

    public ArrayList<LocalAgent> getLocalAgent() {
        return localAgent;
    }

    public void setLocalAgent(ArrayList<LocalAgent> localAgent) {
        this.localAgent = localAgent;
    }
    
    
    
    
}

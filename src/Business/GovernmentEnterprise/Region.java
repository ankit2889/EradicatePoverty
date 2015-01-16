/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.GovernmentEnterprise;

import java.util.ArrayList;

/**
 *
 * @author JJPL
 */
public class Region {
    
    private String regionName;
    private ArrayList <Village> villageList;
    private int totalVillageBPL;
    
    public Region ()
    {
        this.villageList = new ArrayList<Village>();
        
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public ArrayList<Village> getVillageList() {
        return villageList;
    }

    public void setVillageList(ArrayList<Village> villageList) {
        this.villageList = villageList;
    }
    
    public Village addVillage (String name,int villageBPL,int percentPersonBPL)
    {
        Village village = new Village();
        villageList.add(village);
        village.setVillageName(name);
        village.setVillageBPL(villageBPL);
        village.setPercentPersonsBPL(percentPersonBPL);
        return village;
    }
    
    
    public boolean checkUniqueVillage(String villageName)
    {
        for(Village village:villageList)
        {
            if(village.getVillageName().equalsIgnoreCase(villageName))
            {
                return false;
            }
        }
    return true;
    }
    
    
    @Override
    public String toString()
    {
        return regionName;
    }
    
    
    public int noOfRecipients()
    {
        int noOfRecipients=0;
    
    for(Village village:villageList)
    {
        noOfRecipients+= village.getRecipientList().size();
    }
    
    return noOfRecipients;
}

    public void setTotalVillageBPL() {
        
        int totalSum=0;
        for(Village village:villageList)
        {
            totalSum+=village.getVillageBPL();
        }
        totalVillageBPL=totalSum;
        
    }

   
    public int getTotalVillageBPL()
    {
        return totalVillageBPL;
    }
  
    
}
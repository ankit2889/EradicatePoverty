/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.GovernmentEnterprise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author JJPL
 */
public class RegionDirectory {
    
    private ArrayList<Region> regionList;
    
    public RegionDirectory()
    {
        this.regionList = new ArrayList<>();
    }

    public ArrayList<Region> getRegionList() {
        return regionList;
    }

    public void setRegionList(ArrayList<Region> regionList) {
        this.regionList = regionList;
    }
    
    public Region addRegion()
    {
       Region newregion = new Region();
       regionList.add(newregion);
       Collections.sort(regionList,new Comparator<Region>(){
           @Override public int compare(Region r1,Region r2) {
            return r1.getTotalVillageBPL()-r2.getTotalVillageBPL();
        }});
       
       
       return newregion;
        
    }
    
    
    public boolean checkUniqueRegion(String regionName)
    {
        for(Region region:regionList)
       {
           if(region.getRegionName().equalsIgnoreCase(regionName))
           {
                return false;
           }
   
    }return true;
    }
 
    
}

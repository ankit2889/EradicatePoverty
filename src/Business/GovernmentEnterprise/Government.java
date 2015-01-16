/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.GovernmentEnterprise;

import Business.Enterprise.Enterprise;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author JJPL
 */
public class Government extends Enterprise {
    
    private ArrayList <Region> regionList;
    private String countryName;
    public Government (String name,EnterpriseType type)
    {
        super(name,type.GOVERNMENT);
        this.regionDirectory = new RegionDirectory();
        this.regionList = new ArrayList<>();
    }
    
    private RegionDirectory regionDirectory;

    public RegionDirectory getRegionDirectory() {
        return regionDirectory;
    }

    public void setRegionDirectory(RegionDirectory regionDirectory) {
        this.regionDirectory = regionDirectory;
    }
    
    
   
     public ArrayList<Role> getSupportedRole() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<Region> getRegionList() {
        return regionList;
    }

    public void setRegionList(ArrayList<Region> regionList) {
        this.regionList = regionList;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
    
    
}

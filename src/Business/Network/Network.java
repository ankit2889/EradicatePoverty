/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Network;

import Business.Enterprise.EnterpriseDirectory;
import Business.Organization.Organization;
import Business.Role.NetworkAdminRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author JJPL
 */
public class Network  {
    
    private String name;
    private EnterpriseDirectory enterpriseDirectory;
    private static int count=0;
    private int networkId;
    private String networkType;
    private NetworkDirectory subNetworkDirectory;
    

    public enum NetworkType {
    
        GLOBAL("Global Network"),
        COUNTRY("Country Network"),
        STATE("State Network"),
        CITY("City Network");
        
        public String value;
        
        private NetworkType(String value)
        {
            this.value = value;
        }
        
        @Override
        public String toString()
        {
            return value;
        }
        
        public String getValue()
        {
            return value;
        }
        
        
        
    
    }
    
    
    public Network(String name,String type) {
        this.name=name;
        this.networkType=type;
        this.enterpriseDirectory = new EnterpriseDirectory();
        networkId = count++;
        this.subNetworkDirectory = new NetworkDirectory();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    

    public EnterpriseDirectory getEnterpriseDirectory() {
        return enterpriseDirectory;
    }

    public void setEnterpriseDirectory(EnterpriseDirectory enterpriseDirectory) {
        this.enterpriseDirectory = enterpriseDirectory;
    }

    public String getNetworkType() {
        return networkType;
    }

    public void setNetworkType(String networkType) {
        this.networkType = networkType;
    }

    public NetworkDirectory getSubNetworkDirectory() {
        return subNetworkDirectory;
    }

    public void setSubNetworkDirectory(NetworkDirectory subNetworkDirectory) {
        this.subNetworkDirectory = subNetworkDirectory;
    }

    
    
    @Override
    public String toString()
    {
        return name;
    }
    
    
    
    
//    public ArrayList<Role> getSupportedRole() {
//        ArrayList<Role> roles = new ArrayList<>();
//        roles.add(new NetworkAdminRole());
//        return roles;
//    }
//    
//    

    public int getNetworkId() {
        return networkId;
    }

    public void setNetworkId(int networkId) {
        this.networkId = networkId;
    }
    
    
    public Network findCountryNetwork(String countryName)
    {
         Network rootNetwork=this;
        for(Network countryNetwork:rootNetwork.getSubNetworkDirectory().getNetworkList())
        {
            if(countryNetwork.getName().equalsIgnoreCase(countryName))
            return countryNetwork;
        }
        return null;
    }
    
    public Network findStateNetwork(String countryName, String stateName)
    {
        Network rootNetwork=this;
        for(Network countryNetwork:rootNetwork.getSubNetworkDirectory().getNetworkList())
        {
            for(Network stateNetwork:countryNetwork.getSubNetworkDirectory().getNetworkList())
            {
                if(countryNetwork.getName().equalsIgnoreCase(countryName) && stateNetwork.getName().equalsIgnoreCase(stateName))
                {
                    return stateNetwork;
                }   
            }
        }
        return null;
    }
    
    
    public Network findCityNetwork(String countryName, String stateName, String cityName)
    {
        Network rootNetwork=this;
        for(Network countryNetwork:rootNetwork.getSubNetworkDirectory().getNetworkList())
        {
            for(Network stateNetwork:countryNetwork.getSubNetworkDirectory().getNetworkList())
            {
                for(Network cityNetwork:stateNetwork.getSubNetworkDirectory().getNetworkList())
                {
                    if(countryNetwork.getName().equalsIgnoreCase(countryName) && stateNetwork.getName().equalsIgnoreCase(stateName)&& cityNetwork.getName().equalsIgnoreCase(cityName))
                    {
                        return cityNetwork;
                    }   
                }
            }
        }
        return null;
    }
}

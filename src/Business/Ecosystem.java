/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business;

import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Network.NetworkDirectory;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.Role.SystemAdmin;
import java.util.ArrayList;

/**
 *
 * @author JJPL
 */
public class Ecosystem extends Organization {

    private static Ecosystem business;
    private NetworkDirectory networkDirectory;
    private Network rootNetwork;
    
    
    
    public Ecosystem(String systemName,String networkName,String networkType)
    {
        super(systemName,"SYSTEM");
        rootNetwork = new Network(networkName,networkType);
        this.networkDirectory = new NetworkDirectory();
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList <Role> roleList = new ArrayList<>();
        roleList.add(new SystemAdmin());
        return roleList;
    }

    public NetworkDirectory getNetworkDirectory() {
        return networkDirectory;
    }

    public void setNetworkDirectory(NetworkDirectory networkDirectory) {
        this.networkDirectory = networkDirectory;
    }

    
    public boolean checkUserNamePresent(String emailId)
    {
        for(Network network:getAllNetwork())
        {
            if(network.getEnterpriseDirectory().checkUserNamePresent(emailId))
                return true;
        }
        return false;
    }
    
    
    
    

    public Network getRootNetwork() {
        return rootNetwork;
    }

    public void setRootNetwork(Network rootNetwork) {
        this.rootNetwork = rootNetwork;
    }
    

    public ArrayList<Network> getAllNetwork()
    {
        
        ArrayList<Network> finalNetworkList=new ArrayList<>();
        finalNetworkList.add(rootNetwork);
        for(Network country: rootNetwork.getSubNetworkDirectory().getNetworkList())
        {
           finalNetworkList.add(country);
            for(Network state:country.getSubNetworkDirectory().getNetworkList())
            {
               finalNetworkList.add(state);
                for(Network city: state.getSubNetworkDirectory().getNetworkList())
                {
                    finalNetworkList.add(city);
                }
            }
        }
        return finalNetworkList;
}
    
    
}



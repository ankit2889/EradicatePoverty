/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Network;

import Business.Network.Network.NetworkType;
import java.util.ArrayList;

/**
 *
 * @author JJPL
 */
public class NetworkDirectory {
    
    private ArrayList<Network> networkList;
    
    public NetworkDirectory()
    {
        this.networkList = new ArrayList<>();
    }

    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    public void setNetworkList(ArrayList<Network> networkList) {
        this.networkList = networkList;
    }
    
    
    public Network createAndAddNetwork(String name,String networkType)
    {
        Network network = new Network(name,networkType);
        networkList.add(network);
        return network;
    }
    
    public boolean checkifNetworkIsUnique(String name)
    {
        for (Network network:networkList)
        {
            if (network.getName().equals(name))
            {
                return false;
            }
        }
    return true;
    
    }
    
    
    public void removeNetwork(Network network)
    {
        networkList.remove(network);
    }
    
    public Network getNetwork(String name)
    {
        for (Network network:networkList)
        {
            if(network.getName().equalsIgnoreCase(name))
            {
                return network;
            }
        }
    return null;
    }
   
    
    public boolean isPresent(Network network)
    {
        for(Network net:networkList)
        {
            if(net==network)
            {
                return true;
            }
        }
        return false;
    }
    

public boolean isPresent(String networkName)
    {
        for(Network network:networkList)
        {
            if(network.getName().equalsIgnoreCase(networkName))
            {
                return true;
            }
        }
        return false;
    }

}

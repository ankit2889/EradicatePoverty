/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package userInterface.Donor;

import Business.LocalAgent.LocalAgent;
import java.util.Comparator;

/**
 *
 * @author JJPL
 */
public class LocalAgentComparator implements Comparator<LocalAgent>{

    @Override
    public int compare(LocalAgent l1,LocalAgent l2) {
        
        if(l1.getLastPaymentDate().after(l2.getLastPaymentDate()))
            return -1;
       if(l1.getLastPaymentDate().before(l2.getLastPaymentDate()))
            return 1;
        
        return 0;
    }
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Donor;

import Business.Donor.Donor.DonorType;
import java.util.ArrayList;

/**
 *
 * @author JJPL
 */
public class DonorDirectory {
    
    
    private ArrayList<DonorPerson>donorList;
    
   public DonorDirectory()
   {
       this.donorList = new ArrayList<>();
   }

    public ArrayList<DonorPerson> getDonorList() {
        return donorList;
    }

    public void setDonorList(ArrayList<DonorPerson> donorList) {
        this.donorList = donorList;
    }
   
   
    
}

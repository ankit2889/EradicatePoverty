/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Recipient;

import Business.Bank.SavingsAccount;
import Business.LocalAgent.LocalAgent;
import Business.Person.Person;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author JJPL
 */
public class Recipient extends Person{
    
    private RecipientLocation location;
    private Profile profile;
    private String noOfMemebers;
    private String noOfRooms;
    private String noOfAdults;
    private String noOfChildren;
    private String mpin;
    private String startKey;
    private SavingsAccount mobileAccount;
    private Date registeredDate;
    private int recipientClass;
    private ArrayList<LocalAgent> assignedLocalAgent;
   
    

    public String getNoOfChildren() {
        return noOfChildren;
    }

    public void setNoOfChildren(String noOfChildren) {
        this.noOfChildren = noOfChildren;
    }
    
    
    
    public Recipient ()
    {
        this.location = new RecipientLocation();
        this.profile = new Profile();
        this.mobileAccount = new SavingsAccount();
        this.registeredDate = new Date();
        this.assignedLocalAgent = new ArrayList<>();
    }

    public RecipientLocation getLocation() {
        return location;
    }

    public void setLocation(RecipientLocation location) {
        this.location = location;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    
    
    public String getNoOfMemebers() {
        return noOfMemebers;
    }

    public void setNoOfMemebers(String noOfMemebers) {
        this.noOfMemebers = noOfMemebers;
    }

    public String getNoOfRooms() {
        return noOfRooms;
    }

    public void setNoOfRooms(String noOfRooms) {
        this.noOfRooms = noOfRooms;
    }

    public String getNoOfAdults() {
        return noOfAdults;
    }

    public void setNoOfAdults(String noOfAdults) {
        this.noOfAdults = noOfAdults;
    }

    public String getMpin() {
        return mpin;
    }

    public void setMpin(String mpin) {
        this.mpin = mpin;
    }

    public String getStartKey() {
        return startKey;
    }

    public void setStartKey(String startKey) {
        this.startKey = startKey;
    }

    public SavingsAccount getMobileAccount() {
        return mobileAccount;
    }

    public void setMobileAccount(SavingsAccount mobileAccount) {
        this.mobileAccount = mobileAccount;
    }

    public Date getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(Date registeredDate) {
        this.registeredDate = registeredDate;
    }

    public int getRecipientClass() {
        return recipientClass;
    }

    public void setRecipientClass(int recipientClass) {
        this.recipientClass = recipientClass;
    }

    public ArrayList<LocalAgent> getAssignedLocalAgent() {
        return assignedLocalAgent;
    }

    public void setAssignedLocalAgent(ArrayList<LocalAgent> assignedLocalAgent) {
        this.assignedLocalAgent = assignedLocalAgent;
    }
    
    
    
}

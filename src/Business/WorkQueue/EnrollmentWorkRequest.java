/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.WorkQueue;

import Business.GovernmentEnterprise.Village;
import Business.Recipient.RecipientLocation;
import Business.UserAccount.UserAccount;
import java.util.Date;

/**
 *
 * @author JJPL
 */
public class EnrollmentWorkRequest extends WorkRequest{
    
    private String headFirstName;
    private String headMiddleName;
    private String headLastName;
    private String headGender;
    private String headMaritalStatus;
    private String educationStatus;
    private String schoolName;
    private String schoolDetails;
    private String employmentStatus;
    private String employerName;
    private String employerDetails;
    private String dailyIncome;
    private boolean phonePresent;
    private String cellPhoneNo;
    private String noOfMembers;
    private String noOfAdults;
    private String noOfChildren;
    private String spouseName;
    private String districtName;
    private Village villageName;
    private String mudHome;
    private String homeImagePath;
    private int fieldStaffId;
    private UserAccount userIdFieldStaff;
    private UserAccount userIdSeniorStaff;
    private UserAccount userIdResearchManager;
    private RecipientLocation location;
    private String streetName;
    private String nearByLandMark;
    private Date birthDate;
    private String idNo;
    private String idType;
    
    public EnrollmentWorkRequest()
    {
        super();
        this.location=new RecipientLocation();
    }

    public String getHeadFirstName() {
        return headFirstName;
    }

    public void setHeadFirstName(String headFirstName) {
        this.headFirstName = headFirstName;
    }

    public String getHeadMiddleName() {
        return headMiddleName;
    }

    public void setHeadMiddleName(String headMiddleName) {
        this.headMiddleName = headMiddleName;
    }

    public String getHeadLastName() {
        return headLastName;
    }

    public void setHeadLastName(String headLastName) {
        this.headLastName = headLastName;
    }

    public String getHeadGender() {
        return headGender;
    }

    public void setHeadGender(String headGender) {
        this.headGender = headGender;
    }

    public String getHeadMaritalStatus() {
        return headMaritalStatus;
    }

    public void setHeadMaritalStatus(String headMaritalStatus) {
        this.headMaritalStatus = headMaritalStatus;
    }

    public String getEducationStatus() {
        return educationStatus;
    }

    public void setEducationStatus(String educationStatus) {
        this.educationStatus = educationStatus;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolDetails() {
        return schoolDetails;
    }

    public void setSchoolDetails(String schoolDetails) {
        this.schoolDetails = schoolDetails;
    }

    public String getEmploymentStatus() {
        return employmentStatus;
    }

    public void setEmploymentStatus(String employmentStatus) {
        this.employmentStatus = employmentStatus;
    }

    public String getEmployerName() {
        return employerName;
    }

    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }

    public String getEmployerDetails() {
        return employerDetails;
    }

    public void setEmployerDetails(String employerDetails) {
        this.employerDetails = employerDetails;
    }

    public String getDailyIncome() {
        return dailyIncome;
    }

    public void setDailyIncome(String dailyIncome) {
        this.dailyIncome = dailyIncome;
    }

    public boolean isPhonePresent() {
        return phonePresent;
    }

    public void setPhonePresent(boolean phonePresent) {
        this.phonePresent = phonePresent;
    }

    public String getCellPhoneNo() {
        return cellPhoneNo;
    }

    public void setCellPhoneNo(String cellPhoneNo) {
        this.cellPhoneNo = cellPhoneNo;
    }

    public String getNoOfMembers() {
        return noOfMembers;
    }

    public void setNoOfMembers(String noOfMembers) {
        this.noOfMembers = noOfMembers;
    }

    public String getNoOfAdults() {
        return noOfAdults;
    }

    public void setNoOfAdults(String noOfAdults) {
        this.noOfAdults = noOfAdults;
    }

    public String getNoOfChildren() {
        return noOfChildren;
    }

    public void setNoOfChildren(String noOfChildren) {
        this.noOfChildren = noOfChildren;
    }

    public String getSpouseName() {
        return spouseName;
    }

    public void setSpouseName(String spouseName) {
        this.spouseName = spouseName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public Village getVillageName() {
        return villageName;
    }

    public void setVillageName(Village villageName) {
        this.villageName = villageName;
    }

    public String isMudHome() {
        return mudHome;
    }

    public void setMudHome(String mudHome) {
        this.mudHome = mudHome;
    }

    public String getHomeImagePath() {
        return homeImagePath;
    }

    public void setHomeImagePath(String homeImagePath) {
        this.homeImagePath = homeImagePath;
    }

    public int getFieldStaffId() {
        return fieldStaffId;
    }

    public void setFieldStaffId(int fieldStaffId) {
        this.fieldStaffId = fieldStaffId;
    }

    public UserAccount getUserIdFieldStaff() {
        return userIdFieldStaff;
    }

    public void setUserIdFieldStaff(UserAccount userIdFieldStaff) {
        this.userIdFieldStaff = userIdFieldStaff;
    }

    public UserAccount getUserIdSeniorStaff() {
        return userIdSeniorStaff;
    }

    public void setUserIdSeniorStaff(UserAccount userIdSeniorStaff) {
        this.userIdSeniorStaff = userIdSeniorStaff;
    }

    public UserAccount getUserIdResearchManager() {
        return userIdResearchManager;
    }

    public void setUserIdResearchManager(UserAccount userIdResearchManager) {
        this.userIdResearchManager = userIdResearchManager;
    }

    public RecipientLocation getLocation() {
        return location;
    }

    public void setLocation(RecipientLocation location) {
        this.location = location;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getNearByLandMark() {
        return nearByLandMark;
    }

    public void setNearByLandMark(String nearByLandMark) {
        this.nearByLandMark = nearByLandMark;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }
    
    
    
}

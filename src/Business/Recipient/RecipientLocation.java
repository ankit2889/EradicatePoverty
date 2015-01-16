/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Recipient;

import Business.GovernmentEnterprise.Village;

/**
 *
 * @author JJPL
 */

public class RecipientLocation {
 
    private double lattitude;
    private double longitude;
    private double altitude;
    private double accuracy;
    private boolean mud_thatch_home;
    private String districtName;
    private Village villageName;
    private String streetName;
    private String nearByLandmark;
    private String homeImage;

    public String getHomeImage() {
        return homeImage;
    }

    public void setHomeImage(String homeImage) {
        this.homeImage = homeImage;
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
    
    

    public double getLattitude() {
        return lattitude;
    }

    public void setLattitude(double lattitude) {
        this.lattitude = lattitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }

    public boolean isMud_thatch_home() {
        return mud_thatch_home;
    }

    public void setMud_thatch_home(boolean mud_thatch_home) {
        this.mud_thatch_home = mud_thatch_home;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getNearByLandmark() {
        return nearByLandmark;
    }

    public void setNearByLandmark(String nearByLandmark) {
        this.nearByLandmark = nearByLandmark;
    }
    
    
    
}



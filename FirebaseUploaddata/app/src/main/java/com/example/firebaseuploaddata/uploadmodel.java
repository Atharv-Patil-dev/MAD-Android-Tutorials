package com.example.firebaseuploaddata;

public class uploadmodel {
    private String sportname;
    private String sportdetails;
    private String image;
    private String startdate;
    private String enddate;
       private   String id;

    public uploadmodel(String sportname, String sportdetails, String image, String startdate, String enddate, String id) {
        this.sportname = sportname;
        this.sportdetails = sportdetails;
        this.image = image;
        this.startdate = startdate;
        this.enddate = enddate;
        this.id = id;
    }

    public uploadmodel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;


    }

    public String getSportname() {
        return sportname;
    }

    public void setSportname(String sportname) {
        this.sportname = sportname;
    }

    public String getSportdetails() {
        return sportdetails;
    }

    public void setSportdetails(String sportdetails) {
        this.sportdetails = sportdetails;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }
}

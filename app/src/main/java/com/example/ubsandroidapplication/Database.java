package com.example.ubsandroidapplication;

import com.google.firebase.database.Exclude;

public class Database {

    private String key;
    //Clubs
    private String clubUsername;
    private String clubFirstName;
    private String clubLastName;
    private String clubName;
    private String clubDescription;
    private String clubUniversity;

    //Communication ////////////////////////// is there another way to set up messages instead of through the database?
    private String recipient;
    private String commUsername;    // must check this with username to know who to block

    //Exchange
    private String excUsername; // must check this with username
    private String excTitle;
    private String excAnnouncementBox;
    private String excUniversity;

    //Login
    private String logUsername;  // must check this with username
    private String logPassword;  // must check this with password
    private String resetSQ1;
    private String resetSQ2;
    private String resetSQ3;
    private String resetSA1;
    private String resetSA2;
    private String resetSA3;

    //Payment aditya
    private String payUsername; // must check this with username
    private String payFirstName;
    private String payLastName;
    private String cardNum;
    private String expDate;
    private String cvvNum;
    private String streetAddress;
    private String city;
    private String state;
    private String country;
    private int zipCode;

    //Registration
    private String regFirstName;
    private String regLastName;
    private String university;
    private String email;
    private String username;
    private String password;
    private String sq1;
    private String sq2;
    private String sq3;
    private String sa1;
    private String sa2;
    private String sa3;

    //Sales aditya
    private String salesUsername;   // must check this with username
    private String itemName;
    private String itemDescription;
    private String itemCategory;
    private double itemPrice;

    //Search
    private String keyword;

    //Empty Constructor
    public Database() {
    }

    //Constructor
    public Database(String clubUsername, String clubFirstName, String clubLastName, String clubName, String clubDescription, String clubUniversity, String recipient, String commUsername, String excUsername, String excTitle, String excAnnouncementBox, String excUniversity, String logUsername, String logPassword, String resetSQ1, String resetSQ2, String resetSQ3, String resetSA1, String resetSA2, String resetSA3, String payUsername, String payFirstName, String payLastName, String cardNum, String expDate, String cvvNum, String streetAddress, String city, String state, String country, int zipCode, String regFirstName, String regLastName, String university, String email, String username, String password, String sq1, String sq2, String sq3, String sa1, String sa2, String sa3, String salesUsername, String itemName, String itemDescription, String itemCategory, double itemPrice, String keyword) {
        this.clubUsername = clubUsername;
        this.clubFirstName = clubFirstName;
        this.clubLastName = clubLastName;
        this.clubName = clubName;
        this.clubDescription = clubDescription;
        this.clubUniversity = clubUniversity;
        this.recipient = recipient;
        this.commUsername = commUsername;
        this.excUsername = excUsername;
        this.excTitle = excTitle;
        this.excAnnouncementBox = excAnnouncementBox;
        this.excUniversity = excUniversity;
        this.logUsername = logUsername;
        this.logPassword = logPassword;
        this.resetSQ1 = resetSQ1;
        this.resetSQ2 = resetSQ2;
        this.resetSQ3 = resetSQ3;
        this.resetSA1 = resetSA1;
        this.resetSA2 = resetSA2;
        this.resetSA3 = resetSA3;
        this.payUsername = payUsername;
        this.payFirstName = payFirstName;
        this.payLastName = payLastName;
        this.cardNum = cardNum;
        this.expDate = expDate;
        this.cvvNum = cvvNum;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;
        this.regFirstName = regFirstName;
        this.regLastName = regLastName;
        this.university = university;
        this.email = email;
        this.username = username;
        this.password = password;
        this.sq1 = sq1;
        this.sq2 = sq2;
        this.sq3 = sq3;
        this.sa1 = sa1;
        this.sa2 = sa2;
        this.sa3 = sa3;
        this.salesUsername = salesUsername;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemCategory = itemCategory;
        this.itemPrice = itemPrice;
        this.keyword = keyword;
    }

    @Exclude
    public String getKey() {
        return key;
    }
    @Exclude
    public void setKey(String dbkey) {
        key = dbkey;
    }

    //Clubs
    public String getClubUsername() {
        return clubUsername;
    }

    public void setClubUsername(String clubUsername) {
        this.clubUsername = clubUsername;
    }

    public String getClubFirstName() {
        return clubFirstName;
    }

    public void setClubFirstName(String clubFirstName) {
        this.clubFirstName = clubFirstName;
    }

    public String getClubLastName() {
        return clubLastName;
    }

    public void setClubLastName(String clubLastName) {
        this.clubLastName = clubLastName;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getClubDescription() {
        return clubDescription;
    }

    public void setClubDescription(String clubDescription) {
        this.clubDescription = clubDescription;
    }

    public String getClubUniversity() {
        return clubUniversity;
    }

    public void setClubUniversity(String clubUniversity) {
        this.clubUniversity = clubUniversity;
    }

    //Communication
    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getCommUsername() {
        return commUsername;
    }

    public void setCommUsername(String commUsername) {
        this.commUsername = commUsername;
    }

    //Exchange
    public String getExcUsername() {
        return excUsername;
    }

    public void setExcUsername(String excUsername) {
        this.excUsername = excUsername;
    }

    public String getExcTitle() {
        return excTitle;
    }

    public void setExcTitle(String excTitle) {
        this.excTitle = excTitle;
    }

    public String getExcAnnouncementBox() {
        return excAnnouncementBox;
    }

    public void setExcAnnouncementBox(String excAnnouncementBox) {
        this.excAnnouncementBox = excAnnouncementBox;
    }

    public String getExcUniversity() {
        return excUniversity;
    }

    public void setExcUniversity(String excUniversity) {
        this.excUniversity = excUniversity;
    }

    //Login
    public String getLogUsername() {
        return logUsername;
    }

    public void setLogUsername(String logUsername) {
        this.logUsername = logUsername;
    }

    public String getLogPassword() {
        return logPassword;
    }

    public void setLogPassword(String logPassword) {
        this.logPassword = logPassword;
    }

    public String getResetSQ1() {
        return resetSQ1;
    }

    public void setResetSQ1(String resetSQ1) {
        this.resetSQ1 = resetSQ1;
    }

    public String getResetSQ2() {
        return resetSQ2;
    }

    public void setResetSQ2(String resetSQ2) {
        this.resetSQ2 = resetSQ2;
    }

    public String getResetSQ3() {
        return resetSQ3;
    }

    public void setResetSQ3(String resetSQ3) {
        this.resetSQ3 = resetSQ3;
    }

    public String getResetSA1() {
        return resetSA1;
    }

    public void setResetSA1(String resetSA1) {
        this.resetSA1 = resetSA1;
    }

    public String getResetSA2() {
        return resetSA2;
    }

    public void setResetSA2(String resetSA2) {
        this.resetSA2 = resetSA2;
    }

    public String getResetSA3() {
        return resetSA3;
    }

    public void setResetSA3(String resetSA3) {
        this.resetSA3 = resetSA3;
    }

    //Payment
    public String getPayUsername() {
        return payUsername;
    }

    public void setPayUsername(String payUsername) {
        this.payUsername = payUsername;
    }

    public String getPayFirstName() {
        return payFirstName;
    }

    public void setPayFirstName(String payFirstName) {
        this.payFirstName = payFirstName;
    }

    public String getPayLastName() {
        return payLastName;
    }

    public void setPayLastName(String payLastName) {
        this.payLastName = payLastName;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getCvvNum() {
        return cvvNum;
    }

    public void setCvvNum(String cvvNum) {
        this.cvvNum = cvvNum;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    //Registration
    public String getRegFirstName() {
        return regFirstName;
    }

    public void setRegFirstName(String regFirstName) {
        this.regFirstName = regFirstName;
    }

    public String getRegLastName() {
        return regLastName;
    }

    public void setRegLastName(String regLastName) {
        this.regLastName = regLastName;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSq1() {
        return sq1;
    }

    public void setSq1(String sq1) {
        this.sq1 = sq1;
    }

    public String getSq2() {
        return sq2;
    }

    public void setSq2(String sq2) {
        this.sq2 = sq2;
    }

    public String getSq3() {
        return sq3;
    }

    public void setSq3(String sq3) {
        this.sq3 = sq3;
    }

    public String getSa1() {
        return sa1;
    }

    public void setSa1(String sa1) {
        this.sa1 = sa1;
    }

    public String getSa2() {
        return sa2;
    }

    public void setSa2(String sa2) {
        this.sa2 = sa2;
    }

    public String getSa3() {
        return sa3;
    }

    public void setSa3(String sa3) {
        this.sa3 = sa3;
    }

    //Sales
    public String getSalesUsername() {
        return salesUsername;
    }

    public void setSalesUsername(String salesUsername) {
        this.salesUsername = salesUsername;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    //Search
    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
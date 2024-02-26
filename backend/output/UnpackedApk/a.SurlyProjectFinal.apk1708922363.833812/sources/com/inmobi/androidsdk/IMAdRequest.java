package com.inmobi.androidsdk;

import android.location.Location;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class IMAdRequest {
    public static final int ID_DEVICE_NONE = 1;
    public static final int ID_DEVICE_ODIN_1 = 2;
    private int age;
    private String areaCode;
    private String cityLocation;
    private Location currentLocation;
    private Date dateOfBirth;
    private EducationType education;
    private EthnicityType ethnicity;
    private GenderType gender;
    private Map<IMIDType, String> idtypeParams = new HashMap();
    private int income;
    private String interests;
    private boolean isLocationInquiryAllowed = true;
    private boolean isTestMode = false;
    private String keywords;
    private String postalCode;
    private Map<String, String> requestParams;
    private String searchString;
    private int uidMapFlag = 2;

    public enum EducationType {
        Edu_None,
        Edu_HighSchool,
        Edu_SomeCollege,
        Edu_InCollege,
        Edu_BachelorsDegree,
        Edu_MastersDegree,
        Edu_DoctoralDegree,
        Edu_Other
    }

    public enum ErrorCode {
        INVALID_REQUEST,
        AD_DOWNLOAD_IN_PROGRESS,
        AD_CLICK_IN_PROGRESS,
        NETWORK_ERROR,
        INTERNAL_ERROR,
        NO_FILL
    }

    public enum EthnicityType {
        Eth_None,
        Eth_Mixed,
        Eth_Asian,
        Eth_Black,
        Eth_Hispanic,
        Eth_NativeAmerican,
        Eth_White,
        Eth_Other
    }

    public enum GenderType {
        NONE,
        MALE,
        FEMALE
    }

    public enum IMIDType {
        ID_LOGIN,
        ID_SESSION
    }

    public boolean isLocationInquiryAllowed() {
        return this.isLocationInquiryAllowed;
    }

    public void setLocationInquiryAllowed(boolean isLocationInquiryAllowed2) {
        this.isLocationInquiryAllowed = isLocationInquiryAllowed2;
    }

    public Location getCurrentLocation() {
        return this.currentLocation;
    }

    public void setCurrentLocation(Location currentLocation2) {
        this.currentLocation = currentLocation2;
    }

    public void setLocationWithCityStateCountry(String city, String state, String country) {
        this.cityLocation = String.valueOf(city) + "-" + state + "-" + country;
    }

    public String getLocationWithCityStateCountry() {
        return this.cityLocation;
    }

    public boolean isTestMode() {
        return this.isTestMode;
    }

    public void setTestMode(boolean testMode) {
        this.isTestMode = testMode;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public void setPostalCode(String postalCode2) {
        this.postalCode = postalCode2;
    }

    public String getAreaCode() {
        return this.areaCode;
    }

    public void setAreaCode(String areaCode2) {
        this.areaCode = areaCode2;
    }

    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth2) {
        this.dateOfBirth = dateOfBirth2;
    }

    public GenderType getGender() {
        return this.gender;
    }

    public void setGender(GenderType gender2) {
        this.gender = gender2;
    }

    public String getKeywords() {
        return this.keywords;
    }

    public void setKeywords(String keywords2) {
        this.keywords = keywords2;
    }

    public String getSearchString() {
        return this.searchString;
    }

    public void setSearchString(String searchString2) {
        this.searchString = searchString2;
    }

    public int getIncome() {
        return this.income;
    }

    public void setIncome(int income2) {
        this.income = income2;
    }

    public EducationType getEducation() {
        return this.education;
    }

    public void setEducation(EducationType educationType) {
        this.education = educationType;
    }

    public EthnicityType getEthnicity() {
        return this.ethnicity;
    }

    public void setEthnicity(EthnicityType ethnicity2) {
        this.ethnicity = ethnicity2;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age2) {
        this.age = age2;
    }

    public String getInterests() {
        return this.interests;
    }

    public void setInterests(String interests2) {
        this.interests = interests2;
    }

    public Map<String, String> getRequestParams() {
        return this.requestParams;
    }

    public void setRequestParams(Map<String, String> requestParams2) {
        this.requestParams = requestParams2;
    }

    public void setDeviceIDMask(int mask) {
        this.uidMapFlag = mask;
    }

    public int getDeviceIdMask() {
        return this.uidMapFlag;
    }

    public void addIDType(IMIDType idtype, String value) {
        if (this.idtypeParams != null) {
            this.idtypeParams.put(idtype, value);
        }
    }

    public String getIDType(IMIDType idtype) {
        if (this.idtypeParams != null) {
            return this.idtypeParams.get(idtype);
        }
        return null;
    }

    public void removeIDType(IMIDType idtype) {
        if (this.idtypeParams != null) {
            this.idtypeParams.remove(idtype);
        }
    }
}

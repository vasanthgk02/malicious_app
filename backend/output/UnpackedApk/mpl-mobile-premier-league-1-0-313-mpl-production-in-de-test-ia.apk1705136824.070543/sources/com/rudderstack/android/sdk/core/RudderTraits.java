package com.rudderstack.android.sdk.core;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.rudderstack.android.sdk.core.util.Utils;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class RudderTraits {
    public static final String ADDRESS_KEY = "address";
    public static final String AGE_KEY = "age";
    public static final String ANONYMOUSID_KEY = "anonymousId";
    public static final String BIRTHDAY_KEY = "birthday";
    public static final String COMPANY_KEY = "company";
    public static final String CREATEDAT_KEY = "createdat";
    public static final String DESCRIPTION_KEY = "description";
    public static final String EMAIL_KEY = "email";
    public static final String FIRSTNAME_KEY = "firstname";
    public static final String GENDER_KEY = "gender";
    public static final String LASTNAME_KEY = "lastname";
    public static final String NAME_KEY = "name";
    public static final String PHONE_KEY = "phone";
    public static final String TITLE_KEY = "title";
    public static final String USERID_KEY = "userId";
    public static final String USERNAME_KEY = "username";
    @SerializedName("address")
    public Address address;
    @SerializedName("age")
    public String age;
    @SerializedName("anonymousId")
    public String anonymousId;
    @SerializedName("birthday")
    public String birthday;
    @SerializedName("company")
    public Company company;
    @SerializedName("createdat")
    public String createdAt;
    @SerializedName("description")
    public String description;
    @SerializedName("email")
    public String email;
    public Map<String, Object> extras;
    @SerializedName("firstname")
    public String firstName;
    @SerializedName("gender")
    public String gender;
    @SerializedName("userId")
    public String id;
    @SerializedName("lastname")
    public String lastName;
    @SerializedName("name")
    public String name;
    @SerializedName("id")
    public String oldId;
    @SerializedName("phone")
    public String phone;
    @SerializedName("title")
    public String title;
    @SerializedName("username")
    public String userName;

    public static class Address {
        @SerializedName("city")
        public String city;
        @SerializedName("country")
        public String country;
        @SerializedName("postalcode")
        public String postalCode;
        @SerializedName("state")
        public String state;
        @SerializedName("street")
        public String street;

        public Address() {
        }

        public static Address fromString(String str) {
            return (Address) new Gson().fromJson(str, Address.class);
        }

        public String getCity() {
            return this.city;
        }

        public String getCountry() {
            return this.country;
        }

        public String getPostalCode() {
            return this.postalCode;
        }

        public String getState() {
            return this.state;
        }

        public String getStreet() {
            return this.street;
        }

        public Address putCity(String str) {
            this.city = str;
            return this;
        }

        public Address putCountry(String str) {
            this.country = str;
            return this;
        }

        public Address putPostalCode(String str) {
            this.postalCode = str;
            return this;
        }

        public Address putState(String str) {
            this.state = str;
            return this;
        }

        public Address putStreet(String str) {
            this.street = str;
            return this;
        }

        public Address(String str, String str2, String str3, String str4, String str5) {
            this.city = str;
            this.country = str2;
            this.postalCode = str3;
            this.state = str4;
            this.street = str5;
        }
    }

    public static class Company {
        @SerializedName("id")
        public String id;
        @SerializedName("industry")
        public String industry;
        @SerializedName("name")
        public String name;

        public Company() {
        }

        public Company putId(String str) {
            this.id = str;
            return this;
        }

        public Company putIndustry(String str) {
            this.industry = str;
            return this;
        }

        public Company putName(String str) {
            this.name = str;
            return this;
        }

        public Company(String str, String str2, String str3) {
            this.name = str;
            this.id = str2;
            this.industry = str3;
        }
    }

    public RudderTraits() {
        if (RudderClient.getApplication() != null) {
            this.anonymousId = RudderContext.getAnonymousId();
        }
    }

    public static String getAddress(Map<String, Object> map) {
        if ((map != null) && map.containsKey(ADDRESS_KEY)) {
            return new Gson().toJson(map.get(ADDRESS_KEY));
        }
        return null;
    }

    public static String getAge(Map<String, Object> map) {
        if ((map != null) && map.containsKey(AGE_KEY)) {
            return (String) map.get(AGE_KEY);
        }
        return null;
    }

    public static String getAnonymousId(Map<String, Object> map) {
        if ((map != null) && map.containsKey(ANONYMOUSID_KEY)) {
            return (String) map.get(ANONYMOUSID_KEY);
        }
        return null;
    }

    public static String getBirthday(Map<String, Object> map) {
        if ((map != null) && map.containsKey(BIRTHDAY_KEY)) {
            return (String) map.get(BIRTHDAY_KEY);
        }
        return null;
    }

    public static String getCompany(Map<String, Object> map) {
        if ((map != null) && map.containsKey(COMPANY_KEY)) {
            return (String) map.get(COMPANY_KEY);
        }
        return null;
    }

    public static String getCreatedAt(Map<String, Object> map) {
        if ((map != null) && map.containsKey(CREATEDAT_KEY)) {
            return (String) map.get(CREATEDAT_KEY);
        }
        return null;
    }

    public static String getDescription(Map<String, Object> map) {
        if ((map != null) && map.containsKey("description")) {
            return (String) map.get("description");
        }
        return null;
    }

    public static String getEmail(Map<String, Object> map) {
        if ((map != null) && map.containsKey("email")) {
            return (String) map.get("email");
        }
        return null;
    }

    public static String getFirstname(Map<String, Object> map) {
        if ((map != null) && map.containsKey(FIRSTNAME_KEY)) {
            return (String) map.get(FIRSTNAME_KEY);
        }
        return null;
    }

    public static String getGender(Map<String, Object> map) {
        if ((map != null) && map.containsKey(GENDER_KEY)) {
            return (String) map.get(GENDER_KEY);
        }
        return null;
    }

    public static String getLastname(Map<String, Object> map) {
        if ((map != null) && map.containsKey(LASTNAME_KEY)) {
            return (String) map.get(LASTNAME_KEY);
        }
        return null;
    }

    public static String getName(Map<String, Object> map) {
        if ((map != null) && map.containsKey("name")) {
            return (String) map.get("name");
        }
        return null;
    }

    public static String getPhone(Map<String, Object> map) {
        if ((map != null) && map.containsKey("phone")) {
            return (String) map.get("phone");
        }
        return null;
    }

    public static String getTitle(Map<String, Object> map) {
        if ((map != null) && map.containsKey("title")) {
            return (String) map.get("title");
        }
        return null;
    }

    public static String getUserid(Map<String, Object> map) {
        if ((map != null) && map.containsKey("userId")) {
            return (String) map.get("userId");
        }
        return null;
    }

    public static String getUsername(Map<String, Object> map) {
        if ((map != null) && map.containsKey(USERNAME_KEY)) {
            return (String) map.get(USERNAME_KEY);
        }
        return null;
    }

    public Map<String, Object> getExtras() {
        return this.extras;
    }

    public String getId() {
        return this.id;
    }

    public RudderTraits put(String str, Object obj) {
        if (this.extras == null) {
            this.extras = new HashMap();
        }
        this.extras.put(str, obj);
        return this;
    }

    public RudderTraits putAddress(Address address2) {
        this.address = address2;
        return this;
    }

    public RudderTraits putAge(String str) {
        this.age = str;
        return this;
    }

    public RudderTraits putBirthday(String str) {
        this.birthday = str;
        return this;
    }

    public RudderTraits putCompany(Company company2) {
        this.company = company2;
        return this;
    }

    public RudderTraits putCreatedAt(String str) {
        this.createdAt = str;
        return this;
    }

    public RudderTraits putDescription(String str) {
        this.description = str;
        return this;
    }

    public RudderTraits putEmail(String str) {
        this.email = str;
        return this;
    }

    public RudderTraits putFirstName(String str) {
        this.firstName = str;
        return this;
    }

    public RudderTraits putGender(String str) {
        this.gender = str;
        return this;
    }

    public RudderTraits putId(String str) {
        this.id = str;
        this.oldId = str;
        return this;
    }

    public RudderTraits putLastName(String str) {
        this.lastName = str;
        return this;
    }

    public RudderTraits putName(String str) {
        this.name = str;
        return this;
    }

    public RudderTraits putPhone(String str) {
        this.phone = str;
        return this;
    }

    public RudderTraits putTitle(String str) {
        this.title = str;
        return this;
    }

    public RudderTraits putUserName(String str) {
        this.userName = str;
        return this;
    }

    public RudderTraits putBirthday(Date date) {
        this.birthday = Utils.toDateString(date);
        return this;
    }

    public RudderTraits(String str) {
        this.anonymousId = str;
    }

    public RudderTraits(Address address2, String str, String str2, Company company2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13) {
        String str14 = str8;
        if (RudderClient.getApplication() != null) {
            this.anonymousId = RudderContext.getAnonymousId();
        }
        this.address = address2;
        this.age = str;
        this.birthday = str2;
        this.company = company2;
        this.createdAt = str3;
        this.description = str4;
        this.email = str5;
        this.firstName = str6;
        this.gender = str7;
        this.id = str14;
        this.oldId = str14;
        this.lastName = str9;
        this.name = str10;
        this.phone = str11;
        this.title = str12;
        this.userName = str13;
    }
}

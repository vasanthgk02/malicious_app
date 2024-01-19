package com.rudderstack.android.sdk.core;

import com.rudderstack.android.sdk.core.RudderTraits.Address;
import com.rudderstack.android.sdk.core.RudderTraits.Company;

public class RudderTraitsBuilder {
    public String age;
    public String birthDay;
    public String city;
    public String companyId;
    public String companyName;
    public String country;
    public String createdAt;
    public String description;
    public String email;
    public String firstName;
    public String gender;
    public String id;
    public String industry;
    public String lastName;
    public String name;
    public String phone;
    public String postalCode;
    public String state;
    public String street;
    public String title;
    public String userName;

    public RudderTraits build() {
        Address address;
        Company company = null;
        if (this.city == null && this.country == null && this.postalCode == null && this.state == null && this.street == null) {
            address = null;
        } else {
            Address address2 = new Address(this.city, this.country, this.postalCode, this.state, this.street);
            address = address2;
        }
        if (!(this.companyName == null && this.companyId == null && this.industry == null)) {
            company = new Company(this.companyName, this.companyId, this.industry);
        }
        Company company2 = company;
        String str = this.age;
        String str2 = this.birthDay;
        String str3 = this.createdAt;
        String str4 = this.description;
        String str5 = this.email;
        String str6 = this.firstName;
        String str7 = this.gender;
        String str8 = this.id;
        String str9 = this.lastName;
        RudderTraits rudderTraits = new RudderTraits(address, str, str2, company2, str3, str4, str5, str6, str7, str8, str9, this.name, this.phone, this.title, this.userName);
        return rudderTraits;
    }

    public RudderTraitsBuilder setAge(int i) {
        this.age = Integer.toString(i);
        return this;
    }

    public RudderTraitsBuilder setBirthDay(String str) {
        this.birthDay = str;
        return this;
    }

    public RudderTraitsBuilder setCity(String str) {
        this.city = str;
        return this;
    }

    public RudderTraitsBuilder setCompanyId(String str) {
        this.companyId = str;
        return this;
    }

    public RudderTraitsBuilder setCompanyName(String str) {
        this.companyName = str;
        return this;
    }

    public RudderTraitsBuilder setCountry(String str) {
        this.country = str;
        return this;
    }

    public RudderTraitsBuilder setCreateAt(String str) {
        this.createdAt = str;
        return this;
    }

    public RudderTraitsBuilder setDescription(String str) {
        this.description = str;
        return this;
    }

    public RudderTraitsBuilder setEmail(String str) {
        this.email = str;
        return this;
    }

    public RudderTraitsBuilder setFirstName(String str) {
        this.firstName = str;
        return this;
    }

    public RudderTraitsBuilder setGender(String str) {
        this.gender = str;
        return this;
    }

    public RudderTraitsBuilder setId(String str) {
        this.id = str;
        return this;
    }

    public RudderTraitsBuilder setIndustry(String str) {
        this.industry = str;
        return this;
    }

    public RudderTraitsBuilder setLastName(String str) {
        this.lastName = str;
        return this;
    }

    public RudderTraitsBuilder setName(String str) {
        this.name = str;
        return this;
    }

    public RudderTraitsBuilder setPhone(String str) {
        this.phone = str;
        return this;
    }

    public RudderTraitsBuilder setPostalCode(String str) {
        this.postalCode = str;
        return this;
    }

    public RudderTraitsBuilder setState(String str) {
        this.state = str;
        return this;
    }

    public RudderTraitsBuilder setStreet(String str) {
        this.street = str;
        return this;
    }

    public RudderTraitsBuilder setTitle(String str) {
        this.title = str;
        return this;
    }

    public RudderTraitsBuilder setUserName(String str) {
        this.userName = str;
        return this;
    }
}

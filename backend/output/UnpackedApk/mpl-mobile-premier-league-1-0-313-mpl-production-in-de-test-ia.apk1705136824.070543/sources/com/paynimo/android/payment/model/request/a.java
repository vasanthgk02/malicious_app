package com.paynimo.android.payment.model.request;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;
import org.apache.fontbox.cmap.CMapParser;

public class a implements Serializable {
    public static final long serialVersionUID = 1;
    public String city = "";
    public String country = "";
    public String county = "";
    public String state = "";
    public String street = "";
    public String zipCode = "";

    public String getCity() {
        return this.city;
    }

    public String getCountry() {
        return this.country;
    }

    public String getCounty() {
        return this.county;
    }

    public String getState() {
        return this.state;
    }

    public String getStreet() {
        return this.street;
    }

    public String getZipCode() {
        return this.zipCode;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public void setCounty(String str) {
        this.county = str;
    }

    public void setState(String str) {
        this.state = str;
    }

    public void setStreet(String str) {
        this.street = str;
    }

    public void setZipCode(String str) {
        this.zipCode = str;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Address [street=");
        outline73.append(this.street);
        outline73.append(", city=");
        outline73.append(this.city);
        outline73.append(", state=");
        outline73.append(this.state);
        outline73.append(", county=");
        outline73.append(this.county);
        outline73.append(", country=");
        outline73.append(this.country);
        outline73.append(", zipCode=");
        return GeneratedOutlineSupport.outline62(outline73, this.zipCode, CMapParser.MARK_END_OF_ARRAY);
    }
}

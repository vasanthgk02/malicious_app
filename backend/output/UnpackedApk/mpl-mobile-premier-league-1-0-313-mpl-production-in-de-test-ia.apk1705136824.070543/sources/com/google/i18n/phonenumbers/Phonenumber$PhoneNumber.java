package com.google.i18n.phonenumbers;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;

public class Phonenumber$PhoneNumber implements Serializable {
    public static final long serialVersionUID = 1;
    public CountryCodeSource countryCodeSource_ = CountryCodeSource.UNSPECIFIED;
    public int countryCode_ = 0;
    public String extension_ = "";
    public boolean hasCountryCodeSource;
    public boolean hasExtension;
    public boolean hasItalianLeadingZero;
    public boolean hasNumberOfLeadingZeros;
    public boolean hasPreferredDomesticCarrierCode;
    public boolean hasRawInput;
    public boolean italianLeadingZero_ = false;
    public long nationalNumber_ = 0;
    public int numberOfLeadingZeros_ = 1;
    public String preferredDomesticCarrierCode_ = "";
    public String rawInput_ = "";

    public enum CountryCodeSource {
        FROM_NUMBER_WITH_PLUS_SIGN,
        FROM_NUMBER_WITH_IDD,
        FROM_NUMBER_WITHOUT_PLUS_SIGN,
        FROM_DEFAULT_COUNTRY,
        UNSPECIFIED
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Phonenumber$PhoneNumber)) {
            return false;
        }
        Phonenumber$PhoneNumber phonenumber$PhoneNumber = (Phonenumber$PhoneNumber) obj;
        if (phonenumber$PhoneNumber != null && (this == phonenumber$PhoneNumber || (this.countryCode_ == phonenumber$PhoneNumber.countryCode_ && this.nationalNumber_ == phonenumber$PhoneNumber.nationalNumber_ && this.extension_.equals(phonenumber$PhoneNumber.extension_) && this.italianLeadingZero_ == phonenumber$PhoneNumber.italianLeadingZero_ && this.numberOfLeadingZeros_ == phonenumber$PhoneNumber.numberOfLeadingZeros_ && this.rawInput_.equals(phonenumber$PhoneNumber.rawInput_) && this.countryCodeSource_ == phonenumber$PhoneNumber.countryCodeSource_ && this.preferredDomesticCarrierCode_.equals(phonenumber$PhoneNumber.preferredDomesticCarrierCode_) && this.hasPreferredDomesticCarrierCode == phonenumber$PhoneNumber.hasPreferredDomesticCarrierCode))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = 1237;
        int outline11 = GeneratedOutlineSupport.outline11(this.preferredDomesticCarrierCode_, (this.countryCodeSource_.hashCode() + GeneratedOutlineSupport.outline11(this.rawInput_, (((GeneratedOutlineSupport.outline11(this.extension_, (Long.valueOf(this.nationalNumber_).hashCode() + ((this.countryCode_ + 2173) * 53)) * 53, 53) + (this.italianLeadingZero_ ? 1231 : 1237)) * 53) + this.numberOfLeadingZeros_) * 53, 53)) * 53, 53);
        if (this.hasPreferredDomesticCarrierCode) {
            i = 1231;
        }
        return outline11 + i;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Country Code: ");
        outline73.append(this.countryCode_);
        outline73.append(" National Number: ");
        outline73.append(this.nationalNumber_);
        if (this.hasItalianLeadingZero && this.italianLeadingZero_) {
            outline73.append(" Leading Zero(s): true");
        }
        if (this.hasNumberOfLeadingZeros) {
            outline73.append(" Number of leading zeros: ");
            outline73.append(this.numberOfLeadingZeros_);
        }
        if (this.hasExtension) {
            outline73.append(" Extension: ");
            outline73.append(this.extension_);
        }
        if (this.hasCountryCodeSource) {
            outline73.append(" Country Code Source: ");
            outline73.append(this.countryCodeSource_);
        }
        if (this.hasPreferredDomesticCarrierCode) {
            outline73.append(" Preferred Domestic Carrier Code: ");
            outline73.append(this.preferredDomesticCarrierCode_);
        }
        return outline73.toString();
    }
}

package co.hyperverge.hypersnapsdk.objects;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.gson.annotations.SerializedName;

public class GeoDetails {
    @SerializedName("as")
    public String as;
    @SerializedName("city")
    public String city;
    @SerializedName("country")
    public String country;
    @SerializedName("countryCode")
    public String countryCode;
    @SerializedName("isp")
    public String isp;
    @SerializedName("lat")
    public String latitude;
    @SerializedName("long")
    public String longitude;
    @SerializedName("org")

    /* renamed from: org  reason: collision with root package name */
    public String f3190org;
    @SerializedName("query")
    public String query;
    @SerializedName("region")
    public String region;
    @SerializedName("regionName")
    public String regionName;
    @SerializedName("status")
    public String status;
    @SerializedName("timezone")
    public String timezone;
    @SerializedName("zip")
    public String zip;

    public boolean canEqual(Object obj) {
        return obj instanceof GeoDetails;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GeoDetails)) {
            return false;
        }
        GeoDetails geoDetails = (GeoDetails) obj;
        if (!geoDetails.canEqual(this)) {
            return false;
        }
        String as2 = getAs();
        String as3 = geoDetails.getAs();
        if (as2 != null ? !as2.equals(as3) : as3 != null) {
            return false;
        }
        String city2 = getCity();
        String city3 = geoDetails.getCity();
        if (city2 != null ? !city2.equals(city3) : city3 != null) {
            return false;
        }
        String country2 = getCountry();
        String country3 = geoDetails.getCountry();
        if (country2 != null ? !country2.equals(country3) : country3 != null) {
            return false;
        }
        String countryCode2 = getCountryCode();
        String countryCode3 = geoDetails.getCountryCode();
        if (countryCode2 != null ? !countryCode2.equals(countryCode3) : countryCode3 != null) {
            return false;
        }
        String isp2 = getIsp();
        String isp3 = geoDetails.getIsp();
        if (isp2 != null ? !isp2.equals(isp3) : isp3 != null) {
            return false;
        }
        String latitude2 = getLatitude();
        String latitude3 = geoDetails.getLatitude();
        if (latitude2 != null ? !latitude2.equals(latitude3) : latitude3 != null) {
            return false;
        }
        String longitude2 = getLongitude();
        String longitude3 = geoDetails.getLongitude();
        if (longitude2 != null ? !longitude2.equals(longitude3) : longitude3 != null) {
            return false;
        }
        String org2 = getOrg();
        String org3 = geoDetails.getOrg();
        if (org2 != null ? !org2.equals(org3) : org3 != null) {
            return false;
        }
        String query2 = getQuery();
        String query3 = geoDetails.getQuery();
        if (query2 != null ? !query2.equals(query3) : query3 != null) {
            return false;
        }
        String region2 = getRegion();
        String region3 = geoDetails.getRegion();
        if (region2 != null ? !region2.equals(region3) : region3 != null) {
            return false;
        }
        String regionName2 = getRegionName();
        String regionName3 = geoDetails.getRegionName();
        if (regionName2 != null ? !regionName2.equals(regionName3) : regionName3 != null) {
            return false;
        }
        String status2 = getStatus();
        String status3 = geoDetails.getStatus();
        if (status2 != null ? !status2.equals(status3) : status3 != null) {
            return false;
        }
        String timezone2 = getTimezone();
        String timezone3 = geoDetails.getTimezone();
        if (timezone2 != null ? !timezone2.equals(timezone3) : timezone3 != null) {
            return false;
        }
        String zip2 = getZip();
        String zip3 = geoDetails.getZip();
        return zip2 != null ? zip2.equals(zip3) : zip3 == null;
    }

    public String getAs() {
        return this.as;
    }

    public String getCity() {
        return this.city;
    }

    public String getCountry() {
        return this.country;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public String getIsp() {
        return this.isp;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public String getOrg() {
        return this.f3190org;
    }

    public String getQuery() {
        return this.query;
    }

    public String getRegion() {
        return this.region;
    }

    public String getRegionName() {
        return this.regionName;
    }

    public String getStatus() {
        return this.status;
    }

    public String getTimezone() {
        return this.timezone;
    }

    public String getZip() {
        return this.zip;
    }

    public int hashCode() {
        String as2 = getAs();
        int i = 43;
        int hashCode = as2 == null ? 43 : as2.hashCode();
        String city2 = getCity();
        int hashCode2 = ((hashCode + 59) * 59) + (city2 == null ? 43 : city2.hashCode());
        String country2 = getCountry();
        int hashCode3 = (hashCode2 * 59) + (country2 == null ? 43 : country2.hashCode());
        String countryCode2 = getCountryCode();
        int hashCode4 = (hashCode3 * 59) + (countryCode2 == null ? 43 : countryCode2.hashCode());
        String isp2 = getIsp();
        int hashCode5 = (hashCode4 * 59) + (isp2 == null ? 43 : isp2.hashCode());
        String latitude2 = getLatitude();
        int hashCode6 = (hashCode5 * 59) + (latitude2 == null ? 43 : latitude2.hashCode());
        String longitude2 = getLongitude();
        int hashCode7 = (hashCode6 * 59) + (longitude2 == null ? 43 : longitude2.hashCode());
        String org2 = getOrg();
        int hashCode8 = (hashCode7 * 59) + (org2 == null ? 43 : org2.hashCode());
        String query2 = getQuery();
        int hashCode9 = (hashCode8 * 59) + (query2 == null ? 43 : query2.hashCode());
        String region2 = getRegion();
        int hashCode10 = (hashCode9 * 59) + (region2 == null ? 43 : region2.hashCode());
        String regionName2 = getRegionName();
        int hashCode11 = (hashCode10 * 59) + (regionName2 == null ? 43 : regionName2.hashCode());
        String status2 = getStatus();
        int hashCode12 = (hashCode11 * 59) + (status2 == null ? 43 : status2.hashCode());
        String timezone2 = getTimezone();
        int hashCode13 = (hashCode12 * 59) + (timezone2 == null ? 43 : timezone2.hashCode());
        String zip2 = getZip();
        int i2 = hashCode13 * 59;
        if (zip2 != null) {
            i = zip2.hashCode();
        }
        return i2 + i;
    }

    public void setAs(String str) {
        this.as = str;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public void setCountryCode(String str) {
        this.countryCode = str;
    }

    public void setIsp(String str) {
        this.isp = str;
    }

    public void setLatitude(String str) {
        this.latitude = str;
    }

    public void setLongitude(String str) {
        this.longitude = str;
    }

    public void setOrg(String str) {
        this.f3190org = str;
    }

    public void setQuery(String str) {
        this.query = str;
    }

    public void setRegion(String str) {
        this.region = str;
    }

    public void setRegionName(String str) {
        this.regionName = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setTimezone(String str) {
        this.timezone = str;
    }

    public void setZip(String str) {
        this.zip = str;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("GeoDetails(as=");
        outline73.append(getAs());
        outline73.append(", city=");
        outline73.append(getCity());
        outline73.append(", country=");
        outline73.append(getCountry());
        outline73.append(", countryCode=");
        outline73.append(getCountryCode());
        outline73.append(", isp=");
        outline73.append(getIsp());
        outline73.append(", latitude=");
        outline73.append(getLatitude());
        outline73.append(", longitude=");
        outline73.append(getLongitude());
        outline73.append(", org=");
        outline73.append(getOrg());
        outline73.append(", query=");
        outline73.append(getQuery());
        outline73.append(", region=");
        outline73.append(getRegion());
        outline73.append(", regionName=");
        outline73.append(getRegionName());
        outline73.append(", status=");
        outline73.append(getStatus());
        outline73.append(", timezone=");
        outline73.append(getTimezone());
        outline73.append(", zip=");
        outline73.append(getZip());
        outline73.append(")");
        return outline73.toString();
    }
}

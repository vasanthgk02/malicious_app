package co.hyperverge.hypersnapsdk.objects;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.gson.annotations.SerializedName;
import java.util.Date;

public class IPAddress {
    public Date createdAt;
    @SerializedName("geoDetails")
    public GeoDetails geoDetails;
    @SerializedName("ipAddress")
    public String ip;

    public boolean canEqual(Object obj) {
        return obj instanceof IPAddress;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof IPAddress)) {
            return false;
        }
        IPAddress iPAddress = (IPAddress) obj;
        if (!iPAddress.canEqual(this)) {
            return false;
        }
        String ip2 = getIp();
        String ip3 = iPAddress.getIp();
        if (ip2 != null ? !ip2.equals(ip3) : ip3 != null) {
            return false;
        }
        GeoDetails geoDetails2 = getGeoDetails();
        GeoDetails geoDetails3 = iPAddress.getGeoDetails();
        if (geoDetails2 != null ? !geoDetails2.equals(geoDetails3) : geoDetails3 != null) {
            return false;
        }
        Date createdAt2 = getCreatedAt();
        Date createdAt3 = iPAddress.getCreatedAt();
        return createdAt2 != null ? createdAt2.equals(createdAt3) : createdAt3 == null;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public GeoDetails getGeoDetails() {
        return this.geoDetails;
    }

    public String getIp() {
        return this.ip;
    }

    public int hashCode() {
        String ip2 = getIp();
        int i = 43;
        int hashCode = ip2 == null ? 43 : ip2.hashCode();
        GeoDetails geoDetails2 = getGeoDetails();
        int hashCode2 = ((hashCode + 59) * 59) + (geoDetails2 == null ? 43 : geoDetails2.hashCode());
        Date createdAt2 = getCreatedAt();
        int i2 = hashCode2 * 59;
        if (createdAt2 != null) {
            i = createdAt2.hashCode();
        }
        return i2 + i;
    }

    public void setCreatedAt(Date date) {
        this.createdAt = date;
    }

    public void setGeoDetails(GeoDetails geoDetails2) {
        this.geoDetails = geoDetails2;
    }

    public void setIp(String str) {
        this.ip = str;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("IPAddress(ip=");
        outline73.append(getIp());
        outline73.append(", geoDetails=");
        outline73.append(getGeoDetails());
        outline73.append(", createdAt=");
        outline73.append(getCreatedAt());
        outline73.append(")");
        return outline73.toString();
    }
}

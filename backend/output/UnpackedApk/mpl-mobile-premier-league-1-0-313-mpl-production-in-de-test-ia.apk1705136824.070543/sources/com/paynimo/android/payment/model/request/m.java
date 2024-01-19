package com.paynimo.android.payment.model.request;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;
import org.apache.fontbox.cmap.CMapParser;

public class m implements Serializable {
    public static final long serialVersionUID = 1;
    public String dateTime = "";
    public String month = "";
    public String year = "";

    public String getDateTime() {
        return this.dateTime;
    }

    public String getMonth() {
        return this.month;
    }

    public String getYear() {
        return this.year;
    }

    public void setDateTime(String str) {
        this.dateTime = str;
    }

    public void setMonth(String str) {
        this.month = str;
    }

    public void setYear(String str) {
        this.year = str;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Issuance [month=");
        outline73.append(this.month);
        outline73.append(", year=");
        outline73.append(this.year);
        outline73.append(", dateTime=");
        return GeneratedOutlineSupport.outline62(outline73, this.dateTime, CMapParser.MARK_END_OF_ARRAY);
    }
}

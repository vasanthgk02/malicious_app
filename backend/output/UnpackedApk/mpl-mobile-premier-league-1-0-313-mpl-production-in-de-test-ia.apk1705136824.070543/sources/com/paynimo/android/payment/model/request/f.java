package com.paynimo.android.payment.model.request;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;
import org.apache.fontbox.cmap.CMapParser;

public class f implements Serializable {
    public static final long serialVersionUID = 1;
    public a address = new a();
    public String name = "";

    public a getAddress() {
        return this.address;
    }

    public String getName() {
        return this.name;
    }

    public void setAddress(a aVar) {
        this.address = aVar;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Holder [name=");
        outline73.append(this.name);
        outline73.append(", address=");
        outline73.append(this.address);
        outline73.append(CMapParser.MARK_END_OF_ARRAY);
        return outline73.toString();
    }
}

package com.paynimo.android.payment.model.request;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.fontbox.cmap.CMapParser;

public class Cart implements Serializable {
    public static final long serialVersionUID = 1;
    public String description = "";
    public String identifier = "";
    public List<Item> item = new ArrayList();
    public String reference = "";

    public void addItem(Item item2) {
        this.item.add(item2);
    }

    public String getDescription() {
        return this.description;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public List<Item> getItem() {
        return this.item;
    }

    public String getReference() {
        return this.reference;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setIdentifier(String str) {
        this.identifier = str;
    }

    public void setItem(List<Item> list) {
        this.item = list;
    }

    public void setReference(String str) {
        this.reference = str;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Cart [identifier=");
        outline73.append(this.identifier);
        outline73.append(", reference=");
        outline73.append(this.reference);
        outline73.append(", description=");
        outline73.append(this.description);
        outline73.append(", item=");
        return GeneratedOutlineSupport.outline64(outline73, this.item, CMapParser.MARK_END_OF_ARRAY);
    }
}

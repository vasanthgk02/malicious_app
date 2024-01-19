package com.paynimo.android.payment.model.response.k;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.fontbox.cmap.CMapParser;

public class q implements Serializable {
    public static final long serialVersionUID = 1;
    public List<b> otherBanks = new ArrayList();
    public int otherBanksCount;
    public List<b> topBanks = new ArrayList();
    public int topBanksCount;

    public List<b> getOtherBanks() {
        return this.otherBanks;
    }

    public int getOtherBanksCount() {
        return this.otherBanksCount;
    }

    public List<b> getTopBanks() {
        return this.topBanks;
    }

    public int getTopBanksCount() {
        return this.topBanksCount;
    }

    public void setOtherBanks(List<b> list) {
        this.otherBanks = list;
    }

    public void setOtherBanksCount(int i) {
        this.otherBanksCount = i;
    }

    public void setTopBanks(List<b> list) {
        this.topBanks = list;
    }

    public void setTopBanksCount(int i) {
        this.topBanksCount = i;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("NetBanking [topBanksCount=");
        outline73.append(this.topBanksCount);
        outline73.append(", topBanks=");
        outline73.append(this.topBanks);
        outline73.append(", otherBanksCount=");
        outline73.append(this.otherBanksCount);
        outline73.append(", otherBanks=");
        return GeneratedOutlineSupport.outline64(outline73, this.otherBanks, CMapParser.MARK_END_OF_ARRAY);
    }
}

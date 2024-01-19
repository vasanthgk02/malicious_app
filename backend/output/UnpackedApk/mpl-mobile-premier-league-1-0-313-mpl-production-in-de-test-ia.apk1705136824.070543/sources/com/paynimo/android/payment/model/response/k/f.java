package com.paynimo.android.payment.model.response.k;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.fontbox.cmap.CMapParser;

public class f implements Serializable {
    public static final long serialVersionUID = 1;
    public List<c> cardVault = new ArrayList();
    public int cardVaultCount;
    public List<c> impsVault = new ArrayList();
    public int impsVaultCount;

    public List<c> getCardVault() {
        return this.cardVault;
    }

    public int getCardVaultCount() {
        return this.cardVaultCount;
    }

    public List<c> getImpsVault() {
        return this.impsVault;
    }

    public int getImpsVaultCount() {
        return this.impsVaultCount;
    }

    public void setCardVault(List<c> list) {
        this.cardVault = list;
    }

    public void setCardVaultCount(int i) {
        this.cardVaultCount = i;
    }

    public void setImpsVault(List<c> list) {
        this.impsVault = list;
    }

    public void setImpsVaultCount(int i) {
        this.impsVaultCount = i;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("CustomerVault [cardVaultCount=");
        outline73.append(this.cardVaultCount);
        outline73.append(", cardVault=");
        outline73.append(this.cardVault);
        outline73.append(", impsVaultCount=");
        outline73.append(this.impsVaultCount);
        outline73.append(", impsVault=");
        return GeneratedOutlineSupport.outline64(outline73, this.impsVault, CMapParser.MARK_END_OF_ARRAY);
    }
}

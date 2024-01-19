package com.paynimo.android.payment.model.response.k;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;
import org.apache.fontbox.cmap.CMapParser;

public class a implements Serializable {
    public static final long serialVersionUID = 1;
    public p MVISA;
    public s UPI;
    public d cards;
    public e cashCards;
    public h digitalMandate;
    public k emiBanks;
    public String imps = "";
    public q netBanking;
    public t wallets;

    public d getCards() {
        return this.cards;
    }

    public e getCashCards() {
        return this.cashCards;
    }

    public h getDigitalMandate() {
        return this.digitalMandate;
    }

    public k getEmiBanks() {
        return this.emiBanks;
    }

    public String getImps() {
        return this.imps;
    }

    public p getMVISA() {
        return this.MVISA;
    }

    public q getNetBanking() {
        return this.netBanking;
    }

    public s getUpi() {
        return this.UPI;
    }

    public t getWallets() {
        return this.wallets;
    }

    public void setCards(d dVar) {
        this.cards = dVar;
    }

    public void setCashCards(e eVar) {
        this.cashCards = eVar;
    }

    public void setDigitalMandate(h hVar) {
        this.digitalMandate = hVar;
    }

    public void setEmiBanks(k kVar) {
        this.emiBanks = kVar;
    }

    public void setImps(String str) {
        this.imps = str;
    }

    public void setMVISA(p pVar) {
        this.MVISA = pVar;
    }

    public void setNetBanking(q qVar) {
        this.netBanking = qVar;
    }

    public void setUpi(s sVar) {
        this.UPI = sVar;
    }

    public void setWallets(t tVar) {
        this.wallets = tVar;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Banks [netBanking=");
        outline73.append(this.netBanking.toString());
        outline73.append(", wallets=");
        outline73.append(this.wallets.toString());
        outline73.append(", cashCards=");
        outline73.append(this.cashCards.toString());
        outline73.append(", cards=");
        outline73.append(this.cards.toString());
        outline73.append(", emiBanks=, UPI=");
        outline73.append(this.UPI.toString());
        outline73.append(", MVISA=");
        outline73.append(this.MVISA.toString());
        outline73.append(", imps=");
        outline73.append(this.imps.toString());
        outline73.append(CMapParser.MARK_END_OF_ARRAY);
        return outline73.toString();
    }
}

package com.paynimo.android.payment.model.request;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;
import org.apache.fontbox.cmap.CMapParser;

public class RequestPayload implements Serializable {
    public static final long serialVersionUID = 1;
    public Cart cart = new Cart();
    public d consumer = new d();
    public o merchant = new o();
    public q payment = new q();
    public s transaction = new s();

    public Cart getCart() {
        return this.cart;
    }

    public d getConsumer() {
        return this.consumer;
    }

    public o getMerchant() {
        return this.merchant;
    }

    public q getPayment() {
        return this.payment;
    }

    public s getTransaction() {
        return this.transaction;
    }

    public void setCart(Cart cart2) {
        this.cart = cart2;
    }

    public void setConsumer(d dVar) {
        this.consumer = dVar;
    }

    public void setMerchant(o oVar) {
        this.merchant = oVar;
    }

    public void setPayment(q qVar) {
        this.payment = qVar;
    }

    public void setTransaction(s sVar) {
        this.transaction = sVar;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("RequestJson [merchant=");
        outline73.append(this.merchant.toString());
        outline73.append(", transaction=");
        outline73.append(this.transaction.toString());
        outline73.append(", cart=");
        outline73.append(this.cart.toString());
        outline73.append(", consumer=");
        outline73.append(this.consumer.toString());
        outline73.append(", payment=");
        outline73.append(this.payment.toString());
        outline73.append(CMapParser.MARK_END_OF_ARRAY);
        return outline73.toString();
    }
}

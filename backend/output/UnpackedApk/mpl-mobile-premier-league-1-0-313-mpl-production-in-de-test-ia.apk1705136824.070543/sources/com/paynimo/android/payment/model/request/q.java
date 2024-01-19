package com.paynimo.android.payment.model.request;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Serializable;
import org.apache.fontbox.cmap.CMapParser;

public class q implements Serializable {
    public static final long serialVersionUID = 1;
    public k instruction = new k();
    public l instrument = new l();
    public p method = new p();

    public k getInstruction() {
        return this.instruction;
    }

    public l getInstrument() {
        return this.instrument;
    }

    public p getMethod() {
        return this.method;
    }

    public void setInstruction(k kVar) {
        this.instruction = kVar;
    }

    public void setInstrument(l lVar) {
        this.instrument = lVar;
    }

    public void setMethod(p pVar) {
        this.method = pVar;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Payment [method=");
        outline73.append(this.method.toString());
        outline73.append(", instrument=");
        outline73.append(this.instrument.toString());
        outline73.append(", instruction=");
        outline73.append(this.instruction.toString());
        outline73.append(CMapParser.MARK_END_OF_ARRAY);
        return outline73.toString();
    }
}

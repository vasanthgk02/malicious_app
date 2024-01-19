package org.apache.fontbox.cff;

public abstract class FDSelect {
    public final CFFCIDFont owner;

    public FDSelect(CFFCIDFont cFFCIDFont) {
        this.owner = cFFCIDFont;
    }

    public abstract int getFDIndex(int i);
}

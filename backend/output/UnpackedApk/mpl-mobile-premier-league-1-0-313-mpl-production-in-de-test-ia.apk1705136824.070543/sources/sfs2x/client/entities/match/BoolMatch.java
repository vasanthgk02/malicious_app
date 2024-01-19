package sfs2x.client.entities.match;

public enum BoolMatch implements IMatcher {
    EQUALS("=="),
    NOT_EQUALS("!=");
    
    public static final int TYPE_ID = 0;
    public String symbol;

    /* access modifiers changed from: public */
    BoolMatch(String str) {
        this.symbol = str;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public int getType() {
        return 0;
    }
}

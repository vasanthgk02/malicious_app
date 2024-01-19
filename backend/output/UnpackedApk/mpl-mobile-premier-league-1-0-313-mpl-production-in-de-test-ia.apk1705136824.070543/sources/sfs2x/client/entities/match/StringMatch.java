package sfs2x.client.entities.match;

public enum StringMatch implements IMatcher {
    EQUALS("=="),
    NOT_EQUALS("!="),
    CONTAINS("contains"),
    STARTS_WITH("startsWith"),
    ENDS_WITH("endsWith");
    
    public static final int TYPE_ID = 2;
    public String symbol;

    /* access modifiers changed from: public */
    StringMatch(String str) {
        this.symbol = str;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public int getType() {
        return 2;
    }
}

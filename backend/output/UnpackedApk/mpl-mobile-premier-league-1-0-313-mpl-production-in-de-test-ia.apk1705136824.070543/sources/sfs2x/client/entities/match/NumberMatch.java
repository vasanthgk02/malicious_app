package sfs2x.client.entities.match;

public enum NumberMatch implements IMatcher {
    EQUALS("=="),
    NOT_EQUALS("!="),
    GREATER_THAN(">"),
    GREATER_THAN_OR_EQUAL_TO(">="),
    LESS_THAN("<"),
    LESS_THAN_OR_EQUAL_TO("<=");
    
    public static final int TYPE_ID = 1;
    public String symbol;

    /* access modifiers changed from: public */
    NumberMatch(String str) {
        this.symbol = str;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public int getType() {
        return 1;
    }
}

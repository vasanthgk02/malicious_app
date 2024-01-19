package sfs2x.client.entities.match;

public enum LogicOperator {
    AND("AND"),
    OR("OR");
    
    public final String id;

    /* access modifiers changed from: public */
    LogicOperator(String str) {
        this.id = str;
    }

    public String getId() {
        return this.id;
    }
}

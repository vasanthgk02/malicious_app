package org.apache.pdfbox.pdmodel;

public enum PageLayout {
    SINGLE_PAGE("SinglePage"),
    ONE_COLUMN("OneColumn"),
    TWO_COLUMN_LEFT("TwoColumnLeft"),
    TWO_COLUMN_RIGHT("TwoColumnRight"),
    TWO_PAGE_LEFT("TwoPageLeft"),
    TWO_PAGE_RIGHT("TwoPageRight");
    
    public final String value;

    /* access modifiers changed from: public */
    PageLayout(String str) {
        this.value = str;
    }

    public static PageLayout fromString(String str) {
        if (str.equals("SinglePage")) {
            return SINGLE_PAGE;
        }
        if (str.equals("OneColumn")) {
            return ONE_COLUMN;
        }
        if (str.equals("TwoColumnLeft")) {
            return TWO_COLUMN_LEFT;
        }
        if (str.equals("TwoPageLeft")) {
            return TWO_PAGE_LEFT;
        }
        if (str.equals("TwoPageRight")) {
            return TWO_PAGE_RIGHT;
        }
        throw new IllegalArgumentException(str);
    }

    public String stringValue() {
        return this.value;
    }
}

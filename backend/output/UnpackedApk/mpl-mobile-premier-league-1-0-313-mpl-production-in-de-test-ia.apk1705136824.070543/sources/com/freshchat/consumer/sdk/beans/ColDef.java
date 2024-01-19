package com.freshchat.consumer.sdk.beans;

import org.apache.fontbox.cmap.CMap;

public class ColDef {
    public String columnConstraint = "";
    public String columnName;
    public String columnType;
    public boolean nullable;
    public int versionNumber;

    public ColDef(String str, String str2, boolean z, int i) {
        this.columnName = str;
        this.columnType = str2;
        this.nullable = z;
        this.versionNumber = i;
    }

    public ColDef(String str, String str2, boolean z, int i, String str3) {
        this.columnName = str;
        this.columnType = str2;
        this.nullable = z;
        this.versionNumber = i;
        this.columnConstraint = str3;
    }

    public String getColumnConstraint() {
        return this.columnConstraint;
    }

    public String getColumnDefForQuery() {
        StringBuilder sb = new StringBuilder();
        sb.append(getColumnName());
        sb.append(CMap.SPACE);
        sb.append(getColumnType());
        sb.append(CMap.SPACE);
        sb.append(isNullable() ? "" : " NOT NULL ");
        sb.append(getColumnConstraint());
        return sb.toString();
    }

    public String getColumnName() {
        return this.columnName;
    }

    public String getColumnType() {
        return this.columnType;
    }

    public int getVersionNumber() {
        return this.versionNumber;
    }

    public boolean isNullable() {
        return this.nullable;
    }
}

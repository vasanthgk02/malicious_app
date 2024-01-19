package com.smartfoxserver.v2.entities.data;

public enum SFSDataType {
    NULL(0),
    BOOL(1),
    BYTE(2),
    SHORT(3),
    INT(4),
    LONG(5),
    FLOAT(6),
    DOUBLE(7),
    UTF_STRING(8),
    BOOL_ARRAY(9),
    BYTE_ARRAY(10),
    SHORT_ARRAY(11),
    INT_ARRAY(12),
    LONG_ARRAY(13),
    FLOAT_ARRAY(14),
    DOUBLE_ARRAY(15),
    UTF_STRING_ARRAY(16),
    SFS_ARRAY(17),
    SFS_OBJECT(18),
    CLASS(19),
    TEXT(20);
    
    public int typeID;

    /* access modifiers changed from: public */
    SFSDataType(int i) {
        this.typeID = i;
    }

    public static SFSDataType fromClass(Class cls) {
        return null;
    }

    public static SFSDataType fromTypeId(int i) {
        for (SFSDataType sFSDataType : values()) {
            if (sFSDataType.getTypeID() == i) {
                return sFSDataType;
            }
        }
        throw new IllegalArgumentException("Unknown typeId for SFSDataType");
    }

    public int getTypeID() {
        return this.typeID;
    }
}

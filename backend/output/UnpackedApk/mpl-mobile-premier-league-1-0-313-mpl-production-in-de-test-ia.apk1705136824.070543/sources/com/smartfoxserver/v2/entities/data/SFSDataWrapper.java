package com.smartfoxserver.v2.entities.data;

public class SFSDataWrapper {
    public Object object;
    public SFSDataType typeId;

    public SFSDataWrapper(SFSDataType sFSDataType, Object obj) {
        this.typeId = sFSDataType;
        this.object = obj;
    }

    public Object getObject() {
        return this.object;
    }

    public SFSDataType getTypeId() {
        return this.typeId;
    }
}

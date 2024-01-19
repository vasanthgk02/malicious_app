package sfs2x.client.entities.variables;

import com.smartfoxserver.v2.entities.data.ISFSArray;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import com.smartfoxserver.v2.entities.data.SFSArray;

public class BaseVariable implements Variable {
    public String name;
    public int type;
    public Object val;

    public BaseVariable(String str, Object obj) {
        this(str, obj, -1);
    }

    public Boolean getBoolValue() {
        return (Boolean) this.val;
    }

    public Double getDoubleValue() {
        return (Double) this.val;
    }

    public Integer getIntValue() {
        return (Integer) this.val;
    }

    public String getName() {
        return this.name;
    }

    public ISFSArray getSFSArrayValue() {
        return (ISFSArray) this.val;
    }

    public ISFSObject getSFSObjectValue() {
        return (ISFSObject) this.val;
    }

    public String getStringValue() {
        return (String) this.val;
    }

    public int getType() {
        return this.type;
    }

    public Object getValue() {
        return this.val;
    }

    public boolean isNull() {
        return this.type == 0;
    }

    public void populateArrayWithValue(ISFSArray iSFSArray) {
        switch (this.type) {
            case 0:
                iSFSArray.addNull();
                return;
            case 1:
                iSFSArray.addBool(getBoolValue().booleanValue());
                return;
            case 2:
                iSFSArray.addInt(getIntValue().intValue());
                return;
            case 3:
                iSFSArray.addDouble(getDoubleValue().doubleValue());
                return;
            case 4:
                iSFSArray.addUtfString(getStringValue());
                return;
            case 5:
                iSFSArray.addSFSObject(getSFSObjectValue());
                return;
            case 6:
                iSFSArray.addSFSArray(getSFSArrayValue());
                return;
            default:
                return;
        }
    }

    public void setValue(Object obj) {
        this.val = obj;
        if (obj == null) {
            this.type = 0;
        } else if (obj instanceof Boolean) {
            this.type = 1;
        } else if (obj instanceof Integer) {
            this.type = 2;
        } else if (obj instanceof Double) {
            this.type = 3;
        } else if (obj instanceof String) {
            this.type = 4;
        } else {
            String simpleName = obj.getClass().getSimpleName();
            if (simpleName.equals("SFSObject")) {
                this.type = 5;
            } else if (simpleName.equals("SFSArray")) {
                this.type = 6;
            } else {
                throw new IllegalArgumentException("Unsupport SFS Variable type: " + simpleName);
            }
        }
    }

    public ISFSArray toSFSArray() {
        SFSArray sFSArray = new SFSArray();
        sFSArray.addUtfString(this.name);
        sFSArray.addByte((byte) this.type);
        populateArrayWithValue(sFSArray);
        return sFSArray;
    }

    public BaseVariable(String str, Object obj, int i) {
        this.name = str;
        if (i > -1) {
            this.val = obj;
            this.type = i;
            return;
        }
        setValue(obj);
    }
}

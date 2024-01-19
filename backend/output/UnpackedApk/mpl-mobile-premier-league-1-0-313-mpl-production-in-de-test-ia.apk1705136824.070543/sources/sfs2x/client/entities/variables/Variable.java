package sfs2x.client.entities.variables;

import com.smartfoxserver.v2.entities.data.ISFSArray;
import com.smartfoxserver.v2.entities.data.ISFSObject;

public interface Variable {
    Boolean getBoolValue();

    Double getDoubleValue();

    Integer getIntValue();

    String getName();

    ISFSArray getSFSArrayValue();

    ISFSObject getSFSObjectValue();

    String getStringValue();

    int getType();

    Object getValue();

    boolean isNull();

    ISFSArray toSFSArray();
}

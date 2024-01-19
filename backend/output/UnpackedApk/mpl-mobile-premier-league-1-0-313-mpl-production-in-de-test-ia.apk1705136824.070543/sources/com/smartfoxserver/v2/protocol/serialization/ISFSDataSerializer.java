package com.smartfoxserver.v2.protocol.serialization;

import com.smartfoxserver.v2.entities.data.ISFSArray;
import com.smartfoxserver.v2.entities.data.ISFSObject;
import com.smartfoxserver.v2.entities.data.SFSArray;
import com.smartfoxserver.v2.entities.data.SFSObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface ISFSDataSerializer {
    byte[] array2binary(ISFSArray iSFSArray);

    String array2json(List<Object> list);

    ISFSArray binary2array(byte[] bArr);

    ISFSObject binary2object(byte[] bArr);

    ISFSArray json2array(String str);

    ISFSObject json2object(String str);

    byte[] object2binary(ISFSObject iSFSObject);

    String object2json(Map<String, Object> map);

    ISFSObject pojo2sfs(Object obj);

    SFSArray resultSet2array(ResultSet resultSet) throws SQLException;

    SFSObject resultSet2object(ResultSet resultSet) throws SQLException;

    Object sfs2pojo(ISFSObject iSFSObject);
}

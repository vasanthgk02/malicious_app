package com.smartfoxserver.v2.entities.data;

import java.util.Collection;
import java.util.Iterator;

public interface ISFSArray {
    void add(SFSDataWrapper sFSDataWrapper);

    void addBool(boolean z);

    void addBoolArray(Collection<Boolean> collection);

    void addByte(byte b2);

    void addByteArray(byte[] bArr);

    void addClass(Object obj);

    void addDouble(double d2);

    void addDoubleArray(Collection<Double> collection);

    void addFloat(float f2);

    void addFloatArray(Collection<Float> collection);

    void addInt(int i);

    void addIntArray(Collection<Integer> collection);

    void addLong(long j);

    void addLongArray(Collection<Long> collection);

    void addNull();

    void addSFSArray(ISFSArray iSFSArray);

    void addSFSObject(ISFSObject iSFSObject);

    void addShort(short s);

    void addShortArray(Collection<Short> collection);

    void addText(String str);

    void addUtfString(String str);

    void addUtfStringArray(Collection<String> collection);

    boolean contains(Object obj);

    SFSDataWrapper get(int i);

    Boolean getBool(int i);

    Collection<Boolean> getBoolArray(int i);

    Byte getByte(int i);

    byte[] getByteArray(int i);

    Object getClass(int i);

    Double getDouble(int i);

    Collection<Double> getDoubleArray(int i);

    String getDump();

    String getDump(boolean z);

    Object getElementAt(int i);

    Float getFloat(int i);

    Collection<Float> getFloatArray(int i);

    String getHexDump();

    Integer getInt(int i);

    Collection<Integer> getIntArray(int i);

    Long getLong(int i);

    Collection<Long> getLongArray(int i);

    ISFSArray getSFSArray(int i);

    ISFSObject getSFSObject(int i);

    Short getShort(int i);

    Collection<Short> getShortArray(int i);

    String getText(int i);

    Integer getUnsignedByte(int i);

    Collection<Integer> getUnsignedByteArray(int i);

    String getUtfString(int i);

    Collection<String> getUtfStringArray(int i);

    boolean isNull(int i);

    Iterator<SFSDataWrapper> iterator();

    void removeElementAt(int i);

    int size();

    byte[] toBinary();

    String toJson();
}

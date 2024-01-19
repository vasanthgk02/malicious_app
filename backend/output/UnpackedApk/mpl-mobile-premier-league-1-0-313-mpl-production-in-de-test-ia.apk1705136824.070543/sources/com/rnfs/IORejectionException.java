package com.rnfs;

public class IORejectionException extends Exception {
    public String code;

    public IORejectionException(String str, String str2) {
        super(str2);
        this.code = str;
    }
}

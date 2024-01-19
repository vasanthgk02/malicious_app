package com.microsoft.codepush.react;

public class CodePushUnknownException extends RuntimeException {
    public CodePushUnknownException(String str, Throwable th) {
        super(str, th);
    }

    public CodePushUnknownException(String str) {
        super(str);
    }
}

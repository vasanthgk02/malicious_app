package com.microsoft.codepush.react;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.net.MalformedURLException;

public class CodePushMalformedDataException extends RuntimeException {
    public CodePushMalformedDataException(String str, Throwable th) {
        super(GeneratedOutlineSupport.outline52("Unable to parse contents of ", str, ", the file may be corrupted."), th);
    }

    public CodePushMalformedDataException(String str, MalformedURLException malformedURLException) {
        super(GeneratedOutlineSupport.outline50("The package has an invalid downloadUrl: ", str), malformedURLException);
    }
}

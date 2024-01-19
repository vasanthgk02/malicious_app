package com.badlogic.gdx;

import com.badlogic.gdx.files.FileHandle;

public interface Files {

    public enum FileType {
        Classpath,
        Internal,
        External,
        Absolute,
        Local
    }

    FileHandle classpath(String str);

    FileHandle external(String str);

    String getExternalStoragePath();

    FileHandle getFileHandle(String str, FileType fileType);

    String getLocalStoragePath();

    FileHandle internal(String str);

    FileHandle local(String str);
}

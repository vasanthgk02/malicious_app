package com.google.firebase.platforminfo;

import java.util.HashSet;
import java.util.Set;

public class GlobalLibraryVersionRegistrar {
    public static volatile GlobalLibraryVersionRegistrar INSTANCE;
    public final Set<LibraryVersion> infos = new HashSet();
}

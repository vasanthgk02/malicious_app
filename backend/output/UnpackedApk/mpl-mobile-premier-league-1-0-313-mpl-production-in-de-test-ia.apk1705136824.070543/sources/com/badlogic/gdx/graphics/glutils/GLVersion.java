package com.badlogic.gdx.graphics.glutils;

import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.Application.ApplicationType;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GLVersion {
    public final String TAG = "GLVersion";
    public int majorVersion;
    public int minorVersion;
    public int releaseVersion;
    public final String rendererString;
    public final Type type;
    public final String vendorString;

    public enum Type {
        OpenGL,
        GLES,
        WebGL,
        NONE
    }

    public GLVersion(ApplicationType applicationType, String str, String str2, String str3) {
        if (applicationType == ApplicationType.Android) {
            this.type = Type.GLES;
        } else if (applicationType == ApplicationType.iOS) {
            this.type = Type.GLES;
        } else if (applicationType == ApplicationType.Desktop) {
            this.type = Type.OpenGL;
        } else if (applicationType == ApplicationType.Applet) {
            this.type = Type.OpenGL;
        } else if (applicationType == ApplicationType.WebGL) {
            this.type = Type.WebGL;
        } else {
            this.type = Type.NONE;
        }
        Type type2 = this.type;
        if (type2 == Type.GLES) {
            extractVersion("OpenGL ES (\\d(\\.\\d){0,2})", str);
        } else if (type2 == Type.WebGL) {
            extractVersion("WebGL (\\d(\\.\\d){0,2})", str);
        } else if (type2 == Type.OpenGL) {
            extractVersion("(\\d(\\.\\d){0,2})", str);
        } else {
            this.majorVersion = -1;
            this.minorVersion = -1;
            this.releaseVersion = -1;
            str2 = "";
            str3 = str2;
        }
        this.vendorString = str2;
        this.rendererString = str3;
    }

    private void extractVersion(String str, String str2) {
        Matcher matcher = Pattern.compile(str).matcher(str2);
        int i = 0;
        if (matcher.find()) {
            String[] split = matcher.group(1).split("\\.");
            this.majorVersion = parseInt(split[0], 2);
            this.minorVersion = split.length < 2 ? 0 : parseInt(split[1], 0);
            if (split.length >= 3) {
                i = parseInt(split[2], 0);
            }
            this.releaseVersion = i;
            return;
        }
        Application application = k.app;
        application.log("GLVersion", "Invalid version string: " + str2);
        this.majorVersion = 2;
        this.minorVersion = 0;
        this.releaseVersion = 0;
    }

    private int parseInt(String str, int i) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            Application application = k.app;
            application.error("LibGDX GL", "Error parsing number: " + str + ", assuming: " + i);
            return i;
        }
    }

    public String getDebugVersionString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Type: ");
        outline73.append(this.type);
        outline73.append("\nVersion: ");
        outline73.append(this.majorVersion);
        outline73.append(":");
        outline73.append(this.minorVersion);
        outline73.append(":");
        outline73.append(this.releaseVersion);
        outline73.append("\nVendor: ");
        outline73.append(this.vendorString);
        outline73.append("\nRenderer: ");
        outline73.append(this.rendererString);
        return outline73.toString();
    }

    public int getMajorVersion() {
        return this.majorVersion;
    }

    public int getMinorVersion() {
        return this.minorVersion;
    }

    public int getReleaseVersion() {
        return this.releaseVersion;
    }

    public String getRendererString() {
        return this.rendererString;
    }

    public Type getType() {
        return this.type;
    }

    public String getVendorString() {
        return this.vendorString;
    }

    public boolean isVersionEqualToOrHigher(int i, int i2) {
        int i3 = this.majorVersion;
        return i3 > i || (i3 == i && this.minorVersion >= i2);
    }
}

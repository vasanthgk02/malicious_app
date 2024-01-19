package com.facebook.react.modules.systeminfo;

import com.facebook.drawee.backends.pipeline.info.ImageOriginUtils;
import java.util.Map;

public class ReactNativeVersion {
    public static final Map<String, Object> VERSION = ImageOriginUtils.of("major", Integer.valueOf(0), "minor", Integer.valueOf(63), "patch", Integer.valueOf(5), "prerelease", null);
}

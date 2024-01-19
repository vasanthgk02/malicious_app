package org.jboss.netty.util;

import com.android.tools.r8.GeneratedOutlineSupport;
import org.apache.fontbox.cmap.CMapParser;

public class ExternalResourceUtil {
    public static void release(ExternalResourceReleasable... externalResourceReleasableArr) {
        int length = externalResourceReleasableArr.length;
        ExternalResourceReleasable[] externalResourceReleasableArr2 = new ExternalResourceReleasable[length];
        int i = 0;
        while (i < externalResourceReleasableArr.length) {
            if (externalResourceReleasableArr[i] != null) {
                externalResourceReleasableArr2[i] = externalResourceReleasableArr[i];
                i++;
            } else {
                throw new NullPointerException(GeneratedOutlineSupport.outline42("releasables[", i, CMapParser.MARK_END_OF_ARRAY));
            }
        }
        for (int i2 = 0; i2 < length; i2++) {
            externalResourceReleasableArr2[i2].releaseExternalResources();
        }
    }
}

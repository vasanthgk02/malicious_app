package com.google.android.gms.common;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.gms.common.annotation.KeepName;

@KeepName
/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
public final class GooglePlayServicesIncorrectManifestValueException extends GooglePlayServicesManifestException {
    public GooglePlayServicesIncorrectManifestValueException(int i) {
        super(i, GeneratedOutlineSupport.outline44("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected ", GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE, " but found ", i, ".  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />"));
    }
}
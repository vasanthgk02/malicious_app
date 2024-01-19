package com.mpl.network.modules.request;

import androidx.annotation.Keep;
import com.mpl.androidapp.cleanarch.core.config.domain.ConfigZkFeatures;

@Keep
public enum RequestPriority {
    LOW("low"),
    NORMAL(ConfigZkFeatures.CONFIG_TYPE_NORMAL),
    HIGH("high");
    
    public String name;

    /* access modifiers changed from: public */
    RequestPriority(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }
}

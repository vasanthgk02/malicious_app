package com.mpl.androidapp.cleanarch.core.config.domain;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.cleanarch.core.config.domain.usecases.GetBooleanZkUseCase;
import com.mpl.androidapp.cleanarch.core.config.domain.usecases.GetJsonObjectZkUseCase;
import com.mpl.androidapp.cleanarch.core.config.domain.usecases.GetStringZkUseCase;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/mpl/androidapp/cleanarch/core/config/domain/ConfigZkFeatures;", "", "getBooleanZkUseCase", "Lcom/mpl/androidapp/cleanarch/core/config/domain/usecases/GetBooleanZkUseCase;", "getStringZkUseCase", "Lcom/mpl/androidapp/cleanarch/core/config/domain/usecases/GetStringZkUseCase;", "getJsonObjectZkUseCase", "Lcom/mpl/androidapp/cleanarch/core/config/domain/usecases/GetJsonObjectZkUseCase;", "(Lcom/mpl/androidapp/cleanarch/core/config/domain/usecases/GetBooleanZkUseCase;Lcom/mpl/androidapp/cleanarch/core/config/domain/usecases/GetStringZkUseCase;Lcom/mpl/androidapp/cleanarch/core/config/domain/usecases/GetJsonObjectZkUseCase;)V", "getGetBooleanZkUseCase", "()Lcom/mpl/androidapp/cleanarch/core/config/domain/usecases/GetBooleanZkUseCase;", "getGetJsonObjectZkUseCase", "()Lcom/mpl/androidapp/cleanarch/core/config/domain/usecases/GetJsonObjectZkUseCase;", "getGetStringZkUseCase", "()Lcom/mpl/androidapp/cleanarch/core/config/domain/usecases/GetStringZkUseCase;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConfigZkFeatures.kt */
public final class ConfigZkFeatures {
    public static final String CONFIG_TAG = "ConfigZkFeatures";
    public static final String CONFIG_TYPE_NORMAL = "normal";
    public static final String CONFIG_TYPE_PLATFORM = "platform";
    public static final Companion Companion = new Companion(null);
    public final GetBooleanZkUseCase getBooleanZkUseCase;
    public final GetJsonObjectZkUseCase getJsonObjectZkUseCase;
    public final GetStringZkUseCase getStringZkUseCase;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/mpl/androidapp/cleanarch/core/config/domain/ConfigZkFeatures$Companion;", "", "()V", "CONFIG_TAG", "", "CONFIG_TYPE_NORMAL", "CONFIG_TYPE_PLATFORM", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConfigZkFeatures.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ConfigZkFeatures(GetBooleanZkUseCase getBooleanZkUseCase2, GetStringZkUseCase getStringZkUseCase2, GetJsonObjectZkUseCase getJsonObjectZkUseCase2) {
        Intrinsics.checkNotNullParameter(getBooleanZkUseCase2, "getBooleanZkUseCase");
        Intrinsics.checkNotNullParameter(getStringZkUseCase2, "getStringZkUseCase");
        Intrinsics.checkNotNullParameter(getJsonObjectZkUseCase2, "getJsonObjectZkUseCase");
        this.getBooleanZkUseCase = getBooleanZkUseCase2;
        this.getStringZkUseCase = getStringZkUseCase2;
        this.getJsonObjectZkUseCase = getJsonObjectZkUseCase2;
    }

    public static /* synthetic */ ConfigZkFeatures copy$default(ConfigZkFeatures configZkFeatures, GetBooleanZkUseCase getBooleanZkUseCase2, GetStringZkUseCase getStringZkUseCase2, GetJsonObjectZkUseCase getJsonObjectZkUseCase2, int i, Object obj) {
        if ((i & 1) != 0) {
            getBooleanZkUseCase2 = configZkFeatures.getBooleanZkUseCase;
        }
        if ((i & 2) != 0) {
            getStringZkUseCase2 = configZkFeatures.getStringZkUseCase;
        }
        if ((i & 4) != 0) {
            getJsonObjectZkUseCase2 = configZkFeatures.getJsonObjectZkUseCase;
        }
        return configZkFeatures.copy(getBooleanZkUseCase2, getStringZkUseCase2, getJsonObjectZkUseCase2);
    }

    public final GetBooleanZkUseCase component1() {
        return this.getBooleanZkUseCase;
    }

    public final GetStringZkUseCase component2() {
        return this.getStringZkUseCase;
    }

    public final GetJsonObjectZkUseCase component3() {
        return this.getJsonObjectZkUseCase;
    }

    public final ConfigZkFeatures copy(GetBooleanZkUseCase getBooleanZkUseCase2, GetStringZkUseCase getStringZkUseCase2, GetJsonObjectZkUseCase getJsonObjectZkUseCase2) {
        Intrinsics.checkNotNullParameter(getBooleanZkUseCase2, "getBooleanZkUseCase");
        Intrinsics.checkNotNullParameter(getStringZkUseCase2, "getStringZkUseCase");
        Intrinsics.checkNotNullParameter(getJsonObjectZkUseCase2, "getJsonObjectZkUseCase");
        return new ConfigZkFeatures(getBooleanZkUseCase2, getStringZkUseCase2, getJsonObjectZkUseCase2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConfigZkFeatures)) {
            return false;
        }
        ConfigZkFeatures configZkFeatures = (ConfigZkFeatures) obj;
        return Intrinsics.areEqual(this.getBooleanZkUseCase, configZkFeatures.getBooleanZkUseCase) && Intrinsics.areEqual(this.getStringZkUseCase, configZkFeatures.getStringZkUseCase) && Intrinsics.areEqual(this.getJsonObjectZkUseCase, configZkFeatures.getJsonObjectZkUseCase);
    }

    public final GetBooleanZkUseCase getGetBooleanZkUseCase() {
        return this.getBooleanZkUseCase;
    }

    public final GetJsonObjectZkUseCase getGetJsonObjectZkUseCase() {
        return this.getJsonObjectZkUseCase;
    }

    public final GetStringZkUseCase getGetStringZkUseCase() {
        return this.getStringZkUseCase;
    }

    public int hashCode() {
        int hashCode = this.getStringZkUseCase.hashCode();
        return this.getJsonObjectZkUseCase.hashCode() + ((hashCode + (this.getBooleanZkUseCase.hashCode() * 31)) * 31);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("ConfigZkFeatures(getBooleanZkUseCase=");
        outline73.append(this.getBooleanZkUseCase);
        outline73.append(", getStringZkUseCase=");
        outline73.append(this.getStringZkUseCase);
        outline73.append(", getJsonObjectZkUseCase=");
        outline73.append(this.getJsonObjectZkUseCase);
        outline73.append(')');
        return outline73.toString();
    }
}

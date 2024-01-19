package kotlin.reflect.jvm.internal.impl.load.kotlin.header;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmBytecodeBinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMetadataVersion;

/* compiled from: KotlinClassHeader.kt */
public final class KotlinClassHeader {
    public final String[] data;
    public final int extraInt;
    public final String extraString;
    public final String[] incompatibleData;
    public final Kind kind;
    public final JvmMetadataVersion metadataVersion;
    public final String[] strings;

    /* compiled from: KotlinClassHeader.kt */
    public enum Kind {
        UNKNOWN(0),
        CLASS(1),
        FILE_FACADE(2),
        SYNTHETIC_CLASS(3),
        MULTIFILE_CLASS(4),
        MULTIFILE_CLASS_PART(5);
        
        public static final Companion Companion = null;
        public static final Map<Integer, Kind> entryById = null;
        public final int id;

        /* compiled from: KotlinClassHeader.kt */
        public static final class Companion {
            public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            }
        }

        /* access modifiers changed from: public */
        static {
            int i;
            Companion = new Companion(null);
            Kind[] values = values();
            int mapCapacity = TweetUtils.mapCapacity(values.length);
            if (mapCapacity < 16) {
                mapCapacity = 16;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(mapCapacity);
            for (Kind kind : values) {
                linkedHashMap.put(Integer.valueOf(kind.getId()), kind);
            }
            entryById = linkedHashMap;
        }

        /* access modifiers changed from: public */
        Kind(int i) {
            this.id = i;
        }

        public static final Kind getById(int i) {
            if (Companion != null) {
                Kind kind = (Kind) entryById.get(Integer.valueOf(i));
                return kind == null ? UNKNOWN : kind;
            }
            throw null;
        }

        public final int getId() {
            return this.id;
        }
    }

    public KotlinClassHeader(Kind kind2, JvmMetadataVersion jvmMetadataVersion, JvmBytecodeBinaryVersion jvmBytecodeBinaryVersion, String[] strArr, String[] strArr2, String[] strArr3, String str, int i, String str2) {
        Intrinsics.checkNotNullParameter(kind2, "kind");
        Intrinsics.checkNotNullParameter(jvmMetadataVersion, "metadataVersion");
        Intrinsics.checkNotNullParameter(jvmBytecodeBinaryVersion, "bytecodeVersion");
        this.kind = kind2;
        this.metadataVersion = jvmMetadataVersion;
        this.data = strArr;
        this.incompatibleData = strArr2;
        this.strings = strArr3;
        this.extraString = str;
        this.extraInt = i;
    }

    public final String getMultifileClassName() {
        String str = this.extraString;
        if (this.kind == Kind.MULTIFILE_CLASS_PART) {
            return str;
        }
        return null;
    }

    public final boolean has(int i, int i2) {
        return (i & i2) != 0;
    }

    public String toString() {
        return this.kind + " version=" + this.metadataVersion;
    }
}

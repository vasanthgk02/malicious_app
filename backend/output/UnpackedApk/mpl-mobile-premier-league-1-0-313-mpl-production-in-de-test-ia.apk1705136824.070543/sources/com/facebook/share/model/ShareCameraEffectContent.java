package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.share.model.CameraEffectArguments.Builder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001a\u001bB\u000f\b\u0012\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004B\u000f\b\u0010\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R\"\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\"\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\b\u001a\u0004\u0018\u00010\r@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\b\u001a\u0004\u0018\u00010\u0011@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001c"}, d2 = {"Lcom/facebook/share/model/ShareCameraEffectContent;", "Lcom/facebook/share/model/ShareContent;", "Lcom/facebook/share/model/ShareCameraEffectContent$Builder;", "builder", "(Lcom/facebook/share/model/ShareCameraEffectContent$Builder;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "<set-?>", "Lcom/facebook/share/model/CameraEffectArguments;", "arguments", "getArguments", "()Lcom/facebook/share/model/CameraEffectArguments;", "", "effectId", "getEffectId", "()Ljava/lang/String;", "Lcom/facebook/share/model/CameraEffectTextures;", "textures", "getTextures", "()Lcom/facebook/share/model/CameraEffectTextures;", "writeToParcel", "", "out", "flags", "", "Builder", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ShareCameraEffectContent.kt */
public final class ShareCameraEffectContent extends ShareContent<ShareCameraEffectContent, Object> {
    public static final Creator<ShareCameraEffectContent> CREATOR = new ShareCameraEffectContent$Companion$CREATOR$1();
    public CameraEffectArguments arguments;
    public String effectId;
    public CameraEffectTextures textures;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public ShareCameraEffectContent(Parcel parcel) {
        // Intrinsics.checkNotNullParameter(parcel, "parcel");
        super(parcel);
        this.effectId = parcel.readString();
        Builder builder = new Builder();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        CameraEffectArguments cameraEffectArguments = (CameraEffectArguments) parcel.readParcelable(CameraEffectArguments.class.getClassLoader());
        if (cameraEffectArguments != null) {
            builder.params.putAll(cameraEffectArguments.params);
        }
        this.arguments = new CameraEffectArguments(builder, null);
        CameraEffectTextures.Builder builder2 = new CameraEffectTextures.Builder();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        CameraEffectTextures cameraEffectTextures = (CameraEffectTextures) parcel.readParcelable(CameraEffectTextures.class.getClassLoader());
        if (cameraEffectTextures != null) {
            builder2.textures.putAll(cameraEffectTextures.textures);
        }
        this.textures = new CameraEffectTextures(builder2, null);
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        super.writeToParcel(parcel, i);
        parcel.writeString(this.effectId);
        parcel.writeParcelable(this.arguments, 0);
        parcel.writeParcelable(this.textures, 0);
    }
}

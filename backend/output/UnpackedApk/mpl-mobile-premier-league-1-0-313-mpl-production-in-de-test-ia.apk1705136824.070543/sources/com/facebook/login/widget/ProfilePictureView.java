package com.facebook.login.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.facebook.AccessToken;
import com.facebook.AccessToken.Companion;
import com.facebook.FacebookException;
import com.facebook.LoggingBehavior;
import com.facebook.ProfileTracker;
import com.facebook.internal.ImageDownloader;
import com.facebook.internal.ImageRequest;
import com.facebook.internal.ImageRequest.Callback;
import com.facebook.internal.ImageResponse;
import com.facebook.internal.Logger;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.login.R$dimen;
import com.facebook.login.R$drawable;
import com.facebook.login.R$styleable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharKt;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 T2\u00020\u0001:\u0002TUB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u00100\u001a\u00020\t2\u0006\u00101\u001a\u00020\u0011H\u0003J\u0010\u00102\u001a\u0002032\u0006\u00104\u001a\u00020#H\u0002J\b\u00105\u001a\u000206H\u0003J\b\u00107\u001a\u00020\u0011H\u0002J\b\u00108\u001a\u000206H\u0014J0\u00109\u001a\u0002062\u0006\u0010:\u001a\u00020\u00112\u0006\u0010;\u001a\u00020\t2\u0006\u0010<\u001a\u00020\t2\u0006\u0010=\u001a\u00020\t2\u0006\u0010>\u001a\u00020\tH\u0014J\u0018\u0010?\u001a\u0002062\u0006\u0010@\u001a\u00020\t2\u0006\u0010A\u001a\u00020\tH\u0014J\u0010\u0010B\u001a\u0002062\u0006\u0010C\u001a\u00020DH\u0014J\b\u0010E\u001a\u00020DH\u0014J\u0010\u0010F\u001a\u0002062\u0006\u0010\u0005\u001a\u00020\u0006H\u0003J\u0012\u0010G\u001a\u0002062\b\u0010H\u001a\u0004\u0018\u00010IH\u0003J\u0010\u0010J\u001a\u0002062\u0006\u0010K\u001a\u00020\u0011H\u0003J\u0010\u0010L\u001a\u0002062\u0006\u0010M\u001a\u00020\u0011H\u0003J\b\u0010N\u001a\u000206H\u0003J\u0010\u0010O\u001a\u0002062\b\u0010P\u001a\u0004\u0018\u00010\fJ\u0012\u0010Q\u001a\u0002062\b\u0010R\u001a\u0004\u0018\u00010\fH\u0003J\b\u0010S\u001a\u00020\u0011H\u0003R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R$\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001e\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R(\u0010$\u001a\u0004\u0018\u00010#2\b\u0010\u0010\u001a\u0004\u0018\u00010#@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R$\u0010-\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00118F@FX\u000e¢\u0006\f\u001a\u0004\b.\u0010\u0013\"\u0004\b/\u0010\u0015¨\u0006V"}, d2 = {"Lcom/facebook/login/widget/ProfilePictureView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "customizedDefaultProfilePicture", "Landroid/graphics/Bitmap;", "image", "Landroid/widget/ImageView;", "imageContents", "value", "", "isCropped", "()Z", "setCropped", "(Z)V", "lastRequest", "Lcom/facebook/internal/ImageRequest;", "onErrorListener", "Lcom/facebook/login/widget/ProfilePictureView$OnErrorListener;", "getOnErrorListener", "()Lcom/facebook/login/widget/ProfilePictureView$OnErrorListener;", "setOnErrorListener", "(Lcom/facebook/login/widget/ProfilePictureView$OnErrorListener;)V", "presetSize", "getPresetSize", "()I", "setPresetSize", "(I)V", "", "profileId", "getProfileId", "()Ljava/lang/String;", "setProfileId", "(Ljava/lang/String;)V", "profileTracker", "Lcom/facebook/ProfileTracker;", "queryHeight", "queryWidth", "shouldUpdateOnProfileChange", "getShouldUpdateOnProfileChange", "setShouldUpdateOnProfileChange", "getPresetSizeInPixels", "forcePreset", "getProfilePictureUri", "Landroid/net/Uri;", "accessToken", "initialize", "", "isUnspecifiedDimensions", "onDetachedFromWindow", "onLayout", "changed", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onRestoreInstanceState", "state", "Landroid/os/Parcelable;", "onSaveInstanceState", "parseAttributes", "processResponse", "response", "Lcom/facebook/internal/ImageResponse;", "refreshImage", "force", "sendImageRequest", "allowCachedResponse", "setBlankProfilePicture", "setDefaultProfilePicture", "inputBitmap", "setImageBitmap", "imageBitmap", "updateImageQueryParameters", "Companion", "OnErrorListener", "facebook-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ProfilePictureView.kt */
public final class ProfilePictureView extends FrameLayout {
    public static final String TAG;
    public Bitmap customizedDefaultProfilePicture;
    public final ImageView image = new ImageView(getContext());
    public Bitmap imageContents;
    public boolean isCropped = true;
    public ImageRequest lastRequest;
    public OnErrorListener onErrorListener;
    public int presetSize = -1;
    public String profileId;
    public ProfileTracker profileTracker;
    public int queryHeight;
    public int queryWidth;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/facebook/login/widget/ProfilePictureView$OnErrorListener;", "", "onError", "", "error", "Lcom/facebook/FacebookException;", "facebook-login_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: ProfilePictureView.kt */
    public interface OnErrorListener {
        void onError(FacebookException facebookException);
    }

    static {
        String simpleName = ProfilePictureView.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "ProfilePictureView::class.java.simpleName");
        TAG = simpleName;
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public ProfilePictureView(Context context, AttributeSet attributeSet) {
        // Intrinsics.checkNotNullParameter(context, "context");
        // Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        super(context, attributeSet);
        initialize();
        parseAttributes(attributeSet);
    }

    /* renamed from: sendImageRequest$lambda-2  reason: not valid java name */
    public static final void m79sendImageRequest$lambda2(ProfilePictureView profilePictureView, ImageResponse imageResponse) {
        Intrinsics.checkNotNullParameter(profilePictureView, "this$0");
        if (!CrashShieldHandler.isObjectCrashing(profilePictureView) && imageResponse != null) {
            try {
                if (Intrinsics.areEqual(imageResponse.request, profilePictureView.lastRequest)) {
                    profilePictureView.lastRequest = null;
                    Bitmap bitmap = imageResponse.bitmap;
                    Exception exc = imageResponse.error;
                    if (exc != null) {
                        OnErrorListener onErrorListener2 = profilePictureView.onErrorListener;
                        if (onErrorListener2 != null) {
                            onErrorListener2.onError(new FacebookException(Intrinsics.stringPlus("Error in downloading profile picture for profileId: ", profilePictureView.profileId), exc));
                        } else {
                            Logger.Companion.log(LoggingBehavior.REQUESTS, 6, TAG, exc.toString());
                        }
                    } else if (bitmap != null) {
                        profilePictureView.setImageBitmap(bitmap);
                        if (imageResponse.isCachedRedirect) {
                            profilePictureView.sendImageRequest(false);
                        }
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, profilePictureView);
            }
        }
    }

    private final void setImageBitmap(Bitmap bitmap) {
        if (!CrashShieldHandler.isObjectCrashing(this) && bitmap != null) {
            try {
                this.imageContents = bitmap;
                this.image.setImageBitmap(bitmap);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public final OnErrorListener getOnErrorListener() {
        return this.onErrorListener;
    }

    public final int getPresetSize() {
        return this.presetSize;
    }

    public final int getPresetSizeInPixels(boolean z) {
        int i;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return 0;
        }
        try {
            if (this.presetSize == -1 && !z) {
                return 0;
            }
            int i2 = this.presetSize;
            if (i2 == -4) {
                i = R$dimen.com_facebook_profilepictureview_preset_size_large;
            } else if (i2 == -3) {
                i = R$dimen.com_facebook_profilepictureview_preset_size_normal;
            } else if (i2 == -2) {
                i = R$dimen.com_facebook_profilepictureview_preset_size_small;
            } else if (i2 != -1) {
                return 0;
            } else {
                i = R$dimen.com_facebook_profilepictureview_preset_size_normal;
            }
            return getResources().getDimensionPixelSize(i);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return 0;
        }
    }

    public final String getProfileId() {
        return this.profileId;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002a, code lost:
        if ((r1 != null && r1.equals("instagram")) != false) goto L_0x002e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.net.Uri getProfilePictureUri(java.lang.String r5) {
        /*
            r4 = this;
            com.facebook.Profile r0 = com.facebook.Profile.Companion
            com.facebook.Profile r0 = com.facebook.Profile.getCurrentProfile()
            if (r0 == 0) goto L_0x0057
            com.facebook.AccessToken$Companion r1 = com.facebook.AccessToken.Companion
            com.facebook.AccessTokenManager$Companion r1 = com.facebook.AccessTokenManager.Companion
            com.facebook.AccessTokenManager r1 = r1.getInstance()
            com.facebook.AccessToken r1 = r1.currentAccessTokenField
            r2 = 1
            if (r1 == 0) goto L_0x002d
            boolean r3 = r1.isExpired()
            if (r3 != 0) goto L_0x002d
            java.lang.String r1 = r1.graphDomain
            if (r1 == 0) goto L_0x0029
            java.lang.String r3 = "instagram"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0029
            r1 = 1
            goto L_0x002a
        L_0x0029:
            r1 = 0
        L_0x002a:
            if (r1 == 0) goto L_0x002d
            goto L_0x002e
        L_0x002d:
            r2 = 0
        L_0x002e:
            if (r2 == 0) goto L_0x0057
            int r5 = r4.queryWidth
            int r1 = r4.queryHeight
            android.net.Uri r2 = r0.pictureUri
            if (r2 == 0) goto L_0x0039
            goto L_0x0061
        L_0x0039:
            com.facebook.AccessToken$Companion r2 = com.facebook.AccessToken.Companion
            boolean r2 = com.facebook.AccessToken.Companion.isCurrentAccessTokenActive()
            if (r2 == 0) goto L_0x004e
            com.facebook.AccessToken$Companion r2 = com.facebook.AccessToken.Companion
            com.facebook.AccessToken r2 = com.facebook.AccessToken.Companion.getCurrentAccessToken()
            if (r2 != 0) goto L_0x004b
            r2 = 0
            goto L_0x0050
        L_0x004b:
            java.lang.String r2 = r2.token
            goto L_0x0050
        L_0x004e:
            java.lang.String r2 = ""
        L_0x0050:
            java.lang.String r0 = r0.id
            android.net.Uri r2 = com.facebook.internal.ImageRequest.getProfilePictureUri(r0, r5, r1, r2)
            goto L_0x0061
        L_0x0057:
            java.lang.String r0 = r4.profileId
            int r1 = r4.queryWidth
            int r2 = r4.queryHeight
            android.net.Uri r2 = com.facebook.internal.ImageRequest.getProfilePictureUri(r0, r1, r2, r5)
        L_0x0061:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.login.widget.ProfilePictureView.getProfilePictureUri(java.lang.String):android.net.Uri");
    }

    public final boolean getShouldUpdateOnProfileChange() {
        ProfileTracker profileTracker2 = this.profileTracker;
        if (profileTracker2 == null) {
            return false;
        }
        return profileTracker2.isTracking;
    }

    public final void initialize() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                removeAllViews();
                this.image.setLayoutParams(new LayoutParams(-1, -1));
                this.image.setScaleType(ScaleType.CENTER_INSIDE);
                addView(this.image);
                this.profileTracker = new ProfilePictureView$initialize$1(this);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.lastRequest = null;
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        refreshImage(false);
    }

    public void onMeasure(int i, int i2) {
        boolean z;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        int size = MeasureSpec.getSize(i2);
        int size2 = MeasureSpec.getSize(i);
        boolean z2 = true;
        if (MeasureSpec.getMode(i2) == 1073741824 || layoutParams.height != -2) {
            z = false;
        } else {
            size = getPresetSizeInPixels(true);
            i2 = MeasureSpec.makeMeasureSpec(size, 1073741824);
            z = true;
        }
        if (MeasureSpec.getMode(i) == 1073741824 || layoutParams.width != -2) {
            z2 = z;
        } else {
            size2 = getPresetSizeInPixels(true);
            i = MeasureSpec.makeMeasureSpec(size2, 1073741824);
        }
        if (z2) {
            setMeasuredDimension(size2, size);
            measureChildren(i, i2);
            return;
        }
        super.onMeasure(i, i2);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        Intrinsics.checkNotNullParameter(parcelable, "state");
        if (!Intrinsics.areEqual(parcelable.getClass(), Bundle.class)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        super.onRestoreInstanceState(bundle.getParcelable("ProfilePictureView_superState"));
        setProfileId(bundle.getString("ProfilePictureView_profileId"));
        setPresetSize(bundle.getInt("ProfilePictureView_presetSize"));
        setCropped(bundle.getBoolean("ProfilePictureView_isCropped"));
        this.queryWidth = bundle.getInt("ProfilePictureView_width");
        this.queryHeight = bundle.getInt("ProfilePictureView_height");
        refreshImage(true);
    }

    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        Bundle bundle = new Bundle();
        bundle.putParcelable("ProfilePictureView_superState", onSaveInstanceState);
        bundle.putString("ProfilePictureView_profileId", this.profileId);
        bundle.putInt("ProfilePictureView_presetSize", this.presetSize);
        bundle.putBoolean("ProfilePictureView_isCropped", this.isCropped);
        bundle.putInt("ProfilePictureView_width", this.queryWidth);
        bundle.putInt("ProfilePictureView_height", this.queryHeight);
        bundle.putBoolean("ProfilePictureView_refresh", this.lastRequest != null);
        return bundle;
    }

    public final void parseAttributes(AttributeSet attributeSet) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.com_facebook_profile_picture_view);
                Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttributes(attrs, R.styleable.com_facebook_profile_picture_view)");
                setPresetSize(obtainStyledAttributes.getInt(R$styleable.com_facebook_profile_picture_view_com_facebook_preset_size, -1));
                setCropped(obtainStyledAttributes.getBoolean(R$styleable.com_facebook_profile_picture_view_com_facebook_is_cropped, true));
                obtainStyledAttributes.recycle();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public final void refreshImage(boolean z) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                boolean updateImageQueryParameters = updateImageQueryParameters();
                String str = this.profileId;
                if (str != null) {
                    boolean z2 = false;
                    if (!(str.length() == 0)) {
                        if (this.queryWidth == 0 && this.queryHeight == 0) {
                            z2 = true;
                        }
                        if (!z2) {
                            if (updateImageQueryParameters || z) {
                                sendImageRequest(true);
                            }
                        }
                    }
                }
                setBlankProfilePicture();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public final void sendImageRequest(boolean z) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Companion companion = AccessToken.Companion;
                String str = "";
                if (Companion.isCurrentAccessTokenActive()) {
                    Companion companion2 = AccessToken.Companion;
                    AccessToken currentAccessToken = Companion.getCurrentAccessToken();
                    if (currentAccessToken != null) {
                        String str2 = currentAccessToken.token;
                        if (str2 != null) {
                            str = str2;
                        }
                    }
                }
                Uri profilePictureUri = getProfilePictureUri(str);
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(profilePictureUri, "imageUri");
                ImageRequest imageRequest = new ImageRequest(context, profilePictureUri, new Callback() {
                    public final void onCompleted(ImageResponse imageResponse) {
                        ProfilePictureView.m79sendImageRequest$lambda2(ProfilePictureView.this, imageResponse);
                    }
                }, z, this, null);
                ImageRequest imageRequest2 = this.lastRequest;
                if (imageRequest2 != null) {
                    ImageDownloader imageDownloader = ImageDownloader.INSTANCE;
                    ImageDownloader.cancelRequest(imageRequest2);
                }
                this.lastRequest = imageRequest;
                ImageDownloader imageDownloader2 = ImageDownloader.INSTANCE;
                ImageDownloader.downloadAsync(imageRequest);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public final void setBlankProfilePicture() {
        int i;
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                ImageRequest imageRequest = this.lastRequest;
                if (imageRequest != null) {
                    ImageDownloader imageDownloader = ImageDownloader.INSTANCE;
                    ImageDownloader.cancelRequest(imageRequest);
                }
                Bitmap bitmap = this.customizedDefaultProfilePicture;
                if (bitmap == null) {
                    if (this.isCropped) {
                        i = R$drawable.com_facebook_profile_picture_blank_square;
                    } else {
                        i = R$drawable.com_facebook_profile_picture_blank_portrait;
                    }
                    setImageBitmap(BitmapFactory.decodeResource(getResources(), i));
                } else {
                    updateImageQueryParameters();
                    setImageBitmap(Bitmap.createScaledBitmap(bitmap, this.queryWidth, this.queryHeight, false));
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public final void setCropped(boolean z) {
        this.isCropped = z;
        refreshImage(false);
    }

    public final void setDefaultProfilePicture(Bitmap bitmap) {
        this.customizedDefaultProfilePicture = bitmap;
    }

    public final void setOnErrorListener(OnErrorListener onErrorListener2) {
        this.onErrorListener = onErrorListener2;
    }

    public final void setPresetSize(int i) {
        if (i == -4 || i == -3 || i == -2 || i == -1) {
            this.presetSize = i;
            requestLayout();
            return;
        }
        throw new IllegalArgumentException("Must use a predefined preset size");
    }

    public final void setProfileId(String str) {
        String str2 = this.profileId;
        boolean z = false;
        if ((str2 == null || str2.length() == 0) || !CharsKt__CharKt.equals(this.profileId, str, true)) {
            setBlankProfilePicture();
            z = true;
        }
        this.profileId = str;
        refreshImage(z);
    }

    public final void setShouldUpdateOnProfileChange(boolean z) {
        if (z) {
            ProfileTracker profileTracker2 = this.profileTracker;
            if (profileTracker2 != null) {
                profileTracker2.startTracking();
                return;
            }
            return;
        }
        ProfileTracker profileTracker3 = this.profileTracker;
        if (profileTracker3 != null && profileTracker3.isTracking) {
            profileTracker3.broadcastManager.unregisterReceiver(profileTracker3.receiver);
            profileTracker3.isTracking = false;
        }
    }

    public final boolean updateImageQueryParameters() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            int height = getHeight();
            int width = getWidth();
            boolean z = true;
            if (width >= 1) {
                if (height >= 1) {
                    int presetSizeInPixels = getPresetSizeInPixels(false);
                    if (presetSizeInPixels != 0) {
                        height = presetSizeInPixels;
                        width = height;
                    }
                    if (width <= height) {
                        height = this.isCropped ? width : 0;
                    } else {
                        width = this.isCropped ? height : 0;
                    }
                    if (width == this.queryWidth) {
                        if (height == this.queryHeight) {
                            z = false;
                        }
                    }
                    this.queryWidth = width;
                    this.queryHeight = height;
                    return z;
                }
            }
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public ProfilePictureView(Context context, AttributeSet attributeSet, int i) {
        // Intrinsics.checkNotNullParameter(context, "context");
        // Intrinsics.checkNotNullParameter(attributeSet, "attrs");
        super(context, attributeSet, i);
        initialize();
        parseAttributes(attributeSet);
    }
}

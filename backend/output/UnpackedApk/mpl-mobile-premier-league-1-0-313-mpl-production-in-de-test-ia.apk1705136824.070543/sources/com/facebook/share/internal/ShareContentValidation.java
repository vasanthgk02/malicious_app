package com.facebook.share.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.internal.Utility;
import com.facebook.share.model.ShareCameraEffectContent;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareMedia;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareStoryContent;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u00045678B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\b\u001a\u00020\t2\u0010\u0010\n\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u001a\u0010\u0010\u001a\u00020\t2\u0010\u0010\n\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u000bH\u0007J\u001a\u0010\u0011\u001a\u00020\t2\u0010\u0010\n\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u000bH\u0007J\u001a\u0010\u0012\u001a\u00020\t2\u0010\u0010\n\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u000bH\u0007J\u001a\u0010\u0013\u001a\u00020\t2\u0010\u0010\n\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u000bH\u0007J\u001a\u0010\u0014\u001a\u00020\t2\u0010\u0010\n\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u000bH\u0007J\u0018\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u0018\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\f\u001a\u00020\u0004H\u0002J \u0010\u001b\u001a\u00020\t2\u000e\u0010\u001c\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u001d2\u0006\u0010\f\u001a\u00020\u0004H\u0007J\u0012\u0010\u001e\u001a\u00020\t2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002J\u0018\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u0018\u0010$\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u0018\u0010%\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u0018\u0010&\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u0012\u0010'\u001a\u00020\t2\b\u0010(\u001a\u0004\u0018\u00010)H\u0002J\u0010\u0010*\u001a\u00020\t2\u0006\u0010(\u001a\u00020+H\u0002J\u001a\u0010,\u001a\u00020\t2\b\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u001a\u0010/\u001a\u00020\t2\b\u00100\u001a\u0004\u0018\u0001012\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u0018\u00102\u001a\u00020\t2\u0006\u00103\u001a\u0002042\u0006\u0010\f\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/facebook/share/internal/ShareContentValidation;", "", "()V", "apiValidator", "Lcom/facebook/share/internal/ShareContentValidation$Validator;", "defaultValidator", "storyValidator", "webShareValidator", "validate", "", "content", "Lcom/facebook/share/model/ShareContent;", "validator", "validateCameraEffectContent", "cameraEffectContent", "Lcom/facebook/share/model/ShareCameraEffectContent;", "validateForApiShare", "validateForMessage", "validateForNativeShare", "validateForStoryShare", "validateForWebShare", "validateLinkContent", "linkContent", "Lcom/facebook/share/model/ShareLinkContent;", "validateMediaContent", "mediaContent", "Lcom/facebook/share/model/ShareMediaContent;", "validateMedium", "medium", "Lcom/facebook/share/model/ShareMedia;", "validatePhoto", "photo", "Lcom/facebook/share/model/SharePhoto;", "validatePhotoContent", "photoContent", "Lcom/facebook/share/model/SharePhotoContent;", "validatePhotoForApi", "validatePhotoForNativeDialog", "validatePhotoForWebDialog", "validateShareMessengerActionButton", "button", "Lcom/facebook/share/model/ShareMessengerActionButton;", "validateShareMessengerURLActionButton", "Lcom/facebook/share/model/ShareMessengerURLActionButton;", "validateStoryContent", "storyContent", "Lcom/facebook/share/model/ShareStoryContent;", "validateVideo", "video", "Lcom/facebook/share/model/ShareVideo;", "validateVideoContent", "videoContent", "Lcom/facebook/share/model/ShareVideoContent;", "ApiValidator", "StoryShareValidator", "Validator", "WebShareValidator", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ShareContentValidation.kt */
public final class ShareContentValidation {
    public static final ShareContentValidation INSTANCE = new ShareContentValidation();
    public static final Validator defaultValidator = new Validator();
    public static final Validator storyValidator = new StoryShareValidator();
    public static final Validator webShareValidator = new WebShareValidator();

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/facebook/share/internal/ShareContentValidation$StoryShareValidator;", "Lcom/facebook/share/internal/ShareContentValidation$Validator;", "()V", "validate", "", "storyContent", "Lcom/facebook/share/model/ShareStoryContent;", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: ShareContentValidation.kt */
    public static final class StoryShareValidator extends Validator {
        public void validate(ShareStoryContent shareStoryContent) {
            if (shareStoryContent.backgroundAsset == null && shareStoryContent.stickerAsset == null) {
                throw new FacebookException((String) "Must pass the Facebook app a background asset, a sticker asset, or both");
            }
            ShareMedia<?, ?> shareMedia = shareStoryContent.backgroundAsset;
            if (shareMedia != null) {
                validate(shareMedia);
            }
            SharePhoto sharePhoto = shareStoryContent.stickerAsset;
            if (sharePhoto != null) {
                validate(sharePhoto);
            }
        }
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\u0003\u001a\u00020\u00042\u000e\u0010\t\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\nH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0016H\u0016¨\u0006\u0017"}, d2 = {"Lcom/facebook/share/internal/ShareContentValidation$Validator;", "", "()V", "validate", "", "cameraEffectContent", "Lcom/facebook/share/model/ShareCameraEffectContent;", "linkContent", "Lcom/facebook/share/model/ShareLinkContent;", "medium", "Lcom/facebook/share/model/ShareMedia;", "mediaContent", "Lcom/facebook/share/model/ShareMediaContent;", "photo", "Lcom/facebook/share/model/SharePhoto;", "photoContent", "Lcom/facebook/share/model/SharePhotoContent;", "storyContent", "Lcom/facebook/share/model/ShareStoryContent;", "video", "Lcom/facebook/share/model/ShareVideo;", "videoContent", "Lcom/facebook/share/model/ShareVideoContent;", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: ShareContentValidation.kt */
    public static class Validator {
        public void validate(ShareMedia<?, ?> shareMedia) {
            Intrinsics.checkNotNullParameter(shareMedia, "medium");
            Intrinsics.checkNotNullParameter(shareMedia, "medium");
            Intrinsics.checkNotNullParameter(this, "validator");
            if (shareMedia instanceof SharePhoto) {
                validate((SharePhoto) shareMedia);
            } else if (shareMedia instanceof ShareVideo) {
                validate((ShareVideo) shareMedia);
            } else {
                String format = String.format(Locale.ROOT, "Invalid media type: %s", Arrays.copyOf(new Object[]{shareMedia.getClass().getSimpleName()}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
                throw new FacebookException(format);
            }
        }

        public void validate(ShareMediaContent shareMediaContent) {
            Intrinsics.checkNotNullParameter(shareMediaContent, "mediaContent");
            List<ShareMedia<?, ?>> list = shareMediaContent.media;
            if (list == null || list.isEmpty()) {
                throw new FacebookException((String) "Must specify at least one medium in ShareMediaContent.");
            } else if (list.size() <= 6) {
                for (ShareMedia<?, ?> validate : list) {
                    validate(validate);
                }
            } else {
                String format = String.format(Locale.ROOT, "Cannot add more than %d media.", Arrays.copyOf(new Object[]{Integer.valueOf(6)}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
                throw new FacebookException(format);
            }
        }

        public void validate(ShareStoryContent shareStoryContent) {
            if (shareStoryContent.backgroundAsset == null && shareStoryContent.stickerAsset == null) {
                throw new FacebookException((String) "Must pass the Facebook app a background asset, a sticker asset, or both");
            }
            ShareMedia<?, ?> shareMedia = shareStoryContent.backgroundAsset;
            if (shareMedia != null) {
                validate(shareMedia);
            }
            SharePhoto sharePhoto = shareStoryContent.stickerAsset;
            if (sharePhoto != null) {
                validate(sharePhoto);
            }
        }

        public void validate(ShareVideo shareVideo) {
            if (shareVideo != null) {
                Uri uri = shareVideo.localUrl;
                if (uri == null) {
                    throw new FacebookException((String) "ShareVideo does not have a LocalUrl specified");
                } else if (!Utility.isContentUri(uri) && !Utility.isFileUri(uri)) {
                    throw new FacebookException((String) "ShareVideo must reference a video that is on the device");
                }
            } else {
                throw new FacebookException((String) "Cannot share a null ShareVideo");
            }
        }

        public void validate(ShareLinkContent shareLinkContent) {
            Intrinsics.checkNotNullParameter(shareLinkContent, "linkContent");
            Uri uri = shareLinkContent.contentUrl;
            if (uri != null && !Utility.isWebUri(uri)) {
                throw new FacebookException((String) "Content Url must be an http:// or https:// url");
            }
        }

        public void validate(ShareVideoContent shareVideoContent) {
            Intrinsics.checkNotNullParameter(shareVideoContent, "videoContent");
            validate(shareVideoContent.video);
            SharePhoto sharePhoto = shareVideoContent.previewPhoto;
            if (sharePhoto != null) {
                validate(sharePhoto);
            }
        }

        public void validate(SharePhoto sharePhoto) {
            Intrinsics.checkNotNullParameter(sharePhoto, "photo");
            ShareContentValidation.INSTANCE.validatePhotoForApi(sharePhoto);
            if (sharePhoto.bitmap != null || !Utility.isWebUri(sharePhoto.imageUrl)) {
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                Context applicationContext = FacebookSdk.getApplicationContext();
                Intrinsics.checkNotNullParameter(applicationContext, "context");
                FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
                String applicationId = FacebookSdk.getApplicationId();
                PackageManager packageManager = applicationContext.getPackageManager();
                if (packageManager != null) {
                    String stringPlus = Intrinsics.stringPlus("com.facebook.app.FacebookContentProvider", applicationId);
                    if (packageManager.resolveContentProvider(stringPlus, 0) == null) {
                        throw new IllegalStateException(GeneratedOutlineSupport.outline70(new Object[]{stringPlus}, 1, "A ContentProvider for this app was not set up in the AndroidManifest.xml, please add %s as a provider to your AndroidManifest.xml file. See https://developers.facebook.com/docs/sharing/android for more info.", "java.lang.String.format(format, *args)").toString());
                    }
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/facebook/share/internal/ShareContentValidation$WebShareValidator;", "Lcom/facebook/share/internal/ShareContentValidation$Validator;", "()V", "validate", "", "mediaContent", "Lcom/facebook/share/model/ShareMediaContent;", "photo", "Lcom/facebook/share/model/SharePhoto;", "videoContent", "Lcom/facebook/share/model/ShareVideoContent;", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: ShareContentValidation.kt */
    public static final class WebShareValidator extends Validator {
        public void validate(SharePhoto sharePhoto) {
            Intrinsics.checkNotNullParameter(sharePhoto, "photo");
            Bitmap bitmap = sharePhoto.bitmap;
            Uri uri = sharePhoto.imageUrl;
            if (bitmap == null && uri == null) {
                throw new FacebookException((String) "SharePhoto does not have a Bitmap or ImageUrl specified");
            }
        }

        public void validate(ShareVideoContent shareVideoContent) {
            Intrinsics.checkNotNullParameter(shareVideoContent, "videoContent");
            throw new FacebookException((String) "Cannot share ShareVideoContent via web sharing dialogs");
        }

        public void validate(ShareMediaContent shareMediaContent) {
            Intrinsics.checkNotNullParameter(shareMediaContent, "mediaContent");
            throw new FacebookException((String) "Cannot share ShareMediaContent via web sharing dialogs");
        }
    }

    public final void validate(ShareContent<?, ?> shareContent, Validator validator) throws FacebookException {
        if (shareContent == null) {
            throw new FacebookException((String) "Must provide non-null content to share");
        } else if (shareContent instanceof ShareLinkContent) {
            validator.validate((ShareLinkContent) shareContent);
        } else if (shareContent instanceof SharePhotoContent) {
            SharePhotoContent sharePhotoContent = (SharePhotoContent) shareContent;
            Intrinsics.checkNotNullParameter(sharePhotoContent, "photoContent");
            List<SharePhoto> list = sharePhotoContent.photos;
            if (list == null || list.isEmpty()) {
                throw new FacebookException((String) "Must specify at least one Photo in SharePhotoContent.");
            } else if (list.size() <= 6) {
                for (SharePhoto validate : list) {
                    validator.validate(validate);
                }
            } else {
                String format = String.format(Locale.ROOT, "Cannot add more than %d photos.", Arrays.copyOf(new Object[]{Integer.valueOf(6)}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
                throw new FacebookException(format);
            }
        } else if (shareContent instanceof ShareVideoContent) {
            validator.validate((ShareVideoContent) shareContent);
        } else if (shareContent instanceof ShareMediaContent) {
            validator.validate((ShareMediaContent) shareContent);
        } else if (shareContent instanceof ShareCameraEffectContent) {
            ShareCameraEffectContent shareCameraEffectContent = (ShareCameraEffectContent) shareContent;
            Intrinsics.checkNotNullParameter(shareCameraEffectContent, "cameraEffectContent");
            if (Utility.isNullOrEmpty(shareCameraEffectContent.effectId)) {
                throw new FacebookException((String) "Must specify a non-empty effectId");
            }
        } else if (shareContent instanceof ShareStoryContent) {
            validator.validate((ShareStoryContent) shareContent);
        }
    }

    public final void validatePhoto(SharePhoto sharePhoto) {
        if (sharePhoto != null) {
            Bitmap bitmap = sharePhoto.bitmap;
            Uri uri = sharePhoto.imageUrl;
            if (bitmap == null && uri == null) {
                throw new FacebookException((String) "SharePhoto does not have a Bitmap or ImageUrl specified");
            }
            return;
        }
        throw new FacebookException((String) "Cannot share a null SharePhoto");
    }

    public final void validatePhotoForApi(SharePhoto sharePhoto) {
        validatePhoto(sharePhoto);
        Bitmap bitmap = sharePhoto.bitmap;
        Uri uri = sharePhoto.imageUrl;
        if (bitmap == null && Utility.isWebUri(uri)) {
            throw new FacebookException((String) "Cannot set the ImageUrl of a SharePhoto to the Uri of an image on the web when sharing SharePhotoContent");
        }
    }
}

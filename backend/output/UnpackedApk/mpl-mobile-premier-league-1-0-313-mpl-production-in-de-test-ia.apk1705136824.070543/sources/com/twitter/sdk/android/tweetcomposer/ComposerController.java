package com.twitter.sdk.android.tweetcomposer;

import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.text.TextUtils;
import com.twitter.Validator;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.models.User;
import com.twitter.sdk.android.core.services.AccountService;
import com.twitter.sdk.android.tweetcomposer.ComposerActivity.Finisher;
import org.apache.fontbox.cmap.CMap;

public class ComposerController {
    public final ComposerView composerView;
    public final DependencyProvider dependencyProvider;
    public final Finisher finisher;
    public final Uri imageUri;
    public final TwitterSession session;

    public interface ComposerCallbacks {
    }

    public class ComposerCallbacksImpl implements ComposerCallbacks {
        public ComposerCallbacksImpl() {
        }

        public void onCloseClick() {
            ComposerController.this.onClose();
        }

        public void onTweetPost(String str) {
            Intent intent = new Intent(ComposerController.this.composerView.getContext(), TweetUploadService.class);
            intent.putExtra("EXTRA_USER_TOKEN", (Parcelable) ComposerController.this.session.authToken);
            intent.putExtra("EXTRA_TWEET_TEXT", str);
            intent.putExtra("EXTRA_IMAGE_URI", ComposerController.this.imageUri);
            ComposerController.this.composerView.getContext().startService(intent);
            ComposerActivity.this.finish();
        }
    }

    public static class DependencyProvider {
        public final Validator tweetValidator = new Validator();
    }

    public ComposerController(ComposerView composerView2, TwitterSession twitterSession, Uri uri, String str, String str2, Finisher finisher2) {
        DependencyProvider dependencyProvider2 = new DependencyProvider();
        this.composerView = composerView2;
        this.session = twitterSession;
        this.imageUri = uri;
        this.finisher = finisher2;
        this.dependencyProvider = dependencyProvider2;
        composerView2.setCallbacks(new ComposerCallbacksImpl());
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            if (sb.length() > 0) {
                sb.append(CMap.SPACE);
            }
            sb.append(str2);
        }
        composerView2.setTweetText(sb.toString());
        DependencyProvider dependencyProvider3 = this.dependencyProvider;
        TwitterSession twitterSession2 = this.session;
        if (dependencyProvider3 != null) {
            ((AccountService) TwitterCore.getInstance().getApiClient(twitterSession2).getService(AccountService.class)).verifyCredentials(Boolean.FALSE, Boolean.TRUE, Boolean.FALSE).enqueue(new Callback<User>() {
                public void failure(TwitterException twitterException) {
                    ComposerController.this.composerView.setProfilePhotoView(null);
                }

                public void success(Result<User> result) {
                    ComposerController.this.composerView.setProfilePhotoView((User) result.data);
                }
            });
            if (uri != null) {
                this.composerView.setImageView(uri);
                return;
            }
            return;
        }
        throw null;
    }

    public void onClose() {
        Intent intent = new Intent("com.twitter.sdk.android.tweetcomposer.TWEET_COMPOSE_CANCEL");
        intent.setPackage(this.composerView.getContext().getPackageName());
        this.composerView.getContext().sendBroadcast(intent);
        ComposerActivity.this.finish();
    }
}

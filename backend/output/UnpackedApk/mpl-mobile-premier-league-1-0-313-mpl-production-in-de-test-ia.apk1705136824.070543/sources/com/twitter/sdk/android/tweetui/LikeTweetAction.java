package com.twitter.sdk.android.tweetui;

import android.view.View;
import android.view.View.OnClickListener;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterApiException;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.models.ApiError;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.core.models.TweetBuilder;
import com.twitter.sdk.android.core.services.FavoriteService;
import com.twitter.sdk.android.tweetui.TweetRepository.AnonymousClass1;
import com.twitter.sdk.android.tweetui.TweetRepository.AnonymousClass2;

public class LikeTweetAction extends BaseTweetAction implements OnClickListener {
    public final Tweet tweet;
    public final TweetRepository tweetRepository;

    public static class LikeCallback extends Callback<Tweet> {
        public final ToggleImageButton button;
        public final Callback<Tweet> cb;
        public final Tweet tweet;

        public LikeCallback(ToggleImageButton toggleImageButton, Tweet tweet2, Callback<Tweet> callback) {
            this.button = toggleImageButton;
            this.tweet = tweet2;
            this.cb = callback;
        }

        public void failure(TwitterException twitterException) {
            if (twitterException instanceof TwitterApiException) {
                ApiError apiError = ((TwitterApiException) twitterException).apiError;
                int i = apiError == null ? 0 : apiError.code;
                if (i == 139) {
                    TweetBuilder tweetBuilder = new TweetBuilder();
                    tweetBuilder.copy(this.tweet);
                    tweetBuilder.favorited = true;
                    this.cb.success(new Result(tweetBuilder.build(), null));
                } else if (i != 144) {
                    this.button.setToggledOn(this.tweet.favorited);
                    this.cb.failure(twitterException);
                } else {
                    TweetBuilder tweetBuilder2 = new TweetBuilder();
                    tweetBuilder2.copy(this.tweet);
                    tweetBuilder2.favorited = false;
                    this.cb.success(new Result(tweetBuilder2.build(), null));
                }
            } else {
                this.button.setToggledOn(this.tweet.favorited);
                this.cb.failure(twitterException);
            }
        }

        public void success(Result<Tweet> result) {
            this.cb.success(result);
        }
    }

    public LikeTweetAction(Tweet tweet2, TweetUi tweetUi, Callback<Tweet> callback) {
        super(callback);
        this.tweet = tweet2;
        this.tweetRepository = tweetUi.tweetRepository;
    }

    public void onClick(View view) {
        View view2 = view;
        if (view2 instanceof ToggleImageButton) {
            ToggleImageButton toggleImageButton = (ToggleImageButton) view2;
            Tweet tweet2 = this.tweet;
            if (tweet2.favorited) {
                TweetRepository tweetRepository2 = this.tweetRepository;
                long j = tweet2.id;
                LikeCallback likeCallback = new LikeCallback(toggleImageButton, tweet2, this.actionCallback);
                AnonymousClass2 r4 = new LoggingCallback<TwitterSession>(likeCallback, Twitter.DEFAULT_LOGGER, j, likeCallback) {
                    public final /* synthetic */ Callback val$cb;
                    public final /* synthetic */ long val$tweetId;

                    {
                        this.val$tweetId = r4;
                        this.val$cb = r6;
                    }

                    public void success(Result<TwitterSession> result) {
                        ((FavoriteService) TweetRepository.this.twitterCore.getApiClient((TwitterSession) result.data).getService(FavoriteService.class)).destroy(Long.valueOf(this.val$tweetId), Boolean.FALSE).enqueue(this.val$cb);
                    }
                };
                tweetRepository2.getUserSession(r4);
                return;
            }
            TweetRepository tweetRepository3 = this.tweetRepository;
            long j2 = tweet2.id;
            LikeCallback likeCallback2 = new LikeCallback(toggleImageButton, tweet2, this.actionCallback);
            AnonymousClass1 r11 = new LoggingCallback<TwitterSession>(likeCallback2, Twitter.DEFAULT_LOGGER, j2, likeCallback2) {
                public final /* synthetic */ Callback val$cb;
                public final /* synthetic */ long val$tweetId;

                {
                    this.val$tweetId = r4;
                    this.val$cb = r6;
                }

                public void success(Result<TwitterSession> result) {
                    ((FavoriteService) TweetRepository.this.twitterCore.getApiClient((TwitterSession) result.data).getService(FavoriteService.class)).create(Long.valueOf(this.val$tweetId), Boolean.FALSE).enqueue(this.val$cb);
                }
            };
            tweetRepository3.getUserSession(r11);
        }
    }
}

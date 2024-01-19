package com.twitter.sdk.android.tweetui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.material.resources.TextAppearanceConfig;
import com.squareup.picasso.Picasso;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.PersistedSessionManager;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterApiClient;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.internal.UserUtils$AvatarSize;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.core.models.User;
import com.twitter.sdk.android.core.services.StatusesService;
import com.twitter.sdk.android.tweetui.AbstractTweetView.DependencyProvider;
import com.twitter.sdk.android.tweetui.TweetDateUtils.DateFormatter;
import com.twitter.sdk.android.tweetui.TweetRepository.SingleTweetCallback;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public abstract class BaseTweetView extends AbstractTweetView {
    public ColorDrawable avatarMediaBg;
    public ImageView avatarView;
    public int birdLogoResId;
    public View bottomSeparator;
    public int containerBgColor;
    public ViewGroup quoteTweetHolder;
    public QuoteTweetView quoteTweetView;
    public TextView retweetedByView;
    public TextView timestampView;
    public TweetActionBarView tweetActionBarView;
    public ImageView twitterLogoView;

    public BaseTweetView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void setStyleAttributes(TypedArray typedArray) {
        this.containerBgColor = typedArray.getColor(R$styleable.tw__TweetView_tw__container_bg_color, getResources().getColor(R$color.tw__tweet_light_container_bg_color));
        this.primaryTextColor = typedArray.getColor(R$styleable.tw__TweetView_tw__primary_text_color, getResources().getColor(R$color.tw__tweet_light_primary_text_color));
        this.actionColor = typedArray.getColor(R$styleable.tw__TweetView_tw__action_color, getResources().getColor(R$color.tw__tweet_action_color));
        this.actionHighlightColor = typedArray.getColor(R$styleable.tw__TweetView_tw__action_highlight_color, getResources().getColor(R$color.tw__tweet_action_light_highlight_color));
        boolean z = false;
        this.tweetActionsEnabled = typedArray.getBoolean(R$styleable.tw__TweetView_tw__tweet_actions_enabled, false);
        int i = this.containerBgColor;
        if ((((double) Color.blue(i)) * 0.07d) + (((double) Color.green(i)) * 0.72d) + (((double) Color.red(i)) * 0.21d) > 128.0d) {
            z = true;
        }
        if (z) {
            this.photoErrorResId = R$drawable.tw__ic_tweet_photo_error_light;
            this.birdLogoResId = R$drawable.tw__ic_logo_blue;
        } else {
            this.photoErrorResId = R$drawable.tw__ic_tweet_photo_error_dark;
            this.birdLogoResId = R$drawable.tw__ic_logo_white;
        }
        int i2 = -1;
        this.secondaryTextColor = TextAppearanceConfig.calculateOpacityTransform(z ? 0.4d : 0.35d, z ? -1 : -16777216, this.primaryTextColor);
        double d2 = z ? 0.08d : 0.12d;
        if (z) {
            i2 = -16777216;
        }
        this.mediaBgColor = TextAppearanceConfig.calculateOpacityTransform(d2, i2, this.containerBgColor);
        this.avatarMediaBg = new ColorDrawable(this.mediaBgColor);
    }

    private void setTimestamp(Tweet tweet) {
        String str;
        String str2;
        String format;
        if (tweet != null) {
            String str3 = tweet.createdAt;
            if (str3 != null) {
                if (TweetDateUtils.apiTimeToLong(str3) != -1) {
                    Long valueOf = Long.valueOf(TweetDateUtils.apiTimeToLong(tweet.createdAt));
                    Resources resources = getResources();
                    long currentTimeMillis = System.currentTimeMillis();
                    long longValue = valueOf.longValue();
                    long j = currentTimeMillis - longValue;
                    if (j < 0) {
                        str2 = TweetDateUtils.RELATIVE_DATE_FORMAT.formatLongDateString(resources, new Date(longValue));
                    } else if (j < 60000) {
                        int i = (int) (j / 1000);
                        str2 = resources.getQuantityString(R$plurals.tw__time_secs, i, new Object[]{Integer.valueOf(i)});
                    } else if (j < 3600000) {
                        int i2 = (int) (j / 60000);
                        str2 = resources.getQuantityString(R$plurals.tw__time_mins, i2, new Object[]{Integer.valueOf(i2)});
                    } else if (j < 86400000) {
                        int i3 = (int) (j / 3600000);
                        str2 = resources.getQuantityString(R$plurals.tw__time_hours, i3, new Object[]{Integer.valueOf(i3)});
                    } else {
                        Calendar instance = Calendar.getInstance();
                        instance.setTimeInMillis(currentTimeMillis);
                        Calendar instance2 = Calendar.getInstance();
                        instance2.setTimeInMillis(longValue);
                        Date date = new Date(longValue);
                        if (instance.get(1) == instance2.get(1)) {
                            DateFormatter dateFormatter = TweetDateUtils.RELATIVE_DATE_FORMAT;
                            synchronized (dateFormatter) {
                                format = dateFormatter.getDateFormat(resources, R$string.tw__relative_date_format_short).format(date);
                            }
                            str2 = format;
                        } else {
                            str2 = TweetDateUtils.RELATIVE_DATE_FORMAT.formatLongDateString(resources, date);
                        }
                    }
                    str = GeneratedOutlineSupport.outline50("• ", str2);
                    this.timestampView.setText(str);
                }
            }
        }
        str = "";
        this.timestampView.setText(str);
    }

    private void setXmlDataAttributes(TypedArray typedArray) {
        Long l;
        try {
            l = Long.valueOf(Long.parseLong(typedArray.getString(R$styleable.tw__TweetView_tw__tweet_id)));
        } catch (NumberFormatException unused) {
            l = Long.valueOf(-1);
        }
        long longValue = l.longValue();
        if (longValue > 0) {
            setPermalinkUri(null, Long.valueOf(longValue));
            Tweet tweet = new Tweet(null, null, null, null, null, null, false, null, longValue, null, null, 0, null, 0, null, null, null, false, null, 0, null, null, 0, false, null, null, null, null, false, null, false, null, null, null);
            this.tweet = tweet;
            return;
        }
        throw new IllegalArgumentException("Invalid tw__tweet_id");
    }

    public void applyStyles() {
        setBackgroundColor(this.containerBgColor);
        this.fullNameView.setTextColor(this.primaryTextColor);
        this.screenNameView.setTextColor(this.secondaryTextColor);
        this.contentView.setTextColor(this.primaryTextColor);
        this.tweetMediaView.setMediaBgColor(this.mediaBgColor);
        this.tweetMediaView.setPhotoErrorResId(this.photoErrorResId);
        this.avatarView.setImageDrawable(this.avatarMediaBg);
        this.timestampView.setTextColor(this.secondaryTextColor);
        this.twitterLogoView.setImageResource(this.birdLogoResId);
        this.retweetedByView.setTextColor(this.secondaryTextColor);
    }

    public void findSubviews() {
        super.findSubviews();
        this.avatarView = (ImageView) findViewById(R$id.tw__tweet_author_avatar);
        this.timestampView = (TextView) findViewById(R$id.tw__tweet_timestamp);
        this.twitterLogoView = (ImageView) findViewById(R$id.tw__twitter_logo);
        this.retweetedByView = (TextView) findViewById(R$id.tw__tweet_retweeted_by);
        this.tweetActionBarView = (TweetActionBarView) findViewById(R$id.tw__tweet_action_bar);
        this.quoteTweetHolder = (ViewGroup) findViewById(R$id.quote_tweet_holder);
        this.bottomSeparator = findViewById(R$id.bottom_separator);
    }

    public /* bridge */ /* synthetic */ Tweet getTweet() {
        return super.getTweet();
    }

    public /* bridge */ /* synthetic */ long getTweetId() {
        return super.getTweetId();
    }

    public /* synthetic */ void lambda$linkifyProfilePhotoView$0$BaseTweetView(Tweet tweet, View view) {
        TweetLinkClickListener tweetLinkClickListener = this.tweetLinkClickListener;
        if (tweetLinkClickListener != null) {
            tweetLinkClickListener.onLinkClick(tweet, TweetUtils.getProfilePermalink(tweet.user.screenName));
            return;
        }
        if (!TextAppearanceConfig.safeStartActivity(getContext(), new Intent("android.intent.action.VIEW", Uri.parse(TweetUtils.getProfilePermalink(tweet.user.screenName))))) {
            Twitter.getLogger().e("TweetUi", "Activity cannot be found to open URL");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000d, code lost:
        if (r4 != 3) goto L_0x0034;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ boolean lambda$linkifyProfilePhotoView$1$BaseTweetView(android.view.View r3, android.view.MotionEvent r4) {
        /*
            r2 = this;
            r0 = r3
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            int r4 = r4.getAction()
            if (r4 == 0) goto L_0x001e
            r1 = 1
            if (r4 == r1) goto L_0x0010
            r3 = 3
            if (r4 == r3) goto L_0x0013
            goto L_0x0034
        L_0x0010:
            r3.performClick()
        L_0x0013:
            android.graphics.drawable.Drawable r3 = r0.getDrawable()
            r3.clearColorFilter()
            r0.invalidate()
            goto L_0x0034
        L_0x001e:
            android.graphics.drawable.Drawable r3 = r0.getDrawable()
            android.content.res.Resources r4 = r2.getResources()
            int r1 = com.twitter.sdk.android.tweetui.R$color.tw__black_opacity_10
            int r4 = r4.getColor(r1)
            android.graphics.PorterDuff$Mode r1 = android.graphics.PorterDuff.Mode.SRC_ATOP
            r3.setColorFilter(r4, r1)
            r0.invalidate()
        L_0x0034:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.twitter.sdk.android.tweetui.BaseTweetView.lambda$linkifyProfilePhotoView$1$BaseTweetView(android.view.View, android.view.MotionEvent):boolean");
    }

    public void onFinishInflate() {
        TwitterApiClient twitterApiClient;
        super.onFinishInflate();
        boolean z = false;
        if (!isInEditMode()) {
            try {
                if (this.dependencyProvider != null) {
                    TweetUi.getInstance();
                    z = true;
                } else {
                    throw null;
                }
            } catch (IllegalStateException e2) {
                e2.getMessage();
                setEnabled(false);
            }
        }
        if (z) {
            setTweetActionsEnabled(this.tweetActionsEnabled);
            TweetActionBarView tweetActionBarView2 = this.tweetActionBarView;
            if (this.dependencyProvider != null) {
                tweetActionBarView2.setOnActionCallback(new ResetTweetCallback(this, TweetUi.getInstance().tweetRepository, null));
                final long tweetId = getTweetId();
                AnonymousClass1 r3 = new Callback<Tweet>() {
                    public void failure(TwitterException twitterException) {
                        String.format(Locale.ENGLISH, "loadTweet failure for Tweet Id %d.", new Object[]{Long.valueOf(tweetId)});
                    }

                    public void success(Result<Tweet> result) {
                        BaseTweetView.this.setTweet((Tweet) result.data);
                    }
                };
                if (this.dependencyProvider != null) {
                    TweetRepository tweetRepository = TweetUi.getInstance().tweetRepository;
                    long tweetId2 = getTweetId();
                    Tweet tweet = (Tweet) tweetRepository.tweetCache.get(Long.valueOf(tweetId2));
                    if (tweet != null) {
                        tweetRepository.mainHandler.post(new Runnable(tweet) {
                            public final /* synthetic */ Tweet f$1;

                            {
                                this.f$1 = r2;
                            }

                            public final void run() {
                                Callback.this.success(new Result(this.f$1, null));
                            }
                        });
                    } else {
                        TwitterCore twitterCore = tweetRepository.twitterCore;
                        TwitterSession twitterSession = (TwitterSession) ((PersistedSessionManager) twitterCore.twitterSessionManager).getActiveSession();
                        if (twitterSession == null) {
                            if (twitterCore.guestClient == null) {
                                synchronized (twitterCore) {
                                    if (twitterCore.guestClient == null) {
                                        twitterCore.guestClient = new TwitterApiClient();
                                    }
                                }
                            }
                            twitterApiClient = twitterCore.guestClient;
                        } else {
                            twitterApiClient = twitterCore.getApiClient(twitterSession);
                        }
                        ((StatusesService) twitterApiClient.getService(StatusesService.class)).show(Long.valueOf(tweetId2), null, null, null).enqueue(new SingleTweetCallback(r3));
                    }
                    return;
                }
                throw null;
            }
            throw null;
        }
    }

    public void render() {
        super.render();
        Tweet tweet = this.tweet;
        if (tweet != null) {
            Tweet tweet2 = tweet.retweetedStatus;
            if (tweet2 != null) {
                tweet = tweet2;
            }
        }
        setProfilePhotoView(tweet);
        if (!(tweet == null || tweet.user == null)) {
            this.avatarView.setOnClickListener(new OnClickListener(tweet) {
                public final /* synthetic */ Tweet f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    BaseTweetView.this.lambda$linkifyProfilePhotoView$0$BaseTweetView(this.f$1, view);
                }
            });
            this.avatarView.setOnTouchListener(new OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return BaseTweetView.this.lambda$linkifyProfilePhotoView$1$BaseTweetView(view, motionEvent);
                }
            });
        }
        setTimestamp(tweet);
        setTweetActions(this.tweet);
        Tweet tweet3 = this.tweet;
        if (tweet3 == null || tweet3.retweetedStatus == null) {
            this.retweetedByView.setVisibility(8);
        } else {
            this.retweetedByView.setText(getResources().getString(R$string.tw__retweeted_by_format, new Object[]{tweet3.user.name}));
            this.retweetedByView.setVisibility(0);
        }
        setQuoteTweet(this.tweet);
    }

    public void setOnActionCallback(Callback<Tweet> callback) {
        TweetActionBarView tweetActionBarView2 = this.tweetActionBarView;
        if (this.dependencyProvider != null) {
            tweetActionBarView2.setOnActionCallback(new ResetTweetCallback(this, TweetUi.getInstance().tweetRepository, callback));
            this.tweetActionBarView.setTweet(this.tweet);
            return;
        }
        throw null;
    }

    public void setProfilePhotoView(Tweet tweet) {
        String str = null;
        if (this.dependencyProvider != null) {
            Picasso picasso = TweetUi.getInstance().imageLoader;
            if (picasso != null) {
                if (tweet != null) {
                    User user = tweet.user;
                    if (user != null) {
                        str = TextAppearanceConfig.getProfileImageUrlHttps(user, UserUtils$AvatarSize.REASONABLY_SMALL);
                    }
                }
                picasso.load(str).placeholder((Drawable) this.avatarMediaBg).into(this.avatarView);
                return;
            }
            return;
        }
        throw null;
    }

    public void setQuoteTweet(Tweet tweet) {
        this.quoteTweetView = null;
        this.quoteTweetHolder.removeAllViews();
        if (tweet == null || !TweetUtils.showQuoteTweet(tweet)) {
            this.quoteTweetHolder.setVisibility(8);
            return;
        }
        QuoteTweetView quoteTweetView2 = new QuoteTweetView(getContext());
        this.quoteTweetView = quoteTweetView2;
        int i = this.primaryTextColor;
        int i2 = this.secondaryTextColor;
        int i3 = this.actionColor;
        int i4 = this.actionHighlightColor;
        int i5 = this.mediaBgColor;
        int i6 = this.photoErrorResId;
        quoteTweetView2.primaryTextColor = i;
        quoteTweetView2.secondaryTextColor = i2;
        quoteTweetView2.actionColor = i3;
        quoteTweetView2.actionHighlightColor = i4;
        quoteTweetView2.mediaBgColor = i5;
        quoteTweetView2.photoErrorResId = i6;
        int dimensionPixelSize = quoteTweetView2.getResources().getDimensionPixelSize(R$dimen.tw__media_view_radius);
        quoteTweetView2.tweetMediaView.setRoundedCornersRadii(0, 0, dimensionPixelSize, dimensionPixelSize);
        quoteTweetView2.setBackgroundResource(R$drawable.tw__quote_tweet_border);
        quoteTweetView2.fullNameView.setTextColor(quoteTweetView2.primaryTextColor);
        quoteTweetView2.screenNameView.setTextColor(quoteTweetView2.secondaryTextColor);
        quoteTweetView2.contentView.setTextColor(quoteTweetView2.primaryTextColor);
        quoteTweetView2.tweetMediaView.setMediaBgColor(quoteTweetView2.mediaBgColor);
        quoteTweetView2.tweetMediaView.setPhotoErrorResId(quoteTweetView2.photoErrorResId);
        this.quoteTweetView.setTweet(tweet.quotedStatus);
        this.quoteTweetView.setTweetLinkClickListener(this.tweetLinkClickListener);
        this.quoteTweetView.setTweetMediaClickListener(this.tweetMediaClickListener);
        this.quoteTweetHolder.setVisibility(0);
        this.quoteTweetHolder.addView(this.quoteTweetView);
    }

    public /* bridge */ /* synthetic */ void setTweet(Tweet tweet) {
        super.setTweet(tweet);
    }

    public void setTweetActions(Tweet tweet) {
        this.tweetActionBarView.setTweet(tweet);
    }

    public void setTweetActionsEnabled(boolean z) {
        this.tweetActionsEnabled = z;
        if (z) {
            this.tweetActionBarView.setVisibility(0);
            this.bottomSeparator.setVisibility(8);
            return;
        }
        this.tweetActionBarView.setVisibility(8);
        this.bottomSeparator.setVisibility(0);
    }

    public void setTweetLinkClickListener(TweetLinkClickListener tweetLinkClickListener) {
        super.setTweetLinkClickListener(tweetLinkClickListener);
        QuoteTweetView quoteTweetView2 = this.quoteTweetView;
        if (quoteTweetView2 != null) {
            quoteTweetView2.setTweetLinkClickListener(tweetLinkClickListener);
        }
    }

    public void setTweetMediaClickListener(TweetMediaClickListener tweetMediaClickListener) {
        super.setTweetMediaClickListener(tweetMediaClickListener);
        QuoteTweetView quoteTweetView2 = this.quoteTweetView;
        if (quoteTweetView2 != null) {
            quoteTweetView2.setTweetMediaClickListener(tweetMediaClickListener);
        }
    }

    public BaseTweetView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, new DependencyProvider());
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.tw__TweetView, 0, 0);
            try {
                setXmlDataAttributes(obtainStyledAttributes);
                setStyleAttributes(obtainStyledAttributes);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        applyStyles();
    }
}

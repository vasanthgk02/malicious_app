package com.twitter.sdk.android.tweetui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.react.bridge.ColorPropConverter;
import com.google.android.material.resources.TextAppearanceConfig;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.models.Card;
import com.twitter.sdk.android.core.models.ImageValue;
import com.twitter.sdk.android.core.models.MediaEntity;
import com.twitter.sdk.android.core.models.MediaEntity.Size;
import com.twitter.sdk.android.core.models.MediaEntity.Sizes;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.core.models.TweetEntities;
import com.twitter.sdk.android.core.models.User;
import com.twitter.sdk.android.tweetui.internal.AspectRatioFrameLayout;
import com.twitter.sdk.android.tweetui.internal.MediaBadgeView;
import com.twitter.sdk.android.tweetui.internal.TweetMediaView;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public abstract class AbstractTweetView extends RelativeLayout {
    public int actionColor;
    public int actionHighlightColor;
    public TextView contentView;
    public final DependencyProvider dependencyProvider;
    public TextView fullNameView;
    public LinkClickListener linkClickListener;
    public MediaBadgeView mediaBadgeView;
    public int mediaBgColor;
    public AspectRatioFrameLayout mediaContainer;
    public Uri permalinkUri;
    public int photoErrorResId;
    public int primaryTextColor;
    public TextView screenNameView;
    public int secondaryTextColor;
    public Tweet tweet;
    public boolean tweetActionsEnabled;
    public TweetLinkClickListener tweetLinkClickListener;
    public TweetMediaClickListener tweetMediaClickListener;
    public TweetMediaView tweetMediaView;

    public static class DependencyProvider {
    }

    public class PermalinkClickListener implements OnClickListener {
        public PermalinkClickListener() {
        }

        public void onClick(View view) {
            if (AbstractTweetView.this.getPermalinkUri() != null) {
                AbstractTweetView abstractTweetView = AbstractTweetView.this;
                if (abstractTweetView != null) {
                    TextAppearanceConfig.safeStartActivity(abstractTweetView.getContext(), new Intent("android.intent.action.VIEW", abstractTweetView.getPermalinkUri()));
                    return;
                }
                throw null;
            }
        }
    }

    public AbstractTweetView(Context context, AttributeSet attributeSet, int i, DependencyProvider dependencyProvider2) {
        super(context, attributeSet, i);
        this.dependencyProvider = dependencyProvider2;
        LayoutInflater.from(context).inflate(getLayout(), this, true);
        findSubviews();
    }

    private void setName(Tweet tweet2) {
        if (tweet2 != null) {
            User user = tweet2.user;
            if (user != null) {
                this.fullNameView.setText(TweetUtils.stringOrEmpty(user.name));
                return;
            }
        }
        this.fullNameView.setText("");
    }

    private void setScreenName(Tweet tweet2) {
        String str = "";
        if (tweet2 != null) {
            User user = tweet2.user;
            if (user != null) {
                TextView textView = this.screenNameView;
                String stringOrEmpty = TweetUtils.stringOrEmpty(user.screenName);
                if (!TextUtils.isEmpty(stringOrEmpty)) {
                    if (stringOrEmpty.charAt(0) == '@') {
                        str = stringOrEmpty;
                    } else {
                        str = ColorPropConverter.PREFIX_RESOURCE + stringOrEmpty;
                    }
                }
                textView.setText(str);
                return;
            }
        }
        this.screenNameView.setText(str);
    }

    @TargetApi(16)
    private void setText(Tweet tweet2) {
        CharSequence charSequence;
        this.contentView.setImportantForAccessibility(2);
        if (this.dependencyProvider != null) {
            FormattedTweetText formatTweetText = TweetUi.getInstance().tweetRepository.formatTweetText(tweet2);
            if (formatTweetText == null) {
                charSequence = null;
            } else {
                Card card = tweet2.card;
                charSequence = TweetTextLinkifier.linkifyUrls(formatTweetText, getLinkClickListener(), this.actionColor, this.actionHighlightColor, TweetUtils.showQuoteTweet(tweet2), card != null && TextAppearanceConfig.isVine(card));
            }
            if (charSequence == null) {
                charSequence = "";
            }
            TextView textView = this.contentView;
            textView.setOnTouchListener(new OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return SpanClickHandler.lambda$enableClicksOnSpans$0(SpanClickHandler.this, view, motionEvent);
                }
            });
            if (!TextUtils.isEmpty(charSequence)) {
                this.contentView.setText(charSequence);
                this.contentView.setVisibility(0);
                return;
            }
            this.contentView.setText("");
            this.contentView.setVisibility(8);
            return;
        }
        throw null;
    }

    public void findSubviews() {
        this.fullNameView = (TextView) findViewById(R$id.tw__tweet_author_full_name);
        this.screenNameView = (TextView) findViewById(R$id.tw__tweet_author_screen_name);
        this.mediaContainer = (AspectRatioFrameLayout) findViewById(R$id.tw__aspect_ratio_media_container);
        this.tweetMediaView = (TweetMediaView) findViewById(R$id.tweet_media_view);
        this.contentView = (TextView) findViewById(R$id.tw__tweet_text);
        this.mediaBadgeView = (MediaBadgeView) findViewById(R$id.tw__tweet_media_badge);
    }

    public double getAspectRatio(MediaEntity mediaEntity) {
        if (mediaEntity != null) {
            Sizes sizes = mediaEntity.sizes;
            if (sizes != null) {
                Size size = sizes.medium;
                if (size != null) {
                    int i = size.w;
                    if (i != 0) {
                        int i2 = size.h;
                        if (i2 != 0) {
                            return ((double) i) / ((double) i2);
                        }
                    }
                }
            }
        }
        return 1.7777777777777777d;
    }

    public abstract double getAspectRatioForPhotoEntity(int i);

    public abstract int getLayout();

    public LinkClickListener getLinkClickListener() {
        if (this.linkClickListener == null) {
            this.linkClickListener = new LinkClickListener() {
                public final void onUrlClicked(String str) {
                    AbstractTweetView.this.lambda$getLinkClickListener$0$AbstractTweetView(str);
                }
            };
        }
        return this.linkClickListener;
    }

    public Uri getPermalinkUri() {
        return this.permalinkUri;
    }

    public Tweet getTweet() {
        return this.tweet;
    }

    public long getTweetId() {
        Tweet tweet2 = this.tweet;
        if (tweet2 == null) {
            return -1;
        }
        return tweet2.id;
    }

    public /* synthetic */ void lambda$getLinkClickListener$0$AbstractTweetView(String str) {
        if (!TextUtils.isEmpty(str)) {
            TweetLinkClickListener tweetLinkClickListener2 = this.tweetLinkClickListener;
            if (tweetLinkClickListener2 != null) {
                tweetLinkClickListener2.onLinkClick(this.tweet, str);
            } else {
                if (!TextAppearanceConfig.safeStartActivity(getContext(), new Intent("android.intent.action.VIEW", Uri.parse(str)))) {
                    Twitter.getLogger().e("TweetUi", "Activity cannot be found to open URL");
                }
            }
        }
    }

    public void render() {
        Tweet tweet2 = this.tweet;
        if (tweet2 != null) {
            Tweet tweet3 = tweet2.retweetedStatus;
            if (tweet3 != null) {
                tweet2 = tweet3;
            }
        }
        setName(tweet2);
        setScreenName(tweet2);
        setTweetMedia(tweet2);
        setText(tweet2);
        setContentDescription(tweet2);
        if (TweetUtils.isTweetResolvable(this.tweet)) {
            setPermalinkUri(this.tweet.user.screenName, Long.valueOf(getTweetId()));
        } else {
            this.permalinkUri = null;
        }
        setOnClickListener(new PermalinkClickListener());
    }

    public void setContentDescription(Tweet tweet2) {
        if (!TweetUtils.isTweetResolvable(tweet2)) {
            setContentDescription(getResources().getString(R$string.tw__loading_tweet));
            return;
        }
        String str = null;
        if (this.dependencyProvider != null) {
            FormattedTweetText formatTweetText = TweetUi.getInstance().tweetRepository.formatTweetText(tweet2);
            String str2 = formatTweetText != null ? formatTweetText.text : null;
            long apiTimeToLong = TweetDateUtils.apiTimeToLong(tweet2.createdAt);
            if (apiTimeToLong != -1) {
                str = DateFormat.getDateInstance().format(new Date(apiTimeToLong));
            }
            setContentDescription(getResources().getString(R$string.tw__tweet_content_description, new Object[]{TweetUtils.stringOrEmpty(tweet2.user.name), TweetUtils.stringOrEmpty(str2), TweetUtils.stringOrEmpty(str)}));
            return;
        }
        throw null;
    }

    public void setPermalinkUri(String str, Long l) {
        Uri uri;
        String str2;
        if (l.longValue() > 0) {
            long longValue = l.longValue();
            if (longValue <= 0) {
                uri = null;
            } else {
                if (TextUtils.isEmpty(str)) {
                    str2 = String.format(Locale.US, "https://twitter.com/%s/status/%d?ref_src=twsrc%%5Etwitterkit", new Object[]{"twitter_unknown", Long.valueOf(longValue)});
                } else {
                    str2 = String.format(Locale.US, "https://twitter.com/%s/status/%d?ref_src=twsrc%%5Etwitterkit", new Object[]{str, Long.valueOf(longValue)});
                }
                uri = Uri.parse(str2);
            }
            this.permalinkUri = uri;
        }
    }

    public void setTweet(Tweet tweet2) {
        this.tweet = tweet2;
        render();
    }

    public void setTweetLinkClickListener(TweetLinkClickListener tweetLinkClickListener2) {
        this.tweetLinkClickListener = tweetLinkClickListener2;
    }

    public final void setTweetMedia(Tweet tweet2) {
        MediaEntity mediaEntity;
        double d2;
        this.mediaContainer.setVisibility(8);
        if (tweet2 != null) {
            Card card = tweet2.card;
            if (card == null || !TextAppearanceConfig.isVine(card)) {
                MediaEntity videoEntity = TweetUtils.getVideoEntity(tweet2);
                boolean z = true;
                if ((videoEntity == null || TweetUtils.getSupportedVariant(videoEntity) == null) ? false : true) {
                    MediaEntity videoEntity2 = TweetUtils.getVideoEntity(tweet2);
                    setViewsForMedia(getAspectRatio(videoEntity2));
                    this.tweetMediaView.setTweetMediaEntities(this.tweet, Collections.singletonList(videoEntity2));
                    this.mediaBadgeView.setVisibility(0);
                    this.mediaBadgeView.setMediaEntity(videoEntity2);
                } else {
                    ArrayList arrayList = (ArrayList) TweetUtils.getAllMediaEntities(tweet2);
                    int size = arrayList.size();
                    while (true) {
                        size--;
                        if (size < 0) {
                            mediaEntity = null;
                            break;
                        }
                        mediaEntity = (MediaEntity) arrayList.get(size);
                        String str = mediaEntity.type;
                        if (str != null && "photo".equals(str)) {
                            break;
                        }
                    }
                    if (mediaEntity == null) {
                        z = false;
                    }
                    if (z) {
                        ArrayList arrayList2 = new ArrayList();
                        TweetEntities tweetEntities = tweet2.extendedEntities;
                        if (tweetEntities != null) {
                            List<MediaEntity> list = tweetEntities.media;
                            if (list != null && list.size() > 0) {
                                for (int i = 0; i <= tweetEntities.media.size() - 1; i++) {
                                    MediaEntity mediaEntity2 = tweetEntities.media.get(i);
                                    String str2 = mediaEntity2.type;
                                    if (str2 != null && "photo".equals(str2)) {
                                        arrayList2.add(mediaEntity2);
                                    }
                                }
                            }
                        }
                        setViewsForMedia(getAspectRatioForPhotoEntity(arrayList2.size()));
                        this.tweetMediaView.setTweetMediaEntities(tweet2, arrayList2);
                        this.mediaBadgeView.setVisibility(8);
                    }
                }
            } else {
                Card card2 = tweet2.card;
                ImageValue imageValue = (ImageValue) card2.bindingValues.get("player_image");
                String str3 = (String) card2.bindingValues.get("player_stream_url");
                if (imageValue != null && !TextUtils.isEmpty(str3)) {
                    int i2 = imageValue.width;
                    if (i2 != 0) {
                        int i3 = imageValue.height;
                        if (i3 != 0) {
                            d2 = ((double) i2) / ((double) i3);
                            setViewsForMedia(d2);
                            this.tweetMediaView.setVineCard(tweet2);
                            this.mediaBadgeView.setVisibility(0);
                            this.mediaBadgeView.setCard(card2);
                        }
                    }
                    d2 = 1.7777777777777777d;
                    setViewsForMedia(d2);
                    this.tweetMediaView.setVineCard(tweet2);
                    this.mediaBadgeView.setVisibility(0);
                    this.mediaBadgeView.setCard(card2);
                }
            }
        }
    }

    public void setTweetMediaClickListener(TweetMediaClickListener tweetMediaClickListener2) {
        this.tweetMediaClickListener = tweetMediaClickListener2;
        this.tweetMediaView.setTweetMediaClickListener(tweetMediaClickListener2);
    }

    public void setViewsForMedia(double d2) {
        this.mediaContainer.setVisibility(0);
        this.mediaContainer.setAspectRatio(d2);
        this.tweetMediaView.setVisibility(0);
    }
}

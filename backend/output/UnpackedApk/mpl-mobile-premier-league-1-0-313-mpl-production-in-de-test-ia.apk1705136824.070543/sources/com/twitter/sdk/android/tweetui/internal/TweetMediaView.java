package com.twitter.sdk.android.tweetui.internal;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.material.resources.TextAppearanceConfig;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.twitter.sdk.android.core.models.Card;
import com.twitter.sdk.android.core.models.ImageValue;
import com.twitter.sdk.android.core.models.MediaEntity;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.tweetui.GalleryActivity;
import com.twitter.sdk.android.tweetui.GalleryActivity.GalleryItem;
import com.twitter.sdk.android.tweetui.PlayerActivity;
import com.twitter.sdk.android.tweetui.PlayerActivity.PlayerItem;
import com.twitter.sdk.android.tweetui.R$dimen;
import com.twitter.sdk.android.tweetui.R$drawable;
import com.twitter.sdk.android.tweetui.R$id;
import com.twitter.sdk.android.tweetui.R$string;
import com.twitter.sdk.android.tweetui.TweetMediaClickListener;
import com.twitter.sdk.android.tweetui.TweetUi;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

public class TweetMediaView extends ViewGroup implements OnClickListener {
    public final DependencyProvider dependencyProvider;
    public int imageCount;
    public final OverlayImageView[] imageViews = new OverlayImageView[4];
    public boolean internalRoundedCornersEnabled;
    public int mediaBgColor = -16777216;
    public final int mediaDividerSize;
    public List<MediaEntity> mediaEntities = Collections.emptyList();
    public final Path path = new Path();
    public int photoErrorResId;
    public final float[] radii = new float[8];
    public final RectF rect = new RectF();
    public Tweet tweet;
    public TweetMediaClickListener tweetMediaClickListener;

    public static class DependencyProvider {
    }

    public static class PicassoCallback implements Callback {
        public final WeakReference<ImageView> imageViewWeakReference;

        public PicassoCallback(ImageView imageView) {
            this.imageViewWeakReference = new WeakReference<>(imageView);
        }

        public void onSuccess() {
            ImageView imageView = (ImageView) this.imageViewWeakReference.get();
            if (imageView != null) {
                imageView.setBackgroundResource(17170445);
            }
        }
    }

    public static class Size {
        public static final Size EMPTY = new Size();
        public final int height;
        public final int width;

        public Size() {
            this.width = 0;
            this.height = 0;
        }

        public Size(int i, int i2) {
            this.width = i;
            this.height = i2;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public TweetMediaView(Context context, AttributeSet attributeSet) {
        // DependencyProvider dependencyProvider2 = new DependencyProvider();
        super(context, attributeSet);
        this.dependencyProvider = dependencyProvider2;
        this.mediaDividerSize = getResources().getDimensionPixelSize(R$dimen.tw__media_view_divider_size);
        this.photoErrorResId = R$drawable.tw__ic_tweet_photo_error_dark;
    }

    public void clearImageViews() {
        for (int i = 0; i < this.imageCount; i++) {
            OverlayImageView overlayImageView = this.imageViews[i];
            if (overlayImageView != null) {
                overlayImageView.setVisibility(8);
            }
        }
        this.imageCount = 0;
    }

    public void dispatchDraw(Canvas canvas) {
        if (this.internalRoundedCornersEnabled) {
            int save = canvas.save();
            canvas.clipPath(this.path);
            super.dispatchDraw(canvas);
            canvas.restoreToCount(save);
            return;
        }
        super.dispatchDraw(canvas);
    }

    public OverlayImageView getOrCreateImageView(int i) {
        OverlayImageView overlayImageView = this.imageViews[i];
        if (overlayImageView == null) {
            overlayImageView = new OverlayImageView(getContext());
            overlayImageView.setLayoutParams(generateDefaultLayoutParams());
            overlayImageView.setOnClickListener(this);
            this.imageViews[i] = overlayImageView;
            addView(overlayImageView, i);
        } else {
            measureImageView(i, 0, 0);
            layoutImage(i, 0, 0, 0, 0);
        }
        overlayImageView.setVisibility(0);
        overlayImageView.setBackgroundColor(this.mediaBgColor);
        overlayImageView.setTag(R$id.tw__entity_index, Integer.valueOf(i));
        return overlayImageView;
    }

    public void layoutImage(int i, int i2, int i3, int i4, int i5) {
        OverlayImageView overlayImageView = this.imageViews[i];
        if (overlayImageView.getLeft() != i2 || overlayImageView.getTop() != i3 || overlayImageView.getRight() != i4 || overlayImageView.getBottom() != i5) {
            overlayImageView.layout(i2, i3, i4, i5);
        }
    }

    public void measureImageView(int i, int i2, int i3) {
        this.imageViews[i].measure(MeasureSpec.makeMeasureSpec(i2, 1073741824), MeasureSpec.makeMeasureSpec(i3, 1073741824));
    }

    public void onClick(View view) {
        Integer num = (Integer) view.getTag(R$id.tw__entity_index);
        if (this.tweetMediaClickListener != null) {
            this.tweetMediaClickListener.onMediaEntityClick(this.tweet, !this.mediaEntities.isEmpty() ? this.mediaEntities.get(num.intValue()) : null);
        } else if (!this.mediaEntities.isEmpty()) {
            MediaEntity mediaEntity = this.mediaEntities.get(num.intValue());
            if (TweetUtils.isVideoType(mediaEntity)) {
                if (TweetUtils.getSupportedVariant(mediaEntity) != null) {
                    Intent intent = new Intent(getContext(), PlayerActivity.class);
                    PlayerItem playerItem = new PlayerItem(TweetUtils.getSupportedVariant(mediaEntity).url, "animated_gif".equals(mediaEntity.type) || ("video".endsWith(mediaEntity.type) && mediaEntity.videoInfo.durationMillis < 6500), !"animated_gif".equals(mediaEntity.type), null, null);
                    intent.putExtra("PLAYER_ITEM", playerItem);
                    TextAppearanceConfig.safeStartActivity(getContext(), intent);
                }
            } else if ("photo".equals(mediaEntity.type)) {
                int intValue = num.intValue();
                Intent intent2 = new Intent(getContext(), GalleryActivity.class);
                intent2.putExtra("GALLERY_ITEM", new GalleryItem(this.tweet.id, intValue, this.mediaEntities));
                TextAppearanceConfig.safeStartActivity(getContext(), intent2);
            }
        } else {
            Card card = this.tweet.card;
            Intent intent3 = new Intent(getContext(), PlayerActivity.class);
            PlayerItem playerItem2 = new PlayerItem((String) card.bindingValues.get("player_stream_url"), true, false, null, null);
            intent3.putExtra("PLAYER_ITEM", playerItem2);
            TextAppearanceConfig.safeStartActivity(getContext(), intent3);
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.imageCount > 0) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            int i5 = this.mediaDividerSize;
            int i6 = (measuredWidth - i5) / 2;
            int i7 = (measuredHeight - i5) / 2;
            int i8 = i5 + i6;
            int i9 = this.imageCount;
            if (i9 == 1) {
                layoutImage(0, 0, 0, measuredWidth, measuredHeight);
            } else if (i9 == 2) {
                int i10 = measuredHeight;
                layoutImage(0, 0, 0, i6, i10);
                layoutImage(1, i6 + this.mediaDividerSize, 0, measuredWidth, i10);
            } else if (i9 == 3) {
                layoutImage(0, 0, 0, i6, measuredHeight);
                int i11 = i8;
                int i12 = measuredWidth;
                layoutImage(1, i11, 0, i12, i7);
                layoutImage(2, i11, i7 + this.mediaDividerSize, i12, measuredHeight);
            } else if (i9 == 4) {
                int i13 = i6;
                layoutImage(0, 0, 0, i13, i7);
                layoutImage(2, 0, i7 + this.mediaDividerSize, i13, measuredHeight);
                int i14 = i8;
                int i15 = measuredWidth;
                layoutImage(1, i14, 0, i15, i7);
                layoutImage(3, i14, i7 + this.mediaDividerSize, i15, measuredHeight);
            }
        }
    }

    public void onMeasure(int i, int i2) {
        Size size;
        if (this.imageCount > 0) {
            int size2 = MeasureSpec.getSize(i);
            int size3 = MeasureSpec.getSize(i2);
            int i3 = this.mediaDividerSize;
            int i4 = (size2 - i3) / 2;
            int i5 = (size3 - i3) / 2;
            int i6 = this.imageCount;
            if (i6 == 1) {
                measureImageView(0, size2, size3);
            } else if (i6 == 2) {
                measureImageView(0, i4, size3);
                measureImageView(1, i4, size3);
            } else if (i6 == 3) {
                measureImageView(0, i4, size3);
                measureImageView(1, i4, i5);
                measureImageView(2, i4, i5);
            } else if (i6 == 4) {
                measureImageView(0, i4, i5);
                measureImageView(1, i4, i5);
                measureImageView(2, i4, i5);
                measureImageView(3, i4, i5);
            }
            int max = Math.max(size2, 0);
            int max2 = Math.max(size3, 0);
            size = (max == 0 && max2 == 0) ? Size.EMPTY : new Size(max, max2);
        } else {
            size = Size.EMPTY;
        }
        setMeasuredDimension(size.width, size.height);
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.path.reset();
        this.rect.set(0.0f, 0.0f, (float) i, (float) i2);
        this.path.addRoundRect(this.rect, this.radii, Direction.CW);
        this.path.close();
    }

    public void setAltText(ImageView imageView, String str) {
        if (!TextUtils.isEmpty(str)) {
            imageView.setContentDescription(str);
        } else {
            imageView.setContentDescription(getResources().getString(R$string.tw__tweet_media));
        }
    }

    public void setMediaBgColor(int i) {
        this.mediaBgColor = i;
    }

    public void setMediaImage(ImageView imageView, String str) {
        if (this.dependencyProvider != null) {
            Picasso picasso = TweetUi.getInstance().imageLoader;
            if (picasso != null) {
                picasso.load(str).fit().centerCrop().error(this.photoErrorResId).into(imageView, new PicassoCallback(imageView));
                return;
            }
            return;
        }
        throw null;
    }

    public void setOverlayImage(OverlayImageView overlayImageView, boolean z) {
        if (z) {
            overlayImageView.setOverlayDrawable(getContext().getResources().getDrawable(R$drawable.tw__player_overlay));
        } else {
            overlayImageView.setOverlayDrawable(null);
        }
    }

    public void setPhotoErrorResId(int i) {
        this.photoErrorResId = i;
    }

    public void setRoundedCornersRadii(int i, int i2, int i3, int i4) {
        float[] fArr = this.radii;
        float f2 = (float) i;
        fArr[0] = f2;
        fArr[1] = f2;
        float f3 = (float) i2;
        fArr[2] = f3;
        fArr[3] = f3;
        float f4 = (float) i3;
        fArr[4] = f4;
        fArr[5] = f4;
        float f5 = (float) i4;
        fArr[6] = f5;
        fArr[7] = f5;
        requestLayout();
    }

    public void setTweetMediaClickListener(TweetMediaClickListener tweetMediaClickListener2) {
        this.tweetMediaClickListener = tweetMediaClickListener2;
    }

    public void setTweetMediaEntities(Tweet tweet2, List<MediaEntity> list) {
        String str;
        if (tweet2 != null && list != null && !list.isEmpty() && !list.equals(this.mediaEntities)) {
            this.tweet = tweet2;
            this.mediaEntities = list;
            clearImageViews();
            this.imageCount = Math.min(4, list.size());
            for (int i = 0; i < this.imageCount; i++) {
                OverlayImageView orCreateImageView = getOrCreateImageView(i);
                MediaEntity mediaEntity = list.get(i);
                setAltText(orCreateImageView, mediaEntity.altText);
                if (this.imageCount > 1) {
                    str = GeneratedOutlineSupport.outline62(new StringBuilder(), mediaEntity.mediaUrlHttps, ":small");
                } else {
                    str = mediaEntity.mediaUrlHttps;
                }
                setMediaImage(orCreateImageView, str);
                setOverlayImage(orCreateImageView, TweetUtils.isVideoType(mediaEntity));
            }
            this.internalRoundedCornersEnabled = TweetUtils.isPhotoType(list.get(0));
            requestLayout();
        }
    }

    public void setVineCard(Tweet tweet2) {
        if (tweet2 != null) {
            Card card = tweet2.card;
            if (card != null && TextAppearanceConfig.isVine(card)) {
                this.tweet = tweet2;
                this.mediaEntities = Collections.emptyList();
                clearImageViews();
                Card card2 = tweet2.card;
                this.imageCount = 1;
                OverlayImageView orCreateImageView = getOrCreateImageView(0);
                ImageValue imageValue = (ImageValue) card2.bindingValues.get("player_image");
                setAltText(orCreateImageView, imageValue.alt);
                setMediaImage(orCreateImageView, imageValue.url);
                setOverlayImage(orCreateImageView, true);
                this.internalRoundedCornersEnabled = false;
                requestLayout();
            }
        }
    }
}

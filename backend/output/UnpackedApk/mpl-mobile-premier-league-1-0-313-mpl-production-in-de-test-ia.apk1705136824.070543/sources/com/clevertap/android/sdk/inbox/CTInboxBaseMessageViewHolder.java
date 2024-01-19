package com.clevertap.android.sdk.inbox;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.clevertap.android.sdk.R$drawable;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CTInboxBaseMessageViewHolder extends ViewHolder {
    public LinearLayout bodyRelativeLayout;
    public RelativeLayout clickLayout;
    public Context context;
    public LinearLayout ctaLinearLayout;
    public CTInboxMessageContent firstContentItem;
    public FrameLayout frameLayout;
    public ImageView mediaImage;
    public RelativeLayout mediaLayout;
    public CTInboxMessage message;
    public ImageView muteIcon;
    public WeakReference<CTInboxListViewFragment> parentWeakReference;
    public FrameLayout progressBarFrameLayout;
    public RelativeLayout relativeLayout;
    public boolean requiresMediaPlayer;
    public ImageView squareImage;

    public CTInboxBaseMessageViewHolder(View view) {
        super(view);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0131  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean addMediaPlayer(com.google.android.exoplayer2.ui.PlayerView r11) {
        /*
            r10 = this;
            boolean r0 = r10.requiresMediaPlayer
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            android.widget.FrameLayout r0 = r10.frameLayout
            if (r0 != 0) goto L_0x000b
            return r1
        L_0x000b:
            r0.removeAllViews()
            r2 = 8
            r0.setVisibility(r2)
            android.content.Context r3 = r10.context
            android.content.res.Resources r3 = r3.getResources()
            android.util.DisplayMetrics r4 = r3.getDisplayMetrics()
            int r5 = com.clevertap.android.sdk.inbox.CTInboxActivity.orientation
            r6 = 2
            java.lang.String r7 = "l"
            if (r5 != r6) goto L_0x004c
            com.clevertap.android.sdk.inbox.CTInboxMessage r3 = r10.message
            java.lang.String r3 = r3.orientation
            boolean r3 = r3.equalsIgnoreCase(r7)
            if (r3 == 0) goto L_0x0045
            android.widget.ImageView r3 = r10.mediaImage
            int r3 = r3.getMeasuredHeight()
            float r3 = (float) r3
            r5 = 1071728558(0x3fe147ae, float:1.76)
            float r3 = r3 * r5
            int r3 = java.lang.Math.round(r3)
            android.widget.ImageView r5 = r10.mediaImage
            int r5 = r5.getMeasuredHeight()
            goto L_0x0067
        L_0x0045:
            android.widget.ImageView r3 = r10.squareImage
            int r3 = r3.getMeasuredHeight()
            goto L_0x0066
        L_0x004c:
            android.util.DisplayMetrics r3 = r3.getDisplayMetrics()
            int r3 = r3.widthPixels
            com.clevertap.android.sdk.inbox.CTInboxMessage r5 = r10.message
            java.lang.String r5 = r5.orientation
            boolean r5 = r5.equalsIgnoreCase(r7)
            if (r5 == 0) goto L_0x0066
            float r5 = (float) r3
            r6 = 1058013184(0x3f100000, float:0.5625)
            float r5 = r5 * r6
            int r5 = java.lang.Math.round(r5)
            goto L_0x0067
        L_0x0066:
            r5 = r3
        L_0x0067:
            android.widget.FrameLayout$LayoutParams r6 = new android.widget.FrameLayout$LayoutParams
            r6.<init>(r3, r5)
            r11.setLayoutParams(r6)
            r0.addView(r11)
            com.clevertap.android.sdk.inbox.CTInboxMessage r3 = r10.message
            java.lang.String r3 = r3.bgColor
            int r3 = android.graphics.Color.parseColor(r3)
            r0.setBackgroundColor(r3)
            android.widget.FrameLayout r3 = r10.progressBarFrameLayout
            if (r3 == 0) goto L_0x0084
            r3.setVisibility(r1)
        L_0x0084:
            com.google.android.exoplayer2.Player r3 = r11.getPlayer()
            com.google.android.exoplayer2.SimpleExoPlayer r3 = (com.google.android.exoplayer2.SimpleExoPlayer) r3
            r5 = 0
            if (r3 == 0) goto L_0x0092
            float r6 = r3.getVolume()
            goto L_0x0093
        L_0x0092:
            r6 = 0
        L_0x0093:
            com.clevertap.android.sdk.inbox.CTInboxMessageContent r7 = r10.firstContentItem
            boolean r7 = r7.mediaIsVideo()
            r8 = 1
            if (r7 == 0) goto L_0x010b
            android.widget.ImageView r7 = new android.widget.ImageView
            android.content.Context r9 = r10.context
            r7.<init>(r9)
            r10.muteIcon = r7
            r7.setVisibility(r2)
            r2 = 0
            int r5 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1))
            if (r5 <= 0) goto L_0x00bf
            android.widget.ImageView r5 = r10.muteIcon
            android.content.Context r7 = r10.context
            android.content.res.Resources r7 = r7.getResources()
            int r9 = com.clevertap.android.sdk.R$drawable.ct_volume_on
            android.graphics.drawable.Drawable r2 = androidx.core.content.res.ResourcesCompat.getDrawable(r7, r9, r2)
            r5.setImageDrawable(r2)
            goto L_0x00d0
        L_0x00bf:
            android.widget.ImageView r5 = r10.muteIcon
            android.content.Context r7 = r10.context
            android.content.res.Resources r7 = r7.getResources()
            int r9 = com.clevertap.android.sdk.R$drawable.ct_volume_off
            android.graphics.drawable.Drawable r2 = androidx.core.content.res.ResourcesCompat.getDrawable(r7, r9, r2)
            r5.setImageDrawable(r2)
        L_0x00d0:
            r2 = 1106247680(0x41f00000, float:30.0)
            float r5 = android.util.TypedValue.applyDimension(r8, r2, r4)
            int r5 = (int) r5
            float r2 = android.util.TypedValue.applyDimension(r8, r2, r4)
            int r2 = (int) r2
            android.widget.FrameLayout$LayoutParams r7 = new android.widget.FrameLayout$LayoutParams
            r7.<init>(r5, r2)
            r2 = 1082130432(0x40800000, float:4.0)
            float r2 = android.util.TypedValue.applyDimension(r8, r2, r4)
            int r2 = (int) r2
            r5 = 1073741824(0x40000000, float:2.0)
            float r4 = android.util.TypedValue.applyDimension(r8, r5, r4)
            int r4 = (int) r4
            r7.setMargins(r1, r2, r4, r1)
            r2 = 8388613(0x800005, float:1.175495E-38)
            r7.gravity = r2
            android.widget.ImageView r2 = r10.muteIcon
            r2.setLayoutParams(r7)
            android.widget.ImageView r2 = r10.muteIcon
            com.clevertap.android.sdk.inbox.CTInboxBaseMessageViewHolder$1 r4 = new com.clevertap.android.sdk.inbox.CTInboxBaseMessageViewHolder$1
            r4.<init>(r3)
            r2.setOnClickListener(r4)
            android.widget.ImageView r2 = r10.muteIcon
            r0.addView(r2)
        L_0x010b:
            r11.requestFocus()
            r11.setShowBuffering(r1)
            com.google.android.exoplayer2.upstream.DefaultBandwidthMeter$Builder r0 = new com.google.android.exoplayer2.upstream.DefaultBandwidthMeter$Builder
            android.content.Context r2 = r10.context
            r0.<init>(r2)
            com.google.android.exoplayer2.upstream.DefaultBandwidthMeter r0 = r0.build()
            com.google.android.exoplayer2.upstream.DefaultDataSourceFactory r2 = new com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
            android.content.Context r4 = r10.context
            java.lang.String r5 = r4.getPackageName()
            java.lang.String r5 = com.google.android.exoplayer2.util.Util.getUserAgent(r4, r5)
            r2.<init>(r4, r5, r0)
            com.clevertap.android.sdk.inbox.CTInboxMessageContent r0 = r10.firstContentItem
            java.lang.String r0 = r0.media
            if (r0 == 0) goto L_0x0165
            com.google.android.exoplayer2.source.hls.HlsMediaSource$Factory r4 = new com.google.android.exoplayer2.source.hls.HlsMediaSource$Factory
            r4.<init>(r2)
            android.net.Uri r0 = android.net.Uri.parse(r0)
            com.google.android.exoplayer2.source.hls.HlsMediaSource r0 = r4.createMediaSource(r0)
            if (r3 == 0) goto L_0x0165
            r3.prepare(r0)
            com.clevertap.android.sdk.inbox.CTInboxMessageContent r0 = r10.firstContentItem
            boolean r0 = r0.mediaIsAudio()
            if (r0 == 0) goto L_0x0157
            r11.showController()
            r3.setPlayWhenReady(r1)
            r11 = 1065353216(0x3f800000, float:1.0)
            r3.setVolume(r11)
            goto L_0x0165
        L_0x0157:
            com.clevertap.android.sdk.inbox.CTInboxMessageContent r11 = r10.firstContentItem
            boolean r11 = r11.mediaIsVideo()
            if (r11 == 0) goto L_0x0165
            r3.setPlayWhenReady(r8)
            r3.setVolume(r6)
        L_0x0165:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.inbox.CTInboxBaseMessageViewHolder.addMediaPlayer(com.google.android.exoplayer2.ui.PlayerView):boolean");
    }

    public String calculateDisplayTimestamp(long j) {
        StringBuilder sb;
        String str;
        long currentTimeMillis = (System.currentTimeMillis() / 1000) - j;
        int i = (currentTimeMillis > 60 ? 1 : (currentTimeMillis == 60 ? 0 : -1));
        if (i < 0) {
            return "Just Now";
        }
        if (i > 0 && currentTimeMillis < 3540) {
            return (currentTimeMillis / 60) + " mins ago";
        } else if (currentTimeMillis > 3540 && currentTimeMillis < 81420) {
            long j2 = currentTimeMillis / 3600;
            if (j2 > 1) {
                sb = new StringBuilder();
                sb.append(j2);
                str = " hours ago";
            } else {
                sb = new StringBuilder();
                sb.append(j2);
                str = " hour ago";
            }
            sb.append(str);
            return sb.toString();
        } else if (currentTimeMillis <= 86400 || currentTimeMillis >= 172800) {
            return new SimpleDateFormat("dd MMM").format(new Date(j * 1000));
        } else {
            return "Yesterday";
        }
    }

    public void configureWithMessage(CTInboxMessage cTInboxMessage, CTInboxListViewFragment cTInboxListViewFragment, int i) {
        this.context = cTInboxListViewFragment.getContext();
        this.parentWeakReference = new WeakReference<>(cTInboxListViewFragment);
        this.message = cTInboxMessage;
        boolean z = false;
        CTInboxMessageContent cTInboxMessageContent = cTInboxMessage.inboxMessageContents.get(0);
        this.firstContentItem = cTInboxMessageContent;
        if (cTInboxMessageContent.mediaIsAudio() || this.firstContentItem.mediaIsVideo()) {
            z = true;
        }
        this.requiresMediaPlayer = z;
    }

    public CTInboxListViewFragment getParent() {
        return (CTInboxListViewFragment) this.parentWeakReference.get();
    }

    public void hideOneButton(Button button, Button button2, Button button3) {
        button3.setVisibility(8);
        button.setLayoutParams(new LayoutParams(0, -1, 3.0f));
        button2.setLayoutParams(new LayoutParams(0, -1, 3.0f));
        button3.setLayoutParams(new LayoutParams(0, -1, 0.0f));
    }

    public void hideTwoButtons(Button button, Button button2, Button button3) {
        button2.setVisibility(8);
        button3.setVisibility(8);
        button.setLayoutParams(new LayoutParams(0, -1, 6.0f));
        button2.setLayoutParams(new LayoutParams(0, -1, 0.0f));
        button3.setLayoutParams(new LayoutParams(0, -1, 0.0f));
    }

    public void setDots(ImageView[] imageViewArr, int i, Context context2, LinearLayout linearLayout) {
        for (int i2 = 0; i2 < i; i2++) {
            imageViewArr[i2] = new ImageView(context2);
            imageViewArr[i2].setVisibility(0);
            imageViewArr[i2].setImageDrawable(ResourcesCompat.getDrawable(context2.getResources(), R$drawable.ct_unselected_dot, null));
            LayoutParams layoutParams = new LayoutParams(-2, -2);
            layoutParams.setMargins(8, 6, 4, 6);
            layoutParams.gravity = 17;
            if (linearLayout.getChildCount() < i) {
                linearLayout.addView(imageViewArr[i2], layoutParams);
            }
        }
    }
}

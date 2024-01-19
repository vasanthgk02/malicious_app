package com.twitter.sdk.android.tweetcomposer;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.google.android.material.resources.TextAppearanceConfig;
import com.squareup.picasso.Picasso;
import com.twitter.sdk.android.core.internal.UserUtils$AvatarSize;
import com.twitter.sdk.android.core.models.User;
import com.twitter.sdk.android.tweetcomposer.ComposerController.ComposerCallbacks;
import com.twitter.sdk.android.tweetcomposer.ComposerController.ComposerCallbacksImpl;
import com.twitter.sdk.android.tweetcomposer.internal.util.ObservableScrollView;
import com.twitter.sdk.android.tweetcomposer.internal.util.ObservableScrollView.ScrollViewListener;
import java.util.Locale;

public class ComposerView extends LinearLayout {
    public ImageView avatarView;
    public ComposerCallbacks callbacks;
    public TextView charCountView;
    public ImageView closeView;
    public View divider;
    public Picasso imageLoader;
    public ImageView imageView;
    public ColorDrawable mediaBg;
    public ObservableScrollView scrollView;
    public Button tweetButton;
    public EditText tweetEditView;

    public ComposerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public String getTweetText() {
        return this.tweetEditView.getText().toString();
    }

    public final void init(Context context) {
        this.imageLoader = Picasso.with(getContext());
        this.mediaBg = new ColorDrawable(context.getResources().getColor(R$color.tw__composer_light_gray));
        LinearLayout.inflate(context, R$layout.tw__composer_view, this);
    }

    public /* synthetic */ void lambda$onFinishInflate$0$ComposerView(View view) {
        ((ComposerCallbacksImpl) this.callbacks).onCloseClick();
    }

    public /* synthetic */ void lambda$onFinishInflate$1$ComposerView(View view) {
        ((ComposerCallbacksImpl) this.callbacks).onTweetPost(getTweetText());
    }

    public /* synthetic */ boolean lambda$onFinishInflate$2$ComposerView(TextView textView, int i, KeyEvent keyEvent) {
        ((ComposerCallbacksImpl) this.callbacks).onTweetPost(getTweetText());
        return true;
    }

    public /* synthetic */ void lambda$onFinishInflate$3$ComposerView(int i) {
        if (i > 0) {
            this.divider.setVisibility(0);
        } else {
            this.divider.setVisibility(4);
        }
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.avatarView = (ImageView) findViewById(R$id.tw__author_avatar);
        this.closeView = (ImageView) findViewById(R$id.tw__composer_close);
        this.tweetEditView = (EditText) findViewById(R$id.tw__edit_tweet);
        this.charCountView = (TextView) findViewById(R$id.tw__char_count);
        this.tweetButton = (Button) findViewById(R$id.tw__post_tweet);
        this.scrollView = (ObservableScrollView) findViewById(R$id.tw__composer_scroll_view);
        this.divider = findViewById(R$id.tw__composer_profile_divider);
        this.imageView = (ImageView) findViewById(R$id.tw__image_view);
        this.closeView.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                ComposerView.this.lambda$onFinishInflate$0$ComposerView(view);
            }
        });
        this.tweetButton.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                ComposerView.this.lambda$onFinishInflate$1$ComposerView(view);
            }
        });
        this.tweetEditView.setOnEditorActionListener(new OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return ComposerView.this.lambda$onFinishInflate$2$ComposerView(textView, i, keyEvent);
            }
        });
        this.tweetEditView.addTextChangedListener(new TextWatcher() {
            /* JADX WARNING: Removed duplicated region for block: B:34:0x00b1  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void afterTextChanged(android.text.Editable r12) {
                /*
                    r11 = this;
                    com.twitter.sdk.android.tweetcomposer.ComposerView r12 = com.twitter.sdk.android.tweetcomposer.ComposerView.this
                    com.twitter.sdk.android.tweetcomposer.ComposerController$ComposerCallbacks r0 = r12.callbacks
                    java.lang.String r12 = r12.getTweetText()
                    com.twitter.sdk.android.tweetcomposer.ComposerController$ComposerCallbacksImpl r0 = (com.twitter.sdk.android.tweetcomposer.ComposerController.ComposerCallbacksImpl) r0
                    com.twitter.sdk.android.tweetcomposer.ComposerController r1 = com.twitter.sdk.android.tweetcomposer.ComposerController.this
                    r2 = 0
                    if (r1 == 0) goto L_0x010a
                    boolean r3 = android.text.TextUtils.isEmpty(r12)
                    r4 = 0
                    if (r3 == 0) goto L_0x0019
                    r3 = 0
                    goto L_0x00d3
                L_0x0019:
                    com.twitter.sdk.android.tweetcomposer.ComposerController$DependencyProvider r1 = r1.dependencyProvider
                    com.twitter.Validator r1 = r1.tweetValidator
                    if (r1 == 0) goto L_0x0109
                    java.text.Normalizer$Form r3 = java.text.Normalizer.Form.NFC
                    java.lang.String r12 = java.text.Normalizer.normalize(r12, r3)
                    int r3 = r12.length()
                    int r3 = r12.codePointCount(r4, r3)
                    com.twitter.Extractor r5 = r1.extractor
                    if (r5 == 0) goto L_0x0108
                    int r2 = r12.length()
                    if (r2 == 0) goto L_0x00a3
                    boolean r2 = r5.extractURLWithoutProtocol
                    if (r2 == 0) goto L_0x003e
                    r2 = 46
                    goto L_0x0040
                L_0x003e:
                    r2 = 58
                L_0x0040:
                    int r2 = r12.indexOf(r2)
                    r6 = -1
                    if (r2 != r6) goto L_0x0048
                    goto L_0x00a3
                L_0x0048:
                    java.util.ArrayList r2 = new java.util.ArrayList
                    r2.<init>()
                    java.util.regex.Pattern r6 = com.twitter.Regex.VALID_URL
                    java.util.regex.Matcher r12 = r6.matcher(r12)
                L_0x0053:
                    boolean r6 = r12.find()
                    if (r6 == 0) goto L_0x00a7
                    r6 = 4
                    java.lang.String r6 = r12.group(r6)
                    if (r6 != 0) goto L_0x0076
                    boolean r6 = r5.extractURLWithoutProtocol
                    if (r6 == 0) goto L_0x0053
                    java.util.regex.Pattern r6 = com.twitter.Regex.INVALID_URL_WITHOUT_PROTOCOL_MATCH_BEGIN
                    r7 = 2
                    java.lang.String r7 = r12.group(r7)
                    java.util.regex.Matcher r6 = r6.matcher(r7)
                    boolean r6 = r6.matches()
                    if (r6 == 0) goto L_0x0076
                    goto L_0x0053
                L_0x0076:
                    r6 = 3
                    java.lang.String r7 = r12.group(r6)
                    int r8 = r12.start(r6)
                    int r6 = r12.end(r6)
                    java.util.regex.Pattern r9 = com.twitter.Regex.VALID_TCO_URL
                    java.util.regex.Matcher r9 = r9.matcher(r7)
                    boolean r10 = r9.find()
                    if (r10 == 0) goto L_0x0098
                    java.lang.String r7 = r9.group()
                    int r6 = r7.length()
                    int r6 = r6 + r8
                L_0x0098:
                    com.twitter.Extractor$Entity r9 = new com.twitter.Extractor$Entity
                    com.twitter.Extractor$Entity$Type r10 = com.twitter.Extractor.Entity.Type.URL
                    r9.<init>(r8, r6, r7, r10)
                    r2.add(r9)
                    goto L_0x0053
                L_0x00a3:
                    java.util.List r2 = java.util.Collections.emptyList()
                L_0x00a7:
                    java.util.Iterator r12 = r2.iterator()
                L_0x00ab:
                    boolean r2 = r12.hasNext()
                    if (r2 == 0) goto L_0x00d3
                    java.lang.Object r2 = r12.next()
                    com.twitter.Extractor$Entity r2 = (com.twitter.Extractor.Entity) r2
                    int r5 = r2.start
                    int r6 = r2.end
                    int r5 = r5 - r6
                    int r5 = r5 + r3
                    java.lang.String r2 = r2.value
                    java.lang.String r2 = r2.toLowerCase()
                    java.lang.String r3 = "https://"
                    boolean r2 = r2.startsWith(r3)
                    if (r2 == 0) goto L_0x00ce
                    int r2 = r1.shortUrlLengthHttps
                    goto L_0x00d0
                L_0x00ce:
                    int r2 = r1.shortUrlLength
                L_0x00d0:
                    int r3 = r2 + r5
                    goto L_0x00ab
                L_0x00d3:
                    com.twitter.sdk.android.tweetcomposer.ComposerController r12 = com.twitter.sdk.android.tweetcomposer.ComposerController.this
                    com.twitter.sdk.android.tweetcomposer.ComposerView r12 = r12.composerView
                    int r1 = 140 - r3
                    r12.setCharCount(r1)
                    r12 = 1
                    r1 = 140(0x8c, float:1.96E-43)
                    if (r3 <= r1) goto L_0x00e3
                    r2 = 1
                    goto L_0x00e4
                L_0x00e3:
                    r2 = 0
                L_0x00e4:
                    if (r2 == 0) goto L_0x00f0
                    com.twitter.sdk.android.tweetcomposer.ComposerController r2 = com.twitter.sdk.android.tweetcomposer.ComposerController.this
                    com.twitter.sdk.android.tweetcomposer.ComposerView r2 = r2.composerView
                    int r5 = com.twitter.sdk.android.tweetcomposer.R$style.tw__ComposerCharCountOverflow
                    r2.setCharCountTextStyle(r5)
                    goto L_0x00f9
                L_0x00f0:
                    com.twitter.sdk.android.tweetcomposer.ComposerController r2 = com.twitter.sdk.android.tweetcomposer.ComposerController.this
                    com.twitter.sdk.android.tweetcomposer.ComposerView r2 = r2.composerView
                    int r5 = com.twitter.sdk.android.tweetcomposer.R$style.tw__ComposerCharCount
                    r2.setCharCountTextStyle(r5)
                L_0x00f9:
                    com.twitter.sdk.android.tweetcomposer.ComposerController r0 = com.twitter.sdk.android.tweetcomposer.ComposerController.this
                    com.twitter.sdk.android.tweetcomposer.ComposerView r0 = r0.composerView
                    if (r3 <= 0) goto L_0x0102
                    if (r3 > r1) goto L_0x0102
                    r4 = 1
                L_0x0102:
                    android.widget.Button r12 = r0.tweetButton
                    r12.setEnabled(r4)
                    return
                L_0x0108:
                    throw r2
                L_0x0109:
                    throw r2
                L_0x010a:
                    throw r2
                */
                throw new UnsupportedOperationException("Method not decompiled: com.twitter.sdk.android.tweetcomposer.ComposerView.AnonymousClass1.afterTextChanged(android.text.Editable):void");
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        this.scrollView.setScrollViewListener(new ScrollViewListener() {
            public final void onScrollChanged(int i) {
                ComposerView.this.lambda$onFinishInflate$3$ComposerView(i);
            }
        });
    }

    public void setCallbacks(ComposerCallbacks composerCallbacks) {
        this.callbacks = composerCallbacks;
    }

    public void setCharCount(int i) {
        this.charCountView.setText(String.format(Locale.getDefault(), "%d", new Object[]{Integer.valueOf(i)}));
    }

    public void setCharCountTextStyle(int i) {
        this.charCountView.setTextAppearance(getContext(), i);
    }

    public void setImageView(Uri uri) {
        if (this.imageLoader != null) {
            this.imageView.setVisibility(0);
            this.imageLoader.load(uri).into(this.imageView);
        }
    }

    public void setProfilePhotoView(User user) {
        String profileImageUrlHttps = TextAppearanceConfig.getProfileImageUrlHttps(user, UserUtils$AvatarSize.REASONABLY_SMALL);
        Picasso picasso = this.imageLoader;
        if (picasso != null) {
            picasso.load(profileImageUrlHttps).placeholder((Drawable) this.mediaBg).into(this.avatarView);
        }
    }

    public void setTweetText(String str) {
        this.tweetEditView.setText(str);
    }

    public ComposerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }
}

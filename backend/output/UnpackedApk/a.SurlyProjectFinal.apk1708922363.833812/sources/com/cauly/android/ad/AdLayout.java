package com.cauly.android.ad;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.WebSettings.ZoomDensity;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.inmobi.androidsdk.impl.Constants;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdLayout extends RelativeLayout implements OnTouchListener {
    private final int CAULY_RIGHT_ID;
    private RelativeLayout ClickLayout;
    private final int Click_Area;
    private final int Click_Area2;
    private LinearLayout ContentArea;
    private RelativeLayout CoverLayout;
    private final int ICON;
    private final int IMAGE_ID;
    private final int TEXT_ID;
    private final int TITLE_ID;
    private LinearLayout TextArea;
    private LinearLayout TitleArea;
    /* access modifiers changed from: private */
    public RelativeLayout TotalLayout;
    private final int WEB_ID;
    private ImageView adCaulyView;
    /* access modifiers changed from: private */
    public AdCommon adCommon;
    /* access modifiers changed from: private */
    public AdData adData;
    private ImageView adIconView;
    Bitmap adImage;
    private ImageView adImageView;
    /* access modifiers changed from: private */
    public AdListener adListener;
    private TextView adTextView;
    private TextView adTitleView;
    WebView adWebView;
    /* access modifiers changed from: private */
    public int click_level;
    private ImageButton close_btn;
    private RelativeLayout close_layout;
    private LayoutParams close_params;
    private int desc_size;
    private GradientDrawable gradientDrawable;
    private int padding;
    /* access modifiers changed from: private */
    public String param;
    private int title_size;
    /* access modifiers changed from: private */
    public boolean webview_clicked;
    /* access modifiers changed from: private */
    public boolean webview_create;

    class CaulyWebViewClient extends WebViewClient {
        CaulyWebViewClient() {
        }

        public void onPageStarted(WebView view, String url, Bitmap favicon) {
        }

        public void onPageFinished(WebView view, String url) {
            if (view != null) {
                try {
                    if (AdLayout.this.adData.getAdShape().equalsIgnoreCase("popup")) {
                        if (AdLayout.this.webview_create) {
                            AdLayout.this.addView(AdLayout.this.TotalLayout);
                        }
                        AdLayout.this.webview_create = false;
                    }
                } catch (Exception e) {
                }
            }
        }

        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (view == null) {
                return true;
            }
            try {
                if (!url.equals(AdLayout.this.adData.getShapeInfo())) {
                    AdLayout.this.param = "click_url=" + AdCommon.urlEncoder(url);
                    AdLayout.this.clickedAD();
                }
                Matcher youtubeMatcher = Pattern.compile("^(https?:\\/\\/)((\\w+\\.)?(youtube.com)|(youtu.be))").matcher(url);
                Matcher caulyBrowserMatcher = Pattern.compile("cauly_action_param=open_browser").matcher(url);
                if (youtubeMatcher.find() || caulyBrowserMatcher.find()) {
                    return AdLayout.this.openBrowser(url);
                }
                if (!url.startsWith("http://") && !url.startsWith("https://")) {
                    return AdLayout.this.openBrowser(url);
                }
                view.loadUrl(url);
                return true;
            } catch (Exception e) {
                return true;
            }
        }
    }

    AdLayout(Context context) {
        this(context, null, 0);
    }

    AdLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    AdLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.IMAGE_ID = 1;
        this.WEB_ID = 1;
        this.TITLE_ID = 2;
        this.TEXT_ID = 3;
        this.CAULY_RIGHT_ID = 4;
        this.ICON = 3;
        this.Click_Area = 5;
        this.Click_Area2 = 6;
        this.adTitleView = null;
        this.adTextView = null;
        this.adCaulyView = null;
        this.adImageView = null;
        this.adWebView = null;
        this.adIconView = null;
        this.TotalLayout = null;
        this.ClickLayout = null;
        this.CoverLayout = null;
        this.TextArea = null;
        this.TitleArea = null;
        this.ContentArea = null;
        this.webview_create = false;
        this.webview_clicked = false;
        this.param = Constants.QA_SERVER_URL;
    }

    /* access modifiers changed from: 0000 */
    public void setAdData(AdData adData2, AdCommon adCommon2, int size, AdListener listener) {
        int x_width;
        int x_width2;
        LayoutParams webViewparams;
        int new_width;
        int new_icon_width;
        String title;
        String contents;
        int new_width2;
        this.adData = adData2;
        this.adCommon = adCommon2;
        this.adListener = listener;
        if (size > 120) {
            this.title_size = 27;
            this.desc_size = 25;
        } else if (size > 100) {
            this.title_size = 23;
            this.desc_size = 21;
        } else {
            this.title_size = 18;
            this.desc_size = 16;
        }
        if (adData2 != null) {
            setFocusable(true);
            this.adImage = adData2.getAdImage();
            this.padding = 5;
            if (adData2.getAdShape().equalsIgnoreCase("text")) {
                if (this.adImage != null) {
                    int imageSize = size - (this.padding * 2);
                    this.adImageView = new ImageView(getContext().getApplicationContext());
                    this.adImageView.setId(1);
                    this.adImage = Bitmap.createScaledBitmap(this.adImage, imageSize, imageSize, true);
                    this.adImage = ImageHelper.getRoundedCornerBitmap(this.adImage, this.padding * 2);
                    this.adImageView.setImageBitmap(this.adImage);
                    LayoutParams layoutParams = new LayoutParams(imageSize, imageSize);
                    layoutParams.setMargins(this.padding, this.padding, this.padding + 2, this.padding);
                    layoutParams.addRule(9);
                    layoutParams.addRule(15);
                    this.adImageView.setLayoutParams(layoutParams);
                    addView(this.adImageView);
                } else {
                    this.adImageView = new ImageView(getContext().getApplicationContext());
                    this.adImageView.setId(1);
                    try {
                        new_width = Integer.parseInt(String.format("%.0f", new Object[]{Double.valueOf(((double) 40) * (((double) size) / 96.0d))}));
                    } catch (Exception e) {
                        Log.i("new_width", "Default value");
                        new_width = 20;
                    }
                    Bitmap left_cauly = null;
                    try {
                        left_cauly = BitmapFactory.decodeStream(getContext().getApplicationContext().getAssets().open("b_left.png"));
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    this.adImageView.setImageBitmap(Bitmap.createScaledBitmap(left_cauly, new_width, size, true));
                    LayoutParams layoutParams2 = new LayoutParams(new_width, size);
                    layoutParams2.setMargins(0, 0, this.padding + 2, 0);
                    layoutParams2.addRule(9);
                    layoutParams2.addRule(15);
                    this.adImageView.setLayoutParams(layoutParams2);
                    addView(this.adImageView);
                }
                int offset = 0;
                if (this.adImage != null) {
                    String color = adData2.getColor().replace("a_", "b_");
                    this.adCaulyView = new ImageView(getContext().getApplicationContext());
                    this.adCaulyView.setId(4);
                    try {
                        new_width2 = Integer.parseInt(String.format("%.0f", new Object[]{Double.valueOf(((double) 40) * (((double) size) / 96.0d))}));
                    } catch (Exception e3) {
                        Log.i("new_width", "Default value");
                        new_width2 = 20;
                    }
                    offset = new_width2;
                    Bitmap right_cauly = null;
                    try {
                        right_cauly = BitmapFactory.decodeStream(getContext().getApplicationContext().getAssets().open(color));
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                    this.adCaulyView.setImageBitmap(Bitmap.createScaledBitmap(right_cauly, new_width2, size, true));
                    LayoutParams layoutParams3 = new LayoutParams(new_width2, size);
                    layoutParams3.setMargins(0, 0, 0, 0);
                    layoutParams3.addRule(11);
                    layoutParams3.addRule(15);
                    this.adCaulyView.setLayoutParams(layoutParams3);
                    addView(this.adCaulyView);
                }
                this.adIconView = new ImageView(getContext().getApplicationContext());
                this.adIconView.setId(3);
                try {
                    new_icon_width = Integer.parseInt(String.format("%.0f", new Object[]{Double.valueOf(((double) 76) * (((double) size) / 96.0d))}));
                } catch (Exception e5) {
                    Log.i("new_icon_width", "Default value");
                    new_icon_width = 38;
                }
                String icon_image = AdCommon.Change_Icon(adData2.getAdType());
                if (adData2.getAdType().equalsIgnoreCase("app") && adData2.getMarket().equalsIgnoreCase("4")) {
                    icon_image = AdCommon.Change_Icon("skt");
                }
                Bitmap icon_cauly = null;
                try {
                    icon_cauly = BitmapFactory.decodeStream(getContext().getApplicationContext().getAssets().open(icon_image));
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
                Bitmap layout_background = null;
                String gradient_color = adData2.getColor().replace("a_", Constants.QA_SERVER_URL).replace(".png", Constants.QA_SERVER_URL);
                try {
                    layout_background = BitmapFactory.decodeStream(getContext().getApplicationContext().getAssets().open(adData2.getColor()));
                } catch (IOException e7) {
                    e7.printStackTrace();
                }
                BitmapDrawable background = new BitmapDrawable(layout_background);
                background.setCallback(null);
                setBackgroundDrawable(background);
                GradientDrawable gradientDrawable2 = new GradientDrawable(Orientation.BOTTOM_TOP, AdCommon.Change_Icon_Background(gradient_color));
                this.gradientDrawable = gradientDrawable2;
                this.gradientDrawable.setShape(0);
                this.gradientDrawable.setCallback(null);
                Bitmap icon_cauly2 = Bitmap.createScaledBitmap(icon_cauly, new_icon_width, size, true);
                this.adIconView.setBackgroundDrawable(this.gradientDrawable);
                this.adIconView.setImageBitmap(icon_cauly2);
                LayoutParams layoutParams4 = new LayoutParams(new_icon_width, size);
                layoutParams4.setMargins(0, 0, offset, 0);
                layoutParams4.addRule(11);
                layoutParams4.addRule(15);
                this.adIconView.setLayoutParams(layoutParams4);
                addView(this.adIconView);
                if (this.adImage != null) {
                    if (adData2.getTitle().length() > 14) {
                        title = adData2.getTitle().substring(0, 14);
                    } else {
                        title = adData2.getTitle();
                    }
                } else if (adData2.getTitle().length() > 18) {
                    title = adData2.getTitle().substring(0, 18);
                } else {
                    title = adData2.getTitle();
                }
                if (this.adImage != null) {
                    if (adData2.getDescription().length() > 17) {
                        contents = adData2.getDescription().substring(0, 17);
                    } else {
                        contents = adData2.getDescription();
                    }
                } else if (adData2.getDescription().length() > 21) {
                    contents = adData2.getDescription().substring(0, 21);
                } else {
                    contents = adData2.getDescription();
                }
                this.TextArea = new LinearLayout(getContext().getApplicationContext());
                this.TextArea.setOrientation(1);
                LayoutParams TextAreaParams = new LayoutParams(-1, -1);
                TextAreaParams.addRule(1, 1);
                TextAreaParams.addRule(0, 3);
                this.TextArea.setLayoutParams(TextAreaParams);
                this.TitleArea = new LinearLayout(getContext().getApplicationContext());
                this.TitleArea.setOrientation(1);
                this.TitleArea.setBackgroundColor(0);
                LinearLayout.LayoutParams TitleAreaParams = new LinearLayout.LayoutParams(-1, -1, 1.0f);
                TitleAreaParams.setMargins(this.padding * 2, 0, 0, 0);
                this.TitleArea.setLayoutParams(TitleAreaParams);
                this.TitleArea.setGravity(80);
                this.adTitleView = new TextView(getContext().getApplicationContext());
                this.adTitleView.setId(2);
                this.adTitleView.setSingleLine(true);
                this.adTitleView.setText(title);
                this.adTitleView.setTextColor(-1);
                this.adTitleView.setTextSize(0, (float) this.title_size);
                LayoutParams adTitleViewParams = new LayoutParams(-2, -2);
                adTitleViewParams.addRule(15);
                this.adTitleView.setLayoutParams(adTitleViewParams);
                this.adTitleView.setPadding(0, 0, 0, this.padding / 2);
                this.TitleArea.addView(this.adTitleView);
                this.ContentArea = new LinearLayout(getContext().getApplicationContext());
                this.ContentArea.setOrientation(1);
                this.ContentArea.setBackgroundColor(0);
                LinearLayout.LayoutParams ContentAreaParams = new LinearLayout.LayoutParams(-1, -1, 1.0f);
                ContentAreaParams.setMargins(this.padding * 2, 0, 0, 0);
                this.ContentArea.setLayoutParams(ContentAreaParams);
                this.ContentArea.setGravity(48);
                this.adTextView = new TextView(getContext().getApplicationContext());
                this.adTextView.setId(3);
                this.adTextView.setSingleLine(true);
                this.adTextView.setText(contents);
                this.adTextView.setTextColor(-1);
                this.adTextView.setTextSize(0, (float) this.desc_size);
                LayoutParams adTextViewParams = new LayoutParams(-2, -2);
                adTextViewParams.addRule(15);
                this.adTextView.setLayoutParams(adTextViewParams);
                this.adTextView.setPadding(0, this.padding / 2, 0, 0);
                this.ContentArea.addView(this.adTextView);
                this.TextArea.addView(this.TitleArea);
                this.TextArea.addView(this.ContentArea);
                addView(this.TextArea);
                this.CoverLayout = new RelativeLayout(getContext().getApplicationContext());
                this.CoverLayout.setBackgroundColor(0);
                this.CoverLayout.setLayoutParams(new LayoutParams(-1, -1));
                addView(this.CoverLayout);
                this.ClickLayout = new RelativeLayout(getContext().getApplicationContext());
                this.ClickLayout.setId(5);
                this.ClickLayout.setBackgroundColor(0);
                LayoutParams Clickparams = new LayoutParams(-1, -1);
                Clickparams.setMargins(20, 15, 20, 15);
                this.ClickLayout.setLayoutParams(Clickparams);
                addView(this.ClickLayout);
                this.ClickLayout.setFocusable(true);
                this.ClickLayout.setClickable(true);
                this.ClickLayout.setFocusableInTouchMode(true);
                this.ClickLayout.setOnTouchListener(this);
            } else if (adData2.getAdShape().equalsIgnoreCase("banner")) {
                if (adData2.getId() != null && this.adImage != null) {
                    this.adImageView = new ImageView(getContext().getApplicationContext());
                    this.adImageView.setId(1);
                    BitmapDrawable background2 = new BitmapDrawable(this.adImage);
                    background2.setCallback(null);
                    this.adImageView.setBackgroundDrawable(background2);
                    LayoutParams layoutParams5 = new LayoutParams(-1, size + 20);
                    layoutParams5.setMargins(0, 0, 0, 0);
                    layoutParams5.addRule(9);
                    layoutParams5.addRule(15);
                    this.adImageView.setLayoutParams(layoutParams5);
                    addView(this.adImageView);
                    this.CoverLayout = new RelativeLayout(getContext().getApplicationContext());
                    this.CoverLayout.setBackgroundColor(0);
                    this.CoverLayout.setLayoutParams(new LayoutParams(-1, -1));
                    addView(this.CoverLayout);
                    this.ClickLayout = new RelativeLayout(getContext().getApplicationContext());
                    this.ClickLayout.setId(6);
                    this.ClickLayout.setBackgroundColor(0);
                    LayoutParams Clickparams2 = new LayoutParams(-1, -1);
                    Clickparams2.setMargins(10, 15, 20, 15);
                    this.ClickLayout.setLayoutParams(Clickparams2);
                    addView(this.ClickLayout);
                    this.ClickLayout.setFocusable(true);
                    this.ClickLayout.setClickable(true);
                    this.ClickLayout.setFocusableInTouchMode(true);
                    this.ClickLayout.setOnTouchListener(this);
                }
            } else if (adData2.getAdShape().equalsIgnoreCase("rich")) {
                if (adData2.getId() != null) {
                    this.adWebView = new WebView(getContext().getApplicationContext());
                    this.adWebView.setId(1);
                    this.adWebView.getSettings().setJavaScriptEnabled(true);
                    this.adWebView.getSettings().setDefaultZoom(ZoomDensity.FAR);
                    this.adWebView.getSettings().setBuiltInZoomControls(false);
                    this.adWebView.setVerticalScrollBarEnabled(false);
                    this.adWebView.setHorizontalScrollBarEnabled(false);
                    this.adWebView.getSettings().setPluginsEnabled(true);
                    WebView webView = this.adWebView;
                    AnonymousClass1 r0 = new OnTouchListener() {
                        public boolean onTouch(View v, MotionEvent event) {
                            return false;
                        }
                    };
                    webView.setOnTouchListener(r0);
                    this.adWebView.loadUrl(adData2.getShapeInfo());
                    WebView webView2 = this.adWebView;
                    CaulyWebViewClient caulyWebViewClient = new CaulyWebViewClient();
                    webView2.setWebViewClient(caulyWebViewClient);
                    if (adData2.getPayType().equalsIgnoreCase("cpc")) {
                        webViewparams = new LayoutParams(-1, size + 20);
                    } else {
                        webViewparams = new LayoutParams(-1, -1);
                    }
                    webViewparams.setMargins(0, 0, 0, 0);
                    webViewparams.addRule(9);
                    webViewparams.addRule(15);
                    this.adWebView.setLayoutParams(webViewparams);
                    this.webview_create = true;
                    addView(this.adWebView);
                    this.CoverLayout = new RelativeLayout(getContext().getApplicationContext());
                    this.CoverLayout.setBackgroundColor(0);
                    this.CoverLayout.setLayoutParams(new LayoutParams(-1, -1));
                    addView(this.CoverLayout);
                    this.ClickLayout = new RelativeLayout(getContext().getApplicationContext());
                    this.ClickLayout.setId(6);
                    this.ClickLayout.setBackgroundColor(0);
                    LayoutParams Clickparams3 = new LayoutParams(-1, -1);
                    Clickparams3.setMargins(10, 15, 20, 15);
                    this.ClickLayout.setLayoutParams(Clickparams3);
                    addView(this.ClickLayout);
                    this.ClickLayout.setFocusable(true);
                    this.ClickLayout.setClickable(true);
                    this.ClickLayout.setFocusableInTouchMode(true);
                    this.ClickLayout.setOnTouchListener(this);
                }
            } else if (adData2.getAdShape().equalsIgnoreCase("full")) {
                Display display = ((WindowManager) getContext().getApplicationContext().getSystemService("window")).getDefaultDisplay();
                int width = display.getWidth();
                int height = display.getHeight();
                int layout_width = 0;
                int layout_height = 0;
                if (height > width) {
                    layout_width = width;
                    layout_height = height;
                } else if (height < width) {
                    layout_width = (height * height) / width;
                    layout_height = height;
                }
                if (adData2.getId() == null) {
                    return;
                }
                if (this.adImage != null) {
                    this.TotalLayout = new RelativeLayout(getContext().getApplicationContext());
                    this.TotalLayout.setBackgroundColor(-16777216);
                    this.TotalLayout.setLayoutParams(new LayoutParams(-1, -1));
                    this.TotalLayout.setGravity(17);
                    this.adImageView = new ImageView(getContext().getApplicationContext());
                    BitmapDrawable background3 = new BitmapDrawable(this.adImage);
                    background3.setCallback(null);
                    this.adImageView.setBackgroundDrawable(background3);
                    LayoutParams layoutParams6 = new LayoutParams(layout_width, layout_height);
                    layoutParams6.setMargins(0, 0, 0, 0);
                    layoutParams6.addRule(13);
                    this.adImageView.setLayoutParams(layoutParams6);
                    this.ClickLayout = new RelativeLayout(getContext().getApplicationContext());
                    this.ClickLayout.setId(6);
                    this.ClickLayout.setBackgroundColor(0);
                    LayoutParams Clickparams4 = new LayoutParams(layout_width - 40, layout_height);
                    Clickparams4.addRule(13);
                    Clickparams4.setMargins(0, 15, 0, 15);
                    this.ClickLayout.setLayoutParams(Clickparams4);
                    this.ClickLayout.setFocusable(true);
                    this.ClickLayout.setClickable(true);
                    this.ClickLayout.setFocusableInTouchMode(true);
                    this.ClickLayout.setOnTouchListener(this);
                    this.close_layout = new RelativeLayout(getContext().getApplicationContext());
                    this.close_params = new LayoutParams(-1, -2);
                    this.close_params.setMargins(0, -10, -10, 0);
                    this.close_layout.setLayoutParams(this.close_params);
                    this.close_layout.setGravity(5);
                    this.close_btn = new ImageButton(getContext().getApplicationContext());
                    try {
                        int display_width = display.getWidth();
                        int display_height = display.getHeight();
                        if (display_height > display_width) {
                            x_width2 = display_width / 10;
                        } else {
                            x_width2 = display_height / 10;
                        }
                        this.close_btn.setImageBitmap(Bitmap.createScaledBitmap(BitmapFactory.decodeStream(getContext().getApplicationContext().getAssets().open("pop_btn_x.png")), x_width2, x_width2, true));
                        this.close_btn.setBackgroundColor(0);
                        ImageButton imageButton = this.close_btn;
                        AnonymousClass2 r02 = new OnClickListener() {
                            public void onClick(View v) {
                                try {
                                    if (!AdLayout.this.webview_clicked) {
                                        AdLayout.this.webview_clicked = true;
                                        AdLayout.this.param = "where=x";
                                        AdLayout.this.clickedAD();
                                    }
                                    AdLayout.this.removeView(AdLayout.this.TotalLayout);
                                    if (AdLayout.this.adListener != null) {
                                        AdLayout.this.adListener.onCloseInterstitialAd();
                                    }
                                } catch (Exception e) {
                                }
                            }
                        };
                        imageButton.setOnClickListener(r02);
                        this.TotalLayout.addView(this.adImageView);
                        this.TotalLayout.addView(this.ClickLayout);
                        this.close_layout.addView(this.close_btn);
                        this.TotalLayout.addView(this.close_layout);
                        this.webview_create = true;
                        addView(this.TotalLayout);
                    } catch (Exception e8) {
                    }
                } else {
                    throw new RuntimeException();
                }
            } else if (adData2.getAdShape().equalsIgnoreCase("popup") && adData2.getId() != null) {
                this.TotalLayout = new RelativeLayout(getContext().getApplicationContext());
                this.TotalLayout.setBackgroundColor(-16777216);
                this.TotalLayout.setLayoutParams(new LayoutParams(-1, -1));
                this.TotalLayout.setGravity(17);
                this.adWebView = new WebView(getContext().getApplicationContext());
                this.adWebView.setBackgroundColor(0);
                this.adWebView.setId(1);
                this.adWebView.getSettings().setJavaScriptEnabled(true);
                this.adWebView.getSettings().setDefaultZoom(ZoomDensity.FAR);
                this.adWebView.getSettings().setLoadWithOverviewMode(true);
                this.adWebView.getSettings().setUseWideViewPort(true);
                this.adWebView.getSettings().setBuiltInZoomControls(true);
                this.adWebView.setVerticalScrollBarEnabled(true);
                this.adWebView.setHorizontalScrollBarEnabled(true);
                this.adWebView.getSettings().setPluginsEnabled(true);
                this.adWebView.getSettings().setSupportMultipleWindows(true);
                WebView webView3 = this.adWebView;
                AnonymousClass3 r03 = new DownloadListener() {
                    public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
                        AdLayout.this.openBrowser(url);
                    }
                };
                webView3.setDownloadListener(r03);
                WebView webView4 = this.adWebView;
                CaulyWebViewClient caulyWebViewClient2 = new CaulyWebViewClient();
                webView4.setWebViewClient(caulyWebViewClient2);
                this.adWebView.loadUrl(adData2.getShapeInfo());
                WebView webView5 = this.adWebView;
                AnonymousClass4 r04 = new OnTouchListener() {
                    public boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == 0 && !AdLayout.this.webview_clicked) {
                            AdLayout.this.webview_clicked = true;
                            AdLayout.this.param = "where=body";
                            AdLayout.this.clickedAD();
                        }
                        return false;
                    }
                };
                webView5.setOnTouchListener(r04);
                LayoutParams layoutParams7 = new LayoutParams(-1, -1);
                layoutParams7.setMargins(0, 0, 0, 0);
                layoutParams7.addRule(9);
                layoutParams7.addRule(15);
                this.adWebView.setLayoutParams(layoutParams7);
                this.close_layout = new RelativeLayout(getContext().getApplicationContext());
                this.close_params = new LayoutParams(-1, -2);
                this.close_params.setMargins(0, -10, -10, 0);
                this.close_layout.setLayoutParams(this.close_params);
                this.close_layout.setGravity(5);
                this.close_btn = new ImageButton(getContext().getApplicationContext());
                try {
                    Display display2 = ((WindowManager) getContext().getApplicationContext().getSystemService("window")).getDefaultDisplay();
                    int display_width2 = display2.getWidth();
                    int display_height2 = display2.getHeight();
                    if (display_height2 > display_width2) {
                        x_width = display_width2 / 10;
                    } else {
                        x_width = display_height2 / 10;
                    }
                    this.close_btn.setImageBitmap(Bitmap.createScaledBitmap(BitmapFactory.decodeStream(getContext().getApplicationContext().getAssets().open("pop_btn_x.png")), x_width, x_width, true));
                    this.close_btn.setBackgroundColor(0);
                    ImageButton imageButton2 = this.close_btn;
                    AnonymousClass5 r05 = new OnClickListener() {
                        public void onClick(View v) {
                            try {
                                if (!AdLayout.this.webview_clicked) {
                                    AdLayout.this.webview_clicked = true;
                                    AdLayout.this.param = "where=x";
                                    AdLayout.this.clickedAD();
                                }
                                AdLayout.this.adWebView.destroy();
                                AdLayout.this.removeView(AdLayout.this.TotalLayout);
                                if (AdLayout.this.adListener != null) {
                                    AdLayout.this.adListener.onCloseInterstitialAd();
                                }
                            } catch (Exception e) {
                            }
                        }
                    };
                    imageButton2.setOnClickListener(r05);
                    this.TotalLayout.addView(this.adWebView);
                    this.close_layout.addView(this.close_btn);
                    this.TotalLayout.addView(this.close_layout);
                    this.webview_create = true;
                } catch (Exception e9) {
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public boolean openBrowser(String url) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(url));
        intent.addFlags(268435456);
        intent.addCategory("android.intent.category.BROWSABLE");
        intent.putExtra("com.android.browser.application_id", getContext().getApplicationContext().getPackageName());
        try {
            getContext().getApplicationContext().startActivity(intent);
            return true;
        } catch (ActivityNotFoundException e) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    public void clickedAD() {
        new Thread() {
            public void run() {
                try {
                    new AdClickHandler().sendClickData(AdLayout.this.getContext().getApplicationContext(), AdLayout.this.adCommon, AdLayout.this.adData, AdLayout.this.param);
                } catch (Exception e) {
                    Log.e("Cauly Ads", "click AD", e);
                }
            }
        }.start();
    }

    public boolean onTouch(View view, MotionEvent event) {
        String url;
        String url2;
        if (event.getAction() != 0 && event.getAction() == 1) {
            if (this.adData.getPayType().equalsIgnoreCase("cpc")) {
                if (event.getX() < 0.0f || event.getX() > ((float) view.getWidth()) || event.getY() < 0.0f || event.getY() > ((float) view.getHeight())) {
                    this.param = "click_level=1";
                    this.click_level = 1;
                } else {
                    this.param = "click_level=2";
                    this.click_level = 2;
                }
                if (this.adData.getId() != null) {
                    if (this.adData.getAdType().equalsIgnoreCase("app")) {
                        if (this.adData.getMarket().equalsIgnoreCase("2")) {
                            Intent i = new Intent("android.intent.action.VIEW", Uri.parse(String.format("market://details?id=" + this.adData.getLink(), new Object[0])));
                            i.addFlags(268435456);
                            try {
                                clickedAD();
                                if (!this.adData.getStrictLevel().equals("2")) {
                                    getContext().getApplicationContext().startActivity(i);
                                } else if (this.click_level == 2) {
                                    getContext().getApplicationContext().startActivity(i);
                                }
                            } catch (Exception e) {
                                Log.e("Cauly Ads", "click App AD CPC", e);
                            }
                        } else if (this.adData.getMarket().equalsIgnoreCase("4")) {
                            String tstore = this.adData.getLink();
                            if (tstore.startsWith("tstore://") || tstore.startsWith("http://")) {
                                url2 = tstore;
                            } else {
                                url2 = String.format("tstore://PRODUCT_VIEW/%s/0", new Object[]{tstore});
                            }
                            Intent i2 = new Intent("android.intent.action.VIEW", Uri.parse(url2));
                            i2.addFlags(268435456);
                            try {
                                clickedAD();
                                if (!this.adData.getStrictLevel().equals("2")) {
                                    getContext().getApplicationContext().startActivity(i2);
                                } else if (this.click_level == 2) {
                                    getContext().getApplicationContext().startActivity(i2);
                                }
                            } catch (Exception e2) {
                                Log.e("Cauly Ads", "click App AD CPC", e2);
                            }
                        }
                    } else if (this.adData.getAdType().equalsIgnoreCase("skt")) {
                        Intent i3 = new Intent(getContext().getApplicationContext().getPackageManager().getLaunchIntentForPackage("com.skt.skaf.A000Z00040"));
                        i3.setFlags(268435456);
                        try {
                            clickedAD();
                            if (!this.adData.getStrictLevel().equals("2")) {
                                getContext().getApplicationContext().startActivity(i3);
                            } else if (this.click_level == 2) {
                                getContext().getApplicationContext().startActivity(i3);
                            }
                            return false;
                        } catch (Exception e3) {
                            Log.e("Cauly Ads", "click skt AD CPC", e3);
                        }
                    } else if (this.adData.getAdType().equalsIgnoreCase("site")) {
                        String site = this.adData.getLink();
                        if (site.contains("http://")) {
                            url = String.format("http://%s", new Object[]{site.replace("http://", Constants.QA_SERVER_URL)});
                        } else if (site.contains("https://")) {
                            url = String.format("https://%s", new Object[]{site.replace("https://", Constants.QA_SERVER_URL)});
                        } else {
                            url = String.format("http://%s", new Object[]{site});
                        }
                        Intent i4 = new Intent("android.intent.action.VIEW", Uri.parse(url));
                        i4.addFlags(268435456);
                        try {
                            clickedAD();
                            if (!this.adData.getStrictLevel().equals("2")) {
                                getContext().getApplicationContext().startActivity(i4);
                            } else if (this.click_level == 2) {
                                getContext().getApplicationContext().startActivity(i4);
                            }
                        } catch (Exception e4) {
                            Log.e("Cauly Ads", "click Site AD CPC", e4);
                        }
                    } else if (this.adData.getAdType().equalsIgnoreCase("call")) {
                        if (this.adCommon.getAllowcall().equals("yes")) {
                            Builder dialog = new Builder(getContext().getApplicationContext());
                            dialog.setMessage(String.valueOf(this.adData.getLink()) + "번으로 전화를 겁니다.\n거시겠습니까?").setCancelable(false).setPositiveButton("YES", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    try {
                                        Intent i = new Intent("android.intent.action.CALL", Uri.parse(String.format("tel:%s", new Object[]{AdLayout.this.adData.getLink()})));
                                        i.addFlags(268435456);
                                        try {
                                            AdLayout.this.clickedAD();
                                            if (!AdLayout.this.adData.getStrictLevel().equals("2")) {
                                                AdLayout.this.getContext().getApplicationContext().startActivity(i);
                                            } else if (AdLayout.this.click_level == 2) {
                                                AdLayout.this.getContext().getApplicationContext().startActivity(i);
                                            }
                                        } catch (Exception e) {
                                            Log.e("Cauly Ads", "click Call AD CPC", e);
                                        }
                                    } catch (Exception e2) {
                                        Log.e("Cauly Ads", "click alert AD CPC", e2);
                                    }
                                }
                            }).setNeutralButton("NO", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            });
                            AlertDialog alert = dialog.create();
                            alert.setCancelable(false);
                            alert.show();
                        }
                    } else if (this.adData.getAdType().equalsIgnoreCase("fullsite")) {
                        try {
                            clickedAD();
                            WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                            lp.width = -1;
                            lp.height = -1;
                            AdWebview FullSite = new AdWebview(getContext().getApplicationContext());
                            FullSite.setAdData(this.adData, this.adCommon);
                            FullSite.setCancelable(false);
                            if (!this.adData.getStrictLevel().equals("2")) {
                                FullSite.show();
                            } else if (this.click_level == 2) {
                                FullSite.show();
                            }
                            FullSite.getWindow().setAttributes(lp);
                        } catch (Exception e5) {
                            Log.e("Cauly Ads", "click FullSite AD CPC", e5);
                        }
                    }
                }
            } else if (this.adData.getPayType().equalsIgnoreCase("cpm") && this.adData.getAdShape().equalsIgnoreCase("full")) {
                if (!this.webview_clicked) {
                    this.webview_clicked = true;
                    this.param = "where=body";
                    clickedAD();
                }
                removeAllViews();
                if (this.adListener != null) {
                    this.adListener.onCloseInterstitialAd();
                }
            }
        }
        return false;
    }
}

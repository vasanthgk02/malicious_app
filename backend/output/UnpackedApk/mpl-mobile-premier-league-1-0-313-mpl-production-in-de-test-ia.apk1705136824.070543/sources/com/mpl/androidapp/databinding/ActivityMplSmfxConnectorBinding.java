package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.mpl.androidapp.R;

public final class ActivityMplSmfxConnectorBinding implements ViewBinding {
    public final ConstraintLayout LinearLayout1;
    public final TextView battleDescTxt;
    public final ImageView battlePlayerStatusImg;
    public final FrameLayout battlePlayerStatusImgContainer;
    public final TextView battleTimeProgresstxt;
    public final ProgressBar battleTimerProgress;
    public final Button battleTryAgain;
    public final ImageView closeBtn;
    public final FrameLayout didNotJoinContainer;
    public final Button didNotJoinOkButton;
    public final TextView firstRankAmountText;
    public final LinearLayout firstRankContainer;
    public final TextView firstRankPositionText;
    public final SimpleDraweeView gameBackground;
    public final TextView gameName;
    public final RelativeLayout headerLayout;
    public final RelativeLayout headerLayoutKO;
    public final RelativeLayout headerLayoutNormal;
    public final LinearLayout knockoutStatusContainer;
    public final ImageView koClose;
    public final ConstraintLayout matchFailedScreen;
    public final ConstraintLayout matchSuccessScreen;
    public final RecyclerView matchedPlayerList;
    public final TextView matchingStatus;
    public final TextView matchingTimer;
    public final ImageView mplLogo;
    public final LinearLayout multiPlayerDesc;
    public final ImageView notFoundCrest;
    public final TextView playerStatus;
    public final TextView playerStatusDesc;
    public final LinearLayout prizeBreakUp;
    public final RecyclerView prizeBreakUpList;
    public final RelativeLayout progressContainer;
    public final ConstraintLayout rootView;
    public final LinearLayout statusContainer;
    public final LinearLayout webviewBack;

    public ActivityMplSmfxConnectorBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, ImageView imageView, FrameLayout frameLayout, TextView textView2, ProgressBar progressBar, Button button, ImageView imageView2, FrameLayout frameLayout2, Button button2, TextView textView3, LinearLayout linearLayout, TextView textView4, SimpleDraweeView simpleDraweeView, TextView textView5, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, LinearLayout linearLayout2, ImageView imageView3, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, RecyclerView recyclerView, TextView textView6, TextView textView7, ImageView imageView4, LinearLayout linearLayout3, ImageView imageView5, TextView textView8, TextView textView9, LinearLayout linearLayout4, RecyclerView recyclerView2, RelativeLayout relativeLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6) {
        this.rootView = constraintLayout;
        this.LinearLayout1 = constraintLayout2;
        this.battleDescTxt = textView;
        this.battlePlayerStatusImg = imageView;
        this.battlePlayerStatusImgContainer = frameLayout;
        this.battleTimeProgresstxt = textView2;
        this.battleTimerProgress = progressBar;
        this.battleTryAgain = button;
        this.closeBtn = imageView2;
        this.didNotJoinContainer = frameLayout2;
        this.didNotJoinOkButton = button2;
        this.firstRankAmountText = textView3;
        this.firstRankContainer = linearLayout;
        this.firstRankPositionText = textView4;
        this.gameBackground = simpleDraweeView;
        this.gameName = textView5;
        this.headerLayout = relativeLayout;
        this.headerLayoutKO = relativeLayout2;
        this.headerLayoutNormal = relativeLayout3;
        this.knockoutStatusContainer = linearLayout2;
        this.koClose = imageView3;
        this.matchFailedScreen = constraintLayout3;
        this.matchSuccessScreen = constraintLayout4;
        this.matchedPlayerList = recyclerView;
        this.matchingStatus = textView6;
        this.matchingTimer = textView7;
        this.mplLogo = imageView4;
        this.multiPlayerDesc = linearLayout3;
        this.notFoundCrest = imageView5;
        this.playerStatus = textView8;
        this.playerStatusDesc = textView9;
        this.prizeBreakUp = linearLayout4;
        this.prizeBreakUpList = recyclerView2;
        this.progressContainer = relativeLayout4;
        this.statusContainer = linearLayout5;
        this.webviewBack = linearLayout6;
    }

    public static ActivityMplSmfxConnectorBinding bind(View view) {
        View view2 = view;
        ConstraintLayout constraintLayout = (ConstraintLayout) view2;
        int i = R.id.battleDescTxt;
        TextView textView = (TextView) view2.findViewById(R.id.battleDescTxt);
        if (textView != null) {
            i = R.id.battlePlayerStatusImg;
            ImageView imageView = (ImageView) view2.findViewById(R.id.battlePlayerStatusImg);
            if (imageView != null) {
                i = R.id.battlePlayerStatusImgContainer;
                FrameLayout frameLayout = (FrameLayout) view2.findViewById(R.id.battlePlayerStatusImgContainer);
                if (frameLayout != null) {
                    i = R.id.battleTimeProgresstxt;
                    TextView textView2 = (TextView) view2.findViewById(R.id.battleTimeProgresstxt);
                    if (textView2 != null) {
                        i = R.id.battleTimerProgress;
                        ProgressBar progressBar = (ProgressBar) view2.findViewById(R.id.battleTimerProgress);
                        if (progressBar != null) {
                            i = R.id.battle_try_again;
                            Button button = (Button) view2.findViewById(R.id.battle_try_again);
                            if (button != null) {
                                i = R.id.close_btn;
                                ImageView imageView2 = (ImageView) view2.findViewById(R.id.close_btn);
                                if (imageView2 != null) {
                                    i = R.id.didNotJoinContainer;
                                    FrameLayout frameLayout2 = (FrameLayout) view2.findViewById(R.id.didNotJoinContainer);
                                    if (frameLayout2 != null) {
                                        i = R.id.didNotJoinOkButton;
                                        Button button2 = (Button) view2.findViewById(R.id.didNotJoinOkButton);
                                        if (button2 != null) {
                                            i = R.id.firstRankAmountText;
                                            TextView textView3 = (TextView) view2.findViewById(R.id.firstRankAmountText);
                                            if (textView3 != null) {
                                                i = R.id.firstRankContainer;
                                                LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.firstRankContainer);
                                                if (linearLayout != null) {
                                                    i = R.id.firstRankPositionText;
                                                    TextView textView4 = (TextView) view2.findViewById(R.id.firstRankPositionText);
                                                    if (textView4 != null) {
                                                        i = R.id.gameBackground;
                                                        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view2.findViewById(R.id.gameBackground);
                                                        if (simpleDraweeView != null) {
                                                            i = R.id.game_name;
                                                            TextView textView5 = (TextView) view2.findViewById(R.id.game_name);
                                                            if (textView5 != null) {
                                                                i = R.id.header_layout;
                                                                RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(R.id.header_layout);
                                                                if (relativeLayout != null) {
                                                                    i = R.id.headerLayoutKO;
                                                                    RelativeLayout relativeLayout2 = (RelativeLayout) view2.findViewById(R.id.headerLayoutKO);
                                                                    if (relativeLayout2 != null) {
                                                                        i = R.id.header_layoutNormal;
                                                                        RelativeLayout relativeLayout3 = (RelativeLayout) view2.findViewById(R.id.header_layoutNormal);
                                                                        if (relativeLayout3 != null) {
                                                                            i = R.id.knockoutStatusContainer;
                                                                            LinearLayout linearLayout2 = (LinearLayout) view2.findViewById(R.id.knockoutStatusContainer);
                                                                            if (linearLayout2 != null) {
                                                                                i = R.id.koClose;
                                                                                ImageView imageView3 = (ImageView) view2.findViewById(R.id.koClose);
                                                                                if (imageView3 != null) {
                                                                                    i = R.id.matchFailedScreen;
                                                                                    ConstraintLayout constraintLayout2 = (ConstraintLayout) view2.findViewById(R.id.matchFailedScreen);
                                                                                    if (constraintLayout2 != null) {
                                                                                        i = R.id.matchSuccessScreen;
                                                                                        ConstraintLayout constraintLayout3 = (ConstraintLayout) view2.findViewById(R.id.matchSuccessScreen);
                                                                                        if (constraintLayout3 != null) {
                                                                                            i = R.id.matchedPlayerList;
                                                                                            RecyclerView recyclerView = (RecyclerView) view2.findViewById(R.id.matchedPlayerList);
                                                                                            if (recyclerView != null) {
                                                                                                i = R.id.matchingStatus;
                                                                                                TextView textView6 = (TextView) view2.findViewById(R.id.matchingStatus);
                                                                                                if (textView6 != null) {
                                                                                                    i = R.id.matchingTimer;
                                                                                                    TextView textView7 = (TextView) view2.findViewById(R.id.matchingTimer);
                                                                                                    if (textView7 != null) {
                                                                                                        i = R.id.mpl_logo;
                                                                                                        ImageView imageView4 = (ImageView) view2.findViewById(R.id.mpl_logo);
                                                                                                        if (imageView4 != null) {
                                                                                                            i = R.id.multiPlayerDesc;
                                                                                                            LinearLayout linearLayout3 = (LinearLayout) view2.findViewById(R.id.multiPlayerDesc);
                                                                                                            if (linearLayout3 != null) {
                                                                                                                i = R.id.notFoundCrest;
                                                                                                                ImageView imageView5 = (ImageView) view2.findViewById(R.id.notFoundCrest);
                                                                                                                if (imageView5 != null) {
                                                                                                                    i = R.id.playerStatus;
                                                                                                                    TextView textView8 = (TextView) view2.findViewById(R.id.playerStatus);
                                                                                                                    if (textView8 != null) {
                                                                                                                        i = R.id.playerStatusDesc;
                                                                                                                        TextView textView9 = (TextView) view2.findViewById(R.id.playerStatusDesc);
                                                                                                                        if (textView9 != null) {
                                                                                                                            i = R.id.prize_break_up;
                                                                                                                            LinearLayout linearLayout4 = (LinearLayout) view2.findViewById(R.id.prize_break_up);
                                                                                                                            if (linearLayout4 != null) {
                                                                                                                                i = R.id.prize_break_up_list;
                                                                                                                                RecyclerView recyclerView2 = (RecyclerView) view2.findViewById(R.id.prize_break_up_list);
                                                                                                                                if (recyclerView2 != null) {
                                                                                                                                    i = R.id.progressContainer;
                                                                                                                                    RelativeLayout relativeLayout4 = (RelativeLayout) view2.findViewById(R.id.progressContainer);
                                                                                                                                    if (relativeLayout4 != null) {
                                                                                                                                        i = R.id.statusContainer;
                                                                                                                                        LinearLayout linearLayout5 = (LinearLayout) view2.findViewById(R.id.statusContainer);
                                                                                                                                        if (linearLayout5 != null) {
                                                                                                                                            i = R.id.webview_back;
                                                                                                                                            LinearLayout linearLayout6 = (LinearLayout) view2.findViewById(R.id.webview_back);
                                                                                                                                            if (linearLayout6 != null) {
                                                                                                                                                ActivityMplSmfxConnectorBinding activityMplSmfxConnectorBinding = new ActivityMplSmfxConnectorBinding((ConstraintLayout) view2, constraintLayout, textView, imageView, frameLayout, textView2, progressBar, button, imageView2, frameLayout2, button2, textView3, linearLayout, textView4, simpleDraweeView, textView5, relativeLayout, relativeLayout2, relativeLayout3, linearLayout2, imageView3, constraintLayout2, constraintLayout3, recyclerView, textView6, textView7, imageView4, linearLayout3, imageView5, textView8, textView9, linearLayout4, recyclerView2, relativeLayout4, linearLayout5, linearLayout6);
                                                                                                                                                return activityMplSmfxConnectorBinding;
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ActivityMplSmfxConnectorBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityMplSmfxConnectorBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_mpl_smfx_connector, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}

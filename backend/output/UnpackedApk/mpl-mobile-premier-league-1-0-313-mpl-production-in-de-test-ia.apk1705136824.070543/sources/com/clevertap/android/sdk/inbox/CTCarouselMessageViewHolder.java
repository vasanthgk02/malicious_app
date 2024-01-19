package com.clevertap.android.sdk.inbox;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.clevertap.android.sdk.R$drawable;
import com.clevertap.android.sdk.R$id;

public class CTCarouselMessageViewHolder extends CTInboxBaseMessageViewHolder {
    public ImageView carouselReadDot;
    public final RelativeLayout clickLayout;
    public final CTCarouselViewPager imageViewPager;
    public final TextView message;
    public final ImageView readDot;
    public final LinearLayout sliderDots;
    public final TextView timestamp;
    public final TextView title;

    public class CarouselPageChangeListener implements OnPageChangeListener {
        public final Context context;
        public final ImageView[] dots;
        public final CTInboxMessage inboxMessage;
        public final CTCarouselMessageViewHolder viewHolder;

        public CarouselPageChangeListener(CTCarouselMessageViewHolder cTCarouselMessageViewHolder, Context context2, CTCarouselMessageViewHolder cTCarouselMessageViewHolder2, ImageView[] imageViewArr, CTInboxMessage cTInboxMessage) {
            this.context = context2;
            this.viewHolder = cTCarouselMessageViewHolder2;
            this.dots = imageViewArr;
            this.inboxMessage = cTInboxMessage;
            imageViewArr[0].setImageDrawable(ResourcesCompat.getDrawable(context2.getResources(), R$drawable.ct_selected_dot, null));
        }

        public void onPageScrollStateChanged(int i) {
        }

        public void onPageScrolled(int i, float f2, int i2) {
        }

        public void onPageSelected(int i) {
            for (ImageView imageDrawable : this.dots) {
                imageDrawable.setImageDrawable(ResourcesCompat.getDrawable(this.context.getResources(), R$drawable.ct_unselected_dot, null));
            }
            this.dots[i].setImageDrawable(ResourcesCompat.getDrawable(this.context.getResources(), R$drawable.ct_selected_dot, null));
            this.viewHolder.title.setText(this.inboxMessage.inboxMessageContents.get(i).title);
            this.viewHolder.title.setTextColor(Color.parseColor(this.inboxMessage.inboxMessageContents.get(i).titleColor));
            this.viewHolder.message.setText(this.inboxMessage.inboxMessageContents.get(i).message);
            this.viewHolder.message.setTextColor(Color.parseColor(this.inboxMessage.inboxMessageContents.get(i).messageColor));
        }
    }

    public CTCarouselMessageViewHolder(View view) {
        super(view);
        this.imageViewPager = (CTCarouselViewPager) view.findViewById(R$id.image_carousel_viewpager);
        this.sliderDots = (LinearLayout) view.findViewById(R$id.sliderDots);
        this.title = (TextView) view.findViewById(R$id.messageTitle);
        this.message = (TextView) view.findViewById(R$id.messageText);
        this.timestamp = (TextView) view.findViewById(R$id.timestamp);
        this.readDot = (ImageView) view.findViewById(R$id.read_circle);
        this.clickLayout = (RelativeLayout) view.findViewById(R$id.body_linear_layout);
    }

    public void configureWithMessage(CTInboxMessage cTInboxMessage, CTInboxListViewFragment cTInboxListViewFragment, int i) {
        CTInboxMessage cTInboxMessage2 = cTInboxMessage;
        super.configureWithMessage(cTInboxMessage, cTInboxListViewFragment, i);
        CTInboxListViewFragment parent = getParent();
        Context applicationContext = cTInboxListViewFragment.getActivity().getApplicationContext();
        CTInboxMessageContent cTInboxMessageContent = cTInboxMessage2.inboxMessageContents.get(0);
        this.title.setVisibility(0);
        this.message.setVisibility(0);
        this.title.setText(cTInboxMessageContent.title);
        this.title.setTextColor(Color.parseColor(cTInboxMessageContent.titleColor));
        this.message.setText(cTInboxMessageContent.message);
        this.message.setTextColor(Color.parseColor(cTInboxMessageContent.messageColor));
        if (cTInboxMessage2.isRead) {
            this.readDot.setVisibility(8);
        } else {
            this.readDot.setVisibility(0);
        }
        this.timestamp.setVisibility(0);
        this.timestamp.setText(calculateDisplayTimestamp(cTInboxMessage2.date));
        this.timestamp.setTextColor(Color.parseColor(cTInboxMessageContent.titleColor));
        this.clickLayout.setBackgroundColor(Color.parseColor(cTInboxMessage2.bgColor));
        CTCarouselViewPagerAdapter cTCarouselViewPagerAdapter = new CTCarouselViewPagerAdapter(applicationContext, cTInboxListViewFragment, cTInboxMessage, (LayoutParams) this.imageViewPager.getLayoutParams(), i);
        this.imageViewPager.setAdapter(cTCarouselViewPagerAdapter);
        int size = cTInboxMessage2.inboxMessageContents.size();
        if (this.sliderDots.getChildCount() > 0) {
            this.sliderDots.removeAllViews();
        }
        ImageView[] imageViewArr = new ImageView[size];
        setDots(imageViewArr, size, applicationContext, this.sliderDots);
        imageViewArr[0].setImageDrawable(ResourcesCompat.getDrawable(applicationContext.getResources(), R$drawable.ct_selected_dot, null));
        CarouselPageChangeListener carouselPageChangeListener = new CarouselPageChangeListener(this, cTInboxListViewFragment.getActivity().getApplicationContext(), this, imageViewArr, cTInboxMessage);
        this.imageViewPager.addOnPageChangeListener(carouselPageChangeListener);
        RelativeLayout relativeLayout = this.clickLayout;
        CTInboxButtonClickListener cTInboxButtonClickListener = new CTInboxButtonClickListener(i, cTInboxMessage, (String) null, parent, (ViewPager) this.imageViewPager, true);
        relativeLayout.setOnClickListener(cTInboxButtonClickListener);
        final CTInboxListViewFragment cTInboxListViewFragment2 = cTInboxListViewFragment;
        final CTInboxMessage cTInboxMessage3 = cTInboxMessage;
        final CTInboxListViewFragment cTInboxListViewFragment3 = parent;
        final int i2 = i;
        AnonymousClass1 r0 = new Runnable() {
            public void run() {
                FragmentActivity activity = cTInboxListViewFragment2.getActivity();
                if (activity != null) {
                    activity.runOnUiThread(new Runnable() {
                        public void run() {
                            AnonymousClass1 r0 = AnonymousClass1.this;
                            if (cTInboxMessage3.type == CTInboxMessageType.CarouselImageMessage) {
                                if (CTCarouselMessageViewHolder.this.carouselReadDot.getVisibility() == 0) {
                                    AnonymousClass1 r02 = AnonymousClass1.this;
                                    CTInboxListViewFragment cTInboxListViewFragment = cTInboxListViewFragment3;
                                    if (cTInboxListViewFragment != null) {
                                        cTInboxListViewFragment.didShow(null, i2);
                                    }
                                }
                            } else if (CTCarouselMessageViewHolder.this.readDot.getVisibility() == 0) {
                                AnonymousClass1 r03 = AnonymousClass1.this;
                                CTInboxListViewFragment cTInboxListViewFragment2 = cTInboxListViewFragment3;
                                if (cTInboxListViewFragment2 != null) {
                                    cTInboxListViewFragment2.didShow(null, i2);
                                }
                            }
                        }
                    });
                }
            }
        };
        new Handler().postDelayed(r0, 2000);
    }
}

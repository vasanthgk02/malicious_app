package com.clevertap.android.sdk.inbox;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import androidx.viewpager.widget.PagerAdapter;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.R$id;
import com.clevertap.android.sdk.R$layout;
import com.clevertap.android.sdk.Utils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class CTCarouselViewPagerAdapter extends PagerAdapter {
    public final ArrayList<String> carouselImages;
    public final Context context;
    public final CTInboxMessage inboxMessage;
    public LayoutInflater layoutInflater;
    public final LayoutParams layoutParams;
    public final WeakReference<CTInboxListViewFragment> parentWeakReference;
    public final int row;
    public View view;

    public CTCarouselViewPagerAdapter(Context context2, CTInboxListViewFragment cTInboxListViewFragment, CTInboxMessage cTInboxMessage, LayoutParams layoutParams2, int i) {
        this.context = context2;
        this.parentWeakReference = new WeakReference<>(cTInboxListViewFragment);
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<CTInboxMessageContent> it = cTInboxMessage.inboxMessageContents.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().media);
        }
        this.carouselImages = arrayList;
        this.layoutParams = layoutParams2;
        this.inboxMessage = cTInboxMessage;
        this.row = i;
    }

    public void addImageAndSetClick(ImageView imageView, View view2, final int i, ViewGroup viewGroup) {
        imageView.setVisibility(0);
        try {
            Glide.with(imageView.getContext()).load(this.carouselImages.get(i)).apply(((RequestOptions) new RequestOptions().placeholder(Utils.getThumbnailImage(this.context, "ct_image"))).error(Utils.getThumbnailImage(this.context, "ct_image"))).into(imageView);
        } catch (NoSuchMethodError unused) {
            Logger.d("CleverTap SDK requires Glide v4.9.0 or above. Please refer CleverTap Documentation for more info");
            Glide.with(imageView.getContext()).load(this.carouselImages.get(i)).into(imageView);
        }
        viewGroup.addView(view2, this.layoutParams);
        view2.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                CTInboxListViewFragment cTInboxListViewFragment = (CTInboxListViewFragment) CTCarouselViewPagerAdapter.this.parentWeakReference.get();
                if (cTInboxListViewFragment != null) {
                    cTInboxListViewFragment.handleViewPagerClick(CTCarouselViewPagerAdapter.this.row, i, true);
                }
            }
        });
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    public int getCount() {
        return this.carouselImages.size();
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater2 = (LayoutInflater) this.context.getSystemService("layout_inflater");
        this.layoutInflater = layoutInflater2;
        this.view = layoutInflater2.inflate(R$layout.inbox_carousel_image_layout, viewGroup, false);
        try {
            if (this.inboxMessage.orientation.equalsIgnoreCase("l")) {
                addImageAndSetClick((ImageView) this.view.findViewById(R$id.imageView), this.view, i, viewGroup);
            } else if (this.inboxMessage.orientation.equalsIgnoreCase("p")) {
                addImageAndSetClick((ImageView) this.view.findViewById(R$id.squareImageView), this.view, i, viewGroup);
            }
        } catch (NoClassDefFoundError unused) {
            Logger.d("CleverTap SDK requires Glide dependency. Please refer CleverTap Documentation for more info");
        }
        return this.view;
    }

    public boolean isViewFromObject(View view2, Object obj) {
        return view2 == obj;
    }
}

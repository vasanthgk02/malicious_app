package com.freshchat.consumer.sdk.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.freshchat.consumer.sdk.FreshchatImageLoader;
import com.freshchat.consumer.sdk.FreshchatImageLoaderRequest;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.beans.fragment.CarouselCardDefaultFragment;
import com.freshchat.consumer.sdk.j.af;
import com.freshchat.consumer.sdk.j.aq;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.k.i;

public class CarouselCardView extends CardView {
    public a lR;
    public ImageView nF;
    public ImageView nH;
    public TextView nI;
    public TextView nJ;
    public LinearLayout nK;
    public Button nL;
    public Button nM;
    public View nN;
    public i nO;

    public interface a {
        void a(CarouselCardDefaultFragment carouselCardDefaultFragment);
    }

    public CarouselCardView(Context context) {
        super(context);
        hl();
    }

    public CarouselCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        hl();
    }

    public CarouselCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        hl();
    }

    /* access modifiers changed from: private */
    public void hm() {
        String ho = this.nO.ho();
        int j = aq.j(getContext(), R.attr.freshchatCarouselCardPlaceholderImage);
        int j2 = aq.j(getContext(), R.attr.freshchatCarouselCardErrorImage);
        if (as.a(ho)) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.freshchat_carousel_card_default_dimension);
            FreshchatImageLoaderRequest dM = new com.freshchat.consumer.sdk.FreshchatImageLoaderRequest.a(ho).a(this.nO.I(dimensionPixelSize), this.nO.J(dimensionPixelSize)).G(j).H(j2).dM();
            FreshchatImageLoader eK = af.eK();
            if (eK != null) {
                eK.load(dM, this.nH);
            }
        } else {
            this.nH.setImageResource(j2);
        }
        if (as.isEmpty(this.nO.getTitle())) {
            com.freshchat.consumer.sdk.b.i.c(this.nI);
        } else {
            com.freshchat.consumer.sdk.b.i.b(this.nI);
            this.nI.setText(this.nO.getTitle());
        }
        if (as.isEmpty(this.nO.getDescription())) {
            com.freshchat.consumer.sdk.b.i.c(this.nJ);
        } else {
            com.freshchat.consumer.sdk.b.i.b(this.nJ);
            this.nJ.setText(this.nO.getDescription());
        }
        com.freshchat.consumer.sdk.k.i.a hp = this.nO.hp();
        if (hp == com.freshchat.consumer.sdk.k.i.a.PRE_SELECTED_CARD) {
            com.freshchat.consumer.sdk.b.i.b(this.nN);
            com.freshchat.consumer.sdk.b.i.c(this.nK);
            return;
        }
        com.freshchat.consumer.sdk.b.i.b(this.nK);
        com.freshchat.consumer.sdk.b.i.c(this.nN);
        String string = getContext().getString(R.string.freshchat_carousel_card_default_callback_btn_text);
        String string2 = getContext().getString(R.string.freshchat_carousel_card_default_view_btn_text);
        if (hp == com.freshchat.consumer.sdk.k.i.a.CARD_WITH_CALLBACK_AND_VIEW_OPTION) {
            com.freshchat.consumer.sdk.b.i.b(this.nM);
            this.nM.setText(this.nO.bm(string2));
            this.nK.setOrientation(this.nO.x(string, string2) ^ true ? 1 : 0);
            this.nM.setOnClickListener(new b(this));
        } else {
            com.freshchat.consumer.sdk.b.i.c(this.nM);
        }
        this.nL.setText(this.nO.bl(string));
        this.nL.setOnClickListener(new c(this));
    }

    public void hl() {
        this.nO = new i(getContext());
        addView(LayoutInflater.from(getContext()).inflate(R.layout.freshchat_carousel_card_default_view, this, false));
        this.nH = (ImageView) findViewById(R.id.freshchat_carousel_card_hero_image);
        this.nI = (TextView) findViewById(R.id.freshchat_carousel_card_title);
        this.nJ = (TextView) findViewById(R.id.freshchat_carousel_card_description);
        this.nK = (LinearLayout) findViewById(R.id.freshchat_carousel_card_button_container);
        this.nL = (Button) findViewById(R.id.freshchat_carousel_card_callback_btn);
        this.nM = (Button) findViewById(R.id.freshchat_carousel_card_view_btn);
        this.nN = findViewById(R.id.freshchat_carousel_card_selection_indication_container);
        this.nF = (ImageView) findViewById(R.id.freshchat_carousel_card_message_upload_status);
    }

    public void setData(CarouselCardDefaultFragment carouselCardDefaultFragment) {
        this.nO.setData(carouselCardDefaultFragment);
        post(new a(this));
    }

    public void setListener(a aVar) {
        this.lR = aVar;
    }

    public void setUploadedStateDrawable(Drawable drawable) {
        if (drawable != null) {
            ImageView imageView = this.nF;
            if (imageView != null) {
                imageView.setImageDrawable(drawable);
            }
        }
    }
}

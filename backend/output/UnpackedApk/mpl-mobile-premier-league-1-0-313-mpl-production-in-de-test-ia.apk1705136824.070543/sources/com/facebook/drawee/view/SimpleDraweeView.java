package com.facebook.drawee.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.net.Uri;
import android.util.AttributeSet;
import co.hyperverge.hypersnapsdk.c.k;
import com.facebook.common.internal.Supplier;
import com.facebook.common.util.UriUtil;
import com.facebook.drawee.R$styleable;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.systrace.FrescoSystrace;

public class SimpleDraweeView extends GenericDraweeView {
    public static Supplier<? extends AbstractDraweeControllerBuilder> sDraweecontrollerbuildersupplier;
    public AbstractDraweeControllerBuilder mControllerBuilder;

    public SimpleDraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public AbstractDraweeControllerBuilder getControllerBuilder() {
        return this.mControllerBuilder;
    }

    public final void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes;
        try {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("SimpleDraweeView#init");
            }
            if (isInEditMode()) {
                getTopLevelDrawable().setVisible(true, false);
                getTopLevelDrawable().invalidateSelf();
            } else {
                k.checkNotNull(sDraweecontrollerbuildersupplier, (Object) "SimpleDraweeView was not initialized!");
                this.mControllerBuilder = (AbstractDraweeControllerBuilder) sDraweecontrollerbuildersupplier.get();
            }
            if (attributeSet != null) {
                obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SimpleDraweeView);
                if (obtainStyledAttributes.hasValue(R$styleable.SimpleDraweeView_actualImageUri)) {
                    setImageURI(Uri.parse(obtainStyledAttributes.getString(R$styleable.SimpleDraweeView_actualImageUri)), null);
                } else if (obtainStyledAttributes.hasValue(R$styleable.SimpleDraweeView_actualImageResource)) {
                    int resourceId = obtainStyledAttributes.getResourceId(R$styleable.SimpleDraweeView_actualImageResource, -1);
                    if (resourceId != -1) {
                        if (isInEditMode()) {
                            setImageResource(resourceId);
                        } else {
                            setActualImageResource(resourceId);
                        }
                    }
                }
                obtainStyledAttributes.recycle();
            }
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        } catch (Throwable th) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
            throw th;
        }
    }

    public void setActualImageResource(int i) {
        setImageURI(UriUtil.getUriForResourceId(i), null);
    }

    public void setImageRequest(ImageRequest imageRequest) {
        AbstractDraweeControllerBuilder abstractDraweeControllerBuilder = this.mControllerBuilder;
        abstractDraweeControllerBuilder.mImageRequest = imageRequest;
        abstractDraweeControllerBuilder.mOldController = getController();
        setController(abstractDraweeControllerBuilder.build());
    }

    public void setImageResource(int i) {
        super.setImageResource(i);
    }

    public void setImageURI(Uri uri) {
        setImageURI(uri, null);
    }

    public void setImageURI(Uri uri, Object obj) {
        AbstractDraweeControllerBuilder abstractDraweeControllerBuilder = this.mControllerBuilder;
        abstractDraweeControllerBuilder.mCallerContext = obj;
        AbstractDraweeControllerBuilder abstractDraweeControllerBuilder2 = (AbstractDraweeControllerBuilder) abstractDraweeControllerBuilder.setUri(uri);
        abstractDraweeControllerBuilder2.mOldController = getController();
        setController(abstractDraweeControllerBuilder2.build());
    }

    public SimpleDraweeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    public void setImageURI(String str) {
        setImageURI(str != null ? Uri.parse(str) : null, null);
    }
}

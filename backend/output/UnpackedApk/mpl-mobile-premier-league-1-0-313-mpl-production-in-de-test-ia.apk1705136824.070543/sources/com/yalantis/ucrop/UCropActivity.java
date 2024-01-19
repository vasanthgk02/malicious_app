package com.yalantis.ucrop;

import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import com.inca.security.Proxy.iIiIiIiIii;
import com.twitter.sdk.android.tweetui.TweetUtils;
import com.yalantis.ucrop.callback.BitmapCropCallback;
import com.yalantis.ucrop.model.CropParameters;
import com.yalantis.ucrop.model.ImageState;
import com.yalantis.ucrop.task.BitmapCropTask;
import com.yalantis.ucrop.view.GestureCropImageView;
import com.yalantis.ucrop.view.OverlayView;
import com.yalantis.ucrop.view.TransformImageView.TransformImageListener;
import com.yalantis.ucrop.view.UCropView;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class UCropActivity extends AppCompatActivity {
    public static final CompressFormat DEFAULT_COMPRESS_FORMAT = CompressFormat.JPEG;
    public int mActiveWidgetColor;
    public int[] mAllowedGestures = {1, 2, 3};
    public View mBlockingView;
    public CompressFormat mCompressFormat = DEFAULT_COMPRESS_FORMAT;
    public int mCompressQuality = 90;
    public List<ViewGroup> mCropAspectRatioViews = new ArrayList();
    public GestureCropImageView mGestureCropImageView;
    public TransformImageListener mImageListener = new TransformImageListener() {
        public void onRotate(float f2) {
            TextView textView = UCropActivity.this.mTextViewRotateAngle;
            if (textView != null) {
                textView.setText(String.format(Locale.getDefault(), "%.1f°", new Object[]{Float.valueOf(f2)}));
            }
        }

        public void onScale(float f2) {
            TextView textView = UCropActivity.this.mTextViewScalePercent;
            if (textView != null) {
                textView.setText(String.format(Locale.getDefault(), "%d%%", new Object[]{Integer.valueOf((int) (f2 * 100.0f))}));
            }
        }
    };
    public ViewGroup mLayoutAspectRatio;
    public ViewGroup mLayoutRotate;
    public ViewGroup mLayoutScale;
    public int mLogoColor;
    public OverlayView mOverlayView;
    public int mRootViewBackgroundColor;
    public boolean mShowBottomControls;
    public boolean mShowLoader = true;
    public final OnClickListener mStateClickListener = new OnClickListener() {
        public void onClick(View view) {
            if (!view.isSelected()) {
                UCropActivity.this.setWidgetState(view.getId());
            }
        }
    };
    public int mStatusBarColor;
    public TextView mTextViewRotateAngle;
    public TextView mTextViewScalePercent;
    public int mToolbarCancelDrawable;
    public int mToolbarColor;
    public int mToolbarCropDrawable;
    public String mToolbarTitle;
    public int mToolbarWidgetColor;
    public UCropView mUCropView;
    public ViewGroup mWrapperStateAspectRatio;
    public ViewGroup mWrapperStateRotate;
    public ViewGroup mWrapperStateScale;

    public void onCreate(Bundle bundle) {
        iIiIiIiIii.IiiiIiiiII(this, 963301868, bundle);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R$menu.ucrop_menu_activity, menu);
        MenuItem findItem = menu.findItem(R$id.menu_loader);
        Drawable icon = findItem.getIcon();
        if (icon != null) {
            try {
                icon.mutate();
                icon.setColorFilter(this.mToolbarWidgetColor, Mode.SRC_ATOP);
                findItem.setIcon(icon);
            } catch (IllegalStateException e2) {
                String.format("%s - %s", new Object[]{e2.getMessage(), getString(R$string.ucrop_mutate_exception_hint)});
            }
            ((Animatable) findItem.getIcon()).start();
        }
        MenuItem findItem2 = menu.findItem(R$id.menu_crop);
        Drawable drawable = ContextCompat.getDrawable(this, this.mToolbarCropDrawable);
        if (drawable != null) {
            drawable.mutate();
            drawable.setColorFilter(this.mToolbarWidgetColor, Mode.SRC_ATOP);
            findItem2.setIcon(drawable);
        }
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R$id.menu_crop) {
            this.mBlockingView.setClickable(true);
            this.mShowLoader = true;
            supportInvalidateOptionsMenu();
            GestureCropImageView gestureCropImageView = this.mGestureCropImageView;
            CompressFormat compressFormat = this.mCompressFormat;
            int i = this.mCompressQuality;
            AnonymousClass8 r9 = new BitmapCropCallback() {
            };
            gestureCropImageView.cancelAllAnimations();
            gestureCropImageView.setImageToWrapCropBounds(false);
            ImageState imageState = new ImageState(gestureCropImageView.mCropRect, TweetUtils.trapToRect(gestureCropImageView.mCurrentImageCorners), gestureCropImageView.getCurrentScale(), gestureCropImageView.getCurrentAngle());
            CropParameters cropParameters = new CropParameters(gestureCropImageView.mMaxResultImageSizeX, gestureCropImageView.mMaxResultImageSizeY, compressFormat, i, gestureCropImageView.getImageInputPath(), gestureCropImageView.getImageOutputPath(), gestureCropImageView.getExifInfo());
            new BitmapCropTask(gestureCropImageView.getViewBitmap(), imageState, cropParameters, r9).execute(new Void[0]);
        } else if (menuItem.getItemId() == 16908332) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R$id.menu_crop).setVisible(!this.mShowLoader);
        menu.findItem(R$id.menu_loader).setVisible(this.mShowLoader);
        return super.onPrepareOptionsMenu(menu);
    }

    public void onStop() {
        iIiIiIiIii.IiiiIiiiII(this, -2098579594, new Object[0]);
    }

    public final void setAllowedGestures(int i) {
        GestureCropImageView gestureCropImageView = this.mGestureCropImageView;
        int[] iArr = this.mAllowedGestures;
        boolean z = false;
        gestureCropImageView.setScaleEnabled(iArr[i] == 3 || iArr[i] == 1);
        GestureCropImageView gestureCropImageView2 = this.mGestureCropImageView;
        int[] iArr2 = this.mAllowedGestures;
        if (iArr2[i] == 3 || iArr2[i] == 2) {
            z = true;
        }
        gestureCropImageView2.setRotateEnabled(z);
    }

    public void setResultError(Throwable th) {
        setResult(96, new Intent().putExtra("com.yalantis.ucrop.Error", th));
    }

    public final void setWidgetState(int i) {
        if (this.mShowBottomControls) {
            this.mWrapperStateAspectRatio.setSelected(i == R$id.state_aspect_ratio);
            this.mWrapperStateRotate.setSelected(i == R$id.state_rotate);
            this.mWrapperStateScale.setSelected(i == R$id.state_scale);
            int i2 = 8;
            this.mLayoutAspectRatio.setVisibility(i == R$id.state_aspect_ratio ? 0 : 8);
            this.mLayoutRotate.setVisibility(i == R$id.state_rotate ? 0 : 8);
            ViewGroup viewGroup = this.mLayoutScale;
            if (i == R$id.state_scale) {
                i2 = 0;
            }
            viewGroup.setVisibility(i2);
            if (i == R$id.state_scale) {
                setAllowedGestures(0);
            } else if (i == R$id.state_rotate) {
                setAllowedGestures(1);
            } else {
                setAllowedGestures(2);
            }
        }
    }
}

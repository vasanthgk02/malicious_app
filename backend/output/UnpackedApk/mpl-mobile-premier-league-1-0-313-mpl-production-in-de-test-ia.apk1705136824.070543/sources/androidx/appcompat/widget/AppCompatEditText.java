package androidx.appcompat.widget;

import a.a.a.a.d.b;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.util.AttributeSet;
import android.view.ActionMode.Callback;
import android.view.DragEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import androidx.appcompat.R$attr;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.ContentInfoCompat.Builder;
import androidx.core.view.OnReceiveContentViewBehavior;
import androidx.core.view.ViewCompat;
import androidx.core.view.inputmethod.EditorInfoCompat;
import androidx.core.view.inputmethod.InputConnectionCompat$1;
import androidx.core.view.inputmethod.InputConnectionCompat$2;
import androidx.core.widget.CompoundButtonCompat;
import androidx.core.widget.TextViewOnReceiveContentListener;

public class AppCompatEditText extends EditText implements OnReceiveContentViewBehavior {
    public final AppCompatBackgroundHelper mBackgroundTintHelper;
    public final TextViewOnReceiveContentListener mDefaultOnReceiveContentListener;
    public final AppCompatTextClassifierHelper mTextClassifierHelper;
    public final AppCompatTextHelper mTextHelper;

    public AppCompatEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.editTextStyle);
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.applySupportBackgroundTint();
        }
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.applyCompoundDrawablesTints();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.getSupportBackgroundTintList();
        }
        return null;
    }

    public Mode getSupportBackgroundTintMode() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.getSupportBackgroundTintMode();
        }
        return null;
    }

    public TextClassifier getTextClassifier() {
        if (VERSION.SDK_INT < 28) {
            AppCompatTextClassifierHelper appCompatTextClassifierHelper = this.mTextClassifierHelper;
            if (appCompatTextClassifierHelper != null) {
                return appCompatTextClassifierHelper.getTextClassifier();
            }
        }
        return super.getTextClassifier();
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        String[] strArr;
        InputConnection inputConnectionCompat$2;
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.mTextHelper.populateSurroundingTextIfNeeded(this, onCreateInputConnection, editorInfo);
        b.onCreateInputConnection(onCreateInputConnection, editorInfo, this);
        String[] onReceiveContentMimeTypes = ViewCompat.getOnReceiveContentMimeTypes(this);
        if (onCreateInputConnection == null || onReceiveContentMimeTypes == null) {
            return onCreateInputConnection;
        }
        if (VERSION.SDK_INT >= 25) {
            editorInfo.contentMimeTypes = onReceiveContentMimeTypes;
        } else {
            if (editorInfo.extras == null) {
                editorInfo.extras = new Bundle();
            }
            editorInfo.extras.putStringArray("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES", onReceiveContentMimeTypes);
            editorInfo.extras.putStringArray("android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES", onReceiveContentMimeTypes);
        }
        AppCompatReceiveContentHelper$1 appCompatReceiveContentHelper$1 = new AppCompatReceiveContentHelper$1(this);
        if (editorInfo != null) {
            int i = VERSION.SDK_INT;
            if (i >= 25) {
                inputConnectionCompat$2 = new InputConnectionCompat$1(onCreateInputConnection, false, appCompatReceiveContentHelper$1);
            } else {
                if (i >= 25) {
                    strArr = editorInfo.contentMimeTypes;
                    if (strArr == null) {
                        strArr = EditorInfoCompat.EMPTY_STRING_ARRAY;
                    }
                } else {
                    Bundle bundle = editorInfo.extras;
                    if (bundle == null) {
                        strArr = EditorInfoCompat.EMPTY_STRING_ARRAY;
                    } else {
                        String[] stringArray = bundle.getStringArray("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES");
                        strArr = stringArray == null ? editorInfo.extras.getStringArray("android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES") : stringArray;
                        if (strArr == null) {
                            strArr = EditorInfoCompat.EMPTY_STRING_ARRAY;
                        }
                    }
                }
                if (strArr.length == 0) {
                    return onCreateInputConnection;
                }
                inputConnectionCompat$2 = new InputConnectionCompat$2(onCreateInputConnection, false, appCompatReceiveContentHelper$1);
            }
            return inputConnectionCompat$2;
        }
        throw new IllegalArgumentException("editorInfo must be non-null");
    }

    /* JADX INFO: finally extract failed */
    public boolean onDragEvent(DragEvent dragEvent) {
        Activity activity;
        boolean z = false;
        if (VERSION.SDK_INT >= 24 && dragEvent.getLocalState() == null && ViewCompat.getOnReceiveContentMimeTypes(this) != null) {
            Context context = getContext();
            while (true) {
                if (!(context instanceof ContextWrapper)) {
                    activity = null;
                    break;
                } else if (context instanceof Activity) {
                    activity = (Activity) context;
                    break;
                } else {
                    context = ((ContextWrapper) context).getBaseContext();
                }
            }
            if (activity == null) {
                "Can't handle drop: no activity: view=" + this;
            } else if (dragEvent.getAction() != 1 && dragEvent.getAction() == 3) {
                activity.requestDragAndDropPermissions(dragEvent);
                int offsetForPosition = getOffsetForPosition(dragEvent.getX(), dragEvent.getY());
                beginBatchEdit();
                try {
                    Selection.setSelection((Spannable) getText(), offsetForPosition);
                    ViewCompat.performReceiveContent(this, new ContentInfoCompat(new Builder(dragEvent.getClipData(), 3)));
                    endBatchEdit();
                    z = true;
                } catch (Throwable th) {
                    endBatchEdit();
                    throw th;
                }
            }
        }
        if (z) {
            return true;
        }
        return super.onDragEvent(dragEvent);
    }

    public ContentInfoCompat onReceiveContent(ContentInfoCompat contentInfoCompat) {
        return this.mDefaultOnReceiveContentListener.onReceiveContent(this, contentInfoCompat);
    }

    public boolean onTextContextMenuItem(int i) {
        ClipData clipData;
        int i2 = 0;
        if ((i == 16908322 || i == 16908337) && ViewCompat.getOnReceiveContentMimeTypes(this) != null) {
            ClipboardManager clipboardManager = (ClipboardManager) getContext().getSystemService("clipboard");
            if (clipboardManager == null) {
                clipData = null;
            } else {
                clipData = clipboardManager.getPrimaryClip();
            }
            if (clipData != null && clipData.getItemCount() > 0) {
                Builder builder = new Builder(clipData, 1);
                if (i != 16908322) {
                    i2 = 1;
                }
                builder.mFlags = i2;
                ViewCompat.performReceiveContent(this, new ContentInfoCompat(builder));
            }
            i2 = 1;
        }
        if (i2 != 0) {
            return true;
        }
        return super.onTextContextMenuItem(i);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.onSetBackgroundDrawable();
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.onSetBackgroundResource(i);
        }
    }

    public void setCustomSelectionActionModeCallback(Callback callback) {
        super.setCustomSelectionActionModeCallback(CompoundButtonCompat.wrapCustomSelectionActionModeCallback(this, callback));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.setSupportBackgroundTintList(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.setSupportBackgroundTintMode(mode);
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.onSetTextAppearance(context, i);
        }
    }

    public void setTextClassifier(TextClassifier textClassifier) {
        if (VERSION.SDK_INT < 28) {
            AppCompatTextClassifierHelper appCompatTextClassifierHelper = this.mTextClassifierHelper;
            if (appCompatTextClassifierHelper != null) {
                appCompatTextClassifierHelper.mTextClassifier = textClassifier;
                return;
            }
        }
        super.setTextClassifier(textClassifier);
    }

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public AppCompatEditText(Context context, AttributeSet attributeSet, int i) {
        // TintContextWrapper.wrap(context);
        super(context, attributeSet, i);
        ThemeUtils.checkAppCompatTheme(this, getContext());
        AppCompatBackgroundHelper appCompatBackgroundHelper = new AppCompatBackgroundHelper(this);
        this.mBackgroundTintHelper = appCompatBackgroundHelper;
        appCompatBackgroundHelper.loadFromAttributes(attributeSet, i);
        AppCompatTextHelper appCompatTextHelper = new AppCompatTextHelper(this);
        this.mTextHelper = appCompatTextHelper;
        appCompatTextHelper.loadFromAttributes(attributeSet, i);
        this.mTextHelper.applyCompoundDrawablesTints();
        this.mTextClassifierHelper = new AppCompatTextClassifierHelper(this);
        this.mDefaultOnReceiveContentListener = new TextViewOnReceiveContentListener();
    }

    public Editable getText() {
        if (VERSION.SDK_INT >= 28) {
            return super.getText();
        }
        return super.getEditableText();
    }
}

package androidx.appcompat.widget;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;

public final class AppCompatTextClassifierHelper {
    public TextClassifier mTextClassifier;
    public TextView mTextView;

    public AppCompatTextClassifierHelper(TextView textView) {
        this.mTextView = textView;
    }

    public TextClassifier getTextClassifier() {
        TextClassifier textClassifier = this.mTextClassifier;
        if (textClassifier == null) {
            TextClassificationManager textClassificationManager = (TextClassificationManager) this.mTextView.getContext().getSystemService(TextClassificationManager.class);
            if (textClassificationManager != null) {
                return textClassificationManager.getTextClassifier();
            }
            textClassifier = TextClassifier.NO_OP;
        }
        return textClassifier;
    }
}

package com.crimzoncode.tqcontests.fragment;

import com.crimzoncode.tqcontests.R;
import com.crimzoncode.tqcontests.fragment.QuizViewFragment.OnListFragmentInteractionListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 16})
/* compiled from: QuizViewFragment.kt */
public final class QuizViewFragment$updateUI$jsInteractionListener$1$imageLoadingProgress$1 implements Runnable {
    public final /* synthetic */ int $loadedImages;
    public final /* synthetic */ int $totalImages;
    public final /* synthetic */ QuizViewFragment$updateUI$jsInteractionListener$1 this$0;

    public QuizViewFragment$updateUI$jsInteractionListener$1$imageLoadingProgress$1(QuizViewFragment$updateUI$jsInteractionListener$1 quizViewFragment$updateUI$jsInteractionListener$1, int i, int i2) {
        this.this$0 = quizViewFragment$updateUI$jsInteractionListener$1;
        this.$loadedImages = i;
        this.$totalImages = i2;
    }

    public final void run() {
        OnListFragmentInteractionListener access$getListener$p = this.this$0.this$0.listener;
        if (access$getListener$p != null) {
            String string = this.this$0.this$0.getString(R.string.label_loading_images_progress, Integer.valueOf(this.$loadedImages), Integer.valueOf(this.$totalImages));
            Intrinsics.checkExpressionValueIsNotNull(string, "getString(R.string.label…oadedImages, totalImages)");
            access$getListener$p.showLoaderIcon(string);
        }
    }
}

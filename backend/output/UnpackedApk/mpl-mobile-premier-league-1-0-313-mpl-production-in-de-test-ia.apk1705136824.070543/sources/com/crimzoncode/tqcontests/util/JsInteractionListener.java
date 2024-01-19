package com.crimzoncode.tqcontests.util;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0018\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H&J\b\u0010\r\u001a\u00020\u0003H&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0007H&¨\u0006\u0010"}, d2 = {"Lcom/crimzoncode/tqcontests/util/JsInteractionListener;", "", "allImagesLoaded", "", "documentLoaded", "imageFailedToLoad", "loadedImages", "", "totalImages", "imageLoadingProgress", "optionSelected", "questionIdx", "optionIdx", "quizLoadCompleted", "updateNavButtons", "currentQuestionIdx", "contests_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: JsInteractionListener.kt */
public interface JsInteractionListener {
    void allImagesLoaded();

    void documentLoaded();

    void imageFailedToLoad(int i, int i2);

    void imageLoadingProgress(int i, int i2);

    void optionSelected(int i, int i2);

    void quizLoadCompleted();

    void updateNavButtons(int i);
}

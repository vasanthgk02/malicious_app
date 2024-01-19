package com.crimzoncode.tqcontests.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.crimzoncode.tqcontests.R;
import com.crimzoncode.tqcontests.data.model.QuizAttempt;

public abstract class FragmentQuizQuestionBinding extends ViewDataBinding {
    public final View divider;
    public final TextView labelQuestion;
    public final TextView labelQuestionTimer;
    public QuizAttempt mQuizAttempt;
    public final TextView questionCount;
    public final AppCompatTextView questionTimer;
    public final WebView questionWebview;

    public FragmentQuizQuestionBinding(DataBindingComponent dataBindingComponent, View view, int i, View view2, TextView textView, TextView textView2, TextView textView3, AppCompatTextView appCompatTextView, WebView webView) {
        super(dataBindingComponent, view, i);
        this.divider = view2;
        this.labelQuestion = textView;
        this.labelQuestionTimer = textView2;
        this.questionCount = textView3;
        this.questionTimer = appCompatTextView;
        this.questionWebview = webView;
    }

    public static FragmentQuizQuestionBinding bind(View view) {
        return bind(view, DataBindingUtil.sDefaultComponent);
    }

    public static FragmentQuizQuestionBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.sDefaultComponent);
    }

    public QuizAttempt getQuizAttempt() {
        return this.mQuizAttempt;
    }

    public abstract void setQuizAttempt(QuizAttempt quizAttempt);

    public static FragmentQuizQuestionBinding bind(View view, DataBindingComponent dataBindingComponent) {
        return (FragmentQuizQuestionBinding) bind(dataBindingComponent, view, R.layout.fragment_quiz_question);
    }

    public static FragmentQuizQuestionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.sDefaultComponent);
    }

    public static FragmentQuizQuestionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, DataBindingComponent dataBindingComponent) {
        return (FragmentQuizQuestionBinding) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_quiz_question, viewGroup, z, dataBindingComponent);
    }

    public static FragmentQuizQuestionBinding inflate(LayoutInflater layoutInflater, DataBindingComponent dataBindingComponent) {
        return (FragmentQuizQuestionBinding) DataBindingUtil.inflate(layoutInflater, R.layout.fragment_quiz_question, null, false, dataBindingComponent);
    }
}

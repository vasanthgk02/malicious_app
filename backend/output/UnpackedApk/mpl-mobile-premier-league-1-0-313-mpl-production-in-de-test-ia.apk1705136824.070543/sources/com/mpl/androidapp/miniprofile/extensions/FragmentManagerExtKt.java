package com.mpl.androidapp.miniprofile.extensions;

import android.app.Activity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentManager.BackStackEntry;
import androidx.fragment.app.FragmentTransaction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u001a\"\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u001a\f\u0010\t\u001a\u0004\u0018\u00010\u0004*\u00020\u0002\u001a)\u0010\n\u001a\u00020\u0001*\u00020\u000b2\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0002\b\u000fH\bø\u0001\u0000\u001a)\u0010\u0010\u001a\u00020\u0001*\u00020\u000b2\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000fH\bø\u0001\u0000\u001a)\u0010\u0011\u001a\u00020\u0001*\u00020\u000b2\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000fH\bø\u0001\u0000\u001a\n\u0010\u0012\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0013\u001a\u00020\u0001*\u00020\u0002\u001a\u001a\u0010\u0014\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u001a\"\u0010\u0014\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u001a*\u0010\u0014\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0016"}, d2 = {"addFragment", "", "Landroidx/appcompat/app/AppCompatActivity;", "fragment", "Landroidx/fragment/app/Fragment;", "frameId", "", "addToStack", "", "getCurrentFragment", "inTransaction", "Landroidx/fragment/app/FragmentManager;", "func", "Lkotlin/Function1;", "Landroidx/fragment/app/FragmentTransaction;", "Lkotlin/ExtensionFunctionType;", "inTransactionCommit", "inTransactionCommitAllowingStateLoss", "popBackStack", "popBackStackInclusive", "replaceFragment", "clearBackStack", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: FragmentManagerExt.kt */
public final class FragmentManagerExtKt {
    public static final void addFragment(AppCompatActivity appCompatActivity, Fragment fragment, int i) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "<this>");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        KeyboardExtKt.hideSoftKeyboard((Activity) appCompatActivity);
        FragmentManager supportFragmentManager = appCompatActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction()");
        FragmentTransaction add = beginTransaction.add(i, fragment, fragment.getClass().getSimpleName());
        Intrinsics.checkNotNullExpressionValue(add, "add(frameId, fragment, f…ent.javaClass.simpleName)");
        add.commit();
    }

    public static final Fragment getCurrentFragment(AppCompatActivity appCompatActivity) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "<this>");
        FragmentManager supportFragmentManager = appCompatActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        return supportFragmentManager.findFragmentByTag(supportFragmentManager.getBackStackEntryCount() > 0 ? String.valueOf(supportFragmentManager.getBackStackEntryAt(supportFragmentManager.getBackStackEntryCount() - 1).getName()) : "");
    }

    public static final void inTransaction(FragmentManager fragmentManager, Function1<? super FragmentTransaction, ? extends FragmentTransaction> function1) {
        Intrinsics.checkNotNullParameter(fragmentManager, "<this>");
        Intrinsics.checkNotNullParameter(function1, "func");
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction()");
        ((FragmentTransaction) function1.invoke(beginTransaction)).commit();
    }

    public static final void inTransactionCommit(FragmentManager fragmentManager, Function1<? super FragmentTransaction, Unit> function1) {
        Intrinsics.checkNotNullParameter(fragmentManager, "<this>");
        Intrinsics.checkNotNullParameter(function1, "func");
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction()");
        function1.invoke(beginTransaction);
        beginTransaction.commit();
    }

    public static final void inTransactionCommitAllowingStateLoss(FragmentManager fragmentManager, Function1<? super FragmentTransaction, Unit> function1) {
        Intrinsics.checkNotNullParameter(fragmentManager, "<this>");
        Intrinsics.checkNotNullParameter(function1, "func");
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction()");
        function1.invoke(beginTransaction);
        beginTransaction.commitAllowingStateLoss();
    }

    public static final void popBackStack(AppCompatActivity appCompatActivity) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "<this>");
        KeyboardExtKt.hideSoftKeyboard((Activity) appCompatActivity);
        appCompatActivity.getSupportFragmentManager().popBackStack();
    }

    public static final void popBackStackInclusive(AppCompatActivity appCompatActivity) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "<this>");
        KeyboardExtKt.hideSoftKeyboard((Activity) appCompatActivity);
        if (appCompatActivity.getSupportFragmentManager().getBackStackEntryCount() > 0) {
            appCompatActivity.getSupportFragmentManager().popBackStack(appCompatActivity.getSupportFragmentManager().getBackStackEntryAt(0).getId(), 1);
        }
    }

    public static final void replaceFragment(AppCompatActivity appCompatActivity, Fragment fragment, int i) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "<this>");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        KeyboardExtKt.hideSoftKeyboard((Activity) appCompatActivity);
        FragmentManager supportFragmentManager = appCompatActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction()");
        FragmentTransaction replace = beginTransaction.replace(i, fragment, fragment.getClass().getSimpleName());
        Intrinsics.checkNotNullExpressionValue(replace, "replace(\n            fra…lass.simpleName\n        )");
        replace.commit();
    }

    public static final void addFragment(AppCompatActivity appCompatActivity, Fragment fragment, int i, boolean z) {
        FragmentTransaction fragmentTransaction;
        Intrinsics.checkNotNullParameter(appCompatActivity, "<this>");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        KeyboardExtKt.hideSoftKeyboard((Activity) appCompatActivity);
        FragmentManager supportFragmentManager = appCompatActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction()");
        if (z) {
            fragmentTransaction = beginTransaction.add(i, fragment, fragment.getClass().getSimpleName()).addToBackStack(fragment.getClass().getSimpleName());
            Intrinsics.checkNotNullExpressionValue(fragmentTransaction, "add(frameId, fragment, f…ent.javaClass.simpleName)");
        } else {
            fragmentTransaction = beginTransaction.add(i, fragment);
            Intrinsics.checkNotNullExpressionValue(fragmentTransaction, "add(frameId, fragment)");
        }
        fragmentTransaction.commit();
    }

    public static final void replaceFragment(AppCompatActivity appCompatActivity, Fragment fragment, int i, boolean z) {
        FragmentTransaction fragmentTransaction;
        Intrinsics.checkNotNullParameter(appCompatActivity, "<this>");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        KeyboardExtKt.hideSoftKeyboard((Activity) appCompatActivity);
        FragmentManager supportFragmentManager = appCompatActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction()");
        if (z) {
            fragmentTransaction = beginTransaction.replace(i, fragment, fragment.getClass().getSimpleName()).addToBackStack(fragment.getClass().getSimpleName());
            Intrinsics.checkNotNullExpressionValue(fragmentTransaction, "replace(frameId, fragmen…ent.javaClass.simpleName)");
        } else {
            fragmentTransaction = beginTransaction.replace(i, fragment, fragment.getClass().getSimpleName());
            Intrinsics.checkNotNullExpressionValue(fragmentTransaction, "replace(frameId, fragmen…ent.javaClass.simpleName)");
        }
        fragmentTransaction.commit();
    }

    public static final void replaceFragment(AppCompatActivity appCompatActivity, Fragment fragment, int i, boolean z, boolean z2) {
        FragmentTransaction fragmentTransaction;
        Intrinsics.checkNotNullParameter(appCompatActivity, "<this>");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        KeyboardExtKt.hideSoftKeyboard((Activity) appCompatActivity);
        FragmentManager supportFragmentManager = appCompatActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction()");
        if (z2 && appCompatActivity.getSupportFragmentManager().getBackStackEntryCount() > 0) {
            BackStackEntry backStackEntryAt = appCompatActivity.getSupportFragmentManager().getBackStackEntryAt(0);
            Intrinsics.checkNotNullExpressionValue(backStackEntryAt, "supportFragmentManager.getBackStackEntryAt(0)");
            appCompatActivity.getSupportFragmentManager().popBackStack(backStackEntryAt.getId(), 1);
        }
        if (z) {
            fragmentTransaction = beginTransaction.replace(i, fragment, fragment.getClass().getSimpleName()).addToBackStack(fragment.getClass().getSimpleName());
            Intrinsics.checkNotNullExpressionValue(fragmentTransaction, "replace(frameId, fragmen…ent.javaClass.simpleName)");
        } else {
            fragmentTransaction = beginTransaction.replace(i, fragment, fragment.getClass().getSimpleName());
            Intrinsics.checkNotNullExpressionValue(fragmentTransaction, "replace(frameId, fragmen…ent.javaClass.simpleName)");
        }
        fragmentTransaction.commit();
    }
}

package dagger.hilt.android.internal.managers;

import android.content.ContextWrapper;
import android.view.LayoutInflater;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleEventObserver;

public final class ViewComponentManager$FragmentContextWrapper extends ContextWrapper {
    public LayoutInflater baseInflater;
    public Fragment fragment;
    public final LifecycleEventObserver fragmentLifecycleObserver;
    public LayoutInflater inflater;

    /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ViewComponentManager$FragmentContextWrapper(android.content.Context r2, androidx.fragment.app.Fragment r3) {
        /*
            r1 = this;
            r0 = 0
            if (r2 == 0) goto L_0x001e
            r1.<init>(r2)
            dagger.hilt.android.internal.managers.ViewComponentManager$FragmentContextWrapper$1 r2 = new dagger.hilt.android.internal.managers.ViewComponentManager$FragmentContextWrapper$1
            r2.<init>()
            r1.fragmentLifecycleObserver = r2
            r1.baseInflater = r0
            if (r3 == 0) goto L_0x001d
            r1.fragment = r3
            androidx.lifecycle.Lifecycle r2 = r3.getLifecycle()
            androidx.lifecycle.LifecycleEventObserver r3 = r1.fragmentLifecycleObserver
            r2.addObserver(r3)
            return
        L_0x001d:
            throw r0
        L_0x001e:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: dagger.hilt.android.internal.managers.ViewComponentManager$FragmentContextWrapper.<init>(android.content.Context, androidx.fragment.app.Fragment):void");
    }

    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.inflater == null) {
            if (this.baseInflater == null) {
                this.baseInflater = (LayoutInflater) getBaseContext().getSystemService("layout_inflater");
            }
            this.inflater = this.baseInflater.cloneInContext(this);
        }
        return this.inflater;
    }

    /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ViewComponentManager$FragmentContextWrapper(android.view.LayoutInflater r3, androidx.fragment.app.Fragment r4) {
        /*
            r2 = this;
            r0 = 0
            if (r3 == 0) goto L_0x0025
            android.content.Context r1 = r3.getContext()
            com.twitter.sdk.android.tweetui.TweetUtils.checkNotNull(r1)
            r2.<init>(r1)
            dagger.hilt.android.internal.managers.ViewComponentManager$FragmentContextWrapper$1 r1 = new dagger.hilt.android.internal.managers.ViewComponentManager$FragmentContextWrapper$1
            r1.<init>()
            r2.fragmentLifecycleObserver = r1
            r2.baseInflater = r3
            if (r4 == 0) goto L_0x0024
            r2.fragment = r4
            androidx.lifecycle.Lifecycle r3 = r4.getLifecycle()
            androidx.lifecycle.LifecycleEventObserver r4 = r2.fragmentLifecycleObserver
            r3.addObserver(r4)
            return
        L_0x0024:
            throw r0
        L_0x0025:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: dagger.hilt.android.internal.managers.ViewComponentManager$FragmentContextWrapper.<init>(android.view.LayoutInflater, androidx.fragment.app.Fragment):void");
    }
}

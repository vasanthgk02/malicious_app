package com.bumptech.glide.manager;

import android.content.Context;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SupportRequestManagerFragment extends Fragment {
    public final Set<SupportRequestManagerFragment> childRequestManagerFragments = new HashSet();
    public final ActivityFragmentLifecycle lifecycle;
    public Fragment parentFragmentHint;
    public RequestManager requestManager;
    public final RequestManagerTreeNode requestManagerTreeNode = new SupportFragmentRequestManagerTreeNode();
    public SupportRequestManagerFragment rootRequestManagerFragment;

    public class SupportFragmentRequestManagerTreeNode implements RequestManagerTreeNode {
        public SupportFragmentRequestManagerTreeNode() {
        }

        public Set<RequestManager> getDescendants() {
            Set<SupportRequestManagerFragment> descendantRequestManagerFragments = SupportRequestManagerFragment.this.getDescendantRequestManagerFragments();
            HashSet hashSet = new HashSet(descendantRequestManagerFragments.size());
            for (SupportRequestManagerFragment supportRequestManagerFragment : descendantRequestManagerFragments) {
                RequestManager requestManager = supportRequestManagerFragment.requestManager;
                if (requestManager != null) {
                    hashSet.add(requestManager);
                }
            }
            return hashSet;
        }

        public String toString() {
            return super.toString() + "{fragment=" + SupportRequestManagerFragment.this + "}";
        }
    }

    public SupportRequestManagerFragment() {
        ActivityFragmentLifecycle activityFragmentLifecycle = new ActivityFragmentLifecycle();
        this.lifecycle = activityFragmentLifecycle;
    }

    public Set<SupportRequestManagerFragment> getDescendantRequestManagerFragments() {
        boolean z;
        SupportRequestManagerFragment supportRequestManagerFragment = this.rootRequestManagerFragment;
        if (supportRequestManagerFragment == null) {
            return Collections.emptySet();
        }
        if (equals(supportRequestManagerFragment)) {
            return Collections.unmodifiableSet(this.childRequestManagerFragments);
        }
        HashSet hashSet = new HashSet();
        for (SupportRequestManagerFragment next : this.rootRequestManagerFragment.getDescendantRequestManagerFragments()) {
            Fragment parentFragmentUsingHint = next.getParentFragmentUsingHint();
            Fragment parentFragmentUsingHint2 = getParentFragmentUsingHint();
            while (true) {
                Fragment parentFragment = parentFragmentUsingHint.getParentFragment();
                if (parentFragment == null) {
                    z = false;
                    break;
                } else if (parentFragment.equals(parentFragmentUsingHint2)) {
                    z = true;
                    break;
                } else {
                    parentFragmentUsingHint = parentFragmentUsingHint.getParentFragment();
                }
            }
            if (z) {
                hashSet.add(next);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public final Fragment getParentFragmentUsingHint() {
        Fragment parentFragment = getParentFragment();
        return parentFragment != null ? parentFragment : this.parentFragmentHint;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        Fragment fragment = this;
        while (fragment.getParentFragment() != null) {
            fragment = fragment.getParentFragment();
        }
        FragmentManager fragmentManager = fragment.getFragmentManager();
        if (fragmentManager == null) {
            Log.isLoggable("SupportRMFragment", 5);
            return;
        }
        try {
            registerFragmentWithRoot(getContext(), fragmentManager);
        } catch (IllegalStateException unused) {
            Log.isLoggable("SupportRMFragment", 5);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.lifecycle.onDestroy();
        unregisterFragmentWithRoot();
    }

    public void onDetach() {
        super.onDetach();
        this.parentFragmentHint = null;
        unregisterFragmentWithRoot();
    }

    public void onStart() {
        super.onStart();
        this.lifecycle.onStart();
    }

    public void onStop() {
        super.onStop();
        this.lifecycle.onStop();
    }

    public final void registerFragmentWithRoot(Context context, FragmentManager fragmentManager) {
        unregisterFragmentWithRoot();
        RequestManagerRetriever requestManagerRetriever = Glide.get(context).getRequestManagerRetriever();
        if (requestManagerRetriever != null) {
            SupportRequestManagerFragment supportRequestManagerFragment = requestManagerRetriever.getSupportRequestManagerFragment(fragmentManager, null, RequestManagerRetriever.isActivityVisible(context));
            this.rootRequestManagerFragment = supportRequestManagerFragment;
            if (!equals(supportRequestManagerFragment)) {
                this.rootRequestManagerFragment.childRequestManagerFragments.add(this);
                return;
            }
            return;
        }
        throw null;
    }

    public String toString() {
        return super.toString() + "{parent=" + getParentFragmentUsingHint() + "}";
    }

    public final void unregisterFragmentWithRoot() {
        SupportRequestManagerFragment supportRequestManagerFragment = this.rootRequestManagerFragment;
        if (supportRequestManagerFragment != null) {
            supportRequestManagerFragment.childRequestManagerFragments.remove(this);
            this.rootRequestManagerFragment = null;
        }
    }
}

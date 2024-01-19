package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class FragmentStore {
    public static final String TAG = "FragmentManager";
    public final HashMap<String, FragmentStateManager> mActive = new HashMap<>();
    public final ArrayList<Fragment> mAdded = new ArrayList<>();
    public FragmentManagerViewModel mNonConfig;

    public void addFragment(Fragment fragment) {
        if (!this.mAdded.contains(fragment)) {
            synchronized (this.mAdded) {
                this.mAdded.add(fragment);
            }
            fragment.mAdded = true;
            return;
        }
        throw new IllegalStateException("Fragment already added: " + fragment);
    }

    public void burpActive() {
        this.mActive.values().removeAll(Collections.singleton(null));
    }

    public boolean containsActiveFragment(String str) {
        return this.mActive.get(str) != null;
    }

    public void dispatchStateChange(int i) {
        for (FragmentStateManager next : this.mActive.values()) {
            if (next != null) {
                next.setFragmentManagerState(i);
            }
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String outline50 = GeneratedOutlineSupport.outline50(str, "    ");
        if (!this.mActive.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (FragmentStateManager next : this.mActive.values()) {
                printWriter.print(str);
                if (next != null) {
                    Fragment fragment = next.getFragment();
                    printWriter.println(fragment);
                    fragment.dump(outline50, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        int size = this.mAdded.size();
        if (size > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i = 0; i < size; i++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(this.mAdded.get(i).toString());
            }
        }
    }

    public Fragment findActiveFragment(String str) {
        FragmentStateManager fragmentStateManager = this.mActive.get(str);
        if (fragmentStateManager != null) {
            return fragmentStateManager.getFragment();
        }
        return null;
    }

    public Fragment findFragmentById(int i) {
        for (int size = this.mAdded.size() - 1; size >= 0; size--) {
            Fragment fragment = this.mAdded.get(size);
            if (fragment != null && fragment.mFragmentId == i) {
                return fragment;
            }
        }
        for (FragmentStateManager next : this.mActive.values()) {
            if (next != null) {
                Fragment fragment2 = next.getFragment();
                if (fragment2.mFragmentId == i) {
                    return fragment2;
                }
            }
        }
        return null;
    }

    public Fragment findFragmentByTag(String str) {
        if (str != null) {
            for (int size = this.mAdded.size() - 1; size >= 0; size--) {
                Fragment fragment = this.mAdded.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        if (str != null) {
            for (FragmentStateManager next : this.mActive.values()) {
                if (next != null) {
                    Fragment fragment2 = next.getFragment();
                    if (str.equals(fragment2.mTag)) {
                        return fragment2;
                    }
                }
            }
        }
        return null;
    }

    public Fragment findFragmentByWho(String str) {
        for (FragmentStateManager next : this.mActive.values()) {
            if (next != null) {
                Fragment findFragmentByWho = next.getFragment().findFragmentByWho(str);
                if (findFragmentByWho != null) {
                    return findFragmentByWho;
                }
            }
        }
        return null;
    }

    public int findFragmentIndexInContainer(Fragment fragment) {
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup == null) {
            return -1;
        }
        int indexOf = this.mAdded.indexOf(fragment);
        for (int i = indexOf - 1; i >= 0; i--) {
            Fragment fragment2 = this.mAdded.get(i);
            if (fragment2.mContainer == viewGroup) {
                View view = fragment2.mView;
                if (view != null) {
                    return viewGroup.indexOfChild(view) + 1;
                }
            }
        }
        while (true) {
            indexOf++;
            if (indexOf >= this.mAdded.size()) {
                return -1;
            }
            Fragment fragment3 = this.mAdded.get(indexOf);
            if (fragment3.mContainer == viewGroup) {
                View view2 = fragment3.mView;
                if (view2 != null) {
                    return viewGroup.indexOfChild(view2);
                }
            }
        }
    }

    public int getActiveFragmentCount() {
        return this.mActive.size();
    }

    public List<FragmentStateManager> getActiveFragmentStateManagers() {
        ArrayList arrayList = new ArrayList();
        for (FragmentStateManager next : this.mActive.values()) {
            if (next != null) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public List<Fragment> getActiveFragments() {
        ArrayList arrayList = new ArrayList();
        for (FragmentStateManager next : this.mActive.values()) {
            if (next != null) {
                arrayList.add(next.getFragment());
            } else {
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    public FragmentStateManager getFragmentStateManager(String str) {
        return this.mActive.get(str);
    }

    public List<Fragment> getFragments() {
        ArrayList arrayList;
        if (this.mAdded.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.mAdded) {
            try {
                arrayList = new ArrayList(this.mAdded);
            }
        }
        return arrayList;
    }

    public FragmentManagerViewModel getNonConfig() {
        return this.mNonConfig;
    }

    public void makeActive(FragmentStateManager fragmentStateManager) {
        Fragment fragment = fragmentStateManager.getFragment();
        if (!containsActiveFragment(fragment.mWho)) {
            this.mActive.put(fragment.mWho, fragmentStateManager);
            if (fragment.mRetainInstanceChangedWhileDetached) {
                if (fragment.mRetainInstance) {
                    this.mNonConfig.addRetainedFragment(fragment);
                } else {
                    this.mNonConfig.removeRetainedFragment(fragment);
                }
                fragment.mRetainInstanceChangedWhileDetached = false;
            }
            if (FragmentManager.isLoggingEnabled(2)) {
                "Added fragment to active set " + fragment;
            }
        }
    }

    public void makeInactive(FragmentStateManager fragmentStateManager) {
        Fragment fragment = fragmentStateManager.getFragment();
        if (fragment.mRetainInstance) {
            this.mNonConfig.removeRetainedFragment(fragment);
        }
        if (this.mActive.put(fragment.mWho, null) != null && FragmentManager.isLoggingEnabled(2)) {
            "Removed fragment from active set " + fragment;
        }
    }

    public void moveToExpectedState() {
        Iterator<Fragment> it = this.mAdded.iterator();
        while (it.hasNext()) {
            FragmentStateManager fragmentStateManager = this.mActive.get(it.next().mWho);
            if (fragmentStateManager != null) {
                fragmentStateManager.moveToExpectedState();
            }
        }
        for (FragmentStateManager next : this.mActive.values()) {
            if (next != null) {
                next.moveToExpectedState();
                Fragment fragment = next.getFragment();
                if (fragment.mRemoving && !fragment.isInBackStack()) {
                    makeInactive(next);
                }
            }
        }
    }

    public void removeFragment(Fragment fragment) {
        synchronized (this.mAdded) {
            this.mAdded.remove(fragment);
        }
        fragment.mAdded = false;
    }

    public void resetActiveFragments() {
        this.mActive.clear();
    }

    public void restoreAddedFragments(List<String> list) {
        this.mAdded.clear();
        if (list != null) {
            for (String next : list) {
                Fragment findActiveFragment = findActiveFragment(next);
                if (findActiveFragment != null) {
                    if (FragmentManager.isLoggingEnabled(2)) {
                        "restoreSaveState: added (" + next + "): " + findActiveFragment;
                    }
                    addFragment(findActiveFragment);
                } else {
                    throw new IllegalStateException(GeneratedOutlineSupport.outline52("No instantiated fragment for (", next, ")"));
                }
            }
        }
    }

    public ArrayList<FragmentState> saveActiveFragments() {
        ArrayList<FragmentState> arrayList = new ArrayList<>(this.mActive.size());
        for (FragmentStateManager next : this.mActive.values()) {
            if (next != null) {
                Fragment fragment = next.getFragment();
                arrayList.add(next.saveState());
                if (FragmentManager.isLoggingEnabled(2)) {
                    "Saved state of " + fragment + ": " + r2.mSavedFragmentState;
                }
            }
        }
        return arrayList;
    }

    public ArrayList<String> saveAddedFragments() {
        synchronized (this.mAdded) {
            try {
                if (this.mAdded.isEmpty()) {
                    return null;
                }
                ArrayList<String> arrayList = new ArrayList<>(this.mAdded.size());
                Iterator<Fragment> it = this.mAdded.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().mWho);
                    if (FragmentManager.isLoggingEnabled(2)) {
                        "saveAllState: adding fragment (" + r3.mWho + "): " + r3;
                    }
                }
                return arrayList;
            }
        }
    }

    public void setNonConfig(FragmentManagerViewModel fragmentManagerViewModel) {
        this.mNonConfig = fragmentManagerViewModel;
    }
}

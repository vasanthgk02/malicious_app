package androidx.navigation;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.collection.SparseArrayCompat;
import androidx.navigation.NavDestination.DeepLinkMatch;
import androidx.navigation.common.R$styleable;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class NavGraph extends NavDestination implements Iterable<NavDestination> {
    public final SparseArrayCompat<NavDestination> mNodes = new SparseArrayCompat<>();
    public int mStartDestId;
    public String mStartDestIdName;

    public NavGraph(Navigator<? extends NavGraph> navigator) {
        super(navigator);
    }

    public final void addDestination(NavDestination navDestination) {
        int i = navDestination.mId;
        if (i != 0) {
            NavDestination navDestination2 = (NavDestination) this.mNodes.get(i);
            if (navDestination2 != navDestination) {
                if (navDestination.mParent == null) {
                    if (navDestination2 != null) {
                        navDestination2.mParent = null;
                    }
                    navDestination.mParent = this;
                    this.mNodes.put(navDestination.mId, navDestination);
                    return;
                }
                throw new IllegalStateException("Destination already has a parent set. Call NavGraph.remove() to remove the previous parent.");
            }
            return;
        }
        throw new IllegalArgumentException("Destinations must have an id. Call setId() or include an android:id in your navigation XML.");
    }

    public final NavDestination findNode(int i) {
        return findNode(i, true);
    }

    public final Iterator<NavDestination> iterator() {
        return new Iterator<NavDestination>() {
            public int mIndex = -1;
            public boolean mWentToNext = false;

            public boolean hasNext() {
                return this.mIndex + 1 < NavGraph.this.mNodes.size();
            }

            public Object next() {
                if (hasNext()) {
                    this.mWentToNext = true;
                    SparseArrayCompat<NavDestination> sparseArrayCompat = NavGraph.this.mNodes;
                    int i = this.mIndex + 1;
                    this.mIndex = i;
                    return (NavDestination) sparseArrayCompat.valueAt(i);
                }
                throw new NoSuchElementException();
            }

            public void remove() {
                if (this.mWentToNext) {
                    ((NavDestination) NavGraph.this.mNodes.valueAt(this.mIndex)).mParent = null;
                    SparseArrayCompat<NavDestination> sparseArrayCompat = NavGraph.this.mNodes;
                    int i = this.mIndex;
                    Object[] objArr = sparseArrayCompat.mValues;
                    Object obj = objArr[i];
                    Object obj2 = SparseArrayCompat.DELETED;
                    if (obj != obj2) {
                        objArr[i] = obj2;
                        sparseArrayCompat.mGarbage = true;
                    }
                    this.mIndex--;
                    this.mWentToNext = false;
                    return;
                }
                throw new IllegalStateException("You must call next() before you can remove an element");
            }
        };
    }

    public DeepLinkMatch matchDeepLink(NavDeepLinkRequest navDeepLinkRequest) {
        DeepLinkMatch matchDeepLink = super.matchDeepLink(navDeepLinkRequest);
        AnonymousClass1 r1 = new Iterator<NavDestination>() {
            public int mIndex = -1;
            public boolean mWentToNext = false;

            public boolean hasNext() {
                return this.mIndex + 1 < NavGraph.this.mNodes.size();
            }

            public Object next() {
                if (hasNext()) {
                    this.mWentToNext = true;
                    SparseArrayCompat<NavDestination> sparseArrayCompat = NavGraph.this.mNodes;
                    int i = this.mIndex + 1;
                    this.mIndex = i;
                    return (NavDestination) sparseArrayCompat.valueAt(i);
                }
                throw new NoSuchElementException();
            }

            public void remove() {
                if (this.mWentToNext) {
                    ((NavDestination) NavGraph.this.mNodes.valueAt(this.mIndex)).mParent = null;
                    SparseArrayCompat<NavDestination> sparseArrayCompat = NavGraph.this.mNodes;
                    int i = this.mIndex;
                    Object[] objArr = sparseArrayCompat.mValues;
                    Object obj = objArr[i];
                    Object obj2 = SparseArrayCompat.DELETED;
                    if (obj != obj2) {
                        objArr[i] = obj2;
                        sparseArrayCompat.mGarbage = true;
                    }
                    this.mIndex--;
                    this.mWentToNext = false;
                    return;
                }
                throw new IllegalStateException("You must call next() before you can remove an element");
            }
        };
        while (r1.hasNext()) {
            DeepLinkMatch matchDeepLink2 = ((NavDestination) r1.next()).matchDeepLink(navDeepLinkRequest);
            if (matchDeepLink2 != null && (matchDeepLink == null || matchDeepLink2.compareTo(matchDeepLink) > 0)) {
                matchDeepLink = matchDeepLink2;
            }
        }
        return matchDeepLink;
    }

    public void onInflate(Context context, AttributeSet attributeSet) {
        super.onInflate(context, attributeSet);
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R$styleable.NavGraphNavigator);
        int resourceId = obtainAttributes.getResourceId(R$styleable.NavGraphNavigator_startDestination, 0);
        this.mStartDestId = resourceId;
        this.mStartDestIdName = null;
        this.mStartDestIdName = NavDestination.getDisplayName(context, resourceId);
        obtainAttributes.recycle();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(" startDestination=");
        NavDestination findNode = findNode(this.mStartDestId);
        if (findNode == null) {
            String str = this.mStartDestIdName;
            if (str == null) {
                sb.append("0x");
                sb.append(Integer.toHexString(this.mStartDestId));
            } else {
                sb.append(str);
            }
        } else {
            sb.append("{");
            sb.append(findNode.toString());
            sb.append("}");
        }
        return sb.toString();
    }

    public final NavDestination findNode(int i, boolean z) {
        NavDestination navDestination = (NavDestination) this.mNodes.get(i, null);
        if (navDestination != null) {
            return navDestination;
        }
        if (!z) {
            return null;
        }
        NavGraph navGraph = this.mParent;
        if (navGraph != null) {
            return navGraph.findNode(i);
        }
        return null;
    }
}

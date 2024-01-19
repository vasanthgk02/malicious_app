package androidx.navigation.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigator;
import androidx.navigation.Navigator.Name;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayDeque;
import java.util.Iterator;

@Name("fragment")
public class FragmentNavigator extends Navigator<Destination> {
    public ArrayDeque<Integer> mBackStack = new ArrayDeque<>();
    public final int mContainerId;
    public final Context mContext;
    public final FragmentManager mFragmentManager;

    public static class Destination extends NavDestination {
        public String mClassName;

        public Destination(Navigator<? extends Destination> navigator) {
            super(navigator);
        }

        public void onInflate(Context context, AttributeSet attributeSet) {
            super.onInflate(context, attributeSet);
            TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R$styleable.FragmentNavigator);
            String string = obtainAttributes.getString(R$styleable.FragmentNavigator_android_name);
            if (string != null) {
                this.mClassName = string;
            }
            obtainAttributes.recycle();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            sb.append(" class=");
            String str = this.mClassName;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            return sb.toString();
        }
    }

    public static final class Extras implements androidx.navigation.Navigator.Extras {
    }

    public FragmentNavigator(Context context, FragmentManager fragmentManager, int i) {
        this.mContext = context;
        this.mFragmentManager = fragmentManager;
        this.mContainerId = i;
    }

    public NavDestination createDestination() {
        return new Destination(this);
    }

    public final String generateBackStackName(int i, int i2) {
        return i + Constants.ACCEPT_TIME_SEPARATOR_SERVER + i2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0124  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.navigation.NavDestination navigate(androidx.navigation.NavDestination r9, android.os.Bundle r10, androidx.navigation.NavOptions r11, androidx.navigation.Navigator.Extras r12) {
        /*
            r8 = this;
            androidx.navigation.fragment.FragmentNavigator$Destination r9 = (androidx.navigation.fragment.FragmentNavigator.Destination) r9
            androidx.fragment.app.FragmentManager r0 = r8.mFragmentManager
            boolean r0 = r0.isStateSaved()
            r1 = 0
            if (r0 == 0) goto L_0x000d
            goto L_0x012e
        L_0x000d:
            java.lang.String r0 = r9.mClassName
            if (r0 == 0) goto L_0x0130
            r2 = 0
            char r3 = r0.charAt(r2)
            r4 = 46
            if (r3 != r4) goto L_0x002f
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            android.content.Context r4 = r8.mContext
            java.lang.String r4 = r4.getPackageName()
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
        L_0x002f:
            android.content.Context r3 = r8.mContext
            androidx.fragment.app.FragmentManager r4 = r8.mFragmentManager
            androidx.fragment.app.FragmentFactory r4 = r4.getFragmentFactory()
            java.lang.ClassLoader r3 = r3.getClassLoader()
            androidx.fragment.app.Fragment r0 = r4.instantiate(r3, r0)
            r0.setArguments(r10)
            androidx.fragment.app.FragmentManager r10 = r8.mFragmentManager
            androidx.fragment.app.FragmentTransaction r10 = r10.beginTransaction()
            r3 = -1
            if (r11 == 0) goto L_0x004e
            int r4 = r11.mEnterAnim
            goto L_0x004f
        L_0x004e:
            r4 = -1
        L_0x004f:
            if (r11 == 0) goto L_0x0054
            int r5 = r11.mExitAnim
            goto L_0x0055
        L_0x0054:
            r5 = -1
        L_0x0055:
            if (r11 == 0) goto L_0x005a
            int r6 = r11.mPopEnterAnim
            goto L_0x005b
        L_0x005a:
            r6 = -1
        L_0x005b:
            if (r11 == 0) goto L_0x0060
            int r7 = r11.mPopExitAnim
            goto L_0x0061
        L_0x0060:
            r7 = -1
        L_0x0061:
            if (r4 != r3) goto L_0x0069
            if (r5 != r3) goto L_0x0069
            if (r6 != r3) goto L_0x0069
            if (r7 == r3) goto L_0x007c
        L_0x0069:
            if (r4 == r3) goto L_0x006c
            goto L_0x006d
        L_0x006c:
            r4 = 0
        L_0x006d:
            if (r5 == r3) goto L_0x0070
            goto L_0x0071
        L_0x0070:
            r5 = 0
        L_0x0071:
            if (r6 == r3) goto L_0x0074
            goto L_0x0075
        L_0x0074:
            r6 = 0
        L_0x0075:
            if (r7 == r3) goto L_0x0078
            goto L_0x0079
        L_0x0078:
            r7 = 0
        L_0x0079:
            r10.setCustomAnimations(r4, r5, r6, r7)
        L_0x007c:
            int r3 = r8.mContainerId
            r10.replace(r3, r0)
            r10.setPrimaryNavigationFragment(r0)
            int r0 = r9.mId
            java.util.ArrayDeque<java.lang.Integer> r3 = r8.mBackStack
            boolean r3 = r3.isEmpty()
            r4 = 1
            if (r11 == 0) goto L_0x00a5
            if (r3 != 0) goto L_0x00a5
            boolean r11 = r11.mSingleTop
            if (r11 == 0) goto L_0x00a5
            java.util.ArrayDeque<java.lang.Integer> r11 = r8.mBackStack
            java.lang.Object r11 = r11.peekLast()
            java.lang.Integer r11 = (java.lang.Integer) r11
            int r11 = r11.intValue()
            if (r11 != r0) goto L_0x00a5
            r11 = 1
            goto L_0x00a6
        L_0x00a5:
            r11 = 0
        L_0x00a6:
            if (r3 == 0) goto L_0x00a9
            goto L_0x00ea
        L_0x00a9:
            if (r11 == 0) goto L_0x00dc
            java.util.ArrayDeque<java.lang.Integer> r11 = r8.mBackStack
            int r11 = r11.size()
            if (r11 <= r4) goto L_0x00eb
            androidx.fragment.app.FragmentManager r11 = r8.mFragmentManager
            java.util.ArrayDeque<java.lang.Integer> r3 = r8.mBackStack
            int r3 = r3.size()
            java.util.ArrayDeque<java.lang.Integer> r5 = r8.mBackStack
            java.lang.Object r5 = r5.peekLast()
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            java.lang.String r3 = r8.generateBackStackName(r3, r5)
            r11.popBackStack(r3, r4)
            java.util.ArrayDeque<java.lang.Integer> r11 = r8.mBackStack
            int r11 = r11.size()
            java.lang.String r11 = r8.generateBackStackName(r11, r0)
            r10.addToBackStack(r11)
            goto L_0x00eb
        L_0x00dc:
            java.util.ArrayDeque<java.lang.Integer> r11 = r8.mBackStack
            int r11 = r11.size()
            int r11 = r11 + r4
            java.lang.String r11 = r8.generateBackStackName(r11, r0)
            r10.addToBackStack(r11)
        L_0x00ea:
            r2 = 1
        L_0x00eb:
            boolean r11 = r12 instanceof androidx.navigation.fragment.FragmentNavigator.Extras
            if (r11 == 0) goto L_0x011c
            androidx.navigation.fragment.FragmentNavigator$Extras r12 = (androidx.navigation.fragment.FragmentNavigator.Extras) r12
            if (r12 == 0) goto L_0x011b
            java.util.Map r11 = java.util.Collections.unmodifiableMap(r1)
            java.util.Set r11 = r11.entrySet()
            java.util.Iterator r11 = r11.iterator()
        L_0x00ff:
            boolean r12 = r11.hasNext()
            if (r12 == 0) goto L_0x011c
            java.lang.Object r12 = r11.next()
            java.util.Map$Entry r12 = (java.util.Map.Entry) r12
            java.lang.Object r3 = r12.getKey()
            android.view.View r3 = (android.view.View) r3
            java.lang.Object r12 = r12.getValue()
            java.lang.String r12 = (java.lang.String) r12
            r10.addSharedElement(r3, r12)
            goto L_0x00ff
        L_0x011b:
            throw r1
        L_0x011c:
            r10.setReorderingAllowed(r4)
            r10.commit()
            if (r2 == 0) goto L_0x012e
            java.util.ArrayDeque<java.lang.Integer> r10 = r8.mBackStack
            java.lang.Integer r11 = java.lang.Integer.valueOf(r0)
            r10.add(r11)
            goto L_0x012f
        L_0x012e:
            r9 = r1
        L_0x012f:
            return r9
        L_0x0130:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "Fragment class was not set"
            r9.<init>(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.fragment.FragmentNavigator.navigate(androidx.navigation.NavDestination, android.os.Bundle, androidx.navigation.NavOptions, androidx.navigation.Navigator$Extras):androidx.navigation.NavDestination");
    }

    public void onRestoreState(Bundle bundle) {
        int[] intArray = bundle.getIntArray("androidx-nav-fragment:navigator:backStackIds");
        if (intArray != null) {
            this.mBackStack.clear();
            for (int valueOf : intArray) {
                this.mBackStack.add(Integer.valueOf(valueOf));
            }
        }
    }

    public Bundle onSaveState() {
        Bundle bundle = new Bundle();
        int[] iArr = new int[this.mBackStack.size()];
        Iterator<Integer> it = this.mBackStack.iterator();
        int i = 0;
        while (it.hasNext()) {
            iArr[i] = it.next().intValue();
            i++;
        }
        bundle.putIntArray("androidx-nav-fragment:navigator:backStackIds", iArr);
        return bundle;
    }

    public boolean popBackStack() {
        if (this.mBackStack.isEmpty() || this.mFragmentManager.isStateSaved()) {
            return false;
        }
        this.mFragmentManager.popBackStack(generateBackStackName(this.mBackStack.size(), this.mBackStack.peekLast().intValue()), 1);
        this.mBackStack.removeLast();
        return true;
    }
}

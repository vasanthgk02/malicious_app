package androidx.navigation;

import android.os.Bundle;
import androidx.navigation.Navigator.Extras;
import androidx.navigation.Navigator.Name;
import com.android.tools.r8.GeneratedOutlineSupport;

@Name("navigation")
public class NavGraphNavigator extends Navigator<NavGraph> {
    public final NavigatorProvider mNavigatorProvider;

    public NavGraphNavigator(NavigatorProvider navigatorProvider) {
        this.mNavigatorProvider = navigatorProvider;
    }

    public NavDestination createDestination() {
        return new NavGraph(this);
    }

    public NavDestination navigate(NavDestination navDestination, Bundle bundle, NavOptions navOptions, Extras extras) {
        String str;
        NavGraph navGraph = (NavGraph) navDestination;
        int i = navGraph.mStartDestId;
        if (i == 0) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("no start destination defined via app:startDestination for ");
            int i2 = navGraph.mId;
            if (i2 != 0) {
                if (navGraph.mIdName == null) {
                    navGraph.mIdName = Integer.toString(i2);
                }
                str = navGraph.mIdName;
            } else {
                str = "the root navigation";
            }
            outline73.append(str);
            throw new IllegalStateException(outline73.toString());
        }
        NavDestination findNode = navGraph.findNode(i, false);
        if (findNode != null) {
            return this.mNavigatorProvider.getNavigator(findNode.mNavigatorName).navigate(findNode, findNode.addInDefaultArgs(bundle), navOptions, extras);
        }
        if (navGraph.mStartDestIdName == null) {
            navGraph.mStartDestIdName = Integer.toString(navGraph.mStartDestId);
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline52("navigation destination ", navGraph.mStartDestIdName, " is not a direct child of this NavGraph"));
    }

    public boolean popBackStack() {
        return true;
    }
}

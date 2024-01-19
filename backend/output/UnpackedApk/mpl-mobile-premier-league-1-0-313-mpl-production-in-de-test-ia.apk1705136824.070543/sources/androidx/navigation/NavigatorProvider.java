package androidx.navigation;

import android.annotation.SuppressLint;
import androidx.navigation.Navigator.Name;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.HashMap;

@SuppressLint({"TypeParameterUnusedInFormals"})
public class NavigatorProvider {
    public static final HashMap<Class<?>, String> sAnnotationNames = new HashMap<>();
    public final HashMap<String, Navigator<? extends NavDestination>> mNavigators = new HashMap<>();

    public static String getNameForNavigator(Class<? extends Navigator> cls) {
        String str = sAnnotationNames.get(cls);
        if (str == null) {
            Name name = (Name) cls.getAnnotation(Name.class);
            str = name != null ? name.value() : null;
            if (validateName(str)) {
                sAnnotationNames.put(cls, str);
            } else {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("No @Navigator.Name annotation found for ");
                outline73.append(cls.getSimpleName());
                throw new IllegalArgumentException(outline73.toString());
            }
        }
        return str;
    }

    public static boolean validateName(String str) {
        return str != null && !str.isEmpty();
    }

    public final Navigator<? extends NavDestination> addNavigator(Navigator<? extends NavDestination> navigator) {
        String nameForNavigator = getNameForNavigator(navigator.getClass());
        if (validateName(nameForNavigator)) {
            return this.mNavigators.put(nameForNavigator, navigator);
        }
        throw new IllegalArgumentException("navigator name cannot be an empty string");
    }

    public <T extends Navigator<?>> T getNavigator(String str) {
        if (validateName(str)) {
            T t = (Navigator) this.mNavigators.get(str);
            if (t != null) {
                return t;
            }
            throw new IllegalStateException(GeneratedOutlineSupport.outline52("Could not find Navigator with name \"", str, "\". You must call NavController.addNavigator() for each navigation type."));
        }
        throw new IllegalArgumentException("navigator name cannot be an empty string");
    }
}

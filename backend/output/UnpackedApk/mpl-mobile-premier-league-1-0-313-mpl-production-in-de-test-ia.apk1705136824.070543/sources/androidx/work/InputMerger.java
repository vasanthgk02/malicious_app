package androidx.work;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.List;

public abstract class InputMerger {
    public static final String TAG = Logger.tagWithPrefix("InputMerger");

    public static InputMerger fromClassName(String str) {
        try {
            return (InputMerger) Class.forName(str).newInstance();
        } catch (Exception e2) {
            Logger.get().error(TAG, GeneratedOutlineSupport.outline50("Trouble instantiating + ", str), e2);
            return null;
        }
    }

    public abstract Data merge(List<Data> list);
}

package androidx.core.view.accessibility;

import android.os.Bundle;
import android.view.View;

public interface AccessibilityViewCommand {

    public static abstract class CommandArguments {
        public Bundle mBundle;
    }

    public static final class SetProgressArguments extends CommandArguments {
    }

    boolean perform(View view, CommandArguments commandArguments);
}

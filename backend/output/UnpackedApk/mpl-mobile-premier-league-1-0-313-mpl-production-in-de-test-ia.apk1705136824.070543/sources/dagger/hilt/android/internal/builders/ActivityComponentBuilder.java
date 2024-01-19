package dagger.hilt.android.internal.builders;

import android.app.Activity;
import dagger.hilt.android.components.ActivityComponent;

public interface ActivityComponentBuilder {
    ActivityComponentBuilder activity(Activity activity);

    ActivityComponent build();
}

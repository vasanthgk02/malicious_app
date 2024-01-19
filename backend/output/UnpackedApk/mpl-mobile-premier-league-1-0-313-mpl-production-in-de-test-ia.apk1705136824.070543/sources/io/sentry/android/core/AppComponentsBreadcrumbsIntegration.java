package io.sentry.android.core;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import androidx.core.app.NotificationCompat;
import io.sentry.Breadcrumb;
import io.sentry.IHub;
import io.sentry.Integration;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.android.core.util.DeviceOrientations;
import io.sentry.protocol.Device.DeviceOrientation;
import io.sentry.util.Objects;
import java.io.Closeable;
import java.io.IOException;
import java.util.Locale;

public final class AppComponentsBreadcrumbsIntegration implements Integration, Closeable, ComponentCallbacks2 {
    public final Context context;
    public IHub hub;
    public SentryAndroidOptions options;

    public AppComponentsBreadcrumbsIntegration(Context context2) {
        this.context = (Context) Objects.requireNonNull(context2, "Context is required");
    }

    private void createLowMemoryBreadcrumb(Integer num) {
        if (this.hub != null) {
            Breadcrumb breadcrumb = new Breadcrumb();
            if (num != null) {
                if (num.intValue() >= 40) {
                    breadcrumb.setData("level", num);
                } else {
                    return;
                }
            }
            breadcrumb.setType("system");
            breadcrumb.setCategory("device.event");
            breadcrumb.setMessage("Low memory");
            breadcrumb.setData("action", "LOW_MEMORY");
            breadcrumb.setLevel(SentryLevel.WARNING);
            this.hub.addBreadcrumb(breadcrumb);
        }
    }

    public void close() throws IOException {
        try {
            this.context.unregisterComponentCallbacks(this);
        } catch (Exception unused) {
        }
        SentryAndroidOptions sentryAndroidOptions = this.options;
        if (sentryAndroidOptions != null) {
            sentryAndroidOptions.getLogger().log(SentryLevel.DEBUG, (String) "AppComponentsBreadcrumbsIntegration removed.", new Object[0]);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.hub != null) {
            DeviceOrientation orientation = DeviceOrientations.getOrientation(this.context.getResources().getConfiguration().orientation);
            String lowerCase = orientation != null ? orientation.name().toLowerCase(Locale.ROOT) : "undefined";
            Breadcrumb breadcrumb = new Breadcrumb();
            breadcrumb.setType(NotificationCompat.CATEGORY_NAVIGATION);
            breadcrumb.setCategory("device.orientation");
            breadcrumb.setData("position", lowerCase);
            breadcrumb.setLevel(SentryLevel.INFO);
            this.hub.addBreadcrumb(breadcrumb);
        }
    }

    public void onLowMemory() {
        createLowMemoryBreadcrumb(null);
    }

    public void onTrimMemory(int i) {
        createLowMemoryBreadcrumb(Integer.valueOf(i));
    }

    public void register(IHub iHub, SentryOptions sentryOptions) {
        this.hub = (IHub) Objects.requireNonNull(iHub, "Hub is required");
        SentryAndroidOptions sentryAndroidOptions = (SentryAndroidOptions) Objects.requireNonNull(sentryOptions instanceof SentryAndroidOptions ? (SentryAndroidOptions) sentryOptions : null, "SentryAndroidOptions is required");
        this.options = sentryAndroidOptions;
        sentryAndroidOptions.getLogger().log(SentryLevel.DEBUG, (String) "AppComponentsBreadcrumbsIntegration enabled: %s", Boolean.valueOf(this.options.isEnableAppComponentBreadcrumbs()));
        if (this.options.isEnableAppComponentBreadcrumbs()) {
            try {
                this.context.registerComponentCallbacks(this);
                sentryOptions.getLogger().log(SentryLevel.DEBUG, (String) "AppComponentsBreadcrumbsIntegration installed.", new Object[0]);
            } catch (Exception e2) {
                this.options.setEnableAppComponentBreadcrumbs(false);
                sentryOptions.getLogger().log(SentryLevel.INFO, e2, "ComponentCallbacks2 is not available.", new Object[0]);
            }
        }
    }
}

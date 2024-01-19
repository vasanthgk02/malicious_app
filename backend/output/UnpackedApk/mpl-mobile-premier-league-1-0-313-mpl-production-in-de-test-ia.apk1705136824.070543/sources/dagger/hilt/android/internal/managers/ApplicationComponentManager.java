package dagger.hilt.android.internal.managers;

import dagger.hilt.internal.GeneratedComponentManager;

public final class ApplicationComponentManager implements GeneratedComponentManager<Object> {
    public volatile Object component;
    public final ComponentSupplier componentCreator;
    public final Object componentLock = new Object();

    public ApplicationComponentManager(ComponentSupplier componentSupplier) {
        this.componentCreator = componentSupplier;
    }

    public Object generatedComponent() {
        if (this.component == null) {
            synchronized (this.componentLock) {
                try {
                    if (this.component == null) {
                        this.component = this.componentCreator.get();
                    }
                }
            }
        }
        return this.component;
    }
}

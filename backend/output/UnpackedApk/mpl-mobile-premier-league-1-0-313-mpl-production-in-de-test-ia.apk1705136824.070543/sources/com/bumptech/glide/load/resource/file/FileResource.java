package com.bumptech.glide.load.resource.file;

import co.hyperverge.hypersnapsdk.c.k;
import com.bumptech.glide.load.engine.Resource;
import java.io.File;

public class FileResource implements Resource {
    public final Object data;

    public FileResource(File file) {
        k.checkNotNull(file, (String) "Argument must not be null");
        this.data = file;
    }

    public final Object get() {
        return this.data;
    }

    public Class getResourceClass() {
        return this.data.getClass();
    }

    public final int getSize() {
        return 1;
    }

    public void recycle() {
    }
}

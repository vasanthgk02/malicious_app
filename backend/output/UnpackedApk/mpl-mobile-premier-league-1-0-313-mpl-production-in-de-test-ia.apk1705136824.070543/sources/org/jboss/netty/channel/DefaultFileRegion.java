package org.jboss.netty.channel;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import org.jboss.netty.logging.InternalLogger;
import org.jboss.netty.logging.InternalLoggerFactory;

public class DefaultFileRegion implements FileRegion {
    public static final InternalLogger logger = InternalLoggerFactory.getInstance(DefaultFileRegion.class);
    public final long count;
    public final FileChannel file;
    public final long position;

    public DefaultFileRegion(FileChannel fileChannel, long j, long j2) {
        this.file = fileChannel;
        this.position = j;
        this.count = j2;
    }

    public long getCount() {
        return this.count;
    }

    public long getPosition() {
        return this.position;
    }

    public void releaseExternalResources() {
        try {
            this.file.close();
        } catch (IOException e2) {
            logger.warn("Failed to close a file.", e2);
        }
    }

    public long transferTo(WritableByteChannel writableByteChannel, long j) throws IOException {
        long j2 = this.count - j;
        int i = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        if (i < 0 || j < 0) {
            StringBuilder outline76 = GeneratedOutlineSupport.outline76("position out of range: ", j, " (expected: 0 - ");
            outline76.append(this.count - 1);
            outline76.append(")");
            throw new IllegalArgumentException(outline76.toString());
        } else if (i == 0) {
            return 0;
        } else {
            return this.file.transferTo(this.position + j, j2, writableByteChannel);
        }
    }
}

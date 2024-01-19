package okio;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders.Values;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J\b\u0010\b\u001a\u00020\tH\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lokio/SocketAsyncTimeout;", "Lokio/AsyncTimeout;", "socket", "Ljava/net/Socket;", "(Ljava/net/Socket;)V", "newTimeoutException", "Ljava/io/IOException;", "cause", "timedOut", "", "okio"}, k = 1, mv = {1, 4, 1})
/* compiled from: JvmOkio.kt */
public final class SocketAsyncTimeout extends AsyncTimeout {
    public final Socket socket;

    public SocketAsyncTimeout(Socket socket2) {
        Intrinsics.checkNotNullParameter(socket2, "socket");
        this.socket = socket2;
    }

    public IOException newTimeoutException(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException(Values.TIMEOUT);
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }

    public void timedOut() {
        try {
            this.socket.close();
        } catch (Exception e2) {
            Logger access$getLogger$p = Okio__JvmOkioKt.logger;
            Level level = Level.WARNING;
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Failed to close timed out socket ");
            outline73.append(this.socket);
            access$getLogger$p.log(level, outline73.toString(), e2);
        } catch (AssertionError e3) {
            if (Okio.isAndroidGetsocknameError(e3)) {
                Logger access$getLogger$p2 = Okio__JvmOkioKt.logger;
                Level level2 = Level.WARNING;
                StringBuilder outline732 = GeneratedOutlineSupport.outline73("Failed to close timed out socket ");
                outline732.append(this.socket);
                access$getLogger$p2.log(level2, outline732.toString(), e3);
                return;
            }
            throw e3;
        }
    }
}

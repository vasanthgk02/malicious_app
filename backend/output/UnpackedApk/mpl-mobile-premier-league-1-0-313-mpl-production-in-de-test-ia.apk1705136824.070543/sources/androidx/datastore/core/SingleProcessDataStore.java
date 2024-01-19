package androidx.datastore.core;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SafeFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u0000 F*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0003FGHB\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012?\b\u0002\u0010\b\u001a9\u00125\u00123\b\u0001\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00110\n0\t\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u001f\u0010+\u001a\u00020\u00102\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000-H@ø\u0001\u0000¢\u0006\u0002\u0010.J\u001f\u0010/\u001a\u00020\u00102\f\u00100\u001a\b\u0012\u0004\u0012\u00028\u000001H@ø\u0001\u0000¢\u0006\u0002\u00102J\u0011\u00103\u001a\u00020\u0010H@ø\u0001\u0000¢\u0006\u0002\u00104J\u0011\u00105\u001a\u00020\u0010H@ø\u0001\u0000¢\u0006\u0002\u00104J\u0011\u00106\u001a\u00020\u0010H@ø\u0001\u0000¢\u0006\u0002\u00104J\u0011\u00107\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u00104J\u0011\u00108\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u00104JL\u00109\u001a\u00028\u000021\u0010:\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(;\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00110\n2\u0006\u0010<\u001a\u00020=H@ø\u0001\u0000¢\u0006\u0002\u0010>JD\u0010?\u001a\u00028\u000021\u0010:\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(;\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00110\nH@ø\u0001\u0000¢\u0006\u0002\u0010@J\u001b\u0010A\u001a\u00020\u00102\u0006\u0010B\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\bC\u0010DJ\f\u0010E\u001a\u00020\u0010*\u00020\u0005H\u0002R\u000e\u0010\u0017\u001a\u00020\u0018XD¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001b0\u001aX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001dX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR \u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\"0!X\u0004¢\u0006\b\n\u0000\u0012\u0004\b#\u0010$R\u001b\u0010%\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b&\u0010'RJ\u0010*\u001a;\u00125\u00123\b\u0001\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00110\n\u0018\u00010\tX\u000eø\u0001\u0000¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006I"}, d2 = {"Landroidx/datastore/core/SingleProcessDataStore;", "T", "Landroidx/datastore/core/DataStore;", "produceFile", "Lkotlin/Function0;", "Ljava/io/File;", "serializer", "Landroidx/datastore/core/Serializer;", "initTasksList", "", "Lkotlin/Function2;", "Landroidx/datastore/core/InitializerApi;", "Lkotlin/ParameterName;", "name", "api", "Lkotlin/coroutines/Continuation;", "", "", "corruptionHandler", "Landroidx/datastore/core/CorruptionHandler;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "(Lkotlin/jvm/functions/Function0;Landroidx/datastore/core/Serializer;Ljava/util/List;Landroidx/datastore/core/CorruptionHandler;Lkotlinx/coroutines/CoroutineScope;)V", "SCRATCH_SUFFIX", "", "actor", "Landroidx/datastore/core/SimpleActor;", "Landroidx/datastore/core/SingleProcessDataStore$Message;", "data", "Lkotlinx/coroutines/flow/Flow;", "getData", "()Lkotlinx/coroutines/flow/Flow;", "downstreamFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroidx/datastore/core/State;", "getDownstreamFlow$annotations", "()V", "file", "getFile", "()Ljava/io/File;", "file$delegate", "Lkotlin/Lazy;", "initTasks", "handleRead", "read", "Landroidx/datastore/core/SingleProcessDataStore$Message$Read;", "(Landroidx/datastore/core/SingleProcessDataStore$Message$Read;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleUpdate", "update", "Landroidx/datastore/core/SingleProcessDataStore$Message$Update;", "(Landroidx/datastore/core/SingleProcessDataStore$Message$Update;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readAndInit", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readAndInitOrPropagateAndThrowFailure", "readAndInitOrPropagateFailure", "readData", "readDataOrHandleCorruption", "transformAndWrite", "transform", "t", "callerContext", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateData", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeData", "newData", "writeData$datastore_core", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createParentDirectories", "Companion", "Message", "UncloseableOutputStream", "datastore-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: SingleProcessDataStore.kt */
public final class SingleProcessDataStore<T> implements DataStore<T> {
    public static final SingleProcessDataStore Companion = null;
    public static final Set<String> activeFiles = new LinkedHashSet();
    public static final Object activeFilesLock = new Object();
    public final String SCRATCH_SUFFIX = ".tmp";
    public final SimpleActor<Message<T>> actor;
    public final CorruptionHandler<T> corruptionHandler;
    public final Flow<T> data = new SafeFlow(new SingleProcessDataStore$data$1(this, null));
    public final MutableStateFlow<State<T>> downstreamFlow = StateFlowKt.MutableStateFlow(UnInitialized.INSTANCE);
    public final Lazy file$delegate = TweetUtils.lazy((Function0<? extends T>) new SingleProcessDataStore$file$2<Object>(this));
    public List<? extends Function2<? super InitializerApi<T>, ? super Continuation<? super Unit>, ? extends Object>> initTasks;
    public final Function0<File> produceFile;
    public final CoroutineScope scope;
    public final Serializer<T> serializer;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002:\u0002\b\tB\u0007\b\u0004¢\u0006\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0001\u0002\n\u000b¨\u0006\f"}, d2 = {"Landroidx/datastore/core/SingleProcessDataStore$Message;", "T", "", "()V", "lastState", "Landroidx/datastore/core/State;", "getLastState", "()Landroidx/datastore/core/State;", "Read", "Update", "Landroidx/datastore/core/SingleProcessDataStore$Message$Read;", "Landroidx/datastore/core/SingleProcessDataStore$Message$Update;", "datastore-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: SingleProcessDataStore.kt */
    public static abstract class Message<T> {

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0015\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005R\u001c\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/datastore/core/SingleProcessDataStore$Message$Read;", "T", "Landroidx/datastore/core/SingleProcessDataStore$Message;", "lastState", "Landroidx/datastore/core/State;", "(Landroidx/datastore/core/State;)V", "getLastState", "()Landroidx/datastore/core/State;", "datastore-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
        /* compiled from: SingleProcessDataStore.kt */
        public static final class Read<T> extends Message<T> {
            public final State<T> lastState;

            public Read(State<T> state) {
                super(null);
                this.lastState = state;
            }
        }

        @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002Ba\u00121\u0010\u0003\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0004\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00020\u000b\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0002\u0018\u00010\r\u0012\u0006\u0010\u000e\u001a\u00020\u000fø\u0001\u0000¢\u0006\u0002\u0010\u0010R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0002\u0018\u00010\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016RA\u0010\u0003\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0002¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Landroidx/datastore/core/SingleProcessDataStore$Message$Update;", "T", "Landroidx/datastore/core/SingleProcessDataStore$Message;", "transform", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "t", "Lkotlin/coroutines/Continuation;", "", "ack", "Lkotlinx/coroutines/CompletableDeferred;", "lastState", "Landroidx/datastore/core/State;", "callerContext", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/jvm/functions/Function2;Lkotlinx/coroutines/CompletableDeferred;Landroidx/datastore/core/State;Lkotlin/coroutines/CoroutineContext;)V", "getAck", "()Lkotlinx/coroutines/CompletableDeferred;", "getCallerContext", "()Lkotlin/coroutines/CoroutineContext;", "getLastState", "()Landroidx/datastore/core/State;", "getTransform", "()Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function2;", "datastore-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
        /* compiled from: SingleProcessDataStore.kt */
        public static final class Update<T> extends Message<T> {
            public final CompletableDeferred<T> ack;
            public final CoroutineContext callerContext;
            public final State<T> lastState;
            public final Function2<T, Continuation<? super T>, Object> transform;

            /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
            public Update(Function2<? super T, ? super Continuation<? super T>, ? extends Object> function2, CompletableDeferred<T> completableDeferred, State<T> state, CoroutineContext coroutineContext) {
                // Intrinsics.checkNotNullParameter(function2, "transform");
                // Intrinsics.checkNotNullParameter(completableDeferred, "ack");
                // Intrinsics.checkNotNullParameter(coroutineContext, "callerContext");
                super(null);
                this.transform = function2;
                this.ack = completableDeferred;
                this.lastState = state;
                this.callerContext = coroutineContext;
            }
        }

        public Message() {
        }

        public Message(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016J \u0010\n\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u000fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Landroidx/datastore/core/SingleProcessDataStore$UncloseableOutputStream;", "Ljava/io/OutputStream;", "fileOutputStream", "Ljava/io/FileOutputStream;", "(Ljava/io/FileOutputStream;)V", "getFileOutputStream", "()Ljava/io/FileOutputStream;", "close", "", "flush", "write", "b", "", "bytes", "off", "", "len", "datastore-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: SingleProcessDataStore.kt */
    public static final class UncloseableOutputStream extends OutputStream {
        public final FileOutputStream fileOutputStream;

        public UncloseableOutputStream(FileOutputStream fileOutputStream2) {
            Intrinsics.checkNotNullParameter(fileOutputStream2, "fileOutputStream");
            this.fileOutputStream = fileOutputStream2;
        }

        public void close() {
        }

        public void flush() {
            this.fileOutputStream.flush();
        }

        public void write(int i) {
            this.fileOutputStream.write(i);
        }

        public void write(byte[] bArr) {
            Intrinsics.checkNotNullParameter(bArr, "b");
            this.fileOutputStream.write(bArr);
        }

        public void write(byte[] bArr, int i, int i2) {
            Intrinsics.checkNotNullParameter(bArr, "bytes");
            this.fileOutputStream.write(bArr, i, i2);
        }
    }

    public SingleProcessDataStore(Function0<? extends File> function0, Serializer<T> serializer2, List<? extends Function2<? super InitializerApi<T>, ? super Continuation<? super Unit>, ? extends Object>> list, CorruptionHandler<T> corruptionHandler2, CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(function0, "produceFile");
        Intrinsics.checkNotNullParameter(serializer2, "serializer");
        Intrinsics.checkNotNullParameter(list, "initTasksList");
        Intrinsics.checkNotNullParameter(corruptionHandler2, "corruptionHandler");
        Intrinsics.checkNotNullParameter(coroutineScope, "scope");
        this.produceFile = function0;
        this.serializer = serializer2;
        this.corruptionHandler = corruptionHandler2;
        this.scope = coroutineScope;
        this.initTasks = ArraysKt___ArraysJvmKt.toList(list);
        this.actor = new SimpleActor<>(this.scope, new SingleProcessDataStore$actor$1(this), SingleProcessDataStore$actor$2.INSTANCE, new SingleProcessDataStore$actor$3(this, null));
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object access$handleUpdate(androidx.datastore.core.SingleProcessDataStore r9, androidx.datastore.core.SingleProcessDataStore.Message.Update r10, kotlin.coroutines.Continuation r11) {
        /*
            r0 = 0
            if (r9 == 0) goto L_0x00d6
            boolean r1 = r11 instanceof androidx.datastore.core.SingleProcessDataStore$handleUpdate$1
            if (r1 == 0) goto L_0x0016
            r1 = r11
            androidx.datastore.core.SingleProcessDataStore$handleUpdate$1 r1 = (androidx.datastore.core.SingleProcessDataStore$handleUpdate$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0016
            int r2 = r2 - r3
            r1.label = r2
            goto L_0x001b
        L_0x0016:
            androidx.datastore.core.SingleProcessDataStore$handleUpdate$1 r1 = new androidx.datastore.core.SingleProcessDataStore$handleUpdate$1
            r1.<init>(r9, r11)
        L_0x001b:
            java.lang.Object r11 = r1.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r2 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r3 = r1.label
            r4 = 3
            r5 = 2
            r6 = 1
            if (r3 == 0) goto L_0x0051
            if (r3 == r6) goto L_0x0045
            if (r3 == r5) goto L_0x0035
            if (r3 != r4) goto L_0x002d
            goto L_0x0045
        L_0x002d:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0035:
            java.lang.Object r9 = r1.L$2
            kotlinx.coroutines.CompletableDeferred r9 = (kotlinx.coroutines.CompletableDeferred) r9
            java.lang.Object r10 = r1.L$1
            androidx.datastore.core.SingleProcessDataStore r10 = (androidx.datastore.core.SingleProcessDataStore) r10
            java.lang.Object r3 = r1.L$0
            androidx.datastore.core.SingleProcessDataStore$Message$Update r3 = (androidx.datastore.core.SingleProcessDataStore.Message.Update) r3
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r11)     // Catch:{ all -> 0x004e }
            goto L_0x0095
        L_0x0045:
            java.lang.Object r9 = r1.L$0
            kotlinx.coroutines.CompletableDeferred r9 = (kotlinx.coroutines.CompletableDeferred) r9
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r11)     // Catch:{ all -> 0x004e }
            goto L_0x00c6
        L_0x004e:
            r10 = move-exception
            goto L_0x00c2
        L_0x0051:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r11)
            kotlinx.coroutines.CompletableDeferred<T> r11 = r10.ack
            kotlinx.coroutines.flow.MutableStateFlow<androidx.datastore.core.State<T>> r3 = r9.downstreamFlow     // Catch:{ all -> 0x00bf }
            java.lang.Object r3 = r3.getValue()     // Catch:{ all -> 0x00bf }
            androidx.datastore.core.State r3 = (androidx.datastore.core.State) r3     // Catch:{ all -> 0x00bf }
            boolean r7 = r3 instanceof androidx.datastore.core.Data     // Catch:{ all -> 0x00bf }
            if (r7 == 0) goto L_0x0076
            kotlin.jvm.functions.Function2<T, kotlin.coroutines.Continuation<? super T>, java.lang.Object> r0 = r10.transform     // Catch:{ all -> 0x00bf }
            kotlin.coroutines.CoroutineContext r10 = r10.callerContext     // Catch:{ all -> 0x00bf }
            r1.L$0 = r11     // Catch:{ all -> 0x00bf }
            r1.label = r6     // Catch:{ all -> 0x00bf }
            java.lang.Object r9 = r9.transformAndWrite(r0, r10, r1)     // Catch:{ all -> 0x00bf }
            if (r9 != r2) goto L_0x0072
            goto L_0x00d5
        L_0x0072:
            r8 = r11
            r11 = r9
            r9 = r8
            goto L_0x00c6
        L_0x0076:
            boolean r7 = r3 instanceof androidx.datastore.core.ReadException     // Catch:{ all -> 0x00bf }
            if (r7 == 0) goto L_0x007b
            goto L_0x007d
        L_0x007b:
            boolean r6 = r3 instanceof androidx.datastore.core.UnInitialized     // Catch:{ all -> 0x00bf }
        L_0x007d:
            if (r6 == 0) goto L_0x00b0
            androidx.datastore.core.State<T> r6 = r10.lastState     // Catch:{ all -> 0x00bf }
            if (r3 != r6) goto L_0x00ab
            r1.L$0 = r10     // Catch:{ all -> 0x00bf }
            r1.L$1 = r9     // Catch:{ all -> 0x00bf }
            r1.L$2 = r11     // Catch:{ all -> 0x00bf }
            r1.label = r5     // Catch:{ all -> 0x00bf }
            java.lang.Object r3 = r9.readAndInitOrPropagateAndThrowFailure(r1)     // Catch:{ all -> 0x00bf }
            if (r3 != r2) goto L_0x0092
            goto L_0x00d5
        L_0x0092:
            r3 = r10
            r10 = r9
            r9 = r11
        L_0x0095:
            kotlin.jvm.functions.Function2<T, kotlin.coroutines.Continuation<? super T>, java.lang.Object> r11 = r3.transform     // Catch:{ all -> 0x00a8 }
            kotlin.coroutines.CoroutineContext r3 = r3.callerContext     // Catch:{ all -> 0x00a8 }
            r1.L$0 = r9     // Catch:{ all -> 0x00a8 }
            r1.L$1 = r0     // Catch:{ all -> 0x00a8 }
            r1.L$2 = r0     // Catch:{ all -> 0x00a8 }
            r1.label = r4     // Catch:{ all -> 0x00a8 }
            java.lang.Object r11 = r10.transformAndWrite(r11, r3, r1)     // Catch:{ all -> 0x00a8 }
            if (r11 != r2) goto L_0x00c6
            goto L_0x00d5
        L_0x00a8:
            r10 = move-exception
            r11 = r9
            goto L_0x00c1
        L_0x00ab:
            androidx.datastore.core.ReadException r3 = (androidx.datastore.core.ReadException) r3     // Catch:{ all -> 0x00bf }
            java.lang.Throwable r9 = r3.readException     // Catch:{ all -> 0x00bf }
            throw r9     // Catch:{ all -> 0x00bf }
        L_0x00b0:
            boolean r9 = r3 instanceof androidx.datastore.core.Final     // Catch:{ all -> 0x00bf }
            if (r9 == 0) goto L_0x00b9
            androidx.datastore.core.Final r3 = (androidx.datastore.core.Final) r3     // Catch:{ all -> 0x00bf }
            java.lang.Throwable r9 = r3.finalException     // Catch:{ all -> 0x00bf }
            throw r9     // Catch:{ all -> 0x00bf }
        L_0x00b9:
            kotlin.NoWhenBranchMatchedException r9 = new kotlin.NoWhenBranchMatchedException     // Catch:{ all -> 0x00bf }
            r9.<init>()     // Catch:{ all -> 0x00bf }
            throw r9     // Catch:{ all -> 0x00bf }
        L_0x00bf:
            r9 = move-exception
            r10 = r9
        L_0x00c1:
            r9 = r11
        L_0x00c2:
            java.lang.Object r11 = com.twitter.sdk.android.tweetui.TweetUtils.createFailure(r10)
        L_0x00c6:
            java.lang.Throwable r10 = kotlin.Result.m884exceptionOrNullimpl(r11)
            if (r10 != 0) goto L_0x00d0
            r9.complete(r11)
            goto L_0x00d3
        L_0x00d0:
            r9.completeExceptionally(r10)
        L_0x00d3:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
        L_0x00d5:
            return r2
        L_0x00d6:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore.access$handleUpdate(androidx.datastore.core.SingleProcessDataStore, androidx.datastore.core.SingleProcessDataStore$Message$Update, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Flow<T> getData() {
        return this.data;
    }

    public final File getFile() {
        return (File) this.file$delegate.getValue();
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0109 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object readAndInit(kotlin.coroutines.Continuation<? super kotlin.Unit> r14) {
        /*
            r13 = this;
            boolean r0 = r14 instanceof androidx.datastore.core.SingleProcessDataStore$readAndInit$1
            if (r0 == 0) goto L_0x0013
            r0 = r14
            androidx.datastore.core.SingleProcessDataStore$readAndInit$1 r0 = (androidx.datastore.core.SingleProcessDataStore$readAndInit$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.SingleProcessDataStore$readAndInit$1 r0 = new androidx.datastore.core.SingleProcessDataStore$readAndInit$1
            r0.<init>(r13, r14)
        L_0x0018:
            java.lang.Object r14 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 0
            r6 = 1
            r7 = 0
            if (r2 == 0) goto L_0x007c
            if (r2 == r6) goto L_0x0065
            if (r2 == r4) goto L_0x0048
            if (r2 != r3) goto L_0x0040
            java.lang.Object r1 = r0.L$3
            kotlinx.coroutines.sync.Mutex r1 = (kotlinx.coroutines.sync.Mutex) r1
            java.lang.Object r2 = r0.L$2
            kotlin.jvm.internal.Ref$BooleanRef r2 = (kotlin.jvm.internal.Ref$BooleanRef) r2
            java.lang.Object r3 = r0.L$1
            kotlin.jvm.internal.Ref$ObjectRef r3 = (kotlin.jvm.internal.Ref$ObjectRef) r3
            java.lang.Object r0 = r0.L$0
            androidx.datastore.core.SingleProcessDataStore r0 = (androidx.datastore.core.SingleProcessDataStore) r0
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r14)
            goto L_0x010d
        L_0x0040:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L_0x0048:
            java.lang.Object r2 = r0.L$5
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r8 = r0.L$4
            androidx.datastore.core.SingleProcessDataStore$readAndInit$api$1 r8 = (androidx.datastore.core.SingleProcessDataStore$readAndInit$api$1) r8
            java.lang.Object r9 = r0.L$3
            kotlin.jvm.internal.Ref$BooleanRef r9 = (kotlin.jvm.internal.Ref$BooleanRef) r9
            java.lang.Object r10 = r0.L$2
            kotlin.jvm.internal.Ref$ObjectRef r10 = (kotlin.jvm.internal.Ref$ObjectRef) r10
            java.lang.Object r11 = r0.L$1
            kotlinx.coroutines.sync.Mutex r11 = (kotlinx.coroutines.sync.Mutex) r11
            java.lang.Object r12 = r0.L$0
            androidx.datastore.core.SingleProcessDataStore r12 = (androidx.datastore.core.SingleProcessDataStore) r12
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r14)
            goto L_0x00d2
        L_0x0065:
            java.lang.Object r2 = r0.L$3
            kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref$ObjectRef) r2
            java.lang.Object r8 = r0.L$2
            kotlin.jvm.internal.Ref$ObjectRef r8 = (kotlin.jvm.internal.Ref$ObjectRef) r8
            java.lang.Object r9 = r0.L$1
            kotlinx.coroutines.sync.Mutex r9 = (kotlinx.coroutines.sync.Mutex) r9
            java.lang.Object r10 = r0.L$0
            androidx.datastore.core.SingleProcessDataStore r10 = (androidx.datastore.core.SingleProcessDataStore) r10
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r14)
            r11 = r9
            r12 = r10
            r10 = r8
            goto L_0x00bc
        L_0x007c:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r14)
            kotlinx.coroutines.flow.MutableStateFlow<androidx.datastore.core.State<T>> r14 = r13.downstreamFlow
            java.lang.Object r14 = r14.getValue()
            androidx.datastore.core.UnInitialized r2 = androidx.datastore.core.UnInitialized.INSTANCE
            boolean r14 = kotlin.jvm.internal.Intrinsics.areEqual(r14, r2)
            if (r14 != 0) goto L_0x009a
            kotlinx.coroutines.flow.MutableStateFlow<androidx.datastore.core.State<T>> r14 = r13.downstreamFlow
            java.lang.Object r14 = r14.getValue()
            boolean r14 = r14 instanceof androidx.datastore.core.ReadException
            if (r14 == 0) goto L_0x0098
            goto L_0x009a
        L_0x0098:
            r14 = 0
            goto L_0x009b
        L_0x009a:
            r14 = 1
        L_0x009b:
            if (r14 == 0) goto L_0x012c
            kotlinx.coroutines.sync.MutexImpl r14 = new kotlinx.coroutines.sync.MutexImpl
            r14.<init>(r7)
            kotlin.jvm.internal.Ref$ObjectRef r2 = new kotlin.jvm.internal.Ref$ObjectRef
            r2.<init>()
            r0.L$0 = r13
            r0.L$1 = r14
            r0.L$2 = r2
            r0.L$3 = r2
            r0.label = r6
            java.lang.Object r8 = r13.readDataOrHandleCorruption(r0)
            if (r8 != r1) goto L_0x00b8
            return r1
        L_0x00b8:
            r12 = r13
            r11 = r14
            r10 = r2
            r14 = r8
        L_0x00bc:
            r2.element = r14
            kotlin.jvm.internal.Ref$BooleanRef r9 = new kotlin.jvm.internal.Ref$BooleanRef
            r9.<init>()
            androidx.datastore.core.SingleProcessDataStore$readAndInit$api$1 r8 = new androidx.datastore.core.SingleProcessDataStore$readAndInit$api$1
            r8.<init>(r11, r9, r10, r12)
            java.util.List<? extends kotlin.jvm.functions.Function2<? super androidx.datastore.core.InitializerApi<T>, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>> r14 = r12.initTasks
            if (r14 != 0) goto L_0x00ce
        L_0x00cc:
            r2 = r9
            goto L_0x00f3
        L_0x00ce:
            java.util.Iterator r2 = r14.iterator()
        L_0x00d2:
            boolean r14 = r2.hasNext()
            if (r14 == 0) goto L_0x00cc
            java.lang.Object r14 = r2.next()
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            r0.L$0 = r12
            r0.L$1 = r11
            r0.L$2 = r10
            r0.L$3 = r9
            r0.L$4 = r8
            r0.L$5 = r2
            r0.label = r4
            java.lang.Object r14 = r14.invoke(r8, r0)
            if (r14 != r1) goto L_0x00d2
            return r1
        L_0x00f3:
            r12.initTasks = r5
            r0.L$0 = r12
            r0.L$1 = r10
            r0.L$2 = r2
            r0.L$3 = r11
            r0.L$4 = r5
            r0.L$5 = r5
            r0.label = r3
            java.lang.Object r14 = r11.lock(r5, r0)
            if (r14 != r1) goto L_0x010a
            return r1
        L_0x010a:
            r3 = r10
            r1 = r11
            r0 = r12
        L_0x010d:
            r2.element = r6     // Catch:{ all -> 0x0127 }
            r1.unlock(r5)
            kotlinx.coroutines.flow.MutableStateFlow<androidx.datastore.core.State<T>> r14 = r0.downstreamFlow
            androidx.datastore.core.Data r0 = new androidx.datastore.core.Data
            T r1 = r3.element
            if (r1 == 0) goto L_0x011e
            int r7 = r1.hashCode()
        L_0x011e:
            r0.<init>(r1, r7)
            r14.setValue(r0)
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        L_0x0127:
            r14 = move-exception
            r1.unlock(r5)
            throw r14
        L_0x012c:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "Check failed."
            java.lang.String r0 = r0.toString()
            r14.<init>(r0)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore.readAndInit(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object readAndInitOrPropagateAndThrowFailure(kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateAndThrowFailure$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateAndThrowFailure$1 r0 = (androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateAndThrowFailure$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateAndThrowFailure$1 r0 = new androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateAndThrowFailure$1
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r0 = r0.L$0
            androidx.datastore.core.SingleProcessDataStore r0 = (androidx.datastore.core.SingleProcessDataStore) r0
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r5)     // Catch:{ all -> 0x002b }
            goto L_0x0043
        L_0x002b:
            r5 = move-exception
            goto L_0x0048
        L_0x002d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0035:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r5)
            r0.L$0 = r4     // Catch:{ all -> 0x0046 }
            r0.label = r3     // Catch:{ all -> 0x0046 }
            java.lang.Object r5 = r4.readAndInit(r0)     // Catch:{ all -> 0x0046 }
            if (r5 != r1) goto L_0x0043
            return r1
        L_0x0043:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L_0x0046:
            r5 = move-exception
            r0 = r4
        L_0x0048:
            kotlinx.coroutines.flow.MutableStateFlow<androidx.datastore.core.State<T>> r0 = r0.downstreamFlow
            androidx.datastore.core.ReadException r1 = new androidx.datastore.core.ReadException
            r1.<init>(r5)
            r0.setValue(r1)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore.readAndInitOrPropagateAndThrowFailure(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object readAndInitOrPropagateFailure(kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateFailure$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateFailure$1 r0 = (androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateFailure$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateFailure$1 r0 = new androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateFailure$1
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r0 = r0.L$0
            androidx.datastore.core.SingleProcessDataStore r0 = (androidx.datastore.core.SingleProcessDataStore) r0
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r5)     // Catch:{ all -> 0x002b }
            goto L_0x004f
        L_0x002b:
            r5 = move-exception
            goto L_0x0045
        L_0x002d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0035:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r5)
            r0.L$0 = r4     // Catch:{ all -> 0x0043 }
            r0.label = r3     // Catch:{ all -> 0x0043 }
            java.lang.Object r5 = r4.readAndInit(r0)     // Catch:{ all -> 0x0043 }
            if (r5 != r1) goto L_0x004f
            return r1
        L_0x0043:
            r5 = move-exception
            r0 = r4
        L_0x0045:
            kotlinx.coroutines.flow.MutableStateFlow<androidx.datastore.core.State<T>> r0 = r0.downstreamFlow
            androidx.datastore.core.ReadException r1 = new androidx.datastore.core.ReadException
            r1.<init>(r5)
            r0.setValue(r1)
        L_0x004f:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore.readAndInitOrPropagateFailure(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0062, code lost:
        r6 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0067, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r2, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x006b, code lost:
        throw r1;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:24:0x005e, B:30:0x0066] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object readData(kotlin.coroutines.Continuation<? super T> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof androidx.datastore.core.SingleProcessDataStore$readData$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            androidx.datastore.core.SingleProcessDataStore$readData$1 r0 = (androidx.datastore.core.SingleProcessDataStore$readData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.SingleProcessDataStore$readData$1 r0 = new androidx.datastore.core.SingleProcessDataStore$readData$1
            r0.<init>(r5, r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 != r3) goto L_0x0035
            java.lang.Object r1 = r0.L$2
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            java.lang.Object r2 = r0.L$1
            java.io.Closeable r2 = (java.io.Closeable) r2
            java.lang.Object r0 = r0.L$0
            androidx.datastore.core.SingleProcessDataStore r0 = (androidx.datastore.core.SingleProcessDataStore) r0
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r6)     // Catch:{ all -> 0x0033 }
            goto L_0x005e
        L_0x0033:
            r6 = move-exception
            goto L_0x0066
        L_0x0035:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x003d:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r6)
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x006c }
            java.io.File r6 = r5.getFile()     // Catch:{ FileNotFoundException -> 0x006c }
            r2.<init>(r6)     // Catch:{ FileNotFoundException -> 0x006c }
            r6 = 0
            androidx.datastore.core.Serializer<T> r4 = r5.serializer     // Catch:{ all -> 0x0064 }
            r0.L$0 = r5     // Catch:{ all -> 0x0064 }
            r0.L$1 = r2     // Catch:{ all -> 0x0064 }
            r0.L$2 = r6     // Catch:{ all -> 0x0064 }
            r0.label = r3     // Catch:{ all -> 0x0064 }
            java.lang.Object r0 = r4.readFrom(r2, r0)     // Catch:{ all -> 0x0064 }
            if (r0 != r1) goto L_0x005b
            return r1
        L_0x005b:
            r1 = r6
            r6 = r0
            r0 = r5
        L_0x005e:
            com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r2, r1)     // Catch:{ FileNotFoundException -> 0x0062 }
            return r6
        L_0x0062:
            r6 = move-exception
            goto L_0x006e
        L_0x0064:
            r6 = move-exception
            r0 = r5
        L_0x0066:
            throw r6     // Catch:{ all -> 0x0067 }
        L_0x0067:
            r1 = move-exception
            com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r2, r6)     // Catch:{ FileNotFoundException -> 0x0062 }
            throw r1     // Catch:{ FileNotFoundException -> 0x0062 }
        L_0x006c:
            r6 = move-exception
            r0 = r5
        L_0x006e:
            java.io.File r1 = r0.getFile()
            boolean r1 = r1.exists()
            if (r1 != 0) goto L_0x007f
            androidx.datastore.core.Serializer<T> r6 = r0.serializer
            java.lang.Object r6 = r6.getDefaultValue()
            return r6
        L_0x007f:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore.readData(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0083 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object readDataOrHandleCorruption(kotlin.coroutines.Continuation<? super T> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof androidx.datastore.core.SingleProcessDataStore$readDataOrHandleCorruption$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            androidx.datastore.core.SingleProcessDataStore$readDataOrHandleCorruption$1 r0 = (androidx.datastore.core.SingleProcessDataStore$readDataOrHandleCorruption$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.SingleProcessDataStore$readDataOrHandleCorruption$1 r0 = new androidx.datastore.core.SingleProcessDataStore$readDataOrHandleCorruption$1
            r0.<init>(r7, r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0053
            if (r2 == r5) goto L_0x0049
            if (r2 == r4) goto L_0x003d
            if (r2 != r3) goto L_0x0035
            java.lang.Object r1 = r0.L$1
            java.lang.Object r0 = r0.L$0
            androidx.datastore.core.CorruptionException r0 = (androidx.datastore.core.CorruptionException) r0
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r8)     // Catch:{ IOException -> 0x0033 }
            goto L_0x0085
        L_0x0033:
            r8 = move-exception
            goto L_0x0088
        L_0x0035:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x003d:
            java.lang.Object r2 = r0.L$1
            androidx.datastore.core.CorruptionException r2 = (androidx.datastore.core.CorruptionException) r2
            java.lang.Object r4 = r0.L$0
            androidx.datastore.core.SingleProcessDataStore r4 = (androidx.datastore.core.SingleProcessDataStore) r4
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r8)
            goto L_0x0077
        L_0x0049:
            java.lang.Object r2 = r0.L$0
            androidx.datastore.core.SingleProcessDataStore r2 = (androidx.datastore.core.SingleProcessDataStore) r2
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r8)     // Catch:{ CorruptionException -> 0x0051 }
            goto L_0x0061
        L_0x0051:
            r8 = move-exception
            goto L_0x0064
        L_0x0053:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r8)
            r0.L$0 = r7     // Catch:{ CorruptionException -> 0x0062 }
            r0.label = r5     // Catch:{ CorruptionException -> 0x0062 }
            java.lang.Object r8 = r7.readData(r0)     // Catch:{ CorruptionException -> 0x0062 }
            if (r8 != r1) goto L_0x0061
            return r1
        L_0x0061:
            return r8
        L_0x0062:
            r8 = move-exception
            r2 = r7
        L_0x0064:
            androidx.datastore.core.CorruptionHandler<T> r5 = r2.corruptionHandler
            r0.L$0 = r2
            r0.L$1 = r8
            r0.label = r4
            java.lang.Object r4 = r5.handleCorruption(r8, r0)
            if (r4 != r1) goto L_0x0073
            return r1
        L_0x0073:
            r6 = r2
            r2 = r8
            r8 = r4
            r4 = r6
        L_0x0077:
            r0.L$0 = r2     // Catch:{ IOException -> 0x0086 }
            r0.L$1 = r8     // Catch:{ IOException -> 0x0086 }
            r0.label = r3     // Catch:{ IOException -> 0x0086 }
            java.lang.Object r0 = r4.writeData$datastore_core(r8, r0)     // Catch:{ IOException -> 0x0086 }
            if (r0 != r1) goto L_0x0084
            return r1
        L_0x0084:
            r1 = r8
        L_0x0085:
            return r1
        L_0x0086:
            r8 = move-exception
            r0 = r2
        L_0x0088:
            com.twitter.sdk.android.tweetui.TweetUtils.addSuppressed(r0, r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore.readDataOrHandleCorruption(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object transformAndWrite(kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> r8, kotlin.coroutines.CoroutineContext r9, kotlin.coroutines.Continuation<? super T> r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof androidx.datastore.core.SingleProcessDataStore$transformAndWrite$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            androidx.datastore.core.SingleProcessDataStore$transformAndWrite$1 r0 = (androidx.datastore.core.SingleProcessDataStore$transformAndWrite$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.SingleProcessDataStore$transformAndWrite$1 r0 = new androidx.datastore.core.SingleProcessDataStore$transformAndWrite$1
            r0.<init>(r7, r10)
        L_0x0018:
            java.lang.Object r10 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0047
            if (r2 == r5) goto L_0x0039
            if (r2 != r4) goto L_0x0031
            java.lang.Object r8 = r0.L$1
            java.lang.Object r9 = r0.L$0
            androidx.datastore.core.SingleProcessDataStore r9 = (androidx.datastore.core.SingleProcessDataStore) r9
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r10)
            goto L_0x008a
        L_0x0031:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0039:
            java.lang.Object r8 = r0.L$2
            java.lang.Object r9 = r0.L$1
            androidx.datastore.core.Data r9 = (androidx.datastore.core.Data) r9
            java.lang.Object r2 = r0.L$0
            androidx.datastore.core.SingleProcessDataStore r2 = (androidx.datastore.core.SingleProcessDataStore) r2
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r10)
            goto L_0x006f
        L_0x0047:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r10)
            kotlinx.coroutines.flow.MutableStateFlow<androidx.datastore.core.State<T>> r10 = r7.downstreamFlow
            java.lang.Object r10 = r10.getValue()
            androidx.datastore.core.Data r10 = (androidx.datastore.core.Data) r10
            r10.checkHashCode()
            T r2 = r10.value
            androidx.datastore.core.SingleProcessDataStore$transformAndWrite$newData$1 r6 = new androidx.datastore.core.SingleProcessDataStore$transformAndWrite$newData$1
            r6.<init>(r8, r2, r3)
            r0.L$0 = r7
            r0.L$1 = r10
            r0.L$2 = r2
            r0.label = r5
            java.lang.Object r8 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.withContext(r9, r6, r0)
            if (r8 != r1) goto L_0x006b
            return r1
        L_0x006b:
            r9 = r10
            r10 = r8
            r8 = r2
            r2 = r7
        L_0x006f:
            r9.checkHashCode()
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual(r8, r10)
            if (r9 == 0) goto L_0x0079
            goto L_0x009c
        L_0x0079:
            r0.L$0 = r2
            r0.L$1 = r10
            r0.L$2 = r3
            r0.label = r4
            java.lang.Object r8 = r2.writeData$datastore_core(r10, r0)
            if (r8 != r1) goto L_0x0088
            return r1
        L_0x0088:
            r8 = r10
            r9 = r2
        L_0x008a:
            kotlinx.coroutines.flow.MutableStateFlow<androidx.datastore.core.State<T>> r9 = r9.downstreamFlow
            androidx.datastore.core.Data r10 = new androidx.datastore.core.Data
            if (r8 == 0) goto L_0x0095
            int r0 = r8.hashCode()
            goto L_0x0096
        L_0x0095:
            r0 = 0
        L_0x0096:
            r10.<init>(r8, r0)
            r9.setValue(r10)
        L_0x009c:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore.transformAndWrite(kotlin.jvm.functions.Function2, kotlin.coroutines.CoroutineContext, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Object updateData(Function2<? super T, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        CompletableDeferredImpl completableDeferredImpl = new CompletableDeferredImpl(null);
        this.actor.offer(new Update(function2, completableDeferredImpl, (State) this.downstreamFlow.getValue(), continuation.getContext()));
        Object awaitInternal$kotlinx_coroutines_core = completableDeferredImpl.awaitInternal$kotlinx_coroutines_core(continuation);
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return awaitInternal$kotlinx_coroutines_core;
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r8v4, types: [java.io.FileOutputStream] */
    /* JADX WARNING: type inference failed for: r2v2, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r2v8, types: [java.io.FileOutputStream, java.lang.Object] */
    /* JADX WARNING: type inference failed for: r8v13 */
    /* JADX WARNING: type inference failed for: r2v10 */
    /* JADX WARNING: type inference failed for: r8v18, types: [java.io.FileOutputStream] */
    /* JADX WARNING: type inference failed for: r2v12, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r2v13 */
    /* JADX WARNING: type inference failed for: r2v14 */
    /* JADX WARNING: type inference failed for: r2v15 */
    /* JADX WARNING: type inference failed for: r2v16 */
    /* JADX WARNING: type inference failed for: r2v17 */
    /* JADX WARNING: type inference failed for: r8v19 */
    /* JADX WARNING: type inference failed for: r2v18 */
    /* JADX WARNING: type inference failed for: r2v19 */
    /* JADX WARNING: type inference failed for: r2v20 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r2v10
      assigns: []
      uses: []
      mth insns count: 100
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00af A[SYNTHETIC, Splitter:B:35:0x00af] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARNING: Unknown variable types count: 7 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object writeData$datastore_core(T r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof androidx.datastore.core.SingleProcessDataStore$writeData$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            androidx.datastore.core.SingleProcessDataStore$writeData$1 r0 = (androidx.datastore.core.SingleProcessDataStore$writeData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.SingleProcessDataStore$writeData$1 r0 = new androidx.datastore.core.SingleProcessDataStore$writeData$1
            r0.<init>(r7, r9)
        L_0x0018:
            java.lang.Object r9 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0046
            if (r2 != r3) goto L_0x003e
            java.lang.Object r8 = r0.L$4
            java.io.FileOutputStream r8 = (java.io.FileOutputStream) r8
            java.lang.Object r1 = r0.L$3
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            java.lang.Object r2 = r0.L$2
            java.io.Closeable r2 = (java.io.Closeable) r2
            java.lang.Object r3 = r0.L$1
            java.io.File r3 = (java.io.File) r3
            java.lang.Object r0 = r0.L$0
            androidx.datastore.core.SingleProcessDataStore r0 = (androidx.datastore.core.SingleProcessDataStore) r0
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r9)     // Catch:{ all -> 0x003b }
            goto L_0x0098
        L_0x003b:
            r8 = move-exception
            goto L_0x00ce
        L_0x003e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0046:
            com.twitter.sdk.android.tweetui.TweetUtils.throwOnFailure(r9)
            java.io.File r9 = r7.getFile()
            java.io.File r2 = r9.getCanonicalFile()
            java.io.File r2 = r2.getParentFile()
            if (r2 != 0) goto L_0x0058
            goto L_0x0061
        L_0x0058:
            r2.mkdirs()
            boolean r2 = r2.isDirectory()
            if (r2 == 0) goto L_0x00e2
        L_0x0061:
            java.io.File r9 = new java.io.File
            java.io.File r2 = r7.getFile()
            java.lang.String r2 = r2.getAbsolutePath()
            java.lang.String r4 = r7.SCRATCH_SUFFIX
            java.lang.String r2 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r4)
            r9.<init>(r2)
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x00d7 }
            r2.<init>(r9)     // Catch:{ IOException -> 0x00d7 }
            r4 = 0
            androidx.datastore.core.Serializer<T> r5 = r7.serializer     // Catch:{ all -> 0x00d0 }
            androidx.datastore.core.SingleProcessDataStore$UncloseableOutputStream r6 = new androidx.datastore.core.SingleProcessDataStore$UncloseableOutputStream     // Catch:{ all -> 0x00d0 }
            r6.<init>(r2)     // Catch:{ all -> 0x00d0 }
            r0.L$0 = r7     // Catch:{ all -> 0x00d0 }
            r0.L$1 = r9     // Catch:{ all -> 0x00d0 }
            r0.L$2 = r2     // Catch:{ all -> 0x00d0 }
            r0.L$3 = r4     // Catch:{ all -> 0x00d0 }
            r0.L$4 = r2     // Catch:{ all -> 0x00d0 }
            r0.label = r3     // Catch:{ all -> 0x00d0 }
            java.lang.Object r8 = r5.writeTo(r8, r6, r0)     // Catch:{ all -> 0x00d0 }
            if (r8 != r1) goto L_0x0094
            return r1
        L_0x0094:
            r0 = r7
            r3 = r9
            r8 = r2
            r1 = r4
        L_0x0098:
            java.io.FileDescriptor r8 = r8.getFD()     // Catch:{ all -> 0x003b }
            r8.sync()     // Catch:{ all -> 0x003b }
            com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r2, r1)     // Catch:{ IOException -> 0x00cb }
            java.io.File r8 = r0.getFile()     // Catch:{ IOException -> 0x00cb }
            boolean r8 = r3.renameTo(r8)     // Catch:{ IOException -> 0x00cb }
            if (r8 == 0) goto L_0x00af
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L_0x00af:
            java.io.IOException r8 = new java.io.IOException     // Catch:{ IOException -> 0x00cb }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00cb }
            r9.<init>()     // Catch:{ IOException -> 0x00cb }
            java.lang.String r0 = "Unable to rename "
            r9.append(r0)     // Catch:{ IOException -> 0x00cb }
            r9.append(r3)     // Catch:{ IOException -> 0x00cb }
            java.lang.String r0 = ".This likely means that there are multiple instances of DataStore for this file. Ensure that you are only creating a single instance of datastore for this file."
            r9.append(r0)     // Catch:{ IOException -> 0x00cb }
            java.lang.String r9 = r9.toString()     // Catch:{ IOException -> 0x00cb }
            r8.<init>(r9)     // Catch:{ IOException -> 0x00cb }
            throw r8     // Catch:{ IOException -> 0x00cb }
        L_0x00cb:
            r8 = move-exception
            r9 = r3
            goto L_0x00d8
        L_0x00ce:
            r9 = r3
            goto L_0x00d1
        L_0x00d0:
            r8 = move-exception
        L_0x00d1:
            throw r8     // Catch:{ all -> 0x00d2 }
        L_0x00d2:
            r0 = move-exception
            com.twitter.sdk.android.tweetui.TweetUtils.closeFinally(r2, r8)     // Catch:{ IOException -> 0x00d7 }
            throw r0     // Catch:{ IOException -> 0x00d7 }
        L_0x00d7:
            r8 = move-exception
        L_0x00d8:
            boolean r0 = r9.exists()
            if (r0 == 0) goto L_0x00e1
            r9.delete()
        L_0x00e1:
            throw r8
        L_0x00e2:
            java.io.IOException r8 = new java.io.IOException
            java.lang.String r0 = "Unable to create parent directories of "
            java.lang.String r9 = kotlin.jvm.internal.Intrinsics.stringPlus(r0, r9)
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore.writeData$datastore_core(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}

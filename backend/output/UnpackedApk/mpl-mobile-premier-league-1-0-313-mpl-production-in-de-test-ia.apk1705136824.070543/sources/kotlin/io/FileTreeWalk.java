package kotlin.io;

import com.razorpay.AnalyticsConstants;
import com.swmansion.gesturehandler.react.RNGestureHandlerModule;
import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin._Assertions;
import kotlin.collections.AbstractIterator;
import kotlin.collections.State;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001a\u001b\u001cB\u0019\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0001\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b\u00128\u0010\f\u001a4\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010\u0015J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017H\u0002J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0014J\u001a\u0010\u0007\u001a\u00020\u00002\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\bJ \u0010\f\u001a\u00020\u00002\u0018\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000b0\rJ\u001a\u0010\n\u001a\u00020\u00002\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000R@\u0010\f\u001a4\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u000b\u0018\u00010\rX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lkotlin/io/FileTreeWalk;", "Lkotlin/sequences/Sequence;", "Ljava/io/File;", "start", "direction", "Lkotlin/io/FileWalkDirection;", "(Ljava/io/File;Lkotlin/io/FileWalkDirection;)V", "onEnter", "Lkotlin/Function1;", "", "onLeave", "", "onFail", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "f", "Ljava/io/IOException;", "e", "maxDepth", "", "(Ljava/io/File;Lkotlin/io/FileWalkDirection;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;I)V", "iterator", "", "depth", "function", "DirectoryState", "FileTreeWalkIterator", "WalkState", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: FileTreeWalk.kt */
public final class FileTreeWalk implements Sequence<File> {
    public final FileWalkDirection direction;
    public final int maxDepth = Integer.MAX_VALUE;
    public final Function1<File, Boolean> onEnter = null;
    public final Function2<File, IOException, Unit> onFail = null;
    public final Function1<File, Unit> onLeave = null;
    public final File start;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\"\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lkotlin/io/FileTreeWalk$DirectoryState;", "Lkotlin/io/FileTreeWalk$WalkState;", "rootDir", "Ljava/io/File;", "(Ljava/io/File;)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: FileTreeWalk.kt */
    public static abstract class DirectoryState extends WalkState {
        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        public DirectoryState(File file) {
            // Intrinsics.checkNotNullParameter(file, "rootDir");
            super(file);
            if (_Assertions.ENABLED) {
                boolean isDirectory = file.isDirectory();
                if (_Assertions.ENABLED && !isDirectory) {
                    throw new AssertionError("rootDir must be verified to be directory beforehand.");
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\r\u000e\u000fB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0014J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0010R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lkotlin/io/FileTreeWalk$FileTreeWalkIterator;", "Lkotlin/collections/AbstractIterator;", "Ljava/io/File;", "(Lkotlin/io/FileTreeWalk;)V", "state", "Ljava/util/ArrayDeque;", "Lkotlin/io/FileTreeWalk$WalkState;", "computeNext", "", "directoryState", "Lkotlin/io/FileTreeWalk$DirectoryState;", "root", "gotoNext", "BottomUpDirectoryState", "SingleFileState", "TopDownDirectoryState", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: FileTreeWalk.kt */
    public final class FileTreeWalkIterator extends AbstractIterator<File> {
        public final ArrayDeque<WalkState> state = new ArrayDeque<>();

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\r\u001a\u0004\u0018\u00010\u0003H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nX\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkotlin/io/FileTreeWalk$FileTreeWalkIterator$BottomUpDirectoryState;", "Lkotlin/io/FileTreeWalk$DirectoryState;", "rootDir", "Ljava/io/File;", "(Lkotlin/io/FileTreeWalk$FileTreeWalkIterator;Ljava/io/File;)V", "failed", "", "fileIndex", "", "fileList", "", "[Ljava/io/File;", "rootVisited", "step", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: FileTreeWalk.kt */
        public final class BottomUpDirectoryState extends DirectoryState {
            public boolean failed;
            public int fileIndex;
            public File[] fileList;
            public boolean rootVisited;
            public final /* synthetic */ FileTreeWalkIterator this$0;

            /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
            public BottomUpDirectoryState(FileTreeWalkIterator fileTreeWalkIterator, File file) {
                // Intrinsics.checkNotNullParameter(file, "rootDir");
                // this.this$0 = fileTreeWalkIterator;
                super(file);
            }

            public File step() {
                if (!this.failed && this.fileList == null) {
                    Function1<File, Boolean> function1 = FileTreeWalk.this.onEnter;
                    boolean z = false;
                    if (function1 != null && !((Boolean) function1.invoke(this.root)).booleanValue()) {
                        z = true;
                    }
                    if (z) {
                        return null;
                    }
                    File[] listFiles = this.root.listFiles();
                    this.fileList = listFiles;
                    if (listFiles == null) {
                        Function2<File, IOException, Unit> function2 = FileTreeWalk.this.onFail;
                        if (function2 != null) {
                            function2.invoke(this.root, new AccessDeniedException(this.root, null, "Cannot list files in a directory", 2));
                        }
                        this.failed = true;
                    }
                }
                File[] fileArr = this.fileList;
                if (fileArr != null) {
                    int i = this.fileIndex;
                    Intrinsics.checkNotNull(fileArr);
                    if (i < fileArr.length) {
                        File[] fileArr2 = this.fileList;
                        Intrinsics.checkNotNull(fileArr2);
                        int i2 = this.fileIndex;
                        this.fileIndex = i2 + 1;
                        return fileArr2[i2];
                    }
                }
                if (!this.rootVisited) {
                    this.rootVisited = true;
                    return this.root;
                }
                Function1<File, Unit> function12 = FileTreeWalk.this.onLeave;
                if (function12 != null) {
                    function12.invoke(this.root);
                }
                return null;
            }
        }

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lkotlin/io/FileTreeWalk$FileTreeWalkIterator$SingleFileState;", "Lkotlin/io/FileTreeWalk$WalkState;", "rootFile", "Ljava/io/File;", "(Lkotlin/io/FileTreeWalk$FileTreeWalkIterator;Ljava/io/File;)V", "visited", "", "step", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: FileTreeWalk.kt */
        public final class SingleFileState extends WalkState {
            public final /* synthetic */ FileTreeWalkIterator this$0;
            public boolean visited;

            /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
            public SingleFileState(FileTreeWalkIterator fileTreeWalkIterator, File file) {
                // Intrinsics.checkNotNullParameter(file, "rootFile");
                // this.this$0 = fileTreeWalkIterator;
                super(file);
                if (_Assertions.ENABLED) {
                    boolean isFile = file.isFile();
                    if (_Assertions.ENABLED && !isFile) {
                        throw new AssertionError("rootFile must be verified to be file beforehand.");
                    }
                }
            }

            public File step() {
                if (this.visited) {
                    return null;
                }
                this.visited = true;
                return this.root;
            }
        }

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bX\u000e¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkotlin/io/FileTreeWalk$FileTreeWalkIterator$TopDownDirectoryState;", "Lkotlin/io/FileTreeWalk$DirectoryState;", "rootDir", "Ljava/io/File;", "(Lkotlin/io/FileTreeWalk$FileTreeWalkIterator;Ljava/io/File;)V", "fileIndex", "", "fileList", "", "[Ljava/io/File;", "rootVisited", "", "step", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: FileTreeWalk.kt */
        public final class TopDownDirectoryState extends DirectoryState {
            public int fileIndex;
            public File[] fileList;
            public boolean rootVisited;
            public final /* synthetic */ FileTreeWalkIterator this$0;

            /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
            public TopDownDirectoryState(FileTreeWalkIterator fileTreeWalkIterator, File file) {
                // Intrinsics.checkNotNullParameter(file, "rootDir");
                // this.this$0 = fileTreeWalkIterator;
                super(file);
            }

            /* JADX WARNING: Code restructure failed: missing block: B:29:0x006e, code lost:
                if (r0.length == 0) goto L_0x0070;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.io.File step() {
                /*
                    r7 = this;
                    boolean r0 = r7.rootVisited
                    r1 = 0
                    if (r0 != 0) goto L_0x0026
                    kotlin.io.FileTreeWalk$FileTreeWalkIterator r0 = r7.this$0
                    kotlin.io.FileTreeWalk r0 = kotlin.io.FileTreeWalk.this
                    kotlin.jvm.functions.Function1<java.io.File, java.lang.Boolean> r0 = r0.onEnter
                    r2 = 0
                    r3 = 1
                    if (r0 == 0) goto L_0x001e
                    java.io.File r4 = r7.root
                    java.lang.Object r0 = r0.invoke(r4)
                    java.lang.Boolean r0 = (java.lang.Boolean) r0
                    boolean r0 = r0.booleanValue()
                    if (r0 != 0) goto L_0x001e
                    r2 = 1
                L_0x001e:
                    if (r2 == 0) goto L_0x0021
                    return r1
                L_0x0021:
                    r7.rootVisited = r3
                    java.io.File r0 = r7.root
                    return r0
                L_0x0026:
                    java.io.File[] r0 = r7.fileList
                    if (r0 == 0) goto L_0x0041
                    int r2 = r7.fileIndex
                    kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
                    int r0 = r0.length
                    if (r2 >= r0) goto L_0x0033
                    goto L_0x0041
                L_0x0033:
                    kotlin.io.FileTreeWalk$FileTreeWalkIterator r0 = r7.this$0
                    kotlin.io.FileTreeWalk r0 = kotlin.io.FileTreeWalk.this
                    kotlin.jvm.functions.Function1<java.io.File, kotlin.Unit> r0 = r0.onLeave
                    if (r0 == 0) goto L_0x0040
                    java.io.File r2 = r7.root
                    r0.invoke(r2)
                L_0x0040:
                    return r1
                L_0x0041:
                    java.io.File[] r0 = r7.fileList
                    if (r0 != 0) goto L_0x007e
                    java.io.File r0 = r7.root
                    java.io.File[] r0 = r0.listFiles()
                    r7.fileList = r0
                    if (r0 != 0) goto L_0x0066
                    kotlin.io.FileTreeWalk$FileTreeWalkIterator r0 = r7.this$0
                    kotlin.io.FileTreeWalk r0 = kotlin.io.FileTreeWalk.this
                    kotlin.jvm.functions.Function2<java.io.File, java.io.IOException, kotlin.Unit> r0 = r0.onFail
                    if (r0 == 0) goto L_0x0066
                    java.io.File r2 = r7.root
                    kotlin.io.AccessDeniedException r3 = new kotlin.io.AccessDeniedException
                    java.io.File r4 = r7.root
                    r5 = 2
                    java.lang.String r6 = "Cannot list files in a directory"
                    r3.<init>(r4, r1, r6, r5)
                    r0.invoke(r2, r3)
                L_0x0066:
                    java.io.File[] r0 = r7.fileList
                    if (r0 == 0) goto L_0x0070
                    kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
                    int r0 = r0.length
                    if (r0 != 0) goto L_0x007e
                L_0x0070:
                    kotlin.io.FileTreeWalk$FileTreeWalkIterator r0 = r7.this$0
                    kotlin.io.FileTreeWalk r0 = kotlin.io.FileTreeWalk.this
                    kotlin.jvm.functions.Function1<java.io.File, kotlin.Unit> r0 = r0.onLeave
                    if (r0 == 0) goto L_0x007d
                    java.io.File r2 = r7.root
                    r0.invoke(r2)
                L_0x007d:
                    return r1
                L_0x007e:
                    java.io.File[] r0 = r7.fileList
                    kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
                    int r1 = r7.fileIndex
                    int r2 = r1 + 1
                    r7.fileIndex = r2
                    r0 = r0[r1]
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.io.FileTreeWalk.FileTreeWalkIterator.TopDownDirectoryState.step():java.io.File");
            }
        }

        public FileTreeWalkIterator() {
            if (FileTreeWalk.this.start.isDirectory()) {
                this.state.push(directoryState(FileTreeWalk.this.start));
            } else if (FileTreeWalk.this.start.isFile()) {
                this.state.push(new SingleFileState(this, FileTreeWalk.this.start));
            } else {
                this.state = State.Done;
            }
        }

        public final DirectoryState directoryState(File file) {
            int ordinal = FileTreeWalk.this.direction.ordinal();
            if (ordinal == 0) {
                return new TopDownDirectoryState(this, file);
            }
            if (ordinal == 1) {
                return new BottomUpDirectoryState(this, file);
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\"\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0003H&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lkotlin/io/FileTreeWalk$WalkState;", "", "root", "Ljava/io/File;", "(Ljava/io/File;)V", "getRoot", "()Ljava/io/File;", "step", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: FileTreeWalk.kt */
    public static abstract class WalkState {
        public final File root;

        public WalkState(File file) {
            Intrinsics.checkNotNullParameter(file, "root");
            this.root = file;
        }

        public abstract File step();
    }

    public FileTreeWalk(File file, FileWalkDirection fileWalkDirection) {
        Intrinsics.checkNotNullParameter(file, AnalyticsConstants.START);
        Intrinsics.checkNotNullParameter(fileWalkDirection, RNGestureHandlerModule.KEY_DIRECTION);
        this.start = file;
        this.direction = fileWalkDirection;
    }

    public Iterator<File> iterator() {
        return new FileTreeWalkIterator();
    }
}

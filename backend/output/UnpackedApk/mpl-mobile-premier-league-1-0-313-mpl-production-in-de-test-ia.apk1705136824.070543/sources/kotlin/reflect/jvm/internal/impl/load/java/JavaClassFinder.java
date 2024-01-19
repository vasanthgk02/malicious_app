package kotlin.reflect.jvm.internal.impl.load.java;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Arrays;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: JavaClassFinder.kt */
public interface JavaClassFinder {

    /* compiled from: JavaClassFinder.kt */
    public static final class Request {
        public final ClassId classId;
        public final JavaClass outerClass;
        public final byte[] previouslyFoundClassFileContent;

        public Request(ClassId classId2, byte[] bArr, JavaClass javaClass, int i) {
            int i2 = i & 2;
            javaClass = (i & 4) != 0 ? null : javaClass;
            Intrinsics.checkNotNullParameter(classId2, "classId");
            this.classId = classId2;
            this.previouslyFoundClassFileContent = null;
            this.outerClass = javaClass;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Request)) {
                return false;
            }
            Request request = (Request) obj;
            return Intrinsics.areEqual(this.classId, request.classId) && Intrinsics.areEqual(this.previouslyFoundClassFileContent, request.previouslyFoundClassFileContent) && Intrinsics.areEqual(this.outerClass, request.outerClass);
        }

        public int hashCode() {
            int hashCode = this.classId.hashCode() * 31;
            byte[] bArr = this.previouslyFoundClassFileContent;
            int i = 0;
            int hashCode2 = (hashCode + (bArr == null ? 0 : Arrays.hashCode(bArr))) * 31;
            JavaClass javaClass = this.outerClass;
            if (javaClass != null) {
                i = javaClass.hashCode();
            }
            return hashCode2 + i;
        }

        public String toString() {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Request(classId=");
            outline73.append(this.classId);
            outline73.append(", previouslyFoundClassFileContent=");
            outline73.append(Arrays.toString(this.previouslyFoundClassFileContent));
            outline73.append(", outerClass=");
            outline73.append(this.outerClass);
            outline73.append(')');
            return outline73.toString();
        }
    }

    JavaClass findClass(Request request);

    JavaPackage findPackage(FqName fqName);

    Set<String> knownClassNamesInPackage(FqName fqName);
}

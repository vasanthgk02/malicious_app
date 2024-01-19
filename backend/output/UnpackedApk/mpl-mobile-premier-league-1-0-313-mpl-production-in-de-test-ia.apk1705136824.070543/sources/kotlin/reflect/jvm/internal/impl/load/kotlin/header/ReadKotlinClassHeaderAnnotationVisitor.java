package kotlin.reflect.jvm.internal.impl.load.kotlin.header;

import com.mpl.androidapp.login.LoginReactModule;
import com.userexperior.utilities.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArgumentVisitor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationArrayArgumentVisitor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass.AnnotationVisitor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader.Kind;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmBytecodeBinaryVersion;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ClassLiteralValue;
import org.apache.pdfbox.pdfparser.BaseParser;
import sfs2x.client.requests.buddylist.SetBuddyVariablesRequest;

public class ReadKotlinClassHeaderAnnotationVisitor implements AnnotationVisitor {
    public static final Map<ClassId, Kind> HEADER_KINDS;
    public static final boolean IGNORE_OLD_METADATA = BaseParser.TRUE.equals(System.getProperty("kotlin.ignore.old.metadata"));
    public JvmBytecodeBinaryVersion bytecodeVersion = null;
    public String[] data = null;
    public int extraInt = 0;
    public String extraString = null;
    public Kind headerKind = null;
    public String[] incompatibleData = null;
    public int[] metadataVersionArray = null;
    public String packageName = null;
    public String[] strings = null;

    public static abstract class CollectStringArrayAnnotationVisitor implements AnnotationArrayArgumentVisitor {
        public final List<String> strings = new ArrayList();

        public void visit(Object obj) {
            if (obj instanceof String) {
                this.strings.add((String) obj);
            }
        }

        public void visitClassLiteral(ClassLiteralValue classLiteralValue) {
        }

        public void visitEnd() {
            visitEnd((String[]) this.strings.toArray(new String[0]));
        }

        public abstract void visitEnd(String[] strArr);

        public void visitEnum(ClassId classId, Name name) {
        }
    }

    public class KotlinMetadataArgumentVisitor implements AnnotationArgumentVisitor {
        public static /* synthetic */ void $$$reportNull$$$0(int i) {
            Object[] objArr = new Object[3];
            if (i == 1) {
                objArr[0] = "classLiteralValue";
            } else if (i == 7) {
                objArr[0] = "classId";
            } else if (i == 4) {
                objArr[0] = "enumClassId";
            } else if (i != 5) {
                objArr[0] = "name";
            } else {
                objArr[0] = "enumEntryName";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor";
            switch (i) {
                case 2:
                    objArr[2] = "visitArray";
                    break;
                case 3:
                case 4:
                case 5:
                    objArr[2] = "visitEnum";
                    break;
                case 6:
                case 7:
                    objArr[2] = "visitAnnotation";
                    break;
                default:
                    objArr[2] = "visitClassLiteral";
                    break;
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        public KotlinMetadataArgumentVisitor(AnonymousClass1 r2) {
        }

        public void visit(Name name, Object obj) {
            if (name != null) {
                String asString = name.asString();
                if (k.f4287a.equals(asString)) {
                    if (obj instanceof Integer) {
                        ReadKotlinClassHeaderAnnotationVisitor.this.headerKind = Kind.getById(((Integer) obj).intValue());
                    }
                } else if ("mv".equals(asString)) {
                    if (obj instanceof int[]) {
                        ReadKotlinClassHeaderAnnotationVisitor.this.metadataVersionArray = (int[]) obj;
                    }
                } else if (SetBuddyVariablesRequest.KEY_BUDDY_VARS.equals(asString)) {
                    if (obj instanceof int[]) {
                        ReadKotlinClassHeaderAnnotationVisitor.this.bytecodeVersion = new JvmBytecodeBinaryVersion((int[]) obj);
                    }
                } else if ("xs".equals(asString)) {
                    if (obj instanceof String) {
                        ReadKotlinClassHeaderAnnotationVisitor.this.extraString = (String) obj;
                    }
                } else if ("xi".equals(asString)) {
                    if (obj instanceof Integer) {
                        ReadKotlinClassHeaderAnnotationVisitor.this.extraInt = ((Integer) obj).intValue();
                    }
                } else if ("pn".equals(asString) && (obj instanceof String)) {
                    ReadKotlinClassHeaderAnnotationVisitor.this.packageName = (String) obj;
                }
            }
        }

        public AnnotationArgumentVisitor visitAnnotation(Name name, ClassId classId) {
            if (name != null) {
                return null;
            }
            $$$reportNull$$$0(6);
            throw null;
        }

        public AnnotationArrayArgumentVisitor visitArray(Name name) {
            if (name != null) {
                String asString = name.asString();
                if ("d1".equals(asString)) {
                    return new CollectStringArrayAnnotationVisitor() {
                        public void visitEnd(String[] strArr) {
                            if (strArr != null) {
                                ReadKotlinClassHeaderAnnotationVisitor.this.data = strArr;
                            } else {
                                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{LoginReactModule.RESULT, "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor$1", "visitEnd"}));
                            }
                        }
                    };
                }
                if ("d2".equals(asString)) {
                    return new CollectStringArrayAnnotationVisitor() {
                        public void visitEnd(String[] strArr) {
                            if (strArr != null) {
                                ReadKotlinClassHeaderAnnotationVisitor.this.strings = strArr;
                            } else {
                                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{LoginReactModule.RESULT, "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor$2", "visitEnd"}));
                            }
                        }
                    };
                }
                return null;
            }
            $$$reportNull$$$0(2);
            throw null;
        }

        public void visitClassLiteral(Name name, ClassLiteralValue classLiteralValue) {
            if (name == null) {
                $$$reportNull$$$0(0);
                throw null;
            }
        }

        public void visitEnd() {
        }

        public void visitEnum(Name name, ClassId classId, Name name2) {
            if (name == null) {
                $$$reportNull$$$0(3);
                throw null;
            }
        }
    }

    public class OldDeprecatedAnnotationArgumentVisitor implements AnnotationArgumentVisitor {
        public static /* synthetic */ void $$$reportNull$$$0(int i) {
            Object[] objArr = new Object[3];
            if (i == 1) {
                objArr[0] = "classLiteralValue";
            } else if (i == 7) {
                objArr[0] = "classId";
            } else if (i == 4) {
                objArr[0] = "enumClassId";
            } else if (i != 5) {
                objArr[0] = "name";
            } else {
                objArr[0] = "enumEntryName";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor";
            switch (i) {
                case 2:
                    objArr[2] = "visitArray";
                    break;
                case 3:
                case 4:
                case 5:
                    objArr[2] = "visitEnum";
                    break;
                case 6:
                case 7:
                    objArr[2] = "visitAnnotation";
                    break;
                default:
                    objArr[2] = "visitClassLiteral";
                    break;
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        public OldDeprecatedAnnotationArgumentVisitor(AnonymousClass1 r2) {
        }

        public void visit(Name name, Object obj) {
            if (name != null) {
                String asString = name.asString();
                if ("version".equals(asString)) {
                    if (obj instanceof int[]) {
                        ReadKotlinClassHeaderAnnotationVisitor readKotlinClassHeaderAnnotationVisitor = ReadKotlinClassHeaderAnnotationVisitor.this;
                        int[] iArr = (int[]) obj;
                        readKotlinClassHeaderAnnotationVisitor.metadataVersionArray = iArr;
                        if (readKotlinClassHeaderAnnotationVisitor.bytecodeVersion == null) {
                            readKotlinClassHeaderAnnotationVisitor.bytecodeVersion = new JvmBytecodeBinaryVersion(iArr);
                        }
                    }
                } else if ("multifileClassName".equals(asString)) {
                    ReadKotlinClassHeaderAnnotationVisitor.this.extraString = obj instanceof String ? (String) obj : null;
                }
            }
        }

        public AnnotationArgumentVisitor visitAnnotation(Name name, ClassId classId) {
            if (name != null) {
                return null;
            }
            $$$reportNull$$$0(6);
            throw null;
        }

        public AnnotationArrayArgumentVisitor visitArray(Name name) {
            if (name != null) {
                String asString = name.asString();
                if ("data".equals(asString) || "filePartClassNames".equals(asString)) {
                    return new CollectStringArrayAnnotationVisitor() {
                        public void visitEnd(String[] strArr) {
                            if (strArr != null) {
                                ReadKotlinClassHeaderAnnotationVisitor.this.data = strArr;
                            } else {
                                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"data", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor$1", "visitEnd"}));
                            }
                        }
                    };
                }
                if ("strings".equals(asString)) {
                    return new CollectStringArrayAnnotationVisitor() {
                        public void visitEnd(String[] strArr) {
                            if (strArr != null) {
                                ReadKotlinClassHeaderAnnotationVisitor.this.strings = strArr;
                            } else {
                                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"data", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor$2", "visitEnd"}));
                            }
                        }
                    };
                }
                return null;
            }
            $$$reportNull$$$0(2);
            throw null;
        }

        public void visitClassLiteral(Name name, ClassLiteralValue classLiteralValue) {
            if (name == null) {
                $$$reportNull$$$0(0);
                throw null;
            }
        }

        public void visitEnd() {
        }

        public void visitEnum(Name name, ClassId classId, Name name2) {
            if (name == null) {
                $$$reportNull$$$0(3);
                throw null;
            }
        }
    }

    static {
        HashMap hashMap = new HashMap();
        HEADER_KINDS = hashMap;
        hashMap.put(ClassId.topLevel(new FqName((String) "kotlin.jvm.internal.KotlinClass")), Kind.CLASS);
        HEADER_KINDS.put(ClassId.topLevel(new FqName((String) "kotlin.jvm.internal.KotlinFileFacade")), Kind.FILE_FACADE);
        HEADER_KINDS.put(ClassId.topLevel(new FqName((String) "kotlin.jvm.internal.KotlinMultifileClass")), Kind.MULTIFILE_CLASS);
        HEADER_KINDS.put(ClassId.topLevel(new FqName((String) "kotlin.jvm.internal.KotlinMultifileClassPart")), Kind.MULTIFILE_CLASS_PART);
        HEADER_KINDS.put(ClassId.topLevel(new FqName((String) "kotlin.jvm.internal.KotlinSyntheticClass")), Kind.SYNTHETIC_CLASS);
    }

    public AnnotationArgumentVisitor visitAnnotation(ClassId classId, SourceElement sourceElement) {
        if (classId.asSingleFqName().equals(JvmAnnotationNames.METADATA_FQ_NAME)) {
            return new KotlinMetadataArgumentVisitor(null);
        }
        if (IGNORE_OLD_METADATA || this.headerKind != null) {
            return null;
        }
        Kind kind = HEADER_KINDS.get(classId);
        if (kind == null) {
            return null;
        }
        this.headerKind = kind;
        return new OldDeprecatedAnnotationArgumentVisitor(null);
    }

    public void visitEnd() {
    }
}

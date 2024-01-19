package org.objectweb.asm;

public abstract class ClassVisitor {
    public ClassVisitor(int i) {
        if (i != 262144 && i != 327680) {
            throw new IllegalArgumentException();
        }
    }

    public abstract void visit(int i, int i2, String str, String str2, String str3, String[] strArr);

    public abstract AnnotationWriter visitAnnotation(String str, boolean z);

    public abstract MethodVisitor visitMethod(int i, String str, String str2, String str3, String[] strArr);

    public abstract AnnotationWriter visitTypeAnnotation(int i, TypePath typePath, String str, boolean z);
}

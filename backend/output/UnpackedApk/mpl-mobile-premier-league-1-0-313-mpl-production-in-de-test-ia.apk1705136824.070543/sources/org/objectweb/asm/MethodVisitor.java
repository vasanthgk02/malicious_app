package org.objectweb.asm;

public abstract class MethodVisitor {
    public final int api;
    public MethodVisitor mv;

    public MethodVisitor(int i) {
        if (i == 262144 || i == 327680) {
            this.api = i;
            this.mv = null;
            return;
        }
        throw new IllegalArgumentException();
    }

    public abstract AnnotationWriter visitAnnotation(String str, boolean z);

    public abstract void visitFieldInsn(int i, String str, String str2, String str3);

    public abstract void visitFrame(int i, int i2, Object[] objArr, int i3, Object[] objArr2);

    public abstract void visitIincInsn(int i, int i2);

    public abstract void visitInsn(int i);

    public abstract AnnotationWriter visitInsnAnnotation(int i, TypePath typePath, String str, boolean z);

    public abstract void visitIntInsn(int i, int i2);

    public abstract void visitJumpInsn(int i, Label label);

    public abstract void visitLabel(Label label);

    public abstract void visitLdcInsn(Object obj);

    public abstract void visitLineNumber(int i, Label label);

    public abstract void visitLocalVariable(String str, String str2, String str3, Label label, Label label2, int i);

    public abstract AnnotationWriter visitLocalVariableAnnotation(int i, TypePath typePath, Label[] labelArr, Label[] labelArr2, int[] iArr, String str, boolean z);

    public abstract void visitMaxs(int i, int i2);

    public void visitMethodInsn(int i, String str, String str2, String str3) {
        if (this.api >= 327680) {
            visitMethodInsn(i, str, str2, str3, i == 185);
            return;
        }
        MethodVisitor methodVisitor = this.mv;
        if (methodVisitor != null) {
            methodVisitor.visitMethodInsn(i, str, str2, str3);
        }
    }

    public abstract void visitMethodInsn(int i, String str, String str2, String str3, boolean z);

    public abstract AnnotationWriter visitParameterAnnotation(int i, String str, boolean z);

    public abstract void visitTableSwitchInsn(int i, int i2, Label label, Label... labelArr);

    public abstract AnnotationWriter visitTypeAnnotation(int i, TypePath typePath, String str, boolean z);

    public abstract void visitTypeInsn(int i, String str);

    public abstract void visitVarInsn(int i, int i2);
}

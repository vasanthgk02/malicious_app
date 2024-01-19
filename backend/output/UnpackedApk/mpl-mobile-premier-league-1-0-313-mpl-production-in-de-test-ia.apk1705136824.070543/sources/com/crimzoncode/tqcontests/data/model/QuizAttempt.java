package com.crimzoncode.tqcontests.data.model;

import com.badlogic.gdx.graphics.g3d.particles.batches.BillboardParticleBatch;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u0016J\u000e\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u0004J\u000e\u0010<\u001a\u00020\u00062\u0006\u0010=\u001a\u00020\u0004J\u000e\u0010>\u001a\u00020\u00062\u0006\u0010=\u001a\u00020\u0004R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR \u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0010\u0010\u0005\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010\u001eR\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001e\u0010\u0014\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0018\"\u0004\b(\u0010\u001aR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R \u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001c\"\u0004\b.\u0010\u001eR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0018\"\u0004\b0\u0010\u001aR\u001e\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0018\"\u0004\b2\u0010\u001aR \u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001e\u0010\u0013\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0018\"\u0004\b8\u0010\u001a¨\u0006?"}, d2 = {"Lcom/crimzoncode/tqcontests/data/model/QuizAttempt;", "Lcom/crimzoncode/tqcontests/data/model/BaseModel;", "Ljava/io/Serializable;", "attemptId", "", "isSuccessful", "", "millis", "", "marks", "quiz", "Lcom/crimzoncode/tqcontests/data/model/QuizModel;", "subject", "", "chapter", "totalMarks", "updatedAt", "Ljava/util/Date;", "totalPoints", "userMaxMarks", "numQuestions", "message", "(IZJILcom/crimzoncode/tqcontests/data/model/QuizModel;Ljava/lang/String;Ljava/lang/String;ILjava/util/Date;IIILjava/lang/String;)V", "getAttemptId", "()I", "setAttemptId", "(I)V", "getChapter", "()Ljava/lang/String;", "setChapter", "(Ljava/lang/String;)V", "getMarks", "setMarks", "getMessage", "setMessage", "getMillis", "()J", "setMillis", "(J)V", "getNumQuestions", "setNumQuestions", "getQuiz", "()Lcom/crimzoncode/tqcontests/data/model/QuizModel;", "setQuiz", "(Lcom/crimzoncode/tqcontests/data/model/QuizModel;)V", "getSubject", "setSubject", "getTotalMarks", "setTotalMarks", "getTotalPoints", "setTotalPoints", "getUpdatedAt", "()Ljava/util/Date;", "setUpdatedAt", "(Ljava/util/Date;)V", "getUserMaxMarks", "setUserMaxMarks", "getQuestionByIdx", "Lcom/crimzoncode/tqcontests/data/model/Question;", "idx", "isNextQuestionAvailable", "questionIdx", "isPrevQuestionAvailable", "contests_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: QuizAttempt.kt */
public final class QuizAttempt extends BaseModel implements Serializable {
    @SerializedName("id")
    public int attemptId;
    @SerializedName("chapter")
    public String chapter;
    @SerializedName("is_successful")
    public final boolean isSuccessful;
    @SerializedName("marks")
    public int marks;
    public String message;
    @SerializedName("millis")
    public long millis;
    @SerializedName("num_questions")
    public int numQuestions;
    public QuizModel quiz;
    @SerializedName("subject")
    public String subject;
    @SerializedName("total_marks")
    public int totalMarks;
    @SerializedName("total_points")
    public int totalPoints;
    @SerializedName("updated_at")
    public Date updatedAt;
    @SerializedName("highest_marks")
    public int userMaxMarks;

    public QuizAttempt() {
        this(0, false, 0, 0, null, null, null, 0, null, 0, 0, 0, null, BillboardParticleBatch.MAX_PARTICLES_PER_MESH, null);
    }

    /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ QuizAttempt(int r17, boolean r18, long r19, int r21, com.crimzoncode.tqcontests.data.model.QuizModel r22, java.lang.String r23, java.lang.String r24, int r25, java.util.Date r26, int r27, int r28, int r29, java.lang.String r30, int r31, kotlin.jvm.internal.DefaultConstructorMarker r32) {
        /*
            r16 = this;
            r0 = r31
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = 0
            goto L_0x000b
        L_0x0009:
            r1 = r17
        L_0x000b:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0011
            r3 = 0
            goto L_0x0013
        L_0x0011:
            r3 = r18
        L_0x0013:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x001a
            r4 = 0
            goto L_0x001c
        L_0x001a:
            r4 = r19
        L_0x001c:
            r6 = r0 & 8
            if (r6 == 0) goto L_0x0022
            r6 = 0
            goto L_0x0024
        L_0x0022:
            r6 = r21
        L_0x0024:
            r7 = r0 & 16
            r8 = 0
            if (r7 == 0) goto L_0x002b
            r7 = r8
            goto L_0x002d
        L_0x002b:
            r7 = r22
        L_0x002d:
            r9 = r0 & 32
            if (r9 == 0) goto L_0x0033
            r9 = r8
            goto L_0x0035
        L_0x0033:
            r9 = r23
        L_0x0035:
            r10 = r0 & 64
            if (r10 == 0) goto L_0x003b
            r10 = r8
            goto L_0x003d
        L_0x003b:
            r10 = r24
        L_0x003d:
            r11 = r0 & 128(0x80, float:1.8E-43)
            if (r11 == 0) goto L_0x0043
            r11 = 0
            goto L_0x0045
        L_0x0043:
            r11 = r25
        L_0x0045:
            r12 = r0 & 256(0x100, float:3.59E-43)
            if (r12 == 0) goto L_0x004b
            r12 = r8
            goto L_0x004d
        L_0x004b:
            r12 = r26
        L_0x004d:
            r13 = r0 & 512(0x200, float:7.17E-43)
            if (r13 == 0) goto L_0x0053
            r13 = 0
            goto L_0x0055
        L_0x0053:
            r13 = r27
        L_0x0055:
            r14 = r0 & 1024(0x400, float:1.435E-42)
            if (r14 == 0) goto L_0x005b
            r14 = 0
            goto L_0x005d
        L_0x005b:
            r14 = r28
        L_0x005d:
            r15 = r0 & 2048(0x800, float:2.87E-42)
            if (r15 == 0) goto L_0x0062
            goto L_0x0064
        L_0x0062:
            r2 = r29
        L_0x0064:
            r0 = r0 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L_0x0069
            goto L_0x006b
        L_0x0069:
            r8 = r30
        L_0x006b:
            r17 = r16
            r18 = r1
            r19 = r3
            r20 = r4
            r22 = r6
            r23 = r7
            r24 = r9
            r25 = r10
            r26 = r11
            r27 = r12
            r28 = r13
            r29 = r14
            r30 = r2
            r31 = r8
            r17.<init>(r18, r19, r20, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.crimzoncode.tqcontests.data.model.QuizAttempt.<init>(int, boolean, long, int, com.crimzoncode.tqcontests.data.model.QuizModel, java.lang.String, java.lang.String, int, java.util.Date, int, int, int, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final int getAttemptId() {
        return this.attemptId;
    }

    public final String getChapter() {
        return this.chapter;
    }

    public final int getMarks() {
        return this.marks;
    }

    public final String getMessage() {
        return this.message;
    }

    public final long getMillis() {
        return this.millis;
    }

    public final int getNumQuestions() {
        return this.numQuestions;
    }

    public final Question getQuestionByIdx(int i) {
        QuizModel quizModel = this.quiz;
        if (quizModel != null) {
            return quizModel.getQuestions().get(i);
        }
        Intrinsics.throwNpe();
        throw null;
    }

    public final QuizModel getQuiz() {
        return this.quiz;
    }

    public final String getSubject() {
        return this.subject;
    }

    public final int getTotalMarks() {
        return this.totalMarks;
    }

    public final int getTotalPoints() {
        return this.totalPoints;
    }

    public final Date getUpdatedAt() {
        return this.updatedAt;
    }

    public final int getUserMaxMarks() {
        return this.userMaxMarks;
    }

    public final boolean isNextQuestionAvailable(int i) {
        int i2 = i + 1;
        QuizModel quizModel = this.quiz;
        if (quizModel != null) {
            return i2 < quizModel.getQuestions().size();
        }
        Intrinsics.throwNpe();
        throw null;
    }

    public final boolean isPrevQuestionAvailable(int i) {
        return i > 0;
    }

    public final void setAttemptId(int i) {
        this.attemptId = i;
    }

    public final void setChapter(String str) {
        this.chapter = str;
    }

    public final void setMarks(int i) {
        this.marks = i;
    }

    public final void setMessage(String str) {
        this.message = str;
    }

    public final void setMillis(long j) {
        this.millis = j;
    }

    public final void setNumQuestions(int i) {
        this.numQuestions = i;
    }

    public final void setQuiz(QuizModel quizModel) {
        this.quiz = quizModel;
    }

    public final void setSubject(String str) {
        this.subject = str;
    }

    public final void setTotalMarks(int i) {
        this.totalMarks = i;
    }

    public final void setTotalPoints(int i) {
        this.totalPoints = i;
    }

    public final void setUpdatedAt(Date date) {
        this.updatedAt = date;
    }

    public final void setUserMaxMarks(int i) {
        this.userMaxMarks = i;
    }

    public QuizAttempt(int i, boolean z, long j, int i2, QuizModel quizModel, String str, String str2, int i3, Date date, int i4, int i5, int i6, String str3) {
        this.attemptId = i;
        this.isSuccessful = z;
        this.millis = j;
        this.marks = i2;
        this.quiz = quizModel;
        this.subject = str;
        this.chapter = str2;
        this.totalMarks = i3;
        this.updatedAt = date;
        this.totalPoints = i4;
        this.userMaxMarks = i5;
        this.numQuestions = i6;
        this.message = str3;
    }
}

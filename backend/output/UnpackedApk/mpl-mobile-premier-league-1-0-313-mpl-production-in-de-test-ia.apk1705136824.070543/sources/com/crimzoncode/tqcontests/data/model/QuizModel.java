package com.crimzoncode.tqcontests.data.model;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sfs2x.client.entities.invitation.InvitationReply;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b%\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u00012\u00020\u0002Bc\u0012\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007¢\u0006\u0002\u0010\u000fJ\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0003J\t\u0010'\u001a\u00020\u0007HÆ\u0003J\t\u0010(\u001a\u00020\u0007HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010-\u001a\u00020\u0007HÆ\u0003Jg\u0010.\u001a\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000e\u001a\u00020\u0007HÆ\u0001J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u000102HÖ\u0003J\t\u00103\u001a\u00020\u0007HÖ\u0001J\t\u00104\u001a\u00020\nHÖ\u0001R \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\r\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R \u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\u001e\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR \u0010\f\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0011\"\u0004\b#\u0010\u0013R\u001e\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0019\"\u0004\b%\u0010\u001b¨\u00065"}, d2 = {"Lcom/crimzoncode/tqcontests/data/model/QuizModel;", "Lcom/crimzoncode/tqcontests/data/model/BaseModel;", "Ljava/io/Serializable;", "questions", "", "Lcom/crimzoncode/tqcontests/data/model/Question;", "quizId", "", "totalPoints", "board", "", "grade", "subject", "chapter", "numQuestions", "(Ljava/util/List;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getBoard", "()Ljava/lang/String;", "setBoard", "(Ljava/lang/String;)V", "getChapter", "setChapter", "getGrade", "setGrade", "getNumQuestions", "()I", "setNumQuestions", "(I)V", "getQuestions", "()Ljava/util/List;", "setQuestions", "(Ljava/util/List;)V", "getQuizId", "setQuizId", "getSubject", "setSubject", "getTotalPoints", "setTotalPoints", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "", "hashCode", "toString", "contests_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: QuizModel.kt */
public final class QuizModel extends BaseModel implements Serializable {
    @SerializedName("board")
    public String board;
    @SerializedName("chapter")
    public String chapter;
    @SerializedName("class")
    public String grade;
    @SerializedName("num_questions")
    public int numQuestions;
    @SerializedName("questions")
    public List<Question> questions;
    @SerializedName("id")
    public int quizId;
    @SerializedName("subject")
    public String subject;
    @SerializedName("total_points")
    public int totalPoints;

    public QuizModel() {
        this(null, 0, 0, null, null, null, null, 0, InvitationReply.EXPIRED, null);
    }

    /* JADX WARNING: Illegal instructions before constructor call commented (this can break semantics) */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ QuizModel(java.util.List r11, int r12, int r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, int r18, int r19, kotlin.jvm.internal.DefaultConstructorMarker r20) {
        /*
            r10 = this;
            r0 = r19
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000c
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            goto L_0x000d
        L_0x000c:
            r1 = r11
        L_0x000d:
            r2 = r0 & 2
            r3 = 0
            if (r2 == 0) goto L_0x0014
            r2 = 0
            goto L_0x0015
        L_0x0014:
            r2 = r12
        L_0x0015:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x001b
            r4 = 0
            goto L_0x001c
        L_0x001b:
            r4 = r13
        L_0x001c:
            r5 = r0 & 8
            r6 = 0
            if (r5 == 0) goto L_0x0023
            r5 = r6
            goto L_0x0024
        L_0x0023:
            r5 = r14
        L_0x0024:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x002a
            r7 = r6
            goto L_0x002b
        L_0x002a:
            r7 = r15
        L_0x002b:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x0031
            r8 = r6
            goto L_0x0033
        L_0x0031:
            r8 = r16
        L_0x0033:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x0038
            goto L_0x003a
        L_0x0038:
            r6 = r17
        L_0x003a:
            r0 = r0 & 128(0x80, float:1.8E-43)
            if (r0 == 0) goto L_0x003f
            goto L_0x0041
        L_0x003f:
            r3 = r18
        L_0x0041:
            r11 = r10
            r12 = r1
            r13 = r2
            r14 = r4
            r15 = r5
            r16 = r7
            r17 = r8
            r18 = r6
            r19 = r3
            r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.crimzoncode.tqcontests.data.model.QuizModel.<init>(java.util.List, int, int, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public static /* synthetic */ QuizModel copy$default(QuizModel quizModel, List list, int i, int i2, String str, String str2, String str3, String str4, int i3, int i4, Object obj) {
        QuizModel quizModel2 = quizModel;
        int i5 = i4;
        return quizModel.copy((i5 & 1) != 0 ? quizModel2.questions : list, (i5 & 2) != 0 ? quizModel2.quizId : i, (i5 & 4) != 0 ? quizModel2.totalPoints : i2, (i5 & 8) != 0 ? quizModel2.board : str, (i5 & 16) != 0 ? quizModel2.grade : str2, (i5 & 32) != 0 ? quizModel2.subject : str3, (i5 & 64) != 0 ? quizModel2.chapter : str4, (i5 & 128) != 0 ? quizModel2.numQuestions : i3);
    }

    public final List<Question> component1() {
        return this.questions;
    }

    public final int component2() {
        return this.quizId;
    }

    public final int component3() {
        return this.totalPoints;
    }

    public final String component4() {
        return this.board;
    }

    public final String component5() {
        return this.grade;
    }

    public final String component6() {
        return this.subject;
    }

    public final String component7() {
        return this.chapter;
    }

    public final int component8() {
        return this.numQuestions;
    }

    public final QuizModel copy(List<Question> list, int i, int i2, String str, String str2, String str3, String str4, int i3) {
        Intrinsics.checkParameterIsNotNull(list, "questions");
        QuizModel quizModel = new QuizModel(list, i, i2, str, str2, str3, str4, i3);
        return quizModel;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004a, code lost:
        if (r2.numQuestions == r3.numQuestions) goto L_0x004f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r3) {
        /*
            r2 = this;
            if (r2 == r3) goto L_0x004f
            boolean r0 = r3 instanceof com.crimzoncode.tqcontests.data.model.QuizModel
            if (r0 == 0) goto L_0x004d
            com.crimzoncode.tqcontests.data.model.QuizModel r3 = (com.crimzoncode.tqcontests.data.model.QuizModel) r3
            java.util.List<com.crimzoncode.tqcontests.data.model.Question> r0 = r2.questions
            java.util.List<com.crimzoncode.tqcontests.data.model.Question> r1 = r3.questions
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x004d
            int r0 = r2.quizId
            int r1 = r3.quizId
            if (r0 != r1) goto L_0x004d
            int r0 = r2.totalPoints
            int r1 = r3.totalPoints
            if (r0 != r1) goto L_0x004d
            java.lang.String r0 = r2.board
            java.lang.String r1 = r3.board
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x004d
            java.lang.String r0 = r2.grade
            java.lang.String r1 = r3.grade
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x004d
            java.lang.String r0 = r2.subject
            java.lang.String r1 = r3.subject
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x004d
            java.lang.String r0 = r2.chapter
            java.lang.String r1 = r3.chapter
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 == 0) goto L_0x004d
            int r0 = r2.numQuestions
            int r3 = r3.numQuestions
            if (r0 != r3) goto L_0x004d
            goto L_0x004f
        L_0x004d:
            r3 = 0
            return r3
        L_0x004f:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.crimzoncode.tqcontests.data.model.QuizModel.equals(java.lang.Object):boolean");
    }

    public final String getBoard() {
        return this.board;
    }

    public final String getChapter() {
        return this.chapter;
    }

    public final String getGrade() {
        return this.grade;
    }

    public final int getNumQuestions() {
        return this.numQuestions;
    }

    public final List<Question> getQuestions() {
        return this.questions;
    }

    public final int getQuizId() {
        return this.quizId;
    }

    public final String getSubject() {
        return this.subject;
    }

    public final int getTotalPoints() {
        return this.totalPoints;
    }

    public int hashCode() {
        List<Question> list = this.questions;
        int i = 0;
        int hashCode = (((((list != null ? list.hashCode() : 0) * 31) + this.quizId) * 31) + this.totalPoints) * 31;
        String str = this.board;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.grade;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.subject;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.chapter;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return ((hashCode4 + i) * 31) + this.numQuestions;
    }

    public final void setBoard(String str) {
        this.board = str;
    }

    public final void setChapter(String str) {
        this.chapter = str;
    }

    public final void setGrade(String str) {
        this.grade = str;
    }

    public final void setNumQuestions(int i) {
        this.numQuestions = i;
    }

    public final void setQuestions(List<Question> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.questions = list;
    }

    public final void setQuizId(int i) {
        this.quizId = i;
    }

    public final void setSubject(String str) {
        this.subject = str;
    }

    public final void setTotalPoints(int i) {
        this.totalPoints = i;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("QuizModel(questions=");
        outline73.append(this.questions);
        outline73.append(", quizId=");
        outline73.append(this.quizId);
        outline73.append(", totalPoints=");
        outline73.append(this.totalPoints);
        outline73.append(", board=");
        outline73.append(this.board);
        outline73.append(", grade=");
        outline73.append(this.grade);
        outline73.append(", subject=");
        outline73.append(this.subject);
        outline73.append(", chapter=");
        outline73.append(this.chapter);
        outline73.append(", numQuestions=");
        return GeneratedOutlineSupport.outline57(outline73, this.numQuestions, ")");
    }

    public QuizModel(List<Question> list, int i, int i2, String str, String str2, String str3, String str4, int i3) {
        Intrinsics.checkParameterIsNotNull(list, "questions");
        this.questions = list;
        this.quizId = i;
        this.totalPoints = i2;
        this.board = str;
        this.grade = str2;
        this.subject = str3;
        this.chapter = str4;
        this.numQuestions = i3;
    }
}

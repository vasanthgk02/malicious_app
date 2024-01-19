package com.badlogic.gdx.utils;

import com.badlogic.gdx.utils.JsonValue.ValueType;
import okio.Utf8;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.fontbox.ttf.GlyfDescript;
import org.apache.pdfbox.pdfparser.BaseParser;
import org.apache.pdfbox.pdmodel.common.function.type4.Parser.Tokenizer;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;
import org.jboss.netty.handler.codec.http.HttpCodecUtil;

public class JsonReader implements BaseJsonReader {
    public static final byte[] _json_actions = {0, 1, 1, 1, 2, 1, 3, 1, 4, 1, 5, 1, 6, 1, 7, 1, 8, 2, 0, 7, 2, 0, 8, 2, 1, 3, 2, 1, 5};
    public static final byte[] _json_eof_actions = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0};
    public static final short[] _json_index_offsets = {0, 0, 11, 14, 16, 19, 28, 34, 40, 43, 54, 62, 70, 79, 81, 90, 93, 96, 105, 108, 111, 113, 116, 119, 130, 138, 146, 157, 159, 170, 173, 176, 187, 190, 193, 196, 201, 206, 207};
    public static final byte[] _json_indicies = {1, 1, 2, 3, 4, 3, 5, 3, 6, 1, 0, 7, 7, 3, 8, 3, 9, 9, 3, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 13, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, 3, 15, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 10, GlyfDescript.X_DUAL, GlyfDescript.X_DUAL, 17, 18, GlyfDescript.X_DUAL, 3, 19, 19, 20, 21, 19, 3, 22, 22, 3, 21, 21, 24, 3, 25, 3, 26, 3, 27, 21, 23, 28, 29, 29, 28, 30, 31, 32, 3, 33, HttpCodecUtil.DOUBLE_QUOTE, HttpCodecUtil.DOUBLE_QUOTE, 33, 13, 35, 15, 3, HttpCodecUtil.DOUBLE_QUOTE, HttpCodecUtil.DOUBLE_QUOTE, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 36, 37, 3, 15, HttpCodecUtil.DOUBLE_QUOTE, 10, GlyfDescript.X_DUAL, 3, 36, 36, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 3, 38, 3, 3, 36, 10, 39, 39, 3, 40, 40, 3, 13, 13, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 3, 41, 3, 15, 13, 10, 42, 42, 3, 43, 43, 3, 28, 3, HttpCodecUtil.COMMA, HttpCodecUtil.COMMA, 3, 45, 45, 3, 47, 47, BaseParser.ASCII_ZERO, 49, 50, 3, 51, 52, 53, 47, 46, 54, 55, 55, 54, 56, BaseParser.ASCII_NINE, HttpCodecUtil.COLON, 3, HttpCodecUtil.SEMICOLON, 60, 60, HttpCodecUtil.SEMICOLON, 49, 61, 52, 3, 60, 60, BaseParser.ASCII_ZERO, 62, Utf8.REPLACEMENT_BYTE, 3, 51, 52, 53, 60, 46, 54, 3, 62, 62, BaseParser.ASCII_ZERO, 3, 64, 3, 51, 3, 53, 62, 46, 65, 65, 3, 66, 66, 3, 49, 49, BaseParser.ASCII_ZERO, 3, 67, 3, 51, 52, 53, 49, 46, 68, 68, 3, 69, 69, 3, 70, 70, 3, 8, 8, 71, 8, 3, 72, 72, 73, 72, 3, 3, 3, 0};
    public static final short[] _json_key_offsets = {0, 0, 11, 13, 14, 16, 25, 31, 37, 39, 50, 57, 64, 73, 74, 83, 85, 87, 96, 98, 100, 101, 103, 105, 116, 123, 130, 141, 142, 153, 155, 157, 168, 170, 172, 174, 179, 184, 184};
    public static final byte[] _json_range_lengths = {0, 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0};
    public static final byte[] _json_single_lengths = {0, 9, 2, 1, 2, 7, 4, 4, 2, 9, 7, 7, 7, 1, 7, 2, 2, 7, 2, 2, 1, 2, 2, 9, 7, 7, 9, 1, 9, 2, 2, 9, 2, 2, 2, 3, 3, 0, 0};
    public static final byte[] _json_trans_actions = {13, 0, 15, 0, 0, 7, 3, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 1, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 17, 0, 20, 0, 0, 5, 1, 1, 1, 0, 0, 0, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 13, 15, 0, 7, 3, 1, 1, 1, 1, 23, 0, 0, 0, 0, 0, 0, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 0, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 13, 0, 15, 0, 0, 7, 9, 3, 1, 1, 1, 1, 26, 0, 0, 0, 0, 0, 0, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 0, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 1, 0, 0};
    public static final char[] _json_trans_keys = {13, ' ', StringEscapeUtils.CSV_QUOTE, ',', '/', ':', '[', ']', '{', 9, 10, '*', '/', StringEscapeUtils.CSV_QUOTE, '*', '/', 13, ' ', StringEscapeUtils.CSV_QUOTE, ',', '/', ':', '}', 9, 10, 13, ' ', '/', ':', 9, 10, 13, ' ', '/', ':', 9, 10, '*', '/', 13, ' ', StringEscapeUtils.CSV_QUOTE, ',', '/', ':', '[', ']', '{', 9, 10, 9, 10, 13, ' ', ',', '/', '}', 9, 10, 13, ' ', ',', '/', '}', 13, ' ', StringEscapeUtils.CSV_QUOTE, ',', '/', ':', '}', 9, 10, StringEscapeUtils.CSV_QUOTE, 13, ' ', StringEscapeUtils.CSV_QUOTE, ',', '/', ':', '}', 9, 10, '*', '/', '*', '/', 13, ' ', StringEscapeUtils.CSV_QUOTE, ',', '/', ':', '}', 9, 10, '*', '/', '*', '/', StringEscapeUtils.CSV_QUOTE, '*', '/', '*', '/', 13, ' ', StringEscapeUtils.CSV_QUOTE, ',', '/', ':', '[', ']', '{', 9, 10, 9, 10, 13, ' ', ',', '/', ']', 9, 10, 13, ' ', ',', '/', ']', 13, ' ', StringEscapeUtils.CSV_QUOTE, ',', '/', ':', '[', ']', '{', 9, 10, StringEscapeUtils.CSV_QUOTE, 13, ' ', StringEscapeUtils.CSV_QUOTE, ',', '/', ':', '[', ']', '{', 9, 10, '*', '/', '*', '/', 13, ' ', StringEscapeUtils.CSV_QUOTE, ',', '/', ':', '[', ']', '{', 9, 10, '*', '/', '*', '/', '*', '/', 13, ' ', '/', 9, 10, 13, ' ', '/', 9, 10, 0};
    public static final byte[] _json_trans_targs = {35, 1, 3, 0, 4, 36, 36, 36, 36, 1, 6, 5, 13, 17, 22, 37, 7, 8, 9, 7, 8, 9, 7, 10, 20, 21, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 17, 19, 37, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 19, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, GlyfDescript.X_DUAL, 15, MqttWireMessage.MESSAGE_TYPE_DISCONNECT, MqttWireMessage.MESSAGE_TYPE_PINGREQ, 18, 17, MqttWireMessage.MESSAGE_TYPE_UNSUBACK, 9, 5, 24, 23, 27, 31, HttpCodecUtil.DOUBLE_QUOTE, 25, 38, 25, 25, 26, 31, 33, 38, 25, 26, 33, 28, 30, 29, 28, 26, 32, 31, 25, 23, 2, 36, 2};
    public JsonValue current;
    public final Array<JsonValue> elements = new Array<>(true, 8);
    public final Array<JsonValue> lastChild = new Array<>(true, 8);
    public JsonValue root;

    public final void addChild(String str, JsonValue jsonValue) {
        jsonValue.name = str;
        JsonValue jsonValue2 = this.current;
        if (jsonValue2 == null) {
            this.current = jsonValue;
            this.root = jsonValue;
        } else if (jsonValue2.isArray() || this.current.isObject()) {
            JsonValue jsonValue3 = this.current;
            jsonValue.parent = jsonValue3;
            if (jsonValue3.size == 0) {
                jsonValue3.child = jsonValue;
            } else {
                JsonValue jsonValue4 = (JsonValue) this.lastChild.pop();
                jsonValue4.next = jsonValue;
                jsonValue.prev = jsonValue4;
            }
            this.lastChild.add(jsonValue);
            this.current.size++;
        } else {
            this.root = this.current;
        }
    }

    public void bool(String str, boolean z) {
        addChild(str, new JsonValue(z));
    }

    /* JADX WARNING: type inference failed for: r0v15, types: [int[]] */
    /* JADX WARNING: type inference failed for: r9v0 */
    /* JADX WARNING: type inference failed for: r9v1 */
    /* JADX WARNING: type inference failed for: r0v16 */
    /* JADX WARNING: type inference failed for: r9v2 */
    /* JADX WARNING: type inference failed for: r7v2 */
    /* JADX WARNING: type inference failed for: r0v17 */
    /* JADX WARNING: type inference failed for: r9v3 */
    /* JADX WARNING: type inference failed for: r6v7, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r5v17, types: [byte] */
    /* JADX WARNING: type inference failed for: r5v18, types: [int] */
    /* JADX WARNING: type inference failed for: r6v8, types: [int] */
    /* JADX WARNING: type inference failed for: r17v0 */
    /* JADX WARNING: type inference failed for: r5v22 */
    /* JADX WARNING: type inference failed for: r17v1 */
    /* JADX WARNING: type inference failed for: r17v2 */
    /* JADX WARNING: type inference failed for: r17v3 */
    /* JADX WARNING: type inference failed for: r6v9 */
    /* JADX WARNING: type inference failed for: r17v4 */
    /* JADX WARNING: type inference failed for: r17v5 */
    /* JADX WARNING: type inference failed for: r17v6 */
    /* JADX WARNING: type inference failed for: r6v13 */
    /* JADX WARNING: type inference failed for: r17v7 */
    /* JADX WARNING: type inference failed for: r17v8 */
    /* JADX WARNING: type inference failed for: r20v0 */
    /* JADX WARNING: type inference failed for: r9v5 */
    /* JADX WARNING: type inference failed for: r7v17 */
    /* JADX WARNING: type inference failed for: r0v45 */
    /* JADX WARNING: type inference failed for: r20v1 */
    /* JADX WARNING: type inference failed for: r9v6 */
    /* JADX WARNING: type inference failed for: r7v18 */
    /* JADX WARNING: type inference failed for: r20v2 */
    /* JADX WARNING: type inference failed for: r9v7 */
    /* JADX WARNING: type inference failed for: r7v19 */
    /* JADX WARNING: type inference failed for: r6v22, types: [short[]] */
    /* JADX WARNING: type inference failed for: r6v23, types: [short, int] */
    /* JADX WARNING: type inference failed for: r7v20, types: [short[]] */
    /* JADX WARNING: type inference failed for: r7v21, types: [short, int] */
    /* JADX WARNING: type inference failed for: r20v3 */
    /* JADX WARNING: type inference failed for: r7v22, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r7v23, types: [byte] */
    /* JADX WARNING: type inference failed for: r20v4 */
    /* JADX WARNING: type inference failed for: r0v47 */
    /* JADX WARNING: type inference failed for: r9v11 */
    /* JADX WARNING: type inference failed for: r20v5 */
    /* JADX WARNING: type inference failed for: r0v49 */
    /* JADX WARNING: type inference failed for: r9v14, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r6v27, types: [byte] */
    /* JADX WARNING: type inference failed for: r7v24 */
    /* JADX WARNING: type inference failed for: r6v28, types: [int] */
    /* JADX WARNING: type inference failed for: r0v50, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r16v8, types: [int] */
    /* JADX WARNING: type inference failed for: r20v6 */
    /* JADX WARNING: type inference failed for: r0v51 */
    /* JADX WARNING: type inference failed for: r0v53 */
    /* JADX WARNING: type inference failed for: r7v25 */
    /* JADX WARNING: type inference failed for: r9v17 */
    /* JADX WARNING: type inference failed for: r6v38, types: [java.lang.Object, int[]] */
    /* JADX WARNING: type inference failed for: r0v54 */
    /* JADX WARNING: type inference failed for: r6v42 */
    /* JADX WARNING: type inference failed for: r0v55 */
    /* JADX WARNING: type inference failed for: r6v47 */
    /* JADX WARNING: type inference failed for: r6v50, types: [java.lang.Object, int[]] */
    /* JADX WARNING: type inference failed for: r0v56 */
    /* JADX WARNING: type inference failed for: r20v7 */
    /* JADX WARNING: type inference failed for: r0v57 */
    /* JADX WARNING: type inference failed for: r7v26 */
    /* JADX WARNING: type inference failed for: r6v54 */
    /* JADX WARNING: type inference failed for: r0v58 */
    /* JADX WARNING: type inference failed for: r20v8 */
    /* JADX WARNING: type inference failed for: r0v59 */
    /* JADX WARNING: type inference failed for: r20v9 */
    /* JADX WARNING: type inference failed for: r0v60 */
    /* JADX WARNING: type inference failed for: r20v10 */
    /* JADX WARNING: type inference failed for: r0v61 */
    /* JADX WARNING: type inference failed for: r20v11 */
    /* JADX WARNING: type inference failed for: r0v62 */
    /* JADX WARNING: type inference failed for: r20v12 */
    /* JADX WARNING: type inference failed for: r0v63 */
    /* JADX WARNING: type inference failed for: r0v64 */
    /* JADX WARNING: type inference failed for: r20v13 */
    /* JADX WARNING: type inference failed for: r20v14 */
    /* JADX WARNING: type inference failed for: r0v65 */
    /* JADX WARNING: type inference failed for: r0v66 */
    /* JADX WARNING: type inference failed for: r20v15 */
    /* JADX WARNING: type inference failed for: r0v68 */
    /* JADX WARNING: type inference failed for: r20v16 */
    /* JADX WARNING: type inference failed for: r0v70 */
    /* JADX WARNING: type inference failed for: r6v62 */
    /* JADX WARNING: type inference failed for: r0v71 */
    /* JADX WARNING: type inference failed for: r7v30 */
    /* JADX WARNING: type inference failed for: r9v22 */
    /* JADX WARNING: type inference failed for: r6v64 */
    /* JADX WARNING: type inference failed for: r20v17 */
    /* JADX WARNING: type inference failed for: r0v75 */
    /* JADX WARNING: type inference failed for: r20v18 */
    /* JADX WARNING: type inference failed for: r0v78 */
    /* JADX WARNING: type inference failed for: r20v19 */
    /* JADX WARNING: type inference failed for: r0v79 */
    /* JADX WARNING: type inference failed for: r7v31, types: [int] */
    /* JADX WARNING: type inference failed for: r6v91, types: [int] */
    /* JADX WARNING: type inference failed for: r11v33, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r9v44, types: [byte, int] */
    /* JADX WARNING: type inference failed for: r20v20 */
    /* JADX WARNING: type inference failed for: r12v40 */
    /* JADX WARNING: type inference failed for: r12v41, types: [int] */
    /* JADX WARNING: type inference failed for: r9v45 */
    /* JADX WARNING: type inference failed for: r9v46, types: [int] */
    /* JADX WARNING: type inference failed for: r20v21, types: [int] */
    /* JADX WARNING: type inference failed for: r17v10 */
    /* JADX WARNING: type inference failed for: r12v42 */
    /* JADX WARNING: type inference failed for: r9v48 */
    /* JADX WARNING: type inference failed for: r9v51 */
    /* JADX WARNING: type inference failed for: r9v52 */
    /* JADX WARNING: type inference failed for: r12v45 */
    /* JADX WARNING: type inference failed for: r12v46, types: [int] */
    /* JADX WARNING: type inference failed for: r7v32, types: [int] */
    /* JADX WARNING: type inference failed for: r23v0 */
    /* JADX WARNING: type inference failed for: r12v48 */
    /* JADX WARNING: type inference failed for: r12v52 */
    /* JADX WARNING: type inference failed for: r20v28 */
    /* JADX WARNING: type inference failed for: r7v33 */
    /* JADX WARNING: type inference failed for: r20v29 */
    /* JADX WARNING: type inference failed for: r0v83 */
    /* JADX WARNING: type inference failed for: r9v53 */
    /* JADX WARNING: type inference failed for: r9v54 */
    /* JADX WARNING: type inference failed for: r9v55 */
    /* JADX WARNING: type inference failed for: r9v56 */
    /* JADX WARNING: type inference failed for: r9v57 */
    /* JADX WARNING: type inference failed for: r0v84 */
    /* JADX WARNING: type inference failed for: r0v85 */
    /* JADX WARNING: type inference failed for: r9v58 */
    /* JADX WARNING: type inference failed for: r7v34 */
    /* JADX WARNING: type inference failed for: r0v86 */
    /* JADX WARNING: type inference failed for: r5v49 */
    /* JADX WARNING: type inference failed for: r6v93 */
    /* JADX WARNING: type inference failed for: r17v12 */
    /* JADX WARNING: type inference failed for: r17v13 */
    /* JADX WARNING: type inference failed for: r17v14 */
    /* JADX WARNING: type inference failed for: r9v59 */
    /* JADX WARNING: type inference failed for: r7v35 */
    /* JADX WARNING: type inference failed for: r20v30 */
    /* JADX WARNING: type inference failed for: r9v60 */
    /* JADX WARNING: type inference failed for: r7v36 */
    /* JADX WARNING: type inference failed for: r20v31 */
    /* JADX WARNING: type inference failed for: r20v32 */
    /* JADX WARNING: type inference failed for: r9v61 */
    /* JADX WARNING: type inference failed for: r9v62 */
    /* JADX WARNING: type inference failed for: r9v63 */
    /* JADX WARNING: type inference failed for: r7v37 */
    /* JADX WARNING: type inference failed for: r6v94 */
    /* JADX WARNING: type inference failed for: r7v38 */
    /* JADX WARNING: type inference failed for: r7v39 */
    /* JADX WARNING: type inference failed for: r20v33 */
    /* JADX WARNING: type inference failed for: r6v95 */
    /* JADX WARNING: type inference failed for: r0v87 */
    /* JADX WARNING: type inference failed for: r7v40 */
    /* JADX WARNING: type inference failed for: r9v64 */
    /* JADX WARNING: type inference failed for: r6v96 */
    /* JADX WARNING: type inference failed for: r0v88 */
    /* JADX WARNING: type inference failed for: r6v97 */
    /* JADX WARNING: type inference failed for: r20v34 */
    /* JADX WARNING: type inference failed for: r0v89 */
    /* JADX WARNING: type inference failed for: r20v35 */
    /* JADX WARNING: type inference failed for: r0v90 */
    /* JADX WARNING: type inference failed for: r0v91 */
    /* JADX WARNING: type inference failed for: r0v92 */
    /* JADX WARNING: type inference failed for: r20v36 */
    /* JADX WARNING: type inference failed for: r0v93 */
    /* JADX WARNING: type inference failed for: r7v41 */
    /* JADX WARNING: type inference failed for: r6v98 */
    /* JADX WARNING: type inference failed for: r9v65 */
    /* JADX WARNING: type inference failed for: r12v53 */
    /* JADX WARNING: type inference failed for: r9v66 */
    /* JADX WARNING: type inference failed for: r20v37 */
    /* JADX WARNING: type inference failed for: r12v54 */
    /* JADX WARNING: type inference failed for: r9v67 */
    /* JADX WARNING: type inference failed for: r7v42 */
    /* JADX WARNING: type inference failed for: r12v55 */
    /* JADX WARNING: type inference failed for: r7v43 */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x023e, code lost:
        r10 = r9;
        r12 = r18;
        r9 = r6;
        r6 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:392:0x002a, code lost:
        r0 = r0;
        r7 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0135, code lost:
        r20 = r0;
        r21 = r5;
        r0 = r7;
        r9 = r8;
        r8 = r6;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=int, for r9v44, types: [byte, int] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=short, code=int, for r6v23, types: [short, int] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:247:0x032a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:331:0x0442 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r9v2
      assigns: []
      uses: []
      mth insns count: 636
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Removed duplicated region for block: B:255:0x0355  */
    /* JADX WARNING: Removed duplicated region for block: B:258:0x0367  */
    /* JADX WARNING: Removed duplicated region for block: B:261:0x0370  */
    /* JADX WARNING: Removed duplicated region for block: B:345:0x046c  */
    /* JADX WARNING: Removed duplicated region for block: B:353:0x04b2  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00f7 A[Catch:{ RuntimeException -> 0x045c }] */
    /* JADX WARNING: Unknown variable types count: 50 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.badlogic.gdx.utils.JsonValue parse(java.io.Reader r26) {
        /*
            r25 = this;
            r1 = r25
            r0 = 1024(0x400, float:1.435E-42)
            char[] r0 = new char[r0]
            r2 = 0
            r2 = r0
            r3 = 0
        L_0x0009:
            int r0 = r2.length     // Catch:{ IOException -> 0x0510, all -> 0x050c }
            int r0 = r0 - r3
            r4 = r26
            int r0 = r4.read(r2, r3, r0)     // Catch:{ IOException -> 0x050a }
            r5 = -1
            if (r0 != r5) goto L_0x04f6
            r26.close()     // Catch:{ all -> 0x0017 }
        L_0x0017:
            r0 = 4
            int[] r0 = new int[r0]
            com.badlogic.gdx.utils.Array r4 = new com.badlogic.gdx.utils.Array
            r5 = 8
            r6 = 1
            r4.<init>(r6, r5)
            r5 = 0
            r7 = 0
            r8 = 0
            r9 = 1
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
        L_0x002a:
            java.lang.String r14 = "null"
            java.lang.String r15 = "false"
            r26 = r10
            java.lang.String r10 = "true"
            if (r7 == 0) goto L_0x004a
            if (r7 == r6) goto L_0x005a
            r6 = 2
            if (r7 == r6) goto L_0x0042
            r0 = 4
            if (r7 == r0) goto L_0x003e
            goto L_0x0459
        L_0x003e:
            r0 = r26
            goto L_0x0378
        L_0x0042:
            r20 = r0
            r21 = r5
            r0 = r26
            goto L_0x0365
        L_0x004a:
            if (r8 != r3) goto L_0x0050
            r7 = 4
            r10 = r26
            goto L_0x002a
        L_0x0050:
            if (r9 != 0) goto L_0x005a
            r10 = r26
            r20 = r0
            r21 = r5
            goto L_0x0368
        L_0x005a:
            short[] r6 = _json_key_offsets     // Catch:{ RuntimeException -> 0x045c }
            short r6 = r6[r9]     // Catch:{ RuntimeException -> 0x045c }
            short[] r7 = _json_index_offsets     // Catch:{ RuntimeException -> 0x045c }
            short r7 = r7[r9]     // Catch:{ RuntimeException -> 0x045c }
            byte[] r16 = _json_single_lengths     // Catch:{ RuntimeException -> 0x045c }
            byte r16 = r16[r9]     // Catch:{ RuntimeException -> 0x045c }
            if (r16 <= 0) goto L_0x00a3
            int r17 = r6 + r16
            int r18 = r17 + -1
            r19 = r11
            r11 = r18
            r18 = r12
            r12 = r6
        L_0x0073:
            if (r11 >= r12) goto L_0x007a
            int r7 = r7 + r16
            r6 = r17
            goto L_0x00a7
        L_0x007a:
            int r20 = r11 - r12
            int r20 = r20 >> 1
            int r20 = r12 + r20
            r21 = r11
            char r11 = r2[r8]     // Catch:{ RuntimeException -> 0x045c }
            char[] r22 = _json_trans_keys     // Catch:{ RuntimeException -> 0x045c }
            r23 = r12
            char r12 = r22[r20]     // Catch:{ RuntimeException -> 0x045c }
            if (r11 >= r12) goto L_0x0091
            int r11 = r20 + -1
            r12 = r23
            goto L_0x0073
        L_0x0091:
            char r11 = r2[r8]     // Catch:{ RuntimeException -> 0x045c }
            char[] r12 = _json_trans_keys     // Catch:{ RuntimeException -> 0x045c }
            char r12 = r12[r20]     // Catch:{ RuntimeException -> 0x045c }
            if (r11 <= r12) goto L_0x009e
            int r12 = r20 + 1
            r11 = r21
            goto L_0x0073
        L_0x009e:
            int r20 = r20 - r6
            int r20 = r20 + r7
            goto L_0x00e9
        L_0x00a3:
            r19 = r11
            r18 = r12
        L_0x00a7:
            byte[] r11 = _json_range_lengths     // Catch:{ RuntimeException -> 0x045c }
            byte r9 = r11[r9]     // Catch:{ RuntimeException -> 0x045c }
            if (r9 <= 0) goto L_0x00e7
            int r11 = r9 << 1
            int r11 = r11 + r6
            int r11 = r11 + -2
            r12 = r6
        L_0x00b3:
            if (r11 >= r12) goto L_0x00b6
            goto L_0x00e4
        L_0x00b6:
            int r16 = r11 - r12
            int r16 = r16 >> 1
            r16 = r16 & -2
            int r16 = r16 + r12
            r17 = r9
            char r9 = r2[r8]     // Catch:{ RuntimeException -> 0x045c }
            char[] r20 = _json_trans_keys     // Catch:{ RuntimeException -> 0x045c }
            r21 = r11
            char r11 = r20[r16]     // Catch:{ RuntimeException -> 0x045c }
            if (r9 >= r11) goto L_0x00cf
            int r11 = r16 + -2
            r9 = r17
            goto L_0x00b3
        L_0x00cf:
            char r9 = r2[r8]     // Catch:{ RuntimeException -> 0x045c }
            char[] r11 = _json_trans_keys     // Catch:{ RuntimeException -> 0x045c }
            int r12 = r16 + 1
            char r11 = r11[r12]     // Catch:{ RuntimeException -> 0x045c }
            if (r9 <= r11) goto L_0x00e0
            int r12 = r16 + 2
            r9 = r17
            r11 = r21
            goto L_0x00b3
        L_0x00e0:
            int r16 = r16 - r6
            int r9 = r16 >> 1
        L_0x00e4:
            int r20 = r7 + r9
            goto L_0x00e9
        L_0x00e7:
            r20 = r7
        L_0x00e9:
            byte[] r6 = _json_indicies     // Catch:{ RuntimeException -> 0x045c }
            byte r6 = r6[r20]     // Catch:{ RuntimeException -> 0x045c }
            byte[] r7 = _json_trans_targs     // Catch:{ RuntimeException -> 0x045c }
            byte r7 = r7[r6]     // Catch:{ RuntimeException -> 0x045c }
            byte[] r9 = _json_trans_actions     // Catch:{ RuntimeException -> 0x045c }
            byte r9 = r9[r6]     // Catch:{ RuntimeException -> 0x045c }
            if (r9 == 0) goto L_0x0355
            byte[] r9 = _json_trans_actions     // Catch:{ RuntimeException -> 0x045c }
            byte r6 = r9[r6]     // Catch:{ RuntimeException -> 0x045c }
            byte[] r9 = _json_actions     // Catch:{ RuntimeException -> 0x045c }
            int r11 = r6 + 1
            byte r6 = r9[r6]     // Catch:{ RuntimeException -> 0x045c }
            r9 = r26
            r12 = r11
            r11 = r19
        L_0x0106:
            int r16 = r6 + -1
            if (r6 <= 0) goto L_0x034b
            byte[] r6 = _json_actions     // Catch:{ RuntimeException -> 0x0346 }
            int r17 = r12 + 1
            byte r6 = r6[r12]     // Catch:{ RuntimeException -> 0x0346 }
            switch(r6) {
                case 0: goto L_0x0332;
                case 1: goto L_0x0274;
                case 2: goto L_0x0248;
                case 3: goto L_0x0237;
                case 4: goto L_0x0210;
                case 5: goto L_0x0208;
                case 6: goto L_0x01c7;
                case 7: goto L_0x0141;
                case 8: goto L_0x011c;
                default: goto L_0x0113;
            }
        L_0x0113:
            r20 = r0
            r21 = r5
            r0 = r7
            r26 = r8
            goto L_0x033b
        L_0x011c:
            int r8 = r8 + 1
            r6 = 0
            r9 = r8
        L_0x0120:
            char r11 = r2[r9]     // Catch:{ RuntimeException -> 0x013e }
            r12 = 34
            if (r11 == r12) goto L_0x0132
            r12 = 92
            if (r11 == r12) goto L_0x012b
            goto L_0x012e
        L_0x012b:
            int r9 = r9 + 1
            r6 = 1
        L_0x012e:
            int r9 = r9 + 1
            if (r9 != r3) goto L_0x0120
        L_0x0132:
            r11 = r6
            int r6 = r9 + -1
        L_0x0135:
            r20 = r0
            r21 = r5
            r0 = r7
            r9 = r8
            r8 = r6
            goto L_0x033b
        L_0x013e:
            r0 = move-exception
            goto L_0x0205
        L_0x0141:
            r6 = 13
            if (r18 == 0) goto L_0x0176
            r9 = 0
            r11 = r8
        L_0x0147:
            char r12 = r2[r11]     // Catch:{ RuntimeException -> 0x0173 }
            r13 = 10
            if (r12 == r13) goto L_0x01b6
            if (r12 == r6) goto L_0x01b6
            r13 = 47
            if (r12 == r13) goto L_0x015e
            r13 = 58
            if (r12 == r13) goto L_0x01b6
            r13 = 92
            if (r12 == r13) goto L_0x015c
            goto L_0x016e
        L_0x015c:
            r9 = 1
            goto L_0x016e
        L_0x015e:
            int r12 = r11 + 1
            if (r12 != r3) goto L_0x0163
            goto L_0x016e
        L_0x0163:
            char r12 = r2[r12]     // Catch:{ RuntimeException -> 0x0173 }
            r13 = 47
            if (r12 == r13) goto L_0x01b6
            r13 = 42
            if (r12 != r13) goto L_0x016e
            goto L_0x01b6
        L_0x016e:
            int r11 = r11 + 1
            if (r11 != r3) goto L_0x0147
            goto L_0x01b6
        L_0x0173:
            r0 = move-exception
            goto L_0x045e
        L_0x0176:
            r9 = 0
            r9 = r8
            r11 = 0
        L_0x0179:
            char r12 = r2[r9]     // Catch:{ RuntimeException -> 0x013e }
            r13 = 10
            if (r12 == r13) goto L_0x01b1
            if (r12 == r6) goto L_0x01b1
            r6 = 44
            if (r12 == r6) goto L_0x01b1
            r6 = 47
            if (r12 == r6) goto L_0x0199
            r6 = 125(0x7d, float:1.75E-43)
            if (r12 == r6) goto L_0x01b1
            r6 = 92
            if (r12 == r6) goto L_0x0196
            r6 = 93
            if (r12 == r6) goto L_0x01b1
            goto L_0x01a9
        L_0x0196:
            r6 = 1
            r11 = 1
            goto L_0x01a9
        L_0x0199:
            int r6 = r9 + 1
            if (r6 != r3) goto L_0x019e
            goto L_0x01a9
        L_0x019e:
            char r6 = r2[r6]     // Catch:{ RuntimeException -> 0x013e }
            r12 = 47
            if (r6 == r12) goto L_0x01b1
            r12 = 42
            if (r6 != r12) goto L_0x01a9
            goto L_0x01b1
        L_0x01a9:
            int r9 = r9 + 1
            if (r9 != r3) goto L_0x01ae
            goto L_0x01b1
        L_0x01ae:
            r6 = 13
            goto L_0x0179
        L_0x01b1:
            r24 = r11
            r11 = r9
            r9 = r24
        L_0x01b6:
            int r11 = r11 + -1
            char r6 = r2[r11]     // Catch:{ RuntimeException -> 0x0173 }
            boolean r6 = java.lang.Character.isSpace(r6)     // Catch:{ RuntimeException -> 0x0173 }
            if (r6 == 0) goto L_0x01c1
            goto L_0x01b6
        L_0x01c1:
            r6 = 1
            r6 = r11
            r13 = 1
            r11 = r9
            goto L_0x0135
        L_0x01c7:
            int r6 = r8 + 1
            char r8 = r2[r8]     // Catch:{ RuntimeException -> 0x0203 }
            r12 = 47
            if (r8 != r12) goto L_0x01e4
            r8 = r6
        L_0x01d0:
            if (r8 == r3) goto L_0x01db
            char r6 = r2[r8]     // Catch:{ RuntimeException -> 0x045c }
            r12 = 10
            if (r6 == r12) goto L_0x01db
            int r8 = r8 + 1
            goto L_0x01d0
        L_0x01db:
            int r8 = r8 + -1
            r20 = r0
            r21 = r5
            r0 = r7
            goto L_0x033b
        L_0x01e4:
            r8 = r6
            int r6 = r8 + 1
            if (r6 >= r3) goto L_0x01f2
            char r12 = r2[r8]     // Catch:{ RuntimeException -> 0x0346 }
            r26 = r8
            r8 = 42
            if (r12 != r8) goto L_0x01e4
            goto L_0x01f4
        L_0x01f2:
            r26 = r8
        L_0x01f4:
            char r8 = r2[r6]     // Catch:{ RuntimeException -> 0x01fe }
            r12 = 47
            if (r8 == r12) goto L_0x01fb
            goto L_0x01e4
        L_0x01fb:
            r8 = r9
            goto L_0x0135
        L_0x01fe:
            r0 = move-exception
            r8 = r26
            goto L_0x045a
        L_0x0203:
            r0 = move-exception
            r9 = r6
        L_0x0205:
            r11 = r9
            goto L_0x045e
        L_0x0208:
            r25.pop()     // Catch:{ RuntimeException -> 0x045c }
            int r5 = r5 + -1
            r6 = r0[r5]     // Catch:{ RuntimeException -> 0x045c }
            goto L_0x023e
        L_0x0210:
            int r6 = r4.size     // Catch:{ RuntimeException -> 0x045c }
            if (r6 <= 0) goto L_0x021b
            java.lang.Object r6 = r4.pop()     // Catch:{ RuntimeException -> 0x045c }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ RuntimeException -> 0x045c }
            goto L_0x021c
        L_0x021b:
            r6 = 0
        L_0x021c:
            r1.startArray(r6)     // Catch:{ RuntimeException -> 0x045c }
            int r6 = r0.length     // Catch:{ RuntimeException -> 0x045c }
            if (r5 != r6) goto L_0x022d
            int r6 = r0.length     // Catch:{ RuntimeException -> 0x045c }
            int r6 = r6 * 2
            int[] r6 = new int[r6]     // Catch:{ RuntimeException -> 0x045c }
            int r10 = r0.length     // Catch:{ RuntimeException -> 0x045c }
            r12 = 0
            java.lang.System.arraycopy(r0, r12, r6, r12, r10)     // Catch:{ RuntimeException -> 0x045c }
            r0 = r6
        L_0x022d:
            int r6 = r5 + 1
            r0[r5] = r7     // Catch:{ RuntimeException -> 0x045c }
            r5 = 23
            r5 = r6
            r6 = 23
            goto L_0x023e
        L_0x0237:
            r25.pop()     // Catch:{ RuntimeException -> 0x045c }
            int r5 = r5 + -1
            r6 = r0[r5]     // Catch:{ RuntimeException -> 0x045c }
        L_0x023e:
            r7 = 1
            r10 = 2
            r10 = r9
            r12 = r18
            r7 = 2
            r9 = r6
            r6 = 1
            goto L_0x002a
        L_0x0248:
            int r6 = r4.size     // Catch:{ RuntimeException -> 0x045c }
            if (r6 <= 0) goto L_0x0253
            java.lang.Object r6 = r4.pop()     // Catch:{ RuntimeException -> 0x045c }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ RuntimeException -> 0x045c }
            goto L_0x0254
        L_0x0253:
            r6 = 0
        L_0x0254:
            r1.startObject(r6)     // Catch:{ RuntimeException -> 0x045c }
            int r6 = r0.length     // Catch:{ RuntimeException -> 0x045c }
            if (r5 != r6) goto L_0x0265
            int r6 = r0.length     // Catch:{ RuntimeException -> 0x045c }
            int r6 = r6 * 2
            int[] r6 = new int[r6]     // Catch:{ RuntimeException -> 0x045c }
            int r10 = r0.length     // Catch:{ RuntimeException -> 0x045c }
            r12 = 0
            java.lang.System.arraycopy(r0, r12, r6, r12, r10)     // Catch:{ RuntimeException -> 0x045c }
            r0 = r6
        L_0x0265:
            int r6 = r5 + 1
            r0[r5] = r7     // Catch:{ RuntimeException -> 0x045c }
            r5 = 1
            r7 = 2
            r10 = 5
            r5 = r6
            r10 = r9
            r12 = r18
            r6 = 1
            r9 = 5
            goto L_0x002a
        L_0x0274:
            java.lang.String r6 = new java.lang.String     // Catch:{ RuntimeException -> 0x0346 }
            int r12 = r8 - r9
            r6.<init>(r2, r9, r12)     // Catch:{ RuntimeException -> 0x0346 }
            if (r11 == 0) goto L_0x0281
            java.lang.String r6 = r1.unescape(r6)     // Catch:{ RuntimeException -> 0x045c }
        L_0x0281:
            if (r18 == 0) goto L_0x0292
            r4.add(r6)     // Catch:{ RuntimeException -> 0x045c }
            r6 = 0
            r20 = r0
            r21 = r5
            r0 = r7
            r26 = r8
            r18 = 0
            goto L_0x032d
        L_0x0292:
            int r12 = r4.size     // Catch:{ RuntimeException -> 0x0346 }
            if (r12 <= 0) goto L_0x029d
            java.lang.Object r12 = r4.pop()     // Catch:{ RuntimeException -> 0x045c }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ RuntimeException -> 0x045c }
            goto L_0x029e
        L_0x029d:
            r12 = 0
        L_0x029e:
            if (r13 == 0) goto L_0x0323
            boolean r13 = r6.equals(r10)     // Catch:{ RuntimeException -> 0x0346 }
            if (r13 == 0) goto L_0x02ab
            r6 = 1
            r1.bool(r12, r6)     // Catch:{ RuntimeException -> 0x045c }
            goto L_0x02c0
        L_0x02ab:
            boolean r13 = r6.equals(r15)     // Catch:{ RuntimeException -> 0x0346 }
            if (r13 == 0) goto L_0x02b6
            r6 = 0
            r1.bool(r12, r6)     // Catch:{ RuntimeException -> 0x045c }
            goto L_0x02c0
        L_0x02b6:
            boolean r13 = r6.equals(r14)     // Catch:{ RuntimeException -> 0x0346 }
            if (r13 == 0) goto L_0x02c9
            r6 = 0
            r1.string(r12, r6)     // Catch:{ RuntimeException -> 0x045c }
        L_0x02c0:
            r20 = r0
            r21 = r5
            r0 = r7
            r26 = r8
            goto L_0x032d
        L_0x02c9:
            r13 = 0
            r19 = 1
        L_0x02cc:
            if (r9 >= r8) goto L_0x02fb
            r20 = r0
            char r0 = r2[r9]     // Catch:{ RuntimeException -> 0x045c }
            r21 = r5
            r5 = 43
            if (r0 == r5) goto L_0x02f4
            r5 = 69
            if (r0 == r5) goto L_0x02ef
            r5 = 101(0x65, float:1.42E-43)
            if (r0 == r5) goto L_0x02ef
            r5 = 45
            if (r0 == r5) goto L_0x02f4
            r5 = 46
            if (r0 == r5) goto L_0x02ef
            switch(r0) {
                case 48: goto L_0x02f4;
                case 49: goto L_0x02f4;
                case 50: goto L_0x02f4;
                case 51: goto L_0x02f4;
                case 52: goto L_0x02f4;
                case 53: goto L_0x02f4;
                case 54: goto L_0x02f4;
                case 55: goto L_0x02f4;
                case 56: goto L_0x02f4;
                case 57: goto L_0x02f4;
                default: goto L_0x02eb;
            }
        L_0x02eb:
            r13 = 0
            r19 = 0
            goto L_0x02ff
        L_0x02ef:
            r0 = 1
            r5 = 0
            r13 = 1
            r19 = 0
        L_0x02f4:
            int r9 = r9 + 1
            r0 = r20
            r5 = r21
            goto L_0x02cc
        L_0x02fb:
            r20 = r0
            r21 = r5
        L_0x02ff:
            if (r13 == 0) goto L_0x0311
            r0 = r7
            r26 = r8
            double r7 = java.lang.Double.parseDouble(r6)     // Catch:{ NumberFormatException -> 0x032a }
            com.badlogic.gdx.utils.JsonValue r5 = new com.badlogic.gdx.utils.JsonValue     // Catch:{ NumberFormatException -> 0x032a }
            r5.<init>(r7, r6)     // Catch:{ NumberFormatException -> 0x032a }
            r1.addChild(r12, r5)     // Catch:{ NumberFormatException -> 0x032a }
            goto L_0x032d
        L_0x0311:
            r0 = r7
            r26 = r8
            if (r19 == 0) goto L_0x032a
            long r7 = java.lang.Long.parseLong(r6)     // Catch:{ NumberFormatException -> 0x032a }
            com.badlogic.gdx.utils.JsonValue r5 = new com.badlogic.gdx.utils.JsonValue     // Catch:{ NumberFormatException -> 0x032a }
            r5.<init>(r7, r6)     // Catch:{ NumberFormatException -> 0x032a }
            r1.addChild(r12, r5)     // Catch:{ NumberFormatException -> 0x032a }
            goto L_0x032d
        L_0x0323:
            r20 = r0
            r21 = r5
            r0 = r7
            r26 = r8
        L_0x032a:
            r1.string(r12, r6)     // Catch:{ RuntimeException -> 0x01fe }
        L_0x032d:
            r13 = 0
            r8 = r26
            r9 = r8
            goto L_0x033b
        L_0x0332:
            r20 = r0
            r21 = r5
            r0 = r7
            r26 = r8
            r18 = 1
        L_0x033b:
            r7 = r0
            r6 = r16
            r12 = r17
            r0 = r20
            r5 = r21
            goto L_0x0106
        L_0x0346:
            r0 = move-exception
            r26 = r8
            goto L_0x045a
        L_0x034b:
            r20 = r0
            r21 = r5
            r0 = r7
            r26 = r8
            r12 = r18
            goto L_0x0360
        L_0x0355:
            r20 = r0
            r21 = r5
            r0 = r7
            r9 = r26
            r12 = r18
            r11 = r19
        L_0x0360:
            r24 = r9
            r9 = r0
            r0 = r24
        L_0x0365:
            if (r9 != 0) goto L_0x0370
            r10 = r0
        L_0x0368:
            r6 = 1
            r7 = 5
        L_0x036a:
            r0 = r20
            r5 = r21
            goto L_0x002a
        L_0x0370:
            int r8 = r8 + 1
            if (r8 == r3) goto L_0x0378
            r6 = 1
            r7 = 1
            r10 = r0
            goto L_0x036a
        L_0x0378:
            if (r8 != r3) goto L_0x0457
            byte[] r5 = _json_eof_actions     // Catch:{ RuntimeException -> 0x0454 }
            byte r5 = r5[r9]     // Catch:{ RuntimeException -> 0x0454 }
            byte[] r6 = _json_actions     // Catch:{ RuntimeException -> 0x0454 }
            int r7 = r5 + 1
            byte r5 = r6[r5]     // Catch:{ RuntimeException -> 0x0454 }
        L_0x0384:
            int r6 = r5 + -1
            if (r5 <= 0) goto L_0x0457
            byte[] r5 = _json_actions     // Catch:{ RuntimeException -> 0x0454 }
            int r9 = r7 + 1
            byte r5 = r5[r7]     // Catch:{ RuntimeException -> 0x0454 }
            r7 = 1
            if (r5 == r7) goto L_0x039a
            r5 = r0
            r26 = r4
            r17 = r6
            r4 = r8
            r0 = r9
            goto L_0x0448
        L_0x039a:
            java.lang.String r5 = new java.lang.String     // Catch:{ RuntimeException -> 0x0454 }
            int r7 = r8 - r0
            r5.<init>(r2, r0, r7)     // Catch:{ RuntimeException -> 0x0454 }
            if (r11 == 0) goto L_0x03a7
            java.lang.String r5 = r1.unescape(r5)     // Catch:{ RuntimeException -> 0x045c }
        L_0x03a7:
            if (r12 == 0) goto L_0x03b5
            r4.add(r5)     // Catch:{ RuntimeException -> 0x045c }
            r12 = 0
        L_0x03ad:
            r26 = r4
            r17 = r6
            r4 = r8
            r0 = r9
            goto L_0x0445
        L_0x03b5:
            int r7 = r4.size     // Catch:{ RuntimeException -> 0x0454 }
            if (r7 <= 0) goto L_0x03c0
            java.lang.Object r7 = r4.pop()     // Catch:{ RuntimeException -> 0x045c }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ RuntimeException -> 0x045c }
            goto L_0x03c1
        L_0x03c0:
            r7 = 0
        L_0x03c1:
            if (r13 == 0) goto L_0x043c
            boolean r13 = r5.equals(r10)     // Catch:{ RuntimeException -> 0x0454 }
            if (r13 == 0) goto L_0x03ce
            r0 = 1
            r1.bool(r7, r0)     // Catch:{ RuntimeException -> 0x045c }
            goto L_0x03ad
        L_0x03ce:
            boolean r13 = r5.equals(r15)     // Catch:{ RuntimeException -> 0x0454 }
            if (r13 == 0) goto L_0x03d9
            r0 = 0
            r1.bool(r7, r0)     // Catch:{ RuntimeException -> 0x045c }
            goto L_0x03ad
        L_0x03d9:
            boolean r13 = r5.equals(r14)     // Catch:{ RuntimeException -> 0x0454 }
            if (r13 == 0) goto L_0x03e4
            r0 = 0
            r1.string(r7, r0)     // Catch:{ RuntimeException -> 0x045c }
            goto L_0x03ad
        L_0x03e4:
            r13 = 0
            r16 = 1
        L_0x03e7:
            if (r0 >= r8) goto L_0x0416
            r26 = r4
            char r4 = r2[r0]     // Catch:{ RuntimeException -> 0x045c }
            r17 = r6
            r6 = 43
            if (r4 == r6) goto L_0x040f
            r6 = 69
            if (r4 == r6) goto L_0x040a
            r6 = 101(0x65, float:1.42E-43)
            if (r4 == r6) goto L_0x040a
            r6 = 45
            if (r4 == r6) goto L_0x040f
            r6 = 46
            if (r4 == r6) goto L_0x040a
            switch(r4) {
                case 48: goto L_0x040f;
                case 49: goto L_0x040f;
                case 50: goto L_0x040f;
                case 51: goto L_0x040f;
                case 52: goto L_0x040f;
                case 53: goto L_0x040f;
                case 54: goto L_0x040f;
                case 55: goto L_0x040f;
                case 56: goto L_0x040f;
                case 57: goto L_0x040f;
                default: goto L_0x0406;
            }
        L_0x0406:
            r13 = 0
            r16 = 0
            goto L_0x041a
        L_0x040a:
            r4 = 1
            r6 = 0
            r13 = 1
            r16 = 0
        L_0x040f:
            int r0 = r0 + 1
            r4 = r26
            r6 = r17
            goto L_0x03e7
        L_0x0416:
            r26 = r4
            r17 = r6
        L_0x041a:
            if (r13 == 0) goto L_0x042b
            r4 = r8
            r0 = r9
            double r8 = java.lang.Double.parseDouble(r5)     // Catch:{ NumberFormatException -> 0x0442 }
            com.badlogic.gdx.utils.JsonValue r6 = new com.badlogic.gdx.utils.JsonValue     // Catch:{ NumberFormatException -> 0x0442 }
            r6.<init>(r8, r5)     // Catch:{ NumberFormatException -> 0x0442 }
            r1.addChild(r7, r6)     // Catch:{ NumberFormatException -> 0x0442 }
            goto L_0x0445
        L_0x042b:
            r4 = r8
            r0 = r9
            if (r16 == 0) goto L_0x0442
            long r8 = java.lang.Long.parseLong(r5)     // Catch:{ NumberFormatException -> 0x0442 }
            com.badlogic.gdx.utils.JsonValue r6 = new com.badlogic.gdx.utils.JsonValue     // Catch:{ NumberFormatException -> 0x0442 }
            r6.<init>(r8, r5)     // Catch:{ NumberFormatException -> 0x0442 }
            r1.addChild(r7, r6)     // Catch:{ NumberFormatException -> 0x0442 }
            goto L_0x0445
        L_0x043c:
            r26 = r4
            r17 = r6
            r4 = r8
            r0 = r9
        L_0x0442:
            r1.string(r7, r5)     // Catch:{ RuntimeException -> 0x0451 }
        L_0x0445:
            r5 = 0
            r5 = r4
            r13 = 0
        L_0x0448:
            r7 = r0
            r8 = r4
            r0 = r5
            r5 = r17
            r4 = r26
            goto L_0x0384
        L_0x0451:
            r0 = move-exception
            r8 = r4
            goto L_0x045a
        L_0x0454:
            r0 = move-exception
            r4 = r8
            goto L_0x045a
        L_0x0457:
            r4 = r8
            r8 = r4
        L_0x0459:
            r0 = 0
        L_0x045a:
            r11 = r8
            goto L_0x045e
        L_0x045c:
            r0 = move-exception
            goto L_0x045a
        L_0x045e:
            com.badlogic.gdx.utils.JsonValue r4 = r1.root
            r5 = 0
            r1.root = r5
            r1.current = r5
            com.badlogic.gdx.utils.Array<com.badlogic.gdx.utils.JsonValue> r5 = r1.lastChild
            r5.clear()
            if (r11 >= r3) goto L_0x04b2
            r4 = 0
            r5 = 1
        L_0x046e:
            if (r4 >= r11) goto L_0x047b
            char r6 = r2[r4]
            r7 = 10
            if (r6 != r7) goto L_0x0478
            int r5 = r5 + 1
        L_0x0478:
            int r4 = r4 + 1
            goto L_0x046e
        L_0x047b:
            int r4 = r11 + -32
            r6 = 0
            int r4 = java.lang.Math.max(r6, r4)
            com.badlogic.gdx.utils.SerializationException r6 = new com.badlogic.gdx.utils.SerializationException
            java.lang.String r7 = "Error parsing JSON on line "
            java.lang.String r8 = " near: "
            java.lang.StringBuilder r5 = com.android.tools.r8.GeneratedOutlineSupport.outline74(r7, r5, r8)
            java.lang.String r7 = new java.lang.String
            int r8 = r11 - r4
            r7.<init>(r2, r4, r8)
            r5.append(r7)
            java.lang.String r4 = "*ERROR*"
            r5.append(r4)
            java.lang.String r4 = new java.lang.String
            r7 = 64
            int r3 = r3 - r11
            int r3 = java.lang.Math.min(r7, r3)
            r4.<init>(r2, r11, r3)
            r5.append(r4)
            java.lang.String r2 = r5.toString()
            r6.<init>(r2, r0)
            throw r6
        L_0x04b2:
            com.badlogic.gdx.utils.Array<com.badlogic.gdx.utils.JsonValue> r3 = r1.elements
            int r5 = r3.size
            if (r5 == 0) goto L_0x04db
            java.lang.Object r0 = r3.peek()
            com.badlogic.gdx.utils.JsonValue r0 = (com.badlogic.gdx.utils.JsonValue) r0
            com.badlogic.gdx.utils.Array<com.badlogic.gdx.utils.JsonValue> r2 = r1.elements
            r2.clear()
            if (r0 == 0) goto L_0x04d3
            boolean r0 = r0.isObject()
            if (r0 == 0) goto L_0x04d3
            com.badlogic.gdx.utils.SerializationException r0 = new com.badlogic.gdx.utils.SerializationException
            java.lang.String r2 = "Error parsing JSON, unmatched brace."
            r0.<init>(r2)
            throw r0
        L_0x04d3:
            com.badlogic.gdx.utils.SerializationException r0 = new com.badlogic.gdx.utils.SerializationException
            java.lang.String r2 = "Error parsing JSON, unmatched bracket."
            r0.<init>(r2)
            throw r0
        L_0x04db:
            if (r0 != 0) goto L_0x04de
            return r4
        L_0x04de:
            com.badlogic.gdx.utils.SerializationException r3 = new com.badlogic.gdx.utils.SerializationException
            java.lang.String r4 = "Error parsing JSON: "
            java.lang.StringBuilder r4 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r4)
            java.lang.String r5 = new java.lang.String
            r5.<init>(r2)
            r4.append(r5)
            java.lang.String r2 = r4.toString()
            r3.<init>(r2, r0)
            throw r3
        L_0x04f6:
            if (r0 != 0) goto L_0x0505
            int r0 = r2.length     // Catch:{ IOException -> 0x050a }
            int r0 = r0 * 2
            char[] r0 = new char[r0]     // Catch:{ IOException -> 0x050a }
            int r5 = r2.length     // Catch:{ IOException -> 0x050a }
            r6 = 0
            java.lang.System.arraycopy(r2, r6, r0, r6, r5)     // Catch:{ IOException -> 0x050a }
            r2 = r0
            goto L_0x0009
        L_0x0505:
            int r3 = r3 + r0
            goto L_0x0009
        L_0x0508:
            r0 = move-exception
            goto L_0x051b
        L_0x050a:
            r0 = move-exception
            goto L_0x0513
        L_0x050c:
            r0 = move-exception
            r4 = r26
            goto L_0x051b
        L_0x0510:
            r0 = move-exception
            r4 = r26
        L_0x0513:
            com.badlogic.gdx.utils.SerializationException r2 = new com.badlogic.gdx.utils.SerializationException     // Catch:{ all -> 0x0508 }
            java.lang.String r3 = "Error reading input."
            r2.<init>(r3, r0)     // Catch:{ all -> 0x0508 }
            throw r2     // Catch:{ all -> 0x0508 }
        L_0x051b:
            r26.close()     // Catch:{ all -> 0x051e }
        L_0x051e:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.utils.JsonReader.parse(java.io.Reader):com.badlogic.gdx.utils.JsonValue");
    }

    public void pop() {
        this.root = (JsonValue) this.elements.pop();
        if (this.current.size > 0) {
            this.lastChild.pop();
        }
        Array<JsonValue> array = this.elements;
        this.current = array.size > 0 ? (JsonValue) array.peek() : null;
    }

    public void startArray(String str) {
        JsonValue jsonValue = new JsonValue(ValueType.array);
        if (this.current != null) {
            addChild(str, jsonValue);
        }
        this.elements.add(jsonValue);
        this.current = jsonValue;
    }

    public void startObject(String str) {
        JsonValue jsonValue = new JsonValue(ValueType.object);
        if (this.current != null) {
            addChild(str, jsonValue);
        }
        this.elements.add(jsonValue);
        this.current = jsonValue;
    }

    public void string(String str, String str2) {
        addChild(str, new JsonValue(str2));
    }

    public final String unescape(String str) {
        int length = str.length();
        StringBuilder stringBuilder = new StringBuilder(length + 16);
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            char charAt = str.charAt(i);
            if (charAt != '\\') {
                stringBuilder.append0(charAt);
            } else if (i2 == length) {
                break;
            } else {
                i = i2 + 1;
                char charAt2 = str.charAt(i2);
                if (charAt2 == 'u') {
                    i2 = i + 4;
                    char[] chars = Character.toChars(Integer.parseInt(str.substring(i, i2), 16));
                    int length2 = stringBuilder.length + chars.length;
                    if (length2 > stringBuilder.chars.length) {
                        stringBuilder.enlargeBuffer(length2);
                    }
                    System.arraycopy(chars, 0, stringBuilder.chars, stringBuilder.length, chars.length);
                    stringBuilder.length = length2;
                } else {
                    if (!(charAt2 == '\"' || charAt2 == '/' || charAt2 == '\\')) {
                        if (charAt2 == 'b') {
                            charAt2 = 8;
                        } else if (charAt2 == 'f') {
                            charAt2 = Tokenizer.FF;
                        } else if (charAt2 == 'n') {
                            charAt2 = 10;
                        } else if (charAt2 == 'r') {
                            charAt2 = 13;
                        } else if (charAt2 == 't') {
                            charAt2 = 9;
                        } else {
                            throw new SerializationException("Illegal escaped character: \\" + charAt2);
                        }
                    }
                    stringBuilder.append0(charAt2);
                }
            }
            i = i2;
        }
        return stringBuilder.toString();
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0030 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.badlogic.gdx.utils.JsonValue parse(com.badlogic.gdx.files.FileHandle r5) {
        /*
            r4 = this;
            java.lang.String r0 = "Error reading file: "
            java.lang.String r1 = "UTF-8"
            java.io.InputStream r2 = r5.read()     // Catch:{ Exception -> 0x0045 }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ UnsupportedEncodingException -> 0x002a }
            r3.<init>(r2, r1)     // Catch:{ UnsupportedEncodingException -> 0x002a }
            com.badlogic.gdx.utils.JsonValue r5 = r4.parse(r3)     // Catch:{ Exception -> 0x0012 }
            return r5
        L_0x0012:
            r0 = move-exception
            com.badlogic.gdx.utils.SerializationException r1 = new com.badlogic.gdx.utils.SerializationException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Error parsing file: "
            r2.append(r3)
            r2.append(r5)
            java.lang.String r5 = r2.toString()
            r1.<init>(r5, r0)
            throw r1
        L_0x002a:
            r1 = move-exception
            if (r2 == 0) goto L_0x0030
            r2.close()     // Catch:{ all -> 0x0030 }
        L_0x0030:
            com.badlogic.gdx.utils.GdxRuntimeException r2 = new com.badlogic.gdx.utils.GdxRuntimeException     // Catch:{ Exception -> 0x0045 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0045 }
            r3.<init>()     // Catch:{ Exception -> 0x0045 }
            r3.append(r0)     // Catch:{ Exception -> 0x0045 }
            r3.append(r5)     // Catch:{ Exception -> 0x0045 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0045 }
            r2.<init>(r3, r1)     // Catch:{ Exception -> 0x0045 }
            throw r2     // Catch:{ Exception -> 0x0045 }
        L_0x0045:
            r1 = move-exception
            com.badlogic.gdx.utils.SerializationException r2 = new com.badlogic.gdx.utils.SerializationException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r0)
            r3.append(r5)
            java.lang.String r5 = r3.toString()
            r2.<init>(r5, r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.utils.JsonReader.parse(com.badlogic.gdx.files.FileHandle):com.badlogic.gdx.utils.JsonValue");
    }
}

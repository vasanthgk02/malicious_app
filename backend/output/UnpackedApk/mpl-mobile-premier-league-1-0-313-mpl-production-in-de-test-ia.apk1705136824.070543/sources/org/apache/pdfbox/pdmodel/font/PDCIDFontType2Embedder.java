package org.apache.pdfbox.pdmodel.font;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSInteger;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.COSObjectable;
import org.apache.pdfbox.pdmodel.common.PDStream;
import sfs2x.client.entities.invitation.InvitationReply;

public final class PDCIDFontType2Embedder extends TrueTypeEmbedder {
    public final COSDictionary cidFont = createCIDFont();
    public final COSDictionary dict;
    public final PDDocument document;
    public final Map<Integer, Integer> gidToUni;
    public final PDType0Font parent;

    /* renamed from: org.apache.pdfbox.pdmodel.font.PDCIDFontType2Embedder$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$org$apache$pdfbox$pdmodel$font$PDCIDFontType2Embedder$State;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|(2:1|2)|3|5|6|7|8|10) */
        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0016 */
        static {
            /*
                org.apache.pdfbox.pdmodel.font.PDCIDFontType2Embedder$State[] r0 = org.apache.pdfbox.pdmodel.font.PDCIDFontType2Embedder.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$apache$pdfbox$pdmodel$font$PDCIDFontType2Embedder$State = r0
                r1 = 1
                org.apache.pdfbox.pdmodel.font.PDCIDFontType2Embedder$State r2 = org.apache.pdfbox.pdmodel.font.PDCIDFontType2Embedder.State.FIRST     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 2
                int[] r2 = $SwitchMap$org$apache$pdfbox$pdmodel$font$PDCIDFontType2Embedder$State     // Catch:{ NoSuchFieldError -> 0x0016 }
                org.apache.pdfbox.pdmodel.font.PDCIDFontType2Embedder$State r3 = org.apache.pdfbox.pdmodel.font.PDCIDFontType2Embedder.State.BRACKET     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                int[] r1 = $SwitchMap$org$apache$pdfbox$pdmodel$font$PDCIDFontType2Embedder$State     // Catch:{ NoSuchFieldError -> 0x001d }
                org.apache.pdfbox.pdmodel.font.PDCIDFontType2Embedder$State r2 = org.apache.pdfbox.pdmodel.font.PDCIDFontType2Embedder.State.SERIAL     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 3
                r1[r0] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.apache.pdfbox.pdmodel.font.PDCIDFontType2Embedder.AnonymousClass1.<clinit>():void");
        }
    }

    public enum State {
        FIRST,
        BRACKET,
        SERIAL
    }

    public PDCIDFontType2Embedder(PDDocument pDDocument, COSDictionary cOSDictionary, InputStream inputStream, boolean z, PDType0Font pDType0Font) throws IOException {
        super(pDDocument, cOSDictionary, inputStream, z);
        this.document = pDDocument;
        this.dict = cOSDictionary;
        this.parent = pDType0Font;
        cOSDictionary.setItem(COSName.SUBTYPE, (COSBase) COSName.TYPE0);
        cOSDictionary.setName(COSName.BASE_FONT, this.fontDescriptor.getFontName());
        cOSDictionary.setItem(COSName.ENCODING, (COSBase) COSName.IDENTITY_H);
        COSArray cOSArray = new COSArray();
        cOSArray.add((COSBase) this.cidFont);
        cOSDictionary.setItem(COSName.DESCENDANT_FONTS, (COSBase) cOSArray);
        this.gidToUni = new HashMap();
        int numGlyphs = this.ttf.getMaximumProfile().getNumGlyphs();
        for (int i = 1; i <= numGlyphs; i++) {
            Integer characterCode = this.cmap.getCharacterCode(i);
            if (characterCode != null) {
                this.gidToUni.put(Integer.valueOf(i), characterCode);
            }
        }
        buildToUnicodeCMap(null);
    }

    private void addNameTag(String str) throws IOException {
        String outline50 = GeneratedOutlineSupport.outline50(str, this.fontDescriptor.getFontName());
        this.dict.setName(COSName.BASE_FONT, outline50);
        this.fontDescriptor.setFontName(outline50);
        this.cidFont.setName(COSName.BASE_FONT, outline50);
    }

    private void buildCIDSet(Map<Integer, Integer> map) throws IOException {
        byte[] bArr = new byte[((((Integer) Collections.max(map.keySet())).intValue() / 8) + 1)];
        for (Integer intValue : map.keySet()) {
            int intValue2 = intValue.intValue();
            int i = intValue2 / 8;
            bArr[i] = (byte) ((1 << (7 - (intValue2 % 8))) | bArr[i]);
        }
        PDStream pDStream = new PDStream(this.document, new ByteArrayInputStream(bArr));
        pDStream.addCompression();
        this.fontDescriptor.setCIDSet(pDStream);
    }

    private void buildCIDToGIDMap(Map<Integer, Integer> map) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int intValue = ((Integer) Collections.max(map.keySet())).intValue();
        for (int i = 0; i <= intValue; i++) {
            int intValue2 = map.containsKey(Integer.valueOf(i)) ? map.get(Integer.valueOf(i)).intValue() : 0;
            byteArrayOutputStream.write(new byte[]{(byte) ((intValue2 >> 8) & InvitationReply.EXPIRED), (byte) (intValue2 & InvitationReply.EXPIRED)});
        }
        PDStream pDStream = new PDStream(this.document, new ByteArrayInputStream(byteArrayOutputStream.toByteArray()), false);
        pDStream.getStream().setInt(COSName.LENGTH1, pDStream.getByteArray().length);
        pDStream.addCompression();
        this.cidFont.setItem(COSName.CID_TO_GID_MAP, (COSObjectable) pDStream);
    }

    private void buildToUnicodeCMap(Map<Integer, Integer> map) throws IOException {
        int i;
        ToUnicodeWriter toUnicodeWriter = new ToUnicodeWriter();
        int numGlyphs = this.ttf.getMaximumProfile().getNumGlyphs();
        boolean z = false;
        for (int i2 = 1; i2 <= numGlyphs; i2++) {
            if (map == null) {
                i = i2;
            } else if (!map.containsKey(Integer.valueOf(i2))) {
            } else {
                i = map.get(Integer.valueOf(i2)).intValue();
            }
            Integer num = this.gidToUni.get(Integer.valueOf(i));
            if (num != null) {
                if (num.intValue() > 65535) {
                    z = true;
                }
                toUnicodeWriter.add(i, new String(new int[]{num.intValue()}, 0, 1));
            }
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        toUnicodeWriter.writeTo(byteArrayOutputStream);
        PDStream pDStream = new PDStream(this.document, new ByteArrayInputStream(byteArrayOutputStream.toByteArray()), false);
        pDStream.addCompression();
        if (z && ((double) this.document.getVersion()) < 1.5d) {
            this.document.setVersion(1.5f);
        }
        this.dict.setItem(COSName.TO_UNICODE, (COSObjectable) pDStream);
    }

    private void buildWidths(Map<Integer, Integer> map) throws IOException {
        float unitsPerEm = 1000.0f / ((float) this.ttf.getHeader().getUnitsPerEm());
        COSArray cOSArray = new COSArray();
        COSArray cOSArray2 = new COSArray();
        int i = -1;
        for (Integer intValue : map.keySet()) {
            int intValue2 = intValue.intValue();
            if (map.containsKey(Integer.valueOf(intValue2))) {
                float advanceWidth = ((float) this.ttf.getHorizontalMetrics().getAdvanceWidth(map.get(Integer.valueOf(intValue2)).intValue())) * unitsPerEm;
                if (i != intValue2 - 1) {
                    cOSArray2 = new COSArray();
                    cOSArray.add((COSBase) COSInteger.get((long) intValue2));
                    cOSArray.add((COSBase) cOSArray2);
                }
                cOSArray2.add((COSBase) COSInteger.get((long) Math.round(advanceWidth)));
                i = intValue2;
            }
        }
        this.cidFont.setItem(COSName.W, (COSBase) cOSArray);
    }

    private COSDictionary createCIDFont() throws IOException {
        COSDictionary cOSDictionary = new COSDictionary();
        cOSDictionary.setItem(COSName.TYPE, (COSBase) COSName.FONT);
        cOSDictionary.setItem(COSName.SUBTYPE, (COSBase) COSName.CID_FONT_TYPE2);
        cOSDictionary.setName(COSName.BASE_FONT, this.fontDescriptor.getFontName());
        cOSDictionary.setItem(COSName.CIDSYSTEMINFO, (COSBase) toCIDSystemInfo("Adobe", "Identity", 0));
        cOSDictionary.setItem(COSName.FONT_DESC, (COSBase) this.fontDescriptor.getCOSObject());
        buildWidths(cOSDictionary);
        cOSDictionary.setItem(COSName.CID_TO_GID_MAP, (COSBase) COSName.IDENTITY);
        return cOSDictionary;
    }

    private COSArray getWidths(int[] iArr) throws IOException {
        State state;
        int[] iArr2 = iArr;
        if (iArr2.length != 0) {
            float unitsPerEm = 1000.0f / ((float) this.ttf.getHeader().getUnitsPerEm());
            long j = (long) iArr2[0];
            int i = 1;
            long round = (long) Math.round(((float) iArr2[1]) * unitsPerEm);
            COSArray cOSArray = null;
            COSArray cOSArray2 = new COSArray();
            cOSArray2.add((COSBase) COSInteger.get(j));
            State state2 = State.FIRST;
            int i2 = 2;
            while (i2 < iArr2.length) {
                long j2 = (long) iArr2[i2];
                int i3 = i2;
                long round2 = (long) Math.round(((float) iArr2[i2 + 1]) * unitsPerEm);
                int ordinal = state2.ordinal();
                if (ordinal == 0) {
                    int i4 = (j2 > (j + 1) ? 1 : (j2 == (j + 1) ? 0 : -1));
                    if (i4 == 0 && round2 == round) {
                        state = State.SERIAL;
                    } else {
                        if (i4 == 0) {
                            State state3 = State.BRACKET;
                            COSArray cOSArray3 = new COSArray();
                            cOSArray3.add((COSBase) COSInteger.get(round));
                            state2 = state3;
                            cOSArray = cOSArray3;
                        } else {
                            COSArray cOSArray4 = new COSArray();
                            cOSArray4.add((COSBase) COSInteger.get(round));
                            cOSArray2.add((COSBase) cOSArray4);
                            cOSArray2.add((COSBase) COSInteger.get(j2));
                            cOSArray = cOSArray4;
                        }
                        round = round2;
                        i = 1;
                        i2 = i3 + 2;
                        j = j2;
                    }
                } else if (ordinal != i) {
                    if (ordinal == 2 && !(j2 == j + 1 && round2 == round)) {
                        cOSArray2.add((COSBase) COSInteger.get(j));
                        cOSArray2.add((COSBase) COSInteger.get(round));
                        cOSArray2.add((COSBase) COSInteger.get(j2));
                        state = State.FIRST;
                    }
                    round = round2;
                    i = 1;
                    i2 = i3 + 2;
                    j = j2;
                } else {
                    int i5 = (j2 > (j + 1) ? 1 : (j2 == (j + 1) ? 0 : -1));
                    if (i5 == 0 && round2 == round) {
                        State state4 = State.SERIAL;
                        cOSArray2.add((COSBase) cOSArray);
                        cOSArray2.add((COSBase) COSInteger.get(j));
                        state2 = state4;
                        round = round2;
                        i = 1;
                        i2 = i3 + 2;
                        j = j2;
                    } else if (i5 == 0) {
                        cOSArray.add((COSBase) COSInteger.get(round));
                        round = round2;
                        i = 1;
                        i2 = i3 + 2;
                        j = j2;
                    } else {
                        state = State.FIRST;
                        cOSArray.add((COSBase) COSInteger.get(round));
                        cOSArray2.add((COSBase) cOSArray);
                        cOSArray2.add((COSBase) COSInteger.get(j2));
                    }
                }
                state2 = state;
                round = round2;
                i = 1;
                i2 = i3 + 2;
                j = j2;
            }
            int ordinal2 = state2.ordinal();
            if (ordinal2 == 0) {
                COSArray cOSArray5 = new COSArray();
                cOSArray5.add((COSBase) COSInteger.get(round));
                cOSArray2.add((COSBase) cOSArray5);
            } else if (ordinal2 == 1) {
                cOSArray.add((COSBase) COSInteger.get(round));
                cOSArray2.add((COSBase) cOSArray);
            } else if (ordinal2 == 2) {
                cOSArray2.add((COSBase) COSInteger.get(j));
                cOSArray2.add((COSBase) COSInteger.get(round));
            }
            return cOSArray2;
        }
        throw new IllegalArgumentException("length of widths must be > 0");
    }

    private COSDictionary toCIDSystemInfo(String str, String str2, int i) {
        COSDictionary cOSDictionary = new COSDictionary();
        cOSDictionary.setString(COSName.REGISTRY, str);
        cOSDictionary.setString(COSName.ORDERING, str2);
        cOSDictionary.setInt(COSName.SUPPLEMENT, i);
        return cOSDictionary;
    }

    public void buildSubset(InputStream inputStream, String str, Map<Integer, Integer> map) throws IOException {
        HashMap hashMap = new HashMap();
        for (Entry next : map.entrySet()) {
            hashMap.put(Integer.valueOf(((Integer) next.getValue()).intValue()), Integer.valueOf(((Integer) next.getKey()).intValue()));
        }
        buildFontFile2(inputStream);
        addNameTag(str);
        buildWidths((Map<Integer, Integer>) hashMap);
        buildCIDToGIDMap(hashMap);
        buildCIDSet(hashMap);
        buildToUnicodeCMap(map);
    }

    public PDCIDFont getCIDFont() throws IOException {
        return PDFontFactory.createDescendantFont(this.cidFont, this.parent);
    }

    private void buildWidths(COSDictionary cOSDictionary) throws IOException {
        int numberOfGlyphs = this.ttf.getNumberOfGlyphs();
        int[] iArr = new int[(numberOfGlyphs * 2)];
        for (int i = 0; i < numberOfGlyphs; i++) {
            int i2 = i * 2;
            iArr[i2] = i;
            iArr[i2 + 1] = this.ttf.getHorizontalMetrics().getAdvanceWidth(i);
        }
        cOSDictionary.setItem(COSName.W, (COSBase) getWidths(iArr));
    }
}

package org.apache.pdfbox.text;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;
import java.util.regex.Pattern;
import org.apache.fontbox.cmap.CMap;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem;
import org.apache.pdfbox.pdmodel.interactive.pagenavigation.PDThreadBead;

public class PDFTextStripper extends PDFTextStreamEngine {
    public static final float END_OF_LAST_TEXT_X_RESET_VALUE = -1.0f;
    public static final float EXPECTED_START_OF_NEXT_WORD_X_RESET_VALUE = -3.4028235E38f;
    public static final float LAST_WORD_SPACING_RESET_VALUE = -1.0f;
    public static final String[] LIST_ITEM_EXPRESSIONS = {"\\.", "\\d+\\.", "\\[\\d+\\]", "\\d+\\)", "[A-Z]\\.", "[a-z]\\.", "[A-Z]\\)", "[a-z]\\)", "[IVXL]+\\.", "[ivxl]+\\."};
    public static final float MAX_HEIGHT_FOR_LINE_RESET_VALUE = -1.0f;
    public static final float MAX_Y_FOR_LINE_RESET_VALUE = -3.4028235E38f;
    public static final float MIN_Y_TOP_FOR_LINE_RESET_VALUE = Float.MAX_VALUE;
    public static float defaultDropThreshold = 2.5f;
    public static float defaultIndentThreshold = 2.0f;
    public static final boolean useCustomQuickSort = true;
    public final String LINE_SEPARATOR;
    public boolean addMoreFormatting;
    public String articleEnd;
    public String articleStart;
    public float averageCharTolerance;
    public Map<String, TreeMap<Float, TreeSet<Float>>> characterListMapping;
    public Vector<List<TextPosition>> charactersByArticle;
    public int currentPageNo;
    public PDDocument document;
    public float dropThreshold;
    public PDOutlineItem endBookmark;
    public int endBookmarkPageNumber;
    public int endPage;
    public boolean inParagraph;
    public float indentThreshold;
    public String lineSeparator;
    public List<Pattern> listOfPatterns;
    public Writer output;
    public List<PDThreadBead> pageArticles;
    public String pageEnd;
    public String pageStart = "";
    public String paragraphEnd = "";
    public String paragraphStart = "";
    public boolean shouldSeparateByBeads;
    public boolean sortByPosition;
    public float spacingTolerance;
    public PDOutlineItem startBookmark;
    public int startBookmarkPageNumber;
    public int startPage;
    public boolean suppressDuplicateOverlappingText;
    public String wordSeparator = CMap.SPACE;

    public static final class LineItem {
        public static LineItem WORD_SEPARATOR = new LineItem();
        public final TextPosition textPosition;

        public LineItem() {
            this.textPosition = null;
        }

        public static LineItem getWordSeparator() {
            return WORD_SEPARATOR;
        }

        public TextPosition getTextPosition() {
            return this.textPosition;
        }

        public boolean isWordSeparator() {
            return this.textPosition == null;
        }

        public LineItem(TextPosition textPosition2) {
            this.textPosition = textPosition2;
        }
    }

    public static final class PositionWrapper {
        public boolean isArticleStart = false;
        public boolean isHangingIndent = false;
        public boolean isLineStart = false;
        public boolean isPageBreak = false;
        public boolean isParagraphStart = false;
        public TextPosition position = null;

        public PositionWrapper(TextPosition textPosition) {
            this.position = textPosition;
        }

        public TextPosition getTextPosition() {
            return this.position;
        }

        public boolean isArticleStart() {
            return this.isArticleStart;
        }

        public boolean isHangingIndent() {
            return this.isHangingIndent;
        }

        public boolean isLineStart() {
            return this.isLineStart;
        }

        public boolean isPageBreak() {
            return this.isPageBreak;
        }

        public boolean isParagraphStart() {
            return this.isParagraphStart;
        }

        public void setArticleStart() {
            this.isArticleStart = true;
        }

        public void setHangingIndent() {
            this.isHangingIndent = true;
        }

        public void setLineStart() {
            this.isLineStart = true;
        }

        public void setPageBreak() {
            this.isPageBreak = true;
        }

        public void setParagraphStart() {
            this.isParagraphStart = true;
        }
    }

    public static final class WordWithTextPositions {
        public String text;
        public List<TextPosition> textPositions;

        public WordWithTextPositions(String str, List<TextPosition> list) {
            this.text = str;
            this.textPositions = list;
        }

        public String getText() {
            return this.text;
        }

        public List<TextPosition> getTextPositions() {
            return this.textPositions;
        }
    }

    static {
        String str;
        String str2 = null;
        try {
            String lowerCase = PDFTextStripper.class.getSimpleName().toLowerCase();
            str = System.getProperty(lowerCase + ".indent");
            try {
                str2 = System.getProperty(lowerCase + ".drop");
            } catch (SecurityException unused) {
            }
        } catch (SecurityException unused2) {
            str = null;
        }
        if (str != null && str.length() > 0) {
            try {
                defaultIndentThreshold = Float.parseFloat(str);
            } catch (NumberFormatException unused3) {
            }
        }
        if (str2 != null && str2.length() > 0) {
            try {
                defaultDropThreshold = Float.parseFloat(str2);
            } catch (NumberFormatException unused4) {
            }
        }
    }

    public PDFTextStripper() throws IOException {
        String property = System.getProperty("line.separator");
        this.LINE_SEPARATOR = property;
        this.lineSeparator = property;
        this.pageEnd = property;
        this.articleStart = "";
        this.articleEnd = "";
        this.currentPageNo = 0;
        this.startPage = 1;
        this.endPage = Integer.MAX_VALUE;
        this.startBookmark = null;
        this.startBookmarkPageNumber = -1;
        this.endBookmark = null;
        this.endBookmarkPageNumber = -1;
        this.suppressDuplicateOverlappingText = true;
        this.shouldSeparateByBeads = true;
        this.sortByPosition = false;
        this.addMoreFormatting = false;
        this.indentThreshold = defaultIndentThreshold;
        this.dropThreshold = defaultDropThreshold;
        this.spacingTolerance = 0.5f;
        this.averageCharTolerance = 0.3f;
        this.pageArticles = null;
        this.charactersByArticle = new Vector<>();
        this.characterListMapping = new HashMap();
        this.listOfPatterns = null;
    }

    private WordWithTextPositions createWord(String str, List<TextPosition> list) {
        return new WordWithTextPositions(normalizeWord(str), list);
    }

    private PositionWrapper handleLineSeparation(PositionWrapper positionWrapper, PositionWrapper positionWrapper2, PositionWrapper positionWrapper3, float f2) throws IOException {
        positionWrapper.setLineStart();
        isParagraphSeparation(positionWrapper, positionWrapper2, positionWrapper3, f2);
        if (!positionWrapper.isParagraphStart()) {
            writeLineSeparator();
        } else if (positionWrapper2.isArticleStart()) {
            writeParagraphStart();
        } else {
            writeLineSeparator();
            writeParagraphSeparator();
        }
        return positionWrapper;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0076, code lost:
        if (r8.isParagraphStart() == false) goto L_0x009f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x009b, code lost:
        if (r7 == matchListItemPattern(r6)) goto L_0x009f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void isParagraphSeparation(org.apache.pdfbox.text.PDFTextStripper.PositionWrapper r6, org.apache.pdfbox.text.PDFTextStripper.PositionWrapper r7, org.apache.pdfbox.text.PDFTextStripper.PositionWrapper r8, float r9) {
        /*
            r5 = this;
            r0 = 1
            if (r8 != 0) goto L_0x0005
            goto L_0x009f
        L_0x0005:
            org.apache.pdfbox.text.TextPosition r1 = r6.getTextPosition()
            float r1 = r1.getYDirAdj()
            org.apache.pdfbox.text.TextPosition r7 = r7.getTextPosition()
            float r7 = r7.getYDirAdj()
            float r1 = r1 - r7
            float r7 = java.lang.Math.abs(r1)
            float r1 = r5.getDropThreshold()
            float r9 = r5.multiplyFloat(r1, r9)
            org.apache.pdfbox.text.TextPosition r1 = r6.getTextPosition()
            float r1 = r1.getXDirAdj()
            org.apache.pdfbox.text.TextPosition r2 = r8.getTextPosition()
            float r2 = r2.getXDirAdj()
            float r1 = r1 - r2
            float r2 = r5.getIndentThreshold()
            org.apache.pdfbox.text.TextPosition r3 = r6.getTextPosition()
            float r3 = r3.getWidthOfSpace()
            float r2 = r5.multiplyFloat(r2, r3)
            r3 = 1048576000(0x3e800000, float:0.25)
            org.apache.pdfbox.text.TextPosition r4 = r6.getTextPosition()
            float r4 = r4.getWidth()
            float r3 = r5.multiplyFloat(r3, r4)
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 <= 0) goto L_0x0056
            goto L_0x009f
        L_0x0056:
            int r7 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r7 <= 0) goto L_0x0065
            boolean r7 = r8.isParagraphStart()
            if (r7 != 0) goto L_0x0061
            goto L_0x009f
        L_0x0061:
            r6.setHangingIndent()
            goto L_0x009e
        L_0x0065:
            org.apache.pdfbox.text.TextPosition r7 = r6.getTextPosition()
            float r7 = r7.getWidthOfSpace()
            float r7 = -r7
            int r7 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r7 >= 0) goto L_0x0079
            boolean r7 = r8.isParagraphStart()
            if (r7 != 0) goto L_0x009e
            goto L_0x009f
        L_0x0079:
            float r7 = java.lang.Math.abs(r1)
            int r7 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r7 >= 0) goto L_0x009e
            boolean r7 = r8.isHangingIndent()
            if (r7 == 0) goto L_0x008b
            r6.setHangingIndent()
            goto L_0x009e
        L_0x008b:
            boolean r7 = r8.isParagraphStart()
            if (r7 == 0) goto L_0x009e
            java.util.regex.Pattern r7 = r5.matchListItemPattern(r8)
            if (r7 == 0) goto L_0x009e
            java.util.regex.Pattern r8 = r5.matchListItemPattern(r6)
            if (r7 != r8) goto L_0x009e
            goto L_0x009f
        L_0x009e:
            r0 = 0
        L_0x009f:
            if (r0 == 0) goto L_0x00a4
            r6.setParagraphStart()
        L_0x00a4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.pdfbox.text.PDFTextStripper.isParagraphSeparation(org.apache.pdfbox.text.PDFTextStripper$PositionWrapper, org.apache.pdfbox.text.PDFTextStripper$PositionWrapper, org.apache.pdfbox.text.PDFTextStripper$PositionWrapper, float):void");
    }

    private Pattern matchListItemPattern(PositionWrapper positionWrapper) {
        return matchPattern(positionWrapper.getTextPosition().getUnicode(), getListItemPatterns());
    }

    public static Pattern matchPattern(String str, List<Pattern> list) {
        for (Pattern next : list) {
            if (next.matcher(str).matches()) {
                return next;
            }
        }
        return null;
    }

    private float multiplyFloat(float f2, float f3) {
        return ((float) Math.round((f2 * f3) * 1000.0f)) / 1000.0f;
    }

    private List<WordWithTextPositions> normalize(List<LineItem> list, boolean z, boolean z2) {
        LinkedList linkedList = new LinkedList();
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        if (z) {
            for (int size = list.size() - 1; size >= 0; size--) {
                sb = normalizeAdd(linkedList, sb, arrayList, list.get(size));
            }
        } else {
            for (LineItem normalizeAdd : list) {
                sb = normalizeAdd(linkedList, sb, arrayList, normalizeAdd);
            }
        }
        if (sb.length() > 0) {
            linkedList.add(createWord(sb.toString(), arrayList));
        }
        return linkedList;
    }

    private StringBuilder normalizeAdd(List<WordWithTextPositions> list, StringBuilder sb, List<TextPosition> list2, LineItem lineItem) {
        if (lineItem.isWordSeparator()) {
            list.add(createWord(sb.toString(), new ArrayList(list2)));
            StringBuilder sb2 = new StringBuilder();
            list2.clear();
            return sb2;
        }
        TextPosition textPosition = lineItem.getTextPosition();
        sb.append(textPosition.getUnicode());
        list2.add(textPosition);
        return sb;
    }

    private String normalizeWord(String str) {
        int length = str.length();
        int i = 0;
        StringBuilder sb = null;
        int i2 = 0;
        while (i < length) {
            char charAt = str.charAt(i);
            if ((64256 <= charAt && charAt <= 65023) || (65136 <= charAt && charAt <= 65279)) {
                if (sb == null) {
                    sb = new StringBuilder(length * 2);
                }
                sb.append(str.substring(i2, i));
                if (charAt == 65010 && i > 0) {
                    int i3 = i - 1;
                    if (str.charAt(i3) == 1575 || str.charAt(i3) == 65165) {
                        sb.append("لله");
                        i2 = i + 1;
                    }
                }
                sb.append(Normalizer.normalize(str.substring(i, i + 1), Form.NFKC).trim());
                i2 = i + 1;
            }
            i++;
        }
        if (sb == null) {
            return str;
        }
        sb.append(str.substring(i2, i));
        return sb.toString();
    }

    private boolean overlap(float f2, float f3, float f4, float f5) {
        return within(f2, f4, 0.1f) || (f4 <= f2 && f4 >= f2 - f3) || (f2 <= f4 && f2 >= f4 - f5);
    }

    private void resetEngine() {
        this.currentPageNo = 0;
        this.document = null;
        Vector<List<TextPosition>> vector = this.charactersByArticle;
        if (vector != null) {
            vector.clear();
        }
        Map<String, TreeMap<Float, TreeSet<Float>>> map = this.characterListMapping;
        if (map != null) {
            map.clear();
        }
        this.startBookmark = null;
        this.endBookmark = null;
    }

    private boolean within(float f2, float f3, float f4) {
        return f3 < f2 + f4 && f3 > f2 - f4;
    }

    private void writeLine(List<WordWithTextPositions> list, boolean z) throws IOException {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            WordWithTextPositions wordWithTextPositions = list.get(i);
            writeString(wordWithTextPositions.getText(), wordWithTextPositions.getTextPositions());
            if (i < size - 1) {
                writeWordSeparator();
            }
        }
    }

    public void endArticle() throws IOException {
        this.output.write(getArticleEnd());
    }

    public void endDocument(PDDocument pDDocument) throws IOException {
    }

    public void endPage(PDPage pDPage) throws IOException {
    }

    public boolean getAddMoreFormatting() {
        return this.addMoreFormatting;
    }

    public String getArticleEnd() {
        return this.articleEnd;
    }

    public String getArticleStart() {
        return this.articleStart;
    }

    public float getAverageCharTolerance() {
        return this.averageCharTolerance;
    }

    public List<List<TextPosition>> getCharactersByArticle() {
        return this.charactersByArticle;
    }

    public int getCurrentPageNo() {
        return this.currentPageNo;
    }

    public float getDropThreshold() {
        return this.dropThreshold;
    }

    public PDOutlineItem getEndBookmark() {
        return this.endBookmark;
    }

    public int getEndPage() {
        return this.endPage;
    }

    public float getIndentThreshold() {
        return this.indentThreshold;
    }

    public String getLineSeparator() {
        return this.lineSeparator;
    }

    public List<Pattern> getListItemPatterns() {
        if (this.listOfPatterns == null) {
            this.listOfPatterns = new ArrayList();
            for (String compile : LIST_ITEM_EXPRESSIONS) {
                this.listOfPatterns.add(Pattern.compile(compile));
            }
        }
        return this.listOfPatterns;
    }

    public Writer getOutput() {
        return this.output;
    }

    public String getPageEnd() {
        return this.pageEnd;
    }

    public String getPageStart() {
        return this.pageStart;
    }

    public String getParagraphEnd() {
        return this.paragraphEnd;
    }

    public String getParagraphStart() {
        return this.paragraphStart;
    }

    public boolean getSeparateByBeads() {
        return this.shouldSeparateByBeads;
    }

    public boolean getSortByPosition() {
        return this.sortByPosition;
    }

    public float getSpacingTolerance() {
        return this.spacingTolerance;
    }

    public PDOutlineItem getStartBookmark() {
        return this.startBookmark;
    }

    public int getStartPage() {
        return this.startPage;
    }

    public boolean getSuppressDuplicateOverlappingText() {
        return this.suppressDuplicateOverlappingText;
    }

    public String getText(PDDocument pDDocument) throws IOException {
        StringWriter stringWriter = new StringWriter();
        writeText(pDDocument, stringWriter);
        return stringWriter.toString();
    }

    public String getWordSeparator() {
        return this.wordSeparator;
    }

    public void processPage(PDPage pDPage) throws IOException {
        int i = this.currentPageNo;
        if (i >= this.startPage && i <= this.endPage) {
            int i2 = this.startBookmarkPageNumber;
            if (i2 == -1 || i >= i2) {
                int i3 = this.endBookmarkPageNumber;
                if (i3 == -1 || this.currentPageNo <= i3) {
                    startPage(pDPage);
                    List<PDThreadBead> threadBeads = pDPage.getThreadBeads();
                    this.pageArticles = threadBeads;
                    int i4 = 1;
                    int size = (threadBeads.size() * 2) + 1;
                    if (this.shouldSeparateByBeads) {
                        i4 = size;
                    }
                    int size2 = this.charactersByArticle.size();
                    this.charactersByArticle.setSize(i4);
                    for (int i5 = 0; i5 < i4; i5++) {
                        if (i4 < size2) {
                            this.charactersByArticle.get(i5).clear();
                        } else {
                            this.charactersByArticle.set(i5, new ArrayList());
                        }
                    }
                    this.characterListMapping.clear();
                    super.processPage(pDPage);
                    writePage();
                    endPage(pDPage);
                }
            }
        }
    }

    public void processPages(PDPageTree pDPageTree) throws IOException {
        PDPage pDPage;
        PDOutlineItem pDOutlineItem = this.startBookmark;
        PDPage pDPage2 = null;
        if (pDOutlineItem == null) {
            pDPage = null;
        } else {
            pDPage = pDOutlineItem.findDestinationPage(this.document);
        }
        PDOutlineItem pDOutlineItem2 = this.endBookmark;
        if (pDOutlineItem2 != null) {
            pDPage2 = pDOutlineItem2.findDestinationPage(this.document);
        }
        if (!(pDPage == null || pDPage2 == null || this.startBookmark.getCOSObject() != this.endBookmark.getCOSObject())) {
            this.startBookmarkPageNumber = 0;
            this.endBookmarkPageNumber = 0;
        }
        Iterator<PDPage> it = pDPageTree.iterator();
        while (it.hasNext()) {
            PDPage next = it.next();
            PDStream stream = next.getStream();
            this.currentPageNo++;
            if (stream != null) {
                processPage(next);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:83:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void processTextPosition(org.apache.pdfbox.text.TextPosition r12) {
        /*
            r11 = this;
            boolean r0 = r11.suppressDuplicateOverlappingText
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0094
            java.lang.String r0 = r12.getUnicode()
            float r3 = r12.getX()
            float r4 = r12.getY()
            java.util.Map<java.lang.String, java.util.TreeMap<java.lang.Float, java.util.TreeSet<java.lang.Float>>> r5 = r11.characterListMapping
            java.lang.Object r5 = r5.get(r0)
            java.util.TreeMap r5 = (java.util.TreeMap) r5
            if (r5 != 0) goto L_0x0026
            java.util.TreeMap r5 = new java.util.TreeMap
            r5.<init>()
            java.util.Map<java.lang.String, java.util.TreeMap<java.lang.Float, java.util.TreeSet<java.lang.Float>>> r6 = r11.characterListMapping
            r6.put(r0, r5)
        L_0x0026:
            float r6 = r12.getWidth()
            int r0 = r0.length()
            float r0 = (float) r0
            float r6 = r6 / r0
            r0 = 1077936128(0x40400000, float:3.0)
            float r6 = r6 / r0
            float r0 = r3 - r6
            java.lang.Float r0 = java.lang.Float.valueOf(r0)
            float r7 = r3 + r6
            java.lang.Float r7 = java.lang.Float.valueOf(r7)
            java.util.SortedMap r0 = r5.subMap(r0, r7)
            java.util.Collection r0 = r0.values()
            java.util.Iterator r0 = r0.iterator()
        L_0x004b:
            boolean r7 = r0.hasNext()
            if (r7 == 0) goto L_0x006f
            java.lang.Object r7 = r0.next()
            java.util.TreeSet r7 = (java.util.TreeSet) r7
            float r8 = r4 - r6
            java.lang.Float r8 = java.lang.Float.valueOf(r8)
            float r9 = r4 + r6
            java.lang.Float r9 = java.lang.Float.valueOf(r9)
            java.util.SortedSet r7 = r7.subSet(r8, r9)
            boolean r7 = r7.isEmpty()
            if (r7 != 0) goto L_0x004b
            r0 = 1
            goto L_0x0070
        L_0x006f:
            r0 = 0
        L_0x0070:
            if (r0 != 0) goto L_0x0092
            java.lang.Float r0 = java.lang.Float.valueOf(r3)
            java.lang.Object r0 = r5.get(r0)
            java.util.TreeSet r0 = (java.util.TreeSet) r0
            if (r0 != 0) goto L_0x008a
            java.util.TreeSet r0 = new java.util.TreeSet
            r0.<init>()
            java.lang.Float r3 = java.lang.Float.valueOf(r3)
            r5.put(r3, r0)
        L_0x008a:
            java.lang.Float r3 = java.lang.Float.valueOf(r4)
            r0.add(r3)
            goto L_0x0094
        L_0x0092:
            r0 = 0
            goto L_0x0095
        L_0x0094:
            r0 = 1
        L_0x0095:
            if (r0 == 0) goto L_0x0160
            float r0 = r12.getX()
            float r3 = r12.getY()
            boolean r4 = r11.shouldSeparateByBeads
            r5 = -1
            if (r4 == 0) goto L_0x0100
            r1 = 0
            r4 = -1
            r6 = -1
            r7 = -1
            r8 = -1
        L_0x00a9:
            java.util.List<org.apache.pdfbox.pdmodel.interactive.pagenavigation.PDThreadBead> r9 = r11.pageArticles
            int r9 = r9.size()
            if (r1 >= r9) goto L_0x00fe
            if (r4 != r5) goto L_0x00fe
            java.util.List<org.apache.pdfbox.pdmodel.interactive.pagenavigation.PDThreadBead> r9 = r11.pageArticles
            java.lang.Object r9 = r9.get(r1)
            org.apache.pdfbox.pdmodel.interactive.pagenavigation.PDThreadBead r9 = (org.apache.pdfbox.pdmodel.interactive.pagenavigation.PDThreadBead) r9
            if (r9 == 0) goto L_0x00fa
            org.apache.pdfbox.pdmodel.common.PDRectangle r9 = r9.getRectangle()
            boolean r10 = r9.contains(r0, r3)
            if (r10 == 0) goto L_0x00cb
            int r4 = r1 * 2
            int r4 = r4 + r2
            goto L_0x00fb
        L_0x00cb:
            float r10 = r9.getLowerLeftX()
            int r10 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
            if (r10 < 0) goto L_0x00db
            float r10 = r9.getUpperRightY()
            int r10 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r10 >= 0) goto L_0x00e0
        L_0x00db:
            if (r6 != r5) goto L_0x00e0
            int r6 = r1 * 2
            goto L_0x00fb
        L_0x00e0:
            float r10 = r9.getLowerLeftX()
            int r10 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
            if (r10 >= 0) goto L_0x00ed
            if (r7 != r5) goto L_0x00ed
            int r7 = r1 * 2
            goto L_0x00fb
        L_0x00ed:
            float r9 = r9.getUpperRightY()
            int r9 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1))
            if (r9 >= 0) goto L_0x00fb
            if (r8 != r5) goto L_0x00fb
            int r8 = r1 * 2
            goto L_0x00fb
        L_0x00fa:
            r4 = 0
        L_0x00fb:
            int r1 = r1 + 1
            goto L_0x00a9
        L_0x00fe:
            r1 = r4
            goto L_0x0103
        L_0x0100:
            r6 = -1
            r7 = -1
            r8 = -1
        L_0x0103:
            if (r1 == r5) goto L_0x0106
            goto L_0x011a
        L_0x0106:
            if (r6 == r5) goto L_0x010a
            r1 = r6
            goto L_0x011a
        L_0x010a:
            if (r7 == r5) goto L_0x010e
            r1 = r7
            goto L_0x011a
        L_0x010e:
            if (r8 == r5) goto L_0x0112
            r1 = r8
            goto L_0x011a
        L_0x0112:
            java.util.Vector<java.util.List<org.apache.pdfbox.text.TextPosition>> r0 = r11.charactersByArticle
            int r0 = r0.size()
            int r1 = r0 + -1
        L_0x011a:
            java.util.Vector<java.util.List<org.apache.pdfbox.text.TextPosition>> r0 = r11.charactersByArticle
            java.lang.Object r0 = r0.get(r1)
            java.util.List r0 = (java.util.List) r0
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L_0x012c
            r0.add(r12)
            goto L_0x0160
        L_0x012c:
            java.lang.Object r1 = com.android.tools.r8.GeneratedOutlineSupport.outline30(r0, r2)
            org.apache.pdfbox.text.TextPosition r1 = (org.apache.pdfbox.text.TextPosition) r1
            boolean r3 = r12.isDiacritic()
            if (r3 == 0) goto L_0x0142
            boolean r3 = r1.contains(r12)
            if (r3 == 0) goto L_0x0142
            r1.mergeDiacritic(r12)
            goto L_0x0160
        L_0x0142:
            boolean r3 = r1.isDiacritic()
            if (r3 == 0) goto L_0x015d
            boolean r3 = r12.contains(r1)
            if (r3 == 0) goto L_0x015d
            r12.mergeDiacritic(r1)
            int r1 = r0.size()
            int r1 = r1 - r2
            r0.remove(r1)
            r0.add(r12)
            goto L_0x0160
        L_0x015d:
            r0.add(r12)
        L_0x0160:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.pdfbox.text.PDFTextStripper.processTextPosition(org.apache.pdfbox.text.TextPosition):void");
    }

    public void setAddMoreFormatting(boolean z) {
        this.addMoreFormatting = z;
    }

    public void setArticleEnd(String str) {
        this.articleEnd = str;
    }

    public void setArticleStart(String str) {
        this.articleStart = str;
    }

    public void setAverageCharTolerance(float f2) {
        this.averageCharTolerance = f2;
    }

    public void setDropThreshold(float f2) {
        this.dropThreshold = f2;
    }

    public void setEndBookmark(PDOutlineItem pDOutlineItem) {
        this.endBookmark = pDOutlineItem;
    }

    public void setEndPage(int i) {
        this.endPage = i;
    }

    public void setIndentThreshold(float f2) {
        this.indentThreshold = f2;
    }

    public void setLineSeparator(String str) {
        this.lineSeparator = str;
    }

    public void setListItemPatterns(List<Pattern> list) {
        this.listOfPatterns = list;
    }

    public void setPageEnd(String str) {
        this.pageEnd = str;
    }

    public void setPageStart(String str) {
        this.pageStart = str;
    }

    public void setParagraphEnd(String str) {
        this.paragraphEnd = str;
    }

    public void setParagraphStart(String str) {
        this.paragraphStart = str;
    }

    public void setShouldSeparateByBeads(boolean z) {
        this.shouldSeparateByBeads = z;
    }

    public void setSortByPosition(boolean z) {
        this.sortByPosition = z;
    }

    public void setSpacingTolerance(float f2) {
        this.spacingTolerance = f2;
    }

    public void setStartBookmark(PDOutlineItem pDOutlineItem) {
        this.startBookmark = pDOutlineItem;
    }

    public void setStartPage(int i) {
        this.startPage = i;
    }

    public void setSuppressDuplicateOverlappingText(boolean z) {
        this.suppressDuplicateOverlappingText = z;
    }

    public void setWordSeparator(String str) {
        this.wordSeparator = str;
    }

    public void startArticle() throws IOException {
        startArticle(true);
    }

    public void startDocument(PDDocument pDDocument) throws IOException {
    }

    public void startPage(PDPage pDPage) throws IOException {
    }

    public void writeCharacters(TextPosition textPosition) throws IOException {
        this.output.write(textPosition.getUnicode());
    }

    public void writeLineSeparator() throws IOException {
        this.output.write(getLineSeparator());
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x01f0 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x020a  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0213  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0162  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0166  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0179  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0181  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0186  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01e0  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01eb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writePage() throws java.io.IOException {
        /*
            r34 = this;
            r0 = r34
            java.util.Vector<java.util.List<org.apache.pdfbox.text.TextPosition>> r1 = r0.charactersByArticle
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x000d
            r34.writePageStart()
        L_0x000d:
            java.util.Vector<java.util.List<org.apache.pdfbox.text.TextPosition>> r1 = r0.charactersByArticle
            java.util.Iterator r1 = r1.iterator()
            r2 = 0
            r7 = r2
            r8 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            r9 = -1082130432(0xffffffffbf800000, float:-1.0)
            r10 = -1082130432(0xffffffffbf800000, float:-1.0)
            r11 = -1082130432(0xffffffffbf800000, float:-1.0)
            r12 = 2139095039(0x7f7fffff, float:3.4028235E38)
            r13 = 1
        L_0x0022:
            boolean r14 = r1.hasNext()
            if (r14 == 0) goto L_0x0242
            java.lang.Object r14 = r1.next()
            java.util.List r14 = (java.util.List) r14
            boolean r15 = r34.getSortByPosition()
            if (r15 == 0) goto L_0x0044
            org.apache.pdfbox.text.TextPositionComparator r15 = new org.apache.pdfbox.text.TextPositionComparator
            r15.<init>()
            boolean r16 = useCustomQuickSort
            if (r16 == 0) goto L_0x0041
            org.apache.pdfbox.util.QuickSort.sort(r14, r15)
            goto L_0x0044
        L_0x0041:
            java.util.Collections.sort(r14, r15)
        L_0x0044:
            java.util.Iterator r15 = r14.iterator()
            r16 = 0
            r3 = 0
            r4 = 0
        L_0x004c:
            boolean r18 = r15.hasNext()
            if (r18 == 0) goto L_0x0095
            java.lang.Object r18 = r15.next()
            org.apache.pdfbox.text.TextPosition r18 = (org.apache.pdfbox.text.TextPosition) r18
            java.lang.String r5 = r18.getUnicode()
            r20 = r1
            r6 = 0
        L_0x005f:
            int r1 = r5.length()
            if (r6 >= r1) goto L_0x0092
            char r1 = r5.charAt(r6)
            byte r1 = java.lang.Character.getDirectionality(r1)
            r21 = r2
            if (r1 == 0) goto L_0x008b
            r2 = 14
            if (r1 == r2) goto L_0x008b
            r2 = 15
            if (r1 != r2) goto L_0x007a
            goto L_0x008b
        L_0x007a:
            r2 = 1
            if (r1 == r2) goto L_0x0088
            r2 = 2
            if (r1 == r2) goto L_0x0088
            r2 = 16
            if (r1 == r2) goto L_0x0088
            r2 = 17
            if (r1 != r2) goto L_0x008d
        L_0x0088:
            int r3 = r3 + 1
            goto L_0x008d
        L_0x008b:
            int r4 = r4 + 1
        L_0x008d:
            int r6 = r6 + 1
            r2 = r21
            goto L_0x005f
        L_0x0092:
            r1 = r20
            goto L_0x004c
        L_0x0095:
            r20 = r1
            r21 = r2
            if (r3 <= r4) goto L_0x009d
            r1 = 1
            goto L_0x009e
        L_0x009d:
            r1 = 0
        L_0x009e:
            r2 = r1 ^ 1
            r0.startArticle(r2)
            if (r3 <= 0) goto L_0x00a7
            r2 = 1
            goto L_0x00a8
        L_0x00a7:
            r2 = 0
        L_0x00a8:
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Iterator r4 = r14.iterator()
            r5 = r21
            r6 = -1082130432(0xffffffffbf800000, float:-1.0)
            r14 = 1
        L_0x00b6:
            boolean r15 = r4.hasNext()
            if (r15 == 0) goto L_0x021d
            java.lang.Object r15 = r4.next()
            org.apache.pdfbox.text.TextPosition r15 = (org.apache.pdfbox.text.TextPosition) r15
            r21 = r4
            org.apache.pdfbox.text.PDFTextStripper$PositionWrapper r4 = new org.apache.pdfbox.text.PDFTextStripper$PositionWrapper
            r4.<init>(r15)
            java.lang.String r22 = r15.getUnicode()
            r23 = r6
            if (r5 == 0) goto L_0x00f4
            org.apache.pdfbox.pdmodel.font.PDFont r6 = r15.getFont()
            org.apache.pdfbox.text.TextPosition r24 = r5.getTextPosition()
            r25 = r12
            org.apache.pdfbox.pdmodel.font.PDFont r12 = r24.getFont()
            if (r6 != r12) goto L_0x00f1
            float r6 = r15.getFontSize()
            org.apache.pdfbox.text.TextPosition r12 = r5.getTextPosition()
            float r12 = r12.getFontSize()
            int r6 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1))
            if (r6 == 0) goto L_0x00f6
        L_0x00f1:
            r6 = -1082130432(0xffffffffbf800000, float:-1.0)
            goto L_0x00f8
        L_0x00f4:
            r25 = r12
        L_0x00f6:
            r6 = r23
        L_0x00f8:
            boolean r12 = r34.getSortByPosition()
            if (r12 == 0) goto L_0x010f
            float r12 = r15.getXDirAdj()
            float r23 = r15.getYDirAdj()
            float r24 = r15.getWidthDirAdj()
            float r26 = r15.getHeightDir()
            goto L_0x011f
        L_0x010f:
            float r12 = r15.getX()
            float r23 = r15.getY()
            float r24 = r15.getWidth()
            float r26 = r15.getHeight()
        L_0x011f:
            r27 = r4
            r32 = r26
            r26 = r12
            r12 = r32
            r33 = r23
            r23 = r13
            r13 = r33
            float[] r4 = r15.getIndividualWidths()
            int r4 = r4.length
            float r28 = r15.getWidthOfSpace()
            r29 = 1073741824(0x40000000, float:2.0)
            r30 = 0
            int r31 = (r28 > r30 ? 1 : (r28 == r30 ? 0 : -1))
            if (r31 == 0) goto L_0x015b
            r31 = 2143289344(0x7fc00000, float:NaN)
            int r31 = (r28 > r31 ? 1 : (r28 == r31 ? 0 : -1))
            if (r31 != 0) goto L_0x0145
            goto L_0x015b
        L_0x0145:
            int r31 = (r10 > r30 ? 1 : (r10 == r30 ? 0 : -1))
            if (r31 >= 0) goto L_0x0150
            float r10 = r34.getSpacingTolerance()
            float r10 = r10 * r28
            goto L_0x015e
        L_0x0150:
            float r10 = r28 + r10
            float r10 = r10 / r29
            float r31 = r34.getSpacingTolerance()
            float r10 = r10 * r31
            goto L_0x015e
        L_0x015b:
            r10 = 2139095039(0x7f7fffff, float:3.4028235E38)
        L_0x015e:
            int r30 = (r6 > r30 ? 1 : (r6 == r30 ? 0 : -1))
            if (r30 >= 0) goto L_0x0166
            float r4 = (float) r4
            float r4 = r24 / r4
            goto L_0x016c
        L_0x0166:
            float r4 = (float) r4
            float r4 = r24 / r4
            float r4 = r4 + r6
            float r4 = r4 / r29
        L_0x016c:
            r6 = r4
            float r4 = r34.getAverageCharTolerance()
            float r4 = r4 * r6
            r19 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r29 = (r9 > r19 ? 1 : (r9 == r19 ? 0 : -1))
            if (r29 == 0) goto L_0x0181
            int r29 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r29 <= 0) goto L_0x017f
            float r9 = r9 + r10
            goto L_0x0184
        L_0x017f:
            float r9 = r9 + r4
            goto L_0x0184
        L_0x0181:
            r9 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
        L_0x0184:
            if (r5 == 0) goto L_0x01e0
            if (r14 == 0) goto L_0x018c
            r5.setArticleStart()
            r14 = 0
        L_0x018c:
            boolean r4 = r0.overlap(r13, r12, r8, r11)
            if (r4 != 0) goto L_0x01b1
            java.util.List r4 = r0.normalize(r3, r1, r2)
            r0.writeLine(r4, r1)
            r3.clear()
            r4 = r27
            org.apache.pdfbox.text.PDFTextStripper$PositionWrapper r7 = r0.handleLineSeparation(r4, r5, r7, r11)
            r8 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            r9 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            r11 = -1082130432(0xffffffffbf800000, float:-1.0)
            r17 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            r25 = 2139095039(0x7f7fffff, float:3.4028235E38)
            goto L_0x01b6
        L_0x01b1:
            r4 = r27
            r17 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
        L_0x01b6:
            int r10 = (r9 > r17 ? 1 : (r9 == r17 ? 0 : -1))
            if (r10 == 0) goto L_0x01e5
            int r9 = (r9 > r26 ? 1 : (r9 == r26 ? 0 : -1))
            if (r9 >= 0) goto L_0x01e5
            org.apache.pdfbox.text.TextPosition r9 = r5.getTextPosition()
            java.lang.String r9 = r9.getUnicode()
            if (r9 == 0) goto L_0x01e5
            org.apache.pdfbox.text.TextPosition r9 = r5.getTextPosition()
            java.lang.String r9 = r9.getUnicode()
            java.lang.String r10 = " "
            boolean r9 = r9.endsWith(r10)
            if (r9 != 0) goto L_0x01e5
            org.apache.pdfbox.text.PDFTextStripper$LineItem r9 = org.apache.pdfbox.text.PDFTextStripper.LineItem.getWordSeparator()
            r3.add(r9)
            goto L_0x01e5
        L_0x01e0:
            r4 = r27
            r17 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
        L_0x01e5:
            r9 = r25
            int r10 = (r13 > r8 ? 1 : (r13 == r8 ? 0 : -1))
            if (r10 < 0) goto L_0x01ec
            r8 = r13
        L_0x01ec:
            float r10 = r26 + r24
            if (r22 == 0) goto L_0x01ff
            if (r23 == 0) goto L_0x01f7
            if (r5 != 0) goto L_0x01f7
            r34.writeParagraphStart()
        L_0x01f7:
            org.apache.pdfbox.text.PDFTextStripper$LineItem r5 = new org.apache.pdfbox.text.PDFTextStripper$LineItem
            r5.<init>(r15)
            r3.add(r5)
        L_0x01ff:
            float r11 = java.lang.Math.max(r11, r12)
            float r13 = r13 - r12
            float r12 = java.lang.Math.min(r9, r13)
            if (r23 == 0) goto L_0x0213
            r4.setParagraphStart()
            r4.setLineStart()
            r7 = r4
            r13 = 0
            goto L_0x0215
        L_0x0213:
            r13 = r23
        L_0x0215:
            r5 = r4
            r9 = r10
            r4 = r21
            r10 = r28
            goto L_0x00b6
        L_0x021d:
            r25 = r12
            r23 = r13
            r17 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            r19 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r4 = r3.size()
            if (r4 <= 0) goto L_0x0236
            java.util.List r2 = r0.normalize(r3, r1, r2)
            r0.writeLine(r2, r1)
            r34.writeParagraphEnd()
        L_0x0236:
            r34.endArticle()
            r2 = r5
            r1 = r20
            r13 = r23
            r12 = r25
            goto L_0x0022
        L_0x0242:
            r34.writePageEnd()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.pdfbox.text.PDFTextStripper.writePage():void");
    }

    public void writePageEnd() throws IOException {
        this.output.write(getPageEnd());
    }

    public void writePageStart() throws IOException {
        this.output.write(getPageStart());
    }

    public void writeParagraphEnd() throws IOException {
        if (!this.inParagraph) {
            writeParagraphStart();
        }
        this.output.write(getParagraphEnd());
        this.inParagraph = false;
    }

    public void writeParagraphSeparator() throws IOException {
        writeParagraphEnd();
        writeParagraphStart();
    }

    public void writeParagraphStart() throws IOException {
        if (this.inParagraph) {
            writeParagraphEnd();
            this.inParagraph = false;
        }
        this.output.write(getParagraphStart());
        this.inParagraph = true;
    }

    public void writeString(String str, List<TextPosition> list) throws IOException {
        writeString(str);
    }

    public void writeText(PDDocument pDDocument, Writer writer) throws IOException {
        resetEngine();
        this.document = pDDocument;
        this.output = writer;
        if (getAddMoreFormatting()) {
            String str = this.lineSeparator;
            this.paragraphEnd = str;
            this.pageStart = str;
            this.articleStart = str;
            this.articleEnd = str;
        }
        startDocument(this.document);
        processPages(this.document.getPages());
        endDocument(this.document);
    }

    public void writeWordSeparator() throws IOException {
        this.output.write(getWordSeparator());
    }

    public void startArticle(boolean z) throws IOException {
        this.output.write(getArticleStart());
    }

    public void writeString(String str) throws IOException {
        this.output.write(str);
    }
}

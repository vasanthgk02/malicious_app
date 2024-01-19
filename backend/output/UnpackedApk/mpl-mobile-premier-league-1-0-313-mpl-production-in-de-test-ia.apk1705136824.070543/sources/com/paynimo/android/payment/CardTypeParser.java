package com.paynimo.android.payment;

import android.content.Context;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.modules.network.NetworkingModule;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.fontbox.cmap.CMap;

public class CardTypeParser {
    public static final List<Integer> MARKERS_POSITIONS_AMERICANEXPRESS;
    public static final List<Integer> MARKERS_POSITIONS_DEFAULT;
    public static final List<Integer> MARKERS_POSITIONS_DINERSCLUB;
    public static final List<Integer> MARKERS_POSITIONS_UNIONPAY = Arrays.asList(new Integer[]{Integer.valueOf(7), Integer.valueOf(21)});
    public static final List<Integer> SPACES_POSITIONS_AMERICANEXPRESS;
    public static final List<Integer> SPACES_POSITIONS_DEFAULT;
    public static final List<Integer> SPACES_POSITIONS_DINERSCLUB;
    public static final List<Integer> SPACES_POSITIONS_UNIONPAY = Arrays.asList(new Integer[]{Integer.valueOf(6)});
    public static Context context;

    public enum CardType {
        Visa(16, 16, 3, true, r7, GeneratedOutlineSupport.outline32(CardTypeParser.context, CardTypeParser.context.getResources(), "regex_visa_partial", NetworkingModule.REQUEST_BODY_KEY_STRING, r0), CardTypeParser.context.getResources().getIdentifier("paynimo_visa", "drawable", CardTypeParser.context.getPackageName()), 3, CardTypeParser.SPACES_POSITIONS_DEFAULT, CardTypeParser.MARKERS_POSITIONS_DEFAULT),
        Rupay(16, 16, 3, true, r23, GeneratedOutlineSupport.outline32(CardTypeParser.context, CardTypeParser.context.getResources(), "regex_rupay_partial", NetworkingModule.REQUEST_BODY_KEY_STRING, r1), CardTypeParser.context.getResources().getIdentifier("paynimo_rupay", "drawable", CardTypeParser.context.getPackageName()), 3, CardTypeParser.SPACES_POSITIONS_DEFAULT, CardTypeParser.MARKERS_POSITIONS_DEFAULT),
        MasterCard(16, 16, 3, true, r8, GeneratedOutlineSupport.outline32(CardTypeParser.context, CardTypeParser.context.getResources(), "regex_mastercard_partial", NetworkingModule.REQUEST_BODY_KEY_STRING, r1), CardTypeParser.context.getResources().getIdentifier("paynimo_mastercard", "drawable", CardTypeParser.context.getPackageName()), 3, CardTypeParser.SPACES_POSITIONS_DEFAULT, CardTypeParser.MARKERS_POSITIONS_DEFAULT),
        Maestro(12, 19, 3, true, r8, GeneratedOutlineSupport.outline32(CardTypeParser.context, CardTypeParser.context.getResources(), "regex_maestro_partial", NetworkingModule.REQUEST_BODY_KEY_STRING, r1), CardTypeParser.context.getResources().getIdentifier("paynimo_maestro", "drawable", CardTypeParser.context.getPackageName()), 4, CardTypeParser.SPACES_POSITIONS_DEFAULT, CardTypeParser.MARKERS_POSITIONS_DEFAULT),
        AmericanExpress(15, 15, 4, true, r23, GeneratedOutlineSupport.outline32(CardTypeParser.context, CardTypeParser.context.getResources(), "regex_amex_partial", NetworkingModule.REQUEST_BODY_KEY_STRING, r1), CardTypeParser.context.getResources().getIdentifier("paynimo_american_express", "drawable", CardTypeParser.context.getPackageName()), 2, CardTypeParser.SPACES_POSITIONS_AMERICANEXPRESS, CardTypeParser.MARKERS_POSITIONS_AMERICANEXPRESS),
        JCB(16, 16, 3, true, r8, GeneratedOutlineSupport.outline32(CardTypeParser.context, CardTypeParser.context.getResources(), "regex_jcb_partial", NetworkingModule.REQUEST_BODY_KEY_STRING, r1), CardTypeParser.context.getResources().getIdentifier("paynimo_jcb", "drawable", CardTypeParser.context.getPackageName()), 3, CardTypeParser.SPACES_POSITIONS_DEFAULT, CardTypeParser.MARKERS_POSITIONS_DEFAULT),
        DinersClub(14, 14, 3, true, r23, GeneratedOutlineSupport.outline32(CardTypeParser.context, CardTypeParser.context.getResources(), "regex_dinersclub_partial", NetworkingModule.REQUEST_BODY_KEY_STRING, r1), CardTypeParser.context.getResources().getIdentifier("paynimo_diners_club", "drawable", CardTypeParser.context.getPackageName()), 2, CardTypeParser.SPACES_POSITIONS_DINERSCLUB, CardTypeParser.MARKERS_POSITIONS_DINERSCLUB),
        Discover(16, 16, 3, true, r8, GeneratedOutlineSupport.outline32(CardTypeParser.context, CardTypeParser.context.getResources(), "regex_discover_partial", NetworkingModule.REQUEST_BODY_KEY_STRING, r1), CardTypeParser.context.getResources().getIdentifier("paynimo_discover", "drawable", CardTypeParser.context.getPackageName()), 3, CardTypeParser.SPACES_POSITIONS_DEFAULT, CardTypeParser.MARKERS_POSITIONS_DEFAULT),
        UnionPay(16, 19, 3, false, r8, GeneratedOutlineSupport.outline32(CardTypeParser.context, CardTypeParser.context.getResources(), "regex_unionpay_partial", NetworkingModule.REQUEST_BODY_KEY_STRING, r1), CardTypeParser.context.getResources().getIdentifier("paynimo_unionpay", "drawable", CardTypeParser.context.getPackageName()), 1, CardTypeParser.SPACES_POSITIONS_UNIONPAY, CardTypeParser.MARKERS_POSITIONS_UNIONPAY),
        InstaPayment(16, 16, 3, true, r8, GeneratedOutlineSupport.outline32(CardTypeParser.context, CardTypeParser.context.getResources(), "regex_instapayment_partial", NetworkingModule.REQUEST_BODY_KEY_STRING, r1), CardTypeParser.context.getResources().getIdentifier("paynimo_instapayment", "drawable", CardTypeParser.context.getPackageName()), 3, CardTypeParser.SPACES_POSITIONS_DEFAULT, CardTypeParser.MARKERS_POSITIONS_DEFAULT),
        Laser(16, 19, 3, true, r8, GeneratedOutlineSupport.outline32(CardTypeParser.context, CardTypeParser.context.getResources(), "regex_laser_partial", NetworkingModule.REQUEST_BODY_KEY_STRING, r1), CardTypeParser.context.getResources().getIdentifier("paynimo_laser", "drawable", CardTypeParser.context.getPackageName()), 4, CardTypeParser.SPACES_POSITIONS_DEFAULT, CardTypeParser.MARKERS_POSITIONS_DEFAULT),
        YetUnknown(12, 19, 4, true, "", "", 0, 4, CardTypeParser.SPACES_POSITIONS_DEFAULT, CardTypeParser.MARKERS_POSITIONS_DEFAULT),
        Invalid(12, 19, 4, true, "", "", 0, 4, CardTypeParser.SPACES_POSITIONS_DEFAULT, CardTypeParser.MARKERS_POSITIONS_DEFAULT);
        
        public int CVCLength;
        public Matcher cardMatcher;
        public Pattern cardPattern;
        public int imageId;
        public boolean isLuhn;
        public List<Integer> markersPositions;
        public int maxLength;
        public int minLength;
        public int numberOfIntervals;
        public Matcher partialCardMatcher;
        public Pattern partialCardPattern;
        public String regExPartialPattern;
        public String regExPattern;
        public List<Integer> spacesPositions;

        /* access modifiers changed from: public */
        CardType(int i, int i2, int i3, boolean z, String str, String str2, int i4, int i5, List<Integer> list, List<Integer> list2) {
            this.minLength = i;
            this.maxLength = i2;
            this.CVCLength = i3;
            this.isLuhn = z;
            this.regExPattern = str;
            this.regExPartialPattern = str2;
            this.imageId = i4;
            this.numberOfIntervals = i5;
            this.spacesPositions = list;
            this.markersPositions = list2;
            Pattern compile = Pattern.compile(str);
            this.cardPattern = compile;
            this.cardMatcher = compile.matcher("");
            Pattern compile2 = Pattern.compile(str2);
            this.partialCardPattern = compile2;
            this.partialCardMatcher = compile2.matcher("");
        }

        public static CardType getCardType(String str, Collection<CardType> collection) {
            boolean z = false;
            for (CardType cardType : values()) {
                if (cardType != YetUnknown && cardType != Invalid && collection.contains(cardType)) {
                    if (cardType == Rupay) {
                        str = str.replace(CMap.SPACE, "").trim();
                    }
                    cardType.cardMatcher.reset(str);
                    if (!cardType.cardMatcher.find()) {
                        CardType[] values = values();
                        int length = values.length;
                        int i = 0;
                        while (true) {
                            if (i >= length) {
                                break;
                            }
                            CardType cardType2 = values[i];
                            if (collection.contains(cardType2)) {
                                cardType2.partialCardMatcher.reset(str);
                                if (cardType2.partialCardMatcher.find()) {
                                    z = true;
                                    break;
                                }
                            }
                            i++;
                        }
                    } else {
                        return cardType;
                    }
                }
            }
            if (z) {
                return YetUnknown;
            }
            return Invalid;
        }

        public static CardType getCardTypeById(int i) {
            for (CardType cardType : values()) {
                if (i == cardType.getId()) {
                    return cardType;
                }
            }
            return Invalid;
        }

        public int getCVCLength() {
            return this.CVCLength;
        }

        public int getId() {
            return ordinal();
        }

        public int getImageId() {
            return this.imageId;
        }

        public List<Integer> getMarkersPositions() {
            return this.markersPositions;
        }

        public int getMaxLength() {
            return this.maxLength;
        }

        public int getMinLength() {
            return this.minLength;
        }

        public int getNumberOfIntervals() {
            return this.numberOfIntervals;
        }

        public String getRegExPartialPattern() {
            return this.regExPartialPattern;
        }

        public String getRegExPattern() {
            return this.regExPattern;
        }

        public List<Integer> getSpacesPositions() {
            return this.spacesPositions;
        }

        public boolean isLuhn() {
            return this.isLuhn;
        }
    }

    static {
        Integer valueOf = Integer.valueOf(4);
        Integer valueOf2 = Integer.valueOf(10);
        SPACES_POSITIONS_DINERSCLUB = Arrays.asList(new Integer[]{valueOf, valueOf2});
        SPACES_POSITIONS_AMERICANEXPRESS = Arrays.asList(new Integer[]{valueOf, valueOf2});
        Integer valueOf3 = Integer.valueOf(12);
        SPACES_POSITIONS_DEFAULT = Arrays.asList(new Integer[]{valueOf, Integer.valueOf(8), valueOf3, Integer.valueOf(16)});
        Integer valueOf4 = Integer.valueOf(5);
        MARKERS_POSITIONS_DINERSCLUB = Arrays.asList(new Integer[]{valueOf4, valueOf3, Integer.valueOf(17)});
        MARKERS_POSITIONS_AMERICANEXPRESS = Arrays.asList(new Integer[]{valueOf4, valueOf3, Integer.valueOf(18)});
        MARKERS_POSITIONS_DEFAULT = Arrays.asList(new Integer[]{valueOf4, valueOf2, Integer.valueOf(15), Integer.valueOf(20)});
    }

    public static Context getContext() {
        return context;
    }

    public static void setContext(Context context2) {
        if (context2 != null) {
            try {
                context = context2;
            } catch (Exception unused) {
            }
        }
    }
}

package com.google.i18n.phonenumbers;

import android.support.v4.media.session.MediaSessionCompat;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.material.resources.TextAppearanceConfig;
import com.google.i18n.phonenumbers.NumberParseException.ErrorType;
import com.google.i18n.phonenumbers.internal.RegexBasedMatcher;
import com.google.i18n.phonenumbers.internal.RegexCache;
import com.paynimo.android.payment.util.Constant;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.fontbox.cmap.CMap;

public class PhoneNumberUtil {
    public static final Map<Character, Character> ALPHA_MAPPINGS;
    public static final Map<Character, Character> ALPHA_PHONE_MAPPINGS;
    public static final Pattern CAPTURING_DIGIT_PATTERN = Pattern.compile("(\\p{Nd})");
    public static final Pattern EXTN_PATTERN = Pattern.compile("(?:" + EXTN_PATTERNS_FOR_PARSING + ")$", 66);
    public static final String EXTN_PATTERNS_FOR_PARSING = createExtnPattern(",;xｘ#＃~～");
    public static final Pattern FIRST_GROUP_PATTERN = Pattern.compile("(\\$\\d)");
    public static final Pattern PLUS_CHARS_PATTERN = Pattern.compile("[+＋]+");
    public static final Pattern SECOND_NUMBER_START_PATTERN = Pattern.compile("[\\\\/] *x");
    public static final Pattern SEPARATOR_PATTERN = Pattern.compile("[-x‐-―−ー－-／  ­​⁠　()（）［］.\\[\\]/~⁓∼～]+");
    public static final Pattern UNWANTED_END_CHAR_PATTERN = Pattern.compile("[[\\P{N}&&\\P{L}]&&[^#]]+$");
    public static final String VALID_ALPHA = (Arrays.toString(ALPHA_MAPPINGS.keySet().toArray()).replaceAll("[, \\[\\]]", "") + Arrays.toString(ALPHA_MAPPINGS.keySet().toArray()).toLowerCase().replaceAll("[, \\[\\]]", ""));
    public static final Pattern VALID_ALPHA_PHONE_PATTERN = Pattern.compile("(?:.*?[A-Za-z]){3}.*");
    public static final String VALID_PHONE_NUMBER = GeneratedOutlineSupport.outline63(GeneratedOutlineSupport.outline73("\\p{Nd}{2}|[+＋]*+(?:[-x‐-―−ー－-／  ­​⁠　()（）［］.\\[\\]/~⁓∼～*]*\\p{Nd}){3,}[-x‐-―−ー－-／  ­​⁠　()（）［］.\\[\\]/~⁓∼～*"), VALID_ALPHA, "\\p{Nd}", "]*");
    public static final Pattern VALID_PHONE_NUMBER_PATTERN = Pattern.compile(VALID_PHONE_NUMBER + "(?:" + EXTN_PATTERNS_FOR_PARSING + ")?", 66);
    public static final Pattern VALID_START_CHAR_PATTERN = Pattern.compile("[+＋\\p{Nd}]");
    public static PhoneNumberUtil instance = null;
    public static final Logger logger = Logger.getLogger(PhoneNumberUtil.class.getName());
    public final Map<Integer, List<String>> countryCallingCodeToRegionCodeMap;
    public final Set<Integer> countryCodesForNonGeographicalRegion = new HashSet();
    public final RegexBasedMatcher matcherApi = new RegexBasedMatcher();
    public final MultiFileMetadataSourceImpl metadataSource;
    public final Set<String> nanpaRegions = new HashSet(35);
    public final RegexCache regexCache = new RegexCache(100);
    public final Set<String> supportedRegions = new HashSet(MediaSessionCompat.MAX_BITMAP_SIZE_IN_DP);

    public enum PhoneNumberFormat {
        E164,
        INTERNATIONAL,
        NATIONAL,
        RFC3966
    }

    public enum PhoneNumberType {
        FIXED_LINE,
        MOBILE,
        FIXED_LINE_OR_MOBILE,
        TOLL_FREE,
        PREMIUM_RATE,
        SHARED_COST,
        VOIP,
        PERSONAL_NUMBER,
        PAGER,
        UAN,
        VOICEMAIL,
        UNKNOWN
    }

    public enum ValidationResult {
        IS_POSSIBLE,
        IS_POSSIBLE_LOCAL_ONLY,
        INVALID_COUNTRY_CODE,
        TOO_SHORT,
        INVALID_LENGTH,
        TOO_LONG
    }

    static {
        HashMap hashMap = new HashMap();
        Integer valueOf = Integer.valueOf(52);
        Character valueOf2 = Character.valueOf('4');
        hashMap.put(valueOf, "1");
        Integer valueOf3 = Integer.valueOf(54);
        Character valueOf4 = Character.valueOf('6');
        hashMap.put(valueOf3, "9");
        Collections.unmodifiableMap(hashMap);
        HashSet hashSet = new HashSet();
        hashSet.add(Integer.valueOf(86));
        Collections.unmodifiableSet(hashSet);
        HashSet hashSet2 = new HashSet();
        hashSet2.add(valueOf);
        hashSet2.add(valueOf3);
        Character valueOf5 = Character.valueOf('7');
        hashSet2.add(Integer.valueOf(55));
        hashSet2.add(Integer.valueOf(62));
        hashSet2.addAll(hashSet);
        Collections.unmodifiableSet(hashSet2);
        HashMap hashMap2 = new HashMap();
        Character valueOf6 = Character.valueOf('0');
        hashMap2.put(valueOf6, valueOf6);
        Character valueOf7 = Character.valueOf('1');
        hashMap2.put(valueOf7, valueOf7);
        Character valueOf8 = Character.valueOf('2');
        hashMap2.put(valueOf8, valueOf8);
        Character valueOf9 = Character.valueOf('3');
        hashMap2.put(valueOf9, valueOf9);
        hashMap2.put(valueOf2, valueOf2);
        Character valueOf10 = Character.valueOf('5');
        hashMap2.put(valueOf10, valueOf10);
        hashMap2.put(valueOf4, valueOf4);
        hashMap2.put(valueOf5, valueOf5);
        Character valueOf11 = Character.valueOf('8');
        hashMap2.put(valueOf11, valueOf11);
        Character valueOf12 = Character.valueOf('9');
        hashMap2.put(valueOf12, valueOf12);
        HashMap hashMap3 = new HashMap(40);
        hashMap3.put(Character.valueOf('A'), valueOf8);
        hashMap3.put(Character.valueOf('B'), valueOf8);
        hashMap3.put(Character.valueOf('C'), valueOf8);
        hashMap3.put(Character.valueOf('D'), valueOf9);
        hashMap3.put(Character.valueOf('E'), valueOf9);
        hashMap3.put(Character.valueOf('F'), valueOf9);
        hashMap3.put(Character.valueOf('G'), valueOf2);
        hashMap3.put(Character.valueOf('H'), valueOf2);
        hashMap3.put(Character.valueOf('I'), valueOf2);
        hashMap3.put(Character.valueOf('J'), valueOf10);
        hashMap3.put(Character.valueOf('K'), valueOf10);
        hashMap3.put(Character.valueOf('L'), valueOf10);
        hashMap3.put(Character.valueOf('M'), valueOf4);
        hashMap3.put(Character.valueOf('N'), valueOf4);
        hashMap3.put(Character.valueOf('O'), valueOf4);
        hashMap3.put(Character.valueOf('P'), valueOf5);
        hashMap3.put(Character.valueOf('Q'), valueOf5);
        hashMap3.put(Character.valueOf('R'), valueOf5);
        hashMap3.put(Character.valueOf('S'), valueOf5);
        hashMap3.put(Character.valueOf('T'), valueOf11);
        hashMap3.put(Character.valueOf('U'), valueOf11);
        hashMap3.put(Character.valueOf('V'), valueOf11);
        hashMap3.put(Character.valueOf('W'), valueOf12);
        hashMap3.put(Character.valueOf('X'), valueOf12);
        hashMap3.put(Character.valueOf('Y'), valueOf12);
        hashMap3.put(Character.valueOf('Z'), valueOf12);
        ALPHA_MAPPINGS = Collections.unmodifiableMap(hashMap3);
        HashMap hashMap4 = new HashMap(100);
        hashMap4.putAll(ALPHA_MAPPINGS);
        hashMap4.putAll(hashMap2);
        ALPHA_PHONE_MAPPINGS = Collections.unmodifiableMap(hashMap4);
        HashMap hashMap5 = new HashMap();
        hashMap5.putAll(hashMap2);
        Character valueOf13 = Character.valueOf('+');
        hashMap5.put(valueOf13, valueOf13);
        Character valueOf14 = Character.valueOf('*');
        hashMap5.put(valueOf14, valueOf14);
        Character valueOf15 = Character.valueOf('#');
        hashMap5.put(valueOf15, valueOf15);
        Collections.unmodifiableMap(hashMap5);
        HashMap hashMap6 = new HashMap();
        for (Character charValue : ALPHA_MAPPINGS.keySet()) {
            char charValue2 = charValue.charValue();
            hashMap6.put(Character.valueOf(Character.toLowerCase(charValue2)), Character.valueOf(charValue2));
            hashMap6.put(Character.valueOf(charValue2), Character.valueOf(charValue2));
        }
        hashMap6.putAll(hashMap2);
        hashMap6.put(Character.valueOf('-'), Character.valueOf('-'));
        hashMap6.put(Character.valueOf(65293), Character.valueOf('-'));
        hashMap6.put(Character.valueOf(8208), Character.valueOf('-'));
        hashMap6.put(Character.valueOf(8209), Character.valueOf('-'));
        hashMap6.put(Character.valueOf(8210), Character.valueOf('-'));
        hashMap6.put(Character.valueOf(8211), Character.valueOf('-'));
        hashMap6.put(Character.valueOf(8212), Character.valueOf('-'));
        hashMap6.put(Character.valueOf(8213), Character.valueOf('-'));
        hashMap6.put(Character.valueOf(8722), Character.valueOf('-'));
        hashMap6.put(Character.valueOf('/'), Character.valueOf('/'));
        hashMap6.put(Character.valueOf(65295), Character.valueOf('/'));
        hashMap6.put(Character.valueOf(' '), Character.valueOf(' '));
        hashMap6.put(Character.valueOf(12288), Character.valueOf(' '));
        hashMap6.put(Character.valueOf(8288), Character.valueOf(' '));
        hashMap6.put(Character.valueOf('.'), Character.valueOf('.'));
        hashMap6.put(Character.valueOf(65294), Character.valueOf('.'));
        Collections.unmodifiableMap(hashMap6);
        Pattern.compile("[\\d]+(?:[~⁓∼～][\\d]+)?");
        createExtnPattern("xｘ#＃~～");
        Pattern.compile("(\\D+)");
        Pattern.compile("\\(?\\$1\\)?");
    }

    public PhoneNumberUtil(MultiFileMetadataSourceImpl multiFileMetadataSourceImpl, Map<Integer, List<String>> map) {
        this.metadataSource = multiFileMetadataSourceImpl;
        this.countryCallingCodeToRegionCodeMap = map;
        for (Entry next : map.entrySet()) {
            List list = (List) next.getValue();
            if (list.size() != 1 || !Constant.TRANSACTION_SUBTYPE_IFSC.equals(list.get(0))) {
                this.supportedRegions.addAll(list);
            } else {
                this.countryCodesForNonGeographicalRegion.add(next.getKey());
            }
        }
        if (this.supportedRegions.remove(Constant.TRANSACTION_SUBTYPE_IFSC)) {
            logger.log(Level.WARNING, "invalid metadata (country calling code was mapped to the non-geo entity as well as specific region(s))");
        }
        this.nanpaRegions.addAll(map.get(Integer.valueOf(1)));
    }

    public static String createExtnPattern(String str) {
        return GeneratedOutlineSupport.outline62(GeneratedOutlineSupport.outline82(";ext=(\\p{Nd}{1,7})|[  \\t,]*(?:e?xt(?:ensi(?:ó?|ó))?n?|ｅ?ｘｔｎ?|[", str, "]|int|anexo|ｉｎｔ)[:\\.．]?[  \\t,-]*", "(\\p{Nd}{1,7})", "#?|[- ]+("), "\\p{Nd}", "{1,5})#");
    }

    public static boolean descHasPossibleNumberData(Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc) {
        if (phonemetadata$PhoneNumberDesc.possibleLength_.size() == 1 && phonemetadata$PhoneNumberDesc.possibleLength_.get(0).intValue() == -1) {
            return false;
        }
        return true;
    }

    public static synchronized PhoneNumberUtil getInstance() {
        PhoneNumberUtil phoneNumberUtil;
        Class<PhoneNumberUtil> cls = PhoneNumberUtil.class;
        synchronized (cls) {
            if (instance == null) {
                PhoneNumberUtil phoneNumberUtil2 = new PhoneNumberUtil(new MultiFileMetadataSourceImpl(MetadataManager.DEFAULT_METADATA_LOADER), TextAppearanceConfig.getCountryCodeToRegionCodeMap());
                synchronized (cls) {
                    instance = phoneNumberUtil2;
                }
            }
            phoneNumberUtil = instance;
        }
        return phoneNumberUtil;
    }

    public static boolean isViablePhoneNumber(CharSequence charSequence) {
        if (charSequence.length() < 2) {
            return false;
        }
        return VALID_PHONE_NUMBER_PATTERN.matcher(charSequence).matches();
    }

    public static StringBuilder normalize(StringBuilder sb) {
        if (VALID_ALPHA_PHONE_PATTERN.matcher(sb).matches()) {
            int length = sb.length();
            Map<Character, Character> map = ALPHA_PHONE_MAPPINGS;
            StringBuilder sb2 = new StringBuilder(sb.length());
            for (int i = 0; i < sb.length(); i++) {
                Character ch = map.get(Character.valueOf(Character.toUpperCase(sb.charAt(i))));
                if (ch != null) {
                    sb2.append(ch);
                }
            }
            sb.replace(0, length, sb2.toString());
        } else {
            sb.replace(0, sb.length(), normalizeDigitsOnly(sb));
        }
        return sb;
    }

    public static String normalizeDigitsOnly(CharSequence charSequence) {
        StringBuilder sb = new StringBuilder(charSequence.length());
        for (int i = 0; i < charSequence.length(); i++) {
            int digit = Character.digit(charSequence.charAt(i), 10);
            if (digit != -1) {
                sb.append(digit);
            }
        }
        return sb.toString();
    }

    public String format(Phonenumber$PhoneNumber phonenumber$PhoneNumber, PhoneNumberFormat phoneNumberFormat) {
        List<Phonemetadata$NumberFormat> list;
        Phonemetadata$NumberFormat phonemetadata$NumberFormat;
        if (phonenumber$PhoneNumber.nationalNumber_ == 0 && phonenumber$PhoneNumber.hasRawInput) {
            String str = phonenumber$PhoneNumber.rawInput_;
            if (str.length() > 0) {
                return str;
            }
        }
        StringBuilder sb = new StringBuilder(20);
        sb.setLength(0);
        int i = phonenumber$PhoneNumber.countryCode_;
        StringBuilder sb2 = new StringBuilder();
        if (phonenumber$PhoneNumber.italianLeadingZero_) {
            int i2 = phonenumber$PhoneNumber.numberOfLeadingZeros_;
            if (i2 > 0) {
                char[] cArr = new char[i2];
                Arrays.fill(cArr, '0');
                sb2.append(new String(cArr));
            }
        }
        sb2.append(phonenumber$PhoneNumber.nationalNumber_);
        String sb3 = sb2.toString();
        if (phoneNumberFormat == PhoneNumberFormat.E164) {
            sb.append(sb3);
            prefixNumberWithCountryCallingCode(i, PhoneNumberFormat.E164, sb);
        } else if (!this.countryCallingCodeToRegionCodeMap.containsKey(Integer.valueOf(i))) {
            sb.append(sb3);
        } else {
            Phonemetadata$PhoneMetadata metadataForRegionOrCallingCode = getMetadataForRegionOrCallingCode(i, getRegionCodeForCountryCode(i));
            if (metadataForRegionOrCallingCode.intlNumberFormat_.size() == 0 || phoneNumberFormat == PhoneNumberFormat.NATIONAL) {
                list = metadataForRegionOrCallingCode.numberFormat_;
            } else {
                list = metadataForRegionOrCallingCode.intlNumberFormat_;
            }
            Iterator<Phonemetadata$NumberFormat> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    phonemetadata$NumberFormat = null;
                    break;
                }
                phonemetadata$NumberFormat = it.next();
                int size = phonemetadata$NumberFormat.leadingDigitsPattern_.size();
                if (size != 0) {
                    if (!this.regexCache.getPatternForRegex(phonemetadata$NumberFormat.leadingDigitsPattern_.get(size - 1)).matcher(sb3).lookingAt()) {
                        continue;
                    }
                }
                if (this.regexCache.getPatternForRegex(phonemetadata$NumberFormat.pattern_).matcher(sb3).matches()) {
                    break;
                }
            }
            if (phonemetadata$NumberFormat != null) {
                String str2 = phonemetadata$NumberFormat.format_;
                Matcher matcher = this.regexCache.getPatternForRegex(phonemetadata$NumberFormat.pattern_).matcher(sb3);
                PhoneNumberFormat phoneNumberFormat2 = PhoneNumberFormat.NATIONAL;
                String str3 = phonemetadata$NumberFormat.nationalPrefixFormattingRule_;
                if (phoneNumberFormat != phoneNumberFormat2 || str3 == null || str3.length() <= 0) {
                    sb3 = matcher.replaceAll(str2);
                } else {
                    sb3 = matcher.replaceAll(FIRST_GROUP_PATTERN.matcher(str2).replaceFirst(str3));
                }
                if (phoneNumberFormat == PhoneNumberFormat.RFC3966) {
                    Matcher matcher2 = SEPARATOR_PATTERN.matcher(sb3);
                    if (matcher2.lookingAt()) {
                        sb3 = matcher2.replaceFirst("");
                    }
                    sb3 = matcher2.reset(sb3).replaceAll(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                }
            }
            sb.append(sb3);
            if (phonenumber$PhoneNumber.hasExtension && phonenumber$PhoneNumber.extension_.length() > 0) {
                if (phoneNumberFormat == PhoneNumberFormat.RFC3966) {
                    sb.append(";ext=");
                    sb.append(phonenumber$PhoneNumber.extension_);
                } else if (metadataForRegionOrCallingCode.hasPreferredExtnPrefix) {
                    sb.append(metadataForRegionOrCallingCode.preferredExtnPrefix_);
                    sb.append(phonenumber$PhoneNumber.extension_);
                } else {
                    sb.append(" ext. ");
                    sb.append(phonenumber$PhoneNumber.extension_);
                }
            }
            prefixNumberWithCountryCallingCode(i, phoneNumberFormat, sb);
        }
        return sb.toString();
    }

    public Phonemetadata$PhoneMetadata getMetadataForRegion(String str) {
        if (!(str != null && this.supportedRegions.contains(str))) {
            return null;
        }
        MultiFileMetadataSourceImpl multiFileMetadataSourceImpl = this.metadataSource;
        return MetadataManager.getMetadataFromMultiFilePrefix(str, multiFileMetadataSourceImpl.geographicalRegions, multiFileMetadataSourceImpl.phoneNumberMetadataFilePrefix, multiFileMetadataSourceImpl.metadataLoader);
    }

    public final Phonemetadata$PhoneMetadata getMetadataForRegionOrCallingCode(int i, String str) {
        if (!Constant.TRANSACTION_SUBTYPE_IFSC.equals(str)) {
            return getMetadataForRegion(str);
        }
        if (!this.countryCallingCodeToRegionCodeMap.containsKey(Integer.valueOf(i))) {
            return null;
        }
        MultiFileMetadataSourceImpl multiFileMetadataSourceImpl = this.metadataSource;
        if (multiFileMetadataSourceImpl != null) {
            List list = (List) ((HashMap) TextAppearanceConfig.getCountryCodeToRegionCodeMap()).get(Integer.valueOf(i));
            boolean z = false;
            if (list.size() == 1 && Constant.TRANSACTION_SUBTYPE_IFSC.equals(list.get(0))) {
                z = true;
            }
            if (!z) {
                return null;
            }
            return MetadataManager.getMetadataFromMultiFilePrefix(Integer.valueOf(i), multiFileMetadataSourceImpl.nonGeographicalRegions, multiFileMetadataSourceImpl.phoneNumberMetadataFilePrefix, multiFileMetadataSourceImpl.metadataLoader);
        }
        throw null;
    }

    public Phonemetadata$PhoneNumberDesc getNumberDescByType(Phonemetadata$PhoneMetadata phonemetadata$PhoneMetadata, PhoneNumberType phoneNumberType) {
        switch (phoneNumberType.ordinal()) {
            case 0:
            case 2:
                return phonemetadata$PhoneMetadata.fixedLine_;
            case 1:
                return phonemetadata$PhoneMetadata.mobile_;
            case 3:
                return phonemetadata$PhoneMetadata.tollFree_;
            case 4:
                return phonemetadata$PhoneMetadata.premiumRate_;
            case 5:
                return phonemetadata$PhoneMetadata.sharedCost_;
            case 6:
                return phonemetadata$PhoneMetadata.voip_;
            case 7:
                return phonemetadata$PhoneMetadata.personalNumber_;
            case 8:
                return phonemetadata$PhoneMetadata.pager_;
            case 9:
                return phonemetadata$PhoneMetadata.uan_;
            case 10:
                return phonemetadata$PhoneMetadata.voicemail_;
            default:
                return phonemetadata$PhoneMetadata.generalDesc_;
        }
    }

    public String getRegionCodeForCountryCode(int i) {
        List list = this.countryCallingCodeToRegionCodeMap.get(Integer.valueOf(i));
        if (list == null) {
            return "ZZ";
        }
        return (String) list.get(0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x007a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int maybeExtractCountryCode(java.lang.CharSequence r8, com.google.i18n.phonenumbers.Phonemetadata$PhoneMetadata r9, java.lang.StringBuilder r10, boolean r11, com.google.i18n.phonenumbers.Phonenumber$PhoneNumber r12) throws com.google.i18n.phonenumbers.NumberParseException {
        /*
            r7 = this;
            int r0 = r8.length()
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r8)
            if (r9 == 0) goto L_0x0012
            java.lang.String r8 = r9.internationalPrefix_
            goto L_0x0014
        L_0x0012:
            java.lang.String r8 = "NonMatch"
        L_0x0014:
            int r2 = r0.length()
            r3 = 1
            if (r2 != 0) goto L_0x001e
            com.google.i18n.phonenumbers.Phonenumber$PhoneNumber$CountryCodeSource r8 = com.google.i18n.phonenumbers.Phonenumber$PhoneNumber.CountryCodeSource.FROM_DEFAULT_COUNTRY
            goto L_0x007c
        L_0x001e:
            java.util.regex.Pattern r2 = PLUS_CHARS_PATTERN
            java.util.regex.Matcher r2 = r2.matcher(r0)
            boolean r4 = r2.lookingAt()
            if (r4 == 0) goto L_0x0037
            int r8 = r2.end()
            r0.delete(r1, r8)
            normalize(r0)
            com.google.i18n.phonenumbers.Phonenumber$PhoneNumber$CountryCodeSource r8 = com.google.i18n.phonenumbers.Phonenumber$PhoneNumber.CountryCodeSource.FROM_NUMBER_WITH_PLUS_SIGN
            goto L_0x007c
        L_0x0037:
            com.google.i18n.phonenumbers.internal.RegexCache r2 = r7.regexCache
            java.util.regex.Pattern r8 = r2.getPatternForRegex(r8)
            normalize(r0)
            java.util.regex.Matcher r8 = r8.matcher(r0)
            boolean r2 = r8.lookingAt()
            if (r2 == 0) goto L_0x0074
            int r8 = r8.end()
            java.util.regex.Pattern r2 = CAPTURING_DIGIT_PATTERN
            java.lang.String r4 = r0.substring(r8)
            java.util.regex.Matcher r2 = r2.matcher(r4)
            boolean r4 = r2.find()
            if (r4 == 0) goto L_0x006f
            java.lang.String r2 = r2.group(r3)
            java.lang.String r2 = normalizeDigitsOnly(r2)
            java.lang.String r4 = "0"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x006f
            goto L_0x0074
        L_0x006f:
            r0.delete(r1, r8)
            r8 = 1
            goto L_0x0075
        L_0x0074:
            r8 = 0
        L_0x0075:
            if (r8 == 0) goto L_0x007a
            com.google.i18n.phonenumbers.Phonenumber$PhoneNumber$CountryCodeSource r8 = com.google.i18n.phonenumbers.Phonenumber$PhoneNumber.CountryCodeSource.FROM_NUMBER_WITH_IDD
            goto L_0x007c
        L_0x007a:
            com.google.i18n.phonenumbers.Phonenumber$PhoneNumber$CountryCodeSource r8 = com.google.i18n.phonenumbers.Phonenumber$PhoneNumber.CountryCodeSource.FROM_DEFAULT_COUNTRY
        L_0x007c:
            r2 = 0
            if (r11 == 0) goto L_0x0087
            if (r8 == 0) goto L_0x0086
            r12.hasCountryCodeSource = r3
            r12.countryCodeSource_ = r8
            goto L_0x0087
        L_0x0086:
            throw r2
        L_0x0087:
            com.google.i18n.phonenumbers.Phonenumber$PhoneNumber$CountryCodeSource r4 = com.google.i18n.phonenumbers.Phonenumber$PhoneNumber.CountryCodeSource.FROM_DEFAULT_COUNTRY
            if (r8 == r4) goto L_0x00e3
            int r8 = r0.length()
            r9 = 2
            if (r8 <= r9) goto L_0x00d9
            int r8 = r0.length()
            if (r8 == 0) goto L_0x00ca
            char r8 = r0.charAt(r1)
            r9 = 48
            if (r8 != r9) goto L_0x00a1
            goto L_0x00ca
        L_0x00a1:
            int r8 = r0.length()
        L_0x00a5:
            r9 = 3
            if (r3 > r9) goto L_0x00ca
            if (r3 > r8) goto L_0x00ca
            java.lang.String r9 = r0.substring(r1, r3)
            int r9 = java.lang.Integer.parseInt(r9)
            java.util.Map<java.lang.Integer, java.util.List<java.lang.String>> r11 = r7.countryCallingCodeToRegionCodeMap
            java.lang.Integer r2 = java.lang.Integer.valueOf(r9)
            boolean r11 = r11.containsKey(r2)
            if (r11 == 0) goto L_0x00c7
            java.lang.String r8 = r0.substring(r3)
            r10.append(r8)
            r1 = r9
            goto L_0x00ca
        L_0x00c7:
            int r3 = r3 + 1
            goto L_0x00a5
        L_0x00ca:
            if (r1 == 0) goto L_0x00cf
            r12.countryCode_ = r1
            return r1
        L_0x00cf:
            com.google.i18n.phonenumbers.NumberParseException r8 = new com.google.i18n.phonenumbers.NumberParseException
            com.google.i18n.phonenumbers.NumberParseException$ErrorType r9 = com.google.i18n.phonenumbers.NumberParseException.ErrorType.INVALID_COUNTRY_CODE
            java.lang.String r10 = "Country calling code supplied was not recognised."
            r8.<init>(r9, r10)
            throw r8
        L_0x00d9:
            com.google.i18n.phonenumbers.NumberParseException r8 = new com.google.i18n.phonenumbers.NumberParseException
            com.google.i18n.phonenumbers.NumberParseException$ErrorType r9 = com.google.i18n.phonenumbers.NumberParseException.ErrorType.TOO_SHORT_AFTER_IDD
            java.lang.String r10 = "Phone number had an IDD, but after this was not long enough to be a viable phone number."
            r8.<init>(r9, r10)
            throw r8
        L_0x00e3:
            if (r9 == 0) goto L_0x0133
            int r8 = r9.countryCode_
            java.lang.String r4 = java.lang.String.valueOf(r8)
            java.lang.String r5 = r0.toString()
            boolean r6 = r5.startsWith(r4)
            if (r6 == 0) goto L_0x0133
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            int r4 = r4.length()
            java.lang.String r4 = r5.substring(r4)
            r6.<init>(r4)
            com.google.i18n.phonenumbers.Phonemetadata$PhoneNumberDesc r4 = r9.generalDesc_
            r7.maybeStripNationalPrefixAndCarrierCode(r6, r9, r2)
            com.google.i18n.phonenumbers.internal.RegexBasedMatcher r5 = r7.matcherApi
            boolean r5 = r5.matchNationalNumber(r0, r4, r1)
            if (r5 != 0) goto L_0x0117
            com.google.i18n.phonenumbers.internal.RegexBasedMatcher r5 = r7.matcherApi
            boolean r4 = r5.matchNationalNumber(r6, r4, r1)
            if (r4 != 0) goto L_0x0121
        L_0x0117:
            com.google.i18n.phonenumbers.PhoneNumberUtil$PhoneNumberType r4 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberType.UNKNOWN
            com.google.i18n.phonenumbers.PhoneNumberUtil$ValidationResult r9 = r7.testNumberLength(r0, r9, r4)
            com.google.i18n.phonenumbers.PhoneNumberUtil$ValidationResult r0 = com.google.i18n.phonenumbers.PhoneNumberUtil.ValidationResult.TOO_LONG
            if (r9 != r0) goto L_0x0133
        L_0x0121:
            r10.append(r6)
            if (r11 == 0) goto L_0x0130
            com.google.i18n.phonenumbers.Phonenumber$PhoneNumber$CountryCodeSource r9 = com.google.i18n.phonenumbers.Phonenumber$PhoneNumber.CountryCodeSource.FROM_NUMBER_WITHOUT_PLUS_SIGN
            if (r9 == 0) goto L_0x012f
            r12.hasCountryCodeSource = r3
            r12.countryCodeSource_ = r9
            goto L_0x0130
        L_0x012f:
            throw r2
        L_0x0130:
            r12.countryCode_ = r8
            return r8
        L_0x0133:
            r12.countryCode_ = r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.i18n.phonenumbers.PhoneNumberUtil.maybeExtractCountryCode(java.lang.CharSequence, com.google.i18n.phonenumbers.Phonemetadata$PhoneMetadata, java.lang.StringBuilder, boolean, com.google.i18n.phonenumbers.Phonenumber$PhoneNumber):int");
    }

    public boolean maybeStripNationalPrefixAndCarrierCode(StringBuilder sb, Phonemetadata$PhoneMetadata phonemetadata$PhoneMetadata, StringBuilder sb2) {
        int length = sb.length();
        String str = phonemetadata$PhoneMetadata.nationalPrefixForParsing_;
        if (!(length == 0 || str.length() == 0)) {
            Matcher matcher = this.regexCache.getPatternForRegex(str).matcher(sb);
            if (matcher.lookingAt()) {
                Phonemetadata$PhoneNumberDesc phonemetadata$PhoneNumberDesc = phonemetadata$PhoneMetadata.generalDesc_;
                boolean matchNationalNumber = this.matcherApi.matchNationalNumber(sb, phonemetadata$PhoneNumberDesc, false);
                int groupCount = matcher.groupCount();
                String str2 = phonemetadata$PhoneMetadata.nationalPrefixTransformRule_;
                if (str2 != null && str2.length() != 0 && matcher.group(groupCount) != null) {
                    StringBuilder sb3 = new StringBuilder(sb);
                    sb3.replace(0, length, matcher.replaceFirst(str2));
                    if (matchNationalNumber && !this.matcherApi.matchNationalNumber(sb3.toString(), phonemetadata$PhoneNumberDesc, false)) {
                        return false;
                    }
                    if (sb2 != null && groupCount > 1) {
                        sb2.append(matcher.group(1));
                    }
                    sb.replace(0, sb.length(), sb3.toString());
                    return true;
                } else if (matchNationalNumber && !this.matcherApi.matchNationalNumber(sb.substring(matcher.end()), phonemetadata$PhoneNumberDesc, false)) {
                    return false;
                } else {
                    if (!(sb2 == null || groupCount <= 0 || matcher.group(groupCount) == null)) {
                        sb2.append(matcher.group(1));
                    }
                    sb.delete(0, matcher.end());
                    return true;
                }
            }
        }
        return false;
    }

    public Phonenumber$PhoneNumber parse(CharSequence charSequence, String str) throws NumberParseException {
        int i;
        CharSequence charSequence2;
        Phonenumber$PhoneNumber phonenumber$PhoneNumber = new Phonenumber$PhoneNumber();
        if (charSequence == null) {
            throw new NumberParseException(ErrorType.NOT_A_NUMBER, "The phone number supplied was null.");
        } else if (charSequence.length() <= 250) {
            StringBuilder sb = new StringBuilder();
            String charSequence3 = charSequence.toString();
            int indexOf = charSequence3.indexOf(";phone-context=");
            String str2 = "";
            if (indexOf >= 0) {
                int i2 = indexOf + 15;
                if (i2 < charSequence3.length() - 1 && charSequence3.charAt(i2) == '+') {
                    int indexOf2 = charSequence3.indexOf(59, i2);
                    if (indexOf2 > 0) {
                        sb.append(charSequence3.substring(i2, indexOf2));
                    } else {
                        sb.append(charSequence3.substring(i2));
                    }
                }
                int indexOf3 = charSequence3.indexOf("tel:");
                sb.append(charSequence3.substring(indexOf3 >= 0 ? indexOf3 + 4 : 0, indexOf));
            } else {
                Matcher matcher = VALID_START_CHAR_PATTERN.matcher(charSequence3);
                if (matcher.find()) {
                    charSequence2 = charSequence3.subSequence(matcher.start(), charSequence3.length());
                    Matcher matcher2 = UNWANTED_END_CHAR_PATTERN.matcher(charSequence2);
                    if (matcher2.find()) {
                        charSequence2 = charSequence2.subSequence(0, matcher2.start());
                    }
                    Matcher matcher3 = SECOND_NUMBER_START_PATTERN.matcher(charSequence2);
                    if (matcher3.find()) {
                        charSequence2 = charSequence2.subSequence(0, matcher3.start());
                    }
                } else {
                    charSequence2 = str2;
                }
                sb.append(charSequence2);
            }
            int indexOf4 = sb.indexOf(";isub=");
            if (indexOf4 > 0) {
                sb.delete(indexOf4, sb.length());
            }
            if (isViablePhoneNumber(sb)) {
                if ((str != null && this.supportedRegions.contains(str)) || (sb.length() != 0 && PLUS_CHARS_PATTERN.matcher(sb).lookingAt())) {
                    Matcher matcher4 = EXTN_PATTERN.matcher(sb);
                    if (matcher4.find() && isViablePhoneNumber(sb.substring(0, matcher4.start()))) {
                        int groupCount = matcher4.groupCount();
                        int i3 = 1;
                        while (true) {
                            if (i3 > groupCount) {
                                break;
                            } else if (matcher4.group(i3) != null) {
                                String group = matcher4.group(i3);
                                sb.delete(matcher4.start(), sb.length());
                                str2 = group;
                                break;
                            } else {
                                i3++;
                            }
                        }
                    }
                    if (str2.length() > 0) {
                        phonenumber$PhoneNumber.hasExtension = true;
                        phonenumber$PhoneNumber.extension_ = str2;
                    }
                    Phonemetadata$PhoneMetadata metadataForRegion = getMetadataForRegion(str);
                    StringBuilder sb2 = new StringBuilder();
                    try {
                        i = maybeExtractCountryCode(sb, metadataForRegion, sb2, false, phonenumber$PhoneNumber);
                    } catch (NumberParseException e2) {
                        Matcher matcher5 = PLUS_CHARS_PATTERN.matcher(sb);
                        if (e2.errorType != ErrorType.INVALID_COUNTRY_CODE || !matcher5.lookingAt()) {
                            throw new NumberParseException(e2.errorType, e2.getMessage());
                        }
                        i = maybeExtractCountryCode(sb.substring(matcher5.end()), metadataForRegion, sb2, false, phonenumber$PhoneNumber);
                        if (i == 0) {
                            throw new NumberParseException(ErrorType.INVALID_COUNTRY_CODE, "Could not interpret numbers after plus-sign.");
                        }
                    }
                    if (i != 0) {
                        String regionCodeForCountryCode = getRegionCodeForCountryCode(i);
                        if (!regionCodeForCountryCode.equals(str)) {
                            metadataForRegion = getMetadataForRegionOrCallingCode(i, regionCodeForCountryCode);
                        }
                    } else {
                        normalize(sb);
                        sb2.append(sb);
                        if (str != null) {
                            phonenumber$PhoneNumber.countryCode_ = metadataForRegion.countryCode_;
                        }
                    }
                    if (sb2.length() >= 2) {
                        if (metadataForRegion != null) {
                            StringBuilder sb3 = new StringBuilder();
                            StringBuilder sb4 = new StringBuilder(sb2);
                            maybeStripNationalPrefixAndCarrierCode(sb4, metadataForRegion, sb3);
                            ValidationResult testNumberLength = testNumberLength(sb4, metadataForRegion, PhoneNumberType.UNKNOWN);
                            if (!(testNumberLength == ValidationResult.TOO_SHORT || testNumberLength == ValidationResult.IS_POSSIBLE_LOCAL_ONLY || testNumberLength == ValidationResult.INVALID_LENGTH)) {
                                sb2 = sb4;
                            }
                        }
                        int length = sb2.length();
                        if (length < 2) {
                            throw new NumberParseException(ErrorType.TOO_SHORT_NSN, "The string supplied is too short to be a phone number.");
                        } else if (length <= 17) {
                            if (sb2.length() > 1 && sb2.charAt(0) == '0') {
                                phonenumber$PhoneNumber.hasItalianLeadingZero = true;
                                phonenumber$PhoneNumber.italianLeadingZero_ = true;
                                int i4 = 1;
                                while (i4 < sb2.length() - 1 && sb2.charAt(i4) == '0') {
                                    i4++;
                                }
                                if (i4 != 1) {
                                    phonenumber$PhoneNumber.hasNumberOfLeadingZeros = true;
                                    phonenumber$PhoneNumber.numberOfLeadingZeros_ = i4;
                                }
                            }
                            phonenumber$PhoneNumber.nationalNumber_ = Long.parseLong(sb2.toString());
                            return phonenumber$PhoneNumber;
                        } else {
                            throw new NumberParseException(ErrorType.TOO_LONG, "The string supplied is too long to be a phone number.");
                        }
                    } else {
                        throw new NumberParseException(ErrorType.TOO_SHORT_NSN, "The string supplied is too short to be a phone number.");
                    }
                } else {
                    throw new NumberParseException(ErrorType.INVALID_COUNTRY_CODE, "Missing or invalid default region.");
                }
            } else {
                throw new NumberParseException(ErrorType.NOT_A_NUMBER, "The string supplied did not seem to be a phone number.");
            }
        } else {
            throw new NumberParseException(ErrorType.TOO_LONG, "The string supplied was too long to parse.");
        }
    }

    public final void prefixNumberWithCountryCallingCode(int i, PhoneNumberFormat phoneNumberFormat, StringBuilder sb) {
        int ordinal = phoneNumberFormat.ordinal();
        if (ordinal == 0) {
            sb.insert(0, i).insert(0, '+');
        } else if (ordinal == 1) {
            sb.insert(0, CMap.SPACE).insert(0, i).insert(0, '+');
        } else if (ordinal == 3) {
            sb.insert(0, Constants.ACCEPT_TIME_SEPARATOR_SERVER).insert(0, i).insert(0, '+').insert(0, "tel:");
        }
    }

    /* JADX WARNING: type inference failed for: r1v2, types: [java.util.Collection] */
    /* JADX WARNING: type inference failed for: r0v1, types: [java.util.List, java.util.List<java.lang.Integer>, java.util.Collection] */
    /* JADX WARNING: type inference failed for: r1v3, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r0v2, types: [java.util.List] */
    /* JADX WARNING: type inference failed for: r5v9 */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r5v11, types: [java.util.List<java.lang.Integer>] */
    /* JADX WARNING: type inference failed for: r1v7, types: [java.util.List<java.lang.Integer>] */
    /* JADX WARNING: type inference failed for: r1v9, types: [java.util.List<java.lang.Integer>] */
    /* JADX WARNING: type inference failed for: r5v15 */
    /* JADX WARNING: type inference failed for: r5v16 */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: type inference failed for: r1v11 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.i18n.phonenumbers.PhoneNumberUtil.ValidationResult testNumberLength(java.lang.CharSequence r4, com.google.i18n.phonenumbers.Phonemetadata$PhoneMetadata r5, com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberType r6) {
        /*
            r3 = this;
            com.google.i18n.phonenumbers.Phonemetadata$PhoneNumberDesc r0 = r3.getNumberDescByType(r5, r6)
            java.util.List<java.lang.Integer> r1 = r0.possibleLength_
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x0011
            com.google.i18n.phonenumbers.Phonemetadata$PhoneNumberDesc r1 = r5.generalDesc_
            java.util.List<java.lang.Integer> r1 = r1.possibleLength_
            goto L_0x0013
        L_0x0011:
            java.util.List<java.lang.Integer> r1 = r0.possibleLength_
        L_0x0013:
            java.util.List<java.lang.Integer> r0 = r0.possibleLengthLocalOnly_
            com.google.i18n.phonenumbers.PhoneNumberUtil$PhoneNumberType r2 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberType.FIXED_LINE_OR_MOBILE
            if (r6 != r2) goto L_0x006a
            com.google.i18n.phonenumbers.PhoneNumberUtil$PhoneNumberType r6 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberType.FIXED_LINE
            com.google.i18n.phonenumbers.Phonemetadata$PhoneNumberDesc r6 = r3.getNumberDescByType(r5, r6)
            boolean r6 = descHasPossibleNumberData(r6)
            if (r6 != 0) goto L_0x002c
            com.google.i18n.phonenumbers.PhoneNumberUtil$PhoneNumberType r6 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberType.MOBILE
            com.google.i18n.phonenumbers.PhoneNumberUtil$ValidationResult r4 = r3.testNumberLength(r4, r5, r6)
            return r4
        L_0x002c:
            com.google.i18n.phonenumbers.PhoneNumberUtil$PhoneNumberType r6 = com.google.i18n.phonenumbers.PhoneNumberUtil.PhoneNumberType.MOBILE
            com.google.i18n.phonenumbers.Phonemetadata$PhoneNumberDesc r6 = r3.getNumberDescByType(r5, r6)
            boolean r2 = descHasPossibleNumberData(r6)
            if (r2 == 0) goto L_0x006a
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>(r1)
            java.util.List<java.lang.Integer> r1 = r6.possibleLength_
            int r1 = r1.size()
            if (r1 != 0) goto L_0x004a
            com.google.i18n.phonenumbers.Phonemetadata$PhoneNumberDesc r5 = r5.generalDesc_
            java.util.List<java.lang.Integer> r5 = r5.possibleLength_
            goto L_0x004c
        L_0x004a:
            java.util.List<java.lang.Integer> r5 = r6.possibleLength_
        L_0x004c:
            r2.addAll(r5)
            java.util.Collections.sort(r2)
            boolean r5 = r0.isEmpty()
            if (r5 == 0) goto L_0x005b
            java.util.List<java.lang.Integer> r5 = r6.possibleLengthLocalOnly_
            goto L_0x0068
        L_0x005b:
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>(r0)
            java.util.List<java.lang.Integer> r6 = r6.possibleLengthLocalOnly_
            r5.addAll(r6)
            java.util.Collections.sort(r5)
        L_0x0068:
            r0 = r5
            r1 = r2
        L_0x006a:
            r5 = 0
            java.lang.Object r6 = r1.get(r5)
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            r2 = -1
            if (r6 != r2) goto L_0x007b
            com.google.i18n.phonenumbers.PhoneNumberUtil$ValidationResult r4 = com.google.i18n.phonenumbers.PhoneNumberUtil.ValidationResult.INVALID_LENGTH
            return r4
        L_0x007b:
            int r4 = r4.length()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r4)
            boolean r6 = r0.contains(r6)
            if (r6 == 0) goto L_0x008c
            com.google.i18n.phonenumbers.PhoneNumberUtil$ValidationResult r4 = com.google.i18n.phonenumbers.PhoneNumberUtil.ValidationResult.IS_POSSIBLE_LOCAL_ONLY
            return r4
        L_0x008c:
            java.lang.Object r5 = r1.get(r5)
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            if (r5 != r4) goto L_0x009b
            com.google.i18n.phonenumbers.PhoneNumberUtil$ValidationResult r4 = com.google.i18n.phonenumbers.PhoneNumberUtil.ValidationResult.IS_POSSIBLE
            return r4
        L_0x009b:
            if (r5 <= r4) goto L_0x00a0
            com.google.i18n.phonenumbers.PhoneNumberUtil$ValidationResult r4 = com.google.i18n.phonenumbers.PhoneNumberUtil.ValidationResult.TOO_SHORT
            return r4
        L_0x00a0:
            r5 = 1
            java.lang.Object r6 = com.android.tools.r8.GeneratedOutlineSupport.outline30(r1, r5)
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            if (r6 >= r4) goto L_0x00b0
            com.google.i18n.phonenumbers.PhoneNumberUtil$ValidationResult r4 = com.google.i18n.phonenumbers.PhoneNumberUtil.ValidationResult.TOO_LONG
            return r4
        L_0x00b0:
            int r6 = r1.size()
            java.util.List r5 = r1.subList(r5, r6)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            boolean r4 = r5.contains(r4)
            if (r4 == 0) goto L_0x00c5
            com.google.i18n.phonenumbers.PhoneNumberUtil$ValidationResult r4 = com.google.i18n.phonenumbers.PhoneNumberUtil.ValidationResult.IS_POSSIBLE
            goto L_0x00c7
        L_0x00c5:
            com.google.i18n.phonenumbers.PhoneNumberUtil$ValidationResult r4 = com.google.i18n.phonenumbers.PhoneNumberUtil.ValidationResult.INVALID_LENGTH
        L_0x00c7:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.i18n.phonenumbers.PhoneNumberUtil.testNumberLength(java.lang.CharSequence, com.google.i18n.phonenumbers.Phonemetadata$PhoneMetadata, com.google.i18n.phonenumbers.PhoneNumberUtil$PhoneNumberType):com.google.i18n.phonenumbers.PhoneNumberUtil$ValidationResult");
    }
}

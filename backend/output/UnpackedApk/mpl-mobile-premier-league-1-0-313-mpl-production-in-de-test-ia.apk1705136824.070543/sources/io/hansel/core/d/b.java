package io.hansel.core.d;

import io.hansel.core.logger.HSLLogLevel;
import io.hansel.core.logger.LogGroup;

public class b {
    public static void a() {
        LogGroup.TG.setEnabled(true);
        LogGroup.DV.setEnabled(true);
        LogGroup.PT.setEnabled(true);
        LogGroup.GT.setEnabled(true);
        LogGroup.CS.setEnabled(true);
        LogGroup.CJ.setEnabled(true);
        LogGroup.WS.setEnabled(true);
        LogGroup.HC.setEnabled(true);
        LogGroup.AI.setEnabled(true);
        LogGroup.RC.setEnabled(true);
        LogGroup.OT.setEnabled(true);
    }

    public static void a(String str) {
        LogGroup logGroup;
        if (str != null && str.contains("hsl_debug_")) {
            String replace = str.replace("hsl_debug_", "");
            if (":MIN".equals(replace)) {
                HSLLogLevel.min.setEnabled(true);
                HSLLogLevel.mid.setEnabled(false);
                HSLLogLevel.debug.setEnabled(false);
                HSLLogLevel.all.setEnabled(false);
                return;
            }
            if (":MID::".equals(replace)) {
                HSLLogLevel.min.setEnabled(true);
                HSLLogLevel.mid.setEnabled(true);
                HSLLogLevel.debug.setEnabled(false);
            } else if (":ALL_LOG".equals(replace)) {
                HSLLogLevel.min.setEnabled(true);
                HSLLogLevel.mid.setEnabled(true);
                HSLLogLevel.debug.setEnabled(true);
            } else if (":ALL_STC".equals(replace)) {
                HSLLogLevel.min.setEnabled(true);
                HSLLogLevel.mid.setEnabled(true);
                HSLLogLevel.debug.setEnabled(true);
                HSLLogLevel.all.setEnabled(true);
                a();
            } else if (replace.startsWith(":MID:")) {
                HSLLogLevel.min.setEnabled(true);
                HSLLogLevel.mid.setEnabled(true);
                HSLLogLevel.debug.setEnabled(false);
                HSLLogLevel.all.setEnabled(false);
                for (String str2 : replace.replace(":MID:", "").split(":")) {
                    str2.hashCode();
                    char c2 = 65535;
                    switch (str2.hashCode()) {
                        case 2088:
                            if (str2.equals("AI")) {
                                c2 = 0;
                                break;
                            }
                            break;
                        case 2151:
                            if (str2.equals("CJ")) {
                                c2 = 1;
                                break;
                            }
                            break;
                        case 2160:
                            if (str2.equals("CS")) {
                                c2 = 2;
                                break;
                            }
                            break;
                        case 2194:
                            if (str2.equals("DV")) {
                                c2 = 3;
                                break;
                            }
                            break;
                        case 2285:
                            if (str2.equals("GT")) {
                                c2 = 4;
                                break;
                            }
                            break;
                        case 2299:
                            if (str2.equals("HC")) {
                                c2 = 5;
                                break;
                            }
                            break;
                        case 2533:
                            if (str2.equals("OT")) {
                                c2 = 6;
                                break;
                            }
                            break;
                        case 2564:
                            if (str2.equals("PT")) {
                                c2 = 7;
                                break;
                            }
                            break;
                        case 2609:
                            if (str2.equals("RC")) {
                                c2 = 8;
                                break;
                            }
                            break;
                        case 2675:
                            if (str2.equals("TG")) {
                                c2 = 9;
                                break;
                            }
                            break;
                        case 2780:
                            if (str2.equals("WS")) {
                                c2 = 10;
                                break;
                            }
                            break;
                    }
                    switch (c2) {
                        case 0:
                            logGroup = LogGroup.AI;
                            break;
                        case 1:
                            logGroup = LogGroup.CJ;
                            break;
                        case 2:
                            logGroup = LogGroup.CS;
                            break;
                        case 3:
                            logGroup = LogGroup.DV;
                            break;
                        case 4:
                            logGroup = LogGroup.GT;
                            break;
                        case 5:
                            logGroup = LogGroup.HC;
                            break;
                        case 6:
                            logGroup = LogGroup.OT;
                            break;
                        case 7:
                            logGroup = LogGroup.PT;
                            break;
                        case 8:
                            logGroup = LogGroup.RC;
                            break;
                        case 9:
                            logGroup = LogGroup.TG;
                            break;
                        case 10:
                            logGroup = LogGroup.WS;
                            break;
                    }
                    logGroup.setEnabled(true);
                }
                return;
            } else {
                return;
            }
            HSLLogLevel.all.setEnabled(false);
            a();
        }
    }
}

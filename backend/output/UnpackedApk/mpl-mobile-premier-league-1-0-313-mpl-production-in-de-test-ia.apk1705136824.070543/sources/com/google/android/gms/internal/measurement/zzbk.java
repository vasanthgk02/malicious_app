package com.google.android.gms.internal.measurement;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.modules.network.NetworkingModule;
import com.paynimo.android.payment.UPIFragment;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzbk extends zzaw {
    public zzbk() {
        this.zza.add(zzbl.ASSIGN);
        this.zza.add(zzbl.CONST);
        this.zza.add(zzbl.CREATE_ARRAY);
        this.zza.add(zzbl.CREATE_OBJECT);
        this.zza.add(zzbl.EXPRESSION_LIST);
        this.zza.add(zzbl.GET);
        this.zza.add(zzbl.GET_INDEX);
        this.zza.add(zzbl.GET_PROPERTY);
        this.zza.add(zzbl.NULL);
        this.zza.add(zzbl.SET_PROPERTY);
        this.zza.add(zzbl.TYPEOF);
        this.zza.add(zzbl.UNDEFINED);
        this.zza.add(zzbl.VAR);
    }

    public final zzap zza(String str, zzg zzg, List<zzap> list) {
        zzae zzae;
        zzam zzam;
        zzap zzap;
        String str2;
        zzbl zzbl = zzbl.ADD;
        int ordinal = zzh.zze(str).ordinal();
        int i = 0;
        if (ordinal == 3) {
            zzap zzb = zzg.zzb((zzap) GeneratedOutlineSupport.outline27(zzbl.ASSIGN, 2, list, 0));
            if (!(zzb instanceof zzat)) {
                throw new IllegalArgumentException(String.format("Expected string for assign var. got %s", new Object[]{zzb.getClass().getCanonicalName()}));
            } else if (zzg.zzh(zzb.zzi())) {
                zzap zzb2 = zzg.zzb((zzap) list.get(1));
                zzg.zzg(zzb.zzi(), zzb2);
                return zzb2;
            } else {
                throw new IllegalArgumentException(String.format("Attempting to assign undefined value %s", new Object[]{zzb.zzi()}));
            }
        } else if (ordinal == 14) {
            zzh.zzi(zzbl.CONST.name(), 2, list);
            if (list.size() % 2 == 0) {
                int i2 = 0;
                while (i2 < list.size() - 1) {
                    zzap zzb3 = zzg.zzb((zzap) list.get(i2));
                    if (zzb3 instanceof zzat) {
                        zzg.zzf(zzb3.zzi(), zzg.zzb((zzap) list.get(i2 + 1)));
                        i2 += 2;
                    } else {
                        throw new IllegalArgumentException(String.format("Expected string for const name. got %s", new Object[]{zzb3.getClass().getCanonicalName()}));
                    }
                }
                return zzap.zzf;
            }
            throw new IllegalArgumentException(String.format("CONST requires an even number of arguments, found %s", new Object[]{Integer.valueOf(list.size())}));
        } else if (ordinal == 24) {
            zzh.zzi(zzbl.EXPRESSION_LIST.name(), 1, list);
            zzap zzap2 = zzap.zzf;
            while (i < list.size()) {
                zzap2 = zzg.zzb((zzap) list.get(i));
                if (!(zzap2 instanceof zzag)) {
                    i++;
                } else {
                    throw new IllegalStateException("ControlValue cannot be in an expression list");
                }
            }
            return zzap2;
        } else if (ordinal == 33) {
            zzap zzb4 = zzg.zzb((zzap) GeneratedOutlineSupport.outline27(zzbl.GET, 1, list, 0));
            if (zzb4 instanceof zzat) {
                return zzg.zzd(zzb4.zzi());
            }
            throw new IllegalArgumentException(String.format("Expected string for get var. got %s", new Object[]{zzb4.getClass().getCanonicalName()}));
        } else if (ordinal == 49) {
            zzh.zzh(zzbl.NULL.name(), 0, list);
            return zzap.zzg;
        } else if (ordinal == 58) {
            zzap zzb5 = zzg.zzb((zzap) GeneratedOutlineSupport.outline27(zzbl.SET_PROPERTY, 3, list, 0));
            zzap zzb6 = zzg.zzb((zzap) list.get(1));
            zzap zzb7 = zzg.zzb((zzap) list.get(2));
            if (zzb5 == zzap.zzf || zzb5 == zzap.zzg) {
                throw new IllegalStateException(String.format("Can't set property %s of %s", new Object[]{zzb6.zzi(), zzb5.zzi()}));
            }
            if ((zzb5 instanceof zzae) && (zzb6 instanceof zzah)) {
                ((zzae) zzb5).zzq(zzb6.zzh().intValue(), zzb7);
            } else if (zzb5 instanceof zzal) {
                ((zzal) zzb5).zzr(zzb6.zzi(), zzb7);
            }
            return zzb7;
        } else if (ordinal == 17) {
            if (list.isEmpty()) {
                zzae = new zzae();
            } else {
                zzae = new zzae();
                for (zzap zzb8 : list) {
                    zzap zzb9 = zzg.zzb(zzb8);
                    if (!(zzb9 instanceof zzag)) {
                        zzae.zzq(i, zzb9);
                        i++;
                    } else {
                        throw new IllegalStateException("Failed to evaluate array element");
                    }
                }
            }
            return zzae;
        } else if (ordinal == 18) {
            if (list.isEmpty()) {
                zzam = new zzam();
            } else if (list.size() % 2 == 0) {
                zzam = new zzam();
                while (i < list.size() - 1) {
                    zzap zzb10 = zzg.zzb((zzap) list.get(i));
                    zzap zzb11 = zzg.zzb((zzap) list.get(i + 1));
                    if ((zzb10 instanceof zzag) || (zzb11 instanceof zzag)) {
                        throw new IllegalStateException("Failed to evaluate map entry");
                    }
                    zzam.zzr(zzb10.zzi(), zzb11);
                    i += 2;
                }
            } else {
                throw new IllegalArgumentException(String.format("CREATE_OBJECT requires an even number of arguments, found %s", new Object[]{Integer.valueOf(list.size())}));
            }
            return zzam;
        } else if (ordinal == 35 || ordinal == 36) {
            zzap zzb12 = zzg.zzb((zzap) GeneratedOutlineSupport.outline27(zzbl.GET_PROPERTY, 2, list, 0));
            zzap zzb13 = zzg.zzb((zzap) list.get(1));
            if ((zzb12 instanceof zzae) && zzh.zzk(zzb13)) {
                zzap = ((zzae) zzb12).zze(zzb13.zzh().intValue());
            } else if (zzb12 instanceof zzal) {
                zzap = ((zzal) zzb12).zzf(zzb13.zzi());
            } else {
                if (zzb12 instanceof zzat) {
                    if ("length".equals(zzb13.zzi())) {
                        zzap = new zzah(Double.valueOf((double) zzb12.zzi().length()));
                    } else if (zzh.zzk(zzb13) && zzb13.zzh().doubleValue() < ((double) zzb12.zzi().length())) {
                        zzap = new zzat(String.valueOf(zzb12.zzi().charAt(zzb13.zzh().intValue())));
                    }
                }
                zzap = zzap.zzf;
            }
            return zzap;
        } else {
            switch (ordinal) {
                case 62:
                    zzap zzb14 = zzg.zzb((zzap) GeneratedOutlineSupport.outline27(zzbl.TYPEOF, 1, list, 0));
                    if (zzb14 instanceof zzau) {
                        str2 = "undefined";
                    } else if (zzb14 instanceof zzaf) {
                        str2 = "boolean";
                    } else if (zzb14 instanceof zzah) {
                        str2 = UPIFragment.CONFIG_TYPE_NUMBER;
                    } else if (zzb14 instanceof zzat) {
                        str2 = NetworkingModule.REQUEST_BODY_KEY_STRING;
                    } else if (zzb14 instanceof zzao) {
                        str2 = "function";
                    } else if ((zzb14 instanceof zzaq) || (zzb14 instanceof zzag)) {
                        throw new IllegalArgumentException(String.format("Unsupported value type %s in typeof", new Object[]{zzb14}));
                    } else {
                        str2 = "object";
                    }
                    return new zzat(str2);
                case 63:
                    zzh.zzh(zzbl.UNDEFINED.name(), 0, list);
                    return zzap.zzf;
                case 64:
                    zzh.zzi(zzbl.VAR.name(), 1, list);
                    for (zzap zzb15 : list) {
                        zzap zzb16 = zzg.zzb(zzb15);
                        if (zzb16 instanceof zzat) {
                            zzg.zze(zzb16.zzi(), zzap.zzf);
                        } else {
                            throw new IllegalArgumentException(String.format("Expected string for var name. got %s", new Object[]{zzb16.getClass().getCanonicalName()}));
                        }
                    }
                    return zzap.zzf;
                default:
                    return super.zzb(str);
            }
        }
    }
}

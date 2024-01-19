package com.xiaomi.push.service;

import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.xiaomi.push.ag;
import com.xiaomi.push.ak;
import com.xiaomi.push.au;
import com.xiaomi.push.au.d;
import com.xiaomi.push.au.g;
import com.xiaomi.push.au.h;
import com.xiaomi.push.au.i;
import com.xiaomi.push.au.j;
import com.xiaomi.push.bi;
import com.xiaomi.push.bu;
import com.xiaomi.push.cg;
import com.xiaomi.push.ch;
import com.xiaomi.push.ci;
import com.xiaomi.push.cj;
import com.xiaomi.push.cx;
import com.xiaomi.push.service.az.b;
import com.xiaomi.push.service.az.c;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDBorderStyleDictionary;
import sfs2x.client.util.ClientDisconnectionReason;

public class ax {

    /* renamed from: a  reason: collision with root package name */
    public XMPushService f4877a;

    public ax(XMPushService xMPushService) {
        this.f4877a = xMPushService;
    }

    private void a(cg cgVar) {
        String c2 = cgVar.c();
        if (!TextUtils.isEmpty(c2)) {
            String[] split = c2.split(";");
            ag a2 = ak.a().a(bu.a(), false);
            if (a2 != null && split.length > 0) {
                a2.a(split);
                this.f4877a.a(20, (Exception) null);
                this.f4877a.a(true);
            }
        }
    }

    private void b(cj cjVar) {
        String l = cjVar.l();
        String k = cjVar.k();
        if (!TextUtils.isEmpty(l) && !TextUtils.isEmpty(k)) {
            b a2 = az.a().a(k, l);
            if (a2 != null) {
                cx.a(this.f4877a, a2.f869a, (long) cx.a(cjVar.a()), true, true, System.currentTimeMillis());
            }
        }
    }

    private void c(bi biVar) {
        String g = biVar.g();
        String num = Integer.toString(biVar.a());
        if (!TextUtils.isEmpty(g) && !TextUtils.isEmpty(num)) {
            b a2 = az.a().a(num, g);
            if (a2 != null) {
                cx.a(this.f4877a, a2.f869a, (long) biVar.c(), true, true, System.currentTimeMillis());
            }
        }
    }

    public void a(bi biVar) {
        if (5 != biVar.a()) {
            c(biVar);
        }
        try {
            b(biVar);
        } catch (Exception e2) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("handle Blob chid = ");
            outline73.append(biVar.a());
            outline73.append(" cmd = ");
            outline73.append(biVar.a());
            outline73.append(" packetid = ");
            outline73.append(biVar.e());
            outline73.append(" failure ");
            com.xiaomi.channel.commonutils.logger.b.a(outline73.toString(), (Throwable) e2);
        }
    }

    public void a(cj cjVar) {
        if (!"5".equals(cjVar.k())) {
            b(cjVar);
        }
        String k = cjVar.k();
        if (TextUtils.isEmpty(k)) {
            k = "1";
            cjVar.l(k);
        }
        if (k.equals("0")) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Received wrong packet with chid = 0 : ");
            outline73.append(cjVar.a());
            com.xiaomi.channel.commonutils.logger.b.a(outline73.toString());
        }
        if (cjVar instanceof ch) {
            cg a2 = cjVar.a((String) ClientDisconnectionReason.KICK);
            if (a2 != null) {
                String l = cjVar.l();
                String a3 = a2.a((String) "type");
                String a4 = a2.a((String) "reason");
                StringBuilder outline80 = GeneratedOutlineSupport.outline80("kicked by server, chid=", k, " res=");
                outline80.append(b.a(l));
                outline80.append(" type=");
                outline80.append(a3);
                outline80.append(" reason=");
                outline80.append(a4);
                com.xiaomi.channel.commonutils.logger.b.a(outline80.toString());
                if ("wait".equals(a3)) {
                    b a5 = az.a().a(k, l);
                    if (a5 != null) {
                        this.f4877a.a(a5);
                        a5.a(c.unbind, 3, 0, a4, a3);
                    }
                } else {
                    this.f4877a.a(k, l, 3, a4, a3);
                    az.a().a(k, l);
                }
                return;
            }
        } else if (cjVar instanceof ci) {
            ci ciVar = (ci) cjVar;
            if ("redir".equals(ciVar.b())) {
                cg a6 = ciVar.a((String) "hosts");
                if (a6 != null) {
                    a(a6);
                }
                return;
            }
        }
        this.f4877a.b().a(this.f4877a, k, cjVar);
    }

    public void b(bi biVar) {
        String str;
        String str2;
        StringBuilder sb;
        int i;
        int i2;
        c cVar;
        String a2 = biVar.a();
        if (biVar.a() != 0) {
            String num = Integer.toString(biVar.a());
            if ("SECMSG".equals(biVar.a())) {
                if (!biVar.a()) {
                    this.f4877a.b().a(this.f4877a, num, biVar);
                } else {
                    sb = GeneratedOutlineSupport.outline73("Recv SECMSG errCode = ");
                    sb.append(biVar.b());
                    sb.append(" errStr = ");
                    str2 = biVar.c();
                }
            } else if ("BIND".equals(a2)) {
                d a3 = d.a(biVar.a());
                String g = biVar.g();
                b a4 = az.a().a(num, g);
                if (a4 != null) {
                    if (a3.a()) {
                        StringBuilder outline73 = GeneratedOutlineSupport.outline73("SMACK: channel bind succeeded, chid=");
                        outline73.append(biVar.a());
                        com.xiaomi.channel.commonutils.logger.b.a(outline73.toString());
                        a4.a(c.binded, 1, 0, (String) null, (String) null);
                    } else {
                        String a5 = a3.a();
                        if ("auth".equals(a5)) {
                            if ("invalid-sig".equals(a3.b())) {
                                StringBuilder outline732 = GeneratedOutlineSupport.outline73("SMACK: bind error invalid-sig token = ");
                                outline732.append(a4.f4882c);
                                outline732.append(" sec = ");
                                outline732.append(a4.h);
                                com.xiaomi.channel.commonutils.logger.b.a(outline732.toString());
                            }
                            cVar = c.unbind;
                            i2 = 1;
                            i = 5;
                        } else if ("cancel".equals(a5)) {
                            cVar = c.unbind;
                            i2 = 1;
                            i = 7;
                        } else {
                            if ("wait".equals(a5)) {
                                this.f4877a.a(a4);
                                a4.a(c.unbind, 1, 7, a3.b(), a5);
                            }
                            StringBuilder outline80 = GeneratedOutlineSupport.outline80("SMACK: channel bind failed, chid=", num, " reason=");
                            outline80.append(a3.b());
                            str = outline80.toString();
                            com.xiaomi.channel.commonutils.logger.b.a(str);
                        }
                        a4.a(cVar, i2, i, a3.b(), a5);
                        az.a().a(num, g);
                        StringBuilder outline802 = GeneratedOutlineSupport.outline80("SMACK: channel bind failed, chid=", num, " reason=");
                        outline802.append(a3.b());
                        str = outline802.toString();
                        com.xiaomi.channel.commonutils.logger.b.a(str);
                    }
                } else {
                    return;
                }
            } else if ("KICK".equals(a2)) {
                g a6 = g.a(biVar.a());
                String g2 = biVar.g();
                String a7 = a6.a();
                String b2 = a6.b();
                StringBuilder outline803 = GeneratedOutlineSupport.outline80("kicked by server, chid=", num, " res= ");
                outline803.append(b.a(g2));
                outline803.append(" type=");
                outline803.append(a7);
                outline803.append(" reason=");
                outline803.append(b2);
                com.xiaomi.channel.commonutils.logger.b.a(outline803.toString());
                if ("wait".equals(a7)) {
                    b a8 = az.a().a(num, g2);
                    if (a8 != null) {
                        this.f4877a.a(a8);
                        a8.a(c.unbind, 3, 0, b2, a7);
                    }
                } else {
                    this.f4877a.a(num, g2, 3, b2, a7);
                    az.a().a(num, g2);
                }
            }
        }
        if ("PING".equals(a2)) {
            byte[] a9 = biVar.a();
            if (a9 != null && a9.length > 0) {
                j a10 = j.a(a9);
                if (a10.b()) {
                    bn.a().a(a10.a());
                }
            }
            if (!"com.xiaomi.xmsf".equals(this.f4877a.getPackageName())) {
                this.f4877a.a();
            }
            if ("1".equals(biVar.e())) {
                com.xiaomi.channel.commonutils.logger.b.a((String) "received a server ping");
            }
            this.f4877a.b();
        } else if ("SYNC".equals(a2)) {
            if ("CONF".equals(biVar.b())) {
                bn.a().a(au.b.a(biVar.a()));
            } else if (TextUtils.equals(PDBorderStyleDictionary.STYLE_UNDERLINE, biVar.b())) {
                bi biVar2 = new bi();
                biVar2.a(0);
                biVar2.a(biVar.a(), (String) "UCA");
                biVar2.a(biVar.e());
                XMPushService xMPushService = this.f4877a;
                xMPushService.a((XMPushService.j) new bl(xMPushService, biVar2));
            } else if (TextUtils.equals("P", biVar.b())) {
                i a11 = i.a(biVar.a());
                bi biVar3 = new bi();
                biVar3.a(0);
                biVar3.a(biVar.a(), (String) "PCA");
                biVar3.a(biVar.e());
                i iVar = new i();
                if (a11.a()) {
                    iVar.a(a11.a());
                }
                biVar3.a(iVar.a(), (String) null);
                XMPushService xMPushService2 = this.f4877a;
                xMPushService2.a((XMPushService.j) new bl(xMPushService2, biVar3));
                sb = new StringBuilder();
                sb.append("ACK msgP: id = ");
                str2 = biVar.e();
            }
        } else if ("NOTIFY".equals(biVar.a())) {
            h a12 = h.a(biVar.a());
            sb = GeneratedOutlineSupport.outline73("notify by server err = ");
            sb.append(a12.c());
            sb.append(" desc = ");
            str2 = a12.a();
        }
        sb.append(str2);
        str = sb.toString();
        com.xiaomi.channel.commonutils.logger.b.a(str);
    }
}

package com.xiaomi.push;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.au.d;
import com.xiaomi.push.service.aw;
import com.xiaomi.push.service.az;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map.Entry;
import org.apache.fontbox.cmap.CMapParser;

public class br implements ce {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f4505a;

    /* renamed from: a  reason: collision with other field name */
    public a f376a = null;

    /* renamed from: a  reason: collision with other field name */
    public bt f377a = null;

    /* renamed from: a  reason: collision with other field name */
    public bv f378a = null;

    /* renamed from: a  reason: collision with other field name */
    public final String f379a = "[Slim] ";

    /* renamed from: a  reason: collision with other field name */
    public SimpleDateFormat f380a = new SimpleDateFormat("hh:mm:ss aaa");

    /* renamed from: b  reason: collision with root package name */
    public a f4506b = null;

    public class a implements bx, cf {

        /* renamed from: a  reason: collision with other field name */
        public String f381a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f382a = true;

        public a(boolean z) {
            this.f382a = z;
            this.f381a = z ? " RCV " : " Sent ";
        }

        public void a(bi biVar) {
            String str;
            StringBuilder sb;
            if (br.f4505a) {
                sb = GeneratedOutlineSupport.outline73("[Slim] ");
                sb.append(br.a(br.this).format(new Date()));
                sb.append(this.f381a);
                str = biVar.toString();
            } else {
                sb = GeneratedOutlineSupport.outline73("[Slim] ");
                sb.append(br.a(br.this).format(new Date()));
                sb.append(this.f381a);
                sb.append(" Blob [");
                sb.append(biVar.a());
                sb.append(",");
                sb.append(biVar.a());
                sb.append(",");
                sb.append(aw.a(biVar.e()));
                str = CMapParser.MARK_END_OF_ARRAY;
            }
            sb.append(str);
            b.c(sb.toString());
            if (biVar != null && biVar.a() == 99999) {
                String a2 = biVar.a();
                bi biVar2 = null;
                if (!this.f382a) {
                    if ("BIND".equals(a2)) {
                        b.a((String) "build binded result for loopback.");
                        d dVar = new d();
                        dVar.a(true);
                        dVar.c("login success.");
                        dVar.b("success");
                        dVar.a((String) "success");
                        bi biVar3 = new bi();
                        biVar3.a(dVar.a(), (String) null);
                        biVar3.a(2);
                        biVar3.a(99999);
                        biVar3.a((String) "BIND", (String) null);
                        biVar3.a(biVar.e());
                        biVar3.b(null);
                        biVar3.c(biVar.g());
                        biVar2 = biVar3;
                    } else if (!"UBND".equals(a2) && "SECMSG".equals(a2)) {
                        bi biVar4 = new bi();
                        biVar4.a(99999);
                        biVar4.a((String) "SECMSG", (String) null);
                        biVar4.c(biVar.g());
                        biVar4.a(biVar.e());
                        biVar4.a(biVar.a());
                        biVar4.b(biVar.f());
                        biVar4.a(biVar.a(az.a().a(String.valueOf(99999), biVar.g()).h), (String) null);
                        biVar2 = biVar4;
                    }
                }
                if (biVar2 != null) {
                    for (Entry entry : br.a(br.this).a().entrySet()) {
                        if (br.a(br.this) != entry.getKey()) {
                            ((com.xiaomi.push.bt.a) entry.getValue()).a(biVar2);
                        }
                    }
                }
            }
        }

        public void a(cj cjVar) {
            String str;
            StringBuilder sb;
            if (br.f4505a) {
                sb = GeneratedOutlineSupport.outline73("[Slim] ");
                sb.append(br.a(br.this).format(new Date()));
                sb.append(this.f381a);
                sb.append(" PKT ");
                str = cjVar.a();
            } else {
                sb = GeneratedOutlineSupport.outline73("[Slim] ");
                sb.append(br.a(br.this).format(new Date()));
                sb.append(this.f381a);
                sb.append(" PKT [");
                sb.append(cjVar.k());
                sb.append(",");
                sb.append(cjVar.j());
                str = CMapParser.MARK_END_OF_ARRAY;
            }
            sb.append(str);
            b.c(sb.toString());
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m531a(cj cjVar) {
            return true;
        }
    }

    public br(bt btVar) {
        this.f377a = btVar;
        a();
    }

    private void a() {
        this.f376a = new a(true);
        this.f4506b = new a(false);
        bt btVar = this.f377a;
        a aVar = this.f376a;
        btVar.a((bx) aVar, (cf) aVar);
        bt btVar2 = this.f377a;
        a aVar2 = this.f4506b;
        btVar2.b((bx) aVar2, (cf) aVar2);
        this.f378a = new bs(this);
    }
}

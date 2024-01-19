package org.jboss.netty.util.internal.jzlib;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.graphics.g3d.particles.batches.BillboardParticleBatch;
import org.jboss.netty.util.internal.jzlib.JZlib.WrapperType;
import sfs2x.client.entities.invitation.InvitationReply;

public final class Deflate {
    public static final int BUSY_STATE = 113;
    public static final int BlockDone = 1;
    public static final int Buf_size = 16;
    public static final int DYN_TREES = 2;
    public static final int END_BLOCK = 256;
    public static final int FAST = 1;
    public static final int FINISH_STATE = 666;
    public static final int FinishDone = 3;
    public static final int FinishStarted = 2;
    public static final int INIT_STATE = 42;
    public static final int MAX_MATCH = 258;
    public static final int MIN_LOOKAHEAD = 262;
    public static final int MIN_MATCH = 3;
    public static final int NeedMore = 0;
    public static final int REPZ_11_138 = 18;
    public static final int REPZ_3_10 = 17;
    public static final int REP_3_6 = 16;
    public static final int SLOW = 2;
    public static final int STATIC_TREES = 1;
    public static final int STORED = 0;
    public static final int STORED_BLOCK = 0;
    public static final int Z_ASCII = 1;
    public static final int Z_BINARY = 0;
    public static final int Z_UNKNOWN = 2;
    public static final Config[] config_table;
    public static final String[] z_errmsg = {"need dictionary", "stream end", "", "file error", "stream error", "data error", "insufficient memory", "buffer error", "incompatible version", ""};
    public short bi_buf;
    public int bi_valid;
    public short[] bl_count = new short[16];
    public Tree bl_desc = new Tree();
    public short[] bl_tree = new short[78];
    public int block_start;
    public int d_buf;
    public Tree d_desc = new Tree();
    public byte data_type;
    public byte[] depth = new byte[JZlib.HEAP_SIZE];
    public short[] dyn_dtree = new short[122];
    public short[] dyn_ltree = new short[1146];
    public int good_match;
    public int gzipUncompressedBytes;
    public int hash_bits;
    public int hash_mask;
    public int hash_shift;
    public int hash_size;
    public short[] head;
    public int[] heap = new int[JZlib.HEAP_SIZE];
    public int heap_len;
    public int heap_max;
    public int ins_h;
    public int l_buf;
    public Tree l_desc = new Tree();
    public int last_eob_len;
    public int last_flush;
    public int last_lit;
    public int level;
    public int lit_bufsize;
    public int lookahead;
    public int match_available;
    public int match_length;
    public int match_start;
    public int matches;
    public int max_chain_length;
    public int max_lazy_match;
    public int nice_match;
    public int opt_len;
    public int pending;
    public byte[] pending_buf;
    public int pending_buf_size;
    public int pending_out;
    public short[] prev;
    public int prev_length;
    public int prev_match;
    public int static_len;
    public int status;
    public int strategy;
    public ZStream strm;
    public int strstart;
    public int w_bits;
    public int w_mask;
    public int w_size;
    public byte[] window;
    public int window_size;
    public WrapperType wrapperType;
    public boolean wroteTrailer;

    /* renamed from: org.jboss.netty.util.internal.jzlib.Deflate$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$org$jboss$netty$util$internal$jzlib$JZlib$WrapperType;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000e */
        static {
            /*
                org.jboss.netty.util.internal.jzlib.JZlib$WrapperType[] r0 = org.jboss.netty.util.internal.jzlib.JZlib.WrapperType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$jboss$netty$util$internal$jzlib$JZlib$WrapperType = r0
                org.jboss.netty.util.internal.jzlib.JZlib$WrapperType r1 = org.jboss.netty.util.internal.jzlib.JZlib.WrapperType.ZLIB     // Catch:{ NoSuchFieldError -> 0x000e }
                r1 = 1
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x000e }
            L_0x000e:
                int[] r0 = $SwitchMap$org$jboss$netty$util$internal$jzlib$JZlib$WrapperType     // Catch:{ NoSuchFieldError -> 0x0015 }
                org.jboss.netty.util.internal.jzlib.JZlib$WrapperType r1 = org.jboss.netty.util.internal.jzlib.JZlib.WrapperType.GZIP     // Catch:{ NoSuchFieldError -> 0x0015 }
                r1 = 2
                r0[r1] = r1     // Catch:{ NoSuchFieldError -> 0x0015 }
            L_0x0015:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.util.internal.jzlib.Deflate.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class Config {
        public final int func;
        public final int good_length;
        public final int max_chain;
        public final int max_lazy;
        public final int nice_length;

        public Config(int i, int i2, int i3, int i4, int i5) {
            this.good_length = i;
            this.max_lazy = i2;
            this.nice_length = i3;
            this.max_chain = i4;
            this.func = i5;
        }
    }

    static {
        Config[] configArr = new Config[10];
        config_table = configArr;
        Config config = new Config(0, 0, 0, 0, 0);
        configArr[0] = config;
        Config[] configArr2 = config_table;
        Config config2 = new Config(4, 4, 8, 4, 1);
        configArr2[1] = config2;
        Config[] configArr3 = config_table;
        Config config3 = new Config(4, 5, 16, 8, 1);
        configArr3[2] = config3;
        Config[] configArr4 = config_table;
        Config config4 = new Config(4, 6, 32, 32, 1);
        configArr4[3] = config4;
        Config[] configArr5 = config_table;
        Config config5 = new Config(4, 4, 16, 16, 2);
        configArr5[4] = config5;
        Config[] configArr6 = config_table;
        Config config6 = new Config(8, 16, 32, 32, 2);
        configArr6[5] = config6;
        Config[] configArr7 = config_table;
        Config config7 = new Config(8, 16, 128, 128, 2);
        configArr7[6] = config7;
        Config[] configArr8 = config_table;
        Config config8 = new Config(8, 32, 128, 256, 2);
        configArr8[7] = config8;
        Config[] configArr9 = config_table;
        Config config9 = new Config(32, 128, 258, 1024, 2);
        configArr9[8] = config9;
        Config[] configArr10 = config_table;
        Config config10 = new Config(32, 258, 258, 4096, 2);
        configArr10[9] = config10;
    }

    private void _tr_align() {
        send_bits(2, 3);
        send_code(256, StaticTree.static_ltree);
        bi_flush();
        if (((this.last_eob_len + 1) + 10) - this.bi_valid < 9) {
            send_bits(2, 3);
            send_code(256, StaticTree.static_ltree);
            bi_flush();
        }
        this.last_eob_len = 7;
    }

    private void _tr_flush_block(int i, int i2, boolean z) {
        int i3;
        int i4;
        int i5;
        if (this.level > 0) {
            if (this.data_type == 2) {
                set_data_type();
            }
            this.l_desc.build_tree(this);
            this.d_desc.build_tree(this);
            i5 = build_bl_tree();
            i4 = ((this.opt_len + 3) + 7) >>> 3;
            i3 = ((this.static_len + 3) + 7) >>> 3;
            if (i3 <= i4) {
                i4 = i3;
            }
        } else {
            i4 = i2 + 5;
            i5 = 0;
            i3 = i4;
        }
        if (i2 + 4 <= i4 && i != -1) {
            _tr_stored_block(i, i2, z);
        } else if (i3 == i4) {
            send_bits(z + true, 3);
            compress_block(StaticTree.static_ltree, StaticTree.static_dtree);
        } else {
            send_bits((z ? 1 : 0) + true, 3);
            send_all_trees(this.l_desc.max_code + 1, this.d_desc.max_code + 1, i5 + 1);
            compress_block(this.dyn_ltree, this.dyn_dtree);
        }
        init_block();
        if (z) {
            bi_windup();
        }
    }

    private void _tr_stored_block(int i, int i2, boolean z) {
        send_bits((z ? 1 : 0) + false, 3);
        copy_block(i, i2, true);
    }

    private boolean _tr_tally(int i, int i2) {
        byte[] bArr = this.pending_buf;
        int i3 = this.d_buf;
        int i4 = this.last_lit;
        bArr[(i4 * 2) + i3] = (byte) (i >>> 8);
        boolean z = true;
        bArr[GeneratedOutlineSupport.outline7(i4, 2, i3, 1)] = (byte) i;
        bArr[this.l_buf + i4] = (byte) i2;
        this.last_lit = i4 + 1;
        if (i == 0) {
            short[] sArr = this.dyn_ltree;
            int i5 = i2 * 2;
            sArr[i5] = (short) (sArr[i5] + 1);
        } else {
            this.matches++;
            short[] sArr2 = this.dyn_ltree;
            int i6 = (Tree._length_code[i2] + 256 + 1) * 2;
            sArr2[i6] = (short) (sArr2[i6] + 1);
            short[] sArr3 = this.dyn_dtree;
            int d_code = Tree.d_code(i - 1) * 2;
            sArr3[d_code] = (short) (sArr3[d_code] + 1);
        }
        int i7 = this.last_lit;
        if ((i7 & BillboardParticleBatch.MAX_PARTICLES_PER_MESH) == 0 && this.level > 2) {
            int i8 = i7 * 8;
            int i9 = this.strstart - this.block_start;
            for (int i10 = 0; i10 < 30; i10++) {
                i8 = (int) (((((long) Tree.extra_dbits[i10]) + 5) * ((long) this.dyn_dtree[i10 * 2])) + ((long) i8));
            }
            int i11 = i8 >>> 3;
            if (this.matches < this.last_lit / 2 && i11 < i9 / 2) {
                return true;
            }
        }
        if (this.last_lit != this.lit_bufsize - 1) {
            z = false;
        }
        return z;
    }

    private void bi_flush() {
        int i = this.bi_valid;
        if (i == 16) {
            put_short(this.bi_buf);
            this.bi_buf = 0;
            this.bi_valid = 0;
        } else if (i >= 8) {
            put_byte((byte) this.bi_buf);
            this.bi_buf = (short) (this.bi_buf >>> 8);
            this.bi_valid -= 8;
        }
    }

    private void bi_windup() {
        int i = this.bi_valid;
        if (i > 8) {
            put_short(this.bi_buf);
        } else if (i > 0) {
            put_byte((byte) this.bi_buf);
        }
        this.bi_buf = 0;
        this.bi_valid = 0;
    }

    private int build_bl_tree() {
        scan_tree(this.dyn_ltree, this.l_desc.max_code);
        scan_tree(this.dyn_dtree, this.d_desc.max_code);
        this.bl_desc.build_tree(this);
        int i = 18;
        while (i >= 3 && this.bl_tree[(Tree.bl_order[i] * 2) + 1] == 0) {
            i--;
        }
        this.opt_len = ((i + 1) * 3) + 5 + 5 + 4 + this.opt_len;
        return i;
    }

    private void compress_block(short[] sArr, short[] sArr2) {
        if (this.last_lit != 0) {
            int i = 0;
            do {
                byte[] bArr = this.pending_buf;
                int i2 = this.d_buf;
                int i3 = i * 2;
                byte b2 = (bArr[i2 + i3 + 1] & 255) | ((bArr[i2 + i3] << 8) & 65280);
                byte b3 = bArr[this.l_buf + i] & 255;
                i++;
                if (b2 == 0) {
                    send_code(b3, sArr);
                } else {
                    byte b4 = Tree._length_code[b3];
                    send_code(b4 + 256 + 1, sArr);
                    int i4 = Tree.extra_lbits[b4];
                    if (i4 != 0) {
                        send_bits(b3 - Tree.base_length[b4], i4);
                    }
                    int i5 = b2 - 1;
                    int d_code = Tree.d_code(i5);
                    send_code(d_code, sArr2);
                    int i6 = Tree.extra_dbits[d_code];
                    if (i6 != 0) {
                        send_bits(i5 - Tree.base_dist[d_code], i6);
                    }
                }
            } while (i < this.last_lit);
        }
        send_code(256, sArr);
        this.last_eob_len = sArr[513];
    }

    private void copy_block(int i, int i2, boolean z) {
        bi_windup();
        this.last_eob_len = 8;
        if (z) {
            put_short((short) i2);
            put_short((short) (~i2));
        }
        put_byte(this.window, i, i2);
    }

    private int deflateInit2(ZStream zStream, int i, int i2, int i3, int i4, int i5, WrapperType wrapperType2) {
        zStream.msg = null;
        if (i == -1) {
            i = 6;
        }
        if (i3 < 0) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline41("windowBits: ", i3));
        } else if (i4 < 1 || i4 > 9 || i2 != 8 || i3 < 9 || i3 > 15 || i < 0 || i > 9 || i5 < 0 || i5 > 2) {
            return -2;
        } else {
            zStream.dstate = this;
            this.wrapperType = wrapperType2;
            this.w_bits = i3;
            int i6 = 1 << i3;
            this.w_size = i6;
            this.w_mask = i6 - 1;
            int i7 = i4 + 7;
            this.hash_bits = i7;
            int i8 = 1 << i7;
            this.hash_size = i8;
            this.hash_mask = i8 - 1;
            this.hash_shift = ((i7 + 3) - 1) / 3;
            this.window = new byte[(i6 * 2)];
            this.prev = new short[i6];
            this.head = new short[i8];
            int i9 = 1 << (i4 + 6);
            this.lit_bufsize = i9;
            this.pending_buf = new byte[(i9 * 4)];
            this.pending_buf_size = i9 * 4;
            this.d_buf = i9 / 2;
            this.l_buf = i9 * 3;
            this.level = i;
            this.strategy = i5;
            return deflateReset(zStream);
        }
    }

    private int deflateReset(ZStream zStream) {
        zStream.total_out = 0;
        zStream.total_in = 0;
        zStream.msg = null;
        this.pending = 0;
        this.pending_out = 0;
        this.wroteTrailer = false;
        this.status = this.wrapperType == WrapperType.NONE ? 113 : 42;
        zStream.adler = Adler32.adler32(0, null, 0, 0);
        zStream.crc32 = 0;
        this.gzipUncompressedBytes = 0;
        this.last_flush = 0;
        tr_init();
        lm_init();
        return 0;
    }

    private int deflate_fast(int i) {
        boolean z;
        int i2;
        short s;
        int i3;
        short s2 = 0;
        while (true) {
            int i4 = 3;
            if (this.lookahead < 262) {
                fill_window();
                if (this.lookahead < 262 && i == 0) {
                    return 0;
                }
                if (this.lookahead == 0) {
                    flush_block_only(i == 4);
                    if (this.strm.avail_out == 0) {
                        return i == 4 ? 2 : 0;
                    }
                    if (i != 4) {
                        i4 = 1;
                    }
                    return i4;
                }
            }
            if (this.lookahead >= 3) {
                int i5 = this.ins_h << this.hash_shift;
                byte[] bArr = this.window;
                int i6 = this.strstart;
                byte b2 = (i5 ^ (bArr[(i6 + 3) - 1] & 255)) & this.hash_mask;
                this.ins_h = b2;
                short[] sArr = this.head;
                this.prev[this.w_mask & i6] = sArr[b2];
                sArr[b2] = (short) i6;
                s2 = sArr[b2] & 65535;
            }
            if (!(((long) s2) == 0 || ((this.strstart - s2) & 65535) > this.w_size - MIN_LOOKAHEAD || this.strategy == 2)) {
                this.match_length = longest_match(s2);
            }
            if (this.match_length >= 3) {
                z = _tr_tally(this.strstart - this.match_start, r2 - 3);
                int i7 = this.lookahead;
                int i8 = this.match_length;
                int i9 = i7 - i8;
                this.lookahead = i9;
                if (i8 > this.max_lazy_match || i9 < 3) {
                    int i10 = this.strstart + this.match_length;
                    this.strstart = i10;
                    this.match_length = 0;
                    byte[] bArr2 = this.window;
                    byte b3 = bArr2[i10] & 255;
                    this.ins_h = b3;
                    this.ins_h = ((bArr2[i10 + 1] & 255) ^ (b3 << this.hash_shift)) & this.hash_mask;
                } else {
                    this.match_length = i8 - 1;
                    do {
                        i2 = this.strstart + 1;
                        this.strstart = i2;
                        byte b4 = ((this.ins_h << this.hash_shift) ^ (this.window[(i2 + 3) - 1] & 255)) & this.hash_mask;
                        this.ins_h = b4;
                        short[] sArr2 = this.head;
                        s = sArr2[b4] & 65535;
                        this.prev[this.w_mask & i2] = sArr2[b4];
                        sArr2[b4] = (short) i2;
                        i3 = this.match_length - 1;
                        this.match_length = i3;
                    } while (i3 != 0);
                    this.strstart = i2 + 1;
                    s2 = s;
                }
            } else {
                z = _tr_tally(0, this.window[this.strstart] & 255);
                this.lookahead--;
                this.strstart++;
            }
            if (z) {
                flush_block_only(false);
                if (this.strm.avail_out == 0) {
                    return 0;
                }
            }
        }
    }

    private int deflate_slow(int i) {
        int i2;
        int i3;
        short s = 0;
        while (true) {
            int i4 = 3;
            if (this.lookahead < 262) {
                fill_window();
                if (this.lookahead < 262 && i == 0) {
                    return 0;
                }
                if (this.lookahead == 0) {
                    if (this.match_available != 0) {
                        _tr_tally(0, this.window[this.strstart - 1] & 255);
                        this.match_available = 0;
                    }
                    flush_block_only(i == 4);
                    if (this.strm.avail_out == 0) {
                        return i == 4 ? 2 : 0;
                    }
                    if (i != 4) {
                        i4 = 1;
                    }
                    return i4;
                }
            }
            if (this.lookahead >= 3) {
                int i5 = this.ins_h << this.hash_shift;
                byte[] bArr = this.window;
                int i6 = this.strstart;
                byte b2 = (i5 ^ (bArr[(i6 + 3) - 1] & 255)) & this.hash_mask;
                this.ins_h = b2;
                short[] sArr = this.head;
                this.prev[this.w_mask & i6] = sArr[b2];
                sArr[b2] = (short) i6;
                s = sArr[b2] & 65535;
            }
            int i7 = this.match_length;
            this.prev_length = i7;
            this.prev_match = this.match_start;
            this.match_length = 2;
            if (s != 0 && i7 < this.max_lazy_match && ((this.strstart - s) & 65535) <= this.w_size - MIN_LOOKAHEAD) {
                if (this.strategy != 2) {
                    this.match_length = longest_match(s);
                }
                int i8 = this.match_length;
                if (i8 <= 5 && (this.strategy == 1 || (i8 == 3 && this.strstart - this.match_start > 4096))) {
                    this.match_length = 2;
                }
            }
            int i9 = this.prev_length;
            if (i9 >= 3 && this.match_length <= i9) {
                int i10 = this.strstart;
                int i11 = (this.lookahead + i10) - 3;
                boolean _tr_tally = _tr_tally((i10 - 1) - this.prev_match, i9 - 3);
                this.lookahead = this.lookahead - (this.prev_length - 1);
                this.prev_length = i2 - 2;
                do {
                    int i12 = this.strstart + 1;
                    this.strstart = i12;
                    if (i12 <= i11) {
                        byte b3 = ((this.ins_h << this.hash_shift) ^ (this.window[(i12 + 3) - 1] & 255)) & this.hash_mask;
                        this.ins_h = b3;
                        short[] sArr2 = this.head;
                        this.prev[this.w_mask & i12] = sArr2[b3];
                        sArr2[b3] = (short) i12;
                        s = sArr2[b3] & 65535;
                    }
                    i3 = this.prev_length - 1;
                    this.prev_length = i3;
                } while (i3 != 0);
                this.match_available = 0;
                this.match_length = 2;
                this.strstart++;
                if (_tr_tally) {
                    flush_block_only(false);
                    if (this.strm.avail_out == 0) {
                        return 0;
                    }
                } else {
                    continue;
                }
            } else if (this.match_available != 0) {
                if (_tr_tally(0, this.window[this.strstart - 1] & 255)) {
                    flush_block_only(false);
                }
                this.strstart++;
                this.lookahead--;
                if (this.strm.avail_out == 0) {
                    return 0;
                }
            } else {
                this.match_available = 1;
                this.strstart++;
                this.lookahead--;
            }
        }
    }

    private int deflate_stored(int i) {
        int i2 = 65535;
        if (65535 > this.pending_buf_size - 5) {
            i2 = this.pending_buf_size - 5;
        }
        while (true) {
            int i3 = 1;
            int i4 = 0;
            if (this.lookahead <= 1) {
                fill_window();
                if (this.lookahead == 0 && i == 0) {
                    return 0;
                }
                if (this.lookahead == 0) {
                    flush_block_only(i == 4);
                    if (this.strm.avail_out == 0) {
                        if (i == 4) {
                            i4 = 2;
                        }
                        return i4;
                    }
                    if (i == 4) {
                        i3 = 3;
                    }
                    return i3;
                }
            }
            int i5 = this.strstart + this.lookahead;
            this.strstart = i5;
            this.lookahead = 0;
            int i6 = this.block_start + i2;
            if (i5 == 0 || i5 >= i6) {
                this.lookahead = this.strstart - i6;
                this.strstart = i6;
                flush_block_only(false);
                if (this.strm.avail_out == 0) {
                    return 0;
                }
            }
            if (this.strstart - this.block_start >= this.w_size - 262) {
                flush_block_only(false);
                if (this.strm.avail_out == 0) {
                    return 0;
                }
            }
        }
    }

    private void fill_window() {
        do {
            int i = this.window_size;
            int i2 = this.lookahead;
            int i3 = this.strstart;
            int i4 = (i - i2) - i3;
            if (i4 == 0 && i3 == 0 && i2 == 0) {
                i4 = this.w_size;
            } else if (i4 == -1) {
                i4--;
            } else {
                int i5 = this.strstart;
                int i6 = this.w_size;
                if (i5 >= (i6 + i6) - MIN_LOOKAHEAD) {
                    byte[] bArr = this.window;
                    System.arraycopy(bArr, i6, bArr, 0, i6);
                    int i7 = this.match_start;
                    int i8 = this.w_size;
                    this.match_start = i7 - i8;
                    this.strstart -= i8;
                    this.block_start -= i8;
                    int i9 = this.hash_size;
                    int i10 = i9;
                    do {
                        short[] sArr = this.head;
                        i9--;
                        short s = sArr[i9] & 65535;
                        int i11 = this.w_size;
                        sArr[i9] = s >= i11 ? (short) (s - i11) : 0;
                        i10--;
                    } while (i10 != 0);
                    int i12 = this.w_size;
                    int i13 = i12;
                    do {
                        short[] sArr2 = this.prev;
                        i12--;
                        short s2 = sArr2[i12] & 65535;
                        int i14 = this.w_size;
                        sArr2[i12] = s2 >= i14 ? (short) (s2 - i14) : 0;
                        i13--;
                    } while (i13 != 0);
                    i4 += this.w_size;
                }
            }
            ZStream zStream = this.strm;
            if (zStream.avail_in != 0) {
                int read_buf = this.lookahead + zStream.read_buf(this.window, this.strstart + this.lookahead, i4);
                this.lookahead = read_buf;
                if (read_buf >= 3) {
                    byte[] bArr2 = this.window;
                    int i15 = this.strstart;
                    byte b2 = bArr2[i15] & 255;
                    this.ins_h = b2;
                    this.ins_h = ((bArr2[i15 + 1] & 255) ^ (b2 << this.hash_shift)) & this.hash_mask;
                }
                if (this.lookahead >= 262) {
                    break;
                }
            } else {
                return;
            }
        } while (this.strm.avail_in != 0);
    }

    private void flush_block_only(boolean z) {
        int i = this.block_start;
        if (i < 0) {
            i = -1;
        }
        _tr_flush_block(i, this.strstart - this.block_start, z);
        this.block_start = this.strstart;
        this.strm.flush_pending();
    }

    private void init_block() {
        for (int i = 0; i < 286; i++) {
            this.dyn_ltree[i * 2] = 0;
        }
        for (int i2 = 0; i2 < 30; i2++) {
            this.dyn_dtree[i2 * 2] = 0;
        }
        for (int i3 = 0; i3 < 19; i3++) {
            this.bl_tree[i3 * 2] = 0;
        }
        this.dyn_ltree[512] = 1;
        this.static_len = 0;
        this.opt_len = 0;
        this.matches = 0;
        this.last_lit = 0;
    }

    private void lm_init() {
        this.window_size = this.w_size * 2;
        Config[] configArr = config_table;
        int i = this.level;
        this.max_lazy_match = configArr[i].max_lazy;
        this.good_match = configArr[i].good_length;
        this.nice_match = configArr[i].nice_length;
        this.max_chain_length = configArr[i].max_chain;
        this.strstart = 0;
        this.block_start = 0;
        this.lookahead = 0;
        this.prev_length = 2;
        this.match_length = 2;
        this.match_available = 0;
        this.ins_h = 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00d3, code lost:
        r1 = r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int longest_match(int r14) {
        /*
            r13 = this;
            int r0 = r13.max_chain_length
            int r1 = r13.strstart
            int r2 = r13.prev_length
            int r3 = r13.w_size
            int r4 = r3 + -262
            if (r1 <= r4) goto L_0x0011
            int r3 = r3 + -262
            int r3 = r1 - r3
            goto L_0x0012
        L_0x0011:
            r3 = 0
        L_0x0012:
            int r4 = r13.nice_match
            int r5 = r13.w_mask
            int r6 = r13.strstart
            int r6 = r6 + 258
            byte[] r7 = r13.window
            int r8 = r1 + r2
            int r9 = r8 + -1
            byte r9 = r7[r9]
            byte r7 = r7[r8]
            int r8 = r13.prev_length
            int r10 = r13.good_match
            if (r8 < r10) goto L_0x002c
            int r0 = r0 >> 2
        L_0x002c:
            int r8 = r13.lookahead
            if (r4 <= r8) goto L_0x0031
            r4 = r8
        L_0x0031:
            byte[] r8 = r13.window
            int r10 = r14 + r2
            byte r11 = r8[r10]
            if (r11 != r7) goto L_0x00c4
            int r10 = r10 + -1
            byte r10 = r8[r10]
            if (r10 != r9) goto L_0x00c4
            byte r10 = r8[r14]
            byte r11 = r8[r1]
            if (r10 != r11) goto L_0x00c4
            int r10 = r14 + 1
            byte r11 = r8[r10]
            int r12 = r1 + 1
            byte r8 = r8[r12]
            if (r11 == r8) goto L_0x0051
            goto L_0x00c4
        L_0x0051:
            int r1 = r1 + 2
            int r10 = r10 + 1
        L_0x0055:
            byte[] r8 = r13.window
            int r1 = r1 + 1
            byte r11 = r8[r1]
            int r10 = r10 + 1
            byte r12 = r8[r10]
            if (r11 != r12) goto L_0x00aa
            int r1 = r1 + 1
            byte r11 = r8[r1]
            int r10 = r10 + 1
            byte r12 = r8[r10]
            if (r11 != r12) goto L_0x00aa
            int r1 = r1 + 1
            byte r11 = r8[r1]
            int r10 = r10 + 1
            byte r12 = r8[r10]
            if (r11 != r12) goto L_0x00aa
            int r1 = r1 + 1
            byte r11 = r8[r1]
            int r10 = r10 + 1
            byte r12 = r8[r10]
            if (r11 != r12) goto L_0x00aa
            int r1 = r1 + 1
            byte r11 = r8[r1]
            int r10 = r10 + 1
            byte r12 = r8[r10]
            if (r11 != r12) goto L_0x00aa
            int r1 = r1 + 1
            byte r11 = r8[r1]
            int r10 = r10 + 1
            byte r12 = r8[r10]
            if (r11 != r12) goto L_0x00aa
            int r1 = r1 + 1
            byte r11 = r8[r1]
            int r10 = r10 + 1
            byte r12 = r8[r10]
            if (r11 != r12) goto L_0x00aa
            int r1 = r1 + 1
            byte r11 = r8[r1]
            int r10 = r10 + 1
            byte r8 = r8[r10]
            if (r11 != r8) goto L_0x00aa
            if (r1 >= r6) goto L_0x00aa
            goto L_0x0055
        L_0x00aa:
            int r1 = r6 - r1
            int r1 = 258 - r1
            int r8 = r6 + -258
            if (r1 <= r2) goto L_0x00c3
            r13.match_start = r14
            if (r1 < r4) goto L_0x00b7
            goto L_0x00d4
        L_0x00b7:
            byte[] r2 = r13.window
            int r7 = r8 + r1
            int r9 = r7 + -1
            byte r9 = r2[r9]
            byte r2 = r2[r7]
            r7 = r2
            r2 = r1
        L_0x00c3:
            r1 = r8
        L_0x00c4:
            short[] r8 = r13.prev
            r14 = r14 & r5
            short r14 = r8[r14]
            r8 = 65535(0xffff, float:9.1834E-41)
            r14 = r14 & r8
            if (r14 <= r3) goto L_0x00d3
            int r0 = r0 + -1
            if (r0 != 0) goto L_0x0031
        L_0x00d3:
            r1 = r2
        L_0x00d4:
            int r14 = r13.lookahead
            if (r1 > r14) goto L_0x00d9
            return r1
        L_0x00d9:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jboss.netty.util.internal.jzlib.Deflate.longest_match(int):int");
    }

    private final void putShortMSB(int i) {
        put_byte((byte) (i >> 8));
        put_byte((byte) i);
    }

    private final void put_byte(byte[] bArr, int i, int i2) {
        System.arraycopy(bArr, i, this.pending_buf, this.pending, i2);
        this.pending += i2;
    }

    private final void put_short(int i) {
        put_byte((byte) i);
        put_byte((byte) (i >>> 8));
    }

    private void scan_tree(short[] sArr, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        short s = sArr[1];
        if (s == 0) {
            i3 = 138;
            i2 = 3;
        } else {
            i3 = 7;
            i2 = 4;
        }
        short s2 = -1;
        sArr[((i + 1) * 2) + 1] = -1;
        int i6 = 0;
        int i7 = 0;
        while (i6 <= i) {
            i6++;
            short s3 = sArr[(i6 * 2) + 1];
            i7++;
            if (i7 >= i3 || s != s3) {
                if (i7 < i2) {
                    short[] sArr2 = this.bl_tree;
                    int i8 = s * 2;
                    sArr2[i8] = (short) (sArr2[i8] + i7);
                } else if (s != 0) {
                    if (s != s2) {
                        short[] sArr3 = this.bl_tree;
                        int i9 = s * 2;
                        sArr3[i9] = (short) (sArr3[i9] + 1);
                    }
                    short[] sArr4 = this.bl_tree;
                    sArr4[32] = (short) (sArr4[32] + 1);
                } else if (i7 <= 10) {
                    short[] sArr5 = this.bl_tree;
                    sArr5[34] = (short) (sArr5[34] + 1);
                } else {
                    short[] sArr6 = this.bl_tree;
                    sArr6[36] = (short) (sArr6[36] + 1);
                }
                if (s3 == 0) {
                    s2 = s;
                    i4 = 138;
                } else if (s == s3) {
                    i4 = 6;
                    s2 = s;
                } else {
                    s2 = s;
                    i4 = 7;
                    i5 = 4;
                    i7 = 0;
                }
                i5 = 3;
                i7 = 0;
            }
            s = s3;
        }
    }

    private void send_all_trees(int i, int i2, int i3) {
        send_bits(i - 257, 5);
        int i4 = i2 - 1;
        send_bits(i4, 5);
        send_bits(i3 - 4, 4);
        for (int i5 = 0; i5 < i3; i5++) {
            send_bits(this.bl_tree[(Tree.bl_order[i5] * 2) + 1], 3);
        }
        send_tree(this.dyn_ltree, i - 1);
        send_tree(this.dyn_dtree, i4);
    }

    private void send_bits(int i, int i2) {
        int i3 = this.bi_valid;
        if (i3 > 16 - i2) {
            short s = (short) (((i << i3) & 65535) | this.bi_buf);
            this.bi_buf = s;
            put_short(s);
            int i4 = this.bi_valid;
            this.bi_buf = (short) (i >>> (16 - i4));
            this.bi_valid = (i2 - 16) + i4;
            return;
        }
        this.bi_buf = (short) (((i << i3) & 65535) | this.bi_buf);
        this.bi_valid = i3 + i2;
    }

    private final void send_code(int i, short[] sArr) {
        int i2 = i * 2;
        send_bits(sArr[i2] & 65535, sArr[i2 + 1] & 65535);
    }

    private void send_tree(short[] sArr, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        short s = sArr[1];
        if (s == 0) {
            i3 = 138;
            i2 = 3;
        } else {
            i3 = 7;
            i2 = 4;
        }
        int i6 = i;
        int i7 = 0;
        int i8 = 0;
        short s2 = -1;
        while (i7 <= i6) {
            i7++;
            short s3 = sArr[(i7 * 2) + 1];
            i8++;
            if (i8 >= i3 || s != s3) {
                if (i8 < i2) {
                    do {
                        send_code(s, this.bl_tree);
                        i8--;
                    } while (i8 != 0);
                } else if (s != 0) {
                    if (s != s2) {
                        send_code(s, this.bl_tree);
                        i8--;
                    }
                    send_code(16, this.bl_tree);
                    send_bits(i8 - 3, 2);
                } else if (i8 <= 10) {
                    send_code(17, this.bl_tree);
                    send_bits(i8 - 3, 3);
                } else {
                    send_code(18, this.bl_tree);
                    send_bits(i8 - 11, 7);
                }
                if (s3 == 0) {
                    s2 = s;
                    i4 = 138;
                } else if (s == s3) {
                    i4 = 6;
                    s2 = s;
                } else {
                    s2 = s;
                    i4 = 7;
                    i5 = 4;
                    i8 = 0;
                }
                i5 = 3;
                i8 = 0;
            }
            s = s3;
        }
    }

    private void set_data_type() {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i2 < 7) {
            i3 += this.dyn_ltree[i2 * 2];
            i2++;
        }
        int i4 = 0;
        while (i2 < 128) {
            i4 += this.dyn_ltree[i2 * 2];
            i2++;
        }
        while (i2 < 256) {
            i3 += this.dyn_ltree[i2 * 2];
            i2++;
        }
        if (i3 <= (i4 >>> 2)) {
            i = 1;
        }
        this.data_type = (byte) i;
    }

    public static boolean smaller(short[] sArr, int i, int i2, byte[] bArr) {
        short s = sArr[i * 2];
        short s2 = sArr[i2 * 2];
        return s < s2 || (s == s2 && bArr[i] <= bArr[i2]);
    }

    private void tr_init() {
        Tree tree = this.l_desc;
        tree.dyn_tree = this.dyn_ltree;
        tree.stat_desc = StaticTree.static_l_desc;
        Tree tree2 = this.d_desc;
        tree2.dyn_tree = this.dyn_dtree;
        tree2.stat_desc = StaticTree.static_d_desc;
        Tree tree3 = this.bl_desc;
        tree3.dyn_tree = this.bl_tree;
        tree3.stat_desc = StaticTree.static_bl_desc;
        this.bi_buf = 0;
        this.bi_valid = 0;
        this.last_eob_len = 8;
        init_block();
    }

    public int deflate(ZStream zStream, int i) {
        int i2;
        ZStream zStream2 = zStream;
        int i3 = i;
        if (i3 <= 4 && i3 >= 0) {
            if (zStream2.next_out == null || ((zStream2.next_in == null && zStream2.avail_in != 0) || (this.status == 666 && i3 != 4))) {
                zStream2.msg = z_errmsg[4];
            } else if (zStream2.avail_out == 0) {
                zStream2.msg = z_errmsg[7];
                return -5;
            } else {
                this.strm = zStream2;
                int i4 = this.last_flush;
                this.last_flush = i3;
                int i5 = 1;
                if (this.status == 42) {
                    int ordinal = this.wrapperType.ordinal();
                    if (ordinal == 1) {
                        int i6 = (((this.w_bits - 8) << 4) + 8) << 8;
                        int i7 = ((this.level - 1) & InvitationReply.EXPIRED) >> 1;
                        if (i7 > 3) {
                            i7 = 3;
                        }
                        int i8 = i6 | (i7 << 6);
                        if (this.strstart != 0) {
                            i8 |= 32;
                        }
                        putShortMSB((31 - (i8 % 31)) + i8);
                        if (this.strstart != 0) {
                            putShortMSB((int) (zStream2.adler >>> 16));
                            putShortMSB((int) (zStream2.adler & 65535));
                        }
                        zStream2.adler = Adler32.adler32(0, null, 0, 0);
                    } else if (ordinal == 2) {
                        put_byte(31);
                        put_byte(-117);
                        put_byte(8);
                        put_byte(0);
                        put_byte(0);
                        put_byte(0);
                        put_byte(0);
                        put_byte(0);
                        int i9 = config_table[this.level].func;
                        if (i9 == 1) {
                            put_byte(4);
                        } else if (i9 != 2) {
                            put_byte(0);
                        } else {
                            put_byte(2);
                        }
                        put_byte(-1);
                        zStream2.crc32 = 0;
                    }
                    this.status = 113;
                }
                if (this.pending != 0) {
                    zStream.flush_pending();
                    if (zStream2.avail_out == 0) {
                        this.last_flush = -1;
                        return 0;
                    }
                } else if (zStream2.avail_in == 0 && i3 <= i4 && i3 != 4) {
                    zStream2.msg = z_errmsg[7];
                    return -5;
                }
                if (this.status != 666 || zStream2.avail_in == 0) {
                    int i10 = zStream2.next_in_index;
                    try {
                        if (!(zStream2.avail_in == 0 && this.lookahead == 0 && (i3 == 0 || this.status == 666))) {
                            int i11 = config_table[this.level].func;
                            if (i11 == 0) {
                                i2 = deflate_stored(i3);
                            } else if (i11 == 1) {
                                i2 = deflate_fast(i3);
                            } else if (i11 != 2) {
                                i2 = -1;
                            } else {
                                i2 = deflate_slow(i3);
                            }
                            if (i2 == 2 || i2 == 3) {
                                this.status = FINISH_STATE;
                            }
                            if (i2 != 0) {
                                if (i2 != 2) {
                                    if (i2 == 1) {
                                        if (i3 == 1) {
                                            _tr_align();
                                        } else {
                                            _tr_stored_block(0, 0, false);
                                            if (i3 == 3) {
                                                for (int i12 = 0; i12 < this.hash_size; i12++) {
                                                    this.head[i12] = 0;
                                                }
                                            }
                                        }
                                        zStream.flush_pending();
                                        if (zStream2.avail_out == 0) {
                                            this.last_flush = -1;
                                            return 0;
                                        }
                                    }
                                }
                            }
                            if (zStream2.avail_out == 0) {
                                this.last_flush = -1;
                            }
                            return 0;
                        }
                        this.gzipUncompressedBytes = (zStream2.next_in_index - i10) + this.gzipUncompressedBytes;
                        if (i3 != 4) {
                            return 0;
                        }
                        WrapperType wrapperType2 = this.wrapperType;
                        if (wrapperType2 != WrapperType.NONE && !this.wroteTrailer) {
                            int ordinal2 = wrapperType2.ordinal();
                            if (ordinal2 == 1) {
                                putShortMSB((int) (zStream2.adler >>> 16));
                                putShortMSB((int) (zStream2.adler & 65535));
                            } else if (ordinal2 == 2) {
                                put_byte((byte) (zStream2.crc32 & InvitationReply.EXPIRED));
                                put_byte((byte) ((zStream2.crc32 >>> 8) & InvitationReply.EXPIRED));
                                put_byte((byte) ((zStream2.crc32 >>> 16) & InvitationReply.EXPIRED));
                                put_byte((byte) ((zStream2.crc32 >>> 24) & InvitationReply.EXPIRED));
                                put_byte((byte) (this.gzipUncompressedBytes & InvitationReply.EXPIRED));
                                put_byte((byte) ((this.gzipUncompressedBytes >>> 8) & InvitationReply.EXPIRED));
                                put_byte((byte) ((this.gzipUncompressedBytes >>> 16) & InvitationReply.EXPIRED));
                                put_byte((byte) ((this.gzipUncompressedBytes >>> 24) & InvitationReply.EXPIRED));
                            }
                            zStream.flush_pending();
                            this.wroteTrailer = true;
                            if (this.pending != 0) {
                                i5 = 0;
                            }
                        }
                        return i5;
                    } finally {
                        this.gzipUncompressedBytes = (zStream2.next_in_index - i10) + this.gzipUncompressedBytes;
                    }
                } else {
                    zStream2.msg = z_errmsg[7];
                    return -5;
                }
            }
        }
        return -2;
    }

    public int deflateEnd() {
        int i = this.status;
        if (i != 42 && i != 113 && i != 666) {
            return -2;
        }
        this.pending_buf = null;
        this.head = null;
        this.prev = null;
        this.window = null;
        return this.status == 113 ? -3 : 0;
    }

    public int deflateInit(ZStream zStream, int i, int i2, WrapperType wrapperType2) {
        return deflateInit2(zStream, i, 8, i2, 8, 0, wrapperType2);
    }

    public int deflateParams(ZStream zStream, int i, int i2) {
        if (i == -1) {
            i = 6;
        }
        if (i < 0 || i > 9 || i2 < 0 || i2 > 2) {
            return -2;
        }
        Config[] configArr = config_table;
        int deflate = (configArr[this.level].func == configArr[i].func || zStream.total_in == 0) ? 0 : zStream.deflate(1);
        if (this.level != i) {
            this.level = i;
            Config[] configArr2 = config_table;
            this.max_lazy_match = configArr2[i].max_lazy;
            this.good_match = configArr2[i].good_length;
            this.nice_match = configArr2[i].nice_length;
            this.max_chain_length = configArr2[i].max_chain;
        }
        this.strategy = i2;
        return deflate;
    }

    public int deflateSetDictionary(ZStream zStream, byte[] bArr, int i) {
        int i2;
        int i3;
        if (bArr == null || this.status != 42) {
            return -2;
        }
        zStream.adler = Adler32.adler32(zStream.adler, bArr, 0, i);
        if (i < 3) {
            return 0;
        }
        if (i > this.w_size - 262) {
            i3 = this.w_size - 262;
            i2 = i - i3;
        } else {
            i3 = i;
            i2 = 0;
        }
        System.arraycopy(bArr, i2, this.window, 0, i3);
        this.strstart = i3;
        this.block_start = i3;
        byte[] bArr2 = this.window;
        byte b2 = bArr2[0] & 255;
        this.ins_h = b2;
        this.ins_h = ((bArr2[1] & 255) ^ (b2 << this.hash_shift)) & this.hash_mask;
        for (int i4 = 0; i4 <= i3 - 3; i4++) {
            byte b3 = ((this.ins_h << this.hash_shift) ^ (this.window[(i4 + 3) - 1] & 255)) & this.hash_mask;
            this.ins_h = b3;
            short[] sArr = this.head;
            this.prev[this.w_mask & i4] = sArr[b3];
            sArr[b3] = (short) i4;
        }
        return 0;
    }

    public void pqdownheap(short[] sArr, int i) {
        int i2 = this.heap[i];
        int i3 = i << 1;
        while (true) {
            int i4 = this.heap_len;
            if (i3 > i4) {
                break;
            }
            if (i3 < i4) {
                int[] iArr = this.heap;
                int i5 = i3 + 1;
                if (smaller(sArr, iArr[i5], iArr[i3], this.depth)) {
                    i3 = i5;
                }
            }
            if (smaller(sArr, i2, this.heap[i3], this.depth)) {
                break;
            }
            int[] iArr2 = this.heap;
            iArr2[i] = iArr2[i3];
            int i6 = i3;
            i3 <<= 1;
            i = i6;
        }
        this.heap[i] = i2;
    }

    private final void put_byte(byte b2) {
        byte[] bArr = this.pending_buf;
        int i = this.pending;
        this.pending = i + 1;
        bArr[i] = b2;
    }
}

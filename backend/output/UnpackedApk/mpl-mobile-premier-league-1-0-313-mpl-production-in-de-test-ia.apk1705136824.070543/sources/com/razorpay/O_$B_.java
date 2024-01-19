package com.razorpay;

import android.util.Base64;
import in.juspay.hypersdk.security.EncryptionHelper;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class O_$B_ {
    public byte[] G__G_ = new byte[32];
    public Cipher Q_$2$ = Cipher.getInstance("AES/CBC/PKCS5Padding");
    public byte[] R$$r_ = new byte[16];

    private String a_$P$(String str, String str2, O_$B_$a_$P$ o_$B_$a_$P$, String str3) throws UnsupportedEncodingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        String str4;
        int length = str2.getBytes("UTF-8").length;
        int length2 = str2.getBytes("UTF-8").length;
        byte[] bArr = this.G__G_;
        if (length2 > bArr.length) {
            length = bArr.length;
        }
        int length3 = str3.getBytes("UTF-8").length;
        int length4 = str3.getBytes("UTF-8").length;
        byte[] bArr2 = this.R$$r_;
        if (length4 > bArr2.length) {
            length3 = bArr2.length;
        }
        System.arraycopy(str2.getBytes("UTF-8"), 0, this.G__G_, 0, length);
        System.arraycopy(str3.getBytes("UTF-8"), 0, this.R$$r_, 0, length3);
        SecretKeySpec secretKeySpec = new SecretKeySpec(this.G__G_, EncryptionHelper.algorithm);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(this.R$$r_);
        if (o_$B_$a_$P$.equals(O_$B_$a_$P$.ENCRYPT)) {
            this.Q_$2$.init(1, secretKeySpec, ivParameterSpec);
            str4 = Base64.encodeToString(this.Q_$2$.doFinal(str.getBytes("UTF-8")), 2);
        } else {
            str4 = "";
        }
        if (!o_$B_$a_$P$.equals(O_$B_$a_$P$.DECRYPT)) {
            return str4;
        }
        this.Q_$2$.init(2, secretKeySpec, ivParameterSpec);
        return new String(this.Q_$2$.doFinal(Base64.decode(str.getBytes(), 2)));
    }

    public final String G__G_(String str, String str2, String str3) throws InvalidKeyException, UnsupportedEncodingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        return a_$P$(str, str2, O_$B_$a_$P$.DECRYPT, str3);
    }

    public final String a_$P$(String str, String str2, String str3) throws InvalidKeyException, UnsupportedEncodingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        return a_$P$(str, str2, O_$B_$a_$P$.ENCRYPT, str3);
    }
}

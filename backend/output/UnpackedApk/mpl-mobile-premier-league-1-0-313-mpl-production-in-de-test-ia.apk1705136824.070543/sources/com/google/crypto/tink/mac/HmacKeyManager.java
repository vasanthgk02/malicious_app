package com.google.crypto.tink.mac;

import com.google.crypto.tink.KeyTypeManager;
import com.google.crypto.tink.KeyTypeManager.KeyFactory;
import com.google.crypto.tink.KeyTypeManager.PrimitiveFactory;
import com.google.crypto.tink.Mac;
import com.google.crypto.tink.proto.HashType;
import com.google.crypto.tink.proto.HmacKey;
import com.google.crypto.tink.proto.HmacKey.Builder;
import com.google.crypto.tink.proto.HmacKeyFormat;
import com.google.crypto.tink.proto.HmacParams;
import com.google.crypto.tink.proto.KeyData.KeyMaterialType;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.shaded.protobuf.MessageLite;
import com.google.crypto.tink.subtle.PrfHmacJce;
import com.google.crypto.tink.subtle.PrfMac;
import com.google.crypto.tink.subtle.Random;
import com.google.crypto.tink.subtle.Validators;
import java.security.GeneralSecurityException;
import javax.crypto.spec.SecretKeySpec;

public final class HmacKeyManager extends KeyTypeManager<HmacKey> {
    public HmacKeyManager() {
        super(HmacKey.class, new PrimitiveFactory<Mac, HmacKey>(Mac.class) {
            public Object getPrimitive(Object obj) throws GeneralSecurityException {
                HmacKey hmacKey = (HmacKey) obj;
                HashType forNumber = HashType.forNumber(hmacKey.getParams().hash_);
                if (forNumber == null) {
                    forNumber = HashType.UNRECOGNIZED;
                }
                SecretKeySpec secretKeySpec = new SecretKeySpec(hmacKey.keyValue_.toByteArray(), "HMAC");
                int i = hmacKey.getParams().tagSize_;
                int ordinal = forNumber.ordinal();
                if (ordinal == 1) {
                    return new PrfMac(new PrfHmacJce("HMACSHA1", secretKeySpec), i);
                }
                if (ordinal == 3) {
                    return new PrfMac(new PrfHmacJce("HMACSHA256", secretKeySpec), i);
                }
                if (ordinal == 4) {
                    return new PrfMac(new PrfHmacJce("HMACSHA512", secretKeySpec), i);
                }
                throw new GeneralSecurityException("unknown hash");
            }
        });
    }

    public static void validateParams(HmacParams hmacParams) throws GeneralSecurityException {
        if (hmacParams.tagSize_ >= 10) {
            HashType forNumber = HashType.forNumber(hmacParams.hash_);
            if (forNumber == null) {
                forNumber = HashType.UNRECOGNIZED;
            }
            int ordinal = forNumber.ordinal();
            if (ordinal != 1) {
                if (ordinal != 3) {
                    if (ordinal != 4) {
                        throw new GeneralSecurityException("unknown hash type");
                    } else if (hmacParams.tagSize_ > 64) {
                        throw new GeneralSecurityException("tag size too big");
                    }
                } else if (hmacParams.tagSize_ > 32) {
                    throw new GeneralSecurityException("tag size too big");
                }
            } else if (hmacParams.tagSize_ > 20) {
                throw new GeneralSecurityException("tag size too big");
            }
        } else {
            throw new GeneralSecurityException("tag size too small");
        }
    }

    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.HmacKey";
    }

    public KeyFactory<HmacKeyFormat, HmacKey> keyFactory() {
        return new KeyFactory<HmacKeyFormat, HmacKey>(HmacKeyFormat.class) {
            public Object createKey(MessageLite messageLite) throws GeneralSecurityException {
                HmacKeyFormat hmacKeyFormat = (HmacKeyFormat) messageLite;
                Builder builder = (Builder) HmacKey.DEFAULT_INSTANCE.createBuilder();
                if (HmacKeyManager.this != null) {
                    builder.copyOnWrite();
                    ((HmacKey) builder.instance).version_ = 0;
                    HmacParams hmacParams = hmacKeyFormat.params_;
                    if (hmacParams == null) {
                        hmacParams = HmacParams.DEFAULT_INSTANCE;
                    }
                    builder.copyOnWrite();
                    HmacKey.access$300((HmacKey) builder.instance, hmacParams);
                    byte[] randBytes = Random.randBytes(hmacKeyFormat.keySize_);
                    ByteString copyFrom = ByteString.copyFrom(randBytes, 0, randBytes.length);
                    builder.copyOnWrite();
                    HmacKey.access$600((HmacKey) builder.instance, copyFrom);
                    return (HmacKey) builder.build();
                }
                throw null;
            }

            public MessageLite parseKeyFormat(ByteString byteString) throws InvalidProtocolBufferException {
                return (HmacKeyFormat) GeneratedMessageLite.parseFrom(HmacKeyFormat.DEFAULT_INSTANCE, byteString, ExtensionRegistryLite.getEmptyRegistry());
            }

            public void validateKeyFormat(MessageLite messageLite) throws GeneralSecurityException {
                HmacKeyFormat hmacKeyFormat = (HmacKeyFormat) messageLite;
                if (hmacKeyFormat.keySize_ >= 16) {
                    HmacParams hmacParams = hmacKeyFormat.params_;
                    if (hmacParams == null) {
                        hmacParams = HmacParams.DEFAULT_INSTANCE;
                    }
                    HmacKeyManager.validateParams(hmacParams);
                    return;
                }
                throw new GeneralSecurityException("key too short");
            }
        };
    }

    public KeyMaterialType keyMaterialType() {
        return KeyMaterialType.SYMMETRIC;
    }

    public MessageLite parseKey(ByteString byteString) throws InvalidProtocolBufferException {
        return (HmacKey) GeneratedMessageLite.parseFrom(HmacKey.DEFAULT_INSTANCE, byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    public void validateKey(HmacKey hmacKey) throws GeneralSecurityException {
        Validators.validateVersion(hmacKey.version_, 0);
        if (hmacKey.keyValue_.size() >= 16) {
            validateParams(hmacKey.getParams());
            return;
        }
        throw new GeneralSecurityException("key too short");
    }
}

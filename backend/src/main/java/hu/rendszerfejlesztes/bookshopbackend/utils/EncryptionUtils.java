package hu.rendszerfejlesztes.bookshopbackend.utils;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;

import java.security.MessageDigest;

public class EncryptionUtils {

    public static final String getMD5HashString(String plainText) {
        return Hashing.md5().hashString(plainText, Charsets.UTF_8).toString();
    }

}

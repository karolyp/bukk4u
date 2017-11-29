package hu.rendszerfejlesztes.bookshopbackend.utils;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;
import hu.rendszerfejlesztes.bookshopbackend.dao.entities.Customer;

public class EncryptionUtils {

    public static final String getMD5HashString(String plainText) {
        return Hashing.md5().hashString(plainText, Charsets.UTF_8).toString();
    }

    public static final String getSHA256HashString(Customer u) {
        return getSHA256HashString(u.getBytes());
    }

    public static final String getSHA256HashString(String s) {
        return getSHA256HashString(s.getBytes());
    }

    public static final String getSHA256HashString(byte[] bytes) {
        return Hashing.sha256().hashBytes(bytes).toString();
    }

}
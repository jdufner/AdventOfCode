package de.jdufner.adventofcode.fifteen;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class AoC1504 {

    private static MessageDigest md5 = null;

    static String calculateMD5(String secret, int number) throws NoSuchAlgorithmException {
        if (md5 == null) {
            md5 = MessageDigest.getInstance("MD5");
        }
        String s = (secret + number);
        byte[] bytes = s.getBytes(StandardCharsets.US_ASCII);
        return byteArrayToHex(md5.digest(bytes));
    }

    private static String byteArrayToHex(byte[] a) {
        StringBuilder sb = new StringBuilder(a.length * 2);
        for(byte b: a)
            sb.append(String.format("%02x", b));
        return sb.toString();
    }

    static int findNumber(String secret, String prefix) throws Exception {
        int index = 0;
        do {
            String s = calculateMD5(secret, index);
            if (s.startsWith(prefix)) {
                return index;
            }
            index++;
        } while (index < Integer.MAX_VALUE);
        throw new Exception("No value found!");
    }

}

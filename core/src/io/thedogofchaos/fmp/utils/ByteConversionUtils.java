package io.thedogofchaos.fmp.utils;

public class ByteConversionUtils {
    public static byte[] doublesToBytes(double[] d) {
        byte[] b = new byte[d.length << 3];
        for (int i = 0; i < d.length; i++) {
            copyLongIntoByteArray(b, i << 3, Double.doubleToRawLongBits(d[i]));
        }/*from  ww w . jav  a  2  s.c om*/
        return b;
    }

    public static void copyLongIntoByteArray(byte[] b, int byteIndex, long j) {
        for (int i = 7; i >= 0; i--) {
            b[byteIndex + i] = (byte) j;
            j >>= 8;
        }
    }
}

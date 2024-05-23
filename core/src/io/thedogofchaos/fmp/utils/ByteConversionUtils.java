/*
	Copyright (c) 2024 TheDogOfChaos

 	This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

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

package com.github.doraeven.commons.test.format;

import java.math.BigInteger;
import java.util.Locale;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.github.doraeven.commons.format.FileSizeFormat;

public class FileSizeFormatTest {

	@Test
	public void testHumanReadableByteCount() {
		// Binary, IEC(International Electrotechnical Commission)
		Assertions.assertEquals("0 B", FileSizeFormat.humanReadableByteCount(0));
		Assertions.assertEquals("1 B", FileSizeFormat.humanReadableByteCount(1));
		Assertions.assertEquals("480 B", FileSizeFormat.humanReadableByteCount(480));
		Assertions.assertEquals("520 B", FileSizeFormat.humanReadableByteCount(520));
		Assertions.assertEquals("1 KiB", FileSizeFormat.humanReadableByteCount(1024));
		Assertions.assertEquals("1.00 KiB", FileSizeFormat.humanReadableByteCount(1025));
		Assertions.assertEquals("1.99 KiB", FileSizeFormat.humanReadableByteCount(2047));
		Assertions.assertEquals("2 KiB", FileSizeFormat.humanReadableByteCount(2048));
		Assertions.assertEquals("1 MiB", FileSizeFormat.humanReadableByteCount(1024 * 1024));
		Assertions.assertEquals("1.00 MiB", FileSizeFormat.humanReadableByteCount(1024 * 1024 + 1));
		Assertions.assertEquals("1.99 MiB", FileSizeFormat.humanReadableByteCount(1024 * 1024 * 2 - 1));
		Assertions.assertEquals("1 GiB", FileSizeFormat.humanReadableByteCount(1024 * 1024 * 1024));
		Assertions.assertEquals("1.00 GiB", FileSizeFormat.humanReadableByteCount(1024L * 1024 * 1024 + 1));
		Assertions.assertEquals("1.99 GiB", FileSizeFormat.humanReadableByteCount(1024L * 1024 * 1024 * 2 - 1));
		Assertions.assertEquals("2 GiB", FileSizeFormat.humanReadableByteCount(1024L * 1024 * 1024 * 2));
		Assertions.assertEquals("1 TiB", FileSizeFormat.humanReadableByteCount(1024L * 1024 * 1024 * 1024));
		Assertions.assertEquals("1 PiB", FileSizeFormat.humanReadableByteCount(1024L * 1024 * 1024 * 1024 * 1024));
		Assertions.assertEquals("1 EiB",
				FileSizeFormat.humanReadableByteCount(1024L * 1024 * 1024 * 1024 * 1024 * 1024));
		Assertions.assertEquals("7.99 EiB", FileSizeFormat.humanReadableByteCount(Long.MAX_VALUE));
		Assertions.assertEquals("63.99 KiB", FileSizeFormat.humanReadableByteCount(Character.MAX_VALUE));
		Assertions.assertEquals("31.99 KiB", FileSizeFormat.humanReadableByteCount(Short.MAX_VALUE));
		Assertions.assertEquals("1.99 GiB", FileSizeFormat.humanReadableByteCount(Integer.MAX_VALUE));
	}

	@Test
	public void testHumanReadableByteCountUseSiUnits() {
		// Metric, SI(International System of Units)
		Assertions.assertEquals("0 B", FileSizeFormat.humanReadableByteCount(0, true));
		Assertions.assertEquals("1 B", FileSizeFormat.humanReadableByteCount(1, true));
		Assertions.assertEquals("480 B", FileSizeFormat.humanReadableByteCount(480, true));
		Assertions.assertEquals("520 B", FileSizeFormat.humanReadableByteCount(520, true));
		Assertions.assertEquals("1 kB", FileSizeFormat.humanReadableByteCount(1000, true));
		Assertions.assertEquals("1.02 kB", FileSizeFormat.humanReadableByteCount(1025, true));
		Assertions.assertEquals("1.99 kB", FileSizeFormat.humanReadableByteCount(1999, true));
		Assertions.assertEquals("2 kB", FileSizeFormat.humanReadableByteCount(2000, true));
		Assertions.assertEquals("1 MB", FileSizeFormat.humanReadableByteCount(1000 * 1000, true));
		Assertions.assertEquals("1.00 MB", FileSizeFormat.humanReadableByteCount(1000 * 1000 + 1, true));
		Assertions.assertEquals("1.99 MB", FileSizeFormat.humanReadableByteCount(1000 * 1000 * 2 - 1, true));
		Assertions.assertEquals("1 GB", FileSizeFormat.humanReadableByteCount(1000 * 1000 * 1000, true));
		Assertions.assertEquals("1.00 GB", FileSizeFormat.humanReadableByteCount(1000L * 1000 * 1000 + 1, true));
		Assertions.assertEquals("1.99 GB", FileSizeFormat.humanReadableByteCount(1000L * 1000 * 1000 * 2 - 1, true));
		Assertions.assertEquals("2 GB", FileSizeFormat.humanReadableByteCount(1000L * 1000 * 1000 * 2, true));
		Assertions.assertEquals("1 TB", FileSizeFormat.humanReadableByteCount(1000L * 1000 * 1000 * 1000, true));
		Assertions.assertEquals("1 PB", FileSizeFormat.humanReadableByteCount(1000L * 1000 * 1000 * 1000 * 1000, true));
		Assertions.assertEquals("1 EB",
				FileSizeFormat.humanReadableByteCount(1000L * 1000 * 1000 * 1000 * 1000 * 1000, true));
		Assertions.assertEquals("9.22 EB", FileSizeFormat.humanReadableByteCount(Long.MAX_VALUE, true));
		Assertions.assertEquals("65.53 kB", FileSizeFormat.humanReadableByteCount(Character.MAX_VALUE, true));
		Assertions.assertEquals("32.76 kB", FileSizeFormat.humanReadableByteCount(Short.MAX_VALUE, true));
		Assertions.assertEquals("2.14 GB", FileSizeFormat.humanReadableByteCount(Integer.MAX_VALUE, true));
	}

	@Test
	public void testHumanReadableByteCountMore() {
		Assertions.assertEquals("930 B", FileSizeFormat.humanReadableByteCount(930, Locale.getDefault()));
		Assertions.assertEquals("1023 B", FileSizeFormat.humanReadableByteCount(1023, Locale.GERMAN));
		Assertions.assertEquals("1.1 KiB", FileSizeFormat.humanReadableByteCount(1225, 1));
		Assertions.assertEquals("1.002 kB", FileSizeFormat.humanReadableByteCount(1027, true, 3, Locale.getDefault()));
	}

	@Test
	public void testUnits() {
		// 1B, 1
		Assertions.assertEquals(1, FileSizeFormat.ONE_B);

		// 1KB, 1000^1
		Assertions.assertEquals(1000, FileSizeFormat.ONE_KB);
		// 1KiB, 1024^1
		Assertions.assertEquals(1024, FileSizeFormat.ONE_KiB);
		// 1MB, 1000^2
		Assertions.assertEquals(Math.pow(1000, 2), FileSizeFormat.ONE_MB);
		// 1MiB, 1024^2
		Assertions.assertEquals(Math.pow(1024, 2), FileSizeFormat.ONE_MiB);
		// 1GB, 1000^3
		Assertions.assertEquals(Math.pow(1000, 3), FileSizeFormat.ONE_GB);
		// 1GiB, 1024^3
		Assertions.assertEquals(Math.pow(1024, 3), FileSizeFormat.ONE_GiB);
		// 1TB, 1000^4
		Assertions.assertEquals(Math.pow(1000, 4), FileSizeFormat.ONE_TB);
		// 1TiB, 1024^4
		Assertions.assertEquals(Math.pow(1024, 4), FileSizeFormat.ONE_TiB);
		// 1PB, 1000^5
		Assertions.assertEquals(Math.pow(1000, 5), FileSizeFormat.ONE_PB);
		// 1PiB, 1024^5
		Assertions.assertEquals(Math.pow(1024, 5), FileSizeFormat.ONE_PiB);
		// 1EB, 1000^6
		Assertions.assertEquals(Math.pow(1000, 6), FileSizeFormat.ONE_EB);
		// 1EiB, 1024^6
		Assertions.assertEquals(Math.pow(1024, 6), FileSizeFormat.ONE_EiB);

		// 1ZB, 1000^7
		Assertions.assertEquals(
				BigInteger.valueOf(FileSizeFormat.ONE_KB).multiply(BigInteger.valueOf(FileSizeFormat.ONE_EB)),
				FileSizeFormat.ONE_ZB_BI);
		// 1ZiB, 1024^7
		Assertions.assertEquals(
				BigInteger.valueOf(FileSizeFormat.ONE_KiB).multiply(BigInteger.valueOf(FileSizeFormat.ONE_EiB)),
				FileSizeFormat.ONE_ZiB_BI);
		// 1YB, 1000^8
		Assertions.assertEquals(BigInteger.valueOf(FileSizeFormat.ONE_KB).multiply(FileSizeFormat.ONE_ZB_BI),
				FileSizeFormat.ONE_YB_BI);
		// 1YiB, 1024^8
		Assertions.assertEquals(BigInteger.valueOf(FileSizeFormat.ONE_KiB).multiply(FileSizeFormat.ONE_ZiB_BI),
				FileSizeFormat.ONE_YiB_BI);
	}

}

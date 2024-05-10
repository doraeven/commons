package com.github.doraeven.commons.format;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Locale;
import java.util.Objects;

/**
 * File Size Format
 * 
 * <p>
 * Returns a human-readable version of the file size (original is in bytes).
 * </p>
 * 
 * <ul>
 * <li>Supports the SI or IEC units. SI (1 k = 1,000), Binary (1 Ki =
 * 1,024).</li>
 * <li>Supports I18n</li>
 * </ul>
 * 
 * @see <a href=
 *      "https://stackoverflow.com/questions/3758606/how-can-i-convert-byte-size-into-a-human-readable-format-in-java">https://stackoverflow.com/questions/3758606/how-can-i-convert-byte-size-into-a-human-readable-format-in-java</a>
 * @see <a href=
 *      "https://programming.guide/java/formatting-byte-size-to-human-readable-format.html">https://programming.guide/java/formatting-byte-size-to-human-readable-format.html</a>
 * @see <a href=
 *      "https://programming.guide/worlds-most-copied-so-snippet.html">https://programming.guide/worlds-most-copied-so-snippet.html</a>
 * @see <a href=
 *      "https://stackoverflow.com/questions/3263892/format-file-size-as-mb-gb-etc">https://stackoverflow.com/questions/3263892/format-file-size-as-mb-gb-etc</a>
 * @see <a href=
 *      "https://github.com/palantir/human-readable-types">https://github.com/palantir/human-readable-types</a>
 * @see <a href=
 *      "https://issues.apache.org/jira/browse/IO-226">https://issues.apache.org/jira/browse/IO-226</a>
 * @see <a href=
 *      "https://issues.apache.org/jira/browse/IO-373">https://issues.apache.org/jira/browse/IO-373</a>
 * 
 * @author motu
 *
 */
public class FileSizeFormat {

	/**
	 * Returns a human-readable version of the file size, where the input represents
	 * a specific number of bytes.
	 * 
	 * <p>
	 * If the size is over 1GB, the size is returned as the number of whole GB plus
	 * decimal places, i.e. 2047 bytes with precision of 1 will round to 1.9 KB
	 * </p>
	 * 
	 * <p>
	 * Similarly for all precision boundaries and sizes
	 * </p>
	 * 
	 * @param size the number of bytes
	 * @return a human-readable display value (includes SI units - YB, ZB, EB, PB,
	 *         TB, GB, MB, kB or B; BINARY units - YiB, ZiB, EiB, PiB, TiB, GiB,
	 *         MiB, KiB or B)
	 */
	public static String humanReadableByteCount(final BigInteger size) {
		return humanReadableByteCount(size, false);
	}

	/**
	 * Returns a human-readable version of the file size, where the input represents
	 * a specific number of bytes.
	 * 
	 * <p>
	 * If the size is over 1GB, the size is returned as the number of whole GB plus
	 * decimal places, i.e. 2047 bytes with precision of 1 will round to 1.9 KB
	 * </p>
	 * 
	 * <p>
	 * Similarly for all precision boundaries and sizes
	 * </p>
	 * 
	 * @param size   the number of bytes
	 * @param places the number of decimal places to display; not applicable for
	 *               bytes
	 * @return a human-readable display value (includes SI units - YB, ZB, EB, PB,
	 *         TB, GB, MB, kB or B; BINARY units - YiB, ZiB, EiB, PiB, TiB, GiB,
	 *         MiB, KiB or B)
	 */
	public static String humanReadableByteCount(final BigInteger size, final int places) {
		return humanReadableByteCount(size, false, places);
	}

	/**
	 * Returns a human-readable version of the file size, where the input represents
	 * a specific number of bytes.
	 * 
	 * <p>
	 * If the size is over 1GB, the size is returned as the number of whole GB plus
	 * decimal places, i.e. 2047 bytes with precision of 1 will round to 1.9 KB
	 * </p>
	 * 
	 * <p>
	 * Similarly for all precision boundaries and sizes
	 * </p>
	 * 
	 * @param size   the number of bytes
	 * @param locale the {@linkplain java.util.Locale locale} to apply during
	 *               formatting. If {@code locale} is {@code null} then no
	 *               localization is applied.
	 * @return a human-readable display value (includes SI units - YB, ZB, EB, PB,
	 *         TB, GB, MB, kB or B; BINARY units - YiB, ZiB, EiB, PiB, TiB, GiB,
	 *         MiB, KiB or B)
	 */
	public static String humanReadableByteCount(final BigInteger size, final Locale locale) {
		return humanReadableByteCount(size, false, locale);
	}

	/**
	 * Returns a human-readable version of the file size, where the input represents
	 * a specific number of bytes.
	 * 
	 * <p>
	 * If the size is over 1GB, the size is returned as the number of whole GB plus
	 * decimal places, i.e. 2047 bytes with precision of 1 will round to 1.9 KB
	 * </p>
	 * 
	 * <p>
	 * Similarly for all precision boundaries and sizes
	 * </p>
	 * 
	 * @param size       the number of bytes
	 * @param useSiUnits use Metric SI(International System of Units) or Binary
	 *                   IEC(International Electrotechnical Commission); default
	 *                   BINARY units: false
	 * @return a human-readable display value (includes SI units - YB, ZB, EB, PB,
	 *         TB, GB, MB, kB or B; BINARY units - YiB, ZiB, EiB, PiB, TiB, GiB,
	 *         MiB, KiB or B)
	 */
	public static String humanReadableByteCount(final BigInteger size, final boolean useSiUnits) {
		return humanReadableByteCount(size, useSiUnits, DEFAULT_PLACES);
	}

	/**
	 * Returns a human-readable version of the file size, where the input represents
	 * a specific number of bytes.
	 * 
	 * <p>
	 * If the size is over 1GB, the size is returned as the number of whole GB plus
	 * decimal places, i.e. 2047 bytes with precision of 1 will round to 1.9 KB
	 * </p>
	 * 
	 * <p>
	 * Similarly for all precision boundaries and sizes
	 * </p>
	 * 
	 * @param size   the number of bytes
	 * @param places the number of decimal places to display; not applicable for
	 *               bytes
	 * @param locale the {@linkplain java.util.Locale locale} to apply during
	 *               formatting. If {@code locale} is {@code null} then no
	 *               localization is applied.
	 * @return a human-readable display value (includes SI units - YB, ZB, EB, PB,
	 *         TB, GB, MB, kB or B; BINARY units - YiB, ZiB, EiB, PiB, TiB, GiB,
	 *         MiB, KiB or B)
	 */
	public static String humanReadableByteCount(final BigInteger size, final int places, final Locale locale) {
		return humanReadableByteCount(size, false, places, locale);
	}

	/**
	 * Returns a human-readable version of the file size, where the input represents
	 * a specific number of bytes.
	 * 
	 * <p>
	 * If the size is over 1GB, the size is returned as the number of whole GB plus
	 * decimal places, i.e. 2047 bytes with precision of 1 will round to 1.9 KB
	 * </p>
	 * 
	 * <p>
	 * Similarly for all precision boundaries and sizes
	 * </p>
	 * 
	 * @param size       the number of bytes
	 * @param useSiUnits use Metric SI(International System of Units) or Binary
	 *                   IEC(International Electrotechnical Commission); default
	 *                   BINARY units: false
	 * @param places     the number of decimal places to display; not applicable for
	 *                   bytes
	 * @return a human-readable display value (includes SI units - YB, ZB, EB, PB,
	 *         TB, GB, MB, kB or B; BINARY units - YiB, ZiB, EiB, PiB, TiB, GiB,
	 *         MiB, KiB or B)
	 */
	public static String humanReadableByteCount(final BigInteger size, final boolean useSiUnits, final int places) {
		return humanReadableByteCount(size, useSiUnits, places, Locale.getDefault());
	}

	/**
	 * Returns a human-readable version of the file size, where the input represents
	 * a specific number of bytes.
	 * 
	 * <p>
	 * If the size is over 1GB, the size is returned as the number of whole GB plus
	 * decimal places, i.e. 2047 bytes with precision of 1 will round to 1.9 KB
	 * </p>
	 * 
	 * <p>
	 * Similarly for all precision boundaries and sizes
	 * </p>
	 * 
	 * @param size       the number of bytes
	 * @param useSiUnits use Metric SI(International System of Units) or Binary
	 *                   IEC(International Electrotechnical Commission); default
	 *                   BINARY units: false
	 * @param locale     the {@linkplain java.util.Locale locale} to apply during
	 *                   formatting. If {@code locale} is {@code null} then no
	 *                   localization is applied.
	 * @return a human-readable display value (includes SI units - YB, ZB, EB, PB,
	 *         TB, GB, MB, kB or B; BINARY units - YiB, ZiB, EiB, PiB, TiB, GiB,
	 *         MiB, KiB or B)
	 */
	public static String humanReadableByteCount(final BigInteger size, final boolean useSiUnits, final Locale locale) {
		return humanReadableByteCount(size, useSiUnits, DEFAULT_PLACES, locale);
	}

	/**
	 * Returns a human-readable version of the file size, where the input represents
	 * a specific number of bytes.
	 * 
	 * <p>
	 * If the size is over 1GB, the size is returned as the number of whole GB plus
	 * decimal places, i.e. 2047 bytes with precision of 1 will round to 1.9 KB
	 * </p>
	 * 
	 * <p>
	 * Similarly for all precision boundaries and sizes
	 * </p>
	 * 
	 * @param size       the number of bytes
	 * @param useSiUnits use Metric SI(International System of Units) or Binary
	 *                   IEC(International Electrotechnical Commission); default
	 *                   BINARY units: false
	 * @param places     the number of decimal places to display; not applicable for
	 *                   bytes
	 * @param locale     the {@linkplain java.util.Locale locale} to apply during
	 *                   formatting. If {@code locale} is {@code null} then no
	 *                   localization is applied.
	 * @return a human-readable display value (includes SI units - YB, ZB, EB, PB,
	 *         TB, GB, MB, kB or B; BINARY units - YiB, ZiB, EiB, PiB, TiB, GiB,
	 *         MiB, KiB or B)
	 */
	public static String humanReadableByteCount(final BigInteger size, final boolean useSiUnits, final int places,
			final Locale locale) {
		Objects.requireNonNull(size, "size");

		BigDecimal sizeDividend = new BigDecimal(size);
		RoundingMode roundingMode = RoundingMode.DOWN;
		String formatPattern = "%s %s";
		String displaySize;

		if (size.divide(useSiUnits ? ONE_YB_BI : ONE_YiB_BI).compareTo(BigInteger.ZERO) > 0) {
			BigDecimal unitDivisor = new BigDecimal(useSiUnits ? ONE_YB_BI : ONE_YiB_BI);
			BigDecimal sizeRemainder = sizeDividend.remainder(unitDivisor);
			BigDecimal sizeDivide;
			if (sizeRemainder.compareTo(BigDecimal.ZERO) == 0) {
				sizeDivide = sizeDividend.divide(unitDivisor);
			} else {
				sizeDivide = sizeDividend.divide(unitDivisor, places, roundingMode);
			}
			String unit = String.valueOf(useSiUnits ? SI_UNITS.YB : BINARY_UNITS.YiB);
			displaySize = String.format(locale, formatPattern, sizeDivide, unit);
		} else if (size.divide(useSiUnits ? ONE_ZB_BI : ONE_ZiB_BI).compareTo(BigInteger.ZERO) > 0) {
			BigDecimal unitDivisor = new BigDecimal(useSiUnits ? ONE_ZB_BI : ONE_ZiB_BI);
			BigDecimal sizeRemainder = sizeDividend.remainder(unitDivisor);
			BigDecimal sizeDivide;
			if (sizeRemainder.compareTo(BigDecimal.ZERO) == 0) {
				sizeDivide = sizeDividend.divide(unitDivisor);
			} else {
				sizeDivide = sizeDividend.divide(unitDivisor, places, roundingMode);
			}
			String unit = String.valueOf(useSiUnits ? SI_UNITS.ZB : BINARY_UNITS.ZiB);
			displaySize = String.format(locale, formatPattern, sizeDivide, unit);
		} else if (size.divide(useSiUnits ? ONE_EB_BI : ONE_EiB_BI).compareTo(BigInteger.ZERO) > 0) {
			BigDecimal unitDivisor = new BigDecimal(useSiUnits ? ONE_EB_BI : ONE_EiB_BI);
			BigDecimal sizeRemainder = sizeDividend.remainder(unitDivisor);
			BigDecimal sizeDivide;
			if (sizeRemainder.compareTo(BigDecimal.ZERO) == 0) {
				sizeDivide = sizeDividend.divide(unitDivisor);
			} else {
				sizeDivide = sizeDividend.divide(unitDivisor, places, roundingMode);
			}
			String unit = String.valueOf(useSiUnits ? SI_UNITS.EB : BINARY_UNITS.EiB);
			displaySize = String.format(locale, formatPattern, sizeDivide, unit);
		} else if (size.divide(useSiUnits ? ONE_PB_BI : ONE_PiB_BI).compareTo(BigInteger.ZERO) > 0) {
			BigDecimal unitDivisor = new BigDecimal(useSiUnits ? ONE_PB_BI : ONE_PiB_BI);
			BigDecimal sizeRemainder = sizeDividend.remainder(unitDivisor);
			BigDecimal sizeDivide;
			if (sizeRemainder.compareTo(BigDecimal.ZERO) == 0) {
				sizeDivide = sizeDividend.divide(unitDivisor);
			} else {
				sizeDivide = sizeDividend.divide(unitDivisor, places, roundingMode);
			}
			String unit = String.valueOf(useSiUnits ? SI_UNITS.PB : BINARY_UNITS.PiB);
			displaySize = String.format(locale, formatPattern, sizeDivide, unit);
		} else if (size.divide(useSiUnits ? ONE_TB_BI : ONE_TiB_BI).compareTo(BigInteger.ZERO) > 0) {
			BigDecimal unitDivisor = new BigDecimal(useSiUnits ? ONE_TB_BI : ONE_TiB_BI);
			BigDecimal sizeRemainder = sizeDividend.remainder(unitDivisor);
			BigDecimal sizeDivide;
			if (sizeRemainder.compareTo(BigDecimal.ZERO) == 0) {
				sizeDivide = sizeDividend.divide(unitDivisor);
			} else {
				sizeDivide = sizeDividend.divide(unitDivisor, places, roundingMode);
			}
			String unit = String.valueOf(useSiUnits ? SI_UNITS.TB : BINARY_UNITS.TiB);
			displaySize = String.format(locale, formatPattern, sizeDivide, unit);
		} else if (size.divide(useSiUnits ? ONE_GB_BI : ONE_GiB_BI).compareTo(BigInteger.ZERO) > 0) {
			BigDecimal unitDivisor = new BigDecimal(useSiUnits ? ONE_GB_BI : ONE_GiB_BI);
			BigDecimal sizeRemainder = sizeDividend.remainder(unitDivisor);
			BigDecimal sizeDivide;
			if (sizeRemainder.compareTo(BigDecimal.ZERO) == 0) {
				sizeDivide = sizeDividend.divide(unitDivisor);
			} else {
				sizeDivide = sizeDividend.divide(unitDivisor, places, roundingMode);
			}
			String unit = String.valueOf(useSiUnits ? SI_UNITS.GB : BINARY_UNITS.GiB);
			displaySize = String.format(locale, formatPattern, sizeDivide, unit);
		} else if (size.divide(useSiUnits ? ONE_MB_BI : ONE_MiB_BI).compareTo(BigInteger.ZERO) > 0) {
			BigDecimal unitDivisor = new BigDecimal(useSiUnits ? ONE_MB_BI : ONE_MiB_BI);
			BigDecimal sizeRemainder = sizeDividend.remainder(unitDivisor);
			BigDecimal sizeDivide;
			if (sizeRemainder.compareTo(BigDecimal.ZERO) == 0) {
				sizeDivide = sizeDividend.divide(unitDivisor);
			} else {
				sizeDivide = sizeDividend.divide(unitDivisor, places, roundingMode);
			}
			String unit = String.valueOf(useSiUnits ? SI_UNITS.MB : BINARY_UNITS.MiB);
			displaySize = String.format(locale, formatPattern, sizeDivide, unit);
		} else if (size.divide(useSiUnits ? ONE_KB_BI : ONE_KiB_BI).compareTo(BigInteger.ZERO) > 0) {
			BigDecimal unitDivisor = new BigDecimal(useSiUnits ? ONE_KB_BI : ONE_KiB_BI);
			BigDecimal sizeRemainder = sizeDividend.remainder(unitDivisor);
			BigDecimal sizeDivide;
			if (sizeRemainder.compareTo(BigDecimal.ZERO) == 0) {
				sizeDivide = sizeDividend.divide(unitDivisor);
			} else {
				sizeDivide = sizeDividend.divide(unitDivisor, places, roundingMode);
			}
			String unit = String.valueOf(useSiUnits ? SI_UNITS.kB : BINARY_UNITS.KiB);
			displaySize = String.format(locale, formatPattern, sizeDivide, unit);
		} else {
			String unit = String.valueOf(useSiUnits ? SI_UNITS.B : BINARY_UNITS.B);
			displaySize = String.format(locale, formatPattern, size, unit);
		}

		return displaySize;
	}

	/**
	 * Returns a human-readable version of the file size, where the input represents
	 * a specific number of bytes.
	 * 
	 * <p>
	 * If the size is over 1GB, the size is returned as the number of whole GB plus
	 * decimal places, i.e. 2047 bytes with precision of 1 will round to 1.9 KB
	 * </p>
	 * 
	 * <p>
	 * Similarly for all precision boundaries and sizes
	 * </p>
	 * 
	 * @param size the number of bytes
	 * @return a human-readable display value (includes SI units - YB, ZB, EB, PB,
	 *         TB, GB, MB, kB or B; BINARY units - YiB, ZiB, EiB, PiB, TiB, GiB,
	 *         MiB, KiB or B)
	 */
	public static String humanReadableByteCount(final long size) {
		return humanReadableByteCount(BigInteger.valueOf(size));
	}

	/**
	 * Returns a human-readable version of the file size, where the input represents
	 * a specific number of bytes.
	 * 
	 * <p>
	 * If the size is over 1GB, the size is returned as the number of whole GB plus
	 * decimal places, i.e. 2047 bytes with precision of 1 will round to 1.9 KB
	 * </p>
	 * 
	 * <p>
	 * Similarly for all precision boundaries and sizes
	 * </p>
	 * 
	 * @param size   the number of bytes
	 * @param places the number of decimal places to display; not applicable for
	 *               bytes
	 * @return a human-readable display value (includes SI units - YB, ZB, EB, PB,
	 *         TB, GB, MB, kB or B; BINARY units - YiB, ZiB, EiB, PiB, TiB, GiB,
	 *         MiB, KiB or B)
	 */
	public static String humanReadableByteCount(final long size, final int places) {
		return humanReadableByteCount(BigInteger.valueOf(size), places);
	}

	/**
	 * Returns a human-readable version of the file size, where the input represents
	 * a specific number of bytes.
	 * 
	 * <p>
	 * If the size is over 1GB, the size is returned as the number of whole GB plus
	 * decimal places, i.e. 2047 bytes with precision of 1 will round to 1.9 KB
	 * </p>
	 * 
	 * <p>
	 * Similarly for all precision boundaries and sizes
	 * </p>
	 * 
	 * @param size   the number of bytes
	 * @param locale the {@linkplain java.util.Locale locale} to apply during
	 *               formatting. If {@code locale} is {@code null} then no
	 *               localization is applied.
	 * @return a human-readable display value (includes SI units - YB, ZB, EB, PB,
	 *         TB, GB, MB, kB or B; BINARY units - YiB, ZiB, EiB, PiB, TiB, GiB,
	 *         MiB, KiB or B)
	 */
	public static String humanReadableByteCount(final long size, final Locale locale) {
		return humanReadableByteCount(BigInteger.valueOf(size), locale);
	}

	/**
	 * Returns a human-readable version of the file size, where the input represents
	 * a specific number of bytes.
	 * 
	 * <p>
	 * If the size is over 1GB, the size is returned as the number of whole GB plus
	 * decimal places, i.e. 2047 bytes with precision of 1 will round to 1.9 KB
	 * </p>
	 * 
	 * <p>
	 * Similarly for all precision boundaries and sizes
	 * </p>
	 * 
	 * @param size   the number of bytes
	 * @param places the number of decimal places to display; not applicable for
	 *               bytes
	 * @param locale the {@linkplain java.util.Locale locale} to apply during
	 *               formatting. If {@code locale} is {@code null} then no
	 *               localization is applied.
	 * @return a human-readable display value (includes SI units - YB, ZB, EB, PB,
	 *         TB, GB, MB, kB or B; BINARY units - YiB, ZiB, EiB, PiB, TiB, GiB,
	 *         MiB, KiB or B)
	 */
	public static String humanReadableByteCount(final long size, final int places, final Locale locale) {
		return humanReadableByteCount(BigInteger.valueOf(size), places, locale);
	}

	/**
	 * Returns a human-readable version of the file size, where the input represents
	 * a specific number of bytes.
	 * 
	 * <p>
	 * If the size is over 1GB, the size is returned as the number of whole GB plus
	 * decimal places, i.e. 2047 bytes with precision of 1 will round to 1.9 KB
	 * </p>
	 * 
	 * <p>
	 * Similarly for all precision boundaries and sizes
	 * </p>
	 * 
	 * @param size       the number of bytes
	 * @param useSiUnits use Metric SI(International System of Units) or Binary
	 *                   IEC(International Electrotechnical Commission); default
	 *                   BINARY units: false
	 * @return a human-readable display value (includes SI units - YB, ZB, EB, PB,
	 *         TB, GB, MB, kB or B; BINARY units - YiB, ZiB, EiB, PiB, TiB, GiB,
	 *         MiB, KiB or B)
	 */
	public static String humanReadableByteCount(final long size, final boolean useSiUnits) {
		return humanReadableByteCount(BigInteger.valueOf(size), useSiUnits);
	}

	/**
	 * Returns a human-readable version of the file size, where the input represents
	 * a specific number of bytes.
	 * 
	 * <p>
	 * If the size is over 1GB, the size is returned as the number of whole GB plus
	 * decimal places, i.e. 2047 bytes with precision of 1 will round to 1.9 KB
	 * </p>
	 * 
	 * <p>
	 * Similarly for all precision boundaries and sizes
	 * </p>
	 * 
	 * @param size       the number of bytes
	 * @param useSiUnits use Metric SI(International System of Units) or Binary
	 *                   IEC(International Electrotechnical Commission); default
	 *                   BINARY units: false
	 * @param places     the number of decimal places to display; not applicable for
	 *                   bytes
	 * @return a human-readable display value (includes SI units - YB, ZB, EB, PB,
	 *         TB, GB, MB, kB or B; BINARY units - YiB, ZiB, EiB, PiB, TiB, GiB,
	 *         MiB, KiB or B)
	 */
	public static String humanReadableByteCount(final long size, final boolean useSiUnits, final int places) {
		return humanReadableByteCount(BigInteger.valueOf(size), useSiUnits, places);
	}

	/**
	 * Returns a human-readable version of the file size, where the input represents
	 * a specific number of bytes.
	 * 
	 * <p>
	 * If the size is over 1GB, the size is returned as the number of whole GB plus
	 * decimal places, i.e. 2047 bytes with precision of 1 will round to 1.9 KB
	 * </p>
	 * 
	 * <p>
	 * Similarly for all precision boundaries and sizes
	 * </p>
	 * 
	 * @param size       the number of bytes
	 * @param useSiUnits use Metric SI(International System of Units) or Binary
	 *                   IEC(International Electrotechnical Commission); default
	 *                   BINARY units: false
	 * @param locale     the {@linkplain java.util.Locale locale} to apply during
	 *                   formatting. If {@code locale} is {@code null} then no
	 *                   localization is applied.
	 * @return a human-readable display value (includes SI units - YB, ZB, EB, PB,
	 *         TB, GB, MB, kB or B; BINARY units - YiB, ZiB, EiB, PiB, TiB, GiB,
	 *         MiB, KiB or B)
	 */
	public static String humanReadableByteCount(final long size, final boolean useSiUnits, final Locale locale) {
		return humanReadableByteCount(BigInteger.valueOf(size), useSiUnits, locale);
	}

	/**
	 * Returns a human-readable version of the file size, where the input represents
	 * a specific number of bytes.
	 * 
	 * <p>
	 * If the size is over 1GB, the size is returned as the number of whole GB plus
	 * decimal places, i.e. 2047 bytes with precision of 1 will round to 1.9 KB
	 * </p>
	 * 
	 * <p>
	 * Similarly for all precision boundaries and sizes
	 * </p>
	 * 
	 * @param size       the number of bytes
	 * @param useSiUnits use Metric SI(International System of Units) or Binary
	 *                   IEC(International Electrotechnical Commission); default
	 *                   BINARY units: false
	 * @param places     the number of decimal places to display; not applicable for
	 *                   bytes
	 * @param locale     the {@linkplain java.util.Locale locale} to apply during
	 *                   formatting. If {@code locale} is {@code null} then no
	 *                   localization is applied.
	 * @return a human-readable display value (includes SI units - YB, ZB, EB, PB,
	 *         TB, GB, MB, kB or B; BINARY units - YiB, ZiB, EiB, PiB, TiB, GiB,
	 *         MiB, KiB or B)
	 */
	public static String humanReadableByteCount(final long size, final boolean useSiUnits, final int places,
			final Locale locale) {
		return humanReadableByteCount(BigInteger.valueOf(size), useSiUnits, places, locale);
	}

	/**
	 * Returns a human-readable version of the file size, where the input represents
	 * a specific number of bytes.
	 * 
	 * <p>
	 * If the size is over 1GB, the size is returned as the number of whole GB plus
	 * decimal places, i.e. 2047 bytes with precision of 1 will round to 1.9 KB
	 * </p>
	 * 
	 * <p>
	 * Similarly for all precision boundaries and sizes
	 * </p>
	 * 
	 * @param size the number of bytes
	 * @return a human-readable display value (includes SI units - YB, ZB, EB, PB,
	 *         TB, GB, MB, kB or B; BINARY units - YiB, ZiB, EiB, PiB, TiB, GiB,
	 *         MiB, KiB or B)
	 */
	public static String humanReadableByteCount(final Number size) {
		return humanReadableByteCount(size.longValue());
	}

	/**
	 * Returns a human-readable version of the file size, where the input represents
	 * a specific number of bytes.
	 * 
	 * <p>
	 * If the size is over 1GB, the size is returned as the number of whole GB plus
	 * decimal places, i.e. 2047 bytes with precision of 1 will round to 1.9 KB
	 * </p>
	 * 
	 * <p>
	 * Similarly for all precision boundaries and sizes
	 * </p>
	 * 
	 * @param size   the number of bytes
	 * @param places the number of decimal places to display; not applicable for
	 *               bytes
	 * @return a human-readable display value (includes SI units - YB, ZB, EB, PB,
	 *         TB, GB, MB, kB or B; BINARY units - YiB, ZiB, EiB, PiB, TiB, GiB,
	 *         MiB, KiB or B)
	 */
	public static String humanReadableByteCount(final Number size, final int places) {
		return humanReadableByteCount(size.longValue(), places);
	}

	/**
	 * Returns a human-readable version of the file size, where the input represents
	 * a specific number of bytes.
	 * 
	 * <p>
	 * If the size is over 1GB, the size is returned as the number of whole GB plus
	 * decimal places, i.e. 2047 bytes with precision of 1 will round to 1.9 KB
	 * </p>
	 * 
	 * <p>
	 * Similarly for all precision boundaries and sizes
	 * </p>
	 * 
	 * @param size   the number of bytes
	 * @param locale the {@linkplain java.util.Locale locale} to apply during
	 *               formatting. If {@code locale} is {@code null} then no
	 *               localization is applied.
	 * @return a human-readable display value (includes SI units - YB, ZB, EB, PB,
	 *         TB, GB, MB, kB or B; BINARY units - YiB, ZiB, EiB, PiB, TiB, GiB,
	 *         MiB, KiB or B)
	 */
	public static String humanReadableByteCount(final Number size, final Locale locale) {
		return humanReadableByteCount(size.longValue(), locale);
	}

	/**
	 * Returns a human-readable version of the file size, where the input represents
	 * a specific number of bytes.
	 * 
	 * <p>
	 * If the size is over 1GB, the size is returned as the number of whole GB plus
	 * decimal places, i.e. 2047 bytes with precision of 1 will round to 1.9 KB
	 * </p>
	 * 
	 * <p>
	 * Similarly for all precision boundaries and sizes
	 * </p>
	 * 
	 * @param size   the number of bytes
	 * @param places the number of decimal places to display; not applicable for
	 *               bytes
	 * @param locale the {@linkplain java.util.Locale locale} to apply during
	 *               formatting. If {@code locale} is {@code null} then no
	 *               localization is applied.
	 * @return a human-readable display value (includes SI units - YB, ZB, EB, PB,
	 *         TB, GB, MB, kB or B; BINARY units - YiB, ZiB, EiB, PiB, TiB, GiB,
	 *         MiB, KiB or B)
	 */
	public static String humanReadableByteCount(final Number size, final int places, final Locale locale) {
		return humanReadableByteCount(size.longValue(), places, locale);
	}

	/**
	 * Returns a human-readable version of the file size, where the input represents
	 * a specific number of bytes.
	 * 
	 * <p>
	 * If the size is over 1GB, the size is returned as the number of whole GB plus
	 * decimal places, i.e. 2047 bytes with precision of 1 will round to 1.9 KB
	 * </p>
	 * 
	 * <p>
	 * Similarly for all precision boundaries and sizes
	 * </p>
	 * 
	 * @param size       the number of bytes
	 * @param useSiUnits use Metric SI(International System of Units) or Binary
	 *                   IEC(International Electrotechnical Commission); default
	 *                   BINARY units: false
	 * @return a human-readable display value (includes SI units - YB, ZB, EB, PB,
	 *         TB, GB, MB, kB or B; BINARY units - YiB, ZiB, EiB, PiB, TiB, GiB,
	 *         MiB, KiB or B)
	 */
	public static String humanReadableByteCount(final Number size, final boolean useSiUnits) {
		return humanReadableByteCount(size.longValue(), useSiUnits);
	}

	/**
	 * Returns a human-readable version of the file size, where the input represents
	 * a specific number of bytes.
	 * 
	 * <p>
	 * If the size is over 1GB, the size is returned as the number of whole GB plus
	 * decimal places, i.e. 2047 bytes with precision of 1 will round to 1.9 KB
	 * </p>
	 * 
	 * <p>
	 * Similarly for all precision boundaries and sizes
	 * </p>
	 * 
	 * @param size       the number of bytes
	 * @param useSiUnits use Metric SI(International System of Units) or Binary
	 *                   IEC(International Electrotechnical Commission); default
	 *                   BINARY units: false
	 * @param places     the number of decimal places to display; not applicable for
	 *                   bytes
	 * @return a human-readable display value (includes SI units - YB, ZB, EB, PB,
	 *         TB, GB, MB, kB or B; BINARY units - YiB, ZiB, EiB, PiB, TiB, GiB,
	 *         MiB, KiB or B)
	 */
	public static String humanReadableByteCount(final Number size, final boolean useSiUnits, final int places) {
		return humanReadableByteCount(size.longValue(), useSiUnits, places);
	}

	/**
	 * Returns a human-readable version of the file size, where the input represents
	 * a specific number of bytes.
	 * 
	 * <p>
	 * If the size is over 1GB, the size is returned as the number of whole GB plus
	 * decimal places, i.e. 2047 bytes with precision of 1 will round to 1.9 KB
	 * </p>
	 * 
	 * <p>
	 * Similarly for all precision boundaries and sizes
	 * </p>
	 * 
	 * @param size       the number of bytes
	 * @param useSiUnits use Metric SI(International System of Units) or Binary
	 *                   IEC(International Electrotechnical Commission); default
	 *                   BINARY units: false
	 * @param locale     the {@linkplain java.util.Locale locale} to apply during
	 *                   formatting. If {@code locale} is {@code null} then no
	 *                   localization is applied.
	 * @return a human-readable display value (includes SI units - YB, ZB, EB, PB,
	 *         TB, GB, MB, kB or B; BINARY units - YiB, ZiB, EiB, PiB, TiB, GiB,
	 *         MiB, KiB or B)
	 */
	public static String humanReadableByteCount(final Number size, final boolean useSiUnits, final Locale locale) {
		return humanReadableByteCount(size.longValue(), useSiUnits, locale);
	}

	/**
	 * Returns a human-readable version of the file size, where the input represents
	 * a specific number of bytes.
	 * 
	 * <p>
	 * If the size is over 1GB, the size is returned as the number of whole GB plus
	 * decimal places, i.e. 2047 bytes with precision of 1 will round to 1.9 KB
	 * </p>
	 * 
	 * <p>
	 * Similarly for all precision boundaries and sizes
	 * </p>
	 * 
	 * @param size       the number of bytes
	 * @param useSiUnits use Metric SI(International System of Units) or Binary
	 *                   IEC(International Electrotechnical Commission); default
	 *                   BINARY units: false
	 * @param places     the number of decimal places to display; not applicable for
	 *                   bytes
	 * @param locale     the {@linkplain java.util.Locale locale} to apply during
	 *                   formatting. If {@code locale} is {@code null} then no
	 *                   localization is applied.
	 * @return a human-readable display value (includes SI units - YB, ZB, EB, PB,
	 *         TB, GB, MB, kB or B; BINARY units - YiB, ZiB, EiB, PiB, TiB, GiB,
	 *         MiB, KiB or B)
	 */
	public static String humanReadableByteCount(final Number size, final boolean useSiUnits, final int places,
			final Locale locale) {
		return humanReadableByteCount(size.longValue(), useSiUnits, places, locale);
	}

	/** Metric, SI(International System of Units) **/
	public static enum SI_UNITS {
		B, kB, MB, GB, TB, PB, EB, ZB, YB
	};

	/** Binary, IEC(International Electrotechnical Commission) **/
	public static enum BINARY_UNITS {
		B, KiB, MiB, GiB, TiB, PiB, EiB, ZiB, YiB
	};

	/**
	 * Default places number, %.2f(0.00)
	 */
	public static final int DEFAULT_PLACES = 2;

	/**
	 * The number of bytes in a byte.
	 */
	public static final long ONE_B = 1;
	/**
	 * The number of bytes in a kilobyte.
	 */
	public static final long ONE_KB = 1000;
	/**
	 * The number of bytes in a kibibyte.
	 */
	public static final long ONE_KiB = 1024;

	/**
	 * The number of bytes in a kilobyte.
	 */
	public static final BigInteger ONE_KB_BI = BigInteger.valueOf(ONE_KB);
	/**
	 * The number of bytes in a kibibyte.
	 */
	public static final BigInteger ONE_KiB_BI = BigInteger.valueOf(ONE_KiB);

	/**
	 * The number of bytes in a megabyte.
	 */
	public static final long ONE_MB = ONE_KB * ONE_KB;
	/**
	 * The number of bytes in a mebibyte.
	 */
	public static final long ONE_MiB = ONE_KiB * ONE_KiB;

	/**
	 * The number of bytes in a megabyte.
	 */
	public static final BigInteger ONE_MB_BI = ONE_KB_BI.multiply(ONE_KB_BI);

	/**
	 * The number of bytes in a mebibyte.
	 */
	public static final BigInteger ONE_MiB_BI = ONE_KiB_BI.multiply(ONE_KiB_BI);

	/**
	 * The number of bytes in a gigabyte.
	 */
	public static final long ONE_GB = ONE_KB * ONE_MB;

	/**
	 * The number of bytes in a gibibyte.
	 */
	public static final long ONE_GiB = ONE_KiB * ONE_MiB;

	/**
	 * The number of bytes in a gigabyte.
	 */
	public static final BigInteger ONE_GB_BI = ONE_KB_BI.multiply(ONE_MB_BI);

	/**
	 * The number of bytes in a gibibyte.
	 */
	public static final BigInteger ONE_GiB_BI = ONE_KiB_BI.multiply(ONE_MiB_BI);

	/**
	 * The number of bytes in a terabyte.
	 */
	public static final long ONE_TB = ONE_KB * ONE_GB;
	/**
	 * The number of bytes in a tebibyte.
	 */
	public static final long ONE_TiB = ONE_KiB * ONE_GiB;

	/**
	 * The number of bytes in a terabyte.
	 */
	public static final BigInteger ONE_TB_BI = ONE_KB_BI.multiply(ONE_GB_BI);
	/**
	 * The number of bytes in a tebibyte.
	 */
	public static final BigInteger ONE_TiB_BI = ONE_KiB_BI.multiply(ONE_GiB_BI);

	/**
	 * The number of bytes in a petabyte.
	 */
	public static final long ONE_PB = ONE_KB * ONE_TB;
	/**
	 * The number of bytes in a pebibyte.
	 */
	public static final long ONE_PiB = ONE_KiB * ONE_TiB;

	/**
	 * The number of bytes in a petabyte.
	 */
	public static final BigInteger ONE_PB_BI = ONE_KB_BI.multiply(ONE_TB_BI);

	/**
	 * The number of bytes in a pebibyte.
	 */
	public static final BigInteger ONE_PiB_BI = ONE_KiB_BI.multiply(ONE_TiB_BI);

	/**
	 * The number of bytes in an exabyte.
	 */
	public static final long ONE_EB = ONE_KB * ONE_PB;
	/**
	 * The number of bytes in an exbibyte.
	 */
	public static final long ONE_EiB = ONE_KiB * ONE_PiB;

	/**
	 * The number of bytes in an exabyte.
	 */
	public static final BigInteger ONE_EB_BI = ONE_KB_BI.multiply(ONE_PB_BI);
	/**
	 * The number of bytes in an exbibyte.
	 */
	public static final BigInteger ONE_EiB_BI = ONE_KiB_BI.multiply(ONE_PiB_BI);

	/**
	 * The number of bytes in a zettabyte.
	 */
	public static final BigInteger ONE_ZB_BI = BigInteger.valueOf(ONE_KB).multiply(BigInteger.valueOf(ONE_EB));
	/**
	 * The number of bytes in a zebibyte.
	 */
	public static final BigInteger ONE_ZiB_BI = BigInteger.valueOf(ONE_KiB).multiply(BigInteger.valueOf(ONE_EiB));

	/**
	 * The number of bytes in a yottabyte.
	 */
	public static final BigInteger ONE_YB_BI = ONE_KB_BI.multiply(ONE_ZB_BI);
	/**
	 * The number of bytes in a yobibyte.
	 */
	public static final BigInteger ONE_YiB_BI = ONE_KiB_BI.multiply(ONE_ZiB_BI);
}

package com.github.doraeven.commons.regex;

/**
 * China Mobile Phone Number Regex (PCRE standard)
 * 
 * <p>
 * After number porting, it's not very accurate.
 * </p>
 * 
 * <p>
 * What flavour of regular expression is being used in Java?
 * </p>
 * <p>
 * Well, Java uses PCRE (Perl Compatible Regular Expressions). So, all the
 * regular expressions we have developed in the previous articles describing
 * regular expressions in Python, Perl and PHP will work in Java without any
 * modifications, because Python, Perl and PHP also use the PCRE flavour of
 * regular expressions.
 * </p>
 * 
 * @see <a href=
 *      "https://github.com/VincentSit/ChinaMobilePhoneNumberRegex">https://github.com/VincentSit/ChinaMobilePhoneNumberRegex</a>
 * @see <a href=
 *      "https://www.chinacheckup.com/blogs/articles/china-phone-codes">https://www.chinacheckup.com/blogs/articles/china-phone-codes</a>
 * @see <a href=
 *      "https://www.oracle.com/technical-resources/articles/java/regex.html">https://www.oracle.com/technical-resources/articles/java/regex.html</a>
 * @see <a href=
 *      "https://www.regular-expressions.info/posixbrackets.html">https://www.regular-expressions.info/posixbrackets.html</a>
 *
 * @since 2020-05-05, 1441
 *
 * @author motu
 *
 */
public class ChinaMobilePhoneNumberRegex {

	// ## All numbers

	// Match all numbers (Phone number + IoT number + Data only number)
	public static final String CHINA_ALL_NUMBER_REGEX = "^(?:\\+?86)?1(?:3\\d{3}|5[^4\\D]\\d{2}|8\\d{3}|7(?:[0-35-9]\\d{2}|4(?:0\\d|1[0-2]|9\\d))|9[0-35-9]\\d{2}|6[2567]\\d{2}|4(?:(?:10|4[01])\\d{3}|[68]\\d{4}|[579]\\d{2}))\\d{6}$";

	// Match all numbers with SMS (Phone number + Data only number)
	public static final String CHINA_ALL_NUMBER_WITH_SMS_REGEX = "^(?:\\+?86)?1(?:3\\d{3}|5[^4\\D]\\d{2}|8\\d{3}|7(?:[0-35-9]\\d{2}|4(?:0\\d|1[0-2]|9\\d))|9[0-35-9]\\d{2}|6[2567]\\d{2}|4[579]\\d{2})\\d{6}$";

	// ## Mobile phone number

	// Match all
	public static final String CHINA_ALL_PHONE_NUMBER_REGEX = "^(?:\\+?86)?1(?:3\\d{3}|5[^4\\D]\\d{2}|8\\d{3}|7(?:[235-8]\\d{2}|4(?:0\\d|1[0-2]|9\\d))|9[0-35-9]\\d{2}|66\\d{2})\\d{6}$";

	// Match China Mobile
	public static final String CHINA_MOBILE_PHONE_NUMBER_REGEX = "^(?:\\+?86)?1(?:3(?:4[^9\\D]|[5-9]\\d)|5[^3-6\\D]\\d|7[28]\\d|8[23478]\\d|9[578]\\d)\\d{7}$";

	// Match China Unicom
	public static final String CHINA_UNICOM_PHONE_NUMBER_REGEX = "^(?:\\+?86)?1(?:3[0-2]|[578][56]|66|96)\\d{8}$";

	// Match China Telecom
	public static final String CHINA_TELECOM_PHONE_NUMBER_REGEX = "^(?:\\+?86)?1(?:3(?:3\\d|49)\\d|53\\d{2}|8[019]\\d{2}|7(?:[37]\\d{2}|40[0-5])|9[0139]\\d{2})\\d{6}$";

	// Match China Broadcast Network (CBN)
	public static final String CHINA_CBN_PHONE_NUMBER_REGEX = "^(?:\\+?86)?192\\d{8}$";

	// Match Inmarsat (Satellite Communications) (SC)
	public static final String CHINA_SC_PHONE_NUMBER_REGEX = "^(?:\\+?86)?1749\\d{7}$";

	// Match Emergency Communication Support Center of MIIT (Emergency
	// communications) (ECC)
	public static final String CHINA_ECC_PHONE_NUMBER_REGEX = "^(?:\\+?86)?174(?:0[6-9]|1[0-2])\\d{6}$";

	// ## MVNO number (Mobile Virtual Network Operator)

	// Match all
	public static final String CHINA_ALL_MVNO_NUMBER_REGEX = "^(?:\\+?86)?1(?:7[01]|6[257])\\d{8}$";

	// Match China Mobile
	public static final String CHINA_MOBILE_MVNO_NUMBER_REGEX = "^(?:\\+?86)?1(?:65\\d|70[356])\\d{7}$";

	// Match China Unicom
	public static final String CHINA_UNICOM_MVNO_NUMBER_REGEX = "^(?:\\+?86)?1(?:70[4789]|71\\d|67\\d)\\d{7}$";

	// Match China Telecom
	public static final String CHINA_TELECOM_MVNO_NUMBER_REGEX = "^(?:\\+?86)?1(?:70[012]|62\\d)\\d{7}$";

	// ## IoT number (Internet of Things)

	// Match all
	public static final String CHINA_ALL_IOT_NUMBER_REGEX = "^(?:\\+?86)?14(?:[14]0|41|[68]\\d)\\d{9}$";

	// Match China Mobile
	public static final String CHINA_MOBILE_IOT_NUMBER_REGEX = "^(?:\\+?86)?14(?:4[01]|8\\d)\\d{9}$";

	// Match China Unicom
	public static final String CHINA_UNICOM_IOT_NUMBER_REGEX = "^(?:\\+?86)?146\\d{10}$";

	// Match China Telecom
	public static final String CHINA_TELECOM_IOT_NUMBER_REGEX = "^(?:\\+?86)?1410\\d{9}$";

	// ## Data only number

	// Match all
	public static final String CHINA_ALL_DATA_NUMBER_REGEX = "^(?:\\+?86)?14[579]\\d{8}$";

	// Match China Mobile
	public static final String CHINA_MOBILE_DATA_NUMBER_REGEX = "^(?:\\+?86)?147\\d{8}$";

	// Match China Unicom
	public static final String CHINA_UNICOM_DATA_NUMBER_REGEX = "^(?:\\+?86)?145\\d{8}$";

	// Match China Telecom
	public static final String CHINA_TELECOM_DATA_NUMBER_REGEX = "^(?:\\+?86)?149\\d{8}$";

}

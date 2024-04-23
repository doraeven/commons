package com.github.doraeven.commons.validator;

import java.io.Serializable;

import org.apache.commons.validator.GenericValidator;

import com.github.doraeven.commons.regex.ChinaMobilePhoneNumberRegex;

/**
 * China Mobile Phone Number Validator
 * 
 * @author motu
 * 
 */
public class ChinaMobilePhoneNumberValidator implements Serializable {

	// ## All numbers

	public boolean isChinaAllNumber(String phone) {
		return GenericValidator.matchRegexp(phone, ChinaMobilePhoneNumberRegex.CHINA_ALL_NUMBER_REGEX);
	}

	public boolean isChinaAllNumberWithSMS(String phone) {
		return GenericValidator.matchRegexp(phone, ChinaMobilePhoneNumberRegex.CHINA_ALL_NUMBER_WITH_SMS_REGEX);
	}

	// ## Mobile phone number

	public boolean isChinaAllPhoneNumber(String phone) {
		return GenericValidator.matchRegexp(phone, ChinaMobilePhoneNumberRegex.CHINA_ALL_PHONE_NUMBER_REGEX);
	}

	public boolean isChinaMobilePhoneNumber(String phone) {
		return GenericValidator.matchRegexp(phone, ChinaMobilePhoneNumberRegex.CHINA_MOBILE_PHONE_NUMBER_REGEX);
	}

	public boolean isChinaUnicomPhoneNumber(String phone) {
		return GenericValidator.matchRegexp(phone, ChinaMobilePhoneNumberRegex.CHINA_UNICOM_PHONE_NUMBER_REGEX);
	}

	public boolean isChinaTelecomPhoneNumber(String phone) {
		return GenericValidator.matchRegexp(phone, ChinaMobilePhoneNumberRegex.CHINA_TELECOM_PHONE_NUMBER_REGEX);
	}

	public boolean isChinaCBNPhoneNumber(String phone) {
		return GenericValidator.matchRegexp(phone, ChinaMobilePhoneNumberRegex.CHINA_CBN_PHONE_NUMBER_REGEX);
	}

	public boolean isChinaSCPhoneNumber(String phone) {
		return GenericValidator.matchRegexp(phone, ChinaMobilePhoneNumberRegex.CHINA_SC_PHONE_NUMBER_REGEX);
	}

	public boolean isChinaECCPhoneNumber(String phone) {
		return GenericValidator.matchRegexp(phone, ChinaMobilePhoneNumberRegex.CHINA_ECC_PHONE_NUMBER_REGEX);
	}

	// ## MVNO number (Mobile Virtual Network Operator)

	public boolean isChinaAllMVNONumber(String phone) {
		return GenericValidator.matchRegexp(phone, ChinaMobilePhoneNumberRegex.CHINA_ALL_MVNO_NUMBER_REGEX);
	}

	public boolean isChinaMobileMVNONumber(String phone) {
		return GenericValidator.matchRegexp(phone, ChinaMobilePhoneNumberRegex.CHINA_MOBILE_MVNO_NUMBER_REGEX);
	}

	public boolean isChinaUnicomMVNONumber(String phone) {
		return GenericValidator.matchRegexp(phone, ChinaMobilePhoneNumberRegex.CHINA_UNICOM_MVNO_NUMBER_REGEX);
	}

	public boolean isChinaTelecomMVNONumber(String phone) {
		return GenericValidator.matchRegexp(phone, ChinaMobilePhoneNumberRegex.CHINA_TELECOM_MVNO_NUMBER_REGEX);
	}

	// ## IoT number (Internet of Things)

	public boolean isChinaAllIoTNumber(String phone) {
		return GenericValidator.matchRegexp(phone, ChinaMobilePhoneNumberRegex.CHINA_ALL_IOT_NUMBER_REGEX);
	}

	public boolean isChinaMobileIoTNumber(String phone) {
		return GenericValidator.matchRegexp(phone, ChinaMobilePhoneNumberRegex.CHINA_MOBILE_IOT_NUMBER_REGEX);
	}

	public boolean isChinaUnicomIoTNumber(String phone) {
		return GenericValidator.matchRegexp(phone, ChinaMobilePhoneNumberRegex.CHINA_UNICOM_IOT_NUMBER_REGEX);
	}

	public boolean isChinaTelecomIoTNumber(String phone) {
		return GenericValidator.matchRegexp(phone, ChinaMobilePhoneNumberRegex.CHINA_TELECOM_IOT_NUMBER_REGEX);
	}

	// ## Data only number

	public boolean isChinaAllDataNumber(String phone) {
		return GenericValidator.matchRegexp(phone, ChinaMobilePhoneNumberRegex.CHINA_ALL_DATA_NUMBER_REGEX);
	}

	public boolean isChinaMobileDataNumber(String phone) {
		return GenericValidator.matchRegexp(phone, ChinaMobilePhoneNumberRegex.CHINA_MOBILE_DATA_NUMBER_REGEX);
	}

	public boolean isChinaUnicomDataNumber(String phone) {
		return GenericValidator.matchRegexp(phone, ChinaMobilePhoneNumberRegex.CHINA_UNICOM_DATA_NUMBER_REGEX);
	}

	public boolean isChinaTelecomDataNumber(String phone) {
		return GenericValidator.matchRegexp(phone, ChinaMobilePhoneNumberRegex.CHINA_TELECOM_DATA_NUMBER_REGEX);
	}

	private static final long serialVersionUID = 1934302847172940908L;

}

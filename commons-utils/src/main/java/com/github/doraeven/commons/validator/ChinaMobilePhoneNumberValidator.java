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

	/**
	 * Checks if a field is a valid china mobile - all numbers (Phone number + IoT
	 * number + Data only number).
	 * 
	 * @param phone the value validation is being performed on
	 * @return true if the value is valid phone number
	 */
	public boolean isAllNumber(String phone) {
		return GenericValidator.matchRegexp(phone, ChinaMobilePhoneNumberRegex.ALL_NUMBER_REGEX);
	}

	/**
	 * Checks if a field is a valid china mobile - all numbers with SMS (Phone
	 * number + Data only number).
	 * 
	 * @param phone the value validation is being performed on
	 * @return true if the value is valid phone number
	 */
	public boolean isAllNumberWithSMS(String phone) {
		return GenericValidator.matchRegexp(phone, ChinaMobilePhoneNumberRegex.ALL_NUMBER_WITH_SMS_REGEX);
	}

	// ## Mobile phone number

	/**
	 * Checks if a field is a valid china mobile - all Mobile phone number.
	 * 
	 * @param phone the value validation is being performed on
	 * @return true if the value is valid phone number
	 */
	public boolean isAllPhoneNumber(String phone) {
		return GenericValidator.matchRegexp(phone, ChinaMobilePhoneNumberRegex.ALL_PHONE_NUMBER_REGEX);
	}

	/**
	 * Checks if a field is a valid china mobile - China Mobile Mobile phone number.
	 * 
	 * @param phone the value validation is being performed on
	 * @return true if the value is valid phone number
	 */
	public boolean isChinaMobilePhoneNumber(String phone) {
		return GenericValidator.matchRegexp(phone, ChinaMobilePhoneNumberRegex.CHINA_MOBILE_PHONE_NUMBER_REGEX);
	}

	/**
	 * Checks if a field is a valid china mobile - China Unicom Mobile phone number.
	 * 
	 * @param phone the value validation is being performed on
	 * @return true if the value is valid phone number
	 */
	public boolean isChinaUnicomPhoneNumber(String phone) {
		return GenericValidator.matchRegexp(phone, ChinaMobilePhoneNumberRegex.CHINA_UNICOM_PHONE_NUMBER_REGEX);
	}

	/**
	 * Checks if a field is a valid china mobile - China Telecom Mobile phone
	 * number.
	 * 
	 * @param phone the value validation is being performed on
	 * @return true if the value is valid phone number
	 */
	public boolean isChinaTelecomPhoneNumber(String phone) {
		return GenericValidator.matchRegexp(phone, ChinaMobilePhoneNumberRegex.CHINA_TELECOM_PHONE_NUMBER_REGEX);
	}

	/**
	 * Checks if a field is a valid china mobile - China Broadcast Network (CBN)
	 * Mobile phone number.
	 * 
	 * @param phone the value validation is being performed on
	 * @return true if the value is valid phone number
	 */
	public boolean isChinaCBNPhoneNumber(String phone) {
		return GenericValidator.matchRegexp(phone, ChinaMobilePhoneNumberRegex.CHINA_CBN_PHONE_NUMBER_REGEX);
	}

	/**
	 * Checks if a field is a valid china mobile - Inmarsat (Satellite
	 * Communications) (SC) Mobile phone number.
	 * 
	 * @param phone the value validation is being performed on
	 * @return true if the value is valid phone number
	 */
	public boolean isChinaSCPhoneNumber(String phone) {
		return GenericValidator.matchRegexp(phone, ChinaMobilePhoneNumberRegex.CHINA_SC_PHONE_NUMBER_REGEX);
	}

	/**
	 * Checks if a field is a valid china mobile - Emergency Communication Support
	 * Center of MIIT (Emergency communications) (ECC) Mobile phone number.
	 * 
	 * @param phone the value validation is being performed on
	 * @return true if the value is valid phone number
	 */
	public boolean isChinaECCPhoneNumber(String phone) {
		return GenericValidator.matchRegexp(phone, ChinaMobilePhoneNumberRegex.CHINA_ECC_PHONE_NUMBER_REGEX);
	}

	// ## MVNO number (Mobile Virtual Network Operator)

	/**
	 * Checks if a field is a valid china mobile - all MVNO number.
	 * 
	 * @param phone the value validation is being performed on
	 * @return true if the value is valid phone number
	 */
	public boolean isAllMVNONumber(String phone) {
		return GenericValidator.matchRegexp(phone, ChinaMobilePhoneNumberRegex.ALL_MVNO_NUMBER_REGEX);
	}

	/**
	 * Checks if a field is a valid china mobile - China Mobile MVNO number.
	 * 
	 * @param phone the value validation is being performed on
	 * @return true if the value is valid phone number
	 */
	public boolean isChinaMobileMVNONumber(String phone) {
		return GenericValidator.matchRegexp(phone, ChinaMobilePhoneNumberRegex.CHINA_MOBILE_MVNO_NUMBER_REGEX);
	}

	/**
	 * Checks if a field is a valid china mobile - China Unicom MVNO number.
	 * 
	 * @param phone the value validation is being performed on
	 * @return true if the value is valid phone number
	 */
	public boolean isChinaUnicomMVNONumber(String phone) {
		return GenericValidator.matchRegexp(phone, ChinaMobilePhoneNumberRegex.CHINA_UNICOM_MVNO_NUMBER_REGEX);
	}

	/**
	 * Checks if a field is a valid china mobile - China Telecom MVNO number.
	 * 
	 * @param phone the value validation is being performed on
	 * @return true if the value is valid phone number
	 */
	public boolean isChinaTelecomMVNONumber(String phone) {
		return GenericValidator.matchRegexp(phone, ChinaMobilePhoneNumberRegex.CHINA_TELECOM_MVNO_NUMBER_REGEX);
	}

	// ## IoT number (Internet of Things)

	/**
	 * Checks if a field is a valid china mobile - all IoT number.
	 * 
	 * @param phone the value validation is being performed on
	 * @return true if the value is valid phone number
	 */
	public boolean isAllIoTNumber(String phone) {
		return GenericValidator.matchRegexp(phone, ChinaMobilePhoneNumberRegex.ALL_IOT_NUMBER_REGEX);
	}

	/**
	 * Checks if a field is a valid china mobile - China Mobile IoT number.
	 * 
	 * @param phone the value validation is being performed on
	 * @return true if the value is valid phone number
	 */
	public boolean isChinaMobileIoTNumber(String phone) {
		return GenericValidator.matchRegexp(phone, ChinaMobilePhoneNumberRegex.CHINA_MOBILE_IOT_NUMBER_REGEX);
	}

	/**
	 * Checks if a field is a valid china mobile - China Unicom IoT number.
	 * 
	 * @param phone the value validation is being performed on
	 * @return true if the value is valid phone number
	 */
	public boolean isChinaUnicomIoTNumber(String phone) {
		return GenericValidator.matchRegexp(phone, ChinaMobilePhoneNumberRegex.CHINA_UNICOM_IOT_NUMBER_REGEX);
	}

	/**
	 * Checks if a field is a valid china mobile - China Telecom IoT number.
	 * 
	 * @param phone the value validation is being performed on
	 * @return true if the value is valid phone number
	 */
	public boolean isChinaTelecomIoTNumber(String phone) {
		return GenericValidator.matchRegexp(phone, ChinaMobilePhoneNumberRegex.CHINA_TELECOM_IOT_NUMBER_REGEX);
	}

	// ## Data only number

	/**
	 * Checks if a field is a valid china mobile - all Data only number.
	 * 
	 * @param phone the value validation is being performed on
	 * @return true if the value is valid phone number
	 */
	public boolean isAllDataNumber(String phone) {
		return GenericValidator.matchRegexp(phone, ChinaMobilePhoneNumberRegex.ALL_DATA_NUMBER_REGEX);
	}

	/**
	 * Checks if a field is a valid china mobile - China Mobile Data only number.
	 * 
	 * @param phone the value validation is being performed on
	 * @return true if the value is valid phone number
	 */
	public boolean isChinaMobileDataNumber(String phone) {
		return GenericValidator.matchRegexp(phone, ChinaMobilePhoneNumberRegex.CHINA_MOBILE_DATA_NUMBER_REGEX);
	}

	/**
	 * Checks if a field is a valid china mobile - China Unicom Data only number.
	 * 
	 * @param phone the value validation is being performed on
	 * @return true if the value is valid phone number
	 */
	public boolean isChinaUnicomDataNumber(String phone) {
		return GenericValidator.matchRegexp(phone, ChinaMobilePhoneNumberRegex.CHINA_UNICOM_DATA_NUMBER_REGEX);
	}

	/**
	 * Checks if a field is a valid china mobile - China Telecom Data only number.
	 * 
	 * @param phone the value validation is being performed on
	 * @return true if the value is valid phone number
	 */
	public boolean isChinaTelecomDataNumber(String phone) {
		return GenericValidator.matchRegexp(phone, ChinaMobilePhoneNumberRegex.CHINA_TELECOM_DATA_NUMBER_REGEX);
	}

	/**
	 * Returns the singleton instance of this validator.
	 * 
	 * @return the singleton instance of this validator
	 */
	public static ChinaMobilePhoneNumberValidator getInstance() {
		return VALIDATOR;
	}

	/**
	 * Singleton instance of this class.
	 */
	private static final ChinaMobilePhoneNumberValidator VALIDATOR = new ChinaMobilePhoneNumberValidator();

	private static final long serialVersionUID = 1934302847172940908L;

}

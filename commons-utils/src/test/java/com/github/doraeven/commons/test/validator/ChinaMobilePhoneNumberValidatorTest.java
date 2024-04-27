package com.github.doraeven.commons.test.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.github.doraeven.commons.validator.ChinaMobilePhoneNumberValidator;

public class ChinaMobilePhoneNumberValidatorTest {

	// ## All numbers

	@Test
	public void testIsAllNumber() {
		ChinaMobilePhoneNumberValidator validator = ChinaMobilePhoneNumberValidator.getInstance();

		String phone1 = "13400000000";
		String phone2 = "11100000000";
		boolean result1 = validator.isAllNumber(phone1);
		boolean result2 = validator.isAllNumber(phone2);

		Assertions.assertTrue(result1);
		Assertions.assertFalse(result2);
	}

	@Test
	public void testIsAllNumberWithSMS() {
		ChinaMobilePhoneNumberValidator validator = ChinaMobilePhoneNumberValidator.getInstance();

		String phone1 = "13400000000";
		String phone2 = "14600000000";
		boolean result1 = validator.isAllNumberWithSMS(phone1);
		boolean result2 = validator.isAllNumberWithSMS(phone2);

		Assertions.assertTrue(result1);
		Assertions.assertFalse(result2);
	}

	// ## Mobile phone number

	@Test
	public void testIsAllPhoneNumber() {
		ChinaMobilePhoneNumberValidator validator = ChinaMobilePhoneNumberValidator.getInstance();

		String phone1 = "13400000000";
		String phone2 = "14600000000";
		boolean result1 = validator.isAllPhoneNumber(phone1);
		boolean result2 = validator.isAllPhoneNumber(phone2);

		Assertions.assertTrue(result1);
		Assertions.assertFalse(result2);
	}

	@Test
	public void testIsChinaMobilePhoneNumber() {
		ChinaMobilePhoneNumberValidator validator = ChinaMobilePhoneNumberValidator.getInstance();

		String phone1 = "13400000000";
		String phone2 = "14600000000";
		boolean result1 = validator.isChinaMobilePhoneNumber(phone1);
		boolean result2 = validator.isChinaMobilePhoneNumber(phone2);

		Assertions.assertTrue(result1);
		Assertions.assertFalse(result2);
	}

	@Test
	public void testIsChinaUnicomPhoneNumber() {
		ChinaMobilePhoneNumberValidator validator = ChinaMobilePhoneNumberValidator.getInstance();

		String phone1 = "13000000000";
		String phone2 = "14600000000";
		boolean result1 = validator.isChinaUnicomPhoneNumber(phone1);
		boolean result2 = validator.isChinaUnicomPhoneNumber(phone2);

		Assertions.assertTrue(result1);
		Assertions.assertFalse(result2);
	}

	@Test
	public void testIsChinaTelecomPhoneNumber() {
		ChinaMobilePhoneNumberValidator validator = ChinaMobilePhoneNumberValidator.getInstance();

		String phone1 = "13300000000";
		String phone2 = "14600000000";
		boolean result1 = validator.isChinaTelecomPhoneNumber(phone1);
		boolean result2 = validator.isChinaTelecomPhoneNumber(phone2);

		Assertions.assertTrue(result1);
		Assertions.assertFalse(result2);
	}

	@Test
	public void testIsChinaCBNPhoneNumber() {
		ChinaMobilePhoneNumberValidator validator = ChinaMobilePhoneNumberValidator.getInstance();

		String phone1 = "19200000000";
		String phone2 = "14600000000";
		boolean result1 = validator.isChinaCBNPhoneNumber(phone1);
		boolean result2 = validator.isChinaCBNPhoneNumber(phone2);

		Assertions.assertTrue(result1);
		Assertions.assertFalse(result2);
	}

	@Test
	public void testIsChinaSCPhoneNumber() {
		ChinaMobilePhoneNumberValidator validator = ChinaMobilePhoneNumberValidator.getInstance();

		String phone1 = "17490000000";
		String phone2 = "14600000000";
		boolean result1 = validator.isChinaSCPhoneNumber(phone1);
		boolean result2 = validator.isChinaSCPhoneNumber(phone2);

		Assertions.assertTrue(result1);
		Assertions.assertFalse(result2);
	}

	@Test
	public void testIsChinaECCPhoneNumber() {
		ChinaMobilePhoneNumberValidator validator = ChinaMobilePhoneNumberValidator.getInstance();

		String phone1 = "17406000000";
		String phone2 = "14600000000";
		boolean result1 = validator.isChinaECCPhoneNumber(phone1);
		boolean result2 = validator.isChinaECCPhoneNumber(phone2);

		Assertions.assertTrue(result1);
		Assertions.assertFalse(result2);
	}

	// ## MVNO number (Mobile Virtual Network Operator)

	@Test
	public void testIsAllMVNONumber() {
		ChinaMobilePhoneNumberValidator validator = ChinaMobilePhoneNumberValidator.getInstance();

		String phone1 = "16500000000";
		String phone2 = "14600000000";
		boolean result1 = validator.isAllMVNONumber(phone1);
		boolean result2 = validator.isAllMVNONumber(phone2);

		Assertions.assertTrue(result1);
		Assertions.assertFalse(result2);
	}

	@Test
	public void testIsChinaMobileMVNONumber() {
		ChinaMobilePhoneNumberValidator validator = ChinaMobilePhoneNumberValidator.getInstance();

		String phone1 = "16500000000";
		String phone2 = "14600000000";
		boolean result1 = validator.isChinaMobileMVNONumber(phone1);
		boolean result2 = validator.isChinaMobileMVNONumber(phone2);

		Assertions.assertTrue(result1);
		Assertions.assertFalse(result2);
	}

	@Test
	public void testIsChinaUnicomMVNONumber() {
		ChinaMobilePhoneNumberValidator validator = ChinaMobilePhoneNumberValidator.getInstance();

		String phone1 = "16700000000";
		String phone2 = "14600000000";
		boolean result1 = validator.isChinaUnicomMVNONumber(phone1);
		boolean result2 = validator.isChinaUnicomMVNONumber(phone2);

		Assertions.assertTrue(result1);
		Assertions.assertFalse(result2);
	}

	@Test
	public void testIsChinaTelecomMVNONumber() {
		ChinaMobilePhoneNumberValidator validator = ChinaMobilePhoneNumberValidator.getInstance();

		String phone1 = "16200000000";
		String phone2 = "14600000000";
		boolean result1 = validator.isChinaTelecomMVNONumber(phone1);
		boolean result2 = validator.isChinaTelecomMVNONumber(phone2);

		Assertions.assertTrue(result1);
		Assertions.assertFalse(result2);
	}

	// ## IoT number (Internet of Things)

	@Test
	public void testIsAllIoTNumber() {
		ChinaMobilePhoneNumberValidator validator = ChinaMobilePhoneNumberValidator.getInstance();

		String phone1 = "1441600000003";
		String phone2 = "1490000000003";
		boolean result1 = validator.isAllIoTNumber(phone1);
		boolean result2 = validator.isAllIoTNumber(phone2);

		Assertions.assertTrue(result1);
		Assertions.assertFalse(result2);
	}

	@Test
	public void testIsChinaMobileIoTNumber() {
		ChinaMobilePhoneNumberValidator validator = ChinaMobilePhoneNumberValidator.getInstance();

		String phone1 = "1441600000003";
		String phone2 = "1460000000003";
		boolean result1 = validator.isChinaMobileIoTNumber(phone1);
		boolean result2 = validator.isChinaMobileIoTNumber(phone2);

		Assertions.assertTrue(result1);
		Assertions.assertFalse(result2);
	}

	@Test
	public void testIsChinaUnicomIoTNumber() {
		ChinaMobilePhoneNumberValidator validator = ChinaMobilePhoneNumberValidator.getInstance();

		String phone1 = "1461600000003";
		String phone2 = "1400000000003";
		boolean result1 = validator.isChinaUnicomIoTNumber(phone1);
		boolean result2 = validator.isChinaUnicomIoTNumber(phone2);

		Assertions.assertTrue(result1);
		Assertions.assertFalse(result2);
	}

	@Test
	public void testIsChinaTelecomIoTNumber() {
		ChinaMobilePhoneNumberValidator validator = ChinaMobilePhoneNumberValidator.getInstance();

		String phone1 = "1410600000003";
		String phone2 = "1400000000003";
		boolean result1 = validator.isChinaTelecomIoTNumber(phone1);
		boolean result2 = validator.isChinaTelecomIoTNumber(phone2);

		Assertions.assertTrue(result1);
		Assertions.assertFalse(result2);
	}

	// ## Data only number

	@Test
	public void testIsAllDataNumber() {
		ChinaMobilePhoneNumberValidator validator = ChinaMobilePhoneNumberValidator.getInstance();

		String phone1 = "14700000000";
		String phone2 = "14600000000";
		boolean result1 = validator.isAllDataNumber(phone1);
		boolean result2 = validator.isAllDataNumber(phone2);

		Assertions.assertTrue(result1);
		Assertions.assertFalse(result2);
	}

	@Test
	public void testIsChinaMobileDataNumber() {
		ChinaMobilePhoneNumberValidator validator = ChinaMobilePhoneNumberValidator.getInstance();

		String phone1 = "14700000000";
		String phone2 = "14600000000";
		boolean result1 = validator.isChinaMobileDataNumber(phone1);
		boolean result2 = validator.isChinaMobileDataNumber(phone2);

		Assertions.assertTrue(result1);
		Assertions.assertFalse(result2);
	}

	@Test
	public void testIsChinaUnicomDataNumber() {
		ChinaMobilePhoneNumberValidator validator = ChinaMobilePhoneNumberValidator.getInstance();

		String phone1 = "14500000000";
		String phone2 = "14600000000";
		boolean result1 = validator.isChinaUnicomDataNumber(phone1);
		boolean result2 = validator.isChinaUnicomDataNumber(phone2);

		Assertions.assertTrue(result1);
		Assertions.assertFalse(result2);
	}

	@Test
	public void testIsChinaTelecomDataNumber() {
		ChinaMobilePhoneNumberValidator validator = ChinaMobilePhoneNumberValidator.getInstance();

		String phone1 = "14900000000";
		String phone2 = "14600000000";
		boolean result1 = validator.isChinaTelecomDataNumber(phone1);
		boolean result2 = validator.isChinaTelecomDataNumber(phone2);

		Assertions.assertTrue(result1);
		Assertions.assertFalse(result2);
	}

}

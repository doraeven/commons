package com.github.doraeven.commons.test.validator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
		assertTrue(result1);
		assertFalse(result2);

		System.out.println("isAllNumber1:" + result1);
		System.out.println("isAllNumber2:" + result2);
	}

	@Test
	public void testIsAllNumberWithSMS() {
		ChinaMobilePhoneNumberValidator validator = ChinaMobilePhoneNumberValidator.getInstance();

		String phone1 = "13400000000";
		String phone2 = "14600000000";
		boolean result1 = validator.isAllNumberWithSMS(phone1);
		boolean result2 = validator.isAllNumberWithSMS(phone2);
		assertTrue(result1);
		assertFalse(result2);

		System.out.println("isAllNumberWithSMS1:" + result1);
		System.out.println("isAllNumberWithSMS2:" + result2);
	}

	// ## Mobile phone number

	@Test
	public void testIsAllPhoneNumber() {
		ChinaMobilePhoneNumberValidator validator = ChinaMobilePhoneNumberValidator.getInstance();

		String phone1 = "13400000000";
		String phone2 = "14600000000";
		boolean result1 = validator.isAllPhoneNumber(phone1);
		boolean result2 = validator.isAllPhoneNumber(phone2);
		assertTrue(result1);
		assertFalse(result2);

		System.out.println("isAllPhoneNumber1:" + result1);
		System.out.println("isAllPhoneNumber2:" + result2);
	}

	@Test
	public void testIsChinaMobilePhoneNumber() {
		ChinaMobilePhoneNumberValidator validator = ChinaMobilePhoneNumberValidator.getInstance();

		String phone1 = "13400000000";
		String phone2 = "14600000000";
		boolean result1 = validator.isChinaMobilePhoneNumber(phone1);
		boolean result2 = validator.isChinaMobilePhoneNumber(phone2);
		assertTrue(result1);
		assertFalse(result2);

		System.out.println("isChinaMobilePhoneNumber1:" + result1);
		System.out.println("isChinaMobilePhoneNumber2:" + result2);
	}

	@Test
	public void testIsChinaUnicomPhoneNumber() {
		ChinaMobilePhoneNumberValidator validator = ChinaMobilePhoneNumberValidator.getInstance();

		String phone1 = "13000000000";
		String phone2 = "14600000000";
		boolean result1 = validator.isChinaUnicomPhoneNumber(phone1);
		boolean result2 = validator.isChinaUnicomPhoneNumber(phone2);
		assertTrue(result1);
		assertFalse(result2);

		System.out.println("isChinaUnicomPhoneNumber1:" + result1);
		System.out.println("isChinaUnicomPhoneNumber2:" + result2);
	}

	@Test
	public void testIsChinaTelecomPhoneNumber() {
		ChinaMobilePhoneNumberValidator validator = ChinaMobilePhoneNumberValidator.getInstance();

		String phone1 = "13300000000";
		String phone2 = "14600000000";
		boolean result1 = validator.isChinaTelecomPhoneNumber(phone1);
		boolean result2 = validator.isChinaTelecomPhoneNumber(phone2);
		assertTrue(result1);
		assertFalse(result2);

		System.out.println("isChinaTelecomPhoneNumber1:" + result1);
		System.out.println("isChinaTelecomPhoneNumber2:" + result2);
	}

	@Test
	public void testIsChinaCBNPhoneNumber() {
		ChinaMobilePhoneNumberValidator validator = ChinaMobilePhoneNumberValidator.getInstance();

		String phone1 = "19200000000";
		String phone2 = "14600000000";
		boolean result1 = validator.isChinaCBNPhoneNumber(phone1);
		boolean result2 = validator.isChinaCBNPhoneNumber(phone2);
		assertTrue(result1);
		assertFalse(result2);

		System.out.println("isChinaCBNPhoneNumber1:" + result1);
		System.out.println("isChinaCBNPhoneNumber2:" + result2);
	}

	@Test
	public void testIsChinaSCPhoneNumber() {
		ChinaMobilePhoneNumberValidator validator = ChinaMobilePhoneNumberValidator.getInstance();

		String phone1 = "17490000000";
		String phone2 = "14600000000";
		boolean result1 = validator.isChinaSCPhoneNumber(phone1);
		boolean result2 = validator.isChinaSCPhoneNumber(phone2);
		assertTrue(result1);
		assertFalse(result2);

		System.out.println("isChinaSCPhoneNumber1:" + result1);
		System.out.println("isChinaSCPhoneNumber2:" + result2);
	}

	@Test
	public void testIsChinaECCPhoneNumber() {
		ChinaMobilePhoneNumberValidator validator = ChinaMobilePhoneNumberValidator.getInstance();

		String phone1 = "17406000000";
		String phone2 = "14600000000";
		boolean result1 = validator.isChinaECCPhoneNumber(phone1);
		boolean result2 = validator.isChinaECCPhoneNumber(phone2);
		assertTrue(result1);
		assertFalse(result2);

		System.out.println("isChinaECCPhoneNumber1:" + result1);
		System.out.println("isChinaECCPhoneNumber2:" + result2);
	}

	// ## MVNO number (Mobile Virtual Network Operator)

	@Test
	public void testIsAllMVNONumber() {
		ChinaMobilePhoneNumberValidator validator = ChinaMobilePhoneNumberValidator.getInstance();

		String phone1 = "16500000000";
		String phone2 = "14600000000";
		boolean result1 = validator.isAllMVNONumber(phone1);
		boolean result2 = validator.isAllMVNONumber(phone2);
		assertTrue(result1);
		assertFalse(result2);

		System.out.println("isAllMVNONumber1:" + result1);
		System.out.println("isAllMVNONumber2:" + result2);
	}

	@Test
	public void testIsChinaMobileMVNONumber() {
		ChinaMobilePhoneNumberValidator validator = ChinaMobilePhoneNumberValidator.getInstance();

		String phone1 = "16500000000";
		String phone2 = "14600000000";
		boolean result1 = validator.isChinaMobileMVNONumber(phone1);
		boolean result2 = validator.isChinaMobileMVNONumber(phone2);
		assertTrue(result1);
		assertFalse(result2);

		System.out.println("isChinaMobileMVNONumber1:" + result1);
		System.out.println("isChinaMobileMVNONumber2:" + result2);
	}

	@Test
	public void testIsChinaUnicomMVNONumber() {
		ChinaMobilePhoneNumberValidator validator = ChinaMobilePhoneNumberValidator.getInstance();

		String phone1 = "16700000000";
		String phone2 = "14600000000";
		boolean result1 = validator.isChinaUnicomMVNONumber(phone1);
		boolean result2 = validator.isChinaUnicomMVNONumber(phone2);
		assertTrue(result1);
		assertFalse(result2);

		System.out.println("isChinaUnicomMVNONumber1:" + result1);
		System.out.println("isChinaUnicomMVNONumber2:" + result2);
	}

	@Test
	public void testIsChinaTelecomMVNONumber() {
		ChinaMobilePhoneNumberValidator validator = ChinaMobilePhoneNumberValidator.getInstance();

		String phone1 = "16200000000";
		String phone2 = "14600000000";
		boolean result1 = validator.isChinaTelecomMVNONumber(phone1);
		boolean result2 = validator.isChinaTelecomMVNONumber(phone2);
		assertTrue(result1);
		assertFalse(result2);

		System.out.println("isChinaTelecomMVNONumber1:" + result1);
		System.out.println("isChinaTelecomMVNONumber2:" + result2);
	}

	// ## IoT number (Internet of Things)

	@Test
	public void testIsAllIoTNumber() {
		ChinaMobilePhoneNumberValidator validator = ChinaMobilePhoneNumberValidator.getInstance();

		String phone1 = "1441600000003";
		String phone2 = "1490000000003";
		boolean result1 = validator.isAllIoTNumber(phone1);
		boolean result2 = validator.isAllIoTNumber(phone2);
		assertTrue(result1);
		assertFalse(result2);

		System.out.println("isAllIoTNumber1:" + result1);
		System.out.println("isAllIoTNumber2:" + result2);
	}

	@Test
	public void testIsChinaMobileIoTNumber() {
		ChinaMobilePhoneNumberValidator validator = ChinaMobilePhoneNumberValidator.getInstance();

		String phone1 = "1441600000003";
		String phone2 = "1460000000003";
		boolean result1 = validator.isChinaMobileIoTNumber(phone1);
		boolean result2 = validator.isChinaMobileIoTNumber(phone2);
		assertTrue(result1);
		assertFalse(result2);

		System.out.println("isChinaMobileIoTNumber1:" + result1);
		System.out.println("isChinaMobileIoTNumber2:" + result2);
	}

	@Test
	public void testIsChinaUnicomIoTNumber() {
		ChinaMobilePhoneNumberValidator validator = ChinaMobilePhoneNumberValidator.getInstance();

		String phone1 = "1461600000003";
		String phone2 = "1400000000003";
		boolean result1 = validator.isChinaUnicomIoTNumber(phone1);
		boolean result2 = validator.isChinaUnicomIoTNumber(phone2);
		assertTrue(result1);
		assertFalse(result2);

		System.out.println("isChinaUnicomIoTNumber1:" + result1);
		System.out.println("isChinaUnicomIoTNumber2:" + result2);
	}

	@Test
	public void testIsChinaTelecomIoTNumber() {
		ChinaMobilePhoneNumberValidator validator = ChinaMobilePhoneNumberValidator.getInstance();

		String phone1 = "1410600000003";
		String phone2 = "1400000000003";
		boolean result1 = validator.isChinaTelecomIoTNumber(phone1);
		boolean result2 = validator.isChinaTelecomIoTNumber(phone2);
		assertTrue(result1);
		assertFalse(result2);

		System.out.println("isChinaTelecomIoTNumber1:" + result1);
		System.out.println("isChinaTelecomIoTNumber2:" + result2);
	}

	// ## Data only number

	@Test
	public void testIsAllDataNumber() {
		ChinaMobilePhoneNumberValidator validator = ChinaMobilePhoneNumberValidator.getInstance();

		String phone1 = "14700000000";
		String phone2 = "14600000000";
		boolean result1 = validator.isAllDataNumber(phone1);
		boolean result2 = validator.isAllDataNumber(phone2);
		assertTrue(result1);
		assertFalse(result2);

		System.out.println("isAllDataNumber1:" + result1);
		System.out.println("isAllDataNumber2:" + result2);
	}

	@Test
	public void testIsChinaMobileDataNumber() {
		ChinaMobilePhoneNumberValidator validator = ChinaMobilePhoneNumberValidator.getInstance();

		String phone1 = "14700000000";
		String phone2 = "14600000000";
		boolean result1 = validator.isChinaMobileDataNumber(phone1);
		boolean result2 = validator.isChinaMobileDataNumber(phone2);
		assertTrue(result1);
		assertFalse(result2);

		System.out.println("isChinaMobileDataNumber1:" + result1);
		System.out.println("isChinaMobileDataNumber2:" + result2);
	}

	@Test
	public void testIsChinaUnicomDataNumber() {
		ChinaMobilePhoneNumberValidator validator = ChinaMobilePhoneNumberValidator.getInstance();

		String phone1 = "14500000000";
		String phone2 = "14600000000";
		boolean result1 = validator.isChinaUnicomDataNumber(phone1);
		boolean result2 = validator.isChinaUnicomDataNumber(phone2);
		assertTrue(result1);
		assertFalse(result2);

		System.out.println("isChinaUnicomDataNumber1:" + result1);
		System.out.println("isChinaUnicomDataNumber2:" + result2);
	}

	@Test
	public void testIsChinaTelecomDataNumber() {
		ChinaMobilePhoneNumberValidator validator = ChinaMobilePhoneNumberValidator.getInstance();

		String phone1 = "14900000000";
		String phone2 = "14600000000";
		boolean result1 = validator.isChinaTelecomDataNumber(phone1);
		boolean result2 = validator.isChinaTelecomDataNumber(phone2);
		assertTrue(result1);
		assertFalse(result2);

		System.out.println("isChinaTelecomDataNumber1:" + result1);
		System.out.println("isChinaTelecomDataNumber2:" + result2);
	}

}

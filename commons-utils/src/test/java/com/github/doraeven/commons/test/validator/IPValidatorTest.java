package com.github.doraeven.commons.test.validator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.github.doraeven.commons.validator.IPValidator;

public class IPValidatorTest {

	@Test
	public void testIsIP() {
		IPValidator validator = IPValidator.getInstance();

		String address1 = "127.0.0.1";
		String address2 = "2001:db8::211:22ff:fe33:4455";
		String address3 = "xxx.xxx.xxx.xxx";
		boolean result1 = validator.isIP(address1);
		boolean result2 = validator.isIP(address2);
		boolean result3 = validator.isIP(address3);
		assertTrue(result1);
		assertTrue(result2);
		assertFalse(result3);

		System.out.println("isIP1:" + result1);
		System.out.println("isIP2:" + result2);
		System.out.println("isIP3:" + result3);
	}

	@Test
	public void testIsIPv4() {
		IPValidator validator = IPValidator.getInstance();

		String address = "127.0.0.1";
		boolean result = validator.isIPv4(address);
		assertTrue(result);

		System.out.println("isIPv4:" + result);
	}

	@Test
	public void testIsIPv6() {
		IPValidator validator = IPValidator.getInstance();

		String address = "2001:db8::211:22ff:fe33:4455";
		boolean result = validator.isIPv6(address);
		assertTrue(result);

		System.out.println("isIPv6:" + result);
	}

}

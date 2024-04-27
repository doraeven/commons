package com.github.doraeven.commons.test.validator;

import org.junit.jupiter.api.Assertions;
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

		Assertions.assertTrue(result1);
		Assertions.assertTrue(result2);
		Assertions.assertFalse(result3);
	}

	@Test
	public void testIsIPv4() {
		IPValidator validator = IPValidator.getInstance();

		String address = "127.0.0.1";
		boolean result = validator.isIPv4(address);

		Assertions.assertTrue(result);
	}

	@Test
	public void testIsIPv6() {
		IPValidator validator = IPValidator.getInstance();

		String address = "2001:db8::211:22ff:fe33:4455";
		boolean result = validator.isIPv6(address);

		Assertions.assertTrue(result);
	}

}

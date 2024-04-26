package com.github.doraeven.commons.validator;

import java.io.Serializable;

import org.apache.commons.validator.routines.InetAddressValidator;

/**
 * IP Validator
 * 
 * <p>
 * Validate a IP address. Base on
 * {@link org.apache.commons.validator.routines.InetAddressValidator}.
 * </p>
 * 
 * @see <a href=
 *      "https://www.techiedelight.com/validate-ip-address-java/">https://www.techiedelight.com/validate-ip-address-java/</a>
 * 
 * @author motu
 *
 */
public class IPValidator implements Serializable {

	/**
	 * Checks if the specified string is a valid IP address.
	 * 
	 * @param address the string to validate
	 * @return true if the string validates as an IP address
	 */
	public boolean isIP(String address) {
		return inetAddressValidator.isValid(address);
	}

	/**
	 * Validates an IPv4 address.
	 * 
	 * @param address the IPv4 address to validate
	 * @return true if the argument contains a valid IPv4 address
	 */
	public boolean isIPv4(String address) {
		return inetAddressValidator.isValidInet4Address(address);
	}

	/**
	 * Validates an IPv6 address.
	 * 
	 * @param address the IPv6 address to validate
	 * @return true if the argument contains a valid IPv6 address
	 */
	public boolean isIPv6(String address) {
		return inetAddressValidator.isValidInet6Address(address);
	}

	/**
	 * Returns the singleton instance of this validator.
	 * 
	 * @return the singleton instance of this validator
	 */
	public static IPValidator getInstance() {
		return VALIDATOR;
	}

	/**
	 * Singleton instance of this class.
	 */
	private static final IPValidator VALIDATOR = new IPValidator();

	/** InetAddressValidator */
	private final InetAddressValidator inetAddressValidator = new InetAddressValidator();

	private static final long serialVersionUID = -8053706192439972121L;

}

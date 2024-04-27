package com.github.doraeven.commons.web;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;

/**
 * Client IP Utils
 * 
 * <p>
 * Get client IP address.
 * </p>
 * 
 * <p>
 * If your application is running on a webserver that is located behind a
 * reverse proxy or load balancer, then that proxy can be configured to inject
 * the requested IP address in a request header. Different reverse proxies can
 * inject different headers.
 * </p>
 * 
 * @see <a href=
 *      "https://mkyong.com/java/how-to-get-client-ip-address-in-java/">https://mkyong.com/java/how-to-get-client-ip-address-in-java/</a>
 * @see <a href=
 *      "https://stackoverflow.com/questions/29910074/how-to-get-client-ip-address-in-java-httpservletrequest">https://stackoverflow.com/questions/29910074/how-to-get-client-ip-address-in-java-httpservletrequest</a>
 * @see <a href=
 *      "https://stackoverflow.com/questions/4678797/how-do-i-get-the-remote-address-of-a-client-in-servlet">https://stackoverflow.com/questions/4678797/how-do-i-get-the-remote-address-of-a-client-in-servlet</a>
 * 
 * @author motu
 * 
 */
public class ClientIPUtils {

	/**
	 * Get the all possible candidates that may get the client ip address.
	 * 
	 * @param request HTTP request
	 * @return the client IP address
	 */
	public static String getClientIP(HttpServletRequest request) {
		for (String header : VALID_IP_HEADER_CANDIDATES) {
			String ip = request.getHeader(header);
			if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip)) {
				return ip;
			}
		}

		return request.getRemoteAddr();
	}

	/**
	 * Get all the key and value pairs are in HTTP header.
	 * 
	 * @param request HTTP request
	 * @return key and value pairs in map
	 */
	public static Map<String, String> getRequestHeadersInMap(HttpServletRequest request) {
		Map<String, String> result = new HashMap<>();
		Enumeration<?> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String key = (String) headerNames.nextElement();
			String value = request.getHeader(key);
			result.put(key, value);
		}

		return result;
	}

	/** All header possible candidates **/
	public static final String[] VALID_IP_HEADER_CANDIDATES = { "X-Forwarded-For", "Proxy-Client-IP",
			"WL-Proxy-Client-IP", "HTTP_X_FORWARDED_FOR", "HTTP_X_FORWARDED", "HTTP_X_CLUSTER_CLIENT_IP",
			"HTTP_CLIENT_IP", "HTTP_FORWARDED_FOR", "HTTP_FORWARDED", "HTTP_VIA", "REMOTE_ADDR", "X-Real-IP" };

}

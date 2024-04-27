package com.github.doraeven.commons.web.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.github.doraeven.commons.web.ClientIPUtils;

import jakarta.servlet.http.HttpServletRequest;

/**
 * Client IP Utils Test
 * 
 * <p>
 * Mock out the request object using a mocking library
 * </p>
 * 
 * @see <a href= "https://site.mockito.org/">https://site.mockito.org/</a>
 * @see <a href=
 *      "https://www.baeldung.com/java-httpservletrequest-mock">https://www.baeldung.com/java-httpservletrequest-mock</a>
 * @see <a href=
 *      "https://stackoverflow.com/questions/12945907/how-to-mock-the-httpservletrequest">https://stackoverflow.com/questions/12945907/how-to-mock-the-httpservletrequest</a>
 * @see <a href=
 *      "https://stackoverflow.com/questions/11721622/how-do-i-pass-the-httpservletrequest-object-to-the-test-case">https://stackoverflow.com/questions/11721622/how-do-i-pass-the-httpservletrequest-object-to-the-test-case</a>
 * @see <a href=
 *      "https://stackoverflow.com/questions/47178048/writing-a-unit-test-for-a-method-with-two-http-calls-with-mockito-and-junit">https://stackoverflow.com/questions/47178048/writing-a-unit-test-for-a-method-with-two-http-calls-with-mockito-and-junit</a>
 * @see <a href=
 *      "https://stackoverflow.com/questions/12945907/how-to-mock-the-httpservletrequest">https://stackoverflow.com/questions/12945907/how-to-mock-the-httpservletrequest</a>
 * @see <a href=
 *      "https://stackoverflow.com/questions/51564904/mock-httpservletrequest-and-requestcontext">https://stackoverflow.com/questions/51564904/mock-httpservletrequest-and-requestcontext</a>
 * 
 * @author motu
 * 
 */
public class ClientIPUtilsTest {

	@Test
	public void testGetClientIP() {
		HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
		Mockito.when(request.getHeader("X-Forwarded-For")).thenReturn("192.168.8.8");

		String ip = ClientIPUtils.getClientIP(request);
		Assertions.assertEquals("192.168.8.8", ip);
	}

	@Test
	public void testGetRequestHeadersInMap() {
		HttpServletRequest request = Mockito.mock(HttpServletRequest.class);

		List<String> headerNames = new ArrayList<String>();
		headerNames.add("referer");
		headerNames.add("cf-ipcountry");
		headerNames.add("cf-ray");
		headerNames.add("x-forwarded-proto");
		headerNames.add("accept-language");
		headerNames.add("cookie");
		headerNames.add("accept");
		headerNames.add("x-forwarded-for");
		headerNames.add("x-real-ip");
		headerNames.add("x-forwarded-server");
		headerNames.add("x-forwarded-host");
		headerNames.add("cf-visitor");
		headerNames.add("host");
		headerNames.add("upgrade-insecure-requests");
		headerNames.add("connection");
		headerNames.add("cf-connecting-ip");
		headerNames.add("accept-encoding");
		headerNames.add("user-agent");
		Mockito.when(request.getHeaderNames()).thenReturn(Collections.enumeration(headerNames));

		Mockito.when(request.getHeader("referer")).thenReturn("https://www.google.com/");
		Mockito.when(request.getHeader("cf-ipcountry")).thenReturn("US");
		Mockito.when(request.getHeader("cf-ray")).thenReturn("348c7acba8a02210-EWR");
		Mockito.when(request.getHeader("x-forwarded-proto")).thenReturn("https");
		Mockito.when(request.getHeader("accept-language")).thenReturn("en-US,en;q=0.8");
		Mockito.when(request.getHeader("cookie"))
				.thenReturn("__cfduid=d3c6e5d73aa55b6b42fad9600c94849851490726068; _ga=GA1.2.450731937.1490726069");
		Mockito.when(request.getHeader("x-forwarded-for")).thenReturn("100.8.204.40");
		Mockito.when(request.getHeader("accept"))
				.thenReturn("text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
		Mockito.when(request.getHeader("x-real-ip")).thenReturn("108.162.219.236");
		Mockito.when(request.getHeader("x-forwarded-server")).thenReturn("hostingcompass.com");
		Mockito.when(request.getHeader("x-forwarded-host")).thenReturn("hostingcompass.com");
		Mockito.when(request.getHeader("cf-visitor")).thenReturn("{\\\"scheme\\\":\\\"https\\\"}");
		Mockito.when(request.getHeader("host")).thenReturn("127.0.0.1:8080");
		Mockito.when(request.getHeader("upgrade-insecure-requests")).thenReturn("1");
		Mockito.when(request.getHeader("connection")).thenReturn("close");
		Mockito.when(request.getHeader("cf-connecting-ip")).thenReturn("100.8.204.40");
		Mockito.when(request.getHeader("accept-encoding")).thenReturn("gzip");
		Mockito.when(request.getHeader("user-agent")).thenReturn(
				"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36");

		Map<String, String> result = ClientIPUtils.getRequestHeadersInMap(request);
		Assertions.assertEquals("https://www.google.com/", result.get("referer"));
		Assertions.assertEquals("US", result.get("cf-ipcountry"));
		Assertions.assertEquals("en-US,en;q=0.8", result.get("accept-language"));
		Assertions.assertEquals("__cfduid=d3c6e5d73aa55b6b42fad9600c94849851490726068; _ga=GA1.2.450731937.1490726069",
				result.get("cookie"));
		Assertions.assertEquals("100.8.204.40", result.get("x-forwarded-for"));
		Assertions.assertEquals("text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8",
				result.get("accept"));
		Assertions.assertEquals("108.162.219.236", result.get("x-real-ip"));
		Assertions.assertEquals("hostingcompass.com", result.get("x-forwarded-server"));
		Assertions.assertEquals("hostingcompass.com", result.get("x-forwarded-host"));
		Assertions.assertEquals("{\\\"scheme\\\":\\\"https\\\"}", result.get("cf-visitor"));
		Assertions.assertEquals("127.0.0.1:8080", result.get("host"));
		Assertions.assertEquals("1", result.get("upgrade-insecure-requests"));
		Assertions.assertEquals("close", result.get("connection"));
		Assertions.assertEquals("100.8.204.40", result.get("cf-connecting-ip"));
		Assertions.assertEquals("gzip", result.get("accept-encoding"));
		Assertions.assertEquals(
				"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36",
				result.get("user-agent"));
	}

}

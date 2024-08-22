package com.github.doraeven.commons.test.utils;

import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.github.doraeven.commons.utils.UUIDUtils;

public class UUIDUtilsTest {

	@Test
	public void testRandomUUID() {
		UUID uuid = UUIDUtils.randomUUID();
		log.debug("randomUUID:" + uuid);
	}

	@Test
	public void getRandomUUID() {
		String uuid = UUIDUtils.getRandomUUID();
		log.debug("getRandomUUID:" + uuid);
	}

	@Test
	public void toBytes() {
		UUID uuid = UUIDUtils.randomUUID();
		log.debug("uuid:" + uuid);

		byte[] result = UUIDUtils.toBytes(uuid);
		StringBuilder sb = new StringBuilder();
		for (byte b : result) {
			sb.append(b);
			sb.append(' ');
		}
		log.debug("toBytes result:" + sb.toString());
	}

	@Test
	public void fromBytes() {
		UUID uuid = UUIDUtils.randomUUID();
		log.debug("uuid:" + uuid);

		byte[] uuid_encode = UUIDUtils.toBytes(uuid);
		StringBuilder sb = new StringBuilder();
		for (byte b : uuid_encode) {
			sb.append(b);
			sb.append(' ');
		}
		log.debug("uuid encode:" + sb.toString());

		UUID uuid_decode = UUIDUtils.fromBytes(uuid_encode);
		log.debug("uuid decode:" + uuid_decode);
	}

	@Test
	public void toBase64_UUID() {
		UUID uuid = UUIDUtils.randomUUID();
		log.debug("uuid:" + uuid);

		byte[] result = UUIDUtils.toBase64(uuid);
		StringBuilder sb = new StringBuilder();
		for (byte b : result) {
			sb.append(b);
			sb.append(' ');
		}
		log.debug("UUID toBase64 result:" + sb.toString());
	}

	@Test
	public void toBase64_bytes() {
		UUID uuid = UUIDUtils.randomUUID();
		log.debug("uuid:" + uuid);

		byte[] uuid_encode = UUIDUtils.toBytes(uuid);
		byte[] result = UUIDUtils.toBase64(uuid_encode);
		StringBuilder sb = new StringBuilder();
		for (byte b : result) {
			sb.append(b);
			sb.append(' ');
		}
		log.debug("bytes toBase64 result:" + sb.toString());
	}

	@Test
	public void toBase64URLSafe_UUID() {
		UUID uuid = UUIDUtils.randomUUID();
		log.debug("uuid:" + uuid);

		byte[] result = UUIDUtils.toBase64URLSafe(uuid);
		StringBuilder sb = new StringBuilder();
		for (byte b : result) {
			sb.append(b);
			sb.append(' ');
		}
		log.debug("UUID toBase64URLSafe result:" + sb.toString());
	}

	@Test
	public void toBase64URLSafe_bytes() {
		UUID uuid = UUIDUtils.randomUUID();
		log.debug("uuid:" + uuid);

		byte[] uuid_encode = UUIDUtils.toBytes(uuid);
		byte[] result = UUIDUtils.toBase64URLSafe(uuid_encode);
		StringBuilder sb = new StringBuilder();
		for (byte b : result) {
			sb.append(b);
			sb.append(' ');
		}
		log.debug("bytes toBase64URLSafe result:" + sb.toString());
	}

	@Test
	public void toBase64String_UUID() {
		UUID uuid = UUIDUtils.randomUUID();
		log.debug("uuid:" + uuid);

		String result = UUIDUtils.toBase64String(uuid);
		log.debug("UUID toBase64String result:" + result);
	}

	@Test
	public void toBase64String_bytes() {
		UUID uuid = UUIDUtils.randomUUID();
		log.debug("uuid:" + uuid);

		byte[] uuid_encode = UUIDUtils.toBytes(uuid);
		String result = UUIDUtils.toBase64String(uuid_encode);
		log.debug("bytes toBase64String result:" + result);
	}

	@Test
	public void toBase64URLSafeString_UUID() {
		UUID uuid = UUIDUtils.randomUUID();
		log.debug("uuid:" + uuid);

		String result = UUIDUtils.toBase64URLSafeString(uuid);
		log.debug("UUID toBase64URLSafeString result:" + result);
	}

	@Test
	public void toBase64URLSafeString_bytes() {
		UUID uuid = UUIDUtils.randomUUID();
		log.debug("uuid:" + uuid);

		byte[] uuid_encode = UUIDUtils.toBytes(uuid);
		String result = UUIDUtils.toBase64URLSafeString(uuid_encode);
		log.debug("bytes toBase64URLSafeString result:" + result);
	}

	@Test
	public void fromBase64_bytes() {
		UUID uuid = UUIDUtils.randomUUID();
		log.debug("uuid:" + uuid);

		// encode
		byte[] uuid_encode = UUIDUtils.toBytes(uuid);
		byte[] encode_base64 = UUIDUtils.toBase64(uuid_encode);
		byte[] encode_base64urlsafe = UUIDUtils.toBase64URLSafe(uuid_encode);

		// decode
		byte[] decode_base64 = UUIDUtils.fromBase64(encode_base64);
		byte[] decode_base64urlsafe = UUIDUtils.fromBase64(encode_base64urlsafe);

		StringBuilder sb_base64 = new StringBuilder();
		for (byte b : decode_base64) {
			sb_base64.append(b);
			sb_base64.append(' ');
		}
		log.debug("bytes decode_base64 result:" + sb_base64.toString());

		StringBuilder sb_base64urlsafe = new StringBuilder();
		for (byte b : decode_base64urlsafe) {
			sb_base64urlsafe.append(b);
			sb_base64urlsafe.append(' ');
		}
		log.debug("bytes decode_base64urlsafe result:" + sb_base64urlsafe.toString());

		Assertions.assertArrayEquals(uuid_encode, decode_base64);
		Assertions.assertArrayEquals(uuid_encode, decode_base64urlsafe);
	}

	@Test
	public void fromBase64_String() {
		UUID uuid = UUIDUtils.randomUUID();
		log.debug("uuid:" + uuid);

		// encode
		byte[] uuid_encode = UUIDUtils.toBytes(uuid);
		String encode_base64 = UUIDUtils.toBase64String(uuid_encode);
		String encode_base64urlsafe = UUIDUtils.toBase64URLSafeString(uuid_encode);
		log.debug("bytes toBase64String result:" + encode_base64);
		log.debug("bytes toBase64URLSafeString result:" + encode_base64urlsafe);

		// decode
		byte[] decode_base64 = UUIDUtils.fromBase64(encode_base64);
		byte[] decode_base64urlsafe = UUIDUtils.fromBase64(encode_base64urlsafe);

		StringBuilder sb_base64 = new StringBuilder();
		for (byte b : decode_base64) {
			sb_base64.append(b);
			sb_base64.append(' ');
		}
		log.debug("bytes decode_base64 result:" + sb_base64.toString());

		StringBuilder sb_base64urlsafe = new StringBuilder();
		for (byte b : decode_base64urlsafe) {
			sb_base64urlsafe.append(b);
			sb_base64urlsafe.append(' ');
		}
		log.debug("bytes decode_base64urlsafe result:" + sb_base64urlsafe.toString());

		Assertions.assertArrayEquals(uuid_encode, decode_base64);
		Assertions.assertArrayEquals(uuid_encode, decode_base64urlsafe);
	}

	private Log log = LogFactory.getLog(UUIDUtilsTest.class);
}

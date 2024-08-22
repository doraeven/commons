package com.github.doraeven.commons.utils;

import java.nio.ByteBuffer;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;

public class UUIDUtils {

	/**
	 * Get a random UUID
	 * 
	 * @return random UUID
	 */
	public static UUID randomUUID() {
		return UUID.randomUUID();
	}

	/**
	 * Get a random UUID string
	 * 
	 * @return random UUID string
	 */
	public static String getRandomUUID() {
		UUID uuid = randomUUID();
		return uuid.toString();
	}

	/**
	 * Convert the UUID to byte array
	 * 
	 * @param uuid the UUID
	 * @return a uuid byte array
	 */
	public static byte[] toBytes(UUID uuid) {
		ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
		bb.putLong(uuid.getMostSignificantBits());
		bb.putLong(uuid.getLeastSignificantBits());
		return bb.array();
	}

	/**
	 * Convert the uuid byte array to UUID
	 * 
	 * @param bytes the uuid byte array
	 * @return a UUID
	 */
	public static UUID fromBytes(byte[] bytes) {
		ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
		long high = byteBuffer.getLong();
		long low = byteBuffer.getLong();
		return new UUID(high, low);
	}

	/**
	 * Encode the UUID to Base64 byte array
	 * 
	 * @param uuid the UUID
	 * @return a Base64 byte array
	 */
	public static byte[] toBase64(UUID uuid) {
		byte[] bytes = toBytes(uuid);
		return toBase64(bytes);
	}

	/**
	 * Encode the uuid byte array to Base64 byte array
	 * 
	 * @param bytes the uuid byte array
	 * @return a Base64 byte array
	 */
	public static byte[] toBase64(byte[] bytes) {
		return Base64.encodeBase64(bytes);
	}

	/**
	 * Encode the UUID to Base64URLSafe byte array
	 * 
	 * @param uuid the UUID
	 * @return a Base64URLSafe byte array
	 */
	public static byte[] toBase64URLSafe(UUID uuid) {
		byte[] bytes = toBytes(uuid);
		return toBase64URLSafe(bytes);
	}

	/**
	 * Encode the uuid byte array to Base64URLSafe byte array
	 * 
	 * @param bytes the uuid byte array
	 * @return a Base64URLSafe byte array
	 */
	public static byte[] toBase64URLSafe(byte[] bytes) {
		return Base64.encodeBase64URLSafe(bytes);
	}

	/**
	 * Encode the UUID to Base64 string
	 * 
	 * @param uuid the UUID
	 * @return a Base64 string
	 */
	public static String toBase64String(UUID uuid) {
		byte[] bytes = toBytes(uuid);
		return toBase64String(bytes);
	}

	/**
	 * Encode the uuid byte array to Base64 string
	 * 
	 * @param bytes the uuid byte array
	 * @return a Base64 string
	 */
	public static String toBase64String(byte[] bytes) {
		return Base64.encodeBase64String(bytes);
	}

	/**
	 * Encode the UUID to Base64URLSafe string
	 * 
	 * @param uuid the UUID
	 * @return a Base64URLSafe string
	 */
	public static String toBase64URLSafeString(UUID uuid) {
		byte[] bytes = toBytes(uuid);
		return toBase64URLSafeString(bytes);
	}

	/**
	 * Encode the uuid byte array to Base64URLSafe string
	 * 
	 * @param bytes the uuid byte array
	 * @return a Base64URLSafe string
	 */
	public static String toBase64URLSafeString(byte[] bytes) {
		return Base64.encodeBase64URLSafeString(bytes);
	}

	/**
	 * Decode the Base64 byte array to uuid byte array
	 * 
	 * @param base64Bytes the Base64 byte array
	 * @return a uuid byte array
	 */
	public static byte[] fromBase64(byte[] base64Bytes) {
		return Base64.decodeBase64(base64Bytes);
	}

	/**
	 * Decode the Base64 string to uuid byte array
	 * 
	 * @param base64String the Base64 string
	 * @return a uuid byte array
	 */
	public static byte[] fromBase64(String base64String) {
		return Base64.decodeBase64(base64String);
	}

}

package com.github.doraeven.commons.test.lang;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.github.doraeven.commons.lang.Ref;

@SuppressWarnings("deprecation")
public class RefTest {

	@Test
	public void testRef() {
		Ref<Integer> ref = new Ref<Integer>();
		ref.value = 1;
		assertEquals(ref.value, 1);

		System.out.println(ref.value);
	}

}

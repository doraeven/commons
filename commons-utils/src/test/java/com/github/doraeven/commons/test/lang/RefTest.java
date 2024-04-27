package com.github.doraeven.commons.test.lang;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.github.doraeven.commons.lang.Ref;

@SuppressWarnings("deprecation")
public class RefTest {

	@Test
	public void testRef() {
		Ref<Integer> ref = new Ref<Integer>();
		ref.value = 1;

		Assertions.assertEquals(1, ref.value);
	}

}

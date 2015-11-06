package com.maming.common.mock;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class MockTest {

	@Test
	public void controllTest() {

		Service service2 = Mockito.mock(Service.class);

		Person person = new Person();
		person.setName("aa");
		person.setSex("man");

		Controller controller = new Controller();

		try {
			Field serviceField = controller.getClass().getDeclaredField(
					"service");
			serviceField.setAccessible(true);
			serviceField.set(controller, service2);

			Mockito.when(service2.add()).thenReturn(8);

			final Map<String, String> map = new HashMap<String, String>();
			map.put("aa", "bbb");
			map.put("cc", "ddd");
			Answer<Map<String, String>> aswser = new Answer<Map<String, String>>() {
				public Map<String, String> answer(InvocationOnMock invocation) {
					return map;
				}
			};

			Mockito.when(service2.getMap()).then(aswser);
			controller.controll(person);
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}

package org.logoff;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class HooksClass {
	@Before
	private void before() {
		System.out.println("Before Scenario");

	}
	
	@After
	private void after() {
		System.out.println("After Scenario");

	}
}

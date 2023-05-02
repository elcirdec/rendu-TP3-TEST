package ilu2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WelcomeTest {

	@Test
	void testInput1Name() {
		assertEquals(Welcome.welcome("bob"), "Hello, Bob");
		assertEquals(Welcome.welcome("amy"), "Hello, Amy");
	}
	
	@Test
	void testInputNullEmpty() {
		assertEquals(Welcome.welcome(""), "Hello, my friend");
		assertEquals(Welcome.welcome(null), "Hello, my friend");
		assertEquals(Welcome.welcome("   "), "Hello, my friend");
	}
	
	@Test
	void test1SeulCris() {
		assertEquals(Welcome.welcome("JERRY"), "HELLO, JERRY");
		assertEquals(Welcome.welcome("TOM"), "HELLO, TOM");
	}

}

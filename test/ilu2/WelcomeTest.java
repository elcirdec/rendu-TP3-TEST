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
	
	@Test
	void testInput2Names() {
		assertEquals(Welcome.welcome("amy,bob"), "Hello, Amy and Bob");
	}

	@Test
	void testInputMoreThan2Names() {
		assertEquals(Welcome.welcome("Amy, bob, jerry"), "Hello, Amy, Bob and Jerry");
	}
	
	@Test
	void testCrisAvecPlusieursNom() {
		assertEquals(Welcome.welcome("Amy, BOB, Jerry"), "Hello, Amy and Jerry. AND HELLO, BOB !");
	}
	
	@Test
	void testAndEntreLesDerniersNoms() {
		assertEquals(Welcome.welcome("bob, AMY, jerry, JACK"), "Hello, Bob and Jerry. AND HELLO, AMY AND JACK !");
	}
	
	@Test
	void testSupprimerEspaceInutile() {
		assertEquals(Welcome.welcome("bob    , amy   "), "Hello, Bob and Amy");
	}
}

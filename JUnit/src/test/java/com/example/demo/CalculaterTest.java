package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.test.Calculater;

public class CalculaterTest {
	
	Calculater calculator;
	
	@BeforeEach
	public void setUp() {
	calculator = new Calculater();
	}
	
	@Test
	public void testMultiply() {
		assertEquals(20, calculator.multiply(4, 5));
	}
	
	@Test
	public void testDevide() {
		assertEquals(1, calculator.devide(2, 2));
	}
	
}

package com.uci.oit.pts.site.services;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringSanitizorTest {

	@Test
	public void testSanitizeWithHtmlEscape() {
		StringSanitizor sut = new StringSanitizor();
		assertEquals("&lt;html&gt;", sut.sanitizeWithHtmlEscape("<html>"));
	}

}

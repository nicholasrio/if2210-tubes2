package org;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConfigurationTest {

	@Test
	public void testGetHeaderDownloadLimit() throws Exception {
		Configuration cfg = new Configuration();
		cfg.load("configuration.xml");
		int limit = cfg.getHeaderDownloadLimit();
		assertEquals("Header Download Limit = 20",20,limit);
	}

	

}

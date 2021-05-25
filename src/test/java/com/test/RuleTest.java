package com.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;

public class RuleTest {
	
	@Rule
	public TemporaryFolder tmpFolder = new TemporaryFolder();
	
	@Test 
	public void shouCreateNewFileInTemporaryFolder() throws IOException {
		
		File created = tmpFolder.newFile("file.txt");
		
		assertTrue(created.isFile());
		assertEquals(tmpFolder.getRoot(), created.getParentFile());
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void shouldTestExceptionMessage() throws IndexOutOfBoundsException {
		List<Object> list = new ArrayList<Object>();
		
		thrown.expect(IndexOutOfBoundsException.class);
		thrown.expectMessage("Index: 0, Size: 0");
		list.get(0);
	}
	
	@Test
	public void testExceptionMessage() {
		try {
			new ArrayList<Object>().get(0);
			fail("Esperado que IndexOutOfBoundsException seja lançada");
		} catch (IndexOutOfBoundsException ex) {
			assertEquals(ex.getMessage(), ("Index: 0, Size: 0"));
		}
	}
}

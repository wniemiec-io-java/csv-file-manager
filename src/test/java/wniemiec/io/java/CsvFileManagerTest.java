package wniemiec.io.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.After;
import org.junit.Test;

public class CsvFileManagerTest {

	//-------------------------------------------------------------------------
	//		Attributes
	//-------------------------------------------------------------------------
	private static final CsvFileManager csv;
	
	
	//-------------------------------------------------------------------------
	//		Initialization block
	//-------------------------------------------------------------------------
	static {
		csv = new CsvFileManager(
				new File(System.getProperty("java.io.tmpdir")), 
				"csv-test"
		);
	}
	
	
	//-------------------------------------------------------------------------
	//		Test hooks
	//-------------------------------------------------------------------------
	@After
	public void clean() {
		csv.delete();
	}
	
	
	//-------------------------------------------------------------------------
	//		Tests
	//-------------------------------------------------------------------------
	@Test
	public void testWriteAndRead() throws IOException {
		List<String> firstLine = List.of("hello", "world");
		List<String> secondLine = List.of("world", "hello");
		List<List<String>> content = List.of(firstLine, secondLine);
		
		csv.writeLine(firstLine);
		csv.writeLine(secondLine);
		
		assertEquals(content, csv.readLines());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorWithDirectoryNull() {
		new CsvFileManager(null, "filename");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorWithFilenameNull() {
		new CsvFileManager(new File("."), null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorWithDirectoryAndFilenameNull() {
		new CsvFileManager(null, null);
	}
	
	@Test
	public void testWriteAndReadWithSpecifiedDelimiter() throws IOException {
		List<String> firstLine = List.of("hello", "world");
		List<String> secondLine = List.of("world", "hello");
		List<List<String>> content = List.of(firstLine, secondLine);
		String delimiter = ";";
		
		csv.writeLine(firstLine, delimiter);
		csv.writeLine(secondLine, delimiter);
		
		assertEquals(content, csv.readLines(delimiter));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testWriteWithNullSpecifiedDelimiter() throws IOException {
		List<String> firstLine = List.of("hello", "world");
		List<String> secondLine = List.of("world", "hello");
		String delimiter = null;
		
		csv.writeLine(firstLine, delimiter);
		csv.writeLine(secondLine, delimiter);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testReadWithNullSpecifiedDelimiter() throws IOException {
		List<String> firstLine = List.of("hello", "world");
		List<String> secondLine = List.of("world", "hello");
		String delimiter = ";";
		
		csv.writeLine(firstLine, delimiter);
		csv.writeLine(secondLine, delimiter);
		
		csv.readLines(null);
	}
	
	@Test
	public void testExists() throws IOException {
		List<String> firstLine = List.of("hello", "world");
		List<String> secondLine = List.of("world", "hello");
		
		csv.writeLine(firstLine);
		csv.writeLine(secondLine);
		
		assertTrue(csv.exists());
	}
	
	@Test
	public void testNotExists() throws IOException {
		csv.delete();
		
		assertFalse(csv.exists());
	}
}

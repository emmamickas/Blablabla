package p2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TarEntryTest {
	
	private static TarEntry testTarEntry;
	
	private static TarHeader testTarHeader;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		testTarEntry = new TarEntry("Test Tar Entry");
		
		testTarHeader = new TarHeader();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		testTarEntry = null;
		testTarHeader = null;
	}

	@Before
	public void setUp() throws Exception {
		// There is nothing necessary to this class requiring setup before each individual test
 }

	@After
	public void tearDown() throws Exception {
	   // There is nothing necessary to this class requiring tear down after each individual test
	}

	@Test
	public void testTarEntryString() {
		fail("Not yet implemented");
	}

	@Test
	public void testTarEntryFile() {
		fail("Not yet implemented");
	}

	@Test
	public void testTarEntryByteArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testEqualsTarEntry() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsDescendent() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetHeader() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetName() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetName() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetUserId() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetUserId() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetGroupId() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetGroupId() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetUserName() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetUserName() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetGroupName() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetGroupName() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetIds() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetNames() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetModTimeLong() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetModTimeDate() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetModTime() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFile() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSize() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetSize() {
		fail("Not yet implemented");
	}

	@Test
	public void testAdjustEntryName() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsDirectory() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFileTarHeader() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDirectoryEntries() {
		fail("Not yet implemented");
	}

	@Test
	public void testComputeCheckSum() {
		fail("Not yet implemented");
	}

	@Test
	public void testWriteEntryHeader() {
		fail("Not yet implemented");
	}

	@Test
	public void testParseTarHeader() {
		fail("Not yet implemented");
	}

	@Test
	public void testNameTarHeader() {
		fail("Not yet implemented");
	}

}

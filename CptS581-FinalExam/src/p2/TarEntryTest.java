package p2;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
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
		testTarHeader = null;
	}

	@Before
	public void setUp() throws Exception {
		testTarEntry = new TarEntry("Test Tar Entry");
		
		testTarHeader = new TarHeader();
	}

	@After
	public void tearDown() throws Exception {
		   // There is nothing necessary to this class requiring tear down after each individual test
	}

	@Ignore
	@Test
	public void testTarEntryString() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testTarEntryFile() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testTarEntryByteArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testEqualsTarEntry() {
		TarEntry testTarEntryToCompare = new TarEntry("Test Tar Entry");
		
		assertTrue(testTarEntryToCompare.tarEntryEquals(testTarEntry));
		
		testTarEntryToCompare = new TarEntry("Test Tar Entry Not");
		
		assertFalse(testTarEntryToCompare.tarEntryEquals(testTarEntry));
	}

	@Ignore
	@Test
	public void testIsDescendent() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testGetHeader() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testGetName() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testSetName() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testGetUserId() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testSetUserId() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testGetGroupId() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testSetGroupId() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testGetUserName() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testSetUserName() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testGetGroupName() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testSetGroupName() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testSetIds() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testSetNames() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testSetModTimeLong() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testSetModTimeDate() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testGetModTime() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testGetFile() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testGetSize() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testSetSize() {
		fail("Not yet implemented");
	}

	@Test
	public void testAdjustEntryName() {

		byte[] buf = new byte[100];
		
		testTarEntry.adjustEntryName(buf, "NewName");

		byte[] bufToCompare = {78, 101, 119, 78, 97, 109, 101, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		
		assertEquals(Arrays.toString(bufToCompare), Arrays.toString(buf));
		
		testTarEntry.adjustEntryName(buf, "AnotherNewName");

		byte[] bufToCompare2 = {65, 110, 111, 116, 104, 101, 114, 78, 101, 119, 78, 97, 109, 101, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		
		assertEquals(Arrays.toString(bufToCompare2), Arrays.toString(buf));
	}

	@Ignore
	@Test
	public void testIsDirectory() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFileTarHeader() {
		
		File file = new File("testGetFileTarHeader.txt");
		
		try {
			testTarEntry.getFileTarHeader(testTarHeader, file);
		} catch (InvalidHeaderException e) {
			e.printStackTrace();
		}
		
		assertEquals(testTarEntry.file, file);
		

		String name = file.getPath();
		String osname = System.getProperty( "os.name" );
		if ( osname != null )
		{
			String win32Prefix = "windows";
			if ( osname.toLowerCase().startsWith( win32Prefix ) )
			{
				if ( name.length() > 2 )
				{
					char ch1 = name.charAt(0);
					char ch2 = name.charAt(1);
					if ( ch2 == ':'
						&& ( (ch1 >= 'a' && ch1 <= 'z')
							|| (ch1 >= 'A' && ch1 <= 'Z') ) )
					{
						name = name.substring( 2 );
					}
				}
			}
		}

		name = name.replace( File.separatorChar, '/' );

		while (name.startsWith( "/" ))
			name = name.substring( 1 );
 		
 		assertEquals(new StringBuilder( "" ).toString(), testTarEntry.header.getLinkName().toString());

		if ( file.isDirectory() )
		{
			assertEquals(040755, testTarEntry.header.getMode());
			assertEquals(TarHeader.LF_DIR, testTarEntry.header.getLinkFlag());
			if ( testTarEntry.header.getName().charAt( testTarEntry.header.getName().length() - 1 ) != '/' )
			{
				assertTrue(testTarEntry.header.getName().endsWith("/"));
	 			assertEquals(new StringBuilder( name ).append("/").toString(), testTarEntry.header.getName());
			}
			else
			{
				assertEquals(new StringBuilder( name ).toString(), testTarEntry.header.getName());
			}
		}
		else
		{
			assertEquals(0100644, testTarEntry.header.getMode());
			assertEquals(TarHeader.LF_NORMAL, testTarEntry.header.getLinkFlag());
		}

		assertEquals(file.length(), testTarEntry.header.getSize());
		assertEquals(0, testTarEntry.header.getCheckSum());
		assertEquals(0, testTarEntry.header.getDevMajor());
		assertEquals(0, testTarEntry.header.getDevMinor());
	}

	@Ignore
	@Test
	public void testGetDirectoryEntries() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testComputeCheckSum() {
		fail("Not yet implemented");
	}

	@Test
	public void testWriteEntryHeader() {
		
		byte[] buf = new byte[345];
		
		testTarEntry.header = testTarHeader;
		
		testTarEntry.writeEntryHeader(buf);
		
		byte[] bufToCompare = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 32, 32, 32, 32, 32, 48, 32, 0, 32, 32, 32, 32, 32, 48, 32, 0, 32, 32, 32, 32, 32, 48, 32, 0, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 48, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 48, 32, 32, 32, 54, 52, 49, 50, 0, 32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 117, 115, 116, 97, 114, 0, 0, 0, 101, 109, 109, 97, 107, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 32, 32, 32, 32, 32, 48, 32, 0, 32, 32, 32, 32, 32, 48, 32, 0};
		
		assertEquals(Arrays.toString(bufToCompare), Arrays.toString(buf));
	}

	@Ignore
	@Test
	public void testParseTarHeader() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testNameTarHeader() {
		fail("Not yet implemented");
	}

}

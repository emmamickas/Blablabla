package p2;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Arrays;
import java.util.Date;

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

	@Test
	public void testSetName() {
		testTarEntry.getHeader().setName(new StringBuilder("Hello"));
		
		assertTrue(testTarEntry.getHeader().getName().equals("Hello"));
	}

	@Ignore
	@Test
	public void testGetUserId() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetUserId() {
		testTarEntry.getHeader().setUserId(10);
		
		assertEquals(10, testTarEntry.getHeader().getUserId());
	}

	@Ignore
	@Test
	public void testGetGroupId() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetGroupId() {
		testTarEntry.getHeader().setGroupId(10);
		
		assertEquals(10, testTarEntry.getHeader().getGroupId());
	}

	@Ignore
	@Test
	public void testGetUserName() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetUserName() {
		testTarEntry.getHeader().setUserName(new StringBuilder("Hello"));
		
		assertTrue(testTarEntry.getHeader().getUserName().toString().equals("Hello"));
	}
	
	@Ignore
	@Test
	public void testGetGroupName() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetGroupName() {
		testTarEntry.getHeader().setGroupName(new StringBuilder("Hello"));
		
		assertTrue(testTarEntry.getHeader().getGroupName().toString().equals("Hello"));
	}

	@Test
	public void testSetIds() {
		testTarEntry.getHeader().setIds(10, 20);
		
		assertEquals(10, testTarEntry.getHeader().getUserId());
		
		assertEquals(20, testTarEntry.getHeader().getGroupId());
	}

	@Test
	public void testSetNames() {
		testTarEntry.getHeader().setNames("Hello", "How are you?");
		
		assertTrue(testTarEntry.getHeader().getUserName().toString().equals("Hello"));
		
		assertTrue(testTarEntry.getHeader().getGroupName().toString().equals("How are you?"));
	}

	@Test
	public void testSetModTimeLong() {
		testTarEntry.getHeader().setModTime(10);
		
		assertEquals(10, testTarEntry.getHeader().getModTime());
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
		testTarEntry.getHeader().setSize(10);
		
		assertEquals(10, testTarEntry.getHeader().getSize());
	}

	@Test
	public void testIsDirectory() {
		assertFalse(testTarEntry.isDirectory());
		
		File file = new File("C:\\Users\\emmak\\Desktop\\Fall2021\\CptS581\\FinalExam\\Blablabla\\CptS581-FinalExam\\src\\p2\\testFile.TXT");
		
		try {
			testTarEntry.getFileTarHeader(testTarHeader, file);
		} catch (InvalidHeaderException e) {
			e.printStackTrace();
		}
		
		assertFalse(testTarEntry.isDirectory());
		
		file = new File("C:\\Users\\emmak\\Desktop\\Fall2021\\CptS581\\FinalExam\\Blablabla\\CptS581-FinalExam\\src\\p2\\testFolder");
		
		try {
			testTarEntry.getFileTarHeader(testTarHeader, file);
		} catch (InvalidHeaderException e) {
			e.printStackTrace();
		}
		
		assertTrue(testTarEntry.isDirectory());
	}

	@Test
	public void testGetFileTarHeader() {
		
		File file = new File("C:\\Users\\emmak\\Desktop\\Fall2021\\CptS581\\FinalExam\\Blablabla\\CptS581-FinalExam\\src\\p2\\testFile.TXT");
		
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

}

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

public class TarHeaderTest {
	
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

	@Test
	public void testTarHeader() {
		
		assertEquals(100, TarHeader.NAMELEN);

		assertEquals(8, TarHeader.MODELEN);

		assertEquals(8, TarHeader.UIDLEN);

		assertEquals(8, TarHeader.GIDLEN);

		assertEquals(8, TarHeader.CHKSUMLEN);

		assertEquals(12, TarHeader.SIZELEN);

		assertEquals(8, TarHeader.MAGICLEN);

		assertEquals(12, TarHeader.MODTIMELEN);

		assertEquals(32, TarHeader.UNAMELEN);

		assertEquals(32, TarHeader.GNAMELEN);

		assertEquals(8, TarHeader.DEVLEN);
		
		assertEquals(0, TarHeader.LF_OLDNORM);
		
		assertEquals((byte) '0', TarHeader.LF_NORMAL);
		
		assertEquals((byte) '1', TarHeader.LF_LINK);
		
		assertEquals((byte) '2', TarHeader.LF_SYMLINK);
		
		assertEquals((byte) '3', TarHeader.LF_CHR);
		
		assertEquals((byte) '4', TarHeader.LF_BLK);
		
		assertEquals((byte) '5', TarHeader.LF_DIR);
		
		assertEquals((byte) '6', TarHeader.LF_FIFO);
		
		assertEquals((byte) '7', TarHeader.LF_CONTIG);
		
		assertEquals("ustar", TarHeader.TMAGIC);
		
		assertEquals("ustar  ", TarHeader.GNU_TMAGIC);
		
		assertEquals(new StringBuilder(TarHeader.TMAGIC).toString(), testTarHeader.getMagic().toString());
		
		assertEquals(new StringBuilder().toString(), testTarHeader.name.toString());
		
		assertEquals(new StringBuilder().toString(), testTarHeader.getLinkName().toString());
		
		String user =
				System.getProperty( "user.name", "" );

			if ( user.length() > 31 )
				user = user.substring( 0, 31 );
		
		assertEquals(new StringBuilder(user).toString(), testTarHeader.getUserName().toString());
		
		assertEquals(new StringBuilder("").toString(), testTarHeader.getGroupName().toString());
	}

	@Ignore
	@Test
	public void testClone() {
		TarHeader testTarHeaderClone = (TarHeader) testTarHeader.clone();
		
		assertEquals(testTarHeader.getMagic().toString(), testTarHeaderClone.getMagic().toString());
		
		assertEquals(testTarHeader.name.toString(), testTarHeaderClone.name.toString());
		
		assertEquals(testTarHeader.getLinkName().toString(), testTarHeaderClone.getLinkName().toString());
		
		assertEquals(testTarHeader.getUserName().toString(), testTarHeaderClone.getUserName().toString());
		
		assertEquals(testTarHeader.getGroupName().toString(), testTarHeaderClone.getGroupName().toString());
	}

	@Test
	public void testSetName() {
		
	}

	@Test
	public void testGetName() {
		
		assertEquals(new StringBuilder().toString(), testTarHeader.getName());
	}

	@Test
	public void testMode() {
		testTarHeader.setMode(5);
		
		assertEquals(5, testTarHeader.getMode());
		
		testTarHeader.setMode(-1);
		
		assertEquals(-1, testTarHeader.getMode());
		
		testTarHeader.setMode(100);
		
		assertEquals(100, testTarHeader.getMode());
	}

	@Test
	public void testUserId() {

		testTarHeader.setUserId(5);
		
		assertEquals(5, testTarHeader.getUserId());
		
		testTarHeader.setUserId(-1);
		
		assertEquals(-1, testTarHeader.getUserId());
		
		testTarHeader.setUserId(100);
		
		assertEquals(100, testTarHeader.getUserId());
	}

	@Test
	public void testGroupId() {

		testTarHeader.setGroupId(5);
		
		assertEquals(5, testTarHeader.getGroupId());
		
		testTarHeader.setGroupId(-1);
		
		assertEquals(-1, testTarHeader.getGroupId());
		
		testTarHeader.setGroupId(100);
		
		assertEquals(100, testTarHeader.getGroupId());
	}

	@Test
	public void testSize() {

		testTarHeader.setSize(5);
		
		assertEquals(5, testTarHeader.getSize());
		
		testTarHeader.setSize(-1);
		
		assertEquals(-1, testTarHeader.getSize());
		
		testTarHeader.setSize(100);
		
		assertEquals(100, testTarHeader.getSize());
	}
	
	@Test
	public void testModTime() {

		testTarHeader.setModTime(5);
		
		assertEquals(5, testTarHeader.getModTime());
		
		testTarHeader.setModTime(-1);
		
		assertEquals(-1, testTarHeader.getModTime());
		
		testTarHeader.setModTime(100);
		
		assertEquals(100, testTarHeader.getModTime());
	}

	@Test
	public void testCheckSum() {

		testTarHeader.setCheckSum(5);
		
		assertEquals(5, testTarHeader.getCheckSum());
		
		testTarHeader.setCheckSum(-1);
		
		assertEquals(-1, testTarHeader.getCheckSum());
		
		testTarHeader.setCheckSum(100);
		
		assertEquals(100, testTarHeader.getCheckSum());
	}

	@Test
	public void testLinkFlag() {

		testTarHeader.setLinkFlag((byte) 5);
		
		assertEquals(5, testTarHeader.getLinkFlag());
		
		testTarHeader.setLinkFlag((byte) -1);
		
		assertEquals(-1, testTarHeader.getLinkFlag());
		
		testTarHeader.setLinkFlag((byte) 100);
		
		assertEquals(100, testTarHeader.getLinkFlag());
	}

	@Test
	public void testLinkName() {

		testTarHeader.setLinkName(new StringBuilder("Test1"));
		
		assertEquals(new StringBuilder("Test1").toString(), testTarHeader.getLinkName().toString());
		
		testTarHeader.setLinkName(new StringBuilder("Test2"));
		
		assertEquals(new StringBuilder("Test2").toString(), testTarHeader.getLinkName().toString());
		
		testTarHeader.setLinkName(new StringBuilder("Test3"));
		
		assertEquals(new StringBuilder("Test3").toString(), testTarHeader.getLinkName().toString());
	}

	@Test
	public void testMagic() {

		testTarHeader.setMagic(new StringBuilder("Test1"));
		
		assertEquals(new StringBuilder("Test1").toString(), testTarHeader.getMagic().toString());
		
		testTarHeader.setMagic(new StringBuilder("Test2"));
		
		assertEquals(new StringBuilder("Test2").toString(), testTarHeader.getMagic().toString());
		
		testTarHeader.setMagic(new StringBuilder("Test3"));
		
		assertEquals(new StringBuilder("Test3").toString(), testTarHeader.getMagic().toString());
	}

	@Test
	public void testUserName() {

		testTarHeader.setUserName(new StringBuilder("Test1"));
		
		assertEquals(new StringBuilder("Test1").toString(), testTarHeader.getUserName().toString());
		
		testTarHeader.setUserName(new StringBuilder("Test2"));
		
		assertEquals(new StringBuilder("Test2").toString(), testTarHeader.getUserName().toString());
		
		testTarHeader.setUserName(new StringBuilder("Test3"));
		
		assertEquals(new StringBuilder("Test3").toString(), testTarHeader.getUserName().toString());
	}

	@Test
	public void testGroupName() {

		testTarHeader.setGroupName(new StringBuilder("Test1"));
		
		assertEquals(new StringBuilder("Test1").toString(), testTarHeader.getGroupName().toString());
		
		testTarHeader.setGroupName(new StringBuilder("Test2"));
		
		assertEquals(new StringBuilder("Test2").toString(), testTarHeader.getGroupName().toString());
		
		testTarHeader.setGroupName(new StringBuilder("Test3"));
		
		assertEquals(new StringBuilder("Test3").toString(), testTarHeader.getGroupName().toString());
	}

	@Test
	public void testDevMajor() {

		testTarHeader.setDevMajor(5);
		
		assertEquals(5, testTarHeader.getDevMajor());
		
		testTarHeader.setDevMajor(-1);
		
		assertEquals(-1, testTarHeader.getDevMajor());
		
		testTarHeader.setDevMajor(100);
		
		assertEquals(100, testTarHeader.getDevMajor());
	}

	@Test
	public void testDevMinor() {

		testTarHeader.setDevMinor(5);
		
		assertEquals(5, testTarHeader.getDevMinor());
		
		testTarHeader.setDevMinor(-1);
		
		assertEquals(-1, testTarHeader.getDevMinor());
		
		testTarHeader.setDevMinor(100);
		
		assertEquals(100, testTarHeader.getDevMinor());
	}

	@Test
	public void testParseTarHeader() {
		
		TarHeader hdr = new TarHeader();
		
		byte[] header = new byte[345];
		
		testTarHeader.writeEntryHeader(header);

		try {
			hdr.parseTarHeader(header);
		} catch (InvalidHeaderException e) {
			e.printStackTrace();
		}
		
		assertTrue(hdr.getName().equals(testTarHeader.getName()));
		
		assertEquals(hdr.getSize(), testTarHeader.getSize());
	}

	@Test
	public void testAdjustEntryName() {

		byte[] buf = new byte[100];
		
		TarParser.adjustEntryName(buf, "NewName");

		byte[] bufToCompare = {78, 101, 119, 78, 97, 109, 101, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		
		assertEquals(Arrays.toString(bufToCompare), Arrays.toString(buf));
		
		TarParser.adjustEntryName(buf, "AnotherNewName");

		byte[] bufToCompare2 = {65, 110, 111, 116, 104, 101, 114, 78, 101, 119, 78, 97, 109, 101, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		
		assertEquals(Arrays.toString(bufToCompare2), Arrays.toString(buf));
	}

	@Test
	public void testGetOctalBytes() {
		
		byte[] buf = new byte[345];
		
		testTarEntry.header = testTarHeader;
		
		int offset = 0;

		offset = TarParser.getNameBytes
			( testTarHeader.name, buf, offset, TarHeader.NAMELEN );

		offset = TarParser.getOctalBytes
			( testTarHeader.getMode(), buf, offset, TarHeader.MODELEN );

		offset = TarParser.getOctalBytes
			( testTarHeader.getUserId(), buf, offset, TarHeader.UIDLEN );

		offset = TarParser.getOctalBytes
			( testTarHeader.getGroupId(), buf, offset, TarHeader.GIDLEN );

		long size = testTarHeader.getSize();

		offset = TarParser.getLongOctalBytes
			( size, buf, offset, TarHeader.SIZELEN );

		offset = TarParser.getLongOctalBytes
			( testTarHeader.getModTime(), buf, offset, TarHeader.MODTIMELEN );

		int csOffset = offset;
		for ( int c = 0 ; c < TarHeader.CHKSUMLEN ; ++c )
			buf[ offset++ ] = (byte) ' ';

		buf[ offset++ ] = testTarHeader.getLinkFlag();

		offset = TarParser.getNameBytes
			( testTarHeader.getLinkName(), buf, offset, TarHeader.NAMELEN );

		offset = TarParser.getNameBytes
			( testTarHeader.getMagic(), buf, offset, TarHeader.MAGICLEN );

		offset = TarParser.getNameBytes
			( testTarHeader.getUserName(), buf, offset, TarHeader.UNAMELEN );

		offset = TarParser.getNameBytes
			( testTarHeader.getGroupName(), buf, offset, TarHeader.GNAMELEN );

		offset = TarParser.getOctalBytes
			( testTarHeader.getDevMajor(), buf, offset, TarHeader.DEVLEN );

		offset = TarParser.getOctalBytes
			( testTarHeader.getDevMinor(), buf, offset, TarHeader.DEVLEN );

		while (offset < buf.length)
			buf[ offset++ ] = 0;

		long checkSum = TarParser.computeCheckSum( buf );

		TarParser.getCheckSumOctalBytes
			( checkSum, buf, csOffset, TarHeader.CHKSUMLEN );
		
		byte[] bufToCompare = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 32, 32, 32, 32, 32, 48, 32, 0, 32, 32, 32, 32, 32, 48, 32, 0, 32, 32, 32, 32, 32, 48, 32, 0, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 48, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 48, 32, 32, 32, 54, 52, 49, 50, 0, 32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 117, 115, 116, 97, 114, 0, 0, 0, 101, 109, 109, 97, 107, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 32, 32, 32, 32, 32, 48, 32, 0, 32, 32, 32, 32, 32, 48, 32, 0};
		
		assertEquals(Arrays.toString(bufToCompare), Arrays.toString(buf));
	}

	@Test
	public void testNameTarHeader() {
		
		TarHeader hdr = new TarHeader();
		
		byte[] header = new byte[345];
		
		testTarHeader.writeEntryHeader(header);

		hdr.nameTarHeader("New header name");
		
		assertTrue(hdr.getName().equals("New header name"));
	}

	@Test
	public void testWriteEntryHeader() {
		
		byte[] buf = new byte[345];
		
		testTarEntry.header = testTarHeader;
		
		testTarEntry.getHeader().writeEntryHeader(buf);
		
		byte[] bufToCompare = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 32, 32, 32, 32, 32, 48, 32, 0, 32, 32, 32, 32, 32, 48, 32, 0, 32, 32, 32, 32, 32, 48, 32, 0, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 48, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 48, 32, 32, 32, 54, 52, 49, 50, 0, 32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 117, 115, 116, 97, 114, 0, 0, 0, 101, 109, 109, 97, 107, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 32, 32, 32, 32, 32, 48, 32, 0, 32, 32, 32, 32, 32, 48, 32, 0};
		
		assertEquals(Arrays.toString(bufToCompare), Arrays.toString(buf));
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
	}

}

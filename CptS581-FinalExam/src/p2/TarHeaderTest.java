package p2;

import static org.junit.Assert.*;

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
		
		assertEquals(new StringBuffer(TarHeader.TMAGIC).toString(), testTarHeader.magic.toString());
		
		assertEquals(new StringBuffer().toString(), testTarHeader.name.toString());
		
		assertEquals(new StringBuffer().toString(), testTarHeader.linkName.toString());
		
		String user =
				System.getProperty( "user.name", "" );

			if ( user.length() > 31 )
				user = user.substring( 0, 31 );
		
		assertEquals(new StringBuffer(user).toString(), testTarHeader.userName.toString());
		
		assertEquals(new StringBuffer("").toString(), testTarHeader.groupName.toString());
	}

	@Ignore
	@Test
	public void testClone() {
		TarHeader testTarHeaderClone = (TarHeader) testTarHeader.clone();
		
		assertEquals(testTarHeader.magic.toString(), testTarHeaderClone.magic.toString());
		
		assertEquals(testTarHeader.name.toString(), testTarHeaderClone.name.toString());
		
		assertEquals(testTarHeader.linkName.toString(), testTarHeaderClone.linkName.toString());
		
		assertEquals(testTarHeader.userName.toString(), testTarHeaderClone.userName.toString());
		
		assertEquals(testTarHeader.groupName.toString(), testTarHeaderClone.groupName.toString());
	}

	@Test
	public void testSetName() {
		
	}

	@Test
	public void testGetName() {
		
		assertEquals(new StringBuffer().toString(), testTarHeader.getName());
	}

	@Test
	public void testMode() {
		testTarHeader.mode = 5;
		
		assertEquals(5, testTarHeader.mode);
		
		testTarHeader.mode = -1;
		
		assertEquals(-1, testTarHeader.mode);
		
		testTarHeader.mode = 100;
		
		assertEquals(100, testTarHeader.mode);
	}

	@Test
	public void testUserId() {

		testTarHeader.userId = 5;
		
		assertEquals(5, testTarHeader.userId);
		
		testTarHeader.userId = -1;
		
		assertEquals(-1, testTarHeader.userId);
		
		testTarHeader.userId = 100;
		
		assertEquals(100, testTarHeader.userId);
	}

	@Test
	public void testGroupId() {

		testTarHeader.groupId = 5;
		
		assertEquals(5, testTarHeader.groupId);
		
		testTarHeader.groupId = -1;
		
		assertEquals(-1, testTarHeader.groupId);
		
		testTarHeader.groupId = 100;
		
		assertEquals(100, testTarHeader.groupId);
	}

	@Test
	public void testSize() {

		testTarHeader.size = 5;
		
		assertEquals(5, testTarHeader.size);
		
		testTarHeader.size = -1;
		
		assertEquals(-1, testTarHeader.size);
		
		testTarHeader.size = 100;
		
		assertEquals(100, testTarHeader.size);
	}
	
	@Test
	public void testModTime() {

		testTarHeader.modTime = 5;
		
		assertEquals(5, testTarHeader.modTime);
		
		testTarHeader.modTime = -1;
		
		assertEquals(-1, testTarHeader.modTime);
		
		testTarHeader.modTime = 100;
		
		assertEquals(100, testTarHeader.modTime);
	}

	@Test
	public void testCheckSum() {

		testTarHeader.checkSum = 5;
		
		assertEquals(5, testTarHeader.checkSum);
		
		testTarHeader.checkSum = -1;
		
		assertEquals(-1, testTarHeader.checkSum);
		
		testTarHeader.checkSum = 100;
		
		assertEquals(100, testTarHeader.checkSum);
	}

	@Test
	public void testLinkFlag() {

		testTarHeader.linkFlag = 5;
		
		assertEquals(5, testTarHeader.linkFlag);
		
		testTarHeader.linkFlag = -1;
		
		assertEquals(-1, testTarHeader.linkFlag);
		
		testTarHeader.linkFlag = 100;
		
		assertEquals(100, testTarHeader.linkFlag);
	}

	@Test
	public void testLinkName() {

		testTarHeader.linkName = new StringBuffer("Test1");
		
		assertEquals(new StringBuffer("Test1").toString(), testTarHeader.linkName.toString());
		
		testTarHeader.linkName = new StringBuffer("Test2");
		
		assertEquals(new StringBuffer("Test2").toString(), testTarHeader.linkName.toString());
		
		testTarHeader.linkName = new StringBuffer("Test3");
		
		assertEquals(new StringBuffer("Test3").toString(), testTarHeader.linkName.toString());
	}

	@Test
	public void testMagic() {

		testTarHeader.magic = new StringBuffer("Test1");
		
		assertEquals(new StringBuffer("Test1").toString(), testTarHeader.magic.toString());
		
		testTarHeader.magic = new StringBuffer("Test2");
		
		assertEquals(new StringBuffer("Test2").toString(), testTarHeader.magic.toString());
		
		testTarHeader.magic = new StringBuffer("Test3");
		
		assertEquals(new StringBuffer("Test3").toString(), testTarHeader.magic.toString());
	}

	@Test
	public void testUserName() {

		testTarHeader.userName = new StringBuffer("Test1");
		
		assertEquals(new StringBuffer("Test1").toString(), testTarHeader.userName.toString());
		
		testTarHeader.userName = new StringBuffer("Test2");
		
		assertEquals(new StringBuffer("Test2").toString(), testTarHeader.userName.toString());
		
		testTarHeader.userName = new StringBuffer("Test3");
		
		assertEquals(new StringBuffer("Test3").toString(), testTarHeader.userName.toString());
	}

	@Test
	public void testGroupName() {

		testTarHeader.groupName = new StringBuffer("Test1");
		
		assertEquals(new StringBuffer("Test1").toString(), testTarHeader.groupName.toString());
		
		testTarHeader.groupName = new StringBuffer("Test2");
		
		assertEquals(new StringBuffer("Test2").toString(), testTarHeader.groupName.toString());
		
		testTarHeader.groupName = new StringBuffer("Test3");
		
		assertEquals(new StringBuffer("Test3").toString(), testTarHeader.groupName.toString());
	}

	@Test
	public void testDevMajor() {

		testTarHeader.devMajor = 5;
		
		assertEquals(5, testTarHeader.devMajor);
		
		testTarHeader.devMajor = -1;
		
		assertEquals(-1, testTarHeader.devMajor);
		
		testTarHeader.devMajor = 100;
		
		assertEquals(100, testTarHeader.devMajor);
	}

	@Test
	public void testDevMinor() {

		testTarHeader.devMinor = 5;
		
		assertEquals(5, testTarHeader.devMinor);
		
		testTarHeader.devMinor = -1;
		
		assertEquals(-1, testTarHeader.devMinor);
		
		testTarHeader.devMinor = 100;
		
		assertEquals(100, testTarHeader.devMinor);
	}

	@Ignore
	@Test
	public void testParseOctal() {
		
		byte[] buf = new byte[345];
		
		testTarEntry.header = testTarHeader;
		
		testTarEntry.writeEntryHeader(buf);
		
		//System.out.print(Arrays.toString(buf));
		
		try {
			assertEquals(345, TarHeader.parseOctal(buf, 0, 345));
		} catch (InvalidHeaderException e) {
			e.printStackTrace();
		}
	}

	@Ignore
	@Test
	public void testParseName() {
		fail("Not yet implemented");
	}
	
	@Ignore
	@Test
	public void testGetNameBytes() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testGetOctalBytes() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testGetLongOctalBytes() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testGetCheckSumOctalBytes() {
		fail("Not yet implemented");
	}

}

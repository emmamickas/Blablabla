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
		
		assertEquals(new StringBuffer(TarHeader.TMAGIC).toString(), testTarHeader.getMagic().toString());
		
		assertEquals(new StringBuffer().toString(), testTarHeader.name.toString());
		
		assertEquals(new StringBuffer().toString(), testTarHeader.getLinkName().toString());
		
		String user =
				System.getProperty( "user.name", "" );

			if ( user.length() > 31 )
				user = user.substring( 0, 31 );
		
		assertEquals(new StringBuffer(user).toString(), testTarHeader.getUserName().toString());
		
		assertEquals(new StringBuffer("").toString(), testTarHeader.getGroupName().toString());
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
		
		assertEquals(new StringBuffer().toString(), testTarHeader.getName());
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

		testTarHeader.setLinkName(new StringBuffer("Test1"));
		
		assertEquals(new StringBuffer("Test1").toString(), testTarHeader.getLinkName().toString());
		
		testTarHeader.setLinkName(new StringBuffer("Test2"));
		
		assertEquals(new StringBuffer("Test2").toString(), testTarHeader.getLinkName().toString());
		
		testTarHeader.setLinkName(new StringBuffer("Test3"));
		
		assertEquals(new StringBuffer("Test3").toString(), testTarHeader.getLinkName().toString());
	}

	@Test
	public void testMagic() {

		testTarHeader.setMagic(new StringBuffer("Test1"));
		
		assertEquals(new StringBuffer("Test1").toString(), testTarHeader.getMagic().toString());
		
		testTarHeader.setMagic(new StringBuffer("Test2"));
		
		assertEquals(new StringBuffer("Test2").toString(), testTarHeader.getMagic().toString());
		
		testTarHeader.setMagic(new StringBuffer("Test3"));
		
		assertEquals(new StringBuffer("Test3").toString(), testTarHeader.getMagic().toString());
	}

	@Test
	public void testUserName() {

		testTarHeader.setUserName(new StringBuffer("Test1"));
		
		assertEquals(new StringBuffer("Test1").toString(), testTarHeader.getUserName().toString());
		
		testTarHeader.setUserName(new StringBuffer("Test2"));
		
		assertEquals(new StringBuffer("Test2").toString(), testTarHeader.getUserName().toString());
		
		testTarHeader.setUserName(new StringBuffer("Test3"));
		
		assertEquals(new StringBuffer("Test3").toString(), testTarHeader.getUserName().toString());
	}

	@Test
	public void testGroupName() {

		testTarHeader.setGroupName(new StringBuffer("Test1"));
		
		assertEquals(new StringBuffer("Test1").toString(), testTarHeader.getGroupName().toString());
		
		testTarHeader.setGroupName(new StringBuffer("Test2"));
		
		assertEquals(new StringBuffer("Test2").toString(), testTarHeader.getGroupName().toString());
		
		testTarHeader.setGroupName(new StringBuffer("Test3"));
		
		assertEquals(new StringBuffer("Test3").toString(), testTarHeader.getGroupName().toString());
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

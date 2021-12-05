package p3;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.apache.tools.ant.types.Resource;
import org.apache.tools.ant.types.ResourceCollection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import p1.UndoManager;

public class JarTest {
	
	static Jar testJar;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		   // There is nothing necessary to this class requiring setup before the class
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		testJar = null;
	}

	@Before
	public void setUp() throws Exception {
		testJar = new Jar();
	}

	@After
	public void tearDown() throws Exception {
		   // There is nothing necessary to this class requiring tear down after each individual test
	}

	@Ignore
	@Test
	public void testGrabManifests() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testGetProject() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testGrabNonFileSetResources() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testGrabResources() {
		fail("Not yet implemented");
	}

}

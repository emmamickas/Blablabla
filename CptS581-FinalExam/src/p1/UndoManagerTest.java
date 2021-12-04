package p1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class UndoManagerTest {
	
	static UndoManager testUndoManager;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		   // There is nothing necessary to this class requiring setup before the class
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		testUndoManager = null;
	}

	@Before
	public void setUp() throws Exception {
		testUndoManager = new UndoManager(5);
	}

	@After
	public void tearDown() throws Exception {
		   // There is nothing necessary to this class requiring tear down after each individual test
	}

	@Ignore
	@Test
	public void testUndoManager() {
		testUndoManager = new UndoManager(3);
		
		assertEquals(3, testUndoManager.getUndoSize());
		
		assertEquals(3, testUndoManager.getRedoSize());

		testUndoManager = new UndoManager(10);
		
		assertEquals(10, testUndoManager.getUndoSize());
		
		assertEquals(10, testUndoManager.getRedoSize());
	}

	@Ignore
	@Test
	public void testUndoManagerInt() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testPushUndo() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testPushRedo() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testIsUndoable() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testIsRedoable() {
		fail("Not yet implemented");
	}

	@Test
	public void testPeekUndo() {
		assertEquals(null, testUndoManager.peekUndo());
	}

	@Test
	public void testPeekRedo() {
		assertEquals(null, testUndoManager.peekRedo());
	}

	@Ignore
	@Test
	public void testGetUndoSize() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testGetRedoSize() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testPopUndo() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testPopRedo() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testClearUndos() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testClearRedos() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testClearStack() {
		fail("Not yet implemented");
	}

}

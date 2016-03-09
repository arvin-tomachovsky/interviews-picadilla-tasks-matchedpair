package task.matchedpair;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import daniel.fryze.picadilla.interview.matchedpairs.MatchedPair;

/**
 * Test class for testing {@linkplain MatchedPair} algorithm class. It contains only the test cases
 * with input argument values which do follow validation rules defined in algorithm description.
 * 
 * @author daniel.fryze
 */
public class MatchedPairInputValidTest {

	/** The real algorithm class with optimal solution which is being tested. */
	private MatchedPair testedAlgorithm;

	@Before
	public void initAlgorithmComponents() {
		testedAlgorithm = new MatchedPair();
	}

	// Test cases which follow the validation rules for input arguments

	/**
	 * Input description: the values from exactly the limitation function only
	 * Expected result: (calculated value), no exception thrown
	 */
	@Test
	public void testInputValuesOnTheLimitFunctionOnly() {
		Assert.assertEquals(testedAlgorithm.matchedPair(
			new int[] { 1, 3 }, new int[] { 500000, 0 }, true), 1);
		Assert.assertEquals(testedAlgorithm.matchedPair(
			new int[] { 1, 5 }, new int[] { 250000, 0 }, true), 1);
		Assert.assertEquals(testedAlgorithm.matchedPair(
			new int[] { 1, 17 }, new int[] { 62500, 0 }, true), 1);
	}

	/**
	 * Input description: the values from above the limitation function space only
	 * Expected result: (calculated value), no exception thrown
	 */
	@Test
	public void testInputValuesAboveTheLimitFuntionOnly() {
		Assert.assertEquals(testedAlgorithm.matchedPair(
			new int[] { 2, 3, 3, 5, 7, 10, 12 }, new int[] { 0, 1000, 250000, 25000, 10, 150, 750000 }, true), 21);
		Assert.assertEquals(testedAlgorithm.matchedPair(
			new int[] { 2, 3, 13, 15, 27, 30, 32, 54, 71 }, new int[] { 0, 1000, 370000, 28000, 1025, 1505, 650000, 0, 10 }, true), 36);
		Assert.assertEquals(testedAlgorithm.matchedPair(
			new int[] { 100, 101, 102, 103, 104 }, new int[] { 0, 10, 100, 1000, 10000 }, true), 10);
		Assert.assertEquals(testedAlgorithm.matchedPair(
			new int[] { 100, 100, 100, 100 }, new int[] { 10, 10, 10, 10 }, true), 6);
		Assert.assertEquals(testedAlgorithm.matchedPair(
			new int[] { 200, 200, 200, 200 }, new int[] { 0, 0, 0, 0 }, true), 6);
	}

	/**
	 * Input description: the big numbers only (values close to upper boundary)
	 * Expected result: (calculated value), no exception thrown
	 */
	@Test
	public void testInputValuesBigNumbers() {
		Assert.assertEquals(testedAlgorithm.matchedPair(
			new int[] { 1000, 1000, 1000 }, new int[] { 0, 0, 0 }, true), 3);
		Assert.assertEquals(testedAlgorithm.matchedPair(
			new int[] { 1000, 1000, 1000 }, new int[] { 999999, 999999, 999999 }, true), 3);
	}

	/**
	 * Input description: the values from between zero (excluding) and one (including) only
	 * Expected result: (calculated value), no exception thrown
	 */
	@Test
	public void testInputValuesBelowOneOnly() {
		Assert.assertEquals(testedAlgorithm.matchedPair(
			new int[] { 0, 0, 0, 0, 0 }, new int[] { 1, 1, 15, 300, 5000 }, true), 0);
		Assert.assertEquals(testedAlgorithm.matchedPair(
			new int[] { 0, 0, 0 }, new int[] { 10, 10, 10 }, true), 0);
		Assert.assertEquals(testedAlgorithm.matchedPair(
			new int[] { 0, 0, 0 }, new int[] { 1, 500000, 999999 }, true), 0);
		System.out.println(
			testedAlgorithm.matchedPair(
					new int[] { 0, 1, 1, 1, 3, 4, 5, 6 }, new int[] { 700000, 0, 400000, 700000, 100000, 0, 500000, 600000 }));
	}

	/**
	 * Input description: the values equal to zero only
	 * Expected result: (calculated value), no exception thrown
	 */
	@Test
	public void testInputValuesEqualToZeroOnly() {
		Assert.assertEquals(testedAlgorithm.matchedPair(
			new int[] { 0, 0 }, new int[] { 0, 0 }, true), 1);
		Assert.assertEquals(testedAlgorithm.matchedPair(
			new int[] { 0, 0, 0 }, new int[] { 0, 0, 0 }, true), 3);
		Assert.assertEquals(testedAlgorithm.matchedPair(
			new int[] { 0, 0, 0, 0, 0 }, new int[] { 0, 0, 0, 0, 0 }, true), 10);
	}

	/**
	 * Input description: the values from the whole possible range without duplicates
	 * Expected result: (calculated value), no exception thrown
	 */
	@Test
	public void testInputValuesFromWholeRange() {
		Assert.assertEquals(testedAlgorithm.matchedPair(
			new int[] { 0, 0, 0, 0, 0, 1, 1, 2, 2, 2, 7, 11, 12, 12 }, 
			new int[] { 0, 0, 10, 10, 1000, 0, 2000, 50000, 75000, 100, 2000, 250, 0, 10 }, true), 22);
		Assert.assertEquals(testedAlgorithm.matchedPair(
			new int[] { 0, 0, 3, 3, 5, 7, 11, 15, 20, 21 }, 
			new int[] { 0, 0, 10, 100, 1000, 0, 2000, 50000, 75000, 100 }, true), 29);
		Assert.assertEquals(testedAlgorithm.matchedPair(
			new int[] { 0, 0, 7, 7, 9, 11, 11 }, 
			new int[] { 10, 1000, 1500, 2000, 1000, 0, 100 }, true), 10);
	}

	/**
	 * Input description: the values from the whole possible range with duplicates
	 * Expected result: (calculated value), no exception thrown
	 */
	@Test
	public void  testInputValuesFromWholeRangeWithDuplicates() {
		Assert.assertEquals(testedAlgorithm.matchedPair(
			new int[] { 0, 0, 0, 0, 0, 1, 1, 2, 2, 2, 7, 11, 12, 12 }, 
			new int[] { 0, 0, 10, 10, 10, 0, 2000, 50000, 50000, 50000, 2000, 250, 10, 10 }, true), 22);
		Assert.assertEquals(testedAlgorithm.matchedPair(
			new int[] { 0, 0, 3, 3, 5, 7, 11, 15, 20, 21, 21, 21, 21 }, 
			new int[] { 0, 0, 100, 100, 1000, 0, 2000, 50000, 75000, 100, 100, 100, 100 }, true), 56);
		Assert.assertEquals(testedAlgorithm.matchedPair(
			new int[] { 0, 0, 7, 7, 9, 11, 11 }, 
			new int[] { 10, 10, 1500, 1500, 1000, 0, 0 }, true), 10);
	}
}
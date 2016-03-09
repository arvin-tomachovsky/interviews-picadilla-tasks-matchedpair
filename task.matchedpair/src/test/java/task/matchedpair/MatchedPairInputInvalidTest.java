package task.matchedpair;

import org.junit.Before;
import org.junit.Test;

import daniel.fryze.picadilla.interview.matchedpairs.MatchedPair;

/**
 * Test class for testing {@linkplain MatchedPair} algorithm class. It contains only the test cases
 * with input argument values which do not follow validation rules defined in algorithm description.
 * 
 * @author daniel.fryze
 */
public class MatchedPairInputInvalidTest {

	/** The real algorithm class with optimal solution which is being tested. */
	private MatchedPair testedAlgorithm;

	@Before
	public void initAlgorithmComponents() {
		testedAlgorithm = new MatchedPair();
	}

	// Test cases which do not follow the validation rules for input arguments

	/**
	 * Input description: <sup>null</sup> value only for the argument with integral parts 
	 * Expected result: {@linkplain IllegalArgumentException} to be thrown
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testNullInputArrayIntegrals() {
		testedAlgorithm.matchedPair(null, new int[] { 1, 2, 3 });
	}

	/**
	 * Input description: <sup>null</sup> value only for the argument with integral parts
	 * Expected result: {@linkplain IllegalArgumentException} to be thrown
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testNullInputArrayFractionals() {
		testedAlgorithm.matchedPair(new int[] { 1, 2, 3 }, null);
	}

	/**
	 * Input description: <sup>null</sup> value only for the argument with fractional parts
	 * Expected result: {@linkplain IllegalArgumentException} to be thrown
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testNullInputArrayBoth() {
		testedAlgorithm.matchedPair(null, new int[] { 1, 2, 3 });
	}

	/**
	 * Input description: <sup>null</sup> value only for both input argument arrays
	 * Expected result: {@linkplain IllegalArgumentException} to be thrown
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testInputArraysWithDifferentLengths() {
		testedAlgorithm.matchedPair(new int[] { 1, 2, 3 }, new int[] { 1, 2 });
	}

	/**
	 * Input description: input argument arrays having different number of elements
	 * Expected result: {@linkplain IllegalArgumentException} to be thrown
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testInputArraysToLong() {
		int[] inputArrayIntegralParts = new int[100001];
		int[] inputArrayFractionalParts = new int[100001];
		testedAlgorithm.matchedPair(inputArrayIntegralParts, inputArrayFractionalParts);
	}

	/**
	 * Input description: input argument array with integral parts contains negative values
	 * Expected result: {@linkplain IllegalArgumentException} to be thrown
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testInputArrayWithIntegralPartsContainsNegativeValues() {
		testedAlgorithm.matchedPair(new int[] { -1, 2, -3 }, new int[] { 1, 2, 3 });
	}

	/**
	 * Input description: input argument array with integral parts contains too big values
	 * Expected result: {@linkplain IllegalArgumentException} to be thrown
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testInputArrayWithIntegralPartsContainsTooBigValues() {
		testedAlgorithm.matchedPair(new int[] { 1, 2, 1001 }, new int[] { 1, 2, 3 });
	}

	/**
	 * Input description: input argument array with fractional parts contains negative values
	 * Expected result: {@linkplain IllegalArgumentException} to be thrown
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testInputArrayWithFractionalPartsContainsNegativeValues() {
		testedAlgorithm.matchedPair(new int[] { 1, 2, 3 }, new int[] { -1, 2, 3 });
	}

	/**
	 * Input description: input argument array with fractional parts contains too big values
	 * Expected result: {@linkplain IllegalArgumentException} to be thrown
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testInputArrayWithFractionalPartsContainsTooBigValues() {
		testedAlgorithm.matchedPair(new int[] { 1, 2, 3 }, new int[] { 1, 2, 1000001 });
	}

	/**
	 * Input description: result array with decimals is not sorted (on integral parts level)
	 * Expected result: {@linkplain IllegalArgumentException} to be thrown
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testInputResultArrayWithDecimalValuesIsNotSortedInIntegrals() {
		testedAlgorithm.matchedPair(new int[] { 3, 2, 1 }, new int[] { 1, 1, 1 });
	}

	/**
	 * Input description: result array with decimals is not sorted (on fractional parts level)
	 * Expected result: {@linkplain IllegalArgumentException} to be thrown
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testInputResultArrayWithDecimalValuesIsNotSortedInFracionals() {
		testedAlgorithm.matchedPair(new int[] { 1, 2, 2 }, new int[] { 1, 1, 0 });
	}
}
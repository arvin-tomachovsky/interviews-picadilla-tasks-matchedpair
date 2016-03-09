package task.matchedpair;

import java.util.Arrays;
import java.util.Random;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import daniel.fryze.picadilla.interview.matchedpairs.MatchedPair;
import daniel.fryze.picadilla.interview.matchedpairs.MatchedPairBruteForce;

/**
 * Test class for testing {@linkplain MatchedPair} algorithm class. It contains a parameterize test
 * case for testing an algorithm with random-input values. Using the parameters we can easily adjust
 * the testing scenario: number of elements in input arrays and number of loops the test case is
 * invoked to our needs.
 * 
 * In this test the 'brute-force' version of the tested algorithm {@linkplain MatchedPairBruteForce}
 * provides us with the 'expected result' for the tested algorithm in the tested scenario for random
 * input values. That's why it's important to set the parameters with such values, so that the
 * 'brute-force' algorithm ends processing in a reasonable time for us.
 * 
 * @author daniel.fryze
 */
public class MatchedPairRandomInputsTest {

	final static Logger logger = Logger.getLogger(MatchedPairInputInvalidTest.class);

	/** The real algorithm class with optimal solution which is being tested. */
	private MatchedPair testedAlgorithm;

	/**
	 * The 'brute-force' version of the tested algorithm - used only in order to verify the
	 * correctness of the result of the real algorithm in random-input values test cases.
	 */
	private MatchedPairBruteForce bruteForceAlgorithm;

	// Parameters for the random-input test cases

	/**
	 * The number of integer elements in input arrays for a test case. If we set this value to
	 * <sup>null</sup> the random number (between 0 and 100000) will be used instead. It's
	 * recommended to set a really reasonable value, so that the 'brute-force' algorithm gives the
	 * result in a reasonable time.
	 */
	private Integer numberOfInputElements = 1000;

	/**
	 * The number of loops we want the algorithm to be invoked with random values. If we set this
	 * value to <sup>null</sup> the random number of loops (between 0 and 100) will be used instead.
	 * It's recommended to set a really reasonable value, so that the 'brute-force' algorithm gives
	 * the result in a reasonable time.
	 */
	private Integer numberOfLoops = 10;

	/** Using this flag we can enable/disable debug info logging - useful for batch of tests. */
	private boolean enableDebugLogging = false;

	@Before
	public void initAlgorithmComponents() {
		testedAlgorithm = new MatchedPair();
		bruteForceAlgorithm = new MatchedPairBruteForce();
	}

	// Test case for random-input arguments - tested by brute-force algorithm alternative

	@Test
	public void testRandomInput() {

		if (numberOfLoops == null) {
			numberOfLoops = new Random().nextInt(100 + 1);
		}

		for (int loop = 0; loop < numberOfLoops; loop++) {

			if (numberOfInputElements == null) {
				numberOfInputElements = new Random().nextInt(100000 + 1);
			}

			if (enableDebugLogging) {
				logger.debug("[" + (loop + 1) + "] invocation - input arguments count: " + numberOfInputElements + ":" );
			}

			int[] integralParts = new int[numberOfInputElements];
			int[] fractionalParts = new int[numberOfInputElements];

			for (int i = 0; i < numberOfInputElements; i++) {
				integralParts[i] = new Random().nextInt(1000 + 1);
			}

			Arrays.sort(integralParts);

			fractionalParts[0] = new Random().nextInt(1000000 + 1);
			for (int i = 1; i < numberOfInputElements; i++) {
				int nextFractionalPart = new Random().nextInt(1000000 + 1);
				if (integralParts[i - 1] == integralParts[i]) {
					while (nextFractionalPart < fractionalParts[i - 1]) {
						nextFractionalPart = new Random().nextInt(1000000 + 1);
					}
				}
				fractionalParts[i] = nextFractionalPart;
			}

			long startTimeOptimal = System.currentTimeMillis();
			long calculatedResult = testedAlgorithm.matchedPair(integralParts, fractionalParts);
			long endTimeOptimal = System.currentTimeMillis();

			long startTimeBruteForce = System.currentTimeMillis();
			long bruteForceResult = bruteForceAlgorithm.matchedPair(integralParts, fractionalParts);
			long endTimeBruteForce = System.currentTimeMillis();

			if (enableDebugLogging) {
				logger.debug(" - expected result (calculated by 'brute-force') = " + bruteForceResult + " [time: " + (endTimeBruteForce - startTimeBruteForce) + " ms]");
				logger.debug(" - algorithm result (calculated by 'solution')   = " + calculatedResult + " [time: " + (endTimeOptimal - startTimeOptimal) + " ms]");
			}

			Assert.assertEquals(calculatedResult, bruteForceResult);
		}
	}
}
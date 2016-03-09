package daniel.fryze.picadilla.interview.matchedpairs;

import java.math.BigDecimal;
import java.math.MathContext;

import daniel.fryze.picadilla.interview.matchedpairs.auxiliary.BigDecimalConverter;
import daniel.fryze.picadilla.interview.matchedpairs.auxiliary.MatchedPairInputValidator;

/**
 * The class which contains the implementation of the algorithm being the subject of the task.
 * 
 * @author daniel.fryze
 */
public class MatchedPair {

	/**
	 * The main method of the algorithm. It validates input arguments based on the rules from
	 * algorithm description. It converts the input values into format desired by the core
	 * functionality of the algorithm and returns the final result calculated by the core algorithm.
	 * See the core algorithm in method: {@link #countMatchedPairs(BigDecimal[])}.
	 * 
	 * @param P the array with integral parts for input values list
	 * @param Q the array with fractional parts (multiplied by 1000000) for input values list
	 * @param args additional optional invocation arguments, used to disable input arguments
	 *            validation, if <sup>args[0] == true</sup> the validation is disabled
	 * @return the result of the algorithm calculation
	 */
	public long matchedPair(int[] P, int[] Q, boolean... args) {
		if (args.length == 0 || args[0] == false) {
			MatchedPairInputValidator.validate(P, Q);
		}
		return countMatchedPairs(BigDecimalConverter.convertToBigDecimals(P, Q));
	}

	/**
	 * The core implementation of the algorithm. The full description of the algorithm used in this
	 * solution has been described in the <sup>README.MD</sup> file of the current project.
	 * 
	 * @param inputs the input array with decimals, converted from two separate integer input arrays
	 * @return the number of distinct pairs of digits which follow the "MatchedPair" condition
	 */
	private long countMatchedPairs(BigDecimal[] inputs) {

		int inputLength = inputs.length;

		// if array is empty or has only one element, there can't be any pair at all, naturally
		if (inputLength < 2) {
			return 0;
		}

		long matchedPairs = 0;
		int bottomIndex = 0;
		int topIndex = inputLength - 1;

		// stage 1 of the algorithm - counting all occurrences of value '0' in the array
		int zeroValuesInSet = 0;
		while (bottomIndex < inputLength && inputs[bottomIndex].compareTo(BigDecimal.ZERO) == 0) {
			zeroValuesInSet += 1;
			bottomIndex += 1;
		}
		matchedPairs += countNumberOfDistinctPairsInSet(zeroValuesInSet);

		// stage 2 of the algorithm - values between '0' (excl.) and '1' (incl.) can be ignored
		while (bottomIndex < inputLength && inputs[bottomIndex].compareTo(BigDecimal.ONE) <= 0) {
			bottomIndex++;
		}

		// stage 3 of the algorithm - core part - counting all the pairs in the set which follow the
		// 'matched pair' condition (detailed description of this algorithm in README.MD file)
		while (bottomIndex < topIndex) {

			BigDecimal limitFunctionValue = inputs[topIndex].divide(
				inputs[topIndex].subtract(BigDecimal.ONE), MathContext.DECIMAL128);

			while (bottomIndex < topIndex && inputs[bottomIndex].compareTo(limitFunctionValue) < 0) {
				bottomIndex += 1;
			}

			matchedPairs += (topIndex - bottomIndex);
			topIndex -= 1;
		}
		return matchedPairs;
	}

	// AUXILLIARY METHODS

	/**
	 * Counts the number of distinct subsets with two elements in a set of N elements. It uses the
	 * math formula for k-combination of set of N elements (binomial coefficient formula).
	 * 
	 * @param N the number of elements in set
	 * @return the number of distinct pairs in set of N elements
	 */
	private int countNumberOfDistinctPairsInSet(int N) {
		return (N * (N - 1)) / 2;
	}
}
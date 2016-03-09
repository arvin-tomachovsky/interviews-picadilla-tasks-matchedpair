package daniel.fryze.picadilla.interview.matchedpairs.auxiliary;

/**
 * The 'validator' class for input values of MatchedPair algorithm. It validates if the input values
 * meets the conditions which input values need to follow, according to the algorithm description.
 * 
 * @author daniel.fryze
 */
public class MatchedPairInputValidator {

	/**
	 * Validates the input arguments for the algorithm according to the rules defined in algorithm.
	 * 
	 * @param integralParts input argument array with integral parts for decimal value
	 * @param fractionalParts input argument array with fractional parts for decimal value
	 */
	public static void validate(int[] integralParts, int[] fractionalParts) {
		if (integralParts == null || fractionalParts == null) {
			throw new IllegalArgumentException("Input array arguments arrays can not be null.");
		}
		if (integralParts.length != fractionalParts.length) {
			throw new IllegalArgumentException("Input array arguments arrays must be the same length.");
		}
		if (integralParts.length > 100000) {
			throw new IllegalArgumentException("Input array arguments arrays can not be longer than 100000.");
		}
		for (int i = 0; i < integralParts.length; i++) {
			if (integralParts[i] < 0 || integralParts[i] > 1000) {
				throw new IllegalArgumentException(
						"Input array with 'integral parts' must contain values between 0 and 1000.");
			}
			if (fractionalParts[i] < 0 || fractionalParts[i] > 1000000) {
				throw new IllegalArgumentException(
						"Input array with 'fractional parts' must contain values between 0 and 1000000.");
			}
			if (i < integralParts.length - 1 && !areSiblingsSorted(integralParts, fractionalParts, i)) {
				throw new IllegalArgumentException("Result input array must be sorted in non-descending order.");
			}
		}
	}

	/**
	 * Checks if two sibling elements in input arrays represent decimal values in non-desc. order.
	 * 
	 * @param integralParts array with integral parts
	 * @param fractionalParts array with fractional parts
	 * @param firstSiblingIndex index of first sibling checked
	 * @return {@value true} if siblings are in order, {@value false} otherwise
	 */
	private static boolean areSiblingsSorted(int[] integralParts, int[] fractionalParts, int firstSiblingIndex) {
		return (integralParts[firstSiblingIndex] < integralParts[firstSiblingIndex + 1]
			|| integralParts[firstSiblingIndex] == integralParts[firstSiblingIndex + 1]
				&& fractionalParts[firstSiblingIndex] <= fractionalParts[firstSiblingIndex + 1]);
	}
}
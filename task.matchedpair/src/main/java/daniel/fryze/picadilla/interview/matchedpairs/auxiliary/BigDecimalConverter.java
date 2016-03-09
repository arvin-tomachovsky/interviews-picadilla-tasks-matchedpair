package daniel.fryze.picadilla.interview.matchedpairs.auxiliary;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * The converter class. It converts the input list of decimal values represented as two separate
 * arrays with integer values (one with integral parts, the other with fractional parts) into one
 * result array with values represented as {@code BigDecimal} type.
 * 
 * Having the following: P - the input array with integral parts, Q - the input array with
 * fractional parts, D - the result array with decimal values:
 * 
 * The conversion algorithm works as follows: D[i] = P[i] + ( Q[i] / 1000000 )
 * 
 * For example:
 * 
 * The inputs: {0, 1, 2} and {50000, 0, 100} are converted into result array {0.05, 1.0, 2.0001}.
 * 
 * @author daniel.fryze
 */
public class BigDecimalConverter {

	/**
	 * Converts the two input arrays (with integral and fractional parts separately) into one result
	 * array containing {@code BigDecimal} values created from the two previous.
	 * 
	 * @param integralParts the array with integral parts for input values
	 * @param fractionalParts the array with fractional parts for input values
	 * @return the array with calculated {@code BigDecimal} values
	 */
	public static BigDecimal[] convertToBigDecimals(int[] integralParts, int[] fractionalParts) {
		BigDecimal[] result = new BigDecimal[integralParts.length];
		for (int i = 0; i < integralParts.length; i++) {
			result[i] = createBigDecimal(integralParts[i], fractionalParts[i]);
		}
		return result;
	}

	/**
	 * Creates the value in {@code BigDecimal} format form two separate values: one for integral
	 * part and the other for fractional part (multiplied by 1000000).
	 * 
	 * @param integralPart the integral part represented as {@code int} type
	 * @param fractionalPart the fractional part represented as {@code int} type
	 * @return the created decimal value represented as {@code BigDecimal} type
	 */
	private static BigDecimal createBigDecimal(int integralPart, int fractionalPart) {
		BigDecimal integralPartBD = new BigDecimal(integralPart);
		BigDecimal fractionalPartBD = new BigDecimal(BigInteger.valueOf(fractionalPart), 6);
		return integralPartBD.add(fractionalPartBD);
	}
}
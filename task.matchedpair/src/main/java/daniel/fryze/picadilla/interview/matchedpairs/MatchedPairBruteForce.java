package daniel.fryze.picadilla.interview.matchedpairs;

import java.math.BigDecimal;

import daniel.fryze.picadilla.interview.matchedpairs.auxiliary.BigDecimalConverter;

/**
 * The 'brute-force' version of the 'MatchedPair' algorithm. Its expected worst-case time complexity
 * is O(N*N). It is only used to test the real algorithm's version {@link MatchedPair} correctness
 * for random-input test cases.
 * 
 * @author daniel.fryze
 */
public class MatchedPairBruteForce {

	/**
	 * The full description in the real algorihtm's implementation.
	 * {@link #MatchedPair.matchedPair}
	 */
	public long matchedPair(int[] P, int[] Q) {
		BigDecimal[] bds = BigDecimalConverter.convertToBigDecimals(P, Q);
		int matchedPairs = 0;
		for (int i = 0; i < P.length; i++) {
			for (int j = 0; j < Q.length; j++) {
				if (i != j) {
					BigDecimal a = bds[i];
					BigDecimal b = bds[j];
					if ((a.multiply(b)).compareTo(a.add(b)) >= 0) {
						matchedPairs++;
					}
				}
			}
		}
		return matchedPairs / 2;
	}
}
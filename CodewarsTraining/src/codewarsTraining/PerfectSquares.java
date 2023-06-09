package codewarsTraining;

import java.util.Arrays;

public class PerfectSquares {
	
	public static int smallestListOfSquares(int n) {
	    int[] dp = new int[n+1];
	    
	    Arrays.fill(dp, n);
	    
	    dp[0] = 0;
	    
	    for (int i = 1; i <= Math.sqrt(n); i++) {
	        for (int j = i*i; j <= n; j++) {
	            dp[j] = Math.min(dp[j], dp[j-i*i]+1);
	        }
	    }
	    return dp[n];
	}
	
}

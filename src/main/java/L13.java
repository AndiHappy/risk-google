import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

/**
 * @author zhailiuzhen
 
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.

Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.

Example 1:

Input: "III"
Output: 3
Example 2:

Input: "IV"
Output: 4
Example 3:

Input: "IX"
Output: 9
Example 4:

Input: "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
Example 5:

Input: "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

 */
public class L13 {
	
	static Map<Character, Integer> comvertMap = new HashMap<Character, Integer>();
	static {
		/**
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
		 * */
		comvertMap.put('a', 0);
		comvertMap.put('I', 1);
		comvertMap.put('V', 5);
		comvertMap.put('X', 10);
		comvertMap.put('L', 50);
		comvertMap.put('C', 100);
		comvertMap.put('D', 500);
		comvertMap.put('M', 1000);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Assert.assertEquals(L13.romanToInt("III"), 3);
		System.out.print(L13.romanToInt("IV"));

		System.out.print(L13.romanToInt("IX"));

		System.out.print(L13.romanToInt("LVIII"));
		
		System.out.print(L13.romanToInt("MCMXCIV"));

	}
	
	public static int romanToInt(String s) {
		char[] tmp = s.toCharArray();
		int result = 0;
		for (int i = 0; i < tmp.length; i++) {
			char tmpchar = tmp[i];
			char tmpafter = i+1>= tmp.length ?'a':tmp[i+1];
			if(comvertMap.get(tmpchar) >= comvertMap.get(tmpafter)) {
				result=result+comvertMap.get(tmpchar);
			}else {
				result=result-comvertMap.get(tmpchar);
			}
		}
		
		return result;
        
    }

}

// Idan Hur 318247822
package HW4;

import java.util.Scanner;

public class RecClass {

	public static boolean isTheSame(String str) {
		boolean res;
		if (str.length() == 1) {
			return true;
		}
		res = isTheSame(str.substring(1));
		if (str.charAt(0) == str.charAt(1) && res) {
			return true;
		}
		return false;
	}

	public static int numOfMod3(int[] arr, int size) {
		if (size == 0) {
			return 0;
		}
		if (((double) arr[size - 1] / 3) == (arr[size - 1]) / 3) {
			return numOfMod3(arr, size - 1) + 1;
		} else {
			return numOfMod3(arr, size - 1);
		}
	}

	public static void subGroups(int n) {

		String str = subGroupsHelper((n));

		System.out.println(str);
	}

	private static String subGroupsHelper(int n) {
		String str;
		if (n == 0) {
			return "{}\n";
		}
		str = subGroupsHelper(n - 1);
		str += str.replaceAll("}", "," + n + "}");
		str = str.replace("{,", "{");
		return str;
	}

}

// Idan Hur 318247822

package HW4;

public class StringUtil {

	public static String getFirstLetters(String str) {
		String str1 = new String();
		char ch1, ch2;
		boolean hasBeen = false;
		str = str.trim();
		str1 += str.charAt(0);
		for (int i = 0; i < str.length(); i++) {
			if ((str.charAt(i)) == ' ') {
				ch1 = Character.toLowerCase(str.charAt(i + 1));
				ch2 = Character.toUpperCase(str.charAt(i + 1));
				for (int j = 0; j < str1.length(); j++) {
					if (str1.charAt(j) == ch1 || str1.charAt(j) == ch2) {
						hasBeen = true;
					}
				}
				if (!hasBeen) {
					str1 += str.charAt(i + 1);
				}
				hasBeen = false;
			}
		}
		return str1.replace(" ", "");
	}

	public static boolean isOnlyLetters(String str) {
		int test;
		for (int i = 0; i < str.length(); i++) {
			test = str.charAt(i);
			if (test < 58) {
				return false;
			}
		}
		return true;
	}

	public static boolean isLegalName(String name) {
		char firstLetter = name.charAt(0);
		char firstLetterBig = Character.toUpperCase(firstLetter);
		if (name.length() > 8) {
			return false;
		}
		if (firstLetter != firstLetterBig || isOnlyLetters(name)) {
			return false;
		}
		return true;
	}

}

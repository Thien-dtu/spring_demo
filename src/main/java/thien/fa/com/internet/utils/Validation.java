package thien.fa.com.internet.utils;

import java.util.regex.Pattern;

public class Validation {
	public static boolean checkValidKHID(String khID) {
		Pattern p = Pattern.compile(Constants.REGEX_KH_ID);
		if (!p.matcher(khID).matches()) {
			return false;
		}
		return true;
	}

	public static boolean checkValidMID(String mID) {
		Pattern p = Pattern.compile(Constants.REGEX_M_ID);
		if (!p.matcher(mID).matches()) {
			return false;
		}
		return true;
	}

	public static boolean checkValidDVID(String dvID) {
		Pattern p = Pattern.compile(Constants.REGEX_DV_ID);
		if (!p.matcher(dvID).matches()) {
			return false;
		}
		return true;
	}
	public static boolean checkValidKHEmail(String email) {
		Pattern p = Pattern.compile(Constants.REGEX_CHECK_EMAIL);
		if (!p.matcher(email).matches()) {
			return false;
		}
		return true;
	}
	public static boolean checkValidKHPhone(String phone) {
		Pattern p = Pattern.compile(Constants.REGEX_CHECK_PHONE);
		if (!p.matcher(phone).matches()) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		String mess = null;

		checkValidKHID("KH000001");

	}
}

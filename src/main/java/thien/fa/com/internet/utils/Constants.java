package thien.fa.com.internet.utils;

public class Constants {
	public static final String REGEX_KH_ID = "^KH[0-9]{6}$";
	public static final String REGEX_DV_ID = "^DV[0-9]{3}$";
	public static final String REGEX_M_ID = "^M[0-9]{3}$";

//	static final String REGEX_CHECK_EMAIL = "^[a-zA-Z]\\w+@[a-zA-Z]+(\\.[a-zA-Z]+)$";
	
	static final String REGEX_CHECK_EMAIL = "^[a-zA-Z][a-z0-9_\\.]{4,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$";
	
	static final String REGEX_CHECK_PHONE = "^0[0-9]{9}$";

}

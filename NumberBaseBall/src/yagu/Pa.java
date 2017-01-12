package yagu;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Pattern p = Pattern.compile("\\d{3}");
//		Matcher m = p.matcher("123");
//		boolean b = m.matches();
		
		
		boolean a = Pattern.matches("\\d{3}", "123");
		
		
		
		System.out.println(a);
	}

}

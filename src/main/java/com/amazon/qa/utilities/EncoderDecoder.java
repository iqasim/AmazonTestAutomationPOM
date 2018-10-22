package com.amazon.qa.utilities;

import java.util.Base64;

public class EncoderDecoder {
	
	public static String encodePassword(String str)
	{
		byte[] encodedPass = Base64.getEncoder().encode(str.getBytes());
		String encodedPassword = encodedPass.toString();
		System.out.println("Encoded Password is: "+encodedPassword );
		return encodedPassword;
	}
	
	public static String decodePassword(String str)
	{
		byte[] decodedPass = Base64.getDecoder().decode(str);
		String decodedPassword = decodedPass.toString();
		System.out.println("Decoded Password is: "+decodedPassword);
		return decodedPassword;
	}
	

}

package util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

import org.apache.tomcat.util.codec.binary.Base64;

public class Encrypt {
	public static String toSHA1 (String str){
		String salt = "hgnvjdntVGnhscniHDPjfnc";
		String result = "";
		
		str = str + salt;
		try {
			byte[] data = str.getBytes("UTF-8");
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			result = Base64.encodeBase64String(md.digest(data));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(toSHA1("123"));
	}
}

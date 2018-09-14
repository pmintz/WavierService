package utilites;

import java.security.MessageDigest;
import sun.misc.BASE64Encoder;

public final class PasswordService {
	
	public String encrypt(String pass){
		MessageDigest md = null;
		
		try{
			md = MessageDigest.getInstance("SHA-256");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		try{
			md.update(pass.getBytes("UTF-8"));
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		byte raw[] = md.digest();
		String hash = (new BASE64Encoder()).encode(raw);
		return hash;
	}

}

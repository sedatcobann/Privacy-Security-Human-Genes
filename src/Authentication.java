import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class Authentication {
	public static boolean hashingPassword(String username, String password) throws Exception 
	{ 
		File file = new File("src/usernamePass.txt"); 
		BufferedReader rd = new BufferedReader(new FileReader(file)); 
		HashMap passwords = readPasswords(rd);
		String saltedpassword = "";
		String hashedText = null;
		if(passwords.containsKey(username)) {
			User user = (User) passwords.get(username);
			saltedpassword = password+user.getSalt();
		}else {
			return false;
		}
		try { 
			MessageDigest md = MessageDigest.getInstance("SHA-512"); 
			byte[] messageDigest = md.digest(saltedpassword.getBytes(StandardCharsets.UTF_8)); 
			hashedText = String.format("%064x", new BigInteger(1, messageDigest));
			User a = (User) passwords.get(username);
			if(a == null) {
				return false;
			}else if(a.getPassword().equals(hashedText)) {
				return true;
			}else {
				return false;
			}
		}catch (NoSuchAlgorithmException e) { 
			throw new RuntimeException(e); 
		} 
	} 
	
	public static HashMap<String,User> readPasswords(BufferedReader rd) throws Exception {
		HashMap<String,User> usernamePasswords = new HashMap<String, User>();
		try {
			while(true) {
				String line = rd.readLine();
				if(line==null) {
					break;
				}else {
					String[] split = line.split("\\s+");
					User user = new User();
					user.setUserName(split[0]);
					user.setSalt(split[1]);
					user.setPassword(split[2]);
					usernamePasswords.put(split[0], user);
				}	
			}
			rd.close();
		}catch(IOException ex) {
			throw new Exception(ex);
		}
		return usernamePasswords;

	}
	
	public static boolean hashingSecretKey(String key) throws FileNotFoundException {
		File file = new File("src/secretKey.txt"); 
		BufferedReader rd = new BufferedReader(new FileReader(file)); 
		String saltAndKey = null;
		try {
			saltAndKey = rd.readLine();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String[] split = saltAndKey.split("\\s+");
		String salt = split[0];
		String hashedKey = split[1];
		String hashedText = null;
		try { 
			String saltedKey = key+salt;
			MessageDigest md = MessageDigest.getInstance("SHA-512"); 
			byte[] messageDigest = md.digest(saltedKey.getBytes(StandardCharsets.UTF_8)); 
			hashedText = String.format("%064x", new BigInteger(1, messageDigest));
			if(hashedText.equals(hashedKey)) {
				return true;
			}else {
				return false;
			}
		}catch (NoSuchAlgorithmException e) { 
			throw new RuntimeException(e); 
		} 
	}
}

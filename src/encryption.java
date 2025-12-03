import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
//This class is needed to encrypt the dataset before performing my project. Also, it is needed to decrypt the encrypted data. 
public class encryption {
	public String salt = "kocuniversity016";
	
	public static SecretKeySpec generateSecretKey(String key) {
		byte[] byteKey = key.getBytes();
		byte[] byteSecretKey = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		MessageDigest digest = null;
		try {
			digest = MessageDigest.getInstance("SHA-512");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byteSecretKey = Arrays.copyOf(digest.digest(byteKey), 16); 
		SecretKeySpec secretKey = new SecretKeySpec(byteSecretKey, "AES");
		return secretKey;
		
	}
	
	
	public String encrypt(String row, String key) {
		
			SecretKeySpec secretKey = generateSecretKey(key);
			Cipher cipher = null;
			try {
				cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            try {
				cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			} catch (InvalidKeyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            String encryptedRow="";
            try {
				encryptedRow+=Base64.getEncoder().encodeToString(cipher.doFinal(row.getBytes("UTF-8")));
			} catch (IllegalBlockSizeException | BadPaddingException | UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            return encryptedRow;
	}
	
	public static String decrypt(String row, String key) {
		SecretKeySpec secretKey = generateSecretKey(key);
		Cipher cipher = null;
		try {
			cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        String decryptedRow="";
        try {
        	byte[] decodes = Base64.getDecoder().decode(row);
			String decrypted = new String(cipher.doFinal(decodes));
			decryptedRow+=decrypted;
		} catch (IllegalBlockSizeException | BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return decryptedRow;
	}
	
	
}

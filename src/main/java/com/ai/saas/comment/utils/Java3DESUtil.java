package com.ai.saas.comment.utils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.DESedeKeySpec;

import Decoder.BASE64Decoder;
import Decoder.BASE64Encoder;

/**
 * java 3des加密解密
 * 
 * @date Mar 11, 2014 10:37:31 AM
 * @author wuzl
 * @comment
 */
public class Java3DESUtil {
//	private final static String key = "4BD634432ERRDF432FFSDDSFAQSDF3E83A361FA75FA446933F90D384C6F6520F29FCD8EA";
	private final static String key = "FA75FA1987071190384C6F6520F29FCD8EA4BD634432ERRDF432FFSDDSFAQSDF3E83A361";

	/**
	 * 加密
	 * 
	 * @param src
	 * @param key
	 * @return
	 * @throws Exception
	 * @date Mar 11, 2014 10:41:13 AM
	 * @author wuzl
	 * @comment
	 */
	public static String encryptThreeDESECB(String src, String key)
			throws Exception {
		try {
//			DESKeySpec ks = new DESKeySpec(key.getBytes("UTF-8"));
			DESedeKeySpec ks = new DESedeKeySpec(key.getBytes("UTF-8"));
			SecretKeyFactory kf = SecretKeyFactory.getInstance("DESede");
			SecretKey ky = kf.generateSecret(ks);

			Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, ky);
			byte[] b = cipher.doFinal(src.getBytes());

			BASE64Encoder encoder = new BASE64Encoder();
			return encoder.encode(b).replaceAll("\r", "").replaceAll("\n", "");
		} catch (Exception e) {
			throw new Exception("3des加密失败："+e.getMessage());
		}

	}
	
	public static String encrypt3Des(String src, String key)
			throws Exception {
		try {
			DESKeySpec ks = new DESKeySpec(key.getBytes("UTF-8"));
			SecretKeyFactory kf = SecretKeyFactory.getInstance("DES");
			SecretKey ky = kf.generateSecret(ks);

			Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, ky);
			byte[] b = cipher.doFinal(src.getBytes());

			BASE64Encoder encoder = new BASE64Encoder();
			return encoder.encode(b).replaceAll("\r", "").replaceAll("\n", "");
		} catch (Exception e) {
			throw new Exception("3des加密失败："+e.getMessage());
		}

	}
	/**
     * 加密
     * 
     * @param src
     * @param key
     * @return
     * @throws Exception
     * @date Mar 11, 2014 10:41:13 AM
     * @author wuzl
     * @comment
     */
    public static String encryptThreeDESECB(String src){
//    	DESKeySpec dks;
        DESedeKeySpec dks;
        try
        {
            dks = new DESedeKeySpec(key.getBytes("UTF-8"));
//        	dks = new DESKeySpec(key.getBytes("UTF-8"));
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
            SecretKey securekey = keyFactory.generateSecret(dks);
    
            Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, securekey);
            byte[] b = cipher.doFinal(src.getBytes());
    
            BASE64Encoder encoder = new BASE64Encoder();
            return encoder.encode(b).replaceAll("\r", "").replaceAll("\n", "");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return src;

    }
    
    public static String encrypt3Des(String src){
    	DESKeySpec dks;
        try
        {
        	dks = new DESKeySpec(key.getBytes("UTF-8"));
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey securekey = keyFactory.generateSecret(dks);
    
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, securekey);
            byte[] b = cipher.doFinal(src.getBytes());
    
            BASE64Encoder encoder = new BASE64Encoder();
            return encoder.encode(b).replaceAll("\r", "").replaceAll("\n", "");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return src;

    }
	/**
	 * 解密
	 * 
	 * @param src
	 * @param key
	 * @return
	 * @throws Exception
	 * @date Mar 11, 2014 10:41:07 AM
	 * @author wuzl
	 * @comment
	 */
	public static String decryptThreeDESECB(String src, String key)
			throws Exception {
		System.out.println(key.length());
		// --通过base64,将字符串转成byte数组
		BASE64Decoder decoder = new BASE64Decoder();
		byte[] bytesrc = decoder.decodeBuffer(src);
		// --解密的key
//		DESKeySpec dks = new DESKeySpec(key.getBytes("UTF-8"));
		DESedeKeySpec dks = new DESedeKeySpec(key.getBytes("UTF-8"));
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
		SecretKey securekey = keyFactory.generateSecret(dks);

		// --Chipher对象解密
		Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
		cipher.init(Cipher.DECRYPT_MODE, securekey);
		byte[] retByte = cipher.doFinal(bytesrc);

		return new String(retByte);
	}
	
	public static String decrypt3Des(String src, String key)
			throws Exception {
		// --通过base64,将字符串转成byte数组
		BASE64Decoder decoder = new BASE64Decoder();
		byte[] bytesrc = decoder.decodeBuffer(src);
		// --解密的key
		DESKeySpec dks = new DESKeySpec(key.getBytes("UTF-8"));
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey securekey = keyFactory.generateSecret(dks);

		// --Chipher对象解密
		Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
		cipher.init(Cipher.DECRYPT_MODE, securekey);
		byte[] retByte = cipher.doFinal(bytesrc);

		return new String(retByte);
	}
	/**
     * 解密
     * 
     * @param src
     * @return
     * @throws Exception
     * @date Mar 11, 2014 10:41:07 AM
     * @author wuzl
     * @comment
     */
    public static String decryptThreeDESECB(String src){
        try
        {
            // --通过base64,将字符串转成byte数组
            BASE64Decoder decoder = new BASE64Decoder();
            byte[] bytesrc;
                bytesrc = decoder.decodeBuffer(src);
           
            // --解密的key
//            DESKeySpec dks = new DESKeySpec(key.getBytes("UTF-8"));
            DESedeKeySpec dks = new DESedeKeySpec(key.getBytes("UTF-8"));
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
            SecretKey securekey = keyFactory.generateSecret(dks);
    
            // --Chipher对象解密
            Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, securekey);
            byte[] retByte = cipher.doFinal(bytesrc);
    
            return new String(retByte);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return src;
    }
    
    public static String decrypt3Des(String src){
        try
        {
            // --通过base64,将字符串转成byte数组
            BASE64Decoder decoder = new BASE64Decoder();
            byte[] bytesrc;
                bytesrc = decoder.decodeBuffer(src);
           
            // --解密的key
            DESKeySpec dks = new DESKeySpec(key.getBytes("UTF-8"));
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey securekey = keyFactory.generateSecret(dks);
    
            // --Chipher对象解密
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, securekey);
            byte[] retByte = cipher.doFinal(bytesrc);
    
            return new String(retByte);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return src;
    }
    
	public static void main(String[] args) throws Exception {
//		System.out.println(Java3DESUtil.encryptThreeDESECB("yanjing3"));
		
//		System.out.println(Java3DESUtil.encryptThreeDESECB("{\"createtime\":\"2014-11-06 22:11:46\",\"pcontent\":\"帖子内容\",\"plink\":\"\",\"pdevice\":\"iPhone 6 Plus\",\"pcurrent\":\"\",\"ptype\":1,\"preleasetype\":0,\"uid\":14139,\"cid\":0,\"tid\":8}"));
//		System.out.println(Java3DESUtil.decryptThreeDESECB("n8wGeIcBIfr0CZUnKeqtVg=="));
//		System.out.println(Java3DESUtil.decryptThreeDESECB("/1tc9gxJKYf9cJoVr0r6xvxEKi2uAl5t", key));
		//System.out.println(Java3DESUtil.decryptThreeDESECB("SdCawlnhpPk=", "rsml5270"));
//		System.out.println(Java3DESUtil.decryptThreeDESECB("ZKooP/d1giSJ8aeu7hEUBMgaeAIG2OZI", key));
		



System.out.println(decryptThreeDESECB("QNfc4fP5Qtb0CZUnKeqtVg==", key));
System.out.println(decryptThreeDESECB("AfCT8WAtzkU=", key));
System.out.println(decryptThreeDESECB("uAnsSoYjLlw=", key));
System.out.println(decryptThreeDESECB("nl1vq8d+4dc=", key));
System.out.println(decryptThreeDESECB("3sDgmEFso6P0CZUnKeqtVg==", key));
			
		/*System.out.println(encryptThreeDESECB("jinxing3", key));
		System.out.println(decryptThreeDESECB(encryptThreeDESECB("jinxing3", key), key));
		System.out.println(encryptThreeDESECB("haoyh", key));
		System.out.println(decryptThreeDESECB(encryptThreeDESECB("haoyh", key), key));
		System.out.println(encryptThreeDESECB("renfeng3", key));
		System.out.println(decryptThreeDESECB(encryptThreeDESECB("renfeng3", key), key));
		System.out.println(encryptThreeDESECB("zhangft", key));
		System.out.println(decryptThreeDESECB(encryptThreeDESECB("zhangft", key), key));*/
	}
}

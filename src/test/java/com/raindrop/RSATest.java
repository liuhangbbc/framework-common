package com.raindrop;

import java.util.Map;

import com.raindrop.utils.rsatUtils.Base64Utils;
import com.raindrop.utils.rsatUtils.RSAUtils;

public class RSATest {

	static String publicKey;
	static String privateKey;

	// static {
	// try {
	// Map<String, Object> keyMap = RSAUtils.genKeyPair();
	// publicKey = RSAUtils.getPublicKey(keyMap);
	// privateKey = RSAUtils.getPrivateKey(keyMap);
	// System.err.println("公钥: \n\r" + publicKey);
	// System.err.println("私钥： \n\r" + privateKey);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }

	public static void main(String[] args) throws Exception {
//		test4();
		// test3();
		// test2();
//		 test();
		test5();
	}

	static void test5() throws Exception {
		byte[] decodedData = RSAUtils.decryptByPrivateKey(
				Base64Utils.decode("dzaQ6WiarJOjXki1djdmE3umAIyxMFmbhyoumsZ/b/tOGuSvf5ODVtPXW5K7ZApQXp4BHf0xqOdfAt5qvUHyWMSwO16f+5mXJt8+nBk7gt/Ln3Qvv7g+veX8mwBZd0yRox6jMtRrqh+zZseYe8KL4u1M0FG5Y6xtDJu4YBQ32ac="),
				"MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAM44qKHtrdW7jOsIUUtGTk6bu/yldEN5Y5bXiEc7nAqqJNhPjCUo1hoM0htsqR6wonaetRHWLCB2Jl+a229dKqaDAtT3kzF5i7Qi4V9NuaSPW0swufC1Y60647HdqUUFNUFpDzkliqzubFVRDK0TCtD1WmjpNeBZ8myY4Lj0uQvHAgMBAAECgYAyQ7Emtu4WGH7CkuZtuJdBpcfuTs3F3IKfs60t36OrHcmZR9pa/FcjRli4AoY+SsNuskRkMpXS27mCuBYgUM8iEquxxOhOQLfvS2yuLxgCRYYIPoCmFLgHt/xHmymYaRpAy5LEg/IWaenkx0VlvjWwhpIn5y52rZbIKXA4TWT84QJBAPYEKCgJADBG0cV20uYafmKDy7nuaWpzNsDoOd94ukI3dZSYpTh4UaNfGxG2QkeEOozPrvIiFSqmp6UdFtftzJkCQQDWlxNeI2o58fcc5VBwXmoBPv9wf56rONRTIpxhiCWwtgiB3zn5+qHfMQTED/uEOAxS5VR/taB9k2jlJG9It3dfAkEA07egF1QnpWRNAvLPbNdADOf/W3OhpMqiREGWDIuJP5MazVbQWViyaTZfxU5km8df2+6fUCGktZ/WhnISRqGPgQJBAKrXfEPmThvz15jZuEC96gcz8InQELKge+n0FCxSCC+3vO4omi+6qkTW8cRmNQf+11Dn424JW8yeH1TOvQpXhmECQBgiK4FAyKdJFO19nqGU5J1VfXjZzwHsqDuxp8NJ0BDrMbv5mxJkGPwe/4PHLtT8Of1VVqM05hIn2HNOiN0BY3w=");
		String target = new String(decodedData);
		System.out.println("解密后文字: \r\n" + target);
	}
	static void test() throws Exception {
		System.err.println("公钥加密——私钥解密");
		String source = "123";
		System.out.println("\r加密前文字：\r\n" + source);
		byte[] data = source.getBytes();
		byte[] encodedData = RSAUtils.encryptByPublicKey(data, "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDOOKih7a3Vu4zrCFFLRk5Om7v8pXRDeWOW14hHO5wKqiTYT4wlKNYaDNIbbKkesKJ2nrUR1iwgdiZfmttvXSqmgwLU95MxeYu0IuFfTbmkj1tLMLnwtWOtOuOx3alFBTVBaQ85JYqs7mxVUQytEwrQ9Vpo6TXgWfJsmOC49LkLxwIDAQAB");
		System.out.println("加密后文字：\r\n" + Base64Utils.encode(encodedData));
		// StringBuilder str = new StringBuilder(
		// "JskEqybE6pXdNtWl/UBVHrrM0tdAEuUumcQASAUu3lv/+VMc7zW8QkzMPgjsm3Qstm1YpG4GF6jpiCvPLCPc4pNmeX+RqpLnoMvuMot1Lp8C5onqNp2MLEP/whTGEt3lpwZ37rhbkL4zGOnH+qNPvDhtBxIbsV+TCjSrw3ww+og=");
		// System.out.println("码为二进制数据: \r\n" + str.toString());
		// byte[] decodedData = RSAUtils.decryptByPrivateKey(
		// Base64Utils.decode(str.toString()), privateKey);
		byte[] decodedData = RSAUtils.decryptByPrivateKey(
				Base64Utils.decode("dzaQ6WiarJOjXki1djdmE3umAIyxMFmbhyoumsZ/b/tOGuSvf5ODVtPXW5K7ZApQXp4BHf0xqOdfAt5qvUHyWMSwO16f+5mXJt8+nBk7gt/Ln3Qvv7g+veX8mwBZd0yRox6jMtRrqh+zZseYe8KL4u1M0FG5Y6xtDJu4YBQ32ac="),
				"MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAM44qKHtrdW7jOsIUUtGTk6bu/yldEN5Y5bXiEc7nAqqJNhPjCUo1hoM0htsqR6wonaetRHWLCB2Jl+a229dKqaDAtT3kzF5i7Qi4V9NuaSPW0swufC1Y60647HdqUUFNUFpDzkliqzubFVRDK0TCtD1WmjpNeBZ8myY4Lj0uQvHAgMBAAECgYAyQ7Emtu4WGH7CkuZtuJdBpcfuTs3F3IKfs60t36OrHcmZR9pa/FcjRli4AoY+SsNuskRkMpXS27mCuBYgUM8iEquxxOhOQLfvS2yuLxgCRYYIPoCmFLgHt/xHmymYaRpAy5LEg/IWaenkx0VlvjWwhpIn5y52rZbIKXA4TWT84QJBAPYEKCgJADBG0cV20uYafmKDy7nuaWpzNsDoOd94ukI3dZSYpTh4UaNfGxG2QkeEOozPrvIiFSqmp6UdFtftzJkCQQDWlxNeI2o58fcc5VBwXmoBPv9wf56rONRTIpxhiCWwtgiB3zn5+qHfMQTED/uEOAxS5VR/taB9k2jlJG9It3dfAkEA07egF1QnpWRNAvLPbNdADOf/W3OhpMqiREGWDIuJP5MazVbQWViyaTZfxU5km8df2+6fUCGktZ/WhnISRqGPgQJBAKrXfEPmThvz15jZuEC96gcz8InQELKge+n0FCxSCC+3vO4omi+6qkTW8cRmNQf+11Dn424JW8yeH1TOvQpXhmECQBgiK4FAyKdJFO19nqGU5J1VfXjZzwHsqDuxp8NJ0BDrMbv5mxJkGPwe/4PHLtT8Of1VVqM05hIn2HNOiN0BY3w=");
		String target = new String(decodedData);
		System.out.println("解密后文字: \r\n" + target);
	}

	static void test2() throws Exception {
		StringBuilder str = new StringBuilder(
				"PpWfAJ/vwAXI0YvBgjp5A/lUHZRPcowJxqSUxhRTPg66t24RKlKZy/voirznMof/Qc6x0QG7n7DWVX9yelWCeR0StgUcPXfvgqkVvYR8gkgerWTpq8L5+1WKesALQof+iKcGdHdPUoe/3GMQo6C27VQuUrNFR0ezT4eHAnntCGQ=");
		System.out.println("码为二进制数据: \r\n" + str.toString());
		byte[] decodedData = RSAUtils
				.decryptByPrivateKey(
						Base64Utils.decode(str.toString()),
						"MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAJHp4cP4yrLN7sK+ejGjwDCjm8aZly82pmeg+aAKgZ0xSDwFb6LfG6MTftwBYU2f9/KpFqnUpzphIwWjVZDAYZcOJVcwmC0sLQmHf0YS2I+uK1jqf2SM9Xew8SoCk2c+9chuLGA0SK8TkFWkfzNNxJF8BDkcG8+prDOBMTCYJGITAgMBAAECgYB038+0dz11BzptxsB9rlotG3+VDkVoze9wJiKMrJ2xWV4wpXIMFYU/lEgS1RApay7hscqzceAZBOFWjMPm1BHWAsZYD1frYqJTJ9zy+TGmGAq3x+KyDDR6MLXLFhH2QjcpJG5v6paa+1T28f/9Y3RKuOhgMpJBQ34tA6K5lPfTEQJBANqld5gKEAxqkqArlt0C5psrpT793j+k0kMiOLGFqIXvisDThHjRfvEHcJvo1CWxiE/1pet4BZRd/scWK/3qMXUCQQCq12+tE5s27POj4YaCHRk4rrCus+lYKIm0JpGsrERYQ0WM2brFLXGmQYboWPd4R2bHwaJNpP1oR/2SZnwOFQxnAkAkG6Vnd2n1EviJ+QjeEOeSgp+0impUqlyK97DTKFaPX+LTO1sqNLa5CViAdu/qFaqEQfYXr+eD/A3iRPgY478tAkB7ufCoESX8/lhpHIDUpIxKj8FnlOZusVUhQjmIK26H2Zh6LIlmGcZQGO7CQQRgeJ2IF8UapF3d8x1CtLQtYrMLAkEAzROc9JUNAQV3FYyOoHEk9917PPlgBOQBFdXXmgNrqkoYYks447NcGTmES6ngFfMGfiXd9cw9MwpTGOIzhdGA7Q==");
		String target = new String(decodedData);
		System.out.println("解密后文字: \r\n" + target);
	}

	static void test3() throws Exception {
		System.err.println("公钥加密——私钥解密");
		String source = "bbbb";
		System.out.println("\r加密前文字：\r\n" + source);
		byte[] data = source.getBytes();
		byte[] encodedData = RSAUtils
				.encryptByPublicKey(
						data,
						"MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCR6eHD+Mqyze7Cvnoxo8Awo5vGmZcvNqZnoPmgCoGdMUg8BW+i3xujE37cAWFNn/fyqRap1Kc6YSMFo1WQwGGXDiVXMJgtLC0Jh39GEtiPritY6n9kjPV3sPEqApNnPvXIbixgNEivE5BVpH8zTcSRfAQ5HBvPqawzgTEwmCRiEwIDAQAB");
		System.out.println("加密后文字：\r\n" + Base64Utils.encode(encodedData));
	}

	static void test4() throws Exception {
		try {
			Map<String, Object> keyMap = RSAUtils.genKeyPair();
			publicKey = RSAUtils.getPublicKey(keyMap);
			privateKey = RSAUtils.getPrivateKey(keyMap);
			System.err.println("公钥: \n\r" + publicKey);
			System.err.println("私钥： \n\r" + privateKey);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void testSign() throws Exception {
		System.err.println("私钥加密——公钥解密");
		String source = "这是一行测试RSA数字签名的无意义文字";
		System.out.println("原文字：\r\n" + source);
		byte[] data = source.getBytes();
		byte[] encodedData = RSAUtils.encryptByPrivateKey(data, privateKey);
		System.out.println("加密后：\r\n" + new String(encodedData));
		byte[] decodedData = RSAUtils
				.decryptByPublicKey(encodedData, publicKey);
		String target = new String(decodedData);
		System.out.println("解密后: \r\n" + target);
		System.err.println("私钥签名——公钥验证签名");
		String sign = RSAUtils.sign(encodedData, privateKey);
		System.err.println("签名:\r" + sign);
		boolean status = RSAUtils.verify(encodedData, publicKey, sign);
		System.err.println("验证结果:\r" + status);
	}

}
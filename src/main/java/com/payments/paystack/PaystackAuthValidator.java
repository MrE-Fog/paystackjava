package com.payments.paystack;

import java.io.UnsupportedEncodingException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.json.JSONObject;

public class PaystackAuthValidator {
    private static final String ALGORITHM = "HmacSHA512";
    
    public static boolean isTokenValid(String rawJsonRequest, String authToken, String secretKey) throws Exception {
        Mac mac = getMac(secretKey);
        final byte[] mac_data = mac.doFinal(convertBodyToBytes(rawJsonRequest));
        
        String result = DatatypeConverter.printHexBinary(mac_data);
        return result.toLowerCase().equals(authToken);
    }
    
    private static Mac getMac(String secretKey) throws Exception {
        Mac mac = Mac.getInstance(ALGORITHM);
        mac.init(getSecretKeySpec(ALGORITHM, secretKey));
        return mac;
    }
    
    private static SecretKeySpec getSecretKeySpec(String algorithm, String secretKey) throws Exception {
        byte[] byteKey = secretKey.getBytes("UTF-8");
        return new SecretKeySpec(byteKey, algorithm);
    }
    
    private static byte[] convertBodyToBytes(String rawJson) throws UnsupportedEncodingException {
        return new JSONObject(rawJson).toString().getBytes("UTF-8");
    }
}
package utils;

import org.apache.commons.codec.binary.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springside.modules.security.utils.Digests;
import org.springside.modules.utils.Encodes;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.*;

/**
 *
 *
 */

public class SignUtil {
    private static Logger logger = LoggerFactory.getLogger(SignUtil.class);
    /**
     *
     * @param sArray
     * @return
     */
    public static Map<String, String> paraFilter(Map<String, String> sArray) {
        Map<String, String> result = new HashMap<String, String>();

        if (sArray == null || sArray.size() <= 0) {
            return result;
        }
        DecimalFormat formater = new DecimalFormat("###0.00");
        for (String key : sArray.keySet()) {
            String finalValue = null;
            Object value = sArray.get(key);
            if(value instanceof BigDecimal){
                finalValue = formater.format(value);
            }else {
                finalValue = (String) value;
            }
            if (value == null || value.equals("")
                    || key.equalsIgnoreCase("sign")) {
                continue;
            }
            result.put(key, finalValue);
        }

        return result;
    }
    /**
     * 调用
     * @param params
     * @return
     */
    public static String createLinkString(Map<String, String> params) {
        List<String> keys = new ArrayList<String>(params.keySet());
        Collections.sort(keys);

        String prestr = "";

        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = params.get(key);

            if (i == keys.size() - 1) {
                prestr = prestr + key + "=" + value;
            } else {
                prestr = prestr + key + "=" + value + "&";
            }
        }

        return prestr;
    }
    /**
     * 调用
     * @param key
     * @param str
     * @return
     */
    public static String genSign(String key,String str){
        logger.info("method SignUtil--genSign:"+"签名数据:"+str+"&key="+key);
        return md5(str+"&key="+key).toUpperCase();
    }
    /**
     * md5
     * @param plainText
     * @return
     */
    public static String md5(String plainText) {
        try {
            return Encodes.encodeHex(Digests.md5(new ByteArrayInputStream(plainText.getBytes("utf-8"))));
        } catch (Exception ex) {
            return "";
        }
    }
    /**
     * 调用
     * @param map
     * @param key
     * @return
     */
    public static boolean validSign(Map<String, String> map,String key){
        String oldSign = map.get("sign");
        String sign = genSign(key, createLinkString(paraFilter(map)));
        return sign.equalsIgnoreCase(oldSign);
    }

    public static String getSHA256Str(String str){
        System.out.println("str = " + str);
        MessageDigest messageDigest;
        String encdeStr = null;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hash = messageDigest.digest(str.getBytes("UTF-8"));
            encdeStr = Hex.encodeHexString(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encdeStr;
    }

}

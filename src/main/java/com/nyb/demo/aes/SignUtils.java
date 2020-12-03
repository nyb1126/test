package com.nyb.demo.aes;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * @Author:nyb
 * @DESC:
 * @Date: Created in 15:30 2020/9/22
 * @Modified By:
 */
public class SignUtils {
    private static final Logger logger = LoggerFactory.getLogger(SignUtils.class);

//    public static String createSign(String jsonStr,String secretKey) {
//        Object object = JSON.parse(jsonStr);
//        String param = null;
//        if(object instanceof JSONObject){
//            logger.info("加密对象是JSONObject类型");
//            String json = JSON.toJSONString(object);
//            JSONObject jsonObject = JSON.parseObject(json);
//            Map<String, Object> tempMap = jsonObjectToTreeMap(jsonObject);
//            param = JSON.toJSONString(tempMap);
//        }else{
//            logger.info("加密对象是JSONArray类型");
//            List<Map<String, Object>> mapList = new ArrayList<>();
//            JSONArray jsonArray = (JSONArray) object;
//            for (int i = 0; i < jsonArray.size(); i++) {
//                JSONObject tempBodyJsonObj = jsonArray.getJSONObject(i);
//                Map<String, Object> tempMap = jsonObjectToTreeMap(tempBodyJsonObj);
//                mapList.add(tempMap);
//            }
//            param = JSON.toJSONString(mapList);
//        }
//        logger.info("请求参数为:"+param);
//        return md5AndSalt(param,secretKey);
//    }
//
//    /**
//     * 将JSONObject对象转成TreeMap,属性名为key,属性值为value
//     *
//     * @param jsonObject Json对象
//     * @return  Map<String, Object>
//     */
//    public static Map<String, Object> jsonObjectToTreeMap(JSONObject jsonObject) {
//        SortedMap<String, Object> data = new TreeMap<>();
//        Set<String> keySet = jsonObject.keySet();
//        for (String key : keySet) {
//            Object value = jsonObject.get(key);
//            if(value instanceof JSONObject){
//                value = jsonObjectToTreeMap((JSONObject)value);
//            }
//            data.put(key, value);
//        }
//
//        return data;
//    }
//
//    public static String md5AndSalt(String dataStr,String salt)  {
//        try {
//            return MD5Utils.MD5(dataStr,salt);
//        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        throw new RuntimeException("加密验签失败！");
//    }

}

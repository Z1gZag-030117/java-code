package com.zz.utiles;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.SerializerFactory;

import java.text.SimpleDateFormat;

/**
 * @author 朱喆
 * @version 1.0
 */
public class JsonUtil {

    public static String getJson(Object object){
        return getJson(object,"yyyy-MM-dd HH:mm:ss");
    }

    public static String getJson(Object object, String simpleDateFormat){
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);
        SimpleDateFormat sdf = new SimpleDateFormat(simpleDateFormat);
        mapper.setDateFormat(sdf);
        try {
            return mapper.writeValueAsString(sdf);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

}

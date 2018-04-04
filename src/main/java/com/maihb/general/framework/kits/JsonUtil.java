package com.maihb.general.framework.kits;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * simon.wei
 * @param <T>
 */
public class JsonUtil<T> {

    public static final ObjectMapper mapper = new ObjectMapper();

    //将对象序列化
    public static <T> String toString (T object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    //反序列化
    public static <T> T toBean(String json, Class<T> tClass){
        try {
            return mapper.readValue(json, tClass);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


}

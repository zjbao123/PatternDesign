package com.Pattern.design.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Enzo Cotter on 2020/2/3.
 */
public class UrlUtil {
    public static class UrlEntity{
        private String baseurl;
        private Map<String, String> params;
        public String getBaseurl() {
            return baseurl;
        }


        public Map<String, String> getParams() {
            return params;
        }
    }

    public static UrlEntity prase(String url){
        UrlEntity urlEntity = new UrlEntity();
        if(url == null){
            return urlEntity;
        }
        url = url.trim();
        if(url.isEmpty()){
            return urlEntity;
        }

        String[] urlParts = url.split("\\?");
        urlEntity.baseurl = urlParts[0];
        if(urlParts.length ==1){
            return urlEntity;
        }
        String[] params = urlParts[1].split("&");
        urlEntity.params = new HashMap<>();
        for(String param : params){
            String[] keyValue = param.split("=");
            urlEntity.params.put(keyValue[0], keyValue[1]);
        }
        return urlEntity;
    }
}

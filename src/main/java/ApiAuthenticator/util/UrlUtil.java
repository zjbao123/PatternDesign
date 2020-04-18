package ApiAuthenticator.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zjbao123
 * @version 1.0
 * @since 2020-02-15 17:26:46
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

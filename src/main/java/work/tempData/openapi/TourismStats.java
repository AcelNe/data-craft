package work.tempData.openapi;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.*;

public class TourismStats {
    public static void main(String[] args) {
        try {
            StringBuilder urlBuilder = new StringBuilder("http://openapi.tour.go.kr/openapi/service/EdrcntTourismStatsService/getEdrcntTourismStatsList"); /*URL*/
            urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=8Ysr2Jhs+38CJevMrBGgtfFN3XPM0rTRu7ok9F6dKs84vFf3yN5o2E5nSboh500+YIREhaHUJFu1+QGTZxQGkA=="); /*Service Key*/
            urlBuilder.append("&" + URLEncoder.encode("YM","UTF-8") + "=" + URLEncoder.encode("201201", "UTF-8")); /*연월*/
            urlBuilder.append("&" + URLEncoder.encode("NAT_CD","UTF-8") + "=" + URLEncoder.encode("112", "UTF-8")); /*국가코드*/
            urlBuilder.append("&" + URLEncoder.encode("ED_CD","UTF-8") + "=" + URLEncoder.encode("E", "UTF-8")); /*출입국구분코드*/
            URL url = new URL(urlBuilder.toString());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-type", "application/json");
            System.out.println("result::"+conn.getResponseCode());
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (ProtocolException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

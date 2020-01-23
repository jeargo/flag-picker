package mx.flag.picker.service.util;


import org.springframework.http.HttpHeaders;


public class HeaderServiceUtil {

    private static final String CONSTANT_APP_ID = "X-flag-";
    private static final String CONSTANT_SUCCESS = "success";
    private static final String CONSTANT_ERROR = "error";


    public static HttpHeaders successMessage(String message, String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(CONSTANT_APP_ID+CONSTANT_SUCCESS, message);
        return headers;
    }

    public static HttpHeaders successHeader(String message) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(CONSTANT_APP_ID+CONSTANT_SUCCESS, message);
        return headers;
    }


    public static HttpHeaders headerError(String message, String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(CONSTANT_APP_ID+CONSTANT_ERROR, message);
        return headers;
    }
    
    public static HttpHeaders headerError(String message) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(CONSTANT_APP_ID+CONSTANT_ERROR, message);
        return headers;
    }
}

package kz.stolik.servicebackendstolik.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class HttpServletUtils {
    private static final String IP_HEADER = "X-Forwarded-For";

    public static Object getParam(String param) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        if (request.getParameter(param) != null)
            return request.getParameter(param);
        return null;
    }

    public static Object getPathVariable(String pathVariableName) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        Map<String, Object> params = (Map<String, Object>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        if (!params.isEmpty() && params.get(pathVariableName) != null) {
            return params.get(pathVariableName);
        }
        return null;
    }

    public static String getIpAddress(HttpServletRequest httpServletRequest) {
        String ip = httpServletRequest.getHeader(IP_HEADER);
        if (ip != null) {
            String[] ips = ip.split(",");
            ip = ips[0];
        }
        return ip;
    }

    public static String getHeaderParam(String param) {
        HttpServletRequest httpServletRequest = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        return httpServletRequest.getHeader(param);
    }

    public static String getIpAddress() {
        HttpServletRequest httpServletRequest = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String ip = httpServletRequest.getHeader(IP_HEADER);
        if (ip != null) {
            String[] ips = ip.split(",");
            ip = ips[0];
        }
        return ip;
    }
}

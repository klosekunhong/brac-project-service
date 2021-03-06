package com.mantis.brac.common.utils;

import com.alibaba.fastjson.util.IOUtils;
//import com.mantis.brac.aspect.WebLogAspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Description:
 * @author: wei.wang
 * @since: 2020/4/4 10:40
 * @history: 1.2020/4/4 created by wei.wang
 */
public class JsonUtil {

    private static Logger logger = LoggerFactory.getLogger(JsonUtil.class);

    /**
     * 获取传入JSON
     *
     * @param request
     * @return
     */
    public static StringBuilder getJson(HttpServletRequest request) {
        byte[] buf = new byte[1024];
        InputStream input = null;
        StringBuilder json = null;
        try {
            input = request.getInputStream();
            json = new StringBuilder();
            int size = 0;
            do {
                size = input.read(buf);
                if (size > 0) {
                    json.append(new String(buf, 0, size, IOUtils.UTF8));
                }
            } while (size > 0);
        } catch (IOException e) {
            logger.info("getJson {}", e.getMessage());
        }
        return json;
    }
}

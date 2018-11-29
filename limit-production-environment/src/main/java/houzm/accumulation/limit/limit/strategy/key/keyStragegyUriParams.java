package houzm.accumulation.limit.limit.strategy.key;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpMethod;

/**
 * Package: com.nair.pss.res.business.common.limit.strategy.key
 * Author: hzm_dream@163.com
 * Date: Created in 2018/11/7 16:28
 * Copyright: Copyright (c) 2018
 * Version: 0.0.1
 * Modified By:
 * Description： keyStragegyUriParams
 */
public class keyStragegyUriParams extends AbstractKeyStragegy {

    public keyStragegyUriParams(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String key() {
        String params = this.getRequestParams(request);
        String uri = request.getRequestURI().replace("/", "_");
//        String md5 = MD5.md5s(params);
//        return uri.concat("_").concat(md5);
        return uri.concat("_");
    }

    private String getRequestParams(HttpServletRequest request) {
        String result = "";
        if (request.getMethod().equals(HttpMethod.GET.name())) {
            Enumeration enu = request.getParameterNames();
            while (enu.hasMoreElements()) {
                String paraName = (String) enu.nextElement();
                result += paraName + ":" + request.getParameter(paraName) + ";";
            }
        } else if (request.getMethod().equals(HttpMethod.POST.name())) {
            InputStream is = null;
            try {
                is = request.getInputStream();
                result = IOUtils.toString(is, "utf-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

}

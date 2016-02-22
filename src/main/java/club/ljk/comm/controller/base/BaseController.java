package club.ljk.comm.controller.base;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 基础控制器
 * Created by lijk on 2015/11/24.
 */
public class BaseController {
    protected Logger log = Logger.getLogger(getClass());













    protected Map<String, Object> success() {
        return success(null);
    }
    protected Map<String, Object> success(String msg) {
        return success(msg, null);
    }
    protected Map<String, Object> success(String msg, Object data) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("code", HttpStatus.OK.value());
        resultMap.put("msg", StringUtils.isEmpty(msg)?HttpStatus.OK.getReasonPhrase():msg);
        resultMap.put("data", data);
        return resultMap;
}

    protected Map<String, Object> error() {
        return error(null);
    }
    protected Map<String, Object> error(String msg) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("code", HttpStatus.INTERNAL_SERVER_ERROR.value());
        resultMap.put("msg", StringUtils.isEmpty(msg)?HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase():msg);
        return resultMap;
    }
}

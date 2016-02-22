package club.ljk.comm.interceptor;

import club.ljk.comm.note.Token;
import club.ljk.comm.util.IDGenerator;
import org.springframework.http.HttpStatus;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 防止表单重复提交
 * Created by lijk on 2015/11/25.
 */
public class TokenInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            Token annotation = method.getAnnotation(Token.class);
            if (annotation != null) {
                boolean needSaveSession = annotation.save();
                if (needSaveSession) {
                    request.getSession(false).setAttribute("token", IDGenerator.getUUID());
                }
                boolean needRemoveSession = annotation.remove();
                if (needRemoveSession) {
                    if (isRepeatSubmit(request)) {
                        // TODO: 2016/1/15 表单重复提交，重定向提示页面
                        return false;
                    }
                    request.getSession(false).removeAttribute("token");
                }
            }
            return true;
        } else {
            return super.preHandle(request, response, handler);
        }
    }

    private boolean isRepeatSubmit(HttpServletRequest request) {
        String serverToken = (String) request.getSession(false).getAttribute("token");
        if (serverToken == null) {
            return true;
        }
        String clinetToken = request.getParameter("token");
        if (clinetToken == null) {
            return true;
        }else if (!serverToken.equals(clinetToken)) {
            return true;
        }
        return false;
    }
}

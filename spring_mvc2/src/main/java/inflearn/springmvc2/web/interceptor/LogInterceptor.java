package inflearn.springmvc2.web.interceptor;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Slf4j
public class LogInterceptor implements HandlerInterceptor {

    private static final String LOG_ID = "logId";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String requestURI = request.getRequestURI();
        String uuid = UUID.randomUUID().toString();

        // UUID를 전역 변수로 사용할 경우 싱글톤(공유하며 같이 사용하는 객체)이라 다른 트랜젝션 UUID로 변경이 될 수 있다.
        // 그래서 setAttribute를 통해 같은 UUID를 afterCompletion등 다른 메소드에 사용할 수 있게 해준다.
        request.setAttribute(LOG_ID, uuid);

        log.info("REQUEST [{}][{}][{}]", uuid, requestURI, handler);

        // @RequestMapping: HandlerMethod 사용
        // 정적 리소스: ResourceHttpRequestHandler 사용
        if (handler instanceof HandlerMethod){
            HandlerMethod hm = (HandlerMethod) handler; // 호출할 컨트롤러의 메소드의 metadata를 가지고있다.
        }

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
       log.info("postHandler [{}]", modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        String requestURI = request.getRequestURI();
        String logId = (String) request.getAttribute(LOG_ID);
        log.info("RESPONSE [{}][{}][{}]", logId, requestURI, handler);

        if(ex != null){
            log.error("afterCompletion error!!", ex);
        }
    }
}

package com.zhuyoupeng.zuulgateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthFilter extends ZuulFilter {
    /**
     * 过滤类型
     *  pre：路由之前
     *  routing：路由之时
     *  post： 路由之后
     *  error：发送错误调用
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤排序 zuul可以设置多个过滤器
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 添加是否过滤的条件
     * @return
     */
    @Override
    public boolean shouldFilter() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        //获取请求的URL
        String requestURI = request.getRequestURI();
        System.out.println(requestURI);
        if(requestURI.startsWith("/api/user")){
            return false;
        }
        return true;
    }

    /**
     * 过滤器的具体逻辑
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        //获取请求的URL
        String requestURI = request.getRequestURI();
        System.out.println("run"+requestURI);
        String token = request.getParameter("token");
        if(StringUtils.isEmpty(token)){
            // 表示不进行路由,不会被zuul转发到后端服务器
            requestContext.setSendZuulResponse(false);
            // http状态码，标识未授权
            requestContext.setResponseStatusCode(401);
            HttpServletResponse response = requestContext.getResponse();
            // 设置返回的内容类型
            response.setContentType("application/json;charset=utf-8");
            try {
                // 输出返回结果
                response.getWriter().write("{\"message\":\"未授权\"}");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}

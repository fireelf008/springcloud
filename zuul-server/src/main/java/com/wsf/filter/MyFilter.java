package com.wsf.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/2/4.
 */
public class MyFilter extends ZuulFilter {

    private static final Logger logger = LoggerFactory.getLogger(MyFilter.class);

    /**
     * 返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
     * pre：可以在请求被路由之前调用
     * routing：在路由请求时候被调用
     * error：处理请求时发生错误时被调用
     * post：在routing和error之后被调用
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 如果有多个过滤器，则通过int值来定义过滤器的执行顺序
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 返回一个boolean类型来判断该过滤器是否要执行，所以通过此函数可实现过滤器的开关
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体逻辑
     * ctx.setSendZuulResponse(false)令zuul过滤该请求
     * ctx.setResponseStatusCode(401)设置了其返回的错误码
     * ctx.setResponseBody(body)对返回body内容进行编辑
     * @return
     */
    @Override
    public Object run() {
//        RequestContext ctx = RequestContext.getCurrentContext();
//        HttpServletRequest request = ctx.getRequest();
//        logger.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
//        Object a = request.getParameter("a");
//        Object b = request.getParameter("b");
//        if(null == a || null == b) {
//            logger.warn("parameter error");
//            ctx.setSendZuulResponse(false);
//            ctx.setResponseStatusCode(500);
//            return null;
//        }
        logger.info("parameter ok");
        return null;
    }
}

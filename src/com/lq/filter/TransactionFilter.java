package com.lq.filter;

import com.lq.utils.JdbcUtils;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author qili
 * @create 2022-01-06-20:26
 */
public class TransactionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            chain.doFilter(request, response);
            JdbcUtils.commitAndClose();
        } catch (Exception e) {
            JdbcUtils.rollbackAndClose();
            e.printStackTrace();
            throw new RuntimeException(e);//抛给服务器
        }
    }

    @Override
    public void destroy() {

    }
}

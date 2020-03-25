package com.example.sample.sysbase.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

/**
 *　フィルタサンプル(その２).
 */
public class SampleFilter2 implements Filter {

    private Logger logger = LoggerFactory.getLogger(SampleFilter2.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.info("フィルタ2 start.");
        chain.doFilter(request, response);
        logger.info("フィルタ2 end.");
    }
}

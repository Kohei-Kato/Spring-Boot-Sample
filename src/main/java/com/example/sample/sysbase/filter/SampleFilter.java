package com.example.sample.sysbase.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

/**
 *　フィルタサンプル.
 */
public class SampleFilter implements Filter {

    private Logger logger = LoggerFactory.getLogger(SampleFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.info("フィルタ１ start.");
        chain.doFilter(request, response);
        logger.info("フィルタ１ end.");
    }
}

package com.example.sample.sysbase.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import javax.servlet.*;
import java.io.IOException;
import java.util.UUID;

/**
 *　フィルタサンプル.
 */
public class SampleFilter implements Filter {

    private Logger logger = LoggerFactory.getLogger(SampleFilter.class);

    final String KEY_UUID = "UUID";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        MDC.put(KEY_UUID, createUUID());

        logger.info("フィルタ１ start.");

        chain.doFilter(request, response);

        logger.info("KEY_UUID end.");

        MDC.remove(KEY_UUID);
    }

    private String createUUID(){
        return UUID.randomUUID().toString();
    }
}

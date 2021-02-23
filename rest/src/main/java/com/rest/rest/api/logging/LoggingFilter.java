package com.rest.rest.api.logging;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.AbstractRequestLoggingFilter;

import javax.servlet.http.HttpServletRequest;


@Component
public class LoggingFilter extends AbstractRequestLoggingFilter {

    @Value("${request.logging.shouldLog}")
    private boolean shouldLog;

    public LoggingFilter(){
        setIncludeClientInfo(true);
        setIncludeHeaders(true);
        setIncludePayload(true);
        setIncludeQueryString(true);
        setBeforeMessagePrefix("Request started => ");
        setAfterMessagePrefix("Request ended => ");
    }

    @Override
    protected boolean shouldLog(HttpServletRequest request) {
        return shouldLog;
    }

    @Override
    protected void beforeRequest(HttpServletRequest request, String message) {
        logger.info(message+ request.getHeader("Identificador"));
    }

    @Override
    protected void afterRequest(HttpServletRequest request, String message) {
        logger.info(message + request.getHeader("Identificador"));
    }


}

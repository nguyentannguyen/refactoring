package com.h2rd.refactoring.filter;

import com.h2rd.refactoring.exception.DAOException;
import com.h2rd.refactoring.exception.ValidationException;
import org.springframework.web.util.NestedServletException;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * User: Nguyen Tan Nguyen < nguyenabap at gmail dot com >
 * Date: 2014-08-06
 */
public class ExceptionHandlingFilter implements Filter{

    protected static final Logger log = Logger.getLogger( ExceptionHandlingFilter.class.getName());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (Exception e) {
            handleError((HttpServletResponse) servletResponse, e);
        }
    }

    @Override
    public void destroy() {}

    private void handleError(HttpServletResponse servletResponse, Exception e)  {
        if (e instanceof ValidationException){
            servletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        } if (e instanceof DAOException) {
            servletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        } else {
            servletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }

        writeResponse(servletResponse, e.getMessage());
    }

    private void writeResponse(HttpServletResponse response, String message){

        response.setContentType("application/json; charset=UTF-8");

        // write response
        Exception ee = null;
        try {
            PrintWriter out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "UTF8"), true);
            out.println(message);
        } catch (UnsupportedEncodingException e) {
            ee = e;
        } catch (IOException e) {
            ee = e;
        }

        if (null != ee) {
            log.log( Level.SEVERE, "could not write response", ee);
            try {
                response.sendError( HttpURLConnection.HTTP_INTERNAL_ERROR, ee.getMessage());
            } catch (IOException e) {
                log.log( Level.SEVERE, "could not send error message", e);
            }
        }

    }
}

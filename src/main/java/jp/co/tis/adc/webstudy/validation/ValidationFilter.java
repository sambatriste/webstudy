package jp.co.tis.adc.webstudy.validation;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ValidationFilter implements Filter {

    public static final String ERRORS = "errors";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest req,
                         ServletResponse res,
                         FilterChain filter) throws IOException, ServletException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) res;
        try {
            filter.doFilter(req, res);
        } catch (ForwardingValidationException e) {
            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            req.setAttribute(ERRORS, e.getResult());
            req.getRequestDispatcher(e.getForwardUri()).forward(req, res);
        } catch (ValidationException e) {
            httpServletResponse.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    @Override
    public void destroy() {

    }
}

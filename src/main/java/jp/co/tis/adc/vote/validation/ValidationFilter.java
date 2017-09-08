package jp.co.tis.adc.vote.validation;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: kawasaki
 * Date: 13/11/04
 * Time: 3:58
 */
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
        } catch (ValidationException e) {
            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            req.setAttribute(ERRORS, e.getResult());
            req.getRequestDispatcher(e.getForwardUri()).forward(req, res);
        } catch (BadRequestException e) {
            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            httpServletResponse.sendError(400);
        }
    }

    @Override
    public void destroy() {

    }
}

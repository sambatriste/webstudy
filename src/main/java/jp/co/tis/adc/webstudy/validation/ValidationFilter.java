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

/**
 * バリデーションの結果を反映するサーブレットフィルタ.
 *
 * バリデーション失敗時の例外{@link ValidationException}、
 * {@link ValidationException}を捕捉し、
 * リクエストスコープに、バリデーション結果を設定する。
 * （キー{@link #ERRORS}、値{@link ValidationResult}）
 * 設定された値は画面レンダリング時に使用できる。
 *
 * {@link ValidationException}を捕捉した場合、
 * その例外に設定されたフォワード先に遷移する。
 * ){@link ValidationException#getForwardUri()}
 *
 */
@WebFilter(urlPatterns = "*")
public class ValidationFilter implements Filter {

    /** バリデーション結果をリクエストスコープに設定する時のキー */
    public static final String ERRORS = "errors";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // NOP
    }


    @Override
    public void doFilter(ServletRequest req,
                         ServletResponse res,
                         FilterChain filter) throws IOException, ServletException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) res;
        try {
            filter.doFilter(req, res);
        } catch (ValidationException e) {
            req.setAttribute(ERRORS, e.getResult());
            httpServletResponse.setStatus(e.getStatusCode());
            req.getRequestDispatcher(e.getForwardUri())
               .forward(req, res);
        } catch (ClientErrorException e) {
            httpServletResponse.sendError(e.getStatusCode());
        }
    }



    @Override
    public void destroy() {
        // NOP
    }
}

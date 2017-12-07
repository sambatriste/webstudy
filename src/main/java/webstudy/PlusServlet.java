package webstudy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet(urlPatterns = "/plus")
public class PlusServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        BigDecimal x = new BigDecimal(req.getParameter("x"));
        BigDecimal y = new BigDecimal(req.getParameter("y"));

        BigDecimal ans = x.add(y);

        req.setAttribute("ans", ans);

        req.getRequestDispatcher("/02/plus/ans.jsp").forward(req, resp);
    }
}

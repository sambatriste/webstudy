package webstudy.member.servlet;

import webstudy.member.form.MemberInputForm;
import webstudy.member.serivce.MemberService;
import webstudy.validation.ValidationResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/** 登録 */
public class MemberRegister extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        MemberInputForm form = new MemberInputForm(req.getParameterMap());
        ValidationResult<MemberInputForm> result = form.validate();
        if (result.isError()) {
            req.setAttribute("member", form);
            req.setAttribute("errors", result);
            req.getRequestDispatcher("/pages/member/memberInput.jsp")
               .forward(req, resp);
            return;
        }

        MemberService service = new MemberService();
        service.register(form.toEntity());
        resp.sendRedirect("list");
    }
}

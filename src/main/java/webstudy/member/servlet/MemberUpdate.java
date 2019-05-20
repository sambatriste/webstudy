package webstudy.member.servlet;

import webstudy.member.form.MemberUpdateForm;
import webstudy.member.serivce.MemberService;
import webstudy.validation.ValidationResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/** 更新 */
public class MemberUpdate extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        MemberUpdateForm form = new MemberUpdateForm(req.getParameterMap());
        ValidationResult<MemberUpdateForm> result = form.validate();
        if (result.isError()) {
            req.setAttribute("member", form);
            req.setAttribute("errors", result);
            req.getRequestDispatcher("/pages/member/memberUpdate.jsp")
               .forward(req, resp);
            return;
        }
        new MemberService().update(form.toEntity());
        resp.sendRedirect("list");
    }
}

package webstudy.member.servlet;

import webstudy.entity.Member;
import webstudy.member.form.MemberFindForm;
import webstudy.member.serivce.MemberService;
import webstudy.validation.ValidationResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/** 変更 */
@WebServlet(urlPatterns = "/member/inputForUpdate")
public class MemberInputForUpdate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        MemberFindForm form = new MemberFindForm(req.getParameterMap());
        ValidationResult<MemberFindForm> result = form.validate();
        if (result.isError()) {
            resp.sendError(400);  // リクエスト改ざん以外発生しない.
            return;
        }
        Member member = new MemberService().findById(form.getMemberId());
        if (member == null) {
            resp.sendError(404);
            return;
        }
        req.setAttribute("member", member);
        req.getRequestDispatcher("/pages/member/memberUpdate.jsp")
           .forward(req, resp);
    }
}

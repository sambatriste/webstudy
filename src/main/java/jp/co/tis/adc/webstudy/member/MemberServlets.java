package jp.co.tis.adc.webstudy.member;


import jp.co.tis.adc.webstudy.entity.Member;
import jp.co.tis.adc.webstudy.util.SimpleBeanUtil;
import jp.co.tis.adc.webstudy.validation.ValidationExecutor;
import jp.co.tis.adc.webstudy.validation.ValidationResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * メンバーサーブレット。
 */
public class MemberServlets {

    /** インデックス */
    @WebServlet(urlPatterns = {"/member", "member/index"})
    public static class Index extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.getRequestDispatcher("/pages/member/index.jsp")
               .forward(req, resp);
        }
    }

    /** 一覧 */
    @WebServlet(urlPatterns = "/member/list")
    public static class MemberList extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                throws ServletException, IOException {

            MemberService service = new MemberService();
            List<Member> allMembers = service.getAllMembers();
            req.setAttribute("memberList", allMembers);
            req.getRequestDispatcher("/pages/member/memberList.jsp")
               .forward(req, resp);
        }
    }

    /** 入力 */
    @WebServlet(urlPatterns = "/member/inputForRegister")
    public static class MemberInputForRegister extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                throws ServletException, IOException {

            req.getRequestDispatcher("/pages/member/memberInput.jsp")
               .forward(req, resp);
        }
    }

    /** 登録 */
    @WebServlet(urlPatterns = "/member/register")
    public static class MemberRegister extends HttpServlet {
        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp)
                throws ServletException, IOException {

            Member member = SimpleBeanUtil.create(req.getParameterMap(), Member.class);
            ValidationResult<Member> result = ValidationExecutor.validate(member);
            if (result.isError()) {
                req.setAttribute("member", member);
                req.setAttribute("errors", result);
                req.getRequestDispatcher("/pages/member/memberInput.jsp")
                   .forward(req, resp);
                return;
            }

            MemberService service = new MemberService();
            service.register(member);
            resp.sendRedirect("list");
        }

    }

    /** 検索 */
    @WebServlet(urlPatterns = "/member/search")
    public static class MemberSearch extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                throws ServletException, IOException {

            MemberFindForm form = SimpleBeanUtil.create(req.getParameterMap(), MemberFindForm.class);
            ValidationResult<MemberFindForm> result = ValidationExecutor.validate(form);
            if (result.isError()) {
                resp.sendError(400);  // リクエスト改ざん以外発生しない.
                return;
            }
            Member member = new MemberService().findById(form.getParsedMemberId());
            if (member == null) {
                resp.sendError(404);
                return;
            }
            req.setAttribute("member", member);
            req.getRequestDispatcher("/pages/member/memberSearch.jsp")
               .forward(req, resp);
        }
    }

    /** 変更 */
    @WebServlet(urlPatterns = "/member/inputForUpdate")
    public static class MemberInputForUpdate extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                throws ServletException, IOException {

            MemberFindForm form = SimpleBeanUtil.create(req.getParameterMap(), MemberFindForm.class);
            ValidationResult<MemberFindForm> result = ValidationExecutor.validate(form);
            if (result.isError()) {
                resp.sendError(400);  // リクエスト改ざん以外発生しない.
                return;
            }
            Member member = new MemberService().findById(form.getParsedMemberId());
            if (member == null) {
                resp.sendError(404);
                return;
            }
            req.setAttribute("member", member);
            req.getRequestDispatcher("/pages/member/memberUpdate.jsp")
               .forward(req, resp);
        }
    }

    /** 更新 */
    @WebServlet(urlPatterns = "/member/update")
    public static class MemberUpdate extends HttpServlet {
        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp)
                throws ServletException, IOException {

            Member member = SimpleBeanUtil.create(req.getParameterMap(), Member.class);
            ValidationResult<Member> result = ValidationExecutor.validate(member);
            if (result.isError()) {
                req.setAttribute("member", member);
                req.setAttribute("errors", result);
                req.getRequestDispatcher("/pages/member/memberUpdate.jsp")
                   .forward(req, resp);
                return;
            }

            new MemberService().update(member);
            resp.sendRedirect("list");
        }
    }

}
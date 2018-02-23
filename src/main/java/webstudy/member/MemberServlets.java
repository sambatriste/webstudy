package webstudy.member;


import webstudy.entity.Dept;
import webstudy.entity.Member;
import webstudy.entity.MemberDept;
import webstudy.validation.ValidationResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * メンバーサーブレット。
 *
 * サーブレットを外部クラス(outer class)ではなく、staticなネストクラス(nested class)としているのは、
 * 小さいファイルの数が多くなることを防ぐためであり、それ以上の意味はない。
 * サーブレットは一つのURLパターンに対して1クラス必要となるため、このような形式としている。
 *
 * @see <a href="https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html">Nested Classes (The Java™ Tutorials > Learning the Java Language > Classes and Objects)</a>
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
            List<MemberDept> allMembers = service.getAllMembersWithDept();
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
            MemberService service = new MemberService();
            List<Dept> allDepts = service.getAllDepts();
            req.setAttribute("depts",allDepts);
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

    /** 検索 */
    @WebServlet(urlPatterns = "/member/search")
    public static class MemberSearch extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                throws ServletException, IOException {

            MemberFindForm form = new MemberFindForm(req.getParameterMap());
            ValidationResult<MemberFindForm> result = form.validate();
            if (result.isError()) {
                resp.sendError(400);  // リクエスト改ざん以外発生しない.
                return;
            }
            MemberDept member = new MemberService().findById(form.getMemberId());
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

            MemberFindForm form = new MemberFindForm(req.getParameterMap());
            ValidationResult<MemberFindForm> result = form.validate();
            if (result.isError()) {
                resp.sendError(400);  // リクエスト改ざん以外発生しない.
                return;
            }
            MemberDept member = new MemberService().findById(form.getMemberId());
            if (member == null) {
                resp.sendError(404);
                return;
            }
            MemberService service = new MemberService();
            List<Dept> allDepts = service.getAllDepts();
            req.setAttribute("depts",allDepts);
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

}
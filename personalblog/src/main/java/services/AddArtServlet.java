package services;

import dao.ArticleInfoDao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.UserInfo;
import utils.ResultJSONUtils;

@WebServlet({"/addart"})
public class AddArtServlet extends HttpServlet {
    public AddArtServlet() {
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int succ = -1;
        String msg = "";
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        if (title != null && content != null && !title.equals("") && !content.equals("")) {
            HttpSession session = req.getSession(false);
            if (session != null && session.getAttribute("userinfo") != null) {
                UserInfo userInfo = (UserInfo)session.getAttribute("userinfo");
                ArticleInfoDao articleInfoDao = new ArticleInfoDao();

                try {
                    succ = articleInfoDao.add(title, content, userInfo.getId());
                } catch (SQLException var11) {
                    var11.printStackTrace();
                }
            } else {
                msg = "非登录状态，请先登录。";
            }
        } else {
            msg = "非法请求：参数不完整";
        }

        HashMap<String, Object> result = new HashMap();
        result.put("succ", succ);
        result.put("msg", msg);
        ResultJSONUtils.write(resp, result);
    }
}

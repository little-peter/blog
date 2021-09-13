
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
import models.vo.ArticleInfoVO;
import utils.ResultJSONUtils;

@WebServlet({"/init"})
public class InitServlet extends HttpServlet {
    public InitServlet() {
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int succ = -1;
        String msg = "";
        ArticleInfoVO articleInfo = null;
        int id = Integer.parseInt(req.getParameter("id"));
        if (id > 0) {
            ArticleInfoDao articleInfoDao = new ArticleInfoDao();

            try {
                articleInfo = articleInfoDao.getArtById(id);
                succ = 1;
            } catch (SQLException var9) {
                var9.printStackTrace();
            }
        } else {
            msg = "无效参数";
        }

        HashMap<String, Object> result = new HashMap();
        result.put("succ", Integer.valueOf(succ));
        result.put("msg", msg);
        result.put("art", articleInfo);
        ResultJSONUtils.write(resp, result);
    }
}


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
import utils.ResultJSONUtils;

@WebServlet({"/addcount"})
public class AddCountServlet extends HttpServlet {
    public AddCountServlet() {
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int succ = -1;
        String msg = "";
        int id = Integer.parseInt(req.getParameter("id"));
        if (id > 0) {
            ArticleInfoDao dao = new ArticleInfoDao();

            try {
                succ = dao.upRcount(id);
            } catch (SQLException var8) {
                var8.printStackTrace();
            }
        } else {
            msg = "参数无效";
        }

        HashMap<String, Object> map = new HashMap();
        map.put("succ", succ);
        map.put("msg", msg);
        ResultJSONUtils.write(resp, map);
    }
}

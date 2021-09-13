
package services;

import dao.UserInfoDao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.UserInfo;
import utils.ResultJSONUtils;

public class LoginServlet extends HttpServlet {
    public LoginServlet() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int succ = -1;
        String msg = "";
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username != null && password != null && !username.equals("") && !password.equals("")) {
            UserInfoDao userInfoDao = new UserInfoDao();

            try {
                UserInfo userInfo = userInfoDao.getUser(username, password);
                if (userInfo.getId() > 0) {
                    succ = 1;
                    HttpSession session = request.getSession();
                    session.setAttribute("userinfo", userInfo);
                } else {
                    succ = 0;
                    msg = "用户名或密码输入错误";
                }
            } catch (SQLException var10) {
                var10.printStackTrace();
            }
        } else {
            msg = "非法请求：参数不完整";
        }

        HashMap<String, Object> result = new HashMap();
        result.put("succ", succ);
        result.put("msg", msg);
        ResultJSONUtils.write(response, result);
    }
}

package services;

import java.io.IOException;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.ResultJSONUtils;

@WebServlet({"/hello"})
public class HelloServlet extends HttpServlet {
    public HelloServlet() {
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int succ = -1;
        String msg = "";
        HashMap<String, Object> result = new HashMap();
        result.put("succ", Integer.valueOf(succ));
        result.put("msg", msg);
        ResultJSONUtils.write(resp, result);
    }
}

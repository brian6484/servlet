package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getParameterNames().asIterator()
                .forEachRemaining(paramName -> System.out.println(paramName+"=" + req.getParameter(paramName)));

//        if there are multiple usernames
        String[] usernames = req.getParameterValues("username");
        for (String username : usernames) {
            System.out.println(username);
        }
        resp.getWriter().write("hi");
    }
}

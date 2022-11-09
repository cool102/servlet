package exercise.servlet;

import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// BEGIN
public class WelcomeServlet extends HttpServlet {

   //@Override
   //protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   //    String responseMsq = "Hello, Hexlet!";
   //    PrintWriter out = resp.getWriter();
   //    out.println(responseMsq);
   //}

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {

        RequestDispatcher view = request.getRequestDispatcher("welcome.jsp");
        view.forward(request, response);
    }
}
// END

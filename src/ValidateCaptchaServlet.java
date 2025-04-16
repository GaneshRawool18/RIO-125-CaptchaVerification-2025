import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ValidateCaptchaServlet")
public class ValidateCaptchaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String storedCaptcha = (String) session.getAttribute("captcha");
        String userCaptcha = request.getParameter("userCaptcha");

        response.setContentType("application/json");

        if (storedCaptcha != null && storedCaptcha.equalsIgnoreCase(userCaptcha)) {
            response.getWriter().write("{\"success\": true, \"message\": \"CAPTCHA correct!\"}");
        } else {
            response.getWriter().write("{\"success\": false, \"message\": \"Incorrect CAPTCHA.\"}");
        }
    }
}

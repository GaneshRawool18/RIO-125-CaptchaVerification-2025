import java.io.IOException;
import java.util.Random;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/VerifyCaptchaServlet")
public class VerifyCaptchaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Set response headers first
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "0");

        // Generate CAPTCHA
        String captcha = generateCaptcha();

        // Store in session
        HttpSession session = request.getSession();
        session.setAttribute("captcha", captcha);

        // Write only the CAPTCHA text
        response.getWriter().print(captcha);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        
        HttpSession session = request.getSession();
        String sessionCaptcha = (String) session.getAttribute("captcha");
        String userCaptcha = request.getParameter("captchaInput");
        
        if (sessionCaptcha == null || !sessionCaptcha.equalsIgnoreCase(userCaptcha)) {
            response.getWriter().print("error");
        } else {
            response.getWriter().print("success");
            session.removeAttribute("captcha");
        }
    }

    private String generateCaptcha() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder captcha = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            captcha.append(chars.charAt(random.nextInt(chars.length())));
        }
        return captcha.toString();
    }
}
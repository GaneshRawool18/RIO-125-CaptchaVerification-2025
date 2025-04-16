# RIO-125-CaptchaVerification-2025
CAPTCHA Validation Web Application Form
This project is a stylish and interactive web-based form that includes CAPTCHA verification to enhance security. It validates user entries such as Username, Email, and Password, and uses CAPTCHA to prevent automated submissions.

🔐 Features
Stylish login form with background image and animations

CAPTCHA text fetched dynamically via a servlet (/Captcha/VerifyCaptchaServlet)

Colorful and animated CAPTCHA characters for better visibility

Password visibility toggle (👁️ icon)

Refresh CAPTCHA button (🔄)

Popup-based feedback on CAPTCHA validation

Responsive design suitable for desktop and mobile devices

🛠️ Technologies Used
HTML5, CSS3 for layout and styling

JavaScript for dynamic behavior and CAPTCHA validation

Animate.css for smooth UI animations

Java Servlet (backend) to generate and serve CAPTCHA (e.g., VerifyCaptchaServlet)

📁 Project Structure
bash
Copy
Edit
project/
│
├── index.html               # Main HTML file
├── bg.jpeg                  # Background image
├── captcha.png              # CAPTCHA box background
└── (Java backend required)  # /Captcha/VerifyCaptchaServlet - CAPTCHA generator servlet
🚀 How to Use
Start the backend servlet that returns a plain text CAPTCHA (e.g., using Java + Tomcat).

Open index.html in a web browser.

Enter your username, email, and password.

Type the CAPTCHA shown in the colorful animated text.

Click "Validate CAPTCHA" to submit.

A popup will show success or error based on CAPTCHA correctness.

⚙️ Backend Servlet Example (Java)
java
Copy
Edit
@WebServlet("/Captcha/VerifyCaptchaServlet")
public class VerifyCaptchaServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String captcha = generateCaptcha();
        response.setContentType("text/plain");
        response.getWriter().write(captcha);
    }

    private String generateCaptcha() {
        String chars = "ABCDEFGHJKLMNPQRSTUVWXYZ23456789";
        StringBuilder captcha = new StringBuilder();
        Random rnd = new Random();
        for (int i = 0; i < 6; i++) {
            captcha.append(chars.charAt(rnd.nextInt(chars.length())));
        }
        return captcha.toString();
    }
}
📌 Customization
You can change background and styles in the style section of the HTML.

Modify the CAPTCHA generation logic in the servlet as needed.

Add more fields or validations based on your project requirements.

📷 Preview
![alt text](image.png)
![alt text](image-1.png)

🙌 Credits
Developed by Ganesh Rawool
Animated effects provided by Animate.css


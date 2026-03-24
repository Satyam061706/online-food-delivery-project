package in.satyamsharma.foodiesapi.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Custom Error Controller to handle SPA routing for missing resources.
 * Instead of showing 404, it forwards to index.html to let React Router handle the path.
 */
@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());

            if (statusCode == 404) {
                String originalUri = (String) request.getAttribute(RequestDispatcher.FORWARD_REQUEST_URI);
                if (originalUri == null) {
                    originalUri = request.getRequestURI();
                }

                // If path starts with /admin, forward to admin SPA index
                if (originalUri.startsWith("/admin")) {
                    return "forward:/admin/index.html";
                }
                
                // For other non-API paths, forward to main SPA index
                if (!originalUri.startsWith("/api")) {
                    return "forward:/index.html";
                }
            }
        }
        return "error"; // Fallback to default error page
    }
}

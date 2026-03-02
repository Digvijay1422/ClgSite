package com.clg.Controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ErrorHandlingController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        Object status = request.getAttribute("javax.servlet.error.status_code");
        Object message = request.getAttribute("javax.servlet.error.message");
        Object exception = request.getAttribute("javax.servlet.error.exception");
        
        int statusCode = 500;
        String errorMessage = "An error occurred";
        
        if (status != null) {
            statusCode = Integer.parseInt(status.toString());
        }
        
        if (statusCode == 404) {
            errorMessage = "Page not found";
        } else if (statusCode == 500) {
            errorMessage = "Internal Server Error";
            if (exception != null) {
                errorMessage += ": " + exception.toString();
            }
        }
        
        // Log the error for debugging
        System.err.println("Error " + statusCode + ": " + errorMessage);
        if (exception != null) {
            ((Throwable) exception).printStackTrace();
        }
        
        model.addAttribute("statusCode", statusCode);
        model.addAttribute("errorMessage", errorMessage);
        
        return "error";
    }
}

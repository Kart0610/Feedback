package com.example.FeedbackApp.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class FeedbackController {

     @PostMapping("/submitFeedback")
    public String submitFeedback(@RequestParam String name,
                                 @RequestParam String book,
                                 @RequestParam String feedback) {
        System.out.println("Name: " + name);
        System.out.println("Book: " + book);
        System.out.println("Feedback: " + feedback);
        return "Feedback Saved";
    }
}
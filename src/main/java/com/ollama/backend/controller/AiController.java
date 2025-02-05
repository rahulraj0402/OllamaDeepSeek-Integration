package com.ollama.backend.controller;

import com.ollama.backend.impl.AiServiceImpl;
import com.ollama.backend.service.AiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api/v1/ai")
public class AiController {

    private AiService aiService;

    public AiController (AiService aiService){
        this.aiService = aiService;
    }

    @GetMapping()
    public ResponseEntity<String> askAi(
            @RequestParam(value = "query" , required = false , defaultValue = "How are you ? How can you help me ") String query
    ){

        String responce = aiService.askAi(query);
        return new ResponseEntity<>(responce , HttpStatus.OK);
    }

}

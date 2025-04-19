package com.example.sprbootw4.controllers;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class DefaultRestController {

    @GetMapping("/member/{teamId}/{memberId}")
    public Map<String, String> getMemberInfo(@PathVariable String teamId, @PathVariable String memberId) {
        Map<String, String> response = new HashMap<>();
        response.put("teamId", teamId);
        response.put("memberId", memberId);
        return response;
    }
}

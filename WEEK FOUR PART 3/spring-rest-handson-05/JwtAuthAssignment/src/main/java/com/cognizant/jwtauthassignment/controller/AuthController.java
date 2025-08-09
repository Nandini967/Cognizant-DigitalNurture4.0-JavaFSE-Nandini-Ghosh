package com.cognizant.jwtauthassignment.controller;

import com.cognizant.jwtauthassignment.model.AuthRequest;
import com.cognizant.jwtauthassignment.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthController {
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody AuthRequest req) {
        if ("user".equals(req.getUsername()) && "pwd".equals(req.getPassword())) {
            String token = jwtUtil.generateToken(req.getUsername());
            Map<String, String> map = new HashMap<>();
            map.put("token", token);
            return ResponseEntity.ok(map);
        } else {
            Map<String, String> err = new HashMap<>();
            err.put("error", "Invalid credentials");
            return ResponseEntity.status(401).body(err);
        }
    }
}

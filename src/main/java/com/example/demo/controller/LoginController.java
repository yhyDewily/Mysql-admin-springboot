package com.example.demo.controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
public class LoginController {

    @ResponseBody
    @CrossOrigin
    @PostMapping(value = "/api/login", produces = "application/json; charset=UTF-8")
    public Integer login(@Valid@RequestBody Map<String, String> map, BindingResult bindingResult){
        String logn = map.get("id");
        String pswd = map.get("pswd");
        if(bindingResult.hasErrors()) return 500;

        if (!logn.equals("16121755") && !pswd.equals("16121755")) return 400;

        return 200;
    }
}

package com.cognizant.loan;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class LoanController {

    @GetMapping("/loans/{number}")
    public Map<String, String> getAccount(@PathVariable String number) {
        Map<String, String> map = new HashMap<>();
        map.put("number", number);
        map.put("type", "car");
        map.put("loan", "400000");
        map.put("emi", "3285");
        map.put("tenure", "18");


        return map;
    }


}

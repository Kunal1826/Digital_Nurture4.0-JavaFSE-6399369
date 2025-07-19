package com.cognizant.account;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ServiceController {

    @GetMapping("/account/{number}")
    public Map<String, String> getAccount(@PathVariable String number) {
        Map<String, String> map = new HashMap<>();
        map.put("number", number);
        map.put("type", "savings");
        map.put("balance", "234343");

        return map;
    }


}

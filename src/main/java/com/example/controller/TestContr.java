package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.entity.UserInfo;
import com.example.service.UserService;


@RestController
@Controller
public class TestContr {

    @PostMapping("/get/online/licence")
    public String addNewUser(@RequestBody String s) {
        return "{\n" +
                "    \"code\": 0,\n" +
                "    \"message\": \"SUCCESS\",\n" +
                "    \"licenceKey\": \"[ {\\n  \\\"expirationDate\\\" : \\\"\\\",\\n  \\\"lastBuildDate\\\" : \\\"2027-03-09\\\",\\n  \\\"keys\\\" : [ \\\"2673686195\\\" ],\\n  \\\"version\\\" : \\\"4.6\\\",\\n  \\\"product\\\" : \\\"POS\\\",\\n  \\\"features\\\" : [ \\\"uds\\\", \\\"egais\\\", \\\"loyalty\\\", \\\"rsloyalty\\\", \\\"plazius\\\", \\\"loya\\\", \\\"heineken\\\", \\\"goldcrown\\\", \\\"loymax\\\",";
    }
}

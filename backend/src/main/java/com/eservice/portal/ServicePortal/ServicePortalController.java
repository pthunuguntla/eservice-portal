package com.eservice.portal.ServicePortal;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ServicePortalController {

    @Value("${admin_user}")
    private String admin_user;


    @Value("${admin_password}")
    private String admin_password;


    @Value("${customer_user}")
    private String customer_user;

    @Value("${customer_password}")
    private String customer_password;


    @CrossOrigin
    @PostMapping("/login")
    public Map<String, String> login( @RequestBody  Map<String, String> loginObj) {

        Map<String, String> resultObj = new HashMap();
        resultObj.put("type", null);
        String userName = loginObj.get("userName");
        String password = loginObj.get("password");

        if(userName.equalsIgnoreCase(admin_user) && password.equals(admin_password)){
            resultObj.put("type", "admin");
        }

        if(userName.equalsIgnoreCase(customer_user) && password.equals(customer_password)){
            resultObj.put("type", "customer");
        }
        return  resultObj;
    }
}

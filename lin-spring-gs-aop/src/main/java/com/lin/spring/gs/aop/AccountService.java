package com.lin.spring.gs.aop;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//creating interface that throws exception if the customer id not found

@Service public class AccountService {
    //storing account detail in the HashMap
    private static Map<String, Account> map = null;

    static {
        map = new HashMap<>();
        map.put("M4546779", new Account("10441117000", "Saving Account"));
        map.put("K2434567", new Account("10863554577", "Current Account"));
    }

    public Account getAccountByCustomerId(String customerId) throws Exception {
        if (customerId == null) {
            throw new Exception("Invalid! Customer Id");
        }
        Account account = null;
        Set<Map.Entry<String, Account>> entrySet = map.entrySet();
        for (Map.Entry<String, Account> entry : entrySet) {
            if (entry.getKey().equals(customerId)) {
                account = entry.getValue();
            }
        }
        return account;
    }
}

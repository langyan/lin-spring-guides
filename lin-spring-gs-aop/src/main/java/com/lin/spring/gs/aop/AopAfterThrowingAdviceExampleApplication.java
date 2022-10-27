package com.lin.spring.gs.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
// @EnableAspectJAutoProxy annotation enables support for handling the components marked with @Aspect annotation. It is
// similar to tag in the xml configuration.
@EnableAspectJAutoProxy(proxyTargetClass = true) public class AopAfterThrowingAdviceExampleApplication {
    public static void main(String[] args) {
        ConfigdurableApplicationContext ac =
            SpringApplication.run(AopAfterThrowingAdviceExampleApplication.class, args);
        // Fetching the account object from the application context
        AccountService accountService = ac.getBean(AccountService.class);
        Account account;
        try {
            // generating exception
            account = accountService.getAccountByCustomerId(null);
            if (account != null) {
                System.out.println(account.getAccountNumber() + "\t" + account.getAccountType());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            // e.printStackTrace();
        }
    }
}

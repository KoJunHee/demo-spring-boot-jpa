package me.jko.demospringbootjpa.v2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Transactional
public class ControllerV2 {

    @Autowired
    AccountRepository accountRepository;

    @GetMapping("v2/findAll")
    @ResponseBody
    public void findAllAccounts() {
        accountRepository.findAll().forEach(account -> System.out.println(account.getUsername()));
    }

    @GetMapping("v2/findOne")
    @ResponseBody
    public void findOneAccount(@RequestParam String username, @RequestParam String password) {
        accountRepository.findByUsernameAndPassword(username, password).forEach(account -> System.out.println(account.getUsername()));
    }


    @GetMapping("v2/myQuery")
    @ResponseBody
    public void findOneAccountByMyQuery(@RequestParam String username) {
        System.out.println(accountRepository.myQuery(username).getPassword());
    }


}

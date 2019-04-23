package me.jko.demospringbootjpa.v1;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Controller
@Transactional
public class ControllerV1 {


    @PersistenceContext
    EntityManager entityManager;

    @GetMapping("v1/save")
    @ResponseBody
    public void saveAccount(@RequestParam String name, @RequestParam String password) {
        entityManager.persist(new Account(name, password));
    }

    @GetMapping("v1/update")
    @ResponseBody
    public void clearAccount() {
        Account account = entityManager.find(Account.class, 1L);
        entityManager.persist(account);

        account.setUsername("aa");
        account.setUsername("bb");
        account.setUsername("aa");
    }

}

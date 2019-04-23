package me.jko.demospringbootjpa.v2;

import me.jko.demospringbootjpa.v1.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findByUsernameAndPassword(String username, String password);

    @Query("SELECT a FROM Account a WHERE a.username = :aa")
    Account myQuery(@Param("aa") String username);

}

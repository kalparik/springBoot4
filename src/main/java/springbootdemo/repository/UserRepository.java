package springbootdemo.repository;

import org.springframework.stereotype.Repository;
import ru.netology.springbootdemo.model.Authorities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {
    public List<Authorities> getUserAuthorities(String user, String password) {
        List<Authorities> authorities = new ArrayList<>();
        Map<String, String> account = new HashMap<>();
        account.put("Dima", "12345");
        account.put("Roma", "54321");
        account.put("Masha", "99999");

        if (account.containsKey(user) && account.get(user).equals(password)) {
            authorities.add(Authorities.READ);
            authorities.add(Authorities.WRITE);
            authorities.add(Authorities.DELETE);
        }
        return authorities;
    }
}

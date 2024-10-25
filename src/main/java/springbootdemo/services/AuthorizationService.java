package springbootdemo.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.netology.springbootdemo.exception.InvalidCredentials;
import ru.netology.springbootdemo.exception.UnauthorizedUser;
import ru.netology.springbootdemo.model.Authorities;
import ru.netology.springbootdemo.repository.UserRepository;
import ru.netology.springbootdemo.requests.UserRequest;

import java.util.List;

@Service
@AllArgsConstructor
public class AuthorizationService {
    //@Autowired - можно ли так?
    UserRepository userRepository;

    public List<Authorities> getAuthorities(UserRequest request) {
        String user = request.getUser();
        String password = request.getPassword();

        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}

package springbootdemo.controller;

import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.springbootdemo.model.Authorities;
import ru.netology.springbootdemo.requests.UserRequest;
import ru.netology.springbootdemo.services.AuthorizationService;

import java.util.List;

@RestController
@AllArgsConstructor
public class AuthorizationController {
    //@Autowired - можно ли так?
    AuthorizationService service;

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@Validated UserRequest request) {
        return service.getAuthorities(request);
    }
}

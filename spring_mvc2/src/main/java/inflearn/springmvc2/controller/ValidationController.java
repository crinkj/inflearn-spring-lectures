package inflearn.springmvc2.controller;

import inflearn.springmvc2.domain.Item;
import inflearn.springmvc2.domain.User;
import inflearn.springmvc2.repository.ItemRepository;
import inflearn.springmvc2.repository.UserRepository;
import inflearn.springmvc2.web.session.SessionConst;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/items")
public class ValidationController {

    private final ItemRepository itemRepository;
    private final UserRepository userRepository;

    @GetMapping
    public ResponseEntity loginUser(@Validated @ModelAttribute User user,
                                    HttpServletRequest request) {

        Optional<User> savedUser = userRepository.findUserByUserIdAndPassword(user);
        if (savedUser == null) {
            return new ResponseEntity<>(null, HttpStatus.OK);
        }

        HttpSession session = request.getSession();
        session.setAttribute(SessionConst.LOGIN_MEMBER, savedUser);

        return new ResponseEntity<>(savedUser.get().getUserId(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createItem(@Validated @ModelAttribute Item item, BindingResult bindingResult) {
        return new ResponseEntity<>(itemRepository.save(item).getId(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getItems() {
        return new ResponseEntity<>(itemRepository.findAll(), HttpStatus.OK);
    }
}

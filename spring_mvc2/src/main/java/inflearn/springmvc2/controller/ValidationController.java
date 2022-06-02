package inflearn.springmvc2.controller;

import inflearn.springmvc2.domain.Item;
import inflearn.springmvc2.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("v1/items")
@RequiredArgsConstructor
public class ValidationController {

    private final ItemRepository itemRepository;

    @PostMapping
    public ResponseEntity createItem(@ModelAttribute Item item){
        return new ResponseEntity<>(itemRepository.save(item).getId(), HttpStatus.OK);
    }
}

package inflearn.springmvc2.controller;

import inflearn.springmvc2.domain.Item;
import inflearn.springmvc2.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/items")
public class ValidationController {

    private final ItemRepository itemRepository;

    @PostMapping
    public ResponseEntity createItem(@Validated @ModelAttribute Item item, BindingResult bindingResult){
        return new ResponseEntity<>(itemRepository.save(item).getId(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getItems(){
        return new ResponseEntity<>(itemRepository.findAll(), HttpStatus.OK);
    }
}

package com.acheron.susach;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final EntityRepo repo;
    private final ValueRepo valueRepo;
    private final ValueGenerator generator;
    private final ValueMapper mapper;

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("users",repo.findAll());
        return "index";
    }

    @PostMapping("/addUser")
    public String addUser(@RequestParam String email, Model model){
        Integer first = repo.findAll().stream().map(User::getId).max(Integer::compareTo).orElse(0);
        User save = repo.save(new User(first + 1, email));
        generator.generate(save);
        return "redirect:/";
    }
    @GetMapping("/user/{id}")
    public String findById(@PathVariable Integer id,Model model){
        User user = repo.findById(id).orElseThrow();
        List<Value> value = valueRepo.findValuesByUser(user);
        model.addAttribute("values",value);
        model.addAttribute("user",user.getEmail());
        model.addAttribute("mapper",mapper);
        model.addAttribute("sum",value.stream().map(mapper::convert).map(e->e.getDayPrice()+e.getNightPrice()).reduce(Float::sum).orElse((float) 0L));
        return "user";
    }
}

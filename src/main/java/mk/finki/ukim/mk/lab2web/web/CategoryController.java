package mk.finki.ukim.mk.lab2web.web;

import mk.finki.ukim.mk.lab2web.domain.enums.Category;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "http://localhost:3000")
public class CategoryController {
    @GetMapping
    public List<Category> getAllCategories() {
        return Arrays.stream(Category.values()).toList();
    }
}

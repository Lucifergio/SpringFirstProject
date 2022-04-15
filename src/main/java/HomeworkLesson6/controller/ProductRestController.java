package HomeworkLesson6.controller;

import HomeworkLesson6.entity.Product;
import HomeworkLesson6.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductRestController {

    private final ProductService productService;

    @PostMapping("/create")
    public String processForm(Product product) {
       return productService.save(product).toString();
    }
    @GetMapping("/{id}")
    public String getProductId(@PathVariable Integer id) {

        return productService.findById(id).toString();
    }

    @GetMapping("/all")
    public String getAllProduct(Model model) {

        return productService.findAll().toString();
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable Integer id) {

        productService.deleteById(id);

        return productService.findById(id).toString() + " - deleted";
    }
}

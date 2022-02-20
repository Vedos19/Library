package com.example.library.controllers;

import com.example.library.services.implementation.BasketService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BasketController {

    private final BasketService basketService;

    public BasketController(BasketService basketService) {
        this.basketService = basketService;
    }


    @GetMapping("/basket")
    public String getBasket(Model model) {
        model.addAttribute("get_basket_books", this.basketService.getBasketBooks());
        return "basket";
    }

    @GetMapping("basket/remove/{book_id}")
    public String removeBook(@PathVariable int book_id) {
        basketService.removeBook(book_id);
        return "redirect:/basket";
    }
}

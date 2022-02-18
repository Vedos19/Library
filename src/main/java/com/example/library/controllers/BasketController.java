package com.example.library.controllers;

import com.example.library.services.BasketService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}

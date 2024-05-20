package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.service.CineMo;
import com.example.demo.service.CineMoService;

@Controller
public class CineMoController {

    @Autowired
    private CineMoService cineMoService;

    @GetMapping("/list")
    public String showCineMos(Model model) {
        model.addAttribute("CineMos", cineMoService.getAllCineMos());
        return "CineMoList";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("CineMo", new CineMo());
        return "login";
    }

    @PostMapping("/CineMos")
    public String addCineMo(@ModelAttribute CineMo cineMo) {
        cineMoService.saveCineMo(cineMo);
        return "redirect:/CineMos";
    }

    @GetMapping("/editCineMo/{id}")
    public String showEditCineMoForm(@PathVariable Long id, Model model) {
        CineMo cineMo = cineMoService.getCineMoById(id);
        model.addAttribute("CineMo", cineMo);
        return "editCineMo";
    }

    @PostMapping("/signup")
    public String handleSignup(@ModelAttribute CineMo cineMo) {
        cineMoService.saveCineMo(cineMo);
        return "redirect:/index"; // Redirect to /index
    }

    @GetMapping("/deleteCineMo/{id}")
    public String deleteCineMo(@PathVariable Long id) {
        cineMoService.deleteCineMo(id);
        return "redirect:/CineMos";
    }

    @GetMapping("/forgot")
    public String forgot() {
        return "forgot";
    }

    @GetMapping("/signup")
    public String showSignupForm(Model model) {
        model.addAttribute("CineMo", new CineMo());
        return "signup";
    }
    @GetMapping("/index")
    public String showIndexPage() {
        return "index";
    }


}

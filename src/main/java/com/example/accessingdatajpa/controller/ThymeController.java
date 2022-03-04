package com.example.accessingdatajpa.controller;

import com.example.accessingdatajpa.AddressBook;
import com.example.accessingdatajpa.AddressBookRespository;
import com.example.accessingdatajpa.BuddyInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ThymeController {
    private final AddressBookRespository addressBookRespository;

    @GetMapping("/getBook/{id}")
    public String getBook(@PathVariable Integer id, Model model) {
        AddressBook book = addressBookRespository.findById(id).orElse(null);
        if (book != null) {
            model.addAttribute("id", id);
            model.addAttribute("buddies", book.getBuddies());
        }
        return "book";
    }

    @GetMapping("/")
    public String getHome(Model model) {
        return "home";
    }

    @PostMapping("/create/book")
    public String createBook(@ModelAttribute AddressBook addressBook,
                             Model model) {
        addressBookRespository.save(addressBook);
        model.addAttribute("id", addressBook.getId());
        return "created";
    }

    @PostMapping("/getBook/{id}")
    public String addBuddy(@PathVariable Integer id,
                           @ModelAttribute BuddyInfo buddyInfo, Model model) {
        AddressBook book = addressBookRespository.findById(id).orElse(null);
        if (book != null) {
            book.addBuddy(buddyInfo);
            addressBookRespository.save(book);
            model.addAttribute("id", id);
            model.addAttribute("buddies", book.getBuddies());
            model.addAttribute("buddyInfo", new BuddyInfo());
        }
        return "book";
    }
}

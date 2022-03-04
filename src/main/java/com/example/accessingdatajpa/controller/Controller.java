package com.example.accessingdatajpa.controller;

import com.example.accessingdatajpa.AddressBook;

import com.example.accessingdatajpa.AddressBookRespository;
import com.example.accessingdatajpa.BuddyInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class Controller {
    @Autowired
    private AddressBookRespository addressBookRespository;

    @GetMapping(value = "/get/book/{id}")
    public AddressBook getBook(@PathVariable Integer id) {
        return addressBookRespository.findById(id).orElse(null);
    }

    @PostMapping("/create/book")
    public AddressBook createBook() {
        return addressBookRespository.save(new AddressBook());
    }

    @PostMapping(value = "/add-buddy/{id}", consumes =
            MediaType.APPLICATION_JSON_VALUE)
    public AddressBook addBuddy(@PathVariable Integer id,
                                @RequestBody BuddyInfo buddyInfo) {

        AddressBook book = addressBookRespository.findById(id).orElse(null);
        if (book != null) {
            book.addBuddy(buddyInfo);
            return addressBookRespository.save(book);
        }
        return null;
    }

    @DeleteMapping(value = "/addressBook/{bookID}/{budID}", consumes =
            MediaType.APPLICATION_JSON_VALUE)
    public AddressBook removeBuddy(@PathVariable Integer bookID,
                                   @PathVariable Integer budID) {
        AddressBook book = addressBookRespository.findById(bookID).orElse(null);
        if (book == null) {
            return null;
        }

        book.removeBuddy(budID);
        return addressBookRespository.save(book);
    }
}

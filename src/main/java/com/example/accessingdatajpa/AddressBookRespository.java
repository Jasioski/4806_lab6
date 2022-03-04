package com.example.accessingdatajpa;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface AddressBookRespository extends CrudRepository<AddressBook,
        Integer> {

    List<AddressBook> findByName(String name);
//    AddressBook findById(Integer id);
}
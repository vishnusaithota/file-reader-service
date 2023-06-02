package com.webservices.filereaderservice.controller;

import com.webservices.filereaderservice.model.Letter;
import com.webservices.filereaderservice.service.FileReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FileReaderController {

    @Autowired
    private FileReaderService fileReaderService;


    @GetMapping("/values")
    public List<Letter> getAllTheLetters(){
        return fileReaderService.readAllTheLetters();
    }

    @PostMapping
    public String addLetter(@RequestBody Letter letter){
        fileReaderService.addLetter(letter);
        return "Letter Inserted Successfully";
    }

    @GetMapping("/sync")
    public String addLetterSync(){
        fileReaderService.addLetterSync();
        return "File Read and Lines inserted successfully";
    }

    @GetMapping("/async")
    public String addLettersAsync(){
        fileReaderService.addLettersAsync();
        return "Success";
    }

}

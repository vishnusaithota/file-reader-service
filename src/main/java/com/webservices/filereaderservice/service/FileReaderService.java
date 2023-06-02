package com.webservices.filereaderservice.service;

import com.webservices.filereaderservice.model.Letter;
import com.webservices.filereaderservice.repository.FileReaderRepository;
import com.webservices.filereaderservice.utils.FileReaderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileReaderService {

    @Autowired
    private FileReaderRepository fileReaderRepository;
    @Value("${my.file1.path}")
    private String filepath1;
    @Value("${my.file2.path}")
    private String filepath2;
    @Value("${my.file3.path}")
    private String filepath3;


    public List<Letter> readAllTheLetters() {

        return fileReaderRepository.findAll();
    }

    public void addLetter(Letter letter) {
        fileReaderRepository.save(letter);
    }

    public void addLettersAsync() {
        FileReaderUtil.readFilesAsync(filepath1,filepath2,filepath3,fileReaderRepository);
    }

    public void addLetterSync() {
        List<Letter> l1 = FileReaderUtil.readValuesSync(filepath1);
        List<Letter> l2 = FileReaderUtil.readValuesSync(filepath2);
        List<Letter> l3 = FileReaderUtil.readValuesSync(filepath3);


        fileReaderRepository.saveAll(l1);
        fileReaderRepository.saveAll(l2);
        fileReaderRepository.saveAll(l3);
    }
}

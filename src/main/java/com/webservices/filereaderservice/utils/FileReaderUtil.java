package com.webservices.filereaderservice.utils;

import com.webservices.filereaderservice.model.Letter;
import com.webservices.filereaderservice.repository.FileReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Component
public class FileReaderUtil {

    @Autowired
    private FileReaderRepository fileReaderRepository;

    public static List<Letter> readValuesSync(String fileName) {

        List<String> lines = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lines.stream().map(line -> new Letter(line)).toList();
    }

    public static void readFilesAsync(String filePath1, String filePath2, String filePath3,FileReaderRepository fileReaderRepository) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Future<List<String>> future1 = executorService.submit(() -> readFile(filePath1,fileReaderRepository));
        Future<List<String>> future2 = executorService.submit(() -> readFile(filePath2,fileReaderRepository));
        Future<List<String>> future3 = executorService.submit(() -> readFile(filePath3,fileReaderRepository));

        executorService.shutdown();
    }

    private static Letter persist(String line) {
        return new Letter(line);
    }

    private static List<String> readFile(String filePath, FileReaderRepository fileReaderRepository) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                fileReaderRepository.save(new Letter(line));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lines;
    }

}


package com.webservices.filereaderservice.repository;

import com.webservices.filereaderservice.model.Letter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileReaderRepository extends JpaRepository<Letter,Long> {

}

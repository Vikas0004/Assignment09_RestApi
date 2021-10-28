package com.nagarro.assignment09.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.assignment09.entity_class.Books;

@Repository
public interface BookRepository extends JpaRepository<Books, Integer> {


}

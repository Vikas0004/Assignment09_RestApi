package com.nagarro.assignment09.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.assignment09.entity_class.Authors;


@Repository
public interface AuthorRepository extends JpaRepository<Authors, String>  {

}

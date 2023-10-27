package com.example.springbootactivemq.repositories;

import com.example.springbootactivemq.entities.WikiData;
import com.example.springbootactivemq.entities.WikiDataError;
import org.springframework.data.repository.CrudRepository;

public interface WikiDataErrorRepository extends CrudRepository<WikiDataError, Long> {
}

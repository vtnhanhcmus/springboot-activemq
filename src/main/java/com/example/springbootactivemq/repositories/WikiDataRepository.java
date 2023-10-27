package com.example.springbootactivemq.repositories;

import com.example.springbootactivemq.entities.WikiData;
import org.springframework.data.repository.CrudRepository;

public interface WikiDataRepository extends CrudRepository<WikiData, Long> {
}

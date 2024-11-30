package com.erik.webscrapper.repository;

import com.erik.webscrapper.model.Webpage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebpageRepository extends CrudRepository<Webpage, Integer> {

}

package com.tpe.service;

import com.tpe.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmService {

    @Autowired
    private FilmRepository filmRepository;
    public String getFilmCount() {
        return filmRepository.getFilmCount();
    }
}

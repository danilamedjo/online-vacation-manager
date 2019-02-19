package jwd.service;

import jwd.model.Vacation;

import java.util.List;

public interface VacationService {

    Vacation findOne(Long id);

    List<Vacation> findAll();

    Vacation save(Vacation vacation);

    Vacation remove(Long id);

}

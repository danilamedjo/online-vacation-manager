package jwd.service.impl;

import jwd.model.Vacation;
import jwd.repository.VacationRepository;
import jwd.service.VacationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class JpaVacationServiceImpl implements VacationService {

    @Autowired
    private VacationRepository vacationRepository;


    @Override
    public Vacation findOne(Long id) {
        return vacationRepository.findOne(id);
    }

    @Override
    public List<Vacation> findAll() {
        return vacationRepository.findAll();
    }

    @Override
    public Vacation save(Vacation vacation) {
        return vacationRepository.save(vacation);
    }

    @Override
    public Vacation remove(Long id) {

        Vacation vacation = vacationRepository.findOne(id);

        if(vacation != null){
            vacationRepository.delete(vacation);
        }

        return vacation;
    }
}

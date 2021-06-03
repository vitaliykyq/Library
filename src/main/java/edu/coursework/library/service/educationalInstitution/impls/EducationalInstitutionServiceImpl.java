package edu.coursework.library.service.educationalInstitution.impls;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    CivilServiceImpl 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.library.model.EducationalInstitution;
import edu.coursework.library.repository.EducationalInstitutionRepository;
import edu.coursework.library.service.educationalInstitution.interfaces.IEducationalInstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EducationalInstitutionServiceImpl implements IEducationalInstitutionService {

    @Autowired
    EducationalInstitutionRepository repository;

    @Override
    public EducationalInstitution getById(String id) {

        return repository.findById(id).orElse(null);
    }

    @Override
    public EducationalInstitution create(EducationalInstitution educationalInstitution) {
        educationalInstitution.setCreatedAt(new Date());
        return repository.save(educationalInstitution);
    }

    @Override
    public EducationalInstitution update(EducationalInstitution educationalInstitution) {
        educationalInstitution.setModifiedAt(new Date());
        educationalInstitution.setCreatedAt(repository.findById(educationalInstitution.getId())
                .orElse(null)
                .getCreatedAt());
        repository.save(educationalInstitution);
        return educationalInstitution;
    }

    @Override
    public EducationalInstitution delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<EducationalInstitution> getAll() {

        return repository.findAll();
    }
}

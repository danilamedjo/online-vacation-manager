package jwd.service.impl;

import jwd.model.Department;
import jwd.repository.DepartmentRepository;
import jwd.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class JpaDepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department findOne(Long id) {
        return departmentRepository.findOne(id);
    }

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department remove(Long id) {

        Department department = departmentRepository.findOne(id);

        if(department != null) {
            departmentRepository.delete(department);
        }

        return department;
    }
}

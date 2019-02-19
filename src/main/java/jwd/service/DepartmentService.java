package jwd.service;

import jwd.model.Department;

import java.util.List;

public interface DepartmentService {

    Department findOne(Long id);

    List<Department> findAll();

    Department save(Department department);

    Department remove(Long id);
}

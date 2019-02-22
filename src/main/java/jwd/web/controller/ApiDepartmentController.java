package jwd.web.controller;

import jwd.model.Department;
import jwd.service.DepartmentService;
import jwd.support.DepartmentToDepartmentDTO;
import jwd.web.dto.DepartmentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/departments")
public class ApiDepartmentController {


    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private DepartmentToDepartmentDTO toDTO;

    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> get(){

        List<Department> departments = departmentService.findAll();

        return new ResponseEntity<>(toDTO.convert(departments), HttpStatus.OK);
    }

}

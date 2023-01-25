package com.serviceapp.departmentservice.controller;

import com.serviceapp.departmentservice.dto.DepartmentDto;
import com.serviceapp.departmentservice.service.DepartmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentDto> addDepartment(@RequestBody DepartmentDto departmentDto){
        return new ResponseEntity<>(departmentService.addDepartment(departmentDto), HttpStatus.CREATED);
    }

    // Build Get Department REST API
    @GetMapping("{id}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable("id") long id){
        return new ResponseEntity<>(departmentService.getDepartmentById(id), HttpStatus.OK);
    }

    // Build Get Department REST API
    @GetMapping("/")
    public ResponseEntity<List<DepartmentDto>> getDepartments(){
        return new ResponseEntity<>(departmentService.getDepartments(), HttpStatus.OK);
    }

    // Build Update  Department By ID
    @PutMapping
    public ResponseEntity<DepartmentDto> updateDepartment(@RequestBody DepartmentDto departmentDto){
        return new ResponseEntity<>(departmentService.updateDepartment(departmentDto),HttpStatus.OK);
    }

    // Build Delete Department By ID
    @DeleteMapping("/{id}")
    public  ResponseEntity<String> deleteDepartmentById(@PathVariable("id") Long id){
        departmentService.deleteDepartmentById(id);
        return new ResponseEntity<>("Department Deleted ",HttpStatus.OK);
    }

}

package com.serviceapp.departmentservice.service;

import com.serviceapp.departmentservice.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {
    DepartmentDto addDepartment(DepartmentDto departmentDto);

    DepartmentDto getDepartmentById(long id);

    List<DepartmentDto> getDepartments();

    DepartmentDto updateDepartment(DepartmentDto departmentDto);

    void deleteDepartmentById(Long id);
}

package com.serviceapp.departmentservice.service.impl;

import com.serviceapp.departmentservice.dto.DepartmentDto;
import com.serviceapp.departmentservice.entity.Department;
import com.serviceapp.departmentservice.exception.ResourceNotFoundException;
import com.serviceapp.departmentservice.repository.DepartmentRepository;
import com.serviceapp.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private static final Logger LOGGER= LoggerFactory.getLogger(DepartmentServiceImpl.class);
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public DepartmentDto addDepartment(DepartmentDto departmentDto) {
        return modelMapper.map(departmentRepository.save(modelMapper.map(departmentDto, Department.class)),DepartmentDto.class);
    }

    @Override
    public DepartmentDto getDepartmentById(long id) {
        return modelMapper.map(departmentRepository.getReferenceById(id),DepartmentDto.class);
    }

    @Override
    public List<DepartmentDto> getDepartments() {
        return departmentRepository.findAll().stream().map(department -> modelMapper.map(department,DepartmentDto.class)).collect(Collectors.toList());
    }

    @Override
    public DepartmentDto updateDepartment(DepartmentDto departmentDto) {
        return modelMapper.map(departmentRepository.save(modelMapper.map(departmentDto, Department.class)),DepartmentDto.class);
    }

    @Override
    public void deleteDepartmentById(Long id) {
        departmentRepository.deleteById(id);
    }

}

package com.example.hello_shoes_02.service.impl;

import com.example.hello_shoes_02.dao.EmployeeRepo;
import com.example.hello_shoes_02.dto.EmployeeDTO;
import com.example.hello_shoes_02.entity.EmployeeEntity;
import com.example.hello_shoes_02.service.EmployeeService;
import com.example.hello_shoes_02.util.Mapping;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepo repo;
    private final Mapping mapping;


    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        return mapping.toEmployeeDTO(repo.save(mapping.toEmployee(employeeDTO)));
    }

    @Override
    public List<EmployeeDTO> getAllEmployee() {
        return mapping.toEmployeeDTOList(repo.findAll());
    }

    @Override
    public void deleteEmployee(String employeeId) {
        repo.deleteById(employeeId);
    }

    @Override
    public EmployeeDTO getSelectedEmployee(String employeeId) {
        Optional<EmployeeEntity> optionalEmployee = repo.findById(employeeId);
        return optionalEmployee.map(mapping::toEmployeeDTO).orElse(null);
    }

    @Override
    public EmployeeEntity updateEmployee(String id, EmployeeDTO updatedEmployee) {
        Optional<EmployeeEntity> optionalEmployee = repo.findById(id);
        if(optionalEmployee.isPresent()){
            EmployeeEntity existingEmployee = optionalEmployee.get();

            existingEmployee.setEmployeeId(updatedEmployee.getEmployeeId());
            existingEmployee.setEmp_Name(updatedEmployee.getEmp_Name());
            existingEmployee.setProfile_pic(updatedEmployee.getProfile_pic());
            existingEmployee.setEmp_DOB(updatedEmployee.getEmp_dob());
            existingEmployee.setCivil_status(updatedEmployee.getCivil_status());
            existingEmployee.setGender(updatedEmployee.getGender());
            existingEmployee.setMobile(updatedEmployee.getMobile());
            existingEmployee.setEmail(updatedEmployee.getEmail());
            existingEmployee.setGuardian(updatedEmployee.getGuardian());
            existingEmployee.setEmergency_no(updatedEmployee.getEmergency_no());
            existingEmployee.setBuilding_no(updatedEmployee.getBuilding_no());
            existingEmployee.setLane(updatedEmployee.getLane());
            existingEmployee.setCity(updatedEmployee.getCity());
            existingEmployee.setState(updatedEmployee.getState());
            existingEmployee.setPostal_code(updatedEmployee.getPostal_code());
            existingEmployee.setDesignation(updatedEmployee.getDesignation());
            existingEmployee.setJoin_date(updatedEmployee.getJoin_date());
            existingEmployee.setBranch(updatedEmployee.getBranch());
            existingEmployee.setRole(updatedEmployee.getRole());

            return repo.save(existingEmployee);
        }else {
            return null;
        }

    }
}

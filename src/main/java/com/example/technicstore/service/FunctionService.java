package com.example.technicstore.service;

import com.example.technicstore.entity.Function;
import com.example.technicstore.repository.FunctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FunctionService {

    @Autowired
    private FunctionRepository functionRepository;

    public List<Function> getAllFunctions() {
        return functionRepository.findAll();
    }

    public Optional<Function> getFunctionById(Long id) {
        return functionRepository.findById(id);
    }

    // Tìm chức năng theo chính xác theo tên
    public Optional<Function> getFunctionByName(String name) {
        return functionRepository.findFunctionByName(name);
    }

    // Tìm các chức năng gần đúng theo tên
    public List<Function> getFunctionsByNameContaining(String name) {
        return functionRepository.findFunctionByNameContainingIgnoreCase(name);
    }

    public Function createFunction(Function function) {
        return functionRepository.save(function);
    }

    public Function updateFunction(Long id, Function updatedFunction) {
        Optional<Function> functionOptional = functionRepository.findById(id);
        if (functionOptional.isPresent()) {
            Function existingFunction = functionOptional.get();
            existingFunction.setName(updatedFunction.getName());
            return functionRepository.save(existingFunction);
        }
        return null;
    }

    public void deleteFunction(Long id) {
        functionRepository.deleteById(id);
    }
}

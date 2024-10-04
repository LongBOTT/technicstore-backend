package com.example.technicstore.controller;

import com.example.technicstore.entity.Function;
import com.example.technicstore.service.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/functions")
public class FunctionController {

    @Autowired
    private FunctionService functionService;

    @GetMapping
    public List<Function> getAllFunctions() {
        return functionService.getAllFunctions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Function> getFunctionById(@PathVariable Long id) {
        Optional<Function> function = functionService.getFunctionById(id);
        return function.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    // Tìm các chức năng gần đúng theo tên chứa chuỗi name
    @GetMapping("/search/name/containing")
    public List<Function> searchFunctionsByNameContaining(@RequestParam String name) {
        return functionService.getFunctionsByNameContaining(name);
    }
  // Tìm các chức năng theo tên chính xác
    @GetMapping("/search/name/exact")
    public ResponseEntity<Function> searchFunctionsByName(@RequestParam String name) {
        Optional<Function> function = functionService.getFunctionByName(name);
        return function.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping
    public ResponseEntity<Function> createFunction(@RequestBody Function function) {
        Function createdFunction = functionService.createFunction(function);
        return ResponseEntity.ok(createdFunction);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Function> updateFunction(@PathVariable Long id, @RequestBody Function function) {
        Function updatedFunction = functionService.updateFunction(id, function);
        if (updatedFunction != null) {
            return ResponseEntity.ok(updatedFunction);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFunction(@PathVariable Long id) {
        functionService.deleteFunction(id);
        return ResponseEntity.noContent().build();
    }
}

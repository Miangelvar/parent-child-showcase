package com.example.parentchildshowcase.rest;

import com.example.parentchildshowcase.service.ParentService;
import com.example.parentchildshowcase.persistence.Parent;
import com.example.parentchildshowcase.persistence.ParentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/parent")
@RestController
@RequiredArgsConstructor
public class ParentController {
    @Autowired
    private final ParentRepository parentRepository;

    @Autowired
    private final ParentService parentService;

    @PostMapping
    public ResponseEntity<Parent> saveParentWithChild(@RequestBody ParentDto parentDto){
        return ResponseEntity.ok(
                parentService.save(parentDto)
        );
    }

    @PostMapping("/save-multiple")
    public ResponseEntity<Parent> saveParentWithChildren(@RequestBody ParentWithMultipleChildrenDto parentDto){
        return ResponseEntity.ok(
                parentService.saveWithMultipleChildren(parentDto)
        );
    }

    @GetMapping
    public ResponseEntity<List<Parent>> getParents() {
        return ResponseEntity.ok(parentRepository.findAll());
    }
}

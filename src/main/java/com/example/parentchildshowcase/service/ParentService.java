package com.example.parentchildshowcase.service;

import com.example.parentchildshowcase.persistence.Child;
import com.example.parentchildshowcase.persistence.Parent;
import com.example.parentchildshowcase.rest.ParentDto;
import com.example.parentchildshowcase.persistence.ParentRepository;
import com.example.parentchildshowcase.rest.ParentWithMultipleChildrenDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ParentService implements ParentCreator {

    @Autowired
    private final ParentRepository parentRepository;

    public Parent save(ParentDto parentDto) {
        var parent = new Parent();
        var child = new Child();

        parent.setName(parentDto.getParentName());

        child.setChildName(parentDto.getChildName());
        child.setParent(parent);

        parent.getChildren().add(child);

        return parentRepository.save(parent);
    }

    @Override
    public void save(Parent parent) {

    }

    @Override
    public Parent saveWithMultipleChildren(ParentWithMultipleChildrenDto request) {
        var parent = new Parent();
        parent.setName(request.getParentName());

        parent.setChildren(request.getChildrenDto().stream()
                .map(childDto -> Child.builder()
                        .childName(childDto.getChildName())
                        .parent(parent)
                        .build())
                .collect(Collectors.toList())
        );
        return parentRepository.save(parent);
    }
}

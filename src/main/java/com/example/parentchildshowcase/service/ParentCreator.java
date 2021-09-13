package com.example.parentchildshowcase.service;

import com.example.parentchildshowcase.persistence.Parent;
import com.example.parentchildshowcase.rest.ParentWithMultipleChildrenDto;

public interface ParentCreator {
    void save(Parent parent);
    Parent saveWithMultipleChildren(ParentWithMultipleChildrenDto request);
}

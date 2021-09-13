package com.example.parentchildshowcase.rest;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class ParentWithMultipleChildrenDto {
    private String parentName;
    List<ChildDto> childrenDto;
}

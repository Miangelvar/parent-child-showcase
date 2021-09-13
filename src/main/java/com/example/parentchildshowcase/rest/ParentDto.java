package com.example.parentchildshowcase.rest;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ParentDto {
    private String parentName;
    private String childName;
}

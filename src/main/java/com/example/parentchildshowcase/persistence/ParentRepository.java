package com.example.parentchildshowcase.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ParentRepository extends JpaRepository<Parent, Long> {
}
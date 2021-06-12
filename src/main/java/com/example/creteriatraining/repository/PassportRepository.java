package com.example.creteriatraining.repository;

import com.example.creteriatraining.domain.Course;
import com.example.creteriatraining.domain.Passport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassportRepository extends JpaRepository<Passport, Long> {
}

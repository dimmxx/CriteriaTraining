package com.example.creteriatraining.repository.creteria;

import com.example.creteriatraining.domain.Passport;
import com.example.creteriatraining.domain.Passport_;
import com.example.creteriatraining.domain.Student;
import com.example.creteriatraining.domain.Student_;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.NonNull;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class StudentSpecifications {

    public static Specification<Student> studentByPassportSerial(String passportSerial) {
        return new Specification<>() {
            @Override
            public Predicate toPredicate(@NonNull Root<Student> root,
                                         @NonNull CriteriaQuery<?> query,
                                         @NonNull CriteriaBuilder criteriaBuilder) {
                Join<Student, Passport> passportJoin = root.join(Student_.passport, JoinType.LEFT);
                return criteriaBuilder.equal(passportJoin.get(Passport_.passportSerial), passportSerial);
            }
        };
    }
}


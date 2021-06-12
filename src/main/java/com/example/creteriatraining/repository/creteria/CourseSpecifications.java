package com.example.creteriatraining.repository.creteria;

import com.example.creteriatraining.domain.Course;
import com.example.creteriatraining.domain.Course_;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.NonNull;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class CourseSpecifications {

    public static Specification<Course> nameLike(String name){
        return new Specification<Course>() {
            @Override
            public Predicate toPredicate(@NonNull Root<Course> root,
                                         @NonNull CriteriaQuery<?> query,
                                         @NonNull CriteriaBuilder criteriaBuilder) {
                root.fetch(Course_.students, JoinType.LEFT);
                Predicate predicate = criteriaBuilder.like(root.get(Course_.title), "%"+name+"%");
                return predicate;
            }
        };
    }

    public static Specification<Course> fetchStudents(){
        return new Specification<Course>() {
            @Override
            public Predicate toPredicate(@NonNull Root<Course> root,
                                         @NonNull CriteriaQuery<?> query,
                                         @NonNull CriteriaBuilder criteriaBuilder) {
                root.fetch(Course_.students, JoinType.LEFT);
                return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
            }
        };
    }





}


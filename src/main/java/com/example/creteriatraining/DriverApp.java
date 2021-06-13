package com.example.creteriatraining;

import com.example.creteriatraining.domain.Course;
import com.example.creteriatraining.domain.Student;
import com.example.creteriatraining.repository.CourseRepository;
import com.example.creteriatraining.repository.PassportRepository;
import com.example.creteriatraining.repository.ReviewRepository;
import com.example.creteriatraining.repository.StudentRepository;
import com.example.creteriatraining.repository.creteria.CourseSpecifications;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.creteriatraining.repository.creteria.CourseSpecifications.*;
import static com.example.creteriatraining.repository.creteria.CourseSpecifications.fetchStudents;
import static org.springframework.data.jpa.domain.Specification.*;

@Service
@Slf4j
@Builder
public class DriverApp {

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    private final ReviewRepository reviewRepository;
    private final PassportRepository passportRepository;

    public DriverApp(CourseRepository courseRepository,
                     StudentRepository studentRepository,
                     ReviewRepository reviewRepository,
                     PassportRepository passportRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
        this.reviewRepository = reviewRepository;
        this.passportRepository = passportRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void startUp(){

        List<Course> list = courseRepository.findAll(where(fetchStudents().and(fetchReviews())));
        System.out.println();


    }





}

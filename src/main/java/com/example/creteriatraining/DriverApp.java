package com.example.creteriatraining;

import com.example.creteriatraining.repository.CourseRepository;
import com.example.creteriatraining.repository.PassportRepository;
import com.example.creteriatraining.repository.ReviewRepository;
import com.example.creteriatraining.repository.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.List;

import static com.example.creteriatraining.service.util.LibraryReader.readFile;
import static com.example.creteriatraining.service.util.LibraryReader.readFileInputStream;

@Service
@Slf4j
@Builder
public class DriverApp {

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    private final ReviewRepository reviewRepository;
    private final PassportRepository passportRepository;
    private final ResourceLoader resourceLoader;

    public DriverApp(CourseRepository courseRepository, StudentRepository studentRepository, ReviewRepository reviewRepository, PassportRepository passportRepository, ResourceLoader resourceLoader) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
        this.reviewRepository = reviewRepository;
        this.passportRepository = passportRepository;
        this.resourceLoader = resourceLoader;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void startUp() throws IOException {

        // List<Course> list = courseRepository.findAll(where(fetchStudents().and(fetchReviews())));
        // System.out.println();

        Resource resource = resourceLoader.getResource("classpath:library.md");
        InputStream inputStream = resource.getInputStream();

        System.out.println();

        List<String> reviews = readFileInputStream(inputStream, Charset.defaultCharset());
        System.out.println("FILE:" + reviews);
    }


}

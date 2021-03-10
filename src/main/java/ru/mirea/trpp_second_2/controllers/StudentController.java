package ru.mirea.trpp_second_2.controllers;

import com.opencsv.bean.CsvToBeanBuilder;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import ru.mirea.trpp_second_2.entity.Student;

import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;

/** Контроллер для работы со студентами. */
@Controller("/student")
public class StudentController {

    /** Список студентов. */
    private final List<Student> studentList;

    /** Конструктор. */
    public StudentController() {
        studentList = new CsvToBeanBuilder<Student>(new InputStreamReader(this.getClass().getResourceAsStream("/MOCK_DATA.csv"))).withType(Student.class).build().parse();
    }

    /**
     * Получить список студентов.
     * @return список студентов
     */
    @Get()
    public HttpResponse<List<Student>> getStudents() {
        return HttpResponse.ok(studentList);
    }

    /**
     * Найти студента по идентификатору.
     * @param id идентификатор студента
     * @return Студент, если есть, иначе 404 ошибка
     */
    @Get("/{id}")
    public HttpResponse<Student> findById(Long id) {
        Optional<Student> result = studentList.stream().filter(it -> it.getId().equals(id)).findAny();
        if (result.isPresent()) {
            return HttpResponse.ok(result.get());
        } else {
            return HttpResponse.notFound();
        }
    }
}

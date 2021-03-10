package ru.mirea.trpp_second_2.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.opencsv.bean.CsvBindByName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/** Сущность сотрудника. */
@Getter
@Setter
@ToString
public class Student {
    /** Идентификатор. */
    @JsonProperty("id")
    @CsvBindByName(column = "id")
    private Long id;
    /** Имя. */
    @JsonProperty("firstName")
    @CsvBindByName(column = "first_name")
    private String firstName;
    /** Фамилия. */
    @JsonProperty("lastName")
    @CsvBindByName(column = "last_name")
    private String lastName;
    /** email. */
    @JsonProperty("email")
    @CsvBindByName(column = "email")
    private String email;
    /** Пол. */
    @JsonProperty("gender")
    @CsvBindByName(column = "gender")
    private String gender;
    /** Университет. */
    @JsonProperty("university")
    @CsvBindByName(column = "university")
    private String university;
    /** Дата рождения. */
    @JsonProperty("birthDate")
    @CsvBindByName(column = "birth_date")
    private String birthDate;

}

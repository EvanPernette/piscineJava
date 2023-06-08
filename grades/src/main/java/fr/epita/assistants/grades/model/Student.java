package fr.epita.assistants.grades.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
public record Student(String name, int age, List<Grade> grades) {}
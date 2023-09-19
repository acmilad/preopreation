package com.diapo.preop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PatientDto {
    String firstName;
    String lastName;
    private Integer age;
    private Long unitNo;
}

package com.edstem.contactManagement.GlobalExceptionController;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionMsg {

    private String msg;
    private String httpResponse;
    private LocalDate date;
}

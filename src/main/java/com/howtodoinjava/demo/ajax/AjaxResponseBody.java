package com.howtodoinjava.demo.ajax;

import com.howtodoinjava.demo.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AjaxResponseBody {

    private String msg;
    private List<Employee> result;
}
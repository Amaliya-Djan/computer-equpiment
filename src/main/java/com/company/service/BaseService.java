package com.company.service;

import com.company.dtos.DataDTO;
import com.company.dtos.ResponseEntity;

import java.util.List;

public interface BaseService<T> {
    ResponseEntity<DataDTO<List<T>>> findAll(String sort);

    ResponseEntity<DataDTO<T>> findByID(Long id);

    ResponseEntity<DataDTO<List<T>>> findByColor(String color);

    ResponseEntity<DataDTO<List<T>>> filterByPrice(Double min, Double max);
}

package com.company.service;

import com.company.dao.MouseDao;
import com.company.domain.Mouse;
import com.company.dtos.AppErrorDTO;
import com.company.dtos.DataDTO;
import com.company.dtos.ResponseEntity;
import com.company.exceptions.GenericNotFoundException;

import java.util.Comparator;
import java.util.List;

public class MouseService implements BaseService<Mouse> {

    private final MouseDao dao = new MouseDao();

    @Override
    public ResponseEntity<DataDTO<List<Mouse>>> findAll(String sort) {
        try {
            List<Mouse> mouseList = dao.findAll();
            if (mouseList.isEmpty()) {
                throw new GenericNotFoundException("Mouses not found!");
            }
            switch (sort) {
                case "1" -> mouseList.sort(Comparator.comparing(Mouse::getId));
                case "2" -> mouseList.sort(Comparator.comparing(Mouse::getPrice));
            }
            return new ResponseEntity<>(new DataDTO<>(mouseList), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    @Override
    public ResponseEntity<DataDTO<Mouse>> findByID(Long id) {
        try {
            Mouse mouse = dao.findAll().stream().filter(mouse1 ->
                    mouse1.getId().equals(id)).findFirst().orElse(null);
            if (mouse == null) {
                throw new GenericNotFoundException("Mouse not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(mouse), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    @Override
    public ResponseEntity<DataDTO<List<Mouse>>> findByColor(String color) {
        try {
            List<Mouse> mouses = dao.findAll().stream().filter(mouse ->
                    mouse.getColor().equals(color)).toList();
            if (mouses.isEmpty()) {
                throw new GenericNotFoundException("Mouse not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(mouses), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    @Override
    public ResponseEntity<DataDTO<List<Mouse>>> filterByPrice(Double min, Double max) {
        try {
            List<Mouse> mouses = dao.findAll().stream().filter(mouse ->
                    mouse.getPrice() >= min && mouse.getPrice() <= max).toList();
            if (mouses.isEmpty()) {
                throw new GenericNotFoundException("Mouse not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(mouses), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    public ResponseEntity<DataDTO<List<Mouse>>> findByWireLess(String wireless) {
        try {
            List<Mouse> mouseList = dao.findAll();
            if (mouseList.isEmpty()) {
                throw new GenericNotFoundException("Mouses not found!");
            }
            switch (wireless) {
                case "yes" -> {
                    return new ResponseEntity<>(new DataDTO<>(mouseList.stream().filter(mouse ->
                            mouse.getWireless().equals(true)).toList()), 200);
                }
                case "no" -> {
                    return new ResponseEntity<>(new DataDTO<>(mouseList.stream().filter(mouse ->
                            mouse.getWireless().equals(false)).toList()), 200);
                }
            }
            return new ResponseEntity<>(new DataDTO<>(mouseList), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }
}

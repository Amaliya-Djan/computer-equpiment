package com.company.service;

import com.company.dao.KeyboardDao;
import com.company.domain.Keyboard;
import com.company.dtos.AppErrorDTO;
import com.company.dtos.DataDTO;
import com.company.dtos.ResponseEntity;
import com.company.exceptions.GenericNotFoundException;

import java.util.Comparator;
import java.util.List;

public class KeyboardService implements BaseService<Keyboard> {

    private final KeyboardDao dao = new KeyboardDao();

    @Override
    public ResponseEntity<DataDTO<List<Keyboard>>> findAll(String sort) {
        try {
            List<Keyboard> keyboards = dao.findAll();
            if (keyboards.isEmpty()) {
                throw new GenericNotFoundException("Keyboards not found!");
            }
            switch (sort) {
                case "1" -> keyboards.sort(Comparator.comparing(Keyboard::getId));
                case "2" -> keyboards.sort(Comparator.comparing(Keyboard::getPrice));
            }
            return new ResponseEntity<>(new DataDTO<>(keyboards));
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    @Override
    public ResponseEntity<DataDTO<Keyboard>> findByID(Long id) {
        try {
            Keyboard keyboard = dao.findAll().stream().filter(keyboard1 ->
                    keyboard1.getId().equals(id)).findFirst().orElse(null);
            if (keyboard == null) {
                throw new GenericNotFoundException("Keyboard not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(keyboard), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    @Override
    public ResponseEntity<DataDTO<List<Keyboard>>> findByColor(String color) {
        try {
            List<Keyboard> keyboards = dao.findAll().stream().filter(keyboard ->
                    keyboard.getColor().equals(color)).toList();
            if (keyboards.isEmpty()) {
                throw new GenericNotFoundException("Keyboard not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(keyboards), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    @Override
    public ResponseEntity<DataDTO<List<Keyboard>>> filterByPrice(Double min, Double max) {
        try {
            List<Keyboard> keyboards = dao.findAll().stream().filter(keyboard ->
                    keyboard.getPrice() >= min && keyboard.getPrice() <= max).toList();
            if (keyboards.isEmpty()) {
                throw new GenericNotFoundException("Keyboard not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(keyboards), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    public ResponseEntity<DataDTO<List<Keyboard>>> findByWidthAndHeight(Double width, Double height) {
        try {
            List<Keyboard> keyboards = dao.findAll().stream().filter(keyboard ->
                    keyboard.getWidth().equals(width) && keyboard.getHeight().equals(height)).toList();
            if (keyboards.isEmpty()) {
                throw new GenericNotFoundException("Keyboard not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(keyboards), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }
}

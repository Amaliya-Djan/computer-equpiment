package com.company.service;

import com.company.dao.MonitorDao;
import com.company.domain.Monitor;
import com.company.dtos.AppErrorDTO;
import com.company.dtos.DataDTO;
import com.company.dtos.ResponseEntity;
import com.company.exceptions.GenericNotFoundException;

import java.util.Comparator;
import java.util.List;

public class MonitorService implements BaseService<Monitor> {

    private final MonitorDao dao = new MonitorDao();

    @Override
    public ResponseEntity<DataDTO<List<Monitor>>> findAll(String sort) {
        try {
            List<Monitor> monitors = dao.findAll();
            if (monitors.isEmpty()) {
                throw new GenericNotFoundException("Monitors not found!");
            }
            switch (sort) {
                case "1" -> monitors.sort(Comparator.comparing(Monitor::getId));
                case "2" -> monitors.sort(Comparator.comparing(Monitor::getPrice));
            }
            return new ResponseEntity<>(new DataDTO<>(monitors));
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    @Override
    public ResponseEntity<DataDTO<Monitor>> findByID(Long id) {
        try {
            Monitor monitor = dao.findAll().stream().filter(monitor1 ->
                    monitor1.getId().equals(id)).findFirst().orElse(null);
            if (monitor == null) {
                throw new GenericNotFoundException("Monitor not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(monitor), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    @Override
    public ResponseEntity<DataDTO<List<Monitor>>> findByColor(String color) {
        try {
            List<Monitor> monitors = dao.findAll().stream().filter(monitor ->
                    monitor.getColor().equals(color)).toList();
            if (monitors.isEmpty()) {
                throw new GenericNotFoundException("Monitor not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(monitors), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    @Override
    public ResponseEntity<DataDTO<List<Monitor>>> filterByPrice(Double min, Double max) {
        try {
            List<Monitor> monitors = dao.findAll().stream().filter(monitor ->
                    monitor.getPrice() >= min && monitor.getPrice() <= max).toList();
            if (monitors.isEmpty()) {
                throw new GenericNotFoundException("Monitor not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(monitors), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    public ResponseEntity<DataDTO<List<Monitor>>> refreshRate(Integer refreshRate) {
        try {
            List<Monitor> monitors = dao.findAll().stream().filter(monitor ->
                    monitor.getRefreshRate().equals(refreshRate)).toList();
            if (monitors.isEmpty()) {
                throw new GenericNotFoundException("Monitor not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(monitors), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }

    public ResponseEntity<DataDTO<List<Monitor>>> displaySize(Integer displaySize) {
        try {
            List<Monitor> monitors = dao.findAll().stream().filter(monitor ->
                    monitor.getDisplaySize().equals(displaySize)).toList();
            if (monitors.isEmpty()) {
                throw new GenericNotFoundException("Monitor not found!");
            }
            return new ResponseEntity<>(new DataDTO<>(monitors), 200);
        } catch (Exception e) {
            return new ResponseEntity<>(new DataDTO<>(AppErrorDTO.builder()
                    .friendlyMessage(e.getMessage())
                    .developerMessage(e.getMessage())
                    .build()), 400);
        }
    }
}

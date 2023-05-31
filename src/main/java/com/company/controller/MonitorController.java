package com.company.controller;

import com.company.domain.Monitor;
import com.company.dtos.DataDTO;
import com.company.dtos.ResponseEntity;
import com.company.service.MonitorService;
import com.company.utils.BaseUtils;

import java.util.List;

public class MonitorController implements BaseController {

    private final MonitorService service = new MonitorService();

    @Override
    public void showAll(String sort) {
        ResponseEntity<DataDTO<List<Monitor>>> responseEntity = service.findAll(sort);
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void findByID() {
        BaseUtils.print("Enter id: ");
        ResponseEntity<DataDTO<Monitor>> responseEntity = service.findByID(BaseUtils.readLong());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void findByColor() {
        BaseUtils.print("Enter color: ");
        ResponseEntity<DataDTO<List<Monitor>>> responseEntity = service.findByColor(BaseUtils.readText());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void filterByPrice() {
        BaseUtils.print("Enter min: ");
        Double min = BaseUtils.readDouble();
        BaseUtils.print("Enter max: ");
        Double max = BaseUtils.readDouble();
        ResponseEntity<DataDTO<List<Monitor>>> responseEntity = service.filterByPrice(min, max);
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    public void refreshRate() {
        BaseUtils.print("Enter refresh rate: ");
        ResponseEntity<DataDTO<List<Monitor>>> responseEntity = service.refreshRate(BaseUtils.readInteger());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    public void displaySize() {
        BaseUtils.print("Enter display size: ");
        ResponseEntity<DataDTO<List<Monitor>>> responseEntity = service.displaySize(BaseUtils.readInteger());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }
}

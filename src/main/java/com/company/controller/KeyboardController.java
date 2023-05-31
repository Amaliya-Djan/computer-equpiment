package com.company.controller;

import com.company.domain.Keyboard;
import com.company.dtos.DataDTO;
import com.company.dtos.ResponseEntity;
import com.company.service.KeyboardService;
import com.company.utils.BaseUtils;

import java.util.List;

public class KeyboardController implements BaseController {

    private final KeyboardService service = new KeyboardService();

    @Override
    public void showAll(String sort) {
        ResponseEntity<DataDTO<List<Keyboard>>> responseEntity = service.findAll(sort);
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void findByID() {
        BaseUtils.print("Enter id: ");
        ResponseEntity<DataDTO<Keyboard>> responseEntity = service.findByID(BaseUtils.readLong());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void findByColor() {
        BaseUtils.print("Enter color: ");
        ResponseEntity<DataDTO<List<Keyboard>>> responseEntity = service.findByColor(BaseUtils.readText());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void filterByPrice() {
        BaseUtils.print("Enter min: ");
        Double min = BaseUtils.readDouble();
        BaseUtils.print("Enter max: ");
        Double max = BaseUtils.readDouble();
        ResponseEntity<DataDTO<List<Keyboard>>> responseEntity = service.filterByPrice(min, max);
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    public void findByWidthAndHeight() {
        BaseUtils.print("Enter width: ");
        Double width = BaseUtils.readDouble();
        BaseUtils.print("Enter height: ");
        Double height = BaseUtils.readDouble();
        ResponseEntity<DataDTO<List<Keyboard>>> responseEntity = service.findByWidthAndHeight(width, height);
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }
}

package com.company.controller;

import com.company.domain.Mouse;
import com.company.dtos.DataDTO;
import com.company.dtos.ResponseEntity;
import com.company.service.MouseService;
import com.company.utils.BaseUtils;

import java.util.List;

public class MouseController implements BaseController {

    private final MouseService service = new MouseService();

    @Override
    public void showAll(String sort) {
        ResponseEntity<DataDTO<List<Mouse>>> responseEntity = service.findAll(sort);
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void findByID() {
        BaseUtils.print("Enter id: ");
        ResponseEntity<DataDTO<Mouse>> responseEntity = service.findByID(BaseUtils.readLong());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void findByColor() {
        BaseUtils.print("Enter color: ");
        ResponseEntity<DataDTO<List<Mouse>>> responseEntity = service.findByColor(BaseUtils.readText());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    @Override
    public void filterByPrice() {
        BaseUtils.print("Enter min: ");
        Double min = BaseUtils.readDouble();
        BaseUtils.print("Enter max: ");
        Double max = BaseUtils.readDouble();
        ResponseEntity<DataDTO<List<Mouse>>> responseEntity = service.filterByPrice(min, max);
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }

    public void findByWireLess() {
        BaseUtils.print("Want wireless (yes/no) : ");
        ResponseEntity<DataDTO<List<Mouse>>> responseEntity = service.findByWireLess(BaseUtils.readText());
        BaseUtils.print(BaseUtils.gson.toJson(responseEntity));
    }
}

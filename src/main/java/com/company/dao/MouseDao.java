package com.company.dao;

import com.company.config.CustomFileReader;
import com.company.domain.Mouse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MouseDao implements BaseDao<Mouse> {

    private final String mouseFile = "src/main/resources/mouse.csv";

    private final CustomFileReader fileReader = new CustomFileReader();

    @Override
    public List<Mouse> findAll() throws IOException {
        return readMouseFile();
    }

    public List<Mouse> readMouseFile() throws IOException {
        List<Mouse> mouses = new ArrayList<>();
        List<String> strings = fileReader.readFile(mouseFile);
        strings.forEach(s -> mouses.add(toMouse(s)));
        return mouses;
    }

    private Mouse toMouse(String line) {
        String[] strings = line.split(",");
        return Mouse.childBuilder()
                .id(Long.valueOf(strings[0]))
                .color(strings[1])
                .price(Double.valueOf(strings[2]))
                .quantity(Integer.valueOf(strings[3]))
                .numberButtons(Integer.valueOf(strings[4]))
                .forGame(Boolean.valueOf(strings[5]))
                .wireless(Boolean.valueOf(strings[6]))
                .length(Double.valueOf(strings[7]))
                .build();
    }
}

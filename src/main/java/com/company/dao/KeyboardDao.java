package com.company.dao;

import com.company.config.CustomFileReader;
import com.company.domain.Keyboard;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class KeyboardDao implements BaseDao<Keyboard> {

    private final String keyboardFile = "src/main/resources/keyboard.csv";

    private final CustomFileReader fileReader = new CustomFileReader();

    @Override
    public List<Keyboard> findAll() throws IOException {
        return readKeyboardFile();
    }

    public List<Keyboard> readKeyboardFile() throws IOException {
        List<Keyboard> keyboards = new ArrayList<>();
        List<String> strings = fileReader.readFile(keyboardFile);
        strings.forEach(s -> keyboards.add(toKeyboard(s)));
        return keyboards;
    }

    private Keyboard toKeyboard(String line) {
        String[] strings = line.split(",");
        return Keyboard.childBuilder()
                .id(Long.valueOf(strings[0]))
                .color(strings[1])
                .price(Double.valueOf(strings[2]))
                .quantity(Integer.valueOf(strings[3]))
                .lamps(Boolean.valueOf(strings[4]))
                .width(Double.valueOf(strings[5]))
                .height(Double.valueOf(strings[6]))
                .build();
    }
}

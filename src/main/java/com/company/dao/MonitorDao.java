package com.company.dao;

import com.company.config.CustomFileReader;
import com.company.domain.Monitor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MonitorDao implements BaseDao<Monitor> {

    private final String monitorFile = "src/main/resources/monitor.csv";

    private final CustomFileReader fileReader = new CustomFileReader();

    @Override
    public List<Monitor> findAll() throws IOException {
        return readMonitorFile();
    }

    public List<Monitor> readMonitorFile() throws IOException {
        List<Monitor> monitors = new ArrayList<>();
        List<String> strings = fileReader.readFile(monitorFile);
        strings.forEach(s -> monitors.add(toMonitor(s)));
        return monitors;
    }

    private Monitor toMonitor(String line) {
        String[] strings = line.split(",");
        return Monitor.childBuilder()
                .id(Long.valueOf(strings[0]))
                .color(strings[1])
                .price(Double.valueOf(strings[2]))
                .quantity(Integer.valueOf(strings[3]))
                .refreshRate(Integer.valueOf(strings[4]))
                .displaySize(Integer.valueOf(strings[5]))
                .speaker(Boolean.valueOf(strings[6]))
                .company(strings[7])
                .build();
    }
}

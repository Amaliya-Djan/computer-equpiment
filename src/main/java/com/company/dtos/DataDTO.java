package com.company.dtos;

import lombok.Getter;

@Getter
public class DataDTO<T> {
    private T body;
    private boolean success;
    private AppErrorDTO errorDTO;

    public DataDTO(AppErrorDTO errorDTO) {
        this.errorDTO = errorDTO;
        this.success = false;
    }

    public DataDTO(T body) {
        this.body = body;
        this.success = true;
    }

}

package com.company.exceptions;

import lombok.Getter;

@Getter
public class DaoException extends Exception {
    public DaoException(String message) {
        super(message);
    }
}

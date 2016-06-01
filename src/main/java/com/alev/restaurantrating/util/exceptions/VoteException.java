package com.alev.restaurantrating.util.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY, reason = "You can't vote today") // 422
public class VoteException extends RuntimeException {
    public VoteException(String message) {
        super(message);
    }
}

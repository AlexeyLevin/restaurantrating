package com.alev.restaurantrating.util.exceptions;

public class ErrorInfo {
    public final String url;
    public final String cause;
    public final String detail;

    public ErrorInfo(String url, String cause, String detail) {
        this.url = url;
        this.cause = cause;
        this.detail = detail;
    }

    public ErrorInfo(CharSequence url, Throwable ex) {
        this.url = url.toString();
        this.cause = ex.getClass().getSimpleName();
        this.detail = ex.getLocalizedMessage();
    }
}

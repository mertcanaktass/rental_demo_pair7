package com.etiya.rentaldemopair7.core.utils.result;

public class ErrorDataResult<T> extends DataResult {
    public ErrorDataResult(Object data) {
        super(data, false);
    }

    public ErrorDataResult(Object data, String message) {
        super(data, false, message);
    }

    public ErrorDataResult(String message) {
        super(null, false, message);
    }

    public ErrorDataResult() {
        super(null, false);
    }
}

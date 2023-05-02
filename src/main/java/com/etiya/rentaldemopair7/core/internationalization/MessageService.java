package com.etiya.rentaldemopair7.core.internationalization;

public interface MessageService {
    String getMessage(String keyword);
    String getMessageWithParams(String keywords, Object... params);
}

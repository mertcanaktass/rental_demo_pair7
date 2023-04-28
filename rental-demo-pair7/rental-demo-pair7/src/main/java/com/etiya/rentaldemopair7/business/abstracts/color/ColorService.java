package com.etiya.rentaldemopair7.business.abstracts.color;

import com.etiya.rentaldemopair7.entities.concreate.Color;

import java.util.List;

public interface ColorService {

    List<Color> getAll();

    void add(Color color);
}

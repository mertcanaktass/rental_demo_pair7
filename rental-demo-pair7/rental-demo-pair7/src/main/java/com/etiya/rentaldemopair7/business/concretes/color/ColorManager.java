package com.etiya.rentaldemopair7.business.concretes.color;

import com.etiya.rentaldemopair7.business.abstracts.color.ColorService;
import com.etiya.rentaldemopair7.entities.concreate.Color;
import com.etiya.rentaldemopair7.repositories.ColorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ColorManager implements ColorService {
    private ColorRepository colorRepository;

    @Override
    public List<Color> getAll() {
        return colorRepository.findAll();
    }

    @Override
    public void add(Color color) {
        Color addColor =
                colorRepository.findByName(color.getName());
        if(addColor != null)
            return;
        colorRepository.save(color);

    }
}

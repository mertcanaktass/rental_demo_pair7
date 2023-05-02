package com.etiya.rentaldemopair7.core.utils.mapping;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ModelMapperManager implements ModelMapperService {
    private ModelMapper modelMapper;

    @Override
    public ModelMapper forRequest() {
        this.modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STANDARD)
                .setAmbiguityIgnored(true);
        return this.modelMapper;
    }
    @Override
    public ModelMapper forResponse () {
            this.modelMapper.getConfiguration()
                    .setAmbiguityIgnored(true)
                    .setMatchingStrategy(MatchingStrategies.LOOSE);
            return this.modelMapper;
        }

}




package br.com.viniciusdiefenbach.alura.screenmatch.services;

import br.com.viniciusdiefenbach.alura.screenmatch.models.SeriesData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataConversion implements IDataConversion {
    private final ObjectMapper mapper = new ObjectMapper();


    @Override
    public <T> T getData(String json, Class<T> tClass) {
        try {
            return mapper.readValue(json, tClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}

package br.com.viniciusdiefenbach.alura.screenmatch.services;

public interface IDataConversion {
    <T> T getData(String json, Class<T> tClass);
}

package br.com.viniciusdiefenbach.alura.screenmatch.models;

import com.fasterxml.jackson.annotation.JsonAlias;

public record SeriesData(@JsonAlias("Title") String title, @JsonAlias("totalSeasons") Integer totalSeasons,
                         @JsonAlias("imdbRating") String rating) {
}
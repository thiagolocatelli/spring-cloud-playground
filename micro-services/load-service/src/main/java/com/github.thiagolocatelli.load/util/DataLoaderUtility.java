package com.github.thiagolocatelli.load.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class DataLoaderUtility {

    private static final Random rnd = new Random();

    public static String randomize(List<String> literals) {
        return StringUtils.capitalize(literals.get(rnd.nextInt(literals.size())));
    }

    public static List<String> firstNames(ResourceLoader resourceLoader) {
        return loadObjects(resourceLoader, "classpath:/data/first-names.json", new TypeReference<List<String>>(){});
    }

    public static List<String> lastNames(ResourceLoader resourceLoader) {
        return loadObjects(resourceLoader, "classpath:/data/last-names.json", new TypeReference<List<String>>(){});
    }

    public static List<DemoMovie> movies(ResourceLoader resourceLoader) {
        return loadObjects(resourceLoader, "classpath:/data/movies.json", new TypeReference<List<DemoMovie>>(){});
    }

    private static <T> List<T> loadObjects(ResourceLoader resourceLoader, String resourceName, TypeReference<List<T>> valueTypeRef) {
        try {
            return new ObjectMapper().readValue(resourceLoader.getResource(resourceName).getInputStream(), valueTypeRef);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class DemoMovie {

        @JsonProperty("movie_name")
        private String movieName;

        @JsonProperty("release_date")
        private String releaseDate;

        @JsonProperty("worldwide_gross")
        private String worldwideGross;

        @JsonProperty("production_budget")
        private String productionBudget;

        @JsonProperty("movie_link")
        private String movieLink;

        @JsonProperty("domestic_gross")
        private String domesticGross;

        public String getMovieName() {
            return movieName;
        }

        public void setMovieName(String movieName) {
            this.movieName = movieName;
        }

        public String getReleaseDate() {
            return releaseDate;
        }

        public void setReleaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
        }

        public String getWorldwideGross() {
            return worldwideGross;
        }

        public void setWorldwideGross(String worldwideGross) {
            this.worldwideGross = worldwideGross;
        }

        public String getProductionBudget() {
            return productionBudget;
        }

        public void setProductionBudget(String productionBudget) {
            this.productionBudget = productionBudget;
        }

        public String getMovieLink() {
            return movieLink;
        }

        public void setMovieLink(String movieLink) {
            this.movieLink = movieLink;
        }

        public String getDomesticGross() {
            return domesticGross;
        }

        public void setDomesticGross(String domesticGross) {
            this.domesticGross = domesticGross;
        }

        @Override
        public String toString() {
            return "DemoMovie{" +
                    "movieName='" + movieName + '\'' +
                    ", releaseDate='" + releaseDate + '\'' +
                    '}';
        }
    }
}

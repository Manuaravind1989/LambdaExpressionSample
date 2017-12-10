package com.mobiledev.lambdalombok.dataTemplate;

import java.util.List;

import lombok.Data;

/**
 * Created by manu on 12/10/2017.
 */
@Data
public class MoviesModel {
    private List<DataBean> data;
    @Data
    public  class DataBean {
        private int id;
        private String title;
        private String poster;
        private String year;
        private String country;
        private String imdb_rating;
        private List<String> genres;
        private List<String> images;


    }
}

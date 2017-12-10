package com.mobiledev.lambdalombok.network;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by manu on 12/10/2017.
 */
@Getter
@Setter
public class PopularMovieModel {

    private MetadataBean metadata;
    private List<DataBean> data;

    @Getter
    @Setter
    public class MetadataBean {

        private int current_page;
        private int per_page;
        private int page_count;
        private int total_count;


    }
    @Getter
    @Setter
    public class DataBean {
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

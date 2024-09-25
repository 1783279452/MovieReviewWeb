package com.example.moviereviewweb.Bean;

import java.util.HashMap;
import java.util.Map;

public class Genre {//影视类型类

    private static Map<Integer, String> genre_map = new HashMap<>();

    static {
        genre_map.put(1, "动作");
        genre_map.put(2, "爱情");
        genre_map.put(3, "科幻");
        genre_map.put(4, "恐怖");
        genre_map.put(5, "喜剧");
        genre_map.put(6, "奇幻");
        genre_map.put(7, "战争");
        genre_map.put(8, "犯罪");
    }

    public static String getCategoryNameById(Integer id){
        return genre_map.get(id);
    }
}

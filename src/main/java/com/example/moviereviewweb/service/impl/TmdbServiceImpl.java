package com.example.moviereviewweb.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.moviereviewweb.Bean.Movie;
import com.example.moviereviewweb.Bean.TV;
import com.example.moviereviewweb.service.MovieService;
import com.example.moviereviewweb.service.TmdbService;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
@Slf4j
public class TmdbServiceImpl implements TmdbService {//TMDB搜索数据处理

    @Autowired
    private MovieService movieService;

    private final RestTemplate restTemplate;
    private final Gson gson;



    public TmdbServiceImpl(RestTemplate restTemplate, Gson gson) {
        this.restTemplate = restTemplate;
        this.gson = gson;
    }

    /*参考格式如下https://api.themoviedb.org/3/search/movie?api_key=你的API密钥&query=搜索关键字&language=zh-CN&page=1*/
    private static final String TMDB_Http = "https://api.themoviedb.org/3/";//http前缀
    private static final String MultiSearch = "search/multi?";//聚合搜索
    private static final String MovieSearch = "search/movie?";//电影搜索
    private static final String TvSearch = "search/tv?";//电视剧TV搜索
    private static final String TMDB_APIkey = "api_key=d3459ceb989dbc69c664097b38e0c1ae";//tmdb key
    private static final String Language = "&language=zh-CN";//语言
    private static final String TMDB_HotMovies = "https://api.themoviedb.org/3/movie/popular?api_key=";//当前所有热门电影

    //&query=你想的影视名字

    //聚合搜索，分类识别电影、电视剧
    public List<Object> getMultiSearchResults(String data) {
        String SerachData = data;
        String url = TMDB_Http + MultiSearch + TMDB_APIkey + "&query=" + SerachData + Language;
        log.info("url=" + url);
        String HTTPinfo = restTemplate.getForObject(url, String.class);//发送http请求并封装返回数据

        log.info("原始HTTPinfo信息(未过滤)" + HTTPinfo);

        // 设立匹配规则
        String idPattern = "\"id\":\\s*(\\d+)";
        String titlePattern = "\"title\":\\s*\"([^\"]+)\"";//电影
        String namePattern = "\"name\":\\s*\"([^\"]+)\"";//电视剧
        String mediaTypePattern = "\"media_type\":\\s*\"(movie|tv)\"";
        String posterPathPattern = "\"poster_path\":\\s*\"([^\"]+)\"";
        String releaseDatePattern = "\"release_date\":\\s*\"([^\"]+)\"";//电影
        String firstAirDatePattern = "\"first_air_date\":\\s*\"([^\"]+)\"";//电视剧
        String genreIdsPattern = "\"genre_ids\":\\s*\\[([\\d,\\s]+)\\]";
        String voteAveragePattern = "\"vote_average\":\\s*([0-9.]+)";
        String languagePattern = "\"original_language\":\\s*\"([^\"]+)\"";
        String overviewPattern = "\"overview\":\\s*\"([^\"]+)\"";

        // 匹配器
        Matcher idMatcher = Pattern.compile(idPattern).matcher(HTTPinfo);
        Matcher titleMatcher = Pattern.compile(titlePattern).matcher(HTTPinfo);
        Matcher nameMatcher = Pattern.compile(namePattern).matcher(HTTPinfo);
        Matcher mediaTypeMatcher = Pattern.compile(mediaTypePattern).matcher(HTTPinfo);
        Matcher posterPathMatcher = Pattern.compile(posterPathPattern).matcher(HTTPinfo);
        Matcher releaseDateMatcher = Pattern.compile(releaseDatePattern).matcher(HTTPinfo);
        Matcher firstAirDateMatcher = Pattern.compile(firstAirDatePattern).matcher(HTTPinfo);
        Matcher genreIdsMatcher = Pattern.compile(genreIdsPattern).matcher(HTTPinfo);
        Matcher voteAverageMatcher = Pattern.compile(voteAveragePattern).matcher(HTTPinfo);
        Matcher languageMatcher = Pattern.compile(languagePattern).matcher(HTTPinfo);
        Matcher overviewMatcher = Pattern.compile(overviewPattern).matcher(HTTPinfo);

        List<Object> resultList = new ArrayList<>();

        // 开始解析每个搜索结果
        while (mediaTypeMatcher.find()) {
            String mediaType = mediaTypeMatcher.group(1);
            if (idMatcher.find()) {
                String id = idMatcher.group(1);
                String posterPath = posterPathMatcher.find() ? posterPathMatcher.group(1) : null;
                String language = languageMatcher.find() ? languageMatcher.group(1) : null;
                String overview = overviewMatcher.find() ? overviewMatcher.group(1) : null;
                String genres = genreIdsMatcher.find() ? genreIdsMatcher.group(1) : null;
                String voteAverage = voteAverageMatcher.find() ? voteAverageMatcher.group(1) : "0";

                // 如果是电影
                if ("movie".equals(mediaType) && titleMatcher.find()) {
                    String title = titleMatcher.group(1);
                    String releaseDate = releaseDateMatcher.find() ? releaseDateMatcher.group(1) : null;

                    Movie movie = new Movie();
                    movie.setMID(Integer.valueOf(id));
                    movie.setName(title);
                    movie.setImgUrl(posterPath);
                    movie.setReleaseTime(releaseDate);
                    movie.setType(genres);
                    movie.setM_score(Float.valueOf(voteAverage));
                    movie.setLanguage(language);
                    movie.setSummary(overview);

                    resultList.add(movie);
                    log.info("电影信息：" + movie);

                    //TODO

                    if (movieService.IsMovieById(Integer.valueOf(id)) == false){
                        movieService.addMovie(movie);
                        log.info("添加进数据库");
                    }


                }

                // 如果是电视剧
                if ("tv".equals(mediaType) && nameMatcher.find()) {
                    String name = nameMatcher.group(1);
                    String firstAirDate = firstAirDateMatcher.find() ? firstAirDateMatcher.group(1) : null;

                    TV tv = new TV();
                    tv.setTID(Integer.valueOf(id));
                    tv.setName(name);
                    tv.setImgUrl(posterPath);
                    tv.setReleaseTime(firstAirDate);
                    tv.setType(genres);
                    tv.setT_score(Float.valueOf(voteAverage));
                    tv.setLanguage(language);
                    tv.setSummary(overview);

                    resultList.add(tv);
                    log.info("电视剧信息：" + tv);
                }
            }
        }
        log.info("最终返回结果：" + resultList);
        return resultList;
    }

    //聚合搜索  原始版本备份
    /*public List<Movie> getMultiMovie(String data){
        String SerachData = data;
        String url = TMDB_Http + MultiSearch +TMDB_APIkey + "&query=" +SerachData + Language;
        log.info("url="+url);
        String HTTPinfo = restTemplate.getForObject(url, String.class);//发送http请求并封装返回数据

        log.info("原始HTTPinfo信息(未过滤)" + HTTPinfo);

        //设立匹配规则：
        // 匹配 id
        String idPattern = "\"id\":\\s*(\\d+)";
        // 匹配 title 和 name (处理电影和电视剧)
        //String titlePattern = "\"title\":\\s*\"([^\"]+)\"|\"name\":\\s*\"([^\"]+)\"";
        String titlePattern = "\"(title|name)\":\\s*\"([^\"]+)\"";//简化处理
        // 匹配 poster_path
        String posterPathPattern = "\"poster_path\":\\s*\"([^\"]+)\"";
        // 匹配 release_date 和 first_air_date (处理电影和电视剧)
        String releaseDatePattern = "\"release_date\":\\s*\"([^\"]+)\"|\"first_air_date\":\\s*\"([^\"]+)\"";
        // 匹配 genre_ids
        String genreIdsPattern = "\"genre_ids\":\\s*\\[([\\d,\\s]+)\\]";
        // 匹配 vote_average
        String voteAveragePattern = "\"vote_average\":\\s*([0-9.]+)";
        // 匹配 original_language
        String languagePattern = "\"original_language\":\\s*\"([^\"]+)\"";
        // 匹配 overview
        String overviewPattern = "\"overview\":\\s*\"([^\"]+)\"";

        //规则编译为Pattern对象，并查找HTTPinfo字符串里匹配项
        Matcher idMatcher = Pattern.compile(idPattern).matcher(HTTPinfo);
        Matcher titleMatcher = Pattern.compile(titlePattern).matcher(HTTPinfo);
        Matcher posterPathMatcher = Pattern.compile(posterPathPattern).matcher(HTTPinfo);
        Matcher releaseDateMatcher = Pattern.compile(releaseDatePattern).matcher(HTTPinfo);
        Matcher genreIdsMatcher = Pattern.compile(genreIdsPattern).matcher(HTTPinfo);
        Matcher voteAverageMatcher = Pattern.compile(voteAveragePattern).matcher(HTTPinfo);
        Matcher languageMatcher = Pattern.compile(languagePattern).matcher(HTTPinfo);
        Matcher overviewMatcher = Pattern.compile(overviewPattern).matcher(HTTPinfo);

        List<Movie> movieList = new ArrayList<>();

        //判断是否存在id，当搜索结果id位空时，停止搜索
        while (idMatcher.find() == true ){

            //提取结果，如未空则赋予null值避免运行异常
            String MID = idMatcher.group(1);
            //String Name = titleMatcher.find() ? (titleMatcher.group(1) != null ? titleMatcher.group(1) : titleMatcher.group(2)) : null;
            String Name = titleMatcher.find() ?titleMatcher.group(2) : null;//简化处理，group字段搜索2
            String imgUrl = posterPathMatcher.find() ? posterPathMatcher.group(1) : null;
            String ReleaseTime = releaseDateMatcher.find() ? (releaseDateMatcher.group(1) != null ? releaseDateMatcher.group(1) : releaseDateMatcher.group(2)) : null;
            String type = genreIdsMatcher.find() ? genreIdsMatcher.group(1) : null;
            String M_score = voteAverageMatcher.find() ? voteAverageMatcher.group(1) : null;
            String language = languageMatcher.find() ? languageMatcher.group(1) : null;
            String summary = overviewMatcher.find() ? overviewMatcher.group(1) : null;
            //封装对象
            Movie movie1 = new Movie();
            movie1.setMID(Integer.valueOf(MID));
            movie1.setName(Name);
            movie1.setImgUrl(imgUrl);
            movie1.setReleaseTime(ReleaseTime);
            movie1.setType(type);
            movie1.setM_score(Float.valueOf(M_score));
            movie1.setLanguage(language);
            movie1.setSummary(summary);

            movieList.add(movie1);

            log.info("相关信息：" + movie1);
        }
        log.info("实际返回："+movieList);
        return movieList;
    }*/









}

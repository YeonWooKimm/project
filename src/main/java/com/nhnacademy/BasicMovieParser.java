package com.nhnacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BasicMovieParser implements MovieParser {

    @Override
    public List<Movie> parse() throws IOException {
        List<Movie> movieList = new ArrayList<Movie>();

        try (InputStream inputStream = getMovieFileAsStream();
            BufferedReader input = new BufferedReader(new InputStreamReader(inputStream, "UTF-8")))
            {
            input.readLine();
            while (input.ready()) {
                StringTokenizer line = new StringTokenizer(input.readLine(),",");
                long movieId = Long.parseLong(line.nextToken());
                String title = line.nextToken();
                Set<String> genres = Arrays.stream(line.nextToken().split("\\|")).collect(Collectors.toSet());
                movieList.add(new Movie(movieId, title, genres));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return movieList;
    }
  
  }
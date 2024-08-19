package com.nhnacademy;

import java.util.List;
import java.util.Objects;
import java.util.Random;

import org.apache.commons.math3.random.RandomDataGenerator;
import org.apache.commons.lang3.StringUtils;

public class Main {
    public static void main(String[] args) {
        
        //실습1-- 난수출력
        System.out.println("problem1");
        System.out.println("java.util.Random 사용: " + (new Random().nextInt(100) + 1));
        System.out.println("org.apache.commons.math3.random.RandomDataGenerator 사용: " + new RandomDataGenerator().nextInt(1, 100));
        System.out.println();

        //실습2-- 빈 or null 문자열 확인
        System.out.println("problem2");
        String str1 = "check";
        String str2 = null;
        String str3 = "";
        System.out.println("str1 -> Objects.isNull , 'java.lang.String.isEmpty()' 사용: " + (Objects.isNull(str1)||str1.isEmpty()));
        System.out.println("str1 -> org.apache.commons.lang3.StringUtils.isEmpty() 사용: " + StringUtils.isEmpty(str1));
        System.out.println("str2 -> Objects.isNull , 'java.lang.String.isEmpty()' 사용: " + (Objects.isNull(str2)||str2.isEmpty()));
        System.out.println("str2 -> org.apache.commons.lang3.StringUtils.isEmpty() 사용: " + StringUtils.isEmpty(str2));
        System.out.println("str3 -> Objects.isNull , 'java.lang.String.isEmpty()' 사용: " + (Objects.isNull(str3)||str3.isEmpty()));
        System.out.println("str3 -> org.apache.commons.lang3.StringUtils.isEmpty() 사용: " + StringUtils.isEmpty(str3));
        System.out.println();
        
        //실습3-- movies.csv파일 parcing
        MovieParser movieParser = new BasicMovieParser();
        //MovieParser movieParser = new ApacheCommonsCsvMovieParser();
        try {
            List<Movie> movieList = movieParser.parse();
            for(Movie movie : movieList){
                System.out.println(movie);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        
    }
}
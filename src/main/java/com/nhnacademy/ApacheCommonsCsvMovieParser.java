package com.nhnacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class ApacheCommonsCsvMovieParser implements MovieParser {

    @Override
    public List<Movie> parse() throws IOException {
        List<Movie> movieList = new ArrayList<Movie>();

        try (InputStream inputStream = getMovieFileAsStream();
            BufferedReader input = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            CSVParser parser = new CSVParser(input, CSVFormat.EXCEL))
            {
            List<CSVRecord> csvRecordList = parser.getRecords();
            for (int i = 1; i < csvRecordList.size(); i++) {
                CSVRecord csvRecord = csvRecordList.get(i);

                long movieId = Long.parseLong(csvRecord.get(0));
                String title = csvRecord.get(1);
                Set<String> genres = Arrays.stream(csvRecord.get(2).split("\\|")).collect(Collectors.toSet());
                movieList.add(new Movie(movieId, title, genres));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return movieList;
    }
  
  }
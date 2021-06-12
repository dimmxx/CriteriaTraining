package com.example.creteriatraining.service.util;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LibraryReader {

    public static List<String> readFile(String path, Charset encoding){
        try{
            byte[] encoded = Files.readAllBytes(Paths.get(path));
            String str = new String(encoded, encoding);
            String[] output = str.split("\n", -1);
            return Arrays.stream(output)
                .filter(s -> !Objects.equals(s, ""))
                .distinct()
                .collect(Collectors.toList());
        }catch (IOException e){
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}

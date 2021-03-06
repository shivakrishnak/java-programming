package com.ksk.snippets;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadLogAndFindKeywords {

    public static final String INPUT_DIRECTORY = "C:\\Users\\Shivakrishna_Kurremu\\Desktop\\input_directory\\test";
    public static final String OUTPUT_DIRECTORY = "C:\\Users\\Shivakrishna_Kurremu\\Desktop\\output_directory\\";
    private static final List<String> EXTENSION = Arrays.asList(".log",".txt");
    private static final String EXTENSION_LOG = ".log";
    private static final String REGEX_URL = "\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
    private static final String REGEX_PHONE = "^\\+([0-9\\-]?){9,11}[0-9]$";
    private static final String REGEX_IP= "^((0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)\\.){3}(0|1\\d?\\d?|2[0-4]?\\d?|25[0-5]?|[3-9]\\d?)$";
    private static final List<String> REGEX_LIST = Collections.unmodifiableList(Arrays.asList(REGEX_IP,REGEX_PHONE,REGEX_URL));
    public static Map<String, List<String>> finalMap = new HashMap<>();

    public static final String fileName = "C:\\Users\\Shivakrishna_Kurremu\\Desktop\\input_directory\\yarn-error.log";
    public static void main(String[] args) throws IOException {
        List<File> filesInFolder = listFilesUsingFileWalk(INPUT_DIRECTORY);
        filesInFolder.forEach(fileName  ->{
            readFile(fileName.getAbsolutePath());
        });
        //System.out.println(finalMap);
        int i = 0;
        for (Map.Entry<String, List<String>> keyword: finalMap.entrySet()){
            System.out.println(keyword.getKey());
            writeToFile("file-"+ (++i), keyword.getValue());
        }
    }

    private static void readFile(String fileName) {
        System.out.println("File Name -> " + fileName);
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEach(line -> patternMatcher(line));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void patternMatcher(String input) {
        for (String reg : REGEX_LIST){
            List<String> list = new ArrayList<String>();
            Matcher m = Pattern.compile(reg).matcher(input);
            while (m.find())
            {
                list.add(m.group());
                //System.out.println("List : " + list);
            }
            if (!list.isEmpty()){
                addToMap(reg, list);
            }
            list.clear();
        }
    }

    private static void addToMap(String reg, List<String> list) {
        finalMap.computeIfAbsent(reg, val ->new ArrayList<>());
        List<String> newList = finalMap.get(reg);
        newList.addAll(list);
        finalMap.put(reg, newList);
    }

    public static List<File> listFilesUsingFileWalk(String dir) throws IOException {

        return Files.walk(Paths.get(INPUT_DIRECTORY))
                .filter(Files::isRegularFile)
                .map(Path::toFile)
                .collect(Collectors.toList());
    }
    public static void writeToFile(String fileName, List<String> output) throws IOException {

        FileWriter writer = new FileWriter(OUTPUT_DIRECTORY + fileName + ".txt");
        for(String str: output) {
            writer.write(str + System.lineSeparator());
        }
        writer.close();
    }

}

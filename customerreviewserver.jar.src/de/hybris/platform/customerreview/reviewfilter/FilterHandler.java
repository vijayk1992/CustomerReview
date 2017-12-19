package de.hybris.platform.customerreview.reviewfilter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
 
final public class FilterHandler {
    public static boolean foundBadWord(String inReviewBody, List<String> stringList) {
        boolean found = false;
        if (inReviewBody != null) {
            Stream<String> bodyStream = Stream.of(inReviewBody.split(" "));
            String tempWord = bodyStream.filter(x -> stringList.contains(x.toLowerCase()))
                    .findFirst()
                    .orElse("");
            if (tempWord != "") {
                found = true;
            }
        }
        return found;
    }
 
    public static List<String> loadData() {
        List<String> listOfCursedWords = new ArrayList<>();
        listOfCursedWords = parseFile();
        return listOfCursedWords;
    }
 
    public static List<String> parseFile() {
        return parseFile("badwords.txt");
    }
 
    public static List<String> parseFile(String inputFile) {
        List<String> wordList = new ArrayList<String>();
        try {
 
            Path currentRelativePath = Paths.get("");
            String fullPath = currentRelativePath.toAbsolutePath().toString();
 
            File f = new File(fullPath + File.separator + inputFile);
            BufferedReader b = new BufferedReader(new FileReader(f));
 
            String readLine;
 
            while ((readLine = b.readLine()) != null) {
                wordList.add(readLine.toLowerCase());
            }
 
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wordList;
    }
}
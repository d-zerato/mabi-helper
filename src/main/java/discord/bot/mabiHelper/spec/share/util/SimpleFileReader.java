package discord.bot.mabiHelper.spec.share.util;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.net.URL;

public class SimpleFileReader {
    //

    public static String readFileToString(URI uri) throws IOException {
        //
        StringBuilder fileParser = new StringBuilder();

        try(Stream<String> stream = Files.lines(Paths.get(uri))) {
            stream.forEach(text -> fileParser.append(text).append("\n"));
        }

        return fileParser.toString();
    }

    public static String readFileToString(String uri) throws IOException {
        //
        StringBuilder fileParser = new StringBuilder();

        try(Stream<String> stream = Files.lines(Paths.get(uri),StandardCharsets.UTF_8)) {
            stream.forEach(text -> fileParser.append(text).append("\n"));
        }

        return fileParser.toString();
    }

    public static <T> T readFileToJson(String uri, Class<T> parsingType) throws IOException {
        //
        Gson gson = new Gson();

        return gson.fromJson(readFileToString(uri), parsingType);
    }

    public static <T> T readFileToJson(URI uri, Class<T> parsingType) throws IOException {
        //
        Gson gson = new Gson();

        return gson.fromJson(readFileToString(uri), parsingType);
    }
}

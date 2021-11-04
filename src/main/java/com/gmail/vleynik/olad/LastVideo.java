package com.gmail.vleynik.olad;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Paths;
import java.util.Scanner;

public class LastVideo {
    public static void save(String path) {
        try(FileWriter writer = new FileWriter(Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "config.txt").toString()))
        {
            writer.write(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String load() {
        try (Scanner scanner = new Scanner(Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "config.txt").toFile())) {
            if (scanner.hasNext()) {
                File file =  new File(scanner.nextLine());
                if (file.exists() && file.getName().endsWith(".mp4")) {
                    return file.getAbsolutePath();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "bunny.mp4").toString();
    }
}

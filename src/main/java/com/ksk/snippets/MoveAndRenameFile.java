package com.ksk.snippets;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class MoveAndRenameFile {

    public static final String FILE_EXTENSION = ".csv";

    public static void main(String[] args) {
        String source = "D:\\Chubb-WorkersComp\\Datastore";
        String destination = "D:\\Chubb-WorkersComp\\Test";
        String newFileName = "iamgroot";
        moveFile(source, destination, newFileName);
    }

    private static void moveFile(String source, String destination, String newFileName) {
        Path sourceDir = Paths.get(source);
        Path destinationDir = Paths.get(destination);

        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(sourceDir)) {
            for (Path path : directoryStream) {
                System.out.println("copying " + path.toString());
                Files.move(path, destinationDir.resolve(newFileName+ FILE_EXTENSION), REPLACE_EXISTING);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}

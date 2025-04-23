package com.example.gabrielm;
import java.io.File;

public class Paths {
    private Paths() {}

    public static boolean DEVMODE = true;

    public static File ROOT_DIR;
    public static File MD_FOLDER;
    public static File HTML_FOLDER;
    public static File IMAGES;

    private static void refreshFolderPaths() {
        MD_FOLDER = new File(ROOT_DIR, "mdFiles");
        HTML_FOLDER = new File(ROOT_DIR, "topics");
        IMAGES = new File(ROOT_DIR, "images");

        if (!MD_FOLDER.exists() || !MD_FOLDER.isDirectory()) {
            throw new IllegalStateException(
                    "Failed to find mdFiles folder at " + MD_FOLDER.getAbsolutePath() +
                            " (DEVMODE=" + DEVMODE + ")");
        }
        if (!HTML_FOLDER.exists() || !HTML_FOLDER.isDirectory()) {
            throw new IllegalStateException(
                    "Failed to find topics folder at " + HTML_FOLDER.getAbsolutePath() +
                            " (DEVMODE=" + DEVMODE + ")");
        }
        System.out.println("success - found Folders");
    }

    private static void setPathsDev() {
        try {
            ROOT_DIR = new File("D:/programming/GabrielMout");
            System.out.println("DEVMODE");
        }
        catch (Exception e) {
            ROOT_DIR = new File(".");
        }
    }
    private static void setPathsProd() {
        try {
            File v_jarFile = new File(Paths.class.getProtectionDomain()
                    .getCodeSource()
                    .getLocation()
                    .toURI());
            ROOT_DIR = v_jarFile.getParentFile();
            System.out.println("PRODMODE");
        }
        catch (Exception e) {
            ROOT_DIR = new File(".");
        }
    }

    public static void init() {
        if (DEVMODE) setPathsDev();
        else setPathsProd();
        refreshFolderPaths();
    }

    public static void changePaths(String newBaseDir) {
        try {
            ROOT_DIR = new File(newBaseDir);
            System.out.println("changing paths");
        }
        catch (Exception e) {
            ROOT_DIR = new File(".");
        }
        refreshFolderPaths();
    }
}

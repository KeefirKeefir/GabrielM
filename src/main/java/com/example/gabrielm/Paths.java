package com.example.gabrielm;
import java.io.File;

public class Paths {
    public static boolean DEVMODE = true;

    public static File xBaseDir;
    public static File xMdFolder;
    public static File xHtmlFolder;
    public static File xImages;

    private static void refreshFolderPaths() {
        xMdFolder = new File(xBaseDir, "mdFiles");
        xHtmlFolder = new File(xBaseDir, "topics");
        xImages = new File(xBaseDir, "images");

        if (!xMdFolder.exists() || !xMdFolder.isDirectory()) {
            throw new IllegalStateException(
                    "Failed to find mdFiles folder at " + xMdFolder.getAbsolutePath() +
                            " (DEVMODE=" + DEVMODE + ")");
        }
        if (!xHtmlFolder.exists() || !xHtmlFolder.isDirectory()) {
            throw new IllegalStateException(
                    "Failed to find topics folder at " + xHtmlFolder.getAbsolutePath() +
                            " (DEVMODE=" + DEVMODE + ")");
        }
        System.out.println("success - found Folders");
    }

    private static void setPathsDev() {
        try {
            xBaseDir = new File("D:/programming/GabrielMout");
            System.out.println("DEVMODE");
        }
        catch (Exception e) {
            xBaseDir = new File(".");
        }
    }
    private static void setPathsProd() {
        try {
            File jarFile = new File(Paths.class.getProtectionDomain()
                    .getCodeSource()
                    .getLocation()
                    .toURI());
            xBaseDir = jarFile.getParentFile();
            System.out.println("PRODMODE");
        }
        catch (Exception e) {
            xBaseDir = new File(".");
        }
    }

    public static void init() {
        if (DEVMODE) {
            setPathsDev();
        }
        else {
            setPathsProd();
        }
        refreshFolderPaths();
    }

    public static void changePaths(String newBaseDir) {
        try {
            xBaseDir = new File(newBaseDir);
            System.out.println("changing paths");
        }
        catch (Exception e) {
            xBaseDir = new File(".");
        }
        refreshFolderPaths();
    }
}

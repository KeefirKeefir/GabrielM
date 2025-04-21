package com.example.gabrielm;
import java.io.File;
import java.io.IOException;
import java.net.FileNameMap;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.css.Match;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;


public class HtmlGenerator {
    public static void generateHtmlFiles() {

        File[] axFiles = Paths.xMdFolder.listFiles((dir, name) -> name.endsWith(".md"));
        if (axFiles == null) {
            System.err.println("No markdown files found");
            return;
        }

        Parser parser = Parser.builder().build();
        HtmlRenderer renderer = HtmlRenderer.builder().build();

        String kCommentRegex = "<!--|-->";
        Pattern xPattern = Pattern.compile(kCommentRegex);

        for (File xFile : axFiles) {
            try {
                String xFileName = xFile.getName();
                String xFileNameNoExtension = xFileName.substring(0, xFileName.lastIndexOf('.'));
                String xMarkdown = Files.readString(xFile.toPath());

                String xHtmlContent = renderer.render(parser.parse(xMarkdown));

                Matcher xMatcher = xPattern.matcher(xHtmlContent);
                String xHtmlBody = xMatcher.replaceAll("");

                String xHtmlOutput = kHtmlHead + xHtmlBody + kHtmlTail;

                if (!Paths.xHtmlFolder.exists()) {
                    Paths.xHtmlFolder.mkdirs();
                }

                File xOutFile = new File(Paths.xHtmlFolder, xFileNameNoExtension + ".html");
                Files.writeString(xOutFile.toPath(), xHtmlOutput);

                System.out.println("Generated html file: " + xOutFile.getAbsolutePath());
            }
            catch (IOException e) {
                System.err.println("Error processing file: "  + xFile.getAbsolutePath() + e.getMessage());
                e.printStackTrace();
            }
        }
    }
    private static String kHtmlHead = "<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <title>Title</title>\n" +
            "    <script type=\"text/javascript\" async\n" +
            "            src=\"../mathjax/es5/tex-mml-chtml.js\">\n" +
            "    </script>\n" +
            "</head>\n" +
            "<body>\n";
    private static String kHtmlTail = "</body>\n" + "</html>";
}

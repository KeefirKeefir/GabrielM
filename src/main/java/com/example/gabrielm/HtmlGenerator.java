package com.example.gabrielm;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;


public class HtmlGenerator {
    private HtmlGenerator() {}

    public static void generateHtmlFiles() {

        File[] v_files = Paths.MD_FOLDER.listFiles((dir, name) -> name.endsWith(".md"));
        if (v_files == null) {
            System.err.println("No markdown files found");
            return;
        }

        Parser v_parser = Parser.builder().build();
        HtmlRenderer v_renderer = HtmlRenderer.builder().build();

        for (File v_file : v_files) {
            try {
                String v_fileName = v_file.getName();
                String v_fileNameNoExtension = v_fileName.substring(0, v_fileName.lastIndexOf('.'));
                String v_markdown = Files.readString(v_file.toPath());

                v_markdown = v_markdown
                        .replaceAll("\\[\\[\\[", "<!--\\$")
                        .replaceAll("\\]\\]\\]", "\\$-->")
                        .replaceAll("\\[\\[", "<!--")
                        .replaceAll("\\]\\]", "-->");

                String v_htmlContent = v_renderer.render(v_parser.parse(v_markdown));

                v_htmlContent = v_htmlContent
                        .replaceAll("<!--\\$", "\\$\\$")
                        .replaceAll("\\$-->", "\\$\\$")
                        .replaceAll("<!--", "\\$")
                        .replaceAll("-->", "\\$");

                String v_htmlOutput = HTML_HEAD + v_htmlContent + HTML_TAIL;

                if (!Paths.HTML_FOLDER.exists()) {
                    Paths.HTML_FOLDER.mkdirs();
                }

                File v_outFile = new File(Paths.HTML_FOLDER, v_fileNameNoExtension + ".html");
                Files.writeString(v_outFile.toPath(), v_htmlOutput);

                System.out.println("Generated html file: " + v_outFile.getAbsolutePath());
            }
            catch (IOException e) {
                System.err.println("Error processing file: "  + v_file.getAbsolutePath() + e.getMessage());
                e.printStackTrace();
            }
        }
    }
    private static final String HTML_HEAD = "<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <title>Title</title>\n" +
            "    <script type=\"text/javascript\" async\n" +
            "            src=\"../mathjax/es5/tex-mml-chtml.js\">\n" +
            "    </script>\n" +
            "</head>\n" +
            "<body>\n";
    private static final String HTML_TAIL = "</body>\n" + "</html>";
}

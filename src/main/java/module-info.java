module com.example.gabrielm {
    requires javafx.controls;
    requires org.commonmark;
    requires javafx.web;
    requires flexmark.util.ast;
    requires flexmark;
    requires flexmark.util.data;
    requires flexmark.ext.tables;
    requires flexmark.ext.jekyll.tag;
    requires flexmark.ext.math;
    requires flexmark.util.misc;
    requires flexmark.ext.gfm.strikethrough;
    requires com.ibm.icu;

    opens com.example.gabrielm to javafx.fxml;
    exports com.example.gabrielm;
}
package com.example.demo.service;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Formats {
    @JsonProperty("text/html")
    private String textHtml;
    @JsonProperty("application/epub+zip")
    private String applicationEpubZip;
    @JsonProperty("application/x-mobipocket-ebook")
    private String applicationXMobipocketEbook;
    @JsonProperty("application/rdf+xml")
    private String applicationRdfXml;
    @JsonProperty("image/jpeg")
    private String imageJpeg;
    @JsonProperty("text/plain; charset=us-ascii")
    private String textPlainCharsetUsAscii;
    @JsonProperty("application/octet-stream")
    private String applicationOctetStream;
    @JsonProperty("text/html; charset=utf-8")
    private String textHtmlCharsetUtf8;
    @JsonProperty("text/plain; charset=utf-8")
    private String textPlainCharsetUtf8;
    @JsonProperty("text/plain; charset=iso-8859-1")
    private String textPlainCharsetIso88591;
    @JsonProperty("text/html; charset=iso-8859-1")
    private String textHtmlCharsetIso88591;

    // Constructor vacío requerido por Jackson
    public Formats() {
    }

    // Getters y setters para cada campo
    public String getTextHtml() {
        return textHtml;
    }

    public void setTextHtml(String textHtml) {
        this.textHtml = textHtml;
    }

    public String getApplicationEpubZip() {
        return applicationEpubZip;
    }

    public void setApplicationEpubZip(String applicationEpubZip) {
        this.applicationEpubZip = applicationEpubZip;
    }

    public String getApplicationXMobipocketEbook() {
        return applicationXMobipocketEbook;
    }

    public void setApplicationXMobipocketEbook(String applicationXMobipocketEbook) {
        this.applicationXMobipocketEbook = applicationXMobipocketEbook;
    }

    public String getApplicationRdfXml() {
        return applicationRdfXml;
    }

    public void setApplicationRdfXml(String applicationRdfXml) {
        this.applicationRdfXml = applicationRdfXml;
    }

    public String getImageJpeg() {
        return imageJpeg;
    }

    public void setImageJpeg(String imageJpeg) {
        this.imageJpeg = imageJpeg;
    }

    public String getTextPlainCharsetUsAscii() {
        return textPlainCharsetUsAscii;
    }

    public void setTextPlainCharsetUsAscii(String textPlainCharsetUsAscii) {
        this.textPlainCharsetUsAscii = textPlainCharsetUsAscii;
    }

    public String getApplicationOctetStream() {
        return applicationOctetStream;
    }

    public void setApplicationOctetStream(String applicationOctetStream) {
        this.applicationOctetStream = applicationOctetStream;
    }

    public String getTextHtmlCharsetUtf8() {
        return textHtmlCharsetUtf8;
    }

    public void setTextHtmlCharsetUtf8(String textHtmlCharsetUtf8) {
        this.textHtmlCharsetUtf8 = textHtmlCharsetUtf8;
    }

    public String getTextPlainCharsetUtf8() {
        return textPlainCharsetUtf8;
    }

    public void setTextPlainCharsetUtf8(String textPlainCharsetUtf8) {
        this.textPlainCharsetUtf8 = textPlainCharsetUtf8;
    }

    public String getTextPlainCharsetIso88591() {
        return textPlainCharsetIso88591;
    }

    public void setTextPlainCharsetIso88591(String textPlainCharsetIso88591) {
        this.textPlainCharsetIso88591 = textPlainCharsetIso88591;
    }

    public String getTextHtmlCharsetIso88591() {
        return textHtmlCharsetIso88591;
    }

    public void setTextHtmlCharsetIso88591(String textHtmlCharsetIso88591) {
        this.textHtmlCharsetIso88591 = textHtmlCharsetIso88591;
    }
}

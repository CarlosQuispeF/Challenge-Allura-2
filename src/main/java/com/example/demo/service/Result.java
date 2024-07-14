package com.example.demo.service;

import java.util.List;

public class Result
{
    public int id;
    public String title;
    public List<Author> authors;
    public List<Translator> translators;
    public List<String> subjects;
    public List<String> bookshelves;
    public List<String> languages;
    public boolean copyright;
    public String media_type;
    public Formats formats;
    public int download_count;
}

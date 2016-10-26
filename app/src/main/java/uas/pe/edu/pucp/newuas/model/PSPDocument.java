package uas.pe.edu.pucp.newuas.model;

import java.util.Calendar;

/**
 * Created by Franz on 21/10/2016.
 */

public class PSPDocument {

    private String name;
    private Calendar date;
    private String author;
    private String format;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}

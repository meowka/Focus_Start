package com.example.focus_start.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class APIResponse implements Serializable {
    @SerializedName("Date")
    @Expose
    public String date;
    @SerializedName("PreviousDate")
    @Expose
    public String previousDate;
    @SerializedName("PreviousURL")
    @Expose
    public String previousURL;
    @SerializedName("Timestamp")
    @Expose
    public String timestamp;
    @SerializedName("Valute")
    @Expose
    public Map<String, Valute> valute;
    private final static long serialVersionUID = 8770451614740452409L;

    public static class Valute implements Serializable{

        @SerializedName("ID")
        @Expose
        public String iD;
        @SerializedName("NumCode")
        @Expose
        public String numCode;
        @SerializedName("CharCode")
        @Expose
        public String charCode;
        @SerializedName("Nominal")
        @Expose
        public Integer nominal;
        @SerializedName("Name")
        @Expose
        public String name;
        @SerializedName("Value")
        @Expose
        public Double value;
        @SerializedName("Previous")
        @Expose
        public Double previous;
        private final static long serialVersionUID = -2113021061628497463L;
    }
}

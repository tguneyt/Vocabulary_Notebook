package com.example.vocabularynotebook;


import static com.example.vocabularynotebook.MainActivity.MainTitle;

public class Title {

    String sTitle;

public String titleadd(String firstlang, String secondlang){

    String firstlang1,secondlang1;

    sTitle = firstlang+"/"+secondlang;

    MainTitle =sTitle;

    return sTitle;
}
}

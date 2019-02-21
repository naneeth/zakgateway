package com.stackroute.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface NlpService {


    public void setParagraph(String paragraph) ;

    public String getCleanerParagrah() ;

    public String getParagrahWithSentences();

    public ArrayList<String> getLemmitizedWords();
    public List<String> getStemmedWords();
    public ArrayList<POSTagging> getPOSWords();
    public ArrayList<String> getWordsWithoutStopWords();
    public String getParagraphWithOutStopWords();

    public HashMap<String, Long> getFrequencyOfWords();

}

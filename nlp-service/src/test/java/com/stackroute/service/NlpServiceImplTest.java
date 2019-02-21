package com.stackroute.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

public class NlpServiceImplTest {
    NlpServiceImpl nlpService = new NlpServiceImpl();

    @Before
    public void setUp() throws Exception {

        nlpService.paragraph = "We are creating KnowledgeHub Application that makes sense of unstructured data which                      "+
                 "remain scattered in an organisation. Making sense of such           scattered unstructured data and converting them into relevant knowledge is one critical challenge all organisations face.";
    }

    @After
    public void tearDown() throws Exception {
          nlpService = null;
    }

    @Test
    public void setParagraph() {
    }

    @Test
    public void getCleanerParagrahSuccess() {

      String actual = nlpService.getCleanerParagrah();
      String expected ="We are creating KnowledgeHub Application that makes sense of unstructured data which"+
                " remain scattered in an organisation. Making sense of such scattered unstructured data and converting them into relevant knowledge is one critical challenge all organisations face.";
        Assert.assertEquals(actual,expected);

    }

    @Test
    public void getCleanerParagrahFailure() {

        String actual = nlpService.getCleanerParagrah();
        String expected ="We are creating KnowledgeHub Application that makes sense of unstructured data which"+
                " remain scattered in an organisation. Making sen se of such scattered unstructured data and converting them into relevant knowledge is one critical challenge all organisations face." +
                "KnowledgeHub is a system that takes unstructured data as in    put in a wide variety of formats such as Web documents, PDF, PPT, RTF and so on. The system extracts and analyses data from the documents and indexes the data against a rich graph ontology based on relationships." +
                " Extracted data are indexed based on metadata and semantics to form a knowledge graph.   " +
                "KnowledgeHub also enables searching the knowledge graph and providing accurate results by comprehending the" +
                " intent of the user who making a search query.";
        Assert.assertNotEquals(actual,expected);

    }

    @Test
    public void getAllTokenizedSentencesSuccess() {
        ArrayList<String> expected = new ArrayList();
        expected.add("We are creating KnowledgeHub Application that makes sense of unstructured data which remain scattered in an organisation. ") ;
        expected.add("Making sense of such scattered unstructured data and converting them into relevant knowledge is one critical challenge all organisations face.") ;

        ArrayList<String> actual = nlpService.getAllTokenizedSentences();
        Assert.assertEquals(actual,expected);

    }

    @Test
    public void getAllTokenizedSentencesFailure() {
        ArrayList<String> expected = new ArrayList();
        expected.add("We are creating KnowledgeHub Application that makes sense of unstructured data which remain scattered in an organisation.") ;
        expected.add("Making sense of such scattered unstructured data and converting them into relevant knowledge is one critical challenge all organisations face. ") ;

        ArrayList<String> actual = nlpService.getAllTokenizedSentences();
        Assert.assertNotEquals(actual,expected);

    }

    @Test
    public void getParagrahWithSentences() {

    }

    @Test
    public void getLemmitizedWordsSuccess() {
           List<String> expected = Arrays.asList("we","be","create","KnowledgeHub","application","that","make","sense","of","unstructured","datum","which","remain","scatter","in","a","organisation",".","make","sense","of","such","scatter","unstructured","datum","and","convert","they","into","relevant","knowledge","be","one","critical","challenge","all","organisation","face",".");

            List<String> actual = nlpService.getLemmitizedWords();
            Assert.assertEquals(actual,expected);

        }

    @Test
    public void getLemmitizedWordsFailure() {
        List<String> expected = Arrays.asList("we","  be","  create","  KnowledgeHub","  application","  that","  make","  datum","  which","  remain","  scatter","  in","  a","  organisation","  .","  make","  sense","  of","  such","  scatter","  unstructured","  datum","  and","  convert","  they","  into","  relevant","  knowledge","  be","  one","  critical","  challenge","  all","  organisation","  face","  .");

        List<String> actual = nlpService.getLemmitizedWords();
        Assert.assertNotEquals(actual,expected);

    }


    @Test
    public void getStemmedWordsSuccess() {
        ArrayList a = new ArrayList();
//        String expected = "[[we], [be], [creat], [KnowledgeHub], [applic], [that], [make], [sens], [of], [unstructur], [datum], [which], [remain], [scatter], [in], [a], [organis], [.], [make], [sens], [of], [such], [scatter], [unstructur], [datum], [and], [convert], [thei], [into], [relev], [knowledg], [be], [on], [critic], [challeng], [all], [organis], [face], [.]]";
       String [][]array1 = {{"we"}, {"be"}, {"creat"}, {"KnowledgeHub"}, {"applic"}, {"that"}, {"make"}, {"sens"}, {"of"}, {"unstructur"}, {"datum"}, {"which"}, {"remain"}, {"scatter"}, {"in"}, {"a"}, {"organis"}, {"."}, {"make"}, {"sens"}, {"of"}, {"such"}, {"scatter"}, {"unstructur"}, {"datum"}, {"and"}, {"convert"}, {"thei"}, {"into"}, {"relev"}, {"knowledg"}, {"be"}, {"on"}, {"critic"}, {"challeng"}, {"all"}, {"organis"}, {"face"}, {"."}};
        ArrayList<String> actual =new ArrayList<>(nlpService.getStemmedWords());
       ArrayList<String> expected = new ArrayList<String>();
       expected.add("[we], [be], [creat], [KnowledgeHub], [applic], [that], [make], [sens], [of], [unstructur], [datum], [which], [remain], [scatter], [in], [a], [organis], [.], [make], [sens], [of], [such], [scatter], [unstructur], [datum], [and], [convert], [thei], [into], [relev], [knowledg], [be], [on], [critic], [challeng], [all], [organis], [face], [.]");
        System.out.println(expected);
        System.out.println(actual);
        Assert.assertEquals(actual.toString(),expected.toString());
    }
    @Test
    public void getStemmedWordsFailure() {

        String [][]array1 = {{"we"}, {"be"}, {"creat"}, {"KnowledgeHub"}, {"applic"}, {"make"}, {"sens"}, {"of"}, {"which"}, {"remain"}, {"scatter"}, {"in"}, {"a"}, {"organis"}, {"."}, {"make"}, {"sens"}, {"of"}, {"such"}, {"scatter"}, {"unstructur"}, {"datum"}, {"and"}, {"convert"}, {"thei"}, {"into"}, {"relev"}, {"knowledg"}, {"be"}, {"on"}, {"critic"}, {"challeng"}, {"all"}, {"organis"}, {"face"}, {"."}};
        ArrayList<String> actual =new ArrayList<>(nlpService.getStemmedWords());
        Assert.assertNotEquals(actual,array1);
    }

    @Test
    public void getWordsWithoutStopWordsSuccess() {
        List<String> expected = Arrays.asList("create", "KnowledgeHub", "application", "make", "sense", "unstructured", "datum", "remain", "scatter", "organisation", ".", "make", "sense", "of", "scatter", "unstructured", "datum", "convert", "relevant", "knowledge", "be", "one", "critical", "challenge", "organisation", "face", ".");
        List<String> actual = new ArrayList<>(nlpService.getWordsWithoutStopWords());
        Assert.assertEquals(actual,expected);
    }
    @Test
    public void getWordsWithoutStopWordsFailure() {
        List<String> expected = Arrays.asList("create", "KnowledgeHub", "application", "make", "sense", "remain", "scatter", "organisation", " .", "make ", "sense", "of", "scatter", "unstructured", "datum", "convert", " relevant", "knowledge", "be", "one", "critical", "challenge", "organisation", "face", ".");
        List<String> actual = new ArrayList<>(nlpService.getWordsWithoutStopWords());
        Assert.assertNotEquals(actual,expected);
    }

    @Test
    public void getParagraphWithOutStopWordsSuccess() {
        String expected = "create KnowledgeHub application make sense unstructured datum remain scatter organisation . make sense of scatter unstructured datum convert relevant knowledge be one critical challenge organisation face .";
        String actual = nlpService.getParagraphWithOutStopWords();
        Assert.assertEquals(actual,expected);
    }


    @Test
    public void getParagraphWithOutStopWordsFailure() {
        String expected = "create Knowledge. make sense of scatter unstructured datum convert re challenge organisation face .";
        String actual = nlpService.getParagraphWithOutStopWords();
        Assert.assertNotEquals(actual,expected);
    }

    @Test
    public void getPOSWordsSuccess() {
        String expected = "[POSTagging{originalWord='create', POSTag='VB'}, POSTagging{originalWord='KnowledgeHub', POSTag='NNP'}, POSTagging{originalWord='application', POSTag='NN'}, POSTagging{originalWord='make', POSTag='VB'}, POSTagging{originalWord='sense', POSTag='NN'}, POSTagging{originalWord='unstructured', POSTag='JJ'}, POSTagging{originalWord='datum', POSTag='NN'}, POSTagging{originalWord='remain', POSTag='VBP'}, POSTagging{originalWord='scatter', POSTag='NN'}, POSTagging{originalWord='organisation', POSTag='NN'}, POSTagging{originalWord='.', POSTag='.'}, POSTagging{originalWord='make', POSTag='VB'}, POSTagging{originalWord='sense', POSTag='NN'}, POSTagging{originalWord='of', POSTag='IN'}, POSTagging{originalWord='scatter', POSTag='NN'}, POSTagging{originalWord='unstructured', POSTag='JJ'}, POSTagging{originalWord='datum', POSTag='NN'}, POSTagging{originalWord='convert', POSTag='VBP'}, POSTagging{originalWord='relevant', POSTag='JJ'}, POSTagging{originalWord='knowledge', POSTag='NN'}, POSTagging{originalWord='be', POSTag='VB'}, POSTagging{originalWord='one', POSTag='CD'}, POSTagging{originalWord='critical', POSTag='JJ'}, POSTagging{originalWord='challenge', POSTag='NN'}, POSTagging{originalWord='organisation', POSTag='NN'}, POSTagging{originalWord='face', POSTag='NN'}, POSTagging{originalWord='.', POSTag='.'}]";
        ArrayList<POSTagging> actual = nlpService.getPOSWords();
        Assert.assertEquals(actual.toString(),expected);
    }
    @Test
    public void getPOSWordsFailure() {
        String expected = "[POSTagging{originalWord='create', POSTag=' VB'}, POSTagging{originalWord='application', POSTag='NN'}, POSTagging{originalWord='make', POSTag='VB'}, POSTagging{originalWord='sense', POSTag='NN'}, POSTagging{originalWord='unstructured', POSTag='JJ'}, POSTagging{originalWord='datum', POSTag='NN'}, POSTagging{originalWord='remain', POSTag='VBP'}, POSTagging{originalWord='scatter', POSTag='NN'}, POSTagging{originalWord='organisation', POSTag='NN'}, POSTagging{originalWord='.', POSTag='.'}, POSTagging{originalWord='make', POSTag='VB'}, POSTagging{originalWord='sense', POSTag='NN'}, POSTagging{originalWord='of', POSTag='IN'}, POSTagging{originalWord='scatter', POSTag='NN'}, POSTagging{originalWord='unstructured', POSTag='JJ'}, POSTagging{originalWord='datum', POSTag='NN'}, POSTagging{originalWord='convert', POSTag='VBP'}, POSTagging{originalWord='relevant', POSTag='JJ'}, POSTagging{originalWord='knowledge', POSTag='NN'}, POSTagging{originalWord='be', POSTag='VB'}, POSTagging{originalWord='one', POSTag='CD'}, POSTagging{originalWord='critical', POSTag='JJ'}, POSTagging{originalWord='challenge', POSTag='NN'}, POSTagging{originalWord='organisation', POSTag='NN'}, POSTagging{originalWord='face', POSTag='NN'}, POSTagging{originalWord='.', POSTag='.'}]";
        ArrayList<POSTagging> actual = nlpService.getPOSWords();
        Assert.assertNotEquals(actual.toString(),expected);
    }

    @Test
    public void getFrequencyOfWordsSuccess() {
        String expected ="{datum=2, be=1, critical=1, remain=1, one=1, organisation=2, sense=2, convert=1, .=2, relevant=1, face=1, application=1, unstructured=2, scatter=2, of=1, create=1, challenge=1, KnowledgeHub=1, make=2, knowledge=1}";
        HashMap<String, Long> actual = nlpService.getFrequencyOfWords();
        Assert.assertEquals(actual.toString(),expected);
    }

    @Test
    public void getFrequencyOfWordsFailure() {
        String expected ="{ organisation=2, sense=2, convert=1, .=2, relevant=1,  face=1, application=1, unstructured=2, scatter=2, of=1, create=1, challenge=1, KnowledgeHub=1, make=2, knowledge=1}";
        HashMap<String, Long> actual = nlpService.getFrequencyOfWords();
        Assert.assertNotEquals(actual.toString(),expected);
    }

}
package com.example.demo.stream;

import com.example.demo.controller.Java8StringPractice;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class Java8StringTest {

    @Test
    public void testAllString() {

        Java8StringPractice js = new Java8StringPractice();

        String s1 = "1234322523";
        String s2 = "12,abADecer";
        String s3 = "     ";
        String s4 = "ABC";
        String s5 = "yzxyaadh";
        String s6 = "aaaaaaaaaaaaaaa";

        String res1 = js.mostFrequentLetters(s1);
        String res2 = js.mostFrequentLetters(s2);
        String res3 = js.mostFrequentLetters(s3);
        String res4 = js.mostFrequentLetters(s4);
        String res5 = js.mostFrequentLetters(s5);
        String res6 = js.mostFrequentLetters(s6);

        Assertions.assertEquals("",res1);
        Assertions.assertEquals("aebcdr",res2);
        Assertions.assertEquals("",res3);
        Assertions.assertEquals("abc",res4);
        Assertions.assertEquals("aydhxz",res5);
        Assertions.assertEquals("a",res6);
    }

}

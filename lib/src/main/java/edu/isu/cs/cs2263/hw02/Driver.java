package edu.isu.cs.cs2263.hw02;

public class Driver {
    public static void main(String[] args){
        // This first test runs through the first three words, then resets back two tokens.
        PushbackTokenizer tkn = new PushbackTokenizerImpl("This is a test without nonspace delimiters");
        System.out.println(tkn.nextToken());
        System.out.println(tkn.nextToken());
        System.out.println(tkn.nextToken());
        tkn.pushback();
        tkn.pushback();
        System.out.println(tkn.nextToken());

        // The second test ensures that the user can still set their own delimiters.
        PushbackTokenizer tkn2 = new PushbackTokenizerImpl("Testing,With Delimiters,different", ", ");
        System.out.println(tkn2.nextToken());
        System.out.println(tkn2.nextToken());
        System.out.println(tkn2.nextToken());
        tkn2.pushback();
        System.out.println(tkn2.nextToken());

        // The third test ensures that normal behavior is observed when the program cannot be pushed back any further
        PushbackTokenizer tkn3 = new PushbackTokenizerImpl("This is the final test");
        System.out.println(tkn3.nextToken());
        tkn3.pushback();
        tkn3.pushback();
        System.out.println(tkn3.nextToken());

        // Ensures that the hasMoreTokens() method works
        PushbackTokenizer tkn4 = new PushbackTokenizerImpl("I was joking about that last test");
        while(tkn4.hasMoreTokens()){
            System.out.println(tkn4.nextToken());
        }
    }
}

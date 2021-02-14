package edu.isu.cs.cs2263.hw02;

import java.util.StringTokenizer;

public class PushbackTokenizerImpl implements PushbackTokenizer{
    private String inputStr;
    private String inputDelim;
    private StringTokenizer current;

    public PushbackTokenizerImpl(String str, String delim) {
        current = new StringTokenizer(str, delim);
        inputStr = str;
        inputDelim = delim;
    }

    public PushbackTokenizerImpl(String str) {
        current = new StringTokenizer(str);
        inputStr = str;
    }

    @Override
    public String nextToken() {
        return current.nextToken();
    }

    @Override
    public boolean hasMoreTokens() {
        return current.hasMoreTokens();
    }

    @Override
    public void pushback() {
        // To roll back the tokenizer, it is reset and moved forward until it is exactly one index behind where it was before
        StringTokenizer initial = setInitial(inputStr, inputDelim);
        if(initial.countTokens() == current.countTokens()){
            return;
        }
        for(int i = 0; i < (initial.countTokens() - current.countTokens() - 1); i++){
            initial.nextToken();
        }
        current = initial;
    }

    private static StringTokenizer setInitial(String str, String delim){
        StringTokenizer tkn;
        if(delim == null){
            tkn = new StringTokenizer(str);
        } else {
            tkn = new StringTokenizer(str, delim);
        }
        return tkn;
    }
}

package com.practice.main;

public class PossibleCombinatiosOfSet {
    private StringBuilder output = new StringBuilder();
    private final String inputstring;
    public PossibleCombinatiosOfSet( final String str ){
        inputstring = str;
        System.out.println("The input string  is  : " + inputstring);
    }
    
    
    public static void main (String args[])
    {
        PossibleCombinatiosOfSet combobj= new PossibleCombinatiosOfSet("wxyz");
        System.out.println("");
        System.out.println("");
        System.out.println("All possible combinations are :  ");
        System.out.println("");
        System.out.println("");
        combobj.combine();
    }
    
    public void combine() { combine( 0 ); }
    private void combine(int start ){
        for( int i = start; i < inputstring.length(); ++i ){
        	char appendChar = inputstring.charAt(i);
            output.append(appendChar);
            System.out.println( output );
            combine( i + 1);
            output.setLength( output.length() - 1 );
            System.out.print("");
        }
    }
}
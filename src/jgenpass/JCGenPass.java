/*
 * Java password generator
 */

package jgenpass;

import java.util.Random;

/**
 * Password generator
 * @version 1.0
 * @author Denis Ovcharenko
 */
public class JCGenPass {
    private int sizeOfpassword = 0;
    private boolean isUpperCase = false;
    private boolean isSpecialSymb = false;
    private String charset = "0123456789abcdefghijklmnopqrstuvwxyz";
    private final String specialSymb = "$#_";
    
    
    public JCGenPass(int sizeOfpassword, boolean isUpperCase, boolean isSpecialSymb) {
        this.sizeOfpassword = sizeOfpassword;
        this.isUpperCase = isUpperCase;
        this.isSpecialSymb = isSpecialSymb;
    }
    
    public int getSizeOfpassword(){
        return sizeOfpassword;
    }
    
    public boolean getIsUpperCase(){
       return isUpperCase;
    }
            
    public boolean getIsSpecialSymb(){
        return isSpecialSymb;
    }
    
    private String getRandomPassword(int length, boolean isUpperCase, boolean isSpecialSymb) {
        Random rand = new Random(System.currentTimeMillis());
        StringBuilder sb = new StringBuilder();
        int pos;
        boolean isUP;
        if (isSpecialSymb)
            charset = charset + specialSymb;
        String charsetUP = charset.toUpperCase();
        for (int i = 0; i < length; i++) {
            pos = rand.nextInt(charset.length());
            isUP = (pos % 2) == 0;
            //
            if (isUpperCase)
                if(isUP){
                    sb.append(charsetUP.charAt(pos));
                }else
                    sb.append(charset.charAt(pos));
            else
                sb.append(charset.charAt(pos));
        }
        return sb.toString();
    }
    
    public String createPassword(){
        String result = getRandomPassword(getSizeOfpassword(), getIsUpperCase(), getIsSpecialSymb());
        return result;
    }
    
}

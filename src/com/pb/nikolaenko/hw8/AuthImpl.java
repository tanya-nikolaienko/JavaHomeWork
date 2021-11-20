package com.pb.nikolaenko.hw8;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class AuthImpl implements AuthUser {
    private static ArrayList<Auth> array = new ArrayList<Auth>();

    public boolean signIn(String Login, String Password){ // проверка входа
        boolean flag=false;

        for (Auth a:array){
            if(a.getLogin().equals(Login)&&
               a.getPassword().equals(Password)){
                flag=true;
                break;
            }
        }
        return flag;
    }

    @Override
    public void signup(Auth auth) { // регистрация
        array.add(auth);








/*
        public boolean isCyrillic(String textInput)
        {
            boolean rezultat=true;
            String pattern = @"[абвгдѓежзѕијклљмнњопрстќуфхцчџш]";
            char[] textArray = textInput.ToCharArray();
            for (int i = 0; i < textArray.length; i++)
            {
                if (!Regex.isMatch(textArray[i].ToString(),pattern))
                {
                    rezultat = false;
                    break;
                }
            }
            return rezultat;
        }
*/
/*
        public boolean isCyrillic(String s) {
            boolean result = false;
            for (char a : s.toCharArray()) {
                if (Character.UnicodeBlock.of(a) == Character.UnicodeBlock.CYRILLIC) {
                    result = !result;
                    break;
                }
            }
            return result;
        }
*/

/*
        String template = "([0-9A-Za-z])";
        boolean isMatchingRegexp(final String text, final String template) {
            Pattern pattern = null;
            try                    {
                pattern = Pattern.compile(template);
            }
            catch(PatternSyntaxException e) {
                e.printStackTrace();
            }
            if(pattern == null)                    {
                return false;
            }
            final Matcher regexp = pattern.matcher(text);
            return regexp.matches();
        }
*/
    }
}

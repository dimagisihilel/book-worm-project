package lk.ijse.util;

import javafx.scene.control.TextField;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static boolean isTextFieldValid(TextFields textField,String text){
        String field="";
        switch (textField){
            case ID:
                field="(^([A-Z]+\\d{3})$||^(\\d+)$)";
                break;
            case LANKAN_ID:
                field="^([0-9]){5,10}([V|v]){0,1}$";
                break;
            case NAME:
                field="^[A-z|\\s]{3,}$";
                break;
            case EMAIL:
                field="^([A-z])([A-z0-9.]){1,}[@]([A-z0-9]){1,10}[.]([A-z]){2,5}$";
                break;
            case ADDRESS:
                field="^([A-z0-9]|[-/,.@+]|\\s){4,}$";
                break;
            case PHONE:
                field="^([+]94{1,3}|[0])([1-9]{2})([0-9]){7}$";
                break;
            case DOUBLE:
                field="^([0-9]){1,}[.]([0-9]){1,}$";
                break;
            case INTEGER:
                field="^([0-9]){1,}$";
                break;
            case NONE_CHARACTER:
                field="^[\\W]{1,}$";
                break;
            case INVOICE:
                field="^([A-z 0-9]){1,5}([0-9/_@$+,-]){1,}$";
                break;
            case TEXT_SPACE_NUMBER:
                field="^[a-z A-Z\\d]{1,}$";
                break;
            case PASSWORD:
                field="^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";
                break;
        }

        Pattern pattern=Pattern.compile(field);
        if(text !=null){
            if(text.trim().isEmpty()){
                return false;
            }
        }else{
            return false;
        }
        Matcher matcher= pattern.matcher(text);

        if(matcher.matches()){
            return true;
        }
        return false;
    }public static boolean setTextColor(TextFields location, TextField fields){

        if(Regex.isTextFieldValid(location,fields.getText())){
            //fields.setFocusColor(Paint.valueOf("Green"));
            fields.setStyle(" -fx-text-fill: #38a600;");
            return true;
        }else {
            //fields.setFocusColor(Paint.valueOf("Red"));
            fields.setStyle(" -fx-text-fill: #ff0000;");
            return false;
        }
    }
}

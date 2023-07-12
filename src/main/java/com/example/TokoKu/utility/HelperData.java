package com.example.TokoKu.utility;

import java.text.NumberFormat;
import java.util.Locale;

public class HelperData {
    public static String formatCurrency(Double value){
        Locale indo=new Locale("id","ID");
        return NumberFormat.getCurrencyInstance(indo).format(value);
    }

    public static String textFormat(String message){
        String formattedMessage = message.replaceAll("\\n", "<br>");
        return formattedMessage;
    }
}

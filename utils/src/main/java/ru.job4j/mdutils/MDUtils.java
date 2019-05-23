package ru.job4j.mdutils;

import java.util.Scanner;

/**
 * Преобразует строку в заголовок со ссылко для файлов
 * README.md в github
 *
 * @author Alexander Abramov (alllexe@mail.ru)
 * @version 1
 * @since 10.04.2019
 */
public class MDUtils {

    public String getMenuItem(String str) {
        str = str.replaceAll("#", "");
        str = str.replaceAll("\\(", "");
        str = str.replaceAll("\\)", "");
        str = str.replaceAll("\\[", "");
        str = str.replaceAll("\\]", "");
        str = str.replaceAll("\\+", "");
        str = str.replaceAll("\\/", "");
        str = str.trim();

        String question = str;
        question = "+ [" + question + "]";

        str = str.replaceAll("\\.", "");
        str = str.replaceAll("\\,", "");
        str = str.replaceAll("\\?", "");
        str = str.replaceAll(" ", "-");

        String answer = removeNumberFromBeginOfLine(str);

        return question + "(#" + answer + ")";
    }

    private String removeNumberFromBeginOfLine(String str) {
        String number = str.substring(str.indexOf("-") - 1);
        if (isNumeric(number)) {
            str = str.substring(str.indexOf("-") + 1);
        }
        return str;
    }

    public static boolean isNumeric(String strNum) {
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {

        String str;
        MDUtils mdUtils = new MDUtils();
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            str = input.nextLine();
            if (str.isEmpty()) {
                break;
            }
            System.out.println(mdUtils.getMenuItem(str));
        }
    }


}
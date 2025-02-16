package com.regex.replaceandmodifystrings.replacemultiplespaceswithsinglespace;

public class RemoveExtraSpaces {
    public static void main(String[] args) {
        String text = "This   is  an   example   with   multiple   spaces.";

        String modifiedText = replaceMultipleSpaces(text);

        // Print the modified text
        System.out.println(modifiedText);
    }

    public static String replaceMultipleSpaces(String text) {
        return text.replaceAll("\\s+", " ").trim();
    }
}

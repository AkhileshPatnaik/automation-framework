package org.akhil.test.framework;

import org.testng.TestRunner;
import org.testng.annotations.Test;

public class ReverseTask {
    @Test
    public void capitalizel() {
        String str = "Shivam Pratap Singh";
        String[] a = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String each : a) {
            StringBuilder reverse = new StringBuilder(each).reverse();
            if (reverse.length() > 1) {
                reverse.setCharAt(0, Character.toUpperCase(reverse.charAt(0)));
            }
            sb.append(reverse + " ");
        }
        System.out.println("After Reversing the statement is: " + sb.toString().trim());
    }

    @Test
    public void capitalizeFirstandLast() {
        String str = "i love my india";
        String[] a = str.split(" ");
        StringBuffer sb = new StringBuffer();
        for (String each : a) {
            StringBuffer reverse = new StringBuffer(each).reverse();
            if (reverse.length() > 1) {
                reverse.setCharAt(0, Character.toUpperCase(reverse.charAt(0)));
                reverse.setCharAt(reverse.length() - 1, Character.toUpperCase(reverse.charAt(reverse.length() - 1)));
            } else {
                reverse.setCharAt(0, Character.toUpperCase(reverse.charAt(0)));
            }
            sb.append(reverse).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

}

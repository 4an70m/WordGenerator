/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alex.wordgeneratorproject;

import java.util.Random;

/**
 *
 * @author Admin
 */
public class NewWord {

    private StringBuffer a;
    private Random r;
    public static char[] vovels;
    public static char[] consonants;

    public NewWord() {
        a = new StringBuffer();
        r = new Random();
        vovels = new char[]{'у', 'е', 'ы', 'а', 'о', 'э', 'я', 'и', 'ю', 'ё'};
        consonants = new char[]{'й', 'ц', 'к', 'н', 'г', 'ш', 'щ', 'з', 'х', 'б', 'ф', 'в', 'п', 'р', 'л', 'д', 'ж', 'ч', 'c', 'м', 'т', 'ь'};
    }

    private static boolean contains(char[] array, char letter) {
        for (char temp : array) {
            if (temp == letter) {
                return true;
            }
        }
        return false;
    }

    public void generate() {
        if (a.length() > 0) {
            a.delete(0, a.length() - 1);
        }
        int size = 0;
        char randomLetter;
        //size of the word
        while (size <= 3) {
            size = r.nextInt(8);
        }
        //starting letter
        if (r.nextInt(1) == 0) {
            randomLetter = vovels[r.nextInt(vovels.length)];
        } else {
            randomLetter = consonants[r.nextInt(consonants.length)];
        }
        //write newly generated letter
        a.append(randomLetter);
        //other part of the word
        for (int i = 1; i < size; i++) {
            if (contains(vovels, a.charAt(i - 1))) {
                randomLetter = consonants[r.nextInt(consonants.length)];
            } else {
                randomLetter = vovels[r.nextInt(vovels.length)];
            }
            a.append(randomLetter);
        }
    }
    @Override
    public String toString() {
        return a.toString();
    }
    public int length()
    {
        return a.length();
    }

}

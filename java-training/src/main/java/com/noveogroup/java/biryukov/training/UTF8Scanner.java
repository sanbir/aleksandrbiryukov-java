package com.noveogroup.java.biryukov.training;

import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Scanner;

/**
 * Specifies the encoding of Scanner as UTF-8.
 */
final class UTF8Scanner {

    private UTF8Scanner() { }

    public static Scanner getScanner() {
        return new Scanner(new InputStreamReader(System.in, Charset.forName("UTF-8")));
    }
}

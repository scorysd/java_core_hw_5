package ru.geekbrains.lesson5;

import java.io.File;

public class Tree {

    /**
     * DO: Доработать метод print, необходимо распечатывать директории и файлы
     *
     * @param file
     * @param indent
     * @param isLast
     */
    public static void print(File file, String indent, boolean isLast) {
        System.out.print(indent); // рисуем отступ
        if (isLast) {
            System.out.print("└─");
            indent += "  ";
        } else {
            System.out.print("├─");
            indent += "│ ";
        }
        System.out.println(file.getName());

        File[] files = file.listFiles();
        if (files == null)
            return;
        int filesTotal = 0;
        int subDirTotal = 0;
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory())
                subDirTotal++;
            if (files[i].isFile())
                filesTotal++;
        }
        int filesCounter = 0;
        int subDirCounter = 0;
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                print(files[i], indent, subDirCounter == subDirTotal - 1);
                subDirCounter++;
            }
            if (files[i].isFile()) {
                print(files[i], indent, filesCounter == filesTotal - 1);
                filesCounter++;
            }


        }
    }
}

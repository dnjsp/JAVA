package kr.or.ddit.basic;

import java.io.File;

public class FileTest03 {
   public static void main(String[] args) {
      File f = new File("d:/D_Other/test.txt");
      System.out.println(f.getName() + "의 크기 : " + f.length() + " byte");
      
      System.out.println("path : " + f.getPath());
      System.out.println("absolutePath : " + f.getAbsolutePath());
      System.out.println();
      
      File file = new File(".");
      System.out.println("path : " + file.getPath());
      System.out.println("absolutePath : " + file.getAbsolutePath());
      System.out.println();
   }
}
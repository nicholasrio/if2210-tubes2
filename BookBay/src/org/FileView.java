package org;

public class FileView {
  public void printFileDetails(FileExt File){
      System.out.println("Name      : "+File.getName());
      System.out.println("Size      : "+File.getSize());
      System.out.println("Location  : "+File.getLocation());
  }
}

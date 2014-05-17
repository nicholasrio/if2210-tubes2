package org;

public class FileView {
  public void printFileDetails(FileExt file){
      System.out.println("Name      : " + file.getNamedName());
      System.out.println("Size      : " + file.length());
      System.out.println("Location  : " + file.getAbsolutePath());
  }
}

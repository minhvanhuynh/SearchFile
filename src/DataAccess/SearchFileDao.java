/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import view.Validation;

/**
 *
 * @author This PC
 */
public class SearchFileDao {
    
    private static SearchFileDao instance=null;
    private Validation validation;
    
    public SearchFileDao(){
        validation= new Validation();
    }
    
    public static SearchFileDao Instance(){
        if(instance==null){
            synchronized (SearchFileDao.class) {
                if(instance==null){
                    instance= new SearchFileDao();
                }
            }
        }
        return instance;
    }
    
    public int countWordInFile(String path, String word) {           
        FileReader fr = null;
        try {
            fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            int count = 0;
            while (line != null) {
                String[] parts = line.split(" ");
                for (String w : parts) {
                    if (w.equalsIgnoreCase(word)) {
                        count++;
                    }
                }
                line = br.readLine();
            }
            return count;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return 0;
    }
    
    public void getFileNameContainsWordInDirectory() {
        System.out.println("-------- Find File By Word --------");
        System.out.print("Enter Path: ");
        String path = validation.checkInputString();
        System.out.print("Enter Word: ");
        String word = validation.checkInputString();
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        System.out.println("------------ File Name ------------");
        for (File file : listOfFiles) {
            if (file.isFile()) {
                if (countWordInFile(file.getAbsolutePath(), word) != 0) {
                    System.out.println("file name: " + file.getName());
                }
            }
        }
    }
}

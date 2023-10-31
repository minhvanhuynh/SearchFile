/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Repository.ISearchFileRepository;
import Repository.SearchFileRepository;
import view.Menu;
import view.Validation;

/**
 *
 * @author This PC
 */
public class ManageSearchFile extends Menu<String>{
    
    private ISearchFileRepository isf= new SearchFileRepository();
    private Validation validation= new Validation();
    private String path;
    private String word;
    
    public ManageSearchFile(String title, String[] s){
        super(title, s);
    }
    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                System.out.println("-------- Count Word --------");     
                System.out.print("Enter Path: ");
                path = validation.checkInputString();
                System.out.print("Enter Word: ");
                word = validation.checkInputString();
                System.out.println("Result: "+isf.countWordInFile(path, word));
                break;
            case 2:
                isf.getFileNameContainWordInDirectory();
                break;
            case 3:
                System.exit(0);
                break;
        }
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository;

/**
 *
 * @author This PC
 */
public interface ISearchFileRepository {
    public int countWordInFile(String path, String word);
    
    public void getFileNameContainWordInDirectory();
}

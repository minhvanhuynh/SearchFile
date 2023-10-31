/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DataAccess.SearchFileDao;

/**
 *
 * @author This PC
 */
public class SearchFileRepository implements ISearchFileRepository{


    @Override
    public void getFileNameContainWordInDirectory() {
        SearchFileDao.Instance().getFileNameContainsWordInDirectory();
    }
    

    @Override
    public int countWordInFile(String path, String word) {
        return SearchFileDao.Instance().countWordInFile(path, word);
    }
    
}

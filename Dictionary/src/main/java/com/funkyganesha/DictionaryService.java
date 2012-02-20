package com.funkyganesha;

import java.util.List;

public interface DictionaryService {
    void createDictionary(List<String> strings);

    void insertIntoDictionary(String wordToInsert);

    void deleteFromDictionary(String wordToDelete);

    void findInDictionary(String searchWord);
}

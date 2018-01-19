package wordsdemo.zhangxiao.com.wordsdemo;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * @author ZhangXiao
 * @date 2018/1/18
 */
@Dao
public interface WordDao {

    @Insert
    void insertWord(Word word);

    @Query("DELETE from word_table")
    void deleteAll();

    @Query("SELECT * FROM WORD_TABLE ORDER BY word ASC")
    LiveData<List<Word>> getAllWords();
}

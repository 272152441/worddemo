package wordsdemo.zhangxiao.com.wordsdemo;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * @author ZhangXiao
 * @date 2018/1/18
 */
@Entity(tableName ="word_table" )
public class Word {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "word")
    private String mWord;

    public Word(String word) {
        mWord = word;
    }

    public String getWord() {
        return mWord;
    }
}

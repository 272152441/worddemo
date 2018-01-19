package wordsdemo.zhangxiao.com.wordsdemo;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * @author ZhangXiao
 * @date 2018/1/18
 */
@Database(entities = {Word.class},version = 1)
public abstract class WordRoomDataBase extends RoomDatabase {

    private static volatile WordRoomDataBase INSTANCE;

    public abstract WordDao getWordDao();

    public static WordRoomDataBase getInstance(final Context context){
        if(INSTANCE==null){
            synchronized (WordRoomDataBase.class){
                if(INSTANCE==null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext()
                            ,WordRoomDataBase.class,"word_database").build();
                }
            }

        }
        return INSTANCE;
    }
}

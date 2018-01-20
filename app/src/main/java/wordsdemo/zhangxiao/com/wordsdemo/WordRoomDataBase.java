package wordsdemo.zhangxiao.com.wordsdemo;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

/**
 * @author ZhangXiao
 * @date 2018/1/18
 */
@Database(entities = {Word.class}, version = 1)
public abstract class WordRoomDataBase extends RoomDatabase {

    private static volatile WordRoomDataBase INSTANCE;

    public abstract WordDao getWordDao();

    public static WordRoomDataBase getInstance(final Context context) {
        if (INSTANCE == null) {
            synchronized (WordRoomDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext()
                            , WordRoomDataBase.class, "word_database")
                            .addCallback(callback).build();
                }
            }

        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback callback = new Callback() {

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            new PopulateDbAsync(INSTANCE).execute();
        }
    };

    private static class PopulateDbAsync extends AsyncTask<Void,Void,Void>{

        private WordDao wordDao;

        public  PopulateDbAsync(WordRoomDataBase INSTANCE){
            wordDao = INSTANCE.getWordDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            wordDao.deleteAll();
            Word word1 = new Word("Hello");
            wordDao.insertWord(word1);
            Word word2 = new Word("World");
            wordDao.insertWord(word2);
            return null;
        }
    }
}

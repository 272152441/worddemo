package wordsdemo.zhangxiao.com.wordsdemo;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

/**
 * @author 张枭
 * @version V1.0
 * @date 2018/1/20
 * @desc
 */
public class WordRepository {

    private WordDao mWordDao;
    private LiveData<List<Word>> mAllWords;

    public WordRepository(Context context){
        WordRoomDataBase dataBase = WordRoomDataBase.getInstance(context);
        mWordDao = dataBase.getWordDao();
        mAllWords = mWordDao.getAllWords();
    }

    public LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }

    public void insertWord(Word word){
        new InsertWordAsync(mWordDao).execute(word);
    }

    private static  class InsertWordAsync extends AsyncTask<Word,Void,Void>{
        private WordDao wordDao;

        public InsertWordAsync(WordDao wordDao){
            this.wordDao = wordDao;
        }

        @Override
        protected Void doInBackground(final Word... words) {
            wordDao.insertWord(words[0]);
            return null;
        }
    }
}

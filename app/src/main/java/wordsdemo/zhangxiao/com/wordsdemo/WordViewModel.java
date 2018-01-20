package wordsdemo.zhangxiao.com.wordsdemo;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

/**
 * @author 张枭
 * @version V1.0
 * @date 2018/1/20
 * @desc
 */
public class WordViewModel extends AndroidViewModel {
    private WordRepository mWordRepository;

    private LiveData<List<Word>> mAllWords;

    public WordViewModel(@NonNull Application application) {
        super(application);
        mWordRepository = new WordRepository(application);
        mAllWords = mWordRepository.getAllWords();
    }

    public LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }

    public void insertWord(Word word){
        mWordRepository.insertWord(word);
    }
}

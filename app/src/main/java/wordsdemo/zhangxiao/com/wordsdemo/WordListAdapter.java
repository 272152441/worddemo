package wordsdemo.zhangxiao.com.wordsdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 张枭
 * @version V1.0
 * @date 2018/1/20
 * @desc
 */
public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {



    private LayoutInflater inflater;

    private List<Word> allWords = new ArrayList<>();

    public WordListAdapter(Context context){
        inflater = LayoutInflater.from(context);
    }

    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new WordViewHolder(inflater
                .inflate(R.layout.item_recyclerview,parent,false));
    }

    @Override
    public void onBindViewHolder(WordViewHolder holder, int position) {
        Word word = allWords.get(position);
        holder.wordItemView.setText(word.getWord());
    }


    @Override
    public int getItemCount() {
        return allWords.size();
    }

    public void setList(List<Word> words){
        if(words!=null){
            allWords = words;
            notifyDataSetChanged();
        }
    }

    class WordViewHolder extends RecyclerView.ViewHolder{
        TextView wordItemView;

        public WordViewHolder(View itemView) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.textview);
        }
    }
}

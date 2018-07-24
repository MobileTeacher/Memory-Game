package br.edu.infnet.memorygame;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CardAdapter extends BaseAdapter {

    Context context;
    List cards_frontId;

    public CardAdapter(Context context, int[] imagesId) {
        cards_frontId = new ArrayList<>(Arrays.asList(imagesId));
        this.context = context;
    }

    public CardAdapter(Context context, List<Integer> imagesId) {
        cards_frontId = imagesId;
        this.context = context;
    }

    @Override
    public int getCount() {
        return cards_frontId.size();
    }

    @Override
    public Object getItem(int i) {
        return cards_frontId.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null){
            view = new GameCard(context);
        }
        //TODO: config front
        return view;
    }
}

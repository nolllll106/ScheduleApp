package jp.techacademy.toshinori.suzuki.scheduleapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Created by Tony on 2017/06/08.
 */

public class MessageListAdapter extends BaseAdapter {

    private LayoutInflater mLayoutInflater = null;
    private Message mMessage;

    public MessageListAdapter(Context context, Message message) {
        mLayoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mMessage = message;
    }

    @Override
    public int getCount() {
        return 1;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public Object getItem(int position) {
        return mMessage;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        String contents = mMessage.getmContents();
        String author = mMessage.getmAuthor();
        return convertView;
    }

}

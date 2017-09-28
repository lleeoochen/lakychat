package com.lakywale.lakychat;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ChatViewAdapter extends BaseAdapter {

    private static LayoutInflater inflater;
    private Activity mainActivity;
    private ArrayList<ChatMessage> messages;

    public ChatViewAdapter(Activity mainActivity, ArrayList<ChatMessage> messages) {
        this.messages = messages;
        this.mainActivity = mainActivity;
        inflater = (LayoutInflater) mainActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return messages.size();
    }

    @Override
    public ChatMessage getItem(int position) {
        return messages.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class Holder {
        TextView message_view;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        final Holder holder;
        View layoutView = convertView;

        if (convertView == null) {
            layoutView = inflater.inflate(R.layout.each_chat_view, null);
            holder = new Holder();
            layoutView.setTag(holder);
        } else {
            holder = (Holder) layoutView.getTag();
        }

        ChatMessage chatMessage = messages.get(position);
        holder.message_view = (TextView) layoutView.findViewById(R.id.each_chat_message);

        if ( chatMessage.sender.equals("Wei Tung") ) {
            ((LinearLayout)layoutView).setGravity(Gravity.END);
            holder.message_view.setGravity(Gravity.END);
            layoutView.setBackgroundResource(R.color.chat_submit);
        } else {
            ((LinearLayout)layoutView).setGravity(Gravity.START);
            holder.message_view.setGravity(Gravity.START);
            layoutView.setBackgroundResource(R.color.chat_input);
        }

        if ( position > 0 && messages.get(position - 1).sender.equals(chatMessage.sender) )
            layoutView.setPadding(
                    mainActivity.getResources().getDimensionPixelOffset(R.dimen.each_chat_padding),
                    0,
                    mainActivity.getResources().getDimensionPixelOffset(R.dimen.each_chat_padding),
                    mainActivity.getResources().getDimensionPixelOffset(R.dimen.each_chat_padding));

        holder.message_view.setText(chatMessage.message);

        return layoutView;
    }
}

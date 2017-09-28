package com.lakywale.lakychat;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class ChatFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_chat, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayList<ChatMessage> messages = new ArrayList<>();
        messages.add(new ChatMessage("Wei Tung", "I think you are cute.", 12345));
        messages.add(new ChatMessage("Soy", "You are sick. Go away!!!!!!!!!!!!!!! :(((", 12345));
        messages.add(new ChatMessage("Wei Tung", "Oh please... I just want to talk...", 12345));
        messages.add(new ChatMessage("Wei Tung", "Plzzz..", 12345));
        messages.add(new ChatMessage("Soy", "See you later =.=", 12345));

        ListView chat_list_view = (ListView) getActivity().findViewById(R.id.chat_view);
        chat_list_view.setAdapter(new ChatViewAdapter(getActivity(), messages));

    }
}

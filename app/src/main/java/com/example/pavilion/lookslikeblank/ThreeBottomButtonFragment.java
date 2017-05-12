package com.example.pavilion.lookslikeblank;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class ThreeBottomButtonFragment extends Fragment implements View.OnClickListener{
    ButtonClickListener bListener;
    public int pageNumber = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate
                (R.layout.three_bottom_button_fragment, container, false);
        Button prev = (Button) view.findViewById(R.id.previous_button);
        Button proceed = (Button) view.findViewById(R.id.proceed_button);
        Button next = (Button) view.findViewById(R.id.next_button);

        prev.setOnClickListener(this);
        proceed.setOnClickListener(this);
        next.setOnClickListener(this);

        return view;
    }

    public interface ButtonClickListener {
        public void PreviousButtonListener(int position);
        public void ProceedButtonListener(int position);
        public void NextButtonListener(int position);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onClick(View view) {
        Button CheckButton = (Button) view.findViewById(R.id.proceed_button);
        bListener.ProceedButtonListener(pageNumber);
    }
}

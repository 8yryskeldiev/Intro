package com.example.intro;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.airbnb.lottie.LottieAnimationView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {

    public BlankFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate( R.layout.fragment_blank, container, false );
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated( view, savedInstanceState );
        LottieAnimationView lottieAnimationView=view.findViewById( R.id.animation_view );
        final int pos=getArguments().getInt( "pos" );
        switch (pos){
            case 0:
                lottieAnimationView.setAnimation( R.raw.history );
                break;
            case 1:
                lottieAnimationView.setAnimation( R.raw.swinging );
                break;
            case 2:
                lottieAnimationView.setAnimation( R.raw.startupanimations );
                break;
        }

    }

}

package com.example.withbash.ui.pay;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.withbash.R;


public class Pay extends Fragment implements View.OnClickListener {

    private NavController navController;
    public Button button;


    public Pay() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pay, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController= Navigation.findNavController(view);
        button =view.findViewById(R.id.pay_nav);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        navController.navigate(R.id.action_navigation_pay_to_cart);

    }
}
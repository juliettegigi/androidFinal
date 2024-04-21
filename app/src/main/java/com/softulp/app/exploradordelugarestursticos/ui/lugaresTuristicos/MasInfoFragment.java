package com.softulp.app.exploradordelugarestursticos.ui.lugaresTuristicos;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softulp.app.exploradordelugarestursticos.R;
import com.softulp.app.exploradordelugarestursticos.databinding.FragmentMasInfoBinding;

public class MasInfoFragment extends Fragment {

    private MasInfoViewModel vm;
    private FragmentMasInfoBinding binding;

    public static MasInfoFragment newInstance() {
        return new MasInfoFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        vm=new ViewModelProvider(this).get(MasInfoViewModel.class);
        binding=FragmentMasInfoBinding.inflate(inflater,container,false);
        View root = binding.getRoot();
        vm.getMutableLugar().observe(getViewLifecycleOwner(), new Observer<LugarTuristico>() {
            @Override
            public void onChanged(LugarTuristico lugarTuristico) {
                binding.tvNombre2.setText(lugarTuristico.getNombre());
                binding.tvMAsInfo.setText(lugarTuristico.getMasInfo());
                binding.tvHorario.setText(lugarTuristico.getHorarios());
                if(lugarTuristico.getFotos()!=null) {
                    binding.ivImagen.setImageResource(lugarTuristico.getFotos().get(0));
                    binding.btnNext.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            vm.getImg(1);
                        }
                    });
                    binding.btnPrevious.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            vm.getImg(-1);
                        }
                    });
                }
            }
        });

        vm.getMutableImagen().observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                binding.ivImagen.setImageResource(integer);
            }
        });



        vm.recibirLugar(getArguments());
        return root;
    }



}
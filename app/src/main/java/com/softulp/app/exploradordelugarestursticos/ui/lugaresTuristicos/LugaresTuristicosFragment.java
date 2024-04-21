package com.softulp.app.exploradordelugarestursticos.ui.lugaresTuristicos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.softulp.app.exploradordelugarestursticos.databinding.FragmentLugaresturisticosBinding;

public class LugaresTuristicosFragment extends Fragment {

    private LugaresTuristicosViewModel vm;
    private FragmentLugaresturisticosBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        vm = new ViewModelProvider(this).get(LugaresTuristicosViewModel.class);
        binding = FragmentLugaresturisticosBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        vm.getMutableAdapter().observe(getViewLifecycleOwner(), new Observer<RecyclerView.Adapter<LugarTuristicoAdapter.ViewHolder>>() {
            @Override
            public void onChanged(RecyclerView.Adapter<LugarTuristicoAdapter.ViewHolder> viewHolderAdapter) {
                GridLayoutManager glm=new GridLayoutManager(getContext(),1,GridLayoutManager.VERTICAL,false);
                binding.rvLista.setLayoutManager(glm);
                binding.rvLista.setAdapter(viewHolderAdapter);
            }
        });



        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
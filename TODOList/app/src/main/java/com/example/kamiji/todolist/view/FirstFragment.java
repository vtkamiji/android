package com.example.kamiji.todolist.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kamiji.todolist.R;
import com.example.kamiji.todolist.TodoApplication;
import com.example.kamiji.todolist.dao.TaskDAO;
import com.example.kamiji.todolist.databinding.FragmentFirstBinding;
import com.example.kamiji.todolist.model.Task;
import com.example.kamiji.todolist.view.adapter.TaskAdapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    TaskAdapter adapter;
    private List<Task> listaTarefas;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);

        loadTasks();
        //RecycleView
        adapter = new TaskAdapter(this.listaTarefas);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(inflater.getContext());
        binding.taskRecyclerView.setLayoutManager(layoutManager);
        binding.taskRecyclerView.setHasFixedSize(true);
        binding.taskRecyclerView.addItemDecoration(new DividerItemDecoration(inflater.getContext(), LinearLayout.HORIZONTAL));
        binding.taskRecyclerView.setAdapter(adapter);

        return binding.getRoot();
    }

    private void loadTasks() {

        TaskDAO taskDAO = ((TodoApplication)this.getContext().getApplicationContext()).getDatabase().getTaskDAO();
        List<Task> tarefas = taskDAO.list();
        if (tarefas != null && tarefas.size() > 0) {
            getListaTarefas().clear();
            getListaTarefas().addAll(tarefas);
        }
        adapter = new TaskAdapter(this.listaTarefas);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Bundle args = new Bundle();
//                args.putString("taskId", "1");
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Inflate the menu; this adds items to the action bar if it is present.
        inflater.inflate(R.menu.menu_main, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private  List<Task> getListaTarefas() {
        if (this.listaTarefas == null) {
            this.listaTarefas = new ArrayList<>();
        }
        return listaTarefas;
    }
}
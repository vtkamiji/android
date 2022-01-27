package com.example.kamiji.todolist.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavArgument;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.example.kamiji.todolist.R;
import com.example.kamiji.todolist.TodoApplication;
import com.example.kamiji.todolist.dao.TaskDAO;
import com.example.kamiji.todolist.databinding.FragmentSecondBinding;
import com.example.kamiji.todolist.model.Task;

import java.util.Date;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    private Task editTask;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        binding.btEditarTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTask(v);
            }
        });

        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {

            String taskId = getArguments().getString("taskId");

            if (taskId != null) {

                editTask = getTaskDAO().getById(Integer.parseInt(taskId));
                binding.txtEditTask.setText(editTask.getMessage());
                binding.btEditarTask.setText("Editar");
            } else {
                binding.txtEditTask.setText("");
                binding.btEditarTask.setText("Salvar");
            }
        }
    }

    private void editTask(View view) {
        if (editTask != null && editTask.getId() != null) {
            editTask.setMessage(binding.txtEditTask.getText().toString());
            getTaskDAO().update(editTask);
            Toast.makeText(getContext(), "Tarefa editada com sucesso!", Toast.LENGTH_LONG).show();
        } else {
            editTask = new Task();
            editTask.setMessage(binding.txtEditTask.getText().toString());
            editTask.setTitle("Nova Tarefa");
            editTask.setCreationDate(new Date().toString());
            getTaskDAO().insert(editTask);
            Toast.makeText(getContext(), "Tarefa incluida com sucesso!", Toast.LENGTH_LONG).show();
        }
        NavHostFragment.findNavController(SecondFragment.this)
                .navigate(R.id.action_SecondFragment_to_FirstFragment);
    }

    private TaskDAO getTaskDAO() {
        return ((TodoApplication)this.getContext().getApplicationContext()).getDatabase().getTaskDAO();
    }

    /** Para modificar o AppBar por Fragmento **/
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_editar, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (R.id.action_salvar == id) {
            editTask(null);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
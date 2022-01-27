package com.example.kamiji.todolist.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kamiji.todolist.R;
import com.example.kamiji.todolist.model.Task;
import com.example.kamiji.todolist.view.holder.TaskViewHolder;

import java.util.ArrayList;
import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskViewHolder> {

    List<Task> lista;

    public TaskAdapter(List<Task> lista) {
        this.lista = lista;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_adapter, parent, false);
        TaskViewHolder taskViewHolder = new TaskViewHolder(view);

        return taskViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        Task task = lista.get(position);
        holder.getTarefa().setText(lista.get(position).getMessage());
    }

    @Override
    public int getItemCount() {
        return getTarefas().size();
    }

     private List<Task> getTarefas() {
        if (this.lista == null) {
            this.lista = new ArrayList<>();
        }
        return lista;
     }
}

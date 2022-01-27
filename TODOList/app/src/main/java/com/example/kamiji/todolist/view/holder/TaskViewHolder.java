package com.example.kamiji.todolist.view.holder;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kamiji.todolist.R;
import com.example.kamiji.todolist.view.FirstFragment;

public class TaskViewHolder extends RecyclerView.ViewHolder{

    private TextView tarefa;

    public TaskViewHolder(@NonNull View itemView) {
        super(itemView);
        tarefa = itemView.findViewById(R.id.taskTextView);
        tarefa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putString("taskId", "1");
//                NavHostFragment.findNavController(v.getContext().getApplicationContext())
//                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }

    public TextView getTarefa() {
        return tarefa;
    }

    public void setTarefa(TextView tarefa) {
        this.tarefa = tarefa;
    }
}

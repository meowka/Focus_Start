package com.example.focus_start.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.focus_start.Converter;
import com.example.focus_start.MainActivity;
import com.example.focus_start.POJO.APIResponse;
import com.example.focus_start.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


class ValuteViewHolder extends RecyclerView.ViewHolder {

    TextView shortName, name, value;

    public ValuteViewHolder(@NonNull View itemView) {
        super(itemView);
        shortName = itemView.findViewById(R.id.shortName);
        name = itemView.findViewById(R.id.name);
        value = itemView.findViewById(R.id.value);
    }
}

public class Adapter extends RecyclerView.Adapter {
    Context context;
    Collection<APIResponse.Valute> data;
    LayoutInflater inflater;

    public Adapter(Context context, Collection<APIResponse.Valute> data) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = inflater.inflate(R.layout.item_list, parent, false);
        final ValuteViewHolder valuteViewHolder = new ValuteViewHolder(view);
        return valuteViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        List<APIResponse.Valute> ValuteItem = new ArrayList<>();
        ValuteItem.addAll(data);

        final APIResponse.Valute valuteItem = (APIResponse.Valute) ValuteItem.get(position);
        ((ValuteViewHolder) holder).shortName.setText(valuteItem.charCode);
        ((ValuteViewHolder) holder).name.setText(valuteItem.name);
        ((ValuteViewHolder) holder).value.setText(String.valueOf(valuteItem.value).substring(0,5));
        ((ValuteViewHolder) holder).itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Converter.class);
                intent.putExtra("value", valuteItem.value);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}

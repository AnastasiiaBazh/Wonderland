package com.app.wonderland;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class OptionsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    final int OPTIONS_TYPE = 1;
    final int ADD_BUTTON_TYPE = 2;

    private List<Option> items; //List <Item>

    public OptionsAdapter(List<Option> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        switch (viewType) {
            case OPTIONS_TYPE: {
                View view = inflater.inflate(R.layout.options_view, parent, false);
                return new OptionsViewHolder(view);
            }
            case ADD_BUTTON_TYPE: {
                View view = inflater.inflate(R.layout.add_button_view, parent, false);
                return new AddButtonViewHolder(view);
            }
            default:
                throw new IllegalStateException("Unexpected value: " + viewType);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof OptionsViewHolder) {
            ((OptionsViewHolder) holder).text.setText(items.get(position).getOption());
        }
        if (holder instanceof AddButtonViewHolder) {
            ((AddButtonViewHolder) holder).addButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Option option = new Option("");
                    items.add(option);
                    notifyItemInserted(items.size()-1);
                }
            });
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == items.size()) {
            return ADD_BUTTON_TYPE;
        } else {
            return OPTIONS_TYPE;
        }
    }

    @Override
    public int getItemCount() {
        return items.size() + 1;
    }

    public static class OptionsViewHolder extends RecyclerView.ViewHolder {

        TextView text;

        public OptionsViewHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.textOption);
        }
    }

    public static class AddButtonViewHolder extends RecyclerView.ViewHolder {

        TextView addButton;

        public AddButtonViewHolder(@NonNull View itemView) {
            super(itemView);
            addButton = itemView.findViewById(R.id.addButton);
        }
    }
}




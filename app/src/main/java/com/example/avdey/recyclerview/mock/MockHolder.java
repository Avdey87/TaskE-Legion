package com.example.avdey.recyclerview.mock;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.example.avdey.recyclerview.ContactsAdapter;
import com.example.avdey.recyclerview.R;

public class MockHolder extends RecyclerView.ViewHolder {

    private TextView name;
    private TextView value;
    private String id;

    public MockHolder( View itemView) {
        super(itemView);

        name = itemView.findViewById(R.id.tv_name);
        value = itemView.findViewById(R.id.tv_value);


    }

    public void bind(Mock mock) {

        name.setText(mock.getName());
        value.setText(mock.getValue());
        id = mock.getValue();

    }

    public void setListener(final ContactsAdapter.OnItemClickListener listener) {
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(id);
            }
        });
    }
}

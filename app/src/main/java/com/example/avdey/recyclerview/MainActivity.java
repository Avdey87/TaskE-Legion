package com.example.avdey.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ContactsAdapter.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, RecyclerFragment.newInstance())
                    .commit();
        }
    }

    @Override
    public void onItemClick() {
        Toast.makeText(this, "Clicked",Toast.LENGTH_LONG).show();
    }
}

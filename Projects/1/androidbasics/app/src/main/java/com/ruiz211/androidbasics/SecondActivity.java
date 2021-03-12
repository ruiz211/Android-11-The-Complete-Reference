package com.ruiz211.androidbasics;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    private ListView listView;
    private EditText search_edit_frame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

        listView = findViewById(R.id.list);
        search_edit_frame = findViewById(R.id.search_edit_frame);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Toast.makeText(this, "Press", Toast.LENGTH_SHORT).show();
        });

        List<Person> personList = new ArrayList<>();
        personList.add(new Person("John", "Johnson", 37));
        personList.add(new Person("John", "Johnson", 37));
        personList.add(new Person("John", "Johnson", 37));
        personList.add(new Person("John", "Johnson", 37));
        personList.add(new Person("John", "Johnson", 37));
        personList.add(new Person("John", "Johnson", 37));
        personList.add(new Person("John", "Johnson", 37));
        personList.add(new Person("John", "Johnson", 37));
        personList.add(new Person("John", "Johnson", 37));
        personList.add(new Person("John", "Johnson", 37));
        personList.add(new Person("John", "Johnson", 37));
        personList.add(new Person("John", "Johnson", 37));
        personList.add(new Person("John", "Johnson", 37));
        personList.add(new Person("John", "Johnson", 37));
        personList.add(new Person("John", "Johnson", 37));
        personList.add(new Person("John", "Johnson", 37));
        personList.add(new Person("John", "Johnson", 37));
        personList.add(new Person("John", "Johnson", 37));

        PersonAdapter adapter = new PersonAdapter(this, R.layout.person_list_layout, personList);
        listView.setAdapter(adapter);

        search_edit_frame.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}

class Person {
    private String name, lastname;
    private int age;

    public Person(String name, String lastname, int age) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}


class PersonAdapter extends ArrayAdapter<Person> {
    private Context context;
    private int resource;
    private List<Person> personList;

    public PersonAdapter(@NonNull Context context, int resource, @NonNull List<Person> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.personList = objects;
    }

    @NonNull
    @Override
    public Context getContext() {
        return context;
    }

    public int getResource() {
        return resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        convertView = inflater.inflate(getResource(), parent, false);

        TextView text_name = convertView.findViewById(R.id.text_name);
        TextView text_lastname = convertView.findViewById(R.id.text_lastname);
        TextView text_age = convertView.findViewById(R.id.text_age);

        text_name.setText(getItem(position).getName());
        text_lastname.setText(getItem(position).getLastname());
        text_age.setText(String.valueOf(getItem(position).getAge()));

        return convertView;
    }
}
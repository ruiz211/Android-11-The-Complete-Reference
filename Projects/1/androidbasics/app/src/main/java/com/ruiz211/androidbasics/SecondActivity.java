package com.ruiz211.androidbasics;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    private ListView listView;

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
        String name = getItem(position).getName();
        String lastname = getItem(position).getLastname();
        int age = getItem(position).getAge();

        LayoutInflater inflater = LayoutInflater.from(getContext());
        convertView = inflater.inflate(getResource(), parent, false);

        TextView text_name = convertView.findViewById(R.id.text_name);
        TextView text_lastname = convertView.findViewById(R.id.text_lastname);
        TextView text_age = convertView.findViewById(R.id.text_age);

        text_name.setText(name);
        text_lastname.setText(lastname);
        text_age.setText(String.valueOf(age));

        return convertView;
    }
}
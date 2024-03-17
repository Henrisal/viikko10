package com.example.viikko9;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;


public class AddUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

    }

    public void addUser(View view) {
        EditText firstNameEditText = findViewById(R.id.editFirstName);
        EditText lastNameEditText = findViewById(R.id.editLastName);
        EditText emailEditText = findViewById(R.id.editEmail);

        String firstName = firstNameEditText.getText().toString();
        String lastName = lastNameEditText.getText().toString();
        String email = emailEditText.getText().toString();
        RadioGroup rgUserType = findViewById(R.id.radioDegreeProgram);

        int checkedId = rgUserType.getCheckedRadioButtonId();

        if (checkedId == R.id.seRadioButton) {
            User newUser = new User(firstName, lastName, email, "Software Engineering");
            UserStorage.getInstance().addUser(newUser);
        }

        if (checkedId == R.id.imRadioButton) {
            User newUser2 = new User(firstName, lastName, email, "Industrial Management");
            UserStorage.getInstance().addUser(newUser2);
        }
        if (checkedId == R.id.ceRadioButton) {
            User newUser3 = new User(firstName, lastName, email, "Computational Engineering");
            UserStorage.getInstance().addUser(newUser3);
        }

        if (checkedId == R.id.eeRadioButton) {
                User newUser4 = new User(firstName, lastName, email, "Electrical Engineering");
                UserStorage.getInstance().addUser(newUser4);
        }

    }
}
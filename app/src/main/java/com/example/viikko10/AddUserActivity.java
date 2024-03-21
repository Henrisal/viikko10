package com.example.viikko10;

import android.content.Context;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class AddUserActivity extends AppCompatActivity {

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        context = AddUserActivity.this;

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

        String degreeProgram = "";
        if (checkedId == R.id.seRadioButton) {
            degreeProgram = "Software Engineering";
        }

        else if (checkedId == R.id.imRadioButton) {
            degreeProgram = "Industrial Management";
        }
        else if (checkedId == R.id.ceRadioButton) {
            degreeProgram = "Computational Engineering";
        }

        else if (checkedId == R.id.eeRadioButton) {
                degreeProgram = "Electrical Engineering";
        }

        CheckBox phdCheckBox = findViewById(R.id.phdCheckBox);
        CheckBox lciCheckBox = findViewById(R.id.lciCheckBox);
        CheckBox msCheckBox = findViewById(R.id.msCheckBox);
        CheckBox bcCheckBox = findViewById(R.id.bcCheckBox);


        ArrayList<String> degrees = new ArrayList<>();
        if (phdCheckBox.isChecked()) {
            degrees.add("Doctoral Degree");
        }
        if (lciCheckBox.isChecked()) {
            degrees.add("Licenciate");
        }
        if (msCheckBox.isChecked()) {
            degrees.add("M.Sc. degree");
        }
        if (bcCheckBox.isChecked()) {
            degrees.add("B.Sc. degree");
        }

        User newUser = new User(firstName, lastName, email, degreeProgram, degrees);
        UserStorage.getInstance().addUser(newUser);
        UserStorage.getInstance().saveUsers(context);

    }
}
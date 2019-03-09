package com.adampolt.palindrome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get the button we defined in our Layout file (make sure the ID is the same!)
        Button check = findViewById(R.id.check);

        // Add an on-click action to the button
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get the EditText from the layout file
                EditText palindromeField = findViewById(R.id.palindromeField);

                // Get the word that the user entered
                String enteredWord = palindromeField.getText().toString();

                // Note: This wasn't covered in class, but just adding it in case you were
                // wondering how to handle uppercase letters and special characters here.
                // The two lines convert it to lowercase and remove all non-letter characters:
                String plainWord = enteredWord.toLowerCase();
                plainWord = plainWord.replaceAll("[^a-z]", "");

                // Reverse the string
                StringBuilder sb = new StringBuilder(plainWord);
                String reversed = sb.reverse().toString();

                // Get the TextView for showing our results
                TextView result = findViewById(R.id.result);

                // If the word is the same forward and backward, it is a palindrome
                // Set the text in the result textview to tell the user either way
                if(plainWord.equals(reversed)) {
                    result.setText(enteredWord + " is a palindrome");
                } else {
                    result.setText(enteredWord + " is NOT a palindrome");
                }
            }
        });
    }
}

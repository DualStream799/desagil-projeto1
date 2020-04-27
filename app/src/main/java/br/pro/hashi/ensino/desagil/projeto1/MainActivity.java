package br.pro.hashi.ensino.desagil.projeto1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textMessage = findViewById(R.id.text_message);
        Button buttonMessage = findViewById(R.id.button_message);

        buttonMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new DialogMessages(textMessage).show(getSupportFragmentManager(), "messagesDialog");

            }
        }) ;



    }
}

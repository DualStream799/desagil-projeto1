package br.pro.hashi.ensino.desagil.projeto1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    String content;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonMessage1 = findViewById(R.id.button_message);
        Button buttonMessage2 = findViewById(R.id.button_message2);
        Button buttonMessage3 = findViewById(R.id.button_message3);
        Button buttonMessage4 = findViewById(R.id.button_message4);
        TextView textMessage = findViewById(R.id.text_message);

        buttonMessage1.setOnClickListener((view -> {
            content = "Quero ir ao banheiro!";
            new DialogMessages(textMessage, content).show(getSupportFragmentManager(), "messagesDialog");
        }));

        buttonMessage2.setOnClickListener((view -> {
            content = "Estou com dor!";
            new DialogMessages(textMessage, content).show(getSupportFragmentManager(), "messagesDialog");
        }));

        buttonMessage3.setOnClickListener((view -> {
            content = "Estou com sede!";
            new DialogMessages(textMessage, content).show(getSupportFragmentManager(), "messagesDialog");
        }));

        buttonMessage4.setOnClickListener((view -> {
            content = "Estou com fome!";
            new DialogMessages(textMessage, content).show(getSupportFragmentManager(), "messagesDialog");
        }));



    }
}

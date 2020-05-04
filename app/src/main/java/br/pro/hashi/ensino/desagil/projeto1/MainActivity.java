package br.pro.hashi.ensino.desagil.projeto1;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
        Button buttonMessageSend = findViewById(R.id.export_message);
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

        buttonMessageSend.setOnClickListener((view -> {
            if (textMessage.getText().toString().equals("")) {
                Toast.makeText(this,"No text to export", Toast.LENGTH_SHORT).show();
            } else {
                exportMessage(textMessage.getText());
            }
        }));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.morse_dict) {
            //TODO: exibir dicionário Morse -> Romano
            return true;
        } else if (id == R.id.roman_dict) {
            //TODO: exibir dicionário Romano -> Morse
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void exportMessage(CharSequence message) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/*");
        intent.putExtra(Intent.EXTRA_TEXT, message);
        startActivity(intent);
    }
}

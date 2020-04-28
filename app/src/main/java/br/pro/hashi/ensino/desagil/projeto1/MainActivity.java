package br.pro.hashi.ensino.desagil.projeto1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textMessage = findViewById(R.id.text_message);
        Button buttonMessage = findViewById(R.id.button_message);

        textMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new DialogMessages(textMessage).show(getSupportFragmentManager(), "messagesDialog");

            }
        }) ;

        buttonMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = textMessage.getText().toString();
                if (message.length() > 16) {
                    showToast("Mensagem inválida!");
                    return;
                } else {
                    showToast("Mensagem enviada!");
                }
            }
        }) ;

    }

    // Método de conveniência para mostrar uma bolha de texto.
    private void showToast(String text) {

        // Constrói uma bolha de duração curta.
        Toast toast = Toast.makeText(this, text, Toast.LENGTH_SHORT);

        // Mostra essa bolha.
        toast.show();
    }
}

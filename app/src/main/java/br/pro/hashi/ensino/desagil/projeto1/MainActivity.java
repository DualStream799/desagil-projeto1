package br.pro.hashi.ensino.desagil.projeto1;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    String content;
    CharSequence message = "";
    static final int REQUEST_SELECT_PHONE_NUMBER = 1;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_SELECT_PHONE_NUMBER && resultCode == RESULT_OK) {
            // Get the URI and query the content provider for the phone number
            Uri contactUri = data.getData();
            String[] projection = new String[]{ContactsContract.CommonDataKinds.Phone.NUMBER};
            Cursor cursor = getContentResolver().query(contactUri, projection,
                    null, null, null);
            // If the cursor returned is valid, get the phone number
            if (cursor != null && cursor.moveToFirst()) {
                int numberIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                String number = cursor.getString(numberIndex);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", number, null));
                intent.putExtra("sms_body", message);
                startActivity(intent);
            }
        }
    }



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonMessage1 = findViewById(R.id.button_message);
        Button buttonMessage2 = findViewById(R.id.button_message2);
        Button buttonMessage3 = findViewById(R.id.button_message3);
        Button buttonMessage4 = findViewById(R.id.button_message4);
        ImageView buttonMessageSend = findViewById(R.id.export_message);
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
                selectContact();
                message = textMessage.getText();
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

    public void selectContact() {
        // Start an activity for the user to pick a phone number from contacts
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_SELECT_PHONE_NUMBER);
        }
    }
}

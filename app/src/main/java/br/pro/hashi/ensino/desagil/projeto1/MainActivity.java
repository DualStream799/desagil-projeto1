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
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    String content;
    CharSequence message = "";
    static final int REQUEST_SELECT_PHONE_NUMBER = 1;
    StringBuilder morseCode;
    StringBuilder translatedMessage;
    Translator translator;

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

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getString(R.string.app_name));

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton buttonMessage1 = findViewById(R.id.button_message);
        ImageButton buttonMessage2 = findViewById(R.id.button_message2);
        ImageButton buttonMessage3 = findViewById(R.id.button_message3);
        ImageButton buttonMessage4 = findViewById(R.id.button_message4);
        ImageButton buttonMessageSend = findViewById(R.id.button_send_message);
        ImageButton buttonToolbar1 = findViewById(R.id.button_toolbar_1);
        ImageButton buttonToolbar2 = findViewById(R.id.button_toolbar_2);
        ImageButton buttonToolbar3 = findViewById(R.id.button_toolbar_3);
        ImageButton buttonDot = findViewById(R.id.button_dot);
        ImageButton buttonDash = findViewById(R.id.button_dash);
        ImageButton buttonErase = findViewById(R.id.button_erase);
        ImageButton buttonAddChar = findViewById(R.id.button_add);

        com.chinodev.androidneomorphframelayout.NeomorphFrameLayout neoToolbar1 = findViewById(R.id.neo_toolbar_tab_1);
        com.chinodev.androidneomorphframelayout.NeomorphFrameLayout neoToolbar2 = findViewById(R.id.neo_toolbar_tab_2);
        com.chinodev.androidneomorphframelayout.NeomorphFrameLayout neoToolbar3 = findViewById(R.id.neo_toolbar_tab_3);

        TextView textMessage = findViewById(R.id.text_message);
        TextView textMorse = findViewById(R.id.text_morse);
        TextView textTranslated = findViewById(R.id.text_translated);

        morseCode = new StringBuilder();
        translatedMessage = new StringBuilder();
        translator = new Translator();

        neoToolbar1.switchShadowType();
        neoToolbar3.switchShadowType();
        // Actions for each one of the buttons:
        buttonMessage1.setOnClickListener((view -> {
            content = "Quero ir ao banheiro!";
            textMessage.setText(content);
        }));

        buttonMessage2.setOnClickListener((view -> {
            content = "Estou com dor!";
            textMessage.setText(content);
        }));

        buttonMessage3.setOnClickListener((view -> {
            content = "Estou com sede!";
            textMessage.setText(content);
        }));

        buttonMessage4.setOnClickListener((view -> {
            content = "Estou com fome!";
            textMessage.setText(content);
        }));

        buttonMessageSend.setOnClickListener((view -> {
            if (textMessage.getText().toString().equals("")) {
                Toast.makeText(this,"No text to export", Toast.LENGTH_SHORT).show();
            } else {
                selectContact();
                message = textMessage.getText();
            }
        }));
        // Add a dot:
        buttonDot.setOnClickListener((view -> {
            morseCode.append('.');
            textMorse.setText(morseCode);
            try {
                char translatedChar = translator.morseToChar(morseCode.toString());
                if (translatedChar != '|' && translatedChar != ' ') {
                    textTranslated.setText(Character.toString(translatedChar));
                } else {
                    Toast.makeText(this,"Invalid morse code", Toast.LENGTH_SHORT).show();
                }
            } catch (NullPointerException npe) {
                Toast.makeText(this,"Invalid morse code", Toast.LENGTH_SHORT).show();
            }

        }));
        // Add a dash:
        buttonDash.setOnClickListener((view -> {
            morseCode.append('-');
            textMorse.setText(morseCode);
            try {
                char translatedChar = translator.morseToChar(morseCode.toString());
                if (translatedChar != '|' && translatedChar != ' ') {
                    textTranslated.setText(Character.toString(translatedChar));
                } else {
                    Toast.makeText(this,"Invalid morse code", Toast.LENGTH_SHORT).show();
                }
            } catch (NullPointerException npe) {
                Toast.makeText(this,"Invalid morse code", Toast.LENGTH_SHORT).show();
            }
        }));
        // Remove the last signal:
        buttonErase.setOnClickListener((view -> {
            if (morseCode.length() != 0) {
                morseCode.setLength(morseCode.length() - 1);
                textMorse.setText(morseCode);
            }
            try {
                char translatedChar = translator.morseToChar(morseCode.toString());
                if (translatedChar != '|' && translatedChar != ' ') {
                    textTranslated.setText(Character.toString(translatedChar));
                } else {
                    Toast.makeText(this,"Invalid morse code", Toast.LENGTH_SHORT).show();
                }
            } catch (NullPointerException npe) {
                Toast.makeText(this,"Invalid morse code", Toast.LENGTH_SHORT).show();
            }
        }));
        /// Add the translated char to the message:
        buttonAddChar.setOnClickListener((view -> {
            translatedMessage.append(textTranslated.getText());
            textMessage.setText(translatedMessage);
            morseCode.setLength(0);
            textMorse.setText(morseCode);
            textTranslated.setText("");
        }));


        buttonToolbar1.setOnClickListener((view -> {
            neoToolbar1.setShadowInner();
            neoToolbar2.setShadowOuter();
            neoToolbar3.setShadowOuter();
            //TODO: implement real action (open dictionary menu)
        }));

        buttonToolbar2.setOnClickListener((view -> {
            neoToolbar1.setShadowOuter();
            neoToolbar2.setShadowInner();
            neoToolbar3.setShadowOuter();
            //TODO: implement real action (open texting menu)
        }));

        buttonToolbar3.setOnClickListener((view -> {
            neoToolbar1.setShadowOuter();
            neoToolbar2.setShadowOuter();
            neoToolbar3.setShadowInner();
            //TODO: implement real action (open settings menu)
        }));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return super.onCreateOptionsMenu(menu);
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

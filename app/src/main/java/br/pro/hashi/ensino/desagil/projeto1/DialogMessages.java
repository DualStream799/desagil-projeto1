package br.pro.hashi.ensino.desagil.projeto1;
import androidx.fragment.app.DialogFragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.TextView;



public class DialogMessages extends DialogFragment {

    private TextView textView;
    private String buttonMsg;
    public DialogMessages (TextView textView, String msg) {
        this.textView = textView;
        this.buttonMsg = msg;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Tem certeza de que deseja transmitir" + " " + textView.getText().toString() + "?")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setPositiveButton("SIM", (dialog, id) -> {
                    textView.setText(buttonMsg);
                })
                .setNegativeButton("NÃO", (dialog, id) -> {
                    // User cancelled the dialog
                    textView.setText(null);
                    textView.setHint("Mensagem");
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }
}

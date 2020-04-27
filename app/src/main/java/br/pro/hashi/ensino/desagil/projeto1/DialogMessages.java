package br.pro.hashi.ensino.desagil.projeto1;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogMessages extends DialogFragment {

    private TextView textView;
    public DialogMessages (TextView textView) {
        this.textView = textView;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        String[] messages = getActivity().getResources().getStringArray(R.array.messages_dialog);

        builder.setTitle("Mensagens");
        builder.setItems(messages, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //Toast.makeText(getActivity(), "Select message: "+messages[i], Toast.LENGTH_SHORT);
                textView.setText(messages[i]);
                dialogInterface.dismiss();
            }
        });
        return builder.create();
    }
}

package com.vantuz.nm.hop_freelancer.fragment;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

/**
 * Created by nm.arsahanov on 22.01.2018.
 */

public class ApplyDialog extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        String title = "some title";
        String msg = "some msg";
        String btnCancel = "cancel";
        String btnApply = "apply";

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(title);

        builder.setMessage(msg);
        builder.setPositiveButton(btnApply, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getActivity(), "Отправлено", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton(btnCancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getActivity(), "Отмена", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setCancelable(true);
        return builder.create();
    }
}

package jp.suntech.s21044.myconstraintlayout;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;



public class MailDialogFragment extends DialogFragment {
        @Override
        public android.app.Dialog onCreateDialog(Bundle savedInstanceState){

            AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());

            builder.setTitle(R.string.dialog_title);
            builder.setMessage(R.string.dialog_mes);
            builder.setPositiveButton(R.string.dialog_ok,new DialogButtonClickListener());
            builder.setNegativeButton(R.string.dialog_ng,new DialogButtonClickListener());

            AlertDialog dialog=builder.create();
            return dialog;
        }


    private class DialogButtonClickListener implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialog,int which){
            String dia="";

            switch (which){

                case DialogInterface.BUTTON_POSITIVE:
                    dia=getString(R.string.dialog_po);
                    break;

                case DialogInterface.BUTTON_NEGATIVE:
                    dia=getString(R.string.dialog_ne);
                    break;

                default:
                    break;
            }
            Toast.makeText(getActivity(),dia, Toast.LENGTH_LONG).show();
        }


    }
}

package jp.suntech.s21044.myconstraintlayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelStoreOwner;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btConfirm=findViewById(R.id.btConfirm);
        Button btClear=findViewById(R.id.btClear);
        Button btSend=findViewById(R.id.btSend);

        btConfirm.setOnClickListener(new ButtonClickListener());
        btSend.setOnClickListener(new ButtonClickListener());
        btClear.setOnClickListener(new ButtonClickListener());

    }


    private class ButtonClickListener implements View.OnClickListener{

        @Override
        public void onClick(View view){

            String show="";

            EditText name=findViewById(R.id.etName);
            EditText mailad=findViewById(R.id.etMail);
            EditText mailti=findViewById(R.id.etMailTitle);
            EditText comment=findViewById(R.id.etComment);
            String sname=name.getText().toString();
            String smailad=mailad.getText().toString();
            String smailti=mailti.getText().toString();
            String scomment=comment.getText().toString();

            int id=view.getId();
            switch(id){
                case R.id.btConfirm:
                   MailDialogFragment dialogFragment=new MailDialogFragment();
                   dialogFragment.show(getSupportFragmentManager(),"MailDialogFragment");
                    show ="名前："+sname+"　メールアドレス："+smailad+"　題名："+smailti+"\n質問内容：\n"+scomment;
                    break;

                case R.id.btSend:
                    show ="名前："+sname+"　メールアドレス："+smailad+"　題名："+smailti+"\n質問内容：\n"+scomment;
                    break;

                case R.id.btClear:
                    name.setText("");
                    mailad.setText("");
                    mailti.setText("");
                    comment.setText("");

                    show="入力内容をクリアしました";
                    break;
            }

            Toast.makeText(MainActivity.this, show, Toast.LENGTH_LONG).show();

        }
    }

}
package id.sch.smktelkom_mlg.www.fragmen;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button pesanToat, keluar, tampilList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pesanToat = (Button) findViewById(R.id.toastBtn);
        keluar
                = (Button) findViewById(R.id.exitBtn);
        tampilList =
                (Button) findViewById(R.id.listDialogBtn);
        pesanToat.setOnClickListener(this);
        keluar.setOnClickListener(this);
        tampilList.setOnClickListener(this);
    }

    @Override
    public void onClick(View clicked) {
        switch (clicked.getId()) {
            case R.id.listDialogBtn:
                munculListDialog();
                break;
            case R.id.toastBtn:
                Toast.makeText(this, "Kamu memilih toast",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.exitBtn:
                exit();
                break;
        }
    }

    private void exit() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Apakah Anda Benar ingin keluar?").setCancelable(false)
                .setPositiveButton("Ya", new
                        DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                MainActivity.this.finish();
                            }
                        })
                .setNegativeButton("Tidak", new
                        DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int arg1) {
                                dialog.cancel();
                            }
                        }).show();
    }

    private void munculListDialog() {
        final CharSequence[] items = {"Programming", "Teknisi",
                "Designer", "Animator", "Developer Web"
        };
        AlertDialog.Builder kk = new AlertDialog.Builder(this);
        kk.setTitle("Pilih Profesi");
        kk.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                Toast.makeText(getApplicationContext(), items[item],
                        Toast.LENGTH_SHORT).show();
            }
        }).show();
    }
    }



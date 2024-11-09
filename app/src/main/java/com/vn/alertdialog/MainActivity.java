package com.vn.alertdialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnShow;
    int selectedChoice = 0;
    String[] gioiTinh = new String[]{"Nam", "Nữ", "khác"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnShow = findViewById(R.id.btnShow);
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialogMultiChoice();
            }
        });
    }

    public void AlertDialogSimple() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setTitle("Thông báo");
        dialog.setIcon(R.drawable.ic_launcher_foreground);
        dialog.setMessage("Bạn có muốn xóa không");
        dialog.setCancelable(false);
        dialog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Có", Toast.LENGTH_SHORT).show();
            }
        });
        dialog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Không", Toast.LENGTH_SHORT).show();
            }
        });
        dialog.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Hủy", Toast.LENGTH_SHORT).show();
            }
        });
        dialog.show();
    }

    public void AlertDialogList() {
        String[] gioiTinh = new String[]{"Nam", "Nữ", "khác"};
        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setTitle("Thông báo");
        dialog.setIcon(R.drawable.ic_launcher_foreground);

        dialog.setCancelable(false);
        dialog.setItems(gioiTinh, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, gioiTinh[i], Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alertDialog = dialog.create();
        dialog.show();
    }

    public void AlertSigleChoice() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setTitle("Thông báo");
        dialog.setIcon(R.drawable.ic_launcher_foreground);
        dialog.setCancelable(false);
        dialog.setSingleChoiceItems(gioiTinh, selectedChoice, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                selectedChoice = i;
                Toast.makeText(MainActivity.this, gioiTinh[i], Toast.LENGTH_SHORT).show();
                dialogInterface.dismiss();
            }
        });
        dialog.show();
    }

    public void AlertDialogMultiChoice() {
        String[] gioiTinh = new String[]{"Xanh", "Đỏ", "Tím", "Đen"};
        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        dialog.setTitle("Thông báo");
        dialog.setIcon(R.drawable.ic_launcher_foreground);
        dialog.setMultiChoiceItems(gioiTinh, new boolean[]{true, false, true, false}, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                    }
                });
                dialog.show();
    }
}

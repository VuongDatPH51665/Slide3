package com.vn.alertdialog;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity1 extends AppCompatActivity {
    EditText username;
    EditText password;
    Button btnlogin;
    Button btnout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnlogin=findViewById(R.id.btnlogin);
        btnout=findViewById(R.id.btnregister);
        username=findViewById(R.id.edtuser);
        password=findViewById(R.id.edtpass);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String user=username.getText().toString();
            String pass=password.getText().toString();
            if(user.equals("admin")&&pass.equals("123")){
                Toast.makeText(MainActivity1.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(MainActivity1.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
            }
            }
        });
        btnout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
    });
}
}
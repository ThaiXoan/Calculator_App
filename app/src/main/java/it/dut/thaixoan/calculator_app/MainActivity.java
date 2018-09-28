package it.dut.thaixoan.calculator_app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    float f_thamSoThuNhat;
    float f_thamSoThuHai;
    String s_toanTu;
    String s_xuatManHinh = "";
    EditText editText_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();

    }

    private void addControls() {

        editText_result = findViewById(R.id.editText_result);
        int[] idButon = {R.id.button_delete, R.id.button_dau, R.id.button_percent, R.id.button_division, R.id.button_multiplication,
                R.id.button_subtraction, R.id.button_addition, R.id.button_equal, R.id.button_number_0, R.id.button_number_1,
                R.id.button_number_2, R.id.button_number_3, R.id.button_number_4, R.id.button_number_5, R.id.button_number_6,
                R.id.button_number_7, R.id.button_number_8, R.id.button_number_9};

        for (int id : idButon) {
            View view = (View) findViewById(id);
            view.setOnClickListener(this);
        }

    }

    private void toanTu() {
        f_thamSoThuNhat = Float.parseFloat(editText_result.getText().toString());
        //s_xuatManHinh = "0";
        s_xuatManHinh += s_toanTu;
        editText_result.setText(s_xuatManHinh);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_addition:
                s_toanTu = "+";
                toanTu();
                break;
            case R.id.button_subtraction:
                s_toanTu = "-";
                toanTu();
                break;
            case R.id.button_multiplication:
                s_toanTu = "*";
                toanTu();
                break;
            case R.id.button_division:
                s_toanTu = "/";
                toanTu();
                break;
            case R.id.button_equal:
                float ketQua = 0.0f;
                int viTriToanTu = editText_result.getText().toString().indexOf(s_toanTu) + 1;
                f_thamSoThuHai = Float.parseFloat((editText_result.getText().toString()).substring(viTriToanTu));
                if (s_toanTu == "+") {
                    ketQua = f_thamSoThuNhat + f_thamSoThuHai;
                }
                if (s_toanTu == "-") {
                    ketQua = f_thamSoThuNhat - f_thamSoThuHai;
                }

                if (s_toanTu == "*") {
                    ketQua = f_thamSoThuNhat * f_thamSoThuHai;
                }
                if (s_toanTu == "/") {
                    ketQua = f_thamSoThuNhat / f_thamSoThuHai;

                }
                s_xuatManHinh = "";
                s_xuatManHinh += ketQua;
                editText_result.setText(s_xuatManHinh);
                f_thamSoThuNhat = 0.0f;
                f_thamSoThuHai = 0.0f;
                s_xuatManHinh = "0";
                break;
            case R.id.button_delete:
                f_thamSoThuNhat = 0.0f;
                f_thamSoThuHai = 0.0f;
                s_xuatManHinh = "0";
                editText_result.setText(s_xuatManHinh);
                break;
            default:
                if (s_xuatManHinh.equals("0")) {
                    s_xuatManHinh = "";
                }
                s_xuatManHinh += ((Button) view).getText().toString();
                editText_result.setText(s_xuatManHinh);
        }
    }
}

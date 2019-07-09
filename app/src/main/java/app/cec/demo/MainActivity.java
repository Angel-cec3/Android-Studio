package app.cec.demo;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText etFirst;
    EditText etSecond;
    Button btnAdd;
    Button btnSubtract;
    Button btnMultiply;
    Button btnDivide;
    Button btnClear;
    TextView tvResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etFirst = findViewById(R.id.et_first);
        etSecond = findViewById(R.id.et_second);
        btnAdd = findViewById(R.id.btn_add);
        btnSubtract = findViewById(R.id.btn_subtract);
        btnMultiply = findViewById(R.id.btn_multiply);
        btnDivide = findViewById(R.id.btn_divide);
        btnClear = findViewById(R.id.btn_clear);
        tvResult = findViewById(R.id.tv_result);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                     /*new AddTask().execute();

                 int a=Integer.parseInt(etFirst.getText().toString());
                 int b=Integer.parseInt(etSecond.getText().toString());
                 int c=add(a,b);
                 tvResult.setText(String.valueOf(c));

*/
                    new AddTask().execute();//creating object
                } catch (Exception e) {
                    showErrorToast();
                }

            }
        });

        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {


                    int a = Integer.parseInt(etFirst.getText().toString());
                    int b = Integer.parseInt(etSecond.getText().toString());
                    int c = a - b;
                    tvResult.setText(String.valueOf(c));

                } catch (Exception e) {
                    showErrorToast();
                }

            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int a = Integer.parseInt(etFirst.getText().toString());
                    int b = Integer.parseInt(etSecond.getText().toString());
                    int c = a * b;
                    tvResult.setText(String.valueOf(c));

                } catch (Exception e) {
                    showErrorToast();
                }
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int a = Integer.parseInt(etFirst.getText().toString());
                    int b = Integer.parseInt(etSecond.getText().toString());
                    int c = a / b;
                    tvResult.setText(String.valueOf(c));

                } catch (Exception e) {
                    showErrorToast();
                }
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvResult.setText("");
                etFirst.setText("");
                etSecond.setText("");


            }
        });

    }

    public void showErrorToast() {
        Toast.makeText(this, "Enter a number ", Toast.LENGTH_SHORT).show();
    }

    public int add(int a, int b) {
        return a + b;
    }

    class AddTask extends AsyncTask {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            tvResult.setText("PLEASE WAIT");
        }

        @Override
        protected Object doInBackground(Object[] objects) {
            try {
                Thread.sleep(3000);
            } catch (Exception e) {

            }
            String epoch = String.valueOf(System.currentTimeMillis());
            return epoch;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            tvResult.setText((String) o);
        }
    }
}


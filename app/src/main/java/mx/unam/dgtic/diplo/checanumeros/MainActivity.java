package mx.unam.dgtic.diplo.checanumeros;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView tvTitulo;
    EditText etNumero;
    Button btnPrimo, btnPar, btnPerfecto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTitulo = findViewById(R.id.tvTitulo);
        etNumero = findViewById(R.id.etNumero);
        btnPrimo = findViewById(R.id.btnPrimo);
        btnPar = findViewById(R.id.btnPar);
        btnPerfecto = findViewById(R.id.btnPerfecto);

        btnPrimo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, "Botón primo",Toast.LENGTH_LONG).show();
                if(validaEditText()){
                    int numero = Integer.valueOf(etNumero.getText().toString());
                    if(esPrimo(numero)){
                        Toast.makeText(MainActivity.this, getResources().getString(R.string.respuesta) + numero + getResources().getString(R.string.si) + getResources().getString(R.string.primo), Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(MainActivity.this, getResources().getString(R.string.respuesta) + numero + getResources().getString(R.string.no) + getResources().getString(R.string.primo), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btnPar.setOnClickListener(this);
        btnPerfecto.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(validaEditText()) {
            int numero = Integer.valueOf(etNumero.getText().toString());

            switch(v.getId()){
                case R.id.btnPar:

                    if(esPar(numero)){
                        Toast.makeText(MainActivity.this, getResources().getString(R.string.respuesta) + numero + getResources().getString(R.string.si) + getResources().getString(R.string.par), Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(MainActivity.this, getResources().getString(R.string.respuesta) + numero + getResources().getString(R.string.no) + getResources().getString(R.string.par), Toast.LENGTH_SHORT).show();
                    }

                    break;
                case R.id.btnPerfecto:

                    if(esPerfecto(numero)){
                        Toast.makeText(MainActivity.this, getResources().getString(R.string.respuesta) + numero + getResources().getString(R.string.si) + getResources().getString(R.string.perfecto), Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(MainActivity.this, getResources().getString(R.string.respuesta) + numero + getResources().getString(R.string.no) + getResources().getString(R.string.perfecto), Toast.LENGTH_SHORT).show();
                    }

                    break;
                default:
                    break;
            }
        }

    }

    private boolean validaEditText(){
        if(etNumero.getText().length()==0){
            Toast.makeText(MainActivity.this, getResources().getText(R.string.error),Toast.LENGTH_LONG).show();
            etNumero.setError(getResources().getText(R.string.requerido));
            return false;
        }
        return true;
    }

    public static boolean esPrimo(int numero){
        if(numero <= 1) return false;
        int contador = 2;
        boolean primo=true;
        while ((primo) && (contador!=numero)){
            if (numero % contador == 0)
                primo = false;
            contador++;
        }
        return primo;
    }

    private boolean esPar(int numero){
        if(numero % 2 == 0){
            return true;
        } else{
            return false;
        }
    }

    private boolean esPerfecto(int numero){
        int i, suma = 1;
        for (i = 2; i <= numero/2; i++) {  // i son los divisores. Se divide desde 1 hasta n-1
            if (numero % i == 0) {
                suma = suma + i;     // si es divisor se suma
            }
        }
        if(suma == numero){
            return true;
        } else{
            return false;
        }
    }

    public void btnExtraClic(View v){
        Toast.makeText(MainActivity.this, "Se presionó el botón extra!",Toast.LENGTH_LONG).show();
    }

}

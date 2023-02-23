package com.ugb.parcial;

import androidx.appcompat.app.AppCompatActivity;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Gustavo Enrique Cerna Argueta USSS108722
//Fernando Jose Lopez Torres USTS002422
//Nilderson Alexis Chavez Barahona USSS012222
//kathia vanessa serrano portillo USSS167322
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TabHost tbh;
Button btn;
TextView temp;
Spinner spn;
conversor miconversor = new conversor();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tbh = findViewById(R.id.tbhConversores);
        tbh.setup();

        tbh.addTab(tbh.newTabSpec("tarifa por metro").setContent(R.id.tbhtarifapormetro).setIndicator("tarifa"));
        tbh.addTab(tbh.newTabSpec("area").setContent(R.id.tbharea).setIndicator("area"));

        btn = findViewById(R.id.btnConvertir);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp = (TextView) findViewById(R.id.txtcantidad);
                double cantidad = Double.parseDouble(temp.getText().toString());

                spn = findViewById(R.id.spnde);
                int de = spn.getSelectedItemPosition();

                spn = findViewById(R.id.spna);
                int a = spn.getSelectedItemPosition();

                temp = findViewById(R.id.lblrespuesta);
                temp.setText("Respuesta: " + miconversor.convertir(0, de, a, cantidad));
            }
        });
    }
}
class conversor{
    double[][] valores = {


            {1, 1.19599005, 0.0001, 10.7639104, 0.00014196479273, 0.0015903307888, 0.698896 },//Area
    };
    public double convertir (int opcion, int de, int a, double cantidad){
        return valores [opcion][a] / valores [opcion][de]* cantidad;
    }
}

package lecttarjetas.com.dialogs;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import lecttarjetas.com.dialogs.Class.CustomAlert;

public class MainActivity extends AppCompatActivity {

    //Borrar esta variable de prueba********
    ProgressBar barra1;
    public static CountDownTimer contador;
    int progreso;

    private Button success,warning,error, progress, custom, normal,InfoGeneral, barras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        success =(Button)findViewById(R.id.succes);
        warning =(Button)findViewById(R.id.warning);
        error =(Button)findViewById(R.id.error);
        progress = (Button)findViewById(R.id.progress);
        custom = (Button)findViewById(R.id.custom);
        InfoGeneral = (Button)findViewById(R.id.InfoGeneral);
        normal = (Button)findViewById(R.id.Normal);
        barras = (Button)findViewById(R.id.ProgressBar);





        success.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomAlert alert = new CustomAlert(v.getContext());
                alert.setTypeSuccess("Hecho", "La operacion se realizo correctamente","Aceptar");
                alert.show();
            }
        });
        warning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomAlert alert = new CustomAlert(v.getContext());
                alert.setTypeWarning("Atención", "La operacion se realizo con errores","Aceptar");
                alert.show();

            }
        });
        error.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomAlert alert = new CustomAlert(v.getContext());
                alert.setTypeError("Error", "La operacion no se realizo correctamente","Aceptar", "Intentar");
                alert.getButtonLeft(CustomAlert._INFO).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println("Hola que hace =============================");
                    }
                });
                alert.show();

            }
        });
        progress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomAlert alert = new CustomAlert(v.getContext());
                alert.setTypeProgress("", "Realizando operación espera...","Aceptar");
                alert.show();

            }
        });
        custom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomAlert alert = new CustomAlert(v.getContext());
                alert.setTypeCustom(getResources().getDrawable(R.drawable.ic_close_white_24dp),"Perzonalizado", "Texto perzonalizado","Aceptar", "Cancelar");
                alert.show();

            }
        });
        InfoGeneral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomAlert alert = new CustomAlert(v.getContext(),CustomAlert._WHIT_VIEW);
                alert.setTypeThreeButtons("Aceptar" ,"Cancelar" , "Huir");

                LinearLayout contenedor = (LinearLayout) alert.getView().findViewById(R.id.Content);
                LayoutInflater inflater = LayoutInflater.from(v.getContext());
                View view = inflater.inflate(R.layout.layout_info, contenedor, true);
                alert.show();

            }
        });
        normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomAlert alert = new CustomAlert(v.getContext(),CustomAlert._WHIT_VIEW);
                alert.setTypeTwoButtons("Aceptar", "Cancelar");
                LinearLayout contenedor = (LinearLayout) alert.getView().findViewById(R.id.Content);
                LayoutInflater inflater = LayoutInflater.from(v.getContext());
                View view = inflater.inflate(R.layout.layout_info, contenedor, true);


                alert.show();

            }
        });

        barras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertaBarras();

            }
        });

    }

    void alertaBarras(){

        //TODO: Hilo de ejemplo para poder ver el progreso de la barra
        contador = new CountDownTimer(5000, 10) {
            @Override
            public void onTick(long l) {
                progreso++;
                barra1.setProgress(progreso*100/(5000/10));
            }

            @Override
            public void onFinish() {
                barra1.setProgress(100);
            }
        };
        CustomAlert alert = new CustomAlert(this,CustomAlert._WHIT_VIEW);
        alert.setTypeTwoButtons("Aceptar", "Cancelar");
        LinearLayout contenedor = (LinearLayout) alert.getView().findViewById(R.id.Content);
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.alert_info_progress_data, contenedor, true);
        barra1 =(ProgressBar)view.findViewById(R.id.progressBarDatos);
        alert.show();
        contador.start();
    }
}

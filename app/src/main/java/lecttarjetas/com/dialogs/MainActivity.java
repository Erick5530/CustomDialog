package lecttarjetas.com.dialogs;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.yarolegovich.lovelydialog.LovelyInfoDialog;
import com.yarolegovich.lovelydialog.LovelyProgressDialog;

import org.xmlpull.v1.XmlPullParser;

import lecttarjetas.com.dialogs.Class.CustomAlert;
import lecttarjetas.com.dialogs.Class.ImageConverter;

public class MainActivity extends AppCompatActivity {
    private Button success,warning,error, progress, custom, normal,InfoGeneral;

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
                View view = inflater.inflate(R.layout.info, contenedor, true);
                (view.findViewById(R.id.boton_1)).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println("====================================================");
                    }
                });
                alert.getButtonLeft(CustomAlert._INFO_VIEW).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println("Hola que hace Info_General =============================");
                    }
                });
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
                View view = inflater.inflate(R.layout.info, contenedor, true);
                (view.findViewById(R.id.boton_1)).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println("====================================================");
                    }
                });

                alert.show();

            }
        });








    }
}

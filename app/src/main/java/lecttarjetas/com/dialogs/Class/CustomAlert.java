package lecttarjetas.com.dialogs.Class;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;
import lecttarjetas.com.dialogs.R;

public class CustomAlert {

    private Context contexto;
    private View view;
    private LayoutInflater inflater;
    private Dialog alertDialog;
    private String typeView;


    private LinearLayout content;
    private String WHIT_VIEW;




    public static  final String _WHIT_VIEW ="WHIT_VIEW";
    public static  final String _INFO_VIEW ="_INFO_VIEW";
    public static  final String _INFO ="_INFO";

    /*----------------------------------------------setTypeXXXX---------------------------------------------------------*/
    public  CustomAlert(Context contexto){
        this.contexto = contexto;
        inflater = (LayoutInflater) this.contexto.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        View viewInflada;
        viewInflada = inflater.inflate(R.layout.alert_info, null);
        this.view = viewInflada;
    }
    /*----------------------------------------------setTypeThreeButtons---------------------------------------------------------*/
    public  CustomAlert( Context contexto,String WHIT_VIEW ){
        this.contexto = contexto;
        this.WHIT_VIEW = WHIT_VIEW;
        inflater = (LayoutInflater) this.contexto.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        View viewInflada;
        viewInflada = inflater.inflate(R.layout.alert_info_view, null);
        this.view = viewInflada;
        this.content = (LinearLayout) view.findViewById(R.id.Content);
        (view.findViewById(R.id.close)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();

            }
        });

    }

    public void setTypeWarning(String title, String text, String textOneButton){
        view.findViewById(R.id.buttonLeft).setVisibility(View.GONE);
        view.findViewById(R.id.buttonRight).setVisibility(View.GONE);
        ((TextView)view.findViewById(R.id.titulo)).setText(title);
        ((TextView)view.findViewById(R.id.text)).setText(text);
        ((Button)view.findViewById(R.id.buttOne)).setText(textOneButton);
        view.findViewById(R.id.circleView).setBackgroundDrawable(contexto.getResources().getDrawable(R.drawable.circle_warning));
        ((CircleImageView) view.findViewById(R.id.circleView)).setImageDrawable(contexto.getResources().getDrawable(R.drawable.ic_priority_high_white_24dp));
    }
    public void setTypeError(String title, String text, String textButtonLeft, String textButtonRight ){
        view.findViewById(R.id.buttonLeft).setVisibility(View.VISIBLE);
        view.findViewById(R.id.buttonRight).setVisibility(View.VISIBLE);
        view.findViewById(R.id.buttOne).setVisibility(View.GONE);
        ((TextView)view.findViewById(R.id.titulo)).setText(title);
        ((TextView)view.findViewById(R.id.text)).setText(text);
        ((Button)view.findViewById(R.id.buttonLeft)).setText(textButtonLeft);
        ((Button)view.findViewById(R.id.buttonRight)).setText(textButtonRight);
        view.findViewById(R.id.circleView).setBackgroundDrawable(contexto.getResources().getDrawable(R.drawable.circle_error));
        ((CircleImageView) view.findViewById(R.id.circleView)).setImageDrawable(contexto.getResources().getDrawable(R.drawable.ic_close_white_24dp));
    }
    public void setTypeSuccess(String title, String text , String textOneButton) {
        view.findViewById(R.id.buttonLeft).setVisibility(View.GONE);
        view.findViewById(R.id.buttonRight).setVisibility(View.GONE);
        ((TextView)view.findViewById(R.id.titulo)).setText(title);
        ((TextView)view.findViewById(R.id.text)).setText(text);
        ((Button) view.findViewById(R.id.buttOne)).setText(textOneButton);
        view.findViewById(R.id.circleView).setBackgroundDrawable(contexto.getResources().getDrawable(R.drawable.circle_success));
        ((CircleImageView) view.findViewById(R.id.circleView)).setImageDrawable(contexto.getResources().getDrawable(R.drawable.ic_done_white_24dp));
    }
    public void setTypeCustom(Drawable icon, String title, String text, String textButtonLeft, String textButtonRight ){
        view.findViewById(R.id.buttonLeft).setVisibility(View.VISIBLE);
        view.findViewById(R.id.buttonRight).setVisibility(View.VISIBLE);
        view.findViewById(R.id.buttOne).setVisibility(View.GONE);
        ((TextView)view.findViewById(R.id.titulo)).setText(title);
        ((TextView)view.findViewById(R.id.text)).setText(text);
        ((Button)view.findViewById(R.id.buttonLeft)).setText(textButtonLeft);
        ((Button)view.findViewById(R.id.buttonRight)).setText(textButtonRight);
        view.findViewById(R.id.circleView).setBackgroundDrawable(contexto.getResources().getDrawable(R.drawable.circle));
        ((CircleImageView) view.findViewById(R.id.circleView)).setImageDrawable(icon);
    }
    public void setTypeProgress(String title, String text, String textOneButton){
        view.findViewById(R.id.buttonLeft).setVisibility(View.GONE);
        view.findViewById(R.id.buttonRight).setVisibility(View.GONE);
        view.findViewById(R.id.progressBar).setVisibility(View.VISIBLE);
        ((TextView)view.findViewById(R.id.titulo)).setText(title);
        ((TextView)view.findViewById(R.id.text)).setText(text);
        ((Button) view.findViewById(R.id.buttOne)).setText(textOneButton);
        view.findViewById(R.id.circleView).setBackgroundDrawable(contexto.getResources().getDrawable(R.drawable.circle));

    }
    public void setTypeTwoButtons(String textButtonLeftUpView, String textButtonRightUpView){
        view.findViewById(R.id.ButtonLeftUpView).setVisibility(View.VISIBLE);
        view.findViewById(R.id.ButtonRightUpView).setVisibility(View.VISIBLE);
        view.findViewById(R.id.OneButton).setVisibility(View.GONE);
        ((Button) view.findViewById(R.id.ButtonLeftUpView)).setText(textButtonLeftUpView);
        ((Button) view.findViewById(R.id.ButtonRightUpView)).setText(textButtonRightUpView);

        view.findViewById(R.id.circleView).setBackgroundDrawable(contexto.getResources().getDrawable(R.drawable.circle));
        ((CircleImageView) view.findViewById(R.id.circleView)).setImageDrawable(contexto.getResources().getDrawable(R.drawable.ic_person_white_36dp));

    }
    public void setTypeThreeButtons(String textButtonLeftUpView, String textButtonRightUpView, String textButtonLeftDownView){
        view.findViewById(R.id.ButtonLeftUpView).setVisibility(View.VISIBLE);
        view.findViewById(R.id.ButtonRightUpView).setVisibility(View.VISIBLE);
        view.findViewById(R.id.OneButton).setVisibility(View.VISIBLE);
        ((Button) view.findViewById(R.id.ButtonLeftUpView)).setText(textButtonLeftUpView);
        ((Button) view.findViewById(R.id.ButtonRightUpView)).setText(textButtonRightUpView);
        ((Button) view.findViewById(R.id.OneButton)).setText(textButtonLeftDownView);

        view.findViewById(R.id.circleView).setBackgroundDrawable(contexto.getResources().getDrawable(R.drawable.circle));
        ((CircleImageView) view.findViewById(R.id.circleView)).setImageDrawable(contexto.getResources().getDrawable(R.drawable.ic_person_white_36dp));

    }
    public void show(){
        Animation togheter = AnimationUtils.loadAnimation(contexto, R.anim.togheter);
        togheter.reset();
        ( view.findViewById(R.id.circleView)).startAnimation(togheter);

        alertDialog = new Dialog(contexto);
        alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        alertDialog.setContentView(view);
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.getWindow().getAttributes().windowAnimations = R.style.DialogTheme;
        alertDialog.show();
    }

    public View getView() {
        return view;
    }
    public Button getButtonLeft(String typeView){
        Button boton = null;
        switch(typeView){
            case "_INFO":
                boton = (Button) view.findViewById(R.id.buttonLeft);
                break;
            case "_INFO_VIEW":
                boton = (Button) view.findViewById(R.id.ButtonLeftUpView);
                break;

        }
        return boton;
    }
    public Button getButtonRight(String typeView){
        Button boton = null;
        switch(typeView){
            case "_INFO":
                boton = (Button) view.findViewById(R.id.buttonRight);
                break;
            case "_INFO_VIEW":
                boton = (Button) view.findViewById(R.id.ButtonRightUpView);
                break;

        }
        return boton;
    }
    public Button getOneButton(String typeView){
        Button boton = null;
        switch(typeView){
            case "_INFO":
                boton = (Button) view.findViewById(R.id.buttOne);
                break;
            case "_INFO_VIEW":
                boton = (Button) view.findViewById(R.id.OneButton);
                break;

        }
        return boton;
    }

    public void close(){
        alertDialog.dismiss();
    }

}

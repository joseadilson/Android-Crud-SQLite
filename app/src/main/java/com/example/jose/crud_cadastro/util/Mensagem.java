package com.example.jose.crud_cadastro.util;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

/**
 * Created by Jose on 14/12/2016.
 */

public class Mensagem {

    public static void addMsgOK(Activity activity, String titulo, String msg){
        AlertDialog.Builder alert = new AlertDialog.Builder(activity);
        alert.setTitle(titulo);
        alert.setMessage(msg);
        alert.setNegativeButton("OK", null);
        alert.show();
    }

    public static void MsgConfirm(Activity activity, String titulo, String msg, DialogInterface.OnClickListener listener){
        AlertDialog.Builder alert = new AlertDialog.Builder(activity);
        alert.setTitle(titulo);
        alert.setMessage(msg);
        alert.setPositiveButton("Sim", listener);
        alert.setNegativeButton("Não", null);
        alert.show();
    }

    public static AlertDialog alertDialog (Activity activity){
        final CharSequence[] itens = {
                "Editar",
                "Excluir"
        };
        AlertDialog.Builder alert = new AlertDialog.Builder(activity);
        alert.setTitle("Opções");
        alert.setItems(itens, (DialogInterface.OnClickListener) activity);

        return  alert.create();
    }

    public static AlertDialog criarDialogConfirmacao(Activity activity){
        AlertDialog.Builder alert = new AlertDialog.Builder(activity);
        alert.setMessage("Deseja realmente excluir ?");
        alert.setPositiveButton("Sim", (DialogInterface.OnClickListener) activity);
        alert.setNegativeButton("Não", (DialogInterface.OnClickListener) activity);

        return alert.create();
    }

}

package pt.ipleiria.estg.dei.amsi.myscores.singletonClasses;

import android.content.Context;

import pt.ipleiria.estg.dei.amsi.myscores.baseDados.LocalBaseDados;

public class SingletonBD {
    private static SingletonBD instance = null;
    private static LocalBaseDados localBaseDados = null;

    public static synchronized SingletonBD getInstance(Context context){
        if (instance == null){
            instance = new SingletonBD(context);
        }
        return instance;
    }

    public SingletonBD(Context context) {
    }

    public static void iniciarBD(Context context){
        if (localBaseDados == null){
            localBaseDados = new LocalBaseDados(context);
        }
    }

}

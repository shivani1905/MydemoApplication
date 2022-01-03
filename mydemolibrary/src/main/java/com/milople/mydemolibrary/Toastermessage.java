package com.milople.mydemolibrary;

import android.content.Context;
import android.widget.Toast;

public class Toastermessage {
    public static void toasty(Context ctx, String str)
    {
        Toast.makeText(ctx, str, Toast.LENGTH_SHORT).show();
    }
}

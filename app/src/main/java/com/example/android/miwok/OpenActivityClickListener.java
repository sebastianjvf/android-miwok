package com.example.android.miwok;

import android.content.Context;
import android.content.Intent;
import android.view.View;

public class OpenActivityClickListener implements View.OnClickListener {

    Class openActivity;
    Context context;

    /**
     * Creates an object definining the context and the activity, which is to be opened by the onClick method.
     * @param context      The context of the activity
     * @param openActivity The activity to which an explicit intent should be sent
     */
    public OpenActivityClickListener(Context context, Class openActivity) {
        this.context = context;
        this.openActivity = openActivity;
    }

    /**
     * Starts a new activity by sending an explicit intent to the supplied activity (in the given context)
     */
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(context, openActivity);
        context.startActivity(intent);
    }

}

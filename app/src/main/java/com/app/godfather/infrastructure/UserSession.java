package com.app.godfather.infrastructure;

import android.content.Context;

import com.github.brunodles.simplepreferences.lib.ActivePreferences;
import com.github.brunodles.simplepreferences.lib.Property;

/**
 * Created by erivan on 22/10/16.
 */
public class UserSession extends ActivePreferences {
    @Property private String sessionEmail;

    public UserSession(Context context) {
        super(context);
        reload();
    }

    public String getSessionEmail() {
        reload();
        return sessionEmail;
    }

    public void newSession(String email) {
        sessionEmail = email;
        apply();
    }
}

package com.app.godfather.add_godfather_email;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.app.godfather.R;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by root on 21/10/16.
 */
public class AddGodFatherEmailFragment extends Fragment implements AddGodFatherEmailContract.View {


    @BindView(R.id.btn_add_godfather_email)
    TextView mBtnOkForGodfatherEmail;


    @NotEmpty(sequence = 1, messageResId = R.string.saripaar_empty_message)
    @Email(sequence    = 2, messageResId = R.string.saripaar_email_message)
    @BindView(R.id.godfather_email_edit_text)
    EditText mFillGodfatherEmail;

    private Dialog welcomeDialog;

    public static AddGodFatherEmailFragment newInstance(){
        AddGodFatherEmailFragment fragment = new AddGodFatherEmailFragment();

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_godfather_email_frag, container, false);
        ButterKnife.bind(this, view);

        welcomeDialog = new Dialog(getContext(), R.style.DialogTheme);
        welcomeDialog.setContentView(R.layout.wellcome_dialog);

        return view;
    }

    @Override
    public void openCongratsDialog() {
        welcomeDialog.show();
    }
}

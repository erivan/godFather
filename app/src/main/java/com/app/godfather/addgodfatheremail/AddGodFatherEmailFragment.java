package com.app.godfather.addgodfatheremail;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.app.godfather.R;
import com.app.godfather.experiences.ExperiencesActivity;
import com.app.godfather.utils.ValidationErrorWrapper;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by root on 21/10/16.
 */
public class AddGodFatherEmailFragment extends Fragment implements AddGodFatherEmailContract.View,  Validator.ValidationListener {


    @BindView(R.id.btn_add_godfather_email)
    TextView mBtnOkForGodfatherEmail;

    @BindView(R.id.layout_email)
    TextInputLayout mTextInputLayout;


    @NotEmpty(sequence = 1, messageResId = R.string.saripaar_empty_message)
    @Email(sequence    = 2, messageResId = R.string.saripaar_email_message)
    @BindView(R.id.godfather_email_edit_text)
    EditText mFillGodfatherEmail;

    private Dialog welcomeDialog;
    private Validator mValidator;

    public static AddGodFatherEmailFragment newInstance(){
        AddGodFatherEmailFragment fragment = new AddGodFatherEmailFragment();

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_godfather_email_frag, container, false);
        ButterKnife.bind(this, view);

        mValidator = new Validator(this);
        mValidator.setValidationListener(this);

        mTextInputLayout.setHintAnimationEnabled(false);

        welcomeDialog = new Dialog(getContext(), R.style.DialogTheme);
        welcomeDialog.setContentView(R.layout.wellcome_dialog);
        TextView btnDialogGo = (TextView) welcomeDialog.findViewById(R.id.btn_dialog_go);
        btnDialogGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), ExperiencesActivity.class);

                startActivity(i);
            }
        });

        return view;
    }

    @Override
    @OnClick(R.id.btn_add_godfather_email)
    public void openCongratsDialog() {

        mFillGodfatherEmail.setError(null);
        mValidator.validate();

    }

    @Override
    public void onValidationSucceeded() {
        welcomeDialog.show();
    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        for (ValidationError error : errors) {
            ValidationErrorWrapper errorWrapper = new ValidationErrorWrapper(error, getContext());
            View view = error.getView();
            TextInputLayout field = (TextInputLayout) view.getParent();
            field.setError(errorWrapper.getFirstErrorMessage());
        }
    }
}

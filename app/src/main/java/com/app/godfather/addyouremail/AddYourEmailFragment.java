package com.app.godfather.addyouremail;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.app.godfather.R;
import com.app.godfather.addgodfatheremail.AddGodFatherEmailActivity;
import com.app.godfather.domain.entity.User;
import com.app.godfather.experiences.ExperiencesActivity;
import com.app.godfather.infrastructure.UserRepository;
import com.app.godfather.infrastructure.UserRepository.LoadUserCallback;
import com.app.godfather.infrastructure.UserSession;
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
public class AddYourEmailFragment extends Fragment implements  Validator.ValidationListener, AddYourEmailContract.View{

    public static final String KEY_CHEMICAL_DEPENDENT_EMAIL = "KEY_CHEMICAL_DEPENDENT_EMAIL";

    @BindView(R.id.add_your_email_layout)
    TextInputLayout mAddYourEmailInputLayout;


    @NotEmpty(sequence = 1, messageResId = R.string.saripaar_empty_message)
    @Email(sequence    = 2, messageResId = R.string.saripaar_email_message)
    @BindView(R.id.your_email_edit_text)
    EditText mFillYourLayoutEmail;

    private Dialog welcomeDialog;
    private Validator mValidator;
    private boolean isAddict;

    public static AddYourEmailFragment newInstance(boolean isAddict){
        AddYourEmailFragment fragment = new AddYourEmailFragment();

        fragment.isAddict = isAddict;
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_your_email_frag, container, false);
        ButterKnife.bind(this, view);

        mValidator = new Validator(this);
        mValidator.setValidationListener(this);

        welcomeDialog = new Dialog(getContext(), R.style.DialogTheme);
        welcomeDialog.setContentView(R.layout.wellcome_dialog);

        return view;
    }

    @Override
    public void onValidationSucceeded() {
        User user;
        if (isAddict){
            user = new User(mFillYourLayoutEmail.getText().toString(), User.CHEMICAL_DEPENDENT);
            UserRepository.getInstance().save(user);
            UserSession userSession = new UserSession(getContext());
            userSession.newSession(user.getEmail());

            Intent intent = new Intent(getContext(), AddGodFatherEmailActivity.class);
            intent.putExtra(KEY_CHEMICAL_DEPENDENT_EMAIL, user.getEmail());
            startActivity(intent);
        }else{
            UserRepository.getInstance().findByEmail(mFillYourLayoutEmail.getText().toString(), new LoadUserCallback() {
                @Override
                public void onSuccess(User user) {
                    UserSession userSession = new UserSession(getContext());
                    userSession.newSession(user.getEmail());

                    Intent intent = new Intent(getContext(), ExperiencesActivity.class);
                    startActivity(intent);
                }
            });
        }
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

    @Override
    @OnClick(R.id.btn_add_your_email)
    public void saveExperience() {
        mFillYourLayoutEmail.setError(null);
        mValidator.validate();
    }
}

package com.strikalov.unittestinghomework.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.strikalov.unittestinghomework.App;
import com.strikalov.unittestinghomework.R;
import com.strikalov.unittestinghomework.presenter.MainPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends MvpAppCompatActivity implements MainView {

    @BindView(R.id.user_name_text_view)
    TextView userNameTextView;

    @Inject
    @InjectPresenter
    public MainPresenter mainPresenter;

    @ProvidePresenter
    public MainPresenter provideMainPresenter(){
        return mainPresenter;
    }

    {
        App.getAppComponent().injectMainActivity(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    public void showUserName(String name) {
        userNameTextView.setText(name);
    }
}

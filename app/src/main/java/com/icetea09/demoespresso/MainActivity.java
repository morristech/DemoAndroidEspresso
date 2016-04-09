package com.icetea09.demoespresso;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mEtUsername;
    private EditText mEtPassword;
    private TextView mTvMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEtUsername = (EditText) findViewById(R.id.et_username);
        mEtPassword = (EditText) findViewById(R.id.et_password);
        mTvMessage = (TextView) findViewById(R.id.tv_message);
        findViewById(R.id.btn_login).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                String username = mEtUsername.getText().toString();
                String password = mEtPassword.getText().toString();
                if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
                    mTvMessage.setText("You must enter both username and password!");
                } else {
                    mTvMessage.setText("Login successfully!");
                }
                mTvMessage.setVisibility(View.VISIBLE);
                break;
        }
    }
}

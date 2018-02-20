package com.altv.dugoutapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.altv.dugout_domain.executor.ThreadExecutor;
import com.altv.dugoutapp.di.components.DaggerApplicationComponent;
import com.altv.dugoutapp.di.modules.ApplicationModule;
import com.altv.dugoutapp.state_machines.MainStateMachine;
import com.bluelinelabs.conductor.Conductor;
import com.bluelinelabs.conductor.Router;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private Router router;
    public MainStateMachine mainStateMachineHandler;

    @BindView(R.id.controller_container)
    ViewGroup container;

    @BindView(R.id.image)
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        router = Conductor.attachRouter(this, container, savedInstanceState);

        mainStateMachineHandler = new MainStateMachine(router);
    }

    @Override
    public void onBackPressed() {
        if (!router.getBackstack().get(0).controller().handleBack()) {
            super.onBackPressed();
        }
    }

    public Router getRouter() {
        return router;
    }
}

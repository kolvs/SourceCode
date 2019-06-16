package com.assess15.openProjects.dagger2;

import android.widget.FrameLayout;
import android.widget.TextView;

import com.assess15.comm.BaseActivity;
import com.assess15.openProject.R;
import com.assess15.openProjects.dagger2.di.component.DaggerMyComponent;
import com.assess15.openProjects.dagger2.di.module.TextViewModule;

import javax.inject.Inject;

public class Dagger2Activity extends BaseActivity {

    @Inject
    User mUser;
    @Inject
    TextView mTextView;

    @Override
    public int getLayoutRes() {
        return R.layout.activity_dagger2;
    }

    @Override
    public void initView() {
        DaggerMyComponent.builder().textViewModule(new TextViewModule(this)).build().inject(this);
        FrameLayout frameLayout = findViewById(R.id.frame);
        mTextView.setText(mUser.name);
        frameLayout.addView(mTextView);
//        DaggerMyComponent.builder().build().inject(this);
//        Toast.makeText(this, mUser.name, Toast.LENGTH_LONG).show();
    }

}
package com.gohung.hazukie.qhakka;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;
import com.qmuiteam.qmui.widget.QMUITopBar;
import com.qmuiteam.qmui.widget.QMUITopBarLayout;

public class MainAllActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_navhost_fragement);
        QMUITopBarLayout top=(QMUITopBarLayout) findViewById(R.id.top);
        top.setTitle("客家方言查询字典");
        top.addRightTextButton(getString(R.string.mainAllmenu),R.id.top).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        NavController navController= Navigation.findNavController(this,R.id.nav_host);
        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener()
        {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments)
            {
                //Toast.makeText(MainAllActivity.this, "cilcked", Toast.LENGTH_SHORT).show();
            }
        });
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavi);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
    }
    public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
        Intent intent;
        if (paramInt == KeyEvent.KEYCODE_BACK) {
            intent = new Intent("android.intent.action.MAIN");
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.addCategory("android.intent.category.HOME");
            startActivity(intent);
            return true;
        }
        return super.onKeyDown(paramInt, paramKeyEvent);
    }
}

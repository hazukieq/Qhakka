package com.gohung.hazukie.qhakka;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Gravity;

import com.gohung.hazukie.qhakka.adapers.QMUIFragmentPagerAdapter;
import com.qmuiteam.qmui.util.QMUIStatusBarHelper;
import com.qmuiteam.qmui.widget.QMUIViewPager;
import com.qmuiteam.qmui.widget.tab.QMUITab;
import com.qmuiteam.qmui.widget.tab.QMUITabBuilder;
import com.qmuiteam.qmui.widget.tab.QMUITabSegment;

public class mainAllAct extends AppCompatActivity {
    private QMUIViewPager mViewPager;
    private QMUITabSegment mTabSegment;
    private FragmentManager fm = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_all);
        QMUIStatusBarHelper.translucent(this);
        mViewPager=(QMUIViewPager) findViewById(R.id.pager);
        mTabSegment=(QMUITabSegment) findViewById(R.id.tabs);
        initPagers();
    }

    private void initPagers() {
        QMUIFragmentPagerAdapter adapter = new QMUIFragmentPagerAdapter(fm) {
            @Override
            public Fragment createFragment(int position) {
                switch (position){
                    case 0:
                        return new main_frag();
                    case 1:
                        return new word_Fragment();
                    case 2:
                        return new help_Fragment();
                    default:
                        return null;
                }

            }

            @Override
            public int getCount() {
                return 3;
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
               switch (position){
                   case 0:
                       return "首页";
                   case 1:
                       return "词汇";
                   case 2:
                       return "帮助";
                   default:
                       return "";
               }
            }
        };
        mViewPager.setAdapter(adapter);
        mViewPager.setOffscreenPageLimit(3);
        QMUITabBuilder tabBuilder = mTabSegment.tabBuilder()
                .setGravity(Gravity.CENTER);
        tabBuilder.setDynamicChangeIconColor(true);
        tabBuilder.setColor(getColor(R.color.qmui_config_color_gray_2),getColor(R.color.text_red));
        mTabSegment.setIndicator(null);
        QMUITab home=tabBuilder.setText("首页").
                setNormalDrawable(getDrawable(R.drawable.ic_action_home))
                .setSelectedDrawable(getDrawable(R.drawable.home)).build(this);
        QMUITab word=tabBuilder.setText("词汇").
                setNormalDrawable(getDrawable(R.drawable.ic_action_word)).setSelectedDrawable(getDrawable(R.drawable.ic_action_word)).build(this);
        QMUITab help=tabBuilder.setText("帮助").
                setNormalDrawable(getDrawable(R.drawable.ic_action_help)).setSelectedDrawable(getDrawable(R.drawable.ic_action_help)).build(this);
        mTabSegment.addTab(home);
        mTabSegment.addTab(word);
        mTabSegment.addTab(help);
        mTabSegment.setupWithViewPager(mViewPager,false);
    }


}


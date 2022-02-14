package com.gohung.hazukie.qhakka;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;
import androidx.preference.PreferenceManager;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import com.qmuiteam.qmui.widget.QMUITopBarLayout;
import com.qmuiteam.qmui.widget.grouplist.QMUICommonListItemView;
import com.qmuiteam.qmui.widget.grouplist.QMUIGroupListView;


public class frag_settings_main extends Fragment {
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root=inflater.inflate(R.layout.frag_settings_main, container, false);
        sp= PreferenceManager.getDefaultSharedPreferences(getActivity());
        editor=sp.edit();
        QMUITopBarLayout top=(QMUITopBarLayout)root.findViewById(R.id.setting_main_topbar);
        top.setTitle(getString(R.string.setting_main_title));
        top.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
            }
        });
            QMUIGroupListView groupListView;
        SettingActivity set=(SettingActivity) getActivity();
            groupListView=(QMUIGroupListView) root.findViewById(R.id.groupListView);
            QMUICommonListItemView lang_cmn =groupListView.createItemView(getString(R.string.setting_main_lang_cmn));
            lang_cmn.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_CHEVRON);

            QMUICommonListItemView lang_hakka=groupListView.createItemView(getString(R.string.setting_main_lang_hakka));
            lang_hakka.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_CHEVRON);

            QMUICommonListItemView lang_ipatone=groupListView.createItemView(getString(R.string.setting_main_lang_ipaTone));
            lang_ipatone.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_CHEVRON);


            QMUICommonListItemView chooseItem1=groupListView.createItemView(getString(R.string.setting_main_lang));
            chooseItem1.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_CHEVRON);

            QMUICommonListItemView chooseItem2=groupListView.createItemView("普通话");
            chooseItem2.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_NONE);

            int size = QMUIDisplayHelper.dp2px(root.getContext(), 20);
            QMUIGroupListView.newSection(root.getContext())
                    .setTitle(getString(R.string.setting_main_lang))
                    .setLeftIconSize(size, ViewGroup.LayoutParams.WRAP_CONTENT)
                    .addItemView(lang_cmn, new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            String[] stras=new String[]{
                                    getActivity().getString(R.string.setting_main_lang_cmn_cmnpin),
                                    getActivity().getString(R.string.setting_main_lang_cmn_ipa)
                            };

                            set.returnFragment(new SubFragment(getString(R.string.setting_main_lang_cmn),stras,0));
                        }
                    })
                    .addItemView(lang_hakka, new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String[] strs=new String[]{getActivity().getString(R.string.setting_main_lang_hakka_gaufungpin),getActivity().getString(R.string.setting_main_lang_hakka_moipin),getActivity().getString(R.string.setting_main_lang_hakka_ipa)};
                            set.returnFragment(new SubFragment(getString(R.string.setting_main_lang_hakka),strs,1));
                        }
                    })
                    .addItemView(lang_ipatone, new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            String[] tonse=new String[]{
                                    getActivity().getString(R.string.setting_main_lang_tone),
                                    getActivity().getString(R.string.setting_main_lang_ipatone_number),
                                    getActivity().getString(R.string.setting_main_lang_ipatone_line)
                            };
                              set.returnFragment(new SubFragment(getString(R.string.setting_main_lang_ipaTone),tonse,2));
                        }
                    })
                    .setOnlyShowStartEndSeparator(true)
                    .addTo(groupListView);


            QMUICommonListItemView singlehan_cmn=groupListView.createItemView(getString(R.string.setting_singlehan_card_cmn));
            singlehan_cmn.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_SWITCH);
            singlehan_cmn.getSwitch().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    editor.putBoolean("cmn_boolean",isChecked);
                    editor.commit();
                   // Toast.makeText(root.getContext(), "checked = " + isChecked, Toast.LENGTH_SHORT).show();
                }
            });
        Boolean cmnBoolean=sp.getBoolean("cmn_boolean",true);
        singlehan_cmn.getSwitch().setChecked(cmnBoolean);

            QMUICommonListItemView singlehan_vas= groupListView.createItemView(getString(R.string.setting_singlehan_card_vas));

            singlehan_vas.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_SWITCH);
            singlehan_vas.getSwitch().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    editor.putBoolean("vas_boolean",isChecked);
                    editor.commit();
                   // Toast.makeText(root.getContext(), "checked = " + isChecked, Toast.LENGTH_SHORT).show();
                }
            });
        Boolean vasBoolean=sp.getBoolean("vas_boolean",true);
        singlehan_vas.getSwitch().setChecked(vasBoolean);

            QMUICommonListItemView singlehan_hakka_audio=groupListView.createItemView(getString(R.string.setting_singlehan_card_hakka_audio));

            singlehan_hakka_audio.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_SWITCH);
            singlehan_hakka_audio.getSwitch().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    editor.putBoolean("hakka_boolean",isChecked);
                    editor.commit();
                    //Toast.makeText(root.getContext(), "checked = " + isChecked, Toast.LENGTH_SHORT).show();
                }
            });
        Boolean hakkaBoolean=sp.getBoolean("hakka_boolean",true);
        singlehan_hakka_audio.getSwitch().setChecked(hakkaBoolean);

            QMUICommonListItemView singlehan_sw=groupListView.createItemView(getString(R.string.setting_singlehan_card_sw));

            singlehan_sw.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_SWITCH);
            singlehan_sw.getSwitch().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    editor.putBoolean("sw_boolean",isChecked);
                    editor.commit();
                  //  Toast.makeText(root.getContext(), "checked = " + isChecked, Toast.LENGTH_SHORT).show();
                }
            });
        Boolean swBoolean=sp.getBoolean("sw_boolean",true);
        singlehan_sw.getSwitch().setChecked(swBoolean);

            QMUICommonListItemView singlehan_kx=groupListView.createItemView(getString(R.string.setting_singlehan_card_kx));

            singlehan_kx.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_SWITCH);
            singlehan_kx.getSwitch().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    editor.putBoolean("kx_boolean",isChecked);
                    editor.commit();
                    //Toast.makeText(root.getContext(), "checked = " + isChecked, Toast.LENGTH_SHORT).show();
                }
            });
        Boolean kxBoolean=sp.getBoolean("kx_boolean",true);
        singlehan_kx.getSwitch().setChecked(kxBoolean);

            QMUICommonListItemView singlehan_hd=groupListView.createItemView(getString(R.string.setting_singlehan_card_hd));

            singlehan_hd.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_SWITCH);
            singlehan_hd.getSwitch().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    editor.putBoolean("hd_boolean",isChecked);
                    editor.commit();
                    //Toast.makeText(root.getContext(), "checked = " + isChecked, Toast.LENGTH_SHORT).show();
                }
            });
        Boolean hdBoolean=sp.getBoolean("hd_boolean",true);
        singlehan_hd.getSwitch().setChecked(hdBoolean);

            QMUIGroupListView.newSection(root.getContext())
                    .setTitle(getString(R.string.setting_singlehan_card_title))
                    .setOnlyShowStartEndSeparator(true)
                    .addItemView(singlehan_cmn, new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                        }
                    })
                    .addItemView(singlehan_vas, new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                        }
                    })
                    .addItemView(singlehan_hakka_audio, new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                        }
                    })
                    .addItemView(singlehan_sw, new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                        }
                    })
                    .addItemView(singlehan_kx, new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                        }
                    })
                    .addItemView(singlehan_hd, new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                        }
                    })
                    .addTo(groupListView);

            QMUICommonListItemView others_lang= groupListView.createItemView(getString(R.string.setting_others_font_type));
            others_lang.setAccessoryType(QMUICommonListItemView.ACCESSORY_TYPE_CHEVRON);

             QMUIGroupListView.newSection(root.getContext()).setTitle(getString(R.string.setting_others_title))
                     .setOnlyShowStartEndSeparator(true).addItemView(others_lang, new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {

                     String[] stres=new String[]{
                             getActivity().getString(R.string.setting_others_font_gan),
                             getActivity().getString(R.string.setting_others_font_fan)
                     };
                       set.returnFragment(new SubFragment(getString(R.string.setting_others_font_type),stres,3));
                 }
             })
                     .addTo(groupListView);
        return root;
    }

}
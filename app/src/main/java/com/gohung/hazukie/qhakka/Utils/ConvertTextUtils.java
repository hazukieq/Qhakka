package com.gohung.hazukie.qhakka.Utils;

import android.content.Context;
import android.content.res.Resources;

import com.gohung.hazukie.qhakka.R;
import com.gohung.hazukie.qhakka.database.Word;

public class ConvertTextUtils {
    private Context context;
    private ConvertToUtils convert;

    public ConvertTextUtils(Context context) {
        this.context = context;
    }

    public String returnText(Word word, String selectType) {
        convert = new ConvertToUtils();
        Resources res = this.context.getResources();
        String all_vu = res.getString(R.string.all_vu);
        String cmn_head = res.getString(R.string.cmn_head);
        String bh_head = res.getString(R.string.bh_head);
        String hk_head = res.getString(R.string.hk_head);
        String va_head = res.getString(R.string.va_head);

        switch (selectType) {
            case "cmn":
                String cmn = word.getCmn_p();
                String scmn=null;
                if ( cmn == null||cmn.isEmpty()) {
                    scmn= cmn_head + all_vu;
                } else {
                    StringBuffer cmnx = convert.returnTones_PY(cmn);
                    scmn = cmn_head + cmnx;
                }
                return scmn;

            case "hk":
                String hkp = word.getHk_p();
                String shk="";
                if ( hkp== null||hkp.isEmpty()) {
                    shk= hk_head + all_vu;
                } else {
                    StringBuffer hkpx = convert.returnTones_PY(hkp);
                    shk = hk_head + hkpx;
                }
                return shk;
            case "bh":
                String bh = word.getBh();
                String sbh="";
                sbh = bh_head + bh;
                return sbh;
            case "va":
                String va = word.getVa();
                String sva="";
                if ( va == null||va.isEmpty()) {
                    sva = va_head + all_vu;
                } else {
                    sva = va_head + va;
                }
                return sva;
            default:
                return all_vu;
        }
    }

}
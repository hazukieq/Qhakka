package com.gohung.hazukie.qhakka.Utils;

import android.util.Log;

import com.gohung.hazukie.qhakka.database.Word;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class FilterData {
    String filter_str;
    List<Word> want_filterlist=new ArrayList<>();

    public FilterData(String str, List<Word> list){
        this.filter_str=str;
        this.want_filterlist=list;
    }

    public List<Word> returnHanzlist(){
        List<Word> returnList=new ArrayList<>();
        for(Word ini:want_filterlist){
            String match_str=ini.getHz();
            if(filter_str.equals(match_str)) {
                returnList.clear();
                returnList.add(ini);
            }
        }
        return returnList;
    }
    public List<Word> returnCmnList(){
        List<Word> returnList=new ArrayList<>();
        TreeSet<Integer>   Str_list=new TreeSet<>();
        for(Word ini:want_filterlist){
            String h=ini.getCmn_p();
            if((h==null)||(h.isEmpty())){}else{
            String[] target=ini.getCmn_p().split(",");

            for(String tar:target) {
                if ((filter_str.startsWith("re`^") && filter_str.endsWith("x$")) | (filter_str.startsWith("re`^") && filter_str.endsWith("q$")) | (filter_str.startsWith("re`^") && filter_str.endsWith("h$")) | (filter_str.startsWith("re`^") && filter_str.endsWith("s$"))) {
                    String fomat = filter_str.replace("re`", "");
                    Pattern p = Pattern.compile(fomat);
                    Matcher matcher = p.matcher(tar);
                    while (matcher.find()) {
                        int y = want_filterlist.indexOf(ini);
                        Str_list.add(y);
                    }

                } else {
                    if (filter_str.equals(tar)) {
                        int x = want_filterlist.indexOf(ini);
                        Str_list.add(x);
                    }
                }
            }
            }

        }
        for(int y:Str_list) {
            Word u=want_filterlist.get(y);
            returnList.add(u);
        }
        return  returnList;

    }

    public List<Word> returnHakkaList(){
        List<Word> returnList=new ArrayList<>();
        TreeSet<Integer>   Str_list=new TreeSet<>();
        for(Word ini:want_filterlist){
            String h=ini.getHk_p();
            if(h==null||h.isEmpty()) {}else{
                String[] target = h.split(",");
                for (String tar : target) {
                    if ((filter_str.startsWith("re`^") && filter_str.endsWith("x$")) | (filter_str.startsWith("re`^") && filter_str.endsWith("q$")) | (filter_str.startsWith("re`^") && filter_str.endsWith("h$")) | (filter_str.startsWith("re`^") && filter_str.endsWith("s$"))) {
                        String fomat = filter_str.replace("re`", "");
                        Pattern p = Pattern.compile(fomat);
                        Matcher matcher = p.matcher(tar);
                        while (matcher.find()) {
                            int y = want_filterlist.indexOf(ini);
                            Str_list.add(y);
                        }

                    } else {
                        if (filter_str.equals(tar)) {
                            int x = want_filterlist.indexOf(ini);
                            Str_list.add(x);
                        }
                    }
                }
            }

        }
        for(int y:Str_list) {
            Word u=want_filterlist.get(y);
            returnList.add(u);
        }
        return  returnList;

    }
}
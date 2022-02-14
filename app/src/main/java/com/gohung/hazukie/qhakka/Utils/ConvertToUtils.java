package com.gohung.hazukie.qhakka.Utils;
import java.util.ArrayList;

public class ConvertToUtils {

        static String[] Dan_tones=new String[]{
                "ā","á","ǎ","à","a",
                "ō","ó","ǒ","ò","o",
                "ē","é","ě","è","e",
                "ī","í","ǐ","ì","i",
                "ū","ú","ǔ","ù","u",
                "ǖ","ǘ","ǚ","ǜ",
                "ṅg","ńg","ňg","ǹg","ng",
                "ṅ","ń","ň","ǹ","n"
                ,"m2","m1","m3","m4","m"
        };

        static String[] Dan_tones_Al=new String[]{
                "ax","aq","ah","as","a",
                "ox","oq","oh","os","o",
                "ex","eq","eh","es","e",
                "ix","iq","ih","is","i",
                "ux","uq","uh","us","u","vx",
                "vq","vh","vs",
                "nghx","nghq","nghh","nghs","ng",
                "nhx","nhq","nhh","nhs","n"
                ,"mhq","mhx","mhh","mhs","m"};

        static String[] Double_tones_Al=new String[]{
                "itx","it","ipx","ip","ikx","ik",
                "atx","at","apx","ap","akx","ak",
                "etx","et","epx","ep","ekx","ek",
                "utx","ut","ukx","uk",
                "otx","ot","okx","ok",
                "eux","euq","euh","eus",
                "oix","oiq","oih","ois",

                "aix","aiq","aih","ais","ai",
                "eix","eiq","eih","eis","ei",
                "aox","aoq","aoh","aos","ao",
                "aux","auq","auh","aus",
                "oux","ouq","ouh","ous","ou",
                "erx","erq","erh","ers","er",};

        static String[] Double_tones=new String[]{
                "īt","ít","īp","íp","īk","ík",
                "āt","át","āp","áp","āk","ák",
                "ēt","ét","ēp","ép","ēk","ék",
                "ūt","út","ūk","úk",
                "ōt","ót", "ōk","ók",

                "ēu","éu","ěu","èu",
                "ōi","ói","ǒi","òi",
                "āi","ái","ǎi","ài","ai",
                "ēi","éi","ěi","èi","ei",
                "āo","áo","ǎo","ào","ao",
                "āu","áu","ǎu","àu",
                "ōu","óu","ǒu","òu","ou",
                "ēr","ér","ěr","èr","er"};

        static String[] Ang_Tones=new String[] {
                "ām","ám","ǎm","àm",
                "ān","án","ǎn","àn","an",
                "āng","áng","ǎng","àng","ang",

                "īn","ín","ǐn","ìn","in",
                "īm","ím","ǐm","ìm",
                "īng","íng","ǐng","ìng","ing",

                "ūn","ún","ǔn","ùn","un",
                "ūng","úng","ǔng","ùng",

                "ēn","én","ěn","èn","en",
                "ēm","ém","ěm","èm",
                "ēng","éng","ěng","èng","eng",

                "ōn","ón","ǒn","òn",
                "ōng","óng","ǒng","òng","ong",
        };

        static String[] Ang_Tones_Al=new String[] {
                "amx","amq","amh","ams",
                "anx","anq","anh","ans","an",
                "angx","angq","angh","angs","ang",

                "inx","inq","inh","ins","in",
                "imx","imq","imh","ims",
                "ingx","ingq","ingh","ings","ing",

                "unx","unq","unh","uns","un",
                "ungx","ungq","ungh","ungs",

                "enx","enq","enh","ens","en",
                "emx","emq","emh","ems",
                "engx","engq","engh","engs","eng",

                "onx","onq","onh","ons",
                "ongx","ongq","ongh","ongs","ong",};

        //梅县拼音方案转换，把高峰客家话拼音方案中不符合的，全部替换掉；

        static String[] Gau_consonant_Al=new String[] {
                "nzi","th","qa","qi","qu","qe","qo",
                "zi","ci","si",
                "ji","j",
        };
        static String[] Moi_consonant_Al=new String[] {
                "ngi","sl","a","i","u","e","o"
                ,"ji","qi","si",
                "yi","y",
        };

        static String[] Gau_vowels_Al=new String[] {"e","êu","en","em","eng"};
        static String[] Moi_vowels_Al=new String[] {"ê","êu","ên","êm","êng"};
        static String[] Gau_tone_Al=new String[] {"x","q","h","s","tx","t","px","p","kx","k"};
        static String[] Moi_tone_Al=new String[] {"1","2","3","4","d5","d6","b5","b6","g5","g6"};


        //普通话IPA转换对照表
        static String[] Consonant_Set=new String[] {
                //普通话声母个国际音标；
                "pʰ","p","m","f",
                "tʰ","t","n","l",
                "kh","k",
                "x","tɕ","tɕʰ","ɕ",
                "tʂ","tʂʰ","ʂ",
                "ts","tsʰ","s",
                "ɻ","ua","uə","iu","iɛ","yɛ","i","iuŋ"
        };
        static String[] Consonant_Set_Al=new String[] {
                //普通话的声母体系；
                "p","b","m","f",
                "t","d","n","l",
                "k","g",
                "h","j","q","x",
                "zh","ch","sh",
                "z","c","s",
                "r","wa","we","yo","ya","yua","yi","yung"
        };
        //国际音标声调对照表，有调值表示、一二三四表示、折线表示；
        static String[] cmn_tonse_Al=new String[]{"x","q","h","s",""};
        static String[] cmn_tones=new String[] {"˥","˧˥","˨˩˦","˥˩",""};
        static String[] cmn_num_tones=new String[] {"⁵⁵","³⁵","²¹⁴","⁵¹",""};
        static String[] cmn_sinum_tones=new String[] {"1","2","3","4",""};
        //普通话单元音
        static String[] cmn_single_vowels_Al=new String[] {"a","i","u","e","o","v"};
        static String[] cmn_single_vowels=new String[] {"a","i","u","ə","o","y"};
        //普通话特殊整体拼读音节，为方便转换，单独成表；
        static String[] cmn_special_Al=new String[] { "zhi","chi","shi","zi","ci","si","yi","yu","ya","ye","yue","you","yao","yo","ri","wu","wo","wa","wai","wei","qu","ju","xi","xu","re"};
        static String[] cmn_special=new String[] { "tʂɿ","tʂʰɿ","ʂɿ","tsɿ","tsʰɿ","sɿ","i","y","ia","iɛ","yɛ","iou","iau","io","ɻɿ","u","uo","ua","uai","uei","tɕʰy","tɕy","ɕi","ɕy","ɻə"};
        //普通话双元音列表
        static String[] cmn_double_vowels_Al=new String[] {"ai","ei","ao","ou","er","ui","iu","uo","ue","ua","uai","ia","iao","ie",};
        static String[] cmn_double_vowels=new String[] {"ai","ɛ","au","ou","ɚ","uei","iou","uo","yɛ","ua","uai","ia","iau","iɛ"};
        //普通话有韵尾的元音列表
        static String[] cmn_Ang_Al=new String[] {"","n","ng","an","ang","en","eng","un","ong","in","ing","ian","iang","uan","uang","iong",};
        static String[] cmn_Ang=new String[] {"","n","ŋ","an","aŋ","ən","ɤŋ","uən","uŋ","in","iŋ","iɛn","iaŋ","uan","uaŋ","iuŋ",};


        //客家话IPA转换，辅音列表；
        static String[] hakka_consonant=new String[] {
                "pʰ","p","m","f","ʋ",
                "tʰ","t","n","l","ȵ","θ",
                "kh","k","h","ŋ","hŋ",
                "ts","tsʰ","s",
                "ʔ","j","j"
        };
        static String[] hakka_consonant_Al=new String[] {
                "b","p","m","f","v",
                "t","d","n","l","nzi","th",
                "k","g","h","ng","hng",
                "z","c","s",
                "q","ji","j"};

        //客家话单元音列表
        static String[] hakka_vowels_Al=new String[]{"a","i","u","e","o","ii","h",""};
        static String[] hakka_vowels=new String[]   {"a","i","u","ɛ","ɔ","ɿ","",""};

        //客家话双元音列表
        static String[] hakka_double_vowels_Al=new String[] {"ai","iai","au","iau","eu","oi","io","ioi","ie","ia","iu","ui"};
        static String[] hakka_double_vowels=   new String[] {"ai","iai","au","iau","ɛu","ɔi","iɔ","iɔi","iɛ","ia","iu","ui"};

        //末尾为-n/-m/-ng的韵母列表
        static String[] hakka_Ang_Al=new String[] {"an","am","iam","ang","iang","en","ien","iem","em","eng","in","im","ing","un","iun","ung","iung","on","ong","iong","ion",};
        static String[] hakka_Ang=new String[]    {"an","am","iam","aŋ", "iaŋ","ɛn","iɛn","iɛm","ɛm","iɛŋ","in","im","iŋ", "un","iun","uŋ", "iuŋ","ɔn","ɔŋ","iɔŋ","iɔn"};

        //声调列表
        static String[] hakka_tones_Al=new String[]   {"x","q","h","s","tx","t","px","p","kx","k"};
        static String[] hakka_tones=new String[]     {"˧˧˥","˩˧","˨˩","˥˧","t˨","t˥","p˨","p˥","k˨","k˥"};
        static String[] hakka_tones_num=new String[] {"1","2","3","5","t7","t8","p7","p8","k7","k8"};
        static String[] hakka_tones_sinum=new String[]{"³³⁵","¹³","²¹","⁵³","t²","t⁵","p²","p⁵","k²","k⁵"};


        public StringBuffer ReturnToMoi(String returnStr) {
            StringBuffer return_all=new StringBuffer();
            String[] convert_str=null;
            String first_str=null;
            String second_str=null;
            String third_str=null;
            String forth_str=null;
            String rest_str=null;
            String last_str=null;
            String others_str=null;
            String complex_str=null;
            ArrayList<String> all_str=new ArrayList<>();
            if((!returnStr.isEmpty())|(!returnStr.equals(""))) {

                convert_str=returnStr.split(",");
                for(int y=0;y<convert_str.length;y++) {
                    first_str=convert_str[y];
                    for(int u=0;u<Gau_consonant_Al.length;u++) {
                        if(first_str.startsWith(Gau_consonant_Al[u])) {
                            second_str=first_str.replace(Gau_consonant_Al[u], Moi_consonant_Al[u]);
                            first_str="";
                            continue;
                        }
                    }
                    if(first_str.equals("")) {
                        for(int a=0;a<Gau_vowels_Al.length;a++) {
                            for(int s=0;s<Gau_tone_Al.length;s++) {
                                if(second_str.endsWith(Gau_vowels_Al[a]+Gau_tone_Al[s])) {
                                    rest_str=second_str.replace(Gau_vowels_Al[a]+Gau_tone_Al[s], Moi_vowels_Al[a]+Moi_tone_Al[s]);
                                    second_str="";
                                }
                            }
                        }
                        if(second_str.equals("")) {
                            all_str.add(rest_str);
                        }else if(second_str.endsWith("tq")|second_str
                                .endsWith("tx")|second_str.endsWith("pq")|second_str.endsWith("px")|second_str.endsWith("kq")|second_str.endsWith("kx")){

                            for(int m=0;m<Gau_tone_Al.length;m++) {
                                if(second_str.endsWith(Gau_tone_Al[m])) {
                                    others_str=second_str.replaceAll(".{2}$", Moi_tone_Al[m]);
                                }

                            }
                            all_str.add(others_str);
                            System.out.println(second_str+"...elseif converted is "+others_str);

                        }else {
                            for(int b=0;b<Gau_tone_Al.length;b++) {
                                if(second_str.endsWith(Gau_tone_Al[b])) {
                                    System.out.println("rest str is--->"+second_str);
                                    last_str=second_str.replaceAll(".$", Moi_tone_Al[b]);
                                }
                            }
                            all_str.add(last_str);
                        }



                    }else {
                        for(int d=0;d<Gau_vowels_Al.length;d++) {
                            for(int  f=0;f<Gau_tone_Al.length;f++) {
                                if(first_str.endsWith(Gau_vowels_Al[d]+Gau_tone_Al[f])) {
                                    third_str=first_str.replace(Gau_vowels_Al[d]+Gau_tone_Al[f], Moi_vowels_Al[d]+Moi_tone_Al[f]);
                                    first_str="";
                                    continue;
                                }
                            }
                        }
                        if(first_str.equals("")) {
                            all_str.add(third_str);
                        }else if(first_str.endsWith("tq")|first_str.endsWith("tx")|first_str.endsWith("pq")|first_str.endsWith("px")|first_str.endsWith("kq")|first_str.endsWith("kx")){
                            for(int q=0;q<Gau_tone_Al.length;q++) {
                                if(first_str.endsWith(Gau_tone_Al[q])) {
                                    complex_str=first_str.replaceAll(".{2}$", Moi_tone_Al[q]);

                                }
                            }
                            all_str.add(complex_str);

                        }else {
                            for(int j=0;j<Gau_tone_Al.length;j++) {
                                if(first_str.endsWith(Gau_tone_Al[j])) {
                                    forth_str=first_str.replaceAll(".$", Moi_tone_Al[j]);

                                }
                            }
                            all_str.add(forth_str);
                        }
                    }
                }
            }
            for(String ini:all_str) return_all.append(ini+" ");

            return return_all;
        }


        public StringBuffer ConverToHkIPA(String receive_str,int Tonformat) {
            StringBuffer returnAll=new StringBuffer();
            String[] hktones=null;
            //这里是控制音标调值显示的方法，2为折线显示，1为一二三四声调显示，0为调值显示
            switch(Tonformat) {
                case 0:
                    hktones=hakka_tones_sinum;
                    break;
                case 1:
                    hktones=hakka_tones_num;
                    break;
                case 2:
                    hktones=hakka_tones;
                    break;

                default:break;
            }
            String[] willReceive_str=new String[] {};
            String willConvert_str=null;
            String double_str=null;
            String single_str=null;
            String Ang_str=null;
            ArrayList<String> allstr=new ArrayList<>();
            //检查传入字符是否为空，如空则不转换，否则继续。这是避免出现空字符错误；
            if((!receive_str.equals(""))|(!receive_str.isEmpty())){
                willReceive_str=receive_str.split(",");
                for(int  i=0;i<willReceive_str.length;i++) {
                    String instance_str=willReceive_str[i];
                    //这里先对传入字符进行检查是否带有“|”这类符号，如有则替换，否则不操作；
                    if(instance_str.startsWith("|")|instance_str.endsWith("|")) {
                        willConvert_str=instance_str.replace("|", "");
                    }else {
                        willConvert_str=instance_str;
                    }
                    //对传入字符组进行for循环，这是首层，里面的循环将会对分割的每个音节进行匹配处理；
                    for(int ih=0;ih<hakka_consonant_Al.length;ih++) {
                        //这里对双元音进行处理，将其与class中的双元音列表匹配，是则转换，否则继续循环；
                        for(int ij=0;ij<hakka_double_vowels_Al.length;ij++) {
                            for(int ik=0;ik<hakka_tones_Al.length;ik++) {
                                if(willConvert_str.equals(hakka_consonant_Al[ih]+hakka_double_vowels_Al[ij]+hakka_tones_Al[ik])) {
                                    double_str=willConvert_str.replace(hakka_consonant_Al[ih]+hakka_double_vowels_Al[ij]+hakka_tones_Al[ik], hakka_consonant[ih]+hakka_double_vowels[ij]+hktones[ik]);
                                    willConvert_str="";
                                    continue;

                                }
                            }
                        }
                    }
                    //这里将转换好的音节添加到总列表中去，剩下的继续循环匹配
                    if(willConvert_str.equals("")) {
                        allstr.add(double_str);

                    }else if(willConvert_str.endsWith("ngq")|willConvert_str.endsWith("ngx")|willConvert_str.endsWith("ngh")|willConvert_str.endsWith("ngs")|
                            willConvert_str.endsWith("nq")|willConvert_str.endsWith("nx")|willConvert_str.endsWith("nh")|willConvert_str.endsWith("ns")|
                            willConvert_str.endsWith("mq")|willConvert_str.endsWith("mx")|willConvert_str.endsWith("mh")|willConvert_str.endsWith("ms")) {
                        //这里处理Ang韵列表，匹配则转换，剩下的转换声调即可，因为if那里已经限定音节结尾为-n/-m/-ng
                        for(int oh=0;oh<hakka_consonant_Al.length;oh++) {
                            for(int oj=0;oj<hakka_Ang_Al.length;oj++) {
                                for(int ok=0;ok<hakka_tones_Al.length;ok++) {
                                    if(willConvert_str.equals(hakka_consonant_Al[oh]+hakka_Ang_Al[oj]+hakka_tones_Al[ok])) {
                                        Ang_str=willConvert_str.replace(hakka_consonant_Al[oh]+hakka_Ang_Al[oj]+hakka_tones_Al[ok],hakka_consonant[oh]+hakka_Ang[oj]+hktones[ok]);
                                        willConvert_str="";
                                        continue;
                                    }
                                }
                            }
                        }
                        //剩下音节处理声调后即添加进总列表
                        allstr.add(Ang_str);


                    }else {
                        //继续处理余下音节，这里处理单元音音节
                        for(int ph=0;ph<hakka_consonant_Al.length;ph++) {
                            for(int pj=0;pj<hakka_vowels_Al.length;pj++) {
                                for(int pk=0;pk<hakka_tones_Al.length;pk++) {
                                    if(willConvert_str.equals(hakka_consonant_Al[ph]+hakka_vowels_Al[pj]+hakka_tones_Al[pk])){
                                        single_str=willConvert_str.replace(hakka_consonant_Al[ph]+hakka_vowels_Al[pj]+hakka_tones_Al[pk], hakka_consonant[ph]+hakka_vowels[pj]+hktones[pk]);
                                        willConvert_str="";
                                        continue;


                                    }
                                }
                            }
                        }
                        //添加转换好的音节进总列表中去，到此已经完成所有音节转换
                        allstr.add(single_str);
                    }
                }
            }
            //使用for循环，把所有转换好的音节从总列表中拿出，并装进字符buffer中去，方便显示
            for(String all:allstr) returnAll.append(all+" ");
            return returnAll;
        }



        public StringBuffer  ConvertToIPA(String Test_str,int Tonesformat){
            String[] ToneseFormat = null;
            switch(Tonesformat) {
                case 0:
                    //num_tones为调值显示；sinum_tones为一二三四显示；tones为折线显示；
                    ToneseFormat=cmn_num_tones; break;
                case 1:  ToneseFormat=cmn_sinum_tones;break;
                case 2: ToneseFormat=cmn_tones;break;

            }
            StringBuffer returnAll=new StringBuffer();
            String yi=null;
            ArrayList<String> alldata=new ArrayList<>();
            String  sepecial_str=null;
            String  single_str=null;
            String Ang_str=null;
            String[] test_str=null;
            String yh=null;
            if(Test_str==null) {

            }else {
                test_str=Test_str.split(",");
                for(int i=0;i<test_str.length;i++) {
                    String yh_str=test_str[i];
                    if(yh_str.startsWith("|")) {
                        yh=yh_str.replace("|", "");
                    }else {
                        yh=yh_str;
                    }
                    for(int ih=0;ih<Consonant_Set_Al.length;ih++) {
                        for(int k=0; k<cmn_double_vowels_Al .length;k++) {
                            for(int t=0;t<cmn_tonse_Al.length;t++) {
                                if(yh.equals(Consonant_Set_Al[ih]+cmn_double_vowels_Al[k]+cmn_tonse_Al[t])) {
                                    yi=yh.replace(Consonant_Set_Al[ih]+cmn_double_vowels_Al[k]+cmn_tonse_Al[t], Consonant_Set[ih]+cmn_double_vowels[k]+ToneseFormat[t]);
                                    yh="";
                                }
                            }

                        }
                    }
                    if(yh.equals("")) {
                        alldata.add(yi);
                    }
                    else if(yh.endsWith("nx")|yh.endsWith("nq")|yh.endsWith("nh")|yh.endsWith("ns")|yh.endsWith("ngx")|yh.endsWith("ngq")|yh.endsWith("ngh")|yh.endsWith("ngs")){
                        for(int l=0;l<Consonant_Set_Al.length;l++) {
                            for(int x=0;x<cmn_Ang_Al.length;x++) {
                                for(int b=0;b<cmn_tonse_Al.length;b++) {
                                    if(yh.equals(Consonant_Set_Al[l]+cmn_Ang_Al[x]+cmn_tonse_Al[b])) {
                                        Ang_str=yh.replace(Consonant_Set_Al[l]+cmn_Ang_Al[x]+cmn_tonse_Al[b], Consonant_Set[l]+cmn_Ang[x]+ToneseFormat[b]);

                                    }
                                }

                            }
                        }
                        alldata.add(Ang_str);
                    }
                    else{
                        for(int y=0;y<cmn_special_Al.length;y++) {
                            for(int g=0;g<cmn_tonse_Al.length;g++) {
                                if(yh.equals(cmn_special_Al[y]+cmn_tonse_Al[g])) {
                                    sepecial_str=yh.replace(cmn_special_Al[y]+cmn_tonse_Al[g], cmn_special[y]+ToneseFormat[g]);
                                    yh="";
                                    continue;
                                }
                            }

                        }

                        if(yh.equals("")) {
                            alldata.add(sepecial_str);
                        }else {
                            for(int d=0;d<Consonant_Set_Al.length;d++) {
                                for(int f=0;f<cmn_single_vowels_Al.length;f++) {
                                    for(int o=0;o<cmn_tonse_Al.length;o++) {
                                        if(yh.equals(Consonant_Set_Al[d]+cmn_single_vowels_Al[f]+cmn_tonse_Al[o])) {
                                            single_str=yh.replace(Consonant_Set_Al[d]+cmn_single_vowels_Al[f]+cmn_tonse_Al[o], Consonant_Set[d]+cmn_single_vowels[f]+ToneseFormat[o]);
                                            yh="";
                                            continue;

                                        }
                                    }

                                }
                            }
                            if(yh.equals("")){
                                alldata.add(single_str);
                            }else{
                                for(int y=0;y<cmn_single_vowels_Al.length;y++){
                                    for(int r=0;r<cmn_tonse_Al.length;r++){
                                        if(yh.equals(cmn_single_vowels_Al[y]+cmn_tonse_Al[r])){
                                            yh=yh.replace(cmn_single_vowels_Al[y]+cmn_tonse_Al[r],cmn_single_vowels[y]+ToneseFormat[r] );
                                        }
                                    }
                                }
                                alldata.add(yh);
                            }

                        }

                    }
                }
            }
            for(String i:alldata) returnAll.append(i+" ");
            return returnAll;
        }

        public StringBuffer returnTones_PY(String wantConvertStr) {
            StringBuffer strb=new StringBuffer();
            ArrayList<String> alldata=new ArrayList<>();
            String nw=null;
            String f=null;
            String[] h=new String[]{""};
            if(wantConvertStr==null){

            }
            else {
                h = wantConvertStr.split(",");
                for (int i = 0; i < h.length; i++) {
                    String Use_f = h[i];
                    if (Use_f.startsWith("|")) {
                        f = Use_f.replace("|", "");
                    } else {
                        f = Use_f;
                    }
                    for (int sh = 0; sh < Double_tones_Al.length; sh++) {
                        if (f.endsWith(Double_tones_Al[sh])) {
                            nw = f.replace(Double_tones_Al[sh], Double_tones[sh]);
                            f = "";
                            continue;
                        }
                    }
                    if (f.equals("")) {
                        alldata.add(nw);
                    } else if (f.endsWith("nx") | f.endsWith("nq") | f.endsWith("nh") | f.endsWith("ns") |f.endsWith("n")| f.endsWith("ngx") | f.endsWith("ngq") | f.endsWith("ngh") | f.endsWith("ngs") |f.endsWith("ng")| f.endsWith("mx") | f.endsWith("mq") | f.endsWith("mh") | f.endsWith("ms")) {
                        for (int y = 0; y < Ang_Tones_Al.length; y++) {
                            if (f.endsWith(Ang_Tones_Al[y])) {
                                String w = f.replace(Ang_Tones_Al[y], Ang_Tones[y]);
                                f = w;
                            }
                        }
                        alldata.add(f);
                    } else {
                        for (int j = 0; j < Dan_tones_Al.length; j++) {
                            if (f.endsWith(Dan_tones_Al[j])) {
                                String jk = f.replace(Dan_tones_Al[j], Dan_tones[j]);
                                f = jk;
                            }
                        }
                        alldata.add(f);
                    }
                }
            }
            for (String i : alldata) strb.append(i + " ");
            return strb;
        }
    public String returnSingleTones_PY(String wantConvertStr) {
        StringBuffer strb=new StringBuffer();
        ArrayList<String> alldata=new ArrayList<>();
        String nw=null;
        String f=null;
        String[] h=new String[]{""};
        if(wantConvertStr==null){

        }
        else {
            h = wantConvertStr.split(",");
            for (int i = 0; i < h.length; i++) {
                String Use_f = h[i];
                if (Use_f.startsWith("|")) {
                    f = Use_f.replace("|", "");
                } else {
                    f = Use_f;
                }
                for (int sh = 0; sh < Double_tones_Al.length; sh++) {
                    if (f.endsWith(Double_tones_Al[sh])) {
                        nw = f.replace(Double_tones_Al[sh], Double_tones[sh]);
                        f = "";
                        continue;
                    }
                }
                if (f.equals("")) {
                    alldata.add(nw);
                } else if (f.endsWith("nx") | f.endsWith("nq") | f.endsWith("nh") | f.endsWith("ns") |f.endsWith("n")| f.endsWith("ngx") | f.endsWith("ngq") | f.endsWith("ngh") | f.endsWith("ngs") |f.endsWith("ng")| f.endsWith("mx") | f.endsWith("mq") | f.endsWith("mh") | f.endsWith("ms")) {
                    for (int y = 0; y < Ang_Tones_Al.length; y++) {
                        if (f.endsWith(Ang_Tones_Al[y])) {
                            String w = f.replace(Ang_Tones_Al[y], Ang_Tones[y]);
                            f = w;
                        }
                    }
                    alldata.add(f);
                } else {
                    for (int j = 0; j < Dan_tones_Al.length; j++) {
                        if (f.endsWith(Dan_tones_Al[j])) {
                            String jk = f.replace(Dan_tones_Al[j], Dan_tones[j]);
                            f = jk;
                        }
                    }
                    alldata.add(f);
                }
            }
        }
        for (String i : alldata) strb.append(i + " ");
        return ""+strb;
    }
}

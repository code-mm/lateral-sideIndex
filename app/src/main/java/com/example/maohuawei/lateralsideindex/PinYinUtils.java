package com.example.maohuawei.lateralsideindex;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;


public class PinYinUtils {

    /**
     * 返回汉字的拼音
     *
     * @param hanzi
     * @return
     */
    public static String getPinYin(String hanzi) {
        String pinyin = "";
        //控制转换是否大小写，是否带音标
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        //大写
        format.setCaseType(HanyuPinyinCaseType.UPPERCASE);
        //没有音标
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);

        //由于不能直接对多个汉字转换，只能对单个汉字转换
        char[] arr = hanzi.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            //如果是空格，则不处理，进行下次遍历
            if (Character.isWhitespace(arr[i])) {
                continue;
            }
            //汉字是2个字节存储，肯定大于127，所以大于127就可以当为汉字转换
            if (arr[i] > 127) {
                try {
                    //由于多音字的存在，单 dan shan
                    String[] pinyinArr = PinyinHelper.toHanyuPinyinStringArray(arr[i], format);

                    if (pinyinArr != null) {
                        pinyin += pinyinArr[0];
                    } else {
                        pinyin += arr[i];
                    }
                } catch (BadHanyuPinyinOutputFormatCombination e) {
                    e.printStackTrace();
                    //不是正确的汉字
                    pinyin += arr[i];

                    //return "#";
                }
            } else {
                //不是汉字，
                pinyin += arr[i];
                //return "#";
            }
        }
        return pinyin;
    }
}

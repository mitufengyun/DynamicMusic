package com.ixuea.courses.mymusic.util;

import static com.ixuea.courses.mymusic.util.Constant.REGEX_EMAIL;
import static com.ixuea.courses.mymusic.util.Constant.REGEX_PASSWORD;
import static com.ixuea.courses.mymusic.util.Constant.REGEX_PHONE;

/**
 * author: xpf
 * time: 2020/2/6 16:45
 * describe: 字符串相关工具类
 */
public class StringUtil {

    /**
     * 是否是手机号
     * @param value
     * @return
     */
    public static boolean isPhone(String value) {
        return value.matches(REGEX_PHONE);
    }

    /**
     * 是否是邮箱
     * @param value
     * @return
     */
    public static boolean isEmail(String value) {
        return value.matches(REGEX_EMAIL);
    }



    /**
     * 是否符合密码格式
     *
     * @param value
     * @return
     */
    public static boolean isPassword(String value) {
        if (value.length() >= 6 && value.length() <= 15) {
            value.matches(REGEX_PASSWORD);
            return true;
        }
        return false;
    }
}

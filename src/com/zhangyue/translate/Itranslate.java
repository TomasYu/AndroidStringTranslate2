package com.zhangyue.translate;

/**
 * Created by zy on 2019/3/21.
 */
public interface Itranslate {
    /**
     * 默认的转换方式  中文简体  to  英文
     * @param src
     * @return
     */
    String translate(String src);

    /**
     * 可以指定由什么语言 转换到什么语言
     * @param src  要翻译的字符串
     * @param from  从什么语言
     * @param to  翻译到什么语言
     * @return
     */
    String translate(String src,String from,String to);
}

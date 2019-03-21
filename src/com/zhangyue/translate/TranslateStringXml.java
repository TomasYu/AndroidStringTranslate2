package com.zhangyue.translate;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by zy on 2019/3/21.
 */
public class TranslateStringXml {

    public static void main(String[] args) {
        translateAndroidXmlString("F:\\github\\AndroidStringTranslate\\src\\res\\strings.xml","F:\\github\\AndroidStringTranslate\\out\\result.xml");
    }

    /**
     * 翻译的总入口  需要传递两个路径
     * @param sourcePath 源文件的绝对路径
     * @param outPath 输出文件的绝对路径
     */
    public static void translateAndroidXmlString(String sourcePath,String outPath){
        // 解析xml
        SAXReader reader = new SAXReader();
        Itranslate translate = new YouDaoTranslate();
        try {
            // 通过reader对象的read方法加载books.xml文件,获取docuemnt对象。
            Document document = reader.read(new File(sourcePath));
            // 通过document对象获取根节点bookstore
            Element rootElement = document.getRootElement();
            // 通过element对象的elementIterator方法获取迭代器
            Iterator it = rootElement.elementIterator();
            // 遍历迭代器，获取根节点中的信息
            while (it.hasNext()) {
                Element element = (Element) it.next();
                String name = element.attribute("name").getValue();
                String value = element.getStringValue();
                System.out.println(name + "-"+ value);
                element.setText(translate.translate(value));
//                element.setText("1111");
            }
            System.out.println(document.asXML());
            FileWriter writer = new FileWriter(outPath);
            document.write(writer);
            writer.flush();
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package DependencyInjection;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zjbao123
 * @version 1.0
 * @since 2020-03-04 23:49:34
 */
public class XmlBeanConfigParser implements BeanConfigParser {

    @Override
    public List<BeanDefinition> parse(InputStream inputStream) {
        String content = new BufferedReader(new InputStreamReader(inputStream)).lines().collect(Collectors.joining("\n"));;
        return parse(content);
    }

    @Override
    public List<BeanDefinition> parse(String configContent) {
        List<BeanDefinition> beanDefinitions = new ArrayList<>();
        try{
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document doc = documentBuilder.parse(configContent);
            //重新整理
            doc.getDocumentElement().normalize();

            NodeList beanlist  = doc.getElementsByTagName("bean");

            for(int i = 0; i<beanlist.getLength(); i++){
                Node node = beanlist.item(i);

                if(node.getNodeType() != Node.ELEMENT_NODE) {
                    continue;
                }

                Element element =(Element) node;

            }

        }catch (Exception e){

        }

        return beanDefinitions;
    }

}


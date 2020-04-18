package DependencyInjection;

import DependencyInjection.BeanConfigParser;
import DependencyInjection.BeanDefinition;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zjbao123
 * @version 1.0
 * @since 2020-03-04 23:49:34
 */
public class XmlBeanConfigParser implements BeanConfigParser {


    @Override
    public List<BeanDefinition> parse(InputStream inputStream) {
        List<BeanDefinition> beanDefinitions = new ArrayList<>();
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document doc = documentBuilder.parse(inputStream);
            //重新整理
            doc.getDocumentElement().normalize();

            NodeList beanlist = doc.getElementsByTagName("bean");

            for (int i = 0; i < beanlist.getLength(); i++) {
                Node node = beanlist.item(i);

                if (node.getNodeType() != Node.ELEMENT_NODE) {
                    continue;
                }

                Element element = (Element) node;

                BeanDefinition beanDefinition = new BeanDefinition(element.getAttribute("id"), element.getAttribute("class"));
                if (element.getAttribute("scope").equals("singleton")) {
                    beanDefinition.setScope(BeanDefinition.Scope.SINGLETON);
                }
                if (element.getAttribute("lazy-init").equals("true")) {
                    beanDefinition.setLazyInit(true);
                }
                loadConstructorArgs(element.getElementsByTagName("constructor-arg"), beanDefinition);
                beanDefinitions.add(beanDefinition);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return beanDefinitions;
    }

    private void loadConstructorArgs(NodeList nodes, BeanDefinition beanDefinition) {
        List<BeanDefinition.ConstructorArg> constructorArgList = new ArrayList<>();
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            if (node.getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            BeanDefinition.ConstructorArg constructorArg = null;
            Element element = (Element) node;
            if (!element.getAttribute("type").isEmpty()) {
                constructorArg = new BeanDefinition.ConstructorArg.Builder().
                        setType(String.class).setArg(element.getAttribute("value")).build();
            }
            if (!element.getAttribute("ref").isEmpty()) {

                constructorArg = new BeanDefinition.ConstructorArg.Builder().setIsRef(true).setArg(element.getAttribute("ref")).build();
            }
            constructorArgList.add(constructorArg);
        }
        beanDefinition.setConstructorArgs(constructorArgList);
    }
}


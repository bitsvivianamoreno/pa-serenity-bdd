package core.Helpers;

/**
 * En esta clase se crean las variables que van a almacenar la informacion de los elementos e implementa la interfaz IParam
 */
public class GeneralParams implements IParam {

    public String where;
    public String targetElementName;
    public String cssOrXPathSelector;
    public String url;

    public GeneralParams(String where, String targetElementName, String cssOrXPathSelector) {
        this.where = where;
        this.targetElementName = targetElementName;
        this.cssOrXPathSelector = cssOrXPathSelector;

    }

    public  GeneralParams(String targetElementName, String cssOrXPathSelector) {
        this.targetElementName = targetElementName;
        this.cssOrXPathSelector = cssOrXPathSelector;
    }

    public GeneralParams(String url) {
        this.url = url;
    }
}

package mazurek.run.logic;

import java.beans.PropertyEditorSupport;

public class MyCustomTypeEditor extends PropertyEditorSupport {
    @Override
    public String getAsText(){
        String str = (String) getValue();
        System.out.println();
        return str;
    }
    @Override
    public void setAsText(String text) {
        setValue(text);
    }
}

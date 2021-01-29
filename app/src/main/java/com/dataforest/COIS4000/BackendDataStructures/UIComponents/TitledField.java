package com.dataforest.COIS4000.BackendDataStructures.UIComponents;

import com.dataforest.COIS4000.BackendDataStructures.FormAttr;
import java.sql.*;

// This is a wrapper for a form attribute, adding a title to it.
public class TitledField extends FormAttr {
    FormAttr attribute;
    String title;

    public TitledField(String title, FormAttr attribute){
        this.title = title;
        this.attribute = attribute;
    }

    public boolean isComplete(){
        return attribute.isComplete();
    }

    public FormAttr getAttribute(){
        return attribute;
    }
}

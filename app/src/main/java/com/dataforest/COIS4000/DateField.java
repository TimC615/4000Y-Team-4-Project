package com.dataforest.COIS4000;
import java.time.LocalDate;

public class DateField extends FormAttr{

    LocalDate date;
    LocalDate oldValue;

    // not initializing ensures that the attribute is only complete once a value is added
    @Override
    public boolean isComplete() {
        return !(date == null);
    }

    public LocalDate getValue(){
        return date;
    }

    public void setVale(LocalDate value){
        date = value;
    }
}

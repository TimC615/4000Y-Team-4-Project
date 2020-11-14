package com.dataforest.COIS4000;

public class Record extends FormAttr{
    Field[] fields;
    Record next, prev;

    public Record(Field[] fields){
        this.fields = fields;
        next = null;
        prev = null;
    }

    /*
    * record should only be added if the current one is complete
    * */
    public void addRecord(){
        if(!isCurrentRecordComplete()){
            //flag not complete & ask for override
        }

        //only if complete/user overrides incomplete state
        next = new Record(fields);
        next.prev = this;

        //send GUI event for adding a row
    }

    public boolean isCurrentRecordComplete(){
        for(int i = 0; i < fields.length; i++){
            if(!fields[i].isComplete()){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isComplete() {
        if(prev != null)
            return false;
        Record current = this.next;

        while(current != null){
            if(!current.isCurrentRecordComplete()){
                return false;
            }
        }

        return isCurrentRecordComplete();
    }
}


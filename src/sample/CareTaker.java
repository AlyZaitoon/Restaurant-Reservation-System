package sample;

import java.util.ArrayList;

public class CareTaker {
    private ArrayList<Memento> arrayList=new ArrayList<>();
    public void addMemento(Memento m){
        arrayList.add(m);
    }
    public Memento getMemento(){
        return arrayList.get(arrayList.size()-1);
    }

    public void setArrayList(ArrayList<Memento> arrayList) {
        this.arrayList = arrayList;
    }

    public ArrayList<Memento> getArrayList() {
        return arrayList;
    }
}

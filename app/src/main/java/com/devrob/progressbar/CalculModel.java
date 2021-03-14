package com.devrob.progressbar;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class CalculModel implements Operaciones {
    private MutableLiveData<Double> result = new MutableLiveData<>();
    private MutableLiveData<Integer> selectedOp = new MutableLiveData<>();

    public CalculModel() {
        result.setValue(0.0);
    }

    public MutableLiveData<Double> getResult() {
        return result;
    }

    public MutableLiveData<Integer> getSelectedOp() {
        return selectedOp;
    }

    public void setSelectedOp(int position) {
        selectedOp.setValue(position);
    }

    public void calcularResultado( Double n1, Double n2 ){
        switch (selectedOp.getValue()){
            case 0:
                Sumar(n1,n2);
                break;
            case 1:
                Multiplicar(n1,n2);
                break;
            case 2:
                Restar(n1,n2);
                break;
            case 3:
                Dividir(n1,n2);
                break;
            default:
                System.out.println("deafult");
        }
    }
    @Override
    public void Sumar(Double n1, Double n2) {
        result.setValue(n1 + n2);
    }

    @Override
    public void Restar(Double n1, Double n2) {
        result.setValue(n1 - n2);
    }

    @Override
    public void Multiplicar(Double n1, Double n2) {
        result.setValue(n1 * n2);
    }

    @Override
    public void Dividir(Double n1, Double n2) {
        result.setValue(n1 / n2);
    }

}

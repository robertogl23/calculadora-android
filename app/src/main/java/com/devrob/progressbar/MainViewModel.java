package com.devrob.progressbar;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


public class MainViewModel extends ViewModel{

    private MutableLiveData<Double> result;
    private CalculModel calculModel;
    private MutableLiveData<Integer> selectedOp;

    public MainViewModel() {
        this.calculModel = new CalculModel();
        this.result = calculModel.getResult();
        this.selectedOp = calculModel.getSelectedOp();
    }

    public LiveData<Double> getResult() {
        return result;
    }


    public MutableLiveData<Integer> getSelectedOp() {
        return selectedOp;
    }

    public void setSelectedOp(int position) {
        calculModel.setSelectedOp(position);
    }

    public void calcular( Double n1, Double n2){
        calculModel.calcularResultado(n1, n2);
    }


}

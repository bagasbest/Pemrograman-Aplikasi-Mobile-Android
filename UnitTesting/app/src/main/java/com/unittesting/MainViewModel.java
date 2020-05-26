package com.unittesting;

public class MainViewModel {
    private final CuboidModel cuboidModel;


    public MainViewModel(CuboidModel cuboidModel) {
        this.cuboidModel = cuboidModel;
    }

    void save(double l, double w, double h){
        cuboidModel.save(l,w,h);
    }

    double getCircumference(){
        return cuboidModel.getCircumference();
    }

    double getSurfacearea (){
        return cuboidModel.getSurfaceArea();
    }

    double getVolume (){
        return cuboidModel.getVolume();
    }

}

package com.test.testexample;

public class Modelclass_values {
    String maxslab,minslab,wageredpercnetslab,wageredslabmax,slabotcpercentage,slabotcmax;

    public Modelclass_values(String maxslab, String minslab, String wageredpercnetslab, String wageredslabmax, String slabotcpercentage, String slabotcmax) {
        this.maxslab = maxslab;
        this.minslab = minslab;
        this.wageredpercnetslab = wageredpercnetslab;
        this.wageredslabmax = wageredslabmax;
        this.slabotcpercentage = slabotcpercentage;
        this.slabotcmax = slabotcmax;
    }
    public  Modelclass_values(){

    }

    public String getMaxslab() {
        return maxslab;
    }

    public void setMaxslab(String maxslab) {
        this.maxslab = maxslab;
    }

    public String getMinslab() {
        return minslab;
    }

    public void setMinslab(String minslab) {
        this.minslab = minslab;
    }

    public String getWageredpercnetslab() {
        return wageredpercnetslab;
    }

    public void setWageredpercnetslab(String wageredpercnetslab) {
        this.wageredpercnetslab = wageredpercnetslab;
    }

    public String getWageredslabmax() {
        return wageredslabmax;
    }

    public void setWageredslabmax(String wageredslabmax) {
        this.wageredslabmax = wageredslabmax;
    }

    public String getSlabotcpercentage() {
        return slabotcpercentage;
    }

    public void setSlabotcpercentage(String slabotcpercentage) {
        this.slabotcpercentage = slabotcpercentage;
    }

    public String getSlabotcmax() {
        return slabotcmax;
    }

    public void setSlabotcmax(String slabotcmax) {
        this.slabotcmax = slabotcmax;
    }
}

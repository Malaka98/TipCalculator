package com.example.tipcalculatorv0;

public class TipCalculator {
    private float tip;
    private float bill;
    private int ppl;

    public TipCalculator(float newTip, float newBill, int newPpl) {
        setTip(newTip);
        setBill(newBill);
        setPpl(newPpl);
    }

//    public float getTip() {
//        return tip;
//    }
//
//    public float getBill() {
//        return bill;
//    }
    public void setTip(float newTip) {
        if(newTip>0) {
            tip = newTip;
        }
    }
    public void setBill (float newBill) {
        if(newBill > 0) {
            bill = newBill;
        }
    }

    public void setPpl(int newPpl) {
       if(newPpl>0) {
           ppl = newPpl;
       }else {
           ppl = 1;
       }
    }

    public float tipAmount() {
        return bill * tip;
    }

    public float totalAmount() {
        return bill + tipAmount();
    }

    public float perPerson() {
        return totalAmount()/ppl;
    }

}

package com.test.testexample;

public class MOdelcalss_ticket {

    String code,ribbon_msg,max_value,max_percentage,min_slab,ratio_numerator,ratio_deniominator,bonus_expiry,valid_till;



    public MOdelcalss_ticket(String code, String ribbon_msg, String max_value, String max_percentage, String min_slab, String ratio_numerator, String ratio_deniominator, String bonus_expiry) {
        this.code = code;
        this.ribbon_msg = ribbon_msg;
        this.max_value = max_value;
        this.max_percentage = max_percentage;
        this.min_slab = min_slab;
        this.ratio_numerator = ratio_numerator;
        this.ratio_deniominator = ratio_deniominator;
        this.bonus_expiry = bonus_expiry;
    }

    public  MOdelcalss_ticket(){

    }
    public String getValid_till() {
        return valid_till;
    }

    public void setValid_till(String valid_till) {
        this.valid_till = valid_till;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRibbon_msg() {
        return ribbon_msg;
    }

    public void setRibbon_msg(String ribbon_msg) {
        this.ribbon_msg = ribbon_msg;
    }

    public String getMax_value() {
        return max_value;
    }

    public void setMax_value(String max_value) {
        this.max_value = max_value;
    }

    public String getMax_percentage() {
        return max_percentage;
    }

    public void setMax_percentage(String max_percentage) {
        this.max_percentage = max_percentage;
    }

    public String getMin_slab() {
        return min_slab;
    }

    public void setMin_slab(String min_slab) {
        this.min_slab = min_slab;
    }

    public String getRatio_numerator() {
        return ratio_numerator;
    }

    public void setRatio_numerator(String ratio_numerator) {
        this.ratio_numerator = ratio_numerator;
    }

    public String getRatio_deniominator() {
        return ratio_deniominator;
    }

    public void setRatio_deniominator(String ratio_deniominator) {
        this.ratio_deniominator = ratio_deniominator;
    }

    public String getBonus_expiry() {
        return bonus_expiry;
    }

    public void setBonus_expiry(String bonus_expiry) {
        this.bonus_expiry = bonus_expiry;
    }
}

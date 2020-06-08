package com.ciber.retoandroid_asier_iker;

import java.io.Serializable;

public class Allowance implements Serializable {

    private  int code;
    private String allowancename;
    private String allowancestartdate;
    private String allowanceenddate;
    private String allowancelocation;
    private String allowancetransport;
    private String allowancetravelleddistances;
    private String allowancetollamount;
    private String allowanceparkingamount;

    public Allowance() {
    }

    public Allowance(int code, String allowancename, String allowancestartdate, String allowanceenddate, String allowancelocation, String allowancetransport, String allowancetravelleddistances, String allowancetollamount, String allowanceparkingamount) {
        this.code = code;
        this.allowancename = allowancename;
        this.allowancestartdate = allowancestartdate;
        this.allowanceenddate = allowanceenddate;
        this.allowancelocation = allowancelocation;
        this.allowancetransport = allowancetransport;
        this.allowancetravelleddistances = allowancetravelleddistances;
        this.allowancetollamount = allowancetollamount;
        this.allowanceparkingamount = allowanceparkingamount;
    }

    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }

    public String getAllowancename() {
        return allowancename;
    }
    public void setAllowancename(String allowancename) {
        this.allowancename = allowancename;
    }

    public String getAllowancestartdate() {
        return allowancestartdate;
    }
    public void setAllowancestartdate(String allowancestartdate) { this.allowancestartdate = allowancestartdate; }

    public String getAllowanceenddate() {
        return allowanceenddate;
    }
    public void setAllowanceenddate(String allowanceenddate) { this.allowanceenddate = allowanceenddate; }

    public String getAllowancelocation() {
        return allowancelocation;
    }
    public void setAllowancelocation(String allowancelocation) { this.allowancelocation = allowancelocation; }

    public String getAllowancetransport() {
        return allowancetransport;
    }
    public void setAllowancetransport(String allowancetransport) { this.allowancetransport = allowancetransport; }

    public String getAllowancetravelleddistances() {
        return allowancetravelleddistances;
    }
    public void setAllowancetravelleddistances(String allowancetravelleddistances) { this.allowancetravelleddistances = allowancetravelleddistances; }

    public String getAllowancetollamount() {
        return allowancetollamount;
    }
    public void setAllowancetollamount(String allowancetollamount) { this.allowancetollamount = allowancetollamount; }

    public String getAllowanceparkingamount() {
        return allowanceparkingamount;
    }
    public void setAllowanceparkingamount(String allowanceparkingamount) { this.allowanceparkingamount = allowanceparkingamount; }
}

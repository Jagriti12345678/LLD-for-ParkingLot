package models;

public class Gate extends BaseModel{

    private GateType gateType;

    private int gateNumber;

    private GateStatus gateStatus;

    private Operator currOperator;

    public GateType getGateType() {
        return gateType;
    }

    public void setGateType(GateType gateType) {
        this.gateType = gateType;
    }

    public int getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(int gateNumber) {
        this.gateNumber = gateNumber;
    }

    public GateStatus getGateStatus() {
        return gateStatus;
    }

    public void setGateStatus(GateStatus gateStatus) {
        this.gateStatus = gateStatus;
    }

    public Operator getCurrOperator() {
        return currOperator;
    }

    public void setCurrOperator(Operator currOperator) {
        this.currOperator = currOperator;
    }
}

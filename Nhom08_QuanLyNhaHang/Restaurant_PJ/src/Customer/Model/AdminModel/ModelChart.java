package Customer.Model.AdminModel;

public class ModelChart {

    private String month;
    private double[] values;

    public ModelChart() {
    }

    public ModelChart(String month, double[] values) {
        this.month = month;
        this.values = values;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public double[] getValues() {
        return values;
    }

    public void setValues(double[] values) {
        this.values = values;
    }

}

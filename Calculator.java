package model;

public class Calculator extends Updater
{   
    double total;
    
    public Calculator()
    {
        this.total = total;
    }
    public void plus(double num1, double num2)
    {
        total = num1 + num2;
        updateViews();
    }
    public void minus(double num1, double num2)
    {
        total = num1 - num2;
        updateViews();
    }
    public void times(double num1, double num2)
    {
        total = num1 * num2;
        updateViews();
    }
     public void division(double num1, double num2)
    {
        total = num1 / num2;
        updateViews();
    }
    public double getTotal()
    {
        return total;
    }
}

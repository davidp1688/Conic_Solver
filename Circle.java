public class Circle extends Conic
{
    private double radius;
    /**
     * Constructor for objects of class Circle
     */
    public Circle(double [] co, double d, String cT)
    {
        // initialise instance variables
        super(co, d, cT);
        radius = 0;
        setRadius();
    }
    public void setRadius()
    {
        radius = Math.sqrt(Math.pow(getCenter()[0], 2) + Math.pow(getCenter()[1], 2) - getCoeff()[4]/getCoeff()[0]);
    }
    public double getRadius()
    {
        return radius;
    }
    public String toString()
    {
        String output = "";
        if(getCenter()[0] >= 0 && getCenter()[1] >= 0)
        {
            output = String.format("The Conic is a circle with equation: (x - %.2f)^2 + (y - %.2f)^2 = %.2f.\nIt is centered at the point (%.2f, %.2f).\nIt has a radius of %.2f", getCenter()[0], getCenter()[1], Math.pow(radius, 2), getCenter()[0], getCenter()[1], radius);
        }
        else if(getCenter()[0] < 0 && getCenter()[1] >= 0)
        {
            output = String.format("The Conic is a circle with equation: (x + %.2f)^2 + (y - %.2f)^2 = %.2f.\nIt is centered at the point (%.2f, %.2f).\nIt has a radius of %.2f", Math.abs(getCenter()[0]), getCenter()[1], Math.pow(radius, 2), getCenter()[0], getCenter()[1], radius);            
        }
        else if(getCenter()[0] >= 0 && getCenter()[1] < 0)
        {
            output = String.format("The Conic is a circle with equation: (x - %.2f)^2 + (y + %.2f)^2 = %.2f.\nIt is centered at the point (%.2f, %.2f).\nIt has a radius of %.2f", getCenter()[0], Math.abs(getCenter()[1]), Math.pow(radius, 2), getCenter()[0], getCenter()[1], radius);                        
        }
        else
        {
            output = String.format("The Conic is a circle with equation: (x + %.2f)^2 + (y + %.2f)^2 = %.2f.\nIt is centered at the point (%.2f, %.2f).\nIt has a radius of %.2f", Math.abs(getCenter()[0]), Math.abs(getCenter()[1]), Math.pow(radius, 2), getCenter()[0], getCenter()[1], radius);                        
        }
        return output;
    }
}

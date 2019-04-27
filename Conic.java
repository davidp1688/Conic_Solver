public class Conic
{
    private double [] coeff;
    private double discriminant;
    private String conicType;
    private double [] center;
    public Conic(double [] co, double d, String cT)
    {
        // initialise instance variables
        coeff = co;
        discriminant = d;
        conicType = cT;
        center = new double[2];
        setCenter();
    }
    public double [] getCoeff()
    {
        return coeff;
    }
    public void setCenter()
    {
        if(conicType.equals("Parabola"))
        {
            if(coeff[0] == 0)
            {
                center[0] = -coeff[4]/coeff[2] + Math.pow(coeff[3], 2)/(4*coeff[1]*coeff[2]);
                center[1] = -coeff[3]/(2*coeff[1]);
            }
            else
            {
                center[0] = -coeff[2]/(2*coeff[0]);
                center[1] = -coeff[4]/coeff[3] + Math.pow(coeff[2], 2)/(4*coeff[0]*coeff[3]);
            }
        }
        else
        {
            center[0] = -coeff[2]/(2*coeff[0]);
            center[1] = -coeff[3]/(2*coeff[1]);               
        }
    }
    public double [] getCenter()
    {
        return  center;
    }
}

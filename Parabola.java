public class Parabola extends Conic
{
    private double p, directrix;
    private double [] focus;
    public Parabola(double [] co, double d, String cT)
    {
        super(co, d , cT);
        p = 0;
        focus = new double[2];
        directrix = 0;
        setP();
        setFocus();
        setDirectrix();
    }
    public void setP()
    {
        if(getCoeff()[0] == 0)
        {
            p = -getCoeff()[2]/(4*getCoeff()[1]);
        }
        else
        {
            p = -getCoeff()[3]/(4*getCoeff()[0]);
        }
    }
    public double getP()
    {
        return p;
    }
    public void setFocus()
    {
        if(getCoeff()[0] == 0)
        {
            if(p > 0)
            {
                focus[0] = getCenter()[0] + p;
                focus[1] = getCenter()[1];
            }
            else
            {
                focus[0] = getCenter()[0] - p;
                focus[1] = getCenter()[1];
            }
        }
        else
        {
            if(p > 0)
            {
                focus[0] = getCenter()[0];
                focus[1] = getCenter()[1] + p;
            }
            else
            {
                focus[0] = getCenter()[0];
                focus[1] = getCenter()[1] - p;
            }
        }       
    }
    public double [] getFocus()
    {
        return focus;
    }
    public void setDirectrix()
    {
        if(getCoeff()[0] == 0)
        {
            if(p > 0)
            {
                directrix = getCenter()[0] - p;
            }
            else
            {
                directrix = getCenter()[0] + p;
            }
        }
        else
        {
            if(p > 0)
            {
                directrix = getCenter()[1] - p;
            }
            else
            {
                directrix = getCenter()[1] + p;
            }
        }
    }
    public double getDirectrix()
    {
        return directrix;
    }
    public String toString()
    {
        String output = "";
        if(getCoeff()[0] == 0)
        {
            if(getCenter()[0] >= 0 && getCenter()[1] >= 0)
            {
                output = String.format("The Conic is a parabola with equation: (y - %.2f)^2 = %.2f(x - %.2f).\nThe vertex is at the point (%.2f, %.2f).\nThe focus is located at the point (%.2f, %.2f).\nThe directrix has the equation: x = %.2f", getCenter()[1], 4*p, getCenter()[0], getCenter()[0], getCenter()[1], focus[0], focus[1], directrix); 
            }
            else if(getCenter()[0] >= 0 && getCenter()[1] < 0)
            {
                output = String.format("The Conic is a parabola with equation: (y + %.2f)^2 = %.2f(x - %.2f).\nThe vertex is at the point (%.2f, %.2f).\nThe focus is located at the point (%.2f, %.2f).\nThe directrix has the equation: x = %.2f", Math.abs(getCenter()[1]), 4*p, getCenter()[0], getCenter()[0], getCenter()[1], focus[0], focus[1], directrix);                 
            }
            else if(getCenter()[0] < 0 && getCenter()[1] >= 0)
            {
                output = String.format("The Conic is a parabola with equation: (y - %.2f)^2 = %.2f(x + %.2f).\nThe vertex is at the point (%.2f, %.2f).\nThe focus is located at the point (%.2f, %.2f).\nThe directrix has the equation: x = %.2f", getCenter()[1], 4*p, Math.abs(getCenter()[0]), getCenter()[0], getCenter()[1], focus[0], focus[1], directrix); 
            }
            else
            {
                output = String.format("The Conic is a parabola with equation: (y + %.2f)^2 = %.2f(x + %.2f).\nThe vertex is at the point (%.2f, %.2f).\nThe focus is located at the point (%.2f, %.2f).\nThe directrix has the equation: x = %.2f", Math.abs(getCenter()[1]), 4*p, Math.abs(getCenter()[0]), getCenter()[0], getCenter()[1], focus[0], focus[1], directrix); 
            }
        }
        else
        {
            if(getCenter()[0] >= 0 && getCenter()[1] >= 0)
            {
                output = String.format("The Conic is a parabola with equation: (x - %.2f)^2 = %.2f(y - %.2f).\nThe vertex is at the point (%.2f, %.2f).\nThe focus is located at the point (%.2f, %.2f).\nThe directrix has the equation: y = %.2f", getCenter()[0], 4*p, getCenter()[1], getCenter()[0], getCenter()[1], focus[0], focus[1], directrix); 
            }
            else if(getCenter()[0] >= 0 && getCenter()[1] < 0)
            {
                output = String.format("The Conic is a parabola with equation: (x - %.2f)^2 = %.2f(y + %.2f).\nThe vertex is at the point (%.2f, %.2f).\nThe focus is located at the point (%.2f, %.2f).\nThe directrix has the equation: y = %.2f", getCenter()[0], 4*p, Math.abs(getCenter()[1]), getCenter()[0], getCenter()[1], focus[0], focus[1], directrix);                 
            }
            else if(getCenter()[0] < 0 && getCenter()[1] >= 0)
            {
                output = String.format("The Conic is a parabola with equation: (x + %.2f)^2 = %.2f(y - %.2f).\nThe vertex is at the point (%.2f, %.2f).\nThe focus is located at the point (%.2f, %.2f).\nThe directrix has the equation: y = %.2f", Math.abs(getCenter()[0]), 4*p, getCenter()[1], getCenter()[0], getCenter()[1], focus[0], focus[1], directrix); 
            }
            else
            {
                output = String.format("The Conic is a parabola with equation: (x + %.2f)^2 = %.2f(y + %.2f).\nThe vertex is at the point (%.2f, %.2f).\nThe focus is located at the point (%.2f, %.2f).\nThe directrix has the equation: y = %.2f", Math.abs(getCenter()[0]), 4*p, Math.abs(getCenter()[1]), getCenter()[0], getCenter()[1], focus[0], focus[1], directrix); 
            }
        }
        return output;
    }
}

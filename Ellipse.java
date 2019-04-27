public class Ellipse extends Conic
{
    private double a, b, c, area, maAxis, miAxis;
    private double [][] foci, vertices;
    public Ellipse(double [] co, double d, String cT)
    {
        // initialise instance variables
        super(co, d, cT);
        a = 0;
        b = 0;
        c = 0;
        area = 0;
        maAxis = 0;
        miAxis = 0;
        foci = new double[2][2];
        vertices = new double[4][2];
        setRadii();
        setFoci();
        setAxes();
        setArea();
        setVertices();
    }    
    public void setRadii()
    {
        a = Math.sqrt((getCoeff()[0]*Math.pow(getCenter()[0], 2) + getCoeff()[1]*Math.pow(getCenter()[1], 2) - getCoeff()[4])/getCoeff()[0]);
        b = Math.sqrt((getCoeff()[0]*Math.pow(getCenter()[0], 2) + getCoeff()[1]*Math.pow(getCenter()[1], 2) - getCoeff()[4])/getCoeff()[1]);
    }
    public double getA()
    {
        return a; 
    }
    public double getB()
    {
        return b;
    }
    public void setAxes()
    {
        if(a > b)
        {
            maAxis = a;
            miAxis = b;
        }
        else
        {
            maAxis = b;
            miAxis = a;
        }
    }
    public double getMaAxis()
    {
        return maAxis;
    }    
    public double getMiAxis()
    {
        return miAxis;
    }
    public void setFoci()
    {
        c = Math.sqrt(Math.abs(Math.pow(a, 2) - Math.pow(b, 2)));
        if(maAxis == a)
        {
            foci[0][0] = getCenter()[0] + c;
            foci[0][1] = getCenter()[1];
            foci[1][0] = getCenter()[0] - c;
            foci[1][1] = getCenter()[1];
        }
        else        
        {
            foci[0][0] = getCenter()[0];
            foci[0][1] = getCenter()[1] + c;
            foci[1][0] = getCenter()[0];
            foci[1][1] = getCenter()[1] - c;
        }
    }
    public double [][] getFoci()
    {
        return foci;
    }
    public void setVertices()
    {
        vertices[0][0] = getCenter()[0] + a;
        vertices[0][1] = getCenter()[1];
        vertices[1][0] = getCenter()[0] - a;
        vertices[1][1] = getCenter()[1];
        vertices[2][0] = getCenter()[0];
        vertices[2][1] = getCenter()[1] + b;
        vertices[3][0] = getCenter()[0];
        vertices[3][1] = getCenter()[1] - b;
    }
    public double [][] getVertices()
    {
        return vertices;
    }
    public void setArea()
    {
        area = a*b*Math.PI;
    }
    public double getArea()
    {
        return area;
    }
    public String toString()
    {
        String output = "";
        if(getCenter()[0] >= 0 && getCenter()[1] >= 0)
        {
            output = String.format("The Conic is an ellipse with equation: (x - %.2f)^2/%.2f + (y - %.2f)^2/%.2f = 1.\nIt is centered at the point (%.2f, %.2f).\nIt has a major axis of length %.2f\nIt has a minor axis of length %.2f\nIt has foci at the points(%.2f, %.2f) and (%.2f, %.2f)\nIt has an area of %.2f\nIt has vertices at (%.2f, %.2f), (%.2f, %.2f), (%.2f, %.2f), and (%.2f, %.2f)", getCenter()[0], Math.pow(a, 2), getCenter()[1], Math.pow(b, 2), getCenter()[0], getCenter()[1], 2*maAxis, 2*miAxis, foci[0][0],foci[0][1], foci[1][0], foci[1][1], area, vertices[0][0], vertices[0][1], vertices[1][0], vertices[1][1], vertices[2][0], vertices[2][1], vertices[3][0], vertices[3][1]);
        }
        else if(getCenter()[0] < 0 && getCenter()[1] >= 0)
        {
            output = String.format("The Conic is an ellipse with equation: (x +%.2f)^2/%.2f + (y - %.2f)^2/%.2f = 1.\nIt is centered at the point (%.2f, %.2f).\nIt has a major axis of length %.2f\nIt has a minor axis of length %.2f\nIt has foci at the points(%.2f, %.2f) and (%.2f, %.2f)\nIt has an area of %.2f\nIt has vertices at (%.2f, %.2f), (%.2f, %.2f), (%.2f, %.2f), and (%.2f, %.2f)", Math.abs(getCenter()[0]), Math.pow(a, 2), getCenter()[1], Math.pow(b, 2), getCenter()[0], getCenter()[1], 2*maAxis, 2*miAxis, foci[0][0],foci[0][1], foci[1][0], foci[1][1], area, vertices[0][0], vertices[0][1], vertices[1][0], vertices[1][1], vertices[2][0], vertices[2][1], vertices[3][0], vertices[3][1]);
        }
        else if(getCenter()[0] >= 0 && getCenter()[1] < 0)
        {
            output = String.format("The Conic is an ellipse with equation: (x - %.2f)^2/%.2f + (y + %.2f)^2/%.2f = 1.\nIt is centered at the point (%.2f, %.2f).\nIt has a major axis of length %.2f\nIt has a minor axis of length %.2f\nIt has foci at the points(%.2f, %.2f) and (%.2f, %.2f)\nIt has an area of %.2f\nIt has vertices at (%.2f, %.2f), (%.2f, %.2f), (%.2f, %.2f), and (%.2f, %.2f)", getCenter()[0], Math.pow(a, 2), Math.abs(getCenter()[1]), Math.pow(b, 2), getCenter()[0], getCenter()[1], 2*maAxis, 2*miAxis, foci[0][0],foci[0][1], foci[1][0], foci[1][1], area, vertices[0][0], vertices[0][1], vertices[1][0], vertices[1][1], vertices[2][0], vertices[2][1], vertices[3][0], vertices[3][1]);
        }
        else
        {
            output = String.format("The Conic is an ellipse with equation: (x + %.2f)^2/%.2f + (y + %.2f)^2/%.2f = 1.\nIt is centered at the point (%.2f, %.2f).\nIt has a major axis of length %.2f\nIt has a minor axis of length %.2f\nIt has foci at the points(%.2f, %.2f) and (%.2f, %.2f)\nIt has an area of %.2f\nIt has vertices at (%.2f, %.2f), (%.2f, %.2f), (%.2f, %.2f), and (%.2f, %.2f)", Math.abs(getCenter()[0]), Math.pow(a, 2), Math.abs(getCenter()[1]), Math.pow(b, 2), getCenter()[0], getCenter()[1], 2*maAxis, 2*miAxis, foci[0][0],foci[0][1], foci[1][0], foci[1][1], area, vertices[0][0], vertices[0][1], vertices[1][0], vertices[1][1], vertices[2][0], vertices[2][1], vertices[3][0], vertices[3][1]);
        }
        return output;
    }
    
}

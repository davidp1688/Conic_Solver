public class Hyperbola extends Conic
{
    private double a, b, c, tAxis, cAxis;
    private double [][] foci, asy, vertices;
    public Hyperbola(double [] co, double d, String cT)
    {
        // initialise instance variables
        super(co, d, cT);
        a = 0;
        b = 0;
        c = 0;
        tAxis = 0;
        cAxis = 0;
        foci = new double[2][2];
        asy = new double[2][2];
        vertices = new double[2][2];
        setRadii();
        setAxes();
        setFoci();
        setAsymptotes();
        setVertices();
    }
    public void setRadii()
    {
        a = Math.sqrt(Math.abs((getCoeff()[0]*Math.pow(getCenter()[0], 2) + getCoeff()[1]*Math.pow(getCenter()[1], 2) - getCoeff()[4])/getCoeff()[0]));
        b = Math.sqrt(Math.abs((getCoeff()[0]*Math.pow(getCenter()[0], 2) + getCoeff()[1]*Math.pow(getCenter()[1], 2) - getCoeff()[4])/getCoeff()[1]));
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
        if(getCoeff()[0] < 0)
        {
            if(getCoeff()[0]*Math.pow(getCenter()[0], 2) + getCoeff()[1]*Math.pow(getCenter()[1], 2) > 0)
            {
                tAxis = a;
                cAxis = b;
            }
            else
            {
                tAxis = b;
                cAxis = a;
            }
        }
        else
        {
            if(getCoeff()[0]*Math.pow(getCenter()[0], 2) + getCoeff()[1]*Math.pow(getCenter()[1], 2) > 0)
            {
                tAxis = a;
                cAxis = b;
            }
            else
            {
                tAxis = b;
                cAxis = a;
            }
        }
    }
    public double getTAxis()
    {
        return  tAxis;
    }
    public double getCAxis()
    {
        return cAxis;
    }
    public void setFoci()    
    {
        c = Math.sqrt(Math.abs(Math.pow(a, 2) + Math.pow(b, 2)));
        if(tAxis == a)
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
    public void setAsymptotes()
    {
        asy[0][0] = b/a;
        asy[0][1] = getCenter()[1] - b*getCenter()[0]/a;
        asy[1][0] = -b/a;
        asy[1][1] = getCenter()[1] + b*getCenter()[0]/a;
    }
    public double [][] getAsymptotes()
    {
        return asy;
    }
    public void setVertices()
    {
        if(tAxis == a)
        {
            vertices[0][0] = getCenter()[0] + a;
            vertices[0][0] = getCenter()[1];
            vertices[1][0] = getCenter()[0] - a;
            vertices[1][1] = getCenter()[1];
        }
        else
        {
            vertices[0][0] = getCenter()[0];
            vertices[0][0] = getCenter()[1] + b;
            vertices[1][0] = getCenter()[0];
            vertices[1][1] = getCenter()[1] - b;
        }
    }
    public double [][] getVertices()
    {
        return vertices;
    }
    public String toString()
    {
        String output = "";
        if(tAxis == a)
        {
            if(getCenter()[0] >= 0 && getCenter()[1] >= 0)
            {
                if(vertices[0][1] >= 0 && vertices[1][1] >= 0)
                {
                    output = String.format("The Conic is a hyperbola with equation: (x - %.2f)^2/%.2f - (y - %.2f)^2/%.2f = 1.\nIt is centered at the point (%.2f, %.2f).\nIt has a transverse axis of length %.2f\nIt has a  conjugate axis of length %.2f\nIt has foci at the points(%.2f, %.2f) and (%.2f, %.2f)\nIt has vertices at (%.2f, %.2f) and (%.2f, %.2f)\nIt has asymptotes with equations: y = %.2fx + %.2f and y = %.2fx + %.2f", getCenter()[0], Math.pow(tAxis, 2), getCenter()[1], Math.pow(cAxis, 2), getCenter()[0], getCenter()[1], 2*tAxis, 2*cAxis, foci[0][0],foci[0][1], foci[1][0], foci[1][1], vertices[0][0], vertices[0][1], vertices[1][0], vertices[1][1], asy[0][0], asy[0][1], asy[1][0], asy[1][1]);                
                }
                else if(vertices[0][1] >= 0 && vertices[1][1] < 0)
                {
                    output = String.format("The Conic is a hyperbola with equation: (x - %.2f)^2/%.2f - (y - %.2f)^2/%.2f = 1.\nIt is centered at the point (%.2f, %.2f).\nIt has a transverse axis of length %.2f\nIt has a  conjugate axis of length %.2f\nIt has foci at the points(%.2f, %.2f) and (%.2f, %.2f)\nIt has vertices at (%.2f, %.2f) and (%.2f, %.2f)\nIt has asymptotes with equations: y = %.2fx + %.2f and y = %.2fx - %.2f", getCenter()[0], Math.pow(tAxis, 2), getCenter()[1], Math.pow(cAxis, 2), getCenter()[0], getCenter()[1], 2*tAxis, 2*cAxis, foci[0][0],foci[0][1], foci[1][0], foci[1][1], vertices[0][0], vertices[0][1], vertices[1][0], vertices[1][1], asy[0][0], asy[0][1], asy[1][0], Math.abs(asy[1][1]));
                }
                else if(vertices[0][1] < 0 && vertices[1][1] >= 0)
                {
                    output = String.format("The Conic is a hyperbola with equation: (x - %.2f)^2/%.2f - (y - %.2f)^2/%.2f = 1.\nIt is centered at the point (%.2f, %.2f).\nIt has a transverse axis of length %.2f\nIt has a  conjugate axis of length %.2f\nIt has foci at the points(%.2f, %.2f) and (%.2f, %.2f)\nIt has vertices at (%.2f, %.2f) and (%.2f, %.2f)\nIt has asymptotes with equations: y = %.2fx - %.2f and y = %.2fx + %.2f", getCenter()[0], Math.pow(tAxis, 2), getCenter()[1], Math.pow(cAxis, 2), getCenter()[0], getCenter()[1], 2*tAxis, 2*cAxis, foci[0][0],foci[0][1], foci[1][0], foci[1][1], vertices[0][0], vertices[0][1], vertices[1][0], vertices[1][1], asy[0][0], Math.abs(asy[0][1]), asy[1][0], asy[1][1]);
                }
                else
                {
                    output = String.format("The Conic is a hyperbola with equation: (x - %.2f)^2/%.2f - (y - %.2f)^2/%.2f = 1.\nIt is centered at the point (%.2f, %.2f).\nIt has a transverse axis of length %.2f\nIt has a  conjugate axis of length %.2f\nIt has foci at the points(%.2f, %.2f) and (%.2f, %.2f)\nIt has vertices at (%.2f, %.2f) and (%.2f, %.2f)\nIt has asymptotes with equations: y = %.2fx - %.2f and y = %.2fx - %.2f", getCenter()[0], Math.pow(tAxis, 2), getCenter()[1], Math.pow(cAxis, 2), getCenter()[0], getCenter()[1], 2*tAxis, 2*cAxis, foci[0][0],foci[0][1], foci[1][0], foci[1][1], vertices[0][0], vertices[0][1], vertices[1][0], vertices[1][1], asy[0][0], Math.abs(asy[0][1]), asy[1][0], Math.abs(asy[1][1]));
                }
            }
            else if(getCenter()[0] >= 0 && getCenter()[1] < 0)
            {
                if(vertices[0][1] >= 0 && vertices[1][1] >= 0)
                {
                    output = String.format("The Conic is a hyperbola with equation: (x - %.2f)^2/%.2f - (y + %.2f)^2/%.2f = 1.\nIt is centered at the point (%.2f, %.2f).\nIt has a transverse axis of length %.2f\nIt has a  conjugate axis of length %.2f\nIt has foci at the points(%.2f, %.2f) and (%.2f, %.2f)\nIt has vertices at (%.2f, %.2f) and (%.2f, %.2f)\nIt has asymptotes with equations: y = %.2fx + %.2f and y = %.2fx + %.2f", getCenter()[0], Math.pow(tAxis, 2), Math.abs(getCenter()[1]), Math.pow(cAxis, 2), getCenter()[0], getCenter()[1], 2*tAxis, 2*cAxis, foci[0][0],foci[0][1], foci[1][0], foci[1][1], vertices[0][0], vertices[0][1], vertices[1][0], vertices[1][1], asy[0][0], asy[0][1], asy[1][0], asy[1][1]);                
                }
                else if(vertices[0][1] >= 0 && vertices[1][1] < 0)
                {
                    output = String.format("The Conic is a hyperbola with equation: (x - %.2f)^2/%.2f - (y + %.2f)^2/%.2f = 1.\nIt is centered at the point (%.2f, %.2f).\nIt has a transverse axis of length %.2f\nIt has a  conjugate axis of length %.2f\nIt has foci at the points(%.2f, %.2f) and (%.2f, %.2f)\nIt has vertices at (%.2f, %.2f) and (%.2f, %.2f)\nIt has asymptotes with equations: y = %.2fx + %.2f and y = %.2fx - %.2f", getCenter()[0], Math.pow(tAxis, 2), Math.abs(getCenter()[1]), Math.pow(cAxis, 2), getCenter()[0], getCenter()[1], 2*tAxis, 2*cAxis, foci[0][0],foci[0][1], foci[1][0], foci[1][1], vertices[0][0], vertices[0][1], vertices[1][0], vertices[1][1], asy[0][0], asy[0][1], asy[1][0], Math.abs(asy[1][1]));
                }
                else if(vertices[0][1] < 0 && vertices[1][1] >= 0)
                {
                    output = String.format("The Conic is a hyperbola with equation: (x - %.2f)^2/%.2f - (y + %.2f)^2/%.2f = 1.\nIt is centered at the point (%.2f, %.2f).\nIt has a transverse axis of length %.2f\nIt has a  conjugate axis of length %.2f\nIt has foci at the points(%.2f, %.2f) and (%.2f, %.2f)\nIt has vertices at (%.2f, %.2f) and (%.2f, %.2f)\nIt has asymptotes with equations: y = %.2fx - %.2f and y = %.2fx + %.2f", getCenter()[0], Math.pow(tAxis, 2), Math.abs(getCenter()[1]), Math.pow(cAxis, 2), getCenter()[0], getCenter()[1], 2*tAxis, 2*cAxis, foci[0][0],foci[0][1], foci[1][0], foci[1][1], vertices[0][0], vertices[0][1], vertices[1][0], vertices[1][1], asy[0][0], Math.abs(asy[0][1]), asy[1][0], asy[1][1]);
                }
                else
                {
                    output = String.format("The Conic is a hyperbola with equation: (x - %.2f)^2/%.2f - (y + %.2f)^2/%.2f = 1.\nIt is centered at the point (%.2f, %.2f).\nIt has a transverse axis of length %.2f\nIt has a  conjugate axis of length %.2f\nIt has foci at the points(%.2f, %.2f) and (%.2f, %.2f)\nIt has vertices at (%.2f, %.2f) and (%.2f, %.2f)\nIt has asymptotes with equations: y = %.2fx - %.2f and y = %.2fx - %.2f", getCenter()[0], Math.pow(tAxis, 2), Math.abs(getCenter()[1]), Math.pow(cAxis, 2), getCenter()[0], getCenter()[1], 2*tAxis, 2*cAxis, foci[0][0],foci[0][1], foci[1][0], foci[1][1], vertices[0][0], vertices[0][1], vertices[1][0], vertices[1][1], asy[0][0], Math.abs(asy[0][1]), asy[1][0], Math.abs(asy[1][1]));
                }
            }
            else if(getCenter()[0] < 0 && getCenter()[1] >= 0)
            {
                if(vertices[0][1] >= 0 && vertices[1][1] >= 0)
                {
                    output = String.format("The Conic is a hyperbola with equation: (x + %.2f)^2/%.2f - (y - %.2f)^2/%.2f = 1.\nIt is centered at the point (%.2f, %.2f).\nIt has a transverse axis of length %.2f\nIt has a  conjugate axis of length %.2f\nIt has foci at the points(%.2f, %.2f) and (%.2f, %.2f)\nIt has vertices at (%.2f, %.2f) and (%.2f, %.2f)\nIt has asymptotes with equations: y = %.2fx + %.2f and y = %.2fx + %.2f", Math.abs(getCenter()[0]), Math.pow(tAxis, 2), getCenter()[1], Math.pow(cAxis, 2), getCenter()[0], getCenter()[1], 2*tAxis, 2*cAxis, foci[0][0],foci[0][1], foci[1][0], foci[1][1], vertices[0][0], vertices[0][1], vertices[1][0], vertices[1][1], asy[0][0], asy[0][1], asy[1][0], asy[1][1]);                
                }
                else if(vertices[0][1] >= 0 && vertices[1][1] < 0)
                {
                    output = String.format("The Conic is a hyperbola with equation: (x + %.2f)^2/%.2f - (y - %.2f)^2/%.2f = 1.\nIt is centered at the point (%.2f, %.2f).\nIt has a transverse axis of length %.2f\nIt has a  conjugate axis of length %.2f\nIt has foci at the points(%.2f, %.2f) and (%.2f, %.2f)\nIt has vertices at (%.2f, %.2f) and (%.2f, %.2f)\nIt has asymptotes with equations: y = %.2fx + %.2f and y = %.2fx - %.2f", Math.abs(getCenter()[0]), Math.pow(tAxis, 2), getCenter()[1], Math.pow(cAxis, 2), getCenter()[0], getCenter()[1], 2*tAxis, 2*cAxis, foci[0][0],foci[0][1], foci[1][0], foci[1][1], vertices[0][0], vertices[0][1], vertices[1][0], vertices[1][1], asy[0][0], asy[0][1], asy[1][0], Math.abs(asy[1][1]));
                }
                else if(vertices[0][1] < 0 && vertices[1][1] >= 0)
                {
                    output = String.format("The Conic is a hyperbola with equation: (x + %.2f)^2/%.2f - (y - %.2f)^2/%.2f = 1.\nIt is centered at the point (%.2f, %.2f).\nIt has a transverse axis of length %.2f\nIt has a  conjugate axis of length %.2f\nIt has foci at the points(%.2f, %.2f) and (%.2f, %.2f)\nIt has vertices at (%.2f, %.2f) and (%.2f, %.2f)\nIt has asymptotes with equations: y = %.2fx - %.2f and y = %.2fx + %.2f", Math.abs(getCenter()[0]), Math.pow(tAxis, 2), getCenter()[1], Math.pow(cAxis, 2), getCenter()[0], getCenter()[1], 2*tAxis, 2*cAxis, foci[0][0],foci[0][1], foci[1][0], foci[1][1], vertices[0][0], vertices[0][1], vertices[1][0], vertices[1][1], asy[0][0], Math.abs(asy[0][1]), asy[1][0], asy[1][1]);
                }
                else
                {
                    output = String.format("The Conic is a hyperbola with equation: (x + %.2f)^2/%.2f - (y - %.2f)^2/%.2f = 1.\nIt is centered at the point (%.2f, %.2f).\nIt has a transverse axis of length %.2f\nIt has a  conjugate axis of length %.2f\nIt has foci at the points(%.2f, %.2f) and (%.2f, %.2f)\nIt has vertices at (%.2f, %.2f) and (%.2f, %.2f)\nIt has asymptotes with equations: y = %.2fx - %.2f and y = %.2fx - %.2f", Math.abs(getCenter()[0]), Math.pow(tAxis, 2), getCenter()[1], Math.pow(cAxis, 2), getCenter()[0], getCenter()[1], 2*tAxis, 2*cAxis, foci[0][0],foci[0][1], foci[1][0], foci[1][1], vertices[0][0], vertices[0][1], vertices[1][0], vertices[1][1], asy[0][0], Math.abs(asy[0][1]), asy[1][0], Math.abs(asy[1][1]));
                }
            }
            else
            {
                if(vertices[0][1] >= 0 && vertices[1][1] >= 0)
                {
                    output = String.format("The Conic is a hyperbola with equation: (x + %.2f)^2/%.2f - (y + %.2f)^2/%.2f = 1.\nIt is centered at the point (%.2f, %.2f).\nIt has a transverse axis of length %.2f\nIt has a  conjugate axis of length %.2f\nIt has foci at the points(%.2f, %.2f) and (%.2f, %.2f)\nIt has vertices at (%.2f, %.2f) and (%.2f, %.2f)\nIt has asymptotes with equations: y = %.2fx + %.2f and y = %.2fx + %.2f", Math.abs(getCenter()[0]), Math.pow(tAxis, 2), Math.abs(getCenter()[1]), Math.pow(cAxis, 2), getCenter()[0], getCenter()[1], 2*tAxis, 2*cAxis, foci[0][0],foci[0][1], foci[1][0], foci[1][1], vertices[0][0], vertices[0][1], vertices[1][0], vertices[1][1], asy[0][0], asy[0][1], asy[1][0], asy[1][1]);                
                }
                else if(vertices[0][1] >= 0 && vertices[1][1] < 0)
                {
                    output = String.format("The Conic is a hyperbola with equation: (x + %.2f)^2/%.2f - (y + %.2f)^2/%.2f = 1.\nIt is centered at the point (%.2f, %.2f).\nIt has a transverse axis of length %.2f\nIt has a  conjugate axis of length %.2f\nIt has foci at the points(%.2f, %.2f) and (%.2f, %.2f)\nIt has vertices at (%.2f, %.2f) and (%.2f, %.2f)\nIt has asymptotes with equations: y = %.2fx + %.2f and y = %.2fx - %.2f", Math.abs(getCenter()[0]), Math.pow(tAxis, 2), Math.abs(getCenter()[1]), Math.pow(cAxis, 2), getCenter()[0], getCenter()[1], 2*tAxis, 2*cAxis, foci[0][0],foci[0][1], foci[1][0], foci[1][1], vertices[0][0], vertices[0][1], vertices[1][0], vertices[1][1], asy[0][0], asy[0][1], asy[1][0], Math.abs(asy[1][1]));
                }
                else if(vertices[0][1] < 0 && vertices[1][1] >= 0)
                {
                    output = String.format("The Conic is a hyperbola with equation: (x + %.2f)^2/%.2f - (y + %.2f)^2/%.2f = 1.\nIt is centered at the point (%.2f, %.2f).\nIt has a transverse axis of length %.2f\nIt has a  conjugate axis of length %.2f\nIt has foci at the points(%.2f, %.2f) and (%.2f, %.2f)\nIt has vertices at (%.2f, %.2f) and (%.2f, %.2f)\nIt has asymptotes with equations: y = %.2fx - %.2f and y = %.2fx + %.2f", Math.abs(getCenter()[0]), Math.pow(tAxis, 2), Math.abs(getCenter()[1]), Math.pow(cAxis, 2), getCenter()[0], getCenter()[1], 2*tAxis, 2*cAxis, foci[0][0],foci[0][1], foci[1][0], foci[1][1], vertices[0][0], vertices[0][1], vertices[1][0], vertices[1][1], asy[0][0], Math.abs(asy[0][1]), asy[1][0], asy[1][1]);
                }
                else
                {
                    output = String.format("The Conic is a hyperbola with equation: (x + %.2f)^2/%.2f - (y + %.2f)^2/%.2f = 1.\nIt is centered at the point (%.2f, %.2f).\nIt has a transverse axis of length %.2f\nIt has a  conjugate axis of length %.2f\nIt has foci at the points(%.2f, %.2f) and (%.2f, %.2f)\nIt has vertices at (%.2f, %.2f) and (%.2f, %.2f)\nIt has asymptotes with equations: y = %.2fx - %.2f and y = %.2fx - %.2f", Math.abs(getCenter()[0]), Math.pow(tAxis, 2), Math.abs(getCenter()[1]), Math.pow(cAxis, 2), getCenter()[0], getCenter()[1], 2*tAxis, 2*cAxis, foci[0][0],foci[0][1], foci[1][0], foci[1][1], vertices[0][0], vertices[0][1], vertices[1][0], vertices[1][1], asy[0][0], Math.abs(asy[0][1]), asy[1][0], Math.abs(asy[1][1]));
                }
            }
        }
        else
        {
            if(getCenter()[0] >= 0 && getCenter()[1] >= 0)
            {
                if(vertices[0][1] >= 0 && vertices[1][1] >= 0)
                {
                    output = String.format("The Conic is a hyperbola with equation: (y - %.2f)^2/%.2f - (x - %.2f)^2/%.2f = 1.\nIt is centered at the point (%.2f, %.2f).\nIt has a transverse axis of length %.2f\nIt has a  conjugate axis of length %.2f\nIt has foci at the points(%.2f, %.2f) and (%.2f, %.2f)\nIt has vertices at (%.2f, %.2f) and (%.2f, %.2f)\nIt has asymptotes with equations: y = %.2fx + %.2f and y = %.2fx + %.2f", getCenter()[1], Math.pow(tAxis, 2), getCenter()[0], Math.pow(cAxis, 2), getCenter()[0], getCenter()[1], 2*tAxis, 2*cAxis, foci[0][0],foci[0][1], foci[1][0], foci[1][1], vertices[0][0], vertices[0][1], vertices[1][0], vertices[1][1], asy[0][0], asy[0][1], asy[1][0], asy[1][1]);                
                } 
                else if(vertices[0][1] >= 0 && vertices[1][1] < 0)
                {
                    output = String.format("The Conic is a hyperbola with equation: (y - %.2f)^2/%.2f - (x - %.2f)^2/%.2f = 1.\nIt is centered at the point (%.2f, %.2f).\nIt has a transverse axis of length %.2f\nIt has a  conjugate axis of length %.2f\nIt has foci at the points(%.2f, %.2f) and (%.2f, %.2f)\nIt has vertices at (%.2f, %.2f) and (%.2f, %.2f)\nIt has asymptotes with equations: y = %.2fx + %.2f and y = %.2fx - %.2f", getCenter()[1], Math.pow(tAxis, 2), getCenter()[0], Math.pow(cAxis, 2), getCenter()[0], getCenter()[1], 2*tAxis, 2*cAxis, foci[0][0],foci[0][1], foci[1][0], foci[1][1], vertices[0][0], vertices[0][1], vertices[1][0], vertices[1][1], asy[0][0], asy[0][1], asy[1][0], Math.abs(asy[1][1]));
                }
                else if(vertices[0][1] < 0 && vertices[1][1] >= 0)
                {
                    output = String.format("The Conic is a hyperbola with equation: (y - %.2f)^2/%.2f - (x - %.2f)^2/%.2f = 1.\nIt is centered at the point (%.2f, %.2f).\nIt has a transverse axis of length %.2f\nIt has a  conjugate axis of length %.2f\nIt has foci at the points(%.2f, %.2f) and (%.2f, %.2f)\nIt has vertices at (%.2f, %.2f) and (%.2f, %.2f)\nIt has asymptotes with equations: y = %.2fx - %.2f and y = %.2fx + %.2f", getCenter()[1], Math.pow(tAxis, 2), getCenter()[0], Math.pow(cAxis, 2), getCenter()[0], getCenter()[1], 2*tAxis, 2*cAxis, foci[0][0],foci[0][1], foci[1][0], foci[1][1], vertices[0][0], vertices[0][1], vertices[1][0], vertices[1][1], asy[0][0], Math.abs(asy[0][1]), asy[1][0], asy[1][1]);
                }
                else
                {
                    output = String.format("The Conic is a hyperbola with equation: (y - %.2f)^2/%.2f - (x - %.2f)^2/%.2f = 1.\nIt is centered at the point (%.2f, %.2f).\nIt has a transverse axis of length %.2f\nIt has a  conjugate axis of length %.2f\nIt has foci at the points(%.2f, %.2f) and (%.2f, %.2f)\nIt has vertices at (%.2f, %.2f) and (%.2f, %.2f)\nIt has asymptotes with equations: y = %.2fx - %.2f and y = %.2fx - %.2f", getCenter()[1], Math.pow(tAxis, 2), getCenter()[0], Math.pow(cAxis, 2), getCenter()[0], getCenter()[1], 2*tAxis, 2*cAxis, foci[0][0],foci[0][1], foci[1][0], foci[1][1], vertices[0][0], vertices[0][1], vertices[1][0], vertices[1][1], asy[0][0], Math.abs(asy[0][1]), asy[1][0], Math.abs(asy[1][1]));
                }
            }
            else if(getCenter()[0] >= 0 && getCenter()[1] < 0)
            {
                if(vertices[0][1] >= 0 && vertices[1][1] >= 0)
                {
                    output = String.format("The Conic is a hyperbola with equation: (y + %.2f)^2/%.2f - (x - %.2f)^2/%.2f = 1.\nIt is centered at the point (%.2f, %.2f).\nIt has a transverse axis of length %.2f\nIt has a  conjugate axis of length %.2f\nIt has foci at the points(%.2f, %.2f) and (%.2f, %.2f)\nIt has vertices at (%.2f, %.2f) and (%.2f, %.2f)\nIt has asymptotes with equations: y = %.2fx + %.2f and y = %.2fx + %.2f", getCenter()[1], Math.pow(tAxis, 2), Math.abs(getCenter()[0]), Math.pow(cAxis, 2), getCenter()[0], getCenter()[1], 2*tAxis, 2*cAxis, foci[0][0],foci[0][1], foci[1][0], foci[1][1], vertices[0][0], vertices[0][1], vertices[1][0], vertices[1][1], asy[0][0], asy[0][1], asy[1][0], asy[1][1]);                
                }
                else if(vertices[0][1] >= 0 && vertices[1][1] < 0)
                {
                    output = String.format("The Conic is a hyperbola with equation: (y + %.2f)^2/%.2f - (x - %.2f)^2/%.2f = 1.\nIt is centered at the point (%.2f, %.2f).\nIt has a transverse axis of length %.2f\nIt has a  conjugate axis of length %.2f\nIt has foci at the points(%.2f, %.2f) and (%.2f, %.2f)\nIt has vertices at (%.2f, %.2f) and (%.2f, %.2f)\nIt has asymptotes with equations: y = %.2fx + %.2f and y = %.2fx - %.2f", getCenter()[1], Math.pow(tAxis, 2), Math.abs(getCenter()[0]), Math.pow(cAxis, 2), getCenter()[0], getCenter()[1], 2*tAxis, 2*cAxis, foci[0][0],foci[0][1], foci[1][0], foci[1][1], vertices[0][0], vertices[0][1], vertices[1][0], vertices[1][1], asy[0][0], asy[0][1], asy[1][0], Math.abs(asy[1][1]));
                }
                else if(vertices[0][1] < 0 && vertices[1][1] >= 0)
                {
                    output = String.format("The Conic is a hyperbola with equation: (y + %.2f)^2/%.2f - (x - %.2f)^2/%.2f = 1.\nIt is centered at the point (%.2f, %.2f).\nIt has a transverse axis of length %.2f\nIt has a  conjugate axis of length %.2f\nIt has foci at the points(%.2f, %.2f) and (%.2f, %.2f)\nIt has vertices at (%.2f, %.2f) and (%.2f, %.2f)\nIt has asymptotes with equations: y = %.2fx - %.2f and y = %.2fx + %.2f", getCenter()[1], Math.pow(tAxis, 2), Math.abs(getCenter()[0]), Math.pow(cAxis, 2), getCenter()[0], getCenter()[1], 2*tAxis, 2*cAxis, foci[0][0],foci[0][1], foci[1][0], foci[1][1], vertices[0][0], vertices[0][1], vertices[1][0], vertices[1][1], asy[0][0], Math.abs(asy[0][1]), asy[1][0], asy[1][1]);
                }
                else
                {
                    output = String.format("The Conic is a hyperbola with equation: (y + %.2f)^2/%.2f - (x - %.2f)^2/%.2f = 1.\nIt is centered at the point (%.2f, %.2f).\nIt has a transverse axis of length %.2f\nIt has a  conjugate axis of length %.2f\nIt has foci at the points(%.2f, %.2f) and (%.2f, %.2f)\nIt has vertices at (%.2f, %.2f) and (%.2f, %.2f)\nIt has asymptotes with equations: y = %.2fx - %.2f and y = %.2fx - %.2f", getCenter()[1], Math.pow(tAxis, 2), Math.abs(getCenter()[0]), Math.pow(cAxis, 2), getCenter()[0], getCenter()[1], 2*tAxis, 2*cAxis, foci[0][0],foci[0][1], foci[1][0], foci[1][1], vertices[0][0], vertices[0][1], vertices[1][0], vertices[1][1], asy[0][0], Math.abs(asy[0][1]), asy[1][0], Math.abs(asy[1][1]));
                }
            }
            else if(getCenter()[0] < 0 && getCenter()[1] >= 0)
            {
                if(vertices[0][1] >= 0 && vertices[1][1] >= 0)
                {
                    output = String.format("The Conic is a hyperbola with equation: (y - %.2f)^2/%.2f - (x + %.2f)^2/%.2f = 1.\nIt is centered at the point (%.2f, %.2f).\nIt has a transverse axis of length %.2f\nIt has a  conjugate axis of length %.2f\nIt has foci at the points(%.2f, %.2f) and (%.2f, %.2f)\nIt has vertices at (%.2f, %.2f) and (%.2f, %.2f)\nIt has asymptotes with equations: y = %.2fx + %.2f and y = %.2fx + %.2f", Math.abs(getCenter()[1]), Math.pow(tAxis, 2), getCenter()[0], Math.pow(cAxis, 2), getCenter()[0], getCenter()[1], 2*tAxis, 2*cAxis, foci[0][0],foci[0][1], foci[1][0], foci[1][1], vertices[0][0], vertices[0][1], vertices[1][0], vertices[1][1], asy[0][0], asy[0][1], asy[1][0], asy[1][1]);                
                }
                else if(vertices[0][1] >= 0 && vertices[1][1] < 0)
                {
                    output = String.format("The Conic is a hyperbola with equation: (y - %.2f)^2/%.2f - (x + %.2f)^2/%.2f = 1.\nIt is centered at the point (%.2f, %.2f).\nIt has a transverse axis of length %.2f\nIt has a  conjugate axis of length %.2f\nIt has foci at the points(%.2f, %.2f) and (%.2f, %.2f)\nIt has vertices at (%.2f, %.2f) and (%.2f, %.2f)\nIt has asymptotes with equations: y = %.2fx + %.2f and y = %.2fx - %.2f", Math.abs(getCenter()[1]), Math.pow(tAxis, 2), getCenter()[0], Math.pow(cAxis, 2), getCenter()[0], getCenter()[1], 2*tAxis, 2*cAxis, foci[0][0],foci[0][1], foci[1][0], foci[1][1], vertices[0][0], vertices[0][1], vertices[1][0], vertices[1][1], asy[0][0], asy[0][1], asy[1][0], Math.abs(asy[1][1]));
                }
                else if(vertices[0][1] < 0 && vertices[1][1] >= 0)
                {
                    output = String.format("The Conic is a hyperbola with equation: (y - %.2f)^2/%.2f - (x + %.2f)^2/%.2f = 1.\nIt is centered at the point (%.2f, %.2f).\nIt has a transverse axis of length %.2f\nIt has a  conjugate axis of length %.2f\nIt has foci at the points(%.2f, %.2f) and (%.2f, %.2f)\nIt has vertices at (%.2f, %.2f) and (%.2f, %.2f)\nIt has asymptotes with equations: y = %.2fx - %.2f and y = %.2fx + %.2f", Math.abs(getCenter()[1]), Math.pow(tAxis, 2), getCenter()[0], Math.pow(cAxis, 2), getCenter()[0], getCenter()[1], 2*tAxis, 2*cAxis, foci[0][0],foci[0][1], foci[1][0], foci[1][1], vertices[0][0], vertices[0][1], vertices[1][0], vertices[1][1], asy[0][0], Math.abs(asy[0][1]), asy[1][0], asy[1][1]);
                }
                else
                {
                    output = String.format("The Conic is a hyperbola with equation: (y - %.2f)^2/%.2f - (x + %.2f)^2/%.2f = 1.\nIt is centered at the point (%.2f, %.2f).\nIt has a transverse axis of length %.2f\nIt has a  conjugate axis of length %.2f\nIt has foci at the points(%.2f, %.2f) and (%.2f, %.2f)\nIt has vertices at (%.2f, %.2f) and (%.2f, %.2f)\nIt has asymptotes with equations: y = %.2fx - %.2f and y = %.2fx - %.2f", Math.abs(getCenter()[1]), Math.pow(tAxis, 2), getCenter()[0], Math.pow(cAxis, 2), getCenter()[0], getCenter()[1], 2*tAxis, 2*cAxis, foci[0][0],foci[0][1], foci[1][0], foci[1][1], vertices[0][0], vertices[0][1], vertices[1][0], vertices[1][1], asy[0][0], Math.abs(asy[0][1]), asy[1][0], Math.abs(asy[1][1]));
                }
            }
            else
            {
                if(vertices[0][1] >= 0 && vertices[1][1] >= 0)
                {
                    output = String.format("The Conic is a hyperbola with equation: (y + %.2f)^2/%.2f - (x + %.2f)^2/%.2f = 1.\nIt is centered at the point (%.2f, %.2f).\nIt has a transverse axis of length %.2f\nIt has a  conjugate axis of length %.2f\nIt has foci at the points(%.2f, %.2f) and (%.2f, %.2f)\nIt has vertices at (%.2f, %.2f) and (%.2f, %.2f)\nIt has asymptotes with equations: y = %.2fx + %.2f and y = %.2fx + %.2f", Math.abs(getCenter()[0]), Math.pow(tAxis, 2), Math.abs(getCenter()[1]), Math.pow(cAxis, 2), getCenter()[0], getCenter()[1], 2*tAxis, 2*cAxis, foci[0][0],foci[0][1], foci[1][0], foci[1][1], vertices[0][0], vertices[0][1], vertices[1][0], vertices[1][1], asy[0][0], asy[0][1], asy[1][0], asy[1][1]);                
                }
                else if(vertices[0][1] >= 0 && vertices[1][1] < 0)
                {
                    output = String.format("The Conic is a hyperbola with equation: (y + %.2f)^2/%.2f - (x + %.2f)^2/%.2f = 1.\nIt is centered at the point (%.2f, %.2f).\nIt has a transverse axis of length %.2f\nIt has a  conjugate axis of length %.2f\nIt has foci at the points(%.2f, %.2f) and (%.2f, %.2f)\nIt has vertices at (%.2f, %.2f) and (%.2f, %.2f)\nIt has asymptotes with equations: y = %.2fx + %.2f and y = %.2fx - %.2f", Math.abs(getCenter()[0]), Math.pow(tAxis, 2), Math.abs(getCenter()[1]), Math.pow(cAxis, 2), getCenter()[0], getCenter()[1], 2*tAxis, 2*cAxis, foci[0][0],foci[0][1], foci[1][0], foci[1][1], vertices[0][0], vertices[0][1], vertices[1][0], vertices[1][1], asy[0][0], asy[0][1], asy[1][0], Math.abs(asy[1][1]));
                }
                else if(vertices[0][1] < 0 && vertices[1][1] >= 0)
                {
                    output = String.format("The Conic is a hyperbola with equation: (y + %.2f)^2/%.2f - (x + %.2f)^2/%.2f = 1.\nIt is centered at the point (%.2f, %.2f).\nIt has a transverse axis of length %.2f\nIt has a  conjugate axis of length %.2f\nIt has foci at the points(%.2f, %.2f) and (%.2f, %.2f)\nIt has vertices at (%.2f, %.2f) and (%.2f, %.2f)\nIt has asymptotes with equations: y = %.2fx - %.2f and y = %.2fx + %.2f", Math.abs(getCenter()[0]), Math.pow(tAxis, 2), Math.abs(getCenter()[1]), Math.pow(cAxis, 2), getCenter()[0], getCenter()[1], 2*tAxis, 2*cAxis, foci[0][0],foci[0][1], foci[1][0], foci[1][1], vertices[0][0], vertices[0][1], vertices[1][0], vertices[1][1], asy[0][0], Math.abs(asy[0][1]), asy[1][0], asy[1][1]);
                }
                else
                {
                    output = String.format("The Conic is a hyperbola with equation: (y + %.2f)^2/%.2f - (x + %.2f)^2/%.2f = 1.\nIt is centered at the point (%.2f, %.2f).\nIt has a transverse axis of length %.2f\nIt has a  conjugate axis of length %.2f\nIt has foci at the points(%.2f, %.2f) and (%.2f, %.2f)\nIt has vertices at (%.2f, %.2f) and (%.2f, %.2f)\nIt has asymptotes with equations: y = %.2fx - %.2f and y = %.2fx - %.2f", Math.abs(getCenter()[0]), Math.pow(tAxis, 2), Math.abs(getCenter()[1]), Math.pow(cAxis, 2), getCenter()[0], getCenter()[1], 2*tAxis, 2*cAxis, foci[0][0],foci[0][1], foci[1][0], foci[1][1], vertices[0][0], vertices[0][1], vertices[1][0], vertices[1][1], asy[0][0], Math.abs(asy[0][1]), asy[1][0], Math.abs(asy[1][1]));
                }
            }
        }
        return output;
    }
}

import java.util.Scanner;
public class ConicTester
{
    public static void main(String [] args)
    {        
        Scanner in = new Scanner(System.in);
        System.out.println("The general form of a non-rotated conic is Ax^2 + By^2 + Cx + Dy + E = 0");
        System.out.println("This program will allow you to enter a conic in general form and return the conic in graphing form.");
        System.out.println("Please enter the value of the each of the coefficients seperated by a space.");
        System.out.println("Ex: For conic 2x^2 + 3y^2 - 4x + 5y - 6.5 = 0");
        System.out.println("Enter: 2 3 -4 5 -6.5");
        String quit = "";
        while(!quit.equalsIgnoreCase("yes"))
        {
            System.out.println("Please enter the coefficients: ");
            double [] coeff = new double[5];
            for(int i = 0; i < 5; i++)
            {
                coeff[i] = in.nextDouble();
            }
            double discriminant = calcDiscriminant(coeff);
            String conicType = findConicType(discriminant, coeff);
            boolean deg = isDegenerate(coeff);
            if(deg == true)
            {
                System.out.println("Conic is degenerate");
            }
            else if(conicType.equals("Circle"))
            {
                Circle circle = new Circle(coeff, discriminant, conicType);
                System.out.println(circle.toString());
            }        
            else if(conicType.equals("Ellipse"))
            {
                Ellipse ellipse = new Ellipse(coeff, discriminant, conicType);
                System.out.println(ellipse.toString());
            }
            else if(conicType.equals("Parabola"))
            {
                Parabola parabola = new Parabola(coeff, discriminant, conicType);
                System.out.println(parabola.toString());
            }
            else
            {
                Hyperbola hyperbola = new Hyperbola(coeff, discriminant, conicType);
                System.out.println(hyperbola.toString());
            }
            System.out.println("Would you like to quit? Type yes to quit, no to continue");
            quit = in.next();
        }                            
    }
    public static boolean isDegenerate(double [] c)
    {
        boolean deg = false;
        double det = c[0]*c[1]*c[4] - c[1]*Math.pow(c[2], 2)/4 - c[0]*Math.pow(c[3], 2)/4;
        if(det == 0)
        {
            deg = true;
        }
        return deg;
    }
    public static double calcDiscriminant(double [] coeff)
    {
        return -4*coeff[0]*coeff[1];
    }
    public static String findConicType(double discriminant, double [] coeff)
    {
        if(discriminant  < 0)
        {
            if(coeff[0] == coeff[1])
            {
                return "Circle";
            }
            else
            {
                 return "Ellipse";
            }
        }
        else if(discriminant == 0)
        {
            return "Parabola";
        }
        else
        {
            return "Hyperbola";
        }
    }
}

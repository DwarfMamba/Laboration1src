import java.awt.*;

/**
 * Superklass Car, håller reda på en bils riktning, position och hastighet
 * Innehåller samtliga bilars funktioner men vissa override:as av subklasser
 */
public class Car implements Moveable{
    public Point position = new Point(200,200);

    public int dir;
    public static final int NORTH = 0;
    public static final int EAST = 1;
    public static final int SOUTH = 2;
    public static final int WEST = 3;

    public int nrDoors; // Number of doors on the car
    public double enginePower; // Engine power of the car
    public double currentSpeed; // The current speed of the car
    public Color color; // Color of the car
    public String modelName; // The car model name
    // Skulle kunna göra dessa paket-private, alltså varken public/private

    public void move(){
        int xIntPos = (int) position.getX();
        int yIntPos = (int) position.getY();

        if(dir == NORTH){
            yIntPos += -currentSpeed;
        }
        else if(dir == SOUTH){
            yIntPos += currentSpeed;
        }
        else if(dir == WEST){
            xIntPos += -currentSpeed;
        }
        else if(dir == EAST){
            xIntPos += +currentSpeed;
        }
        position = new Point(xIntPos,yIntPos);
    } //metoden tar bilens position och ändrar den till en ny position baserad på bilens rikting och hastighet

    public void turnLeft(){
        dir = (dir+3)%4;
    }
    public void turnRight(){
        dir = (dir+1)%4;
    }

    public void gas(double factor){

    }
    public void brake(double factor){

    }


    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
        color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){
        currentSpeed = 0;
    }

}

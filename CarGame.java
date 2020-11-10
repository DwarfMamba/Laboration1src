import javax.swing.*;
import java.awt.*;
import java.lang.*;

/**
 * En GUI-värld där bilen åker runt
 */
public class CarGame extends JFrame{
    ImageIcon carIcon;

    public static void main(String[] args){
        Car car = new Saab95(); //skapa ny bil
        car.startEngine(); //starta bilen
        CarGame map = new CarGame(car); //skapa ny karta

        for (int i = 0; i <= 300; i++){

            car.gas(1); //GAS

            if(i%20 == 1){
                car.turnLeft();
            }//sväng vänster var tjugonde frame

            if(i%30 == 1){
                car.turnRight();
            }//sväng höger var trettionde frame

            car.move(); //flytta bilen
            JLabel newLabel = map.createLabel(car); //skapar ny bil-etikett
            map.getContentPane().removeAll(); //rensar fönstret (borde nog ta bort bara bilen specifikt)
            map.add(newLabel); //lägger till nya bilen
            map.repaint(); //uppdaterar fönstret

            wait(17); //väntar 17 millisekunder = 60FPS
        }
    }

    public CarGame(Car car){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,500);
        getContentPane().setBackground(Color.green);
        setLocation(600,400);
        setLayout(null);

        JLabel newLabel = createLabel(car);
        add(newLabel);

        setVisible(true);
    }//konstruktor skapar ny karta med bil

    public JLabel createLabel(Car inputCar){
        int xcoord = (int) Math.round(inputCar.position.getX());
        int ycoord = (int) Math.round(inputCar.position.getY());

        if(inputCar.dir == 0){
            carIcon = new ImageIcon("carIconNORTH.png");
        } else if(inputCar.dir == 1){
            carIcon = new ImageIcon("carIconEAST.png");
        } else if(inputCar.dir == 2){
            carIcon = new ImageIcon("carIconSOUTH.png");
        } else {
            carIcon = new ImageIcon("carIconWEST.png");
        }

        JLabel carLabel = new JLabel("",carIcon,JLabel.CENTER);
        Dimension size = carLabel.getPreferredSize();
        carLabel.setBounds(xcoord-size.width/2,ycoord-size.height/2,size.width,size.height);

        return carLabel;
    }//returnerar en etikett med bilen som gavs



    public static void wait(int ms)
    {
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }



}

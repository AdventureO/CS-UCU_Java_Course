package cor_lab.com;

/**
 * Created by pryho on 13-Dec-16.
 */
public class Data {

    private double x;
    private double y;

    Data(double x, double y){
        this.x = x;
        this.y = y;
    }

    /**
     * Returns x
     * @return x
     */
    double getPrettyX(){
        return this.x;
    }

    /**
     * Returns y
     * @return y
     */
    double getPrettyY(){
        return this.y;
    }
}

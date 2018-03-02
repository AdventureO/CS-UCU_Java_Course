package cor_lab.com;

/**
 * Created by pryho on 13-Dec-16.
 */
public class DataAdapter extends Data implements IDataAdapter {

    DataAdapter(double x, double y) {
        super(x, y);
    }

    @Override
    public double getX() {
        return getPrettyX();
    }

    @Override
    public double getY() {
        return getPrettyY();
    }
}

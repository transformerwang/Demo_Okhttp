package wyz.android.com.model;

/**
 * Created by wangyuzhe on 9/29/15.
 */
public class Wind {
    private String speed;
    private String deg;

    public Wind(String speed, String deg)
    {
        this.speed = speed;
        this.deg = deg;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getDeg() {
        return deg;
    }

    public void setDeg(String deg) {
        this.deg = deg;
    }
}

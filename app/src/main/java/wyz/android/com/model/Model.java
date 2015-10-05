package wyz.android.com.model;

import java.util.List;

/**
 * Created by wangyuzhe on 9/29/15.
 */
public class Model {
    private Coord coord;
    private List<Weather> weather;
    private String base;
    private Main main;
    private Wind wind;
    private String dt;
    private Sys sys;
    private String id;
    private String name;
    private String cod;

    public Model(Coord coord, List<Weather> weather, String base, Main main, Wind wind, String dt, Sys sys, String id, String name, String cod)
    {
        this.coord = coord;
        this.weather = weather;
        this.base = base;
        this.main = main;
        this.wind = wind;
        this.dt = dt;
        this.sys = sys;
        this.id = id;
        this.name = name;
        this.cod = cod;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }
}

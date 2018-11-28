package com.service.platform.user.common.validate;

public class ImageCodeConfig {

    private int width = 67;
    private int height = 23;
    private int lenght = 4;
    private int expireSencond = 60;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getLenght() {
        return lenght;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }

    public int getExpireSencond() {
        return expireSencond;
    }

    public void setExpireSencond(int expireSencond) {
        this.expireSencond = expireSencond;
    }
}

package jp.artan.dmlreloaded.util;

public class RenderInfo {
    public int x, y;
    public double scale, yaw, pitch;

    public RenderInfo(int x, int y, double scale, double yaw, double pitch) {
        this.x = x;
        this.y = y;
        this.scale = scale;
        this.yaw = yaw;
        this.pitch = pitch;
    }
}


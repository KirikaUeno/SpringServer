package ServerMain.serverData;

public class ServerData {
    public static float cathodeTemperature = 296;
    public static float cathodeVoltage = 0;
    public static float cathodeCurrent = 0;
    public static float cathodeUptime = 0;
    public static float filamentVoltage = 0;
    public static float filamentCurrent = 0;
    public static float filamentPower = 0;
    public static float piTemperature = 296;
    public static float pressure = 1;
    public static boolean cathodeSystemOn = false;
    public static boolean filamentSystemOn = false;

    public static String composeUpdates(){
        String info = "";
        info+=String.valueOf(cathodeTemperature);
        info+="||";
        info+=String.valueOf(cathodeVoltage);
        info+="||";
        info+=String.valueOf(cathodeCurrent);
        info+="||";
        info+=String.valueOf(cathodeUptime);
        info+="||";
        info+=String.valueOf(filamentVoltage);
        info+="||";
        info+=String.valueOf(filamentCurrent);
        info+="||";
        info+=String.valueOf(filamentPower);
        info+="||";
        info+=String.valueOf(pressure);
        info+="||";
        info+=String.valueOf(piTemperature);
        return info;
    }

    public static void setCathodeVoltage(float v){
        cathodeVoltage = v;
    }

    public static void setCathodeCurrent(float c){
        cathodeCurrent = c;
    }
}

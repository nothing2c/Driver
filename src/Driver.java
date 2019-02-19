public class Driver {

    private int driverNum;

    private String driverName;

    private boolean banned = false;



    public Driver(String driverName,int driverNum){

        setDriverNum(driverNum);

        setDriverName(driverName);

    }


    public int getDriverNum() {

        return driverNum;

    }

    private void setDriverNum(int driverNum) {

        if (driverNum < 100)
        {
            throw new IllegalArgumentException();
        }

        this.driverNum = driverNum;

    }

    public String getDriverName() {

        return driverName;

    }

    private void setDriverName(String driverName) {

        if (driverName.isEmpty()){
            throw new IllegalArgumentException();
        }

        this.driverName = driverName;

    }

    public String toString(){

        return "\nDriver Name: "+getDriverName()+"\nDriver Number: "+getDriverNum();
    }

    public boolean check_status(){
        return banned;
    }


    public void waitTillBanned(){
        while (!banned){

        }
    }
}

package Just;

public class MyException extends Exception{
    @Override
    public String toString() {
        return "Error. Bad values\"!!! Program is invalid !!! \nValues do not fit the capacity of BIN!\n \nCHANGE THE VALUES ...";
    }
}

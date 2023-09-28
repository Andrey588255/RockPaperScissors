
public class LogicChoice
{
    private int type;
    public LogicChoice(int t)
    {
        type = t;
    }
    public boolean equals(LogicChoice other)  // метод equals
    {
        if (type == other.type) return true;
        else return false;
    }
    public boolean beats(LogicChoice other)  // Метод визначення типу вибору
    {
        if (type == 2 && other.type == 1) return true;
        else if (type == 1 && other.type == 0) return true;
        else if (type == 0 && other.type == 2) return true;
        else if (other.type == 2 && type == 1) return false;
        else if (other.type == 1 && type == 0) return false;
        else if (other.type == 0 && type == 2) return false;
        else return false;
    }
    public String describeWin()       // Логіка визначення переможця
    {
        switch (type)
        {
            case 0: return "Rock crushes Scissors!";
            case 1: return "Paper wraps Rock!";
            case 2: return "Scissors cuts Paper!";
        }
        return "Could not describe the win!";
    }
    public String toString()
    {
        switch (type) {
            case 0: return "Rock";
            case 1: return "Paper";
            case 2: return "Scissors";
        }
        return "ERROR: Couldn't determine type! (fix me!)";
    }
}

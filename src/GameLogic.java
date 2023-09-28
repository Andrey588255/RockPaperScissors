   public class GameLogic
    {
        private int roundNum;
        private int p1score;
        private int p2score;
        private LogicChoice c1;
        private LogicChoice c2;

        public GameLogic()
        {
            c1 = new LogicChoice(0);
            c2 = new LogicChoice(0);
        }

        public void reset()
        {
            roundNum = 1;
            p1score = 0;
            p2score = 0;
        }

        public int getRound()
        {
            return roundNum;
        }

        public String play(LogicChoice c1, LogicChoice c2)  // Логіка методу визначення переможця
        {
            if (c1.equals(c2) == true)  // Нічия
            {
                roundNum ++;
                return "It's a tie!";
            }
            else if (c1.beats(c2) == true)  // Пенремога гравця 1
            {
                System.out.println ("Player 1 wins this round!");
                p1score += 1;
                roundNum += 1;
                return c1.describeWin();
            }
            else
            {
                System.out.println ("Player 2 wins this round!"); // перемога гравця 2
                p2score ++;
                roundNum ++;
                return c2.describeWin();
            }
        }
        public String getScoreString()
        {
            return "" + p1score + "-" + p2score;
        }
        public boolean isGameOver()   // Закіннчення гри
        {
            if (p1score == 3 || p2score == 3) return true;
            else return false;
        }
        public int getWinner()   // захунок визначення переможця
        {
            if (p1score >= 3) return 1;
            else return 2;
        }
    }


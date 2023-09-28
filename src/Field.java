import java.util.*;

public class Field
{
    private Scanner kb;
    private GameLogic game;

    public Field()
    {
        kb = new Scanner( System.in );
        game = new GameLogic();

        play();
    }

    public void play()  // Метод друку "Нова гра, раунд, ти кидаєш, рахунок"
    {
        System.out.println( "==== New Game ====" );  //
        game.reset();

        while ( !game.isGameOver() )
        {
            System.out.println( "*** Round " + game.getRound() + " ***" );
            LogicChoice player_choice = getPlayerChoice();
            LogicChoice ai_choice = getAIChoice();

            System.out.println( "You throw: " + player_choice );
            System.out.println( "AI throws: " + ai_choice );

            System.out.println( game.play( player_choice, ai_choice ) );
            System.out.println( "Score: " + game.getScoreString() );
            System.out.println();
        }

        if (game.getWinner() == 1)    // друк виграшу чи поразки
        {
            System.out.println( "You win!" );
        }
        else
        {
            System.out.println( "The computer wins!" );
        }
    }

    public LogicChoice getPlayerChoice()
    {
        while (true)       // Виводимо запит на введення
        {
            System.out.print( "Choose: (r)Rock, (p)Paper, or (s)Scissors: " );   // Читаємо введення користувача
            String st = kb.nextLine();
            if (st == null || st.length() != 1) continue;

             
            switch (st.charAt(0))
            {
                case 'r': return new LogicChoice( 0 );
                case 'p': return new LogicChoice( 1 );
                case 's': return new LogicChoice( 2 );
            }
        }
    }

    public LogicChoice getAIChoice()
    {
        return new LogicChoice( (int)(Math.random() * 3) );
    }
}
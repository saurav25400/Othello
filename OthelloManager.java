package Othello;

import tic_tac_toe.Boards;

import java.util.Scanner;

public class OthelloManager {
    private Board boards;
    private Player player1,player2;
    private static int numPlayer;


    public static void main(String[] args) {
        OthelloManager othello=new OthelloManager();
        othello.startGame();
    }

    public void startGame() {
        Scanner sc=new Scanner(System.in);
        this.player1=takeInput(++numPlayer);
        this.player2=takeInput(++numPlayer);
        while(this.player1.getColor()==this.player2.getColor()){
            this.player2.setColor(sc.nextInt());
        }
        this.boards=new Board(this.player1.getColor(),this.player2.getColor());
//        this.boards.printBoard();
        boolean isPlayer1=true;
        int status= Board.INCOMPLETEMOVE;
        while(status==Board.INCOMPLETEMOVE||status==Board.INVALIDMOVE){
            if(isPlayer1){
                System.out.println("player 1 turn :");
                System.out.println("Enter x :");
                int x=sc.nextInt();
                System.out.println("Enter y :");
                int y=sc.nextInt();
                status=this.boards.move(this.player1.getColor(),x,y);

            }
            else{
                System.out.println("player 2 turn :");
                System.out.println("Enter x :");
                int x=sc.nextInt();
                System.out.println("Enter y :");
                int y=sc.nextInt();
                status=this.boards.move(this.player2.getColor(),x,y);

            }
            isPlayer1=!isPlayer1;
            //print the board;
            this.boards.printBoard();



        }
        // game over status
        if(status==Board.PLAYER1WON){
            System.out.println(player1.getName()+"has won the game ");
        } else if (status==Board.PLAYER2WON) {
            System.out.println(player2.getName()+"has won the game ");

        } else if (status==Board.DRAW) {
            System.out.println("DRAW!!!-------Game is drawn");

        }


    }
    public Player takeInput(int num){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter player"+num+"name : ");
        String name=sc.nextLine();
        System.out.println("Enter player "+num+"symbol either 1 or 2:");
        int symbol=sc.nextInt();
        Player p=new Player(name,symbol);
        return p;
    }




}

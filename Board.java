package Othello;

import tic_tac_toe.Boards;

public class Board {
    private int count;
    private int p1Symbol;
    private int p2Symbol;
    int[][]board;
    final private int boardSize=8;
//      final static int INVALID_MOVE=1;
      final static int PLAYER1WON=1;
      final static int PLAYER2WON=2;
      final static  int DRAW=3;
      final static int INVALIDMOVE=4;
      final static  int INCOMPLETEMOVE=5;


    Board(int p1Symbol,int p2Symbol){
        this.board=new int[this.boardSize][this.boardSize];
        this.p1Symbol=p1Symbol;
        this.p2Symbol=p2Symbol;
//        initial configuration..
        this.board[3][3]=p1Symbol;
        this.board[3][4]=p2Symbol;
        this.board[4][3]=p2Symbol;
        this.board[4][4]=p1Symbol;
        this.count=2;
    }
    public void printBoard(){
        System.out.println("-------------------");
        for(int i=0;i<this.boardSize;i++){
            for(int j=0;j<this.boardSize;j++){
                System.out.print("|"+this.board[i][j]+"|");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("-------------------");
    }


    public int move(int symbol, int x, int y) {
        //check for valid cells
        if(x<0||x>=this.boardSize||y<0||y>=this.boardSize||this.board[x][y]!=0){
            return INVALIDMOVE;
        }
        int[]dx={-1,-1,0,1,1,1,0,-1};
        int[]dy={0,1,1,1,0,-1,-1,-1};

        for(int i=0;i<dx.length;i++){
            int xi=x+dx[i];
            int ax=x+dx[i];
            int yi=y+dy[i];
            int ay=y+dy[i];
            boolean isValidMove=false;

            if(xi>=0&&xi<this.boardSize&&yi>=0&&yi<this.boardSize&&this.board[xi][yi]!=0&&this.board[xi][yi]!=symbol){
//                int pieces=1;
                //means  got a oppenent piece;
                while(xi>=0&&xi<this.boardSize&&yi>=0&&yi<this.boardSize&&this.board[xi][yi]!=0){
                    //keep on going in same direction
                    xi+=dx[i];
                    yi+=dy[i];
                    if(xi>=0&&xi<this.boardSize&&yi>=0&&yi<this.boardSize&&this.board[xi][yi]==symbol){
                        int flipX=ax;
                        int flipY=ay;
                        while(flipX!=xi || flipY!=yi){
                            this.board[flipX][flipY]=symbol;
                            this.count++;
                            flipX+=dx[i];
                            flipY+=dx[i];
                        }
                        isValidMove=true;
                        break;
                    }

                    if(isValidMove){
                        this.board[x][y]=symbol;
                    }




                }


            }
        }


        //status  game over condition
        if(this.count==this.boardSize*this.boardSize){
            //win and draw condition
            int p1=0;int p2=0;
            for(int i=0;i<this.boardSize;i++){
                for(int j=0;j<this.boardSize;j++){
                    if(this.board[i][j]==this.p1Symbol){
                        p1++;

                    }
                    if(this.board[i][j]==this.p2Symbol){
                        p2++;
                    }
                }
            }
            if(p1>p2){
                return Board.PLAYER1WON;
            }
            else if(p2>p1){
                return Board.PLAYER2WON;
            }
            else{
                return Board.DRAW;
            }
        }
        return INCOMPLETEMOVE;

    }
}

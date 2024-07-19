import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Snake
{
    char [][]board=null;
    Queue<Node>snake=new LinkedList<>();
    public Snake(int row,int col){
        this.snake.add(new Node(0,0));
        this.board=new char[row][col];
        this.board[0][1]='x';
        this.board[1][1]='x';
        this.board[2][3]='x';
        this.board[2][4]='x';
        this.board[2][1]='x';
    }

    public void moveSnake(int r,int c)
    {
            //printBoard..()
            if(r>=0 && c>=0 && r<board.length && c< board.length) {

                if(board[r][c]=='.'){
                    System.out.println("Game Over..");
                    System.exit(1);
                }
                snake.add(new Node(r,c));
                if(board[r][c]!='x'){
                    Node node=snake.poll();
                    int row= node.getRow();
                    int col= node.getCol();
                    board[row][col]='0';
                }
                board[r][c]='.';
                while(!snake.isEmpty()){
                    printBoard();
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter val");
                char ch = sc.next().charAt(0);
                if(ch=='w'){
                    moveSnake(--r,c);
                }
                else if(ch=='a'){
                    moveSnake(r,--c);
                }
                else if(ch=='s'){
                    moveSnake(++r,c);
                }
                else if(ch=='d'){
                    moveSnake(r,++c);
                }
                else{
                    System.out.println("Invalid input");
                }
            }


        }
            else{
                System.out.println("Game Over!!");
                System.exit(1);
            }
    }
    public void printBoard(){
        for(int i=0;i< board.length;i++){
            for(int j=0;j< board.length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

}

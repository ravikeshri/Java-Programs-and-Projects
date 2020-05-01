/*

Tic Tac Toe Game
Register with Unique ID and a password of length 3 or more

*/

import java.util.*;
import java.util.regex.*;

class Player {
    private String name, id, password;
    public int played, won;
    // Constructor
    Player(String name, String id, String password) {
        this.name = name;
        this.id = id;
        this.password = password;
        this.played = 0;
        this.won = 0;
    }

    public void draw() {
        this.played++;
    }
    public String getName() {
        return this.name;
    }
    public boolean isMatched(String password) {
        return this.password.equals(password);
    }
    public String getId() {
        return this.id;
    }
    public int getPlayed() {
        return this.played;
    }
    public int getWon() {
        return this.won;
    }
}

class TicTacToe {
    private Player p1, p2;
    private String[][] board = new String[3][3];
    // Initializing Board
    TicTacToe(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
        for(int i=0; i<3; i++) {
            Arrays.fill(this.board[i], " ");
        }
    }
    public void showBoard() {
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                System.out.print(this.board[i][j] + " | ");
            }
            System.out.println();
        }
    }
    public boolean markBoard(int k, int move) {
        int count = 1;
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                if(count == move) {
                    if(k==1 && this.board[i][j].equals(" ")) {
                        this.board[i][j] = "X";
                        return true;
                    }
                    else if(k==2 && this.board[i][j].equals(" ")) {
                        this.board[i][j] = "O";
                        return true;
                    }
                    else {
                        return false;
                    }
                }
                count++;
            }
        }
        return false;
    }
    public boolean isFull() {
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                if(this.board[i][j].equals(" "))
                    return false;
            }
        }
        return true;
    }

    public int checkWinner() {
        for(int i=0; i<3; i++) {
            if(this.board[i][0].equals("X") &&
                    this.board[i][1].equals("X") &&
                    this.board[i][2].equals("X")) {
                return 1;
            }
            else if(this.board[i][0].equals("O") &&
                    this.board[i][1].equals("O") &&
                    this.board[i][2].equals("O")) {
                return 2;
            }
        }
        for(int i=0; i<3; i++) {
            if(this.board[0][i].equals("X") &&
                    this.board[1][i].equals("X") &&
                    this.board[2][i].equals("X")) {
                return 1;
            }
            else if(this.board[0][i].equals("O") &&
                    this.board[1][i].equals("O") &&
                    this.board[2][i].equals("O")) {
                return 2;
            }
        }
        if(this.board[0][0].equals("X") &&
                this.board[1][1].equals("X") &&
                this.board[2][2].equals("X")) {
            return 1;
        }
        if(this.board[0][0].equals("O") &&
                this.board[1][1].equals("O") &&
                this.board[2][2].equals("O")) {
            return 2;
        }
        if(this.board[0][2].equals("X") &&
                this.board[1][1].equals("X") &&
                this.board[2][0].equals("X")) {
            return 1;
        }
        if(this.board[0][2].equals("O") &&
                this.board[1][1].equals("O") &&
                this.board[2][0].equals("O")) {
            return 2;
        }
        return 3;
    }

    public void wonBy(Player p) {
        if(this.p1 == p) {
            this.p1.won++;
        }
        else {
            this.p2.won++;
        }
        this.p1.played++;
        this.p2.played++;
    }

}

public class Game {
    public static void main(String[] args) {
        Vector<Player> p = new Vector<Player>(2);
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("(1) register a new user or (2) play a game or (3 or any) to Quit.");
            System.out.println("Enter choice:");
            String ch = sc.nextLine();
            if (ch.equals("1")) {
                System.out.println("Enter name: ");
                String name = sc.nextLine();
                boolean unique;
                String id;
                do {
                    System.out.println("Choose Unique Login ID: ");
                    id = sc.nextLine();
                    unique = true;
                    for (int i = 0; i < p.size(); i++) {
                        if (p.get(i).getId().equals(id)) {
                            unique = false;
                            break;
                        }
                    }
                    if(!unique)
                        System.out.println("ID Not Available!!");
                } while (!unique);
                String password;
                do {
                    System.out.println("Register Password: (Atleast of length 3)");
                    password = sc.nextLine();
                } while(!Pattern.matches(".{3,}",password));
                Player q = new Player(name, id, password);
                p.add(q);
            }
            else if (ch.equals("2")) {
                if(p.size() < 2) {
                    System.out.println("No Sufficient Players Registered!! (Required atleast 2)");
                    continue;
                }
                String id;
                int i, index = 0;
                do {
                    System.out.println("Enter 1st player ID: ");
                    id = sc.nextLine();
                    for (i = 0; i < p.size(); i++) {
                        if (p.get(i).getId().equals(id)) {
                            index = i;
                            break;
                        }
                    }
                    if (i == p.size()) {
                        System.out.println("Player Not Available!!");
                    }
                } while( i == p.size());
                Player p1 = p.get(index);
                System.out.println("Enter password: ");
                String password = sc.nextLine();
                while(!p1.isMatched(password)){
                    System.out.println("Wrong password!! (Enter Q to quit)");
                    password = sc.nextLine();
                    if(password.equals("Q"))
                        break;
                }
                if(password.equals("Q"))
                    break;
                do {
                    System.out.println("Enter 2nd player ID: ");
                    id = sc.nextLine();
                    for (i = 0; i < p.size(); i++) {
                        if (p.get(i).getId().equals(id) && !id.equals(p1.getId())) {
                            index = i;
                            break;
                        }
                    }
                    if (i == p.size()) {
                        System.out.println("Player Not Available!!");
                    }
                } while (i == p.size());
                Player p2 = p.get(index);
                System.out.println("Enter password: ");
                password = sc.nextLine();
                while(!p2.isMatched(password)){
                    System.out.println("Wrong password!! (Enter Q to quit)");
                    password = sc.nextLine();
                    if(password.equals("Q"))
                        break;
                }
                if(password.equals("Q"))
                    break;

                TicTacToe board = new TicTacToe(p1, p2);
                board.showBoard();

                System.out.println("Places are index 1 to 9");
                int move, j, w;
                for(i=0; i<9; i++) {
                    if(i%2 == 0)
                        j=1;
                    else j = 2;
                    System.out.println("Player "+ j +":(1-9) ");
                    move = sc.nextInt();
                    boolean marked = board.markBoard(j, move);
                    while(!marked) {
                        System.out.println("Enter valid move in an empty space (1-9):");
                        move = sc.nextInt();
                        marked = board.markBoard(j, move);
                    }
                    board.showBoard();
                    w = board.checkWinner();
                    if(w == 1) {
                        board.wonBy(p1);
                        System.out.println("Player 1 wins!!");
                        System.out.println("Player Name: " + p1.getName());
                        System.out.println("Total Wins: " + p1.getWon());
                        System.out.println("Total played: " + p1.getPlayed());
                        break;
                    }
                    else if(w == 2) {
                        board.wonBy(p2);
                        System.out.println("Player 2 wins!!");
                        System.out.println("Player Name: " + p2.getName());
                        System.out.println("Total Wins: " + p2.getWon());
                        System.out.println("Total played: " + p2.getPlayed());
                        break;
                    }
                    else if(w == 3 && board.isFull()) {
                        System.out.println("Match Drawn");
                        p1.draw();
                        p2.draw();
                        break;
                    }
                }
                sc.nextLine();
            }
            else {
                System.out.println("--------------------------------------------");
                for (Player player : p) {
                    System.out.println("Player Name: " + player.getName());
                    System.out.println("Total Wins: " + player.getWon());
                    System.out.println("Total played: " + player.getPlayed());
                    System.out.println("--------------------------------------------");
                }
                break;
            }
        }
    }
}

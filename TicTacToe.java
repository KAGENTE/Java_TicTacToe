import java.util.Scanner;

class Matriz{

    

    public static int jogo[][] = new int[3][3]; //"tabuleiro" do jogo
    Scanner scan = new Scanner(System.in);//objeto apra executar leitura dos inputs
    int y;//eixo y para jogada
    int x;//eixo x para jogada
    boolean controle = false;//controle para turno, falso = turno do X, true = turno do O

    //imprime o grid subistituindo os valores por X OU O sendo x=1 O=2 e vazio = 0
        public void Print(){
            System.out.println("  X  X  X");
            for(int i=0;i<3;i++){
                System.out.print("Y");
                for(int j=0;j<3;j++){
                    switch (jogo[i][j]) {
                        case 0:
                            System.out.print("[ ]");
                            break;
                        case 1:
                            System.out.print("[X]");
                            break;
                        case 2:
                            System.out.print("[O]");
                            break;
                    } 
                }
                System.out.println();
            }
        }
    
//pega do usuario a informação de qual eixo ele irá jogar
    public void GetUserPlay(){            
            System.out.println("Digite o eixo Y");
            try {
                x = scan.nextInt()-1;
                    
                }catch (Exception e){
                    System.out.println("digite um valor valido");
                    scan.next();
                }

                System.out.println("Digite o eixo X");
                try {
                    y =scan.nextInt()-1;
                    }catch (Exception e){
                        System.out.println("digite um valor valido");
                        scan.next();
                    } 
    }
    //seta a play de acordo com as cordenadas X e Y alem de usar o controle para definir turno X ou O
    public void Setplay() {
        try{
            if (jogo[x][y] == 0) { // Verifica se a posição está vazia
                if (controle == false) {
                    jogo[x][y] = 1;
                } else { 
                    jogo[x][y] = 2; 
                }
                    controle = !controle; // Alterna o controle para o próximo jogador
            }else {
                System.out.println("digite um local valido"); // Mensagem de erro
            }
        }catch (ArrayIndexOutOfBoundsException e){
            this.Print();
            System.out.println("DIGITE UMA COORDENADA VALIDA!!!");
            this.GetUserPlay();
            
        }
        }
    
    public boolean FimDeJogo() {// fim do jogo se true acaba o jogo
        for(int i=0;i<3;i++){// testa as linhas do jogo
            if (jogo[i][0] != 0 &&jogo[i][0] == jogo[i][1] && jogo[i][1] == jogo[i][2]){
                return true;
            }
        }
        
        for(int j=0;j<3;j++){// testa as colunas do jogo 
            if (jogo[0][j] != 0 && jogo[0][j] == jogo[1][j] && jogo[1][j] == jogo[2][j]){
                return true;
            }
        }
        if(jogo[1][1] != 0 && jogo[0][0] == jogo[1][1] && jogo[1][1] == jogo[2][2]){// testa diagonal 1
            return true;
        }
        if(jogo[1][1] != 0 && jogo[0][2] == jogo[1][1] && jogo[1][1] == jogo[2][0]){// testa diagonal 2
            return true;
        }
   
        return false;

        
    }
    
    public void Play(){
        boolean T = this.FimDeJogo();
        while(!T){
            this.Print();
            this.GetUserPlay();
            this.Setplay();
            System.out.println();
            T = this.FimDeJogo();
        }
        if(controle){
            System.out.println("VITORIA DO X");
            this.Print();
        }else{
            System.out.println("VITORIA DO O");
            this.Print();
        }
    }
}

public class TicTacToe{
    public static void main(String a[]){
        Matriz game = new Matriz();
        game.Play();
        }
    }





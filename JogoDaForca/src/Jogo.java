
import java.util.Scanner;
import java.util.Random;

public class Jogo {
	 public static void main(String[] args) {
	    	Scanner ler = new Scanner(System.in);
	    	Random gerador = new Random();
	    	
	    	int opcao;
	    	String[][] palavras = new String[50][50];
	    	
	    	System.out.println("Selecione o n�mero da op��o desejada:");
	    	System.out.println("1. Jogar\n" + "2. Gerenciar temas\n" + "3. Gerenciar palavras\n" + "4. Sair\n");
	    	opcao = ler.nextInt();
	    	
	    	while(opcao != 4) {	
	    		
	    		if(opcao == 1) {
	    			System.out.println("Vamos jogar!");
	    			System.out.println("Escolha o tema:");
	    			String tema = ler.next();

	    			int posicaoDoTema = 0;
	    			int l=0;
	    			boolean achouTema = false;
	    			while(l < 50) {
	    				if(tema.equals(palavras[l][0])){
	    					achouTema = true;
	    					posicaoDoTema = l;
	    					int numeroSorteado = gerador.nextInt(50); 
	    					while(palavras[posicaoDoTema][numeroSorteado] == null) { 
	    						numeroSorteado = gerador.nextInt(50); 
	    					}
	    					if(numeroSorteado == 0) {
	    						numeroSorteado++; 
	    					}
	    					 
	    					String str = palavras[posicaoDoTema][numeroSorteado];
	    					System.out.print("|");
	    					for(int o = 0; o<str.length(); o++) {
	    						System.out.print(" _ ");
	    					}
	    					System.out.print("|\n");
	    					
	    					System.out.println("Palavra sorteada! Voc� pode errar 5 vezes, boa sorte.");
	    					int erros = 0;
	    					int acertos = 0;
	    					boolean achou = false;
	    					while(erros != 5) {
	    						System.out.println("Digite uma letra: ");
	    						String letra = ler.next();
	    						char[] charSearch = letra.toCharArray();
	    				        for(int i=0; i<str.length(); i++){
	    				            char chr = str.charAt(i); 	
	    				            if(charSearch[0] == chr){ 
	    				            	System.out.println("Existe a letra " + charSearch[0] + " na posi��o:" + (i+1));
	    				            	achou = true;
	    				            	acertos++;    
	    				            }	
	    				        }
	    				        if (erros == str.length()) {
	    				        	System.out.println("Voc� perdeu!");
	    				        	break;
	    				        }
	    				        if(achou == false) { 
	    				        	System.out.println("N�o existe a letra '" + letra + "' na palavra");
	    				        	erros++;
	    				        	System.out.println("Voc� tem mais " + (5-erros) + " tentativas");
	    				        }
	    				        
	    				        if(acertos == str.length()){ 
	    				        	System.out.println("Parab�ns! Voc� conseguiu acertar a palavra: " + palavras[posicaoDoTema][numeroSorteado]);
	    				        	break;
	    				        }
	    				        achou = false;
	    					}
	    				}
	    				if(achouTema == true) {
	    					System.out.println("\nDeseja jogar novamente? \n1. Sim \n2. N�o");
	    					int novamente = ler.nextInt();
	    					if(novamente == 1) {
	    						System.out.println("Voc� selecionou jogar novamente\n");
	    					} else if( novamente == 2 )  {
	    						System.out.println("Voc� selecionou n�o jogar novamente");
	    						System.out.println("Obrigada por participar :D\n\n");
	    						break;
	    					} else {
	    						System.out.println("Op��o n�o dispon�vel");
	    						break;
	    					}
	    				}
	    				if(l == 49) {
	    					System.out.println("Tema n�o cadastrado, volte e cadastre o tema e as palavras antes de jogar!");
	    				}
	    				l++;
	    			}
	    				
	    		}else if(opcao == 2) {
	    			System.out.println("Voc� selecionou gerenciar temas");
	    			System.out.println("Selecione o n�mero da op��o desejada:");
	    			System.out.println("1. Cadastrar temas\n" + "2. Exluir temas\n" + "3. Buscar temas\n" + "4. Voltar\n");
	    			opcao = ler.nextInt();
	    			while(opcao != 4) {    				
	    				if(opcao == 1) {
	    					System.out.println("Voc� optou por cadastrar temas");
	    					for(int i = 0; i<50;i++) {
	    						if(palavras[i][0] == null) {
	    							System.out.println("Digite o tema que deseja cadastrar:");
	    							String tema = ler.next();
	    							for(int j = 0; j<50; j++) {
	    								if(tema.equals(palavras[j][0])){ 
	    									System.out.println("Tema j� cadastrado, tente outro\n");
	    									break;
	    								}
	    								if(j == 49) {    									
	    									palavras[i][0] = tema;
	    									System.out.println("Voc� cadastrou o tema: " + palavras[i][0] + " na posi��o " + i + "\n");
	    								}
	    							}
	    							
	    							System.out.println("\nVoltamos para o menu de edi��o de temas: ");
	    							break;
	    						}
	    						if( i == 49 && palavras[i][0] != null) {
	    							System.out.println("Limite de temas cadastrados atingidos, tente excluir algum e tente novamente");
	    							break;
	    						}
	    					}
	    				}else if(opcao == 2) {
	    					System.out.println("Voc� optou por deletar temas");
	    					System.out.println("Digite o tema que deseja deletar: ");
	    					String tema = ler.next();
	    					boolean achouTema = false;
	    					int chaveDeConfirmacao = 0;
	    					for(int i = 0; i<50; i++) { 
	    						if(tema.equals(palavras[i][0])) { 
	    							for(int h = 1; h<50; h++) {
	    								if(palavras[i][h] != null) {
	    									System.out.println("N�o � poss�vel deletar o tema pois h� palavras cadastradas, exlua as palavras primeiro!");
	    									chaveDeConfirmacao = 1;
	    									break;
	    								}
	    							}
	    							if(chaveDeConfirmacao == 0) {
	    								palavras[i][0] = null;
	    								achouTema = true;
	    								System.out.println("Tema deletado com sucesso\n");
	    								break;
	    							}
	    						}
	    						if(achouTema == false && i == 49) {
	    							System.out.println("Tema n�o encontrado\n");
	    						}
	    					}
	    					System.out.println("Voltamos para o menu de edi��o de temas: ");
	    				}else if(opcao == 3) {
	    					System.out.println("Voc� optou por buscar temas");
	    					System.out.println("Digite o tema\n");
	    					String word = ler.next();
	    					boolean achou = false;
	    					for(int i=0; i<50; i++) {
	    						if(word.equals(palavras[i][0])) {
	    							System.out.println("O tema foi encontrado na posi��o: " + i + "\n");
	    							achou = true;
	    							break;
	    						}
	    					}
	    					if(achou == false) {
	    						System.out.println("Tema n�o encontrado");
	    					}
	    				}else if(opcao == 4) {
	    					System.out.println("Voc� optou por voltar");
	    					break;
	    				}else {
	    					System.out.println("Op��o n�o dispon�vel, tente novamente");
	    				}
	    				System.out.println("1. Cadastrar temas\n" + "2. Exluir temas\n" + "3. Buscar temas\n" + "4. Voltar\n");
	    				opcao = ler.nextInt();
	    			}
	    		}else if(opcao == 3) {
	    			System.out.println("Voc� selecionou gerenciar palavras");
	    			System.out.println("1. Cadastrar palavras\n" + "2. Exluir palavras\n" + "3. Buscar palavras\n" + "4. Listar palavras\n" +  "5. Voltar\n");
	    			opcao = ler.nextInt(); 
	    			while(opcao!=5) {
	    				if(opcao == 1) {
	    					System.out.println("Voc� selecionou cadastrar palavras");
	    					System.out.println("Digite o tema: ");
	    					String tema = ler.next();
	    					for(int i = 0; i < 50 ;i++) { // procura os temas
	    						if(tema.equals(palavras[i][0])) { 
	    							System.out.println("Digite quantas palavras voc� ir� adicionar: ");
	    							int quantidade = ler.nextInt();
	    							for(int j = 0; j<quantidade; j++) { // loop para acrescentar palavras
	    								System.out.println("Digite uma palavra: ");
	    								String word = ler.next();
	    								boolean repetida = false;
	    								for(int b = 1; b<50; b++) {	// procura espa�os vazios
	    									if(palavras[i][b] == null) { 
	    										for(int v = 1; v<50; v++){ // checa se h� repeti��o 
	    											if (word.equals(palavras[i][v])) { 
	    												System.out.println("Esta palavra j� foi cadastrada, n�o foi poss�vel resgistrar.");
	    												repetida = true;
	    												break;
	    											}
	    										}
	    										if(repetida == false) {	    								
	    											palavras[i][b] = word;
	    										}
	    										break;
	    									}
	    								}
	    							}
	    							System.out.println("Cadastro finalizado!\n");
	    							break;
	    						}
	    					}
	    				}else if(opcao == 2) {
	    					System.out.println("Voc� selecionou excluir palavras\n");
	    					System.out.println("Digite a palavra\n");
	    					String word = ler.next();
	    					boolean achou = false;
	    					for(int i=0; i<50; i++) {
	    						for(int j=0; j<50;j++) {
	    							if(word.equals(palavras[i][j])) {
	    								System.out.println("Palavra excluida");
	    								palavras[i][j] = null;
	    								achou = true;
	    								break;
	    							}
	    						}
	    						if(achou == true) {
	    							break;
	    						}
	    					}
	    					if(achou == false) {
	    						System.out.println("Palavra n�o encontrada");
	    					}
	    				}else if(opcao == 3) {
	    					System.out.println("Voc� selecionou buscar palavras");
	    					System.out.println("Digite a palavra\n");
	    					String word = ler.next();
	    					boolean achou = false;
	    					for(int i=0; i<50; i++) {
	    						for(int j=0; j<50;j++) {
	    							if(word.equals(palavras[i][j])) {
	    								System.out.println("A palavra foi encontrada no tema: " + palavras[i][0]);
	    								achou = true;
	    								break;
	    							}
	    						}
	    						if(achou == true) {
	    							break;
	    						}
	    					}
	    					if(achou == false) {
	    						System.out.println("Palavra n�o encontrada");
	    					}
	    				}else if(opcao == 4){
	    					System.out.println("Voc� selecionou listar palavras:");
	    					for(int s = 0; s<50; s++) {
	    						for(int w=1; w<50; w++) {
	    							if(palavras[s][w] != null) {
	    								System.out.println(palavras[s][w]);
	    							}
	    						}
	    					}
	    				}else {
	    					break;
	    				}
	    				System.out.println("\nVoc� voltou para gerenciar palavras, digite o n�mero da pr�xima op��o");
	    				System.out.println("1. Cadastrar palavras\n" + "2. Exluir palavras\n" + "3. Buscar palavras\n" + "4. Listar palavras\n" +  "5. Voltar\n");
	    				opcao = ler.nextInt(); 
	    			}
	    		}else if(opcao == 4) {
	    			System.out.println("Voc� encerrou o jogo");
	    			break;
	    		}else {
	    			System.out.println("Op��o n�o dispon�vel, tente novamente");
	    		}
	    		
	        	System.out.println("1. Jogar\n" + "2. Gerenciar temas\n" + "3. Gerenciar palavras\n" + "4. Sair\n");
	        	opcao = ler.nextInt();
	    	}
	    	
	    }	
}

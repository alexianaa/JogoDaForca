
import java.util.Scanner;
import java.util.Random;

public class Jogo {
	 public static void main(String[] args) {
	    	Scanner ler = new Scanner(System.in);
	    	Random gerador = new Random();
	    	
	    	int opcao;
	    	String[][] palavras = new String[50][50];
	    	
	    	System.out.println("Selecione o número da opção desejada:");
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
	    					
	    					System.out.println("Palavra sorteada! Você pode errar 5 vezes, boa sorte.");
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
	    				            	System.out.println("Existe a letra " + charSearch[0] + " na posição:" + (i+1));
	    				            	achou = true;
	    				            	acertos++;    
	    				            }	
	    				        }
	    				        if (erros == str.length()) {
	    				        	System.out.println("Você perdeu!");
	    				        	break;
	    				        }
	    				        if(achou == false) { 
	    				        	System.out.println("Não existe a letra '" + letra + "' na palavra");
	    				        	erros++;
	    				        	System.out.println("Você tem mais " + (5-erros) + " tentativas");
	    				        }
	    				        
	    				        if(acertos == str.length()){ 
	    				        	System.out.println("Parabéns! Você conseguiu acertar a palavra: " + palavras[posicaoDoTema][numeroSorteado]);
	    				        	break;
	    				        }
	    				        achou = false;
	    					}
	    				}
	    				if(achouTema == true) {
	    					System.out.println("\nDeseja jogar novamente? \n1. Sim \n2. Não");
	    					int novamente = ler.nextInt();
	    					if(novamente == 1) {
	    						System.out.println("Você selecionou jogar novamente\n");
	    					} else if( novamente == 2 )  {
	    						System.out.println("Você selecionou não jogar novamente");
	    						System.out.println("Obrigada por participar :D\n\n");
	    						break;
	    					} else {
	    						System.out.println("Opção não disponível");
	    						break;
	    					}
	    				}
	    				if(l == 49) {
	    					System.out.println("Tema não cadastrado, volte e cadastre o tema e as palavras antes de jogar!");
	    				}
	    				l++;
	    			}
	    				
	    		}else if(opcao == 2) {
	    			System.out.println("Você selecionou gerenciar temas");
	    			System.out.println("Selecione o número da opção desejada:");
	    			System.out.println("1. Cadastrar temas\n" + "2. Exluir temas\n" + "3. Buscar temas\n" + "4. Voltar\n");
	    			opcao = ler.nextInt();
	    			while(opcao != 4) {    				
	    				if(opcao == 1) {
	    					System.out.println("Você optou por cadastrar temas");
	    					for(int i = 0; i<50;i++) {
	    						if(palavras[i][0] == null) {
	    							System.out.println("Digite o tema que deseja cadastrar:");
	    							String tema = ler.next();
	    							for(int j = 0; j<50; j++) {
	    								if(tema.equals(palavras[j][0])){ 
	    									System.out.println("Tema já cadastrado, tente outro\n");
	    									break;
	    								}
	    								if(j == 49) {    									
	    									palavras[i][0] = tema;
	    									System.out.println("Você cadastrou o tema: " + palavras[i][0] + " na posição " + i + "\n");
	    								}
	    							}
	    							
	    							System.out.println("\nVoltamos para o menu de edição de temas: ");
	    							break;
	    						}
	    						if( i == 49 && palavras[i][0] != null) {
	    							System.out.println("Limite de temas cadastrados atingidos, tente excluir algum e tente novamente");
	    							break;
	    						}
	    					}
	    				}else if(opcao == 2) {
	    					System.out.println("Você optou por deletar temas");
	    					System.out.println("Digite o tema que deseja deletar: ");
	    					String tema = ler.next();
	    					boolean achouTema = false;
	    					int chaveDeConfirmacao = 0;
	    					for(int i = 0; i<50; i++) { 
	    						if(tema.equals(palavras[i][0])) { 
	    							for(int h = 1; h<50; h++) {
	    								if(palavras[i][h] != null) {
	    									System.out.println("Não é possível deletar o tema pois há palavras cadastradas, exlua as palavras primeiro!");
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
	    							System.out.println("Tema não encontrado\n");
	    						}
	    					}
	    					System.out.println("Voltamos para o menu de edição de temas: ");
	    				}else if(opcao == 3) {
	    					System.out.println("Você optou por buscar temas");
	    					System.out.println("Digite o tema\n");
	    					String word = ler.next();
	    					boolean achou = false;
	    					for(int i=0; i<50; i++) {
	    						if(word.equals(palavras[i][0])) {
	    							System.out.println("O tema foi encontrado na posição: " + i + "\n");
	    							achou = true;
	    							break;
	    						}
	    					}
	    					if(achou == false) {
	    						System.out.println("Tema não encontrado");
	    					}
	    				}else if(opcao == 4) {
	    					System.out.println("Você optou por voltar");
	    					break;
	    				}else {
	    					System.out.println("Opção não disponível, tente novamente");
	    				}
	    				System.out.println("1. Cadastrar temas\n" + "2. Exluir temas\n" + "3. Buscar temas\n" + "4. Voltar\n");
	    				opcao = ler.nextInt();
	    			}
	    		}else if(opcao == 3) {
	    			System.out.println("Você selecionou gerenciar palavras");
	    			System.out.println("1. Cadastrar palavras\n" + "2. Exluir palavras\n" + "3. Buscar palavras\n" + "4. Listar palavras\n" +  "5. Voltar\n");
	    			opcao = ler.nextInt(); 
	    			while(opcao!=5) {
	    				if(opcao == 1) {
	    					System.out.println("Você selecionou cadastrar palavras");
	    					System.out.println("Digite o tema: ");
	    					String tema = ler.next();
	    					for(int i = 0; i < 50 ;i++) { // procura os temas
	    						if(tema.equals(palavras[i][0])) { 
	    							System.out.println("Digite quantas palavras você irá adicionar: ");
	    							int quantidade = ler.nextInt();
	    							for(int j = 0; j<quantidade; j++) { // loop para acrescentar palavras
	    								System.out.println("Digite uma palavra: ");
	    								String word = ler.next();
	    								boolean repetida = false;
	    								for(int b = 1; b<50; b++) {	// procura espaços vazios
	    									if(palavras[i][b] == null) { 
	    										for(int v = 1; v<50; v++){ // checa se há repetição 
	    											if (word.equals(palavras[i][v])) { 
	    												System.out.println("Esta palavra já foi cadastrada, não foi possível resgistrar.");
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
	    					System.out.println("Você selecionou excluir palavras\n");
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
	    						System.out.println("Palavra não encontrada");
	    					}
	    				}else if(opcao == 3) {
	    					System.out.println("Você selecionou buscar palavras");
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
	    						System.out.println("Palavra não encontrada");
	    					}
	    				}else if(opcao == 4){
	    					System.out.println("Você selecionou listar palavras:");
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
	    				System.out.println("\nVocê voltou para gerenciar palavras, digite o número da próxima opção");
	    				System.out.println("1. Cadastrar palavras\n" + "2. Exluir palavras\n" + "3. Buscar palavras\n" + "4. Listar palavras\n" +  "5. Voltar\n");
	    				opcao = ler.nextInt(); 
	    			}
	    		}else if(opcao == 4) {
	    			System.out.println("Você encerrou o jogo");
	    			break;
	    		}else {
	    			System.out.println("Opção não disponível, tente novamente");
	    		}
	    		
	        	System.out.println("1. Jogar\n" + "2. Gerenciar temas\n" + "3. Gerenciar palavras\n" + "4. Sair\n");
	        	opcao = ler.nextInt();
	    	}
	    	
	    }	
}

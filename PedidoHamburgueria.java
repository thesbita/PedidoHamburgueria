import java.util.Scanner;

/* @author: Emanuelle Thesbita 
@version 1.0 2023.11.19 
* O código apresenta um bug que, quando se tem mais de 1 combo, ele só revisa 
* o pedido do último combo e, não dos anteriores :(
*/
public class PedidoHamburgueria {
    public static void main(String[] args) {
        fazerPedido();
    }

    public static void fazerPedido() {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Quantos combos você deseja pedir? (0 a 100): ");
            int quantidadeCombos = scanner.nextInt();
            scanner.nextLine(); 

            for (int i = 1; i <= quantidadeCombos; i++) {
                System.out.println("Combo " + i + ":");

                int opcaoHamburguer = escolherOpcao(scanner, "Hamburguer");
                int opcaoAcompanhamento = 0;
                int opcaoBebida = 0;

                char escolhaAcompanhamento = obterEscolha(scanner, "Deseja adicionar um acompanhamento? (S/N): ");
                if (escolhaAcompanhamento == 'S' || escolhaAcompanhamento == 's') {
                    opcaoAcompanhamento = escolherOpcao(scanner, "Acompanhamento");
                }

                char escolhaBebida = obterEscolha(scanner, "Deseja adicionar uma bebida? (S/N): ");
                if (escolhaBebida == 'S' || escolhaBebida == 's') {
                    opcaoBebida = escolherOpcao(scanner, "Bebida");
                }

                exibirRevisaoPedido(opcaoHamburguer, opcaoAcompanhamento, opcaoBebida);
            }

            char confirmacao = obterEscolha(scanner, "Deseja confirmar o pedido? (S/N): ");
            if (confirmacao == 'S' || confirmacao == 's') {
                System.out.println("Agradecemos pela preferência! Pedido confirmado.");
                break;
            }

            char fazerOutroPedido = obterEscolha(scanner, "Pedido cancelado. Deseja fazer outro pedido? (S/N): ");
            if (fazerOutroPedido != 'S' && fazerOutroPedido != 's') {
                System.out.println("Agradecemos pela visita!");
                break;
            }

        } while (true);

        scanner.close();
    }

    public static int escolherOpcao(Scanner scanner, String categoria) {
        System.out.println("Escolha o " + categoria + ":");
        exibirOpcoes(categoria);
        int opcao = scanner.nextInt();
        scanner.nextLine(); 
        exibirOpcaoEscolhida(categoria, opcao);
        return opcao;
    }

    public static char obterEscolha(Scanner scanner, String mensagem) {
        System.out.println(mensagem);
        return scanner.next().charAt(0);
    }

    public static void exibirRevisaoPedido(int opcaoHamburguer, int opcaoAcompanhamento, int opcaoBebida) {
        System.out.println("Revisão do Pedido:");
        exibirOpcaoEscolhida("Hamburguer", opcaoHamburguer);
        
        if (opcaoAcompanhamento != 0) {
            exibirOpcaoEscolhida("Acompanhamento", opcaoAcompanhamento);
        }

        if (opcaoBebida != 0) {
            exibirOpcaoEscolhida("Bebida", opcaoBebida);
        }
    }

    public static void exibirOpcoes(String categoria) {
        switch (categoria) {
            case "Hamburguer":
                System.out.println("01 - Burguer de Shimeji");
                System.out.println("02 - Burguer de Frango");
                System.out.println("03 - Burguer da Casa");
                System.out.println("04 - Burguer Receita Secreta");
                break;
            case "Acompanhamento":
                System.out.println("00 - Batata canoa temperada com maionese verde");
                System.out.println("56 - Nuggets de frango");
                System.out.println("14 - Salada Caesar");
                break;
            case "Bebida":
                System.out.println("22 - Refrigerante");
                System.out.println("18 - Suco");
                System.out.println("12 - Água");
                System.out.println("26 - Milkshake");
                break;
            default:
                System.out.println("Opções indisponíveis.");
                break;
        }
    }

    public static void exibirOpcaoEscolhida(String categoria, int opcao) {
        switch (categoria) {
            case "Hamburguer":
                switch (opcao) {
                    case 1:
                        System.out.println("Burguer de Shimeji selecionado.");
                        break;
                    case 2:
                        System.out.println("Burguer de Frango selecionado.");
                        break;
                    case 3:
                        System.out.println("Burguer da Casa selecionado.");
                        break;
                    case 4:
                        System.out.println("Burguer Receita Secreta selecionado.");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                        break;
                }
                break;
            case "Acompanhamento":
                switch (opcao) {
                    case 0:
                        System.out.println("Batata canoa temperada com maionese verde selecionada.");
                        break;
                    case 56:
                        System.out.println("Nuggets de frango selecionados.");
                        break;
                    case 14:
                        System.out.println("Salada Caesar selecionada.");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                        break;
                }
                break;
            case "Bebida":
                switch (opcao) {
                    case 22:
                        System.out.println("Refrigerante selecionado.");
                        break;
                    case 18:
                        System.out.println("Suco selecionado.");
                        break;
                    case 12:
                        System.out.println("Água selecionada.");
                        break;
                    case 26:
                        System.out.println("Milkshake selecionado.");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                        break;
                }
                break;
            default:
                System.out.println("Categoria inválida.");
                break;
        }
    }
}

import java.util.Scanner;

public class trabalhoFinal {
    public static Scanner input = new Scanner(System.in);

    public static void incluirCliente(int j, String[] nome, String[] cpf, String[] dataNascimento) {
        for (int i = j; i <= j; i++) {
            System.out.println("\nDigite o nome: ");
            System.out.print("> ");
            nome[i] = input.nextLine();
            while (nome[i].equals("")) {
                System.out.println("O campo nome deve ser preenchido! Por favor, digite novamente:");
                System.out.print("> ");
                nome[i] = input.nextLine();
            }
            System.out.println("Digite o CPF: ");
            System.out.print("> ");
            cpf[i] = input.nextLine();
            while (cpf[i].equals("")) {
                System.out.println("O campo CPF deve ser preenchido! Por favor, digite novamente: ");
                System.out.print("> ");
                cpf[i] = input.nextLine();
            }
            // validação do CPF
            int g = 0, h = i - 1;
            for (int k = i - 1; k >= 0; k--) {
                if (cpf[i].equals(cpf[k]) || cpf[i].equals(cpf[g])) {
                    do {
                        System.out.println("CPF já cadastrado! Por favor, digite novamente: ");
                        System.out.print("> ");
                        cpf[i] = input.nextLine();
                        if (cpf[g] != null)
                            g++;
                        if (cpf[g] != null && cpf[g + 1] == null) {
                            g = 0;
                            h++;
                        }
                        if (h > 0)
                            h--;

                    } while (cpf[i].equals(cpf[k]) || cpf[i].equals(cpf[g]) || cpf[i].equals(cpf[h]));
                }
            }

            System.out.println("Digite a data de nascimento: [dia/mês/ano]");
            System.out.print("> ");
            dataNascimento[i] = input.nextLine();
            while (dataNascimento[i].equals("")) {
                System.out.println("O campo data de nascimento deve ser preenchido! Por favor, digite novamente:");
                System.out.print("> ");
                dataNascimento[i] = input.nextLine();
            }
        }

    }

    public static int consultarCliente(String[] nome, String[] cpf, String[] dataNascimento) {
        int k = -1;
        if (cpf[0] == null) {
            System.out.println("\nNenhum cliente cadastrado!");
        } else {
            System.out.println("\nDigite o CPF do cliente: ");
            System.out.print("=> ");
            String cpfConsultar = input.nextLine();
            for (int i = 0; i < 10; i++) {
                if (cpfConsultar.equals(cpf[i])) {
                    k = i;
                    for (int j = k; j <= k; j++) {
                        System.out.println("Nome: " + nome[j]);
                        System.out.println("Data de Nascimento: " + dataNascimento[j]);
                        break;
                    }
                } else if (i == 9 && k == -1) {
                    System.out.println("Cliente Inexistente");
                    break;
                }
            }
        }
        return k;
    }

    public static void ExcluirCliente(String[] nome, String[] cpf, String[] dataNascimento) {
        if (cpf[0] == null)
            System.out.println("Nenhum cliente cadastrado!");

        else {
            int k = consultarCliente(nome, cpf, dataNascimento);
            char resposta = ' ';
            if (k == -1)
                System.out.println("CPF inválido!");
            else {
                while (resposta != 'S' && resposta != 'N') {
                    System.out.println("Tem certeza que deseja exlcuir o cliente? [S/N]");
                    System.out.print("=> ");
                    resposta = input.nextLine().toUpperCase().charAt(0);
                    if (resposta == 'S') {
                        for (int i = k; i <= k; i++) {
                            nome[i] = null;
                            cpf[i] = null;
                            dataNascimento[i] = null;

                            if (nome[i] == null && nome[i + 1] != null) {
                                for (int j = k; j < nome.length; j++) {
                                    if (j >= 0 && j < 8)
                                        nome[j] = nome[j + 1];
                                    if (j == 9)
                                        nome[j] = null;
                                }
                            }
                            if (cpf[i] == null && cpf[i + 1] != null) {
                                for (int j = k; j < cpf.length; j++) {
                                    if (j >= 0 && j < 8)
                                        cpf[j] = cpf[j + 1];
                                    if (j == 9)
                                        cpf[j] = null;
                                }
                            }
                            if (dataNascimento[i] == null && dataNascimento[i + 1] != null) {
                                for (int j = k; j < dataNascimento.length; j++) {
                                    if (j >= 0 && j < 8)
                                        dataNascimento[j] = dataNascimento[j + 1];
                                    if (j == 9)
                                        dataNascimento[j] = null;
                                }
                            }
                        }

                        System.out.println("Cliente removido.");
                    } else if (resposta == 'N')
                        System.out.println("Exclusão cancelada.");
                }
            }
        }
    }

    public static void AlterarCliente(String[] nome, String[] cpf, String[] dataNascimento) {
        if (cpf[0] == null)
            System.out.println("Nenhum cliente cadastrado!");

        else {
            int k = consultarCliente(nome, cpf, dataNascimento);
            char resposta = ' ';
            if (k == -1)
                System.out.println("CPF inválido!");
            else {
                while (resposta != 'S' && resposta != 'N') {
                    System.out.println("\nTem certeza que deseja alterar o cliente? [S/N]");
                    System.out.print("=> ");
                    resposta = input.nextLine().toUpperCase().charAt(0);
                    if (resposta == 'S') {
                        for (int i = k; i <= k; i++) {
                            System.out.println("Digite o novo nome: ");
                            System.out.print("> ");
                            nome[i] = input.nextLine();
                            System.out.println("Digite a nova data de nascimento: ");
                            System.out.print("> ");
                            dataNascimento[i] = input.nextLine();

                        }

                        System.out.println("Cliente alterado.");
                    } else if (resposta == 'N')
                        System.out.println("Alteração cancelada.");
                }
            }
        }

    }

    public static void ListarCliente(String[] nome, String[] cpf, String[] dataNascimento) {
        for (int i = 0; i < 10; i++) {
            while (cpf[i] != null && nome[i] != null && dataNascimento[i] != null) {
                System.out.println("\n" + (i + 1) + "º Cliente:");
                System.out.println("> CPF: " + cpf[i]);
                System.out.println("> Nome: " + nome[i]);
                System.out.println("> Data de Nascimento: " + dataNascimento[i]);
                break;
            }

        }
    }

    public static void main(String[] args) {
        int j = 0;
        String[] nome = new String[10];
        String[] cpf = new String[10];
        String[] dataNascimento = new String[10];
        char opcao = 'A';
        while (opcao != 'S') {
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("\t MENU \n");
            System.out.println("[I] - Incluir Cliente");
            System.out.println("[C] - Consultar Cliente");
            System.out.println("[E] - Excluir Cliente");
            System.out.println("[A] - Alterar Cliente");
            System.out.println("[L] - Listar Cliente");
            System.out.println("[S] - Sair");
            System.out.print("> ");
            opcao = input.nextLine().toUpperCase().charAt(0);
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            if (opcao != 'I' && opcao != 'C' && opcao != 'E' && opcao != 'A' && opcao != 'L' && opcao != 'S') {
                System.out.println("Opção inválida!");
            } else if (opcao == 'I') {
                System.out.println("\t~> CADASTRO <~");
                incluirCliente(j, nome, cpf, dataNascimento);
                j++;
            } else if (opcao == 'C') {
                System.out.println("\t~> CONSULTAR CLIENTE <~");
                consultarCliente(nome, cpf, dataNascimento);

            } else if (opcao == 'E') {
                System.out.println("\t~> EXCLUIR CLIENTE <~");
                ExcluirCliente(nome, cpf, dataNascimento);

            } else if (opcao == 'A') {
                System.out.println("\t~> ALTERAR CLIENTE <~");
                AlterarCliente(nome, cpf, dataNascimento);

            } else if (opcao == 'L') {
                System.out.println("\t~> LISTAR CLIENTE <~");
                ListarCliente(nome, cpf, dataNascimento);
            }
        }
        System.out.println("[S] - Sair selecionado! Encerrando...");
    }
}

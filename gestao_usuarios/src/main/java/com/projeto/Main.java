package com.projeto;

import com.projeto.controller.*;

import java.util.Scanner;

public final class Main {
    static UsuarioController usuarioController = new UsuarioController();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        boolean repetir = true;

        do {
            usuarioController.limparTela();

            System.out.println("Bem vindo ao programa de gestão de usuários!");
            System.out.println("--------------------------------------------\n");
            System.out.println("1 - Listar usuários cadastrados.");
            System.out.println("2 - Buscar usuário pelo ID.");
            System.out.println("3 - Cadastrar um novo usuário.");
            System.out.println("4 - Alterar um usuário.");
            System.out.println("5 - Remover um usuário.");
            System.out.println("6 - Sair do programa.\n");
            System.out.println("");
            System.out.print("Por favor, digite a opção desejada: ");
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    usuarioController.limparTela();

                    usuarioController.listarUsuarios();

                    System.out.print("\nAperte Enter para retornar ao menu...");
                    scanner.nextLine();
                    break;
                case "2":
                    usuarioController.limparTela();

                    try {
                        usuarioController.buscarUsuario();
                    } catch (Exception e) {
                        System.out.println("\nErro ao buscar o usuário: " + e);
                    }

                    System.out.print("\nAperte Enter para retornar ao menu...");
                    scanner.nextLine();
                    break;
                case "3":
                    usuarioController.limparTela();

                    try {
                        usuarioController.cadastrarUsuario();
                    } catch (Exception e) {
                        System.out.println("\nErro no cadastro do usuário: " + e);
                    }

                    System.out.print("\nAperte Enter para retornar ao menu...");
                    scanner.nextLine();
                    break;
                case "4":
                    usuarioController.limparTela();

                    try {
                        usuarioController.atualizarUsuario();
                    } catch (Exception e) {
                        System.out.println("\nErro na atualização do usuário: " + e);
                    }

                    System.out.print("\nAperte Enter para retornar ao menu...");
                    scanner.nextLine();
                    break;
                case "5":
                    usuarioController.limparTela();

                    try {
                        usuarioController.removerUsuario();
                    } catch (Exception e) {
                        System.out.println("\nErro ao tentar remover o usuário: " + e);
                    }

                    System.out.print("\nAperte Enter para retornar ao menu...");
                    scanner.nextLine();
                    break;
                case "6":
                    repetir = false;
                    break;
                default:
                    usuarioController.limparTela();
                    break;
            }
        } while (repetir);
    }
}

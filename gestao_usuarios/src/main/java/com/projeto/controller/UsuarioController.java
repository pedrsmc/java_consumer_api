package com.projeto.controller;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.projeto.model.Usuario;
import com.projeto.service.*;

public class UsuarioController {
    UsuarioServices usuarioServices = new UsuarioServices();
    static Scanner scanner = new Scanner(System.in);

    public void listarUsuarios() throws Exception {
        List<Usuario> usuarios = usuarioServices.listarUsuarios();
        int quantidade = usuarios.size();

        usuarios.forEach(usuario -> {
            System.out.print(usuario);
            System.out.println("-----------------------------------------");
        });

        System.out.println("\nTotal de usuários: " + quantidade + "\n");
    }

    public void buscarUsuario() throws Exception {
        System.out.print("Digite o ID do usuário: ");
        String id = scanner.nextLine();
        System.out.println("-------------------------------------------------------------");

        Usuario usuario = usuarioServices.buscarUsuario(id);

        System.out.println("\n" + usuario);
    }

    public void cadastrarUsuario() throws Exception {
        Usuario usuario = new Usuario();

        System.out.print("Nome: ");
        usuario.setNome(scanner.nextLine());

        System.out.print("Email: ");
        usuario.setEmail(scanner.nextLine());

        System.out.print("Telefone: ");
        usuario.setTel(scanner.nextLine());

        System.out.print("Idade: ");
        usuario.setIdade(scanner.nextInt());
        scanner.nextLine();

        Usuario criado = usuarioServices.cadastrarUsuario(usuario);

        System.out.println("------------------------------------------");
        System.out.println("Usuario criado:");
        System.out.println(criado);
    }

    public void atualizarUsuario() throws Exception {
        System.out.print("Digite o ID do usuário: ");
        String id = scanner.nextLine();
        System.out.println("------------------------------------------------------------\n");

        Usuario usuario = usuarioServices.buscarUsuario(id);

        System.out.println(usuario);
        System.out.println("\n------------------------------------------------------------");

        while (true) {
            System.out.print("Você irá alterar o usuário em questão, deseja prosseguir? (S/N): ");
            String confirma = scanner.nextLine();

            if (confirma.equalsIgnoreCase("S")) {
                System.out.print("Nome: ");
                usuario.setNome(scanner.nextLine());

                System.out.print("Email: ");
                usuario.setEmail(scanner.nextLine());

                System.out.print("Telefone: ");
                usuario.setTel(scanner.nextLine());

                System.out.print("Idade: ");
                usuario.setIdade(scanner.nextInt());
                scanner.nextLine();

                usuarioServices.alterarUsuario(id, usuario);
                System.out.println("Usuário alterado com sucesso!");
                break;

            } else if (confirma.equalsIgnoreCase("N")) {
                System.out.println("Alteração cancelada!");
                return;

            } else {
                System.out.println("Opção inválida! Digite S para sim ou N para não.");
            }
        }
    }

    public void removerUsuario() throws Exception {
        System.out.print("Digite o ID do usuário: ");
        String id = scanner.nextLine();

        Usuario usuario = usuarioServices.buscarUsuario(id);

        System.out.println("------------------------------------------------------------\n");
        System.out.print(usuario);
        System.out.println("\n------------------------------------------------------------");

        while (true) {
            System.out.print("Você removerá o usuário em questão, deseja prosseguir? (S/N): ");
            String confirma = scanner.nextLine();

            if (confirma.equalsIgnoreCase("S")) {
                int resposta = usuarioServices.removerUsuario(id);

                if (resposta == 200) {
                    System.out.println("Remoção feita com sucesso!");
                }
                break;

            } else if (confirma.equalsIgnoreCase("N")) {
                System.out.println("Remoção cancelada!");
                return;

            } else {
                System.out.println("Opção inválida! Digite S para sim ou N para não.");
            }
        }
    }

    public void limparTela() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
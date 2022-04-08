package main.java.view;

import main.java.controller.ControllerGenero;
import main.java.entity.GenreEntity;

import java.io.*;
import java.util.Scanner;

/**
 * Exemplo de como fazer a leitura e escrita em arquivos texto com Java
 */
public class RunLocadora {


    /**
     * Escreve uma String em um arquivo texto, cujo nome fora passado via parâmetro
     *
     * @param nome  nome do arquivo texto
     * @param linha linha a ser escrita no arquivo texto
     */
    public static void abrirArquivoParaEscrita(String nome, String linha) {
        FileWriter fwArquivo;
        BufferedWriter bwArquivo;
        try {
            File arquivo = new File(nome);

            //Se o arquivo já existir, então abrir para concatenação, caso contrário criar novo arquivo
            fwArquivo = new FileWriter(arquivo, arquivo.exists());
            bwArquivo = new BufferedWriter(fwArquivo);


            // escrevendo String no arquivo e adicionando caracter para criar nova linha
            bwArquivo.write(linha + '\n');


            // fechando o arquivo
            bwArquivo.close();
            fwArquivo.close();

        } catch (IOException e) {
            System.err.println("Erro ao tentar escrever no arquivo: " + e.toString());
        }
    }

    /**
     * Imprime no dispositivo de saída padrão o conteúdo do arquivo texto, cujo nome fora passado via parâmetro
     *
     * @param nome nome do arquivo texto
     */
    public static void lerConteudoDeArquivo(String nome) {
        File arquivo = new File(nome);

        try {
            Scanner leitor = new Scanner(arquivo);

            // varrendo o conteúdo do arquivo linha por linha
            while (leitor.hasNextLine()) {
                System.out.println(leitor.nextLine());
            }

        } catch (FileNotFoundException e) {
            System.err.println("Erro ao tentar ler o arquivo: " + e.toString());
        }
    }


    public static void main(String[] args) {

       /* String nomeDoArquivo = "c:\\tmp\\java-arquivo.txt";

        // Escrevendo algumas linhas no arquivo

        System.out.println("Escrevendo no arquivo");

        abrirArquivoParaEscrita(nomeDoArquivo, "Olá mundo");
        abrirArquivoParaEscrita(nomeDoArquivo, "Segunda linha");
        abrirArquivoParaEscrita(nomeDoArquivo, "Fim do arquivo.");

        System.out.println("Fim da escrita!");
        // Selecione as Opçoes :
        // 1 - Cdastrar clientes
        //2 - cadastrar filmes
        // 3 cadasatrar usuaurio
        // 4- cadastrar locacao
        // 5 - listar files
        // 6 - listar locacoes*/

        System.out.println("Menu Locadora..........: ");

        System.out.print("1 - Cadastrar Filme...: ");
        System.out.print("2 - Cadastrar Cliente...: ");
        System.out.print("3 - Cadastrar Locacao...: ");



       // System.out.println("2 - ..........: ");
     //   System.out.print("3 - ..........: ");
        Scanner entrada = new Scanner(System.in);
        String linha = entrada.nextLine();
        System.out.println("Opção.........: " + linha);


        int opcao = Integer.valueOf(linha);


        if (opcao == 1) {

            // accessa a controller
            ControllerGenero controllerGenero = new ControllerGenero();


            System.out.println("1.1 - Inserir id...: ");
            entrada = new Scanner(System.in);
            String id = entrada.nextLine();

            System.out.println("1.1 - Inserir nome...: ");
            entrada = new Scanner(System.in);
            String nome = entrada.nextLine();

            GenreEntity genero = new GenreEntity(Integer.parseInt(id),nome);
            controllerGenero.preSalvar(genero);
            System.out.println("GenreEntity inserido com sucesso!");

        }


        // Fazendo a leitura das linhas do arquivo


        System.out.println("--------------------------");
        System.out.println("Lendo conteúdo do arquivo");

        //lerConteudoDeArquivo(nomeDoArquivo);

        System.out.println("--------------------------");


    }

}

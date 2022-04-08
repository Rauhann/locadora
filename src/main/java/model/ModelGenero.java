package main.java.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import main.java.entity.GenreEntity;

public class ModelGenero {
    private static final String file = "c:\\tmp\\genero.txt";

    public String getArquivo() {
        return file;
    }

    public void salvar(GenreEntity genero) {
        abrirArquivoParaEscrita(getArquivo(), String.valueOf(genero.getId()));
        abrirArquivoParaEscrita(getArquivo(), genero.getNome());
    }

    public static void abrirArquivoParaEscrita(String nome, String linha) {
        FileWriter fwArquivo;
        BufferedWriter bwArquivo;
        try {
            File arquivo = new File(nome);

            fwArquivo = new FileWriter(arquivo, arquivo.exists());
            bwArquivo = new BufferedWriter(fwArquivo);
            bwArquivo.write(linha + '\n');

            // fechando o arquivo
            bwArquivo.close();
            fwArquivo.close();

        } catch (IOException e) {
            System.err.println("Erro ao tentar escrever no arquivo: " + e.toString());
        }
    }
}

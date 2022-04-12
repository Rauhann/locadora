package main.java.view;

import main.java.controller.*;
import main.java.entity.CategoryEntity;
import main.java.entity.GenreEntity;
import main.java.entity.LanguageEntity;
import main.java.entity.ProducerEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class RunAllocation {

    public static void main(String[] args) {

        /**
         * Até o momento a idéia é que o sistema nunca deixa de executar, somente quando o força
         */
        while (true) {
            System.out.println("**********************************************************************");
            System.out.println("MENU LOCADORA");
            System.out.println("**********************************************************************");

            System.out.println("(1) - Cadastrar Cliente");
            System.out.println("(2) - Cadastrar Filme");
            System.out.println("(3) - Cadastrar Usuário");
            System.out.println("(4) - Cadastrar Locação");
            System.out.println("(5) - Listar Filmes");
            System.out.println("(6) - Listar Locações");

            Locale.setDefault(Locale.US);

            try {
                Scanner sc = new Scanner(System.in);
                System.out.print("Opção: ");
                int option = sc.nextInt();

                switch (option) {
                    case 1:
                        System.out.println("Módulo não desenvolvido");
                        break;
                    case 2:
                        System.out.println("---------------------------- CADASTRAR GÊNERO ----------------------------");
                        GenreController genreController = new GenreController();
                        System.out.print("Código: ");
                        int genreCode = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Nome: ");
                        String genreName = sc.nextLine();
                        genreController.save(genreCode, genreName);

                        System.out.println("---------------------------- CADASTRAR IDIOMAS ----------------------------");
                        LanguageController languageController = new LanguageController();
                        List<LanguageEntity> languages = new ArrayList<>();
                        int moreLanguages = 1;
                        while (moreLanguages == 1) {
                            System.out.print("Código: ");
                            int languageCode = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Nome: ");
                            String languageName = sc.nextLine();

                            languageController.save(languageCode, languageName);

                            System.out.print("Existem mais idiomas? (Sim = 1, Não = 0): ");
                            moreLanguages = sc.nextInt();
                            sc.nextLine();
                            languageController.addLanguage(languages, languageCode, languageName);
                        }

                        System.out.println("---------------------------- CADASTRAR PRODUTORA ----------------------------");
                        ProducerController producerController = new ProducerController();
                        System.out.print("Código: ");
                        int producerCode = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Nome: ");
                        String producerName = sc.nextLine();
                        producerController.save(producerCode, producerName);

                        System.out.println("---------------------------- CADASTRAR CATEGORIA ----------------------------");
                        CategoryController categoryController = new CategoryController();
                        System.out.print("Código: ");
                        int categoryCode = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Nome: ");
                        String categoryName = sc.nextLine();
                        System.out.print("Valor: ");
                        double categoryValue = sc.nextDouble();
                        System.out.print("Período: ");
                        int categoryPeriod = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Promoção? (true ou false): ");
                        boolean categoryPromotion = sc.nextBoolean();

                        int categoryPromotionPeriod = 0;
                        if (categoryPromotion) {
                            System.out.print("Período promocional: ");
                            categoryPromotionPeriod = sc.nextInt();
                            sc.nextLine();
                        }

                        categoryController.save(categoryCode, categoryName, categoryValue, categoryPeriod, categoryPromotion, categoryPromotionPeriod);

                        System.out.println("---------------------------- INFORMAÇÕES ADICIONAIS ----------------------------");
                        TitleController titleController = new TitleController();
                        System.out.print("Código: ");
                        int codeTitle = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Título: ");
                        String title = sc.nextLine();
                        System.out.print("Subtítulo: ");
                        String subTitle = sc.nextLine();

                        GenreEntity genre = new GenreEntity(genreCode, genreName);
                        ProducerEntity producer = new ProducerEntity(producerCode, producerName);
                        CategoryEntity category = new CategoryEntity(categoryCode, categoryName, categoryValue, categoryPeriod, categoryPromotion, categoryPromotionPeriod);

                        titleController.save(codeTitle, title, subTitle, genre, languages, producer, category);

                        System.out.println();
                        System.out.println("Filme cadastrado com sucesso!");
                        System.out.println();
                        break;
                    case 3:
                        System.out.println("Módulo não desenvolvido");
                        break;
                    case 4:
                        System.out.println("Módulo não desenvolvido");
                        break;
                    case 5:
                        System.out.println("Módulo não desenvolvido");
                        break;
                    case 6:
                        System.out.println("Módulo não desenvolvido");
                        break;
                    default:
                        System.out.println();
                        System.out.println("Opção inválida!");
                        System.out.println();
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }
}
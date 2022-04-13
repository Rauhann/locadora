package main.java.view;

import main.java.controller.*;
import main.java.entity.*;
import main.java.exceptions.ValidatorException;
import main.java.helpers.StringHelper;

import java.util.*;

public class RunAllocation {

    public static void main(String[] args) throws ValidatorException {

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
                System.out.println();
                System.out.print("Opção: ");
                int option = sc.nextInt();

                switch (option) {
                    case 1:
                        System.out.println("---------------------------- CADASTRAR CLIENTE ----------------------------");
                        ClientController clientController = new ClientController();
                        System.out.print("Código: ");
                        int clientCode = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Nome: ");
                        String clientName = sc.nextLine();
                        System.out.print("CPF: ");
                        String clientCpf = sc.nextLine();

                        System.out.print("Possui cliente responsável? (Sim = 1, Não = 0): ");
                        int hasParentClient = sc.nextInt();
                        sc.nextLine();

                        ClientEntity parentClient = new ClientEntity();
                        if (hasParentClient == 1) {
                            System.out.print("Código responsável: ");
                            int parentClientCode = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Nome responsável: ");
                            String parentClientName = sc.nextLine();
                            System.out.print("CPF responsável: ");
                            String parentClientCpf = sc.nextLine();

                            parentClient.setCode(parentClientCode);
                            parentClient.setName(parentClientName);
                            parentClient.setCpf(parentClientCpf);
                            clientController.save(parentClientCode, parentClientName, parentClientCpf, new ClientEntity());
                        }

                        clientController.save(clientCode, clientName, clientCpf, parentClient);

                        System.out.println();
                        System.out.println("Cliente cadastrado com sucesso!");
                        System.out.println();
                        break;
                    case 2:
                        System.out.println("---------------------------- CADASTRAR GÊNERO ----------------------------");
                        GenreController genreController = new GenreController();
                        System.out.print("Código: ");
                        int genreCode = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Nome: ");
                        String genreName = sc.nextLine();
                        genreName = StringHelper.removeAccents(genreName.toUpperCase());
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
                            languageName = StringHelper.removeAccents(languageName.toUpperCase());
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
                        System.out.print("Promoção? (Sim = 1 ou Não = 0): ");
                        int categoryPromotion = sc.nextInt();

                        int categoryPromotionPeriod = 0;
                        if (categoryPromotion == 1) {
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
                        System.out.println("---------------------------- CADASTRAR USUÁRIO ----------------------------");
                        UserController userController = new UserController();
                        System.out.print("Código: ");
                        int userCode = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Nome: ");
                        String userName = sc.nextLine();
                        System.out.print("Login: ");
                        String userLogin = sc.nextLine();
                        System.out.print("Password: ");
                        String userPass = sc.nextLine();

                        userController.save(userCode, userName, userLogin, userPass, true);

                        System.out.println();
                        System.out.println("Usuário cadastrado com sucesso!");
                        System.out.println();
                        break;
                    case 4:
                        System.out.println("---------------------------- CADASTRAR LOCAÇÃO ----------------------------");
                        LocationController locationController = new LocationController();
                        System.out.print("Código: ");
                        int locationCode = sc.nextInt();
                        sc.nextLine();

                        UserController userController1 = new UserController();
                        List<Integer> arrayUserCodes = userController1.print();

                        if (arrayUserCodes.isEmpty()) {
                            System.out.println();
                            System.out.println("Cadastre um usuário!");
                            break;
                        }

                        System.out.print("Escolha o usuario (Código): ");
                        int locationUser = sc.nextInt();
                        sc.nextLine();

                        while (!userController1.checkExistsInList(arrayUserCodes, locationUser)) {
                            System.out.println();
                            System.out.println("Escolha um usuario existente na lista:");
                            userController1.print();
                            System.out.println();
                            System.out.print("Escolha o usuario (Código): ");
                            locationUser = sc.nextInt();
                            sc.nextLine();
                        }

                        ClientController clientController1 = new ClientController();
                        List<Integer> arrayClientCodes = clientController1.print();

                        if (arrayClientCodes.isEmpty()) {
                            System.out.println();
                            System.out.println("Cadastre um cliente!");
                            break;
                        }

                        System.out.print("Escolha o cliente (Código): ");
                        int locationClient = sc.nextInt();
                        sc.nextLine();

                        while (!clientController1.checkExistsInList(arrayClientCodes, locationClient)) {
                            System.out.println();
                            System.out.println("Escolha um cliente existente na lista:");
                            clientController1.print();
                            System.out.println();
                            System.out.print("Escolha o cliente (Código): ");
                            locationClient = sc.nextInt();
                            sc.nextLine();
                        }

                        TitleController titleController1 = new TitleController();
//                        List<Integer> arrayTitleCodes = titleController1.print();

                        System.out.println();
                        System.out.println("Digite 0 para finalizar a adição de filmes");
                        int locationTitle = 1;
                        List<Integer> titles = new ArrayList<>();

                        while (locationTitle > 0) {
                            System.out.print("Escolha o filme (Código): ");
                            locationTitle = sc.nextInt();
                            sc.nextLine();

//                            while (!titleController1.checkExistsInList(arrayTitleCodes, locationTitle) || locationTitle == 0) {
//                                System.out.println();
//                                System.out.println("Escolha um filme existente na lista:");
//                                titleController1.print();
//                                System.out.println();
//                                System.out.print("Escolha o filme (Código): ");
//                                locationTitle = sc.nextInt();
//                                sc.nextLine();
//                            }

                            titles.add(locationTitle);
                        }

                        locationController.save(locationCode, locationUser, locationClient, titles);

                        System.out.println();
                        System.out.println("Locação realizada com sucesso!");
                        System.out.println();
                        break;
                    case 5:
                        System.out.println();
                        TitleController listTitle = new TitleController();
                        System.out.println(listTitle.list());
                        System.out.println();
                        break;
                    case 6:
                        System.out.println();
                        LocationController locationController1 = new LocationController();
                        System.out.println(locationController1.list());
                        System.out.println();
                        break;
                    default:
                        System.out.println();
                        System.out.println("Opção inválida!");
                        System.out.println();
                }
            } catch (ValidatorException | RuntimeException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}

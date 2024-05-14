package ui;

import controllers.*;
import entity.*;
import dao.criteria.parameter.MaterialParameter;
import dao.criteria.parameter.cupParameters.ColorParameter;
import dao.criteria.parameter.cupParameters.SizeParameter;
import dao.criteria.parameter.plateParameters.PlateColorParameter;
import dao.criteria.parameter.plateParameters.ShapeParameter;
import dao.criteria.parameter.potParameters.TypeParameter;
import dao.criteria.parameter.spoonParameters.SpoonTypeParameter;
import lombok.SneakyThrows;
import ui.impl.AppViewImpl;
import java.util.Map;
import java.util.Scanner;

public class UI extends Constant{
    @SneakyThrows
    public void start() {
        AppViewImpl appView = new AppViewImpl();

        Map<String, String> output;
        CommandController commandController = new CommandController();

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n" + "Start your journey! Enter the command: ");

        // Controllers
        CupController cupController = new CupController();
        PlateController plateController = new PlateController();
        PotController potController = new PotController();
        SpoonController spoonController = new SpoonController();

        //**********************************************//
        //**********  debugging are  ************//



        //**********  debugging are  ************//
        //*********************************************//

        // Listen CMD for commands
        while (true){
            String input = scanner.nextLine();
            System.out.println("{DEBUG: From 60 line}. Input: " + input);
            String command = input.toLowerCase().trim();
            // common commands
            if (command.equals("/exit")){
                appView.endMessage("Goodbye! Have a nice day!");
                break;
            }
            if (command.equals("/help")){
                appView.displayMenu();
            }
            if(command.equals("/tlist")){
                System.out.println("List of Tablewares: " + getGeneralParameter());
            }
            if(command.contains("/search")){
                output = commandController.searchCommand(command);
                System.out.println(output);
                System.out.println(command);
                if (output.containsKey("-t") && output.containsKey("-p") && output.containsKey("-a")) {
                    String tableware = output.get("-t").trim();
                    String parameter = output.get("-p").trim();
                    String argument = output.get("-a").trim();
                    if (!argument.isEmpty()) {
                        argument = argument.substring(0, 1).toUpperCase() + argument.substring(1);
                    } else {
                        System.out.println("Invalid argument! Please enter a valid argument");
                    }

                    if (getAllParameters().contains(parameter)){
                        if (tableware.equals("cup")){
                            switch (parameter) {
                                case "name" -> cupController.getProductByName(argument);
                                case "material" ->
                                        cupController.getProductByParameter(new MaterialParameter<Cup>(argument));
                                case "color" -> cupController.getProductByParameter(new ColorParameter(argument));
                                case "size" -> cupController.getProductByParameter(new SizeParameter(argument));
                                default ->
                                        System.out.println("Invalid parameter! Please enter a valid parameter. See /help for more info.");
                            }
                        }
                        else if (tableware.equals("plate")){
                            switch (parameter) {
                                case "name" -> plateController.getProductByName(argument);
                                case "material" ->
                                        plateController.getProductByParameter(new MaterialParameter<Plate>(argument));
                                case "color" -> plateController.getProductByParameter(new PlateColorParameter(argument));
                                case "shape" -> plateController.getProductByParameter(new ShapeParameter(argument));
                                default ->
                                        System.out.println("Invalid parameter! Please enter a valid parameter. See /help for more info.");
                            }
                        }
                        else if (tableware.equals("pot")){
                            switch (parameter) {
                                case "name" -> potController.getProductByName(argument);
                                case "material" ->
                                        potController.getProductByParameter(new MaterialParameter<Pot>(argument));
                                case "type" -> potController.getProductByParameter(new TypeParameter(argument));
                                default ->
                                        System.out.println("Invalid parameter! Please enter a valid parameter. See /help for more info.");
                            }
                        }
                        else if (tableware.equals("spoon")){
                            switch (parameter) {
                                case "name" -> spoonController.getProductByName(argument);
                                case "material" ->
                                        spoonController.getProductByParameter(new MaterialParameter<Spoon>(argument));
                                case "type" -> spoonController.getProductByParameter(new SpoonTypeParameter(argument));
                                default ->
                                        System.out.println("Invalid parameter! Please enter a valid parameter. See /help for more info.");
                            }
                        }
                        else {
                            System.out.println("OOPS, seems you have entered an invalid tableware name! See /help for more info.");
                        }
                    } else {
                        System.out.println("Invalid parameter! Please enter a valid parameter. See /plist for more info.");
                    }

                }
                else if (output.containsKey("-t") && output.containsKey("-n")) {
                    String tableware = output.get("-t");
                    String name = output.get("-n").trim();
                    name = name.substring(0, 1).toUpperCase() + name.substring(1);
                    switch (tableware) {
                        case "cup" -> cupController.getProductByName(name);
                        case "plate" -> plateController.getProductByName(name);
                        case "pot" -> potController.getProductByName(name);
                        case "spoon" -> spoonController.getProductByName(name);
                        default -> System.out.println("OOPS, seems you have entered an invalid tableware name! See /help for more info.");
                    }
                }
                else {
                    System.out.println("Invalid command! Please enter a valid command. See /help for more info. {DEBUG: From 163 line}");
                }
            }
            if(command.contains("/all")){
                output = commandController.searchCommand(command);
                if (output.containsKey("-t")){
                    String tableware = output.get("-t");
                    switch (tableware) {
                        case "cup" -> cupController.getAll();
                        case "plate" -> plateController.getAll();
                        case "pot" -> potController.getAll();
                        case "spoon" -> spoonController.getAll();
                        default -> System.out.println("OOPS, seems you have entered an invalid tableware name! See /help for more info.");
                    }
                }
                else {
                    cupController.getAll();
                    spoonController.getAll();
                    plateController.getAll();
                    potController.getAll();
                }
            }
            if(command.contains("/plist")){
                output = commandController.searchCommand(command);
                if (output.isEmpty()){
                    System.out.println("List of general parameters: " + getGeneralParameter() + "\n To see parameters for specific tableware, use /plist -t=[TABLEWARE NAME]");
                } else if (output.containsKey("-t")){
                    String tableware = output.get("-t");
                    switch (tableware) {
                        case "cup" -> System.out.println("List of Parameters for cup: " + getCupParameters());
                        case "plate" -> System.out.println("List of Parameters for plate: " + getPlateParameters());
                        case "pot" -> System.out.println("List of Parameters for pot: " + getPotParameters());
                        case "spoon" -> System.out.println("List of Parameters for spoon: " + getSpoonParameters());
                        default -> System.out.println("OOPS, seems you have entered an invalid tableware name! See /help for more info.");
                    }
                } else {
                    System.out.println("Invalid command! Please enter a valid command. See /help for more info.");
                }
            }









            // should work at the end
            if (!command.isEmpty()){
                System.out.println("Enter next command: ");
            } else {
                System.out.println("Time never comes back! Don't waste it! Enter a command: ");
            }
        }
    }
}

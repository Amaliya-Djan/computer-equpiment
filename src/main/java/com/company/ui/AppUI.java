package com.company.ui;

import com.company.controller.KeyboardController;
import com.company.controller.MonitorController;
import com.company.controller.MouseController;
import com.company.utils.BaseUtils;

import java.util.Objects;

public class AppUI {

    private final MonitorController monitorController = new MonitorController();
    private final KeyboardController keyboardController = new KeyboardController();
    private final MouseController mouseController = new MouseController();

    public void run() {
        BaseUtils.println("\n\n1 -> Monitor");
        BaseUtils.println("2 -> Keyboard");
        BaseUtils.println("3 -> Mouse");
        BaseUtils.println("q -> Quit");

        BaseUtils.print("-- Select operation: ");
        switch (BaseUtils.readText()) {
            case "1" -> monitorUI();
            case "2" -> keyboardUI();
            case "3" -> mouseUI();
            case "q" -> System.exit(0);
            default -> BaseUtils.println("Wrong choice!");
        }
        run();
    }

    public String baseUI() {
        BaseUtils.println("1 -> Show all");
        BaseUtils.println("2 -> Find by id");
        BaseUtils.println("3 -> Find by color");
        BaseUtils.println("4 -> Filter by price");
        BaseUtils.println("0 -> Back");

        BaseUtils.print("Select operation: ");
        return BaseUtils.readText();
    }

    private void monitorUI() {
        BaseUtils.println("\n\n5 -> Find by refresh rate");
        BaseUtils.println("6 -> Find by display size");
        switch (baseUI()) {
            case "1" -> showAllMonitor();
            case "2" -> monitorController.findByID();
            case "3" -> monitorController.findByColor();
            case "4" -> monitorController.filterByPrice();
            case "5" -> monitorController.refreshRate();
            case "6" -> monitorController.displaySize();
            case "0" -> run();
            default -> BaseUtils.println("Wrong choice!");
        }
        monitorUI();
    }

    private String showUI() {
        BaseUtils.println("\n\n1 -> Sort by id");
        BaseUtils.println("2 -> Sort by price");
        BaseUtils.println("0 -> Back");

        BaseUtils.print("-- Select operation: ");
        return BaseUtils.readText();
    }

    private void showAllMonitor() {
        String operation = showUI();
        if (Objects.equals(operation, "0")) {
            monitorUI();
        }
        monitorController.showAll(operation);
        showAllMonitor();
    }

    private void keyboardUI() {
        BaseUtils.println("\n\n5 -> Find by width and height");
        switch (baseUI()) {
            case "1" -> showAllKeyboard();
            case "2" -> keyboardController.findByID();
            case "3" -> keyboardController.findByColor();
            case "4" -> keyboardController.filterByPrice();
            case "5" -> keyboardController.findByWidthAndHeight();
            case "0" -> run();
            default -> BaseUtils.println("Wrong choice!");
        }
        keyboardUI();
    }

    private void showAllKeyboard() {
        String operation = showUI();
        if (Objects.equals(operation, "0")) {
            keyboardUI();
        }
        keyboardController.showAll(operation);
        showAllKeyboard();
    }

    private void mouseUI() {
        BaseUtils.println("\n\n5 -> Find by wireless");
        switch (baseUI()) {
            case "1" -> showAllMouse();
            case "2" -> mouseController.findByID();
            case "3" -> mouseController.findByColor();
            case "4" -> mouseController.filterByPrice();
            case "5" -> mouseController.findByWireLess();
            case "0" -> run();
            default -> BaseUtils.println("Wrong choice!");
        }
        mouseUI();
    }

    private void showAllMouse() {
        String operation = showUI();
        if (Objects.equals(operation, "0")) {
            mouseUI();
        }
        mouseController.showAll(operation);
        showAllMouse();
    }
}

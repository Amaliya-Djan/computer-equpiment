package com.company;

import com.company.ui.AppUI;
import com.company.utils.BaseUtils;

public class Main {
    static AppUI appUI = new AppUI();

    public static void main(String[] args) {
        BaseUtils.println("\n\n*************** Project: Warehouse search system *****************");
        BaseUtils.println("--------------- Author: Amaliya Djan ---------------");
        BaseUtils.println("--------------- Email: amaliya_djan@student.itpu.uz ---------------");
        BaseUtils.println("--------------- Creation date: since 30/04/23 17:12 ---------------");
        BaseUtils.println("--------------- Version: version-0.0.1 ---------------");
        appUI.run();
    }
}
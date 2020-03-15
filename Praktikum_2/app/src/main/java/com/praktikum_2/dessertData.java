package com.praktikum_2;

import java.util.ArrayList;

public class dessertData {
    private static  String[] daftarDessert = {
            "Donut Sprinkle",
            "Snowin' Sweet Princess",
            "Melted Ice Cream",
            "Sweet Pie"

    };

    private static String[] daftarDetail = {
            "Donut strawberry bertabur sprinkle lembut nan manis seperti saya",
            "Donut Bertabur kelapa muda yang memberi rasa gurih seperti rasa yang pernah ada",
            "Ice cream spesial durian dengan taburan sprinkle manis dan topping kopi",
            "Bolu rasa vanila dengan strawberry dan anggur"

    };

    private static int[] foto = {
            R.drawable.sprinkle,
            R.drawable.sprinkle2,
            R.drawable.sprinkle3,
            R.drawable.sprinkle4
    };

    static ArrayList<Dessert> getListData() {
        ArrayList<Dessert> list = new ArrayList<>();

        for(int pos=0; pos<daftarDessert.length; pos++ ){
            Dessert dessert = new Dessert();
            dessert.setNama(daftarDessert[pos]);
            dessert.setDetail(daftarDetail[pos]);
            dessert.setFoto(foto[pos]);
            list.add(dessert);

        }
        return list;
    }
}

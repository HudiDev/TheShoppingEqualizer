package hudiilfeld.theshoppingequalizer.sources;

import java.util.ArrayList;

/**
 * Created by ibm on 31/07/2017.
 */

public class MegaUrlDataSource {
    public static ArrayList<SubCategoryNameAndInfo> getTitles(){
        ArrayList<SubCategoryNameAndInfo> foodSubTitles = new ArrayList<>();

        /////////////////לחמים1
        foodSubTitles.add(new SubCategoryNameAndInfo("לחם" , 0,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%9C%D7%97%D7%9D/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("מאפיה טרייה" , 1,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%9E%D7%90%D7%A4%D7%99%D7%99%D7%94_%D7%98%D7%A8%D7%99%D7%94/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("לחמניות ופיתות", 2,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%9C%D7%97%D7%9E%D7%A0%D7%99%D7%95%D7%AA_%D7%95%D7%A4%D7%99%D7%AA%D7%95%D7%AA/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("פריכיות, מצות ותחליפי לחם" , 3,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%A4%D7%A8%D7%99%D7%9B%D7%99%D7%95%D7%AA_%D7%9E%D7%A6%D7%95%D7%AA_%D7%95%D7%AA%D7%97%D7%9C%D7%99%D7%A4%D7%99_%D7%9C%D7%97%D7%9D/%D7%9E%D7%93%D7%A3"
        ));

        //ירקות2 ////////////
        foodSubTitles.add(new SubCategoryNameAndInfo("ירקות", 4,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%99%D7%A8%D7%A7%D7%95%D7%AA/%D7%9E%D7%93%D7%A3"
        ));
        ////
        foodSubTitles.add(new SubCategoryNameAndInfo("פירות", 5,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%A4%D7%99%D7%A8%D7%95%D7%AA/%D7%9E%D7%93%D7%A3"
        ));
        ////
        foodSubTitles.add(new SubCategoryNameAndInfo("פירות יבשים, אגוזים ופיצוחים", 6,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%A4%D7%99%D7%A8%D7%95%D7%AA_%D7%99%D7%91%D7%A9%D7%99%D7%9D_%D7%90%D7%92%D7%95%D7%96%D7%99%D7%9D_%D7%95%D7%A4%D7%99%D7%A6%D7%95%D7%97%D7%99%D7%9D/%D7%9E%D7%93%D7%A3"
        ));


        //בשרים3
        foodSubTitles.add(new SubCategoryNameAndInfo("עוף והודו טרי", 7,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%A2%D7%95%D7%A3_%D7%95%D7%94%D7%95%D7%93%D7%95_%D7%98%D7%A8%D7%99/%D7%9E%D7%93%D7%A3"
        ));
        foodSubTitles.add(new SubCategoryNameAndInfo("בשר טרי", 8,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%91%D7%A9%D7%A8_%D7%98%D7%A8%D7%99/%D7%9E%D7%93%D7%A3"
        ));
        foodSubTitles.add(new SubCategoryNameAndInfo("בשר ועוף מוכן", 9,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%91%D7%A9%D7%A8_%D7%95%D7%A2%D7%95%D7%A3_%D7%9E%D7%95%D7%9B%D7%9F/%D7%9E%D7%93%D7%A3"
        ));
        foodSubTitles.add(new SubCategoryNameAndInfo("נקניקיות", 10,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%A0%D7%A7%D7%A0%D7%99%D7%A7%D7%99%D7%95%D7%AA/%D7%9E%D7%93%D7%A3"
        ));
        foodSubTitles.add(new SubCategoryNameAndInfo("נקניקים ופסטרמה", 11,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%A0%D7%A7%D7%A0%D7%99%D7%A7%D7%99%D7%9D_%D7%95%D7%A4%D7%A1%D7%98%D7%A8%D7%9E%D7%94/%D7%9E%D7%93%D7%A3"
        ));
        foodSubTitles.add(new SubCategoryNameAndInfo("דגים טריים", 12,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%93%D7%92%D7%99%D7%9D_%D7%98%D7%A8%D7%99%D7%99%D7%9D/%D7%9E%D7%93%D7%A3"
        ));
        foodSubTitles.add(new SubCategoryNameAndInfo("דגים ארוזים וסושי טרי", 13,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%93%D7%92%D7%99%D7%9D_%D7%90%D7%A8%D7%95%D7%96%D7%99%D7%9D_%D7%95%D7%A1%D7%95%D7%A9%D7%99_%D7%98%D7%A8%D7%99/%D7%9E%D7%93%D7%A3"
        ));


        //חלב וביצים4
        foodSubTitles.add(new SubCategoryNameAndInfo("חלב ומשקאות", 14,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%97%D7%9C%D7%91_%D7%95%D7%9E%D7%A9%D7%A7%D7%90%D7%95%D7%AA/%D7%9E%D7%93%D7%A3"
        ));
        foodSubTitles.add(new SubCategoryNameAndInfo("משקאות סויה ואורז", 15,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%9E%D7%A9%D7%A7%D7%90%D7%95%D7%AA_%D7%A1%D7%95%D7%99%D7%94_%D7%95%D7%90%D7%95%D7%A8%D7%96/%D7%9E%D7%93%D7%A3"
        ));
        foodSubTitles.add(new SubCategoryNameAndInfo("קוטג' וגבינה לבנה", 16,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%A7%D7%95%D7%98%D7%92_%D7%95%D7%92%D7%91%D7%99%D7%A0%D7%94_%D7%9C%D7%91%D7%A0%D7%94/%D7%9E%D7%93%D7%A3"
        ));
        foodSubTitles.add(new SubCategoryNameAndInfo("בולגרית, פטה ומלוחה", 17,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%91%D7%95%D7%9C%D7%92%D7%A8%D7%99%D7%AA_%D7%A4%D7%98%D7%94_%D7%95%D7%9E%D7%9C%D7%95%D7%97%D7%94/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("גבינה צהובה ומוצרלה", 18,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%92%D7%91%D7%99%D7%A0%D7%94_%D7%A6%D7%94%D7%95%D7%91%D7%94_%D7%95%D7%9E%D7%95%D7%A6%D7%A8%D7%9C%D7%94/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("גבינה מחלב עיזים וכבשים", 19,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%92%D7%91%D7%99%D7%A0%D7%95%D7%AA_%D7%9E%D7%97%D7%9C%D7%91_%D7%A2%D7%99%D7%96%D7%99%D7%9D_%D7%90%D7%95_%D7%9B%D7%91%D7%A9%D7%99%D7%9D/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("גבינות קשות", 20,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%92%D7%91%D7%99%D7%A0%D7%95%D7%AA_%D7%A7%D7%A9%D7%95%D7%AA/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("גבינות רכות", 21,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%92%D7%91%D7%99%D7%A0%D7%95%D7%AA_%D7%A8%D7%9B%D7%95%D7%AA/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("גבינת שמנת", 22,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%92%D7%91%D7%99%D7%A0%D7%AA_%D7%A9%D7%9E%D7%A0%D7%AA/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("ביצים", 23,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%91%D7%99%D7%A6%D7%99%D7%9D/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("סלטים", 24,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%A1%D7%9C%D7%98%D7%99%D7%9D_%D7%95%D7%97%D7%9E%D7%95%D7%A6%D7%99%D7%9D/%D7%9E%D7%93%D7%A3"
                ));

        //אורגי5
        foodSubTitles.add(new SubCategoryNameAndInfo("אורגני", 25,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%90%D7%95%D7%A8%D7%92%D7%A0%D7%99/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("ללא גלוטן", 26,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%9C%D7%9C%D7%90_%D7%92%D7%9C%D7%95%D7%98%D7%9F/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("דיאטטי", 27,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%93%D7%99%D7%90%D7%98%D7%98%D7%99/%D7%9E%D7%93%D7%A3"
                ));

        //קפואים6
        foodSubTitles.add(new SubCategoryNameAndInfo("בשר ועוף", 28,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%91%D7%A9%D7%A8_%D7%95%D7%A2%D7%95%D7%A3/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("דגים", 29,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%93%D7%92%D7%99%D7%9D/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("בצקים, מאפים ופיצות", 30,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%91%D7%A6%D7%A7%D7%99%D7%9D_%D7%9E%D7%90%D7%A4%D7%99%D7%9D_%D7%95%D7%A4%D7%99%D7%A6%D7%95%D7%AA/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("ירקות ופירות", 31,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%99%D7%A8%D7%A7%D7%95%D7%AA_%D7%95%D7%A4%D7%99%D7%A8%D7%95%D7%AA/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("שניצל מהצומח וארוחות מוכנות צמחיות", 32,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%A9%D7%A0%D7%99%D7%A6%D7%9C_%D7%9E%D7%94%D7%A6%D7%95%D7%9E%D7%97_%D7%95%D7%90%D7%A8%D7%95%D7%97%D7%95%D7%AA_%D7%9E%D7%95%D7%9B%D7%A0%D7%95%D7%AA_%D7%A6%D7%9E%D7%97%D7%99%D7%95%D7%AA/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("שניצל בשרי וארוחות מוכנות בשריות", 33,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%A9%D7%A0%D7%99%D7%A6%D7%9C_%D7%91%D7%A9%D7%A8%D7%99_%D7%95%D7%90%D7%A8%D7%95%D7%97%D7%95%D7%AA_%D7%9E%D7%95%D7%9B%D7%A0%D7%95%D7%AA_%D7%91%D7%A9%D7%A8%D7%99%D7%95%D7%AA/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("גלידות וקינוחים", 34,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%92%D7%9C%D7%99%D7%93%D7%95%D7%AA_%D7%95%D7%A7%D7%99%D7%A0%D7%95%D7%97%D7%99%D7%9D/%D7%9E%D7%93%D7%A3"
                ));


        //שימורים7
        foodSubTitles.add(new SubCategoryNameAndInfo("תבשילים", 35,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%AA%D7%91%D7%A9%D7%99%D7%9C%D7%99%D7%9D/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("מרקים מוכנים", 36,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%9E%D7%A8%D7%A7%D7%99%D7%9D_%D7%9E%D7%95%D7%9B%D7%A0%D7%99%D7%9D/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("אבקות למרק ולתיבול", 37,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%90%D7%91%D7%A7%D7%95%D7%AA_%D7%9C%D7%9E%D7%A8%D7%A7_%D7%95%D7%9C%D7%AA%D7%99%D7%91%D7%95%D7%9C/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("קרוטונים ושקדי מרק", 38,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%A7%D7%A8%D7%95%D7%98%D7%95%D7%A0%D7%99%D7%9D_%D7%95%D7%A9%D7%A7%D7%93%D7%99_%D7%9E%D7%A8%D7%A7/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("שימורי ירקות", 39,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%A9%D7%99%D7%9E%D7%95%D7%A8%D7%99_%D7%99%D7%A8%D7%A7%D7%95%D7%AA/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("שימורי דגים", 40,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%A9%D7%99%D7%9E%D7%95%D7%A8%D7%99_%D7%93%D7%92%D7%99%D7%9D/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("שימורי חמוצים וזיתים", 41,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%A9%D7%99%D7%9E%D7%95%D7%A8%D7%99_%D7%97%D7%9E%D7%95%D7%A6%D7%99%D7%9D_%D7%95%D7%96%D7%99%D7%AA%D7%99%D7%9D/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("שימורי טונה", 42,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%A9%D7%99%D7%9E%D7%95%D7%A8%D7%99_%D7%98%D7%95%D7%A0%D7%94/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("שימורי פירות", 43,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%A9%D7%99%D7%9E%D7%95%D7%A8%D7%99_%D7%A4%D7%99%D7%A8%D7%95%D7%AA/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("רסק ושימורי עגבניות", 44,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%A8%D7%A1%D7%A7_%D7%95%D7%A9%D7%99%D7%9E%D7%95%D7%A8%D7%99_%D7%A2%D7%92%D7%91%D7%A0%D7%99%D7%95%D7%AA/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("מלח ותבלינים", 45,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%9E%D7%9C%D7%97_%D7%95%D7%AA%D7%91%D7%9C%D7%99%D7%A0%D7%99%D7%9D/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("דבש וסילאן", 46,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%93%D7%91%D7%A9_%D7%95%D7%A1%D7%99%D7%9C%D7%90%D7%9F/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("קטשופ, מיונז וחרדל", 47,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%A7%D7%98%D7%A9%D7%95%D7%A4_%D7%9E%D7%99%D7%95%D7%A0%D7%96_%D7%95%D7%97%D7%A8%D7%93%D7%9C/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("טחינה גולמית", 48,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%98%D7%97%D7%99%D7%A0%D7%94_%D7%92%D7%95%D7%9C%D7%9E%D7%99%D7%AA/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("תערובות תיבול", 49,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%AA%D7%A2%D7%A8%D7%95%D7%91%D7%95%D7%AA_%D7%AA%D7%99%D7%91%D7%95%D7%9C/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("רטבים לסלט ואלף האיים",50,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%A8%D7%98%D7%91%D7%99%D7%9D_%D7%9C%D7%A1%D7%9C%D7%98_%D7%95%D7%90%D7%9C%D7%A3_%D7%94%D7%90%D7%99%D7%99%D7%9D/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("רטבים לבישול וברביקיו", 51,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%A8%D7%98%D7%91%D7%99%D7%9D_%D7%9C%D7%91%D7%99%D7%A9%D7%95%D7%9C_%D7%95%D7%91%D7%A8%D7%91%D7%99%D7%A7%D7%99%D7%95/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("רוטב פסטה ועגבניות", 52,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%A8%D7%95%D7%98%D7%91_%D7%A4%D7%A1%D7%98%D7%94_%D7%95%D7%A2%D7%92%D7%91%D7%A0%D7%99%D7%95%D7%AA/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("רוטב סויה, טריאקי וצ'ילי", 53,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%A8%D7%95%D7%98%D7%91_%D7%A1%D7%95%D7%99%D7%94_%D7%98%D7%A8%D7%99%D7%90%D7%A7%D7%99_%D7%95%D7%A6%D7%99%D7%9C%D7%99/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("רטבים אחרים", 54,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%A8%D7%98%D7%91%D7%99%D7%9D_%D7%90%D7%97%D7%A8%D7%99%D7%9D/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("ריבות", 55,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%A8%D7%99%D7%91%D7%95%D7%AA/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("ממרחים מתוקים", 56,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%9E%D7%9E%D7%A8%D7%97%D7%99%D7%9D_%D7%9E%D7%AA%D7%95%D7%A7%D7%99%D7%9D/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("ממרחים אחרים", 57,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%9E%D7%9E%D7%A8%D7%97%D7%99%D7%9D_%D7%90%D7%97%D7%A8%D7%99%D7%9D/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("קמח וסולת", 58,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%A7%D7%9E%D7%97_%D7%95%D7%A1%D7%95%D7%9C%D7%AA/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("סוכר וממתיקים", 59,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%A1%D7%95%D7%9B%D7%A8_%D7%95%D7%9E%D7%9E%D7%AA%D7%99%D7%A7%D7%99%D7%9D/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("מוצרי אפיה", 60,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%9E%D7%95%D7%A6%D7%A8%D7%99_%D7%90%D7%A4%D7%99%D7%94/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("שמן וחומץ", 61,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%A9%D7%9E%D7%9F_%D7%95%D7%97%D7%95%D7%9E%D7%A5/%D7%9E%D7%93%D7%A3"
                ));


        //דגנים8
        foodSubTitles.add(new SubCategoryNameAndInfo("קורנפלקס", 62,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%A7%D7%95%D7%A8%D7%A0%D7%A4%D7%9C%D7%A7%D7%A1/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("דגני בוקר", 63,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%93%D7%92%D7%A0%D7%99_%D7%91%D7%95%D7%A7%D7%A8/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("דגני בוקר לילדים", 64,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%93%D7%92%D7%A0%D7%99_%D7%91%D7%95%D7%A7%D7%A8_%D7%9C%D7%99%D7%9C%D7%93%D7%99%D7%9D/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("חטיפי דגנים", 65,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%97%D7%98%D7%99%D7%A4%D7%99_%D7%93%D7%92%D7%A0%D7%99%D7%9D/%D7%9E%D7%93%D7%A3"
                ));

        foodSubTitles.add(new SubCategoryNameAndInfo("גרנולה, מוזלי ושיבולת שועל", 66,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%92%D7%A8%D7%A0%D7%95%D7%9C%D7%94_%D7%9E%D7%95%D7%96%D7%9C%D7%99_%D7%95%D7%A9%D7%99%D7%91%D7%95%D7%9C%D7%AA_%D7%A9%D7%95%D7%A2%D7%9C/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("פסטה", 67,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%A4%D7%A1%D7%98%D7%94/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("פתיתים", 68,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%A4%D7%AA%D7%99%D7%AA%D7%99%D7%9D/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("אורז", 69,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%90%D7%95%D7%A8%D7%96/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("קטניות", 70,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%A7%D7%98%D7%A0%D7%99%D7%95%D7%AA/%D7%9E%D7%93%D7%A3"
                ));

        //מתוקים9
        foodSubTitles.add(new SubCategoryNameAndInfo("עוגות", 71,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%A2%D7%95%D7%92%D7%95%D7%AA/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("עוגיות", 72,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%A2%D7%95%D7%92%D7%99%D7%95%D7%AA/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("סוכריות ומסטיקים", 73,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%A1%D7%95%D7%9B%D7%A8%D7%99%D7%95%D7%AA_%D7%95%D7%9E%D7%A1%D7%98%D7%99%D7%A7%D7%99%D7%9D/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("שוקולד", 74,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%A9%D7%95%D7%A7%D7%95%D7%9C%D7%93/%D7%9E%D7%93%D7%A3",
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%A9%D7%95%D7%A7%D7%95%D7%9C%D7%93/%D7%9E%D7%93%D7%A3?page=2"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("חלבה, מרציפן וממתקים מזרחיים", 75,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%97%D7%9C%D7%91%D7%94_%D7%9E%D7%A8%D7%A6%D7%99%D7%A4%D7%9F_%D7%95%D7%9E%D7%9E%D7%AA%D7%A7%D7%99%D7%9D_%D7%9E%D7%96%D7%A8%D7%97%D7%99%D7%99%D7%9D/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("פופקורן", 76,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%A4%D7%95%D7%A4%D7%A7%D7%95%D7%A8%D7%9F/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("ביסקווטים", 77,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%91%D7%99%D7%A1%D7%A7%D7%95%D7%95%D7%98%D7%99%D7%9D/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("וופלים", 78,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%95%D7%95%D7%A4%D7%9C%D7%99%D7%9D/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("צ'יפס ובייגלה", 79,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%A6%D7%99%D7%A4%D7%A1_%D7%95%D7%91%D7%99%D7%99%D7%92%D7%9C%D7%94/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("חטיפים", 80,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%97%D7%98%D7%99%D7%A4%D7%99%D7%9D/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("קרקרים", 81,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%A7%D7%A8%D7%A7%D7%A8%D7%99%D7%9D/%D7%9E%D7%93%D7%A3"
                ));

        //טיפוח ותינוקות10
        foodSubTitles.add(new SubCategoryNameAndInfo("דאודורנט לאישה", 82,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%93%D7%90%D7%95%D7%93%D7%95%D7%A8%D7%A0%D7%98_%D7%9C%D7%90%D7%99%D7%A9%D7%94/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("דאודורנט לגבר", 83,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%93%D7%90%D7%95%D7%93%D7%95%D7%A8%D7%A0%D7%98_%D7%9C%D7%92%D7%91%D7%A8/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("טיפוח הגוף", 84,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%98%D7%99%D7%A4%D7%95%D7%97_%D7%94%D7%92%D7%95%D7%A3/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("טיפוח הפנים", 85,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%98%D7%99%D7%A4%D7%95%D7%97_%D7%94%D7%A4%D7%A0%D7%99%D7%9D/%D7%9E%D7%93%D7%A3"
        ));
        foodSubTitles.add(new SubCategoryNameAndInfo("היגיינת הפה", 86,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%94%D7%99%D7%92%D7%99%D7%99%D7%A0%D7%AA_%D7%94%D7%A4%D7%94/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("מוצרי גילוח לגבר", 87,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%9E%D7%95%D7%A6%D7%A8%D7%99_%D7%92%D7%99%D7%9C%D7%95%D7%97_%D7%9C%D7%92%D7%91%D7%A8/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("הסרת שיער לאישה", 88,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%94%D7%A1%D7%A8%D7%AA_%D7%A9%D7%99%D7%A2%D7%A8_%D7%9C%D7%90%D7%99%D7%A9%D7%94/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("היגיינה נשית", 89,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%94%D7%99%D7%92%D7%99%D7%99%D7%A0%D7%94_%D7%A0%D7%A9%D7%99%D7%AA/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("איפור ובישום", 90,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%90%D7%99%D7%A4%D7%95%D7%A8_%D7%95%D7%91%D7%99%D7%A9%D7%95%D7%9D/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("מוצרי הגנה מהשמש", 91,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%9E%D7%95%D7%A6%D7%A8%D7%99_%D7%94%D7%92%D7%A0%D7%94_%D7%9E%D7%94%D7%A9%D7%9E%D7%A9/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("שמפו", 92,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%A9%D7%9E%D7%A4%D7%95/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("טיפוח ועיצוב השיער", 93,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%98%D7%99%D7%A4%D7%95%D7%97_%D7%95%D7%A2%D7%99%D7%A6%D7%95%D7%91_%D7%94%D7%A9%D7%99%D7%A2%D7%A8/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("מרכך שיער ומסיכות", 94,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%9E%D7%A8%D7%9B%D7%9A_%D7%A9%D7%99%D7%A2%D7%A8_%D7%95%D7%9E%D7%A1%D7%99%D7%9B%D7%95%D7%AA/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("אביזרי אמבט", 95,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%90%D7%91%D7%99%D7%96%D7%A8%D7%99_%D7%90%D7%9E%D7%91%D7%98/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("סבון מוצק", 96,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%A1%D7%91%D7%95%D7%9F_%D7%9E%D7%95%D7%A6%D7%A7/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("סבון נוזלי", 97,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%A1%D7%91%D7%95%D7%9F_%D7%A0%D7%95%D7%96%D7%9C%D7%99/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("תוספי תזונה", 98,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%AA%D7%95%D7%A1%D7%A4%D7%99_%D7%AA%D7%96%D7%95%D7%A0%D7%94/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("מוצרי ספיגה למבוגרים", 99,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%9E%D7%95%D7%A6%D7%A8%D7%99_%D7%A1%D7%A4%D7%99%D7%92%D7%94_%D7%9C%D7%9E%D7%91%D7%95%D7%92%D7%A8%D7%99%D7%9D/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("אמצעי מניעה", 100,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%90%D7%9E%D7%A6%D7%A2%D7%99_%D7%9E%D7%A0%D7%99%D7%A2%D7%94/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("חיתולים", 101,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%97%D7%99%D7%AA%D7%95%D7%9C%D7%99%D7%9D/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("תחליפי חלב לתינוקות", 102,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%AA%D7%97%D7%9C%D7%99%D7%A4%D7%99_%D7%97%D7%9C%D7%91_%D7%9C%D7%AA%D7%99%D7%A0%D7%95%D7%A7%D7%95%D7%AA/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("מזון לתינוקות", 103,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%9E%D7%96%D7%95%D7%9F_%D7%9C%D7%AA%D7%99%D7%A0%D7%95%D7%A7%D7%95%D7%AA/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("מגבונים", 104,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%9E%D7%92%D7%91%D7%95%D7%A0%D7%99%D7%9D/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("מוצרי טיפוח ואביזרים", 105,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%9E%D7%95%D7%A6%D7%A8%D7%99_%D7%98%D7%99%D7%A4%D7%95%D7%97_%D7%95%D7%90%D7%91%D7%99%D7%96%D7%A8%D7%99%D7%9D/%D7%9E%D7%93%D7%A3"
                ));


        //חד פעמי11
        foodSubTitles.add(new SubCategoryNameAndInfo("עטיפות, שקיות ותבניות", 106,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%A2%D7%98%D7%99%D7%A4%D7%95%D7%AA_%D7%A9%D7%A7%D7%99%D7%95%D7%AA_%D7%95%D7%AA%D7%91%D7%A0%D7%99%D7%95%D7%AA/%D7%9E%D7%93%D7%A3"
        ));
        foodSubTitles.add(new SubCategoryNameAndInfo("חד פעמי", 107,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%97%D7%93_%D7%A4%D7%A2%D7%9E%D7%99/%D7%9E%D7%93%D7%A3"
        ));

        //ביגוד12
        foodSubTitles.add(new SubCategoryNameAndInfo("בגדי נשים", 108,
                "http://www.mysupermarket.co.il/רמי_לוי/סלטים_וחמוצים/מדף"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("בגדי גברים", 109,
                "http://www.mysupermarket.co.il/רמי_לוי/סלטים_וחמוצים/מדף"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("טקסטיל ואביזרים", 110,
                "http://www.mysupermarket.co.il/רמי_לוי/סלטים_וחמוצים/מדף"
                ));

        //אחזקת הבית13
        foodSubTitles.add(new SubCategoryNameAndInfo("כביסה כללי", 111,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%9B%D7%91%D7%99%D7%A1%D7%94_%D7%9B%D7%9C%D7%9C%D7%99/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("מרכך כביסה", 112,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%9E%D7%A8%D7%9B%D7%9A_%D7%9B%D7%91%D7%99%D7%A1%D7%94/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("ג'ל ואבקת כביסה", 113,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%92%D7%9C_%D7%95%D7%90%D7%91%D7%A7%D7%AA_%D7%9B%D7%91%D7%99%D7%A1%D7%94/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("ממחטות ומגבוני נייר", 114,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%9E%D7%9E%D7%97%D7%98%D7%95%D7%AA_%D7%95%D7%9E%D7%92%D7%91%D7%95%D7%A0%D7%99_%D7%A0%D7%99%D7%99%D7%A8/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("נייר טואלט", 115,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%A0%D7%99%D7%99%D7%A8_%D7%98%D7%95%D7%90%D7%9C%D7%98/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("מטהר אויר", 116,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%9E%D7%98%D7%94%D7%A8_%D7%90%D7%95%D7%99%D7%A8/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("קוטל חרקים", 117,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%A7%D7%95%D7%98%D7%9C_%D7%97%D7%A8%D7%A7%D7%99%D7%9D/%D7%9E%D7%93%D7%A3"
        ));
        foodSubTitles.add(new SubCategoryNameAndInfo("כלי בית", 118,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%9B%D7%9C%D7%99_%D7%91%D7%99%D7%AA/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("חומרי ניקיון לבית", 119,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%97%D7%95%D7%9E%D7%A8%D7%99_%D7%A0%D7%99%D7%A7%D7%99%D7%95%D7%9F_%D7%9C%D7%91%D7%99%D7%AA/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("אביזרי ניקיון", 120,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%90%D7%91%D7%99%D7%96%D7%A8%D7%99_%D7%A0%D7%99%D7%A7%D7%99%D7%95%D7%9F/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("ניקוי כלים", 121,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%A0%D7%99%D7%A7%D7%95%D7%99_%D7%9B%D7%9C%D7%99%D7%9D/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("ניקוי רצפות", 122,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%A0%D7%99%D7%A7%D7%95%D7%99_%D7%A8%D7%A6%D7%A4%D7%95%D7%AA/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("ניקוי אסלות ושירותים", 123,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%A0%D7%99%D7%A7%D7%95%D7%99_%D7%90%D7%A1%D7%9C%D7%95%D7%AA_%D7%95%D7%A9%D7%99%D7%A8%D7%95%D7%AA%D7%99%D7%9D/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("מוצרי בעלי חיים", 124,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%9E%D7%95%D7%A6%D7%A8%D7%99_%D7%91%D7%A2%D7%9C%D7%99_%D7%97%D7%99%D7%99%D7%9D/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("נרות, גפרורים ופחמים", 125,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%A0%D7%A8%D7%95%D7%AA_%D7%92%D7%A4%D7%A8%D7%95%D7%A8%D7%99%D7%9D_%D7%95%D7%A4%D7%97%D7%9E%D7%99%D7%9D/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("סוללות", 126,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%A1%D7%95%D7%9C%D7%9C%D7%95%D7%AA/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("סיגריות", 127,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%A1%D7%99%D7%92%D7%A8%D7%99%D7%95%D7%AA/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("חנות מותג קולור קאצ'ר", 128,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%97%D7%A0%D7%95%D7%AA_%D7%9E%D7%95%D7%AA%D7%92_%D7%A7%D7%95%D7%9C%D7%95%D7%A8_%D7%A7%D7%90%D7%A6%D7%A8/%D7%9E%D7%93%D7%A3"
                ));


        //שתייה
        foodSubTitles.add(new SubCategoryNameAndInfo("בירה", 129,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%91%D7%99%D7%A8%D7%94/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("יין", 130,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%99%D7%99%D7%9F/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("משקאות חריפים", 131,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%9E%D7%A9%D7%A7%D7%90%D7%95%D7%AA_%D7%97%D7%A8%D7%99%D7%A4%D7%99%D7%9D/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("קוקטייל מוגז", 132,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%A7%D7%95%D7%A7%D7%98%D7%99%D7%99%D7%9C_%D7%9E%D7%95%D7%92%D7%96/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("קפה", 133,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%A7%D7%A4%D7%94/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("תה", 134,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%AA%D7%94/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("קפה שחור", 135,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%A7%D7%A4%D7%94_%D7%A9%D7%97%D7%95%D7%A8/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("אבקות שוקו ושתיה", 136,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%90%D7%91%D7%A7%D7%95%D7%AA_%D7%A9%D7%95%D7%A7%D7%95_%D7%95%D7%A9%D7%AA%D7%99%D7%94/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("מים מינרלים", 137,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%9E%D7%99%D7%9D_%D7%9E%D7%99%D7%A0%D7%A8%D7%9C%D7%99%D7%9D/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("משקאות מוגזים ואנרגיה", 138,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%9E%D7%A9%D7%A7%D7%90%D7%95%D7%AA_%D7%9E%D7%95%D7%92%D7%96%D7%99%D7%9D_%D7%95%D7%90%D7%A0%D7%A8%D7%92%D7%99%D7%94/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("תרכיזים", 139,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%AA%D7%A8%D7%9B%D7%99%D7%96%D7%99%D7%9D/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("משקאות קלים ותה קר", 140,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%9E%D7%A9%D7%A7%D7%90%D7%95%D7%AA_%D7%A7%D7%9C%D7%99%D7%9D_%D7%95%D7%AA%D7%94_%D7%A7%D7%A8/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("מיצים", 141,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%9E%D7%99%D7%A6%D7%99%D7%9D/%D7%9E%D7%93%D7%A3"
                ));
        foodSubTitles.add(new SubCategoryNameAndInfo("נקטר", 142,
                "http://www.mysupermarket.co.il/%D7%9E%D7%92%D7%94/%D7%A0%D7%A7%D7%98%D7%A8/%D7%9E%D7%93%D7%A3"
                ));

        return foodSubTitles;
    }
}

package de.tum.in.ase.eist;

import org.springframework.stereotype.Service;

@Service
public class QueryProcessor {

    public String process(String query) {
        query = query.toLowerCase();
        if (query.contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        } else if (query.contains("name")) {
            return "Chiheb";
        } else if (query.contains("plus")) { // TODO extend the programm here
            String[] temp = query.split("is");
            temp = temp[1].split("plus");
            temp[0] = temp[0].trim();
            temp[1] = temp[1].trim();
            int i1 = 0;
            int i2 = 0;
            try {
                i1 = Integer.parseInt(temp[0]);
            } catch (Exception e) {
                return "";
            }
            try {
                i2 = Integer.parseInt(temp[1]);
            } catch (Exception e) {
                return "";
            }
            return String.valueOf(i1 + i2);
        } else if (query.contains("largest")) {
            String[] temp = query.split(":");
            temp = temp[1].split(",");
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < temp.length; i++) {
                temp[i] = temp[i].trim();
                try {
                    if (Integer.parseInt(temp[i]) > max) {
                        max = Integer.parseInt(temp[i]);
                    }
                } catch (Exception e) {
                    return "";
                }
            }
            return String.valueOf(max);
        } else if (query.contains("multiplied")) {
            String[] temp = query.split("is");
            temp = temp[1].split("multiplied");
            temp[0] = temp[0].trim();
            temp[1] = temp[1].trim();
            int i1 = 0;
            int i2 = 0;
            try {
                i1 = Integer.parseInt(temp[0]);
            } catch (Exception e) {
                return "";
            }
            try {
                i2 = Integer.parseInt(temp[1]);
            } catch (Exception e) {
                return "";
            }
            return String.valueOf(i1 * i2);
        } else if (query.contains("square")) {
            String[] temp = query.split(":");
            temp = temp[1].split(",");

            for (int i = 0; i < temp.length; i++) {
                temp[i] = temp[i].trim();
                try {
                    if (isSquare(Integer.parseInt(temp[i])) && isCube(Integer.parseInt(temp[i]))) {
                        return String.valueOf(Integer.parseInt(temp[i]));
                    }

                } catch (Exception e) {
                    return "";
                }
            }
            return String.valueOf(0);

        } else {
            return "";
        }


    }

    static Boolean isSquare(int n) {
        for (int i = 0; i < n / 2 + 2; i++) {
            if (i * i == n) {
                return true;
            }
        }
        return false;
    }

    static Boolean isCube(int num) {
        int n = (int) Math.round(Math.pow(num, 1.0 / 3.0));
        if ((num == n * n * n)) {
            return true;
        } else {
            return false;
        }
    }
}


// TEST COMMENT 2
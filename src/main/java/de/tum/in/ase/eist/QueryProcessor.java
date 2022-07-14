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
            int i1 = Integer.parseInt(temp[0]);
            int i2 = Integer.parseInt(temp[1]);
            return String.valueOf(i1 + i2);
        } else if (query.contains("largest")) {
            String[] temp = query.split(":");
            temp = temp[1].split(",");
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < temp.length; i++) {
                temp[i] = temp[i].trim();
                if (Integer.parseInt(temp[i]) > max) {
                    max = Integer.parseInt(temp[i]);
                }
            }
            return String.valueOf(max);
        } else {
            return "";
        }
    }
}
// TEST COMMENT 2
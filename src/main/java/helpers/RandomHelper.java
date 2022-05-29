package helpers;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomHelper {

    public static String getRandomText(){
        return RandomStringUtils.random(10);
    }
}

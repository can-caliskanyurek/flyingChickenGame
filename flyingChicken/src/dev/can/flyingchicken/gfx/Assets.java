/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.can.flyingchicken.gfx;

import java.awt.image.BufferedImage;

/**
 *
 * @author can
 */
public class Assets {
    private static final int width = 32, height = 32;
    
    public static BufferedImage chickenFront[], chickenLeft[], chickenRight[], cat[];
    public static BufferedImage btn_start[], btn_easy[], btn_medium[], btn_hard[], numbers[], egg[];
    public static BufferedImage cloud, balloon, heart, chick;
    public static BufferedImage label_choose, label_over, label_try, label_congrats, label_level[];
    public static BufferedImage level_rule[];
    
    public static void init() {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/img/sheet.png"));
        
        chickenFront = new BufferedImage[4];
        chickenFront[0] = sheet.crop(0, 0, width, height);
        chickenFront[1] = sheet.crop(width, 0, width, height);
        chickenFront[2] = sheet.crop(width * 2, 0, width, height);
        chickenFront[3] = sheet.crop(width * 3, 0, width, height);
        
        chickenRight = new BufferedImage[4];
        chickenRight[0] = sheet.crop(0, height, width, height);
        chickenRight[1] = sheet.crop(width, height, width, height);
        chickenRight[2] = sheet.crop(width * 2, height, width, height);
        chickenRight[3] = sheet.crop(width * 3, height, width, height);
        
        chickenLeft = new BufferedImage[4];
        chickenLeft[0] = sheet.crop(0, height * 2, width, height);
        chickenLeft[1] = sheet.crop(width, height * 2, width, height);
        chickenLeft[2] = sheet.crop(width * 2, height * 2, width, height);
        chickenLeft[3] = sheet.crop(width * 3, height * 2, width, height);
        
        cat = new BufferedImage[4];
        cat[0] = sheet.crop(0, height * 3, width, height);
        cat[1] = sheet.crop(width, height * 3, width, height);
        cat[2] = sheet.crop(width * 2, height * 3, width, height);
        cat[3] = sheet.crop(width * 3, height * 3, width, height);
                
        cloud = sheet.crop(0, height * 4, width, height);
        balloon = sheet.crop(width, height * 4, width, height);

        egg = new BufferedImage[2];
        egg[0] = sheet.crop(width * 2, height * 4, width, height);
        egg[1] = sheet.crop(width * 3, height * 4, width, height);

        btn_easy = new BufferedImage[2];
        btn_easy[0] = sheet.crop(0, height * 5, width, height);
        btn_easy[1] = sheet.crop(width, height * 5, width, height);

        btn_medium = new BufferedImage[2];
        btn_medium[0] = sheet.crop(width * 2, height * 5, width, height);
        btn_medium[1] = sheet.crop(width * 3, height * 5, width, height);

        btn_hard = new BufferedImage[2];
        btn_hard[0] = sheet.crop(0, height * 6, width, height);
        btn_hard[1] = sheet.crop(width, height * 6, width, height);

        btn_start = new BufferedImage[2];
        btn_start[0] = sheet.crop(width * 2, height * 6, width, height);
        btn_start[1] = sheet.crop(width * 3, height * 6, width, height);

        numbers = new BufferedImage[10];
        numbers[0] = sheet.crop(0 * (width / 2), height * 7, width/2, height/2);
        numbers[1] = sheet.crop(1 * (width / 2), height * 7, width/2, height/2);
        numbers[2] = sheet.crop(2 * (width / 2), height * 7, width/2, height/2);
        numbers[3] = sheet.crop(3 * (width / 2), height * 7, width/2, height/2);
        numbers[4] = sheet.crop(4 * (width / 2), height * 7, width/2, height/2);
        numbers[5] = sheet.crop(5 * (width / 2), height * 7, width/2, height/2);
        numbers[6] = sheet.crop(6 * (width / 2), height * 7, width/2, height/2);
        numbers[7] = sheet.crop(7 * (width / 2), height * 7, width/2, height/2);
        numbers[8] = sheet.crop(0, (height / 2) * 15, width/2, height/2);
        numbers[9] = sheet.crop(0, height * 8, width/2, height/2);

        heart = sheet.crop(width / 2, (height / 2) * 15, width, height);

        label_choose = sheet.crop(3 * (width / 2), (height / 2) * 15, 3 * (width / 2), height);
        label_over = sheet.crop( width * 3, (height / 2) * 15, width, height);

        label_level = new BufferedImage[3];
        label_level[0] = sheet.crop(0, (height / 2) * 17, width, height);
        label_level[1] = sheet.crop(width, (height / 2) * 17, width, height);
        label_level[2] = sheet.crop(width * 2, (height / 2) * 17, width, height);

        label_try = sheet.crop(width * 3, (height / 2) * 17, width, height);

        level_rule = new BufferedImage[3];
        level_rule[0] = sheet.crop(0, (height / 2) * 19, width * 4, height);
        level_rule[1] = sheet.crop(0, (height / 2) * 21, width * 4, height);
        level_rule[2] = sheet.crop(0, (height / 2) * 23, width * 4, height);

        label_congrats = sheet.crop(0, (height / 2) * 25, width * 2, height);
    }
}

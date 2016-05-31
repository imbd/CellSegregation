import java.awt.*;
import java.util.*;


public class ArraysFiller {


    protected static class RectangleArrayFiller {

        ArrayList<ArrayList<Rectangle>> rectAr = new ArrayList<>();
        ArrayList<ArrayList<Double>> rate = new ArrayList<>();

        RectangleArrayFiller() {
            ArrayList<Rectangle> ar1 = new ArrayList<>();
            ArrayList<Double> r1 = new ArrayList<>();

            ar1.add(new Rectangle(0, 0, 230, 335));
            r1.add(1.0);
            ar1.add(new Rectangle(230, 0, 425, 110));
            r1.add(0.5);
            ar1.add(new Rectangle(265, 20, 500, 245));
            r1.add(0.8);
            ar1.add(new Rectangle(430, 30, 730, 385));
            r1.add(1.0);
            ar1.add(new Rectangle(750, 30, 1080, 240));
            r1.add(1.0);
            ar1.add(new Rectangle(1060, 30, 1380, 690));
            r1.add(1.0);
            ar1.add(new Rectangle(720, 220, 1030, 510));
            r1.add(1.0);
            ar1.add(new Rectangle(250, 290, 555, 735));
            r1.add(1.0);
            ar1.add(new Rectangle(570, 410, 930, 775));
            r1.add(1.0);
            ar1.add(new Rectangle(255, 675, 670, 1010));
            r1.add(0.8);
            ar1.add(new Rectangle(10, 515, 375, 915));
            r1.add(0.6);

            rectAr.add(ar1);
            rate.add(r1);

            ArrayList<Rectangle> ar2 = new ArrayList<>();
            ArrayList<Double> r2 = new ArrayList<>();

            ar2.add(new Rectangle(0, 520, 240, 790));
            r2.add(0.5);
            ar2.add(new Rectangle(180, 230, 355, 655));
            r2.add(1.0);
            ar2.add(new Rectangle(360, 515, 515, 790));
            r2.add(1.0);
            ar2.add(new Rectangle(310, 15, 680, 340));
            r2.add(1.0);
            ar2.add(new Rectangle(435, 300, 750, 590));
            r2.add(1.0);
            ar2.add(new Rectangle(780, 20, 1010, 430));
            r2.add(1.0);
            ar2.add(new Rectangle(1075, 100, 1370, 680));
            r2.add(1.0);
            ar2.add(new Rectangle(730, 480, 1060, 790));
            r2.add(1.0);
            ar2.add(new Rectangle(460, 670, 780, 1010));
            r2.add(1.0);

            rectAr.add(ar2);
            rate.add(r2);

            ArrayList<Rectangle> ar3 = new ArrayList<>();
            ArrayList<Double> r3 = new ArrayList<>();
            ar3.add(new Rectangle(100, 155, 280, 305));
            r3.add(0.9);
            ar3.add(new Rectangle(350, 60, 475, 500));
            r3.add(1.0);
            ar3.add(new Rectangle(355, 415, 710, 730));
            r3.add(1.0);
            ar3.add(new Rectangle(480, 120, 880, 410));
            r3.add(1.0);
            ar3.add(new Rectangle(790, 385, 1070, 665));
            r3.add(0.4);
            ar3.add(new Rectangle(1050, 220, 1215, 505));
            r3.add(0.3);
            ar3.add(new Rectangle(1085, 555, 1260, 830));
            r3.add(0.9);
            ar3.add(new Rectangle(805, 670, 1350, 965));
            r3.add(0.9);

            rectAr.add(ar3);
            rate.add(r3);

            ArrayList<Rectangle> ar4 = new ArrayList<>();
            ArrayList<Double> r4 = new ArrayList<>();
            ar4.add(new Rectangle(440, 740, 880, 1035));
            r4.add(1.0);
            ar4.add(new Rectangle(350, 140, 940, 810));
            r4.add(1.0);
            ar4.add(new Rectangle(945, 320, 1200, 1030));
            r4.add(1.0);
            ar4.add(new Rectangle(1060, 200, 1385, 680));
            r4.add(1.0);

            rectAr.add(ar4);
            rate.add(r4);

            ArrayList<Rectangle> ar5 = new ArrayList<>();
            ArrayList<Double> r5 = new ArrayList<>();

            ar5.add(new Rectangle(15, 230, 460, 905));
            r5.add(1.0);
            ar5.add(new Rectangle(475, 205, 890, 665));
            r5.add(1.0);
            ar5.add(new Rectangle(725, 0, 1160, 245));
            r5.add(1.0);

            rectAr.add(ar5);
            rate.add(r5);

            ArrayList<Rectangle> ar6 = new ArrayList<>();
            ArrayList<Double> r6 = new ArrayList<>();
            ar6.add(new Rectangle(455, 205, 895, 750));
            r6.add(1.0);
            ar6.add(new Rectangle(445, 750, 1100, 1037));
            r6.add(1.0);

            rectAr.add(ar6);
            rate.add(r6);

            ArrayList<Rectangle> ar7 = new ArrayList<>();
            ArrayList<Double> r7 = new ArrayList<>();

            ar7.add(new Rectangle(311, 15, 740, 300));
            r7.add(0.8);
            ar7.add(new Rectangle(375, 395, 740, 955));
            r7.add(1.0);
            ar7.add(new Rectangle(770, 610, 1210, 1030));
            r7.add(1.0);

            rectAr.add(ar7);
            rate.add(r7);


            ArrayList<Rectangle> ar8 = new ArrayList<>();
            ArrayList<Double> r8 = new ArrayList<>();

            ar8.add(new Rectangle(450, 400, 920, 830));
            r8.add(1.0);
            ar8.add(new Rectangle(430, 830, 730, 1030));
            r8.add(1.0);

            rectAr.add(ar8);
            rate.add(r8);

            ArrayList<Rectangle> ar9 = new ArrayList<>();
            ArrayList<Double> r9 = new ArrayList<>();

            ar9.add(new Rectangle(5, 445, 190, 875));
            r9.add(1.0);
            ar9.add(new Rectangle(170, 15, 560, 280));
            r9.add(1.0);
            ar9.add(new Rectangle(360, 270, 1035, 830));
            r9.add(1.0);

            rectAr.add(ar9);
            rate.add(r9);

            ArrayList<Rectangle> ar10 = new ArrayList<>();
            ArrayList<Double> r10 = new ArrayList<>();

            ar10.add(new Rectangle(5, 5, 230, 520));
            r10.add(0.8);
            ar10.add(new Rectangle(50, 500, 650, 950));
            r10.add(1.0);
            ar10.add(new Rectangle(320, 190, 1000, 780));
            r10.add(1.0);

            rectAr.add(ar10);
            rate.add(r10);

            ArrayList<Rectangle> ar11 = new ArrayList<>();
            ArrayList<Double> r11 = new ArrayList<>();

            ar11.add(new Rectangle(50, 90, 430, 1000));
            r11.add(1.0);
            ar11.add(new Rectangle(460, 360, 790, 1030));
            r11.add(1.0);
            ar11.add(new Rectangle(830, 200, 1175, 650));
            r11.add(1.0);
            ar11.add(new Rectangle(910, 580, 1360, 1030));
            r11.add(1.0);
            ar11.add(new Rectangle(1200, 320, 1380, 570));
            r11.add(0.6);

            rectAr.add(ar11);
            rate.add(r11);


            ArrayList<Rectangle> ar12 = new ArrayList<>();


            ar12.add(new Rectangle(30, 300, 455, 900));
            ar12.add(new Rectangle(450, 210, 870, 680));
            ar12.add(new Rectangle(790, 590, 1350, 985));


            rectAr.add(ar12);

            ArrayList<Double> r12 = new ArrayList<>();

            r12.add(0.5);
            r12.add(0.5);
            r12.add(0.4);

            rate.add(r12);

            ArrayList<Rectangle> ar13 = new ArrayList<>();


            ar13.add(new Rectangle(5, 175, 390, 760));
            ar13.add(new Rectangle(465, 360, 955, 600));
            ar13.add(new Rectangle(430, 545, 960, 845));
            ar13.add(new Rectangle(1130, 30, 1375, 540));

            ArrayList<Double> r13 = new ArrayList<>();

            r13.add(1.0);
            r13.add(1.0);
            r13.add(1.0);
            r13.add(1.0);
            rate.add(r13);

            rectAr.add(ar13);


            ArrayList<Rectangle> ar14 = new ArrayList<>();

            ar14.add(new Rectangle(10, 20, 715, 440));
            ar14.add(new Rectangle(770, 5, 1150, 430));
            ar14.add(new Rectangle(5, 450, 325, 1035));
            ar14.add(new Rectangle(170, 420, 520, 835));
            ar14.add(new Rectangle(550, 440, 995, 945));

            ArrayList<Double> r14 = new ArrayList<>();
            r14.add(1.0);
            r14.add(0.9);
            r14.add(0.7);
            r14.add(1.0);
            r14.add(1.0);
            rate.add(r14);

            rectAr.add(ar14);

            ArrayList<Rectangle> ar15 = new ArrayList<>();

            ar15.add(new Rectangle(1, 30, 215, 610));
            ar15.add(new Rectangle(265, 5, 735, 325));
            ar15.add(new Rectangle(350, 300, 955, 785));
            ar15.add(new Rectangle(735, 5, 1370, 280));

            ArrayList<Double> r15 = new ArrayList<>();
            r15.add(0.4);
            r15.add(0.5);
            r15.add(0.5);
            r15.add(0.3);
            rate.add(r15);

            rectAr.add(ar15);


            ArrayList<Rectangle> ar16 = new ArrayList<>();

            ar16.add(new Rectangle(660, 5, 1380, 360));
            ar16.add(new Rectangle(400, 290, 990, 820));
            ar16.add(new Rectangle(880, 560, 1387, 1039));

            ArrayList<Double> r16 = new ArrayList<>();
            r16.add(0.8);
            r16.add(1.0);
            r16.add(0.4);
            rate.add(r16);

            rectAr.add(ar16);


            ArrayList<Rectangle> ar17 = new ArrayList<>();

            ar17.add(new Rectangle(260, 5, 610, 480));
            ar17.add(new Rectangle(540, 320, 830, 800));
            ar17.add(new Rectangle(735, 5, 1385, 370));
            ar17.add(new Rectangle(790, 360, 1380, 925));

            ArrayList<Double> r17 = new ArrayList<>();

            r17.add(0.8);
            r17.add(1.0);
            r17.add(0.4);
            r17.add(0.8);
            rate.add(r17);

            rectAr.add(ar17);


            ArrayList<Rectangle> ar18 = new ArrayList<>();

            ar18.add(new Rectangle(5, 340, 295, 1035));
            ar18.add(new Rectangle(45, 10, 770, 370));
            ar18.add(new Rectangle(390, 355, 945, 965));
            ar18.add(new Rectangle(815, 5, 1380, 330));

            ArrayList<Double> r18 = new ArrayList<>();
            r18.add(0.9);
            r18.add(0.6);
            r18.add(1.0);
            r18.add(0.3);
            rate.add(r18);

            rectAr.add(ar18);


            ArrayList<Rectangle> ar19 = new ArrayList<>();

            ar19.add(new Rectangle(15, 5, 510, 550));
            ar19.add(new Rectangle(310, 300, 920, 890));


            ArrayList<Double> r19 = new ArrayList<>();
            r19.add(0.8);
            r19.add(0.8);

            rate.add(r19);

            rectAr.add(ar19);


            ArrayList<Rectangle> ar20 = new ArrayList<>();

            ar20.add(new Rectangle(10, 60, 450, 945));
            ar20.add(new Rectangle(410, 155, 840, 725));
            ar20.add(new Rectangle(520, 675, 1285, 995));


            ArrayList<Double> r20 = new ArrayList<>();
            r20.add(1.0);
            r20.add(0.8);
            r20.add(0.8);

            rate.add(r20);


            rectAr.add(ar20);


            ArrayList<Rectangle> ar21 = new ArrayList<>();


            ar21.add(new Rectangle(220, 275, 985, 800));
            ar21.add(new Rectangle(725, 775, 1370, 1030));
            ar21.add(new Rectangle(1050, 375, 1380, 715));
            ar21.add(new Rectangle(1040, 10, 1380, 355));

            ArrayList<Double> r21 = new ArrayList<>();

            r21.add(0.4);
            r21.add(0.4);
            r21.add(0.8);
            r21.add(0.4);
            rate.add(r21);

            rectAr.add(ar21);


            ArrayList<Rectangle> ar22 = new ArrayList<>();

            ar22.add(new Rectangle(565, 5, 1110, 315));
            ar22.add(new Rectangle(895, 300, 1380, 880));
            ar22.add(new Rectangle(515, 430, 895, 995));
            ar22.add(new Rectangle(80, 690, 480, 1039));

            ArrayList<Double> r22 = new ArrayList<>();

            r22.add(0.6);
            r22.add(1.0);
            r22.add(1.0);
            r22.add(0.7);
            rate.add(r22);

            rectAr.add(ar22);


            ArrayList<Rectangle> ar23 = new ArrayList<>();

            ar23.add(new Rectangle(795, 1, 1145, 430));
            ar23.add(new Rectangle(1180, 1, 1385, 415));
            ar23.add(new Rectangle(1135, 500, 1385, 1039));
            ar23.add(new Rectangle(850, 820, 1240, 1039));
            ar23.add(new Rectangle(425, 330, 980, 845));

            ArrayList<Double> r23 = new ArrayList<>();
            r23.add(0.4);
            r23.add(0.3);
            r23.add(0.4);
            r23.add(0.4);
            r23.add(1.0);
            rate.add(r23);

            rectAr.add(ar23);


            ArrayList<Rectangle> ar24 = new ArrayList<>();

            ar24.add(new Rectangle(5, 545, 465, 1005));
            ar24.add(new Rectangle(475, 305, 855, 895));
            ar24.add(new Rectangle(870, 155, 1275, 850));

            ArrayList<Double> r24 = new ArrayList<>();
            r24.add(0.7);
            r24.add(1.0);
            r24.add(1.0);
            rate.add(r24);

            rectAr.add(ar24);


            ArrayList<Rectangle> ar25 = new ArrayList<>();


            ar25.add(new Rectangle(5, 190, 390, 735));
            ar25.add(new Rectangle(430, 530, 925, 830));
            ar25.add(new Rectangle(475, 360, 945, 575));
            ar25.add(new Rectangle(1130, 35, 1385, 500));

            ArrayList<Double> r25 = new ArrayList<>();

            r25.add(1.0);
            r25.add(1.0);
            r25.add(1.0);
            r25.add(0.9);
            rate.add(r25);

            rectAr.add(ar25);


            ArrayList<Rectangle> ar26 = new ArrayList<>();

            ar26.add(new Rectangle(285, 380, 555, 705));
            ar26.add(new Rectangle(530, 175, 885, 470));
            ar26.add(new Rectangle(580, 560, 900, 860));
            ar26.add(new Rectangle(940, 720, 1240, 1030));


            ArrayList<Double> r26 = new ArrayList<>();
            r26.add(0.4);
            r26.add(0.4);
            r26.add(0.4);
            r26.add(0.3);

            rate.add(r26);

            rectAr.add(ar26);


            ArrayList<Rectangle> ar27 = new ArrayList<>();

            ar27.add(new Rectangle(550, 5, 975, 240));
            ar27.add(new Rectangle(700, 260, 1135, 530));
            ar27.add(new Rectangle(375, 535, 945, 835));


            ArrayList<Double> r27 = new ArrayList<>();
            r27.add(0.4);
            r27.add(0.5);
            r27.add(0.5);
            rate.add(r27);

            rectAr.add(ar27);


            ArrayList<Rectangle> ar28 = new ArrayList<>();

            ar28.add(new Rectangle(270, 1, 580, 310));
            ar28.add(new Rectangle(600, 10, 875, 350));
            ar28.add(new Rectangle(300, 330, 885, 595));
            ar28.add(new Rectangle(440, 590, 1085, 880));


            ArrayList<Double> r28 = new ArrayList<>();
            r28.add(0.3);
            r28.add(0.3);
            r28.add(0.4);
            r28.add(0.5);

            rate.add(r28);

            rectAr.add(ar28);


            ArrayList<Rectangle> ar29 = new ArrayList<>();

            ar29.add(new Rectangle(220, 290, 880, 625));

            ArrayList<Double> r29 = new ArrayList<>();

            r29.add(1.0);
            rate.add(r29);

            rectAr.add(ar29);


            ArrayList<Rectangle> ar30 = new ArrayList<>();

            ar30.add(new Rectangle(1, 190, 215, 630));
            ar30.add(new Rectangle(265, 1, 665, 475));
            ar30.add(new Rectangle(645, 105, 1050, 460));
            ar30.add(new Rectangle(950, 1, 1340, 340));
            ar30.add(new Rectangle(390, 480, 1030, 860));
            ar30.add(new Rectangle(1030, 510, 1385, 870));


            ArrayList<Double> r30 = new ArrayList<>();
            r30.add(0.5);
            r30.add(1.0);
            r30.add(1.0);
            r30.add(0.7);
            r30.add(1.0);
            r30.add(0.7);

            rate.add(r30);

            rectAr.add(ar30);


            ArrayList<Rectangle> ar31 = new ArrayList<>();

            ar31.add(new Rectangle(5, 130, 135, 275));
            ar31.add(new Rectangle(705, 1, 1135, 215));
            ar31.add(new Rectangle(270, 390, 715, 925));
            ar31.add(new Rectangle(740, 370, 1055, 735));

            ArrayList<Double> r31 = new ArrayList<>();
            r31.add(0.1);
            r31.add(0.3);
            r31.add(0.9);
            r31.add(0.6);
            rate.add(r31);

            rectAr.add(ar31);


            ArrayList<Rectangle> ar32 = new ArrayList<>();

            ar32.add(new Rectangle(335, 130, 750, 720));
            ar32.add(new Rectangle(835, 1, 1170, 500));
            ar32.add(new Rectangle(985, 430, 1380, 765));

            ArrayList<Double> r32 = new ArrayList<>();
            r32.add(1.0);
            r32.add(0.8);
            r32.add(0.5);
            rate.add(r32);

            rectAr.add(ar32);


            ArrayList<Rectangle> ar33 = new ArrayList<>();

            ar33.add(new Rectangle(1, 50, 145, 610));
            ar33.add(new Rectangle(30, 1, 640, 225));
            ar33.add(new Rectangle(480, 195, 910, 900));
            ar33.add(new Rectangle(30, 665, 440, 1037));
            ar33.add(new Rectangle(805, 1, 1250, 230));

            ArrayList<Double> r33 = new ArrayList<>();
            r33.add(0.3);
            r33.add(0.4);
            r33.add(0.9);
            r33.add(0.4);
            r33.add(0.5);

            rate.add(r33);

            rectAr.add(ar33);


            ArrayList<Rectangle> ar34 = new ArrayList<>();

            ar34.add(new Rectangle(160, 100, 455, 665));
            ar34.add(new Rectangle(520, 155, 835, 600));
            ar34.add(new Rectangle(645, 575, 975, 780));
            ar34.add(new Rectangle(995, 460, 1375, 755));
            ar34.add(new Rectangle(760, 115, 1080, 470));
            ar34.add(new Rectangle(1075, 100, 1365, 390));

            ArrayList<Double> r34 = new ArrayList<>();
            r34.add(0.8);
            r34.add(0.8);
            r34.add(0.6);
            r34.add(0.5);
            r34.add(0.6);
            r34.add(0.4);
            rate.add(r34);


            rectAr.add(ar34);

            ArrayList<Rectangle> ar35 = new ArrayList<>();

            ar35.add(new Rectangle(695, 200, 910, 900));
            ar35.add(new Rectangle(470, 180, 670, 690));
            ar35.add(new Rectangle(890, 125, 1130, 465));
            ar35.add(new Rectangle(930, 490, 1375, 830));
            ar35.add(new Rectangle(1, 270, 385, 605));
            ar35.add(new Rectangle(240, 1, 530, 310));
            ar35.add(new Rectangle(270, 690, 690, 1030));

            ArrayList<Double> r35 = new ArrayList<>();
            r35.add(1.0);
            r35.add(1.0);
            r35.add(1.0);
            r35.add(0.9);
            r35.add(0.9);
            r35.add(0.8);
            r35.add(0.5);
            rate.add(r35);

            rectAr.add(ar35);

        }
    }


    protected static class ColorCodeFiller {

        int[] colorCode = new int[256];

        ColorCodeFiller() {
            colorCode[0] = -16777216;
            colorCode[1] = -16711423;
            colorCode[2] = -16645630;
            colorCode[3] = -16579837;
            colorCode[4] = -16514044;
            colorCode[5] = -16448251;
            colorCode[6] = -16382458;
            colorCode[7] = -16316665;
            colorCode[8] = -16250872;
            colorCode[9] = -16185079;
            colorCode[10] = -16119286;
            colorCode[11] = -16053493;
            colorCode[12] = -15987700;
            colorCode[13] = -15921907;
            colorCode[14] = -15856114;
            colorCode[15] = -15790321;
            colorCode[16] = -15724528;
            colorCode[17] = -15658735;
            colorCode[18] = -15592942;
            colorCode[19] = -15527149;
            colorCode[20] = -15461356;
            colorCode[21] = -15395563;
            colorCode[22] = -15329770;
            colorCode[23] = -15263977;
            colorCode[24] = -15198184;
            colorCode[25] = -15132391;
            colorCode[26] = -15066598;
            colorCode[27] = -15000805;
            colorCode[28] = -14935012;
            colorCode[29] = -14869219;
            colorCode[30] = -14803426;
            colorCode[31] = -14737633;
            colorCode[32] = -14671840;
            colorCode[33] = -14606047;
            colorCode[34] = -14540254;
            colorCode[35] = -14474461;
            colorCode[36] = -14408668;
            colorCode[37] = -14342875;
            colorCode[38] = -14277082;
            colorCode[39] = -14211289;
            colorCode[40] = -14145496;
            colorCode[41] = -14079703;
            colorCode[42] = -14013910;
            colorCode[43] = -13948117;
            colorCode[44] = -13882324;
            colorCode[45] = -13816531;
            colorCode[46] = -13750738;
            colorCode[47] = -13684945;
            colorCode[48] = -13619152;
            colorCode[49] = -13553359;
            colorCode[50] = -13487566;
            colorCode[51] = -13421773;
            colorCode[52] = -13355980;
            colorCode[53] = -13290187;
            colorCode[54] = -13224394;
            colorCode[55] = -13158601;
            colorCode[56] = -13092808;
            colorCode[57] = -13027015;
            colorCode[58] = -12961222;
            colorCode[59] = -12895429;
            colorCode[60] = -12829636;
            colorCode[61] = -12763843;
            colorCode[62] = -12698050;
            colorCode[63] = -12632257;
            colorCode[64] = -12566464;
            colorCode[65] = -12500671;
            colorCode[66] = -12434878;
            colorCode[67] = -12369085;
            colorCode[68] = -12303292;
            colorCode[69] = -12237499;
            colorCode[70] = -12171706;
            colorCode[71] = -12105913;
            colorCode[72] = -12040120;
            colorCode[73] = -11974327;
            colorCode[74] = -11908534;
            colorCode[75] = -11842741;
            colorCode[76] = -11776948;
            colorCode[77] = -11711155;
            colorCode[78] = -11645362;
            colorCode[79] = -11579569;
            colorCode[80] = -11513776;
            colorCode[81] = -11447983;
            colorCode[82] = -11382190;
            colorCode[83] = -11316397;
            colorCode[84] = -11250604;
            colorCode[85] = -11184811;
            colorCode[86] = -11119018;
            colorCode[87] = -11053225;
            colorCode[88] = -10987432;
            colorCode[89] = -10921639;
            colorCode[90] = -10855846;
            colorCode[91] = -10790053;
            colorCode[92] = -10724260;
            colorCode[93] = -10658467;
            colorCode[94] = -10592674;
            colorCode[95] = -10526881;
            colorCode[96] = -10461088;
            colorCode[97] = -10395295;
            colorCode[98] = -10329502;
            colorCode[99] = -10263709;
            colorCode[100] = -10197916;
            colorCode[101] = -10132123;
            colorCode[102] = -10066330;
            colorCode[103] = -10000537;
            colorCode[104] = -9934744;
            colorCode[105] = -9868951;
            colorCode[106] = -9803158;
            colorCode[107] = -9737365;
            colorCode[108] = -9671572;
            colorCode[109] = -9605779;
            colorCode[110] = -9539986;
            colorCode[111] = -9474193;
            colorCode[112] = -9408400;
            colorCode[113] = -9342607;
            colorCode[114] = -9276814;
            colorCode[115] = -9211021;
            colorCode[116] = -9145228;
            colorCode[117] = -9079435;
            colorCode[118] = -9013642;
            colorCode[119] = -8947849;
            colorCode[120] = -8882056;
            colorCode[121] = -8816263;
            colorCode[122] = -8750470;
            colorCode[123] = -8684677;
            colorCode[124] = -8618884;
            colorCode[125] = -8553091;
            colorCode[126] = -8487298;
            colorCode[127] = -8421505;
            colorCode[128] = -8355712;
            colorCode[129] = -8289919;
            colorCode[130] = -8224126;
            colorCode[131] = -8158333;
            colorCode[132] = -8092540;
            colorCode[133] = -8026747;
            colorCode[134] = -7960954;
            colorCode[135] = -7895161;
            colorCode[136] = -7829368;
            colorCode[137] = -7763575;
            colorCode[138] = -7697782;
            colorCode[139] = -7631989;
            colorCode[140] = -7566196;
            colorCode[141] = -7500403;
            colorCode[142] = -7434610;
            colorCode[143] = -7368817;
            colorCode[144] = -7303024;
            colorCode[145] = -7237231;
            colorCode[146] = -7171438;
            colorCode[147] = -7105645;
            colorCode[148] = -7039852;
            colorCode[149] = -6974059;
            colorCode[150] = -6908266;
            colorCode[151] = -6842473;
            colorCode[152] = -6776680;
            colorCode[153] = -6710887;
            colorCode[154] = -6645094;
            colorCode[155] = -6579301;
            colorCode[156] = -6513508;
            colorCode[157] = -6447715;
            colorCode[158] = -6381922;
            colorCode[159] = -6316129;
            colorCode[160] = -6250336;
            colorCode[161] = -6184543;
            colorCode[162] = -6118750;
            colorCode[163] = -6052957;
            colorCode[164] = -5987164;
            colorCode[165] = -5921371;
            colorCode[166] = -5855578;
            colorCode[167] = -5789785;
            colorCode[168] = -5723992;
            colorCode[169] = -5658199;
            colorCode[170] = -5592406;
            colorCode[171] = -5526613;
            colorCode[172] = -5460820;
            colorCode[173] = -5395027;
            colorCode[174] = -5329234;
            colorCode[175] = -5263441;
            colorCode[176] = -5197648;
            colorCode[177] = -5131855;
            colorCode[178] = -5066062;
            colorCode[179] = -5000269;
            colorCode[180] = -4934476;
            colorCode[181] = -4868683;
            colorCode[182] = -4802890;
            colorCode[183] = -4737097;
            colorCode[184] = -4671304;
            colorCode[185] = -4605511;
            colorCode[186] = -4539718;
            colorCode[187] = -4473925;
            colorCode[188] = -4408132;
            colorCode[189] = -4342339;
            colorCode[190] = -4276546;
            colorCode[191] = -4210753;
            colorCode[192] = -4144960;
            colorCode[193] = -4079167;
            colorCode[194] = -4013374;
            colorCode[195] = -3947581;
            colorCode[196] = -3881788;
            colorCode[197] = -3815995;
            colorCode[198] = -3750202;
            colorCode[199] = -3684409;
            colorCode[200] = -3618616;
            colorCode[201] = -3552823;
            colorCode[202] = -3487030;
            colorCode[203] = -3421237;
            colorCode[204] = -3355444;
            colorCode[205] = -3289651;
            colorCode[206] = -3223858;
            colorCode[207] = -3158065;
            colorCode[208] = -3092272;
            colorCode[209] = -3026479;
            colorCode[210] = -2960686;
            colorCode[211] = -2894893;
            colorCode[212] = -2829100;
            colorCode[213] = -2763307;
            colorCode[214] = -2697514;
            colorCode[215] = -2631721;
            colorCode[216] = -2565928;
            colorCode[217] = -2500135;
            colorCode[218] = -2434342;
            colorCode[219] = -2368549;
            colorCode[220] = -2302756;
            colorCode[221] = -2236963;
            colorCode[222] = -2171170;
            colorCode[223] = -2105377;
            colorCode[224] = -2039584;
            colorCode[225] = -1973791;
            colorCode[226] = -1907998;
            colorCode[227] = -1842205;
            colorCode[228] = -1776412;
            colorCode[229] = -1710619;
            colorCode[230] = -1644826;
            colorCode[231] = -1579033;
            colorCode[232] = -1513240;
            colorCode[233] = -1447447;
            colorCode[234] = -1381654;
            colorCode[235] = -1315861;
            colorCode[236] = -1250068;
            colorCode[237] = -1184275;
            colorCode[238] = -1118482;
            colorCode[239] = -1052689;
            colorCode[240] = -986896;
            colorCode[241] = -921103;
            colorCode[242] = -855310;
            colorCode[243] = -789517;
            colorCode[244] = -723724;
            colorCode[245] = -657931;
            colorCode[246] = -592138;
            colorCode[247] = -526345;
            colorCode[248] = -460552;
            colorCode[249] = -394759;
            colorCode[250] = -328966;
            colorCode[251] = -263173;
            colorCode[252] = -197380;
            colorCode[253] = -131587;
            colorCode[254] = -65794;
            colorCode[255] = -1;
        }
    }

    protected static class ColorsArray {
        Color[] colors = new Color[10];

        ColorsArray() {

            colors[0] = Color.RED;
            colors[1] = Color.YELLOW;
            colors[2] = Color.GREEN;
            colors[3] = Color.CYAN;
            colors[4] = Color.BLUE;
            colors[5] = Color.MAGENTA;
            colors[6] = new Color(255, 140, 0);
            colors[7] = new Color(255, 20, 147);
            colors[8] = new Color(200, 125, 125);
            colors[9] = new Color(20, 250, 140);
        }

    }

    protected static class ColorsArgbArray {
        int[] colorsArgb = new int[10];

        ColorsArgbArray() {

            colorsArgb[0] = Color.RED.getRGB();
            colorsArgb[1] = Color.YELLOW.getRGB();
            colorsArgb[2] = Color.GREEN.getRGB();
            colorsArgb[3] = Color.CYAN.getRGB();
            colorsArgb[4] = Color.BLUE.getRGB();
            colorsArgb[5] = Color.MAGENTA.getRGB();
            colorsArgb[6] = new Color(255, 140, 0).getRGB();
            colorsArgb[7] = new Color(255, 20, 147).getRGB();
            colorsArgb[8] = new Color(200, 125, 125).getRGB();
            colorsArgb[9] = new Color(20, 250, 140).getRGB();
        }

    }

}
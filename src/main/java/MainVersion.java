import com.idrsolutions.image.tiff.TiffDecoder;
import com.idrsolutions.image.tiff.TiffEncoder;
import javafx.util.Pair;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class MainVersion extends ArraysFiller {

    private static BufferedImage myImage, trueImage;


    private static String path = System.getProperty("user.dir");
    private static String newFolder = "result";
    private static int CURRENT_NUMBER;
    private static int SCALE = 2;
    private static int COLORS_NUMBER = 50;
    private static int COMPONENT_SIZE = 4000;
    private static int MAX_BORDER = 1200;
    private static int MIN_BORDER = 500;
    private static int TO_COLOR_BORDER = MAX_BORDER;
    private static int NOM = 9;
    private static int DENOM = 9;
    private static double K_B = 1.15;
    private static double K_DIV = 1.65;
    private static int BORDER = 70;
    private static int COOL_BORDER = 3;
    private static int MAX_X;
    private static int MAX_Y;
    private static double averageFileBrightness;
    private static int DARK = -16777216;
    private static int[] colorCode = new int[256];
    private static int[] primes = {23, 29, 31, 37};
    private static int[] directionX = new int[]{1, 0, 0, -1, 1, 1, -1, -1}, directionY = new int[]{0, 1, -1, 0, 1, -1, 1, -1};

    public static class Cell {
        private final int x;
        private final int y;
        private final int r;

        Cell(int x, int y, int r) {
            this.x = x;
            this.y = y;
            this.r = r;
        }
    }

    public static Image getImageFromArray(int[] pixels, int width, int height) {
        BufferedImage colorImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        colorImage.setRGB(0, 0, width, height, pixels, 0, width);
        return colorImage;
    }


    public static void bfs(int x, int y, int curColor, int[][] color) {

        Queue queue = new LinkedList<>();
        queue.add(new Pair<>(x, y));

        while (!queue.isEmpty()) {

            Pair<Integer, Integer> pair = (Pair<Integer, Integer>) queue.peek();
            queue.remove();
            x = pair.getKey();
            y = pair.getValue();
            if (color[x][y] != 0) {
                continue;
            }
            CURRENT_NUMBER++;
            color[x][y] = curColor;

            for (int i = 0; i < 8; i++) {
                int nx = x + directionX[i] * SCALE;
                int ny = y + directionY[i] * SCALE;
                if (nx >= MAX_X || ny >= MAX_Y || nx < 0 || ny < 0) {
                    continue;
                }
                int nNX = nx / SCALE;
                int nNY = ny / SCALE;
                int index = (nNX * nNX + nNY * nNY + nNX * nNY + nNX + nNY) % 4;
                int num = (nNX * nNY) % primes[index];

                if (myImage.getRGB(nx, ny) != DARK && color[nx][ny] == 0 && (num % primes[index] <= NOM * primes[index] / DENOM) && (abs((nx / SCALE) - (ny / SCALE)) % 5 <= 3) && (((nx / SCALE) + (ny / SCALE) + 1) % 5 <= 3)) {
                    queue.add(new Pair<>(nx, ny));
                }
            }
        }
    }


    private static Comparator<Pair<Pair<Integer, Integer>, Integer>> comparator = (p1, p2) -> {
        if (p1.getValue() > p2.getValue()) {
            return 1;
        }
        if (p1.getValue() < p2.getValue()) {
            return -1;
        }
        return 0;

    };

    public static void toColorBfs(int x, int y, int curColor, int[][] color, boolean[][] used, int[][] dist, boolean[] colorsUsed, int[][] bestColor) {

        PriorityQueue<Pair<Pair<Integer, Integer>, Integer>> queue = new PriorityQueue<>(comparator);

        queue.add(new Pair(new Pair(x, y), 0));

        while (!queue.isEmpty()) {

            Pair<Integer, Integer> pair = queue.peek().getKey();
            int curDist = queue.remove().getValue();


            x = pair.getKey();
            y = pair.getValue();
            used[x][y] = true;
            if (dist[x][y] <= curDist) {
                continue;
            }
            if (curDist > TO_COLOR_BORDER / SCALE) {
                continue;
            }
            CURRENT_NUMBER++;
            dist[x][y] = curDist;
            bestColor[x][y] = curColor;

            for (int i = 0; i < 8; i++) {
                int nx = x + directionX[i] * SCALE;
                int ny = y + directionY[i] * SCALE;
                if (nx >= MAX_X || ny >= MAX_Y || nx < 0 || ny < 0) {
                    continue;
                }
                int t = 0;
                int rgb = trueImage.getRGB(nx, ny);
                int a = rgb & 0xFF;
                if (a < 2 * averageFileBrightness) {
                    t += 1;
                }
                if (a < averageFileBrightness) {
                    t += 2;
                }
                if (a < averageFileBrightness / 2) {
                    t += 5;
                }
                if (a < averageFileBrightness / 5) {
                    t += 25;
                }
                if (a < averageFileBrightness / 10) {
                    t += 50;
                }
                if (a <= 10) {
                    t += 100;
                }
                if (!colorsUsed[color[nx][ny]] && curDist + t < TO_COLOR_BORDER / SCALE && curDist + t < dist[nx][ny]) {
                    queue.add(new Pair(new Pair(nx, ny), curDist + t));

                }
                if (color[nx][ny] == curColor && dist[nx][ny] > 0) {
                    queue.add(new Pair(new Pair(nx, ny), 0));
                }
            }
        }

    }


    public static void main(String[] args) {

        new File(newFolder).mkdir();
        String fold = path + "\\" + newFolder + "\\Only colored pictures";
        new File(fold).mkdir();

        ColorCodeFiller ccf = new ColorCodeFiller();

        System.arraycopy(ccf.colorCode, 0, colorCode, 0, ccf.colorCode.length);

        /*RectangleArrayFiller rf = new RectangleArrayFiller();

        ArrayList<ArrayList<Rectangle>> rectAr = rf.rectAr;
        ArrayList<ArrayList<Double>> rate = rf.rate;


        int[] scale = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] to_color_border = {80, 120, 160, 240, 320};
        int[] denom = {9, 10, 11};
        double[] k_b = {0.95, 0.9, 0.85, 0.8};
        int[] border = {80, 60, 40};
        double[] k_div = {1.6, 1.7, 1.8};

            double minimum = 1000;
            int res_i1 = 100;
            int res_i2 = 100;
            int res_i3 = 100;
            int res_i4 = 100;
            int res_i5 = 100;
            int res_i6 = 100;
            double res_1 = 1000;

            int i1 = 1;
            int i2 = 4;
            int i3 = 0;
            int i4 = 3;
            int i5 = 1;
            int i6 = 2;


            for (int i1 = 0; i1 < scale.length; i1++) {
            for (int i2 = 0; i2 < to_color_border.length; i2++) {
            for (int i3 = 0; i3 < denom.length; i3++) {
            for (int i4 = 0; i4 < k_b.length; i4++) {
            for (int i5 = 0; i5 < border.length; i5++) {
            for (int i6 = 0; i6 < k_div.length; i6++) {
        ;*/


                /*SCALE = scale[i1];
                TO_COLOR_BORDER = to_color_border[i2];
                DENOM = denom[i3];
                K_B = k_b[i4];
                BORDER = border[i5];
                K_DIV = k_div[i6];*/


                /*System.out.println("SCALE=" + scale[i1]);
                System.out.println("TO_COLOR_BORDER=" + to_color_border[i2]);
                System.out.println("DENOM=" + denom[i3]);
                System.out.println("K_B=" + k_b[i4]);
                System.out.println("BORDER=" + border[i5]);
                System.out.println("K_DIV=" + k_div[i6]);


                double result = 0;
                double result1 = 0; */

        int num = 0;

        try {


            //File folder = new File(path + "\\07-27-11-taxolVero\\to_check\\");
            //File folder = new File(path + "\\07-27-11-taxolVero\\16mar2016\\");
            //File folder = new File(path + "\\07-27-11-taxolVero\\control\\");
            //File folder = new File(path + "\\07-27-11-taxolVero\\01mkg\\");
            //File folder = new File(path + "\\07-27-11-taxolVero\\1mkg\\");
            //File folder = new File(path + "\\07-27-11-taxolVero\\5mkg\\");
            File folder = new File(path + "\\07-27-11-taxolVero\\for_presentation\\");

            File[] files = folder.listFiles();
            for (File f : files) {
                if (!f.isFile()) {
                    continue;
                }
                String absPath = f.getAbsolutePath();
                if (absPath.substring(absPath.length() - 3).equals("xml")) {
                    continue;
                }
                num++;
                String dir = path + "\\" + newFolder + "\\" + f.getName();
                TiffEncoder encoder = new TiffEncoder();
                encoder.setCompressed(true);

                RandomAccessFile raf = new RandomAccessFile(f, "r");
                TiffDecoder decoder = new TiffDecoder(raf);

                myImage = decoder.read();
                MAX_Y = myImage.getHeight();
                MAX_X = myImage.getWidth();

                int allBrightness = 0;
                for (int x = 0; x < MAX_X; x++) {
                    for (int y = 0; y < MAX_Y; y++) {
                        int argb = myImage.getRGB(x, y);
                        int r = (argb) & 0xFF;
                        allBrightness += r;
                    }
                }

                averageFileBrightness = (double) allBrightness / (double) (MAX_X * MAX_Y);

                for (int x = 0; x < MAX_X; x += SCALE) {
                    for (int y = 0; y < MAX_Y; y += SCALE) {
                        int allR = 0;
                        for (int i = x; i < min(x + SCALE, MAX_X); i++) {
                            for (int j = y; j < min(y + SCALE, MAX_Y); j++) {
                                int argb = myImage.getRGB(i, j);
                                int r = (argb) & 0xFF;
                                allR += r;
                            }
                        }
                        allR /= (SCALE * SCALE);
                        int argb = colorCode[allR];
                        for (int i = x; i < min(x + SCALE, MAX_X); i++) {
                            for (int j = y; j < min(y + SCALE, MAX_Y); j++) {
                                myImage.setRGB(i, j, argb);
                            }
                        }
                    }
                }

                if (averageFileBrightness < BORDER) {
                    double k = (double) BORDER / averageFileBrightness;
                    for (int x = 0; x < MAX_X; x += 1) {
                        for (int y = 0; y < MAX_Y; y += 1) {
                            int argb = myImage.getRGB(x, y);
                            int r1 = (argb) & 0xFF;
                            int r = (int) (r1 * k);
                            r = min(r, 255);

                            argb = colorCode[r];
                            myImage.setRGB(x, y, argb);

                        }
                    }
                    averageFileBrightness = BORDER;
                }

                int argb;
                for (int x = 0; x < MAX_X; x++) {
                    for (int y = 0; y < MAX_Y; y++) {
                        int nx = (x / SCALE) * SCALE;
                        int ny = (y / SCALE) * SCALE;
                        argb = myImage.getRGB(nx, ny);
                        int r = (argb) & 0xFF;

                        if (r <= K_B * averageFileBrightness) {
                            argb = DARK;
                        }
                        myImage.setRGB(x, y, argb);

                    }
                }

                allBrightness = 0;
                int pixelNumber = 0;
                for (int x = 0; x < MAX_X; x++) {
                    for (int y = 0; y < MAX_Y; y++) {
                        argb = myImage.getRGB(x, y);
                        int r = (argb) & 0xFF;
                        if (argb != DARK) {
                            allBrightness += r;
                            pixelNumber++;
                        }
                    }
                }

                averageFileBrightness = (double) allBrightness / (double) (pixelNumber);

                double nk = 1.20;
                if (averageFileBrightness <= 180) {
                    nk = 1.10;
                }

                if (averageFileBrightness <= 150) {
                    nk = 1.00;
                }

                nk -= 0.10;

                int lowBrightness = (int) (averageFileBrightness * nk);

                if (lowBrightness > 210) {
                    lowBrightness = min(205, lowBrightness - 10);
                }

                for (int x = 0; x < MAX_X; x++) {
                    for (int y = 0; y < MAX_Y; y++) {
                        int nx = (x / SCALE) * SCALE;
                        int ny = (y / SCALE) * SCALE;
                        argb = myImage.getRGB(nx, ny);
                        int r = (argb) & 0xFF;
                        if (r <= lowBrightness) {
                            argb = DARK;
                        }
                        myImage.setRGB(x, y, argb);

                    }
                }

                ArrayList<Cell> cells = new ArrayList<>();
                for (int x = 0; x < MAX_X; x += SCALE) {
                    for (int y = 0; y < MAX_Y; y += SCALE) {
                        argb = myImage.getRGB(x, y);
                        int r = (argb) & 0xFF;
                        cells.add(new Cell(x / SCALE, y / SCALE, r));
                    }
                }

                cells.sort((c1, c2) -> c1.r > c2.r ? -1 : c1.r < c2.r ? 1 : 0);

                int[][] color = new int[MAX_X][MAX_Y];
                boolean[][] used = new boolean[MAX_X][MAX_Y];
                int[][] dist = new int[MAX_X][MAX_Y];
                int[][] bestColor = new int[MAX_X][MAX_Y];
                int curColor = 1;

                ArrayList<Integer> colors = new ArrayList<>();
                boolean[] colorsUsed = new boolean[MAX_X * MAX_Y];
                ArrayList<Pair<Integer, Integer>> pairs = new ArrayList<>();

                for (Cell cell : cells) {
                    int x = cell.x;
                    int y = cell.y;
                    x *= SCALE;
                    y *= SCALE;
                    if (color[x][y] == 0) {
                        CURRENT_NUMBER = 0;
                        bfs(x, y, curColor, color);
                        if (CURRENT_NUMBER > COMPONENT_SIZE / (SCALE * SCALE) / K_DIV) {
                            colors.add(curColor);
                            pairs.add(new Pair(x, y));
                        }
                        curColor++;
                    }
                }


                if (colors.size() == 0) {
                    System.out.println("HAHA 0 cells detected");
                    continue;
                }

                BufferedImage crop;
                trueImage = decoder.read();
                if (colors.size() > COLORS_NUMBER) {
                    System.out.println("Too much: " + colors.size());
                    break;
                }

                int[] colorsArgb = new int[COLORS_NUMBER];
                ColorsArgbArray caa = new ColorsArgbArray();
                System.arraycopy(caa.colorsArgb, 0, colorsArgb, 0, 10);

                for (int i = 10; i < COLORS_NUMBER; i++) {
                    colorsArgb[i] = colorsArgb[i % 10];
                }
                Color[] myColor = new Color[COLORS_NUMBER];
                ColorsArray ca = new ColorsArray();
                System.arraycopy(ca.colors, 0, myColor, 0, 10);

                for (int i = 10; i < COLORS_NUMBER; i++) {
                    myColor[i] = myColor[i % 10];
                }
                for (int i = 0; i < MAX_X * MAX_Y; i++) {
                    colorsUsed[i] = false;
                }
                for (Integer color1 : colors) {
                    colorsUsed[color1] = true;
                }
                for (int i = 0; i < MAX_X; i++) {
                    for (int j = 0; j < MAX_Y; j++) {
                        used[i][j] = false;
                    }
                }
                for (int i = 0; i < MAX_X; i++) {
                    for (int j = 0; j < MAX_Y; j++) {
                        dist[i][j] = MAX_X * MAX_Y;
                        bestColor[i][j] = 0;
                    }
                }

                TO_COLOR_BORDER = MAX_BORDER;

                if (colors.size() >= 10) {
                    TO_COLOR_BORDER = MIN_BORDER;
                }

                for (int j = 0; j < pairs.size(); j++) {
                    int x = pairs.get(j).getKey();
                    int y = pairs.get(j).getValue();
                    CURRENT_NUMBER = 0;
                    toColorBfs(x, y, colors.get(j), color, used, dist, colorsUsed, bestColor);
                }

                int[] minX = new int[MAX_X * MAX_Y];
                int[] minY = new int[MAX_X * MAX_Y];
                int[] maxX = new int[MAX_X * MAX_Y];
                int[] maxY = new int[MAX_X * MAX_Y];

                for (int i = 0; i < MAX_X * MAX_Y; i++) {
                    minX[i] = MAX_X * MAX_Y;
                    minY[i] = MAX_X * MAX_Y;
                    maxX[i] = 0;
                    maxY[i] = 0;
                }

                for (int x = 0; x < MAX_X; x++) {
                    for (int y = 0; y < MAX_Y; y++) {
                        int col = bestColor[x][y];
                        minX[col] = min(minX[col], x);
                        minY[col] = min(minY[col], y);
                        maxX[col] = max(maxX[col], x);
                        maxY[col] = max(maxY[col], y);
                    }
                }


                int[] pixels = new int[MAX_X * MAX_Y];
                for (int k1 = 0; k1 < MAX_X; k1++) {
                    for (int k2 = 0; k2 < MAX_Y; k2++) {
                        int rgb = trueImage.getRGB(MAX_X - 1 - k1, k2);
                        int r = (rgb) & 0xFF;
                        boolean wasColored = false;
                        for (int t = 0; t < colors.size(); t++) {
                            if (bestColor[((MAX_X - 1 - k1) / SCALE) * SCALE][(k2 / SCALE) * SCALE] == colors.get(t)) {
                                wasColored = true;
                                rgb = myColor[t].getRGB();
                                break;
                            }
                        }
                        Color c = new Color(rgb);
                        r = min(3 * r, 255);
                        int red = (c.getRed() * min(r, 255)) / 256;
                        int green = (c.getGreen() * min(r, 255)) / 256;
                        int blue = (c.getBlue() * min(r, 255)) / 256;
                        Color newC = new Color(red, green, blue);
                        if (wasColored) {
                            rgb = newC.getRGB();
                        }
                        pixels[k1 * MAX_Y + k2] = rgb;
                    }
                }

                BufferedImage colorImage = (BufferedImage) getImageFromArray(pixels, MAX_Y, MAX_X);
                BufferedImage newImage = new BufferedImage(MAX_X, MAX_Y, colorImage.getType());
                for (int i = 0; i < MAX_Y; i++) {
                    for (int j = 0; j < MAX_X; j++)
                        newImage.setRGB(MAX_X - 1 - j, i, colorImage.getRGB(i, j));
                }


                int[] compSize = new int[100];
                int[] brightness = new int[100];
                trueImage = decoder.read();
                for (int j = 0; j < colors.size(); j++) {
                    Rectangle rect = new Rectangle(minX[colors.get(j)], minY[colors.get(j)], maxX[colors.get(j)], maxY[colors.get(j)]);
                    int topX = (int) rect.getWidth() - (int) rect.getMinX();
                    int topY = (int) rect.getHeight() - (int) rect.getMinY();
                    int sX = (int) rect.getMinX();
                    int sY = (int) rect.getMinY();
                    int overallBrightness = 0;
                    pixelNumber = 0;
                    for (int x = sX; x < sX + topX; x++) {
                        for (int y = sY; y < sY + topY; y++) {
                            argb = trueImage.getRGB(x, y);
                            if (bestColor[(x / SCALE) * SCALE][(y / SCALE) * SCALE] == colors.get(j)) {
                                int r = (argb) & 0xFF;
                                if (argb != DARK) {
                                    pixelNumber++;
                                    overallBrightness += r;
                                }
                            }
                        }
                    }
                    compSize[j] = pixelNumber;
                    brightness[j] = overallBrightness / pixelNumber;
                }

                int avBr = 0;
                int avSize = 0;
                for (int j = 0; j < colors.size(); j++) {
                    avBr += brightness[j];
                    avSize += compSize[j];
                }
                avBr /= colors.size();
                avSize /= colors.size();

                double[] cool = new double[100];
                for (int j = 0; j < colors.size(); j++) {
                    cool[j] = 0;
                    cool[j] += (double) avSize / (double) compSize[j];
                    cool[j] += (double) avBr / (double) brightness[j];
                    if (cool[j] >= COOL_BORDER) {
                        continue;
                    }

                    trueImage = decoder.read();
                    Rectangle rect = new Rectangle(minX[colors.get(j)], minY[colors.get(j)], maxX[colors.get(j)], maxY[colors.get(j)]);
                    int topX = (int) rect.getWidth() - (int) rect.getMinX();
                    int topY = (int) rect.getHeight() - (int) rect.getMinY();
                    int sX = (int) rect.getMinX();
                    int sY = (int) rect.getMinY();
                    int overallBrightness = 0;
                    pixelNumber = 0;
                    for (int x = sX; x < sX + topX; x++) {
                        for (int y = sY; y < sY + topY; y++) {
                            argb = trueImage.getRGB(x, y);
                            if (bestColor[(x / SCALE) * SCALE][(y / SCALE) * SCALE] != colors.get(j)) {
                                int a = (argb) & 0xFF;
                                a /= 3;
                                argb = colorCode[a];
                                trueImage.setRGB(x, y, argb);
                            } else {
                                int r = (argb) & 0xFF;
                                if (argb != DARK) {
                                    pixelNumber++;
                                    overallBrightness += r;
                                }
                            }
                        }
                    }
                    crop = trueImage.getSubimage(sX, sY, topX, topY);
                    int averageBrightness = 0;
                    if (pixelNumber != 0) {
                        averageBrightness = overallBrightness / pixelNumber;
                    }
                    new File(path + "\\" + newFolder + "\\" + f.getName()).mkdir();

                    encoder.append(crop, dir + "\\cell" + (j + 1) + "(brightness=" + averageBrightness + ").tif");
                }


                trueImage = decoder.read();

                encoder.append(newImage, dir + "\\_segmented_not_cleaned picture" + f.getName().substring(0, f.getName().length() - 4) + ".jpeg");
                encoder.append(trueImage, dir + "\\_original picture" + f.getName().substring(0, f.getName().length() - 4) + ".tif");


                for (int k1 = 0; k1 < MAX_X; k1++) {
                    for (int k2 = 0; k2 < MAX_Y; k2++) {
                        int rgb = trueImage.getRGB(MAX_X - 1 - k1, k2);
                        int r = (rgb) & 0xFF;
                        boolean wasColored = false;
                        for (int t = 0; t < colors.size(); t++) {
                            if (bestColor[((MAX_X - 1 - k1) / SCALE) * SCALE][(k2 / SCALE) * SCALE] == colors.get(t) && cool[t] < COOL_BORDER) {
                                wasColored = true;
                                rgb = myColor[t].getRGB();
                                break;
                            }
                        }
                        Color c = new Color(rgb);
                        r = min(3 * r, 255);
                        int red = (c.getRed() * min(r, 255)) / 256;
                        int green = (c.getGreen() * min(r, 255)) / 256;
                        int blue = (c.getBlue() * min(r, 255)) / 256;

                        Color newC = new Color(red, green, blue);
                        if (wasColored) {
                            rgb = newC.getRGB();
                        }
                        pixels[k1 * MAX_Y + k2] = rgb;
                    }
                }

                colorImage = (BufferedImage) getImageFromArray(pixels, MAX_Y, MAX_X);
                newImage = new BufferedImage(MAX_X, MAX_Y, colorImage.getType());
                for (int i = 0; i < MAX_Y; i++) {
                    for (int j = 0; j < MAX_X; j++)
                        newImage.setRGB(MAX_X - 1 - j, i, colorImage.getRGB(i, j));
                }


                encoder.append(newImage, fold + "\\Picture" + f.getName().substring(0, f.getName().length() - 4) + ".jpeg");


                /*
                double pictureResult = 0;
                int recognizedNumber = 0;

                        if (num <= rectAr.size()) {
                            int rectArSize = rectAr.get(num - 1).size();
                            int colorsSize = colors.size();
                            for (int j = 0; j < rectArSize; j++) {

                                Rectangle rect = rectAr.get(num - 1).get(j);
                                double areaRect = ((rect.getWidth() - rect.getMinX()) * (rect.getHeight() - rect.getMinY()));
                                double maxRatio = 1000;
                                double ratio = 1;
                                int index = 0;

                                for (int p = 0; p < colorsSize; p++) {
                                    int col = colors.get(p);
                                    Rectangle r = new Rectangle(minX[col], minY[col], maxX[col], maxY[col]);
                                    int topX = (int) r.getWidth() - (int) r.getMinX();
                                    int topY = (int) r.getHeight() - (int) r.getMinY();
                                    int sX = (int) r.getMinX();
                                    int sY = (int) r.getMinY();
                                    Rectangle inter = intersect(rect, r);
                                    double areaR = ((r.getWidth() - r.getMinX()) * (r.getHeight() - r.getMinY()));
                                    double area = ((inter.getWidth() - inter.getMinX()) * (inter.getHeight() - inter.getMinY()));

                                    if ((areaRect / area) * max(areaR / areaRect, areaRect / areaR) < maxRatio) {
                                        maxRatio = (areaRect / area) * max(areaR / areaRect, areaRect / areaR);
                                        ratio = areaRect / area;
                                        index = p;
                                    }
                                }

                                if (maxRatio >= 8 || ratio <= 0.5) {
                                    maxRatio = 8;
                                }

                                pictureResult += maxRatio;

                                crop = trueImage.getSubimage((int) rect.getMinX(), (int) rect.getMinY(), (int) (rect.getWidth() - rect.getMinX()), (int) (rect.getHeight() - rect.getMinY()));
                                encoder.append(crop, dir + "\\real_cell" + (j + 1) + ".tif");
                            }

                            result += (pictureResult / rectArSize);

                        }
                        encoder.append(newImage, fold + "\\col_" + f.getName().substring(0, f.getName().length() - 4) + " penalty= " + pictureResult + ".jpeg");
                 */


            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        /* System.out.println("Result: " + result);

        if (minimum > result) {
            minimum = result;
            res_i1 = i1;
            res_i2 = i2;
            res_i3 = i3;
            res_i4 = i4;
            res_i5 = i5;
            res_i6 = i6;
            res_1 = result1;
        }


        System.out.println("All minimum:");
        System.out.println("SCALE=" + scale[res_i1]);
        System.out.println("TO_COLOR_BORDER=" + to_color_border[res_i2]);
        System.out.println("DENOM=" + denom[res_i3]);
        System.out.println("K_B=" + k_b[res_i4]);
        System.out.println("BORDER=" + border[res_i5]);
        System.out.println("K_DIV=" + k_div[res_i6]);
        System.out.println("RESULT=" + minimum / rectAr.size());
        System.out.println("RESULT WITHOUT SMALL=" + res_1);

        */

    }
}
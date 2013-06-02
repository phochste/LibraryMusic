/*
 * Library Sounds Version 3.0
 *
 * (c) Patrick Hochstenbach <Patrick.Hochstenbach@UGent.be>
 */
import arb.soundcipher.*;

int W1_X = 91;
int W2_X = 120;
int W3_X = 149;
int W_Y = 117;

int W_W = 10;
int W_H = 13;
int W_D = 3;

int[] music = {512,8194,1052674,32768,4160,65536,2228736,32770,512,139264,131074,8192,73728,524352,98304,65536,32768,49156,131074,6,9216,4374528,4194306,65536,344066,32770,393216,2,65536,576,139264,64,32770,131072,40960,16384,128,131072,2,2,131072,32768,65536,32768,2097152,512,131072,64,65536,2097154,2097154,66,655360,2097152,2129920,2097152,40960,2097152,2097152,2,128,64,2,16384,65536,64,2097152,1179648,196608,128,2,36864,622592,131072,131072,32768,262144,65536,2,2,2097152,2,2,32768,393216,196608,262656,131072,512,131072,4202496,32768,65536,65536,32768,68,4,131584,34,2260992,229376,4325376,131072,131072,16384,98816,131072,163840,1048576,131584,163840,131584,132096,4194304,65536,65536,1605632,8194,1536,6307840,512,164354,32768,64,524292,573442,4325378,2,65600,82016,4882432,32768,32768,2,64,32768,16384,4325632,4194304,4,32768,65536,98304,32768,2,8192,131072,33280,16384,40960,6569984,524288,64,1122304,65536,163842,16384,4,4194304,98306,131650,64,66048,2113600,76416,8704,163840,131072,770,2,514,32770,2097152,7340544,131072,4325888,2359298,114688,65536,49156,69632,65552,24576,8192,1024,512,98304,2,4325442,4407808,64,303232,114690,135170,1088,65538,163840,4915200,4194306,2228738,4326400,2490368,65536,1088,393728,65536,33280,2097154,512,514,4098,131072,131090,4456448,2,65538,262144,131072,4587520,16386,1245186,196610,131072,4096,41472,8194,147456,34816,262144,2392320,2097152,32768,2,514,131074,131072,106496,262144,4608,131584,2,147456,2,2097152,147456,294980,2,262144,2097220,32770,131074,131072,514,131586,32770,514,512,294912,9216,278528,1572864,66560,40960,2,512,131074,262146,2097152,4194816,64,5242884,3211264,2752576,196608,4341760,164352,65536,64,49152,131074,1048578,2,4194304,65600,34880,32768,64,33280,32784,2,32768,65600,33280,65792,128,533504,131088,131072,131072,524288,655360,4224,1048576,82432,2752512,2,131074,32768,2,1048576,131074,131072,4325440,2162880,2097410,4327456,2097154,2228224,4333568,73728,33280,131072,4296704,35328,2236420,4210690,41984,4588544,4328448,18434,512,135298,2097218,2,196608,18434,2,2,32768,32786,33344,131074,1026,514,65538,131074,163842,917504,174592,514,131074,4473348,4,1049088,327680,2114,2,66116,4227648,2562,8704,2,262146,983040,131584,132098,393728,4325376,33344,33284,8192,131072,1049088,1024,322,10240,131584,2240,64,2,2,4194304,512,514,32832,66560,1024,1024,32768,2,2,2,2,1024,4194304,128,2,48,512,33792,576,131072,16448,131074,6,6,73730,2,524290,1441792,2,131584,32768,2,4489216,131072,294912,262146,786432,43010,65568,65536,64,65602,8896,262724,68,139264,2097152,2097666,131072,83968,303106,8192,163840,98306,64,2048,1048592,6293568,131072,2,4358146,8192,32768,2367488,2113540,5505024,2097152,2097152,131584,512,66,10240,64,64,2,64,135168,2,4096,1048576,512,576,2,32770,1048576,1048576,2,1179650,163842,2,2,8192,131584,131072,2048,512,2,1024,32768,2,512,131072,163840,131072,2162688,6,32770,131072,64,32768,163840,32768,64,524290,32768,4098,64,131072,6,32768,524288,32768,512,32768,16,65536,73728,131072,262144,196608,131072,131072,557056,8256,256,512,262144,131072,16384,32770,131074,132096,1048592,2,1026,131072,655360,512,132,8192,2,131072,32768,128,16386,65536,2,139264,64,32768,32768,64,131074,4235264,32770,147456,4259840,524304,512,262178,5120,294912,2359296,524800,266242,4231168,4325376,131136,130,131088,5251072,70144,32838,131076,2232320,8450,5378304,2105856,2162754,8192,2195456,16386,16384,131074,66,278528,32768,67072,1024,5376,294976,1064992,2,131072,65538,131074,2,131072,131072,33536,2097152,262144,2097152,32768,64,2097152,66,512,295426,2,4196352,131104,576,256,73856,66048,143360,131074,32768,131072,32768,4325376,139266,24576,98818,131074,131586,131074,2,163840,32768,655366,514,66,1024,164178,1441794,5939206,917508,18432,163842,16402,163842,139266,524288,33282,65538,32768,6291456,512,2050,16,514,131072,32770,524288,4194304,229378,401408,66,131072,135168,4456448,2050,655362,2228742,512,16386,163842,132096,32768,32768,146,139264,2,262144,4198400,4325376,2,16384,32768,512,524288,131072,64,66048,163840,132096,131074,131200,1572864,163856,1056770,131072,4325378,262208,131072,33282,49154,131074,32770,132098,1606144,131652,2761216,4325376,163840,131072,131200,229376,98304,1311234,73730,53248,32768,131072,131200,139264,33794,163842,131072,131072,2,4334082,4456448,4,4194306,131586,2163200,1026,514,131584,4195328,540672,262148,4194304};
int[] tone_map = { 0, 2, 5, 7, 9, 12, 14, 17, 19, 21, 24, 26, 29, 31, 33, 36, 38, 41, 43, 45, 48, 50, 53, 55, 57, 60};
int keyRoot = 25;

PImage img;
SoundCipher sc;
int i = 0;

void setup() {
  frameRate(5);
  size(256, 613);
  background(#b3b3b3);
  
  sc = new SoundCipher(this);
  sc.instrument(sc.GUITAR);
  img = loadImage("boekentoren.png");
  
  stroke(#cccccc);
  
  image(img,25,5);
}

void draw() { 
    windows_clear();
  
    windows_chord(music[i], W1_X);
    windows_chord(music[i+1], W2_X);
    windows_chord(music[i+2], W3_X);
  
    play_chord(music[i]);
  
    i++;
  
    if (i + 3 > music.length) {
     i = 0;
    }
}

void play_chord(int chord) {
 java.util.Vector vec = new java.util.Vector();
 for (int i = 0 ; i < 23 ; i++) {
   int _mask = 1 << i;
   if ( (chord & _mask) == _mask) {
     int t = i;
     int note = keyRoot + tone_map[t];
     vec.add(new Float(note));
   }
 }
 float[] ret = new float[vec.size()];
 for (int n = 0 ; n < vec.size() ; n++) {
   ret[n] = ((Float) vec.get(n)).floatValue();
 }
 sc.playChord(ret,random(10)+90,random(20)/10 + 0.2);
}

void windows_chord(int chord, int window) {
  for (int i = 0 ; i < 23 ; i++) {
    int _mask = 1 << i;
    if ( (chord & _mask) == _mask) {
      fill(#ffffff);
      rect(window,W_Y + i * (W_H + W_D), W_W , W_H);
    }
  }
}

void windows_clear() {
  fill(#b3b3b3);
  for (int i = 0 ; i < 23 ; i++) {
   rect(W1_X, W_Y + i * (W_H + W_D), W_W , W_H);
   rect(W2_X, W_Y + i * (W_H + W_D), W_W , W_H);
   rect(W3_X, W_Y + i * (W_H + W_D), W_W , W_H);     
  }
}

void keyPressed() {
  println(mouseX + " , " + mouseY);
}

